// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetCreateParamsTest {

    @Test
    fun create() {
        TweetCreateParams.builder()
            .account("@elonmusk")
            .attachmentUrl("https://x.com/elonmusk/status/1234567890")
            .communityId("1500000000000000000")
            .isNoteTweet(false)
            .addMedia("https://example.com/image.jpg")
            .addMediaId("1234567890123456789")
            .replyToTweetId("1234567890")
            .text("Just launched our new feature!")
            .build()
    }

    @Test
    fun body() {
        val params =
            TweetCreateParams.builder()
                .account("@elonmusk")
                .attachmentUrl("https://x.com/elonmusk/status/1234567890")
                .communityId("1500000000000000000")
                .isNoteTweet(false)
                .addMedia("https://example.com/image.jpg")
                .addMediaId("1234567890123456789")
                .replyToTweetId("1234567890")
                .text("Just launched our new feature!")
                .build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("@elonmusk")
        assertThat(body.attachmentUrl()).contains("https://x.com/elonmusk/status/1234567890")
        assertThat(body.communityId()).contains("1500000000000000000")
        assertThat(body.isNoteTweet()).contains(false)
        assertThat(body.media().getOrNull()).containsExactly("https://example.com/image.jpg")
        assertThat(body.mediaIds().getOrNull()).containsExactly("1234567890123456789")
        assertThat(body.replyToTweetId()).contains("1234567890")
        assertThat(body.text()).contains("Just launched our new feature!")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = TweetCreateParams.builder().account("@elonmusk").build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("@elonmusk")
    }
}
