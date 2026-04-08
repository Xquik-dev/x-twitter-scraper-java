// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets.like

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LikeCreateResponseTest {

    @Test
    fun create() {
        val likeCreateResponse = LikeCreateResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val likeCreateResponse = LikeCreateResponse.builder().build()

        val roundtrippedLikeCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(likeCreateResponse),
                jacksonTypeRef<LikeCreateResponse>(),
            )

        assertThat(roundtrippedLikeCreateResponse).isEqualTo(likeCreateResponse)
    }
}
