package jogi
package testor
package model

import list.{ ::, Nil }

object Account {
  trait Email extends values.Email
  trait PasswordHash extends values.PasswordHash
  trait PasswordSalt extends values.PasswordSalt
}

// format: OFF
trait Account extends (
  Account.Email ::
    Account.PasswordHash ::
    Account.PasswordSalt ::
    Nil)