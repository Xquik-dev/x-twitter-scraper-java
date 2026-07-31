// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
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
                .id("id")
                .allowDownload(true)
                .altText("altText")
                .addAspectRatio(0L)
                .availabilityStatus("availabilityStatus")
                .displayUrl("displayUrl")
                .durationMillis(0L)
                .expandedUrl("expandedUrl")
                .faceRects(
                    TweetMedia.FaceRects.builder()
                        .putAdditionalProperty(
                            "foo",
                            JsonValue.from(listOf(mapOf("h" to 0, "w" to 0, "x" to 0, "y" to 0))),
                        )
                        .build()
                )
                .addFocusRect(TweetMedia.FocusRect.builder().h(0L).w(0L).x(0L).y(0L).build())
                .height(0L)
                .addIndex(0L)
                .mediaKey("mediaKey")
                .monetizable(true)
                .sizes(
                    TweetMedia.Sizes.builder()
                        .putAdditionalProperty(
                            "foo",
                            JsonValue.from(mapOf("h" to 0, "resize" to "resize", "w" to 0)),
                        )
                        .build()
                )
                .addVideoVariant(
                    TweetMedia.VideoVariant.builder()
                        .contentType("contentType")
                        .url("url")
                        .bitrate(0L)
                        .build()
                )
                .width(0L)
                .build()

        assertThat(tweetMedia.mediaUrl()).isEqualTo("mediaUrl")
        assertThat(tweetMedia.type()).isEqualTo(TweetMedia.Type.PHOTO)
        assertThat(tweetMedia.url()).isEqualTo("url")
        assertThat(tweetMedia.id()).contains("id")
        assertThat(tweetMedia.allowDownload()).contains(true)
        assertThat(tweetMedia.altText()).contains("altText")
        assertThat(tweetMedia.aspectRatio().getOrNull()).containsExactly(0L)
        assertThat(tweetMedia.availabilityStatus()).contains("availabilityStatus")
        assertThat(tweetMedia.displayUrl()).contains("displayUrl")
        assertThat(tweetMedia.durationMillis()).contains(0L)
        assertThat(tweetMedia.expandedUrl()).contains("expandedUrl")
        assertThat(tweetMedia.faceRects())
            .contains(
                TweetMedia.FaceRects.builder()
                    .putAdditionalProperty(
                        "foo",
                        JsonValue.from(listOf(mapOf("h" to 0, "w" to 0, "x" to 0, "y" to 0))),
                    )
                    .build()
            )
        assertThat(tweetMedia.focusRects().getOrNull())
            .containsExactly(TweetMedia.FocusRect.builder().h(0L).w(0L).x(0L).y(0L).build())
        assertThat(tweetMedia.height()).contains(0L)
        assertThat(tweetMedia.indices().getOrNull()).containsExactly(0L)
        assertThat(tweetMedia.mediaKey()).contains("mediaKey")
        assertThat(tweetMedia.monetizable()).contains(true)
        assertThat(tweetMedia.sizes())
            .contains(
                TweetMedia.Sizes.builder()
                    .putAdditionalProperty(
                        "foo",
                        JsonValue.from(mapOf("h" to 0, "resize" to "resize", "w" to 0)),
                    )
                    .build()
            )
        assertThat(tweetMedia.videoVariants().getOrNull())
            .containsExactly(
                TweetMedia.VideoVariant.builder()
                    .contentType("contentType")
                    .url("url")
                    .bitrate(0L)
                    .build()
            )
        assertThat(tweetMedia.width()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tweetMedia =
            TweetMedia.builder()
                .mediaUrl("mediaUrl")
                .type(TweetMedia.Type.PHOTO)
                .url("url")
                .id("id")
                .allowDownload(true)
                .altText("altText")
                .addAspectRatio(0L)
                .availabilityStatus("availabilityStatus")
                .displayUrl("displayUrl")
                .durationMillis(0L)
                .expandedUrl("expandedUrl")
                .faceRects(
                    TweetMedia.FaceRects.builder()
                        .putAdditionalProperty(
                            "foo",
                            JsonValue.from(listOf(mapOf("h" to 0, "w" to 0, "x" to 0, "y" to 0))),
                        )
                        .build()
                )
                .addFocusRect(TweetMedia.FocusRect.builder().h(0L).w(0L).x(0L).y(0L).build())
                .height(0L)
                .addIndex(0L)
                .mediaKey("mediaKey")
                .monetizable(true)
                .sizes(
                    TweetMedia.Sizes.builder()
                        .putAdditionalProperty(
                            "foo",
                            JsonValue.from(mapOf("h" to 0, "resize" to "resize", "w" to 0)),
                        )
                        .build()
                )
                .addVideoVariant(
                    TweetMedia.VideoVariant.builder()
                        .contentType("contentType")
                        .url("url")
                        .bitrate(0L)
                        .build()
                )
                .width(0L)
                .build()

        val roundtrippedTweetMedia =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetMedia),
                jacksonTypeRef<TweetMedia>(),
            )

        assertThat(roundtrippedTweetMedia).isEqualTo(tweetMedia)
    }
}
