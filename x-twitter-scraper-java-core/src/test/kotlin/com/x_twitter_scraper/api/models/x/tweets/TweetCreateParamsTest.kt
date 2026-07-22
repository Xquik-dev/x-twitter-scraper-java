// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

import com.x_twitter_scraper.api.core.http.Headers
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetCreateParamsTest {

    @Test
    fun create() {
        TweetCreateParams.builder()
            .idempotencyKey("Idempotency-Key")
            .account("@elonmusk")
            .communityId("1500000000000000000")
            .isNoteTweet(false)
            .addMedia("https://example.com/video.mp4")
            .replyToTweetId("1234567890")
            .text("Just launched our new feature!")
            .build()
    }

    @Test
    fun headers() {
        val params =
            TweetCreateParams.builder()
                .idempotencyKey("Idempotency-Key")
                .account("@elonmusk")
                .communityId("1500000000000000000")
                .isNoteTweet(false)
                .addMedia("https://example.com/video.mp4")
                .replyToTweetId("1234567890")
                .text("Just launched our new feature!")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "Idempotency-Key").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            TweetCreateParams.builder()
                .idempotencyKey("Idempotency-Key")
                .account("@elonmusk")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "Idempotency-Key").build())
    }

    @Test
    fun body() {
        val params =
            TweetCreateParams.builder()
                .idempotencyKey("Idempotency-Key")
                .account("@elonmusk")
                .communityId("1500000000000000000")
                .isNoteTweet(false)
                .addMedia("https://example.com/video.mp4")
                .replyToTweetId("1234567890")
                .text("Just launched our new feature!")
                .build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("@elonmusk")
        assertThat(body.communityId()).contains("1500000000000000000")
        assertThat(body.isNoteTweet()).contains(false)
        assertThat(body.media().getOrNull()).containsExactly("https://example.com/video.mp4")
        assertThat(body.replyToTweetId()).contains("1234567890")
        assertThat(body.text()).contains("Just launched our new feature!")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            TweetCreateParams.builder()
                .idempotencyKey("Idempotency-Key")
                .account("@elonmusk")
                .build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("@elonmusk")
    }
}
