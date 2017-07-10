package jogi
package jvm
import java.io.FileOutputStream

import akka.NotUsed
import akka.Done

import scala.concurrent.{duration, Await, ExecutionContext, Future}
import duration._
import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.typesafe.config.{Config, ConfigFactory}
import io.grpc.ServerBuilder
import incubate._
import akka.http.scaladsl.{model, server, Http}
import server._
import Directives._
import model.ws.{BinaryMessage, Message}
import akka.stream.{scaladsl, ActorMaterializer}
import scaladsl.{Flow, Keep, Sink, Source}
import akka.util.ByteString

import scala.concurrent.Promise

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
    implicit val materializer = ActorMaterializer()

    val messageHandler: Message ⇒ Source[Message, NotUsed] =
      _.asBinaryMessage.asScala.dataStream
      .fold(ByteString())(_ ++ _)
      .map(BinaryMessage.apply)
      .mapMaterializedValue(_ ⇒ NotUsed)

    val wsHandler: Flow[Message, Message, _] = Flow[Message]
      .flatMapConcat(messageHandler)

    val promiseOfGoodbye: Promise[Done] = Promise()

    val route: Route =
      (get & path("ws")) { handleWebSocketMessages(wsHandler) } ~
        (delete & path("ws")) { promiseOfGoodbye.success(Done); complete("ok'") }

    val serverBinding = Http().bindAndHandle(route, interface = "0.0.0.0", port = 19000)

    val streamer = system actorOf Props[StdStreamer]
    streamer ! StdOut(config.toString)
    streamer ! StdOut(streamer.path)
    streamer ! StdOut("Hi ppl")
    streamer ! StdOut(s"deserialized account: ${Account.parseFrom(accbytes)}")

    val theEnd: Future[Unit] = {
      import ExecutionContext.Implicits.global
      promiseOfGoodbye.future
        .flatMap(_ ⇒ serverBinding)
        .map(_.unbind())
        .map(_ ⇒ system)
        .flatMap(_.terminate())
        .map(println)
    }

    Await result (theEnd, Duration.Inf)
  }

}
