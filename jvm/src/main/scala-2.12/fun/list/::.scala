package fun
package list

final case class ::[h, t <: List](head: h, tail: t) extends List {
  override def toString: String = s"$head :: $tail"
}

