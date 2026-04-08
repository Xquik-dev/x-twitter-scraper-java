// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.communities

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CommunityCreateResponseTest {

    @Test
    fun create() {
        val communityCreateResponse =
            CommunityCreateResponse.builder()
                .communityId("1500000000000000000")
                .communityName("Tesla Fans")
                .build()

        assertThat(communityCreateResponse.communityId()).isEqualTo("1500000000000000000")
        assertThat(communityCreateResponse.communityName()).contains("Tesla Fans")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val communityCreateResponse =
            CommunityCreateResponse.builder()
                .communityId("1500000000000000000")
                .communityName("Tesla Fans")
                .build()

        val roundtrippedCommunityCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(communityCreateResponse),
                jacksonTypeRef<CommunityCreateResponse>(),
            )

        assertThat(roundtrippedCommunityCreateResponse).isEqualTo(communityCreateResponse)
    }
}
