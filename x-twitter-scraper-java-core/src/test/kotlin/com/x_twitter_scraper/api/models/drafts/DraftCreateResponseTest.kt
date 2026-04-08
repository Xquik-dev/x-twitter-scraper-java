// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.drafts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DraftCreateResponseTest {

    @Test
    fun create() {
        val draftCreateResponse =
            DraftCreateResponse.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .text("Draft tweet about AI trends")
                .updatedAt(OffsetDateTime.parse("2025-01-16T09:30:00Z"))
                .goal("Engagement")
                .topic("Technology")
                .build()

        assertThat(draftCreateResponse.id()).isEqualTo("42")
        assertThat(draftCreateResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(draftCreateResponse.text()).isEqualTo("Draft tweet about AI trends")
        assertThat(draftCreateResponse.updatedAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-16T09:30:00Z"))
        assertThat(draftCreateResponse.goal()).contains("Engagement")
        assertThat(draftCreateResponse.topic()).contains("Technology")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val draftCreateResponse =
            DraftCreateResponse.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .text("Draft tweet about AI trends")
                .updatedAt(OffsetDateTime.parse("2025-01-16T09:30:00Z"))
                .goal("Engagement")
                .topic("Technology")
                .build()

        val roundtrippedDraftCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(draftCreateResponse),
                jacksonTypeRef<DraftCreateResponse>(),
            )

        assertThat(roundtrippedDraftCreateResponse).isEqualTo(draftCreateResponse)
    }
}
