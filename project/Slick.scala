import sbt._
import Keys._

object Slick {

  val ORG = "com.typesafe.slick"
  val VERSION = "3.2.0"

  object artifacts {
    val slick = "slick"
    val hikari = "slick-hikaricp"
    val codegen = "slick-codegen"
    val all = Seq(slick, hikari, codegen)
  }

  val config = Seq(
    libraryDependencies ++= artifacts.all map (ORG %% _ % VERSION)
  )

}
