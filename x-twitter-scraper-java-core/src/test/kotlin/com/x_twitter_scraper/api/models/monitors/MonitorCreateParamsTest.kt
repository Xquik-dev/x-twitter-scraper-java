// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.monitors

import com.x_twitter_scraper.api.models.EventType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MonitorCreateParamsTest {

    @Test
    fun create() {
        MonitorCreateParams.builder()
            .addEventType(EventType.TWEET_NEW)
            .addEventType(EventType.TWEET_REPLY)
            .username("elonmusk")
            .build()
    }

    @Test
    fun body() {
        val params =
            MonitorCreateParams.builder()
                .addEventType(EventType.TWEET_NEW)
                .addEventType(EventType.TWEET_REPLY)
                .username("elonmusk")
                .build()

        val body = params._body()

        assertThat(body.eventTypes()).containsExactly(EventType.TWEET_NEW, EventType.TWEET_REPLY)
        assertThat(body.username()).isEqualTo("elonmusk")
    }
}
