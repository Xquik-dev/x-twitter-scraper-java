// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.integrations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.EventType
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class IntegrationListResponseTest {

    @Test
    fun create() {
        val integrationListResponse =
            IntegrationListResponse.builder()
                .addIntegration(
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
                )
                .build()

        assertThat(integrationListResponse.integrations())
            .containsExactly(
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
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val integrationListResponse =
            IntegrationListResponse.builder()
                .addIntegration(
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
