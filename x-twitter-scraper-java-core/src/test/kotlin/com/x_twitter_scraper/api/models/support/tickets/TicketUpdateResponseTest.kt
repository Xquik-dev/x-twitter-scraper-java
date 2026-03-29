// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.support.tickets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TicketUpdateResponseTest {

    @Test
    fun create() {
        val ticketUpdateResponse =
            TicketUpdateResponse.builder().publicId("publicId").status("status").build()

        assertThat(ticketUpdateResponse.publicId()).contains("publicId")
        assertThat(ticketUpdateResponse.status()).contains("status")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val ticketUpdateResponse =
            TicketUpdateResponse.builder().publicId("publicId").status("status").build()

        val roundtrippedTicketUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(ticketUpdateResponse),
                jacksonTypeRef<TicketUpdateResponse>(),
            )

        assertThat(roundtrippedTicketUpdateResponse).isEqualTo(ticketUpdateResponse)
    }
}
