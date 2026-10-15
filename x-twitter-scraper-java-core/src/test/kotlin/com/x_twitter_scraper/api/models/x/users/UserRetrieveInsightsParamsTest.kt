// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.users

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserRetrieveInsightsParamsTest {

    @Test
    fun create() {
        UserRetrieveInsightsParams.builder()
            .id("id")
            .fields("id,text,author.username")
            .omit("entities,media")
            .build()
    }

    @Test
    fun pathParams() {
        val params = UserRetrieveInsightsParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            UserRetrieveInsightsParams.builder()
                .id("id")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("fields", "id,text,author.username")
                    .put("omit", "entities,media")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = UserRetrieveInsightsParams.builder().id("id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
