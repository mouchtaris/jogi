package isi.store.cross.js

import scala.concurrent.Future
import isi.convert._

import scala.collection.mutable

final case class InMemory[k, v](
    mem: mutable.Map[k, v] = mutable.Map[k, v]()
) extends isi.store.Repository {
  type Key = k
  type Value = v

  def store(key: k): Future[Storer] =
    Future successful { value ⇒
      mem.put(key, value)
      Future successful Result.OK
    }

  def apply(key: k): Future[v] =
    mem.get(key).convertToEffect[Future]
}
