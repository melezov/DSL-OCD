package com.dslplatform.ocd
package staging

import java.util.regex.Pattern

object Analyse {
  private[this] def sed(
      project: String, path: String
    , replacements: ((Option[String], String), String)*): String = {

    val target = Path(s"repositories/${project}/${path}", '/')
    val backup = Path(s"repositories/${project}/${path}.backup", '/')

    if (backup.exists) {
      backup.copyTo(target = target, replaceExisting = true)
    } else {
      target.copyTo(target = backup)
    }

    val ((firstCheck, firstPattern), firstReplacement) = replacements.head
    val firstMatcher = Pattern.compile(firstPattern).matcher(target.string)
    assert(firstMatcher.find(), s"Could not find $firstPattern in ${target.path}")

    val origVersion = firstMatcher.group(2)
    for (check <- firstCheck) yield {
      assert(origVersion == check, s"Version of $project/$path dependency ${origVersion} differs from expected: ${check}")
      println(s"Original version of $project/$path was: $origVersion")
      origVersion
    }

    val sb = new StringBuffer
    firstMatcher.appendReplacement(sb, firstReplacement)
    val nextBody = firstMatcher.appendTail(sb).toString

    val body = replacements.tail.foldLeft(nextBody) { case (acc, ((nextCheck, nextPattern), nextReplacement)) =>
      val nextMatcher = Pattern.compile(nextPattern).matcher(acc)
      assert(nextMatcher.find(), s"Could not find $nextPattern in ${target.path}")

      val nextVersion = nextMatcher.group(2)
      for (check <- nextCheck) {
        assert(nextVersion == check, s"Version of $project/$path dependency ${nextVersion} differs from expected: ${check}")
      }
      acc.replaceFirst(nextPattern, nextReplacement)
    }

    target write body
    origVersion
  }

  lazy val dslClcVersion = {
    val version = sed("dsl-compiler-client", "CommandLineClient/pom.xml",
      None ->
        "(<version>)([^<]+)(</version>)" ->
        s"$$1$$2-$xkcd$$3"
    )
    Path("repositories/dsl-compiler-client/CommandLineClient/src/main/resources/com/dslplatform/compiler/client/dsl-clc.properties", '/')
      .write(s"version=${version}-$xkcd\ndate=${now.toLocalDate}")
    version
  }

  lazy val dslJsonVersion = sed("dsl-json", "library/pom.xml",
    None ->
      "(<version>)([^<]+)(</version>)" ->
      s"$$1$$2-$xkcd$$3"
  )

  lazy val dslJsonJava8Version = sed("dsl-json", "java8/pom.xml",
    None ->
      "(<version>)([^<]+)(</version>)" ->
      s"$$1$$2-$xkcd$$3"
    , Some(dslJsonVersion) ->
      """(<dependency>\s+<groupId>com.dslplatform</groupId>\s+<artifactId>dsl-json</artifactId>\s+<version>)([^<]+)(</version>)""" ->
      s"$$1${dslJsonVersion}-$xkcd$$3"
  )

  lazy val dslClientJavaVersion = {
    val version = sed("dsl-client-java", "build.sbt",
      None ->
        """(version in ThisBuild\s+:= ")([^"]+)(")""" ->
        s"$$1$$2-$xkcd$$3"
    )
    sed("dsl-client-java", "project/Build.scala",
      None ->
        """(\n\s+, )(EclipseKeys\.projectFlavor := EclipseProjectFlavor\.Java)""" ->
        "$1$2$1resolvers += Resolver.mavenLocal"
      , Some(dslJsonVersion) ->
        """(val dslJson = "com.dslplatform" % "dsl-json" % ")([^"]+)(")""" ->
        s"$$1${dslJsonVersion}-$xkcd$$3"
    )
    version
  }

  lazy val revenjCoreJavaVersion = sed("revenj", "java/revenj-core/pom.xml",
    None ->
      "(<version>)([^<]+)(</version>)" ->
      s"$$1$$2-$xkcd$$3"
    , Some(dslJsonJava8Version) ->
      """(<dependency>\s+<groupId>com.dslplatform</groupId>\s+<artifactId>dsl-json-java8</artifactId>\s+<version>)([^<]+)(</version>)""" ->
      s"$$1${dslJsonJava8Version}-$xkcd$$3"
  )
  lazy val revenjServletJavaVersion = sed("revenj", "java/revenj-servlet/pom.xml",
    None ->
      "(<version>)([^<]+)(</version>)" -> s"$$1$$2-$xkcd$$3"
    , Some(revenjCoreJavaVersion) ->
      """(<dependency>\s+<groupId>org.revenj</groupId>\s+<artifactId>revenj-core</artifactId>\s+<version>)([^<]+)(</version>)""" ->
      s"$$1${revenjCoreJavaVersion}-$xkcd$$3"
  )

  lazy val revenjCoreScalaVersion = sed("revenj", "scala/build.sbt",
    None ->
      """(?s)(revenj-core.+?version := ")([^"]+)(")""" ->
      s"$$1$$2-$xkcd$$3"
  )
  lazy val revenjAkkaScalaVersion = sed("revenj", "scala/build.sbt",
    None ->
      """(?s)(revenj-akka.+?version := ")([^"]+)(")""" ->
      s"$$1$$2-$xkcd$$3"
    , None ->
      """(?s)(revenj-core.+?version := ")([^"]+)(")""" ->
        s"$$1${revenjCoreScalaVersion}-$xkcd$$3"
  )

  def apply(): Unit = {
    logger.info("Analysed dsl-clc: {}", dslClcVersion)
    logger.info("Analysed dsl-json version: {}", dslJsonVersion)
    logger.info("Analysed dsl-json-java8 version: {}", dslJsonJava8Version)
    logger.info("Analysed dsl-client-java version: {}", dslClientJavaVersion)
    logger.info("Analysed revenj-core (Java) version: {}", revenjCoreJavaVersion)
    logger.info("Analysed revenj-servlet (Java) version: {}", revenjServletJavaVersion)
    logger.info("Analysed revenj-core (Scala) version: {}", revenjCoreScalaVersion)
    logger.info("Analysed revenj-akka (Scala) version: {}", revenjAkkaScalaVersion)
  }
}
