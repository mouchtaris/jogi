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

  /**
   * Private instance, which is reused, since this is
   * a type-level trait.
   */
  private[this] object Instance extends Value[Nothing]

  /**
   * An object creator.
   *
   * This is used only to create implicit evidence instances.
   *
   * @tparam st underlying scala type
   * @return a instance of Value[st]
   */
  @inline def apply[st](): Value[st] =
    Instance.asInstanceOf[Value[st]]

}