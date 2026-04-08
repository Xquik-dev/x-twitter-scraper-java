// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.support.tickets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TicketListResponseTest {

    @Test
    fun create() {
        val ticketListResponse =
            TicketListResponse.builder()
                .addTicket(
                    TicketListResponse.Ticket.builder()
                        .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .messageCount(2L)
                        .publicId("tk_abc123")
                        .status("open")
                        .subject("Cannot connect X account")
                        .updatedAt(OffsetDateTime.parse("2025-01-16T09:30:00Z"))
                        .build()
                )
                .build()

        assertThat(ticketListResponse.tickets().getOrNull())
            .containsExactly(
                TicketListResponse.Ticket.builder()
                    .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                    .messageCount(2L)
                    .publicId("tk_abc123")
                    .status("open")
                    .subject("Cannot connect X account")
                    .updatedAt(OffsetDateTime.parse("2025-01-16T09:30:00Z"))
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val ticketListResponse =
            TicketListResponse.builder()
                .addTicket(
                    TicketListResponse.Ticket.builder()
                        .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .messageCount(2L)
                        .publicId("tk_abc123")
                        .status("open")
                        .subject("Cannot connect X account")
                        .updatedAt(OffsetDateTime.parse("2025-01-16T09:30:00Z"))
                        .build()
                )
                .build()

        val roundtrippedTicketListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(ticketListResponse),
                jacksonTypeRef<TicketListResponse>(),
            )

        assertThat(roundtrippedTicketListResponse).isEqualTo(ticketListResponse)
    }
}
