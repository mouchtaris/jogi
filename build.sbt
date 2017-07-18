import Dependencies._

lazy val root = (project in file("."))
  .aggregate(jogiJS, jogiJVM)

lazy val jogi = crossProject.in(file("."))
  .settings(Project.config)
  .settings {
    import ScalacOptions._
    standard ++ inConsole ++ inDoc ++ inDocSettings
  }
  .settings(ScalaJS.config).jsSettings(ScalaJS.jsconfig)
  .settings(ScalaPB.config)
  .jvmSettings(Akka.config).jsSettings(Akka.js.config)
  .jvmSettings(TypesafeConfig.config)
  .settings(Scalariform.config)
  .jvmSettings(SprayJson.config)
  .jvmSettings(JRuby.config)
  .jvmSettings(Slick.config)
//    libraryDependencies += "org.scala-js" %% "scalajs-stubs" % scalaJSVersion % "provided"

lazy val jogiJS = jogi.js
  .enablePlugins(
    ScalaJSPlugin
  )

lazy val jogiJVM = jogi.jvm
