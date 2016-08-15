scalaVersion := "2.11.8"
autoScalaLibrary := false

resolvers += Resolver.mavenLocal

packAutoSettings
packCopyDependenciesUseSymbolicLinks := false
packCopyDependenciesTarget := file("dependencies")
