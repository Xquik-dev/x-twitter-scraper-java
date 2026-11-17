// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException

/** Why X cut a page short. */
class CoverageEndReason @JsonCreator private constructor(private val value: JsonField<String>) :
    Enum {

    /** Returns this class instance's raw value. */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val STALLED = of("stalled")

        @JvmStatic fun of(value: String) = CoverageEndReason(JsonField.of(value))
    }

    /** An enum containing [CoverageEndReason]'s known values. */
    enum class Known {
        STALLED
    }

    /** An enum containing [CoverageEndReason]'s known values, as well as an [_UNKNOWN] member. */
    enum class Value {
        STALLED,
        /**
         * An enum member indicating that [CoverageEndReason] was instantiated with an unknown
         * value.
         */
        _UNKNOWN,
    }

    /**
     * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if
     * unknown.
     */
    fun value(): Value =
        when (this) {
            STALLED -> Value.STALLED
            else -> Value._UNKNOWN
        }

    /**
     * Returns an enum member corresponding to this class instance's value.
     *
     * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a known
     *   member.
     */
    fun known(): Known =
        when (this) {
            STALLED -> Known.STALLED
            else -> throw XTwitterScraperInvalidDataException("Unknown CoverageEndReason: $value")
        }

    /**
     * Returns this class instance's primitive wire representation.
     *
     * @throws XTwitterScraperInvalidDataException if this class instance's value does not have the
     *   expected primitive type.
     */
    fun asString(): String =
        _value().asString().orElseThrow {
            XTwitterScraperInvalidDataException("Value is not a String")
        }

    private var validated: Boolean = false

    /** Validates that this value is a known member. */
    fun validate(): CoverageEndReason = apply {
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

        return other is CoverageEndReason && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
