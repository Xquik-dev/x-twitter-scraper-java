// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.communities.join

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JoinCreateResponseTest {

    @Test
    fun create() {
        val joinCreateResponse =
            JoinCreateResponse.builder()
                .communityId("1500000000000000000")
                .communityName("Tesla Fans")
                .build()

        assertThat(joinCreateResponse.communityId()).isEqualTo("1500000000000000000")
        assertThat(joinCreateResponse.communityName()).isEqualTo("Tesla Fans")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val joinCreateResponse =
            JoinCreateResponse.builder()
                .communityId("1500000000000000000")
                .communityName("Tesla Fans")
                .build()

        val roundtrippedJoinCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(joinCreateResponse),
                jacksonTypeRef<JoinCreateResponse>(),
            )

        assertThat(roundtrippedJoinCreateResponse).isEqualTo(joinCreateResponse)
    }
}
