package patron2.typelevel

trait OrA extends Any {

  @inline final implicit def orA[a: Known, b]: Or[a, b] =
    Or()

}
