// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetGetFavoritersResponseTest {

    @Test
    fun create() {
        val tweetGetFavoritersResponse =
            TweetGetFavoritersResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addUser(JsonValue.from(mapOf<String, Any>()))
                .build()

        assertThat(tweetGetFavoritersResponse.hasNextPage()).isEqualTo(true)
        assertThat(tweetGetFavoritersResponse.nextCursor()).isEqualTo("next_cursor")
        assertThat(tweetGetFavoritersResponse.users())
            .containsExactly(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tweetGetFavoritersResponse =
            TweetGetFavoritersResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addUser(JsonValue.from(mapOf<String, Any>()))
                .build()

        val roundtrippedTweetGetFavoritersResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetGetFavoritersResponse),
                jacksonTypeRef<TweetGetFavoritersResponse>(),
            )

        assertThat(roundtrippedTweetGetFavoritersResponse).isEqualTo(tweetGetFavoritersResponse)
    }
}
