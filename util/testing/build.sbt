// ### BASIC SETTINGS ### //

organization := "com.dslplatform.ocd"
name := "DSL-OCD-Util-Testing"
version := "0.2.2"

unmanagedSourceDirectories in Compile := Seq(
  (javaSource in Compile).value
)
unmanagedSourceDirectories in Test := Nil

crossPaths := false
autoScalaLibrary := false

// ### DEPENDENCIES ### //

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.12"
, "commons-lang" % "commons-lang" % "2.6"
)

packageOptions in (Compile, packageBin) +=
  Package.ManifestAttributes( java.util.jar.Attributes.Name.SEALED -> "false" )
