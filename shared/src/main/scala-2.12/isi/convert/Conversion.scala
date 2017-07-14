package isi.convert

trait Conversion[from, to] {
  def apply(from: from): to
}

object Conversion extends ConversionCompanion {

  final implicit class Ext[a, b](val self: Conversion[a, b])
    extends AnyVal with ConversionOps[a, b]

}