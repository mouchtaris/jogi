package isi

package object convert extends AnyRef
  with ImplicitResolutionOrder.Implicits
{

  final implicit class ConvertToDecoration[t](val self: t)
    extends AnyVal with ConvertToDecorationOps[t]
  
}
