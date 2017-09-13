package jogi.list.ops

import jogi.list.{ ::, List }

trait ContainsInTail extends Any {

  @inline final implicit def containsInTail[T, h, t <: List: Contains.typ[T]#in]: Contains[h :: t, T] =
    Contains()

}