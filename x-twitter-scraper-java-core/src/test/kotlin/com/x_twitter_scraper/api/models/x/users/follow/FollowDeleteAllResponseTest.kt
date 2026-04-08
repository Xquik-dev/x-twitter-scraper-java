// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.users.follow

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FollowDeleteAllResponseTest {

    @Test
    fun create() {
        val followDeleteAllResponse = FollowDeleteAllResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val followDeleteAllResponse = FollowDeleteAllResponse.builder().build()

        val roundtrippedFollowDeleteAllResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(followDeleteAllResponse),
                jacksonTypeRef<FollowDeleteAllResponse>(),
            )

        assertThat(roundtrippedFollowDeleteAllResponse).isEqualTo(followDeleteAllResponse)
    }
}
