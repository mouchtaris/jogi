package jogi
package testor
package model

import list.{ ::, Nil }
import record.{ Value, Enum, `1-n` }

object Service {
  trait Name extends Value.String
  trait Price extends Value.Long

  sealed trait Type extends Enum
  object Type {
    trait Hourly extends Type
    trait Fixed extends Type
    trait Event extends Type
  }

  object relations {
    trait ServiceUser extends (User `1-n` Service)
  }
}

// format: OFF
trait Service extends (
  Service.Name ::
    Service.Type ::
    Service.Price ::
    Nil
  )
