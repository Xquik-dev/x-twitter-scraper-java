// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.monitors.keywords

import com.x_twitter_scraper.api.models.EventType
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class KeywordUpdateParamsTest {

    @Test
    fun create() {
        KeywordUpdateParams.builder()
            .id("id")
            .addEventType(EventType.TWEET_NEW)
            .isActive(true)
            .build()
    }

    @Test
    fun pathParams() {
        val params = KeywordUpdateParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            KeywordUpdateParams.builder()
                .id("id")
                .addEventType(EventType.TWEET_NEW)
                .isActive(true)
                .build()

        val body = params._body()

        assertThat(body.eventTypes().getOrNull()).containsExactly(EventType.TWEET_NEW)
        assertThat(body.isActive()).contains(true)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = KeywordUpdateParams.builder().id("id").build()

        val body = params._body()
    }
}
