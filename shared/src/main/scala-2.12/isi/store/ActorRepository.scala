package isi.store

import java.util.concurrent.TimeUnit.SECONDS

import akka.actor.Status.Failure
import akka.actor.{ Actor, ActorRef, ActorSystem, Props }
import akka.pattern.ask
import akka.util.Timeout

import scala.collection.mutable
import scala.concurrent.Future
import scala.reflect.ClassTag

final class ActorRepository[k, v: ClassTag](implicit system: ActorSystem) extends Repository {

  private[this] case class Store(k: k, v: v)
  private[this] case class Retrieve(k: k)

  private[this] class Back extends Actor {
    private[this] val mem: mutable.Map[k, v] = mutable.Map[k, v]()

    def receive: Receive = {
      case Store(k, v) ⇒
        mem put (k, v)
        sender() ! Result.OK

      case Retrieve(k) ⇒
        mem get k match {
          case Some(v) ⇒ sender() ! v
          case None    ⇒ sender() ! Failure(new NoSuchElementException(k.toString))
        }
    }
  }

  private[this] val back: ActorRef = system actorOf Props(new Back)
  private[this] implicit val timeout: Timeout = Timeout(1, SECONDS)

  type Key = k

  type Value = v

  def apply(k: k): Future[v] = (back ? Retrieve(k)).mapTo[v]

  def update(k: k, v: v): Future[Result] =
    (back ? Store(k, v)).mapTo[Result]

}
