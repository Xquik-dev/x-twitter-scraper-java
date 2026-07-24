// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x.communities

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.communities.tweets.TweetListByCommunityParams
import com.x_twitter_scraper.api.models.x.communities.tweets.TweetListParams
import org.junit.jupiter.api.Test

internal class TweetServiceTest {
    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val tweetService = client.x().communities().tweets()

        val paginatedTweets =
            tweetService.list(
                TweetListParams.builder()
                    .communityId("321669910225")
                    .q("q")
                    .cursor("cursor")
                    .pageSize(1L)
                    .queryType(TweetListParams.QueryType.LATEST)
                    .build()
            )

        kotlin.test.assertNotNull(paginatedTweets)
    }

    @Test
    fun listByCommunity() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val tweetService = client.x().communities().tweets()

        val paginatedTweets =
            tweetService.listByCommunity(
                TweetListByCommunityParams.builder().id("id").cursor("cursor").pageSize(1L).build()
            )

        kotlin.test.assertNotNull(paginatedTweets)
    }
}
