package patron

import akka.actor.ActorSystem
import isi.store.{ ActorRepository, Repository }
import isi.ClassTag._

import scala.collection.mutable
import scala.concurrent.Future
import scala.reflect.ClassTag

final class Repo(implicit system: ActorSystem) {

  type Key = ClassTag[Any]
  type Value = Repository.Aux[Long, Any]
  type Result[t] = Repository.Aux[Long, t]#Result

  private[this] val repos: mutable.Map[ClassTag[t] forSome { type t }, Repository] = mutable.Map()

  def apply[T](implicit ct: ClassTag[T]): Repository.Aux[Long, T] =
    repos.getOrElseUpdate(ct, new ActorRepository[Long, T]())
      .asInstanceOf[Repository.Aux[Long, T]]

}