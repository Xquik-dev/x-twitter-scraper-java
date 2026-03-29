// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserRetrieveFollowersYouKnowResponseTest {

    @Test
    fun create() {
        val userRetrieveFollowersYouKnowResponse =
            UserRetrieveFollowersYouKnowResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addUser(JsonValue.from(mapOf<String, Any>()))
                .build()

        assertThat(userRetrieveFollowersYouKnowResponse.hasNextPage()).isEqualTo(true)
        assertThat(userRetrieveFollowersYouKnowResponse.nextCursor()).isEqualTo("next_cursor")
        assertThat(userRetrieveFollowersYouKnowResponse.users())
            .containsExactly(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val userRetrieveFollowersYouKnowResponse =
            UserRetrieveFollowersYouKnowResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addUser(JsonValue.from(mapOf<String, Any>()))
                .build()

        val roundtrippedUserRetrieveFollowersYouKnowResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userRetrieveFollowersYouKnowResponse),
                jacksonTypeRef<UserRetrieveFollowersYouKnowResponse>(),
            )

        assertThat(roundtrippedUserRetrieveFollowersYouKnowResponse)
            .isEqualTo(userRetrieveFollowersYouKnowResponse)
    }
}
