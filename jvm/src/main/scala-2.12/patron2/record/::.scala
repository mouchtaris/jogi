package patron2.record

trait ::[+a, +b <: Record]

object :: {

  private[this] final object instance extends ::[Nothing, Nil]

  final implicit class ops[a, b <: Record](val self: a :: b) extends AnyVal {

    @inline def ::[x](x: x): x :: a :: b = instance.asInstanceOf[x :: a :: b]

  }

}