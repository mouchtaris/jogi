package patron2.record

import patron2.typelevel.Or

trait ForAny[r <: Record, pred[_]] extends Any

object ForAny {

  private[this]type NoFun[a] = Nothing

  private[this] final object Instance extends ForAny[Nil, NoFun]

  @inline def apply[r <: Record, pred[_]](): ForAny[r, pred] =
    Instance.asInstanceOf[ForAny[r, pred]]

  @inline implicit def listForAny[r <: Record, pred[_], mapOut <: Record](
    implicit
    listMap: ListMap.Aux[pred, r, mapOut],
    proof:   ListFold[Or, mapOut]
  ): ForAny[r, pred] =
    ForAny()

}
