package com.dslplatform.ocd
package staging

import scala.sys.process._

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
    protected val version = "3.5.2"
    protected val url = s"http://ftp.carnet.hr/misc/apache/maven/maven-3/${version}/binaries/apache-maven-${version}-bin.zip"
    protected val sha1 = "23adadc90b7f79ad84bd14574581d0145611bfda"
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

      val target = repositories / (project, '/') / (path.replace('\\', '/'), '/')

      val result = Process(unixVsWindows("bash")("cmd", "/c") ++ Seq(
        (tool / "bin" / "mvn").path
      , "-Dsource.skip"
      , "-Dmaven.test.skip=true"
      , "-Dmaven.javadoc.skip=true"
      , s"-Duser.home=${userHome.path}"
      ) ++ commands, target.fileOption.get)! ProcessLogger(compilationLogger(this.toString, project, path), logger.warn(_))
      require(result == 0, s"${this} exited with a non-zero result ($result), quitting!")

      logger.debug(s"<-- Finished with ${this} @ {}/{}: {}", project, path, commands mkString " ")
    }
  }

  case object SBT extends BuildTool {
    protected val version = "0.13.15"
    protected val url = s"https://github.com/sbt/sbt/releases/download/v${version}/sbt-${version}.zip"
    protected val sha1 = "e98e689425bf950440a9659313389bd441adb49d"
    protected val home = userHome / ".sbt"
    protected val expectedChildFolder = "sbt"

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
        case "" => repositories / (project, '/')
        case subproject => repositories / (project, '/') / (subproject.replace('\\', '/'), '/')
      }

      val toolJar = (tool / "bin" / s"sbt-launch.jar").toAbsolute
      val result = Process(Seq(
        "java"
      , "-Xmx2G"
      , "-Xss4m"
      , s"-Duser.home=${userHome.path}"
      , "-jar", toolJar.path
      ) ++ commands, target.fileOption.get)! ProcessLogger(compilationLogger(this.toString, project, path), logger.warn(_))
      require(result == 0, s"${this} exited with a non-zero result ($result), quitting!")

      logger.debug(s"<-- Finished with ${this} @ {}/{}: {}", project, path, commandsNoSets mkString " ")
    }
  }

  case object ANT extends BuildTool {
    protected val version = "1.10.1"
    protected val url = s"http://ftp.carnet.hr/misc/apache/ant/binaries/apache-ant-${version}-bin.zip"
    protected val sha1 = "fa9acb3b1987f8acf2aa7a87894d1fd9da80e871"
    protected val home = userHome / ".ant"
    protected val expectedChildFolder = s"apache-ant-${version}/"

    def cleanPublishes(path: String): Unit = ()

    def apply(project: String, path: String, toClean: Seq[String], commands: String*): Unit = {
      ensureToolExists()
      logger.debug(s"--> Starting ${this} @ {}/{}: {}", project, path, commands mkString " ")

      val target = path match {
        case "" => repositories / (project, '/')
        case subproject => repositories / (project, '/') / (subproject.replace('\\', '/'), '/')
      }

      val result = Process(unixVsWindows("bash")("cmd", "/c") ++ Seq(
        (tool / "bin" / "ant").path
      , s"-Duser.home=${userHome.path}"
      ) ++ commands, target.fileOption.get)! ProcessLogger(compilationLogger(this.toString, project, path), logger.warn(_))
      require(result == 0, s"${this} exited with a non-zero result ($result), quitting!")

      logger.debug(s"<-- Finished with ${this} @ {}/{}: {}", project, path, commands mkString " ")
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

    protected def downloadAndUnzip(): Unit = {
      cleanExisting()
      val archive = Helpers.downloadArchive(url, this.toString)
      Helpers.checkSha1(archive, sha1)
      Helpers.extractTool(archive, this.toString, Some(expectedChildFolder), tool)
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
    val `compile` = "compile"
    val `install` = "install"
    val `package` = "package"
    val `publishLocal` = "publishLocal"
    val `publishM2` = "publishM2"
    val `+publishM2` = "+publishM2"
    val `run` = "run"
    val `set no src` = "set publishArtifact in (Compile, packageSrc) := false"
    val `set no doc` = "set publishArtifact in (Compile, packageDoc) := false"
    val `war:war` = "war:war"
  }

  import Dsl._

  def apply(skipCompile: Boolean): Unit = if (!skipCompile) par(
    () => {
      MVN("dsl-compiler-client", "CommandLineClient", Nil, clean, `package`)
    }
  , () => {
      MVN("dsl-json", "library", Seq("com/dslplatform/dsl-json"), clean, install)
      par(
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
