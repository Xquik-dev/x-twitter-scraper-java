// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.communities

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.CommunityTopic
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CommunityListTopicsResponseTest {

    @Test
    fun create() {
        val communityListTopicsResponse =
            CommunityListTopicsResponse.builder()
                .count(1L)
                .addTopic(
                    CommunityTopic.builder()
                        .id("id")
                        .name("name")
                        .addSubtopic(
                            CommunityTopic.Subtopic.builder().id("id").name("name").build()
                        )
                        .build()
                )
                .message("X listed no community topics. Try again soon.")
                .build()

        assertThat(communityListTopicsResponse.count()).isEqualTo(1L)
        assertThat(communityListTopicsResponse.topics())
            .containsExactly(
                CommunityTopic.builder()
                    .id("id")
                    .name("name")
                    .addSubtopic(CommunityTopic.Subtopic.builder().id("id").name("name").build())
                    .build()
            )
        assertThat(communityListTopicsResponse.message())
            .contains("X listed no community topics. Try again soon.")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val communityListTopicsResponse =
            CommunityListTopicsResponse.builder()
                .count(1L)
                .addTopic(
                    CommunityTopic.builder()
                        .id("id")
                        .name("name")
                        .addSubtopic(
                            CommunityTopic.Subtopic.builder().id("id").name("name").build()
                        )
                        .build()
                )
                .message("X listed no community topics. Try again soon.")
                .build()

        val roundtrippedCommunityListTopicsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(communityListTopicsResponse),
                jacksonTypeRef<CommunityListTopicsResponse>(),
            )

        assertThat(roundtrippedCommunityListTopicsResponse).isEqualTo(communityListTopicsResponse)
    }
}
