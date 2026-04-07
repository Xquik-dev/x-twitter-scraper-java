// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.bookmarks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BookmarkListResponseTest {

    @Test
    fun create() {
        val bookmarkListResponse =
            BookmarkListResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addTweet(
                    BookmarkListResponse.Tweet.builder()
                        .id("id")
                        .text("text")
                        .author(
                            BookmarkListResponse.Tweet.Author.builder()
                                .id("id")
                                .name("name")
                                .username("username")
                                .verified(true)
                                .build()
                        )
                        .bookmarkCount(0L)
                        .createdAt("createdAt")
                        .isNoteTweet(true)
                        .likeCount(0L)
                        .quoteCount(0L)
                        .replyCount(0L)
                        .retweetCount(0L)
                        .viewCount(0L)
                        .build()
                )
                .build()

        assertThat(bookmarkListResponse.hasNextPage()).isEqualTo(true)
        assertThat(bookmarkListResponse.nextCursor()).isEqualTo("next_cursor")
        assertThat(bookmarkListResponse.tweets())
            .containsExactly(
                BookmarkListResponse.Tweet.builder()
                    .id("id")
                    .text("text")
                    .author(
                        BookmarkListResponse.Tweet.Author.builder()
                            .id("id")
                            .name("name")
                            .username("username")
                            .verified(true)
                            .build()
                    )
                    .bookmarkCount(0L)
                    .createdAt("createdAt")
                    .isNoteTweet(true)
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
        val bookmarkListResponse =
            BookmarkListResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addTweet(
                    BookmarkListResponse.Tweet.builder()
                        .id("id")
                        .text("text")
                        .author(
                            BookmarkListResponse.Tweet.Author.builder()
                                .id("id")
                                .name("name")
                                .username("username")
                                .verified(true)
                                .build()
                        )
                        .bookmarkCount(0L)
                        .createdAt("createdAt")
                        .isNoteTweet(true)
                        .likeCount(0L)
                        .quoteCount(0L)
                        .replyCount(0L)
                        .retweetCount(0L)
                        .viewCount(0L)
                        .build()
                )
                .build()

        val roundtrippedBookmarkListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(bookmarkListResponse),
                jacksonTypeRef<BookmarkListResponse>(),
            )

        assertThat(roundtrippedBookmarkListResponse).isEqualTo(bookmarkListResponse)
    }
}
