package jogi.list.ops

import jogi.list._
import jogi.typelevel.And

trait ForAll[r <: Record, pred[_]]

object ForAll {

  private[this]type NoFun[a] = Nothing

  private[this] final object Instance extends ForAll[Nil, NoFun]

  @inline def apply[r <: Record, pred[_]](): ForAll[r, pred] =
    Instance.asInstanceOf[ForAll[r, pred]]

  @inline implicit def listForAll[r <: Record, pred[_], mapOut <: Record, foldOut](
    implicit
    listMap:  ListMap.Aux[pred, r, mapOut],
    listFold: ListFold.Aux[And, mapOut, foldOut],
    proof:    foldOut
  ): ForAll[r, pred] =
    ForAll()

}