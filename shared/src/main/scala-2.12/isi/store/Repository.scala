package isi.store

import isi.convert._

import scala.collection.concurrent.TrieMap
import scala.concurrent.Future

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
  type Aux[k, v] = Repository {
    type Key = k
    type Value = v
  }
}