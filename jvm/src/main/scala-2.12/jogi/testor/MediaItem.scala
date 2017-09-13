package jogi
package testor

import list.{ ::, Nil }
import record.{ Enum, Value }

object MediaItem {
  trait Uri extends Value.Uri
  trait Title extends Value.String
  trait Description extends Value.String

  sealed trait Type extends Enum
  object Type {
    trait Image extends Type
    trait Video extends Type
    trait Audio extends Type
  }
}

// format: OFF
trait MediaItem extends (
  MediaItem.Uri ::
    MediaItem.Title ::
    MediaItem.Type ::
    MediaItem.Description ::
    Nil)