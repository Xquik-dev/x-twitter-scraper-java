// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.media

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MediaUploadResponseTest {

    @Test
    fun create() {
        val mediaUploadResponse =
            MediaUploadResponse.builder().mediaId("1234567890123456789").build()

        assertThat(mediaUploadResponse.mediaId()).isEqualTo("1234567890123456789")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val mediaUploadResponse =
            MediaUploadResponse.builder().mediaId("1234567890123456789").build()

        val roundtrippedMediaUploadResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mediaUploadResponse),
                jacksonTypeRef<MediaUploadResponse>(),
            )

        assertThat(roundtrippedMediaUploadResponse).isEqualTo(mediaUploadResponse)
    }
}
