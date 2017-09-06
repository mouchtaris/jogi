package patron2.typelevel

trait Or[+a, +b]

object Or extends Ors {

  private[this] final case object instance extends Or[Nothing, Nothing]

  def apply[a, b](): Or[a, b] = instance.asInstanceOf[Or[a, b]]

  def apply[a, b](implicit or: Or[a, b]): or.type = or

}