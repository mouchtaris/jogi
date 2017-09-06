package patron2.typelevel

trait OrB {

  @inline final implicit def orB[a, b: Known]: Or[a, b] =
    Or()

}