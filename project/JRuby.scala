import sbt._, Keys._

object JRuby {

  final val ORG = "org.jruby"
  final val VERSION = "9.1.12.0"

  final object artifacts {
    final val jruby = "jruby"
    final val all = Seq(jruby)
  }

  final val config = Seq(
    libraryDependencies ++= artifacts.all map (ORG %% _ % VERSION)
  )

}