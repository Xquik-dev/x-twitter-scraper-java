// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking

import com.sun.net.httpserver.HttpServer
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.AsyncStreamResponse
import com.x_twitter_scraper.api.models.events.Event
import com.x_twitter_scraper.api.models.events.EventStreamParams
import java.io.InterruptedIOException
import java.net.InetAddress
import java.net.InetSocketAddress
import java.time.Duration
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class EventServiceStreamTest {

    private val serverReleased = CountDownLatch(1)
    @Volatile private var pauseBeforeSecondEvent: Duration = Duration.ofMillis(1_500)
    private lateinit var server: HttpServer
    private lateinit var baseUrl: String

    @BeforeEach
    fun startServer() {
        server = HttpServer.create(InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0)
        server.createContext("/events/stream") { exchange ->
            exchange.responseHeaders.add("Content-Type", "text/event-stream")
            exchange.sendResponseHeaders(200, 0)
            exchange.responseBody.use { body ->
                body.write(event("42"))
                body.flush()
                val secondEventAt = System.nanoTime() + pauseBeforeSecondEvent.toNanos()
                while (
                    System.nanoTime() < secondEventAt &&
                        !serverReleased.await(100, TimeUnit.MILLISECONDS)
                ) {
                    body.write(": keep-alive\n\n".toByteArray())
                    body.flush()
                }
                body.write(event("43"))
            }
        }
        server.start()
        baseUrl = "http://127.0.0.1:${server.address.port}"
    }

    @AfterEach
    fun stopServer() {
        serverReleased.countDown()
        server.stop(0)
    }

    @Test
    fun streamOutlastsTheClientRequestTimeout() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(baseUrl)
                .apiKey("My API Key")
                .timeout(Duration.ofMillis(500))
                .build()

        val ids =
            client.events().stream().use { stream -> stream.stream().map { it.id() }.toList() }

        assertThat(ids).containsExactly("42", "43")
    }

    @Test
    fun streamStopsAtARequestTimeoutTheCallerSets() {
        val client =
            XTwitterScraperOkHttpClient.builder().baseUrl(baseUrl).apiKey("My API Key").build()
        val requestOptions = RequestOptions.builder().timeout(Duration.ofMillis(500)).build()

        assertThatThrownBy {
                client.events().stream(EventStreamParams.none(), requestOptions).use {
                    it.stream().toList()
                }
            }
            .isInstanceOf(InterruptedIOException::class.java)
    }

    @Test
    fun closingAWaitingStreamEndsItWithoutAnError() {
        pauseBeforeSecondEvent = Duration.ofMinutes(1)
        val asyncClient =
            XTwitterScraperOkHttpClientAsync.builder().baseUrl(baseUrl).apiKey("My API Key").build()
        val firstEvent = CompletableFuture<Event>()
        val completion = CompletableFuture<Optional<Throwable>>()
        val stream =
            asyncClient
                .events()
                .stream()
                .subscribe(
                    object : AsyncStreamResponse.Handler<Event> {
                        override fun onNext(value: Event) {
                            firstEvent.complete(value)
                        }

                        override fun onComplete(error: Optional<Throwable>) {
                            completion.complete(error)
                        }
                    }
                )
        assertThat(firstEvent.get(10, TimeUnit.SECONDS).id()).isEqualTo("42")

        val closeStarted = System.nanoTime()
        stream.close()
        val closeTook = Duration.ofNanos(System.nanoTime() - closeStarted)

        assertThat(completion.get(10, TimeUnit.SECONDS)).isEmpty()
        assertThat(closeTook).isLessThan(Duration.ofSeconds(5))
    }

    private fun event(id: String): ByteArray =
        ("id: $id\nevent: tweet.new\ndata: {\"id\":\"$id\",\"type\":\"tweet.new\"," +
                "\"monitorId\":\"7\",\"monitorType\":\"account\"," +
                "\"occurredAt\":\"2025-01-15T12:00:00.000Z\",\"data\":{}}\n\n")
            .toByteArray()
}
