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
                .id("id")
                .attempts(0L)
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .eventType("eventType")
                .status("status")
                .deliveredAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .lastError("lastError")
                .lastStatusCode(0L)
                .sourceId("sourceId")
                .sourceType("sourceType")
                .build()

        assertThat(integrationDelivery.id()).isEqualTo("id")
        assertThat(integrationDelivery.attempts()).isEqualTo(0L)
        assertThat(integrationDelivery.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(integrationDelivery.eventType()).isEqualTo("eventType")
        assertThat(integrationDelivery.status()).isEqualTo("status")
        assertThat(integrationDelivery.deliveredAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(integrationDelivery.lastError()).contains("lastError")
        assertThat(integrationDelivery.lastStatusCode()).contains(0L)
        assertThat(integrationDelivery.sourceId()).contains("sourceId")
        assertThat(integrationDelivery.sourceType()).contains("sourceType")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val integrationDelivery =
            IntegrationDelivery.builder()
                .id("id")
                .attempts(0L)
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .eventType("eventType")
                .status("status")
                .deliveredAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .lastError("lastError")
                .lastStatusCode(0L)
                .sourceId("sourceId")
                .sourceType("sourceType")
                .build()

        val roundtrippedIntegrationDelivery =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(integrationDelivery),
                jacksonTypeRef<IntegrationDelivery>(),
            )

        assertThat(roundtrippedIntegrationDelivery).isEqualTo(integrationDelivery)
    }
}
