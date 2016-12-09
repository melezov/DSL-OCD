package com.dslplatform.ocd
package staging

import sys.process._

object Compile {
  private[this] def clean(path: String*): Unit = {
    val tempRepoM2 = userHome / ".m2" / "repository" / (path.mkString("/"), '/')
    logger.trace("Cleaning previous publish local .m2: {}", tempRepoM2.path)
    tempRepoM2.deleteRecursively(force = true, continueOnFailure = false)

    val tempRepoIvy = userHome / ".ivy" / "repository" / path.mkString(".")
    logger.trace("Cleaning previous publish local .ivy: {}", tempRepoIvy.path)
    tempRepoIvy.deleteRecursively(force = true, continueOnFailure = false)
  }

  private[this] def mvn(project: String, path: String, commands: String*): Unit = {
    val target = repositories / project / (path.replace('\\', '/'), '/')

    logger.debug(">> Starting MVN @ {}/{}: {}", project, path, commands mkString " ")
    Process((unixVsWindows()("cmd", "/c") ++ Seq(
      "mvn"
    , "-Dmaven.test.skip=true"
    , s"-Duser.home=${userHome.path}"
    ) ++ commands), target.fileOption.get)! ProcessLogger(logger.trace(_), logger.warn(_))
    logger.debug("<< Finished with MVN @ {}/{}: {}", project, path, commands mkString " ")
  }

  private[this] def sbt(project: String, path: String, commands: String*): Unit = {
    val target = path match {
      case "" => repositories / project
      case subproject => repositories / project / (path.replace('\\', '/'), '/')
    }
    val launcher = templates / "tools" / "build" / "sbt-launch-0.13.13.jar"

    logger.debug(">> Starting SBT @ {}/{}: {}", project, path, commands mkString " ")
    Process((Seq(
      "java"
    , s"-Duser.home=${userHome.path}"
    , "-jar", launcher.toAbsolute.path
    ) ++ commands), target.fileOption.get)! ProcessLogger(logger.trace(_), logger.warn(_))
    logger.debug("<< Finished with SBT @ {}/{}: {}", project, path, commands mkString " ")
  }

  def apply(): Unit = block(
    () => {
      mvn("dsl-compiler-client", "CommandLineClient", "clean", "package")
    }
  , () => {
      clean("com", "dslplatform")
      mvn("dsl-json", "library", "clean", "install")
      block(
        () => mvn("dsl-json", "java8", "clean", "install")
      , () => mvn("dsl-json", "joda", "clean", "install")
      )
      sbt("dsl-client-java", "", "clean", "publishM2")

      clean("org", "revenj")
      mvn("revenj", "java/revenj-core", "clean", "install")
      mvn("revenj", "java/revenj-servlet", "clean", "install", "war:war")
    }
  , () => {
      clean("net", "revenj")
      sbt("revenj", "scala"
      , "core/clean", "+core/publishM2"
      , "akka/clean", "+akka/publishM2"
      )
    }
  )
}
