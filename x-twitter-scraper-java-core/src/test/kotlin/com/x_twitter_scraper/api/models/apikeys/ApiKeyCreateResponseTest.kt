// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.apikeys

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyCreateResponseTest {

    @Test
    fun create() {
        val apiKeyCreateResponse =
            ApiKeyCreateResponse.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .fullKey("xq_live_abc123def456")
                .name("My API Key")
                .prefix("xq_live_abc1")
                .build()

        assertThat(apiKeyCreateResponse.id()).isEqualTo("42")
        assertThat(apiKeyCreateResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(apiKeyCreateResponse.fullKey()).isEqualTo("xq_live_abc123def456")
        assertThat(apiKeyCreateResponse.name()).isEqualTo("My API Key")
        assertThat(apiKeyCreateResponse.prefix()).isEqualTo("xq_live_abc1")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiKeyCreateResponse =
            ApiKeyCreateResponse.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .fullKey("xq_live_abc123def456")
                .name("My API Key")
                .prefix("xq_live_abc1")
                .build()

        val roundtrippedApiKeyCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiKeyCreateResponse),
                jacksonTypeRef<ApiKeyCreateResponse>(),
            )

        assertThat(roundtrippedApiKeyCreateResponse).isEqualTo(apiKeyCreateResponse)
    }
}
