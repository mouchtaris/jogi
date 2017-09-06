package patron

import java.util.concurrent.TimeUnit.SECONDS

import akka.actor.ActorSystem
import akka.http.scaladsl.model.Uri
import akka.stream.{ ActorMaterializer, Materializer }
import com.typesafe.config.ConfigFactory

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object test {

  def main(args: Array[String]): Unit = {
    val command = action.Unknown(Uri("https://www.lol.com/lol/lol"))
    val logger = log.StdoutLogger()
    logger.log(command)
    //    return ()
    import patron.db.PostgresqlSlickDatabase
    val conf = ConfigFactory.defaultApplication
    val db = new PostgresqlSlickDatabase(conf = conf, jdbcUrlConfPath = "db.pat.staging")
    implicit val system: ActorSystem = ActorSystem("test")
    implicit val materializer: Materializer = ActorMaterializer()
    val server = new http.server.Server
    try {
      import db.api._

      val q0 = db.tables.Users.take(1).map(u ⇒ (u.email, u.invitedEmails, u.invitePassword)).result
      val f0 = db.conn run q0

      val users = Await result (f0, Duration(10, SECONDS))
      val user = users.head
      println(user)
    }
    finally {
      db.conn.close()
    }
  }

}
