// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.bot

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BotTrackUsageParamsTest {

    @Test
    fun create() {
        BotTrackUsageParams.builder()
            .inputTokens(0L)
            .outputTokens(0L)
            .platformUserId("platformUserId")
            .build()
    }

    @Test
    fun body() {
        val params =
            BotTrackUsageParams.builder()
                .inputTokens(0L)
                .outputTokens(0L)
                .platformUserId("platformUserId")
                .build()

        val body = params._body()

        assertThat(body.inputTokens()).isEqualTo(0L)
        assertThat(body.outputTokens()).isEqualTo(0L)
        assertThat(body.platformUserId()).isEqualTo("platformUserId")
    }
}
