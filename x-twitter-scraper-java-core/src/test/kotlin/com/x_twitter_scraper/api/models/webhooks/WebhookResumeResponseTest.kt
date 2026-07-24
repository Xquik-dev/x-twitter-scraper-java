// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.EventType
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookResumeResponseTest {

    @Test
    fun create() {
        val webhookResumeResponse =
            WebhookResumeResponse.builder()
                .statusCode(200L)
                .success(true)
                .webhook(
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

        assertThat(webhookResumeResponse.statusCode()).isEqualTo(200L)
        assertThat(webhookResumeResponse.success()).isEqualTo(true)
        assertThat(webhookResumeResponse.webhook())
            .isEqualTo(
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
        val webhookResumeResponse =
            WebhookResumeResponse.builder()
                .statusCode(200L)
                .success(true)
                .webhook(
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

        val roundtrippedWebhookResumeResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookResumeResponse),
                jacksonTypeRef<WebhookResumeResponse>(),
            )

        assertThat(roundtrippedWebhookResumeResponse).isEqualTo(webhookResumeResponse)
    }
}
