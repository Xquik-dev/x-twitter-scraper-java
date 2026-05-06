// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x.communities

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.communities.tweets.TweetListByCommunityParams
import com.x_twitter_scraper.api.models.x.communities.tweets.TweetListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TweetServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val tweetService = client.x().communities().tweets()

        val paginatedTweets =
            tweetService.list(
                TweetListParams.builder().q("q").cursor("cursor").queryType("queryType").build()
            )

        paginatedTweets.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun listByCommunity() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val tweetService = client.x().communities().tweets()

        val paginatedTweets =
            tweetService.listByCommunity(
                TweetListByCommunityParams.builder().id("id").cursor("cursor").build()
            )

        paginatedTweets.validate()
    }
}
