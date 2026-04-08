// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.support.tickets

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TicketReplyParamsTest {

    @Test
    fun create() {
        TicketReplyParams.builder().id("id").body("Thank you for the update.").build()
    }

    @Test
    fun pathParams() {
        val params = TicketReplyParams.builder().id("id").body("Thank you for the update.").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params = TicketReplyParams.builder().id("id").body("Thank you for the update.").build()

        val body = params._body()

        assertThat(body.body()).isEqualTo("Thank you for the update.")
    }
}
