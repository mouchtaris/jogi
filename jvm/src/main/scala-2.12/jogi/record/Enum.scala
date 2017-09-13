package jogi
package record

import list.{ ::, Nil }

trait Enum extends (Value.Long :: Nil) {
  trait values
}