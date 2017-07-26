import sbt._
import Keys._

object Postgresql {

  "org.postgresql" % "postgresql" % "42.1.3"

  val ORG = "org.postgresql"
  val VERSION = "42.1.3"

  object artifacts {
    val postgresql = "postgresql"
    val all = Seq(postgresql)
  }

  val config = Seq(
    libraryDependencies ++= artifacts.all map (ORG % _ % VERSION)
  )

}
