package jogi
package testor
package model

import list.{ ::, Nil }
import record.{ `1-n`, Value }

object Booking {
  trait Date extends Value.Instant
  trait Duration extends Value.Long
  trait Price extends Value.Long

  object relations {

    trait BookingPatron extends (User `1-n` Booking)

    trait BookingCreative extends (User `1-n` Booking)

    trait BookingService extends (Service `1-n` Booking)

  }

}

// format: OFF
trait Booking extends (
  Booking.Date ::
    Nil)
