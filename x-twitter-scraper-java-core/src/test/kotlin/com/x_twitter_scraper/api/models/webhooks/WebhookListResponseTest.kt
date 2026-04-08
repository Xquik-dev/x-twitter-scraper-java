// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.EventType
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookListResponseTest {

    @Test
    fun create() {
        val webhookListResponse =
            WebhookListResponse.builder()
                .addWebhook(
                    Webhook.builder()
                        .id("42")
                        .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .addEventType(EventType.TWEET_NEW)
                        .addEventType(EventType.FOLLOWER_GAINED)
                        .isActive(true)
                        .url("https://example.com/webhooks/xquik")
                        .build()
                )
                .build()

        assertThat(webhookListResponse.webhooks())
            .containsExactly(
                Webhook.builder()
                    .id("42")
                    .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                    .addEventType(EventType.TWEET_NEW)
                    .addEventType(EventType.FOLLOWER_GAINED)
                    .isActive(true)
                    .url("https://example.com/webhooks/xquik")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookListResponse =
            WebhookListResponse.builder()
                .addWebhook(
                    Webhook.builder()
                        .id("42")
                        .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .addEventType(EventType.TWEET_NEW)
                        .addEventType(EventType.FOLLOWER_GAINED)
                        .isActive(true)
                        .url("https://example.com/webhooks/xquik")
                        .build()
                )
                .build()

        val roundtrippedWebhookListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookListResponse),
                jacksonTypeRef<WebhookListResponse>(),
            )

        assertThat(roundtrippedWebhookListResponse).isEqualTo(webhookListResponse)
    }
}
