package patron2.record

trait ContainsInHead extends Any {

  @inline final implicit def containsInHead[h, t <: Record]: Contains[h :: t, h] =
    Contains()

}
