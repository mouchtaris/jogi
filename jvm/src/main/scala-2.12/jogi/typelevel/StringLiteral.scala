package jogi.typelevel

/**
  * StringLiteral is a "vanilla" scala common interface for
  * string literal singleton types.
  *
  * Acquiring the value of such a type requires that an implicit instance is
  * provided, and that method {{{toString}}} is overriden in the implementing
  * object.
  */
trait StringLiteral {
  type Self <: StringLiteral

  override def toString: String
}

object StringLiteral {
  type Aux[t <: StringLiteral] = StringLiteral {
    type Self = t
  }
}
