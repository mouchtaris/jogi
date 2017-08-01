package patron.http.server

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server._
import akka.stream.Materializer

import scala.collection.immutable
import scala.concurrent.Future

class Server(
    implicit
    materializer: Materializer,
    system:       ActorSystem
) {

  val route: Route = context ⇒
    Future successful {
      RouteResult.Complete(HttpResponse(
        status   = StatusCode.int2StatusCode(200),
        headers  = immutable.Seq.empty[HttpHeader],
        entity   = HttpEntity(ContentTypes.`text/plain(UTF-8)`, context.request.uri.toString),
        protocol = HttpProtocols.`HTTP/1.1`
      ))
    }

  val binding: Future[Http.ServerBinding] = Http().bindAndHandle(
    handler   = route,
    interface = "0.0.0.0",
    port      = 19000
  )

}
