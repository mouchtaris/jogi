package jogi
package testor
package model

import list.{ ::, Nil }
import record.{ has_many, Value }

object Booking {
  trait Date extends Value.Instant
  trait Duration extends Value.Long
  trait Price extends Value.Long

  object relations {
    trait Patron extends (User `has_many` Booking)
    trait Creative extends (User `has_many` Booking)
    trait Service extends (model.Service `has_many` Booking)
  }

  trait PrimaryKey extends (
    relations.Patron ::
      relations.Creative ::
      relations.Service ::
      Nil)

}

// format: OFF
trait Booking extends (
  Booking.Date ::
    Booking.relations.Patron ::
    Booking.relations.Creative ::
    Booking.relations.Service ::
    Nil)
