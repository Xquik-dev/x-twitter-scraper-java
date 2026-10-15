// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CommunityTopicTest {

    @Test
    fun create() {
        val communityTopic =
            CommunityTopic.builder()
                .id("id")
                .name("name")
                .addSubtopic(CommunityTopic.Subtopic.builder().id("id").name("name").build())
                .build()

        assertThat(communityTopic.id()).isEqualTo("id")
        assertThat(communityTopic.name()).isEqualTo("name")
        assertThat(communityTopic.subtopics())
            .containsExactly(CommunityTopic.Subtopic.builder().id("id").name("name").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val communityTopic =
            CommunityTopic.builder()
                .id("id")
                .name("name")
                .addSubtopic(CommunityTopic.Subtopic.builder().id("id").name("name").build())
                .build()

        val roundtrippedCommunityTopic =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(communityTopic),
                jacksonTypeRef<CommunityTopic>(),
            )

        assertThat(roundtrippedCommunityTopic).isEqualTo(communityTopic)
    }
}
