package jogi.record

/**
 * Scala-level Aliases for "standard" types.
 *
 * They are used through a package object extending this
 * trait.
 */
trait StdTypeAliases {

  /**
   * Bytes is an array of bytes, as is most commonly used in
   * the java standard library and most popular JVM libraries.
   */
  type Bytes = Array[Byte]

}