import sbt._
import Keys._

object H2 {

  val ORG = "com.h2database"
  val VERSION = "1.4.196"

  object artifacts {
    val h2 = "h2"
    val all = Seq(h2)
  }

  val config = Seq(
    libraryDependencies ++= artifacts.all map (ORG % _ % VERSION)
  )

}
