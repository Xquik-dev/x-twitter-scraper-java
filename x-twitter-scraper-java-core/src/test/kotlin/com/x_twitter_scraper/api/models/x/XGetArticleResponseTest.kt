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
                                .height(675L)
                                .text("This is the first paragraph of the article.")
                                .type("unstyled")
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
                    TweetAuthor.builder()
                        .id("9876543210")
                        .followers(150000000L)
                        .username("elonmusk")
                        .verified(true)
                        .profilePicture("https://pbs.twimg.com/profile_images/example.jpg")
                        .build()
                )
                .build()

        assertThat(xGetArticleResponse.article())
            .isEqualTo(
                XGetArticleResponse.Article.builder()
                    .addContent(
                        XGetArticleResponse.Article.Content.builder()
                            .height(675L)
                            .text("This is the first paragraph of the article.")
                            .type("unstyled")
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
        val xGetArticleResponse =
            XGetArticleResponse.builder()
                .article(
                    XGetArticleResponse.Article.builder()
                        .addContent(
                            XGetArticleResponse.Article.Content.builder()
                                .height(675L)
                                .text("This is the first paragraph of the article.")
                                .type("unstyled")
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
                    TweetAuthor.builder()
                        .id("9876543210")
                        .followers(150000000L)
                        .username("elonmusk")
                        .verified(true)
                        .profilePicture("https://pbs.twimg.com/profile_images/example.jpg")
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
