import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.http4k.core.Method.GET
import org.http4k.core.Status.Companion.OK
import org.jsoup.Jsoup
import org.junit.Test

class RequestHandlerTest {

    @Test
    fun `should return welcome page`() {
        val request = org.http4k.core.Request(GET, "http://localhost:9000/")
        val requestHandler = RequestHandler()
        requestHandler(request).run {
            assertThat(this.status,equalTo(OK))
            Jsoup.parse(bodyString()).run {
                com.natpryce.hamkrest.assertion.assertThat(
                    select("#welcomeMessage").html(),
                    com.natpryce.hamkrest.equalTo("Welcome")
                )
            }
        }
    }
}