// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x.communities

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.communities.tweets.TweetListByCommunityParams
import com.x_twitter_scraper.api.models.x.communities.tweets.TweetListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TweetServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val tweetServiceAsync = client.x().communities().tweets()

        val paginatedTweetsFuture =
            tweetServiceAsync.list(
                TweetListParams.builder().q("q").cursor("cursor").queryType("queryType").build()
            )

        val paginatedTweets = paginatedTweetsFuture.get()
        paginatedTweets.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun listByCommunity() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val tweetServiceAsync = client.x().communities().tweets()

        val paginatedTweetsFuture =
            tweetServiceAsync.listByCommunity(
                TweetListByCommunityParams.builder().id("id").cursor("cursor").build()
            )

        val paginatedTweets = paginatedTweetsFuture.get()
        paginatedTweets.validate()
    }
}
