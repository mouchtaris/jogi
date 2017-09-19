package jogi
package record

import typelevel.list.{ ::, Nil }

/**
 * An enum is a single "long" value.
 *
 * Values of this enum extend this train directly.
 */
trait Enum extends (value.Long :: Nil)