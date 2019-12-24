import org.http4k.core.HttpHandler
import org.http4k.core.Request
import org.http4k.core.Response

class RequestHandler: HttpHandler {

    override fun invoke(request: Request): Response = page(render(null,"welcome"))
}
