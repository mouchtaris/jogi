package jogi
package testor

import jogi.{ testor ⇒ app }
import list.{ ::, Nil }
import record.{ Enum, Value }

object User {
  trait Bio extends Value.String
  trait CreativeType extends app.CreativeType

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
    Nil)