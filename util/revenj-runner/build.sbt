// ### BASIC SETTINGS ### //

organization := "com.dslplatform.ocd"
name := "DSL-OCD-Util-Revenj-Runner"
version := "0.2.2"

unmanagedSourceDirectories in Compile := Seq(
  (javaSource in Compile).value
)
unmanagedSourceDirectories in Test := Nil

crossPaths := false
autoScalaLibrary := false

// ### DEPENDENCIES ### //

libraryDependencies ++= Seq(
  "org.nanohttpd" % "nanohttpd" % "2.3.1"
)

assemblyJarName in assembly := s"${name.value.toLowerCase}-${version.value}.jar"

// ### ECLIPSE ### //

EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE16)
EclipseKeys.eclipseOutput := Some(".target")
EclipseKeys.projectFlavor := EclipseProjectFlavor.Java
