// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.support.tickets

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TicketCreateParamsTest {

    @Test
    fun create() {
        TicketCreateParams.builder()
            .body("I am unable to connect my X account. Please help.")
            .subject("Cannot connect X account")
            .build()
    }

    @Test
    fun body() {
        val params =
            TicketCreateParams.builder()
                .body("I am unable to connect my X account. Please help.")
                .subject("Cannot connect X account")
                .build()

        val body = params._body()

        assertThat(body.body()).isEqualTo("I am unable to connect my X account. Please help.")
        assertThat(body.subject()).isEqualTo("Cannot connect X account")
    }
}
