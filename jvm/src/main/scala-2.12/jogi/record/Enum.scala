package jogi
package record

import typelevel.list.{ ::, Nil }

trait Enum extends (value.Long :: Nil) {
  trait values
}