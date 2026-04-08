// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.integrations

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class IntegrationUpdateParamsTest {

    @Test
    fun create() {
        IntegrationUpdateParams.builder()
            .id("id")
            .addEventType(IntegrationUpdateParams.EventType.TWEET_NEW)
            .addEventType(IntegrationUpdateParams.EventType.FOLLOWER_GAINED)
            .filters(IntegrationUpdateParams.Filters.builder().build())
            .isActive(true)
            .messageTemplate(IntegrationUpdateParams.MessageTemplate.builder().build())
            .name("My Telegram Bot")
            .scopeAllMonitors(true)
            .silentPush(false)
            .build()
    }

    @Test
    fun pathParams() {
        val params = IntegrationUpdateParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            IntegrationUpdateParams.builder()
                .id("id")
                .addEventType(IntegrationUpdateParams.EventType.TWEET_NEW)
                .addEventType(IntegrationUpdateParams.EventType.FOLLOWER_GAINED)
                .filters(IntegrationUpdateParams.Filters.builder().build())
                .isActive(true)
                .messageTemplate(IntegrationUpdateParams.MessageTemplate.builder().build())
                .name("My Telegram Bot")
                .scopeAllMonitors(true)
                .silentPush(false)
                .build()

        val body = params._body()

        assertThat(body.eventTypes().getOrNull())
            .containsExactly(
                IntegrationUpdateParams.EventType.TWEET_NEW,
                IntegrationUpdateParams.EventType.FOLLOWER_GAINED,
            )
        assertThat(body.filters()).contains(IntegrationUpdateParams.Filters.builder().build())
        assertThat(body.isActive()).contains(true)
        assertThat(body.messageTemplate())
            .contains(IntegrationUpdateParams.MessageTemplate.builder().build())
        assertThat(body.name()).contains("My Telegram Bot")
        assertThat(body.scopeAllMonitors()).contains(true)
        assertThat(body.silentPush()).contains(false)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = IntegrationUpdateParams.builder().id("id").build()

        val body = params._body()
    }
}
