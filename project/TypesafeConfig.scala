import sbt._
import Keys._

object TypesafeConfig {

  val org = "com.typesafe"
  val version = "1.3.1"

  object packages {
    val config = "config"
    val all = Seq(
      config
    )
  }

  val config = Seq(
    libraryDependencies ++= packages.all.map(org % _ % version)
  )

}
