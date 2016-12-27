package com.dslplatform.ocd.staging

import java.io.{ByteArrayInputStream, ByteArrayOutputStream}
import java.security.MessageDigest
import java.util.zip.ZipInputStream
import scalax.io.JavaConverters._
import scala.annotation.tailrec
import scalax.io.Resource

object Helpers {
  def downloadArchive(url: String, name: String, chunkSize: Int = 500000): Array[Byte] = {
    logger.debug(s"--> Downloading {} @ {} ...", name, url)
    val downloader = Resource.fromURL(url).bytes.grouped(chunkSize)
    val baos = new ByteArrayOutputStream()
    downloader.foldLeft(0L) { (last, buffer) =>
      val soFar = last + buffer.length
      logger.debug(s"--# Downloading {}: {} bytes ...", name, format(soFar))
      baos.write(buffer.toArray)
      soFar
    }
    baos.toByteArray
  }

  def checkSha1(archive: Array[Byte], sha1: String): Unit = {
    val md = MessageDigest.getInstance("SHA-1")
    val digest = md.digest(archive).map(_ formatted "%02x").mkString
    assert(digest == sha1, s"SHA-1 mismatch")
  }

  def extractTool(archive: Array[Byte], name: String, expectedChildFolder: Option[String], outputPath: Path): Unit = {
    logger.debug(s"--# Downloaded $name, extracting ...")
    val zis = new ZipInputStream(new ByteArrayInputStream(archive))

    @tailrec
    def unzip(filesSoFar: Int, sizeSoFar: Long): (Int, Long) =
      zis.getNextEntry match {
        case null => (filesSoFar, sizeSoFar)
        case ze if ze.isDirectory => unzip(filesSoFar, sizeSoFar)
        case ze =>
          val name = ze.getName
          for (ecf <- expectedChildFolder) {
            assert(name startsWith ecf, s"Path mismatch, expected to start with ${ecf}, but got: " + name)
          }
          val innerName = name.drop(expectedChildFolder.map(_.length).getOrElse(0))
          val path = outputPath / (innerName, '/')
          logger.trace(s"--# Unzipping {}: {}", name, path.path)
          val body = zis.asUnmanagedInput.byteArray
          path write body
          unzip(filesSoFar + 1, sizeSoFar + body.length)
      }

    val (extractedFiles, extractedSize) = unzip(0, 0L)
    logger.debug(s"<-- Downloaded {}: ${format(extractedSize)} bytes in ${extractedFiles} files", name)
  }
}
