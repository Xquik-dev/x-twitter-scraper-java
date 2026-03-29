// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.monitors

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MonitorUpdateResponseTest {

    @Test
    fun create() {
        val monitorUpdateResponse =
            MonitorUpdateResponse.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addEventType(MonitorUpdateResponse.EventType.TWEET_NEW)
                .isActive(true)
                .username("username")
                .xUserId("xUserId")
                .build()

        assertThat(monitorUpdateResponse.id()).isEqualTo("id")
        assertThat(monitorUpdateResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(monitorUpdateResponse.eventTypes())
            .containsExactly(MonitorUpdateResponse.EventType.TWEET_NEW)
        assertThat(monitorUpdateResponse.isActive()).isEqualTo(true)
        assertThat(monitorUpdateResponse.username()).isEqualTo("username")
        assertThat(monitorUpdateResponse.xUserId()).isEqualTo("xUserId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val monitorUpdateResponse =
            MonitorUpdateResponse.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addEventType(MonitorUpdateResponse.EventType.TWEET_NEW)
                .isActive(true)
                .username("username")
                .xUserId("xUserId")
                .build()

        val roundtrippedMonitorUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(monitorUpdateResponse),
                jacksonTypeRef<MonitorUpdateResponse>(),
            )

        assertThat(roundtrippedMonitorUpdateResponse).isEqualTo(monitorUpdateResponse)
    }
}
