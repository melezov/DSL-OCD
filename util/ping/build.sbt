// ### BASIC SETTINGS ### //

organization := "com.dslplatform.ocd"
name := "DSL-OCD-Util-Ping"
version := "0.2.2"

unmanagedSourceDirectories in Compile := Seq(
  (javaSource in Compile).value
)
unmanagedSourceDirectories in Test := Nil

crossPaths := false
autoScalaLibrary := false
