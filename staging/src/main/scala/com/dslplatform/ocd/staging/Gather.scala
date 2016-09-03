package com.dslplatform.ocd
package staging

import java.io.{BufferedReader, InputStreamReader}
import java.util.jar.JarInputStream

import sys.process._

object Gather {
  private[staging] val home = repositories / ".gather"

  private[this] def clean(): Unit = {
    if (home.exists) {
      logger.trace("Cleaning .gather cache ...")
      home.deleteRecursively(force = true, continueOnFailure = false)
    }
    home.createDirectory(createParents = true)
  }

  private[this] def downloadDependencies(target: String, dependencies: String*): Unit = {
    val downloadFolder = home / target / "downloader"
    (templates / "tools" / "downloader") copyTo downloadFolder

    val libs = (dependencies map { dependency =>
      "libraryDependencies += " + dependency
    }).mkString("""import sbt._
import Keys._

""", "\n", "\n")

    (downloadFolder / "dependencies.sbt") write libs

    val launcher = templates / "tools" / "build" / "sbt-launch-0.13.12.jar"
    logger.debug(">> Starting SBT @ {}: packCopyDependencies", target + "/downloader")
    Process(Seq(
      "java"
    , s"-Duser.home=${userHome.path}"
    , "-jar", launcher.toAbsolute.path
    , "packCopyDependencies"
    ), downloadFolder.fileOption.get)! ProcessLogger(logger.trace(_), logger.warn(_))
    logger.debug("<< Finished with SBT @ {}: packCopyDependencies", target + "/downloader")

    val packDeps = downloadFolder / "dependencies"
    (packDeps / "downloader_2.11-0.1-SNAPSHOT.jar").delete(force = true)
    (packDeps ** "*.jar") foreach { jar => jar moveTo downloadFolder.parent.get / jar.name }

    downloadFolder.deleteRecursively(force = true, continueOnFailure = false)
    logger.info("Gathered: {}", target)
  }

  private[this] def copy(name: String, source: Path, target: Path): Unit = {
    logger.trace("Copying {} name ...", name)
    source copyTo target
    logger.info("Gathered {}", name)
  }

  private[this] def dslCompiler(): Unit = {
    val src = (repositories / "dsl-compiler" ** s"*.exe").head
    val target = home / "dsl-compiler" / src.name
    copy("dsl-compiler", src, target)
  }

  private[this] def dslClc(): Unit = {
    val src = repositories / "dsl-compiler-client" / "CommandLineClient" / "target" / s"dsl-clc-${Analyse.dslClcVersion}-$xkcd-jar-with-dependencies.jar"
    val target = home / "dsl-compiler-client" / s"dsl-clc-${Analyse.dslClcVersion}-$xkcd.jar"
    copy("dsl-compiler-client", src, target)
  }

  private[this] def dslClientJava(): Unit =
    downloadDependencies("dsl-client-java"
    , s""""com.dslplatform" % "dsl-client-java" % "${Analyse.dslClientJavaVersion}-$xkcd""""
    , """"com.fasterxml.jackson.core" % "jackson-databind" % "2.7.4""""
    )

  private[this] def revenjCoreJava(): Unit =
    downloadDependencies("revenj-core_java"
    , s""""org.revenj" % "revenj-core" % "${Analyse.revenjCoreJavaVersion}-$xkcd""""
    , """"com.fasterxml.jackson.core" % "jackson-databind" % "2.7.4""""
    )

  private[this] val VersionPattern = """[ \t]+<version>([^<]+)</version>"""r
  private[this] def revenjServletJava(): Unit = {
    val src = repositories / "revenj" / "java" / "revenj-servlet" / "target" / "revenj-servlet.war"
    val target = home / "revenj-servlet_java" / s"revenj-servlet-${Analyse.revenjServletJavaVersion}-$xkcd.war"
    src copyTo target

    for (is <- target.inputStream) {
      val jis = new JarInputStream(is)
      try {
        Iterator.continually {
          jis.getNextJarEntry()
        } takeWhile {
          _ ne null
        } find { je =>
          je.getName == "META-INF/maven/org.revenj/revenj-servlet/pom.xml"
        } getOrElse sys.error("Could not locate POM inside the war package")

        val br = new BufferedReader(new InputStreamReader(jis, "UTF-8"))
        Iterator.continually {
          br.readLine()
        } takeWhile {
          _ ne null
        } find {
          case VersionPattern(warVersion) =>
            val pomVersion = Analyse.revenjServletJavaVersion + s"-$xkcd"
            assert(warVersion == pomVersion, s"Version mismatch - original POM vas: ${pomVersion}, but war was: ${warVersion}")
            true
          case _ =>
            false
        } getOrElse sys.error("Could not locate version line in POM!")
      } finally {
        jis.close()
      }
    }
    logger.info("Gathered {}", "revenj-servlet_java")
  }

  private[this] def revenjCoreScala(): Unit =
    downloadDependencies("revenj-core_scala"
    , s""""net.revenj" %% "revenj-core" % "${Analyse.revenjCoreScalaVersion}-$xkcd""""
    , """"org.scala-lang.modules" %% "scala-xml" % "1.0.5""""
    )

  private[this] def revenjAkkaScala(): Unit =
    downloadDependencies("revenj-akka_scala"
    , s""""net.revenj" %% "revenj-akka" % "${Analyse.revenjAkkaScalaVersion}-$xkcd""""
    , """"org.scala-lang.modules" %% "scala-xml" % "1.0.5""""
    )

  private[this] def revenjCoreNet(): Unit = {
    val src = (Fetch.releases ** (Fetch.`revenj.net library dependencies`.replaceFirst("\\.zip$", "") + "-*"))
      .headOption.getOrElse(sys.error("Could not gather revenj-core (.NET)"))
    val target = home / "revenj-core_net"
    copy("revenj-core_net", src, target)
  }

  private[this] def revenjServerNet(): Unit = {
    val src = (Fetch.releases ** (Fetch.`revenj.net runtime server`.replaceFirst("\\.zip$", "") + "-*"))
      .headOption.getOrElse(sys.error("Could not gather revenj-server (.NET)"))
    val target = home / "revenj-server_net"
    copy("revenj-server_net", src, target)
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
    , Future { revenjCoreNet() }
    , Future { revenjServerNet() }
    )
  }
}
