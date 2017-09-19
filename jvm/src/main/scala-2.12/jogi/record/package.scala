package jogi

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
  object stdalias extends StdTypeAliases
  object rel extends Relation
  object key extends Key
  object value extends StandardValues
}
