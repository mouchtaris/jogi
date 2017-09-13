package patron2.list

object Subset {

  trait PackageExtension {

    type Subset[a <: Record, s <: Record] = ForAll[a, Contains.in[s]#typ]

  }

}
