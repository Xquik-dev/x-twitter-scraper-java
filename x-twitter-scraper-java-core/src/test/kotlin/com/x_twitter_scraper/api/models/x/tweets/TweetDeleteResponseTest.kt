// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetDeleteResponseTest {

    @Test
    fun create() {
        val tweetDeleteResponse = TweetDeleteResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tweetDeleteResponse = TweetDeleteResponse.builder().build()

        val roundtrippedTweetDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetDeleteResponse),
                jacksonTypeRef<TweetDeleteResponse>(),
            )

        assertThat(roundtrippedTweetDeleteResponse).isEqualTo(tweetDeleteResponse)
    }
}
