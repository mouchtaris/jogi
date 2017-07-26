package patron

import java.util.concurrent.TimeUnit.SECONDS

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object test {

  def main(args: Array[String]): Unit = {
    import patron.db.SlickPostgresqlDatabase
    val db = new SlickPostgresqlDatabase("pat")
    try {
      import db.api._

      val q0 = db.tables.Users.take(1).map(u ⇒ (u.email, u.invitedEmails, u.invitePassword)).result
      val f0 = db.conn run q0

      val users = Await result (f0, Duration(1, SECONDS))
      val user = users.head
      println(user)
    }
    finally db.conn.close()
  }

}
