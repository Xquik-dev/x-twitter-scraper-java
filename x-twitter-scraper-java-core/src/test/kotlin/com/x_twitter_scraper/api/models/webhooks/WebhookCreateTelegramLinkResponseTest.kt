// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookCreateTelegramLinkResponseTest {

    @Test
    fun create() {
        val webhookCreateTelegramLinkResponse =
            WebhookCreateTelegramLinkResponse.builder()
                .expiresAt(OffsetDateTime.parse("2025-01-15T12:15:00.000Z"))
                .url("https://t.me/XquikBot?start=Q2hhdExpbmtDb2RlRXhhbXBsZTAx")
                .build()

        assertThat(webhookCreateTelegramLinkResponse.expiresAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:15:00.000Z"))
        assertThat(webhookCreateTelegramLinkResponse.url())
            .isEqualTo("https://t.me/XquikBot?start=Q2hhdExpbmtDb2RlRXhhbXBsZTAx")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookCreateTelegramLinkResponse =
            WebhookCreateTelegramLinkResponse.builder()
                .expiresAt(OffsetDateTime.parse("2025-01-15T12:15:00.000Z"))
                .url("https://t.me/XquikBot?start=Q2hhdExpbmtDb2RlRXhhbXBsZTAx")
                .build()

        val roundtrippedWebhookCreateTelegramLinkResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookCreateTelegramLinkResponse),
                jacksonTypeRef<WebhookCreateTelegramLinkResponse>(),
            )

        assertThat(roundtrippedWebhookCreateTelegramLinkResponse)
            .isEqualTo(webhookCreateTelegramLinkResponse)
    }
}
