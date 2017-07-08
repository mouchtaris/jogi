package jogi
package incubate

import akka.actor.Actor

import scala.collection.concurrent.TrieMap

class Accountant extends Actor {

//  val accounts: TrieMap[Int, proto.Account] = TrieMap()

  def receive: Receive = {
    case _ ⇒ throw new Exception()
  }

}
