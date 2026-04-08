// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.draws

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DrawRetrieveResponseTest {

    @Test
    fun create() {
        val drawRetrieveResponse =
            DrawRetrieveResponse.builder()
                .draw(
                    DrawDetail.builder()
                        .id("42")
                        .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .status("completed")
                        .totalEntries(250L)
                        .tweetAuthorUsername("elonmusk")
                        .tweetId("1234567890")
                        .tweetLikeCount(50000L)
                        .tweetQuoteCount(5000L)
                        .tweetReplyCount(10000L)
                        .tweetRetweetCount(25000L)
                        .tweetText("Giving away 3 Tesla Model 3s!")
                        .tweetUrl("https://x.com/elonmusk/status/1234567890")
                        .validEntries(200L)
                        .drawnAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .addWinner(
                    Winner.builder()
                        .authorUsername("authorUsername")
                        .isBackup(true)
                        .position(0L)
                        .tweetId("tweetId")
                        .build()
                )
                .build()

        assertThat(drawRetrieveResponse.draw())
            .isEqualTo(
                DrawDetail.builder()
                    .id("42")
                    .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                    .status("completed")
                    .totalEntries(250L)
                    .tweetAuthorUsername("elonmusk")
                    .tweetId("1234567890")
                    .tweetLikeCount(50000L)
                    .tweetQuoteCount(5000L)
                    .tweetReplyCount(10000L)
                    .tweetRetweetCount(25000L)
                    .tweetText("Giving away 3 Tesla Model 3s!")
                    .tweetUrl("https://x.com/elonmusk/status/1234567890")
                    .validEntries(200L)
                    .drawnAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
        assertThat(drawRetrieveResponse.winners())
            .containsExactly(
                Winner.builder()
                    .authorUsername("authorUsername")
                    .isBackup(true)
                    .position(0L)
                    .tweetId("tweetId")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val drawRetrieveResponse =
            DrawRetrieveResponse.builder()
                .draw(
                    DrawDetail.builder()
                        .id("42")
                        .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .status("completed")
                        .totalEntries(250L)
                        .tweetAuthorUsername("elonmusk")
                        .tweetId("1234567890")
                        .tweetLikeCount(50000L)
                        .tweetQuoteCount(5000L)
                        .tweetReplyCount(10000L)
                        .tweetRetweetCount(25000L)
                        .tweetText("Giving away 3 Tesla Model 3s!")
                        .tweetUrl("https://x.com/elonmusk/status/1234567890")
                        .validEntries(200L)
                        .drawnAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .addWinner(
                    Winner.builder()
                        .authorUsername("authorUsername")
                        .isBackup(true)
                        .position(0L)
                        .tweetId("tweetId")
                        .build()
                )
                .build()

        val roundtrippedDrawRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(drawRetrieveResponse),
                jacksonTypeRef<DrawRetrieveResponse>(),
            )

        assertThat(roundtrippedDrawRetrieveResponse).isEqualTo(drawRetrieveResponse)
    }
}
