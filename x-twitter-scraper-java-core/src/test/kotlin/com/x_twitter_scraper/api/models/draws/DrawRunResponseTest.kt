// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.draws

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DrawRunResponseTest {

    @Test
    fun create() {
        val drawRunResponse =
            DrawRunResponse.builder()
                .id("id")
                .totalEntries(0L)
                .tweetId("tweetId")
                .validEntries(0L)
                .addWinner(
                    DrawRunResponse.Winner.builder()
                        .authorUsername("authorUsername")
                        .isBackup(true)
                        .position(0L)
                        .tweetId("tweetId")
                        .build()
                )
                .build()

        assertThat(drawRunResponse.id()).isEqualTo("id")
        assertThat(drawRunResponse.totalEntries()).isEqualTo(0L)
        assertThat(drawRunResponse.tweetId()).isEqualTo("tweetId")
        assertThat(drawRunResponse.validEntries()).isEqualTo(0L)
        assertThat(drawRunResponse.winners())
            .containsExactly(
                DrawRunResponse.Winner.builder()
                    .authorUsername("authorUsername")
                    .isBackup(true)
                    .position(0L)
                    .tweetId("tweetId")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val drawRunResponse =
            DrawRunResponse.builder()
                .id("id")
                .totalEntries(0L)
                .tweetId("tweetId")
                .validEntries(0L)
                .addWinner(
                    DrawRunResponse.Winner.builder()
                        .authorUsername("authorUsername")
                        .isBackup(true)
                        .position(0L)
                        .tweetId("tweetId")
                        .build()
                )
                .build()

        val roundtrippedDrawRunResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(drawRunResponse),
                jacksonTypeRef<DrawRunResponse>(),
            )

        assertThat(roundtrippedDrawRunResponse).isEqualTo(drawRunResponse)
    }
}
