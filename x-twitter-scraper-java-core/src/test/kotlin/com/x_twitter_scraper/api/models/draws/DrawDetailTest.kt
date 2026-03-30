// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.draws

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DrawDetailTest {

    @Test
    fun create() {
        val drawDetail =
            DrawDetail.builder()
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

        assertThat(drawDetail.id()).isEqualTo("id")
        assertThat(drawDetail.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(drawDetail.status()).isEqualTo("status")
        assertThat(drawDetail.totalEntries()).isEqualTo(0L)
        assertThat(drawDetail.tweetAuthorUsername()).isEqualTo("tweetAuthorUsername")
        assertThat(drawDetail.tweetId()).isEqualTo("tweetId")
        assertThat(drawDetail.tweetLikeCount()).isEqualTo(0L)
        assertThat(drawDetail.tweetQuoteCount()).isEqualTo(0L)
        assertThat(drawDetail.tweetReplyCount()).isEqualTo(0L)
        assertThat(drawDetail.tweetRetweetCount()).isEqualTo(0L)
        assertThat(drawDetail.tweetText()).isEqualTo("tweetText")
        assertThat(drawDetail.tweetUrl()).isEqualTo("https://example.com")
        assertThat(drawDetail.validEntries()).isEqualTo(0L)
        assertThat(drawDetail.drawnAt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val drawDetail =
            DrawDetail.builder()
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

        val roundtrippedDrawDetail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(drawDetail),
                jacksonTypeRef<DrawDetail>(),
            )

        assertThat(roundtrippedDrawDetail).isEqualTo(drawDetail)
    }
}
