package jogi
package typelevel
package list
package ops

trait ContainsInTail extends Any {

  @inline final implicit def containsInTail[T, h, t <: List: Contains.typ[T]#in]: Contains[h :: t, T] =
    Contains()

}