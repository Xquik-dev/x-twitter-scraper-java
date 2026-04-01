// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.webhooks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookCreateParamsTest {

    @Test
    fun create() {
        WebhookCreateParams.builder()
            .addEventType(WebhookCreateParams.EventType.TWEET_NEW)
            .url("https://example.com")
            .build()
    }

    @Test
    fun body() {
        val params =
            WebhookCreateParams.builder()
                .addEventType(WebhookCreateParams.EventType.TWEET_NEW)
                .url("https://example.com")
                .build()

        val body = params._body()

        assertThat(body.eventTypes()).containsExactly(WebhookCreateParams.EventType.TWEET_NEW)
        assertThat(body.url()).isEqualTo("https://example.com")
    }
}
