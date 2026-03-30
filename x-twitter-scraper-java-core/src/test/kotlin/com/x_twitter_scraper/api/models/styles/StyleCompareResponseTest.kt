// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.styles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StyleCompareResponseTest {

    @Test
    fun create() {
        val styleCompareResponse =
            StyleCompareResponse.builder()
                .style1(
                    StyleProfile.builder()
                        .fetchedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .isOwnAccount(true)
                        .tweetCount(0L)
                        .addTweet(
                            StyleProfile.Tweet.builder()
                                .id("id")
                                .text("text")
                                .authorUsername("authorUsername")
                                .createdAt("createdAt")
                                .build()
                        )
                        .xUsername("xUsername")
                        .build()
                )
                .style2(
                    StyleProfile.builder()
                        .fetchedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .isOwnAccount(true)
                        .tweetCount(0L)
                        .addTweet(
                            StyleProfile.Tweet.builder()
                                .id("id")
                                .text("text")
                                .authorUsername("authorUsername")
                                .createdAt("createdAt")
                                .build()
                        )
                        .xUsername("xUsername")
                        .build()
                )
                .build()

        assertThat(styleCompareResponse.style1())
            .isEqualTo(
                StyleProfile.builder()
                    .fetchedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .isOwnAccount(true)
                    .tweetCount(0L)
                    .addTweet(
                        StyleProfile.Tweet.builder()
                            .id("id")
                            .text("text")
                            .authorUsername("authorUsername")
                            .createdAt("createdAt")
                            .build()
                    )
                    .xUsername("xUsername")
                    .build()
            )
        assertThat(styleCompareResponse.style2())
            .isEqualTo(
                StyleProfile.builder()
                    .fetchedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .isOwnAccount(true)
                    .tweetCount(0L)
                    .addTweet(
                        StyleProfile.Tweet.builder()
                            .id("id")
                            .text("text")
                            .authorUsername("authorUsername")
                            .createdAt("createdAt")
                            .build()
                    )
                    .xUsername("xUsername")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val styleCompareResponse =
            StyleCompareResponse.builder()
                .style1(
                    StyleProfile.builder()
                        .fetchedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .isOwnAccount(true)
                        .tweetCount(0L)
                        .addTweet(
                            StyleProfile.Tweet.builder()
                                .id("id")
                                .text("text")
                                .authorUsername("authorUsername")
                                .createdAt("createdAt")
                                .build()
                        )
                        .xUsername("xUsername")
                        .build()
                )
                .style2(
                    StyleProfile.builder()
                        .fetchedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .isOwnAccount(true)
                        .tweetCount(0L)
                        .addTweet(
                            StyleProfile.Tweet.builder()
                                .id("id")
                                .text("text")
                                .authorUsername("authorUsername")
                                .createdAt("createdAt")
                                .build()
                        )
                        .xUsername("xUsername")
                        .build()
                )
                .build()

        val roundtrippedStyleCompareResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(styleCompareResponse),
                jacksonTypeRef<StyleCompareResponse>(),
            )

        assertThat(roundtrippedStyleCompareResponse).isEqualTo(styleCompareResponse)
    }
}
