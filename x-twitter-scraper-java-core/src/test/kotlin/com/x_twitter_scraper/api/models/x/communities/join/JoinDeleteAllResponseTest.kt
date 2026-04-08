// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.communities.join

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JoinDeleteAllResponseTest {

    @Test
    fun create() {
        val joinDeleteAllResponse =
            JoinDeleteAllResponse.builder()
                .communityId("1500000000000000000")
                .communityName("Tesla Fans")
                .build()

        assertThat(joinDeleteAllResponse.communityId()).isEqualTo("1500000000000000000")
        assertThat(joinDeleteAllResponse.communityName()).isEqualTo("Tesla Fans")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val joinDeleteAllResponse =
            JoinDeleteAllResponse.builder()
                .communityId("1500000000000000000")
                .communityName("Tesla Fans")
                .build()

        val roundtrippedJoinDeleteAllResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(joinDeleteAllResponse),
                jacksonTypeRef<JoinDeleteAllResponse>(),
            )

        assertThat(roundtrippedJoinDeleteAllResponse).isEqualTo(joinDeleteAllResponse)
    }
}
