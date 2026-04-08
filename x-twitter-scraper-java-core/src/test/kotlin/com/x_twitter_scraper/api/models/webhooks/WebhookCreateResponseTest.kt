// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookCreateResponseTest {

    @Test
    fun create() {
        val webhookCreateResponse =
            WebhookCreateResponse.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(WebhookCreateResponse.EventType.TWEET_NEW)
                .addEventType(WebhookCreateResponse.EventType.FOLLOWER_GAINED)
                .secret("whsec_abc123def456")
                .url("https://example.com/webhook")
                .build()

        assertThat(webhookCreateResponse.id()).isEqualTo("42")
        assertThat(webhookCreateResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(webhookCreateResponse.eventTypes())
            .containsExactly(
                WebhookCreateResponse.EventType.TWEET_NEW,
                WebhookCreateResponse.EventType.FOLLOWER_GAINED,
            )
        assertThat(webhookCreateResponse.secret()).isEqualTo("whsec_abc123def456")
        assertThat(webhookCreateResponse.url()).isEqualTo("https://example.com/webhook")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookCreateResponse =
            WebhookCreateResponse.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(WebhookCreateResponse.EventType.TWEET_NEW)
                .addEventType(WebhookCreateResponse.EventType.FOLLOWER_GAINED)
                .secret("whsec_abc123def456")
                .url("https://example.com/webhook")
                .build()

        val roundtrippedWebhookCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookCreateResponse),
                jacksonTypeRef<WebhookCreateResponse>(),
            )

        assertThat(roundtrippedWebhookCreateResponse).isEqualTo(webhookCreateResponse)
    }
}
