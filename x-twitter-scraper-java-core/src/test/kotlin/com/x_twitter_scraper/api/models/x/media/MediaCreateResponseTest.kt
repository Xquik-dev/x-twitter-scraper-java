// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.media

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MediaCreateResponseTest {

    @Test
    fun create() {
        val mediaCreateResponse = MediaCreateResponse.builder().mediaId("mediaId").build()

        assertThat(mediaCreateResponse.mediaId()).isEqualTo("mediaId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val mediaCreateResponse = MediaCreateResponse.builder().mediaId("mediaId").build()

        val roundtrippedMediaCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mediaCreateResponse),
                jacksonTypeRef<MediaCreateResponse>(),
            )

        assertThat(roundtrippedMediaCreateResponse).isEqualTo(mediaCreateResponse)
    }
}
