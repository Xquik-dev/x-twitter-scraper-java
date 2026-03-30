// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.draws

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WinnerTest {

    @Test
    fun create() {
        val winner =
            Winner.builder()
                .authorUsername("authorUsername")
                .isBackup(true)
                .position(0L)
                .tweetId("tweetId")
                .build()

        assertThat(winner.authorUsername()).isEqualTo("authorUsername")
        assertThat(winner.isBackup()).isEqualTo(true)
        assertThat(winner.position()).isEqualTo(0L)
        assertThat(winner.tweetId()).isEqualTo("tweetId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val winner =
            Winner.builder()
                .authorUsername("authorUsername")
                .isBackup(true)
                .position(0L)
                .tweetId("tweetId")
                .build()

        val roundtrippedWinner =
            jsonMapper.readValue(jsonMapper.writeValueAsString(winner), jacksonTypeRef<Winner>())

        assertThat(roundtrippedWinner).isEqualTo(winner)
    }
}
