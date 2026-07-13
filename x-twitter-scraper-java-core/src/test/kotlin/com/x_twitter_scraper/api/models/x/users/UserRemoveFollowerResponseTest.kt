// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserRemoveFollowerResponseTest {

    @Test
    fun create() {
        val userRemoveFollowerResponse = UserRemoveFollowerResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val userRemoveFollowerResponse = UserRemoveFollowerResponse.builder().build()

        val roundtrippedUserRemoveFollowerResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userRemoveFollowerResponse),
                jacksonTypeRef<UserRemoveFollowerResponse>(),
            )

        assertThat(roundtrippedUserRemoveFollowerResponse).isEqualTo(userRemoveFollowerResponse)
    }
}
