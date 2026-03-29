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
                .cacheHit(true)
                .galleryUrl("galleryUrl")
                .totalMedia(0L)
                .totalTweets(0L)
                .tweetId("tweetId")
                .build()

        assertThat(mediaDownloadResponse.cacheHit()).contains(true)
        assertThat(mediaDownloadResponse.galleryUrl()).contains("galleryUrl")
        assertThat(mediaDownloadResponse.totalMedia()).contains(0L)
        assertThat(mediaDownloadResponse.totalTweets()).contains(0L)
        assertThat(mediaDownloadResponse.tweetId()).contains("tweetId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val mediaDownloadResponse =
            MediaDownloadResponse.builder()
                .cacheHit(true)
                .galleryUrl("galleryUrl")
                .totalMedia(0L)
                .totalTweets(0L)
                .tweetId("tweetId")
                .build()

        val roundtrippedMediaDownloadResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mediaDownloadResponse),
                jacksonTypeRef<MediaDownloadResponse>(),
            )

        assertThat(roundtrippedMediaDownloadResponse).isEqualTo(mediaDownloadResponse)
    }
}
