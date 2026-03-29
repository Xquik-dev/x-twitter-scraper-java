// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.support.tickets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TicketReplyResponseTest {

    @Test
    fun create() {
        val ticketReplyResponse = TicketReplyResponse.builder().publicId("publicId").build()

        assertThat(ticketReplyResponse.publicId()).contains("publicId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val ticketReplyResponse = TicketReplyResponse.builder().publicId("publicId").build()

        val roundtrippedTicketReplyResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(ticketReplyResponse),
                jacksonTypeRef<TicketReplyResponse>(),
            )

        assertThat(roundtrippedTicketReplyResponse).isEqualTo(ticketReplyResponse)
    }
}
