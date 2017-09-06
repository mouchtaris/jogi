package patron2.typelevel

trait Or[+a, +b] extends Any

object Or extends OrInferences {

  private[this] final case object Instance extends Or[Nothing, Nothing]

  @inline def apply[a, b](): Or[a, b] =
    Instance.asInstanceOf[Or[a, b]]

  @inline def apply[a, b](implicit or: Or[a, b]): Or[a, b] =
    or

}