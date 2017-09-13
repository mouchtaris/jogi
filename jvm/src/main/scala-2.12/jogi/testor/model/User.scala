package jogi
package testor
package model

import list.{ ::, Nil }
import record.{ Enum, Value }

object User {
  trait Bio extends Value.String
  trait CreativeType extends model.CreativeType
  trait Name extends Value.String
  trait LastName extends Value.String

  sealed trait Type extends Enum
  object Type {
    trait Creative extends Type
    trait Patron extends Type
  }
}

// format: OFF
trait User extends (
  User.Type ::
    User.Bio ::
    User.CreativeType ::
    User.Name ::
    User.LastName ::
    Nil)