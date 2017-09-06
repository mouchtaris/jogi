package fun
package list
package ops

import scala.collection.generic.CanBuildFrom

trait ToCol[l <: List, col[_]] {
  type Out
  def apply(l: l): col[Out]
}

object ToCol {

  type aux[l <: List, col[_], out] = ToCol[l, col] { type Out = out }

  implicit def forNil[t, col[_]](implicit cbf: CanBuildFrom[Nothing, Nothing, col[t]]): aux[nil, col, t] =
    new ToCol[nil, col] {
      type Out = t
      def apply(nil: nil): col[t] = cbf().result
    }

//  class ForList0(val self: Int) extends AnyVal

  implicit def forList[h, t <: List, col[_]](implicit tailToCol: ToCol[t, col]) = ???

//  implicit class ops[l <: List](val self: l) extends AnyVal {
//    def to[col[_]](implicit tocol: ToCol[l, col]): col[tocol.Out] = tocol(self)
//  }
  class why(val self: Int) extends AnyVal

}
//
//object wat {
//
//}