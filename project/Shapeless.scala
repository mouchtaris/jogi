import sbt._
import Keys._

object Shapeless {

  val Resolvers = Seq(
    Resolver.sonatypeRepo("releases"),
    Resolver.sonatypeRepo("snapshots")
  )

  val ORG = "com.chuusai"
  val VERSION = "2.3.2"

  object artifacts {
    val shapeless = "shapeless"
    val all = Seq(shapeless)
  }

  val config = Seq(
    resolvers ++= Resolvers,
    libraryDependencies ++= artifacts.all map (ORG %% _ % VERSION)
  )

}
