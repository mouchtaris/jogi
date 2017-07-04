package jogi.js

import scala.language.{ postfixOps, implicitConversions }
import org.scalajs.dom, dom.document, dom.raw.Element
import akka.actor.{ Actor, ActorRef, ActorSystem, Props }
import com.typesafe.config.{ Config, ConfigFactory }
import jogi.proto.{ jogi ⇒ proto }

object App {

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

  val lol: String ⇒ Unit = {
    import jogi.model._
    (Email.apply _)
      .andThen(Account)
      .andThen(pre)
      .andThen(body ++ _.toElem)
  }

  class EventHandler extends Actor {
    def receive: Receive = {
      case any ⇒
        lol(any.toString)
    }
  }


  lazy val Config: Config = ConfigFactory parseString """
      |akka {
      | logLevel = "DEBUG"
      | stdout-loglevel = "DEBUG"
      |}
    """.stripMargin

  import scalajs.js, js.annotation._
  @js.native
  @JSGlobal("poo")
  object poo extends js.Object {
    def the_account: js.Array[Byte] = js.native
  }

  def main(args: Array[String]): Unit = {
    implicit val system: ActorSystem = ActorSystem("Bols", Config)
    val eventHandler: ActorRef = system actorOf Props[EventHandler]

    document.body.onclick = _ ⇒ eventHandler ! poo.the_account.toString

    val acc = proto.Account.parseFrom(poo.the_account.toArray)

    import system.dispatcher
    import scala.concurrent.duration._
    system.scheduler.scheduleOnce(0 millis) {
      println("Hello lol")
      eventHandler ! "ready to roll, baby"
      eventHandler ! Config.toString
      eventHandler ! s"dis is teh account: ${poo.the_account}"
      eventHandler ! s"and dis is deserialized: ${acc}"
    }
  }
}
