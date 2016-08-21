// ### BASIC SETTINGS ### //

organization := "com.dslplatform.ocd"
name := "DSL-OCD-Staging"
version := "0.2.1"

unmanagedSourceDirectories in Compile := Seq(
  (scalaSource in Compile).value
)
unmanagedSourceDirectories in Test := Nil

// ### DEPENDENCIES ### //

resolvers += "repo.jenkins-ci.org" at "http://repo.jenkins-ci.org/public"
libraryDependencies ++= Seq(
  "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.3-1"
, "com.github.nscala-time"        %% "nscala-time"   % "2.12.0"
, "org.kohsuke"                   %  "github-api"    % "1.77"

, "com.typesafe.scala-logging" %% "scala-logging"  % "3.4.0"
, "ch.qos.logback"             % "logback-classic" % "1.1.7"
)

// ### ECLIPSE ### //

EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE16)
EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource
EclipseKeys.eclipseOutput := Some(".target")

// ### MISC ### //

fork in run := true
