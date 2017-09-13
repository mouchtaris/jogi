package jogi.list.ops

import jogi.list.{ ::, Record }

trait ContainsInHead extends Any {

  @inline final implicit def containsInHead[h, t <: Record]: Contains[h :: t, h] =
    Contains()

}
