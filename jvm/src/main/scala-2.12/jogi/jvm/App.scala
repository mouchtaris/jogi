package jogi
package jvm
import java.io.FileOutputStream
import scala.concurrent.{duration, Await, ExecutionContext, Future}, duration._
import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.typesafe.config.{Config, ConfigFactory}
import io.grpc.ServerBuilder
import incubate._

object App {

  final case class Complete(a: a forSome {type a})

  final class Completer extends Actor {
    def receive: Receive = {
      case Complete(a) ⇒ sender() ! a
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
    import jogi.proto.Account
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

    object joga extends jogi.proto.JogaGrpc.Joga {
      val completer = system actorOf Props[Completer]
      import akka.pattern.ask
      implicit val timeout: akka.util.Timeout = 5 seconds
      import ExecutionContext.Implicits.global
      override def addAccount(request: Account): Future[Account] =
        completer ask Complete(request) map {
          case acc: Account ⇒ acc
        }
    }

    val service = jogi.proto.JogaGrpc.bindService(joga, ExecutionContext.global)
    val server = ServerBuilder.forPort(19000)
      .addService(service)
      .build()
      .start()

    val streamer = system actorOf Props[StdStreamer]
    streamer ! StdOut(config.toString)
    streamer ! StdOut(streamer.path)
    streamer ! StdOut("Hi ppl")
    streamer ! StdOut(s"deserialized account: ${Account.parseFrom(accbytes)}")

    val theEnd: Future[Unit] = {
      import ExecutionContext.Implicits.global
      system.terminate() map println
    }

    Await result (theEnd, 1 second)
  }

}
