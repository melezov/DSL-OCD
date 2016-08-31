package com.dslplatform.ocd.staging

import scala.sys.process._

object Deploy {
  private[this] def dslCompiler(): Unit = {
    val src = (Gather.home / "dsl-compiler" ** "dsl-compiler-*.exe")
        .headOption.getOrElse(sys.error("Could not locate dsl-compiler to deploy!"))
    val target = templates / "tools" / "build"

    for (old <- (target ** "dsl-compiler-*.exe")) {
      logger.debug("Cleaning previous dsl-complier: {}", old.name)
      old.delete(true)
    }

    for (config <- (templates / "build-templates" ** "build-common-template-*.xml")) {
      val body = config.string
      val patchedVersion = body.replaceFirst("""(<property name="dsl-compiler" value=")dsl-compiler-[^"]+("/>)""", s"$$1${src.name}$$2")
      if (body != patchedVersion) {
        config write patchedVersion
        logger.debug("Patched dsl-compiler version in {}", config.name)
      }
    }

    src copyTo target / src.name
    logger.info("Copied {} to tools/build", src.name)
  }
  private[this] def dslCompilerClient(): Unit = {
    val src = (Gather.home / "dsl-compiler-client" ** "dsl-clc-*.jar")
        .headOption.getOrElse(sys.error("Could not locate dsl-compiler-client to deploy!"))
    val target = templates / "tools" / "build"

    for (old <- (target ** "dsl-clc-*.jar")) {
      logger.debug("Cleaning previous dsl-complier: {}", old.name)
      old.delete(true)
    }

    for (config <- (templates / "build-templates" ** "build-common-template-*.xml")) {
      val body = config.string
      val patchedVersion = body.replaceFirst("""(<property name="dsl-compiler" value=")dsl-compiler-[^"]+("/>)""", s"$$1${src.name}$$2")
      if (body != patchedVersion) {
        config write patchedVersion
        logger.debug("Patched dsl-compiler version in {}", config.name)
      }
    }

    src copyTo target / src.name
    logger.info("Copied {} to tools/build", src.name)
  }

  def apply(): Unit = {
    block(
      Future { dslCompiler() }
      Future { dslCompilerClient() }
    )
  }
}
//
//  private[this] def downloadDependencies(target: String, dependencies: String*): Unit = {
//    val downloadFolder = home / target / "downloader"
//    (templates / "tools" / "downloader") copyTo downloadFolder
//
//    val libs = (dependencies map { dependency =>
//      "libraryDependencies += " + dependency
//    }).mkString("""import sbt._
//import Keys._
//
//""", "\n", "\n")
//
//    (downloadFolder / "dependencies.sbt") write libs
//
//    val launcher = templates / "tools" / "build" / "sbt-launch-0.13.12.jar"
//    logger.debug(">> Starting SBT @ {}: packCopyDependencies", target + "/downloader")
//    Process(Seq(
//      "java"
//    , s"-Duser.home=${userHome.path}"
//    , "-jar", launcher.toAbsolute.path
//    , "packCopyDependencies"
//    ), downloadFolder.fileOption.get)! ProcessLogger(logger.trace(_), logger.warn(_))
//    logger.debug("<< Finished with SBT @ {}: packCopyDependencies", target + "/downloader")
//
//    val packDeps = downloadFolder / "dependencies"
//    (packDeps / "downloader_2.11-0.1-SNAPSHOT.jar").delete(force = true)
//    (packDeps ** "*.jar") foreach { jar => jar moveTo downloadFolder.parent.get / jar.name }
//
//    downloadFolder.deleteRecursively(force = true, continueOnFailure = false)
//    logger.info("Gathered: {}", target)
//  }
//
//  private[this] def dslCompiler(): Unit = {
//    val src = (repositories / "dsl-compiler" ** s"*.exe").head
//    val target = home / "dsl-compiler" / src.name
//    src copyTo target
//    logger.info("Gathered {}", "dsl-compiler")
//  }
//
//  private[this] def dslClc(): Unit = {
//    val src = repositories / "dsl-compiler-client" / "CommandLineClient" / "target" / s"dsl-clc-${Analyse.dslClcVersion}-$xkcd-jar-with-dependencies.jar"
//    val target = home / "dsl-compiler-client" / s"dsl-clc-${Analyse.dslClcVersion}-$xkcd.jar"
//    src copyTo target
//    logger.info("Gathered {}", "dsl-compiler-client")
//  }
//
//  private[this] def dslClientJava(): Unit =
//    downloadDependencies("dsl-client-java"
//    , s""""com.dslplatform" % "dsl-client-java" % "${Analyse.dslClientJavaVersion}-$xkcd""""
//    , """"com.fasterxml.jackson.core" % "jackson-databind" % "2.7.4""""
//    )
//
//  private[this] def revenjCoreJava(): Unit =
//    downloadDependencies("revenj-core_java"
//    , s""""org.revenj" % "revenj-core" % "${Analyse.revenjCoreJavaVersion}-$xkcd""""
//    , """"com.fasterxml.jackson.core" % "jackson-databind" % "2.7.4""""
//    )
//
//  private[this] val VersionPattern = """[ \t]+<version>([^<]+)</version>"""r
//  private[this] def revenjServletJava(): Unit = {
//    val src = repositories / "revenj" / "java" / "revenj-servlet" / "target" / "revenj-servlet.war"
//    val target = home / "revenj-servlet_java" / s"revenj-servlet-${Analyse.revenjServletJavaVersion}-$xkcd.war"
//    src copyTo target
//
//    for (is <- target.inputStream) {
//      val jis = new JarInputStream(is)
//      try {
//        Iterator.continually {
//          jis.getNextJarEntry()
//        } takeWhile {
//          _ ne null
//        } find { je =>
//          je.getName == "META-INF/maven/org.revenj/revenj-servlet/pom.xml"
//        } getOrElse sys.error("Could not locate POM inside the war package")
//
//        val br = new BufferedReader(new InputStreamReader(jis, "UTF-8"))
//        Iterator.continually {
//          br.readLine()
//        } takeWhile {
//          _ ne null
//        } find {
//          case VersionPattern(warVersion) =>
//            val pomVersion = Analyse.revenjServletJavaVersion + s"-$xkcd"
//            assert(warVersion == pomVersion, s"Version mismatch - original POM vas: ${pomVersion}, but war was: ${warVersion}")
//            true
//          case _ =>
//            false
//        } getOrElse sys.error("Could not locate version line in POM!")
//      } finally {
//        jis.close()
//      }
//    }
//    logger.info("Gathered {}", "revenj-servlet_java")
//  }
//
//  private[this] def revenjCoreScala(): Unit =
//    downloadDependencies("revenj-core_scala"
//    , s""""net.revenj" %% "revenj-core" % "${Analyse.revenjCoreScalaVersion}-$xkcd""""
//    , """"org.scala-lang.modules" %% "scala-xml" % "1.0.5""""
//    )
//
//  private[this] def revenjAkkaScala(): Unit =
//    downloadDependencies("revenj-akka_scala"
//    , s""""net.revenj" %% "revenj-akka" % "${Analyse.revenjAkkaScalaVersion}-$xkcd""""
//    , """"org.scala-lang.modules" %% "scala-xml" % "1.0.5""""
//    )
