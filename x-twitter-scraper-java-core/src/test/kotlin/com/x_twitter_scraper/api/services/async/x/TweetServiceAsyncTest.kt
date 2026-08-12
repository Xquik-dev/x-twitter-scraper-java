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
import java.time.LocalDate
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
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .communityId("1500000000000000000")
                    .isNoteTweet(false)
                    .addMedia("https://example.com/video.mp4")
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
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val tweetServiceAsync = client.x().tweets()

        val tweetFuture = tweetServiceAsync.retrieve("id")

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

        val paginatedTweetsFuture =
            tweetServiceAsync.list(TweetListParams.builder().ids("ids").build())

        val paginatedTweets = paginatedTweetsFuture.get()
        paginatedTweets.validate()
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
                TweetDeleteParams.builder()
                    .id("id")
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .build()
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

        val paginatedUsersFuture =
            tweetServiceAsync.getFavoriters(
                TweetGetFavoritersParams.builder()
                    .id("id")
                    .bioContains("bioContains")
                    .cursor("cursor")
                    .hasLocation(true)
                    .hasWebsite(true)
                    .locationContains("locationContains")
                    .maxFollowers(0L)
                    .maxFollowing(0L)
                    .maxStatuses(0L)
                    .minAccountAgeDays(0L)
                    .minFollowers(0L)
                    .minFollowing(0L)
                    .minStatuses(0L)
                    .pageSize(20L)
                    .usernameContains("usernameContains")
                    .verifiedOnly(true)
                    .verifiedType("verifiedType")
                    .build()
            )

        val paginatedUsers = paginatedUsersFuture.get()
        paginatedUsers.validate()
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

        val paginatedTweetsFuture =
            tweetServiceAsync.getQuotes(
                TweetGetQuotesParams.builder()
                    .id("id")
                    .anyWords("anyWords")
                    .blueVerifiedOnly(true)
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
                    .includeReplies(true)
                    .inReplyToTweetId("inReplyToTweetId")
                    .language("language")
                    .maxFaves(0L)
                    .maxId("maxId")
                    .maxQuotes(0L)
                    .maxReplies(0L)
                    .maxRetweets(0L)
                    .mediaType(TweetGetQuotesParams.MediaType.IMAGES)
                    .mentioning("mentioning")
                    .minBookmarks(0L)
                    .minFaves(0L)
                    .minQuotes(0L)
                    .minReplies(0L)
                    .minRetweets(0L)
                    .minViews(0L)
                    .nativeRetweets(true)
                    .near("near")
                    .news(true)
                    .pageSize(1L)
                    .quotes(TweetGetQuotesParams.Quotes.INCLUDE)
                    .quotesOfTweetId("quotesOfTweetId")
                    .replies(TweetGetQuotesParams.Replies.INCLUDE)
                    .retweets(TweetGetQuotesParams.Retweets.INCLUDE)
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
                    .build()
            )

        val paginatedTweets = paginatedTweetsFuture.get()
        paginatedTweets.validate()
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
                    .anyWords("anyWords")
                    .blueVerifiedOnly(true)
                    .cardName("cardName")
                    .cashtags("cashtags")
                    .conversationId("conversationId")
                    .cursor("cursor")
                    .exactPhrase("exactPhrase")
                    .excludeOriginalAuthor(true)
                    .excludeSource("excludeSource")
                    .excludeWords("excludeWords")
                    .fromUser("fromUser")
                    .geocode("geocode")
                    .hashtags("hashtags")
                    .hasMediaOnly(true)
                    .includeOriginalPost(true)
                    .inReplyToTweetId("inReplyToTweetId")
                    .language("language")
                    .limit(1L)
                    .maxDepth(1L)
                    .maxFaves(0L)
                    .maxId("maxId")
                    .maxQuotes(0L)
                    .maxReplies(0L)
                    .maxRetweets(0L)
                    .mediaType(TweetGetRepliesParams.MediaType.IMAGES)
                    .mentioning("mentioning")
                    .minBookmarks(0L)
                    .minFaves(0L)
                    .minQuotes(0L)
                    .minReplies(0L)
                    .minRetweets(0L)
                    .minViews(0L)
                    .mode(TweetGetRepliesParams.Mode.STANDARD)
                    .nativeRetweets(true)
                    .near("near")
                    .news(true)
                    .pageSize(1L)
                    .quotes(TweetGetRepliesParams.Quotes.INCLUDE)
                    .quotesOfTweetId("quotesOfTweetId")
                    .replies(TweetGetRepliesParams.Replies.INCLUDE)
                    .retweets(TweetGetRepliesParams.Retweets.INCLUDE)
                    .retweetsOfTweetId("retweetsOfTweetId")
                    .safe(true)
                    .scope(TweetGetRepliesParams.Scope.ALL)
                    .sinceDate(LocalDate.parse("2019-12-27"))
                    .sinceId("sinceId")
                    .sinceTime("sinceTime")
                    .sort(TweetGetRepliesParams.Sort.RELEVANCE)
                    .source("source")
                    .toUser("toUser")
                    .untilDate(LocalDate.parse("2019-12-27"))
                    .untilTime("untilTime")
                    .url("url")
                    .verifiedOnly(true)
                    .within("within")
                    .withinTime("withinTime")
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

        val paginatedUsersFuture =
            tweetServiceAsync.getRetweeters(
                TweetGetRetweetersParams.builder()
                    .id("id")
                    .bioContains("bioContains")
                    .cursor("cursor")
                    .hasLocation(true)
                    .hasWebsite(true)
                    .locationContains("locationContains")
                    .maxFollowers(0L)
                    .maxFollowing(0L)
                    .maxStatuses(0L)
                    .minAccountAgeDays(0L)
                    .minFollowers(0L)
                    .minFollowing(0L)
                    .minStatuses(0L)
                    .pageSize(20L)
                    .usernameContains("usernameContains")
                    .verifiedOnly(true)
                    .verifiedType("verifiedType")
                    .build()
            )

        val paginatedUsers = paginatedUsersFuture.get()
        paginatedUsers.validate()
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

        val paginatedTweetsFuture =
            tweetServiceAsync.getThread(
                TweetGetThreadParams.builder()
                    .id("id")
                    .anyWords("anyWords")
                    .blueVerifiedOnly(true)
                    .cashtags("cashtags")
                    .conversationId("conversationId")
                    .cursor("cursor")
                    .exactPhrase("exactPhrase")
                    .excludeWords("excludeWords")
                    .fromUser("fromUser")
                    .hashtags("hashtags")
                    .inReplyToTweetId("inReplyToTweetId")
                    .language("language")
                    .maxFaves(0L)
                    .maxQuotes(0L)
                    .maxReplies(0L)
                    .maxRetweets(0L)
                    .mediaType(TweetGetThreadParams.MediaType.IMAGES)
                    .mentioning("mentioning")
                    .minBookmarks(0L)
                    .minFaves(0L)
                    .minQuotes(0L)
                    .minReplies(0L)
                    .minRetweets(0L)
                    .minViews(0L)
                    .pageSize(1L)
                    .quotes(TweetGetThreadParams.Quotes.INCLUDE)
                    .quotesOfTweetId("quotesOfTweetId")
                    .replies(TweetGetThreadParams.Replies.INCLUDE)
                    .retweets(TweetGetThreadParams.Retweets.INCLUDE)
                    .retweetsOfTweetId("retweetsOfTweetId")
                    .sinceDate(LocalDate.parse("2019-12-27"))
                    .toUser("toUser")
                    .untilDate(LocalDate.parse("2019-12-27"))
                    .url("url")
                    .verifiedOnly(true)
                    .build()
            )

        val paginatedTweets = paginatedTweetsFuture.get()
        paginatedTweets.validate()
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
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
