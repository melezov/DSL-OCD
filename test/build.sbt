// ### BASIC SETTINGS ### //

organization := "com.dslplatform.ocd"
name := "DSL-OCD-Test-Generator"
version := "0.2.1"

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
  "com.dslplatform.ocd" %% "dsl-ocd-model-dsls" % "0.2.1"
, "com.dslplatform.ocd" %% "dsl-ocd-model-javas" % "0.2.1"
, "com.dslplatform.ocd" %% "dsl-ocd-model-scalas" % "0.2.1"
, "com.dslplatform" % "dsl-clc" % "1.7.2"
, "hr.element.etb" %% "etb-util" % "0.2.23"
, "io.jvm.uuid" %% "scala-uuid" % "0.2.1"
, "ch.qos.logback" % "logback-classic" % "1.1.7"
)

// ### ECLIPSE ### //

EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE16)
EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource
EclipseKeys.eclipseOutput := Some(".target")

// ### MISC ### //

fork in run := true
