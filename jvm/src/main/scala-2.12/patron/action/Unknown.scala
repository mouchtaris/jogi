package patron.action

import akka.http.scaladsl.model.Uri
import patron.{Action, ActionDescription}

final case class Unknown(
  uri: Uri
) extends Action

case object Unknown {

  implicit def description: ActionDescription[Unknown] =
    new ActionDescription[Unknown] {
      override def details(event: Unknown): String = {
        import shapeless._
        val genUnknown = Generic[Unknown]
        val list = genUnknown.to(event)
        list match {
          case uri :: HNil ⇒ uri.toString
        }
      }
      override val name: String = Unknown.toString
      val repr: Repr = 'uri → (_.uri.toString)
      type Repr = (Symbol, (Unknown ⇒ String))
    }

}