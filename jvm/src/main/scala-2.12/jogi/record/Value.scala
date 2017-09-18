package jogi
package record

/**
 * A value is a value alias. Something like a value class wrapper,
 * but in a type-detectable way.
 *
 * @tparam scalaType the underlying scala type.
 */
trait Value[scalaType] {
  final type ScalaType = scalaType
}