package jogi
package record

/**
 * A value is a value alias. Something like a value class wrapper,
 * but in a type-detectable way.
 *
 * @tparam scalaType the underlying scala type.
 */
trait Value[scalaType] {
  final type ScalaType = scalaType
}

object Value {

  private[this] object Instance extends Value[Nothing]

  @inline def apply[st](): Value[st] =
    Instance.asInstanceOf[Value[st]]

}