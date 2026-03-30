// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.profile

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfileUpdateResponseTest {

    @Test
    fun create() {
        val profileUpdateResponse = ProfileUpdateResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val profileUpdateResponse = ProfileUpdateResponse.builder().build()

        val roundtrippedProfileUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(profileUpdateResponse),
                jacksonTypeRef<ProfileUpdateResponse>(),
            )

        assertThat(roundtrippedProfileUpdateResponse).isEqualTo(profileUpdateResponse)
    }
}
