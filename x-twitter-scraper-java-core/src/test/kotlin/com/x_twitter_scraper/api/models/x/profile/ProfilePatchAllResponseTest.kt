// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.profile

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfilePatchAllResponseTest {

    @Test
    fun create() {
        val profilePatchAllResponse = ProfilePatchAllResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val profilePatchAllResponse = ProfilePatchAllResponse.builder().build()

        val roundtrippedProfilePatchAllResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(profilePatchAllResponse),
                jacksonTypeRef<ProfilePatchAllResponse>(),
            )

        assertThat(roundtrippedProfilePatchAllResponse).isEqualTo(profilePatchAllResponse)
    }
}
