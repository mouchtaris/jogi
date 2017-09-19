package jogi
package testor
package model

import typelevel.list.{ ::, Nil }
import record.{ value, Entity, rel }

object Booking {
  trait Date extends value.Instant
  trait Duration extends value.Long
  trait Price extends value.Long

  final implicit case object Patron extends typelevel.StringLiteral { type Self = this.type }
  final implicit case object Creative extends typelevel.StringLiteral { type Self = this.type }
}

// format: OFF
trait Booking extends Entity[
  Booking.Date ::
    rel.has_one[User] with rel.as[Booking.Patron.Self] ::
    rel.has_one[User] with rel.as[Booking.Creative.Self] ::
    rel.has_one[Service] ::
    Nil]
