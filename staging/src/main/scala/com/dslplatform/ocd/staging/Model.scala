package com.dslplatform.ocd.staging

import java.io.ByteArrayOutputStream
import java.util.Properties

import Compile._

object Model {
  val home = repositories / "model"

  private[this] def copyModel(): Unit = {
    if (home.isDirectory) {
      logger.debug("Cleaning model home: {} ...", home.path)
      home.deleteRecursively(force = true, continueOnFailure = true)
    }

    val configPath = userHome / ".config" / "DSL-OCD" / "ocd.config"
    val baos = new ByteArrayOutputStream()
    val props = new Properties()
    props.put("model", home.path)
    props.store(baos, "")
    configPath write baos.toByteArray
    logger.trace("Wrote ocd.config: {}", configPath.path)

    val src = repositories / ".." / ".." / "model"
    logger.debug("Copying model to {}", home.path)
    src copyTo home
    logger.trace("Copied model to {}", home.path)
  }

  private[this] def mutateVersions(): Unit = {
    val (generatorVersion, version) = {
      val generatorBuild = home / "generator" / "build.sbt"
      backup(generatorBuild)
      val globalFind = s"""(?s).*version := "([^"]+)".*""".r
      val globalFind(generatorVersion) = generatorBuild.string
      (generatorVersion, generatorVersion + "-" + xkcd)
    }

    logger.info("--# Set model version is: {}", version)
    val versionPatterns = Seq(
      s"""(version := ")([^"]+)(")"""
      , s"""("com.dslplatform.ocd" %% "dsl-ocd-model-[a-z]+" % ")([^"]+)(")"""
    )

    home ** ("build.sbt") foreach { path =>
      backup(path)
      val versionFix = versionPatterns.foldLeft(path.string){ case (curBody, pattern) =>
        curBody.replaceAll(pattern, s"$$1${version}$$3")
      }
      path write versionFix
      logger.debug("--# Updated versions in {}", path.path)
    }
  }

  private[this] def compileModel(): Unit = {
    import Dsl._

    block(
      () => SBT("model", "generator", Nil, "clean", "run")
    , () => SBT("model", "kinds", Seq("com.dslplatform.ocd/dsl-ocd-model-kinds_2.11"), clean, `set no src`, `set no doc`, publishLocal)
    )
    block(
      () => SBT("model", "boxes", Seq("com.dslplatform.ocd/dsl-ocd-model-boxes_2.11"), clean, `set no src`, `set no doc`, publishLocal)
    , () => SBT("model", "types", Seq("com.dslplatform.ocd/dsl-ocd-model-types_2.11"), clean, `set no src`, `set no doc`, publishLocal)
    )
    block(
      () => SBT("model", "dsls", Seq("com.dslplatform.ocd/dsl-ocd-model-dsls_2.11"), clean, `set no src`, `set no doc`, publishLocal)
    , () => SBT("model", "javas", Seq("com.dslplatform.ocd/dsl-ocd-model-javas_2.11"), clean, `set no src`, `set no doc`, publishLocal)
    , () => SBT("model", "scalas", Seq("com.dslplatform.ocd/dsl-ocd-model-scalas_2.11"), clean, `set no src`, `set no doc`, publishLocal)
    , () => SBT("model", "java-asserts", Seq("com.dslplatform.ocd/dsl-ocd-model-java-asserts"), clean, `set no src`, `set no doc`, publishLocal)
    )
  }

  def apply(skipModel: Boolean): Unit = {
    if (!skipModel) {
      copyModel()
      mutateVersions()
      compileModel()
    }
  }
}
