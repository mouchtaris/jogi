package patron2.record

trait ConsOps[a, b <: Record] extends Any {

  @inline final def ::[x](x: x): x :: a :: b = Cons()

}
