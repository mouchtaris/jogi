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

    scalacOptions ++= Seq(
      "-feature",
      "-language:implicitConversions"
    ),

    libraryDependencies += scalaTest % Test
  )
  .jsSettings(
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.1"
  )
  .jsSettings(Akka.js.config: _*)
  .jvmSettings(
//    libraryDependencies += "org.scala-js" %% "scalajs-stubs" % scalaJSVersion % "provided"
    libraryDependencies ++= Seq(
      "com.trueaccord.scalapb" %% "scalapb-runtime" % com.trueaccord.scalapb.compiler.Version.scalapbVersion % "protobuf",
      "io.grpc" % "grpc-netty" % com.trueaccord.scalapb.compiler.Version.grpcJavaVersion,
      "com.trueaccord.scalapb" %% "scalapb-runtime-grpc" % com.trueaccord.scalapb.compiler.Version.scalapbVersion
    ),
    PB.targets in Compile := Seq(
      scalapb.gen() -> (sourceManaged in Compile).value
    )
  )
  .jvmSettings(Akka.config: _*)
  .jvmSettings(TypesafeConfig.config: _*)

lazy val jogiJS = jogi.js
  .enablePlugins(
    ScalaJSPlugin
  )

lazy val jogiJVM = jogi.jvm