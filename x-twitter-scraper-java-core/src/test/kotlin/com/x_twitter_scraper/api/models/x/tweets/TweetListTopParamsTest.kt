// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.tweets

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetListTopParamsTest {

    @Test
    fun create() {
        TweetListTopParams.builder()
            .country("US")
            .cursor("cursor")
            .fields("id,text,author.username")
            .language("en")
            .metric(TweetListTopParams.Metric.LIKES)
            .omit("entities,media")
            .pageSize(1L)
            .window(TweetListTopParams.Window.DAY)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            TweetListTopParams.builder()
                .country("US")
                .cursor("cursor")
                .fields("id,text,author.username")
                .language("en")
                .metric(TweetListTopParams.Metric.LIKES)
                .omit("entities,media")
                .pageSize(1L)
                .window(TweetListTopParams.Window.DAY)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("country", "US")
                    .put("cursor", "cursor")
                    .put("fields", "id,text,author.username")
                    .put("language", "en")
                    .put("metric", "likes")
                    .put("omit", "entities,media")
                    .put("pageSize", "1")
                    .put("window", "day")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = TweetListTopParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
