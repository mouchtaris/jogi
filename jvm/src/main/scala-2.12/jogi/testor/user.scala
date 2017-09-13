package jogi
package testor

import jogi.{ testor ⇒ app }
import list.{ ::, Nil }
import record.{ Enum, Value }

object user {

  sealed trait `type` extends Enum
  object `type` {
    trait creative extends `type`
    trait patron extends `type`
  }

  trait creative_type extends app.creative_type
  trait bio extends Value.String

  final implicit case object user extends user
}

trait user extends (user.`type` :: user.bio :: user.creative_type :: Nil)