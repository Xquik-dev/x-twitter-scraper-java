// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

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

    @Test
    fun readsEveryFieldTheSpecDescribes() {
        val xGetArticleResponse =
            jsonMapper()
                .readValue(
                    """
                    {
                      "article": {
                        "articleId": "2100651802404544512",
                        "title": "The Future of AI",
                        "previewText": "A deep dive into the latest AI trends...",
                        "summaryText": "- Pinned DMs now work on desktop.",
                        "coverImageUrl": "https://pbs.twimg.com/media/example.jpg",
                        "coverMedia": {},
                        "metadata": {},
                        "lifecycleState": {},
                        "bodyText": "This is the first paragraph of the article.",
                        "bodyMarkdown": "## Pinned DMs\n\n**Pinning DMs** now works on [desktop](https://x.com/discord).",
                        "contents": [
                          {
                            "type": "paragraph",
                            "tweetId": "2058951429612875794",
                            "links": [
                              {
                                "offset": 15,
                                "length": 13,
                                "url": "https://x.com/discord"
                              }
                            ],
                            "text": "This is the first paragraph of the article.",
                            "url": "https://pbs.twimg.com/media/example.jpg",
                            "previewUrl": "https://pbs.twimg.com/media/example.jpg",
                            "width": 1200,
                            "height": 675,
                            "mediaType": "video",
                            "caption": "Wordle is excellent because of its simplicity",
                            "altText": "A chart of daily active users",
                            "durationMs": 42376,
                            "variants": [
                              {
                                "bitrate": 832000,
                                "contentType": "video/mp4",
                                "url": "https://video.twimg.com/ext_tw_video/1765989573685837824/pu/vid/avc1/462x360/RbrgrAMdncI-EzW7.mp4?tag=12"
                              }
                            ],
                            "inlineStyleRanges": [
                              {
                                "offset": 0,
                                "length": 8,
                                "style": "Bold"
                              }
                            ]
                          }
                        ],
                        "createdAt": "2025-01-15T12:00:00Z",
                        "likeCount": 150,
                        "replyCount": 23,
                        "quoteCount": 8,
                        "retweetCount": 105,
                        "bookmarkCount": 423,
                        "viewCount": 5000
                      },
                      "author": {
                        "id": "9876543210",
                        "name": "Elon Musk",
                        "username": "elonmusk",
                        "description": "description-value",
                        "location": "location-value",
                        "url": "url-value",
                        "createdAt": "createdAt-value",
                        "followersCount": 1610,
                        "followingCount": 1598,
                        "statusesCount": 1513,
                        "mediaCount": 1133,
                        "favouritesCount": 1717,
                        "profilePicture": "profilePicture-value",
                        "profilePictureOriginal": "profilePictureOriginal-value",
                        "profileBannerUrl": "profileBannerUrl-value",
                        "isBlueVerified": true,
                        "isVerified": true,
                        "isTranslator": true,
                        "protected": true
                      }
                    }
                    """
                        .trimIndent(),
                    jacksonTypeRef<XGetArticleResponse>(),
                )

        xGetArticleResponse.validate()
        assertThat(xGetArticleResponse.article().articleId()).contains("2100651802404544512")
        assertThat(xGetArticleResponse.article().bodyMarkdown())
            .contains(
                "## Pinned DMs\n\n**Pinning DMs** now works on [desktop](https://x.com/discord)."
            )
        assertThat(xGetArticleResponse.article().bodyText())
            .contains("This is the first paragraph of the article.")
        assertThat(xGetArticleResponse.article().bookmarkCount()).contains(423L)
        assertThat(xGetArticleResponse.article().contents().get()).hasSize(1)
        assertThat(xGetArticleResponse.article().contents().get()[0].altText())
            .contains("A chart of daily active users")
        assertThat(xGetArticleResponse.article().contents().get()[0].caption())
            .contains("Wordle is excellent because of its simplicity")
        assertThat(xGetArticleResponse.article().contents().get()[0].durationMs()).contains(42376L)
        assertThat(xGetArticleResponse.article().contents().get()[0].height()).contains(675L)
        assertThat(xGetArticleResponse.article().contents().get()[0].inlineStyleRanges().get())
            .hasSize(1)
        assertThat(
                xGetArticleResponse
                    .article()
                    .contents()
                    .get()[0]
                    .inlineStyleRanges()
                    .get()[0]
                    .length()
            )
            .contains(8L)
        assertThat(
                xGetArticleResponse
                    .article()
                    .contents()
                    .get()[0]
                    .inlineStyleRanges()
                    .get()[0]
                    .offset()
            )
            .contains(0L)
        assertThat(
                xGetArticleResponse
                    .article()
                    .contents()
                    .get()[0]
                    .inlineStyleRanges()
                    .get()[0]
                    .style()
            )
            .contains("Bold")
        assertThat(
                xGetArticleResponse
                    .article()
                    .contents()
                    .get()[0]
                    .inlineStyleRanges()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(xGetArticleResponse.article().contents().get()[0].links().get()).hasSize(1)
        assertThat(xGetArticleResponse.article().contents().get()[0].links().get()[0].length())
            .contains(13L)
        assertThat(xGetArticleResponse.article().contents().get()[0].links().get()[0].offset())
            .contains(15L)
        assertThat(xGetArticleResponse.article().contents().get()[0].links().get()[0].url())
            .contains("https://x.com/discord")
        assertThat(
                xGetArticleResponse
                    .article()
                    .contents()
                    .get()[0]
                    .links()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(xGetArticleResponse.article().contents().get()[0].mediaType())
            .contains(XGetArticleResponse.Article.Content.MediaType.VIDEO)
        assertThat(xGetArticleResponse.article().contents().get()[0].previewUrl())
            .contains("https://pbs.twimg.com/media/example.jpg")
        assertThat(xGetArticleResponse.article().contents().get()[0].text())
            .contains("This is the first paragraph of the article.")
        assertThat(xGetArticleResponse.article().contents().get()[0].tweetId())
            .contains("2058951429612875794")
        assertThat(xGetArticleResponse.article().contents().get()[0].type()).contains("paragraph")
        assertThat(xGetArticleResponse.article().contents().get()[0].url())
            .contains("https://pbs.twimg.com/media/example.jpg")
        assertThat(xGetArticleResponse.article().contents().get()[0].variants().get()).hasSize(1)
        assertThat(
                xGetArticleResponse.article().contents().get()[0].variants().get()[0].contentType()
            )
            .isEqualTo("video/mp4")
        assertThat(xGetArticleResponse.article().contents().get()[0].variants().get()[0].url())
            .isEqualTo(
                "https://video.twimg.com/ext_tw_video/1765989573685837824/pu/vid/avc1/462x360/RbrgrAMdncI-EzW7.mp4?tag=12"
            )
        assertThat(xGetArticleResponse.article().contents().get()[0].variants().get()[0].bitrate())
            .contains(832000L)
        assertThat(
                xGetArticleResponse
                    .article()
                    .contents()
                    .get()[0]
                    .variants()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(xGetArticleResponse.article().contents().get()[0].width()).contains(1200L)
        assertThat(xGetArticleResponse.article().contents().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(xGetArticleResponse.article().coverImageUrl())
            .contains("https://pbs.twimg.com/media/example.jpg")
        assertThat(xGetArticleResponse.article().createdAt()).contains("2025-01-15T12:00:00Z")
        assertThat(xGetArticleResponse.article().likeCount()).contains(150L)
        assertThat(xGetArticleResponse.article().previewText())
            .contains("A deep dive into the latest AI trends...")
        assertThat(xGetArticleResponse.article().quoteCount()).contains(8L)
        assertThat(xGetArticleResponse.article().replyCount()).contains(23L)
        assertThat(xGetArticleResponse.article().retweetCount()).contains(105L)
        assertThat(xGetArticleResponse.article().summaryText())
            .contains("- Pinned DMs now work on desktop.")
        assertThat(xGetArticleResponse.article().title()).contains("The Future of AI")
        assertThat(xGetArticleResponse.article().viewCount()).contains(5000L)
        assertThat(xGetArticleResponse.article()._additionalProperties()).isEmpty()
        assertThat(xGetArticleResponse.author().get().id()).isEqualTo("9876543210")
        assertThat(xGetArticleResponse.author().get().name()).isEqualTo("Elon Musk")
        assertThat(xGetArticleResponse.author().get().username()).isEqualTo("elonmusk")
        assertThat(xGetArticleResponse.author().get().createdAt()).contains("createdAt-value")
        assertThat(xGetArticleResponse.author().get().description()).contains("description-value")
        assertThat(xGetArticleResponse.author().get().favouritesCount()).contains(1717L)
        assertThat(xGetArticleResponse.author().get().followersCount()).contains(1610L)
        assertThat(xGetArticleResponse.author().get().followingCount()).contains(1598L)
        assertThat(xGetArticleResponse.author().get().isBlueVerified()).contains(true)
        assertThat(xGetArticleResponse.author().get().isTranslator()).contains(true)
        assertThat(xGetArticleResponse.author().get().isVerified()).contains(true)
        assertThat(xGetArticleResponse.author().get().location()).contains("location-value")
        assertThat(xGetArticleResponse.author().get().mediaCount()).contains(1133L)
        assertThat(xGetArticleResponse.author().get().profileBannerUrl())
            .contains("profileBannerUrl-value")
        assertThat(xGetArticleResponse.author().get().profilePicture())
            .contains("profilePicture-value")
        assertThat(xGetArticleResponse.author().get().profilePictureOriginal())
            .contains("profilePictureOriginal-value")
        assertThat(xGetArticleResponse.author().get().protected_()).contains(true)
        assertThat(xGetArticleResponse.author().get().statusesCount()).contains(1513L)
        assertThat(xGetArticleResponse.author().get().url()).contains("url-value")
        assertThat(xGetArticleResponse.author().get()._additionalProperties()).isEmpty()
        assertThat(xGetArticleResponse._additionalProperties()).isEmpty()
    }
}
