package patron.app

import scala.concurrent.{ ExecutionContext, Future }
import patron.model._
import isi.convert._

trait Patron {

  implicit val executionContext: ExecutionContext
  val accountRepo: isi.store.Repository.Aux[String, Account]

  def addAccount(account: Account): Future[Account] =
    for {
      email ← account.email.map(_.value).convertToEffect[Future]
      storer ← accountRepo.store(email)
      result ← storer(account)
    } yield result match {
      case accountRepo.Result.OK ⇒ account
    }

}