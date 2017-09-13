package jogi.typelevel

trait OrA extends Any {

  @inline final implicit def orA[a, b](implicit a: a): Or[a, b] =
    Or()

}
