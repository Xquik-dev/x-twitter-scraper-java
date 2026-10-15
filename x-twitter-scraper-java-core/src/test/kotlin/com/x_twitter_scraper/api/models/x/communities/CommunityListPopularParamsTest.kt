// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.communities

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CommunityListPopularParamsTest {

    @Test
    fun create() {
        CommunityListPopularParams.builder()
            .cursor("cursor")
            .fields("id,text,author.username")
            .omit("entities,media")
            .pageSize(1L)
            .topic("topic")
            .topicId("topicId")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            CommunityListPopularParams.builder()
                .cursor("cursor")
                .fields("id,text,author.username")
                .omit("entities,media")
                .pageSize(1L)
                .topic("topic")
                .topicId("topicId")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("cursor", "cursor")
                    .put("fields", "id,text,author.username")
                    .put("omit", "entities,media")
                    .put("pageSize", "1")
                    .put("topic", "topic")
                    .put("topicId", "topicId")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = CommunityListPopularParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
