// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.drafts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DraftListResponseTest {

    @Test
    fun create() {
        val draftListResponse =
            DraftListResponse.builder()
                .addDraft(
                    DraftListResponse.Draft.builder()
                        .id("42")
                        .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .text("Draft tweet about AI trends")
                        .goal("Engagement")
                        .topic("Technology")
                        .build()
                )
                .hasMore(false)
                .nextCursor("abc123")
                .build()

        assertThat(draftListResponse.drafts())
            .containsExactly(
                DraftListResponse.Draft.builder()
                    .id("42")
                    .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                    .text("Draft tweet about AI trends")
                    .goal("Engagement")
                    .topic("Technology")
                    .build()
            )
        assertThat(draftListResponse.hasMore()).isEqualTo(false)
        assertThat(draftListResponse.nextCursor()).contains("abc123")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val draftListResponse =
            DraftListResponse.builder()
                .addDraft(
                    DraftListResponse.Draft.builder()
                        .id("42")
                        .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .text("Draft tweet about AI trends")
                        .goal("Engagement")
                        .topic("Technology")
                        .build()
                )
                .hasMore(false)
                .nextCursor("abc123")
                .build()

        val roundtrippedDraftListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(draftListResponse),
                jacksonTypeRef<DraftListResponse>(),
            )

        assertThat(roundtrippedDraftListResponse).isEqualTo(draftListResponse)
    }
}
