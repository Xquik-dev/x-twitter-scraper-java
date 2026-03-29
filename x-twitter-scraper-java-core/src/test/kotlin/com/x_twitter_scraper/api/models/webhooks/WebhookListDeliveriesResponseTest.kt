// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookListDeliveriesResponseTest {

    @Test
    fun create() {
        val webhookListDeliveriesResponse =
            WebhookListDeliveriesResponse.builder()
                .addDelivery(
                    WebhookListDeliveriesResponse.Delivery.builder()
                        .id("id")
                        .attempts(0L)
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .status("status")
                        .streamEventId("streamEventId")
                        .deliveredAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .lastError("lastError")
                        .lastStatusCode(0L)
                        .build()
                )
                .build()

        assertThat(webhookListDeliveriesResponse.deliveries())
            .containsExactly(
                WebhookListDeliveriesResponse.Delivery.builder()
                    .id("id")
                    .attempts(0L)
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .status("status")
                    .streamEventId("streamEventId")
                    .deliveredAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .lastError("lastError")
                    .lastStatusCode(0L)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookListDeliveriesResponse =
            WebhookListDeliveriesResponse.builder()
                .addDelivery(
                    WebhookListDeliveriesResponse.Delivery.builder()
                        .id("id")
                        .attempts(0L)
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .status("status")
                        .streamEventId("streamEventId")
                        .deliveredAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .lastError("lastError")
                        .lastStatusCode(0L)
                        .build()
                )
                .build()

        val roundtrippedWebhookListDeliveriesResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookListDeliveriesResponse),
                jacksonTypeRef<WebhookListDeliveriesResponse>(),
            )

        assertThat(roundtrippedWebhookListDeliveriesResponse)
            .isEqualTo(webhookListDeliveriesResponse)
    }
}
