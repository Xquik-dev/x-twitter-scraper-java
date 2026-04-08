// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets.retweet

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RetweetCreateResponseTest {

    @Test
    fun create() {
        val retweetCreateResponse = RetweetCreateResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val retweetCreateResponse = RetweetCreateResponse.builder().build()

        val roundtrippedRetweetCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(retweetCreateResponse),
                jacksonTypeRef<RetweetCreateResponse>(),
            )

        assertThat(roundtrippedRetweetCreateResponse).isEqualTo(retweetCreateResponse)
    }
}
