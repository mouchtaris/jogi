import sbt._
import Keys._
import org.scalajs.sbtplugin.ScalaJSPlugin, ScalaJSPlugin.autoImport._
import language.{ postfixOps }

object Akka {
  val org: String = "com.typesafe.akka"
  val version: String  = "2.5.2"

  val config =
    http.config ++
    actor.config ++
    Seq.empty

  val akkaModuleId: String ⇒ String =
    "akka-" +

  object http {
    val version: String = "10.0.9"

    object packages {
      val http = "http"
      lazy val all = Seq(http)
    }

    lazy val deps = packages.all.map(akkaModuleId).map(org %% _ % version)

    lazy val config = Seq(
      libraryDependencies ++= deps
    )
  }

  abstract case class js(akkaVersion: String) {
    val org: String = "org.akka-js"
    val versionPrefix: String = "1"
    val version: String = s"$versionPrefix.$akkaVersion"

    object packages {
      val actor = "akkajsactor"
      val stream = "akkajsactorstream"
      val streamtestkit = "akkajsstreamtestkit"
      val actortestkit = "akkajstestkit"
      lazy val all = Seq(actor, stream, streamtestkit, actortestkit)
    }

    lazy val config = Seq(
      libraryDependencies ++= packages.all.map(org %%% _ % version)
    )
  }
  object js extends js(Akka.version)

  object actor {

    object packages {
      val actor = "actor"
      val testkit = "testkit"
      val remote = "remote"
      val slf4j = "slf4j"
      val stream = "stream"
      val streamtestkit = "stream-testkit"
      lazy val all = Seq(actor, testkit, remote, slf4j, stream, streamtestkit)
    }

    lazy val deps = packages.all.map(akkaModuleId).map(org %% _ % version)

    lazy val config = Seq(
      libraryDependencies ++= deps
    )
  }
}
