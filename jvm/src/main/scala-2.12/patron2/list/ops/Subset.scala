package patron2.list.ops

import patron2.list.Record

object Subset {

  trait PackageExtension {

    type Subset[a <: Record, s <: Record] = ForAll[a, Contains.in[s]#typ]

  }

}
