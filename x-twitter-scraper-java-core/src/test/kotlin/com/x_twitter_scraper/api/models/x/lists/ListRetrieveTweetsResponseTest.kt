// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.lists

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ListRetrieveTweetsResponseTest {

    @Test
    fun create() {
        val listRetrieveTweetsResponse =
            ListRetrieveTweetsResponse.builder()
                .hasNextPage(true)
                .nextCursor("DAACCgACGRElMJcAAA")
                .addTweet(
                    ListRetrieveTweetsResponse.Tweet.builder()
                        .id("1234567890")
                        .text("Just launched our new feature!")
                        .author(
                            ListRetrieveTweetsResponse.Tweet.Author.builder()
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

        assertThat(listRetrieveTweetsResponse.hasNextPage()).isEqualTo(true)
        assertThat(listRetrieveTweetsResponse.nextCursor()).isEqualTo("DAACCgACGRElMJcAAA")
        assertThat(listRetrieveTweetsResponse.tweets())
            .containsExactly(
                ListRetrieveTweetsResponse.Tweet.builder()
                    .id("1234567890")
                    .text("Just launched our new feature!")
                    .author(
                        ListRetrieveTweetsResponse.Tweet.Author.builder()
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
        val listRetrieveTweetsResponse =
            ListRetrieveTweetsResponse.builder()
                .hasNextPage(true)
                .nextCursor("DAACCgACGRElMJcAAA")
                .addTweet(
                    ListRetrieveTweetsResponse.Tweet.builder()
                        .id("1234567890")
                        .text("Just launched our new feature!")
                        .author(
                            ListRetrieveTweetsResponse.Tweet.Author.builder()
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

        val roundtrippedListRetrieveTweetsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(listRetrieveTweetsResponse),
                jacksonTypeRef<ListRetrieveTweetsResponse>(),
            )

        assertThat(roundtrippedListRetrieveTweetsResponse).isEqualTo(listRetrieveTweetsResponse)
    }
}
