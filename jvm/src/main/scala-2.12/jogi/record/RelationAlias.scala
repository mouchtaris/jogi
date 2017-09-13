package jogi
package record

import typelevel.StringLiteral

trait RelationAlias[r <: Relation.Any] {
  type NameA <: StringLiteral.Aux[NameA]
  type NameB <: StringLiteral.Aux[NameB]
}

object RelationAlias {

  type Aux[r <: Relation.Any, nameA <: StringLiteral.Aux[nameA], nameB <: StringLiteral.Aux[nameB]] = RelationAlias[r] {
    type NameA = nameA
    type NameB = nameB
  }

  @inline def apply[r <: Relation.Any](implicit alias: RelationAlias[r]): alias.type =
    alias

}