package jogi
package record

import list.{ ::, Nil }

trait Value[t]

object Value {

  private[this] final object Instance extends Value[Nothing]

  type of[t] = t :: Nil

  @inline def apply[t](): Value[t] =
    Instance.asInstanceOf[Value[t]]

  trait String extends Value[Predef.String]
  implicit case object String extends String

  trait Bytes extends Value[Bytes]
  implicit case object Bytes extends Bytes

  trait Long extends Value[scala.Long]
  implicit case object Int extends Long

  trait Boolean extends Value[scala.Boolean]
  implicit case object Boolean extends Boolean

  trait Uri extends Value[akka.http.scaladsl.model.Uri]
  implicit case object Uri extends Uri

  @inline implicit def singleFieldValue[t: Value]: Value[t :: Nil] =
    Value()

}
