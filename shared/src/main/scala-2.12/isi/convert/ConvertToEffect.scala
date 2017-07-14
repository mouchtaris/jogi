package isi.convert

trait ConvertToEffect[f[_], t] {

  type Result <: f[x] forSome { type x }

  def apply(self: t): Result
}

object ConvertToEffect extends ConvertToEffectCompanion