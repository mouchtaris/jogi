package jogi.list.ops

import jogi.list.{ ::, List }

trait ContainsInHead extends Any {

  @inline final implicit def containsInHead[h, t <: List]: Contains[h :: t, h] =
    Contains()

}
