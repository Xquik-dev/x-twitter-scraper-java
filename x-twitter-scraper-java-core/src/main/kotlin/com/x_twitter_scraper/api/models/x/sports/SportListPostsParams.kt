// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.sports

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

/**
 * Returns a game's top or latest posts, plus an X search you can run for more. Works before, during
 * & after the game. Pages hold up to 20 posts, & each post costs 1 credit.
 */
class SportListPostsParams
private constructor(
    private val league: String,
    private val id: String?,
    private val queryType: QueryType?,
    private val cursor: String?,
    private val pageSize: Long?,
    private val fields: String?,
    private val omit: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * nfl for the NFL or ncaafb for college football, in any case. Another value gets a free 400
     * `invalid_league` before X is read.
     */
    fun league(): String = league

    /**
     * Game ID, a number up to 19 digits. GET /x/sports/{league}/games lists them. Another value
     * gets a free 400 `invalid_game_id` before X is read.
     */
    fun id(): Optional<String> = Optional.ofNullable(id)

    /**
     * Top for the posts X ranks highest, or Latest for the newest. Any case works, & so do
     * Relevance & Recency. Alias order or sort. Send the same value with each cursor.
     */
    fun queryType(): Optional<QueryType> = Optional.ofNullable(queryType)

    /**
     * Pagination cursor for collection results. Also read as next_cursor, next_token,
     * pagination_token or continuation_token.
     */
    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    /**
     * Items per page (1-100, default 20). Source, filters or credits can return fewer. Follow
     * next_cursor for more pages. Its aliases are limit, count, max_results, maxItems, max_items &
     * per_page.
     */
    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    /**
     * Fields to keep in each row, comma-separated. Use dots for nested fields, such as
     * author.username. A list keeps the field in each item. Case & underscores do not matter. A row
     * that lacks a field leaves it out. Cursors, counts & diagnostics always stay. An unknown name
     * answers 400 unknown_field with the valid names, before any read. The price stays the same. A
     * required getter throws when you leave its field out, and response validation fails.
     */
    fun fields(): Optional<String> = Optional.ofNullable(fields)

    /**
     * Fields to drop from each row, comma-separated. It takes the same names as fields. With
     * fields, it drops from the kept fields.
     */
    fun omit(): Optional<String> = Optional.ofNullable(omit)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [SportListPostsParams].
         *
         * The following fields are required:
         * ```java
         * .league()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SportListPostsParams]. */
    class Builder internal constructor() {

        private var league: String? = null
        private var id: String? = null
        private var queryType: QueryType? = null
        private var cursor: String? = null
        private var pageSize: Long? = null
        private var fields: String? = null
        private var omit: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(sportListPostsParams: SportListPostsParams) = apply {
            league = sportListPostsParams.league
            id = sportListPostsParams.id
            queryType = sportListPostsParams.queryType
            cursor = sportListPostsParams.cursor
            pageSize = sportListPostsParams.pageSize
            fields = sportListPostsParams.fields
            omit = sportListPostsParams.omit
            additionalHeaders = sportListPostsParams.additionalHeaders.toBuilder()
            additionalQueryParams = sportListPostsParams.additionalQueryParams.toBuilder()
        }

        /**
         * nfl for the NFL or ncaafb for college football, in any case. Another value gets a free
         * 400 `invalid_league` before X is read.
         */
        fun league(league: String) = apply { this.league = league }

        /**
         * Game ID, a number up to 19 digits. GET /x/sports/{league}/games lists them. Another value
         * gets a free 400 `invalid_game_id` before X is read.
         */
        fun id(id: String?) = apply { this.id = id }

        /** Alias for calling [Builder.id] with `id.orElse(null)`. */
        fun id(id: Optional<String>) = id(id.getOrNull())

        /**
         * Top for the posts X ranks highest, or Latest for the newest. Any case works, & so do
         * Relevance & Recency. Alias order or sort. Send the same value with each cursor.
         */
        fun queryType(queryType: QueryType?) = apply { this.queryType = queryType }

        /** Alias for calling [Builder.queryType] with `queryType.orElse(null)`. */
        fun queryType(queryType: Optional<QueryType>) = queryType(queryType.getOrNull())

        /**
         * Pagination cursor for collection results. Also read as next_cursor, next_token,
         * pagination_token or continuation_token.
         */
        fun cursor(cursor: String?) = apply { this.cursor = cursor }

        /** Alias for calling [Builder.cursor] with `cursor.orElse(null)`. */
        fun cursor(cursor: Optional<String>) = cursor(cursor.getOrNull())

        /**
         * Items per page (1-100, default 20). Source, filters or credits can return fewer. Follow
         * next_cursor for more pages. Its aliases are limit, count, max_results, maxItems,
         * max_items & per_page.
         */
        fun pageSize(pageSize: Long?) = apply { this.pageSize = pageSize }

        /**
         * Alias for [Builder.pageSize].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun pageSize(pageSize: Long) = pageSize(pageSize as Long?)

        /** Alias for calling [Builder.pageSize] with `pageSize.orElse(null)`. */
        fun pageSize(pageSize: Optional<Long>) = pageSize(pageSize.getOrNull())

        /**
         * Fields to keep in each row, comma-separated. Use dots for nested fields, such as
         * author.username. A list keeps the field in each item. Case & underscores do not matter. A
         * row that lacks a field leaves it out. Cursors, counts & diagnostics always stay. An
         * unknown name answers 400 unknown_field with the valid names, before any read. The price
         * stays the same. A required getter throws when you leave its field out, and response
         * validation fails.
         */
        fun fields(fields: String?) = apply { this.fields = fields }

        /** Alias for calling [Builder.fields] with `fields.orElse(null)`. */
        fun fields(fields: Optional<String>) = fields(fields.getOrNull())

        /**
         * Fields to drop from each row, comma-separated. It takes the same names as fields. With
         * fields, it drops from the kept fields.
         */
        fun omit(omit: String?) = apply { this.omit = omit }

        /** Alias for calling [Builder.omit] with `omit.orElse(null)`. */
        fun omit(omit: Optional<String>) = omit(omit.getOrNull())

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
         * Returns an immutable instance of [SportListPostsParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .league()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SportListPostsParams =
            SportListPostsParams(
                checkRequired("league", league),
                id,
                queryType,
                cursor,
                pageSize,
                fields,
                omit,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> league
            1 -> id ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                queryType?.let { put("queryType", it.toString()) }
                cursor?.let { put("cursor", it) }
                pageSize?.let { put("pageSize", it.toString()) }
                fields?.let { put("fields", it) }
                omit?.let { put("omit", it) }
                putAll(additionalQueryParams)
            }
            .build()

    /**
     * Top for the posts X ranks highest, or Latest for the newest. Any case works, & so do
     * Relevance & Recency. Alias order or sort. Send the same value with each cursor.
     */
    class QueryType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val TOP = of("Top")

            @JvmField val LATEST = of("Latest")

            @JvmStatic fun of(value: String) = QueryType(JsonField.of(value))
        }

        /** An enum containing [QueryType]'s known values. */
        enum class Known {
            TOP,
            LATEST,
        }

        /** An enum containing [QueryType]'s known values, as well as an [_UNKNOWN] member. */
        enum class Value {
            TOP,
            LATEST,
            /**
             * An enum member indicating that [QueryType] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if unknown.
         */
        fun value(): Value =
            when (this) {
                TOP -> Value.TOP
                LATEST -> Value.LATEST
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
                TOP -> Known.TOP
                LATEST -> Known.LATEST
                else -> throw XTwitterScraperInvalidDataException("Unknown QueryType: $value")
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

        /** Validates that this value is a known member. */
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

        return other is SportListPostsParams &&
            league == other.league &&
            id == other.id &&
            queryType == other.queryType &&
            cursor == other.cursor &&
            pageSize == other.pageSize &&
            fields == other.fields &&
            omit == other.omit &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            league,
            id,
            queryType,
            cursor,
            pageSize,
            fields,
            omit,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "SportListPostsParams{league=$league, id=$id, queryType=$queryType, cursor=$cursor, pageSize=$pageSize, fields=$fields, omit=$omit, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
