// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.support.tickets

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TicketCreateParamsTest {

    @Test
    fun create() {
        TicketCreateParams.builder().body("body").subject("subject").build()
    }

    @Test
    fun body() {
        val params = TicketCreateParams.builder().body("body").subject("subject").build()

        val body = params._body()

        assertThat(body.body()).isEqualTo("body")
        assertThat(body.subject()).isEqualTo("subject")
    }
}
