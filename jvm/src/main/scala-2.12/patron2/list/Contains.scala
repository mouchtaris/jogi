package patron2.list

trait Contains[r <: Record, t] extends Any

object Contains extends ContainsInferences {

  private[this] final object Instance extends Contains[Nil, Nil]

  /**
   * {{{
   *   def contains[t, r <: Record: Contains.typ[t]#in]
   * }}}
   */
  type typ[t] = {
    type in[r <: Record] = Contains[r, t]
  }

  /**
   * {{{
   *   def contains[r <: Record, t: Contains.in[r]#typ]
   * }}}
   */
  type in[r <: Record] = {
    type typ[t] = Contains[r, t]
  }

  @inline def apply[r <: Record, t](): Contains[r, t] =
    Instance.asInstanceOf[Contains[r, t]]

}