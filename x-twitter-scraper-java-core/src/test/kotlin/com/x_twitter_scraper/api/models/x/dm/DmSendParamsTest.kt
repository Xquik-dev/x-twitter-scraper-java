// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.dm

import com.x_twitter_scraper.api.core.http.Headers
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DmSendParamsTest {

    @Test
    fun create() {
        DmSendParams.builder()
            .userId("userId")
            .idempotencyKey("Idempotency-Key")
            .account("@elonmusk")
            .text("Example text content")
            .addMediaId("1234567890123456789")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            DmSendParams.builder()
                .userId("userId")
                .idempotencyKey("Idempotency-Key")
                .account("@elonmusk")
                .text("Example text content")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("userId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            DmSendParams.builder()
                .userId("userId")
                .idempotencyKey("Idempotency-Key")
                .account("@elonmusk")
                .text("Example text content")
                .addMediaId("1234567890123456789")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "Idempotency-Key").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            DmSendParams.builder()
                .userId("userId")
                .idempotencyKey("Idempotency-Key")
                .account("@elonmusk")
                .text("Example text content")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "Idempotency-Key").build())
    }

    @Test
    fun body() {
        val params =
            DmSendParams.builder()
                .userId("userId")
                .idempotencyKey("Idempotency-Key")
                .account("@elonmusk")
                .text("Example text content")
                .addMediaId("1234567890123456789")
                .build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("@elonmusk")
        assertThat(body.text()).isEqualTo("Example text content")
        assertThat(body.mediaIds().getOrNull()).containsExactly("1234567890123456789")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            DmSendParams.builder()
                .userId("userId")
                .idempotencyKey("Idempotency-Key")
                .account("@elonmusk")
                .text("Example text content")
                .build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("@elonmusk")
        assertThat(body.text()).isEqualTo("Example text content")
    }
}
