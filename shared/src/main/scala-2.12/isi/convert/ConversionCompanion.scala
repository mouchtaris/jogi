package isi.convert

trait ConversionCompanion {

  final abstract class from[f] private {
    type to[t] = Conversion[f, t]
  }

}
