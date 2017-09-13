package patron2.list.ops

import patron2.list.{ ::, Record }

trait ContainsInTail extends Any {

  @inline final implicit def containsInTail[T, h, t <: Record: Contains.typ[T]#in]: Contains[h :: t, T] =
    Contains()

}