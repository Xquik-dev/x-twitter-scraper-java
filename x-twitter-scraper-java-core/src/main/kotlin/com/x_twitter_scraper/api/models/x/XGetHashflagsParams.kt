// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x

import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Returns X's hashflags, the custom emoji X shows after some hashtags. Lists the ones running now
 * unless activeOnly is false. Each returned hashflag costs 1 credit.
 */
class XGetHashflagsParams
private constructor(
    private val activeOnly: Boolean?,
    private val fields: String?,
    private val limit: Long?,
    private val omit: String?,
    private val q: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Keeps hashflags that run now. Send false to add ended & upcoming ones. */
    fun activeOnly(): Optional<Boolean> = Optional.ofNullable(activeOnly)

    /**
     * Fields to keep in each row, comma-separated. Use dots for nested fields, such as
     * author.username. A list keeps the field in each item. Case & underscores do not matter. A row
     * that lacks a field leaves it out. Cursors, counts & diagnostics always stay. An unknown name
     * answers 400 unknown_field with the valid names, before any read. The price stays the same.
     * SDK row types then hold only the named fields.
     */
    fun fields(): Optional<String> = Optional.ofNullable(fields)

    /**
     * Maximum hashflags to return. Omit it for every match. A low credit balance can return fewer.
     * Aliases pageSize, count, max_results, maxItems, max_items & per_page.
     */
    fun limit(): Optional<Long> = Optional.ofNullable(limit)

    /**
     * Fields to drop from each row, comma-separated. It takes the same names as fields. With
     * fields, it drops from the kept fields.
     */
    fun omit(): Optional<String> = Optional.ofNullable(omit)

    /**
     * Text the hashtag contains, such as football. Case insensitive. A leading hash sign is
     * ignored. Alias query.
     */
    fun q(): Optional<String> = Optional.ofNullable(q)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): XGetHashflagsParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [XGetHashflagsParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [XGetHashflagsParams]. */
    class Builder internal constructor() {

        private var activeOnly: Boolean? = null
        private var fields: String? = null
        private var limit: Long? = null
        private var omit: String? = null
        private var q: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(xGetHashflagsParams: XGetHashflagsParams) = apply {
            activeOnly = xGetHashflagsParams.activeOnly
            fields = xGetHashflagsParams.fields
            limit = xGetHashflagsParams.limit
            omit = xGetHashflagsParams.omit
            q = xGetHashflagsParams.q
            additionalHeaders = xGetHashflagsParams.additionalHeaders.toBuilder()
            additionalQueryParams = xGetHashflagsParams.additionalQueryParams.toBuilder()
        }

        /** Keeps hashflags that run now. Send false to add ended & upcoming ones. */
        fun activeOnly(activeOnly: Boolean?) = apply { this.activeOnly = activeOnly }

        /** Alias for [Builder.activeOnly]. */
        fun activeOnly(activeOnly: Boolean) = activeOnly(activeOnly as Boolean?)

        /** Alias for calling [Builder.activeOnly] with `activeOnly.orElse(null)`. */
        fun activeOnly(activeOnly: Optional<Boolean>) = activeOnly(activeOnly.getOrNull())

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
         * Maximum hashflags to return. Omit it for every match. A low credit balance can return
         * fewer. Aliases pageSize, count, max_results, maxItems, max_items & per_page.
         */
        fun limit(limit: Long?) = apply { this.limit = limit }

        /** Alias for [Builder.limit]. */
        fun limit(limit: Long) = limit(limit as Long?)

        /** Alias for calling [Builder.limit] with `limit.orElse(null)`. */
        fun limit(limit: Optional<Long>) = limit(limit.getOrNull())

        /**
         * Fields to drop from each row, comma-separated. It takes the same names as fields. With
         * fields, it drops from the kept fields.
         */
        fun omit(omit: String?) = apply { this.omit = omit }

        /** Alias for calling [Builder.omit] with `omit.orElse(null)`. */
        fun omit(omit: Optional<String>) = omit(omit.getOrNull())

        /**
         * Text the hashtag contains, such as football. Case insensitive. A leading hash sign is
         * ignored. Alias query.
         */
        fun q(q: String?) = apply { this.q = q }

        /** Alias for calling [Builder.q] with `q.orElse(null)`. */
        fun q(q: Optional<String>) = q(q.getOrNull())

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
         * Returns an immutable instance of [XGetHashflagsParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): XGetHashflagsParams =
            XGetHashflagsParams(
                activeOnly,
                fields,
                limit,
                omit,
                q,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                activeOnly?.let { put("activeOnly", it.toString()) }
                fields?.let { put("fields", it) }
                limit?.let { put("limit", it.toString()) }
                omit?.let { put("omit", it) }
                q?.let { put("q", it) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is XGetHashflagsParams &&
            activeOnly == other.activeOnly &&
            fields == other.fields &&
            limit == other.limit &&
            omit == other.omit &&
            q == other.q &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(activeOnly, fields, limit, omit, q, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "XGetHashflagsParams{activeOnly=$activeOnly, fields=$fields, limit=$limit, omit=$omit, q=$q, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
