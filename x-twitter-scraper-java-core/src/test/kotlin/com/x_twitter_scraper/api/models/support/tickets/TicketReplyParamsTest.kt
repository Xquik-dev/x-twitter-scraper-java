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

        assertThat(params.body()).contains("Thank you for the update.")
        assertThat(body.filterValues { !it.value.isNull() })
            .usingRecursiveComparison()
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
    fun bodyOrAttachmentsIsRequired() {
        assertThatIllegalStateException()
            .isThrownBy {
                TicketReplyParams.builder().id("tkt_a1b2c3d4e5f6a1b2c3d4e5f6").build()
            }
            .withMessage("At least one of `body` or `attachments` must be set")
        assertThatIllegalStateException()
            .isThrownBy { TicketReplyParams.Body.builder().build() }
            .withMessage("At least one of `body` or `attachments` must be set")
    }

    @Test
    fun emptyAttachmentsWithoutBody() {
        assertThatIllegalStateException()
            .isThrownBy {
                TicketReplyParams.builder()
                    .id("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")
                    .attachments(emptyList())
                    .build()
            }
            .withMessage("At least one of `body` or `attachments` must be set")
        assertThatIllegalStateException()
            .isThrownBy { TicketReplyParams.Body.builder().attachments(emptyList()).build() }
            .withMessage("At least one of `body` or `attachments` must be set")
    }

    @Test
    fun bodyWithEmptyAttachments() {
        val params =
            TicketReplyParams.builder()
                .id("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")
                .body("Please help")
                .attachments(emptyList())
                .build()

        assertThat(params.body()).contains("Please help")
        assertThat(params.attachments()).hasValue(emptyList())
    }

    @Test
    fun bodyBuilderWithBody() {
        val body = TicketReplyParams.Body.builder().body("Please help").build()

        assertThat(body.body()).contains("Please help")
        assertThat(body.attachments()).isEmpty()
        assertThat(body.validate()).isSameAs(body)
    }

    @Test
    fun attachmentsWithoutBody() {
        val params =
            TicketReplyParams.builder()
                .id("tkt_a1b2c3d4e5f6a1b2c3d4e5f6")
                .attachments(listOf("upload".byteInputStream()))
                .build()

        assertThat(params.body()).isEmpty()
        assertThat(params._body()).containsOnlyKeys("attachments")
        assertThat(params.toBuilder().build()).isEqualTo(params)
    }

    @Test
    fun bodyBuilderWithoutBody() {
        val body =
            TicketReplyParams.Body.builder().attachments(listOf("upload".byteInputStream())).build()

        val withBody = body.toBuilder().body("Please help").build()

        assertThat(body.body()).isEmpty()
        assertThat(body.validate()).isSameAs(body)
        assertThat(body.toBuilder().build()).isEqualTo(body)
        assertThat(TicketReplyParams.builder().body(body).build().body()).isEmpty()
        assertThat(withBody.body()).contains("Please help")
        assertThat(withBody.attachments()).isPresent()
    }

    @Test
    fun additionalFields() {
        val params =
            TicketReplyParams.builder()
                .body("sample")
                .attachments(listOf("upload".byteInputStream()))
                .build()

        assertThat(params.attachments()).isPresent()
        assertThat(params._body()).containsKey("attachments")
        assertThat(params.toBuilder().build()).isEqualTo(params)
    }
}
