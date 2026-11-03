// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.users

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects

/** Pass means X shows the account there, and fail means it doesn't. Unknown means the check had nothing to test or X didn't answer. */
class ShadowbanVerdict @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

    /** Returns this class instance's raw value. */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val PASS = of("pass")

        @JvmField val FAIL = of("fail")

        @JvmField val UNKNOWN = of("unknown")

        @JvmStatic fun of(value: String) = ShadowbanVerdict(JsonField.of(value))
    }

    /** An enum containing [ShadowbanVerdict]'s known values. */
    enum class Known {
        PASS,
        FAIL,
        UNKNOWN,
    }

    /** An enum containing [ShadowbanVerdict]'s known values, as well as an [_UNKNOWN] member. */
    enum class Value {
        PASS,
        FAIL,
        UNKNOWN,
        /** An enum member indicating that [ShadowbanVerdict] was instantiated with an unknown value. */
        _UNKNOWN,
    }

    /** Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if unknown. */
    fun value(): Value =
        when (this) {
            PASS -> Value.PASS
            FAIL -> Value.FAIL
            UNKNOWN -> Value.UNKNOWN
            else -> Value._UNKNOWN
        }

    /**
     * Returns an enum member corresponding to this class instance's value.
     *
     * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a known member.
     */
    fun known(): Known =
        when (this) {
            PASS -> Known.PASS
            FAIL -> Known.FAIL
            UNKNOWN -> Known.UNKNOWN
            else -> throw XTwitterScraperInvalidDataException("Unknown ShadowbanVerdict: $value")
        }

    /**
     * Returns this class instance's primitive wire representation.
     *
     * @throws XTwitterScraperInvalidDataException if this class instance's value does not have the expected primitive type.
     */
    fun asString(): String =
        _value().asString().orElseThrow { XTwitterScraperInvalidDataException("Value is not a String") }

    private var validated: Boolean = false

    /** Validates that this value is a known member. */
    fun validate(): ShadowbanVerdict = apply {
        if (validated) {
            return@apply
        }

        known()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: XTwitterScraperInvalidDataException) {
            false
        }

    @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ShadowbanVerdict && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
