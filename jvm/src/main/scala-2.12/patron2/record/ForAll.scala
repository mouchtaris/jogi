package patron2.record

import patron2.typelevel.And

trait ForAll[r <: Record, pred[_]] extends Any

object ForAll {

  private[this]type NoFun[a] = Nothing

  private[this] final object Instance extends ForAll[Nil, NoFun]

  @inline def apply[r <: Record, pred[_]](): ForAll[r, pred] =
    Instance.asInstanceOf[ForAll[r, pred]]

  @inline implicit def listForAll[r <: Record, pred[_], mapOut <: Record](
    implicit
    listMap: ListMap.Aux[pred, r, mapOut],
    proof:   ListFold[And, mapOut]
  ): ForAll[r, pred] =
    ForAll()

}