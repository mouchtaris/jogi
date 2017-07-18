package patron

import akka.actor.ActorSystem

object test {

  final case class Main() {
    implicit val system: ActorSystem = ActorSystem("Bobs")
    val repo = new Repo()
  }

  final case class Point(x: Int, y: Int)

  def main(args: Array[String]): Unit = {
    val m = Main()
    import m.repo.{ apply ⇒ DB }
    import scala.concurrent.ExecutionContext.Implicits.global
    for {
      _ ← DB[Point].set(12) = Point(21, 14)
      v ← DB[Point] get 12
      _ ← m.system.terminate()
    } println(v)
  }

}
