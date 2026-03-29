// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.integrations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class IntegrationSendTestResponseTest {

    @Test
    fun create() {
        val integrationSendTestResponse = IntegrationSendTestResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val integrationSendTestResponse = IntegrationSendTestResponse.builder().build()

        val roundtrippedIntegrationSendTestResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(integrationSendTestResponse),
                jacksonTypeRef<IntegrationSendTestResponse>(),
            )

        assertThat(roundtrippedIntegrationSendTestResponse).isEqualTo(integrationSendTestResponse)
    }
}
