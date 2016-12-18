package com.dslplatform.ocd.staging

import java.io.ByteArrayOutputStream
import java.util.Properties

import com.dslplatform.ocd.staging.Compile._

object Util {
  val home = repositories / "util"

  private[this] def copyUtil(): Unit = {
    if (home.isDirectory) {
      logger.debug("Cleaning util home: {} ...", home.path)
      home.deleteRecursively(force = true, continueOnFailure = true)
    }

    val src = repositories / ".." / ".." / "util"
    logger.debug("Copying util to {}", home.path)
    src copyTo home
    logger.trace("Copied util to {}", home.path)
  }

  private[this] def mutateVersions(): Unit = {
    val version = {
      val generatorBuild = home / "testing" / "build.sbt"
      backup(generatorBuild)
      val globalFind = s"""(?s).*version := "([^"]+)".*""".r
      val globalFind(generatorVersion) = generatorBuild.string
      generatorVersion + "-" + xkcd
    }

    logger.info("--# Util version is: {}", version)
    val versionPatterns = Map(
      s"""(version := ")([^"]+)(")""" -> s"$$1${version}$$3"
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

  private[this] def compileUtil(): Unit = {
    import Dsl._

    block(
      () => SBT("util", "generator", Seq("com.dslplatform.ocd/dsl-ocd-util-generator_2.11"), clean, `set no src`, `set no doc`, publishLocal)
    , () => SBT("util", "ping", Nil, clean, `set no src`, `set no doc`, `package`)
    , () => SBT("util", "port-corrector", Nil, clean, `set no src`, `set no doc`, `package`)
    , () => SBT("util", "report", Nil, clean, `set no src`, `set no doc`, `package`)
    , () => SBT("util", "revenj-runner", Nil, clean, `set no src`, `set no doc`, assembly)
    , () => SBT("util", "testing", Seq("com.dslplatform.ocd/dsl-ocd-util-testing"), clean, `set no src`, `set no doc`, publishLocal)
    )
  }

  def apply(skipUtil: Boolean): Unit = {
    if (!skipUtil) {
      copyUtil()
      mutateVersions()
      compileUtil()
    }
  }
}
