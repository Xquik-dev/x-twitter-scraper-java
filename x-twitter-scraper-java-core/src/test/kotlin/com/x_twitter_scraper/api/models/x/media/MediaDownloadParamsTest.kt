// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.media

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MediaDownloadParamsTest {

    @Test
    fun create() {
        MediaDownloadParams.builder()
            .tweetId("1234567890")
            .addTweetId("1234567890")
            .addTweetId("1234567891")
            .tweetInput("https://x.com/elonmusk/status/1234567890")
            .tweetUrl("https://x.com/elonmusk/status/1234567890")
            .build()
    }

    @Test
    fun body() {
        val params =
            MediaDownloadParams.builder()
                .tweetId("1234567890")
                .addTweetId("1234567890")
                .addTweetId("1234567891")
                .tweetInput("https://x.com/elonmusk/status/1234567890")
                .tweetUrl("https://x.com/elonmusk/status/1234567890")
                .build()

        val body = params._body()

        assertThat(body.tweetId()).contains("1234567890")
        assertThat(body.tweetIds().getOrNull()).containsExactly("1234567890", "1234567891")
        assertThat(body.tweetInput()).contains("https://x.com/elonmusk/status/1234567890")
        assertThat(body.tweetUrl()).contains("https://x.com/elonmusk/status/1234567890")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = MediaDownloadParams.builder().build()

        val body = params._body()
    }
}
