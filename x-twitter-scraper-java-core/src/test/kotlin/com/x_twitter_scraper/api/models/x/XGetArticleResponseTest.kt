// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.x.tweets.TweetAuthor
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class XGetArticleResponseTest {

    @Test
    fun create() {
        val xGetArticleResponse =
            XGetArticleResponse.builder()
                .article(
                    XGetArticleResponse.Article.builder()
                        .addContent(
                            XGetArticleResponse.Article.Content.builder()
                                .height(0L)
                                .text("text")
                                .type("type")
                                .url("url")
                                .width(0L)
                                .build()
                        )
                        .coverImageUrl("coverImageUrl")
                        .createdAt("createdAt")
                        .likeCount(0L)
                        .previewText("previewText")
                        .quoteCount(0L)
                        .replyCount(0L)
                        .title("title")
                        .viewCount(0L)
                        .build()
                )
                .author(
                    TweetAuthor.builder()
                        .id("id")
                        .followers(0L)
                        .username("username")
                        .verified(true)
                        .profilePicture("profilePicture")
                        .build()
                )
                .build()

        assertThat(xGetArticleResponse.article())
            .isEqualTo(
                XGetArticleResponse.Article.builder()
                    .addContent(
                        XGetArticleResponse.Article.Content.builder()
                            .height(0L)
                            .text("text")
                            .type("type")
                            .url("url")
                            .width(0L)
                            .build()
                    )
                    .coverImageUrl("coverImageUrl")
                    .createdAt("createdAt")
                    .likeCount(0L)
                    .previewText("previewText")
                    .quoteCount(0L)
                    .replyCount(0L)
                    .title("title")
                    .viewCount(0L)
                    .build()
            )
        assertThat(xGetArticleResponse.author())
            .contains(
                TweetAuthor.builder()
                    .id("id")
                    .followers(0L)
                    .username("username")
                    .verified(true)
                    .profilePicture("profilePicture")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val xGetArticleResponse =
            XGetArticleResponse.builder()
                .article(
                    XGetArticleResponse.Article.builder()
                        .addContent(
                            XGetArticleResponse.Article.Content.builder()
                                .height(0L)
                                .text("text")
                                .type("type")
                                .url("url")
                                .width(0L)
                                .build()
                        )
                        .coverImageUrl("coverImageUrl")
                        .createdAt("createdAt")
                        .likeCount(0L)
                        .previewText("previewText")
                        .quoteCount(0L)
                        .replyCount(0L)
                        .title("title")
                        .viewCount(0L)
                        .build()
                )
                .author(
                    TweetAuthor.builder()
                        .id("id")
                        .followers(0L)
                        .username("username")
                        .verified(true)
                        .profilePicture("profilePicture")
                        .build()
                )
                .build()

        val roundtrippedXGetArticleResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(xGetArticleResponse),
                jacksonTypeRef<XGetArticleResponse>(),
            )

        assertThat(roundtrippedXGetArticleResponse).isEqualTo(xGetArticleResponse)
    }
}
