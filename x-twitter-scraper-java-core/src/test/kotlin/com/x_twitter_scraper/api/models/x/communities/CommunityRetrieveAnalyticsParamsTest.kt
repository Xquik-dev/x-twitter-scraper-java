// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.communities

import java.util.Optional
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CommunityRetrieveAnalyticsParamsTest {

    @Test
    fun create() {
        val params =
            CommunityRetrieveAnalyticsParams.builder()
                .id("1493446837214187523")
                .fields("id,periodEndsAt,metrics")
                .omit("unused")
                .build()

        assertThat(params.id()).contains("1493446837214187523")
        assertThat(params.fields()).contains("id,periodEndsAt,metrics")
        assertThat(params.omit()).contains("unused")
        assertThat(params.toBuilder().build()).isEqualTo(params)
        assertThat(params.toBuilder().build().hashCode()).isEqualTo(params.hashCode())
    }

    @Test
    fun pathParams() {
        val params = CommunityRetrieveAnalyticsParams.builder().id("1493446837214187523").build()

        assertThat(params._pathParam(0)).isEqualTo("1493446837214187523")
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            CommunityRetrieveAnalyticsParams.builder()
                .fields(Optional.of("id,periodEndsAt,metrics"))
                .omit(Optional.of("unused"))
                .putAdditionalQueryParam("extra", "value")
                .build()

        assertThat(params._queryParams().values("fields"))
            .containsExactly("id,periodEndsAt,metrics")
        assertThat(params._queryParams().values("omit")).containsExactly("unused")
        assertThat(params._queryParams().values("extra")).containsExactly("value")
        assertThat(CommunityRetrieveAnalyticsParams.none()._queryParams().keys()).isEmpty()
    }
}
