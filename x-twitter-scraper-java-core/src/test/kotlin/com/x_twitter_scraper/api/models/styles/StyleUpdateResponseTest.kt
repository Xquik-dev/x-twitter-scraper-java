// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.styles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StyleUpdateResponseTest {

    @Test
    fun create() {
        val styleUpdateResponse =
            StyleUpdateResponse.builder()
                .fetchedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .isOwnAccount(true)
                .tweetCount(0L)
                .addTweet(
                    StyleUpdateResponse.Tweet.builder()
                        .id("id")
                        .text("text")
                        .authorUsername("authorUsername")
                        .createdAt("createdAt")
                        .build()
                )
                .xUsername("xUsername")
                .build()

        assertThat(styleUpdateResponse.fetchedAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(styleUpdateResponse.isOwnAccount()).isEqualTo(true)
        assertThat(styleUpdateResponse.tweetCount()).isEqualTo(0L)
        assertThat(styleUpdateResponse.tweets())
            .containsExactly(
                StyleUpdateResponse.Tweet.builder()
                    .id("id")
                    .text("text")
                    .authorUsername("authorUsername")
                    .createdAt("createdAt")
                    .build()
            )
        assertThat(styleUpdateResponse.xUsername()).isEqualTo("xUsername")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val styleUpdateResponse =
            StyleUpdateResponse.builder()
                .fetchedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .isOwnAccount(true)
                .tweetCount(0L)
                .addTweet(
                    StyleUpdateResponse.Tweet.builder()
                        .id("id")
                        .text("text")
                        .authorUsername("authorUsername")
                        .createdAt("createdAt")
                        .build()
                )
                .xUsername("xUsername")
                .build()

        val roundtrippedStyleUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(styleUpdateResponse),
                jacksonTypeRef<StyleUpdateResponse>(),
            )

        assertThat(roundtrippedStyleUpdateResponse).isEqualTo(styleUpdateResponse)
    }
}
