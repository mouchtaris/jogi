package fun
package list

trait ListOps[l <: List] extends Any {

  final type Self = l

  def self: Self

  def ::[h2](h2: h2): h2 :: l = list.::(h2, self)

}
