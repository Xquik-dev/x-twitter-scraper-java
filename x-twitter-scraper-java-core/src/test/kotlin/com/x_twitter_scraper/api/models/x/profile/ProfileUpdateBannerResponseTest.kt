// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.profile

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfileUpdateBannerResponseTest {

    @Test
    fun create() {
        val profileUpdateBannerResponse = ProfileUpdateBannerResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val profileUpdateBannerResponse = ProfileUpdateBannerResponse.builder().build()

        val roundtrippedProfileUpdateBannerResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(profileUpdateBannerResponse),
                jacksonTypeRef<ProfileUpdateBannerResponse>(),
            )

        assertThat(roundtrippedProfileUpdateBannerResponse).isEqualTo(profileUpdateBannerResponse)
    }
}
