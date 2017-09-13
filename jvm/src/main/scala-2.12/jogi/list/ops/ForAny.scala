package jogi.list.ops

import jogi.list._
import jogi.typelevel.Or

trait ForAny[r <: List, pred[_]] extends Any

object ForAny {

  private[this]type NoFun[a] = Nothing

  private[this] final object Instance extends ForAny[Nil, NoFun]

  @inline def apply[r <: List, pred[_]](): ForAny[r, pred] =
    Instance.asInstanceOf[ForAny[r, pred]]

  @inline implicit def listForAny[r <: List, pred[_], mapOut <: List](
    implicit
    listMap: ListMap.Aux[pred, r, mapOut],
    proof:   ListFold[Or, mapOut]
  ): ForAny[r, pred] =
    ForAny()

}
