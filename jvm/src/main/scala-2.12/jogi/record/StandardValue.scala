package jogi.record

/**
 * Just a marker trait.
 */
trait StandardValue[scalaType] extends Value[scalaType]

object StandardValue {

  private[this] object Instance extends StandardValue[Nothing]

  @inline def apply[st](): StandardValue[st] =
    Instance.asInstanceOf[StandardValue[st]]
}