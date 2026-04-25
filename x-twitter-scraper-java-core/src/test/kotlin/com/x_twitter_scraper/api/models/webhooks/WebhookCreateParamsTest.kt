// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.webhooks

import com.x_twitter_scraper.api.models.EventType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookCreateParamsTest {

    @Test
    fun create() {
        WebhookCreateParams.builder()
            .addEventType(EventType.TWEET_NEW)
            .addEventType(EventType.TWEET_REPLY)
            .url("https://example.com/webhook")
            .build()
    }

    @Test
    fun body() {
        val params =
            WebhookCreateParams.builder()
                .addEventType(EventType.TWEET_NEW)
                .addEventType(EventType.TWEET_REPLY)
                .url("https://example.com/webhook")
                .build()

        val body = params._body()

        assertThat(body.eventTypes()).containsExactly(EventType.TWEET_NEW, EventType.TWEET_REPLY)
        assertThat(body.url()).isEqualTo("https://example.com/webhook")
    }
}
