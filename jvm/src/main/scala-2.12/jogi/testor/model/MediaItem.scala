package jogi
package testor
package model

import typelevel.list.{ ::, Nil }
import record.{ Enum, value, Entity, rel, key }

object MediaItem {
  trait Uri extends value.Uri
  trait Title extends value.String
  trait Description extends value.String

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