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
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val tweetServiceAsync = client.x().tweets()

        val tweetFuture =
            tweetServiceAsync.create(
                TweetCreateParams.builder()
                    .account("account")
                    .text("text")
                    .attachmentUrl("attachment_url")
                    .communityId("community_id")
                    .isNoteTweet(true)
                    .addMediaId("string")
                    .replyToTweetId("reply_to_tweet_id")
                    .build()
            )

        val tweet = tweetFuture.get()
        tweet.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val tweetServiceAsync = client.x().tweets()

        val tweetFuture = tweetServiceAsync.retrieve("tweetId")

        val tweet = tweetFuture.get()
        tweet.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val tweetServiceAsync = client.x().tweets()

        val future = tweetServiceAsync.list(TweetListParams.builder().ids("ids").build())

        val response = future.get()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val tweetServiceAsync = client.x().tweets()

        val tweetFuture =
            tweetServiceAsync.delete(
                TweetDeleteParams.builder().tweetId("tweetId").account("account").build()
            )

        val tweet = tweetFuture.get()
        tweet.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun getFavoriters() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val tweetServiceAsync = client.x().tweets()

        val responseFuture =
            tweetServiceAsync.getFavoriters(
                TweetGetFavoritersParams.builder().id("id").cursor("cursor").build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun getQuotes() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val tweetServiceAsync = client.x().tweets()

        val responseFuture =
            tweetServiceAsync.getQuotes(
                TweetGetQuotesParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .includeReplies(true)
                    .sinceTime("sinceTime")
                    .untilTime("untilTime")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun getReplies() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val tweetServiceAsync = client.x().tweets()

        val responseFuture =
            tweetServiceAsync.getReplies(
                TweetGetRepliesParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .sinceTime("sinceTime")
                    .untilTime("untilTime")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun getRetweeters() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val tweetServiceAsync = client.x().tweets()

        val responseFuture =
            tweetServiceAsync.getRetweeters(
                TweetGetRetweetersParams.builder().id("id").cursor("cursor").build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun getThread() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val tweetServiceAsync = client.x().tweets()

        val responseFuture =
            tweetServiceAsync.getThread(
                TweetGetThreadParams.builder().id("id").cursor("cursor").build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun search() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val tweetServiceAsync = client.x().tweets()

        val responseFuture =
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

        val response = responseFuture.get()
        response.validate()
    }
}
