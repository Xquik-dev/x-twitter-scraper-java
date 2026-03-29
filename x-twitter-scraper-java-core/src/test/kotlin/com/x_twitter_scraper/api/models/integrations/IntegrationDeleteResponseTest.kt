// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.integrations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class IntegrationDeleteResponseTest {

    @Test
    fun create() {
        val integrationDeleteResponse = IntegrationDeleteResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val integrationDeleteResponse = IntegrationDeleteResponse.builder().build()

        val roundtrippedIntegrationDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(integrationDeleteResponse),
                jacksonTypeRef<IntegrationDeleteResponse>(),
            )

        assertThat(roundtrippedIntegrationDeleteResponse).isEqualTo(integrationDeleteResponse)
    }
}
