// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.webhooks

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookUpdateParamsTest {

    @Test
    fun create() {
        WebhookUpdateParams.builder()
            .id("id")
            .addEventType(WebhookUpdateParams.EventType.TWEET_NEW)
            .addEventType(WebhookUpdateParams.EventType.FOLLOWER_GAINED)
            .isActive(true)
            .url("https://example.com/webhook")
            .build()
    }

    @Test
    fun pathParams() {
        val params = WebhookUpdateParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            WebhookUpdateParams.builder()
                .id("id")
                .addEventType(WebhookUpdateParams.EventType.TWEET_NEW)
                .addEventType(WebhookUpdateParams.EventType.FOLLOWER_GAINED)
                .isActive(true)
                .url("https://example.com/webhook")
                .build()

        val body = params._body()

        assertThat(body.eventTypes().getOrNull())
            .containsExactly(
                WebhookUpdateParams.EventType.TWEET_NEW,
                WebhookUpdateParams.EventType.FOLLOWER_GAINED,
            )
        assertThat(body.isActive()).contains(true)
        assertThat(body.url()).contains("https://example.com/webhook")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = WebhookUpdateParams.builder().id("id").build()

        val body = params._body()
    }
}
