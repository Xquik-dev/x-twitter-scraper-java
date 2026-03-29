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
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .text("text")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .goal("goal")
                .topic("topic")
                .build()

        assertThat(draftRetrieveResponse.id()).isEqualTo("id")
        assertThat(draftRetrieveResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(draftRetrieveResponse.text()).isEqualTo("text")
        assertThat(draftRetrieveResponse.updatedAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(draftRetrieveResponse.goal()).contains("goal")
        assertThat(draftRetrieveResponse.topic()).contains("topic")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val draftRetrieveResponse =
            DraftRetrieveResponse.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .text("text")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .goal("goal")
                .topic("topic")
                .build()

        val roundtrippedDraftRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(draftRetrieveResponse),
                jacksonTypeRef<DraftRetrieveResponse>(),
            )

        assertThat(roundtrippedDraftRetrieveResponse).isEqualTo(draftRetrieveResponse)
    }
}
