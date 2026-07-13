// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetMediaTest {

    @Test
    fun create() {
        val tweetMedia =
            TweetMedia.builder()
                .mediaUrl("mediaUrl")
                .type(TweetMedia.Type.PHOTO)
                .url("url")
                .addVideoVariant(
                    TweetMedia.VideoVariant.builder()
                        .contentType("contentType")
                        .url("url")
                        .bitrate(0L)
                        .build()
                )
                .build()

        assertThat(tweetMedia.mediaUrl()).isEqualTo("mediaUrl")
        assertThat(tweetMedia.type()).isEqualTo(TweetMedia.Type.PHOTO)
        assertThat(tweetMedia.url()).isEqualTo("url")
        assertThat(tweetMedia.videoVariants().getOrNull())
            .containsExactly(
                TweetMedia.VideoVariant.builder()
                    .contentType("contentType")
                    .url("url")
                    .bitrate(0L)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tweetMedia =
            TweetMedia.builder()
                .mediaUrl("mediaUrl")
                .type(TweetMedia.Type.PHOTO)
                .url("url")
                .addVideoVariant(
                    TweetMedia.VideoVariant.builder()
                        .contentType("contentType")
                        .url("url")
                        .bitrate(0L)
                        .build()
                )
                .build()

        val roundtrippedTweetMedia =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetMedia),
                jacksonTypeRef<TweetMedia>(),
            )

        assertThat(roundtrippedTweetMedia).isEqualTo(tweetMedia)
    }
}
