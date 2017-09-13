package jogi
package testor

import list.{ ::, Nil }

object account {
  trait email extends values.email
  trait passhash extends values.passhash
  trait passsalt extends values.passsalt
}

trait account extends (account.email :: account.passhash :: account.passsalt :: Nil)