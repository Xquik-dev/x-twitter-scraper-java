// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.integrations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class IntegrationListResponseTest {

    @Test
    fun create() {
        val integrationListResponse =
            IntegrationListResponse.builder()
                .addIntegration(
                    IntegrationListResponse.Integration.builder()
                        .id("42")
                        .config(
                            IntegrationListResponse.Integration.Config.builder()
                                .putAdditionalProperty("chatId", JsonValue.from("bar"))
                                .build()
                        )
                        .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .addEventType(IntegrationListResponse.Integration.EventType.TWEET_NEW)
                        .addEventType(IntegrationListResponse.Integration.EventType.FOLLOWER_GAINED)
                        .isActive(true)
                        .name("My Telegram Bot")
                        .type(IntegrationListResponse.Integration.Type.TELEGRAM)
                        .filters(
                            IntegrationListResponse.Integration.Filters.builder()
                                .putAdditionalProperty("minFollowers", JsonValue.from("bar"))
                                .build()
                        )
                        .messageTemplate("New event: {{event.type}}")
                        .scopeAllMonitors(true)
                        .silentPush(false)
                        .build()
                )
                .build()

        assertThat(integrationListResponse.integrations())
            .containsExactly(
                IntegrationListResponse.Integration.builder()
                    .id("42")
                    .config(
                        IntegrationListResponse.Integration.Config.builder()
                            .putAdditionalProperty("chatId", JsonValue.from("bar"))
                            .build()
                    )
                    .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                    .addEventType(IntegrationListResponse.Integration.EventType.TWEET_NEW)
                    .addEventType(IntegrationListResponse.Integration.EventType.FOLLOWER_GAINED)
                    .isActive(true)
                    .name("My Telegram Bot")
                    .type(IntegrationListResponse.Integration.Type.TELEGRAM)
                    .filters(
                        IntegrationListResponse.Integration.Filters.builder()
                            .putAdditionalProperty("minFollowers", JsonValue.from("bar"))
                            .build()
                    )
                    .messageTemplate("New event: {{event.type}}")
                    .scopeAllMonitors(true)
                    .silentPush(false)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val integrationListResponse =
            IntegrationListResponse.builder()
                .addIntegration(
                    IntegrationListResponse.Integration.builder()
                        .id("42")
                        .config(
                            IntegrationListResponse.Integration.Config.builder()
                                .putAdditionalProperty("chatId", JsonValue.from("bar"))
                                .build()
                        )
                        .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .addEventType(IntegrationListResponse.Integration.EventType.TWEET_NEW)
                        .addEventType(IntegrationListResponse.Integration.EventType.FOLLOWER_GAINED)
                        .isActive(true)
                        .name("My Telegram Bot")
                        .type(IntegrationListResponse.Integration.Type.TELEGRAM)
                        .filters(
                            IntegrationListResponse.Integration.Filters.builder()
                                .putAdditionalProperty("minFollowers", JsonValue.from("bar"))
                                .build()
                        )
                        .messageTemplate("New event: {{event.type}}")
                        .scopeAllMonitors(true)
                        .silentPush(false)
                        .build()
                )
                .build()

        val roundtrippedIntegrationListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(integrationListResponse),
                jacksonTypeRef<IntegrationListResponse>(),
            )

        assertThat(roundtrippedIntegrationListResponse).isEqualTo(integrationListResponse)
    }
}
