// ### BASIC SETTINGS ### //

organization := "com.dslplatform.ocd"
name := "DSL-OCD-Model-Boxes"
version := "0.2.2"

unmanagedSourceDirectories in Compile := Seq(
  (scalaSource in Compile).value
, sourceDirectory.value / "generated" / "scala"
)
unmanagedSourceDirectories in Test := Nil

// ### ECLIPSE ### //

EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE16)
EclipseKeys.eclipseOutput := Some(".target")
