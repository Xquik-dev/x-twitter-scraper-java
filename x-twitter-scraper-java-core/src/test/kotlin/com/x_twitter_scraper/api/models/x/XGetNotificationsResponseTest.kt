// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class XGetNotificationsResponseTest {

    @Test
    fun create() {
        val xGetNotificationsResponse =
            XGetNotificationsResponse.builder()
                .hasNextPage(true)
                .nextCursor("DAACCgACGRElMJcAAA")
                .addNotification(
                    XGetNotificationsResponse.Notification.builder()
                        .id("1234567890")
                        .message("elonmusk liked your tweet")
                        .timestamp("2025-01-15T12:00:00Z")
                        .type("like")
                        .build()
                )
                .build()

        assertThat(xGetNotificationsResponse.hasNextPage()).isEqualTo(true)
        assertThat(xGetNotificationsResponse.nextCursor()).isEqualTo("DAACCgACGRElMJcAAA")
        assertThat(xGetNotificationsResponse.notifications())
            .containsExactly(
                XGetNotificationsResponse.Notification.builder()
                    .id("1234567890")
                    .message("elonmusk liked your tweet")
                    .timestamp("2025-01-15T12:00:00Z")
                    .type("like")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val xGetNotificationsResponse =
            XGetNotificationsResponse.builder()
                .hasNextPage(true)
                .nextCursor("DAACCgACGRElMJcAAA")
                .addNotification(
                    XGetNotificationsResponse.Notification.builder()
                        .id("1234567890")
                        .message("elonmusk liked your tweet")
                        .timestamp("2025-01-15T12:00:00Z")
                        .type("like")
                        .build()
                )
                .build()

        val roundtrippedXGetNotificationsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(xGetNotificationsResponse),
                jacksonTypeRef<XGetNotificationsResponse>(),
            )

        assertThat(roundtrippedXGetNotificationsResponse).isEqualTo(xGetNotificationsResponse)
    }
}
