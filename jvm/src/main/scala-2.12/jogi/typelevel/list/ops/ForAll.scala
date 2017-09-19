package jogi
package typelevel
package list
package ops

trait ForAll[r <: List, pred[_]]

object ForAll {

  private[this]type NoFun[a] = Nothing

  private[this] final object Instance extends ForAll[Nil, NoFun]

  @inline def apply[r <: List, pred[_]](): ForAll[r, pred] =
    Instance.asInstanceOf[ForAll[r, pred]]

  @inline implicit def listForAll[r <: List, pred[_], mapOut <: List, foldOut](
    implicit
    listMap:  ListMap.Aux[pred, r, mapOut],
    listFold: ListFold.Aux[And, mapOut, foldOut],
    proof:    foldOut
  ): ForAll[r, pred] =
    ForAll()

}