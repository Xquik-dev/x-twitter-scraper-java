// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PaginatedUsersTest {

    @Test
    fun create() {
        val paginatedUsers =
            PaginatedUsers.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addUser(
                    PaginatedUsers.User.builder()
                        .id("id")
                        .name("name")
                        .username("username")
                        .createdAt("createdAt")
                        .description("description")
                        .followers(0L)
                        .following(0L)
                        .location("location")
                        .profilePicture("profilePicture")
                        .statusesCount(0L)
                        .verified(true)
                        .build()
                )
                .build()

        assertThat(paginatedUsers.hasNextPage()).isEqualTo(true)
        assertThat(paginatedUsers.nextCursor()).isEqualTo("next_cursor")
        assertThat(paginatedUsers.users())
            .containsExactly(
                PaginatedUsers.User.builder()
                    .id("id")
                    .name("name")
                    .username("username")
                    .createdAt("createdAt")
                    .description("description")
                    .followers(0L)
                    .following(0L)
                    .location("location")
                    .profilePicture("profilePicture")
                    .statusesCount(0L)
                    .verified(true)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val paginatedUsers =
            PaginatedUsers.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addUser(
                    PaginatedUsers.User.builder()
                        .id("id")
                        .name("name")
                        .username("username")
                        .createdAt("createdAt")
                        .description("description")
                        .followers(0L)
                        .following(0L)
                        .location("location")
                        .profilePicture("profilePicture")
                        .statusesCount(0L)
                        .verified(true)
                        .build()
                )
                .build()

        val roundtrippedPaginatedUsers =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(paginatedUsers),
                jacksonTypeRef<PaginatedUsers>(),
            )

        assertThat(roundtrippedPaginatedUsers).isEqualTo(paginatedUsers)
    }
}
