// ### BASIC SETTINGS ### //

organization := "com.dslplatform.ocd"
name := "DSL-OCD-Model-Javas"
version := "0.2.2"

unmanagedSourceDirectories in Compile := Seq(
  (scalaSource in Compile).value
, sourceDirectory.value / "generated" / "scala"
)
unmanagedSourceDirectories in Test := Nil

// ### DEPENDENCIES ### //

libraryDependencies ++= Seq(
  "com.dslplatform.ocd" %% "dsl-ocd-model-types" % "0.2.2"
, "com.dslplatform.ocd" %% "dsl-ocd-model-boxes" % "0.2.2"
)
