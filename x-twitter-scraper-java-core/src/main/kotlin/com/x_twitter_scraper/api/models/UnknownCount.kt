// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException

/** A count X did not send for a post. */
class UnknownCount @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

    /** Returns this class instance's raw value. */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val RETWEET_COUNT = of("retweetCount")

        @JvmField val REPLY_COUNT = of("replyCount")

        @JvmField val LIKE_COUNT = of("likeCount")

        @JvmField val QUOTE_COUNT = of("quoteCount")

        @JvmField val VIEW_COUNT = of("viewCount")

        @JvmField val BOOKMARK_COUNT = of("bookmarkCount")

        @JvmStatic fun of(value: String) = UnknownCount(JsonField.of(value))
    }

    /** An enum containing [UnknownCount]'s known values. */
    enum class Known {
        RETWEET_COUNT,
        REPLY_COUNT,
        LIKE_COUNT,
        QUOTE_COUNT,
        VIEW_COUNT,
        BOOKMARK_COUNT,
    }

    /**
     * An enum containing [UnknownCount]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [UnknownCount] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        RETWEET_COUNT,
        REPLY_COUNT,
        LIKE_COUNT,
        QUOTE_COUNT,
        VIEW_COUNT,
        BOOKMARK_COUNT,
        /** An enum member indicating that [UnknownCount] was instantiated with an unknown value. */
        _UNKNOWN,
    }

    /**
     * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if
     * the class was instantiated with an unknown value.
     */
    fun value(): Value =
        when (this) {
            RETWEET_COUNT -> Value.RETWEET_COUNT
            REPLY_COUNT -> Value.REPLY_COUNT
            LIKE_COUNT -> Value.LIKE_COUNT
            QUOTE_COUNT -> Value.QUOTE_COUNT
            VIEW_COUNT -> Value.VIEW_COUNT
            BOOKMARK_COUNT -> Value.BOOKMARK_COUNT
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
            RETWEET_COUNT -> Known.RETWEET_COUNT
            REPLY_COUNT -> Known.REPLY_COUNT
            LIKE_COUNT -> Known.LIKE_COUNT
            QUOTE_COUNT -> Known.QUOTE_COUNT
            VIEW_COUNT -> Known.VIEW_COUNT
            BOOKMARK_COUNT -> Known.BOOKMARK_COUNT
            else -> throw XTwitterScraperInvalidDataException("Unknown UnknownCount: $value")
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

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match
     *   its expected type.
     */
    fun validate(): UnknownCount = apply {
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

        return other is UnknownCount && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
