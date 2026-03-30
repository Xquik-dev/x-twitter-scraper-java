// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.x_twitter_scraper.api.client.XTwitterScraperClient
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.errors.BadRequestException
import com.x_twitter_scraper.api.errors.InternalServerException
import com.x_twitter_scraper.api.errors.NotFoundException
import com.x_twitter_scraper.api.errors.PermissionDeniedException
import com.x_twitter_scraper.api.errors.RateLimitException
import com.x_twitter_scraper.api.errors.UnauthorizedException
import com.x_twitter_scraper.api.errors.UnexpectedStatusCodeException
import com.x_twitter_scraper.api.errors.UnprocessableEntityException
import com.x_twitter_scraper.api.errors.XTwitterScraperException
import com.x_twitter_scraper.api.models.x.tweets.TweetSearchParams
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ErrorHandlingTest {

    companion object {

        private val ERROR_JSON: JsonValue = JsonValue.from(mapOf("errorProperty" to "42"))

        private val ERROR_JSON_BYTES: ByteArray = jsonMapper().writeValueAsBytes(ERROR_JSON)

        private const val HEADER_NAME: String = "Error-Header"

        private const val HEADER_VALUE: String = "42"

        private const val NOT_JSON: String = "Not JSON"
    }

    private lateinit var client: XTwitterScraperClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
    }

    @Test
    fun tweetsSearch400() {
        val tweetService = client.x().tweets()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
                tweetService.search(
                    TweetSearchParams.builder()
                        .q("q")
                        .cursor("cursor")
                        .limit(200L)
                        .queryType(TweetSearchParams.QueryType.LATEST)
                        .sinceTime("sinceTime")
                        .untilTime("untilTime")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun tweetsSearch400WithRawResponse() {
        val tweetService = client.x().tweets().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
                tweetService.search(
                    TweetSearchParams.builder()
                        .q("q")
                        .cursor("cursor")
                        .limit(200L)
                        .queryType(TweetSearchParams.QueryType.LATEST)
                        .sinceTime("sinceTime")
                        .untilTime("untilTime")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun tweetsSearch401() {
        val tweetService = client.x().tweets()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
                tweetService.search(
                    TweetSearchParams.builder()
                        .q("q")
                        .cursor("cursor")
                        .limit(200L)
                        .queryType(TweetSearchParams.QueryType.LATEST)
                        .sinceTime("sinceTime")
                        .untilTime("untilTime")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun tweetsSearch401WithRawResponse() {
        val tweetService = client.x().tweets().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
                tweetService.search(
                    TweetSearchParams.builder()
                        .q("q")
                        .cursor("cursor")
                        .limit(200L)
                        .queryType(TweetSearchParams.QueryType.LATEST)
                        .sinceTime("sinceTime")
                        .untilTime("untilTime")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun tweetsSearch403() {
        val tweetService = client.x().tweets()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
                tweetService.search(
                    TweetSearchParams.builder()
                        .q("q")
                        .cursor("cursor")
                        .limit(200L)
                        .queryType(TweetSearchParams.QueryType.LATEST)
                        .sinceTime("sinceTime")
                        .untilTime("untilTime")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun tweetsSearch403WithRawResponse() {
        val tweetService = client.x().tweets().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
                tweetService.search(
                    TweetSearchParams.builder()
                        .q("q")
                        .cursor("cursor")
                        .limit(200L)
                        .queryType(TweetSearchParams.QueryType.LATEST)
                        .sinceTime("sinceTime")
                        .untilTime("untilTime")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun tweetsSearch404() {
        val tweetService = client.x().tweets()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
                tweetService.search(
                    TweetSearchParams.builder()
                        .q("q")
                        .cursor("cursor")
                        .limit(200L)
                        .queryType(TweetSearchParams.QueryType.LATEST)
                        .sinceTime("sinceTime")
                        .untilTime("untilTime")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun tweetsSearch404WithRawResponse() {
        val tweetService = client.x().tweets().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
                tweetService.search(
                    TweetSearchParams.builder()
                        .q("q")
                        .cursor("cursor")
                        .limit(200L)
                        .queryType(TweetSearchParams.QueryType.LATEST)
                        .sinceTime("sinceTime")
                        .untilTime("untilTime")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun tweetsSearch422() {
        val tweetService = client.x().tweets()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                tweetService.search(
                    TweetSearchParams.builder()
                        .q("q")
                        .cursor("cursor")
                        .limit(200L)
                        .queryType(TweetSearchParams.QueryType.LATEST)
                        .sinceTime("sinceTime")
                        .untilTime("untilTime")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun tweetsSearch422WithRawResponse() {
        val tweetService = client.x().tweets().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                tweetService.search(
                    TweetSearchParams.builder()
                        .q("q")
                        .cursor("cursor")
                        .limit(200L)
                        .queryType(TweetSearchParams.QueryType.LATEST)
                        .sinceTime("sinceTime")
                        .untilTime("untilTime")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun tweetsSearch429() {
        val tweetService = client.x().tweets()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
                tweetService.search(
                    TweetSearchParams.builder()
                        .q("q")
                        .cursor("cursor")
                        .limit(200L)
                        .queryType(TweetSearchParams.QueryType.LATEST)
                        .sinceTime("sinceTime")
                        .untilTime("untilTime")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun tweetsSearch429WithRawResponse() {
        val tweetService = client.x().tweets().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
                tweetService.search(
                    TweetSearchParams.builder()
                        .q("q")
                        .cursor("cursor")
                        .limit(200L)
                        .queryType(TweetSearchParams.QueryType.LATEST)
                        .sinceTime("sinceTime")
                        .untilTime("untilTime")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun tweetsSearch500() {
        val tweetService = client.x().tweets()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
                tweetService.search(
                    TweetSearchParams.builder()
                        .q("q")
                        .cursor("cursor")
                        .limit(200L)
                        .queryType(TweetSearchParams.QueryType.LATEST)
                        .sinceTime("sinceTime")
                        .untilTime("untilTime")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun tweetsSearch500WithRawResponse() {
        val tweetService = client.x().tweets().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
                tweetService.search(
                    TweetSearchParams.builder()
                        .q("q")
                        .cursor("cursor")
                        .limit(200L)
                        .queryType(TweetSearchParams.QueryType.LATEST)
                        .sinceTime("sinceTime")
                        .untilTime("untilTime")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun tweetsSearch999() {
        val tweetService = client.x().tweets()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                tweetService.search(
                    TweetSearchParams.builder()
                        .q("q")
                        .cursor("cursor")
                        .limit(200L)
                        .queryType(TweetSearchParams.QueryType.LATEST)
                        .sinceTime("sinceTime")
                        .untilTime("untilTime")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun tweetsSearch999WithRawResponse() {
        val tweetService = client.x().tweets().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                tweetService.search(
                    TweetSearchParams.builder()
                        .q("q")
                        .cursor("cursor")
                        .limit(200L)
                        .queryType(TweetSearchParams.QueryType.LATEST)
                        .sinceTime("sinceTime")
                        .untilTime("untilTime")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun tweetsSearchInvalidJsonBody() {
        val tweetService = client.x().tweets()
        stubFor(
            get(anyUrl())
                .willReturn(status(200).withHeader(HEADER_NAME, HEADER_VALUE).withBody(NOT_JSON))
        )

        val e =
            assertThrows<XTwitterScraperException> {
                tweetService.search(
                    TweetSearchParams.builder()
                        .q("q")
                        .cursor("cursor")
                        .limit(200L)
                        .queryType(TweetSearchParams.QueryType.LATEST)
                        .sinceTime("sinceTime")
                        .untilTime("untilTime")
                        .build()
                )
            }

        assertThat(e).hasMessage("Error reading response")
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
