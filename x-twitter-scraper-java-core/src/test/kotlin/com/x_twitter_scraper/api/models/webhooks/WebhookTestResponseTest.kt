// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookTestResponseTest {

    @Test
    fun create() {
        val webhookTestResponse =
            WebhookTestResponse.builder().statusCode(200L).success(true).error("").build()

        assertThat(webhookTestResponse.statusCode()).isEqualTo(200L)
        assertThat(webhookTestResponse.success()).isEqualTo(true)
        assertThat(webhookTestResponse.error()).contains("")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookTestResponse =
            WebhookTestResponse.builder().statusCode(200L).success(true).error("").build()

        val roundtrippedWebhookTestResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookTestResponse),
                jacksonTypeRef<WebhookTestResponse>(),
            )

        assertThat(roundtrippedWebhookTestResponse).isEqualTo(webhookTestResponse)
    }
}
