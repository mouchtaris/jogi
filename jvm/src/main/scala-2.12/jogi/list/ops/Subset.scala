package jogi.list.ops

import jogi.list.List

object Subset {

  trait PackageExtension {

    type Subset[a <: List, s <: List] = ForAll[a, Contains.in[s]#typ]

  }

}
