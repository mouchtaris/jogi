package isi.convert

trait ConversionCompanion {

  final abstract class from[from] private {
    type to[to] = Conversion[from, to]
  }

}
