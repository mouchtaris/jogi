package isi.convert

object ImplicitResolutionOrder {

  sealed trait p100 extends Any with ChainedConversion
  sealed trait p50 extends Any with p100 with StandardConversions
  sealed trait p0 extends Any with p50

  trait Implicits extends p0

}