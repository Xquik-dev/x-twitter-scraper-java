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

        assertThat(styleProfile.fetchedAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(styleProfile.isOwnAccount()).isEqualTo(true)
        assertThat(styleProfile.tweetCount()).isEqualTo(0L)
        assertThat(styleProfile.tweets())
            .containsExactly(
                StyleProfile.Tweet.builder()
                    .id("id")
                    .text("text")
                    .authorUsername("authorUsername")
                    .createdAt("createdAt")
                    .build()
            )
        assertThat(styleProfile.xUsername()).isEqualTo("xUsername")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val styleProfile =
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

        val roundtrippedStyleProfile =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(styleProfile),
                jacksonTypeRef<StyleProfile>(),
            )

        assertThat(roundtrippedStyleProfile).isEqualTo(styleProfile)
    }
}
