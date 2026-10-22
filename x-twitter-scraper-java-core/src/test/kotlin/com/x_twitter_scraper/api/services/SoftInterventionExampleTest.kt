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
import com.x_twitter_scraper.api.models.SoftIntervention
import java.util.Optional
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class SoftInterventionExampleTest {

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
    fun listedPostsAndTheirEmbeddedPostsReturnTheLabel() {
        stubFor(
            get(urlPathEqualTo("/x/tweets/top"))
                .willReturn(
                    okJson(
                        """{"tweets":[$labeledPost,${post("2102761519985332444")}],"has_next_page":false,"next_cursor":""}"""
                    )
                )
        )

        val responses =
            listOf(client.x().tweets().listTop(), asyncClient.x().tweets().listTop().get())

        responses.forEach { response ->
            val post = response.tweets()[0]
            assertLabel(post.softIntervention())
            assertLabel(post.parentTweet().flatMap { it.softIntervention() })
            assertLabel(post.quotedTweet().flatMap { it.softIntervention() })
            assertLabel(post.retweetedTweet().flatMap { it.softIntervention() })
            assertThat(response.tweets()[1].softIntervention()).isEmpty
        }
    }

    @Test
    fun postDetailAndItsEmbeddedPostsReturnTheLabel() {
        stubFor(
            get(urlPathEqualTo("/x/tweets/2102761519985332442"))
                .willReturn(okJson("""{"tweet":$labeledPost}"""))
        )

        val responses =
            listOf(
                client.x().tweets().retrieve("2102761519985332442"),
                asyncClient.x().tweets().retrieve("2102761519985332442").get(),
            )

        responses.forEach { response ->
            val post = response.tweet()
            assertLabel(post.softIntervention())
            assertLabel(post.parentTweet().flatMap { it.softIntervention() })
            assertLabel(post.quotedTweet().flatMap { it.softIntervention() })
            assertLabel(post.retweetedTweet().flatMap { it.softIntervention() })
        }
    }

    private fun assertLabel(label: Optional<SoftIntervention>) {
        val soft = label.orElseThrow()
        assertThat(soft.displayType()).hasValue("Fosnr")
        assertThat(soft.engagementNudge()).hasValue(true)
        val text = soft.text().orElseThrow()
        assertThat(text.text()).hasValue("This Post may violate X's rules against Abuse.")
        assertThat(text.rtl()).hasValue(false)
        val entities = text.entities().orElseThrow()
        assertThat(entities).hasSize(1)
        assertThat(entities[0].fromIndex()).hasValue(40L)
        assertThat(entities[0].toIndex()).hasValue(45L)
        val ref = entities[0].ref().orElseThrow()
        assertThat(ref.type()).hasValue("TimelineUrl")
        assertThat(ref.url()).hasValue("https://help.x.com/rules-and-policies/public-interest")
        assertThat(ref.urlType()).hasValue("ExternalUrl")
        val url = soft.url().orElseThrow()
        assertThat(url.url()).hasValue("https://help.x.com/rules-and-policies/enforcement-options")
        assertThat(url.urlType()).hasValue("ExternalUrl")
    }

    private fun post(id: String, vararg fields: Pair<String, String>): String {
        val extra = fields.joinToString("") { (name, value) -> ",\"$name\":$value" }
        return """{"id":"$id","text":"A post.","bookmarkCount":0,"likeCount":3,"quoteCount":0,"replyCount":1,"retweetCount":0,"viewCount":120$extra}"""
    }

    private val label =
        """
        {
          "displayType": "Fosnr",
          "engagementNudge": true,
          "text": {
            "text": "This Post may violate X's rules against Abuse.",
            "rtl": false,
            "entities": [
              {
                "fromIndex": 40,
                "toIndex": 45,
                "ref": {
                  "type": "TimelineUrl",
                  "url": "https://help.x.com/rules-and-policies/public-interest",
                  "urlType": "ExternalUrl"
                }
              }
            ]
          },
          "url": {
            "url": "https://help.x.com/rules-and-policies/enforcement-options",
            "urlType": "ExternalUrl"
          }
        }
        """

    private val labeledPost =
        post(
            "2102761519985332442",
            "softIntervention" to label,
            "parentTweet" to post("2102761519985332440", "softIntervention" to label),
            "quoted_tweet" to post("2102761519985332441", "softIntervention" to label),
            "retweeted_tweet" to post("2102761519985332443", "softIntervention" to label),
        )
}
