package jogi.record

/**
 * A trait that contains the commonly used "standard" value aliases.
 *
 * It's uses through a package object that extends it.
 */
trait StandardValues {

  trait String extends StandardValue[Predef.String]
  implicit case object String extends String

  trait Bytes extends StandardValue[stdalias.Bytes]
  implicit case object Bytes extends Bytes

  trait Long extends StandardValue[scala.Long]
  implicit case object Long extends Long

  trait Boolean extends StandardValue[scala.Boolean]
  implicit case object Boolean extends Boolean

  trait Uri extends StandardValue[akka.http.scaladsl.model.Uri]
  implicit case object Uri extends Uri

  trait Instant extends StandardValue[java.time.Instant]
  implicit case object Instant extends Instant

}