// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetSearchParamsTest {

    @Test
    fun create() {
        TweetSearchParams.builder()
            .q("q")
            .cursor("cursor")
            .limit(200L)
            .queryType(TweetSearchParams.QueryType.LATEST)
            .sinceTime("sinceTime")
            .untilTime("untilTime")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            TweetSearchParams.builder()
                .q("q")
                .cursor("cursor")
                .limit(200L)
                .queryType(TweetSearchParams.QueryType.LATEST)
                .sinceTime("sinceTime")
                .untilTime("untilTime")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("q", "q")
                    .put("cursor", "cursor")
                    .put("limit", "200")
                    .put("queryType", "Latest")
                    .put("sinceTime", "sinceTime")
                    .put("untilTime", "untilTime")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = TweetSearchParams.builder().q("q").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("q", "q").build())
    }
}
