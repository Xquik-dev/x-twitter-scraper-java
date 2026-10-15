// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.tweets

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetResolveLinksParamsTest {

    @Test
    fun create() {
        TweetResolveLinksParams.builder()
            .urls("https://t.co/Xe1nm2pkSX")
            .fields("id,text,author.username")
            .omit("entities,media")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            TweetResolveLinksParams.builder()
                .urls("https://t.co/Xe1nm2pkSX")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("urls", "https://t.co/Xe1nm2pkSX")
                    .put("fields", "id,text,author.username")
                    .put("omit", "entities,media")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = TweetResolveLinksParams.builder().urls("https://t.co/Xe1nm2pkSX").build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("urls", "https://t.co/Xe1nm2pkSX").build())
    }
}
