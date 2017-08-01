import sbt._
import Keys._

object Scalaz {

  val ORG = "org.scalaz"
  val VERSION = "7.2.14"

  object artifacts {
    val core = "scalaz-core"
    val all = Seq(core)
  }

  val config = Seq(
    libraryDependencies ++= artifacts.all map (ORG %% _ % VERSION)
  )
}
