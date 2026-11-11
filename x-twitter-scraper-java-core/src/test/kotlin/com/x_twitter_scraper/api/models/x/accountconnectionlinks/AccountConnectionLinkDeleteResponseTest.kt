// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.accountconnectionlinks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountConnectionLinkDeleteResponseTest {

    @Test
    fun create() {
        val response = AccountConnectionLinkDeleteResponse.builder().build()

        assertThat(response._success()).isEqualTo(JsonValue.from(true))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val response = AccountConnectionLinkDeleteResponse.builder().build()

        val roundtripped =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(response),
                jacksonTypeRef<AccountConnectionLinkDeleteResponse>(),
            )

        assertThat(roundtripped).isEqualTo(response)
        assertThat(roundtripped.validate()).isSameAs(roundtripped)
    }

    @Test
    fun rejectsAFalseSuccess() {
        val jsonMapper = jsonMapper()

        val response =
            jsonMapper.readValue(
                """{"success":false}""",
                jacksonTypeRef<AccountConnectionLinkDeleteResponse>(),
            )

        assertThat(response.isValid()).isFalse()
    }
}
