// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.users

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserRetrieveFollowersParamsTest {

    @Test
    fun create() {
        UserRetrieveFollowersParams.builder()
            .id("id")
            .after("after")
            .bioContains("bioContains")
            .cursor("cursor")
            .hasLocation(true)
            .hasWebsite(true)
            .limit(1L)
            .locationContains("locationContains")
            .maxFollowers(0L)
            .maxFollowing(0L)
            .maxStatuses(0L)
            .minAccountAgeDays(0L)
            .minFollowers(0L)
            .minFollowing(0L)
            .minStatuses(0L)
            .mode(UserRetrieveFollowersParams.Mode.STANDARD)
            .pageSize(20L)
            .usernameContains("usernameContains")
            .verifiedOnly(true)
            .verifiedType("verifiedType")
            .build()
    }

    @Test
    fun pathParams() {
        val params = UserRetrieveFollowersParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            UserRetrieveFollowersParams.builder()
                .id("id")
                .after("after")
                .bioContains("bioContains")
                .cursor("cursor")
                .hasLocation(true)
                .hasWebsite(true)
                .limit(1L)
                .locationContains("locationContains")
                .maxFollowers(0L)
                .maxFollowing(0L)
                .maxStatuses(0L)
                .minAccountAgeDays(0L)
                .minFollowers(0L)
                .minFollowing(0L)
                .minStatuses(0L)
                .mode(UserRetrieveFollowersParams.Mode.STANDARD)
                .pageSize(20L)
                .usernameContains("usernameContains")
                .verifiedOnly(true)
                .verifiedType("verifiedType")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("bioContains", "bioContains")
                    .put("cursor", "cursor")
                    .put("hasLocation", "true")
                    .put("hasWebsite", "true")
                    .put("limit", "1")
                    .put("locationContains", "locationContains")
                    .put("maxFollowers", "0")
                    .put("maxFollowing", "0")
                    .put("maxStatuses", "0")
                    .put("minAccountAgeDays", "0")
                    .put("minFollowers", "0")
                    .put("minFollowing", "0")
                    .put("minStatuses", "0")
                    .put("mode", "standard")
                    .put("pageSize", "20")
                    .put("usernameContains", "usernameContains")
                    .put("verifiedOnly", "true")
                    .put("verifiedType", "verifiedType")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = UserRetrieveFollowersParams.builder().id("id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
