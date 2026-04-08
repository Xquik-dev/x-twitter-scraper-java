// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets.retweet

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RetweetDeleteResponseTest {

    @Test
    fun create() {
        val retweetDeleteResponse = RetweetDeleteResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val retweetDeleteResponse = RetweetDeleteResponse.builder().build()

        val roundtrippedRetweetDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(retweetDeleteResponse),
                jacksonTypeRef<RetweetDeleteResponse>(),
            )

        assertThat(roundtrippedRetweetDeleteResponse).isEqualTo(retweetDeleteResponse)
    }
}
