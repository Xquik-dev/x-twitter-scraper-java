// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
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

internal class UserServiceAsyncTest {
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.x().users()

        val userProfileFuture = userServiceAsync.retrieve("id")

        val userProfile = userProfileFuture.get()
        kotlin.test.assertNotNull(userProfile)
    }

    @Test
    fun removeFollower() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.x().users()

        val responseFuture =
            userServiceAsync.removeFollower(
                UserRemoveFollowerParams.builder()
                    .id("id")
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveAffiliates() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.x().users()

        val paginatedUsersFuture =
            userServiceAsync.retrieveAffiliates(
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

        val paginatedUsers = paginatedUsersFuture.get()
        kotlin.test.assertNotNull(paginatedUsers)
    }

    @Test
    fun retrieveArticles() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.x().users()

        val paginatedTweetsFuture =
            userServiceAsync.retrieveArticles(
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

        val paginatedTweets = paginatedTweetsFuture.get()
        kotlin.test.assertNotNull(paginatedTweets)
    }

    @Test
    fun retrieveBatch() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.x().users()

        val responseFuture =
            userServiceAsync.retrieveBatch(UserRetrieveBatchParams.builder().ids("ids").build())

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveBatchTweets() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.x().users()

        val responseFuture =
            userServiceAsync.retrieveBatchTweets(
                UserRetrieveBatchTweetsParams.builder()
                    .fields("id,text,author.username")
                    .ids("ids")
                    .omit("entities,media")
                    .pageSize(1L)
                    .usernames("nasa,@OpenAI,x.com/verge")
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveFollowerIds() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.x().users()

        val responseFuture =
            userServiceAsync.retrieveFollowerIds(
                UserRetrieveFollowerIdsParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .pageSize(1L)
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveFollowers() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.x().users()

        val responseFuture =
            userServiceAsync.retrieveFollowers(
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

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveFollowersYouKnow() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.x().users()

        val paginatedUsersFuture =
            userServiceAsync.retrieveFollowersYouKnow(
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

        val paginatedUsers = paginatedUsersFuture.get()
        kotlin.test.assertNotNull(paginatedUsers)
    }

    @Test
    fun retrieveFollowing() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.x().users()

        val responseFuture =
            userServiceAsync.retrieveFollowing(
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

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveFollowingIds() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.x().users()

        val responseFuture =
            userServiceAsync.retrieveFollowingIds(
                UserRetrieveFollowingIdsParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .pageSize(1L)
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveHighlights() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.x().users()

        val paginatedTweetsFuture =
            userServiceAsync.retrieveHighlights(
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

        val paginatedTweets = paginatedTweetsFuture.get()
        kotlin.test.assertNotNull(paginatedTweets)
    }

    @Test
    fun retrieveInsights() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.x().users()

        val responseFuture =
            userServiceAsync.retrieveInsights(
                UserRetrieveInsightsParams.builder()
                    .id("id")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveLikes() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.x().users()

        val paginatedTweetsFuture =
            userServiceAsync.retrieveLikes(
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

        val paginatedTweets = paginatedTweetsFuture.get()
        kotlin.test.assertNotNull(paginatedTweets)
    }

    @Test
    fun retrieveListMemberships() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.x().users()

        val responseFuture =
            userServiceAsync.retrieveListMemberships(
                UserRetrieveListMembershipsParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .pageSize(1L)
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveLists() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.x().users()

        val responseFuture =
            userServiceAsync.retrieveLists(
                UserRetrieveListsParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .pageSize(1L)
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveLive() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.x().users()

        val responseFuture =
            userServiceAsync.retrieveLive(
                UserRetrieveLiveParams.builder()
                    .id("id")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveMedia() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.x().users()

        val paginatedTweetsFuture =
            userServiceAsync.retrieveMedia(
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

        val paginatedTweets = paginatedTweetsFuture.get()
        kotlin.test.assertNotNull(paginatedTweets)
    }

    @Test
    fun retrieveMentions() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.x().users()

        val paginatedTweetsFuture =
            userServiceAsync.retrieveMentions(
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

        val paginatedTweets = paginatedTweetsFuture.get()
        kotlin.test.assertNotNull(paginatedTweets)
    }

    @Test
    fun retrieveReplies() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.x().users()

        val paginatedTweetsFuture =
            userServiceAsync.retrieveReplies(
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

        val paginatedTweets = paginatedTweetsFuture.get()
        kotlin.test.assertNotNull(paginatedTweets)
    }

    @Test
    fun retrieveSearch() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.x().users()

        val paginatedUsersFuture =
            userServiceAsync.retrieveSearch(
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

        val paginatedUsers = paginatedUsersFuture.get()
        kotlin.test.assertNotNull(paginatedUsers)
    }

    @Test
    fun retrieveSimilar() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.x().users()

        val paginatedUsersFuture =
            userServiceAsync.retrieveSimilar(
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

        val paginatedUsers = paginatedUsersFuture.get()
        kotlin.test.assertNotNull(paginatedUsers)
    }

    @Test
    fun retrieveSubscriptions() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.x().users()

        val paginatedUsersFuture =
            userServiceAsync.retrieveSubscriptions(
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

        val paginatedUsers = paginatedUsersFuture.get()
        kotlin.test.assertNotNull(paginatedUsers)
    }

    @Test
    fun retrieveTweets() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.x().users()

        val paginatedTweetsFuture =
            userServiceAsync.retrieveTweets(
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

        val paginatedTweets = paginatedTweetsFuture.get()
        kotlin.test.assertNotNull(paginatedTweets)
    }

    @Test
    fun retrieveVerifiedFollowers() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.x().users()

        val responseFuture =
            userServiceAsync.retrieveVerifiedFollowers(
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

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun translateBio() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.x().users()

        val responseFuture =
            userServiceAsync.translateBio(
                UserTranslateBioParams.builder()
                    .id("id")
                    .language("es")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }
}
