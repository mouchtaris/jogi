package patron2.list

trait ContainsInHead extends Any {

  @inline final implicit def containsInHead[h, t <: Record]: Contains[h :: t, h] =
    Contains()

}
