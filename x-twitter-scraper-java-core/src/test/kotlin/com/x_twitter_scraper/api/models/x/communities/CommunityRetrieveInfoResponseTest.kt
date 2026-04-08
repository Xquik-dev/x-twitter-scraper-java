// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.communities

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CommunityRetrieveInfoResponseTest {

    @Test
    fun create() {
        val communityRetrieveInfoResponse =
            CommunityRetrieveInfoResponse.builder()
                .community(
                    CommunityRetrieveInfoResponse.Community.builder()
                        .id("1500000000000000000")
                        .bannerUrl("banner_url")
                        .createdAt("created_at")
                        .description("description")
                        .joinPolicy("join_policy")
                        .memberCount(0L)
                        .moderatorCount(0L)
                        .name("Tesla Fans")
                        .primaryTopic(
                            CommunityRetrieveInfoResponse.Community.PrimaryTopic.builder()
                                .id("id")
                                .name("name")
                                .build()
                        )
                        .addRule(
                            CommunityRetrieveInfoResponse.Community.Rule.builder()
                                .id("id")
                                .description("description")
                                .name("name")
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(communityRetrieveInfoResponse.community())
            .isEqualTo(
                CommunityRetrieveInfoResponse.Community.builder()
                    .id("1500000000000000000")
                    .bannerUrl("banner_url")
                    .createdAt("created_at")
                    .description("description")
                    .joinPolicy("join_policy")
                    .memberCount(0L)
                    .moderatorCount(0L)
                    .name("Tesla Fans")
                    .primaryTopic(
                        CommunityRetrieveInfoResponse.Community.PrimaryTopic.builder()
                            .id("id")
                            .name("name")
                            .build()
                    )
                    .addRule(
                        CommunityRetrieveInfoResponse.Community.Rule.builder()
                            .id("id")
                            .description("description")
                            .name("name")
                            .build()
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val communityRetrieveInfoResponse =
            CommunityRetrieveInfoResponse.builder()
                .community(
                    CommunityRetrieveInfoResponse.Community.builder()
                        .id("1500000000000000000")
                        .bannerUrl("banner_url")
                        .createdAt("created_at")
                        .description("description")
                        .joinPolicy("join_policy")
                        .memberCount(0L)
                        .moderatorCount(0L)
                        .name("Tesla Fans")
                        .primaryTopic(
                            CommunityRetrieveInfoResponse.Community.PrimaryTopic.builder()
                                .id("id")
                                .name("name")
                                .build()
                        )
                        .addRule(
                            CommunityRetrieveInfoResponse.Community.Rule.builder()
                                .id("id")
                                .description("description")
                                .name("name")
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedCommunityRetrieveInfoResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(communityRetrieveInfoResponse),
                jacksonTypeRef<CommunityRetrieveInfoResponse>(),
            )

        assertThat(roundtrippedCommunityRetrieveInfoResponse)
            .isEqualTo(communityRetrieveInfoResponse)
    }
}
