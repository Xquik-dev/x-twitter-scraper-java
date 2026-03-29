// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.communities

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CommunityDeleteResponseTest {

    @Test
    fun create() {
        val communityDeleteResponse = CommunityDeleteResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val communityDeleteResponse = CommunityDeleteResponse.builder().build()

        val roundtrippedCommunityDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(communityDeleteResponse),
                jacksonTypeRef<CommunityDeleteResponse>(),
            )

        assertThat(roundtrippedCommunityDeleteResponse).isEqualTo(communityDeleteResponse)
    }
}
