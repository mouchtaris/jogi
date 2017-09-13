package jogi
package typelevel

object Pigs {

  import pig.Pig

  trait PackageExtension {

    @inline implicit def andPig[a: Pig, b: Pig]: Pig[And[a, b]] =
      Pig(s"${Pig[a]} AND ${Pig[b]}")

  }

}