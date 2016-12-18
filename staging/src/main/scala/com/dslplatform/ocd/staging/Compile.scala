package com.dslplatform.ocd
package staging

import java.io.{ByteArrayInputStream, ByteArrayOutputStream}
import java.security.MessageDigest
import java.util.zip.ZipInputStream

import scala.annotation.tailrec
import scala.sys.process._
import scalax.io.JavaConverters._
import scalax.io._

object Compile {
  def compilationLogger(source: String, project: String, path: String) = {
    val target = if (path.isEmpty) project else project + "/" + path
    (msg: String) => {
      if (msg contains "Compiling") {
        logger.debug(s"--# Running {} for {}: {}", source, target, msg)
      }
      logger.trace(s"--# Running {} for {}: {}", source, target, msg)
    }
  }

  case object MVN extends BuildTool {
    protected val version = "3.3.9"
    protected val url = s"http://ftp.carnet.hr/misc/apache/maven/maven-3/${version}/binaries/apache-maven-${version}-bin.zip"
    protected val sha1 = "2ddf9bb8c3b41bc2891832a6d6fc25f8bf41d77f"
    protected val home = userHome / ".m2"
    protected val expectedChildFolder = s"apache-maven-${version}/"

    def cleanPublishes(path: String): Unit = {
      val oldInstall = home / "repository" / (path, '/')
      if (oldInstall.isDirectory) {
        logger.debug(s"--# Cleaning previous ${this} local installs: {}", oldInstall.path)
        oldInstall.deleteRecursively(force = true, continueOnFailure = false)
      }
    }

    def apply(project: String, path: String, toClean: Seq[String], commands: String*): Unit = {
      ensureToolExists()

      logger.debug(s"--> Starting ${this} @ {}/{}: {}", project, path, commands mkString " ")
      BuildTool.cleanPublishes(toClean)

      val target = repositories / project / (path.replace('\\', '/'), '/')
      Process((unixVsWindows()("cmd", "/c") ++ Seq(
        (tool / "bin" / "mvn").path
        , "-Dmaven.test.skip=true"
        , "-Dmaven.javadoc.skip=true"
        , s"-Duser.home=${userHome.path}"
      ) ++ commands), target.fileOption.get)! ProcessLogger(compilationLogger(this.toString, project, path), logger.warn(_))

      logger.debug(s"<-- Finished with ${this} @ {}/{}: {}", project, path, commands mkString " ")
    }
  }

  case object SBT extends BuildTool {
    protected val version = "0.13.13"
    protected val url = s"https://dl.bintray.com/sbt/native-packages/sbt/${version}/sbt-${version}.zip"
    protected val sha1 = "42d1c1aed27b0997ab936af987d42d9eeb0d83e6"
    protected val home = userHome / ".sbt"
    protected val expectedChildFolder = s"sbt-launcher-packaging-${version}/"

    def cleanPublishes(path: String): Unit =
      for (repo <- Seq("local", "cache")) {
        val oldLocal = userHome / ".ivy2" / repo / (path, '/')
        if (oldLocal.isDirectory) {
          logger.debug(s"--# Cleaning previous ${this} ${repo} publishes: {}", oldLocal.path)
          oldLocal.deleteRecursively(force = true, continueOnFailure = false)
        }
      }

    def apply(project: String, path: String, toClean: Seq[String], commands: String*): Unit = {
      ensureToolExists()

      val commandsNoSets = commands.filterNot(_ startsWith "set ")
      logger.debug(s"--> Starting ${this} @ {}/{}: {}", project, path, commandsNoSets mkString " ")
      BuildTool.cleanPublishes(toClean)

      val target = path match {
        case "" => repositories / project
        case subproject => repositories / project / (subproject.replace('\\', '/'), '/')
      }

      val toolJar = (tool / "bin" / s"sbt-launch.jar").toAbsolute
      Process((Seq(
        "java"
      , "-Xmx2G", "-Xss4m", "-XX:ReservedCodeCacheSize=512m"
      , s"-Duser.home=${userHome.path}"
      , "-jar", toolJar.path
      ) ++ commands), target.fileOption.get)! ProcessLogger(compilationLogger(this.toString, project, path), logger.warn(_))
      logger.debug(s"<-- Finished with ${this} @ {}/{}: {}", project, path, commandsNoSets mkString " ")
    }
  }

  object BuildTool {
    def cleanPublishes(toClean: Seq[String]): Unit = toClean foreach {
      case ivy2Cache if ivy2Cache.takeWhile(_ != '/').contains('.') =>
        SBT.cleanPublishes(ivy2Cache)
      case m2Cache =>
        MVN.cleanPublishes(m2Cache)
    }
  }

  sealed trait BuildTool {
    protected val version: String
    protected val url: String
    protected val sha1: String
    protected val expectedChildFolder: String

    protected val home: Path
    protected def tool = home / version

    def cleanPublishes(path: String): Unit
    def apply(project: String, path: String, toClean: Seq[String], commands: String*): Unit

    private[this] def cleanExisting(): Unit = {
      if (tool.isDirectory) {
        logger.debug(s"--- Cleaning previous ${this} home: {}", tool.path)
        tool.deleteRecursively(force = true, continueOnFailure = false)
      }
    }

    private[this] def downloadArchive(): Array[Byte] = {
      logger.debug(s"--> Downloading ${this} @ {} ...", url)
      val downloader = Resource.fromURL(url).bytes.grouped(500000)
      val baos = new ByteArrayOutputStream()
      downloader.foldLeft(0L) { (last, buffer) =>
        val soFar = last + buffer.length
        logger.debug(s"--# Downloading ${this}: {} bytes ...", format(soFar))
        baos.write(buffer.toArray)
        soFar
      }
      baos.toByteArray
    }

    private[this] def checkSha1(archive: Array[Byte]): Unit = {
      val md = MessageDigest.getInstance("SHA-1")
      val digest = md.digest(archive).map(_ formatted "%02x").mkString
      assert(digest == sha1, s"SHA-1 mismatch in downloaded ${this} distribution!")
    }

    private[this] def extractTool(archive: Array[Byte]): Unit = {
      logger.debug(s"--# Downloaded ${this}, extracting ...")
      val zis = new ZipInputStream(new ByteArrayInputStream(archive))

      @tailrec
      def unzip(filesSoFar: Int, sizeSoFar: Long): (Int, Long) =
        zis.getNextEntry match {
          case null => (filesSoFar, sizeSoFar)
          case ze if ze.isDirectory => unzip(filesSoFar, sizeSoFar)
          case ze =>
            val name = ze.getName
            assert(name startsWith expectedChildFolder, s"Path mismatch, expected to start with ${expectedChildFolder}, but got: " + name)
            val innerName = name.drop(expectedChildFolder.length)
            val path = (tool / (innerName, '/'))
            logger.trace(s"--# Unzipping ${this}: {}", path.path)
            val body = zis.asUnmanagedInput.byteArray
            path write body
            unzip(filesSoFar + 1, sizeSoFar + body.length)
        }

      val (extractedFiles, extractedSize) = unzip(0, 0L)
      logger.debug(s"<-- Downloaded ${this}: ${format(extractedSize)} bytes in ${extractedFiles} files")
    }

    protected def downloadAndUnzip(): Unit = {
      cleanExisting()
      val archive = downloadArchive()
      checkSha1(archive)
      extractTool(archive)
    }

    protected def ensureToolExists(): Unit = synchronized {
      if (!tool.isDirectory) {
        downloadAndUnzip()
      }
    }
  }

  object Dsl {
    val `assembly` = "assembly"
    val `clean` = "clean"
    val `package` = "package"
    val `install` = "install"
    val `war:war` = "war:war"
    val `publishLocal` = "publishLocal"
    val `publishM2` = "publishM2"
    val `+publishM2` = "+publishM2"
    val `set no src` = "set publishArtifact in (Compile, packageSrc) := false"
    val `set no doc` = "set publishArtifact in (Compile, packageDoc) := false"
  }

  import Dsl._

  def apply(): Unit = block(
    () => {
      MVN("dsl-compiler-client", "CommandLineClient", Nil, clean, `package`)
    }
  , () => {
      MVN("dsl-json", "library", Seq("com/dslplatform/dsl-json"), clean, install)
      block(
        () => {
          MVN("dsl-json", "java8", Seq("com/dslplatform/dsl-json-java8"), clean, install)
          MVN("revenj", "java/revenj-core", Seq("org/revenj/revenj-core"), clean, install)
          MVN("revenj", "java/revenj-servlet", Seq("org/revenj/revenj-servlet"), clean, install, `war:war`)
        }
      , () => {
          MVN("dsl-json", "joda", Seq("com/dslplatform/dsl-json-joda"), clean, install)
          SBT("dsl-client-java", "", Seq("com/dslplatform/dsl-client-java"), clean, `set no src`, `set no doc`, publishM2)
        }
      )
    }
  , () => {
      SBT("revenj", "scala", Seq("revenj-core_2.11", "revenj-core_2.12", "revenj-akka_2.11", "revenj-akka_2.12")
      , "project core", clean, `set no src`, `set no doc`, `+publishM2`
      , "project akka", clean, `set no src`, `set no doc`, `+publishM2`
      )
    }
  )
}
