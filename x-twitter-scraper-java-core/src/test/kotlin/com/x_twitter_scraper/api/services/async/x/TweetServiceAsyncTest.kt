// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.tweets.TweetCreateParams
import com.x_twitter_scraper.api.models.x.tweets.TweetDeleteParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetFavoritersParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetQuotesParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetRepliesParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetRetweetersParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetThreadParams
import com.x_twitter_scraper.api.models.x.tweets.TweetListParams
import com.x_twitter_scraper.api.models.x.tweets.TweetSearchParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TweetServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val tweetServiceAsync = client.x().tweets()

        val tweetFuture =
            tweetServiceAsync.create(
                TweetCreateParams.builder()
                    .account("@elonmusk")
                    .attachmentUrl("https://x.com/elonmusk/status/1234567890")
                    .communityId("1500000000000000000")
                    .isNoteTweet(false)
                    .addMedia("https://example.com/image.jpg")
                    .addMediaId("1234567890123456789")
                    .replyToTweetId("1234567890")
                    .text("Just launched our new feature!")
                    .build()
            )

        val tweet = tweetFuture.get()
        tweet.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val tweetServiceAsync = client.x().tweets()

        val tweetFuture = tweetServiceAsync.retrieve("id")

        val tweet = tweetFuture.get()
        tweet.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val tweetServiceAsync = client.x().tweets()

        val paginatedTweetsFuture =
            tweetServiceAsync.list(TweetListParams.builder().ids("ids").build())

        val paginatedTweets = paginatedTweetsFuture.get()
        paginatedTweets.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val tweetServiceAsync = client.x().tweets()

        val tweetFuture =
            tweetServiceAsync.delete(
                TweetDeleteParams.builder().id("id").account("@elonmusk").build()
            )

        val tweet = tweetFuture.get()
        tweet.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun getFavoriters() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val tweetServiceAsync = client.x().tweets()

        val paginatedUsersFuture =
            tweetServiceAsync.getFavoriters(
                TweetGetFavoritersParams.builder().id("id").cursor("cursor").build()
            )

        val paginatedUsers = paginatedUsersFuture.get()
        paginatedUsers.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun getQuotes() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val tweetServiceAsync = client.x().tweets()

        val paginatedTweetsFuture =
            tweetServiceAsync.getQuotes(
                TweetGetQuotesParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .includeReplies(true)
                    .sinceTime("sinceTime")
                    .untilTime("untilTime")
                    .build()
            )

        val paginatedTweets = paginatedTweetsFuture.get()
        paginatedTweets.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun getReplies() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val tweetServiceAsync = client.x().tweets()

        val paginatedTweetsFuture =
            tweetServiceAsync.getReplies(
                TweetGetRepliesParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .sinceTime("sinceTime")
                    .untilTime("untilTime")
                    .build()
            )

        val paginatedTweets = paginatedTweetsFuture.get()
        paginatedTweets.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun getRetweeters() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val tweetServiceAsync = client.x().tweets()

        val paginatedUsersFuture =
            tweetServiceAsync.getRetweeters(
                TweetGetRetweetersParams.builder().id("id").cursor("cursor").build()
            )

        val paginatedUsers = paginatedUsersFuture.get()
        paginatedUsers.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun getThread() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val tweetServiceAsync = client.x().tweets()

        val paginatedTweetsFuture =
            tweetServiceAsync.getThread(
                TweetGetThreadParams.builder().id("id").cursor("cursor").build()
            )

        val paginatedTweets = paginatedTweetsFuture.get()
        paginatedTweets.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun search() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val tweetServiceAsync = client.x().tweets()

        val paginatedTweetsFuture =
            tweetServiceAsync.search(
                TweetSearchParams.builder()
                    .q("q")
                    .cursor("cursor")
                    .limit(200L)
                    .queryType(TweetSearchParams.QueryType.LATEST)
                    .sinceTime("sinceTime")
                    .untilTime("untilTime")
                    .build()
            )

        val paginatedTweets = paginatedTweetsFuture.get()
        paginatedTweets.validate()
    }
}
