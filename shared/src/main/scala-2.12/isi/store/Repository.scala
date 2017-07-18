package isi.store

import scala.concurrent.Future

trait Repository {
  type Key
  type Value

  sealed trait Result

  final object Result {
    final case object OK extends Result
    case class Error(msg: String, cause: Throwable) extends Exception(msg, cause)
  }

  def apply(key: Key): Future[Value]
  def update(key: Key, value: Value): Future[Result]

  //
  // Aliases
  //
  @inline final def get(key: Key): Future[Value] = this(key)
  final case object set {
    @inline def update(key: Key, value: Value): Future[Result] = Repository.this(key) = value
  }
}

object Repository {
  type Aux[k, v] = Repository {
    type Key = k
    type Value = v
  }
}