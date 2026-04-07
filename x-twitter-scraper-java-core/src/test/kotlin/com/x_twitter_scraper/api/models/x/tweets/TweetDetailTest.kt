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
                .id("id")
                .bookmarkCount(0L)
                .likeCount(0L)
                .quoteCount(0L)
                .replyCount(0L)
                .retweetCount(0L)
                .text("text")
                .viewCount(0L)
                .conversationId("conversationId")
                .createdAt("createdAt")
                .entities(JsonValue.from(mapOf<String, Any>()))
                .isNoteTweet(true)
                .isQuoteStatus(true)
                .isReply(true)
                .addMedia(
                    TweetDetail.Media.builder()
                        .mediaUrl("mediaUrl")
                        .type(TweetDetail.Media.Type.PHOTO)
                        .url("url")
                        .build()
                )
                .quotedTweet(JsonValue.from(mapOf<String, Any>()))
                .source("source")
                .build()

        assertThat(tweetDetail.id()).isEqualTo("id")
        assertThat(tweetDetail.bookmarkCount()).isEqualTo(0L)
        assertThat(tweetDetail.likeCount()).isEqualTo(0L)
        assertThat(tweetDetail.quoteCount()).isEqualTo(0L)
        assertThat(tweetDetail.replyCount()).isEqualTo(0L)
        assertThat(tweetDetail.retweetCount()).isEqualTo(0L)
        assertThat(tweetDetail.text()).isEqualTo("text")
        assertThat(tweetDetail.viewCount()).isEqualTo(0L)
        assertThat(tweetDetail.conversationId()).contains("conversationId")
        assertThat(tweetDetail.createdAt()).contains("createdAt")
        assertThat(tweetDetail._entities()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(tweetDetail.isNoteTweet()).contains(true)
        assertThat(tweetDetail.isQuoteStatus()).contains(true)
        assertThat(tweetDetail.isReply()).contains(true)
        assertThat(tweetDetail.media().getOrNull())
            .containsExactly(
                TweetDetail.Media.builder()
                    .mediaUrl("mediaUrl")
                    .type(TweetDetail.Media.Type.PHOTO)
                    .url("url")
                    .build()
            )
        assertThat(tweetDetail._quotedTweet()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(tweetDetail.source()).contains("source")
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
                .conversationId("conversationId")
                .createdAt("createdAt")
                .entities(JsonValue.from(mapOf<String, Any>()))
                .isNoteTweet(true)
                .isQuoteStatus(true)
                .isReply(true)
                .addMedia(
                    TweetDetail.Media.builder()
                        .mediaUrl("mediaUrl")
                        .type(TweetDetail.Media.Type.PHOTO)
                        .url("url")
                        .build()
                )
                .quotedTweet(JsonValue.from(mapOf<String, Any>()))
                .source("source")
                .build()

        val roundtrippedTweetDetail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetDetail),
                jacksonTypeRef<TweetDetail>(),
            )

        assertThat(roundtrippedTweetDetail).isEqualTo(tweetDetail)
    }
}
