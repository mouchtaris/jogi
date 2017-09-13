package jogi
package testor
package model

import record.`1-n`

trait Following extends (User `1-n` User)

object Following {

  final implicit object RelationAlias extends record.RelationAlias[Following] {
    final implicit case object Follower extends typelevel.StringLiteral { type Self = this.type }
    final implicit case object Following extends typelevel.StringLiteral { type Self = this.type }

    type NameA = Follower.Self
    type NameB = Following.Self
  }

}