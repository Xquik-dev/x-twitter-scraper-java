// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.followers

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FollowerCheckResponseTest {

    @Test
    fun create() {
        val followerCheckResponse =
            FollowerCheckResponse.builder()
                .isFollowedBy(true)
                .isFollowing(true)
                .sourceUsername("sourceUsername")
                .targetUsername("targetUsername")
                .build()

        assertThat(followerCheckResponse.isFollowedBy()).isEqualTo(true)
        assertThat(followerCheckResponse.isFollowing()).isEqualTo(true)
        assertThat(followerCheckResponse.sourceUsername()).isEqualTo("sourceUsername")
        assertThat(followerCheckResponse.targetUsername()).isEqualTo("targetUsername")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val followerCheckResponse =
            FollowerCheckResponse.builder()
                .isFollowedBy(true)
                .isFollowing(true)
                .sourceUsername("sourceUsername")
                .targetUsername("targetUsername")
                .build()

        val roundtrippedFollowerCheckResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(followerCheckResponse),
                jacksonTypeRef<FollowerCheckResponse>(),
            )

        assertThat(roundtrippedFollowerCheckResponse).isEqualTo(followerCheckResponse)
    }
}
