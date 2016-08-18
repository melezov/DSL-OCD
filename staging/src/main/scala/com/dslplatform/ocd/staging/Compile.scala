package com.dslplatform.ocd
package staging

import sys.process._

object Compile {
  private[this] def clean(path: String*): Unit = {
    val tempRepoM2 = userHome / ".m2" / "repository" / (path.mkString("/"), '/')
    logger.debug("Cleaning previous publish local .m2: {}", tempRepoM2.path)
    tempRepoM2.deleteRecursively(force = true, continueOnFailure = false)

    val tempRepoIvy = userHome / ".ivy" / "repository" / path.mkString(".")
    logger.debug("Cleaning previous publish local .ivy: {}", tempRepoIvy.path)
    tempRepoIvy.deleteRecursively(force = true, continueOnFailure = false)
  }

  private[this] def mvn(project: String, path: String, commands: String*): Unit = {
    val target = Path(s"repositories/${project}/${path}", '/')

    Process((unixVsWindows()("cmd", "/c") ++ Seq(
      "mvn"
    , "-Dmaven.test.skip=true"
    , s"-Duser.home=${userHome.path}"
    ) ++ commands), target.jfile)!
  }

  private[this] def sbt(project: String, path: String, commands: String*): Unit = {
    val target = Path(s"repositories/${project}/${path}", '/')
    val launcher = tools / "sbt-launch-0.13.12.jar"

    Process((Seq(
      "java"
    , s"-Duser.home=${userHome.path}"
    , "-jar", launcher.toAbsolute.path
    ) ++ commands), target.jfile)!
  }

  def apply(): Unit = block(
    Future {
      mvn("dsl-compiler-client", "CommandLineClient", "clean", "package")
    }
  , Future {
      clean("com", "dslplatform")
      mvn("dsl-json", "library", "clean", "install")
      mvn("dsl-json", "java8", "clean", "install")
      sbt("dsl-client-java", "", "clean", "publishM2")

      clean("org", "revenj")
      mvn("revenj", "java/revenj-core", "clean", "install")
      mvn("revenj", "java/revenj-servlet", "clean", "install", "war:war")
    }
  , Future {
      clean("net", "revenj")
      sbt("revenj", "scala", "clean", "publishM2")
    }
  )
}
