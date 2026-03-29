// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.lists

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ListRetrieveTweetsParamsTest {

    @Test
    fun create() {
        ListRetrieveTweetsParams.builder()
            .id("id")
            .cursor("cursor")
            .includeReplies(true)
            .sinceTime("sinceTime")
            .untilTime("untilTime")
            .build()
    }

    @Test
    fun pathParams() {
        val params = ListRetrieveTweetsParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            ListRetrieveTweetsParams.builder()
                .id("id")
                .cursor("cursor")
                .includeReplies(true)
                .sinceTime("sinceTime")
                .untilTime("untilTime")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("cursor", "cursor")
                    .put("includeReplies", "true")
                    .put("sinceTime", "sinceTime")
                    .put("untilTime", "untilTime")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ListRetrieveTweetsParams.builder().id("id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
