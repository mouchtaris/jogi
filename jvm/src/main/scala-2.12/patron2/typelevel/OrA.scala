package patron2.typelevel

trait OrA extends OrB {

  @inline final implicit def orA[a: Known, b]: Or[a, b] =
    Or()

}
