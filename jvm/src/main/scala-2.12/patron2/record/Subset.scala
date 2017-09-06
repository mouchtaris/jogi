package patron2.record

trait Subset[a <: Record, s <: Record] extends Any

object Subset {

  final implicit object NilSubset extends Subset[Nil, Nil]

  @inline def apply[a <: Record, s <: Record](): Subset[a, s] =
    NilSubset.asInstanceOf[Subset[a, s]]

  implicit def apply[a <: Record, s <: Record](
    implicit
    proof: ForAll[a, Contains.in[s]#typ]
  ): Subset[a, s] =
    Subset()
}
