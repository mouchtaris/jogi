package patron2.typelevel

trait And[+a, +b]

object And {

  private[this] final case object instance extends And[Nothing, Nothing]

  def apply[a, b](): And[a, b] = instance.asInstanceOf[And[a, b]]

  def apply[a, b](implicit and: And[a, b]): and.type = and

  implicit def and[a: known, b: known]: And[a, b] = And()

}