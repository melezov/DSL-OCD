// ### BASIC SETTINGS ### //

organization := "com.dslplatform.ocd"
name := "DSL-OCD-Model-Kinds"
version := "0.2.2"

unmanagedSourceDirectories in Compile := Seq(
  (scalaSource in Compile).value
)
unmanagedSourceDirectories in Test := Nil
