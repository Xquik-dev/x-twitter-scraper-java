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
                .id("9876543210")
                .followers(150000000L)
                .username("elonmusk")
                .verified(true)
                .profilePicture("https://pbs.twimg.com/profile_images/example.jpg")
                .build()

        assertThat(tweetAuthor.id()).isEqualTo("9876543210")
        assertThat(tweetAuthor.followers()).isEqualTo(150000000L)
        assertThat(tweetAuthor.username()).isEqualTo("elonmusk")
        assertThat(tweetAuthor.verified()).isEqualTo(true)
        assertThat(tweetAuthor.profilePicture())
            .contains("https://pbs.twimg.com/profile_images/example.jpg")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tweetAuthor =
            TweetAuthor.builder()
                .id("9876543210")
                .followers(150000000L)
                .username("elonmusk")
                .verified(true)
                .profilePicture("https://pbs.twimg.com/profile_images/example.jpg")
                .build()

        val roundtrippedTweetAuthor =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetAuthor),
                jacksonTypeRef<TweetAuthor>(),
            )

        assertThat(roundtrippedTweetAuthor).isEqualTo(tweetAuthor)
    }
}
