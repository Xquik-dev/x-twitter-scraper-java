// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookUpdateResponseTest {

    @Test
    fun create() {
        val webhookUpdateResponse =
            WebhookUpdateResponse.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(WebhookUpdateResponse.EventType.TWEET_NEW)
                .addEventType(WebhookUpdateResponse.EventType.FOLLOWER_GAINED)
                .isActive(true)
                .url("https://example.com/webhooks/xquik")
                .build()

        assertThat(webhookUpdateResponse.id()).isEqualTo("42")
        assertThat(webhookUpdateResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(webhookUpdateResponse.eventTypes())
            .containsExactly(
                WebhookUpdateResponse.EventType.TWEET_NEW,
                WebhookUpdateResponse.EventType.FOLLOWER_GAINED,
            )
        assertThat(webhookUpdateResponse.isActive()).isEqualTo(true)
        assertThat(webhookUpdateResponse.url()).isEqualTo("https://example.com/webhooks/xquik")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookUpdateResponse =
            WebhookUpdateResponse.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(WebhookUpdateResponse.EventType.TWEET_NEW)
                .addEventType(WebhookUpdateResponse.EventType.FOLLOWER_GAINED)
                .isActive(true)
                .url("https://example.com/webhooks/xquik")
                .build()

        val roundtrippedWebhookUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookUpdateResponse),
                jacksonTypeRef<WebhookUpdateResponse>(),
            )

        assertThat(roundtrippedWebhookUpdateResponse).isEqualTo(webhookUpdateResponse)
    }
}
