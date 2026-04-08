// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.integrations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class IntegrationDeliveryTest {

    @Test
    fun create() {
        val integrationDelivery =
            IntegrationDelivery.builder()
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

        assertThat(integrationDelivery.id()).isEqualTo("42")
        assertThat(integrationDelivery.attempts()).isEqualTo(1L)
        assertThat(integrationDelivery.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(integrationDelivery.eventType()).isEqualTo("tweet.new")
        assertThat(integrationDelivery.status()).isEqualTo("delivered")
        assertThat(integrationDelivery.deliveredAt())
            .contains(OffsetDateTime.parse("2025-01-15T12:00:01Z"))
        assertThat(integrationDelivery.lastError()).contains("")
        assertThat(integrationDelivery.lastStatusCode()).contains(200L)
        assertThat(integrationDelivery.sourceId()).contains("100")
        assertThat(integrationDelivery.sourceType()).contains("monitor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val integrationDelivery =
            IntegrationDelivery.builder()
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

        val roundtrippedIntegrationDelivery =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(integrationDelivery),
                jacksonTypeRef<IntegrationDelivery>(),
            )

        assertThat(roundtrippedIntegrationDelivery).isEqualTo(integrationDelivery)
    }
}
