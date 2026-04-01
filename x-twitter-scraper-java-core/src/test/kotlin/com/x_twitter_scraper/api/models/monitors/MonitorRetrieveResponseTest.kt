// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.monitors

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MonitorRetrieveResponseTest {

    @Test
    fun create() {
        val monitorRetrieveResponse =
            MonitorRetrieveResponse.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addEventType(MonitorRetrieveResponse.EventType.TWEET_NEW)
                .isActive(true)
                .username("username")
                .xUserId("xUserId")
                .build()

        assertThat(monitorRetrieveResponse.id()).isEqualTo("id")
        assertThat(monitorRetrieveResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(monitorRetrieveResponse.eventTypes())
            .containsExactly(MonitorRetrieveResponse.EventType.TWEET_NEW)
        assertThat(monitorRetrieveResponse.isActive()).isEqualTo(true)
        assertThat(monitorRetrieveResponse.username()).isEqualTo("username")
        assertThat(monitorRetrieveResponse.xUserId()).isEqualTo("xUserId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val monitorRetrieveResponse =
            MonitorRetrieveResponse.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addEventType(MonitorRetrieveResponse.EventType.TWEET_NEW)
                .isActive(true)
                .username("username")
                .xUserId("xUserId")
                .build()

        val roundtrippedMonitorRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(monitorRetrieveResponse),
                jacksonTypeRef<MonitorRetrieveResponse>(),
            )

        assertThat(roundtrippedMonitorRetrieveResponse).isEqualTo(monitorRetrieveResponse)
    }
}
