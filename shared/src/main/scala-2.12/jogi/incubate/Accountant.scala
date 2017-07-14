package jogi
package incubate

import akka.actor.Actor

import scala.collection.concurrent.TrieMap

class Accountant extends Actor {

  //  val state = isi.store.Repository.InMemory[Int, Int]()

  //  val accounts: TrieMap[Int, proto.Account] = TrieMap()

  def receive: Receive = {
    //    case _: Int ⇒ state.store(12).flatMap(_(14))(isi.Asap)
    case _ ⇒ throw new Exception()
  }

}
