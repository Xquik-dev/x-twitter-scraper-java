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
                        .id("1234567890123456789")
                        .createdAt("2025-01-15T12:00:00Z")
                        .receiverId("1234567890")
                        .senderId("9876543210")
                        .text("Hey, how are you?")
                        .build()
                )
                .nextCursor("DAACCgACGRElMJcAAA")
                .build()

        assertThat(dmRetrieveHistoryResponse.hasNextPage()).isEqualTo(true)
        assertThat(dmRetrieveHistoryResponse.messages())
            .containsExactly(
                DmRetrieveHistoryResponse.Message.builder()
                    .id("1234567890123456789")
                    .createdAt("2025-01-15T12:00:00Z")
                    .receiverId("1234567890")
                    .senderId("9876543210")
                    .text("Hey, how are you?")
                    .build()
            )
        assertThat(dmRetrieveHistoryResponse.nextCursor()).isEqualTo("DAACCgACGRElMJcAAA")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val dmRetrieveHistoryResponse =
            DmRetrieveHistoryResponse.builder()
                .hasNextPage(true)
                .addMessage(
                    DmRetrieveHistoryResponse.Message.builder()
                        .id("1234567890123456789")
                        .createdAt("2025-01-15T12:00:00Z")
                        .receiverId("1234567890")
                        .senderId("9876543210")
                        .text("Hey, how are you?")
                        .build()
                )
                .nextCursor("DAACCgACGRElMJcAAA")
                .build()

        val roundtrippedDmRetrieveHistoryResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(dmRetrieveHistoryResponse),
                jacksonTypeRef<DmRetrieveHistoryResponse>(),
            )

        assertThat(roundtrippedDmRetrieveHistoryResponse).isEqualTo(dmRetrieveHistoryResponse)
    }
}
