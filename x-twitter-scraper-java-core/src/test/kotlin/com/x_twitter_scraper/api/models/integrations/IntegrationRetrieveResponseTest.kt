// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.integrations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class IntegrationRetrieveResponseTest {

    @Test
    fun create() {
        val integrationRetrieveResponse =
            IntegrationRetrieveResponse.builder()
                .id("42")
                .config(
                    IntegrationRetrieveResponse.Config.builder()
                        .putAdditionalProperty("chatId", JsonValue.from("bar"))
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(IntegrationRetrieveResponse.EventType.TWEET_NEW)
                .addEventType(IntegrationRetrieveResponse.EventType.FOLLOWER_GAINED)
                .isActive(true)
                .name("My Telegram Bot")
                .type(IntegrationRetrieveResponse.Type.TELEGRAM)
                .filters(
                    IntegrationRetrieveResponse.Filters.builder()
                        .putAdditionalProperty("minFollowers", JsonValue.from("bar"))
                        .build()
                )
                .messageTemplate("New event: {{event.type}}")
                .scopeAllMonitors(true)
                .silentPush(false)
                .build()

        assertThat(integrationRetrieveResponse.id()).isEqualTo("42")
        assertThat(integrationRetrieveResponse.config())
            .isEqualTo(
                IntegrationRetrieveResponse.Config.builder()
                    .putAdditionalProperty("chatId", JsonValue.from("bar"))
                    .build()
            )
        assertThat(integrationRetrieveResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(integrationRetrieveResponse.eventTypes())
            .containsExactly(
                IntegrationRetrieveResponse.EventType.TWEET_NEW,
                IntegrationRetrieveResponse.EventType.FOLLOWER_GAINED,
            )
        assertThat(integrationRetrieveResponse.isActive()).isEqualTo(true)
        assertThat(integrationRetrieveResponse.name()).isEqualTo("My Telegram Bot")
        assertThat(integrationRetrieveResponse.type())
            .isEqualTo(IntegrationRetrieveResponse.Type.TELEGRAM)
        assertThat(integrationRetrieveResponse.filters())
            .contains(
                IntegrationRetrieveResponse.Filters.builder()
                    .putAdditionalProperty("minFollowers", JsonValue.from("bar"))
                    .build()
            )
        assertThat(integrationRetrieveResponse.messageTemplate())
            .contains("New event: {{event.type}}")
        assertThat(integrationRetrieveResponse.scopeAllMonitors()).contains(true)
        assertThat(integrationRetrieveResponse.silentPush()).contains(false)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val integrationRetrieveResponse =
            IntegrationRetrieveResponse.builder()
                .id("42")
                .config(
                    IntegrationRetrieveResponse.Config.builder()
                        .putAdditionalProperty("chatId", JsonValue.from("bar"))
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(IntegrationRetrieveResponse.EventType.TWEET_NEW)
                .addEventType(IntegrationRetrieveResponse.EventType.FOLLOWER_GAINED)
                .isActive(true)
                .name("My Telegram Bot")
                .type(IntegrationRetrieveResponse.Type.TELEGRAM)
                .filters(
                    IntegrationRetrieveResponse.Filters.builder()
                        .putAdditionalProperty("minFollowers", JsonValue.from("bar"))
                        .build()
                )
                .messageTemplate("New event: {{event.type}}")
                .scopeAllMonitors(true)
                .silentPush(false)
                .build()

        val roundtrippedIntegrationRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(integrationRetrieveResponse),
                jacksonTypeRef<IntegrationRetrieveResponse>(),
            )

        assertThat(roundtrippedIntegrationRetrieveResponse).isEqualTo(integrationRetrieveResponse)
    }
}
