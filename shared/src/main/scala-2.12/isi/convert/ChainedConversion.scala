package isi.convert

trait ChainedConversion extends Any {

  final implicit def chainedConversion[a, b, c](
    implicit
    a2b: Conversion[a, b],
    b2c: Conversion[b, c]
  ): Conversion[a, c] = a2b andThen b2c

}
