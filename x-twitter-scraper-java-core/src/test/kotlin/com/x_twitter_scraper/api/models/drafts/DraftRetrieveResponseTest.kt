// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.drafts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DraftRetrieveResponseTest {

    @Test
    fun create() {
        val draftRetrieveResponse =
            DraftRetrieveResponse.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .text("Draft tweet about AI trends")
                .updatedAt(OffsetDateTime.parse("2025-01-16T09:30:00Z"))
                .goal("Engagement")
                .topic("Technology")
                .build()

        assertThat(draftRetrieveResponse.id()).isEqualTo("42")
        assertThat(draftRetrieveResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(draftRetrieveResponse.text()).isEqualTo("Draft tweet about AI trends")
        assertThat(draftRetrieveResponse.updatedAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-16T09:30:00Z"))
        assertThat(draftRetrieveResponse.goal()).contains("Engagement")
        assertThat(draftRetrieveResponse.topic()).contains("Technology")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val draftRetrieveResponse =
            DraftRetrieveResponse.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .text("Draft tweet about AI trends")
                .updatedAt(OffsetDateTime.parse("2025-01-16T09:30:00Z"))
                .goal("Engagement")
                .topic("Technology")
                .build()

        val roundtrippedDraftRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(draftRetrieveResponse),
                jacksonTypeRef<DraftRetrieveResponse>(),
            )

        assertThat(roundtrippedDraftRetrieveResponse).isEqualTo(draftRetrieveResponse)
    }
}
