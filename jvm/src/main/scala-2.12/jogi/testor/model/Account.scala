package jogi
package testor
package model

import list.{ ::, Nil }
import record.{ Entity }

object Account {
  trait Email extends values.Email
  trait PasswordHash extends values.PasswordHash
  trait PasswordSalt extends values.PasswordSalt
}

// format: OFF
trait Account extends Entity[
  Account.Email ::
    Account.PasswordHash ::
    Account.PasswordSalt ::
    Nil]