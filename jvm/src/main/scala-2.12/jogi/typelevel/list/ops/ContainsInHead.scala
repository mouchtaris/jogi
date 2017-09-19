package jogi
package typelevel
package list
package ops

trait ContainsInHead extends Any {

  @inline final implicit def containsInHead[h, t <: List]: Contains[h :: t, h] =
    Contains()

}
