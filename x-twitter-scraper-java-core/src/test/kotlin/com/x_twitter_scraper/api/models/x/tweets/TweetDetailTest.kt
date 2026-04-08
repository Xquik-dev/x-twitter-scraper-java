// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetDetailTest {

    @Test
    fun create() {
        val tweetDetail =
            TweetDetail.builder()
                .id("1234567890")
                .bookmarkCount(2L)
                .likeCount(42L)
                .quoteCount(1L)
                .replyCount(3L)
                .retweetCount(5L)
                .text("Just launched our new feature!")
                .viewCount(1500L)
                .conversationId("1234567890")
                .createdAt("2025-01-15T12:00:00Z")
                .entities(
                    TweetDetail.Entities.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .isNoteTweet(false)
                .isQuoteStatus(false)
                .isReply(false)
                .addMedia(
                    TweetDetail.Media.builder()
                        .mediaUrl("https://pbs.twimg.com/media/example.jpg")
                        .type(TweetDetail.Media.Type.PHOTO)
                        .url("https://t.co/abc123")
                        .build()
                )
                .quotedTweet(
                    TweetDetail.QuotedTweet.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .source("Twitter Web App")
                .build()

        assertThat(tweetDetail.id()).isEqualTo("1234567890")
        assertThat(tweetDetail.bookmarkCount()).isEqualTo(2L)
        assertThat(tweetDetail.likeCount()).isEqualTo(42L)
        assertThat(tweetDetail.quoteCount()).isEqualTo(1L)
        assertThat(tweetDetail.replyCount()).isEqualTo(3L)
        assertThat(tweetDetail.retweetCount()).isEqualTo(5L)
        assertThat(tweetDetail.text()).isEqualTo("Just launched our new feature!")
        assertThat(tweetDetail.viewCount()).isEqualTo(1500L)
        assertThat(tweetDetail.conversationId()).contains("1234567890")
        assertThat(tweetDetail.createdAt()).contains("2025-01-15T12:00:00Z")
        assertThat(tweetDetail.entities())
            .contains(
                TweetDetail.Entities.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(tweetDetail.isNoteTweet()).contains(false)
        assertThat(tweetDetail.isQuoteStatus()).contains(false)
        assertThat(tweetDetail.isReply()).contains(false)
        assertThat(tweetDetail.media().getOrNull())
            .containsExactly(
                TweetDetail.Media.builder()
                    .mediaUrl("https://pbs.twimg.com/media/example.jpg")
                    .type(TweetDetail.Media.Type.PHOTO)
                    .url("https://t.co/abc123")
                    .build()
            )
        assertThat(tweetDetail.quotedTweet())
            .contains(
                TweetDetail.QuotedTweet.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(tweetDetail.source()).contains("Twitter Web App")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tweetDetail =
            TweetDetail.builder()
                .id("1234567890")
                .bookmarkCount(2L)
                .likeCount(42L)
                .quoteCount(1L)
                .replyCount(3L)
                .retweetCount(5L)
                .text("Just launched our new feature!")
                .viewCount(1500L)
                .conversationId("1234567890")
                .createdAt("2025-01-15T12:00:00Z")
                .entities(
                    TweetDetail.Entities.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .isNoteTweet(false)
                .isQuoteStatus(false)
                .isReply(false)
                .addMedia(
                    TweetDetail.Media.builder()
                        .mediaUrl("https://pbs.twimg.com/media/example.jpg")
                        .type(TweetDetail.Media.Type.PHOTO)
                        .url("https://t.co/abc123")
                        .build()
                )
                .quotedTweet(
                    TweetDetail.QuotedTweet.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .source("Twitter Web App")
                .build()

        val roundtrippedTweetDetail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetDetail),
                jacksonTypeRef<TweetDetail>(),
            )

        assertThat(roundtrippedTweetDetail).isEqualTo(tweetDetail)
    }
}
