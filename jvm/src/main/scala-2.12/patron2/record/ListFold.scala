package patron2.record

trait ListFold[f[_, _], r <: Record] {
  type Out
}

object ListFold {

  private[this]type NoFun[a, b] = Unit

  private[this] final object Instance extends ListFold[NoFun, Nil]

  type Aux[f[_, _], r <: Record, out] = ListFold[f, r] {
    type Out = out
  }

  @inline def apply[f[_, _], r <: Record, out](): Aux[f, r, out] =
    Instance.asInstanceOf[Aux[f, r, out]]

  @inline implicit def nilFold[f[_, _], a, b]: Aux[f, a :: b :: Nil, f[a, b]] =
    apply()

  @inline implicit def listFold[f[_, _], h, t <: Record](implicit tfold: ListFold[f, t]): Aux[f, h :: t, f[h, tfold.Out]] =
    apply()

  @inline def apply[f[_, _], r <: Record](implicit fold: ListFold[f, r]): fold.type =
    fold

}