package jogi
package testor

import record.Value

object values {

  trait email extends Value.String
  trait passhash extends Value.Bytes
  trait passsalt extends Value.Bytes

}
