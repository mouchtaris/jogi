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

  trait Bytes extends Value[StdTypeAliases.Bytes]
  implicit case object Bytes extends Bytes

  trait Long extends Value[scala.Long]
  implicit case object Int extends Long

  trait Boolean extends Value[scala.Boolean]
  implicit case object Boolean extends Boolean

  trait Uri extends Value[akka.http.scaladsl.model.Uri]
  implicit case object Uri extends Uri

  trait Instant extends Value[java.time.Instant]
  implicit case object Instant extends Instant

  trait Set[t] extends Value[Predef.Set[t]]
  object Set {
    private[this] final case object Instance extends Set[Nothing]
    implicit def setFor[t]: Set[t] =
      Instance.asInstanceOf[Set[t]]
  }

  @inline implicit def singleFieldValue[t: Value]: Value[t :: Nil] =
    Value()

}
