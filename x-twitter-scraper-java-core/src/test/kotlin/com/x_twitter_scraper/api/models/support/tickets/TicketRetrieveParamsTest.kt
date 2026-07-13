// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.support.tickets

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TicketRetrieveParamsTest {

    @Test
    fun create() {
        TicketRetrieveParams.builder().id("tkt_a1b2c3d4e5f6a1b2c3d4e5f6").build()
    }

    @Test
    fun pathParams() {
        val params = TicketRetrieveParams.builder().id("tkt_a1b2c3d4e5f6a1b2c3d4e5f6").build()

        assertThat(params._pathParam(0)).isEqualTo("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
