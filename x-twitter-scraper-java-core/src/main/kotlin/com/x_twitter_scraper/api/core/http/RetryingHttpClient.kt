// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.core.http

import com.x_twitter_scraper.api.core.DefaultSleeper
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.Sleeper
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.errors.XTwitterScraperIoException
import com.x_twitter_scraper.api.errors.XTwitterScraperRetryableException
import java.io.IOException
import java.time.Clock
import java.time.DateTimeException
import java.time.Duration
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.TimeUnit
import java.util.function.Function
import kotlin.math.min
import kotlin.math.pow

class RetryingHttpClient
private constructor(
    private val httpClient: HttpClient,
    private val sleeper: Sleeper,
    private val clock: Clock,
    private val maxRetries: Int,
    private val idempotencyHeader: String?,
) : HttpClient {

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
        var modifiedRequest = maybeAddIdempotencyHeader(request)

        val shouldSendRetryCount =
            !modifiedRequest.headers.names().contains("X-Stainless-Retry-Count")

        var retries = 0

        while (true) {
            if (shouldSendRetryCount) {
                modifiedRequest = setRetryCountHeader(modifiedRequest, retries)
            }

            if (!isRetryable(modifiedRequest)) {
                return httpClient.execute(modifiedRequest, requestOptions)
            }

            val response =
                try {
                    val response = httpClient.execute(modifiedRequest, requestOptions)
                    if (++retries > maxRetries || !shouldRetry(response)) {
                        return response
                    }

                    response
                } catch (throwable: Throwable) {
                    if (++retries > maxRetries || !shouldRetry(throwable)) {
                        throw throwable
                    }

                    null
                }

            val backoffDuration = getRetryBackoffDuration(retries, response)
            response?.close()
            sleeper.sleep(backoffDuration)
        }
    }

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> {
        val modifiedRequest = maybeAddIdempotencyHeader(request)

        val shouldSendRetryCount =
            !modifiedRequest.headers.names().contains("X-Stainless-Retry-Count")

        var retries = 0

        fun executeWithRetries(
            request: HttpRequest,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            val requestWithRetryCount =
                if (shouldSendRetryCount) setRetryCountHeader(request, retries) else request

            val responseFuture = httpClient.executeAsync(requestWithRetryCount, requestOptions)
            if (!isRetryable(requestWithRetryCount)) {
                return responseFuture
            }

            return responseFuture
                .handleAsync(
                    fun(
                        response: HttpResponse?,
                        throwable: Throwable?,
                    ): CompletableFuture<HttpResponse> {
                        if (response != null) {
                            if (++retries > maxRetries || !shouldRetry(response)) {
                                return CompletableFuture.completedFuture(response)
                            }
                        } else {
                            if (++retries > maxRetries || !shouldRetry(throwable!!)) {
                                val failedFuture = CompletableFuture<HttpResponse>()
                                failedFuture.completeExceptionally(throwable)
                                return failedFuture
                            }
                        }

                        val backoffDuration = getRetryBackoffDuration(retries, response)
                        response?.close()
                        return sleeper.sleepAsync(backoffDuration).thenCompose {
                            executeWithRetries(requestWithRetryCount, requestOptions)
                        }
                    }
                ) {
                    it.run()
                }
                .thenCompose(Function.identity())
        }

        return executeWithRetries(modifiedRequest, requestOptions)
    }

    override fun close() {
        httpClient.close()
        sleeper.close()
    }

    private fun isRetryable(request: HttpRequest): Boolean = request.body?.repeatable() ?: true

    private fun setRetryCountHeader(request: HttpRequest, retries: Int): HttpRequest =
        request.toBuilder().replaceHeaders("X-Stainless-Retry-Count", retries.toString()).build()

    private fun idempotencyKey(): String = "xquik-java-retry-${UUID.randomUUID()}"

    private fun maybeAddIdempotencyHeader(request: HttpRequest): HttpRequest {
        if (idempotencyHeader == null || request.headers.names().contains(idempotencyHeader)) {
            return request
        }

        return request.toBuilder().putHeader(idempotencyHeader, idempotencyKey()).build()
    }

    private fun shouldRetry(response: HttpResponse): Boolean {
        val shouldRetryHeader = response.headers().values("X-Should-Retry").getOrNull(0)
        val statusCode = response.statusCode()

        return when {
            shouldRetryHeader == "true" -> true
            shouldRetryHeader == "false" -> false

            statusCode == 408 -> true
            statusCode == 409 -> true
            statusCode == 429 -> true
            statusCode >= 500 -> true
            else -> false
        }
    }

    private fun shouldRetry(throwable: Throwable): Boolean =
        throwable is IOException ||
            throwable is XTwitterScraperIoException ||
            throwable is XTwitterScraperRetryableException

    private fun getRetryBackoffDuration(retries: Int, response: HttpResponse?): Duration {
        response?.headers()?.let { headers ->
            val retryAfterMs =
                headers.values("Retry-After-Ms").getOrNull(0)?.let {
                    parseServerDelay(it, TimeUnit.MILLISECONDS.toNanos(1))
                }
            if (retryAfterMs != null) {
                return retryAfterMs
            }

            val retryAfter =
                headers.values("Retry-After").getOrNull(0)?.let {
                    parseServerDelay(it, TimeUnit.SECONDS.toNanos(1)) ?: parseServerDate(it)
                }
            if (retryAfter != null) {
                return retryAfter
            }
        }

        val backoffSeconds = min(0.5 * 2.0.pow(retries - 1), 8.0)

        val jitter = 1.0 - 0.25 * ThreadLocalRandom.current().nextDouble()

        return Duration.ofNanos((TimeUnit.SECONDS.toNanos(1) * backoffSeconds * jitter).toLong())
    }

    private fun parseServerDelay(value: String, nanosPerUnit: Long): Duration? {
        val amount = value.toDoubleOrNull()?.takeIf { it.isFinite() && it >= 0.0 } ?: return null
        val nanos = min(amount * nanosPerUnit, MAX_SERVER_RETRY_DELAY.toNanos().toDouble())
        return Duration.ofNanos(nanos.toLong())
    }

    private fun parseServerDate(value: String): Duration? =
        try {
            val delay =
                Duration.between(
                    OffsetDateTime.now(clock),
                    OffsetDateTime.parse(value, DateTimeFormatter.RFC_1123_DATE_TIME),
                )
            if (delay.isNegative) null else minOf(delay, MAX_SERVER_RETRY_DELAY)
        } catch (e: DateTimeException) {
            null
        }

    companion object {

        private val MAX_SERVER_RETRY_DELAY: Duration = Duration.ofSeconds(60)

        @JvmStatic fun builder() = Builder()
    }

    class Builder internal constructor() {

        private var httpClient: HttpClient? = null
        private var sleeper: Sleeper? = null
        private var clock: Clock = Clock.systemUTC()
        private var maxRetries: Int = 2
        private var idempotencyHeader: String? = null

        fun httpClient(httpClient: HttpClient) = apply { this.httpClient = httpClient }

        fun sleeper(sleeper: Sleeper) = apply { this.sleeper = sleeper }

        fun clock(clock: Clock) = apply { this.clock = clock }

        fun maxRetries(maxRetries: Int) = apply { this.maxRetries = maxRetries }

        fun idempotencyHeader(header: String) = apply { this.idempotencyHeader = header }

        fun build(): HttpClient =
            RetryingHttpClient(
                checkRequired("httpClient", httpClient),
                sleeper ?: DefaultSleeper(),
                clock,
                maxRetries,
                idempotencyHeader,
            )
    }
}
