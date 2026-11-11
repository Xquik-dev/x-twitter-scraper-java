// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.accountconnectionlinks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountConnectionLinkCreateParamsTest {

    private val params =
        AccountConnectionLinkCreateParams.builder()
            .accountId("42")
            .reference("crm-user-7")
            .returnUrl("https://app.example.com/connected")
            .build()

    @Test
    fun create() {
        assertThat(params.accountId()).contains("42")
        assertThat(params.reference()).contains("crm-user-7")
        assertThat(params.returnUrl()).contains("https://app.example.com/connected")
    }

    @Test
    fun body() {
        val jsonMapper = jsonMapper()
        val json = jsonMapper.writeValueAsString(params._body())
        val expected =
            """{"accountId":"42","reference":"crm-user-7","returnUrl":"https://app.example.com/connected"}"""

        val roundtripped =
            jsonMapper.readValue(json, jacksonTypeRef<AccountConnectionLinkCreateParams.Body>())

        assertThat(jsonMapper.readTree(json)).isEqualTo(jsonMapper.readTree(expected))
        assertThat(roundtripped).isEqualTo(params._body())
        assertThat(roundtripped.validate()).isSameAs(roundtripped)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = AccountConnectionLinkCreateParams.none()

        assertThat(params.accountId()).isEmpty
        assertThat(params.reference()).isEmpty
        assertThat(params.returnUrl()).isEmpty
        assertThat(params._accountId().isMissing()).isTrue()
        assertThat(params._reference().isMissing()).isTrue()
        assertThat(params._returnUrl().isMissing()).isTrue()
    }

    @Test
    fun bodyWithAdditionalPropertiesWithoutOptionalFields() {
        val params =
            AccountConnectionLinkCreateParams.builder()
                .putAdditionalBodyProperty("extra", JsonValue.from("value"))
                .build()

        val jsonMapper = jsonMapper()
        val body = jsonMapper.readTree(jsonMapper.writeValueAsString(params._body()))

        assertThat(body).isEqualTo(jsonMapper.readTree("""{"extra":"value"}"""))
        assertThat(body.has("accountId")).isFalse()
    }
}
