package jogi
package testor
package model

import list.{ ::, Nil }
import record.{ Value, Enum, Entity, rel, key }

object Service {
  trait Name extends Value.String
  trait Price extends Value.Long

  sealed trait Type extends Enum
  object Type {
    trait Hourly extends Type
    trait Fixed extends Type
    trait Negotiable extends Type
    trait Event extends Type
  }
}

// format: OFF
trait Service extends Entity[
  Service.Name with key.Primary ::
    Service.Type with key.Primary ::
    Service.Price ::
    rel.has_one[User] ::
    Nil]
