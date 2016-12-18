// ### BASIC SETTINGS ### //

organization := "com.dslplatform.ocd"
name := "DSL-OCD-Model-Java-Asserts"
version := "0.2.2"

unmanagedSourceDirectories in Compile := Seq(
  sourceDirectory.value / "generated" / "java"
)
unmanagedSourceDirectories in Test := Nil

crossPaths := false
autoScalaLibrary := false

// ### DEPENDENCIES ### //

libraryDependencies ++= Seq(
  "com.dslplatform.ocd" % "dsl-ocd-util-testing" % "0.2.2"
, "com.dslplatform" % "dsl-client-java" % "1.5.0"
, "joda-time" % "joda-time" % "2.9.6"
, "junit" % "junit" % "4.12"
)

resolvers += Resolver.mavenLocal

// ### ECLIPSE ### //

EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE16)
EclipseKeys.eclipseOutput := Some(".target")
EclipseKeys.projectFlavor := EclipseProjectFlavor.Java
