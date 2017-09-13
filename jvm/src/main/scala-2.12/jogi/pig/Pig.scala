package jogi.pig

class Pig[t](
    val desc: String
) {

  final type T = t

  final override def toString: String =
    desc

}

object Pig {

  @inline def apply[t](implicit pig: Pig[t]): pig.type =
    pig

  @inline def apply[t](desc: String): Pig[t] =
    new Pig(desc)

  @inline def of[t: Pig](t: t): Pig[t] =
    Pig[t]

  implicit val shortPig: Pig[Short] = Pig("Short")
  implicit val intPig: Pig[Int] = Pig("Int")
  implicit val longPig: Pig[Long] = Pig("Long")
  implicit val stringPig: Pig[String] = Pig("String")
  implicit val floatPig: Pig[Float] = Pig("Float")
  implicit val doublePig: Pig[Double] = Pig("Double")
  //    implicit val charPig: Pig[Char] = Pig("Char")
  //    implicit val nothingPig: Pig[Nothing] = Pig("Nothing")
  implicit val unitPig: Pig[Unit] = Pig("Unit")

  @inline implicit def vectorPig[vectorT: Pig]: Pig[Vector[vectorT]] =
    Pig(s"Vector[${Pig[vectorT]}]")

}