package jogi
package testor
package model

import typelevel.list.{ ::, Nil }
import record.{ Enum, value, rel, Entity, key }

object User {
  trait Bio extends value.String
  trait CreativeType extends model.CreativeType
  trait Name extends value.String
  trait LastName extends value.String
  trait Username extends value.String

  sealed trait Type extends Enum
  object Type {
    trait Creative extends Type
    trait Patron extends Type
  }
}

// format: OFF
trait User extends Entity[
  User.Username with key.Primary ::
    User.Type ::
    User.Bio ::
    User.CreativeType ::
    User.Name ::
    User.LastName ::
    rel.has_one[Account] ::
    Nil]