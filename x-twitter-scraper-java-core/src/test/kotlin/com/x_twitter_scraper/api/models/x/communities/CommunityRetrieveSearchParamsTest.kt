// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.communities

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CommunityRetrieveSearchParamsTest {

    @Test
    fun create() {
        CommunityRetrieveSearchParams.builder()
            .communityId("321669910225")
            .q("q")
            .cursor("cursor")
            .pageSize(1L)
            .queryType(CommunityRetrieveSearchParams.QueryType.LATEST)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            CommunityRetrieveSearchParams.builder()
                .communityId("321669910225")
                .q("q")
                .cursor("cursor")
                .pageSize(1L)
                .queryType(CommunityRetrieveSearchParams.QueryType.LATEST)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("communityId", "321669910225")
                    .put("q", "q")
                    .put("cursor", "cursor")
                    .put("pageSize", "1")
                    .put("queryType", "Latest")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            CommunityRetrieveSearchParams.builder().communityId("321669910225").q("q").build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder().put("communityId", "321669910225").put("q", "q").build()
            )
    }
}
