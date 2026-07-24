package com.x_twitter_scraper.api.core.http

import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.Sleeper
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.time.Duration
import java.util.ArrayDeque
import java.util.concurrent.CompletableFuture

internal class RecordingRetrySleeper : Sleeper {

    val durations = mutableListOf<Duration>()

    override fun sleep(duration: Duration) {
        durations.add(duration)
    }

    override fun sleepAsync(duration: Duration): CompletableFuture<Void> {
        durations.add(duration)
        return CompletableFuture.completedFuture(null)
    }

    override fun close() {}
}

internal class SequenceHttpClient(vararg responses: HttpResponse) : HttpClient {

    private val responses = ArrayDeque(responses.toList())

    override fun execute(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): HttpResponse = responses.removeFirst()

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> =
        CompletableFuture.completedFuture(execute(request, requestOptions))

    override fun close() {}
}

internal fun testResponse(
    statusCode: Int,
    headers: Headers = Headers.builder().build(),
): HttpResponse =
    object : HttpResponse {

        override fun statusCode(): Int = statusCode

        override fun headers(): Headers = headers

        override fun body(): InputStream = ByteArrayInputStream(ByteArray(0))

        override fun close() {}
    }
