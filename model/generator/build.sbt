// ### BASIC SETTINGS ### //

organization := "com.dslplatform.ocd"
name := "DSL-OCD-Model-Generator"
version := "0.2.2"

unmanagedSourceDirectories in Compile := Seq(
  (scalaSource in Compile).value
)
unmanagedSourceDirectories in Test := Nil

// ### DEPENDENCIES ### //

libraryDependencies ++= Seq(
  "com.dslplatform.ocd" %% "dsl-ocd-util-generator" % "0.2.2"
, "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.3-1"
, "org.scala-lang.modules" %% "scala-xml" % "1.0.6"
)
