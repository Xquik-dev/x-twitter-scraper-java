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
import java.time.LocalDate
import org.junit.jupiter.api.Test

internal class TweetServiceTest {
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val tweetService = client.x().tweets()

        val tweet =
            tweetService.create(
                TweetCreateParams.builder()
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .communityId("1500000000000000000")
                    .isNoteTweet(false)
                    .addMedia("https://example.com/video.mp4")
                    .replyToTweetId("1234567890")
                    .text("Just launched our new feature!")
                    .build()
            )

        kotlin.test.assertNotNull(tweet)
    }

    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val tweetService = client.x().tweets()

        val tweet = tweetService.retrieve("id")

        kotlin.test.assertNotNull(tweet)
    }

    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val tweetService = client.x().tweets()

        val paginatedTweets = tweetService.list(TweetListParams.builder().ids("ids").build())

        kotlin.test.assertNotNull(paginatedTweets)
    }

    @Test
    fun delete() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val tweetService = client.x().tweets()

        val tweet =
            tweetService.delete(
                TweetDeleteParams.builder()
                    .id("id")
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .build()
            )

        kotlin.test.assertNotNull(tweet)
    }

    @Test
    fun getFavoriters() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val tweetService = client.x().tweets()

        val paginatedUsers =
            tweetService.getFavoriters(
                TweetGetFavoritersParams.builder().id("id").cursor("cursor").pageSize(20L).build()
            )

        kotlin.test.assertNotNull(paginatedUsers)
    }

    @Test
    fun getQuotes() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val tweetService = client.x().tweets()

        val paginatedTweets =
            tweetService.getQuotes(
                TweetGetQuotesParams.builder()
                    .id("id")
                    .anyWords("anyWords")
                    .cashtags("cashtags")
                    .conversationId("conversationId")
                    .cursor("cursor")
                    .exactPhrase("exactPhrase")
                    .excludeWords("excludeWords")
                    .fromUser("fromUser")
                    .hashtags("hashtags")
                    .includeReplies(true)
                    .inReplyToTweetId("inReplyToTweetId")
                    .language("language")
                    .mediaType(TweetGetQuotesParams.MediaType.IMAGES)
                    .mentioning("mentioning")
                    .minFaves(0L)
                    .minQuotes(0L)
                    .minReplies(0L)
                    .minRetweets(0L)
                    .pageSize(1L)
                    .quotes(TweetGetQuotesParams.Quotes.INCLUDE)
                    .quotesOfTweetId("quotesOfTweetId")
                    .replies(TweetGetQuotesParams.Replies.INCLUDE)
                    .retweets(TweetGetQuotesParams.Retweets.INCLUDE)
                    .retweetsOfTweetId("retweetsOfTweetId")
                    .sinceDate(LocalDate.parse("2019-12-27"))
                    .sinceTime("sinceTime")
                    .toUser("toUser")
                    .untilDate(LocalDate.parse("2019-12-27"))
                    .untilTime("untilTime")
                    .url("url")
                    .verifiedOnly(true)
                    .build()
            )

        kotlin.test.assertNotNull(paginatedTweets)
    }

    @Test
    fun getReplies() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val tweetService = client.x().tweets()

        val paginatedTweets =
            tweetService.getReplies(
                TweetGetRepliesParams.builder()
                    .id("id")
                    .anyWords("anyWords")
                    .cashtags("cashtags")
                    .conversationId("conversationId")
                    .cursor("cursor")
                    .exactPhrase("exactPhrase")
                    .excludeWords("excludeWords")
                    .fromUser("fromUser")
                    .hashtags("hashtags")
                    .inReplyToTweetId("inReplyToTweetId")
                    .language("language")
                    .mediaType(TweetGetRepliesParams.MediaType.IMAGES)
                    .mentioning("mentioning")
                    .minFaves(0L)
                    .minQuotes(0L)
                    .minReplies(0L)
                    .minRetweets(0L)
                    .pageSize(1L)
                    .quotes(TweetGetRepliesParams.Quotes.INCLUDE)
                    .quotesOfTweetId("quotesOfTweetId")
                    .replies(TweetGetRepliesParams.Replies.INCLUDE)
                    .retweets(TweetGetRepliesParams.Retweets.INCLUDE)
                    .retweetsOfTweetId("retweetsOfTweetId")
                    .sinceDate(LocalDate.parse("2019-12-27"))
                    .sinceTime("sinceTime")
                    .toUser("toUser")
                    .untilDate(LocalDate.parse("2019-12-27"))
                    .untilTime("untilTime")
                    .url("url")
                    .verifiedOnly(true)
                    .build()
            )

        kotlin.test.assertNotNull(paginatedTweets)
    }

    @Test
    fun getRetweeters() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val tweetService = client.x().tweets()

        val paginatedUsers =
            tweetService.getRetweeters(
                TweetGetRetweetersParams.builder().id("id").cursor("cursor").pageSize(20L).build()
            )

        kotlin.test.assertNotNull(paginatedUsers)
    }

    @Test
    fun getThread() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val tweetService = client.x().tweets()

        val paginatedTweets =
            tweetService.getThread(
                TweetGetThreadParams.builder().id("id").cursor("cursor").pageSize(1L).build()
            )

        kotlin.test.assertNotNull(paginatedTweets)
    }

    @Test
    fun search() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val tweetService = client.x().tweets()

        val paginatedTweets =
            tweetService.search(
                TweetSearchParams.builder()
                    .q("q")
                    .advancedQuery("advancedQuery")
                    .anyWords("anyWords")
                    .boundingBox("boundingBox")
                    .cashtags("cashtags")
                    .conversationId("conversationId")
                    .cursor("cursor")
                    .exactPhrase("exactPhrase")
                    .excludeWords("excludeWords")
                    .fromUser("fromUser")
                    .hashtags("hashtags")
                    .inReplyToTweetId("inReplyToTweetId")
                    .language("language")
                    .limit(200L)
                    .listId("listId")
                    .mediaType(TweetSearchParams.MediaType.IMAGES)
                    .mentioning("mentioning")
                    .minFaves(0L)
                    .minQuotes(0L)
                    .minReplies(0L)
                    .minRetweets(0L)
                    .place("place")
                    .placeCountry("placeCountry")
                    .pointRadius("pointRadius")
                    .queryType(TweetSearchParams.QueryType.LATEST)
                    .quotes(TweetSearchParams.Quotes.INCLUDE)
                    .quotesOfTweetId("quotesOfTweetId")
                    .replies(TweetSearchParams.Replies.INCLUDE)
                    .retweets(TweetSearchParams.Retweets.INCLUDE)
                    .retweetsOfTweetId("retweetsOfTweetId")
                    .sinceDate(LocalDate.parse("2019-12-27"))
                    .sinceTime("sinceTime")
                    .toUser("toUser")
                    .untilDate(LocalDate.parse("2019-12-27"))
                    .untilTime("untilTime")
                    .url("url")
                    .verifiedOnly(true)
                    .build()
            )

        kotlin.test.assertNotNull(paginatedTweets)
    }
}
