package jogi.list

trait ConsOps[a, b <: List] extends Any {

  @inline final def ::[x](x: x): x :: a :: b = Cons()

}
