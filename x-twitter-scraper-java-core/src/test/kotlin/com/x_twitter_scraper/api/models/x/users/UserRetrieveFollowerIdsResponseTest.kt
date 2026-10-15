// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserRetrieveFollowerIdsResponseTest {

    @Test
    fun create() {
        val userRetrieveFollowerIdsResponse =
            UserRetrieveFollowerIdsResponse.builder()
                .hasNextPage(true)
                .addId("9876543210")
                .nextCursor("1878079982871151535")
                .build()

        assertThat(userRetrieveFollowerIdsResponse.hasNextPage()).isEqualTo(true)
        assertThat(userRetrieveFollowerIdsResponse.ids()).containsExactly("9876543210")
        assertThat(userRetrieveFollowerIdsResponse.nextCursor()).isEqualTo("1878079982871151535")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val userRetrieveFollowerIdsResponse =
            UserRetrieveFollowerIdsResponse.builder()
                .hasNextPage(true)
                .addId("9876543210")
                .nextCursor("1878079982871151535")
                .build()

        val roundtrippedUserRetrieveFollowerIdsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userRetrieveFollowerIdsResponse),
                jacksonTypeRef<UserRetrieveFollowerIdsResponse>(),
            )

        assertThat(roundtrippedUserRetrieveFollowerIdsResponse)
            .isEqualTo(userRetrieveFollowerIdsResponse)
    }
}
