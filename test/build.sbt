// ### BASIC SETTINGS ### //

organization := "com.dslplatform.ocd"
name := "DSL-OCD-Test-Generator"
version := "0.2.2"

unmanagedSourceDirectories in Compile :=
  Seq("interfaces", "services", "turtles").map {
    sourceDirectory.value / _ / "scala"
  } :+ (scalaSource in Compile).value
unmanagedResourceDirectories in Compile := Seq(
  sourceDirectory.value / "main" / "resources"
)
unmanagedSourceDirectories in Test := Nil

// ### DEPENDENCIES ### //

libraryDependencies ++= Seq(
  "com.dslplatform.ocd" %% "dsl-ocd-model-dsls" % "0.2.2"
, "com.dslplatform.ocd" %% "dsl-ocd-model-javas" % "0.2.2"
, "com.dslplatform.ocd" %% "dsl-ocd-model-scalas" % "0.2.2"
, "com.github.nscala-time" %% "nscala-time" % "2.16.0"
, "io.jvm.uuid" %% "scala-uuid" % "0.2.2"
, "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.3-1"
, "ch.qos.logback" % "logback-classic" % "1.2.3"
)

resolvers += Resolver.mavenLocal

// ### ECLIPSE ### //

EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE16)
EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource
EclipseKeys.eclipseOutput := Some(".target")

// ### MISC ### //

fork in run := true
