package patron2.record

trait Lub[r <: Record] { type Out }

object Lub {

  type Aux[r <: Record, u] = Lub[r] { type Out = u }

  private[this] final object instance extends Lub[Nil] { type Out = Nothing }

  @inline def apply[r <: Record, u](): Lub.Aux[r, u] =
    instance.asInstanceOf[Lub.Aux[r, u]]

  @inline implicit def nilLub[h]: Lub.Aux[h :: Nil, h] =
    Lub()

  implicit def listLub[h, t <: Record, tu](
                                            implicit tlub: Lub.Aux[t, tu],
                                            hlub: fun.lub.Lub[h, tu]
                                          ): Lub.Aux[h :: t, hlub.Out] =
    Lub()

}