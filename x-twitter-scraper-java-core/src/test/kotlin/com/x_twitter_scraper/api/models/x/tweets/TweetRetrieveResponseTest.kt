// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetRetrieveResponseTest {

    @Test
    fun create() {
        val tweetRetrieveResponse =
            TweetRetrieveResponse.builder()
                .tweet(
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
                )
                .author(
                    TweetAuthor.builder()
                        .id("9876543210")
                        .followers(150000000L)
                        .username("elonmusk")
                        .verified(true)
                        .profilePicture("https://pbs.twimg.com/profile_images/example.jpg")
                        .build()
                )
                .build()

        assertThat(tweetRetrieveResponse.tweet())
            .isEqualTo(
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
            )
        assertThat(tweetRetrieveResponse.author())
            .contains(
                TweetAuthor.builder()
                    .id("9876543210")
                    .followers(150000000L)
                    .username("elonmusk")
                    .verified(true)
                    .profilePicture("https://pbs.twimg.com/profile_images/example.jpg")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tweetRetrieveResponse =
            TweetRetrieveResponse.builder()
                .tweet(
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
                )
                .author(
                    TweetAuthor.builder()
                        .id("9876543210")
                        .followers(150000000L)
                        .username("elonmusk")
                        .verified(true)
                        .profilePicture("https://pbs.twimg.com/profile_images/example.jpg")
                        .build()
                )
                .build()

        val roundtrippedTweetRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetRetrieveResponse),
                jacksonTypeRef<TweetRetrieveResponse>(),
            )

        assertThat(roundtrippedTweetRetrieveResponse).isEqualTo(tweetRetrieveResponse)
    }
}
