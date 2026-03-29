// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.users

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserRetrieveTweetsParamsTest {

    @Test
    fun create() {
        UserRetrieveTweetsParams.builder()
            .id("id")
            .cursor("cursor")
            .includeParentTweet(true)
            .includeReplies(true)
            .build()
    }

    @Test
    fun pathParams() {
        val params = UserRetrieveTweetsParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            UserRetrieveTweetsParams.builder()
                .id("id")
                .cursor("cursor")
                .includeParentTweet(true)
                .includeReplies(true)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("cursor", "cursor")
                    .put("includeParentTweet", "true")
                    .put("includeReplies", "true")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = UserRetrieveTweetsParams.builder().id("id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
