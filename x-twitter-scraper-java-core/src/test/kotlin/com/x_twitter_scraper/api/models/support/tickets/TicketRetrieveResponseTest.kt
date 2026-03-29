// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.support.tickets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TicketRetrieveResponseTest {

    @Test
    fun create() {
        val ticketRetrieveResponse =
            TicketRetrieveResponse.builder()
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addMessage(
                    TicketRetrieveResponse.Message.builder()
                        .body("body")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .sender("sender")
                        .build()
                )
                .publicId("publicId")
                .status("status")
                .subject("subject")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(ticketRetrieveResponse.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(ticketRetrieveResponse.messages().getOrNull())
            .containsExactly(
                TicketRetrieveResponse.Message.builder()
                    .body("body")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .sender("sender")
                    .build()
            )
        assertThat(ticketRetrieveResponse.publicId()).contains("publicId")
        assertThat(ticketRetrieveResponse.status()).contains("status")
        assertThat(ticketRetrieveResponse.subject()).contains("subject")
        assertThat(ticketRetrieveResponse.updatedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val ticketRetrieveResponse =
            TicketRetrieveResponse.builder()
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addMessage(
                    TicketRetrieveResponse.Message.builder()
                        .body("body")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .sender("sender")
                        .build()
                )
                .publicId("publicId")
                .status("status")
                .subject("subject")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedTicketRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(ticketRetrieveResponse),
                jacksonTypeRef<TicketRetrieveResponse>(),
            )

        assertThat(roundtrippedTicketRetrieveResponse).isEqualTo(ticketRetrieveResponse)
    }
}
