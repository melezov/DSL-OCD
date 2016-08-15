package com.dslplatform.ocd
package staging

import sys.process._

object Gather {
  private[this] val home = repositories / ".gather"

  private[this] def clean(): Unit = {
    if (home.exists) {
      logger.info("Cleaning .gather cache ...")
      home.deleteRecursively(force = true, continueOnFailure = false)
    }
    home.createDirectory(createParents = true)
  }

  private[this] def downloadDependencies(target: Path, dependencies: String*): Unit = {
    val downloadFolder = target / "downloader"

    (tools / "downloader") copyTo downloadFolder

    val libs = (dependencies map { dependency =>
      "libraryDependencies += " + dependency
    }).mkString("""import sbt._
import Keys._

""", "\n", "\n")

    (downloadFolder / "dependencies.sbt") write libs

    val launcher = tools / "sbt-launch-0.13.12.jar"
    Process(Seq(
      "java"
      , s"-Duser.home=${userHome.path}"
      , "-jar", launcher.toAbsolute.path
      , "packCopyDependencies"
    ), downloadFolder.fileOption.get)!

    val packDeps = downloadFolder / "dependencies"
    (packDeps / "downloader_2.11-0.1-SNAPSHOT.jar").delete(force = true)
    (packDeps ** "*.jar") foreach { jar => jar moveTo target / jar.name }

    downloadFolder.deleteRecursively(force = true, continueOnFailure = false)
  }

  private[this] def dslCompiler(): Unit = {
    val src = (repositories / "NGS" ** s"*.exe").head
    val target = home / "dsl-compiler" / src.name
    src copyTo target
  }

  private[this] def dslClc(): Unit = {
    val src = repositories / "dsl-compiler-client" / "CommandLineClient" / "target" / s"dsl-clc-${Analyse.dslClcVersion}-$xkcd-jar-with-dependencies.jar"
    val target = home / "dsl-clc" / s"dsl-clc-${Analyse.dslClcVersion}-$xkcd.jar"
    logger.info("Gathering {}", target.path)
    src copyTo target
  }

  private[this] def dslClientJava(): Unit = {
    val target = home / "dsl-client-java"
    downloadDependencies(target
    , s""""com.dslplatform" % "dsl-client-java" % "${Analyse.dslClientJavaVersion}-$xkcd""""
    , """"com.fasterxml.jackson.core" % "jackson-databind" % "2.7.4""""
    )
  }

  private[this] def revenjCoreJava(): Unit = {
    val target = home / "revenj-core_java"
    downloadDependencies(target
    , s""""org.revenj" % "revenj-core" % "${Analyse.revenjCoreJavaVersion}-$xkcd""""
    )
  }

  private[this] def revenjServletJava(): Unit = {
    val target = home / "revenj-servlet_java"
    downloadDependencies(target
    , s""""org.revenj" % "revenj-servlet" % "${Analyse.revenjServletJavaVersion}-$xkcd""""
    )
  }

  private[this] def revenjCoreScala(): Unit = {
    val target = home / "revenj-core_scala"
    downloadDependencies(target
    , s""""net.revenj" %% "revenj-core" % "${Analyse.revenjCoreScalaVersion}-$xkcd""""
    )
  }

  private[this] def revenjAkkaScala(): Unit = {
    val target = home / "revenj-akka_scala"
    downloadDependencies(target
    , s""""net.revenj" %% "revenj-akka" % "${Analyse.revenjAkkaScalaVersion}-$xkcd""""
    )
  }

  def apply(): Unit = {
    clean()
    block(
      Future { dslCompiler() }
    , Future { dslClc() }
    , Future { dslClientJava() }
    , Future { revenjCoreJava() }
    , Future { revenjServletJava() }
    , Future { revenjCoreScala() }
    , Future { revenjAkkaScala() }
    )
  }
}
