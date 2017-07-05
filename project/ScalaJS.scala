import sbt._
import Keys._
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

object ScalaJS {

  val config = Seq(
    scalaJSUseMainModuleInitializer := true
  )

  val jsconfig = Seq(
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.1"
  )

}
