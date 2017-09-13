package patron2.record

object Subset {

  trait PackageExtension {

    type Subset[a <: Record, s <: Record] = ForAll[a, Contains.in[s]#typ]

  }

}
