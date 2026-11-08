// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

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
                .addUnprocessedTweetId("1234567891")
                .build()

        assertThat(mediaDownloadResponse.cacheHit()).contains(false)
        assertThat(mediaDownloadResponse.galleryUrl()).contains("https://xquik.com/gallery/abc123")
        assertThat(mediaDownloadResponse.totalMedia()).contains(5L)
        assertThat(mediaDownloadResponse.totalTweets()).contains(2L)
        assertThat(mediaDownloadResponse.tweetId()).contains("1234567890")
        assertThat(mediaDownloadResponse.unprocessedTweetIds().get())
            .containsExactly("1234567891")
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
                .addUnprocessedTweetId("1234567891")
                .build()

        val roundtrippedMediaDownloadResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mediaDownloadResponse),
                jacksonTypeRef<MediaDownloadResponse>(),
            )

        assertThat(roundtrippedMediaDownloadResponse).isEqualTo(mediaDownloadResponse)
    }

    @Test
    fun itemsReadThePosterAndQualities() {
        val jsonMapper = jsonMapper()
        val json =
            """{"tweetId":"1","galleryUrl":"https://xquik.com/gallery/abc123","cacheHit":false,"items":[{"id":"42","tweetId":"1","mediaType":"video","mediaUrl":"https://media.xquik.com/tweet_1/0.mp4","posterUrl":"https://media.xquik.com/tweet_1/0.jpg","qualities":[{"bitrate":2176000,"height":720,"url":"https://video.twimg.com/a.mp4","width":1280}],"fileSize":"2097152","createdAt":"2026-10-16T11:00:00Z","authorUsername":"elonmusk","authorDisplayName":"Elon Musk","authorAvatar":null,"tweetText":"Launch day.","likes":1200,"retweets":340,"views":56000}]}"""
        val model = jsonMapper.readValue(json, jacksonTypeRef<MediaDownloadResponse>())

        val item = model.items().get().single()
        assertThat(item.posterUrl()).contains("https://media.xquik.com/tweet_1/0.jpg")
        val quality = item.qualities().single()
        assertThat(quality.bitrate()).isEqualTo(2176000L)
        assertThat(quality.height()).isEqualTo(720L)
        assertThat(quality.url()).isEqualTo("https://video.twimg.com/a.mp4")
        assertThat(quality.width()).isEqualTo(1280L)
        assertThat(item._additionalProperties()).isEmpty()
        assertThat(model.isValid()).isTrue()
        assertThat(item.toBuilder().build()).isEqualTo(item)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
    }

    @Test
    fun photoItemKeepsANullPosterAndNoQualities() {
        val jsonMapper = jsonMapper()
        val json =
            """{"id":"42","tweetId":"1","mediaType":"photo","mediaUrl":"https://media.xquik.com/tweet_1/0.jpg","posterUrl":null,"qualities":[],"fileSize":"2097152","createdAt":"2026-10-16T11:00:00Z","authorUsername":"elonmusk","authorDisplayName":"Elon Musk","authorAvatar":null,"tweetText":"Launch day.","likes":1200,"retweets":340,"views":56000}"""
        val item = jsonMapper.readValue(json, jacksonTypeRef<MediaDownloadResponse.Item>())

        assertThat(item.posterUrl()).isEmpty()
        assertThat(item.qualities()).isEmpty()
        assertThat(item.isValid()).isTrue()
    }
}
