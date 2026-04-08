// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.EventType
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookTest {

    @Test
    fun create() {
        val webhook =
            Webhook.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(EventType.TWEET_NEW)
                .addEventType(EventType.FOLLOWER_GAINED)
                .isActive(true)
                .url("https://example.com/webhooks/xquik")
                .build()

        assertThat(webhook.id()).isEqualTo("42")
        assertThat(webhook.createdAt()).isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(webhook.eventTypes())
            .containsExactly(EventType.TWEET_NEW, EventType.FOLLOWER_GAINED)
        assertThat(webhook.isActive()).isEqualTo(true)
        assertThat(webhook.url()).isEqualTo("https://example.com/webhooks/xquik")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhook =
            Webhook.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(EventType.TWEET_NEW)
                .addEventType(EventType.FOLLOWER_GAINED)
                .isActive(true)
                .url("https://example.com/webhooks/xquik")
                .build()

        val roundtrippedWebhook =
            jsonMapper.readValue(jsonMapper.writeValueAsString(webhook), jacksonTypeRef<Webhook>())

        assertThat(roundtrippedWebhook).isEqualTo(webhook)
    }
}
