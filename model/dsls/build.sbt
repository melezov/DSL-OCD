// ### BASIC SETTINGS ### //

organization := "com.dslplatform.ocd"
name := "DSL-OCD-Model-Dsls"
version := "0.2.1"

unmanagedSourceDirectories in Compile := Seq(
  (scalaSource in Compile).value
, sourceDirectory.value / "generated" / "scala"
)
unmanagedSourceDirectories in Test := Nil

// ### DEPENDENCIES ### //

libraryDependencies ++= Seq(
  "com.dslplatform.ocd" %% "dsl-ocd-model-types" % "0.2.1"
, "com.dslplatform.ocd" %% "dsl-ocd-model-boxes" % "0.2.1"
)

// ### ECLIPSE ### //

EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE16)
EclipseKeys.eclipseOutput := Some(".target")
