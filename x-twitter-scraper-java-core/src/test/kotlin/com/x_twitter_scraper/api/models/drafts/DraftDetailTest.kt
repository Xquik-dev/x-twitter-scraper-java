// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.drafts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DraftDetailTest {

    @Test
    fun create() {
        val draftDetail =
            DraftDetail.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .text("Draft tweet about AI trends")
                .updatedAt(OffsetDateTime.parse("2025-01-16T09:30:00Z"))
                .goal("Engagement")
                .topic("Technology")
                .build()

        assertThat(draftDetail.id()).isEqualTo("42")
        assertThat(draftDetail.createdAt()).isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(draftDetail.text()).isEqualTo("Draft tweet about AI trends")
        assertThat(draftDetail.updatedAt()).isEqualTo(OffsetDateTime.parse("2025-01-16T09:30:00Z"))
        assertThat(draftDetail.goal()).contains("Engagement")
        assertThat(draftDetail.topic()).contains("Technology")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val draftDetail =
            DraftDetail.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .text("Draft tweet about AI trends")
                .updatedAt(OffsetDateTime.parse("2025-01-16T09:30:00Z"))
                .goal("Engagement")
                .topic("Technology")
                .build()

        val roundtrippedDraftDetail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(draftDetail),
                jacksonTypeRef<DraftDetail>(),
            )

        assertThat(roundtrippedDraftDetail).isEqualTo(draftDetail)
    }
}
