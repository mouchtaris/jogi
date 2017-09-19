package jogi
package testor
package model

import typelevel.list.{ ::, Nil }
import record.{ Entity, key }

object Account {
  trait Email extends values.Email
  trait PasswordHash extends values.PasswordHash
  trait PasswordSalt extends values.PasswordSalt
}

// format: OFF
trait Account extends Entity[
  Account.Email with key.Primary ::
    Account.PasswordHash ::
    Account.PasswordSalt ::
    Nil]