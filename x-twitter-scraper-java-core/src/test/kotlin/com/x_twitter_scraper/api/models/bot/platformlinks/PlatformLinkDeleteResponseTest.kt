// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.bot.platformlinks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PlatformLinkDeleteResponseTest {

    @Test
    fun create() {
        val platformLinkDeleteResponse = PlatformLinkDeleteResponse.builder().success(true).build()

        assertThat(platformLinkDeleteResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val platformLinkDeleteResponse = PlatformLinkDeleteResponse.builder().success(true).build()

        val roundtrippedPlatformLinkDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(platformLinkDeleteResponse),
                jacksonTypeRef<PlatformLinkDeleteResponse>(),
            )

        assertThat(roundtrippedPlatformLinkDeleteResponse).isEqualTo(platformLinkDeleteResponse)
    }
}
