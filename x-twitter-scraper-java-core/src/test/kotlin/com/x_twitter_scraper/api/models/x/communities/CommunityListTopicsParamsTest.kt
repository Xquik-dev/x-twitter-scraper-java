// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.communities

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CommunityListTopicsParamsTest {

    @Test
    fun create() {
        CommunityListTopicsParams.builder()
            .fields("id,text,author.username")
            .limit(1L)
            .omit("entities,media")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            CommunityListTopicsParams.builder()
                .fields("id,text,author.username")
                .limit(1L)
                .omit("entities,media")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("fields", "id,text,author.username")
                    .put("limit", "1")
                    .put("omit", "entities,media")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = CommunityListTopicsParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
