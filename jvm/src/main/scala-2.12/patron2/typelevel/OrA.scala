package patron2.typelevel

trait OrA extends OrB{
  final implicit def orA[a: known, b]: Or[a, b] = Or()
}
