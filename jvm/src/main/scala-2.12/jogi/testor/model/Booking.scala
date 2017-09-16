package jogi
package testor
package model

import list.{ ::, Nil }
import record.{ Value, Entity, rel }

object Booking {
  trait Date extends Value.Instant
  trait Duration extends Value.Long
  trait Price extends Value.Long

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
