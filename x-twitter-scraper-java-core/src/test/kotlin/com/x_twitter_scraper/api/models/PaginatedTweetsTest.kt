// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PaginatedTweetsTest {

    @Test
    fun create() {
        val paginatedTweets =
            PaginatedTweets.builder()
                .hasNextPage(true)
                .nextCursor("DAACCgACGRElMJcAAA")
                .addTweet(
                    SearchTweet.builder()
                        .id("1234567890")
                        .text("Just launched our new feature!")
                        .author(
                            SearchTweet.Author.builder()
                                .id("9876543210")
                                .name("Elon Musk")
                                .username("elonmusk")
                                .verified(true)
                                .build()
                        )
                        .bookmarkCount(2L)
                        .createdAt("2025-01-15T12:00:00Z")
                        .isNoteTweet(false)
                        .likeCount(42L)
                        .quoteCount(1L)
                        .replyCount(3L)
                        .retweetCount(5L)
                        .viewCount(1500L)
                        .build()
                )
                .build()

        assertThat(paginatedTweets.hasNextPage()).isEqualTo(true)
        assertThat(paginatedTweets.nextCursor()).isEqualTo("DAACCgACGRElMJcAAA")
        assertThat(paginatedTweets.tweets())
            .containsExactly(
                SearchTweet.builder()
                    .id("1234567890")
                    .text("Just launched our new feature!")
                    .author(
                        SearchTweet.Author.builder()
                            .id("9876543210")
                            .name("Elon Musk")
                            .username("elonmusk")
                            .verified(true)
                            .build()
                    )
                    .bookmarkCount(2L)
                    .createdAt("2025-01-15T12:00:00Z")
                    .isNoteTweet(false)
                    .likeCount(42L)
                    .quoteCount(1L)
                    .replyCount(3L)
                    .retweetCount(5L)
                    .viewCount(1500L)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val paginatedTweets =
            PaginatedTweets.builder()
                .hasNextPage(true)
                .nextCursor("DAACCgACGRElMJcAAA")
                .addTweet(
                    SearchTweet.builder()
                        .id("1234567890")
                        .text("Just launched our new feature!")
                        .author(
                            SearchTweet.Author.builder()
                                .id("9876543210")
                                .name("Elon Musk")
                                .username("elonmusk")
                                .verified(true)
                                .build()
                        )
                        .bookmarkCount(2L)
                        .createdAt("2025-01-15T12:00:00Z")
                        .isNoteTweet(false)
                        .likeCount(42L)
                        .quoteCount(1L)
                        .replyCount(3L)
                        .retweetCount(5L)
                        .viewCount(1500L)
                        .build()
                )
                .build()

        val roundtrippedPaginatedTweets =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(paginatedTweets),
                jacksonTypeRef<PaginatedTweets>(),
            )

        assertThat(roundtrippedPaginatedTweets).isEqualTo(paginatedTweets)
    }
}
