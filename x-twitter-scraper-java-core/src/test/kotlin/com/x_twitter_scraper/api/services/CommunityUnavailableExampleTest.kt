// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services

import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.x_twitter_scraper.api.client.XTwitterScraperClient
import com.x_twitter_scraper.api.client.XTwitterScraperClientAsync
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.CommunityUnavailable
import java.util.Optional
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class CommunityUnavailableExampleTest {

    private lateinit var client: XTwitterScraperClient
    private lateinit var asyncClient: XTwitterScraperClientAsync

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .responseValidation(true)
                .build()
        asyncClient =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .responseValidation(true)
                .build()
    }

    @Test
    fun listedPostsAndTheirEmbeddedPostsReturnTheReason() {
        stubFor(
            get(urlPathEqualTo("/x/tweets/top"))
                .willReturn(
                    okJson(
                        """{"tweets":[$withheldPost,${post("2102761519985332444")}],"has_next_page":false,"next_cursor":""}"""
                    )
                )
        )

        val responses =
            listOf(client.x().tweets().listTop(), asyncClient.x().tweets().listTop().get())

        responses.forEach { response ->
            val post = response.tweets()[0]
            assertReason(post.communityUnavailable())
            assertReason(post.parentTweet().flatMap { it.communityUnavailable() })
            assertReason(post.quotedTweet().flatMap { it.communityUnavailable() })
            assertReason(post.retweetedTweet().flatMap { it.communityUnavailable() })
            assertThat(response.tweets()[1].communityUnavailable()).isEmpty
        }
    }

    @Test
    fun postDetailAndItsEmbeddedPostsReturnTheReason() {
        stubFor(
            get(urlPathEqualTo("/x/tweets/2102761519985332442"))
                .willReturn(okJson("""{"tweet":$withheldPost}"""))
        )

        val responses =
            listOf(
                client.x().tweets().retrieve("2102761519985332442"),
                asyncClient.x().tweets().retrieve("2102761519985332442").get(),
            )

        responses.forEach { response ->
            val post = response.tweet()
            assertReason(post.communityUnavailable())
            assertReason(post.parentTweet().flatMap { it.communityUnavailable() })
            assertReason(post.quotedTweet().flatMap { it.communityUnavailable() })
            assertReason(post.retweetedTweet().flatMap { it.communityUnavailable() })
        }
    }

    @Test
    fun eventPostsReturnTheReason() {
        val event =
            """{"id":"42","type":"tweet.new","monitorId":"7","monitorType":"account","occurredAt":"2025-01-15T12:00:00.000Z","data":{"id":"2102761519985332442","communityUnavailable":$reason}}"""
        val page = """{"events":[$event],"hasMore":false}"""
        stubFor(get(urlPathEqualTo("/events")).willReturn(okJson(page)))
        stubFor(get(urlPathEqualTo("/events/42")).willReturn(okJson(event)))

        val listed = listOf(client.events().list(), asyncClient.events().list().get())
        val details =
            listOf(client.events().retrieve("42"), asyncClient.events().retrieve("42").get())

        listed.forEach { assertReason(it.events()[0].data().communityUnavailable()) }
        details.forEach { assertReason(it.data().communityUnavailable()) }
    }

    private fun assertReason(unavailable: Optional<CommunityUnavailable>) {
        assertThat(unavailable.orElseThrow().reason()).isEqualTo("Unauthorized")
    }

    private fun post(id: String, vararg fields: Pair<String, String>): String {
        val extra = fields.joinToString("") { (name, value) -> ",\"$name\":$value" }
        return """{"id":"$id","text":"A post.","bookmarkCount":0,"likeCount":3,"quoteCount":0,"replyCount":1,"retweetCount":0,"viewCount":120$extra}"""
    }

    private val reason = """{"reason":"Unauthorized"}"""

    private val withheldPost =
        post(
            "2102761519985332442",
            "communityUnavailable" to reason,
            "parentTweet" to post("2102761519985332440", "communityUnavailable" to reason),
            "quoted_tweet" to post("2102761519985332441", "communityUnavailable" to reason),
            "retweeted_tweet" to post("2102761519985332443", "communityUnavailable" to reason),
        )
}
