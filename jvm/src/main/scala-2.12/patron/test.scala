package patron

import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeUnit.SECONDS

import akka.actor.ActorSystem

import scala.concurrent.Await
import scala.concurrent.duration.Duration
// Use H2Profile to connect to an H2 database
import slick.jdbc.H2Profile.api._

import scala.concurrent.ExecutionContext.Implicits.global

object test {

  final case class Main() {
    implicit val system: ActorSystem = ActorSystem("Bobs")
    val repo = new Repo()
  }

  final case class Point(x: Int, y: Int)

  def main(args: Array[String]): Unit = {
    class Bob(tag: Tag) extends Table[(Long, String)](tag, "accounts") {
      def id = column[Long]("id", O.PrimaryKey)
      def email = column[String]("email")
      def * = (id, email)
    }
    val accounts = TableQuery[Bob]
    val setup = DBIO.seq(
      accounts += ((1, "bob@sponge.com")),
      accounts += ((2, "sponge@bob.com"))
    )

    val m = Main()
    import m.repo.{ apply ⇒ DB }
    import scala.concurrent.ExecutionContext.Implicits.global

    val db = Database.forURL("jdbc:postgresql:jogi")
    val setupComplete = db.run(setup)

    val awesome = for {
      _ ← DB[Point].set(12) = Point(21, 14)
      v ← DB[Point] get 12
      _ ← setupComplete
      _ ← m.system.terminate()
    } yield println(v)
    awesome.failed.foreach { e ⇒ println(s"bollocked $e") }
    Await.result(awesome, Duration(1, SECONDS))
  }

}
