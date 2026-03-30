// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetAuthorTest {

    @Test
    fun create() {
        val tweetAuthor =
            TweetAuthor.builder()
                .id("id")
                .followers(0L)
                .username("username")
                .verified(true)
                .profilePicture("profilePicture")
                .build()

        assertThat(tweetAuthor.id()).isEqualTo("id")
        assertThat(tweetAuthor.followers()).isEqualTo(0L)
        assertThat(tweetAuthor.username()).isEqualTo("username")
        assertThat(tweetAuthor.verified()).isEqualTo(true)
        assertThat(tweetAuthor.profilePicture()).contains("profilePicture")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tweetAuthor =
            TweetAuthor.builder()
                .id("id")
                .followers(0L)
                .username("username")
                .verified(true)
                .profilePicture("profilePicture")
                .build()

        val roundtrippedTweetAuthor =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetAuthor),
                jacksonTypeRef<TweetAuthor>(),
            )

        assertThat(roundtrippedTweetAuthor).isEqualTo(tweetAuthor)
    }
}
