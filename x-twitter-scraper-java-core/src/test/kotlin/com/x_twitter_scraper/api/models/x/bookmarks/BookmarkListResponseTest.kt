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
                .nextCursor("DAACCgACGRElMJcAAA")
                .addTweet(
                    BookmarkListResponse.Tweet.builder()
                        .id("1234567890")
                        .text("Just launched our new feature!")
                        .author(
                            BookmarkListResponse.Tweet.Author.builder()
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

        assertThat(bookmarkListResponse.hasNextPage()).isEqualTo(true)
        assertThat(bookmarkListResponse.nextCursor()).isEqualTo("DAACCgACGRElMJcAAA")
        assertThat(bookmarkListResponse.tweets())
            .containsExactly(
                BookmarkListResponse.Tweet.builder()
                    .id("1234567890")
                    .text("Just launched our new feature!")
                    .author(
                        BookmarkListResponse.Tweet.Author.builder()
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
        val bookmarkListResponse =
            BookmarkListResponse.builder()
                .hasNextPage(true)
                .nextCursor("DAACCgACGRElMJcAAA")
                .addTweet(
                    BookmarkListResponse.Tweet.builder()
                        .id("1234567890")
                        .text("Just launched our new feature!")
                        .author(
                            BookmarkListResponse.Tweet.Author.builder()
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

        val roundtrippedBookmarkListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(bookmarkListResponse),
                jacksonTypeRef<BookmarkListResponse>(),
            )

        assertThat(roundtrippedBookmarkListResponse).isEqualTo(bookmarkListResponse)
    }
}
