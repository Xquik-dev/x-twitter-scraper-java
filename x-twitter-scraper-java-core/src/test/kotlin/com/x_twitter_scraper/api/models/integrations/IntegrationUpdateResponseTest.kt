// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.integrations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class IntegrationUpdateResponseTest {

    @Test
    fun create() {
        val integrationUpdateResponse =
            IntegrationUpdateResponse.builder()
                .id("42")
                .config(
                    IntegrationUpdateResponse.Config.builder()
                        .putAdditionalProperty("chatId", JsonValue.from("bar"))
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(IntegrationUpdateResponse.EventType.TWEET_NEW)
                .addEventType(IntegrationUpdateResponse.EventType.FOLLOWER_GAINED)
                .isActive(true)
                .name("My Telegram Bot")
                .type(IntegrationUpdateResponse.Type.TELEGRAM)
                .filters(
                    IntegrationUpdateResponse.Filters.builder()
                        .putAdditionalProperty("minFollowers", JsonValue.from("bar"))
                        .build()
                )
                .messageTemplate("New event: {{event.type}}")
                .scopeAllMonitors(true)
                .silentPush(false)
                .build()

        assertThat(integrationUpdateResponse.id()).isEqualTo("42")
        assertThat(integrationUpdateResponse.config())
            .isEqualTo(
                IntegrationUpdateResponse.Config.builder()
                    .putAdditionalProperty("chatId", JsonValue.from("bar"))
                    .build()
            )
        assertThat(integrationUpdateResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(integrationUpdateResponse.eventTypes())
            .containsExactly(
                IntegrationUpdateResponse.EventType.TWEET_NEW,
                IntegrationUpdateResponse.EventType.FOLLOWER_GAINED,
            )
        assertThat(integrationUpdateResponse.isActive()).isEqualTo(true)
        assertThat(integrationUpdateResponse.name()).isEqualTo("My Telegram Bot")
        assertThat(integrationUpdateResponse.type())
            .isEqualTo(IntegrationUpdateResponse.Type.TELEGRAM)
        assertThat(integrationUpdateResponse.filters())
            .contains(
                IntegrationUpdateResponse.Filters.builder()
                    .putAdditionalProperty("minFollowers", JsonValue.from("bar"))
                    .build()
            )
        assertThat(integrationUpdateResponse.messageTemplate())
            .contains("New event: {{event.type}}")
        assertThat(integrationUpdateResponse.scopeAllMonitors()).contains(true)
        assertThat(integrationUpdateResponse.silentPush()).contains(false)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val integrationUpdateResponse =
            IntegrationUpdateResponse.builder()
                .id("42")
                .config(
                    IntegrationUpdateResponse.Config.builder()
                        .putAdditionalProperty("chatId", JsonValue.from("bar"))
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(IntegrationUpdateResponse.EventType.TWEET_NEW)
                .addEventType(IntegrationUpdateResponse.EventType.FOLLOWER_GAINED)
                .isActive(true)
                .name("My Telegram Bot")
                .type(IntegrationUpdateResponse.Type.TELEGRAM)
                .filters(
                    IntegrationUpdateResponse.Filters.builder()
                        .putAdditionalProperty("minFollowers", JsonValue.from("bar"))
                        .build()
                )
                .messageTemplate("New event: {{event.type}}")
                .scopeAllMonitors(true)
                .silentPush(false)
                .build()

        val roundtrippedIntegrationUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(integrationUpdateResponse),
                jacksonTypeRef<IntegrationUpdateResponse>(),
            )

        assertThat(roundtrippedIntegrationUpdateResponse).isEqualTo(integrationUpdateResponse)
    }
}
