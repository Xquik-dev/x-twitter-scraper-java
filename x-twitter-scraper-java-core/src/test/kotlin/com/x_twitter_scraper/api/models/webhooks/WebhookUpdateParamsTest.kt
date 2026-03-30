// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.webhooks

import com.x_twitter_scraper.api.models.EventType
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookUpdateParamsTest {

    @Test
    fun create() {
        WebhookUpdateParams.builder()
            .id("id")
            .addEventType(EventType.TWEET_NEW)
            .isActive(true)
            .url("https://example.com")
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
                .addEventType(EventType.TWEET_NEW)
                .isActive(true)
                .url("https://example.com")
                .build()

        val body = params._body()

        assertThat(body.eventTypes().getOrNull()).containsExactly(EventType.TWEET_NEW)
        assertThat(body.isActive()).contains(true)
        assertThat(body.url()).contains("https://example.com")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = WebhookUpdateParams.builder().id("id").build()

        val body = params._body()
    }
}
