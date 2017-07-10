package jogi.js

import scala.language.{implicitConversions, postfixOps}
import org.scalajs.dom
import dom.document
import dom.raw.Element
import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.typesafe.config.{Config, ConfigFactory}
import io.grpc.ManagedChannelBuilder
import jogi.proto
import proto.Account
import org.scalajs.dom.raw.Blob
import scala.concurrent.duration._
import scala.collection.mutable.ArrayBuffer
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.Promise
import scala.util.Success
import scala.util.Failure
import scalajs.js
import scala.scalajs.js.typedarray
import js.annotation._
import js.JSConverters._

object utilground {
  final case class pre(text: Any)

  implicit val `toElem[p]`: toElem[pre] = {
    case pre(text) ⇒ {
      val el: Element = document createElement "pre"
      val eltext: dom.raw.Text = document createTextNode text.toString
      el appendChild eltext
      el
    }
  }

  trait toElem[a] {
    def apply(a: a): dom.raw.Element
  }
  object toElem {
    implicit def apply[a: toElem](a: a): Element =
      implicitly[toElem[a]].apply(a)
  }

  final implicit class toElemDeco[a](val self: a) extends AnyVal {
    def toElem(implicit i: toElem[a]): dom.raw.Element = i(self)
  }

  final implicit class ApplyTo[a](val self: a) extends AnyVal {
    def applyTo[b](f: a ⇒ b): () ⇒ b = () ⇒ f(self)
  }


  object body {
    def ++(el: Element): Unit =
      document.body appendChild el
  }

  val say: String ⇒ Unit =
    body ++ pre(_).toElem

  final case class Saying(msg: String)
  final case class WsMessage(data: Array[Byte])

  class EventHandler extends Actor {
    def receive: Receive = {
      case Saying(saying) ⇒
        say(saying)
      case WsMessage(data) ⇒
        val acc = jogi.proto.Account.parseFrom(data)
        self ! Saying(acc.toString)
    }
  }

  lazy val Config: Config = ConfigFactory parseString """
      |akka {
      | logLevel = "DEBUG"
      | stdout-loglevel = "DEBUG"
      |}
    """.stripMargin

  @js.native
  @JSGlobal("poo")
  object poo extends js.Object {
    def the_account: js.Array[Byte] = js.native
  }

  implicit class stringpimp(val self: String) extends AnyVal {
    def inspect: String = self
          .replaceAll("\\n", "\\\\n")
  }

  implicit val system: ActorSystem = ActorSystem("Bols", Config)
  val eventHandler: ActorRef = system actorOf Props[EventHandler]
  val wsopen: Promise[Unit] = Promise()
  import system.dispatcher

  val acc = proto.Account.parseFrom(poo.the_account.toArray)
  val accbytes = acc.toByteArray
  val accblob = new Blob(accbytes.toJSArray.map(_.asInstanceOf[js.Any]))

  val wsaddr = "ws://localhost:19000/ws"
  val ws = {
    val ws = new dom.WebSocket(wsaddr)

    ws.onerror = ev ⇒ println(s"error: $ev")

    ws.onclose = ev ⇒ println(s"close: $ev")

    ws.onmessage = ev ⇒ eventHandler !
      Saying(ev.data.asInstanceOf[dom.Blob].toString)

    ws.onopen = ev ⇒ {
      println(s"open: $ev")
      wsopen.success(())
    }
    
    ws
  }

  def setupBody(): Unit = {
    document.body.onclick = _ ⇒
      wsopen.future.onComplete {
        case Success(_) ⇒ ws.send(accblob)
        case Failure(ex) ⇒ eventHandler ! ex
      }
  }
}

object App {
  import utilground.{ Config, _ }
  import utilground.system.dispatcher

  def main(args: Array[String]): Unit = {
//    val channel = ManagedChannelBuilder.forAddress("localhost", 18000).build()
//    val stub = JogaGrpc.stub(channel)
//    val futureAccountReply = stub.addAccount(acc)
    system.scheduler.scheduleOnce(0 millis) {
      println("Hello lol")
      eventHandler ! "ready to roll, baby"
      eventHandler ! Config.toString
      eventHandler ! s"dis is teh account: ${poo.the_account}"
      eventHandler ! s"and dis is deserialized: ${acc.toString.inspect}"
//      Await.result(
//        futureAccountReply
//          .map { acc2 ⇒ eventHandler ! s"account reply: ${acc2.toString.inspect}" },
//        10 seconds
//      )
    }
  }
}
