import sbt._
import Keys._
import Dependencies._

object Project {

  val config =
    inThisBuild(List(
      organization := "light.jogi",
      scalaVersion := "2.12.2",
      version      := "0.1.0-SNAPSHOT"
    )) ++
    Seq(
      name := "Jogi",
      libraryDependencies += scalaTest % Test
    )

}
