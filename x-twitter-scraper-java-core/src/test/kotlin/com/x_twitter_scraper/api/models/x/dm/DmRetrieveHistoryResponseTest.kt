// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.dm

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DmRetrieveHistoryResponseTest {

    @Test
    fun create() {
        val dmRetrieveHistoryResponse =
            DmRetrieveHistoryResponse.builder()
                .hasNextPage(true)
                .addMessage(
                    DmRetrieveHistoryResponse.Message.builder()
                        .id("id")
                        .createdAt("createdAt")
                        .receiverId("receiverId")
                        .senderId("senderId")
                        .text("text")
                        .build()
                )
                .nextCursor("next_cursor")
                .build()

        assertThat(dmRetrieveHistoryResponse.hasNextPage()).isEqualTo(true)
        assertThat(dmRetrieveHistoryResponse.messages())
            .containsExactly(
                DmRetrieveHistoryResponse.Message.builder()
                    .id("id")
                    .createdAt("createdAt")
                    .receiverId("receiverId")
                    .senderId("senderId")
                    .text("text")
                    .build()
            )
        assertThat(dmRetrieveHistoryResponse.nextCursor()).isEqualTo("next_cursor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val dmRetrieveHistoryResponse =
            DmRetrieveHistoryResponse.builder()
                .hasNextPage(true)
                .addMessage(
                    DmRetrieveHistoryResponse.Message.builder()
                        .id("id")
                        .createdAt("createdAt")
                        .receiverId("receiverId")
                        .senderId("senderId")
                        .text("text")
                        .build()
                )
                .nextCursor("next_cursor")
                .build()

        val roundtrippedDmRetrieveHistoryResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(dmRetrieveHistoryResponse),
                jacksonTypeRef<DmRetrieveHistoryResponse>(),
            )

        assertThat(roundtrippedDmRetrieveHistoryResponse).isEqualTo(dmRetrieveHistoryResponse)
    }
}
