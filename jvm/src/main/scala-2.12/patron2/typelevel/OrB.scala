package patron2.typelevel

trait OrB {
  final implicit def orB[a, b: known]: Or[a, b] = Or()
}