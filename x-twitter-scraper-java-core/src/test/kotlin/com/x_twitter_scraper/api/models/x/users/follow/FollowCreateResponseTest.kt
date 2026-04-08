// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.users.follow

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FollowCreateResponseTest {

    @Test
    fun create() {
        val followCreateResponse = FollowCreateResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val followCreateResponse = FollowCreateResponse.builder().build()

        val roundtrippedFollowCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(followCreateResponse),
                jacksonTypeRef<FollowCreateResponse>(),
            )

        assertThat(roundtrippedFollowCreateResponse).isEqualTo(followCreateResponse)
    }
}
