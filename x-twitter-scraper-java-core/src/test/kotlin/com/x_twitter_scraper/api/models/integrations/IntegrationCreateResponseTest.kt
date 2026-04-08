// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.integrations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class IntegrationCreateResponseTest {

    @Test
    fun create() {
        val integrationCreateResponse =
            IntegrationCreateResponse.builder()
                .id("42")
                .config(
                    IntegrationCreateResponse.Config.builder()
                        .putAdditionalProperty("chatId", JsonValue.from("bar"))
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(IntegrationCreateResponse.EventType.TWEET_NEW)
                .addEventType(IntegrationCreateResponse.EventType.FOLLOWER_GAINED)
                .isActive(true)
                .name("My Telegram Bot")
                .type(IntegrationCreateResponse.Type.TELEGRAM)
                .filters(
                    IntegrationCreateResponse.Filters.builder()
                        .putAdditionalProperty("minFollowers", JsonValue.from("bar"))
                        .build()
                )
                .messageTemplate("New event: {{event.type}}")
                .scopeAllMonitors(true)
                .silentPush(false)
                .build()

        assertThat(integrationCreateResponse.id()).isEqualTo("42")
        assertThat(integrationCreateResponse.config())
            .isEqualTo(
                IntegrationCreateResponse.Config.builder()
                    .putAdditionalProperty("chatId", JsonValue.from("bar"))
                    .build()
            )
        assertThat(integrationCreateResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(integrationCreateResponse.eventTypes())
            .containsExactly(
                IntegrationCreateResponse.EventType.TWEET_NEW,
                IntegrationCreateResponse.EventType.FOLLOWER_GAINED,
            )
        assertThat(integrationCreateResponse.isActive()).isEqualTo(true)
        assertThat(integrationCreateResponse.name()).isEqualTo("My Telegram Bot")
        assertThat(integrationCreateResponse.type())
            .isEqualTo(IntegrationCreateResponse.Type.TELEGRAM)
        assertThat(integrationCreateResponse.filters())
            .contains(
                IntegrationCreateResponse.Filters.builder()
                    .putAdditionalProperty("minFollowers", JsonValue.from("bar"))
                    .build()
            )
        assertThat(integrationCreateResponse.messageTemplate())
            .contains("New event: {{event.type}}")
        assertThat(integrationCreateResponse.scopeAllMonitors()).contains(true)
        assertThat(integrationCreateResponse.silentPush()).contains(false)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val integrationCreateResponse =
            IntegrationCreateResponse.builder()
                .id("42")
                .config(
                    IntegrationCreateResponse.Config.builder()
                        .putAdditionalProperty("chatId", JsonValue.from("bar"))
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(IntegrationCreateResponse.EventType.TWEET_NEW)
                .addEventType(IntegrationCreateResponse.EventType.FOLLOWER_GAINED)
                .isActive(true)
                .name("My Telegram Bot")
                .type(IntegrationCreateResponse.Type.TELEGRAM)
                .filters(
                    IntegrationCreateResponse.Filters.builder()
                        .putAdditionalProperty("minFollowers", JsonValue.from("bar"))
                        .build()
                )
                .messageTemplate("New event: {{event.type}}")
                .scopeAllMonitors(true)
                .silentPush(false)
                .build()

        val roundtrippedIntegrationCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(integrationCreateResponse),
                jacksonTypeRef<IntegrationCreateResponse>(),
            )

        assertThat(roundtrippedIntegrationCreateResponse).isEqualTo(integrationCreateResponse)
    }
}
