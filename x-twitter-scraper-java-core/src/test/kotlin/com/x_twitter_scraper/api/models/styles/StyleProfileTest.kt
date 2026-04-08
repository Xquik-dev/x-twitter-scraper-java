// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.styles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StyleProfileTest {

    @Test
    fun create() {
        val styleProfile =
            StyleProfile.builder()
                .fetchedAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .isOwnAccount(true)
                .tweetCount(50L)
                .addTweet(
                    StyleProfile.Tweet.builder()
                        .id("1234567890")
                        .text("Just launched our new feature!")
                        .authorUsername("elonmusk")
                        .createdAt("2025-01-15T12:00:00Z")
                        .build()
                )
                .xUsername("elonmusk")
                .build()

        assertThat(styleProfile.fetchedAt()).isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(styleProfile.isOwnAccount()).isEqualTo(true)
        assertThat(styleProfile.tweetCount()).isEqualTo(50L)
        assertThat(styleProfile.tweets())
            .containsExactly(
                StyleProfile.Tweet.builder()
                    .id("1234567890")
                    .text("Just launched our new feature!")
                    .authorUsername("elonmusk")
                    .createdAt("2025-01-15T12:00:00Z")
                    .build()
            )
        assertThat(styleProfile.xUsername()).isEqualTo("elonmusk")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val styleProfile =
            StyleProfile.builder()
                .fetchedAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .isOwnAccount(true)
                .tweetCount(50L)
                .addTweet(
                    StyleProfile.Tweet.builder()
                        .id("1234567890")
                        .text("Just launched our new feature!")
                        .authorUsername("elonmusk")
                        .createdAt("2025-01-15T12:00:00Z")
                        .build()
                )
                .xUsername("elonmusk")
                .build()

        val roundtrippedStyleProfile =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(styleProfile),
                jacksonTypeRef<StyleProfile>(),
            )

        assertThat(roundtrippedStyleProfile).isEqualTo(styleProfile)
    }
}
