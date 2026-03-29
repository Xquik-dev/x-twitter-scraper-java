// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.apikeys

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyRevokeResponseTest {

    @Test
    fun create() {
        val apiKeyRevokeResponse = ApiKeyRevokeResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiKeyRevokeResponse = ApiKeyRevokeResponse.builder().build()

        val roundtrippedApiKeyRevokeResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiKeyRevokeResponse),
                jacksonTypeRef<ApiKeyRevokeResponse>(),
            )

        assertThat(roundtrippedApiKeyRevokeResponse).isEqualTo(apiKeyRevokeResponse)
    }
}
