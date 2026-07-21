// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.support.tickets

import com.x_twitter_scraper.api.core.MultipartField
import com.x_twitter_scraper.api.core.http.Headers
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TicketCreateParamsTest {

    @Test
    fun create() {
        TicketCreateParams.builder()
            .idempotencyKey("Idempotency-Key")
            .body("I am unable to connect my X account. Please help.")
            .subject("Cannot connect X account")
            .build()
    }

    @Test
    fun headers() {
        val params =
            TicketCreateParams.builder()
                .idempotencyKey("Idempotency-Key")
                .body("I am unable to connect my X account. Please help.")
                .subject("Cannot connect X account")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "Idempotency-Key").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            TicketCreateParams.builder()
                .body("I am unable to connect my X account. Please help.")
                .subject("Cannot connect X account")
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            TicketCreateParams.builder()
                .idempotencyKey("Idempotency-Key")
                .body("I am unable to connect my X account. Please help.")
                .subject("Cannot connect X account")
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
                mapOf(
                        "body" to
                            MultipartField.of("I am unable to connect my X account. Please help."),
                        "subject" to MultipartField.of("Cannot connect X account"),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            TicketCreateParams.builder()
                .body("I am unable to connect my X account. Please help.")
                .subject("Cannot connect X account")
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
                mapOf(
                        "body" to
                            MultipartField.of("I am unable to connect my X account. Please help."),
                        "subject" to MultipartField.of("Cannot connect X account"),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }
}
