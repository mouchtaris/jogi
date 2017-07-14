package isi.convert

trait ConvertToDecorationOps[t] extends Any {
  def self: t

  def convertTo[u: Conversion.from[t]#to]: u = implicitly[Conversion[t, u]].apply(self)
  def convertToEffect[f[_]](implicit tecc: ConvertToEffect[f, t]): tecc.Result = tecc(self)
}
