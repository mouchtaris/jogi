package patron2.record

trait Cons[+a, +b <: Record] extends Any

object Cons {

  private[this] final object instance extends Cons[Nothing, Nil]

  final implicit class ops[a, b <: Record](val self: a :: b) extends AnyVal {

    @inline def ::[x](x: x): x :: a :: b = instance.asInstanceOf[x :: a :: b]

  }

}