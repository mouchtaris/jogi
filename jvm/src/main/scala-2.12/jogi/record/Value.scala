package jogi
package record

trait Value[scalaType] {
  companion ⇒

  final type ScalaType = scalaType

  trait T extends ValueType[ScalaType] {
    final val name: String = companion.toString
  }

  final implicit case object Instance extends T
}

object Value {

  case object String extends Value[Predef.String]
  final type String = String.T

  case object Bytes extends Value[StdTypeAliases.Bytes]
  final type Bytes = Bytes.T

  case object Long extends Value[scala.Long]
  final type Long = Long.T

  case object Boolean extends Value[scala.Boolean]
  final type Boolean = Boolean.T

  case object Uri extends Value[akka.http.scaladsl.model.Uri]
  final type Uri = Uri.T

  case object Instant extends Value[java.time.Instant]
  final type Instant = Instant.T

}
