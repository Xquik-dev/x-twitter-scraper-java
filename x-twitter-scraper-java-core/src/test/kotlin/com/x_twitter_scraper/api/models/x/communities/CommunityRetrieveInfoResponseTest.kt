// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.communities

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CommunityRetrieveInfoResponseTest {

    @Test
    fun create() {
        val communityRetrieveInfoResponse =
            CommunityRetrieveInfoResponse.builder()
                .community(JsonValue.from(mapOf<String, Any>()))
                .build()

        assertThat(communityRetrieveInfoResponse._community())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val communityRetrieveInfoResponse =
            CommunityRetrieveInfoResponse.builder()
                .community(JsonValue.from(mapOf<String, Any>()))
                .build()

        val roundtrippedCommunityRetrieveInfoResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(communityRetrieveInfoResponse),
                jacksonTypeRef<CommunityRetrieveInfoResponse>(),
            )

        assertThat(roundtrippedCommunityRetrieveInfoResponse)
            .isEqualTo(communityRetrieveInfoResponse)
    }
}
