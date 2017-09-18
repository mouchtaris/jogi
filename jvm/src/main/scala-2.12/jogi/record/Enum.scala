package jogi
package record

import list.{ ::, Nil }

trait Enum extends (value.Long :: Nil) {
  trait values
}