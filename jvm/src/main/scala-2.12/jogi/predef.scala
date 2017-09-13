package jogi

object predef {

  def imply[T <: AnyRef](implicit t: T): t.type = t

}
