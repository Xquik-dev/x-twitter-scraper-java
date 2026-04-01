// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.monitors

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MonitorCreateParamsTest {

    @Test
    fun create() {
        MonitorCreateParams.builder()
            .addEventType(MonitorCreateParams.EventType.TWEET_NEW)
            .username("username")
            .build()
    }

    @Test
    fun body() {
        val params =
            MonitorCreateParams.builder()
                .addEventType(MonitorCreateParams.EventType.TWEET_NEW)
                .username("username")
                .build()

        val body = params._body()

        assertThat(body.eventTypes()).containsExactly(MonitorCreateParams.EventType.TWEET_NEW)
        assertThat(body.username()).isEqualTo("username")
    }
}
