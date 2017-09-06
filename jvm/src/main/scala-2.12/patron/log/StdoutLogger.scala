package patron.log

import scala.concurrent.Future

final case class StdoutLogger() extends Logger {

  protected[this] def sink(msg: String): Future[Unit] =
    Future successful println(msg)

}