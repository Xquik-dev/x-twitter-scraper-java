// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.communities

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CommunityActionResultTest {

    @Test
    fun create() {
        val communityActionResult =
            CommunityActionResult.builder()
                .communityId("1500000000000000000")
                .communityName("Tesla Fans")
                .build()

        assertThat(communityActionResult.communityId()).isEqualTo("1500000000000000000")
        assertThat(communityActionResult.communityName()).isEqualTo("Tesla Fans")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val communityActionResult =
            CommunityActionResult.builder()
                .communityId("1500000000000000000")
                .communityName("Tesla Fans")
                .build()

        val roundtrippedCommunityActionResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(communityActionResult),
                jacksonTypeRef<CommunityActionResult>(),
            )

        assertThat(roundtrippedCommunityActionResult).isEqualTo(communityActionResult)
    }
}
