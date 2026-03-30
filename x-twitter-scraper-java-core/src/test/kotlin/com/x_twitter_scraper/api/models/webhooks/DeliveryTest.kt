// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DeliveryTest {

    @Test
    fun create() {
        val delivery =
            Delivery.builder()
                .id("id")
                .attempts(0L)
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status("status")
                .streamEventId("streamEventId")
                .deliveredAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .lastError("lastError")
                .lastStatusCode(0L)
                .build()

        assertThat(delivery.id()).isEqualTo("id")
        assertThat(delivery.attempts()).isEqualTo(0L)
        assertThat(delivery.createdAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(delivery.status()).isEqualTo("status")
        assertThat(delivery.streamEventId()).isEqualTo("streamEventId")
        assertThat(delivery.deliveredAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(delivery.lastError()).contains("lastError")
        assertThat(delivery.lastStatusCode()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val delivery =
            Delivery.builder()
                .id("id")
                .attempts(0L)
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status("status")
                .streamEventId("streamEventId")
                .deliveredAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .lastError("lastError")
                .lastStatusCode(0L)
                .build()

        val roundtrippedDelivery =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(delivery),
                jacksonTypeRef<Delivery>(),
            )

        assertThat(roundtrippedDelivery).isEqualTo(delivery)
    }
}
