// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.integrations

import com.x_twitter_scraper.api.models.EventType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class IntegrationCreateParamsTest {

    @Test
    fun create() {
        IntegrationCreateParams.builder()
            .config(IntegrationCreateParams.Config.builder().chatId("chatId").build())
            .addEventType(EventType.TWEET_NEW)
            .name("name")
            .type(IntegrationCreateParams.Type.TELEGRAM)
            .build()
    }

    @Test
    fun body() {
        val params =
            IntegrationCreateParams.builder()
                .config(IntegrationCreateParams.Config.builder().chatId("chatId").build())
                .addEventType(EventType.TWEET_NEW)
                .name("name")
                .type(IntegrationCreateParams.Type.TELEGRAM)
                .build()

        val body = params._body()

        assertThat(body.config())
            .isEqualTo(IntegrationCreateParams.Config.builder().chatId("chatId").build())
        assertThat(body.eventTypes()).containsExactly(EventType.TWEET_NEW)
        assertThat(body.name()).isEqualTo("name")
        assertThat(body.type()).isEqualTo(IntegrationCreateParams.Type.TELEGRAM)
    }
}
