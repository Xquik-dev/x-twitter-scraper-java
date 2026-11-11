// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.users

import com.fasterxml.jackson.annotation.JsonCreator
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException

/** What 1 follower looks like from its public profile. */
class FollowerClass @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

    /** Returns this class instance's raw value. */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val AUTOMATED = of("automated")

        @JvmField val INACTIVE = of("inactive")

        @JvmField val LIKELY_FAKE = of("likelyFake")

        @JvmField val LIKELY_REAL = of("likelyReal")

        @JvmField val TOO_NEW = of("tooNew")

        @JvmStatic fun of(value: String) = FollowerClass(JsonField.of(value))
    }

    /** An enum containing [FollowerClass]'s known values. */
    enum class Known {
        AUTOMATED,
        INACTIVE,
        LIKELY_FAKE,
        LIKELY_REAL,
        TOO_NEW,
    }

    /** An enum containing [FollowerClass]'s known values, as well as an [_UNKNOWN] member. */
    enum class Value {
        AUTOMATED,
        INACTIVE,
        LIKELY_FAKE,
        LIKELY_REAL,
        TOO_NEW,
        /**
         * An enum member indicating that [FollowerClass] was instantiated with an unknown value.
         */
        _UNKNOWN,
    }

    /**
     * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if
     * unknown.
     */
    fun value(): Value =
        when (this) {
            AUTOMATED -> Value.AUTOMATED
            INACTIVE -> Value.INACTIVE
            LIKELY_FAKE -> Value.LIKELY_FAKE
            LIKELY_REAL -> Value.LIKELY_REAL
            TOO_NEW -> Value.TOO_NEW
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
            AUTOMATED -> Known.AUTOMATED
            INACTIVE -> Known.INACTIVE
            LIKELY_FAKE -> Known.LIKELY_FAKE
            LIKELY_REAL -> Known.LIKELY_REAL
            TOO_NEW -> Known.TOO_NEW
            else -> throw XTwitterScraperInvalidDataException("Unknown FollowerClass: $value")
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
    fun validate(): FollowerClass = apply {
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

        return other is FollowerClass && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
