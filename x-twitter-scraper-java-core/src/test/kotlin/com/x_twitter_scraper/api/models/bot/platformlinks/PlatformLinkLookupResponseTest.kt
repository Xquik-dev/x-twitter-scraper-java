// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.bot.platformlinks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PlatformLinkLookupResponseTest {

    @Test
    fun create() {
        val platformLinkLookupResponse =
            PlatformLinkLookupResponse.builder().userId("userId").build()

        assertThat(platformLinkLookupResponse.userId()).isEqualTo("userId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val platformLinkLookupResponse =
            PlatformLinkLookupResponse.builder().userId("userId").build()

        val roundtrippedPlatformLinkLookupResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(platformLinkLookupResponse),
                jacksonTypeRef<PlatformLinkLookupResponse>(),
            )

        assertThat(roundtrippedPlatformLinkLookupResponse).isEqualTo(platformLinkLookupResponse)
    }
}
