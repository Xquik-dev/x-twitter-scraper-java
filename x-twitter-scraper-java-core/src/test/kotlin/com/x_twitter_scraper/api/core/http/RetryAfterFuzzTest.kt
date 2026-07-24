package com.x_twitter_scraper.api.core.http

import com.code_intelligence.jazzer.api.FuzzedDataProvider
import com.code_intelligence.jazzer.junit.FuzzTest
import java.time.Clock
import java.time.Duration
import java.time.Instant
import java.time.ZoneOffset
import org.assertj.core.api.Assertions.assertThat

internal class RetryAfterFuzzTest {

    @FuzzTest(maxDuration = "30s")
    fun retryAfterDelayRemainsBounded(data: FuzzedDataProvider) {
        val retryAfter = data.consumeRemainingAsString()
        val sleeper = RecordingRetrySleeper()
        val transport =
            SequenceHttpClient(
                testResponse(
                    statusCode = 503,
                    headers = Headers.builder().put("Retry-After", retryAfter).build(),
                ),
                testResponse(statusCode = 200),
            )
        val retryingClient =
            RetryingHttpClient.builder()
                .httpClient(transport)
                .sleeper(sleeper)
                .clock(Clock.fixed(Instant.parse("2026-01-01T00:00:00Z"), ZoneOffset.UTC))
                .maxRetries(1)
                .build()
        val request =
            HttpRequest.builder().method(HttpMethod.GET).baseUrl("https://example.com").build()

        retryingClient.execute(request).use { response ->
            assertThat(response.statusCode()).isEqualTo(200)
        }

        assertThat(sleeper.durations).hasSize(1)
        assertThat(sleeper.durations.single()).isBetween(Duration.ZERO, Duration.ofSeconds(60))
    }
}
