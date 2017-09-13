package jogi
package list

object Pigs {

  import pig.Pig
  import ops._

  trait PackageExtension {

    implicit val nilPig: Pig[Nil] = Pig("Nil")

    @inline implicit def recordPig[h: Pig, t <: Record: Pig]: Pig[h :: t] =
      Pig(s"${Pig[h]} :: ${Pig[t]}")

    @inline implicit def containsPig[a: Pig, s <: Record: Pig]: Pig[Contains[s, a]] =
      Pig(s"(${Pig[a]} in ${Pig[s]})")

  }

}
