package jogi.jvm

import akka.actor.{ ActorSystem, Actor, ActorRef, Props }
import scala.concurrent.{ Future, ExecutionContext, Await, duration }, duration._
import scala.language.{ postfixOps }
import com.typesafe.config.{ Config, ConfigFactory }

object App {

  final case class Stdout(any: Any)

  final class StdStreamer extends Actor {
    def receive: Receive = {
      case Stdout(any) ⇒ println(any)
    }
  }

  def main(args: Array[String]): Unit = {
    val config = ConfigFactory.defaultApplication
    implicit val system = ActorSystem("Backbols")

    val streamer = system actorOf Props[StdStreamer]
    streamer ! Stdout(config.toString)
    streamer ! Stdout(streamer.path)
    streamer ! Stdout("Hi ppl")

    val theEnd: Future[Unit] = {
      import ExecutionContext.Implicits.global
      system.terminate() map println
    }

    Await result (theEnd, 1 second)
  }

}
