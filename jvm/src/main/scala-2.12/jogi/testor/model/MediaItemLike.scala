package jogi
package testor
package model

import typelevel.list.{ ::, Nil }
import record.{ Entity, rel }

// format: OFF
trait MediaItemLike extends Entity[
  rel.has_one[User] ::
    rel.has_one[MediaItem] ::
    Nil]
