package isi.convert

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

trait StandardConversions extends Any {

  final implicit def optionToTry[t]: Conversion[Option[t], Try[t]] = {
    case Some(v) ⇒ Success(v)
    case None ⇒ Failure(new NoSuchElementException("Option.None"))
  }

  final implicit def tryToFuture[t]: Conversion[Try[t], Future[t]] =
    Future.fromTry[t](_)

}
