// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.x

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.x_twitter_scraper.api.client.XTwitterScraperClient
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.ImageFilterSummary
import com.x_twitter_scraper.api.models.PaginatedTweets
import com.x_twitter_scraper.api.models.SearchTweet
import com.x_twitter_scraper.api.models.TopicFilterSummary
import com.x_twitter_scraper.api.models.extractions.ExtractionEstimateCostParams
import com.x_twitter_scraper.api.models.extractions.ExtractionRunParams
import com.x_twitter_scraper.api.models.x.media.MediaDownloadParams
import com.x_twitter_scraper.api.models.x.tweets.TweetSearchParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveMediaParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveRepliesParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveTweetsParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ImageAndTopicFilterTest {

    private lateinit var client: XTwitterScraperClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .responseValidation(true)
                .build()
    }

    @Test
    fun searchSendsTheTopicAndReadsTheTopicFilteredPage() {
        stubFor(get(urlPathEqualTo("/x/tweets/search")).willReturn(okJson(topicPage)))

        val page =
            client
                .x()
                .tweets()
                .search(
                    TweetSearchParams.builder()
                        .q("rust")
                        .topic("the Rust programming language")
                        .build()
                )
                .asPaginatedTweets()

        verify(
            getRequestedFor(urlPathEqualTo("/x/tweets/search"))
                .withQueryParam("topic", equalTo("the Rust programming language"))
        )
        val filter = page.topicFilter().get()
        assertThat(filter.topic()).isEqualTo("the Rust programming language")
        assertThat(filter.question()).isEqualTo("Is this post about the Rust programming language?")
        assertThat(filter.cutoff()).isEqualTo(0.5)
        assertThat(filter.checked()).isEqualTo(20L)
        assertThat(filter.kept()).isEqualTo(1L)
        assertThat(filter.unchecked().single().id()).isEqualTo("1002")
        assertThat(filter.unchecked().single().reason()).isEqualTo("no_answer")
        assertThat(page.imageFilter()).isEmpty
        assertThat(page.tweets().single().topicScore()).contains(0.92)
        assertThat(page.tweets().single().imageScore()).isEmpty
    }

    @Test
    fun userReadsSendTheFiltersAndReadTheFilteredPages() {
        stubFor(get(urlPathEqualTo("/x/users/44196397/tweets")).willReturn(okJson(topicPage)))
        stubFor(get(urlPathEqualTo("/x/users/44196397/replies")).willReturn(okJson(imagePage)))
        stubFor(get(urlPathEqualTo("/x/users/44196397/media")).willReturn(okJson(imagePage)))

        val tweets =
            client
                .x()
                .users()
                .retrieveTweets(
                    UserRetrieveTweetsParams.builder()
                        .id("44196397")
                        .topic("the Rust programming language")
                        .build()
                )
        val replies =
            client
                .x()
                .users()
                .retrieveReplies(
                    UserRetrieveRepliesParams.builder().id("44196397").imageShows("charts").build()
                )
        val media =
            client
                .x()
                .users()
                .retrieveMedia(
                    UserRetrieveMediaParams.builder().id("44196397").imageShows("charts").build()
                )

        verify(
            getRequestedFor(urlPathEqualTo("/x/users/44196397/tweets"))
                .withQueryParam("topic", equalTo("the Rust programming language"))
        )
        verify(
            getRequestedFor(urlPathEqualTo("/x/users/44196397/replies"))
                .withQueryParam("imageShows", equalTo("charts"))
        )
        verify(
            getRequestedFor(urlPathEqualTo("/x/users/44196397/media"))
                .withQueryParam("imageShows", equalTo("charts"))
        )
        assertThat(tweets.topicFilter().get().kept()).isEqualTo(1L)
        assertThat(tweets.tweets().single().topicScore()).contains(0.92)
        for (page in listOf(replies, media)) {
            val filter = page.imageFilter().get()
            assertThat(filter.imageShows()).isEqualTo("charts")
            assertThat(filter.checked()).isEqualTo(16L)
            assertThat(filter.kept()).isEqualTo(1L)
            assertThat(filter.unchecked().single().reason()).isEqualTo("no_safe_photos")
            assertThat(page.topicFilter()).isEmpty
            assertThat(page.tweets().single().imageScore()).contains(0.81)
        }
    }

    @Test
    fun extractionRequestsSendTheFilters() {
        stubFor(post(urlPathEqualTo("/extractions")).willReturn(okJson("{}")))
        stubFor(post(urlPathEqualTo("/extractions/estimate")).willReturn(okJson("{}")))

        client
            .extractions()
            .withRawResponse()
            .run(
                ExtractionRunParams.builder()
                    .toolType(ExtractionRunParams.ToolType.TWEET_SEARCH_EXTRACTOR)
                    .searchQuery("rust")
                    .topic("the Rust programming language")
                    .build()
            )
            .close()
        client
            .extractions()
            .withRawResponse()
            .estimateCost(
                ExtractionEstimateCostParams.builder()
                    .toolType(ExtractionEstimateCostParams.ToolType.TWEET_SEARCH_EXTRACTOR)
                    .searchQuery("rust")
                    .imageShows("charts")
                    .build()
            )
            .close()

        verify(
            postRequestedFor(urlPathEqualTo("/extractions"))
                .withRequestBody(
                    matchingJsonPath("$.topic", equalTo("the Rust programming language"))
                )
        )
        verify(
            postRequestedFor(urlPathEqualTo("/extractions/estimate"))
                .withRequestBody(matchingJsonPath("$.imageShows", equalTo("charts")))
        )
    }

    @Test
    fun extractionJobsReadTheirFilters() {
        stubFor(
            get(urlPathEqualTo("/extractions/ex1"))
                .willReturn(
                    okJson(
                        """{"hasMore":false,"results":[],"job":{"id":"ex1","topicFilter":$topicFilter}}"""
                    )
                )
        )
        stubFor(
            get(urlPathEqualTo("/extractions"))
                .willReturn(
                    okJson(
                        """
                        {
                          "hasMore": false,
                          "extractions": [
                            {
                              "id": "ex2",
                              "createdAt": "2026-11-07T23:00:00Z",
                              "status": "completed",
                              "toolType": "tweet_search_extractor",
                              "totalResults": 1,
                              "url": "https://example.com/extractions/ex2",
                              "imageFilter": $imageFilter
                            }
                          ]
                        }
                        """
                    )
                )
        )

        val job = client.extractions().retrieve("ex1").job()
        val listed = client.extractions().list().extractions().single()

        assertThat(job.topicFilter().get().topic()).isEqualTo("the Rust programming language")
        assertThat(job.imageFilter()).isEmpty
        assertThat(listed.imageFilter().get().imageShows()).isEqualTo("charts")
        assertThat(listed.topicFilter()).isEmpty
    }

    @Test
    fun mediaDownloadSendsImageShowsAndReadsTheImageFilter() {
        stubFor(
            post(urlPathEqualTo("/x/media/download"))
                .willReturn(okJson("""{"tweetId":"1001","imageFilter":$imageFilter}"""))
        )

        val response =
            client
                .x()
                .media()
                .download(
                    MediaDownloadParams.builder()
                        .tweetInput("https://x.com/rustlang/status/1001")
                        .imageShows("charts")
                        .build()
                )

        verify(
            postRequestedFor(urlPathEqualTo("/x/media/download"))
                .withRequestBody(matchingJsonPath("$.imageShows", equalTo("charts")))
        )
        assertThat(response.imageFilter().get().kept()).isEqualTo(1L)
        assertThat(response.imageFilter().get().question())
            .isEqualTo("Does a picture attached to this post show a chart?")
    }

    @Test
    fun builtFilteredPagesRoundtrip() {
        val jsonMapper = jsonMapper()
        val topic =
            TopicFilterSummary.builder()
                .topic("the Rust programming language")
                .question("Is this post about the Rust programming language?")
                .cutoff(0.5)
                .checked(20L)
                .kept(1L)
                .addUnchecked(
                    TopicFilterSummary.Unchecked.builder().id("1002").reason("no_answer").build()
                )
                .build()
        val image =
            ImageFilterSummary.builder()
                .imageShows("charts")
                .question("Does a picture attached to this post show a chart?")
                .cutoff(0.5)
                .checked(16L)
                .kept(1L)
                .addUnchecked(
                    ImageFilterSummary.Unchecked.builder()
                        .id("1003")
                        .reason("no_safe_photos")
                        .build()
                )
                .build()
        val page =
            PaginatedTweets.builder()
                .hasNextPage(true)
                .nextCursor("cursor-2")
                .addTweet(
                    SearchTweet.builder()
                        .id("1001")
                        .bookmarkCount(0L)
                        .likeCount(3L)
                        .quoteCount(0L)
                        .replyCount(1L)
                        .retweetCount(0L)
                        .text("Rust 1.91 is out")
                        .viewCount(40L)
                        .topicScore(0.92)
                        .imageScore(0.81)
                        .build()
                )
                .topicFilter(topic)
                .imageFilter(image)
                .build()

        val roundtripped =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(page),
                jacksonTypeRef<PaginatedTweets>(),
            )

        assertThat(roundtripped).isEqualTo(page)
        assertThat(roundtripped.toBuilder().build()).isEqualTo(page)
        assertThat(roundtripped.topicFilter()).contains(topic)
        assertThat(roundtripped.imageFilter()).contains(image)
        assertThat(roundtripped.tweets().single().topicScore()).contains(0.92)
        assertThat(roundtripped.tweets().single().imageScore()).contains(0.81)
        assertThat(roundtripped.isValid()).isTrue()
    }

    private val tweet =
        """{"id":"1001","text":"Rust 1.91 is out","likeCount":3,"retweetCount":0,"replyCount":1,"quoteCount":0,"viewCount":40,"bookmarkCount":0"""

    private val topicFilter =
        """{"topic":"the Rust programming language","question":"Is this post about the Rust programming language?","cutoff":0.5,"checked":20,"kept":1,"unchecked":[{"id":"1002","reason":"no_answer"}]}"""

    private val imageFilter =
        """{"imageShows":"charts","question":"Does a picture attached to this post show a chart?","cutoff":0.5,"checked":16,"kept":1,"unchecked":[{"id":"1003","reason":"no_safe_photos"}]}"""

    private val topicPage =
        """{"tweets":[$tweet,"topicScore":0.92}],"has_next_page":true,"next_cursor":"cursor-2","topicFilter":$topicFilter}"""

    private val imagePage =
        """{"tweets":[$tweet,"imageScore":0.81}],"has_next_page":true,"next_cursor":"cursor-2","imageFilter":$imageFilter}"""
}
