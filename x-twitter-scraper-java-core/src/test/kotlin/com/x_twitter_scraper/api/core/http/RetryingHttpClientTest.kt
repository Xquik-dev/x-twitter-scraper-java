// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.core.http

import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.matching
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.resetAllScenarios
import com.github.tomakehurst.wiremock.client.WireMock.serviceUnavailable
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.github.tomakehurst.wiremock.stubbing.Scenario
import com.x_twitter_scraper.api.client.okhttp.OkHttpClient
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.Sleeper
import com.x_twitter_scraper.api.errors.XTwitterScraperRetryableException
import java.io.InputStream
import java.time.Clock
import java.time.Duration
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.concurrent.CompletableFuture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.parallel.ResourceLock
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class RetryingHttpClientTest {

    private var openResponseCount = 0
    private lateinit var baseUrl: String
    private lateinit var httpClient: HttpClient

    private class RecordingSleeper : Sleeper {
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

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        baseUrl = wmRuntimeInfo.httpBaseUrl
        val okHttpClient = OkHttpClient.builder().build()
        httpClient =
            object : HttpClient {

                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = trackClose(okHttpClient.execute(request, requestOptions))

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> =
                    okHttpClient.executeAsync(request, requestOptions).thenApply { trackClose(it) }

                override fun close() = okHttpClient.close()

                private fun trackClose(response: HttpResponse): HttpResponse {
                    openResponseCount++
                    return object : HttpResponse {

                        private var isClosed = false

                        override fun statusCode(): Int = response.statusCode()

                        override fun headers(): Headers = response.headers()

                        override fun body(): InputStream = response.body()

                        override fun close() {
                            response.close()
                            if (isClosed) {
                                return
                            }
                            openResponseCount--
                            isClosed = true
                        }
                    }
                }
            }
        resetAllScenarios()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun execute(async: Boolean) {
        stubFor(post(urlPathEqualTo("/something")).willReturn(ok()))
        val sleeper = RecordingSleeper()
        val retryingClient = retryingHttpClientBuilder(sleeper).build()

        val response =
            retryingClient.execute(
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(baseUrl)
                    .addPathSegment("something")
                    .build(),
                async,
            )

        assertThat(response.statusCode()).isEqualTo(200)
        verify(1, postRequestedFor(urlPathEqualTo("/something")))
        assertThat(sleeper.durations).isEmpty()
        assertNoResponseLeaks()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun execute_withIdempotencyHeader(async: Boolean) {
        stubFor(
            post(urlPathEqualTo("/something"))
                .withHeader("X-Some-Header", matching("xquik-java-retry-.+"))
                .willReturn(ok())
        )
        val sleeper = RecordingSleeper()
        val retryingClient =
            retryingHttpClientBuilder(sleeper)
                .maxRetries(2)
                .idempotencyHeader("X-Some-Header")
                .build()

        val response =
            retryingClient.execute(
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(baseUrl)
                    .addPathSegment("something")
                    .build(),
                async,
            )

        assertThat(response.statusCode()).isEqualTo(200)
        verify(1, postRequestedFor(urlPathEqualTo("/something")))
        assertThat(sleeper.durations).isEmpty()
        assertNoResponseLeaks()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun execute_withRetryAfterHeader(async: Boolean) {
        val retryAfterDate = "Wed, 21 Oct 2015 07:28:00 GMT"
        stubFor(
            post(urlPathEqualTo("/something"))
                .inScenario("foo")
                .whenScenarioStateIs(Scenario.STARTED)
                .willReturn(serviceUnavailable().withHeader("Retry-After", retryAfterDate))
                .willSetStateTo("RETRY_AFTER_DATE")
        )
        stubFor(
            post(urlPathEqualTo("/something"))
                .inScenario("foo")
                .whenScenarioStateIs("RETRY_AFTER_DATE")
                .willReturn(serviceUnavailable().withHeader("Retry-After", "1.234"))
                .willSetStateTo("RETRY_AFTER_DELAY")
        )
        stubFor(
            post(urlPathEqualTo("/something"))
                .inScenario("foo")
                .whenScenarioStateIs("RETRY_AFTER_DELAY")
                .willReturn(ok())
                .willSetStateTo("COMPLETED")
        )
        val retryAfterDateTime =
            OffsetDateTime.parse(retryAfterDate, DateTimeFormatter.RFC_1123_DATE_TIME)
        val clock = Clock.fixed(retryAfterDateTime.minusSeconds(5).toInstant(), ZoneOffset.UTC)
        val sleeper = RecordingSleeper()
        val retryingClient = retryingHttpClientBuilder(sleeper, clock).maxRetries(2).build()

        val response =
            retryingClient.execute(
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(baseUrl)
                    .addPathSegment("something")
                    .build(),
                async,
            )

        assertThat(response.statusCode()).isEqualTo(200)
        verify(
            1,
            postRequestedFor(urlPathEqualTo("/something"))
                .withHeader("x-stainless-retry-count", equalTo("0")),
        )
        verify(
            1,
            postRequestedFor(urlPathEqualTo("/something"))
                .withHeader("x-stainless-retry-count", equalTo("1")),
        )
        verify(
            1,
            postRequestedFor(urlPathEqualTo("/something"))
                .withHeader("x-stainless-retry-count", equalTo("2")),
        )
        assertThat(sleeper.durations)
            .containsExactly(Duration.ofSeconds(5), Duration.ofMillis(1234))
        assertNoResponseLeaks()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun execute_withOverwrittenRetryCountHeader(async: Boolean) {
        val retryAfterDate = "Wed, 21 Oct 2015 07:28:00 GMT"
        stubFor(
            post(urlPathEqualTo("/something"))
                .inScenario("foo")
                .whenScenarioStateIs(Scenario.STARTED)
                .willReturn(serviceUnavailable().withHeader("Retry-After", retryAfterDate))
                .willSetStateTo("RETRY_AFTER_DATE")
        )
        stubFor(
            post(urlPathEqualTo("/something"))
                .inScenario("foo")
                .whenScenarioStateIs("RETRY_AFTER_DATE")
                .willReturn(ok())
                .willSetStateTo("COMPLETED")
        )
        val retryAfterDateTime =
            OffsetDateTime.parse(retryAfterDate, DateTimeFormatter.RFC_1123_DATE_TIME)
        val clock = Clock.fixed(retryAfterDateTime.minusSeconds(5).toInstant(), ZoneOffset.UTC)
        val sleeper = RecordingSleeper()
        val retryingClient = retryingHttpClientBuilder(sleeper, clock).maxRetries(2).build()

        val response =
            retryingClient.execute(
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(baseUrl)
                    .addPathSegment("something")
                    .putHeader("x-stainless-retry-count", "42")
                    .build(),
                async,
            )

        assertThat(response.statusCode()).isEqualTo(200)
        verify(
            2,
            postRequestedFor(urlPathEqualTo("/something"))
                .withHeader("x-stainless-retry-count", equalTo("42")),
        )
        assertThat(sleeper.durations).containsExactly(Duration.ofSeconds(5))
        assertNoResponseLeaks()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun execute_withRetryAfterMsHeader(async: Boolean) {
        stubFor(
            post(urlPathEqualTo("/something"))
                .inScenario("foo")
                .whenScenarioStateIs(Scenario.STARTED)
                .willReturn(serviceUnavailable().withHeader("Retry-After-Ms", "10"))
                .willSetStateTo("RETRY_AFTER_DELAY")
        )
        stubFor(
            post(urlPathEqualTo("/something"))
                .inScenario("foo")
                .whenScenarioStateIs("RETRY_AFTER_DELAY")
                .willReturn(ok())
                .willSetStateTo("COMPLETED")
        )
        val sleeper = RecordingSleeper()
        val retryingClient = retryingHttpClientBuilder(sleeper).maxRetries(1).build()

        val response =
            retryingClient.execute(
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(baseUrl)
                    .addPathSegment("something")
                    .build(),
                async,
            )

        assertThat(response.statusCode()).isEqualTo(200)
        verify(2, postRequestedFor(urlPathEqualTo("/something")))
        assertThat(sleeper.durations).containsExactly(Duration.ofMillis(10))
        assertNoResponseLeaks()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun execute_withRetryableException(async: Boolean) {
        stubFor(post(urlPathEqualTo("/something")).willReturn(ok()))

        var callCount = 0
        val failingHttpClient =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse {
                    callCount++
                    if (callCount == 1) {
                        throw XTwitterScraperRetryableException("Simulated retryable failure")
                    }
                    return httpClient.execute(request, requestOptions)
                }

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> {
                    callCount++
                    if (callCount == 1) {
                        val future = CompletableFuture<HttpResponse>()
                        future.completeExceptionally(
                            XTwitterScraperRetryableException("Simulated retryable failure")
                        )
                        return future
                    }
                    return httpClient.executeAsync(request, requestOptions)
                }

                override fun close() = httpClient.close()
            }

        val sleeper = RecordingSleeper()
        val retryingClient =
            RetryingHttpClient.builder()
                .httpClient(failingHttpClient)
                .maxRetries(2)
                .sleeper(sleeper)
                .build()

        val response =
            retryingClient.execute(
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(baseUrl)
                    .addPathSegment("something")
                    .build(),
                async,
            )

        assertThat(response.statusCode()).isEqualTo(200)
        verify(
            1,
            postRequestedFor(urlPathEqualTo("/something"))
                .withHeader("x-stainless-retry-count", equalTo("1")),
        )
        verify(
            0,
            postRequestedFor(urlPathEqualTo("/something"))
                .withHeader("x-stainless-retry-count", equalTo("0")),
        )
        assertThat(sleeper.durations).hasSize(1)
        assertThat(sleeper.durations[0]).isBetween(Duration.ofMillis(375), Duration.ofMillis(500))
        assertNoResponseLeaks()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun execute_withExponentialBackoff(async: Boolean) {
        stubFor(post(urlPathEqualTo("/something")).willReturn(serviceUnavailable()))
        val sleeper = RecordingSleeper()
        val retryingClient = retryingHttpClientBuilder(sleeper).maxRetries(3).build()

        val response =
            retryingClient.execute(
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(baseUrl)
                    .addPathSegment("something")
                    .build(),
                async,
            )

        assertThat(response.statusCode()).isEqualTo(503)
        verify(4, postRequestedFor(urlPathEqualTo("/something")))
        assertThat(sleeper.durations).hasSize(3)
        assertThat(sleeper.durations[0]).isBetween(Duration.ofMillis(375), Duration.ofMillis(500))
        assertThat(sleeper.durations[1]).isBetween(Duration.ofMillis(750), Duration.ofMillis(1000))
        assertThat(sleeper.durations[2]).isBetween(Duration.ofMillis(1500), Duration.ofMillis(2000))
        assertNoResponseLeaks()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun execute_withExponentialBackoffCap(async: Boolean) {
        stubFor(post(urlPathEqualTo("/something")).willReturn(serviceUnavailable()))
        val sleeper = RecordingSleeper()
        val retryingClient = retryingHttpClientBuilder(sleeper).maxRetries(6).build()

        val response =
            retryingClient.execute(
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(baseUrl)
                    .addPathSegment("something")
                    .build(),
                async,
            )

        assertThat(response.statusCode()).isEqualTo(503)
        verify(7, postRequestedFor(urlPathEqualTo("/something")))
        assertThat(sleeper.durations).hasSize(6)
        assertThat(sleeper.durations[4]).isBetween(Duration.ofMillis(6000), Duration.ofMillis(8000))
        assertThat(sleeper.durations[5]).isBetween(Duration.ofMillis(6000), Duration.ofMillis(8000))
        assertNoResponseLeaks()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun execute_withRetryAfterMsPriorityOverRetryAfter(async: Boolean) {
        stubFor(
            post(urlPathEqualTo("/something"))
                .inScenario("foo")
                .whenScenarioStateIs(Scenario.STARTED)
                .willReturn(
                    serviceUnavailable()
                        .withHeader("Retry-After-Ms", "50")
                        .withHeader("Retry-After", "2")
                )
                .willSetStateTo("RETRY")
        )
        stubFor(
            post(urlPathEqualTo("/something"))
                .inScenario("foo")
                .whenScenarioStateIs("RETRY")
                .willReturn(ok())
                .willSetStateTo("COMPLETED")
        )
        val sleeper = RecordingSleeper()
        val retryingClient = retryingHttpClientBuilder(sleeper).maxRetries(1).build()

        val response =
            retryingClient.execute(
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(baseUrl)
                    .addPathSegment("something")
                    .build(),
                async,
            )

        assertThat(response.statusCode()).isEqualTo(200)
        assertThat(sleeper.durations).containsExactly(Duration.ofMillis(50))
        assertNoResponseLeaks()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun execute_withRetryAfterUnparseable(async: Boolean) {
        stubFor(
            post(urlPathEqualTo("/something"))
                .inScenario("foo")
                .whenScenarioStateIs(Scenario.STARTED)
                .willReturn(serviceUnavailable().withHeader("Retry-After", "not-a-date-or-number"))
                .willSetStateTo("RETRY")
        )
        stubFor(
            post(urlPathEqualTo("/something"))
                .inScenario("foo")
                .whenScenarioStateIs("RETRY")
                .willReturn(ok())
                .willSetStateTo("COMPLETED")
        )
        val sleeper = RecordingSleeper()
        val retryingClient = retryingHttpClientBuilder(sleeper).maxRetries(1).build()

        val response =
            retryingClient.execute(
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(baseUrl)
                    .addPathSegment("something")
                    .build(),
                async,
            )

        assertThat(response.statusCode()).isEqualTo(200)
        assertThat(sleeper.durations).hasSize(1)
        assertThat(sleeper.durations[0]).isBetween(Duration.ofMillis(375), Duration.ofMillis(500))
        assertNoResponseLeaks()
    }

    private fun retryingHttpClientBuilder(
        sleeper: RecordingSleeper,
        clock: Clock = Clock.systemUTC(),
    ) = RetryingHttpClient.builder().httpClient(httpClient).sleeper(sleeper).clock(clock)

    private fun HttpClient.execute(request: HttpRequest, async: Boolean): HttpResponse =
        if (async) executeAsync(request).get() else execute(request)

    private fun assertNoResponseLeaks() = assertThat(openResponseCount).isEqualTo(1)
}
