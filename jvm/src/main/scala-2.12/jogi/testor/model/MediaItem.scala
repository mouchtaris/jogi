package jogi
package testor
package model

import list.{ ::, Nil }
import record.{ Enum, Value, Entity, rel, key }

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
trait MediaItem extends Entity[
  MediaItem.Uri with key.Primary ::
    MediaItem.Title ::
    MediaItem.Type ::
    MediaItem.Description ::
    rel.has_one[User] ::
    Nil]