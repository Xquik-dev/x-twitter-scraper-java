// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.styles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StyleListResponseTest {

    @Test
    fun create() {
        val styleListResponse =
            StyleListResponse.builder()
                .addStyle(
                    StyleListResponse.Style.builder()
                        .fetchedAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .isOwnAccount(true)
                        .tweetCount(50L)
                        .xUsername("elonmusk")
                        .build()
                )
                .build()

        assertThat(styleListResponse.styles())
            .containsExactly(
                StyleListResponse.Style.builder()
                    .fetchedAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                    .isOwnAccount(true)
                    .tweetCount(50L)
                    .xUsername("elonmusk")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val styleListResponse =
            StyleListResponse.builder()
                .addStyle(
                    StyleListResponse.Style.builder()
                        .fetchedAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .isOwnAccount(true)
                        .tweetCount(50L)
                        .xUsername("elonmusk")
                        .build()
                )
                .build()

        val roundtrippedStyleListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(styleListResponse),
                jacksonTypeRef<StyleListResponse>(),
            )

        assertThat(roundtrippedStyleListResponse).isEqualTo(styleListResponse)
    }
}
