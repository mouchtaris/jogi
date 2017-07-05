package jogi
package incubate

import akka.actor.Actor

class StdStreamer extends Actor {

  def receive: Receive = {
    case StdOut(any) ⇒
      println(any)
  }

}