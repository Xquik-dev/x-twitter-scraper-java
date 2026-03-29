// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetCreateParamsTest {

    @Test
    fun create() {
        TweetCreateParams.builder()
            .account("account")
            .text("text")
            .attachmentUrl("attachment_url")
            .communityId("community_id")
            .isNoteTweet(true)
            .addMediaId("string")
            .replyToTweetId("reply_to_tweet_id")
            .build()
    }

    @Test
    fun body() {
        val params =
            TweetCreateParams.builder()
                .account("account")
                .text("text")
                .attachmentUrl("attachment_url")
                .communityId("community_id")
                .isNoteTweet(true)
                .addMediaId("string")
                .replyToTweetId("reply_to_tweet_id")
                .build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("account")
        assertThat(body.text()).isEqualTo("text")
        assertThat(body.attachmentUrl()).contains("attachment_url")
        assertThat(body.communityId()).contains("community_id")
        assertThat(body.isNoteTweet()).contains(true)
        assertThat(body.mediaIds().getOrNull()).containsExactly("string")
        assertThat(body.replyToTweetId()).contains("reply_to_tweet_id")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = TweetCreateParams.builder().account("account").text("text").build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("account")
        assertThat(body.text()).isEqualTo("text")
    }
}
