// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.x_twitter_scraper.api.client.XTwitterScraperClient
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.account.AccountRetrieveParams
import com.x_twitter_scraper.api.models.x.tweets.TweetSearchParams
import java.time.LocalDate
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ServiceParamsTest {

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

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val accountService = client.account()
        stubFor(get(anyUrl()).willReturn(ok("{}")))

        accountService.retrieve(
            AccountRetrieveParams.builder()
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .build()
        )

        verify(
            getRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
        )
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun search() {
        val tweetService = client.x().tweets()
        stubFor(get(anyUrl()).willReturn(ok("{}")))

        tweetService.search(
            TweetSearchParams.builder()
                .q("q")
                .advancedQuery("advancedQuery")
                .anyWords("anyWords")
                .blueVerifiedOnly(true)
                .boundingBox("boundingBox")
                .cardName("cardName")
                .cashtags("cashtags")
                .conversationId("conversationId")
                .cursor("cursor")
                .exactPhrase("exactPhrase")
                .excludeSource("excludeSource")
                .excludeWords("excludeWords")
                .fromUser("fromUser")
                .geocode("geocode")
                .hashtags("hashtags")
                .inReplyToTweetId("inReplyToTweetId")
                .language("language")
                .limit(1L)
                .listId("listId")
                .maxFaves(0L)
                .maxId("maxId")
                .maxQuotes(0L)
                .maxReplies(0L)
                .maxRetweets(0L)
                .mediaType(TweetSearchParams.MediaType.IMAGES)
                .mentioning("mentioning")
                .minBookmarks(0L)
                .minFaves(0L)
                .minQuotes(0L)
                .minReplies(0L)
                .minRetweets(0L)
                .minViews(0L)
                .mode(TweetSearchParams.Mode.STANDARD)
                .nativeRetweets(true)
                .near("near")
                .news(true)
                .place("place")
                .placeCountry("placeCountry")
                .pointRadius("pointRadius")
                .queryType(TweetSearchParams.QueryType.LATEST)
                .quotes(TweetSearchParams.Quotes.INCLUDE)
                .quotesOfTweetId("quotesOfTweetId")
                .replies(TweetSearchParams.Replies.INCLUDE)
                .retweets(TweetSearchParams.Retweets.INCLUDE)
                .retweetsOfTweetId("retweetsOfTweetId")
                .safe(true)
                .sinceDate(LocalDate.parse("2019-12-27"))
                .sinceId("sinceId")
                .sinceTime("sinceTime")
                .source("source")
                .toUser("toUser")
                .untilDate(LocalDate.parse("2019-12-27"))
                .untilTime("untilTime")
                .url("url")
                .verifiedOnly(true)
                .within("within")
                .withinTime("withinTime")
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .build()
        )

        verify(
            getRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
        )
    }
}
