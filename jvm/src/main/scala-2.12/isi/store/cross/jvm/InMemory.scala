package isi.store
package cross.jvm

import isi.convert._

import scala.collection.concurrent.TrieMap
import scala.concurrent.Future

final case class InMemory[K, V]() extends Repository {
  type Key = K
  type Value = V

  private[this] final val mem = TrieMap[K, V]()

  def apply(key: Key): Future[Value] =
    (mem get key).convertTo[Future[Value]]

  def store(key: Key): Future[Storer] =
    Future successful { value ⇒
      mem.put(key, value)
      Future successful Result.OK
    }
}
