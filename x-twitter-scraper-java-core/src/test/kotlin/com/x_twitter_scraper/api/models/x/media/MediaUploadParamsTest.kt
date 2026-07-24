// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.media

import com.x_twitter_scraper.api.core.MultipartField
import com.x_twitter_scraper.api.core.http.Headers
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MediaUploadParamsTest {

    @Test
    fun create() {
        MediaUploadParams.builder()
            .idempotencyKey("Idempotency-Key")
            .account("@elonmusk")
            .url("https://example.com/image.png")
            .build()
    }

    @Test
    fun headers() {
        val params =
            MediaUploadParams.builder()
                .idempotencyKey("Idempotency-Key")
                .account("@elonmusk")
                .url("https://example.com/image.png")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "Idempotency-Key").build())
    }

    @Test
    fun body() {
        val params =
            MediaUploadParams.builder()
                .idempotencyKey("Idempotency-Key")
                .account("@elonmusk")
                .url("https://example.com/image.png")
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
                        "account" to MultipartField.of("@elonmusk"),
                        "url" to MultipartField.of("https://example.com/image.png"),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }
}
