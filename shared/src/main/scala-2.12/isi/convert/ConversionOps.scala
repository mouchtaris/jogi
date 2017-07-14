package isi.convert

trait ConversionOps[a, b] extends Any {

  def self: Conversion[a, b]

  def andThen[c](other: Conversion[b, c]): Conversion[a, c] =
    (self apply _) andThen other.apply apply _

}
