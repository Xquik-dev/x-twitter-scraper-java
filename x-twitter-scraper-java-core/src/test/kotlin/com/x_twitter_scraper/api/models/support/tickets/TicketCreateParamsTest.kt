// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.support.tickets

import com.x_twitter_scraper.api.core.MultipartField
import com.x_twitter_scraper.api.core.http.Headers
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalStateException
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

        assertThat(params.body()).contains("I am unable to connect my X account. Please help.")
        assertThat(body.filterValues { !it.value.isNull() })
            .usingRecursiveComparison()
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
        val params = TicketCreateParams.builder().subject("Cannot connect X account").build()

        val body = params._body()

        assertThat(params.body()).isEmpty()
        assertThat(body)
            .isEqualTo(mapOf("subject" to MultipartField.of("Cannot connect X account")))
    }

    @Test
    fun attachmentsWithoutBody() {
        val params =
            TicketCreateParams.builder()
                .subject("Upload issue")
                .attachments(listOf("upload".byteInputStream()))
                .build()

        assertThat(params.body()).isEmpty()
        assertThat(params._body()).containsOnlyKeys("subject", "attachments")
        assertThat(params.toBuilder().build()).isEqualTo(params)
    }

    @Test
    fun bodyBuilderWithoutBody() {
        val body =
            TicketCreateParams.Body.builder()
                .subject("Upload issue")
                .attachments(listOf("upload".byteInputStream()))
                .build()

        assertThat(body.body()).isEmpty()
        assertThat(body.validate()).isSameAs(body)
        assertThat(body.toBuilder().build()).isEqualTo(body)
        assertThat(TicketCreateParams.builder().body(body).build().body()).isEmpty()
        assertThat(body.toBuilder().body("Please help").build().body()).contains("Please help")
    }

    @Test
    fun subjectIsRequired() {
        assertThatIllegalStateException().isThrownBy {
            TicketCreateParams.builder().attachments(listOf("upload".byteInputStream())).build()
        }
        assertThatIllegalStateException().isThrownBy {
            TicketCreateParams.Body.builder()
                .attachments(listOf("upload".byteInputStream()))
                .build()
        }
    }

    @Test
    fun additionalFields() {
        val params =
            TicketCreateParams.builder()
                .body("sample")
                .subject("sample")
                .attachments(listOf("upload".byteInputStream()))
                .build()

        assertThat(params.attachments()).isPresent()
        assertThat(params._body()).containsKey("attachments")
        assertThat(params.toBuilder().build()).isEqualTo(params)
    }
}
