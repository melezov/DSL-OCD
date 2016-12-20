// ### BASIC SETTINGS ### //

organization := "com.dslplatform.ocd"
name := "DSL-OCD-Staging"
version := "0.2.2"

unmanagedSourceDirectories in Compile := Seq(
  (scalaSource in Compile).value
)
unmanagedSourceDirectories in Test := Nil

// ### DEPENDENCIES ### //

resolvers += "repo.jenkins-ci.org" at "http://repo.jenkins-ci.org/public"
libraryDependencies ++= Seq(
  "com.github.scala-incubator.io" %% "scala-io-file"    % "0.4.3-1"
, "com.github.nscala-time"        %% "nscala-time"      % "2.14.0"
, "org.kohsuke"                   %  "github-api"       % "1.80"
, "org.eclipse.jgit"              %  "org.eclipse.jgit" % "4.5.0.201609210915-r"
, "com.typesafe.scala-logging"    %% "scala-logging"    % "3.5.0"
, "ch.qos.logback"                %  "logback-classic"  % "1.1.8"
)

// ### ECLIPSE ### //

EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE16)
EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource
EclipseKeys.eclipseOutput := Some(".target")

// ### MISC ### //

fork in run := true
