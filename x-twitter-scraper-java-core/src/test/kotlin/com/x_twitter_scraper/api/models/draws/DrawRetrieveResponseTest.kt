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
                    DrawRetrieveResponse.Draw.builder()
                        .id("id")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .status("status")
                        .totalEntries(0L)
                        .tweetAuthorUsername("tweetAuthorUsername")
                        .tweetId("tweetId")
                        .tweetLikeCount(0L)
                        .tweetQuoteCount(0L)
                        .tweetReplyCount(0L)
                        .tweetRetweetCount(0L)
                        .tweetText("tweetText")
                        .tweetUrl("https://example.com")
                        .validEntries(0L)
                        .drawnAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .addWinner(
                    DrawRetrieveResponse.Winner.builder()
                        .authorUsername("authorUsername")
                        .isBackup(true)
                        .position(0L)
                        .tweetId("tweetId")
                        .build()
                )
                .build()

        assertThat(drawRetrieveResponse.draw())
            .isEqualTo(
                DrawRetrieveResponse.Draw.builder()
                    .id("id")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .status("status")
                    .totalEntries(0L)
                    .tweetAuthorUsername("tweetAuthorUsername")
                    .tweetId("tweetId")
                    .tweetLikeCount(0L)
                    .tweetQuoteCount(0L)
                    .tweetReplyCount(0L)
                    .tweetRetweetCount(0L)
                    .tweetText("tweetText")
                    .tweetUrl("https://example.com")
                    .validEntries(0L)
                    .drawnAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
        assertThat(drawRetrieveResponse.winners())
            .containsExactly(
                DrawRetrieveResponse.Winner.builder()
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
                    DrawRetrieveResponse.Draw.builder()
                        .id("id")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .status("status")
                        .totalEntries(0L)
                        .tweetAuthorUsername("tweetAuthorUsername")
                        .tweetId("tweetId")
                        .tweetLikeCount(0L)
                        .tweetQuoteCount(0L)
                        .tweetReplyCount(0L)
                        .tweetRetweetCount(0L)
                        .tweetText("tweetText")
                        .tweetUrl("https://example.com")
                        .validEntries(0L)
                        .drawnAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .addWinner(
                    DrawRetrieveResponse.Winner.builder()
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
