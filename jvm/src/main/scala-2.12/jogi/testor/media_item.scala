package jogi
package testor

import list.{ ::, Nil }
import record.{ Enum, Value }

object media_item {
  trait uri extends Value.Uri
  trait title extends Value.String
  trait description extends Value.String

  sealed trait `type` extends Enum
  object `type` {
    trait image extends `type`
    trait video extends `type`
    trait audio extends `type`
  }
}

trait media_item extends (media_item.uri :: media_item.title :: media_item.`type` :: media_item.description :: Nil)