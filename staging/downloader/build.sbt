scalaVersion := "2.11.8"
autoScalaLibrary := false
crossPaths := false

sources in Compile := Nil

resolvers += Resolver.mavenLocal

libraryDependencies ++= Seq(
//  "com.dslplatform" % "dsl-client-java" % "1.4.3-160723-221904"
//, "com.fasterxml.jackson.core" % "jackson-databind" % "2.7.4"

  "org.revenj" % "revenj-servlet" % "1.0.0-160723-221904"
)

packAutoSettings
packCopyDependenciesUseSymbolicLinks := false
packCopyDependenciesTarget := file("dependencies")
