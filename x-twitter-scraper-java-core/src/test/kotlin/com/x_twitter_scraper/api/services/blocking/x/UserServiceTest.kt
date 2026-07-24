// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.users.UserRemoveFollowerParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveBatchParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowersParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowersYouKnowParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowingParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveLikesParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveMediaParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveMentionsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveRepliesParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveSearchParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveTweetsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveVerifiedFollowersParams
import java.time.LocalDate
import org.junit.jupiter.api.Test

internal class UserServiceTest {
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val userProfile = userService.retrieve("id")

        kotlin.test.assertNotNull(userProfile)
    }

    @Test
    fun removeFollower() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val response =
            userService.removeFollower(
                UserRemoveFollowerParams.builder()
                    .id("id")
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveBatch() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val response =
            userService.retrieveBatch(UserRetrieveBatchParams.builder().ids("ids").build())

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveFollowers() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val paginatedUsers =
            userService.retrieveFollowers(
                UserRetrieveFollowersParams.builder()
                    .id("id")
                    .after("after")
                    .cursor("cursor")
                    .limit(0L)
                    .pageSize(20L)
                    .build()
            )

        kotlin.test.assertNotNull(paginatedUsers)
    }

    @Test
    fun retrieveFollowersYouKnow() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val paginatedUsers =
            userService.retrieveFollowersYouKnow(
                UserRetrieveFollowersYouKnowParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .pageSize(20L)
                    .build()
            )

        kotlin.test.assertNotNull(paginatedUsers)
    }

    @Test
    fun retrieveFollowing() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val paginatedUsers =
            userService.retrieveFollowing(
                UserRetrieveFollowingParams.builder()
                    .id("id")
                    .after("after")
                    .cursor("cursor")
                    .limit(0L)
                    .pageSize(20L)
                    .build()
            )

        kotlin.test.assertNotNull(paginatedUsers)
    }

    @Test
    fun retrieveLikes() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val paginatedTweets =
            userService.retrieveLikes(
                UserRetrieveLikesParams.builder()
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
                    .mediaType(UserRetrieveLikesParams.MediaType.IMAGES)
                    .mentioning("mentioning")
                    .minFaves(0L)
                    .minQuotes(0L)
                    .minReplies(0L)
                    .minRetweets(0L)
                    .pageSize(1L)
                    .quotes(UserRetrieveLikesParams.Quotes.INCLUDE)
                    .quotesOfTweetId("quotesOfTweetId")
                    .replies(UserRetrieveLikesParams.Replies.INCLUDE)
                    .retweets(UserRetrieveLikesParams.Retweets.INCLUDE)
                    .retweetsOfTweetId("retweetsOfTweetId")
                    .sinceDate(LocalDate.parse("2019-12-27"))
                    .toUser("toUser")
                    .untilDate(LocalDate.parse("2019-12-27"))
                    .url("url")
                    .verifiedOnly(true)
                    .build()
            )

        kotlin.test.assertNotNull(paginatedTweets)
    }

    @Test
    fun retrieveMedia() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val paginatedTweets =
            userService.retrieveMedia(
                UserRetrieveMediaParams.builder()
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
                    .mediaType(UserRetrieveMediaParams.MediaType.IMAGES)
                    .mentioning("mentioning")
                    .minFaves(0L)
                    .minQuotes(0L)
                    .minReplies(0L)
                    .minRetweets(0L)
                    .pageSize(1L)
                    .quotes(UserRetrieveMediaParams.Quotes.INCLUDE)
                    .quotesOfTweetId("quotesOfTweetId")
                    .replies(UserRetrieveMediaParams.Replies.INCLUDE)
                    .retweets(UserRetrieveMediaParams.Retweets.INCLUDE)
                    .retweetsOfTweetId("retweetsOfTweetId")
                    .sinceDate(LocalDate.parse("2019-12-27"))
                    .toUser("toUser")
                    .untilDate(LocalDate.parse("2019-12-27"))
                    .url("url")
                    .verifiedOnly(true)
                    .build()
            )

        kotlin.test.assertNotNull(paginatedTweets)
    }

    @Test
    fun retrieveMentions() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val paginatedTweets =
            userService.retrieveMentions(
                UserRetrieveMentionsParams.builder()
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
                    .mediaType(UserRetrieveMentionsParams.MediaType.IMAGES)
                    .mentioning("mentioning")
                    .minFaves(0L)
                    .minQuotes(0L)
                    .minReplies(0L)
                    .minRetweets(0L)
                    .pageSize(1L)
                    .quotes(UserRetrieveMentionsParams.Quotes.INCLUDE)
                    .quotesOfTweetId("quotesOfTweetId")
                    .replies(UserRetrieveMentionsParams.Replies.INCLUDE)
                    .retweets(UserRetrieveMentionsParams.Retweets.INCLUDE)
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
    fun retrieveReplies() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val paginatedTweets =
            userService.retrieveReplies(
                UserRetrieveRepliesParams.builder()
                    .id("id")
                    .anyWords("anyWords")
                    .cashtags("cashtags")
                    .conversationId("conversationId")
                    .cursor("cursor")
                    .exactPhrase("exactPhrase")
                    .excludeWords("excludeWords")
                    .fromUser("fromUser")
                    .hashtags("hashtags")
                    .includeParentTweet(true)
                    .inReplyToTweetId("inReplyToTweetId")
                    .language("language")
                    .mediaType(UserRetrieveRepliesParams.MediaType.IMAGES)
                    .mentioning("mentioning")
                    .minFaves(0L)
                    .minQuotes(0L)
                    .minReplies(0L)
                    .minRetweets(0L)
                    .pageSize(1L)
                    .quotes(UserRetrieveRepliesParams.Quotes.INCLUDE)
                    .quotesOfTweetId("quotesOfTweetId")
                    .replies(UserRetrieveRepliesParams.Replies.INCLUDE)
                    .retweets(UserRetrieveRepliesParams.Retweets.INCLUDE)
                    .retweetsOfTweetId("retweetsOfTweetId")
                    .sinceDate(LocalDate.parse("2019-12-27"))
                    .toUser("toUser")
                    .untilDate(LocalDate.parse("2019-12-27"))
                    .url("url")
                    .verifiedOnly(true)
                    .build()
            )

        kotlin.test.assertNotNull(paginatedTweets)
    }

    @Test
    fun retrieveSearch() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val paginatedUsers =
            userService.retrieveSearch(
                UserRetrieveSearchParams.builder().q("q").cursor("cursor").build()
            )

        kotlin.test.assertNotNull(paginatedUsers)
    }

    @Test
    fun retrieveTweets() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val paginatedTweets =
            userService.retrieveTweets(
                UserRetrieveTweetsParams.builder()
                    .id("id")
                    .anyWords("anyWords")
                    .cashtags("cashtags")
                    .conversationId("conversationId")
                    .cursor("cursor")
                    .exactPhrase("exactPhrase")
                    .excludeWords("excludeWords")
                    .fromUser("fromUser")
                    .hashtags("hashtags")
                    .includeParentTweet(true)
                    .includeReplies(true)
                    .inReplyToTweetId("inReplyToTweetId")
                    .language("language")
                    .mediaType(UserRetrieveTweetsParams.MediaType.IMAGES)
                    .mentioning("mentioning")
                    .minFaves(0L)
                    .minQuotes(0L)
                    .minReplies(0L)
                    .minRetweets(0L)
                    .pageSize(1L)
                    .quotes(UserRetrieveTweetsParams.Quotes.INCLUDE)
                    .quotesOfTweetId("quotesOfTweetId")
                    .replies(UserRetrieveTweetsParams.Replies.INCLUDE)
                    .retweets(UserRetrieveTweetsParams.Retweets.INCLUDE)
                    .retweetsOfTweetId("retweetsOfTweetId")
                    .sinceDate(LocalDate.parse("2019-12-27"))
                    .toUser("toUser")
                    .untilDate(LocalDate.parse("2019-12-27"))
                    .url("url")
                    .verifiedOnly(true)
                    .build()
            )

        kotlin.test.assertNotNull(paginatedTweets)
    }

    @Test
    fun retrieveVerifiedFollowers() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val paginatedUsers =
            userService.retrieveVerifiedFollowers(
                UserRetrieveVerifiedFollowersParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .pageSize(20L)
                    .build()
            )

        kotlin.test.assertNotNull(paginatedUsers)
    }
}
