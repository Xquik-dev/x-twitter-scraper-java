// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.tweets

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetTranslateParamsTest {

    @Test
    fun create() {
        TweetTranslateParams.builder()
            .id("id")
            .language("tr")
            .fields("id,text,author.username")
            .omit("entities,media")
            .build()
    }

    @Test
    fun pathParams() {
        val params = TweetTranslateParams.builder().id("id").language("tr").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            TweetTranslateParams.builder()
                .id("id")
                .language("tr")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("language", "tr")
                    .put("fields", "id,text,author.username")
                    .put("omit", "entities,media")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = TweetTranslateParams.builder().id("id").language("tr").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("language", "tr").build())
    }
}
