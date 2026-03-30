// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.draws

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DrawListResponseTest {

    @Test
    fun create() {
        val drawListResponse =
            DrawListResponse.builder()
                .addDraw(
                    DrawListItem.builder()
                        .id("id")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .status("status")
                        .totalEntries(0L)
                        .tweetUrl("https://example.com")
                        .validEntries(0L)
                        .drawnAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .hasMore(true)
                .nextCursor("nextCursor")
                .build()

        assertThat(drawListResponse.draws())
            .containsExactly(
                DrawListItem.builder()
                    .id("id")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .status("status")
                    .totalEntries(0L)
                    .tweetUrl("https://example.com")
                    .validEntries(0L)
                    .drawnAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
        assertThat(drawListResponse.hasMore()).isEqualTo(true)
        assertThat(drawListResponse.nextCursor()).contains("nextCursor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val drawListResponse =
            DrawListResponse.builder()
                .addDraw(
                    DrawListItem.builder()
                        .id("id")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .status("status")
                        .totalEntries(0L)
                        .tweetUrl("https://example.com")
                        .validEntries(0L)
                        .drawnAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .hasMore(true)
                .nextCursor("nextCursor")
                .build()

        val roundtrippedDrawListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(drawListResponse),
                jacksonTypeRef<DrawListResponse>(),
            )

        assertThat(roundtrippedDrawListResponse).isEqualTo(drawListResponse)
    }
}
