package patron.log

import patron.{ Command, CommandDescription }

import scala.concurrent.Future

trait Logger {

  protected[this] def sink(msg: String): Future[Unit]

  final def log[t <: Command: CommandDescription](event: t): Future[Unit] = {
    val commandDesc: CommandDescription[t] = implicitly
    import commandDesc.{ `type`, name }
    val details: String = commandDesc details event
    sink(s"""{ "name": "$name", "type": "${`type`}", "details": $details }""")
  }

}
