// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

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
            TicketUpdateResponse.builder()
                .publicId("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")
                .status(TicketUpdateResponse.Status.RESOLVED)
                .build()

        assertThat(ticketUpdateResponse.publicId()).isEqualTo("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")
        assertThat(ticketUpdateResponse.status()).isEqualTo(TicketUpdateResponse.Status.RESOLVED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val ticketUpdateResponse =
            TicketUpdateResponse.builder()
                .publicId("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")
                .status(TicketUpdateResponse.Status.RESOLVED)
                .build()

        val roundtrippedTicketUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(ticketUpdateResponse),
                jacksonTypeRef<TicketUpdateResponse>(),
            )

        assertThat(roundtrippedTicketUpdateResponse).isEqualTo(ticketUpdateResponse)
    }
}
