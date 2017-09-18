package jogi.record

trait StandardValues {

  trait String extends Value[Predef.String] with StandardValue
  trait Bytes extends Value[StdTypeAliases.Bytes] with StandardValue
  trait Long extends Value[scala.Long] with StandardValue
  trait Boolean extends Value[scala.Boolean] with StandardValue
  trait Uri extends Value[akka.http.scaladsl.model.Uri] with StandardValue
  trait Instant extends Value[java.time.Instant] with StandardValue

}
