// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class XGetArticleResponseTest {

    @Test
    fun create() {
        val xGetArticleResponse =
            XGetArticleResponse.builder()
                .article(
                    XGetArticleResponse.Article.builder()
                        .bodyText("This is the first paragraph of the article.")
                        .addContent(
                            XGetArticleResponse.Article.Content.builder()
                                .height(675L)
                                .addInlineStyleRange(
                                    XGetArticleResponse.Article.Content.InlineStyleRange.builder()
                                        .length(8L)
                                        .offset(0L)
                                        .style("BOLD")
                                        .build()
                                )
                                .previewUrl("https://pbs.twimg.com/media/example.jpg")
                                .text("This is the first paragraph of the article.")
                                .type("paragraph")
                                .url("https://pbs.twimg.com/media/example.jpg")
                                .width(1200L)
                                .build()
                        )
                        .coverImageUrl("https://pbs.twimg.com/media/example.jpg")
                        .createdAt("2025-01-15T12:00:00Z")
                        .likeCount(150L)
                        .previewText("A deep dive into the latest AI trends...")
                        .quoteCount(8L)
                        .replyCount(23L)
                        .title("The Future of AI")
                        .viewCount(5000L)
                        .build()
                )
                .author(
                    XGetArticleResponse.Author.builder()
                        .id("9876543210")
                        .name("Elon Musk")
                        .username("elonmusk")
                        .canDm(true)
                        .createdAt("createdAt")
                        .description("description")
                        .favouritesCount(0L)
                        .followersCount(0L)
                        .followingCount(0L)
                        .isBlueVerified(true)
                        .isTranslator(true)
                        .isVerified(true)
                        .location("location")
                        .mediaCount(0L)
                        .profileBannerUrl("profileBannerUrl")
                        .profilePicture("profilePicture")
                        .protected_(true)
                        .statusesCount(0L)
                        .url("url")
                        .build()
                )
                .build()

        assertThat(xGetArticleResponse.article())
            .isEqualTo(
                XGetArticleResponse.Article.builder()
                    .bodyText("This is the first paragraph of the article.")
                    .addContent(
                        XGetArticleResponse.Article.Content.builder()
                            .height(675L)
                            .addInlineStyleRange(
                                XGetArticleResponse.Article.Content.InlineStyleRange.builder()
                                    .length(8L)
                                    .offset(0L)
                                    .style("BOLD")
                                    .build()
                            )
                            .previewUrl("https://pbs.twimg.com/media/example.jpg")
                            .text("This is the first paragraph of the article.")
                            .type("paragraph")
                            .url("https://pbs.twimg.com/media/example.jpg")
                            .width(1200L)
                            .build()
                    )
                    .coverImageUrl("https://pbs.twimg.com/media/example.jpg")
                    .createdAt("2025-01-15T12:00:00Z")
                    .likeCount(150L)
                    .previewText("A deep dive into the latest AI trends...")
                    .quoteCount(8L)
                    .replyCount(23L)
                    .title("The Future of AI")
                    .viewCount(5000L)
                    .build()
            )
        assertThat(xGetArticleResponse.author())
            .contains(
                XGetArticleResponse.Author.builder()
                    .id("9876543210")
                    .name("Elon Musk")
                    .username("elonmusk")
                    .canDm(true)
                    .createdAt("createdAt")
                    .description("description")
                    .favouritesCount(0L)
                    .followersCount(0L)
                    .followingCount(0L)
                    .isBlueVerified(true)
                    .isTranslator(true)
                    .isVerified(true)
                    .location("location")
                    .mediaCount(0L)
                    .profileBannerUrl("profileBannerUrl")
                    .profilePicture("profilePicture")
                    .protected_(true)
                    .statusesCount(0L)
                    .url("url")
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
                        .bodyText("This is the first paragraph of the article.")
                        .addContent(
                            XGetArticleResponse.Article.Content.builder()
                                .height(675L)
                                .addInlineStyleRange(
                                    XGetArticleResponse.Article.Content.InlineStyleRange.builder()
                                        .length(8L)
                                        .offset(0L)
                                        .style("BOLD")
                                        .build()
                                )
                                .previewUrl("https://pbs.twimg.com/media/example.jpg")
                                .text("This is the first paragraph of the article.")
                                .type("paragraph")
                                .url("https://pbs.twimg.com/media/example.jpg")
                                .width(1200L)
                                .build()
                        )
                        .coverImageUrl("https://pbs.twimg.com/media/example.jpg")
                        .createdAt("2025-01-15T12:00:00Z")
                        .likeCount(150L)
                        .previewText("A deep dive into the latest AI trends...")
                        .quoteCount(8L)
                        .replyCount(23L)
                        .title("The Future of AI")
                        .viewCount(5000L)
                        .build()
                )
                .author(
                    XGetArticleResponse.Author.builder()
                        .id("9876543210")
                        .name("Elon Musk")
                        .username("elonmusk")
                        .canDm(true)
                        .createdAt("createdAt")
                        .description("description")
                        .favouritesCount(0L)
                        .followersCount(0L)
                        .followingCount(0L)
                        .isBlueVerified(true)
                        .isTranslator(true)
                        .isVerified(true)
                        .location("location")
                        .mediaCount(0L)
                        .profileBannerUrl("profileBannerUrl")
                        .profilePicture("profilePicture")
                        .protected_(true)
                        .statusesCount(0L)
                        .url("url")
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
