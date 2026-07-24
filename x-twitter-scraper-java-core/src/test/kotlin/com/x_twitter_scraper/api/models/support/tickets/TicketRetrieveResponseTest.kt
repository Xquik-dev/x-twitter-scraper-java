// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

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
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addMessage(
                    TicketRetrieveResponse.Message.builder()
                        .addAttachment(
                            TicketRetrieveResponse.Message.Attachment.builder()
                                .contentType(
                                    TicketRetrieveResponse.Message.Attachment.ContentType.IMAGE_JPEG
                                )
                                .filename("screen.png")
                                .kind(TicketRetrieveResponse.Message.Attachment.Kind.IMAGE)
                                .publicId("att_a1b2c3d4e5f6a1b2c3d4e5f6")
                                .sizeBytes(204800L)
                                .status(TicketRetrieveResponse.Message.Attachment.Status.READY)
                                .url("/api/v1/support/attachments/att_a1b2c3d4e5f6a1b2c3d4e5f6")
                                .build()
                        )
                        .body("I am unable to connect my X account.")
                        .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .sender("user")
                        .build()
                )
                .publicId("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")
                .status("open")
                .subject("Cannot connect X account")
                .updatedAt(OffsetDateTime.parse("2025-01-16T09:30:00Z"))
                .build()

        assertThat(ticketRetrieveResponse.createdAt())
            .contains(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(ticketRetrieveResponse.messages().getOrNull())
            .containsExactly(
                TicketRetrieveResponse.Message.builder()
                    .addAttachment(
                        TicketRetrieveResponse.Message.Attachment.builder()
                            .contentType(
                                TicketRetrieveResponse.Message.Attachment.ContentType.IMAGE_JPEG
                            )
                            .filename("screen.png")
                            .kind(TicketRetrieveResponse.Message.Attachment.Kind.IMAGE)
                            .publicId("att_a1b2c3d4e5f6a1b2c3d4e5f6")
                            .sizeBytes(204800L)
                            .status(TicketRetrieveResponse.Message.Attachment.Status.READY)
                            .url("/api/v1/support/attachments/att_a1b2c3d4e5f6a1b2c3d4e5f6")
                            .build()
                    )
                    .body("I am unable to connect my X account.")
                    .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                    .sender("user")
                    .build()
            )
        assertThat(ticketRetrieveResponse.publicId()).contains("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")
        assertThat(ticketRetrieveResponse.status()).contains("open")
        assertThat(ticketRetrieveResponse.subject()).contains("Cannot connect X account")
        assertThat(ticketRetrieveResponse.updatedAt())
            .contains(OffsetDateTime.parse("2025-01-16T09:30:00Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val ticketRetrieveResponse =
            TicketRetrieveResponse.builder()
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addMessage(
                    TicketRetrieveResponse.Message.builder()
                        .addAttachment(
                            TicketRetrieveResponse.Message.Attachment.builder()
                                .contentType(
                                    TicketRetrieveResponse.Message.Attachment.ContentType.IMAGE_JPEG
                                )
                                .filename("screen.png")
                                .kind(TicketRetrieveResponse.Message.Attachment.Kind.IMAGE)
                                .publicId("att_a1b2c3d4e5f6a1b2c3d4e5f6")
                                .sizeBytes(204800L)
                                .status(TicketRetrieveResponse.Message.Attachment.Status.READY)
                                .url("/api/v1/support/attachments/att_a1b2c3d4e5f6a1b2c3d4e5f6")
                                .build()
                        )
                        .body("I am unable to connect my X account.")
                        .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .sender("user")
                        .build()
                )
                .publicId("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")
                .status("open")
                .subject("Cannot connect X account")
                .updatedAt(OffsetDateTime.parse("2025-01-16T09:30:00Z"))
                .build()

        val roundtrippedTicketRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(ticketRetrieveResponse),
                jacksonTypeRef<TicketRetrieveResponse>(),
            )

        assertThat(roundtrippedTicketRetrieveResponse).isEqualTo(ticketRetrieveResponse)
    }
}
