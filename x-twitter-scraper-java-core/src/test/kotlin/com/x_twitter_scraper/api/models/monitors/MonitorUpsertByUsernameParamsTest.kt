// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.monitors

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.EventType
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class MonitorUpsertByUsernameParamsTest {

    @Test
    fun pathParams() {
        val params =
            MonitorUpsertByUsernameParams.builder()
                .username("elonmusk")
                .addEventType(EventType.TWEET_NEW)
                .build()

        assertThat(params.username()).contains("elonmusk")
        assertThat(params._pathParam(0)).isEqualTo("elonmusk")
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            MonitorUpsertByUsernameParams.builder()
                .username("elonmusk")
                .addEventType(EventType.TWEET_NEW)
                .name("Launch watch")
                .build()

        val body = params._body()

        assertThat(body.eventTypes()).containsExactly(EventType.TWEET_NEW)
        assertThat(body.name()).contains("Launch watch")
        assertThat(params.eventTypes()).containsExactly(EventType.TWEET_NEW)
        assertThat(params.name()).contains("Launch watch")
        assertThat(params.toBuilder().build()).isEqualTo(params)
        assertThat(body.isValid()).isTrue()
    }

    @Test
    fun theEventTypesAreRequired() {
        assertThatThrownBy { MonitorUpsertByUsernameParams.builder().username("elonmusk").build() }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("eventTypes")
    }

    @Test
    fun theBodyRoundTripsWithAndWithoutAName() {
        val jsonMapper = jsonMapper()
        listOf(
                """{"eventTypes":["tweet.new"]}""",
                """{"eventTypes":["tweet.new"],"name":"Launch watch"}""",
                """{"eventTypes":["tweet.new"],"name":null}""",
            )
            .forEach { json ->
                val body =
                    jsonMapper.readValue(
                        json,
                        jacksonTypeRef<MonitorUpsertByUsernameParams.Body>(),
                    )

                assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(body)))
                    .isEqualTo(jsonMapper.readTree(json))
            }
    }
}
