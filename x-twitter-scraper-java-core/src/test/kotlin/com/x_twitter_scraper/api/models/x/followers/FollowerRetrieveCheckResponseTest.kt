// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.followers

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FollowerRetrieveCheckResponseTest {

    @Test
    fun create() {
        val followerRetrieveCheckResponse =
            FollowerRetrieveCheckResponse.builder()
                .isFollowedBy(true)
                .isFollowing(true)
                .sourceUsername("sourceUsername")
                .targetUsername("targetUsername")
                .build()

        assertThat(followerRetrieveCheckResponse.isFollowedBy()).isEqualTo(true)
        assertThat(followerRetrieveCheckResponse.isFollowing()).isEqualTo(true)
        assertThat(followerRetrieveCheckResponse.sourceUsername()).isEqualTo("sourceUsername")
        assertThat(followerRetrieveCheckResponse.targetUsername()).isEqualTo("targetUsername")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val followerRetrieveCheckResponse =
            FollowerRetrieveCheckResponse.builder()
                .isFollowedBy(true)
                .isFollowing(true)
                .sourceUsername("sourceUsername")
                .targetUsername("targetUsername")
                .build()

        val roundtrippedFollowerRetrieveCheckResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(followerRetrieveCheckResponse),
                jacksonTypeRef<FollowerRetrieveCheckResponse>(),
            )

        assertThat(roundtrippedFollowerRetrieveCheckResponse)
            .isEqualTo(followerRetrieveCheckResponse)
    }
}
