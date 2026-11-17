// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.accountconnectionlinks

import java.util.Optional
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountConnectionLinkListParamsTest {

    @Test
    fun create() {
        val params = AccountConnectionLinkListParams.none()

        assertThat(params.limit()).isEmpty
        assertThat(params.cursor()).isEmpty
        assertThat(params._queryParams().keys()).isEmpty()
    }

    @Test
    fun queryParams() {
        val params = AccountConnectionLinkListParams.builder().limit(20L).cursor("abc123").build()

        assertThat(params.limit()).contains(20L)
        assertThat(params.cursor()).contains("abc123")
        assertThat(params._queryParams().values("limit")).containsExactly("20")
        assertThat(params._queryParams().values("cursor")).containsExactly("abc123")
        assertThat(params.toBuilder().build()).isEqualTo(params)
        assertThat(params.toBuilder().build().hashCode()).isEqualTo(params.hashCode())
        assertThat(params.toString()).contains("limit=20", "cursor=abc123")
    }

    @Test
    fun optionalAliasesClearTheQueryParams() {
        val params =
            AccountConnectionLinkListParams.builder()
                .limit(20L)
                .cursor("abc123")
                .limit(Optional.empty())
                .cursor(Optional.empty())
                .build()

        assertThat(params).isEqualTo(AccountConnectionLinkListParams.none())
        assertThat(
                AccountConnectionLinkListParams.builder()
                    .limit(Optional.of(5L))
                    .cursor(Optional.of("next"))
                    .build()
                    ._queryParams()
                    .values("cursor")
            )
            .containsExactly("next")
    }
}
