package jogi
package list

trait Cons[+a, +b <: Record] extends Any

object Cons {

  private[this] final object instance extends Cons[Nothing, Nil]

  @inline protected[list] def apply[a, b <: Record](): Cons[a, b] =
    instance.asInstanceOf[Cons[a, b]]

  final implicit class Ops[a, b <: Record](val self: a :: b)
    extends AnyVal
    with ConsOps[a, b]

}