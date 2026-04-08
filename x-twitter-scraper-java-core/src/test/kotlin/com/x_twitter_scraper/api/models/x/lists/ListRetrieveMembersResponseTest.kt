// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.lists

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ListRetrieveMembersResponseTest {

    @Test
    fun create() {
        val listRetrieveMembersResponse =
            ListRetrieveMembersResponse.builder()
                .hasNextPage(true)
                .nextCursor("DAACCgACGRElMJcAAA")
                .addUser(
                    ListRetrieveMembersResponse.User.builder()
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

        assertThat(listRetrieveMembersResponse.hasNextPage()).isEqualTo(true)
        assertThat(listRetrieveMembersResponse.nextCursor()).isEqualTo("DAACCgACGRElMJcAAA")
        assertThat(listRetrieveMembersResponse.users())
            .containsExactly(
                ListRetrieveMembersResponse.User.builder()
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
        val listRetrieveMembersResponse =
            ListRetrieveMembersResponse.builder()
                .hasNextPage(true)
                .nextCursor("DAACCgACGRElMJcAAA")
                .addUser(
                    ListRetrieveMembersResponse.User.builder()
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

        val roundtrippedListRetrieveMembersResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(listRetrieveMembersResponse),
                jacksonTypeRef<ListRetrieveMembersResponse>(),
            )

        assertThat(roundtrippedListRetrieveMembersResponse).isEqualTo(listRetrieveMembersResponse)
    }
}
