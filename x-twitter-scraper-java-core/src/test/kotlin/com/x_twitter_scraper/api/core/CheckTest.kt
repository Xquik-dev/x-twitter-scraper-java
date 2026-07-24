// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.core

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class CheckTest {

    @Test
    fun requiredValues() {
        checkRequired("enabled", true)
        assertThat(checkRequired("value", "present")).isEqualTo("present")

        assertThatThrownBy { checkRequired("enabled", false) }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("`enabled` is required, but was not set")
        assertThatThrownBy { checkRequired<String>("value", null) }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("`value` is required, but was not set")
    }

    @Test
    fun knownValues() {
        assertThat(checkKnown("field", JsonField.of("known"))).isEqualTo("known")
        assertThat(checkKnown("field", MultipartField.of("known"))).isEqualTo("known")

        assertThatThrownBy { checkKnown<String>("field", JsonString.of("unknown")) }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("`field` is not a known type: JsonString")
        assertThatThrownBy {
                checkKnown("field", MultipartField.of<String>(JsonString.of("unknown")))
            }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("`field` is not a known type: MultipartField")
    }

    @Test
    fun stringLengths() {
        assertThat(checkLength("code", "123", 3)).isEqualTo("123")
        assertThat(checkMinLength("code", "123", 2)).isEqualTo("123")
        assertThat(checkMaxLength("code", "123", 4)).isEqualTo("123")

        assertThatThrownBy { checkLength("code", "123", 2) }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("`code` must have length 2, but was 3")
        assertThatThrownBy { checkMinLength("code", "", 1) }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("`code` must be non-empty, but was empty")
        assertThatThrownBy { checkMinLength("code", "1", 2) }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("`code` must have at least length 2, but was 1")
        assertThatThrownBy { checkMaxLength("code", "123", 2) }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("`code` must have at most length 2, but was 3")
    }

    @Test
    fun jacksonVersionsAreCompatible() {
        checkJacksonVersionCompatibility()
    }
}
