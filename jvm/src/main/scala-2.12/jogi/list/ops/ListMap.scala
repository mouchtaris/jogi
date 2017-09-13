package jogi.list.ops

import jogi.list.{ ::, Nil, Record }

trait ListMap[f[_], r <: Record] {
  type Out <: Record
}

object ListMap {

  private[this]type NoFun[t] = Nothing

  private[this] final object Instance extends ListMap[Nothing, Nil] {
    type Out = Nil
  }

  type Aux[f[_], r <: Record, out <: Record] = ListMap[f, r] {
    type Out = out
  }

  @inline def apply[f[_], r <: Record, a <: Record](): ListMap.Aux[f, r, a] =
    Instance.asInstanceOf[ListMap.Aux[f, r, a]]

  @inline def apply[f[_], r <: Record](implicit lmap: ListMap[f, r]): lmap.type =
    lmap

  @inline implicit def nilListMap[f[_], h]: ListMap.Aux[f, h :: Nil, f[h] :: Nil] =
    ListMap()

  @inline implicit def listListMap[f[_], h, t <: Record](implicit tmap: ListMap[f, t]): ListMap.Aux[f, h :: t, f[h] :: tmap.Out] =
    ListMap()

  object Applier

  final class Applier[f[_]](val app: Applier.type) extends AnyVal {
    @inline def apply[r <: Record, out <: Record](r: r)(implicit map: Aux[f, r, out]): ListMap.Aux[f, r, out] =
      map
  }

  @inline def apply[f[_]]: Applier[f] =
    new Applier(Applier)

}