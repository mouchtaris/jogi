package jogi.typelevel

trait OrB extends Any {

  @inline final implicit def orB[a, b](implicit b: b): Or[a, b] =
    Or()

}