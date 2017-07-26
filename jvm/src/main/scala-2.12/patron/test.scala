package patron

import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeUnit.SECONDS

import akka.actor.ActorSystem

import scala.concurrent.{ Await, Future }
import scala.concurrent.duration.Duration

import scala.concurrent.ExecutionContext.Implicits.global

object test {

  def main(args: Array[String]): Unit = {
    import patron.db.{ Database, SlickPostgresqlDatabase, schema }
    val db = new SlickPostgresqlDatabase
    try {
      import db.api._

      val q0 = db.tables.Users.take(1).result
      val f0 = db.conn run q0

      f0 onComplete (println _)

      Await ready (f0, Duration(5, SECONDS))
    }
    finally db.conn.close()
  }

}
