// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.draws

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DrawListItemTest {

    @Test
    fun create() {
        val drawListItem =
            DrawListItem.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status("status")
                .totalEntries(0L)
                .tweetUrl("https://example.com")
                .validEntries(0L)
                .drawnAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(drawListItem.id()).isEqualTo("id")
        assertThat(drawListItem.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(drawListItem.status()).isEqualTo("status")
        assertThat(drawListItem.totalEntries()).isEqualTo(0L)
        assertThat(drawListItem.tweetUrl()).isEqualTo("https://example.com")
        assertThat(drawListItem.validEntries()).isEqualTo(0L)
        assertThat(drawListItem.drawnAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val drawListItem =
            DrawListItem.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status("status")
                .totalEntries(0L)
                .tweetUrl("https://example.com")
                .validEntries(0L)
                .drawnAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedDrawListItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(drawListItem),
                jacksonTypeRef<DrawListItem>(),
            )

        assertThat(roundtrippedDrawListItem).isEqualTo(drawListItem)
    }
}
