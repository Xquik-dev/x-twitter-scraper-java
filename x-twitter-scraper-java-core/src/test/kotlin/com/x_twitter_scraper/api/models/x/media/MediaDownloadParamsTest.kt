// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.media

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MediaDownloadParamsTest {

    @Test
    fun create() {
        MediaDownloadParams.builder()
            .addTweetId("1234567890")
            .addTweetId("1234567891")
            .tweetInput("https://x.com/elonmusk/status/1234567890")
            .build()
    }

    @Test
    fun body() {
        val params =
            MediaDownloadParams.builder()
                .addTweetId("1234567890")
                .addTweetId("1234567891")
                .tweetInput("https://x.com/elonmusk/status/1234567890")
                .build()

        val body = params._body()

        assertThat(body.tweetIds().getOrNull()).containsExactly("1234567890", "1234567891")
        assertThat(body.tweetInput()).contains("https://x.com/elonmusk/status/1234567890")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = MediaDownloadParams.builder().build()

        val body = params._body()
    }
}
