package jogi.typelevel

trait Lub[a, b] {
  type Out
}

object Lub {

  private[this] final object Instance extends Lub[Nothing, Nothing] {
    type Out = Nothing
  }

  type Aux[a, b, u] = Lub[a, b] {
    type Out = u
  }

  @inline def apply[a, b, u](): Lub.Aux[a, b, u] =
    Instance.asInstanceOf[Lub.Aux[a, b, u]]

  @inline implicit def forTypes[a >: la, b >: lb, la <: u, lb <: u, u]: Lub.Aux[a, b, u] =
    Lub()

}