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
                .id("id")
                .config(
                    Integration.Config.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addEventType(EventType.TWEET_NEW)
                .isActive(true)
                .name("name")
                .type(Integration.Type.TELEGRAM)
                .filters(
                    Integration.Filters.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .messageTemplate("messageTemplate")
                .scopeAllMonitors(true)
                .silentPush(true)
                .build()

        assertThat(integration.id()).isEqualTo("id")
        assertThat(integration.config())
            .isEqualTo(
                Integration.Config.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(integration.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(integration.eventTypes()).containsExactly(EventType.TWEET_NEW)
        assertThat(integration.isActive()).isEqualTo(true)
        assertThat(integration.name()).isEqualTo("name")
        assertThat(integration.type()).isEqualTo(Integration.Type.TELEGRAM)
        assertThat(integration.filters())
            .contains(
                Integration.Filters.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(integration.messageTemplate()).contains("messageTemplate")
        assertThat(integration.scopeAllMonitors()).contains(true)
        assertThat(integration.silentPush()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val integration =
            Integration.builder()
                .id("id")
                .config(
                    Integration.Config.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addEventType(EventType.TWEET_NEW)
                .isActive(true)
                .name("name")
                .type(Integration.Type.TELEGRAM)
                .filters(
                    Integration.Filters.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .messageTemplate("messageTemplate")
                .scopeAllMonitors(true)
                .silentPush(true)
                .build()

        val roundtrippedIntegration =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(integration),
                jacksonTypeRef<Integration>(),
            )

        assertThat(roundtrippedIntegration).isEqualTo(integration)
    }
}
