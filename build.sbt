import Dependencies._

lazy val root = (project in file("."))
  .aggregate(jogiJS, jogiJVM)

lazy val jogi = crossProject.in(file("."))
  .settings(Project.config)
  .settings(ScalacOptions.standard)
  .settings(ScalacOptions.inConsole)
  .settings(ScalacOptions.inDoc)
  .settings(ScalacOptions.inDocSettings)
  .settings(ScalaJS.config)
  .jsSettings(ScalaJS.jsconfig)
  .settings(ScalaPB.config)
  .jsSettings(Akka.js.config: _*)
  .jvmSettings(Akka.config: _*)
  .jvmSettings(TypesafeConfig.config: _*)
//    libraryDependencies += "org.scala-js" %% "scalajs-stubs" % scalaJSVersion % "provided"

lazy val jogiJS = jogi.js
  .enablePlugins(
    ScalaJSPlugin
  )

lazy val jogiJVM = jogi.jvm
