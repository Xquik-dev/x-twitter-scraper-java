// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.sports

import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Returns the player prop lines & American odds X shows for 1 NFL game. X lists props before & during a game. Other games return no categories. Each request costs 1 credit. */
class SportRetrievePlayerPropsParams
private constructor(
    private val league: String,
    private val id: String?,
    private val fields: String?,
    private val omit: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** nfl, in any case. X has no college rosters or props, so ncaafb gets a free 400 `unsupported_league`. Another value gets a free 400 `invalid_league`. Both come before X is read. */
    fun league(): String = league

    /** Game ID, a number up to 19 digits. GET /x/sports/{league}/games lists them. Another value gets a free 400 `invalid_game_id` before X is read. */
    fun id(): Optional<String> = Optional.ofNullable(id)

    /** Fields to keep in each row, comma-separated. Use dots for nested fields, such as author.username. A list keeps the field in each item. Case & underscores do not matter. A row that lacks a field leaves it out. Cursors, counts & diagnostics always stay. An unknown name answers 400 unknown_field with the valid names, before any read. The price stays the same. A required getter throws when you leave its field out, and response validation fails. */
    fun fields(): Optional<String> = Optional.ofNullable(fields)

    /** Fields to drop from each row, comma-separated. It takes the same names as fields. With fields, it drops from the kept fields. */
    fun omit(): Optional<String> = Optional.ofNullable(omit)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [SportRetrievePlayerPropsParams].
         *
         * The following fields are required:
         * ```java
         * .league()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SportRetrievePlayerPropsParams]. */
    class Builder internal constructor() {

        private var league: String? = null
        private var id: String? = null
        private var fields: String? = null
        private var omit: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic internal fun from(sportRetrievePlayerPropsParams: SportRetrievePlayerPropsParams) = apply {
            league = sportRetrievePlayerPropsParams.league
            id = sportRetrievePlayerPropsParams.id
            fields = sportRetrievePlayerPropsParams.fields
            omit = sportRetrievePlayerPropsParams.omit
            additionalHeaders = sportRetrievePlayerPropsParams.additionalHeaders.toBuilder()
            additionalQueryParams = sportRetrievePlayerPropsParams.additionalQueryParams.toBuilder()
        }

        /** nfl, in any case. X has no college rosters or props, so ncaafb gets a free 400 `unsupported_league`. Another value gets a free 400 `invalid_league`. Both come before X is read. */
        fun league(league: String) = apply { this.league = league }

        /** Game ID, a number up to 19 digits. GET /x/sports/{league}/games lists them. Another value gets a free 400 `invalid_game_id` before X is read. */
        fun id(id: String?) = apply { this.id = id }

        /** Alias for calling [Builder.id] with `id.orElse(null)`. */
        fun id(id: Optional<String>) = id(id.getOrNull())

        /** Fields to keep in each row, comma-separated. Use dots for nested fields, such as author.username. A list keeps the field in each item. Case & underscores do not matter. A row that lacks a field leaves it out. Cursors, counts & diagnostics always stay. An unknown name answers 400 unknown_field with the valid names, before any read. The price stays the same. A required getter throws when you leave its field out, and response validation fails. */
        fun fields(fields: String?) = apply { this.fields = fields }

        /** Alias for calling [Builder.fields] with `fields.orElse(null)`. */
        fun fields(fields: Optional<String>) = fields(fields.getOrNull())

        /** Fields to drop from each row, comma-separated. It takes the same names as fields. With fields, it drops from the kept fields. */
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
         * Returns an immutable instance of [SportRetrievePlayerPropsParams].
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
        fun build(): SportRetrievePlayerPropsParams =
            SportRetrievePlayerPropsParams(
                checkRequired("league", league),
                id,
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
                fields?.let { put("fields", it) }
                omit?.let { put("omit", it) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SportRetrievePlayerPropsParams &&
            league == other.league &&
            id == other.id &&
            fields == other.fields &&
            omit == other.omit &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(league, id, fields, omit, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "SportRetrievePlayerPropsParams{league=$league, id=$id, fields=$fields, omit=$omit, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
