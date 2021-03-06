package com.dslplatform.ocd
package staging

import java.io.ByteArrayInputStream

import scala.sys.process._
import scalax.io.JavaConverters._

object Download {
  private[this] val CompilerUrl = "https://tools.dsl-platform.com/dsl-compiler.zip"
  private[this] val home = repositories / "dsl-compiler"

  private[this] def clean(): Unit = {
    if (!home.exists) home.createDirectory(createParents = true)
    (home ** "*.exe") foreach { old =>
      val oldVersion = testVersion(old)
      old.delete(force = true)
      logger.trace(s"Deleted ${old.path} ($oldVersion) ...")
    }
  }

  private[this] def downloadAndUnzip(): (Path, Int) = {
    val zis = new java.util.zip.ZipInputStream(
      new ByteArrayInputStream(Helpers.downloadArchive(CompilerUrl, "compiler"))
    )

    val firstEntry = zis.getNextEntry
    assert(firstEntry.getName == "dsl-compiler.exe")

    val expectedLength = firstEntry.getSize.toInt
    val tempFile = home / (java.util.UUID.randomUUID + ".exe")

    val body = zis.asInput.byteArray
    assert(body.length == expectedLength, "Size mismatch!")

    tempFile write body
    (tempFile, body.length)
  }

  private[this] def testVersion(tempFile: Path): String = {
    val stdout = new java.io.ByteArrayOutputStream
    val stderr = new java.io.ByteArrayOutputStream
    val stdoutWriter = new java.io.PrintWriter(stdout)
    val stderrWriter = new java.io.PrintWriter(stderr)

    (unixVsWindows("mono")() :+ tempFile.path) ! ProcessLogger(stdoutWriter.println, stderrWriter.println)

    stdoutWriter.close()
    stderrWriter.close()

    val VersionPattern = """(?s).*?Version: (\d+(?:\.\d+)+).*?""".r
    val VersionPattern(version) = stdout.toString
    version
  }

  private[this] def rename(tempFile: Path, version: String): Unit = {
    val targetFile = home / s"dsl-compiler-$version-$xkcd.exe"
    tempFile moveTo targetFile
    logger.debug(s"Renamed to ${targetFile.name}")
  }

  def apply(skipDownload: Boolean): Unit = if (!skipDownload) {
    // Clean all the things!
    clean()

    // Download compiler
    val (tempFile, size) = downloadAndUnzip()
    logger.debug(s"Wrote ${tempFile.name} ($size bytes)")

    // Check version
    val version = testVersion(tempFile)
    logger.info(s"Compiler version: $version")

    // Rename temporary file name
    rename(tempFile, version)
  }
}
