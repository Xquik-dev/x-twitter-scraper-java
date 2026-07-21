// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.communities.join

import com.x_twitter_scraper.api.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JoinDeleteAllParamsTest {

    @Test
    fun create() {
        JoinDeleteAllParams.builder()
            .id("id")
            .idempotencyKey("Idempotency-Key")
            .account("@elonmusk")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            JoinDeleteAllParams.builder()
                .id("id")
                .idempotencyKey("Idempotency-Key")
                .account("@elonmusk")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            JoinDeleteAllParams.builder()
                .id("id")
                .idempotencyKey("Idempotency-Key")
                .account("@elonmusk")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "Idempotency-Key").build())
    }

    @Test
    fun body() {
        val params =
            JoinDeleteAllParams.builder()
                .id("id")
                .idempotencyKey("Idempotency-Key")
                .account("@elonmusk")
                .build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("@elonmusk")
    }
}
