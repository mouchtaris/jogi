package jogi
package testor

import record.Enum

trait CreativeType extends Enum

object CreativeType {
  trait Music extends CreativeType
  trait Photo extends CreativeType
  trait Dance extends CreativeType
  trait Theater extends CreativeType
}