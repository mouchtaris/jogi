package jogi.jvm

import java.io.FileOutputStream

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

import scala.concurrent.{duration, Await, ExecutionContext, Future}
import duration._
import scala.language.postfixOps
import com.typesafe.config.{Config, ConfigFactory}

object App {

  final case class Stdout(any: Any)

  final class StdStreamer extends Actor {
    def receive: Receive = {
      case Stdout(any) ⇒ println(any)
    }
  }

  final def index_html(acc: Array[Byte]): String =
    s"""
      |<!DOCTYPE html>
      |<html>
      |  <head>
      |    <meta charset="UTF-8">
      |    <title>The Scala.js Tutorial</title>
      |    <script type="text/javascript">
      |      window.poo = {
      |        the_account: [${acc.map(_.toString).mkString(", ")}]
      |      }
      |    </script>
      |  </head>
      |  <body>
      |    <!-- Include Scala.js compiled code -->
      |    <script type="text/javascript" src="./js/target/scala-2.12/jogi-js-fastopt.js"></script>
      |  </body>
      |</html>
      |
    """.stripMargin

  def main(args: Array[String]): Unit = {
    import jogi.proto.jogi.Account
    val acc: Account = Account(email = "bobos@com.com")
    val accbytes: Array[Byte] = {
      val bout = new java.io.ByteArrayOutputStream(4096)
      acc.writeTo(bout)
      bout.toByteArray
    }

    {
      val file = new FileOutputStream("index-dev.html")
      file.write(index_html(accbytes).getBytes)
    }

    val config = ConfigFactory.defaultApplication
    implicit val system = ActorSystem("Backbols")

    val streamer = system actorOf Props[StdStreamer]
    streamer ! Stdout(config.toString)
    streamer ! Stdout(streamer.path)
    streamer ! Stdout("Hi ppl")
    streamer ! Stdout(s"deserialized account: ${Account.parseFrom(accbytes)}")

    val theEnd: Future[Unit] = {
      import ExecutionContext.Implicits.global
      system.terminate() map println
    }

    Await result (theEnd, 1 second)
  }

}
