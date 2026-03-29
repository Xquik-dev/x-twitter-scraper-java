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
                        .id("id")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .text("text")
                        .goal("goal")
                        .topic("topic")
                        .build()
                )
                .hasMore(true)
                .nextCursor("nextCursor")
                .build()

        assertThat(draftListResponse.drafts())
            .containsExactly(
                DraftListResponse.Draft.builder()
                    .id("id")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .text("text")
                    .goal("goal")
                    .topic("topic")
                    .build()
            )
        assertThat(draftListResponse.hasMore()).isEqualTo(true)
        assertThat(draftListResponse.nextCursor()).contains("nextCursor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val draftListResponse =
            DraftListResponse.builder()
                .addDraft(
                    DraftListResponse.Draft.builder()
                        .id("id")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .text("text")
                        .goal("goal")
                        .topic("topic")
                        .build()
                )
                .hasMore(true)
                .nextCursor("nextCursor")
                .build()

        val roundtrippedDraftListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(draftListResponse),
                jacksonTypeRef<DraftListResponse>(),
            )

        assertThat(roundtrippedDraftListResponse).isEqualTo(draftListResponse)
    }
}
