// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.users

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserRetrieveSimilarParamsTest {

    @Test
    fun create() {
        UserRetrieveSimilarParams.builder()
            .id("id")
            .bioContains("bioContains")
            .blueVerifiedOnly(true)
            .businessEmailOnly(true)
            .cursor("cursor")
            .emailDomains("acme.com,stanford.edu")
            .fields("id,text,author.username")
            .hasEmail(true)
            .hasLocation(true)
            .hasWebsite(true)
            .locationContains("locationContains")
            .maxFollowers(0L)
            .maxFollowing(0L)
            .maxStatuses(0L)
            .minAccountAgeDays(0L)
            .minFollowers(0L)
            .minFollowing(0L)
            .minStatuses(0L)
            .omit("entities,media")
            .pageSize(1L)
            .usernameContains("usernameContains")
            .verifiedOnly(true)
            .verifiedType("verifiedType")
            .build()
    }

    @Test
    fun pathParams() {
        val params = UserRetrieveSimilarParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            UserRetrieveSimilarParams.builder()
                .id("id")
                .bioContains("bioContains")
                .blueVerifiedOnly(true)
                .businessEmailOnly(true)
                .cursor("cursor")
                .emailDomains("acme.com,stanford.edu")
                .fields("id,text,author.username")
                .hasEmail(true)
                .hasLocation(true)
                .hasWebsite(true)
                .locationContains("locationContains")
                .maxFollowers(0L)
                .maxFollowing(0L)
                .maxStatuses(0L)
                .minAccountAgeDays(0L)
                .minFollowers(0L)
                .minFollowing(0L)
                .minStatuses(0L)
                .omit("entities,media")
                .pageSize(1L)
                .usernameContains("usernameContains")
                .verifiedOnly(true)
                .verifiedType("verifiedType")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("bioContains", "bioContains")
                    .put("blueVerifiedOnly", "true")
                    .put("businessEmailOnly", "true")
                    .put("cursor", "cursor")
                    .put("emailDomains", "acme.com,stanford.edu")
                    .put("fields", "id,text,author.username")
                    .put("hasEmail", "true")
                    .put("hasLocation", "true")
                    .put("hasWebsite", "true")
                    .put("locationContains", "locationContains")
                    .put("maxFollowers", "0")
                    .put("maxFollowing", "0")
                    .put("maxStatuses", "0")
                    .put("minAccountAgeDays", "0")
                    .put("minFollowers", "0")
                    .put("minFollowing", "0")
                    .put("minStatuses", "0")
                    .put("omit", "entities,media")
                    .put("pageSize", "1")
                    .put("usernameContains", "usernameContains")
                    .put("verifiedOnly", "true")
                    .put("verifiedType", "verifiedType")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = UserRetrieveSimilarParams.builder().id("id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
