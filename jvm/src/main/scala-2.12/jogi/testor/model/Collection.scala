package jogi
package testor
package model

import list.{ ::, Nil }
import record.{ Value, Entity, rel }

object Collection {
  trait Name extends Value.String
  trait Title extends Value.String
  trait Subtitle extends Value.String
}

// format: OFF
trait Collection extends Entity[
  Collection.Name ::
    Collection.Title ::
    Collection.Subtitle ::
    rel.has_many[User] ::
    rel.has_many[MediaItem] ::
    rel.has_many[Service] ::
    Nil]
