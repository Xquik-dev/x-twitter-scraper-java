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
                    StyleProfileSummary.builder()
                        .fetchedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .isOwnAccount(true)
                        .tweetCount(0L)
                        .xUsername("xUsername")
                        .build()
                )
                .build()

        assertThat(styleListResponse.styles())
            .containsExactly(
                StyleProfileSummary.builder()
                    .fetchedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .isOwnAccount(true)
                    .tweetCount(0L)
                    .xUsername("xUsername")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val styleListResponse =
            StyleListResponse.builder()
                .addStyle(
                    StyleProfileSummary.builder()
                        .fetchedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .isOwnAccount(true)
                        .tweetCount(0L)
                        .xUsername("xUsername")
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
