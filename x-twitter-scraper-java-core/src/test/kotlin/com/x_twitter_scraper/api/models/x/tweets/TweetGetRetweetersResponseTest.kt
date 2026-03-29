// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetGetRetweetersResponseTest {

    @Test
    fun create() {
        val tweetGetRetweetersResponse =
            TweetGetRetweetersResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addUser(JsonValue.from(mapOf<String, Any>()))
                .build()

        assertThat(tweetGetRetweetersResponse.hasNextPage()).isEqualTo(true)
        assertThat(tweetGetRetweetersResponse.nextCursor()).isEqualTo("next_cursor")
        assertThat(tweetGetRetweetersResponse.users())
            .containsExactly(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tweetGetRetweetersResponse =
            TweetGetRetweetersResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addUser(JsonValue.from(mapOf<String, Any>()))
                .build()

        val roundtrippedTweetGetRetweetersResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetGetRetweetersResponse),
                jacksonTypeRef<TweetGetRetweetersResponse>(),
            )

        assertThat(roundtrippedTweetGetRetweetersResponse).isEqualTo(tweetGetRetweetersResponse)
    }
}
