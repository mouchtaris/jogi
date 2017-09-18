package jogi
package testor
package model

import list.{ ::, Nil }
import record.{ value, Entity, rel, key }

object Collection {
  trait Name extends value.String
  trait Title extends value.String
  trait Subtitle extends value.String
}

// format: OFF
trait Collection extends Entity[
  Collection.Name with key.Primary ::
    Collection.Title ::
    Collection.Subtitle ::
    rel.has_many[User] ::
    rel.has_many[MediaItem] ::
    rel.has_many[Service] ::
    Nil]
