// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException

class EventType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val TWEET_NEW = of("tweet.new")

        @JvmField val TWEET_REPLY = of("tweet.reply")

        @JvmField val TWEET_RETWEET = of("tweet.retweet")

        @JvmField val TWEET_QUOTE = of("tweet.quote")

        @JvmField val FOLLOWER_GAINED = of("follower.gained")

        @JvmField val FOLLOWER_LOST = of("follower.lost")

        @JvmStatic fun of(value: String) = EventType(JsonField.of(value))
    }

    /** An enum containing [EventType]'s known values. */
    enum class Known {
        TWEET_NEW,
        TWEET_REPLY,
        TWEET_RETWEET,
        TWEET_QUOTE,
        FOLLOWER_GAINED,
        FOLLOWER_LOST,
    }

    /**
     * An enum containing [EventType]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [EventType] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        TWEET_NEW,
        TWEET_REPLY,
        TWEET_RETWEET,
        TWEET_QUOTE,
        FOLLOWER_GAINED,
        FOLLOWER_LOST,
        /** An enum member indicating that [EventType] was instantiated with an unknown value. */
        _UNKNOWN,
    }

    /**
     * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if
     * the class was instantiated with an unknown value.
     *
     * Use the [known] method instead if you're certain the value is always known or if you want to
     * throw for the unknown case.
     */
    fun value(): Value =
        when (this) {
            TWEET_NEW -> Value.TWEET_NEW
            TWEET_REPLY -> Value.TWEET_REPLY
            TWEET_RETWEET -> Value.TWEET_RETWEET
            TWEET_QUOTE -> Value.TWEET_QUOTE
            FOLLOWER_GAINED -> Value.FOLLOWER_GAINED
            FOLLOWER_LOST -> Value.FOLLOWER_LOST
            else -> Value._UNKNOWN
        }

    /**
     * Returns an enum member corresponding to this class instance's value.
     *
     * Use the [value] method instead if you're uncertain the value is always known and don't want
     * to throw for the unknown case.
     *
     * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a known
     *   member.
     */
    fun known(): Known =
        when (this) {
            TWEET_NEW -> Known.TWEET_NEW
            TWEET_REPLY -> Known.TWEET_REPLY
            TWEET_RETWEET -> Known.TWEET_RETWEET
            TWEET_QUOTE -> Known.TWEET_QUOTE
            FOLLOWER_GAINED -> Known.FOLLOWER_GAINED
            FOLLOWER_LOST -> Known.FOLLOWER_LOST
            else -> throw XTwitterScraperInvalidDataException("Unknown EventType: $value")
        }

    /**
     * Returns this class instance's primitive wire representation.
     *
     * This differs from the [toString] method because that method is primarily for debugging and
     * generally doesn't throw.
     *
     * @throws XTwitterScraperInvalidDataException if this class instance's value does not have the
     *   expected primitive type.
     */
    fun asString(): String =
        _value().asString().orElseThrow {
            XTwitterScraperInvalidDataException("Value is not a String")
        }

    private var validated: Boolean = false

    fun validate(): EventType = apply {
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

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is EventType && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
