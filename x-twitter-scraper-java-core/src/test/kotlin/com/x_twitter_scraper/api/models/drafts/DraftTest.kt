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
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .text("text")
                .goal("goal")
                .topic("topic")
                .build()

        assertThat(draft.id()).isEqualTo("id")
        assertThat(draft.createdAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(draft.text()).isEqualTo("text")
        assertThat(draft.goal()).contains("goal")
        assertThat(draft.topic()).contains("topic")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val draft =
            Draft.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .text("text")
                .goal("goal")
                .topic("topic")
                .build()

        val roundtrippedDraft =
            jsonMapper.readValue(jsonMapper.writeValueAsString(draft), jacksonTypeRef<Draft>())

        assertThat(roundtrippedDraft).isEqualTo(draft)
    }
}
