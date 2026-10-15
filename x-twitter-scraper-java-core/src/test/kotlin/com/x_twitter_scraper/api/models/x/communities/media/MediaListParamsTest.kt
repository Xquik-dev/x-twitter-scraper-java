// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.communities.media

import com.x_twitter_scraper.api.core.http.QueryParams
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MediaListParamsTest {

    @Test
    fun create() {
        MediaListParams.builder()
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
            .mediaType(MediaListParams.MediaType.IMAGES)
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
            .quotes(MediaListParams.Quotes.INCLUDE)
            .quotesOfTweetId("quotesOfTweetId")
            .replies(MediaListParams.Replies.INCLUDE)
            .retweets(MediaListParams.Retweets.INCLUDE)
            .retweetsOfTweetId("retweetsOfTweetId")
            .sinceDate(LocalDate.parse("2019-12-27"))
            .sinceId("sinceId")
            .toUser("toUser")
            .untilDate(LocalDate.parse("2019-12-27"))
            .url("url")
            .verifiedOnly(true)
            .withinTime("7d")
            .build()
    }

    @Test
    fun pathParams() {
        val params = MediaListParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            MediaListParams.builder()
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
                .mediaType(MediaListParams.MediaType.IMAGES)
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
                .quotes(MediaListParams.Quotes.INCLUDE)
                .quotesOfTweetId("quotesOfTweetId")
                .replies(MediaListParams.Replies.INCLUDE)
                .retweets(MediaListParams.Retweets.INCLUDE)
                .retweetsOfTweetId("retweetsOfTweetId")
                .sinceDate(LocalDate.parse("2019-12-27"))
                .sinceId("sinceId")
                .toUser("toUser")
                .untilDate(LocalDate.parse("2019-12-27"))
                .url("url")
                .verifiedOnly(true)
                .withinTime("7d")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("anyWords", "anyWords")
                    .put("blueVerifiedOnly", "true")
                    .put("cashtags", "cashtags")
                    .put("conversationId", "conversationId")
                    .put("cursor", "cursor")
                    .put("exactPhrase", "exactPhrase")
                    .put("excludeWords", "excludeWords")
                    .put("fields", "id,text,author.username")
                    .put("fromUser", "fromUser")
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
                    .put("minLikes", "0")
                    .put("minQuotes", "0")
                    .put("minReplies", "0")
                    .put("minRetweets", "0")
                    .put("minViews", "0")
                    .put("nativeRetweets", "true")
                    .put("omit", "entities,media")
                    .put("pageSize", "1")
                    .put("quotes", "include")
                    .put("quotesOfTweetId", "quotesOfTweetId")
                    .put("replies", "include")
                    .put("retweets", "include")
                    .put("retweetsOfTweetId", "retweetsOfTweetId")
                    .put("sinceDate", "2019-12-27")
                    .put("sinceId", "sinceId")
                    .put("toUser", "toUser")
                    .put("untilDate", "2019-12-27")
                    .put("url", "url")
                    .put("verifiedOnly", "true")
                    .put("withinTime", "7d")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = MediaListParams.builder().id("id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }

    @Test
    fun mediaTypeSendsEachKnownValue() {
        val values =
            listOf(
                    MediaListParams.MediaType.IMAGES,
                    MediaListParams.MediaType.VIDEOS,
                    MediaListParams.MediaType.GIFS,
                    MediaListParams.MediaType.MEDIA,
                    MediaListParams.MediaType.LINKS,
                    MediaListParams.MediaType.NONE,
                )
                .map {
                    MediaListParams.builder()
                        .id("id")
                        .mediaType(it)
                        .build()
                        ._queryParams()
                        .values("mediaType")
                }

        assertThat(values)
            .containsExactly(
                listOf("images"),
                listOf("videos"),
                listOf("gifs"),
                listOf("media"),
                listOf("links"),
                listOf("none"),
            )
    }

    @Test
    fun quotesSendsEachKnownValue() {
        val values =
            listOf(
                    MediaListParams.Quotes.INCLUDE,
                    MediaListParams.Quotes.EXCLUDE,
                    MediaListParams.Quotes.ONLY,
                )
                .map {
                    MediaListParams.builder()
                        .id("id")
                        .quotes(it)
                        .build()
                        ._queryParams()
                        .values("quotes")
                }

        assertThat(values).containsExactly(listOf("include"), listOf("exclude"), listOf("only"))
    }

    @Test
    fun repliesSendsEachKnownValue() {
        val values =
            listOf(
                    MediaListParams.Replies.INCLUDE,
                    MediaListParams.Replies.EXCLUDE,
                    MediaListParams.Replies.ONLY,
                )
                .map {
                    MediaListParams.builder()
                        .id("id")
                        .replies(it)
                        .build()
                        ._queryParams()
                        .values("replies")
                }

        assertThat(values).containsExactly(listOf("include"), listOf("exclude"), listOf("only"))
    }

    @Test
    fun retweetsSendsEachKnownValue() {
        val values =
            listOf(
                    MediaListParams.Retweets.INCLUDE,
                    MediaListParams.Retweets.EXCLUDE,
                    MediaListParams.Retweets.ONLY,
                )
                .map {
                    MediaListParams.builder()
                        .id("id")
                        .retweets(it)
                        .build()
                        ._queryParams()
                        .values("retweets")
                }

        assertThat(values).containsExactly(listOf("include"), listOf("exclude"), listOf("only"))
    }
}
