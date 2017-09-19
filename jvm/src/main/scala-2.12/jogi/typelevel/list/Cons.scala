package jogi
package typelevel
package list

trait Cons[+a, +b <: List] extends Any

object Cons {

  private[this] final object instance extends Cons[Nothing, Nil]

  @inline protected[list] def apply[a, b <: List](): Cons[a, b] =
    instance.asInstanceOf[Cons[a, b]]

}