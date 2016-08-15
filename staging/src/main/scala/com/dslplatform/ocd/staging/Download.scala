package com.dslplatform.ocd
package staging

import sys.process._

object Download {
  private[this] val home = repositories / "NGS"

  private[this] def clean(): Unit = {
    if (!home.exists) home.createDirectory(createParents = true)
    (home ** "*.exe") foreach { old =>
      val oldVersion = testVersion(old)
      old.delete(force = true)
      logger.debug(s"Deleted ${old.path} ($oldVersion) ...")
    }
  }

  private[this] def download(): (Path, Int) = {
    val url = "https://compiler.dsl-platform.com:8443/platform/download/dsl-compiler.zip"

    val zis = new java.util.zip.ZipInputStream(
      new java.io.BufferedInputStream(
      new java.net.URL(url).openStream()))

    val firstEntry = zis.getNextEntry
    assert(firstEntry.getName == "dsl-compiler.exe")

    val expectedLength = firstEntry.getSize.toInt

    val buffer = new Array[Byte](1 << 20)
    val tempFile = home / (java.util.UUID.randomUUID + ".exe")

    val bis = new java.io.BufferedInputStream(zis)
    val fos = new java.io.FileOutputStream(tempFile.path)

    def slurp(soFar: Int = 0): Int = {
      val toRead = math.min(expectedLength - soFar, buffer.length)
      if (toRead > 0) {
        val read = bis.read(buffer, 0, toRead)
        if (read != -1) {
          fos.write(buffer, 0, read)
          val total = soFar + read
          logger.info(s"Wrote $total bytes ...")
          slurp(total)
        } else {
          soFar
        }
      } else {
        soFar
      }
    }

    val size = slurp()
    assert(size == expectedLength, "Size mismatch!")
    bis.close()
    fos.close()

    (tempFile, size)
  }

  private[this] def testVersion(tempFile: Path): String = {
    val stdout = new java.io.ByteArrayOutputStream
    val stderr = new java.io.ByteArrayOutputStream
    val stdoutWriter = new java.io.PrintWriter(stdout)
    val stderrWriter = new java.io.PrintWriter(stderr)

    (if (java.io.File.separator == "/") {
      Seq("mono", tempFile.path)
    } else {
      Seq(tempFile.path)
    }) ! ProcessLogger(stdoutWriter.println, stderrWriter.println)

    stdoutWriter.close()
    stderrWriter.close()

    val VersionPattern = """(?s).*?Version: (\d+(?:\.\d+)+).*?""".r
    val VersionPattern(version) = stdout.toString
    version
  }

  private[this] def rename(tempFile: Path, version: String): Unit = {
    val targetFile = home / s"dsl-compiler-$version-$xkcd.exe"
    tempFile moveTo targetFile
    logger.info(s"Renamed to ${targetFile.path}")
  }

  def apply(): Unit = {
    // Clean all the things!
    clean()

    // Download compiler
    val (tempFile, size) = download()
    logger.info(s"Wrote ${tempFile.path} ($size bytes)")

    // Check version
    val version = testVersion(tempFile)
    logger.info(s"Compiler version: $version")

    // Rename temporary file name
    rename(tempFile, version)
  }
}
