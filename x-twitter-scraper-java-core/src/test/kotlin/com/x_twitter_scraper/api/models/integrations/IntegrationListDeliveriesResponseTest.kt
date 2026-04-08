// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.integrations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class IntegrationListDeliveriesResponseTest {

    @Test
    fun create() {
        val integrationListDeliveriesResponse =
            IntegrationListDeliveriesResponse.builder()
                .addDelivery(
                    IntegrationListDeliveriesResponse.Delivery.builder()
                        .id("42")
                        .attempts(1L)
                        .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .eventType("tweet.new")
                        .status("delivered")
                        .deliveredAt(OffsetDateTime.parse("2025-01-15T12:00:01Z"))
                        .lastError("")
                        .lastStatusCode(200L)
                        .sourceId("100")
                        .sourceType("monitor")
                        .build()
                )
                .build()

        assertThat(integrationListDeliveriesResponse.deliveries())
            .containsExactly(
                IntegrationListDeliveriesResponse.Delivery.builder()
                    .id("42")
                    .attempts(1L)
                    .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                    .eventType("tweet.new")
                    .status("delivered")
                    .deliveredAt(OffsetDateTime.parse("2025-01-15T12:00:01Z"))
                    .lastError("")
                    .lastStatusCode(200L)
                    .sourceId("100")
                    .sourceType("monitor")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val integrationListDeliveriesResponse =
            IntegrationListDeliveriesResponse.builder()
                .addDelivery(
                    IntegrationListDeliveriesResponse.Delivery.builder()
                        .id("42")
                        .attempts(1L)
                        .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .eventType("tweet.new")
                        .status("delivered")
                        .deliveredAt(OffsetDateTime.parse("2025-01-15T12:00:01Z"))
                        .lastError("")
                        .lastStatusCode(200L)
                        .sourceId("100")
                        .sourceType("monitor")
                        .build()
                )
                .build()

        val roundtrippedIntegrationListDeliveriesResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(integrationListDeliveriesResponse),
                jacksonTypeRef<IntegrationListDeliveriesResponse>(),
            )

        assertThat(roundtrippedIntegrationListDeliveriesResponse)
            .isEqualTo(integrationListDeliveriesResponse)
    }
}
