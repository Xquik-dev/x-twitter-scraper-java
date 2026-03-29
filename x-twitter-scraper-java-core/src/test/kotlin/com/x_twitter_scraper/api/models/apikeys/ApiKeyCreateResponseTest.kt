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
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .fullKey("fullKey")
                .name("name")
                .prefix("prefix")
                .build()

        assertThat(apiKeyCreateResponse.id()).isEqualTo("id")
        assertThat(apiKeyCreateResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(apiKeyCreateResponse.fullKey()).isEqualTo("fullKey")
        assertThat(apiKeyCreateResponse.name()).isEqualTo("name")
        assertThat(apiKeyCreateResponse.prefix()).isEqualTo("prefix")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiKeyCreateResponse =
            ApiKeyCreateResponse.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .fullKey("fullKey")
                .name("name")
                .prefix("prefix")
                .build()

        val roundtrippedApiKeyCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiKeyCreateResponse),
                jacksonTypeRef<ApiKeyCreateResponse>(),
            )

        assertThat(roundtrippedApiKeyCreateResponse).isEqualTo(apiKeyCreateResponse)
    }
}
