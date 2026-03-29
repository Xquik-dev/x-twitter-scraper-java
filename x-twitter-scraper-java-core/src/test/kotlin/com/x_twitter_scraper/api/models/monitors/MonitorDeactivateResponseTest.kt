// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.monitors

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MonitorDeactivateResponseTest {

    @Test
    fun create() {
        val monitorDeactivateResponse = MonitorDeactivateResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val monitorDeactivateResponse = MonitorDeactivateResponse.builder().build()

        val roundtrippedMonitorDeactivateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(monitorDeactivateResponse),
                jacksonTypeRef<MonitorDeactivateResponse>(),
            )

        assertThat(roundtrippedMonitorDeactivateResponse).isEqualTo(monitorDeactivateResponse)
    }
}
