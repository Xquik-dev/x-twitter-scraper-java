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
                    StyleCompareResponse.Style1.builder()
                        .fetchedAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .isOwnAccount(true)
                        .tweetCount(50L)
                        .addTweet(
                            StyleCompareResponse.Style1.Tweet.builder()
                                .id("1234567890")
                                .text("Just launched our new feature!")
                                .authorUsername("elonmusk")
                                .createdAt("2025-01-15T12:00:00Z")
                                .build()
                        )
                        .xUsername("elonmusk")
                        .build()
                )
                .style2(
                    StyleCompareResponse.Style2.builder()
                        .fetchedAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .isOwnAccount(true)
                        .tweetCount(50L)
                        .addTweet(
                            StyleCompareResponse.Style2.Tweet.builder()
                                .id("1234567890")
                                .text("Just launched our new feature!")
                                .authorUsername("elonmusk")
                                .createdAt("2025-01-15T12:00:00Z")
                                .build()
                        )
                        .xUsername("elonmusk")
                        .build()
                )
                .build()

        assertThat(styleCompareResponse.style1())
            .isEqualTo(
                StyleCompareResponse.Style1.builder()
                    .fetchedAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                    .isOwnAccount(true)
                    .tweetCount(50L)
                    .addTweet(
                        StyleCompareResponse.Style1.Tweet.builder()
                            .id("1234567890")
                            .text("Just launched our new feature!")
                            .authorUsername("elonmusk")
                            .createdAt("2025-01-15T12:00:00Z")
                            .build()
                    )
                    .xUsername("elonmusk")
                    .build()
            )
        assertThat(styleCompareResponse.style2())
            .isEqualTo(
                StyleCompareResponse.Style2.builder()
                    .fetchedAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                    .isOwnAccount(true)
                    .tweetCount(50L)
                    .addTweet(
                        StyleCompareResponse.Style2.Tweet.builder()
                            .id("1234567890")
                            .text("Just launched our new feature!")
                            .authorUsername("elonmusk")
                            .createdAt("2025-01-15T12:00:00Z")
                            .build()
                    )
                    .xUsername("elonmusk")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val styleCompareResponse =
            StyleCompareResponse.builder()
                .style1(
                    StyleCompareResponse.Style1.builder()
                        .fetchedAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .isOwnAccount(true)
                        .tweetCount(50L)
                        .addTweet(
                            StyleCompareResponse.Style1.Tweet.builder()
                                .id("1234567890")
                                .text("Just launched our new feature!")
                                .authorUsername("elonmusk")
                                .createdAt("2025-01-15T12:00:00Z")
                                .build()
                        )
                        .xUsername("elonmusk")
                        .build()
                )
                .style2(
                    StyleCompareResponse.Style2.builder()
                        .fetchedAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .isOwnAccount(true)
                        .tweetCount(50L)
                        .addTweet(
                            StyleCompareResponse.Style2.Tweet.builder()
                                .id("1234567890")
                                .text("Just launched our new feature!")
                                .authorUsername("elonmusk")
                                .createdAt("2025-01-15T12:00:00Z")
                                .build()
                        )
                        .xUsername("elonmusk")
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
