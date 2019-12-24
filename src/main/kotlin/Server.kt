import org.http4k.server.Jetty
import org.http4k.server.asServer

fun main() {
    val app = RequestHandler()

    app.asServer(Jetty(9000)).start()
}
