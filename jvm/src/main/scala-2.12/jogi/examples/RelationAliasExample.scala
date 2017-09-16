package jogi
package examples

import list._
import record._

object RelationAliasExample {

  //
  // Define some values
  //

  trait Meter extends Value.Long

  //
  // Define some entities
  //
  object Ant {
    trait Length extends Meter
  }
  trait Ant extends (Ant.Length :: Nil)

  object Cousin {
    trait Age extends Value.Long
  }
  trait Cousin extends (Cousin.Age :: Nil)

  //
  // Define a relaationship
  //

  trait Akin extends (Ant `1:n` Cousin)

  //
  // Specify Akin's aliases
  //

  object Akin {
    final implicit case object RelationAlias extends record.RelationAlias[Akin] {
      final implicit case object INSECT extends typelevel.StringLiteral { type Self = this.type }
      final implicit case object KAZN extends typelevel.StringLiteral { type Self = this.type }
      type NameA = INSECT.Self
      type NameB = KAZN.Self
    }
  }

  //
  // Print out aliases
  //

  def main(args: Array[String]): Unit = {

    val aliases = RelationAlias[Akin]
    val nameA = implicitly[aliases.NameA]
    val nameB = implicitly[aliases.NameB]

    println(s"Akin($nameA, $nameB)")
    // => Akin(INSECT, KAZN)

  }
}
