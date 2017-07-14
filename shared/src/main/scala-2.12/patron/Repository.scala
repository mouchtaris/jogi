package patron

import isi.convert._

import scala.collection.concurrent.TrieMap
import scala.concurrent.Future
import scala.util.Try

trait Repository {
  type Key
  type Value

  trait Result

  final case object Result {
    final case object OK extends Result
    final case class Error(msg: String, cause: Throwable) extends Exception(msg, cause)
  }

  trait Storer {
    def apply(value: Value): Future[Result]
  }

  def apply(key: Key): Future[Value]
  def store(key: Key): Future[Storer]
}

object Repository {

  final case class InMemory[K, V]() extends Repository {
    type Key = K
    type Value = V

    private[this] final val mem = TrieMap[K, V]()

    def apply(key: Key): Future[Value] =
      (mem get key).convertTo[Future[Value]]

    def store(key: Key): Future[Storer] =
      Future successful { value ⇒
        val opt: Option[Result] = mem.put(key, value).map(_ ⇒ Result.OK)
        val trie: Try[Result] = opt.convertTo
        val futu: Future[Result] = trie.convertTo
        futu
      }
  }
}
