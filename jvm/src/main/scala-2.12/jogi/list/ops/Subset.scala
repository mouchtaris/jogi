package jogi.list.ops

import jogi.list.Record

object Subset {

  trait PackageExtension {

    type Subset[a <: Record, s <: Record] = ForAll[a, Contains.in[s]#typ]

  }

}
