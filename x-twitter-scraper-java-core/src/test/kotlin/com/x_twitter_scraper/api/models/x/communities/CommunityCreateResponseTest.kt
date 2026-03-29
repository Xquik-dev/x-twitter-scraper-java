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
                .communityId("communityId")
                .communityName("communityName")
                .build()

        assertThat(communityCreateResponse.communityId()).isEqualTo("communityId")
        assertThat(communityCreateResponse.communityName()).contains("communityName")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val communityCreateResponse =
            CommunityCreateResponse.builder()
                .communityId("communityId")
                .communityName("communityName")
                .build()

        val roundtrippedCommunityCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(communityCreateResponse),
                jacksonTypeRef<CommunityCreateResponse>(),
            )

        assertThat(roundtrippedCommunityCreateResponse).isEqualTo(communityCreateResponse)
    }
}
