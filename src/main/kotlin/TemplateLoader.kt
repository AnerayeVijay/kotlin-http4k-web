import com.github.jknack.handlebars.Handlebars
import com.github.jknack.handlebars.io.ClassPathTemplateLoader
import org.http4k.core.ContentType
import org.http4k.core.Response
import org.http4k.core.Status

private fun Response.contentType(contentType: ContentType): Response = replaceHeader("Content-Type", contentType.toHeaderValue())

fun page(template: String) = Response(Status.OK)
    .contentType(ContentType.TEXT_HTML)
    .body(template)

val engine = Handlebars(templateLoader())

fun render(viewModel: Any?, templateName: String): String = engine.compile(templateName).apply(viewModel)


private fun templateLoader() = ClassPathTemplateLoader("/pages")