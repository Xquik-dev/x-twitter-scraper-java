// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.media

import com.x_twitter_scraper.api.core.MultipartField
import com.x_twitter_scraper.api.core.http.Headers
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalStateException
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

    @Test
    fun additionalFields() {
        val params =
            MediaUploadParams.builder()
                .account("sample")
                .idempotencyKey("sample")
                .file("upload".byteInputStream())
                .isLongVideo(true)
                .build()

        assertThat(params.file()).isPresent()
        assertThat(params._body()).containsKey("file")
        assertThat(params.isLongVideo()).isPresent()
        assertThat(params._body()).containsKey("is_long_video")
        assertThat(params.toBuilder().build()).isEqualTo(params)
        assertThat(params.url()).isEmpty()
        assertThat(params._body()).doesNotContainKey("url")
        assertThat(
                MediaUploadParams.Body.builder()
                    .account("sample")
                    .file("upload".byteInputStream())
                    .build()
                    .isValid()
            )
            .isTrue()
    }

    @Test
    fun rejectsMissingInput() {
        assertThatIllegalStateException().isThrownBy {
            MediaUploadParams.builder().account("sample").idempotencyKey("sample").build()
        }
    }

    @Test
    fun rejectsBothInputs() {
        assertThatIllegalStateException().isThrownBy {
            MediaUploadParams.builder()
                .account("sample")
                .idempotencyKey("sample")
                .url("https://example.com/image.png")
                .file("upload".byteInputStream())
                .build()
        }
    }
}
