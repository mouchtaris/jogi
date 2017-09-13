package jogi
package testor

import record.Enum

trait creative_type extends Enum

object creative_type {
  trait music extends creative_type
  trait photo extends creative_type
  trait dance extends creative_type
  trait theater extends creative_type
}