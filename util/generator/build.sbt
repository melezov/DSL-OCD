// ### BASIC SETTINGS ### //

organization := "com.dslplatform.ocd"
name := "DSL-OCD-Util-Generator"
version := "0.2.1"

unmanagedSourceDirectories in Compile := Seq(
  (scalaSource in Compile).value
)
unmanagedSourceDirectories in Test := Nil

// ### DEPENDENCIES ### //

libraryDependencies ++= Seq(
  "org.apache.commons" % "commons-lang3" % "3.3.1"
)

// ### ECLIPSE ### //

EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE16)
EclipseKeys.eclipseOutput := Some(".target")
