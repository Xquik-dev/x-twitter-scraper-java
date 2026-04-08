// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.support.tickets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TicketCreateResponseTest {

    @Test
    fun create() {
        val ticketCreateResponse = TicketCreateResponse.builder().publicId("tk_abc123").build()

        assertThat(ticketCreateResponse.publicId()).contains("tk_abc123")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val ticketCreateResponse = TicketCreateResponse.builder().publicId("tk_abc123").build()

        val roundtrippedTicketCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(ticketCreateResponse),
                jacksonTypeRef<TicketCreateResponse>(),
            )

        assertThat(roundtrippedTicketCreateResponse).isEqualTo(ticketCreateResponse)
    }
}
