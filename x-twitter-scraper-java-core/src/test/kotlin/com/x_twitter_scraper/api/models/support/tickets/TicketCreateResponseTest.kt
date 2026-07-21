// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.support.tickets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TicketCreateResponseTest {

    @Test
    fun create() {
        val ticketCreateResponse =
            TicketCreateResponse.builder()
                .addAttachment(
                    TicketCreateResponse.Attachment.builder()
                        .publicId("att_a1b2c3d4e5f6a1b2c3d4e5f6")
                        .status(TicketCreateResponse.Attachment.Status.PENDING)
                        .build()
                )
                .publicId("publicId")
                .build()

        assertThat(ticketCreateResponse.attachments().getOrNull())
            .containsExactly(
                TicketCreateResponse.Attachment.builder()
                    .publicId("att_a1b2c3d4e5f6a1b2c3d4e5f6")
                    .status(TicketCreateResponse.Attachment.Status.PENDING)
                    .build()
            )
        assertThat(ticketCreateResponse.publicId()).contains("publicId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val ticketCreateResponse =
            TicketCreateResponse.builder()
                .addAttachment(
                    TicketCreateResponse.Attachment.builder()
                        .publicId("att_a1b2c3d4e5f6a1b2c3d4e5f6")
                        .status(TicketCreateResponse.Attachment.Status.PENDING)
                        .build()
                )
                .publicId("publicId")
                .build()

        val roundtrippedTicketCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(ticketCreateResponse),
                jacksonTypeRef<TicketCreateResponse>(),
            )

        assertThat(roundtrippedTicketCreateResponse).isEqualTo(ticketCreateResponse)
    }
}
