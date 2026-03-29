// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.media

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MediaDownloadParamsTest {

    @Test
    fun create() {
        MediaDownloadParams.builder().addTweetId("string").tweetInput("tweetInput").build()
    }

    @Test
    fun body() {
        val params =
            MediaDownloadParams.builder().addTweetId("string").tweetInput("tweetInput").build()

        val body = params._body()

        assertThat(body.tweetIds().getOrNull()).containsExactly("string")
        assertThat(body.tweetInput()).contains("tweetInput")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = MediaDownloadParams.builder().build()

        val body = params._body()
    }
}
