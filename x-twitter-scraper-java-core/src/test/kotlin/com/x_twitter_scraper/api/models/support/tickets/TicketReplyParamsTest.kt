// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.support.tickets

import com.x_twitter_scraper.api.core.MultipartField
import com.x_twitter_scraper.api.core.http.Headers
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TicketReplyParamsTest {

    @Test
    fun create() {
        TicketReplyParams.builder()
            .id("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")
            .idempotencyKey("Idempotency-Key")
            .body("Thank you for the update.")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            TicketReplyParams.builder()
                .id("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")
                .body("Thank you for the update.")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            TicketReplyParams.builder()
                .id("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")
                .idempotencyKey("Idempotency-Key")
                .body("Thank you for the update.")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "Idempotency-Key").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            TicketReplyParams.builder()
                .id("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")
                .body("Thank you for the update.")
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            TicketReplyParams.builder()
                .id("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")
                .idempotencyKey("Idempotency-Key")
                .body("Thank you for the update.")
                .build()

        val body = params._body()

        assertThat(body.filterValues { !it.value.isNull() })
            .usingRecursiveComparison()
            // TODO(AssertJ): Replace this and the `mapValues` below with:
            // https://github.com/assertj/assertj/issues/3165
            .withEqualsForType(
                { a, b -> a.readBytes() contentEquals b.readBytes() },
                InputStream::class.java,
            )
            .isEqualTo(
                mapOf("body" to MultipartField.of("Thank you for the update.")).mapValues {
                    (_, field) ->
                    field.map { (it as? ByteArray)?.inputStream() ?: it }
                }
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            TicketReplyParams.builder()
                .id("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")
                .body("Thank you for the update.")
                .build()

        val body = params._body()

        assertThat(body.filterValues { !it.value.isNull() })
            .usingRecursiveComparison()
            // TODO(AssertJ): Replace this and the `mapValues` below with:
            // https://github.com/assertj/assertj/issues/3165
            .withEqualsForType(
                { a, b -> a.readBytes() contentEquals b.readBytes() },
                InputStream::class.java,
            )
            .isEqualTo(
                mapOf("body" to MultipartField.of("Thank you for the update.")).mapValues {
                    (_, field) ->
                    field.map { (it as? ByteArray)?.inputStream() ?: it }
                }
            )
    }
}
