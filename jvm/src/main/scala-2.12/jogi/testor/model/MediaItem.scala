package jogi
package testor
package model

import list.{ ::, Nil }
import record.{ Enum, Value, `1-n` }

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

  object relations {
    trait UserMediaItem extends (User `1-n` MediaItem)
  }
}

// format: OFF
trait MediaItem extends (
  MediaItem.Uri ::
    MediaItem.Title ::
    MediaItem.Type ::
    MediaItem.Description ::
    Nil)