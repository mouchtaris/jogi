package jogi
package typelevel
package list
package ops

trait Lub[r <: List] extends Any {
  type Out
}

object Lub {

  type Aux[r <: List, u] = Lub[r] { type Out = u }
  type Of[r <: List] = { type is[u] = Aux[r, u] }

  private[this] final object Instance extends Lub[Nil] {
    type Out = Nothing
  }

  @inline def apply[r <: List, u](): Lub.Aux[r, u] =
    Instance.asInstanceOf[Lub.Aux[r, u]]

  @inline implicit def nilLub[h]: Lub.Aux[h :: Nil, h] =
    Lub()

  implicit def listLub[h, t <: List, tu: Lub.Of[t]#is](implicit hlub: typelevel.Lub[h, tu]): Lub.Aux[h :: t, hlub.Out] =
    Lub()

}