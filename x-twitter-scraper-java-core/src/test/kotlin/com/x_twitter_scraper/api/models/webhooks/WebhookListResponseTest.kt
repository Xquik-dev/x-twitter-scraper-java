// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

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
                        .consecutiveFailures(0L)
                        .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .deliveryStatus(Webhook.DeliveryStatus.ACTIVE)
                        .addEventType(EventType.TWEET_NEW)
                        .addEventType(EventType.TWEET_REPLY)
                        .failureHardCap(200L)
                        .isActive(true)
                        .url("https://example.com/webhooks/xquik")
                        .build()
                )
                .build()

        assertThat(webhookListResponse.webhooks())
            .containsExactly(
                Webhook.builder()
                    .id("42")
                    .consecutiveFailures(0L)
                    .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                    .deliveryStatus(Webhook.DeliveryStatus.ACTIVE)
                    .addEventType(EventType.TWEET_NEW)
                    .addEventType(EventType.TWEET_REPLY)
                    .failureHardCap(200L)
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
                        .consecutiveFailures(0L)
                        .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .deliveryStatus(Webhook.DeliveryStatus.ACTIVE)
                        .addEventType(EventType.TWEET_NEW)
                        .addEventType(EventType.TWEET_REPLY)
                        .failureHardCap(200L)
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

    @Test
    fun additionalFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json = """{"hasMore":true,"nextCursor":"sample"}"""
        val model = jsonMapper.readValue(json, jacksonTypeRef<WebhookListResponse>())

        assertThat(model.hasMore()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("hasMore")
        assertThat(model.nextCursor()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("nextCursor")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<WebhookListResponse>(),
                )
            )
            .isEqualTo(model)
    }
}
