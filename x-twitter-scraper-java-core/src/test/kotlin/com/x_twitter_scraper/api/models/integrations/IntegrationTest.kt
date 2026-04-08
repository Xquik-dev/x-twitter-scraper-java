// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.integrations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.EventType
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class IntegrationTest {

    @Test
    fun create() {
        val integration =
            Integration.builder()
                .id("42")
                .config(
                    Integration.Config.builder()
                        .putAdditionalProperty("chatId", JsonValue.from("bar"))
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(EventType.TWEET_NEW)
                .addEventType(EventType.FOLLOWER_GAINED)
                .isActive(true)
                .name("My Telegram Bot")
                .type(Integration.Type.TELEGRAM)
                .filters(
                    Integration.Filters.builder()
                        .putAdditionalProperty("minFollowers", JsonValue.from("bar"))
                        .build()
                )
                .messageTemplate("New event: {{event.type}}")
                .scopeAllMonitors(true)
                .silentPush(false)
                .build()

        assertThat(integration.id()).isEqualTo("42")
        assertThat(integration.config())
            .isEqualTo(
                Integration.Config.builder()
                    .putAdditionalProperty("chatId", JsonValue.from("bar"))
                    .build()
            )
        assertThat(integration.createdAt()).isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(integration.eventTypes())
            .containsExactly(EventType.TWEET_NEW, EventType.FOLLOWER_GAINED)
        assertThat(integration.isActive()).isEqualTo(true)
        assertThat(integration.name()).isEqualTo("My Telegram Bot")
        assertThat(integration.type()).isEqualTo(Integration.Type.TELEGRAM)
        assertThat(integration.filters())
            .contains(
                Integration.Filters.builder()
                    .putAdditionalProperty("minFollowers", JsonValue.from("bar"))
                    .build()
            )
        assertThat(integration.messageTemplate()).contains("New event: {{event.type}}")
        assertThat(integration.scopeAllMonitors()).contains(true)
        assertThat(integration.silentPush()).contains(false)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val integration =
            Integration.builder()
                .id("42")
                .config(
                    Integration.Config.builder()
                        .putAdditionalProperty("chatId", JsonValue.from("bar"))
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(EventType.TWEET_NEW)
                .addEventType(EventType.FOLLOWER_GAINED)
                .isActive(true)
                .name("My Telegram Bot")
                .type(Integration.Type.TELEGRAM)
                .filters(
                    Integration.Filters.builder()
                        .putAdditionalProperty("minFollowers", JsonValue.from("bar"))
                        .build()
                )
                .messageTemplate("New event: {{event.type}}")
                .scopeAllMonitors(true)
                .silentPush(false)
                .build()

        val roundtrippedIntegration =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(integration),
                jacksonTypeRef<Integration>(),
            )

        assertThat(roundtrippedIntegration).isEqualTo(integration)
    }
}
