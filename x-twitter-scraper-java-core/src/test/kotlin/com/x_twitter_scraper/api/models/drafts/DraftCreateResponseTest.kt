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
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .text("text")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .goal("goal")
                .topic("topic")
                .build()

        assertThat(draftCreateResponse.id()).isEqualTo("id")
        assertThat(draftCreateResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(draftCreateResponse.text()).isEqualTo("text")
        assertThat(draftCreateResponse.updatedAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(draftCreateResponse.goal()).contains("goal")
        assertThat(draftCreateResponse.topic()).contains("topic")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val draftCreateResponse =
            DraftCreateResponse.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .text("text")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .goal("goal")
                .topic("topic")
                .build()

        val roundtrippedDraftCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(draftCreateResponse),
                jacksonTypeRef<DraftCreateResponse>(),
            )

        assertThat(roundtrippedDraftCreateResponse).isEqualTo(draftCreateResponse)
    }
}
