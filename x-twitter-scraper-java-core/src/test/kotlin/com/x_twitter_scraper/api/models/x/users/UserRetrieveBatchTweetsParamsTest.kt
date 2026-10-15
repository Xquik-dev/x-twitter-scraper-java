// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.users

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserRetrieveBatchTweetsParamsTest {

    @Test
    fun create() {
        UserRetrieveBatchTweetsParams.builder()
            .fields("id,text,author.username")
            .ids("ids")
            .omit("entities,media")
            .pageSize(1L)
            .usernames("nasa,@OpenAI,x.com/verge")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            UserRetrieveBatchTweetsParams.builder()
                .fields("id,text,author.username")
                .ids("ids")
                .omit("entities,media")
                .pageSize(1L)
                .usernames("nasa,@OpenAI,x.com/verge")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("fields", "id,text,author.username")
                    .put("ids", "ids")
                    .put("omit", "entities,media")
                    .put("pageSize", "1")
                    .put("usernames", "nasa,@OpenAI,x.com/verge")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = UserRetrieveBatchTweetsParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
