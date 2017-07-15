import sbt._
import Keys._

object SprayJson {

  final val VERSION = "1.3.3"

  final val ORG = "io.spray"

  object packages {
    final val json = "spray-json"
    final val all = Seq(json)
  }

  val config = Seq(
    libraryDependencies ++= packages.all map(ORG %% _ % VERSION)
  )
}
