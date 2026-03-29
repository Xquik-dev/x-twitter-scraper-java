// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.profile

import com.x_twitter_scraper.api.core.MultipartField
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfileUpdateAvatarParamsTest {

    @Test
    fun create() {
        ProfileUpdateAvatarParams.builder()
            .account("account")
            .file("Example data".byteInputStream())
            .build()
    }

    @Test
    fun body() {
        val params =
            ProfileUpdateAvatarParams.builder()
                .account("account")
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
                        "account" to MultipartField.of("account"),
                        "file" to MultipartField.of("Example data".byteInputStream()),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }
}
