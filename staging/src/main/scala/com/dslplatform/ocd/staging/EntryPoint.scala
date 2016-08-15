package com.dslplatform.ocd
package staging

import java.util.regex.Pattern
import scala.concurrent.ExecutionContext
import sys.process._

object EntryPoint
    extends App {

  val now = DateTime.now
  val xkcd = now.toString("YYMMdd-HHmmss")

  Repositories.clean()

  Git("dsl-platform", "dsl-json",            "master")
  Git("dsl-platform", "dsl-client-java",     "master")
  Git("dsl-platform", "revenj",              "master")
  Git("dsl-platform", "dsl-compiler-client", "master")
  Git("dsl-platform", "DSL-OCD",             "master")

  val dslJsonVersion = Sed("dsl-json", "library/pom.xml",
    None ->
      "(<version>)([^<]+)(</version>)" ->
      s"$$1$$2-$xkcd$$3"
  )
  val dslJsonJava8Version = Sed("dsl-json", "java8/pom.xml",
    None ->
      "(<version>)([^<]+)(</version>)" ->
      s"$$1$$2-$xkcd$$3"
  , Some(dslJsonVersion) ->
      """(<dependency>\s+<groupId>com.dslplatform</groupId>\s+<artifactId>dsl-json</artifactId>\s+<version>)([^<]+)(</version>)""" ->
      s"$$1${dslJsonVersion}-$xkcd$$3"
  )

  val dslClientJavaVersion = Sed("dsl-client-java", "build.sbt",
    None ->
      """(version in ThisBuild\s+:= ")([^"]+)(")""" ->
      s"$$1$$2-$xkcd$$3"
  )
  Sed("dsl-client-java", "project/Build.scala",
    None ->
      """(\n\s+, )(EclipseKeys\.projectFlavor := EclipseProjectFlavor\.Java)""" ->
      "$1$2$1resolvers += Resolver.mavenLocal"
  , Some(dslJsonVersion) ->
      """(val dslJson = "com.dslplatform" % "dsl-json" % ")([^"]+)(")""" ->
      s"$$1${dslJsonVersion}-$xkcd$$3"
  )

  val revenjCoreVersion = Sed("revenj", "java/revenj-core/pom.xml",
    None ->
      "(<version>)([^<]+)(</version>)" ->
      s"$$1$$2-$xkcd$$3"
  , Some(dslJsonJava8Version) ->
      """(<dependency>\s+<groupId>com.dslplatform</groupId>\s+<artifactId>dsl-json-java8</artifactId>\s+<version>)([^<]+)(</version>)""" ->
      s"$$1${dslJsonJava8Version}-$xkcd$$3"
  )
  val revenjServletVersion = Sed("revenj", "java/revenj-servlet/pom.xml",
    None ->
      "(<version>)([^<]+)(</version>)" -> s"$$1$$2-$xkcd$$3"
  , Some(revenjCoreVersion) ->
      """(<dependency>\s+<groupId>org.revenj</groupId>\s+<artifactId>revenj-core</artifactId>\s+<version>)([^<]+)(</version>)""" ->
      s"$$1${revenjCoreVersion}-$xkcd$$3"
  )

  val dslClcVersion = Sed("dsl-compiler-client", "CommandLineClient/pom.xml",
    None ->
      "(<version>)([^<]+)(</version>)" ->
      s"$$1$$2-$xkcd$$3"
  )
  Path("repositories/dsl-compiler-client/CommandLineClient/src/main/resources/com/dslplatform/compiler/client/dsl-clc.properties", '/')
      .write(s"version=${dslClcVersion}-$xkcd\ndate=${now.toLocalDate}")


//  private implicit val executionContext =
//    ExecutionContext.fromExecutor(
//      java.util.concurrent.Executors.newFixedThreadPool(
//        Runtime.getRuntime.availableProcessors()))

  Mvn("dsl-compiler-client", "CommandLineClient", "clean", "package")
  Mvn("dsl-json", "library", "clean", "install")
  Mvn("dsl-json", "java8", "clean", "install")
  Sbt("dsl-client-java", "", "clean", "publishM2")
  Mvn("revenj", "java/revenj-core", "clean", "install")
  Mvn("revenj", "java/revenj-servlet", "clean", "install", "war:war")
  Sbt("revenj", "scala", "clean", "publishM2")
}

object Repositories {
  val userHome = Path("repositories") / ".home" toAbsolute

  def clean(): Unit = if (userHome.exists) {
    userHome.deleteRecursively(force = true, continueOnFailure = false)
  }
}

object Git {
  def apply(username: String, project: String, branch: String): Unit = {
    val target = Path("repositories") / project
    if (target.exists) {
      target.deleteRecursively(force = true, continueOnFailure = false)
    }
    Seq(
      "git", "clone"
    , "-b", branch
    , "--depth", "1"
    , "--single-branch"
    , s"git@github.com:/${username}/${project}.git", s"repositories/${project}"
    )!
  }
}

object Sed {
  def apply(
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
}

object Mvn {
  import Repositories._

  def apply(project: String, path: String, commands: String*): Unit = {
    val target = Path(s"repositories/${project}/${path}", '/')

    Process((Seq(
      "cmd", "/c", "mvn"
    , "-Dmaven.test.skip=true"
    , s"-Duser.home=${userHome.path}"
    ) ++ commands), target.jfile)!
  }
}

object Sbt {
  import Repositories._

  def apply(project: String, path: String, commands: String*): Unit = {
    val target = Path(s"repositories/${project}/${path}", '/')
    val launcher = Path("tools") / "sbt-launch-0.13.12.jar"

    Process((Seq(
      "java"
    , s"-Duser.home=${userHome.path}"
    , "-jar", launcher.toAbsolute.path
    ) ++ commands), target.jfile)!
  }
}
