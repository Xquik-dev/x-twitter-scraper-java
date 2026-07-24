// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.core.http

import java.time.Clock
import java.time.Duration
import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class RetryingHttpClientSecurityTest {

    @ParameterizedTest
    @ValueSource(strings = ["NaN", "Infinity", "-1"])
    fun invalidRetryAfterUsesBoundedBackoff(retryAfter: String) {
        val sleeper = RecordingRetrySleeper()
        val client =
            retryingClient(
                sleeper,
                testResponse(503, retryAfterHeaders(retryAfter)),
                testResponse(503),
            )

        client.execute(TEST_REQUEST).use { response ->
            assertThat(response.statusCode()).isEqualTo(503)
        }

        assertThat(sleeper.durations).hasSize(1)
        assertThat(sleeper.durations.single())
            .isBetween(Duration.ofMillis(375), Duration.ofMillis(500))
    }

    @ParameterizedTest
    @ValueSource(strings = ["1e100", "999999999999999999999999999999"])
    fun excessiveRetryAfterCapsServerDelay(retryAfter: String) {
        val sleeper = RecordingRetrySleeper()
        val client =
            retryingClient(
                sleeper,
                testResponse(503, retryAfterHeaders(retryAfter)),
                testResponse(200),
            )

        client.execute(TEST_REQUEST).use { response ->
            assertThat(response.statusCode()).isEqualTo(200)
        }

        assertThat(sleeper.durations).containsExactly(MAX_SERVER_DELAY)
    }

    @ParameterizedTest
    @ValueSource(strings = ["Fri, 31 Dec 9999 23:59:59 GMT"])
    fun farFutureRetryAfterDateCapsServerDelay(retryAfter: String) {
        val sleeper = RecordingRetrySleeper()
        val client =
            retryingClient(
                sleeper,
                testResponse(503, retryAfterHeaders(retryAfter)),
                testResponse(200),
            )

        client.execute(TEST_REQUEST).use { response ->
            assertThat(response.statusCode()).isEqualTo(200)
        }

        assertThat(sleeper.durations).containsExactly(MAX_SERVER_DELAY)
    }

    @ParameterizedTest
    @ValueSource(strings = ["Wed, 21 Oct 2015 07:28:00 GMT"])
    fun pastRetryAfterDateUsesBoundedBackoff(retryAfter: String) {
        val clock =
            Clock.fixed(
                OffsetDateTime.parse(retryAfter, DateTimeFormatter.RFC_1123_DATE_TIME)
                    .plusSeconds(1)
                    .toInstant(),
                ZoneOffset.UTC,
            )
        val sleeper = RecordingRetrySleeper()
        val client =
            retryingClient(
                sleeper,
                testResponse(503, retryAfterHeaders(retryAfter)),
                testResponse(503),
                clock,
            )

        client.execute(TEST_REQUEST).use { response ->
            assertThat(response.statusCode()).isEqualTo(503)
        }

        assertThat(sleeper.durations).hasSize(1)
        assertThat(sleeper.durations.single())
            .isBetween(Duration.ofMillis(375), Duration.ofMillis(500))
    }

    private fun retryingClient(
        sleeper: RecordingRetrySleeper,
        firstResponse: HttpResponse,
        secondResponse: HttpResponse,
        clock: Clock = FIXED_CLOCK,
    ): HttpClient =
        RetryingHttpClient.builder()
            .httpClient(SequenceHttpClient(firstResponse, secondResponse))
            .sleeper(sleeper)
            .clock(clock)
            .maxRetries(1)
            .build()

    private fun retryAfterHeaders(value: String): Headers =
        Headers.builder().put("Retry-After", value).build()

    companion object {

        private val FIXED_CLOCK = Clock.fixed(Instant.parse("2026-01-01T00:00:00Z"), ZoneOffset.UTC)
        private val MAX_SERVER_DELAY = Duration.ofSeconds(60)
        private val TEST_REQUEST =
            HttpRequest.builder().method(HttpMethod.GET).baseUrl("https://example.com").build()
    }
}
