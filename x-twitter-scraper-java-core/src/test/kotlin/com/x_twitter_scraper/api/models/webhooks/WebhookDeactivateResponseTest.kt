// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookDeactivateResponseTest {

    @Test
    fun create() {
        val webhookDeactivateResponse = WebhookDeactivateResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookDeactivateResponse = WebhookDeactivateResponse.builder().build()

        val roundtrippedWebhookDeactivateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookDeactivateResponse),
                jacksonTypeRef<WebhookDeactivateResponse>(),
            )

        assertThat(roundtrippedWebhookDeactivateResponse).isEqualTo(webhookDeactivateResponse)
    }
}
