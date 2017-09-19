package jogi
package typelevel
package list
package ops

object Subset {

  trait PackageExtension {

    type Subset[a <: List, s <: List] = ForAll[a, Contains.in[s]#typ]

  }

}
