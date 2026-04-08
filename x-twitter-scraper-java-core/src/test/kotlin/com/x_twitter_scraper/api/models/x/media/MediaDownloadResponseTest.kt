// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.media

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MediaDownloadResponseTest {

    @Test
    fun create() {
        val mediaDownloadResponse =
            MediaDownloadResponse.builder()
                .cacheHit(false)
                .galleryUrl("https://xquik.com/gallery/abc123")
                .totalMedia(5L)
                .totalTweets(2L)
                .tweetId("1234567890")
                .build()

        assertThat(mediaDownloadResponse.cacheHit()).contains(false)
        assertThat(mediaDownloadResponse.galleryUrl()).contains("https://xquik.com/gallery/abc123")
        assertThat(mediaDownloadResponse.totalMedia()).contains(5L)
        assertThat(mediaDownloadResponse.totalTweets()).contains(2L)
        assertThat(mediaDownloadResponse.tweetId()).contains("1234567890")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val mediaDownloadResponse =
            MediaDownloadResponse.builder()
                .cacheHit(false)
                .galleryUrl("https://xquik.com/gallery/abc123")
                .totalMedia(5L)
                .totalTweets(2L)
                .tweetId("1234567890")
                .build()

        val roundtrippedMediaDownloadResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mediaDownloadResponse),
                jacksonTypeRef<MediaDownloadResponse>(),
            )

        assertThat(roundtrippedMediaDownloadResponse).isEqualTo(mediaDownloadResponse)
    }
}
