package fun.lub

trait Lub[a, b] {
  type Out

  implicit val evidence1: a <:< Out
  implicit val evidence2: b <:< Out
}

object Lub {

  type aux[a, b, u] = Lub[a, b] { type Out = u }

  private[this] class impl[u, a <: u, b <: u] extends Lub[a, b] {
    type Out = u
    val evidence1: a <:< Out = implicitly
    val evidence2: b <:< Out = implicitly
  }

  implicit def apply[u, a <: u, b <: u]: Lub.aux[a, b, u] = new impl

  def apply[a, b](a: ⇒ a, b: ⇒ b)(implicit lub: Lub[a, b]): lub.type = lub

}
