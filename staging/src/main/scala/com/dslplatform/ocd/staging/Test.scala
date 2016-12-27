package com.dslplatform.ocd.staging

import Compile._

object Test {
  val home = repositories / "test"

  private[this] def copyTest(): Unit = {
    if (home.isDirectory) {
      logger.debug("Cleaning test home: {} ...", home.path)
      home.deleteRecursively(force = true, continueOnFailure = true)
    }

    val src = repositories / ".." / ".." / "test"
    logger.debug("Copying test to {}", home.path)
    src copyTo home
    logger.trace("Copied test to {}", home.path)
  }

  private[this] def mutateVersions(): Unit = {
    val version = {
      val testBuild = home / "build.sbt"
      backup(testBuild)
      val globalFind = s"""(?s).*version := "([^"]+)".*""".r
      val globalFind(testVersion) = testBuild.string
      testVersion + "-" + xkcd
    }

    logger.info("--# Test version is: {}", version)
    val versionPatterns = Map(
      s"""(version := ")([^"]+)(")""" -> s"$$1${version}$$3"
    , s"""("com.dslplatform.ocd" %% "dsl-ocd-model-[a-z]+" % ")([^"]+)(")""" -> s"$$1${Model.Version}-$xkcd$$3"
    )

    home ** ("build.sbt") foreach { path =>
      backup(path)
      val versionFix = versionPatterns.foldLeft(path.string){ case (curBody, (pattern, replacement)) =>
        curBody.replaceAll(pattern, replacement)
      }
      path write versionFix
      logger.debug("--# Updated versions in {}", path.path)
    }
  }

  private[this] def deployTarget(): Unit = {
    import Dsl._

    SBT("test", "", Nil, clean, compile, run)
  }

  private[this] def runTarget(): Unit = {
//    ANT("DSL-OCD-Target", "", Nil, "-p")
  }

  def apply(skipTest: Boolean): Unit = {
    if (!skipTest) {
      copyTest()
      mutateVersions()
      deployTarget()
      runTarget()
    }
  }
}
