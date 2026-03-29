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
                .id("id")
                .config(
                    IntegrationCreateResponse.Config.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addEventType(IntegrationCreateResponse.EventType.TWEET_NEW)
                .isActive(true)
                .name("name")
                .type(IntegrationCreateResponse.Type.TELEGRAM)
                .filters(
                    IntegrationCreateResponse.Filters.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .messageTemplate("messageTemplate")
                .scopeAllMonitors(true)
                .silentPush(true)
                .build()

        assertThat(integrationCreateResponse.id()).isEqualTo("id")
        assertThat(integrationCreateResponse.config())
            .isEqualTo(
                IntegrationCreateResponse.Config.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(integrationCreateResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(integrationCreateResponse.eventTypes())
            .containsExactly(IntegrationCreateResponse.EventType.TWEET_NEW)
        assertThat(integrationCreateResponse.isActive()).isEqualTo(true)
        assertThat(integrationCreateResponse.name()).isEqualTo("name")
        assertThat(integrationCreateResponse.type())
            .isEqualTo(IntegrationCreateResponse.Type.TELEGRAM)
        assertThat(integrationCreateResponse.filters())
            .contains(
                IntegrationCreateResponse.Filters.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(integrationCreateResponse.messageTemplate()).contains("messageTemplate")
        assertThat(integrationCreateResponse.scopeAllMonitors()).contains(true)
        assertThat(integrationCreateResponse.silentPush()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val integrationCreateResponse =
            IntegrationCreateResponse.builder()
                .id("id")
                .config(
                    IntegrationCreateResponse.Config.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addEventType(IntegrationCreateResponse.EventType.TWEET_NEW)
                .isActive(true)
                .name("name")
                .type(IntegrationCreateResponse.Type.TELEGRAM)
                .filters(
                    IntegrationCreateResponse.Filters.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .messageTemplate("messageTemplate")
                .scopeAllMonitors(true)
                .silentPush(true)
                .build()

        val roundtrippedIntegrationCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(integrationCreateResponse),
                jacksonTypeRef<IntegrationCreateResponse>(),
            )

        assertThat(roundtrippedIntegrationCreateResponse).isEqualTo(integrationCreateResponse)
    }
}
