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
                )
                .build()

        assertThat(integrationListDeliveriesResponse.deliveries())
            .containsExactly(
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
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val integrationListDeliveriesResponse =
            IntegrationListDeliveriesResponse.builder()
                .addDelivery(
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
