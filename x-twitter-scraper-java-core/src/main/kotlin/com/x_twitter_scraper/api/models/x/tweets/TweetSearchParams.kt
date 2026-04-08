// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.annotation.JsonCreator
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Search tweets */
class TweetSearchParams
private constructor(
    private val q: String,
    private val cursor: String?,
    private val limit: Long?,
    private val queryType: QueryType?,
    private val sinceTime: String?,
    private val untilTime: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Search query (keywords, */
    fun q(): String = q

    /** Pagination cursor from previous response */
    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    /** Max tweets to return (server paginates internally). Omit for single page (~20). */
    fun limit(): Optional<Long> = Optional.ofNullable(limit)

    /** Sort order — Latest (chronological) or Top (engagement-ranked) */
    fun queryType(): Optional<QueryType> = Optional.ofNullable(queryType)

    /** ISO 8601 timestamp — only return tweets after this time */
    fun sinceTime(): Optional<String> = Optional.ofNullable(sinceTime)

    /** ISO 8601 timestamp — only return tweets before this time */
    fun untilTime(): Optional<String> = Optional.ofNullable(untilTime)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TweetSearchParams].
         *
         * The following fields are required:
         * ```java
         * .q()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TweetSearchParams]. */
    class Builder internal constructor() {

        private var q: String? = null
        private var cursor: String? = null
        private var limit: Long? = null
        private var queryType: QueryType? = null
        private var sinceTime: String? = null
        private var untilTime: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(tweetSearchParams: TweetSearchParams) = apply {
            q = tweetSearchParams.q
            cursor = tweetSearchParams.cursor
            limit = tweetSearchParams.limit
            queryType = tweetSearchParams.queryType
            sinceTime = tweetSearchParams.sinceTime
            untilTime = tweetSearchParams.untilTime
            additionalHeaders = tweetSearchParams.additionalHeaders.toBuilder()
            additionalQueryParams = tweetSearchParams.additionalQueryParams.toBuilder()
        }

        /** Search query (keywords, */
        fun q(q: String) = apply { this.q = q }

        /** Pagination cursor from previous response */
        fun cursor(cursor: String?) = apply { this.cursor = cursor }

        /** Alias for calling [Builder.cursor] with `cursor.orElse(null)`. */
        fun cursor(cursor: Optional<String>) = cursor(cursor.getOrNull())

        /** Max tweets to return (server paginates internally). Omit for single page (~20). */
        fun limit(limit: Long?) = apply { this.limit = limit }

        /**
         * Alias for [Builder.limit].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun limit(limit: Long) = limit(limit as Long?)

        /** Alias for calling [Builder.limit] with `limit.orElse(null)`. */
        fun limit(limit: Optional<Long>) = limit(limit.getOrNull())

        /** Sort order — Latest (chronological) or Top (engagement-ranked) */
        fun queryType(queryType: QueryType?) = apply { this.queryType = queryType }

        /** Alias for calling [Builder.queryType] with `queryType.orElse(null)`. */
        fun queryType(queryType: Optional<QueryType>) = queryType(queryType.getOrNull())

        /** ISO 8601 timestamp — only return tweets after this time */
        fun sinceTime(sinceTime: String?) = apply { this.sinceTime = sinceTime }

        /** Alias for calling [Builder.sinceTime] with `sinceTime.orElse(null)`. */
        fun sinceTime(sinceTime: Optional<String>) = sinceTime(sinceTime.getOrNull())

        /** ISO 8601 timestamp — only return tweets before this time */
        fun untilTime(untilTime: String?) = apply { this.untilTime = untilTime }

        /** Alias for calling [Builder.untilTime] with `untilTime.orElse(null)`. */
        fun untilTime(untilTime: Optional<String>) = untilTime(untilTime.getOrNull())

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
         * Returns an immutable instance of [TweetSearchParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .q()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TweetSearchParams =
            TweetSearchParams(
                checkRequired("q", q),
                cursor,
                limit,
                queryType,
                sinceTime,
                untilTime,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                put("q", q)
                cursor?.let { put("cursor", it) }
                limit?.let { put("limit", it.toString()) }
                queryType?.let { put("queryType", it.toString()) }
                sinceTime?.let { put("sinceTime", it) }
                untilTime?.let { put("untilTime", it) }
                putAll(additionalQueryParams)
            }
            .build()

    /** Sort order — Latest (chronological) or Top (engagement-ranked) */
    class QueryType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val LATEST = of("Latest")

            @JvmField val TOP = of("Top")

            @JvmStatic fun of(value: String) = QueryType(JsonField.of(value))
        }

        /** An enum containing [QueryType]'s known values. */
        enum class Known {
            LATEST,
            TOP,
        }

        /**
         * An enum containing [QueryType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [QueryType] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            LATEST,
            TOP,
            /**
             * An enum member indicating that [QueryType] was instantiated with an unknown value.
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
                LATEST -> Value.LATEST
                TOP -> Value.TOP
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
                LATEST -> Known.LATEST
                TOP -> Known.TOP
                else -> throw XTwitterScraperInvalidDataException("Unknown QueryType: $value")
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

        fun validate(): QueryType = apply {
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

            return other is QueryType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TweetSearchParams &&
            q == other.q &&
            cursor == other.cursor &&
            limit == other.limit &&
            queryType == other.queryType &&
            sinceTime == other.sinceTime &&
            untilTime == other.untilTime &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            q,
            cursor,
            limit,
            queryType,
            sinceTime,
            untilTime,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "TweetSearchParams{q=$q, cursor=$cursor, limit=$limit, queryType=$queryType, sinceTime=$sinceTime, untilTime=$untilTime, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
