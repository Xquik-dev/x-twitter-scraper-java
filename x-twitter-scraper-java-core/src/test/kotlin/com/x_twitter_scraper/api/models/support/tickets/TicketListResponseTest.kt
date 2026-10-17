// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.support.tickets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
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
                        .publicId("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")
                        .status(TicketListResponse.Ticket.Status.OPEN)
                        .subject("Cannot connect X account")
                        .updatedAt(OffsetDateTime.parse("2025-01-16T09:30:00Z"))
                        .build()
                )
                .build()

        assertThat(ticketListResponse.tickets())
            .containsExactly(
                TicketListResponse.Ticket.builder()
                    .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                    .messageCount(2L)
                    .publicId("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")
                    .status(TicketListResponse.Ticket.Status.OPEN)
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
                        .publicId("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")
                        .status(TicketListResponse.Ticket.Status.OPEN)
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

    @Test
    fun additionalFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json = """{"hasMore":true,"nextCursor":"sample"}"""
        val model = jsonMapper.readValue(json, jacksonTypeRef<TicketListResponse>())

        assertThat(model.hasMore()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("hasMore")
        assertThat(model.nextCursor()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("nextCursor")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<TicketListResponse>(),
                )
            )
            .isEqualTo(model)
    }
}
