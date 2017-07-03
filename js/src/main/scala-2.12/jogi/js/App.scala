package jogi.js

import scala.language.{ postfixOps }

import org.scalajs.dom.document
import org.scalajs.dom

object App {

  final case class p(text: String)
  implicit val `toElem[p]`: toElem[p] = {
    case p(text) ⇒ {
      val el = document createElement "p"
      val eltext = document createTextNode text
      el appendChild eltext
      el
    }
  }

  trait toElem[a] {
    def apply(a: a): dom.raw.Element
  }
  final implicit class toElemDeco[a](val self: a) extends AnyVal {
    def toElem(implicit i: toElem[a]): dom.raw.Element = i(self)
  }

  val lol: Any ⇒ Unit = _ ⇒ {
    import jogi.model._
    document.body appendChild p(Account(Email("lol@com.com")).toString).toElem
  }


  def main(args: Array[String]): Unit = {
    println("Hello lol")

    document.body.appendChild(p("hi").toElem)
    document.body.onclick = lol
  }
}
