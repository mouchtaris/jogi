package jogi
package record

import typelevel.list.{ List }

trait Relation {
  trait has_one[e <: Entity[r] forSome { type r <: List }]
  trait has_many[e <: Entity[r] forSome { type r <: List }]

  trait as[alias <: typelevel.StringLiteral]
}
