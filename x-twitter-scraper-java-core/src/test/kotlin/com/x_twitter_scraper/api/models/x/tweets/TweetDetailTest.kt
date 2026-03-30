// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetDetailTest {

    @Test
    fun create() {
        val tweetDetail =
            TweetDetail.builder()
                .id("id")
                .bookmarkCount(0L)
                .likeCount(0L)
                .quoteCount(0L)
                .replyCount(0L)
                .retweetCount(0L)
                .text("text")
                .viewCount(0L)
                .createdAt("createdAt")
                .build()

        assertThat(tweetDetail.id()).isEqualTo("id")
        assertThat(tweetDetail.bookmarkCount()).isEqualTo(0L)
        assertThat(tweetDetail.likeCount()).isEqualTo(0L)
        assertThat(tweetDetail.quoteCount()).isEqualTo(0L)
        assertThat(tweetDetail.replyCount()).isEqualTo(0L)
        assertThat(tweetDetail.retweetCount()).isEqualTo(0L)
        assertThat(tweetDetail.text()).isEqualTo("text")
        assertThat(tweetDetail.viewCount()).isEqualTo(0L)
        assertThat(tweetDetail.createdAt()).contains("createdAt")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tweetDetail =
            TweetDetail.builder()
                .id("id")
                .bookmarkCount(0L)
                .likeCount(0L)
                .quoteCount(0L)
                .replyCount(0L)
                .retweetCount(0L)
                .text("text")
                .viewCount(0L)
                .createdAt("createdAt")
                .build()

        val roundtrippedTweetDetail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetDetail),
                jacksonTypeRef<TweetDetail>(),
            )

        assertThat(roundtrippedTweetDetail).isEqualTo(tweetDetail)
    }
}
