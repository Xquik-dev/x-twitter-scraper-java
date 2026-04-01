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
                .id("id")
                .config(
                    IntegrationUpdateResponse.Config.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addEventType(IntegrationUpdateResponse.EventType.TWEET_NEW)
                .isActive(true)
                .name("name")
                .type(IntegrationUpdateResponse.Type.TELEGRAM)
                .filters(
                    IntegrationUpdateResponse.Filters.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .messageTemplate("messageTemplate")
                .scopeAllMonitors(true)
                .silentPush(true)
                .build()

        assertThat(integrationUpdateResponse.id()).isEqualTo("id")
        assertThat(integrationUpdateResponse.config())
            .isEqualTo(
                IntegrationUpdateResponse.Config.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(integrationUpdateResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(integrationUpdateResponse.eventTypes())
            .containsExactly(IntegrationUpdateResponse.EventType.TWEET_NEW)
        assertThat(integrationUpdateResponse.isActive()).isEqualTo(true)
        assertThat(integrationUpdateResponse.name()).isEqualTo("name")
        assertThat(integrationUpdateResponse.type())
            .isEqualTo(IntegrationUpdateResponse.Type.TELEGRAM)
        assertThat(integrationUpdateResponse.filters())
            .contains(
                IntegrationUpdateResponse.Filters.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(integrationUpdateResponse.messageTemplate()).contains("messageTemplate")
        assertThat(integrationUpdateResponse.scopeAllMonitors()).contains(true)
        assertThat(integrationUpdateResponse.silentPush()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val integrationUpdateResponse =
            IntegrationUpdateResponse.builder()
                .id("id")
                .config(
                    IntegrationUpdateResponse.Config.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addEventType(IntegrationUpdateResponse.EventType.TWEET_NEW)
                .isActive(true)
                .name("name")
                .type(IntegrationUpdateResponse.Type.TELEGRAM)
                .filters(
                    IntegrationUpdateResponse.Filters.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .messageTemplate("messageTemplate")
                .scopeAllMonitors(true)
                .silentPush(true)
                .build()

        val roundtrippedIntegrationUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(integrationUpdateResponse),
                jacksonTypeRef<IntegrationUpdateResponse>(),
            )

        assertThat(roundtrippedIntegrationUpdateResponse).isEqualTo(integrationUpdateResponse)
    }
}
