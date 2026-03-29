// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets.like

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LikeDeleteResponseTest {

    @Test
    fun create() {
        val likeDeleteResponse = LikeDeleteResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val likeDeleteResponse = LikeDeleteResponse.builder().build()

        val roundtrippedLikeDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(likeDeleteResponse),
                jacksonTypeRef<LikeDeleteResponse>(),
            )

        assertThat(roundtrippedLikeDeleteResponse).isEqualTo(likeDeleteResponse)
    }
}
