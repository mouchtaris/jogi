package jogi
package typelevel
package list
package ops

trait Contains[r <: List, t] extends Any

object Contains extends ContainsInferences {

  private[this] final object Instance extends Contains[Nil, Nil]

  /**
   * {{{
   *   def contains[t, r <: Record: Contains.typ[t]#in]
   * }}}
   */
  type typ[t] = {
    type in[r <: List] = Contains[r, t]
  }

  /**
   * {{{
   *   def contains[r <: Record, t: Contains.in[r]#typ]
   * }}}
   */
  type in[r <: List] = {
    type typ[t] = Contains[r, t]
  }

  @inline def apply[r <: List, t](): Contains[r, t] =
    Instance.asInstanceOf[Contains[r, t]]

}