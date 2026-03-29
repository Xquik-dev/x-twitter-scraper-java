// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.monitors

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MonitorListResponseTest {

    @Test
    fun create() {
        val monitorListResponse =
            MonitorListResponse.builder()
                .addMonitor(
                    MonitorListResponse.Monitor.builder()
                        .id("id")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .addEventType(MonitorListResponse.Monitor.EventType.TWEET_NEW)
                        .isActive(true)
                        .username("username")
                        .xUserId("xUserId")
                        .build()
                )
                .total(0L)
                .build()

        assertThat(monitorListResponse.monitors())
            .containsExactly(
                MonitorListResponse.Monitor.builder()
                    .id("id")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .addEventType(MonitorListResponse.Monitor.EventType.TWEET_NEW)
                    .isActive(true)
                    .username("username")
                    .xUserId("xUserId")
                    .build()
            )
        assertThat(monitorListResponse.total()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val monitorListResponse =
            MonitorListResponse.builder()
                .addMonitor(
                    MonitorListResponse.Monitor.builder()
                        .id("id")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .addEventType(MonitorListResponse.Monitor.EventType.TWEET_NEW)
                        .isActive(true)
                        .username("username")
                        .xUserId("xUserId")
                        .build()
                )
                .total(0L)
                .build()

        val roundtrippedMonitorListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(monitorListResponse),
                jacksonTypeRef<MonitorListResponse>(),
            )

        assertThat(roundtrippedMonitorListResponse).isEqualTo(monitorListResponse)
    }
}
