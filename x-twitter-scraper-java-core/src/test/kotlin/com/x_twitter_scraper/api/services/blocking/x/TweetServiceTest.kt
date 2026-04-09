// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
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

internal class TweetServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val tweetService = client.x().tweets()

        val tweet =
            tweetService.create(
                TweetCreateParams.builder()
                    .account("@elonmusk")
                    .text("Just launched our new feature!")
                    .attachmentUrl("https://x.com/elonmusk/status/1234567890")
                    .communityId("1500000000000000000")
                    .isNoteTweet(false)
                    .addMediaId("1234567890123456789")
                    .replyToTweetId("1234567890")
                    .build()
            )

        tweet.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val tweetService = client.x().tweets()

        val tweet = tweetService.retrieve("id")

        tweet.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val tweetService = client.x().tweets()

        val paginatedTweets = tweetService.list(TweetListParams.builder().ids("ids").build())

        paginatedTweets.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val tweetService = client.x().tweets()

        val tweet =
            tweetService.delete(TweetDeleteParams.builder().id("id").account("@elonmusk").build())

        tweet.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun getFavoriters() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val tweetService = client.x().tweets()

        val paginatedUsers =
            tweetService.getFavoriters(
                TweetGetFavoritersParams.builder().id("id").cursor("cursor").build()
            )

        paginatedUsers.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun getQuotes() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val tweetService = client.x().tweets()

        val paginatedTweets =
            tweetService.getQuotes(
                TweetGetQuotesParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .includeReplies(true)
                    .sinceTime("sinceTime")
                    .untilTime("untilTime")
                    .build()
            )

        paginatedTweets.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun getReplies() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val tweetService = client.x().tweets()

        val paginatedTweets =
            tweetService.getReplies(
                TweetGetRepliesParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .sinceTime("sinceTime")
                    .untilTime("untilTime")
                    .build()
            )

        paginatedTweets.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun getRetweeters() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val tweetService = client.x().tweets()

        val paginatedUsers =
            tweetService.getRetweeters(
                TweetGetRetweetersParams.builder().id("id").cursor("cursor").build()
            )

        paginatedUsers.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun getThread() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val tweetService = client.x().tweets()

        val paginatedTweets =
            tweetService.getThread(TweetGetThreadParams.builder().id("id").cursor("cursor").build())

        paginatedTweets.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun search() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val tweetService = client.x().tweets()

        val paginatedTweets =
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

        paginatedTweets.validate()
    }
}
