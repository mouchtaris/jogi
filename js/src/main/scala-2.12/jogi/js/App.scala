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
import scala.scalajs.js.typedarray
import js.annotation._
import js.JSConverters._
import scala.scalajs.js.typedarray.Uint8Array

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


  implicit def blobToByteArray(blob: Blob)(
      implicit
      ec: ExecutionContext
  ): Future[Array[Byte]] = {
    val reader = new dom.FileReader
    reader.readAsArrayBuffer(blob)
    toReadyFuture(reader)(_.onloadend = _)
      .map { _.result.asInstanceOf[typedarray.ArrayBuffer] }
      .map { new Uint8Array(_).toArray.map(_.toByte) }
  }

  implicit def bytesToBlob(bytes: Array[Byte]): Blob =
    new Blob(js.Array(new Uint8Array(bytes.toJSArray)))

  final implicit class CastToDeco[t](val self: t) extends AnyVal {
    def castTo[u](implicit ev: t ⇒ u): u = self
  }

  trait Inspect[t] {
    def apply(self: t): String
  }
  final implicit class InspectDeco[t](val self: t) extends AnyVal {
    def inspect(implicit i: Inspect[t]): String = i(self)
  }

  final implicit object InspectByteArray extends Inspect[Array[Byte]] {
    def apply(arr: Array[Byte]): String =
      java.util.Arrays.toString(arr)
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
  import system.dispatcher

  val asap: ExecutionContext = new ExecutionContext {
    def execute(runnable: Runnable): Unit = runnable.run()
    def reportFailure(cause: Throwable): Unit = cause.printStackTrace()
  }
  val acc = proto.Account.parseFrom(poo.the_account.toArray)
  val accbytes = acc.toByteArray
  val accblob = accbytes.castTo[Blob]
  val accblobinspect: Future[String] =
    accblob.castTo[Future[Array[Byte]]].map(_.inspect)(asap)

  val wsaddr = "ws://localhost:19000/ws"

  def toReadyFuture[o](obj: o)(set: (o, Any ⇒ Unit) => Unit): Future[o] = {
    val p = Promise[o]()
    set(obj, { _ ⇒ p.success(obj) })
    p.future
  }

  def makews: Future[dom.WebSocket] = {
    val ws = new dom.WebSocket(wsaddr)

    ws.onerror = ev ⇒ println(s"error: $ev")

    ws.onclose = ev ⇒ println(s"close: $ev")

    ws.onmessage = ev ⇒ {
      println(s"message $ev")
      ev.data.asInstanceOf[dom.Blob]
        .castTo[Future[Array[Byte]]]
        .zip(accblobinspect)
        .map { case (bytes, accblobinspectreal) ⇒
          //        val acc2 = Account.parseFrom(bytes)
          eventHandler !
            Saying(s"a ${bytes.inspect} vs\nb ${accblobinspectreal} vs\nc ${accbytes.inspect}")
          eventHandler ! Saying(s"$acc")
            eventHandler ! Saying(s"${Account.parseFrom(accbytes)}")
            eventHandler ! Saying(s"${Account.parseFrom(bytes)}")
        }
    }

    toReadyFuture(ws)(_.onopen = _)
  }

  object ws {
    private[this] var w: Future[dom.WebSocket] = makews
    implicit def getWS(_ws: ws.type): Future[dom.WebSocket] =
      w.flatMap(_w ⇒ { w = _w.refresh; w})(asap)
  }

  final implicit class RefreshingWs(val self: dom.WebSocket) extends AnyVal {
    def refresh: Future[dom.WebSocket] =
      if (self.readyState == dom.WebSocket.CLOSED || self.readyState == dom.WebSocket.CLOSING)
        makews
      else
        Future successful self
  }

  def setupBody(): Unit = {
    document.body.onclick = _ ⇒
      ws
        .flatMap(_.refresh)
        .map(_.send(accblob))
        .recover { case ex ⇒ eventHandler ! Saying(ex.toString) }
  }
}

object App {
  import utilground.{ Config, _ }
  import utilground.system.dispatcher

  def main(args: Array[String]): Unit = {
    setupBody()
//    val channel = ManagedChannelBuilder.forAddress("localhost", 18000).build()
//    val stub = JogaGrpc.stub(channel)
//    val futureAccountReply = stub.addAccount(acc)
    system.scheduler.scheduleOnce(0 millis) {
      println("Hello lol")
      eventHandler ! Saying("ready to roll, baby")
      eventHandler ! Saying(Config.toString)
      eventHandler ! Saying(s"dis is teh account: ${poo.the_account}")
      eventHandler ! Saying(s"and dis is deserialized: ${acc.toString.inspect}")
//      Await.result(
//        futureAccountReply
//          .map { acc2 ⇒ eventHandler ! s"account reply: ${acc2.toString.inspect}" },
//        10 seconds
//      )
    }
  }
}
