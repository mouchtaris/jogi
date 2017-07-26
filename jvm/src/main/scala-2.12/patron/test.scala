package patron

import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeUnit.SECONDS

import akka.actor.ActorSystem

import scala.concurrent.{ Await, Future }
import scala.concurrent.duration.Duration
import scala.language.postfixOps
import slick.jdbc.PostgresProfile.{ api ⇒ db }

import scala.concurrent.ExecutionContext.Implicits.global

object test {

  final case class Main() {
    implicit val system: ActorSystem = ActorSystem("Bobs")
    val repo = new Repo()
  }

  final case class Point(x: Int, y: Int)

  object schema {
    import db._
    class Account(tag: Tag) extends Table[Tuple1[String]](tag, "accounts") {
      def email = column[String]("email", O.PrimaryKey)
      def * = Tuple1(email)
    }
    val accounts = db.TableQuery[Account]
  }

  def main(args: Array[String]): Unit = {
    Class.forName("org.postgresql.Driver")
    val setup = {
      import db._
      db.DBIO.seq(
        schema.accounts += Tuple1("bob@sponge.vom")
      //      schema.Accounts += ("com@sponge.bob")
      )
    }

    val m = Main()
    import m.repo.{ apply ⇒ DB }
    import scala.concurrent.ExecutionContext.Implicits.global

    val dbconn = db.Database.forURL("jdbc:postgresql:jogi?user=jogi")
    val setupComplete = dbconn.run(setup)
    def term0 = m.system.terminate()
    def term1 = Future { dbconn close }
    def terms = term0 zip term1

    val awesome = for {
      _ ← DB[Point].set(12) = Point(21, 14)
      v ← DB[Point] get 12
      _ ← setupComplete
    } yield println(v)

    val wait = awesome flatMap (_ ⇒ terms) recoverWith { case _ ⇒ terms } map (_ ⇒ ())

    wait.failed.foreach { e ⇒ println(s"bollocked $e") }
    Await.result(awesome, Duration(1, SECONDS))
  }

}
