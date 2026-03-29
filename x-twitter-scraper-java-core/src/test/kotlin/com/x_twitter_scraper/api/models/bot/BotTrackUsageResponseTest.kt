// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.bot

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BotTrackUsageResponseTest {

    @Test
    fun create() {
        val botTrackUsageResponse = BotTrackUsageResponse.builder().success(true).build()

        assertThat(botTrackUsageResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val botTrackUsageResponse = BotTrackUsageResponse.builder().success(true).build()

        val roundtrippedBotTrackUsageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(botTrackUsageResponse),
                jacksonTypeRef<BotTrackUsageResponse>(),
            )

        assertThat(roundtrippedBotTrackUsageResponse).isEqualTo(botTrackUsageResponse)
    }
}
