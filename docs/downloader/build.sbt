scalaVersion := "2.11.8"
autoScalaLibrary := false
crossPaths := false

sources in Compile := Nil

resolvers += Resolver.mavenLocal

libraryDependencies ++= Seq(
//  "com.dslplatform" % "dsl-client-java" % "1.4.2-20160419-133000"
//, "com.fasterxml.jackson.core" % "jackson-databind" % "2.7.3"

  "org.revenj" % "revenj-servlet" % "0.9.6-20160419-133000"
)

packAutoSettings
packCopyDependenciesUseSymbolicLinks := false
packCopyDependenciesTarget := file("dependencies")
