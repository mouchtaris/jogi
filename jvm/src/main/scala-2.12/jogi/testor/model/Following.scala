package jogi
package testor
package model

import list.{ ::, Nil }
import record.{ Entity, rel }

object Following {

  final implicit case object Follower extends typelevel.StringLiteral { type Self = this.type }
  final implicit case object Following extends typelevel.StringLiteral { type Self = this.type }

}

// format: OFF
trait Following extends Entity[
  rel.has_one[User] with rel.as[Following.Follower.Self] ::
    rel.has_one[User] with rel.as[Following.Following.Self] ::
    Nil]
