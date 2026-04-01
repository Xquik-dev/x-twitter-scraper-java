// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.styles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StyleRetrieveResponseTest {

    @Test
    fun create() {
        val styleRetrieveResponse =
            StyleRetrieveResponse.builder()
                .fetchedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .isOwnAccount(true)
                .tweetCount(0L)
                .addTweet(
                    StyleRetrieveResponse.Tweet.builder()
                        .id("id")
                        .text("text")
                        .authorUsername("authorUsername")
                        .createdAt("createdAt")
                        .build()
                )
                .xUsername("xUsername")
                .build()

        assertThat(styleRetrieveResponse.fetchedAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(styleRetrieveResponse.isOwnAccount()).isEqualTo(true)
        assertThat(styleRetrieveResponse.tweetCount()).isEqualTo(0L)
        assertThat(styleRetrieveResponse.tweets())
            .containsExactly(
                StyleRetrieveResponse.Tweet.builder()
                    .id("id")
                    .text("text")
                    .authorUsername("authorUsername")
                    .createdAt("createdAt")
                    .build()
            )
        assertThat(styleRetrieveResponse.xUsername()).isEqualTo("xUsername")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val styleRetrieveResponse =
            StyleRetrieveResponse.builder()
                .fetchedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .isOwnAccount(true)
                .tweetCount(0L)
                .addTweet(
                    StyleRetrieveResponse.Tweet.builder()
                        .id("id")
                        .text("text")
                        .authorUsername("authorUsername")
                        .createdAt("createdAt")
                        .build()
                )
                .xUsername("xUsername")
                .build()

        val roundtrippedStyleRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(styleRetrieveResponse),
                jacksonTypeRef<StyleRetrieveResponse>(),
            )

        assertThat(roundtrippedStyleRetrieveResponse).isEqualTo(styleRetrieveResponse)
    }
}
