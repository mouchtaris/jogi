package jogi.list.ops

import jogi.list.{ ::, Nil, Record }
import jogi.typelevel

trait Lub[r <: Record] extends Any {
  type Out
}

object Lub {

  type Aux[r <: Record, u] = Lub[r] { type Out = u }
  type Of[r <: Record] = { type is[u] = Aux[r, u] }

  private[this] final object Instance extends Lub[Nil] {
    type Out = Nothing
  }

  @inline def apply[r <: Record, u](): Lub.Aux[r, u] =
    Instance.asInstanceOf[Lub.Aux[r, u]]

  @inline implicit def nilLub[h]: Lub.Aux[h :: Nil, h] =
    Lub()

  implicit def listLub[h, t <: Record, tu: Lub.Of[t]#is](implicit hlub: typelevel.Lub[h, tu]): Lub.Aux[h :: t, hlub.Out] =
    Lub()

}