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
                .id("id")
                .config(
                    IntegrationRetrieveResponse.Config.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addEventType(IntegrationRetrieveResponse.EventType.TWEET_NEW)
                .isActive(true)
                .name("name")
                .type(IntegrationRetrieveResponse.Type.TELEGRAM)
                .filters(
                    IntegrationRetrieveResponse.Filters.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .messageTemplate("messageTemplate")
                .scopeAllMonitors(true)
                .silentPush(true)
                .build()

        assertThat(integrationRetrieveResponse.id()).isEqualTo("id")
        assertThat(integrationRetrieveResponse.config())
            .isEqualTo(
                IntegrationRetrieveResponse.Config.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(integrationRetrieveResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(integrationRetrieveResponse.eventTypes())
            .containsExactly(IntegrationRetrieveResponse.EventType.TWEET_NEW)
        assertThat(integrationRetrieveResponse.isActive()).isEqualTo(true)
        assertThat(integrationRetrieveResponse.name()).isEqualTo("name")
        assertThat(integrationRetrieveResponse.type())
            .isEqualTo(IntegrationRetrieveResponse.Type.TELEGRAM)
        assertThat(integrationRetrieveResponse.filters())
            .contains(
                IntegrationRetrieveResponse.Filters.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(integrationRetrieveResponse.messageTemplate()).contains("messageTemplate")
        assertThat(integrationRetrieveResponse.scopeAllMonitors()).contains(true)
        assertThat(integrationRetrieveResponse.silentPush()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val integrationRetrieveResponse =
            IntegrationRetrieveResponse.builder()
                .id("id")
                .config(
                    IntegrationRetrieveResponse.Config.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addEventType(IntegrationRetrieveResponse.EventType.TWEET_NEW)
                .isActive(true)
                .name("name")
                .type(IntegrationRetrieveResponse.Type.TELEGRAM)
                .filters(
                    IntegrationRetrieveResponse.Filters.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .messageTemplate("messageTemplate")
                .scopeAllMonitors(true)
                .silentPush(true)
                .build()

        val roundtrippedIntegrationRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(integrationRetrieveResponse),
                jacksonTypeRef<IntegrationRetrieveResponse>(),
            )

        assertThat(roundtrippedIntegrationRetrieveResponse).isEqualTo(integrationRetrieveResponse)
    }
}
