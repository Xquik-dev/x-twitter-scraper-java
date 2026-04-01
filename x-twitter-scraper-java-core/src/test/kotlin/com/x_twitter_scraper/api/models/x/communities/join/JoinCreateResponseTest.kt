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
                .communityId("communityId")
                .communityName("communityName")
                .build()

        assertThat(joinCreateResponse.communityId()).isEqualTo("communityId")
        assertThat(joinCreateResponse.communityName()).isEqualTo("communityName")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val joinCreateResponse =
            JoinCreateResponse.builder()
                .communityId("communityId")
                .communityName("communityName")
                .build()

        val roundtrippedJoinCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(joinCreateResponse),
                jacksonTypeRef<JoinCreateResponse>(),
            )

        assertThat(roundtrippedJoinCreateResponse).isEqualTo(joinCreateResponse)
    }
}
