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
                .nextCursor("next_cursor")
                .addNotification(
                    XGetNotificationsResponse.Notification.builder()
                        .id("id")
                        .message("message")
                        .timestamp("timestamp")
                        .type("type")
                        .build()
                )
                .build()

        assertThat(xGetNotificationsResponse.hasNextPage()).isEqualTo(true)
        assertThat(xGetNotificationsResponse.nextCursor()).isEqualTo("next_cursor")
        assertThat(xGetNotificationsResponse.notifications())
            .containsExactly(
                XGetNotificationsResponse.Notification.builder()
                    .id("id")
                    .message("message")
                    .timestamp("timestamp")
                    .type("type")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val xGetNotificationsResponse =
            XGetNotificationsResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addNotification(
                    XGetNotificationsResponse.Notification.builder()
                        .id("id")
                        .message("message")
                        .timestamp("timestamp")
                        .type("type")
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
