package patron2.typelevel

trait And[+a, +b]

object And {

  private[this] final case object Instance extends And[Nothing, Nothing]

  @inline def apply[a, b](): And[a, b] =
    Instance.asInstanceOf[And[a, b]]

  @inline def apply[a, b](implicit and: And[a, b]): And[a, b] =
    and

  @inline implicit def and[a, b](implicit a: a, b: b): And[a, b] =
    And()

}