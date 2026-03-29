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
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addEventType(WebhookCreateResponse.EventType.TWEET_NEW)
                .secret("secret")
                .url("https://example.com")
                .build()

        assertThat(webhookCreateResponse.id()).isEqualTo("id")
        assertThat(webhookCreateResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(webhookCreateResponse.eventTypes())
            .containsExactly(WebhookCreateResponse.EventType.TWEET_NEW)
        assertThat(webhookCreateResponse.secret()).isEqualTo("secret")
        assertThat(webhookCreateResponse.url()).isEqualTo("https://example.com")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookCreateResponse =
            WebhookCreateResponse.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addEventType(WebhookCreateResponse.EventType.TWEET_NEW)
                .secret("secret")
                .url("https://example.com")
                .build()

        val roundtrippedWebhookCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookCreateResponse),
                jacksonTypeRef<WebhookCreateResponse>(),
            )

        assertThat(roundtrippedWebhookCreateResponse).isEqualTo(webhookCreateResponse)
    }
}
