// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.profile

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfileUpdateAvatarResponseTest {

    @Test
    fun create() {
        val profileUpdateAvatarResponse = ProfileUpdateAvatarResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val profileUpdateAvatarResponse = ProfileUpdateAvatarResponse.builder().build()

        val roundtrippedProfileUpdateAvatarResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(profileUpdateAvatarResponse),
                jacksonTypeRef<ProfileUpdateAvatarResponse>(),
            )

        assertThat(roundtrippedProfileUpdateAvatarResponse).isEqualTo(profileUpdateAvatarResponse)
    }
}
