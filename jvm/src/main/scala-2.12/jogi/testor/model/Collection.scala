package jogi
package testor
package model

import list.{ ::, Nil }
import record.{ Value, `1:n`, `1:1` }

object Collection {
  trait Name extends Value.String
  trait Title extends Value.String

  object Subtitle {
    trait Value extends record.Value.String
  }
  trait Subtitle extends (Subtitle.Value :: Nil)

  object relations {
    trait Users extends (Collection `1:n` User)
    trait MediaItems extends (Collection `1:n` MediaItem)
    trait Services extends (Collection `1:n` Service)
    trait Subtitle extends (Collection `1:1` Collection.Subtitle)
    type all = Users :: MediaItems :: Services :: Subtitle :: Nil
  }

}

// format: OFF
trait Collection extends (
  Collection.Name ::
    Collection.Title ::
    Nil)
