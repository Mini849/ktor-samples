import com.google.gson.Gson
import entity.ElrondResponse
import entity.ElrondResponses
import entity.database.Tables
import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.util.cio.*
import io.ktor.utils.io.*
import kotlinx.coroutines.*
import java.io.*
import java.net.*

fun main() {
    var json : Array<ElrondResponse>
    runBlocking {
        val client = HttpClient(Apache) {
            followRedirects = true
        }
        val content = client.get("https://api.elrond.com/tokens?identifier=RIDE-7d18e9").bodyAsText()
        content
        json = Gson().fromJson(content, Array<ElrondResponse>::class.java)
        json
    }

}

data class HttpClientException(val response: HttpResponse) : IOException("HTTP Error ${response.status}")

suspend fun HttpClient.getAsTempFile(url: String, callback: suspend (file: File) -> Unit) {
    val file = getAsTempFile(url)
    try {
        callback(file)
    } finally {
        file.delete()
    }
}

suspend fun HttpClient.getAsTempFile(url: String): File {
    val file = File.createTempFile("ktor", "http-client")
    val response = request {
        url(URL(url))
        method = HttpMethod.Get
    }
    if (!response.status.isSuccess()) {
        throw HttpClientException(response)
    }
    response.bodyAsChannel().copyAndClose(file.writeChannel())
    return file
}
