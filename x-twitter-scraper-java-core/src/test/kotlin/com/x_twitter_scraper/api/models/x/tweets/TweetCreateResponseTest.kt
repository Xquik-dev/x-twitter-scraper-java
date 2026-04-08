// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetCreateResponseTest {

    @Test
    fun create() {
        val tweetCreateResponse = TweetCreateResponse.builder().tweetId("1234567890").build()

        assertThat(tweetCreateResponse.tweetId()).isEqualTo("1234567890")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tweetCreateResponse = TweetCreateResponse.builder().tweetId("1234567890").build()

        val roundtrippedTweetCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetCreateResponse),
                jacksonTypeRef<TweetCreateResponse>(),
            )

        assertThat(roundtrippedTweetCreateResponse).isEqualTo(tweetCreateResponse)
    }
}
