// ### COMPILE SETTINGS ### //

scalaVersion := "2.11.8"
scalacOptions := Seq(
  "-deprecation"
, "-encoding", "UTF-8"
, "-feature"
, "-language:_"
, "-unchecked"
, "-Xcheckinit"
, "-Xfatal-warnings"
, "-Xfuture"
, "-Xlint"
, "-Xverify"
, "-Yclosure-elim"
, "-Yconst-opt"
, "-Ydead-code"
, "-Yinline"
, "-Yinline-warnings:false"
, "-Yrepl-sync"
, "-Ywarn-adapted-args"
, "-Ywarn-dead-code"
, "-Ywarn-inaccessible"
, "-Ywarn-infer-any"
, "-Ywarn-nullary-override"
, "-Ywarn-nullary-unit"
, "-Ywarn-numeric-widen"
, "-Ywarn-unused"
)

javacOptions in doc := Seq(
  "-encoding", "UTF-8"
, "-source", "1.6"
) ++ (sys.env.get("JDK16_HOME") match {
  case Some(jdk16Home) => Seq("-bootclasspath", jdk16Home + "/jre/lib/rt.jar")
  case _ => Nil
})
javacOptions := Seq(
  "-deprecation"
, "-Xlint"
, "-target", "1.6"
) ++ (javacOptions in doc).value
