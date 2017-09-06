package fun

package object list {

  type nil = nil.type

  implicit class ListDeco[l <: List](val self: l) extends AnyVal with ListOps[l]

}
