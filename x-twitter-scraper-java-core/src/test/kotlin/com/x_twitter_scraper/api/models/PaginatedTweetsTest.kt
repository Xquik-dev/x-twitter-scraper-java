// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.x.tweets.SearchTweet
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PaginatedTweetsTest {

    @Test
    fun create() {
        val paginatedTweets =
            PaginatedTweets.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addTweet(
                    SearchTweet.builder()
                        .id("id")
                        .text("text")
                        .author(
                            SearchTweet.Author.builder()
                                .id("id")
                                .name("name")
                                .username("username")
                                .verified(true)
                                .build()
                        )
                        .bookmarkCount(0L)
                        .createdAt("createdAt")
                        .likeCount(0L)
                        .quoteCount(0L)
                        .replyCount(0L)
                        .retweetCount(0L)
                        .viewCount(0L)
                        .build()
                )
                .build()

        assertThat(paginatedTweets.hasNextPage()).isEqualTo(true)
        assertThat(paginatedTweets.nextCursor()).isEqualTo("next_cursor")
        assertThat(paginatedTweets.tweets())
            .containsExactly(
                SearchTweet.builder()
                    .id("id")
                    .text("text")
                    .author(
                        SearchTweet.Author.builder()
                            .id("id")
                            .name("name")
                            .username("username")
                            .verified(true)
                            .build()
                    )
                    .bookmarkCount(0L)
                    .createdAt("createdAt")
                    .likeCount(0L)
                    .quoteCount(0L)
                    .replyCount(0L)
                    .retweetCount(0L)
                    .viewCount(0L)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val paginatedTweets =
            PaginatedTweets.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addTweet(
                    SearchTweet.builder()
                        .id("id")
                        .text("text")
                        .author(
                            SearchTweet.Author.builder()
                                .id("id")
                                .name("name")
                                .username("username")
                                .verified(true)
                                .build()
                        )
                        .bookmarkCount(0L)
                        .createdAt("createdAt")
                        .likeCount(0L)
                        .quoteCount(0L)
                        .replyCount(0L)
                        .retweetCount(0L)
                        .viewCount(0L)
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
