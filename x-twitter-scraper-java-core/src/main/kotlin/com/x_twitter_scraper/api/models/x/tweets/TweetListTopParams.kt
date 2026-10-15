// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.tweets

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

/**
 * Returns the tweets X ranks highest by 1 metric over the last day, week or month, as x.com's
 * Inspiration page shows them. Covers all of X unless you pick a country or a language. Pages hold
 * up to 20 tweets, and the list ends at 100. Each tweet costs 1 credit.
 */
class TweetListTopParams
private constructor(
    private val country: String?,
    private val cursor: String?,
    private val fields: String?,
    private val language: String?,
    private val metric: Metric?,
    private val omit: String?,
    private val pageSize: Long?,
    private val window: Window?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Only tweets from 1 country, as a 2- or 3-letter ISO 3166 code, such as US or USA. Send
     * country or language, not both.
     */
    fun country(): Optional<String> = Optional.ofNullable(country)

    /**
     * Pagination cursor for collection results. Also read as next_cursor, next_token,
     * pagination_token or continuation_token.
     */
    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    /**
     * Fields to keep in each row, comma-separated. Use dots for nested fields, such as
     * author.username. A list keeps the field in each item. Case & underscores do not matter. A row
     * that lacks a field leaves it out. Cursors, counts & diagnostics always stay. An unknown name
     * answers 400 unknown_field with the valid names, before any read. The price stays the same.
     * SDK row types then hold only the named fields.
     */
    fun fields(): Optional<String> = Optional.ofNullable(fields)

    /**
     * Only tweets in 1 language, as a 2-letter code, such as en. Send country or language, not
     * both.
     */
    fun language(): Optional<String> = Optional.ofNullable(language)

    /** What to rank tweets by. Defaults to likes. Singular names work too, such as like. */
    fun metric(): Optional<Metric> = Optional.ofNullable(metric)

    /**
     * Fields to drop from each row, comma-separated. It takes the same names as fields. With
     * fields, it drops from the kept fields.
     */
    fun omit(): Optional<String> = Optional.ofNullable(omit)

    /**
     * Items per page (1-100, default 20). Source, filters or credits can return fewer. Follow
     * next_cursor for more pages. Its aliases are limit, count, max_results, maxItems, max_items &
     * per_page.
     */
    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    /**
     * How far back to look. Defaults to day. Also takes 24h, 7d, 30d, daily, weekly and monthly.
     */
    fun window(): Optional<Window> = Optional.ofNullable(window)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): TweetListTopParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [TweetListTopParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TweetListTopParams]. */
    class Builder internal constructor() {

        private var country: String? = null
        private var cursor: String? = null
        private var fields: String? = null
        private var language: String? = null
        private var metric: Metric? = null
        private var omit: String? = null
        private var pageSize: Long? = null
        private var window: Window? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(tweetListTopParams: TweetListTopParams) = apply {
            country = tweetListTopParams.country
            cursor = tweetListTopParams.cursor
            fields = tweetListTopParams.fields
            language = tweetListTopParams.language
            metric = tweetListTopParams.metric
            omit = tweetListTopParams.omit
            pageSize = tweetListTopParams.pageSize
            window = tweetListTopParams.window
            additionalHeaders = tweetListTopParams.additionalHeaders.toBuilder()
            additionalQueryParams = tweetListTopParams.additionalQueryParams.toBuilder()
        }

        /**
         * Only tweets from 1 country, as a 2- or 3-letter ISO 3166 code, such as US or USA. Send
         * country or language, not both.
         */
        fun country(country: String?) = apply { this.country = country }

        /** Alias for calling [Builder.country] with `country.orElse(null)`. */
        fun country(country: Optional<String>) = country(country.getOrNull())

        /**
         * Pagination cursor for collection results. Also read as next_cursor, next_token,
         * pagination_token or continuation_token.
         */
        fun cursor(cursor: String?) = apply { this.cursor = cursor }

        /** Alias for calling [Builder.cursor] with `cursor.orElse(null)`. */
        fun cursor(cursor: Optional<String>) = cursor(cursor.getOrNull())

        /**
         * Fields to keep in each row, comma-separated. Use dots for nested fields, such as
         * author.username. A list keeps the field in each item. Case & underscores do not matter. A
         * row that lacks a field leaves it out. Cursors, counts & diagnostics always stay. An
         * unknown name answers 400 unknown_field with the valid names, before any read. The price
         * stays the same. SDK row types then hold only the named fields.
         */
        fun fields(fields: String?) = apply { this.fields = fields }

        /** Alias for calling [Builder.fields] with `fields.orElse(null)`. */
        fun fields(fields: Optional<String>) = fields(fields.getOrNull())

        /**
         * Only tweets in 1 language, as a 2-letter code, such as en. Send country or language, not
         * both.
         */
        fun language(language: String?) = apply { this.language = language }

        /** Alias for calling [Builder.language] with `language.orElse(null)`. */
        fun language(language: Optional<String>) = language(language.getOrNull())

        /** What to rank tweets by. Defaults to likes. Singular names work too, such as like. */
        fun metric(metric: Metric?) = apply { this.metric = metric }

        /** Alias for calling [Builder.metric] with `metric.orElse(null)`. */
        fun metric(metric: Optional<Metric>) = metric(metric.getOrNull())

        /**
         * Fields to drop from each row, comma-separated. It takes the same names as fields. With
         * fields, it drops from the kept fields.
         */
        fun omit(omit: String?) = apply { this.omit = omit }

        /** Alias for calling [Builder.omit] with `omit.orElse(null)`. */
        fun omit(omit: Optional<String>) = omit(omit.getOrNull())

        /**
         * Items per page (1-100, default 20). Source, filters or credits can return fewer. Follow
         * next_cursor for more pages. Its aliases are limit, count, max_results, maxItems,
         * max_items & per_page.
         */
        fun pageSize(pageSize: Long?) = apply { this.pageSize = pageSize }

        /** Alias for [Builder.pageSize]. */
        fun pageSize(pageSize: Long) = pageSize(pageSize as Long?)

        /** Alias for calling [Builder.pageSize] with `pageSize.orElse(null)`. */
        fun pageSize(pageSize: Optional<Long>) = pageSize(pageSize.getOrNull())

        /**
         * How far back to look. Defaults to day. Also takes 24h, 7d, 30d, daily, weekly and
         * monthly.
         */
        fun window(window: Window?) = apply { this.window = window }

        /** Alias for calling [Builder.window] with `window.orElse(null)`. */
        fun window(window: Optional<Window>) = window(window.getOrNull())

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
         * Returns an immutable instance of [TweetListTopParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): TweetListTopParams =
            TweetListTopParams(
                country,
                cursor,
                fields,
                language,
                metric,
                omit,
                pageSize,
                window,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                country?.let { put("country", it) }
                cursor?.let { put("cursor", it) }
                fields?.let { put("fields", it) }
                language?.let { put("language", it) }
                metric?.let { put("metric", it.toString()) }
                omit?.let { put("omit", it) }
                pageSize?.let { put("pageSize", it.toString()) }
                window?.let { put("window", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    class Metric @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val LIKES = of("likes")

            @JvmField val REPLIES = of("replies")

            @JvmField val QUOTES = of("quotes")

            @JvmField val BOOKMARKS = of("bookmarks")

            @JvmField val SHARES = of("shares")

            @JvmField val VIEWS = of("views")

            @JvmStatic fun of(value: String) = Metric(JsonField.of(value))
        }

        /** An enum containing [Metric]'s known values. */
        enum class Known {
            LIKES,
            REPLIES,
            QUOTES,
            BOOKMARKS,
            SHARES,
            VIEWS,
        }

        /**
         * An enum containing [Metric]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Metric] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            LIKES,
            REPLIES,
            QUOTES,
            BOOKMARKS,
            SHARES,
            VIEWS,
            /** An enum member indicating that [Metric] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         */
        fun value(): Value =
            when (this) {
                LIKES -> Value.LIKES
                REPLIES -> Value.REPLIES
                QUOTES -> Value.QUOTES
                BOOKMARKS -> Value.BOOKMARKS
                SHARES -> Value.SHARES
                VIEWS -> Value.VIEWS
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                LIKES -> Known.LIKES
                REPLIES -> Known.REPLIES
                QUOTES -> Known.QUOTES
                BOOKMARKS -> Known.BOOKMARKS
                SHARES -> Known.SHARES
                VIEWS -> Known.VIEWS
                else -> throw XTwitterScraperInvalidDataException("Unknown Metric: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): Metric = apply {
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

            return other is Metric && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class Window @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val DAY = of("day")

            @JvmField val WEEK = of("week")

            @JvmField val MONTH = of("month")

            @JvmStatic fun of(value: String) = Window(JsonField.of(value))
        }

        /** An enum containing [Window]'s known values. */
        enum class Known {
            DAY,
            WEEK,
            MONTH,
        }

        /**
         * An enum containing [Window]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Window] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            DAY,
            WEEK,
            MONTH,
            /** An enum member indicating that [Window] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         */
        fun value(): Value =
            when (this) {
                DAY -> Value.DAY
                WEEK -> Value.WEEK
                MONTH -> Value.MONTH
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                DAY -> Known.DAY
                WEEK -> Known.WEEK
                MONTH -> Known.MONTH
                else -> throw XTwitterScraperInvalidDataException("Unknown Window: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): Window = apply {
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

            return other is Window && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TweetListTopParams &&
            country == other.country &&
            cursor == other.cursor &&
            fields == other.fields &&
            language == other.language &&
            metric == other.metric &&
            omit == other.omit &&
            pageSize == other.pageSize &&
            window == other.window &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            country,
            cursor,
            fields,
            language,
            metric,
            omit,
            pageSize,
            window,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "TweetListTopParams{country=$country, cursor=$cursor, fields=$fields, language=$language, metric=$metric, omit=$omit, pageSize=$pageSize, window=$window, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
