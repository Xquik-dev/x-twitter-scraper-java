// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x.communities

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.communities.media.MediaListParams
import java.time.LocalDate
import org.junit.jupiter.api.Test

internal class MediaServiceAsyncTest {
    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val mediaServiceAsync = client.x().communities().media()

        val paginatedTweetsFuture =
            mediaServiceAsync.list(
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
            )

        val paginatedTweets = paginatedTweetsFuture.get()
        kotlin.test.assertNotNull(paginatedTweets)
    }
}
