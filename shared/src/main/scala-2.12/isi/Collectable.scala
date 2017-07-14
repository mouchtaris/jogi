package isi

import scala.util.Try
import scala.util.control.Exception.nonFatalCatch

trait Collectable[-t] {
  def apply(t: t): Unit
}

object Collectable {

  final implicit class CollectableDecoration[t](val self: t) extends AnyVal {
    def collect()(implicit collector: Collectable[t]): Unit =
      collector(self)
  }

  def using[t: Collectable, r](collectable: t)(block: t ⇒ r): Try[r] =
    nonFatalCatch andFinally {
      collectable.collect()
    } withTry {
      block(collectable)
    }

  final implicit case object AutoCloseableCollectable extends Collectable[AutoCloseable] {
    def apply(closeable: AutoCloseable): Unit =
      closeable.close()
  }

}
