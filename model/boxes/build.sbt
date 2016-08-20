// ### BASIC SETTINGS ### //

organization := "com.dslplatform.ocd"
name := "DSL-OCD-Model-Boxes"
version := "0.2.1"

unmanagedSourceDirectories in Compile := Seq(
  (scalaSource in Compile).value
, sourceDirectory.value / "generated" / "scala"
)
unmanagedSourceDirectories in Test := Nil

// ### COMPILE SETTINGS ### //

scalaVersion := "2.11.8"
scalacOptions := Seq(
  "-deprecation"
, "-encoding", "UTF-8"
, "-feature"
, "-language:_"
, "-unchecked"
, "-Xcheckinit"
, "-Xfatal-warnings"
, "-Xfuture"
, "-Xlint"
, "-Xverify"
, "-Yclosure-elim"
, "-Yconst-opt"
, "-Ydead-code"
, "-Yinline"
, "-Yinline-warnings"
, "-Yrepl-sync"
, "-Ywarn-adapted-args"
, "-Ywarn-dead-code"
, "-Ywarn-inaccessible"
, "-Ywarn-infer-any"
, "-Ywarn-nullary-override"
, "-Ywarn-nullary-unit"
, "-Ywarn-numeric-widen"
, "-Ywarn-unused"
)

javacOptions in doc := Seq(
  "-encoding", "UTF-8"
, "-source", "1.6"
) ++ (sys.env.get("JDK16_HOME") match {
  case Some(jdk16Home) => Seq("-bootclasspath", jdk16Home + "/jre/lib/rt.jar")
  case _ => Nil
})
javacOptions := Seq(
  "-deprecation"
, "-Xlint"
, "-target", "1.6"
) ++ (javacOptions in doc).value

// ### PUBLISH SETTINGS ###

credentials in ThisBuild ++= {
  val creds = Path.userHome / ".config" / "DSL-OCD" / "nexus.config"
  if (creds.exists) Some(Credentials(creds)) else None
}.toSeq

scalacOptions in(Compile, doc) ++= Seq(
  "-no-link-warnings",
  "-sourcepath", baseDirectory.value.toString,
  "-doc-source-url", if (isSnapshot.value) {
    s"""https://github.com/dsl-platform/DSL-OCD/tree/master/model/boxes\u20AC{FILE_PATH}.scala"""
  } else {
    s"""https://github.com/dsl-platform/DSL-OCD/blob/v${version.value}/model/boxes\u20AC{FILE_PATH}.scala"""
  }
)

packageOptions := Seq(Package.ManifestAttributes(
  ("Implementation-Vendor", "DSL Platform"),
  ("Sealed", "true")
))

publishTo := Some(if (isSnapshot.value) Opts.resolver.sonatypeSnapshots else Opts.resolver.sonatypeStaging)
publishArtifact in Test := false
publishMavenStyle := true
pomIncludeRepository := { _ => false }

pomExtra :=
  <inceptionYear>2013</inceptionYear>
    <url>https://github.com/dsl-platform/DSL-OCD</url>
    <licenses>
      <license>
        <name>BSD 3-clause "New" or "Revised" License</name>
        <url>https://spdx.org/licenses/BSD-3-Clause.html</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:dsl-platform/DSL-OCD.git</url>
      <connection>scm:git:git@github.com:dsl-platform/DSL-OCD.git</connection>
    </scm>
    <developers>
      <developer>
        <id>melezov</id>
        <name>Marko Elezovi&#263;</name>
        <url>https://github.com/melezov</url>
      </developer>
      <developer>
        <id>hperadin</id>
        <name>Hrvoje Peradin</name>
        <url>https://github.com/hperadin</url>
      </developer>
      <developer>
        <id>tferega</id>
        <name>Tomo Ferega</name>
        <url>https://github.com/tferega</url>
      </developer>
    </developers>

// ### ECLIPSE ### //

EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE16)
EclipseKeys.eclipseOutput := Some(".target")
