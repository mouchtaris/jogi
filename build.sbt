import Dependencies._

lazy val root = (project in file("."))
  .aggregate(jogiJS, jogiJVM)

lazy val jogi = crossProject.in(file("."))
  .settings(
    inThisBuild(List(
      organization := "light.jogi",
      scalaVersion := "2.12.2",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Jogi JS",
    scalaJSUseMainModuleInitializer := true,

    libraryDependencies += scalaTest % Test
  )
  .jsSettings(
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.1"
  )
  .jvmSettings(
    libraryDependencies += "org.scala-js" %% "scalajs-stubs" % scalaJSVersion % "provided"
  )

lazy val jogiJS = jogi.js
  .enablePlugins(
    ScalaJSPlugin
  )
lazy val jogiJVM = jogi.jvm
