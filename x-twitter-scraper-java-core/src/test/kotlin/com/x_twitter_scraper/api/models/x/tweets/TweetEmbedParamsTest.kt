// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.tweets

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetEmbedParamsTest {

    @Test
    fun create() {
        TweetEmbedParams.builder()
            .id("id")
            .fields("id,text,author.username")
            .hideMedia(true)
            .hideThread(true)
            .omit("entities,media")
            .omitScript(true)
            .theme(TweetEmbedParams.Theme.LIGHT)
            .build()
    }

    @Test
    fun pathParams() {
        val params = TweetEmbedParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            TweetEmbedParams.builder()
                .id("id")
                .fields("id,text,author.username")
                .hideMedia(true)
                .hideThread(true)
                .omit("entities,media")
                .omitScript(true)
                .theme(TweetEmbedParams.Theme.LIGHT)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("fields", "id,text,author.username")
                    .put("hideMedia", "true")
                    .put("hideThread", "true")
                    .put("omit", "entities,media")
                    .put("omitScript", "true")
                    .put("theme", "light")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = TweetEmbedParams.builder().id("id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
