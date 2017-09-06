package patron2.record

import patron2.typelevel.Known

trait ListMap[f[_], r <: Record] extends Any {
  type Out <: Record
}

object ListMap {

  private[this] final object Instance extends ListMap[Known, Nil] {
    type Out = Known[Nil]
  }

  type Aux[f[_], r <: Record, out <: Record] = ListMap[f, r] {
    type Out = out
  }

  @inline def apply[f[_], r <: Record, a <: Record](): ListMap.Aux[f, r, a] =
    Instance.asInstanceOf[ListMap.Aux[f, r, a]]

  @inline implicit def nilListMap[f[_], h]: ListMap.Aux[f, h :: Nil, f[h] :: Nil] =
    ListMap()

  @inline implicit def listListMap[f[_], h, t <: Record](implicit tmap: ListMap[f, t]): ListMap.Aux[f, h :: t, f[h] :: tmap.Out] =
    ListMap()

  object Applier

  final class Applier[f[_]](val app: Applier.type) extends AnyVal {
    @inline def apply[r <: Record, out <: Record](r: r)(implicit map: Aux[f, r, out]): Aux[f, r, out] =
      map
  }

  @inline def apply[f[_]]: Applier[f] =
    new Applier(Applier)

  @inline def apply[f[_], r <: Record, out <: Record](implicit map: Aux[f, r, out]): Aux[f, r, out] =
    map

}