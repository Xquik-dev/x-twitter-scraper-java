// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.support.tickets

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TicketUpdateParamsTest {

    @Test
    fun create() {
        TicketUpdateParams.builder()
            .id("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")
            .status(TicketUpdateParams.Status.RESOLVED)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            TicketUpdateParams.builder()
                .id("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")
                .status(TicketUpdateParams.Status.RESOLVED)
                .build()

        assertThat(params._pathParam(0)).isEqualTo("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            TicketUpdateParams.builder()
                .id("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")
                .status(TicketUpdateParams.Status.RESOLVED)
                .build()

        val body = params._body()

        assertThat(body.status()).isEqualTo(TicketUpdateParams.Status.RESOLVED)
    }
}
