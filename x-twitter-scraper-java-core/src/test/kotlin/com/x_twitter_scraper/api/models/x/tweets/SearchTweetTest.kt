// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SearchTweetTest {

    @Test
    fun create() {
        val searchTweet =
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

        assertThat(searchTweet.id()).isEqualTo("id")
        assertThat(searchTweet.text()).isEqualTo("text")
        assertThat(searchTweet.author())
            .contains(
                SearchTweet.Author.builder()
                    .id("id")
                    .name("name")
                    .username("username")
                    .verified(true)
                    .build()
            )
        assertThat(searchTweet.bookmarkCount()).contains(0L)
        assertThat(searchTweet.createdAt()).contains("createdAt")
        assertThat(searchTweet.likeCount()).contains(0L)
        assertThat(searchTweet.quoteCount()).contains(0L)
        assertThat(searchTweet.replyCount()).contains(0L)
        assertThat(searchTweet.retweetCount()).contains(0L)
        assertThat(searchTweet.viewCount()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val searchTweet =
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

        val roundtrippedSearchTweet =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(searchTweet),
                jacksonTypeRef<SearchTweet>(),
            )

        assertThat(roundtrippedSearchTweet).isEqualTo(searchTweet)
    }
}
