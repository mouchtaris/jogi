package isi.convert

trait ConvertToEffectCompanion {

  abstract class Aux[f[_], t, r <: f[_]] extends ConvertToEffect[f, t] {
    final type Result = r
  }

  implicit def apply[f[_], t, g[_], tt](implicit ev: t =:= g[tt], conv: Conversion[g[tt], f[tt]]): Aux[f, t, f[tt]] =
    self ⇒ conv(ev(self))

}
