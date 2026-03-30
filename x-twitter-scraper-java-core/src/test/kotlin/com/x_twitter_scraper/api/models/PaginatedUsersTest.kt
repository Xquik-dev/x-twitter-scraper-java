// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
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
                .addUser(JsonValue.from(mapOf<String, Any>()))
                .build()

        assertThat(paginatedUsers.hasNextPage()).isEqualTo(true)
        assertThat(paginatedUsers.nextCursor()).isEqualTo("next_cursor")
        assertThat(paginatedUsers.users()).containsExactly(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val paginatedUsers =
            PaginatedUsers.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addUser(JsonValue.from(mapOf<String, Any>()))
                .build()

        val roundtrippedPaginatedUsers =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(paginatedUsers),
                jacksonTypeRef<PaginatedUsers>(),
            )

        assertThat(roundtrippedPaginatedUsers).isEqualTo(paginatedUsers)
    }
}
