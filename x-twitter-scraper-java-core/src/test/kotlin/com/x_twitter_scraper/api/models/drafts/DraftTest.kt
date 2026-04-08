// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.drafts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DraftTest {

    @Test
    fun create() {
        val draft =
            Draft.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .text("Draft tweet about AI trends")
                .goal("Engagement")
                .topic("Technology")
                .build()

        assertThat(draft.id()).isEqualTo("42")
        assertThat(draft.createdAt()).isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(draft.text()).isEqualTo("Draft tweet about AI trends")
        assertThat(draft.goal()).contains("Engagement")
        assertThat(draft.topic()).contains("Technology")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val draft =
            Draft.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .text("Draft tweet about AI trends")
                .goal("Engagement")
                .topic("Technology")
                .build()

        val roundtrippedDraft =
            jsonMapper.readValue(jsonMapper.writeValueAsString(draft), jacksonTypeRef<Draft>())

        assertThat(roundtrippedDraft).isEqualTo(draft)
    }
}
