// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.support.tickets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TicketReplyResponseTest {

    @Test
    fun create() {
        val ticketReplyResponse = TicketReplyResponse.builder().publicId("tk_abc123").build()

        assertThat(ticketReplyResponse.publicId()).contains("tk_abc123")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val ticketReplyResponse = TicketReplyResponse.builder().publicId("tk_abc123").build()

        val roundtrippedTicketReplyResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(ticketReplyResponse),
                jacksonTypeRef<TicketReplyResponse>(),
            )

        assertThat(roundtrippedTicketReplyResponse).isEqualTo(ticketReplyResponse)
    }
}
