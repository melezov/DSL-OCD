// ### BASIC SETTINGS ### //

organization := "com.dslplatform.ocd"
name := "DSL-OCD-Model-Java-Asserts"
version := "0.2.1"

unmanagedSourceDirectories in Compile := Seq(
  sourceDirectory.value / "generated" / "java"
)
unmanagedSourceDirectories in Test := Nil

crossPaths := false
autoScalaLibrary := false

// ### DEPENDENCIES ### //

libraryDependencies ++= Seq(
  "com.dslplatform.ocd" % "dsl-ocd-util-testing" % "0.2.1"
, "joda-time" % "joda-time" % "2.9.4"
, "junit" % "junit" % "4.12"
)

// ### ECLIPSE ### //

EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE16)
EclipseKeys.eclipseOutput := Some(".target")
EclipseKeys.projectFlavor := EclipseProjectFlavor.Java
