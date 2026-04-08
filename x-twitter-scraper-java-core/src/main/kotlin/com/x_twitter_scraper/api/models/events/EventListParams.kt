// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.events

import com.fasterxml.jackson.annotation.JsonCreator
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** List events */
class EventListParams
private constructor(
    private val after: String?,
    private val eventType: EventType?,
    private val limit: Long?,
    private val monitorId: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Cursor for keyset pagination */
    fun after(): Optional<String> = Optional.ofNullable(after)

    /** Filter events by type */
    fun eventType(): Optional<EventType> = Optional.ofNullable(eventType)

    /** Maximum number of items to return (1-100, default 50) */
    fun limit(): Optional<Long> = Optional.ofNullable(limit)

    /** Filter events by monitor ID */
    fun monitorId(): Optional<String> = Optional.ofNullable(monitorId)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): EventListParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [EventListParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [EventListParams]. */
    class Builder internal constructor() {

        private var after: String? = null
        private var eventType: EventType? = null
        private var limit: Long? = null
        private var monitorId: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(eventListParams: EventListParams) = apply {
            after = eventListParams.after
            eventType = eventListParams.eventType
            limit = eventListParams.limit
            monitorId = eventListParams.monitorId
            additionalHeaders = eventListParams.additionalHeaders.toBuilder()
            additionalQueryParams = eventListParams.additionalQueryParams.toBuilder()
        }

        /** Cursor for keyset pagination */
        fun after(after: String?) = apply { this.after = after }

        /** Alias for calling [Builder.after] with `after.orElse(null)`. */
        fun after(after: Optional<String>) = after(after.getOrNull())

        /** Filter events by type */
        fun eventType(eventType: EventType?) = apply { this.eventType = eventType }

        /** Alias for calling [Builder.eventType] with `eventType.orElse(null)`. */
        fun eventType(eventType: Optional<EventType>) = eventType(eventType.getOrNull())

        /** Maximum number of items to return (1-100, default 50) */
        fun limit(limit: Long?) = apply { this.limit = limit }

        /**
         * Alias for [Builder.limit].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun limit(limit: Long) = limit(limit as Long?)

        /** Alias for calling [Builder.limit] with `limit.orElse(null)`. */
        fun limit(limit: Optional<Long>) = limit(limit.getOrNull())

        /** Filter events by monitor ID */
        fun monitorId(monitorId: String?) = apply { this.monitorId = monitorId }

        /** Alias for calling [Builder.monitorId] with `monitorId.orElse(null)`. */
        fun monitorId(monitorId: Optional<String>) = monitorId(monitorId.getOrNull())

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [EventListParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): EventListParams =
            EventListParams(
                after,
                eventType,
                limit,
                monitorId,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                after?.let { put("after", it) }
                eventType?.let { put("eventType", it.toString()) }
                limit?.let { put("limit", it.toString()) }
                monitorId?.let { put("monitorId", it) }
                putAll(additionalQueryParams)
            }
            .build()

    /** Filter events by type */
    class EventType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
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
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            TWEET_NEW,
            TWEET_REPLY,
            TWEET_RETWEET,
            TWEET_QUOTE,
            FOLLOWER_GAINED,
            FOLLOWER_LOST,
            /**
             * An enum member indicating that [EventType] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
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
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
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
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is EventListParams &&
            after == other.after &&
            eventType == other.eventType &&
            limit == other.limit &&
            monitorId == other.monitorId &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(after, eventType, limit, monitorId, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "EventListParams{after=$after, eventType=$eventType, limit=$limit, monitorId=$monitorId, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
