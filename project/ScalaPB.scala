import sbt._
import Keys._
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbtprotoc.ProtocPlugin.autoImport._

object ScalaPB {

  val config = Seq(
    libraryDependencies ++= Seq(
      "com.trueaccord.scalapb" %%% "scalapb-runtime" % com.trueaccord.scalapb.compiler.Version.scalapbVersion,
      "io.grpc" % "grpc-netty" % com.trueaccord.scalapb.compiler.Version.grpcJavaVersion
//      "com.trueaccord.scalapb" %% "scalapb-runtime-grpc" % com.trueaccord.scalapb.compiler.Version.scalapbVersion
    ),
    PB.targets in Compile := Seq(
      scalapb.gen() -> (sourceManaged in Compile).value
    ),
    PB.protoSources in Compile ++= Seq(
      file("shared/src/main/protobuf/")
    )
  )

}
