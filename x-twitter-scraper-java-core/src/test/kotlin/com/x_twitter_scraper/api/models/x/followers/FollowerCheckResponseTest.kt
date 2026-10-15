// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

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
                .isFollowedBy(false)
                .isFollowing(true)
                .sourceUsername("elonmusk")
                .targetUsername("jack")
                .build()

        assertThat(followerCheckResponse.isFollowedBy()).isEqualTo(false)
        assertThat(followerCheckResponse.isFollowing()).isEqualTo(true)
        assertThat(followerCheckResponse.sourceUsername()).isEqualTo("elonmusk")
        assertThat(followerCheckResponse.targetUsername()).isEqualTo("jack")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val followerCheckResponse =
            FollowerCheckResponse.builder()
                .isFollowedBy(false)
                .isFollowing(true)
                .sourceUsername("elonmusk")
                .targetUsername("jack")
                .build()

        val roundtrippedFollowerCheckResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(followerCheckResponse),
                jacksonTypeRef<FollowerCheckResponse>(),
            )

        assertThat(roundtrippedFollowerCheckResponse).isEqualTo(followerCheckResponse)
    }

    @Test
    fun readsEveryFieldTheSpecDescribes() {
        val followerCheckResponse =
            jsonMapper()
                .readValue(
                    """
                    {
                      "isFollowing": true,
                      "isFollowedBy": false,
                      "sourceId": "11348282",
                      "sourceUsername": "elonmusk",
                      "targetId": "34743251",
                      "targetUsername": "spacex"
                    }
                    """
                        .trimIndent(),
                    jacksonTypeRef<FollowerCheckResponse>(),
                )

        followerCheckResponse.validate()
        assertThat(followerCheckResponse.isFollowedBy()).isEqualTo(false)
        assertThat(followerCheckResponse.isFollowing()).isEqualTo(true)
        assertThat(followerCheckResponse.sourceUsername()).isEqualTo("elonmusk")
        assertThat(followerCheckResponse.targetUsername()).isEqualTo("spacex")
        assertThat(followerCheckResponse.sourceId()).contains("11348282")
        assertThat(followerCheckResponse.targetId()).contains("34743251")
        assertThat(followerCheckResponse._additionalProperties()).isEmpty()
    }
}
