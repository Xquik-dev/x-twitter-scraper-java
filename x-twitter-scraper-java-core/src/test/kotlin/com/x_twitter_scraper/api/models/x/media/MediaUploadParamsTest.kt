// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.media

import com.x_twitter_scraper.api.core.MultipartField
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MediaUploadParamsTest {

    @Test
    fun create() {
        MediaUploadParams.builder()
            .account("@elonmusk")
            .file("Example data".byteInputStream())
            .isLongVideo(true)
            .build()
    }

    @Test
    fun body() {
        val params =
            MediaUploadParams.builder()
                .account("@elonmusk")
                .file("Example data".byteInputStream())
                .isLongVideo(true)
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
                        "file" to MultipartField.of("Example data".byteInputStream()),
                        "is_long_video" to MultipartField.of(true),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            MediaUploadParams.builder()
                .account("@elonmusk")
                .file("Example data".byteInputStream())
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
                        "file" to MultipartField.of("Example data".byteInputStream()),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }
}
