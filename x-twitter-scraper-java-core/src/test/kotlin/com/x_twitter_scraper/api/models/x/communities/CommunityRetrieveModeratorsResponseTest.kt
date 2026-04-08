// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.communities

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CommunityRetrieveModeratorsResponseTest {

    @Test
    fun create() {
        val communityRetrieveModeratorsResponse =
            CommunityRetrieveModeratorsResponse.builder()
                .hasNextPage(true)
                .nextCursor("DAACCgACGRElMJcAAA")
                .addUser(
                    CommunityRetrieveModeratorsResponse.User.builder()
                        .id("9876543210")
                        .name("Elon Musk")
                        .username("elonmusk")
                        .createdAt("2009-06-02T20:12:29Z")
                        .description("CEO of Tesla, SpaceX, and X")
                        .followers(150000000L)
                        .following(500L)
                        .location("Austin, TX")
                        .profilePicture("https://pbs.twimg.com/profile_images/example.jpg")
                        .statusesCount(35000L)
                        .verified(true)
                        .build()
                )
                .build()

        assertThat(communityRetrieveModeratorsResponse.hasNextPage()).isEqualTo(true)
        assertThat(communityRetrieveModeratorsResponse.nextCursor()).isEqualTo("DAACCgACGRElMJcAAA")
        assertThat(communityRetrieveModeratorsResponse.users())
            .containsExactly(
                CommunityRetrieveModeratorsResponse.User.builder()
                    .id("9876543210")
                    .name("Elon Musk")
                    .username("elonmusk")
                    .createdAt("2009-06-02T20:12:29Z")
                    .description("CEO of Tesla, SpaceX, and X")
                    .followers(150000000L)
                    .following(500L)
                    .location("Austin, TX")
                    .profilePicture("https://pbs.twimg.com/profile_images/example.jpg")
                    .statusesCount(35000L)
                    .verified(true)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val communityRetrieveModeratorsResponse =
            CommunityRetrieveModeratorsResponse.builder()
                .hasNextPage(true)
                .nextCursor("DAACCgACGRElMJcAAA")
                .addUser(
                    CommunityRetrieveModeratorsResponse.User.builder()
                        .id("9876543210")
                        .name("Elon Musk")
                        .username("elonmusk")
                        .createdAt("2009-06-02T20:12:29Z")
                        .description("CEO of Tesla, SpaceX, and X")
                        .followers(150000000L)
                        .following(500L)
                        .location("Austin, TX")
                        .profilePicture("https://pbs.twimg.com/profile_images/example.jpg")
                        .statusesCount(35000L)
                        .verified(true)
                        .build()
                )
                .build()

        val roundtrippedCommunityRetrieveModeratorsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(communityRetrieveModeratorsResponse),
                jacksonTypeRef<CommunityRetrieveModeratorsResponse>(),
            )

        assertThat(roundtrippedCommunityRetrieveModeratorsResponse)
            .isEqualTo(communityRetrieveModeratorsResponse)
    }
}
