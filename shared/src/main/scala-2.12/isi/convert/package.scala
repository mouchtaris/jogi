package isi

package object convert extends AnyRef
  with ImplicitResolutionOrder.Implicits
{

  final implicit class ConvertToDecoration[t](val self: t) extends AnyVal {
    def convertTo[u: Conversion.from[t]#to]: u = implicitly[Conversion[t, u]].apply(self)
  }

}
