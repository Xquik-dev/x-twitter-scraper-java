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
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .text("text")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .goal("goal")
                .topic("topic")
                .build()

        assertThat(draftDetail.id()).isEqualTo("id")
        assertThat(draftDetail.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(draftDetail.text()).isEqualTo("text")
        assertThat(draftDetail.updatedAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(draftDetail.goal()).contains("goal")
        assertThat(draftDetail.topic()).contains("topic")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val draftDetail =
            DraftDetail.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .text("text")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .goal("goal")
                .topic("topic")
                .build()

        val roundtrippedDraftDetail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(draftDetail),
                jacksonTypeRef<DraftDetail>(),
            )

        assertThat(roundtrippedDraftDetail).isEqualTo(draftDetail)
    }
}
