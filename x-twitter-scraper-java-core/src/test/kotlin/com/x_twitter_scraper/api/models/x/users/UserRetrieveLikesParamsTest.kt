// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.users

import com.x_twitter_scraper.api.core.http.QueryParams
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserRetrieveLikesParamsTest {

    @Test
    fun create() {
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
    }

    @Test
    fun pathParams() {
        val params = UserRetrieveLikesParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
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

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("anyWords", "anyWords")
                    .put("blueVerifiedOnly", "true")
                    .put("cardName", "cardName")
                    .put("cashtags", "cashtags")
                    .put("conversationId", "conversationId")
                    .put("cursor", "cursor")
                    .put("exactPhrase", "exactPhrase")
                    .put("excludeSource", "excludeSource")
                    .put("excludeWords", "excludeWords")
                    .put("fromUser", "fromUser")
                    .put("geocode", "geocode")
                    .put("hashtags", "hashtags")
                    .put("inReplyToTweetId", "inReplyToTweetId")
                    .put("language", "language")
                    .put("maxFaves", "0")
                    .put("maxId", "maxId")
                    .put("maxQuotes", "0")
                    .put("maxReplies", "0")
                    .put("maxRetweets", "0")
                    .put("mediaType", "images")
                    .put("mentioning", "mentioning")
                    .put("minBookmarks", "0")
                    .put("minFaves", "0")
                    .put("minQuotes", "0")
                    .put("minReplies", "0")
                    .put("minRetweets", "0")
                    .put("minViews", "0")
                    .put("nativeRetweets", "true")
                    .put("near", "near")
                    .put("news", "true")
                    .put("pageSize", "1")
                    .put("quotes", "include")
                    .put("quotesOfTweetId", "quotesOfTweetId")
                    .put("replies", "include")
                    .put("retweets", "include")
                    .put("retweetsOfTweetId", "retweetsOfTweetId")
                    .put("safe", "true")
                    .put("sinceDate", "2019-12-27")
                    .put("sinceId", "sinceId")
                    .put("source", "source")
                    .put("toUser", "toUser")
                    .put("untilDate", "2019-12-27")
                    .put("url", "url")
                    .put("verifiedOnly", "true")
                    .put("within", "within")
                    .put("withinTime", "withinTime")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = UserRetrieveLikesParams.builder().id("id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
