package patron2.record

trait ContainsInTail extends Any {

  @inline final implicit def containsInTail[T, h, t <: Record: Contains.typ[T]#in]: Contains[h :: t, T] =
    Contains()

}