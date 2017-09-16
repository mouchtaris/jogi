package jogi

import list.List

/**
 * A record is a list of types.
 *
 * {{{
 *   // Values are immutable values.
 *   //
 *   // Values have always an implicit Value[_] instance.
 *   //
 *   object Value {
 *     trait String extends Value[Predef.String]
 *   }
 *
 *   // Single-type records are also values
 *   //
 *   implicitly[Value[Value.String :: Nil]]
 *
 *   // Using new traits for values allows them to be uniquely
 *   // typed per usage-space.
 *   //
 *   app =>
 *   trait email extends Value.String
 *   object ant { trait email extends app.email }
 *   object moth { trait email extends app.email }
 *   //
 *   // cannot mix ant and moth emails
 *   //
 *   type ant = ant.email :: Nil
 *   type moth = moth.email :: Nil
 *
 *   // Enums are single-valued Long values.
 *   //
 *   trait Enum extends (Value.Long :: Nil)
 *   //
 *   // To create a new enaum type, extend Enum and add values in the
 *   // companion object
 *   trait Finger extends Enum
 *   object Finger {
 *     trait Present extends Finger
 *     trait Lost extends Finger
 *   }
 *   type Hand = Finger :: Nil
 * }}}
 */
package object record {

  type `1:1`[a <: List, b <: List] = Rel1To1[a, b]
  type `1:n`[a <: List, b <: List] = Rel1ToN[a, b]
  type `n:n`[a <: List, b <: List] = RelNToN[a, b]

  type has_one[a <: List, b <: List] = a `1:1` b
  type has_many[a <: List, b <: List] = a `1:n` b
  type has_and_belongs_to_many[a <: List, b <: List] = a `n:n` b

  trait EntityType[record <: List] {
    final type Record = record
    val name: String
  }

  trait Entity[record <: List] {
    companion ⇒

    trait T extends EntityType[record] {
      final val name: String = companion.toString
    }

    final implicit case object Instance extends T
  }

  object rel {
    trait has_one[e <: Entity[r] forSome { type r <: List }]
    trait has_many[e <: Entity[r] forSome { type r <: List }]

    trait as[alias <: typelevel.StringLiteral]
  }
}
