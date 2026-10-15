// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.users.UserRemoveFollowerParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveAffiliatesParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveArticlesParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveBatchParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveBatchTweetsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowerIdsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowersParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowersYouKnowParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowingIdsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowingParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveHighlightsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveInsightsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveLikesParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveListMembershipsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveListsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveLiveParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveMediaParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveMentionsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveRepliesParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveSearchParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveSimilarParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveSubscriptionsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveTweetsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveVerifiedFollowersParams
import com.x_twitter_scraper.api.models.x.users.UserTranslateBioParams
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
    fun retrieveAffiliates() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val paginatedUsers =
            userService.retrieveAffiliates(
                UserRetrieveAffiliatesParams.builder()
                    .id("id")
                    .bioContains("bioContains")
                    .blueVerifiedOnly(true)
                    .businessEmailOnly(true)
                    .cursor("cursor")
                    .emailDomains("acme.com,stanford.edu")
                    .fields("id,text,author.username")
                    .hasEmail(true)
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
                    .omit("entities,media")
                    .pageSize(1L)
                    .usernameContains("usernameContains")
                    .verifiedOnly(true)
                    .verifiedType("verifiedType")
                    .build()
            )

        kotlin.test.assertNotNull(paginatedUsers)
    }

    @Test
    fun retrieveArticles() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val paginatedTweets =
            userService.retrieveArticles(
                UserRetrieveArticlesParams.builder()
                    .id("id")
                    .anyWords("anyWords")
                    .blueVerifiedOnly(true)
                    .cashtags("cashtags")
                    .conversationId("conversationId")
                    .cursor("cursor")
                    .exactPhrase("exactPhrase")
                    .excludeWords("excludeWords")
                    .fields("id,text,author.username")
                    .fromUser("fromUser")
                    .hashtags("hashtags")
                    .inReplyToTweetId("inReplyToTweetId")
                    .language("language")
                    .maxFaves(0L)
                    .maxId("maxId")
                    .maxQuotes(0L)
                    .maxReplies(0L)
                    .maxRetweets(0L)
                    .mediaType(UserRetrieveArticlesParams.MediaType.IMAGES)
                    .mentioning("mentioning")
                    .minBookmarks(0L)
                    .minLikes(0L)
                    .minQuotes(0L)
                    .minReplies(0L)
                    .minRetweets(0L)
                    .minViews(0L)
                    .nativeRetweets(true)
                    .omit("entities,media")
                    .pageSize(1L)
                    .quotes(UserRetrieveArticlesParams.Quotes.INCLUDE)
                    .quotesOfTweetId("quotesOfTweetId")
                    .replies(UserRetrieveArticlesParams.Replies.INCLUDE)
                    .retweets(UserRetrieveArticlesParams.Retweets.INCLUDE)
                    .retweetsOfTweetId("retweetsOfTweetId")
                    .sinceDate(LocalDate.parse("2019-12-27"))
                    .sinceId("sinceId")
                    .toUser("toUser")
                    .untilDate(LocalDate.parse("2019-12-27"))
                    .url("url")
                    .verifiedOnly(true)
                    .withinTime("7d")
                    .build()
            )

        kotlin.test.assertNotNull(paginatedTweets)
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
    fun retrieveBatchTweets() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val response =
            userService.retrieveBatchTweets(
                UserRetrieveBatchTweetsParams.builder()
                    .fields("id,text,author.username")
                    .ids("ids")
                    .omit("entities,media")
                    .pageSize(1L)
                    .usernames("nasa,@OpenAI,x.com/verge")
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveFollowerIds() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val response =
            userService.retrieveFollowerIds(
                UserRetrieveFollowerIdsParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .pageSize(1L)
                    .build()
            )

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

        val response =
            userService.retrieveFollowers(
                UserRetrieveFollowersParams.builder()
                    .id("id")
                    .after("after")
                    .bioContains("bioContains")
                    .cursor("cursor")
                    .hasLocation(true)
                    .hasWebsite(true)
                    .limit(1L)
                    .locationContains("locationContains")
                    .maxFollowers(0L)
                    .maxFollowing(0L)
                    .maxStatuses(0L)
                    .minAccountAgeDays(0L)
                    .minFollowers(0L)
                    .minFollowing(0L)
                    .minStatuses(0L)
                    .mode(UserRetrieveFollowersParams.Mode.STANDARD)
                    .pageSize(20L)
                    .usernameContains("usernameContains")
                    .verifiedOnly(true)
                    .verifiedType("verifiedType")
                    .build()
            )

        kotlin.test.assertNotNull(response)
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

        val response =
            userService.retrieveFollowing(
                UserRetrieveFollowingParams.builder()
                    .id("id")
                    .after("after")
                    .bioContains("bioContains")
                    .cursor("cursor")
                    .hasLocation(true)
                    .hasWebsite(true)
                    .limit(1L)
                    .locationContains("locationContains")
                    .maxFollowers(0L)
                    .maxFollowing(0L)
                    .maxStatuses(0L)
                    .minAccountAgeDays(0L)
                    .minFollowers(0L)
                    .minFollowing(0L)
                    .minStatuses(0L)
                    .mode(UserRetrieveFollowingParams.Mode.STANDARD)
                    .pageSize(20L)
                    .usernameContains("usernameContains")
                    .verifiedOnly(true)
                    .verifiedType("verifiedType")
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveFollowingIds() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val response =
            userService.retrieveFollowingIds(
                UserRetrieveFollowingIdsParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .pageSize(1L)
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveHighlights() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val paginatedTweets =
            userService.retrieveHighlights(
                UserRetrieveHighlightsParams.builder()
                    .id("id")
                    .anyWords("anyWords")
                    .blueVerifiedOnly(true)
                    .cashtags("cashtags")
                    .conversationId("conversationId")
                    .cursor("cursor")
                    .exactPhrase("exactPhrase")
                    .excludeWords("excludeWords")
                    .fields("id,text,author.username")
                    .fromUser("fromUser")
                    .hashtags("hashtags")
                    .inReplyToTweetId("inReplyToTweetId")
                    .language("language")
                    .maxFaves(0L)
                    .maxId("maxId")
                    .maxQuotes(0L)
                    .maxReplies(0L)
                    .maxRetweets(0L)
                    .mediaType(UserRetrieveHighlightsParams.MediaType.IMAGES)
                    .mentioning("mentioning")
                    .minBookmarks(0L)
                    .minLikes(0L)
                    .minQuotes(0L)
                    .minReplies(0L)
                    .minRetweets(0L)
                    .minViews(0L)
                    .nativeRetweets(true)
                    .omit("entities,media")
                    .pageSize(1L)
                    .quotes(UserRetrieveHighlightsParams.Quotes.INCLUDE)
                    .quotesOfTweetId("quotesOfTweetId")
                    .replies(UserRetrieveHighlightsParams.Replies.INCLUDE)
                    .retweets(UserRetrieveHighlightsParams.Retweets.INCLUDE)
                    .retweetsOfTweetId("retweetsOfTweetId")
                    .sinceDate(LocalDate.parse("2019-12-27"))
                    .sinceId("sinceId")
                    .toUser("toUser")
                    .untilDate(LocalDate.parse("2019-12-27"))
                    .url("url")
                    .verifiedOnly(true)
                    .withinTime("7d")
                    .build()
            )

        kotlin.test.assertNotNull(paginatedTweets)
    }

    @Test
    fun retrieveInsights() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val response =
            userService.retrieveInsights(
                UserRetrieveInsightsParams.builder()
                    .id("id")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .build()
            )

        kotlin.test.assertNotNull(response)
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
                    .inReplyToTweetId("inReplyToTweetId")
                    .language("language")
                    .maxFaves(0L)
                    .maxId("maxId")
                    .maxQuotes(0L)
                    .maxReplies(0L)
                    .maxRetweets(0L)
                    .mediaType(UserRetrieveLikesParams.MediaType.IMAGES)
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
                    .quotes(UserRetrieveLikesParams.Quotes.INCLUDE)
                    .quotesOfTweetId("quotesOfTweetId")
                    .replies(UserRetrieveLikesParams.Replies.INCLUDE)
                    .retweets(UserRetrieveLikesParams.Retweets.INCLUDE)
                    .retweetsOfTweetId("retweetsOfTweetId")
                    .safe(true)
                    .sinceDate(LocalDate.parse("2019-12-27"))
                    .sinceId("sinceId")
                    .source("source")
                    .toUser("toUser")
                    .untilDate(LocalDate.parse("2019-12-27"))
                    .url("url")
                    .verifiedOnly(true)
                    .within("within")
                    .withinTime("withinTime")
                    .build()
            )

        kotlin.test.assertNotNull(paginatedTweets)
    }

    @Test
    fun retrieveListMemberships() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val response =
            userService.retrieveListMemberships(
                UserRetrieveListMembershipsParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .pageSize(1L)
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveLists() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val response =
            userService.retrieveLists(
                UserRetrieveListsParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .pageSize(1L)
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveLive() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val response =
            userService.retrieveLive(
                UserRetrieveLiveParams.builder()
                    .id("id")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .build()
            )

        kotlin.test.assertNotNull(response)
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
                    .inReplyToTweetId("inReplyToTweetId")
                    .language("language")
                    .maxFaves(0L)
                    .maxId("maxId")
                    .maxQuotes(0L)
                    .maxReplies(0L)
                    .maxRetweets(0L)
                    .mediaType(UserRetrieveMediaParams.MediaType.IMAGES)
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
                    .quotes(UserRetrieveMediaParams.Quotes.INCLUDE)
                    .quotesOfTweetId("quotesOfTweetId")
                    .replies(UserRetrieveMediaParams.Replies.INCLUDE)
                    .retweets(UserRetrieveMediaParams.Retweets.INCLUDE)
                    .retweetsOfTweetId("retweetsOfTweetId")
                    .safe(true)
                    .sinceDate(LocalDate.parse("2019-12-27"))
                    .sinceId("sinceId")
                    .source("source")
                    .toUser("toUser")
                    .untilDate(LocalDate.parse("2019-12-27"))
                    .url("url")
                    .verifiedOnly(true)
                    .within("within")
                    .withinTime("withinTime")
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
                    .inReplyToTweetId("inReplyToTweetId")
                    .language("language")
                    .maxFaves(0L)
                    .maxId("maxId")
                    .maxQuotes(0L)
                    .maxReplies(0L)
                    .maxRetweets(0L)
                    .mediaType(UserRetrieveMentionsParams.MediaType.IMAGES)
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
                    .quotes(UserRetrieveMentionsParams.Quotes.INCLUDE)
                    .quotesOfTweetId("quotesOfTweetId")
                    .replies(UserRetrieveMentionsParams.Replies.INCLUDE)
                    .retweets(UserRetrieveMentionsParams.Retweets.INCLUDE)
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
                    .includeParentTweet(true)
                    .inReplyToTweetId("inReplyToTweetId")
                    .language("language")
                    .maxFaves(0L)
                    .maxId("maxId")
                    .maxQuotes(0L)
                    .maxReplies(0L)
                    .maxRetweets(0L)
                    .mediaType(UserRetrieveRepliesParams.MediaType.IMAGES)
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
                    .quotes(UserRetrieveRepliesParams.Quotes.INCLUDE)
                    .quotesOfTweetId("quotesOfTweetId")
                    .replies(UserRetrieveRepliesParams.Replies.INCLUDE)
                    .retweets(UserRetrieveRepliesParams.Retweets.INCLUDE)
                    .retweetsOfTweetId("retweetsOfTweetId")
                    .safe(true)
                    .sinceDate(LocalDate.parse("2019-12-27"))
                    .sinceId("sinceId")
                    .source("source")
                    .toUser("toUser")
                    .untilDate(LocalDate.parse("2019-12-27"))
                    .url("url")
                    .verifiedOnly(true)
                    .within("within")
                    .withinTime("withinTime")
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
                UserRetrieveSearchParams.builder()
                    .q("q")
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
                    .usernameContains("usernameContains")
                    .verifiedOnly(true)
                    .verifiedType("verifiedType")
                    .build()
            )

        kotlin.test.assertNotNull(paginatedUsers)
    }

    @Test
    fun retrieveSimilar() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val paginatedUsers =
            userService.retrieveSimilar(
                UserRetrieveSimilarParams.builder()
                    .id("id")
                    .bioContains("bioContains")
                    .blueVerifiedOnly(true)
                    .businessEmailOnly(true)
                    .cursor("cursor")
                    .emailDomains("acme.com,stanford.edu")
                    .fields("id,text,author.username")
                    .hasEmail(true)
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
                    .omit("entities,media")
                    .pageSize(1L)
                    .usernameContains("usernameContains")
                    .verifiedOnly(true)
                    .verifiedType("verifiedType")
                    .build()
            )

        kotlin.test.assertNotNull(paginatedUsers)
    }

    @Test
    fun retrieveSubscriptions() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val paginatedUsers =
            userService.retrieveSubscriptions(
                UserRetrieveSubscriptionsParams.builder()
                    .id("id")
                    .bioContains("bioContains")
                    .blueVerifiedOnly(true)
                    .businessEmailOnly(true)
                    .cursor("cursor")
                    .emailDomains("acme.com,stanford.edu")
                    .fields("id,text,author.username")
                    .hasEmail(true)
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
                    .omit("entities,media")
                    .pageSize(1L)
                    .usernameContains("usernameContains")
                    .verifiedOnly(true)
                    .verifiedType("verifiedType")
                    .build()
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
                    .includeParentTweet(true)
                    .includeReplies(true)
                    .inReplyToTweetId("inReplyToTweetId")
                    .language("language")
                    .maxFaves(0L)
                    .maxId("maxId")
                    .maxQuotes(0L)
                    .maxReplies(0L)
                    .maxRetweets(0L)
                    .mediaType(UserRetrieveTweetsParams.MediaType.IMAGES)
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
                    .quotes(UserRetrieveTweetsParams.Quotes.INCLUDE)
                    .quotesOfTweetId("quotesOfTweetId")
                    .replies(UserRetrieveTweetsParams.Replies.INCLUDE)
                    .retweets(UserRetrieveTweetsParams.Retweets.INCLUDE)
                    .retweetsOfTweetId("retweetsOfTweetId")
                    .safe(true)
                    .sinceDate(LocalDate.parse("2019-12-27"))
                    .sinceId("sinceId")
                    .source("source")
                    .toUser("toUser")
                    .untilDate(LocalDate.parse("2019-12-27"))
                    .url("url")
                    .verifiedOnly(true)
                    .within("within")
                    .withinTime("withinTime")
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

        val response =
            userService.retrieveVerifiedFollowers(
                UserRetrieveVerifiedFollowersParams.builder()
                    .id("id")
                    .after("after")
                    .bioContains("bioContains")
                    .cursor("cursor")
                    .hasLocation(true)
                    .hasWebsite(true)
                    .limit(1L)
                    .locationContains("locationContains")
                    .maxFollowers(0L)
                    .maxFollowing(0L)
                    .maxStatuses(0L)
                    .minAccountAgeDays(0L)
                    .minFollowers(0L)
                    .minFollowing(0L)
                    .minStatuses(0L)
                    .mode(UserRetrieveVerifiedFollowersParams.Mode.STANDARD)
                    .pageSize(20L)
                    .usernameContains("usernameContains")
                    .verifiedOnly(true)
                    .verifiedType("verifiedType")
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun translateBio() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val response =
            userService.translateBio(
                UserTranslateBioParams.builder()
                    .id("id")
                    .language("es")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }
}
