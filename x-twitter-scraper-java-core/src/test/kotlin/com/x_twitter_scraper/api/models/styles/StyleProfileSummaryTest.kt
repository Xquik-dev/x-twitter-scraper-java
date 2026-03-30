// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.styles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StyleProfileSummaryTest {

    @Test
    fun create() {
        val styleProfileSummary =
            StyleProfileSummary.builder()
                .fetchedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .isOwnAccount(true)
                .tweetCount(0L)
                .xUsername("xUsername")
                .build()

        assertThat(styleProfileSummary.fetchedAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(styleProfileSummary.isOwnAccount()).isEqualTo(true)
        assertThat(styleProfileSummary.tweetCount()).isEqualTo(0L)
        assertThat(styleProfileSummary.xUsername()).isEqualTo("xUsername")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val styleProfileSummary =
            StyleProfileSummary.builder()
                .fetchedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .isOwnAccount(true)
                .tweetCount(0L)
                .xUsername("xUsername")
                .build()

        val roundtrippedStyleProfileSummary =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(styleProfileSummary),
                jacksonTypeRef<StyleProfileSummary>(),
            )

        assertThat(roundtrippedStyleProfileSummary).isEqualTo(styleProfileSummary)
    }
}
