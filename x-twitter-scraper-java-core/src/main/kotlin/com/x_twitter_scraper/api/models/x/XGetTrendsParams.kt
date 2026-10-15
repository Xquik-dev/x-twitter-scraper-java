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
 * Returns X's current trends for a place you choose. Pick it by woeid, country or location name.
 * Without one, trends are worldwide. Add at to read what was trending on Twitter at a past time,
 * such as yesterday. Xquik keeps a Twitter trends archive from 2026-10-13 02:20 UTC on, with 1 list
 * per place every 5 minutes. Each request costs 1 credit, however many trends it returns.
 */
class XGetTrendsParams
private constructor(
    private val at: String?,
    private val count: Long?,
    private val country: String?,
    private val fields: String?,
    private val location: String?,
    private val omit: String?,
    private val woeid: Long?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * A past time, to read what was trending on Twitter then. Takes an ISO 8601 time, a date such
     * as 2026-10-13, or Unix seconds. A time without a zone reads as UTC. It also takes a span back
     * from now, as a number & s, m, h or d. So at=24h reads what was trending on Twitter yesterday
     * at this hour, on every run of a schedule. The answer is the stored list nearest that time,
     * with its own time in capturedAt. History starts 2026-10-13 02:20 UTC. A time over 24 hours
     * from every stored list answers 400 at no charge.
     */
    fun at(): Optional<String> = Optional.ofNullable(at)

    /** Number of trending topics to return (1-50, default 30) */
    fun count(): Optional<Long> = Optional.ofNullable(count)

    /**
     * Country to read trends for, by name or 2-letter code, such as Turkey or TR. Case insensitive.
     */
    fun country(): Optional<String> = Optional.ofNullable(country)

    /**
     * Fields to keep in each row, comma-separated. Use dots for nested fields, such as
     * author.username. A list keeps the field in each item. Case & underscores do not matter. A row
     * that lacks a field leaves it out. Cursors, counts & diagnostics always stay. An unknown name
     * answers 400 unknown_field with the valid names, before any read. The price stays the same.
     * SDK row types then hold only the named fields.
     */
    fun fields(): Optional<String> = Optional.ofNullable(fields)

    /**
     * Town or country to read trends for, by name, such as Istanbul. Case insensitive. Add country
     * when 2 towns share a name. /x/trends/locations lists every name.
     */
    fun location(): Optional<String> = Optional.ofNullable(location)

    /**
     * Fields to drop from each row, comma-separated. It takes the same names as fields. With
     * fields, it drops from the kept fields.
     */
    fun omit(): Optional<String> = Optional.ofNullable(omit)

    /**
     * Region WOEID (1=Worldwide, 23424977=US, 23424975=UK, 23424969=Turkey). Wins over country &
     * location.
     */
    fun woeid(): Optional<Long> = Optional.ofNullable(woeid)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): XGetTrendsParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [XGetTrendsParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [XGetTrendsParams]. */
    class Builder internal constructor() {

        private var at: String? = null
        private var count: Long? = null
        private var country: String? = null
        private var fields: String? = null
        private var location: String? = null
        private var omit: String? = null
        private var woeid: Long? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(xGetTrendsParams: XGetTrendsParams) = apply {
            at = xGetTrendsParams.at
            count = xGetTrendsParams.count
            country = xGetTrendsParams.country
            fields = xGetTrendsParams.fields
            location = xGetTrendsParams.location
            omit = xGetTrendsParams.omit
            woeid = xGetTrendsParams.woeid
            additionalHeaders = xGetTrendsParams.additionalHeaders.toBuilder()
            additionalQueryParams = xGetTrendsParams.additionalQueryParams.toBuilder()
        }

        /**
         * A past time, to read what was trending on Twitter then. Takes an ISO 8601 time, a date
         * such as 2026-10-13, or Unix seconds. A time without a zone reads as UTC. It also takes a
         * span back from now, as a number & s, m, h or d. So at=24h reads what was trending on
         * Twitter yesterday at this hour, on every run of a schedule. The answer is the stored list
         * nearest that time, with its own time in capturedAt. History starts 2026-10-13 02:20 UTC.
         * A time over 24 hours from every stored list answers 400 at no charge.
         */
        fun at(at: String?) = apply { this.at = at }

        /** Alias for calling [Builder.at] with `at.orElse(null)`. */
        fun at(at: Optional<String>) = at(at.getOrNull())

        /** Number of trending topics to return (1-50, default 30) */
        fun count(count: Long?) = apply { this.count = count }

        /** Alias for [Builder.count]. */
        fun count(count: Long) = count(count as Long?)

        /** Alias for calling [Builder.count] with `count.orElse(null)`. */
        fun count(count: Optional<Long>) = count(count.getOrNull())

        /**
         * Country to read trends for, by name or 2-letter code, such as Turkey or TR. Case
         * insensitive.
         */
        fun country(country: String?) = apply { this.country = country }

        /** Alias for calling [Builder.country] with `country.orElse(null)`. */
        fun country(country: Optional<String>) = country(country.getOrNull())

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
         * Town or country to read trends for, by name, such as Istanbul. Case insensitive. Add
         * country when 2 towns share a name. /x/trends/locations lists every name.
         */
        fun location(location: String?) = apply { this.location = location }

        /** Alias for calling [Builder.location] with `location.orElse(null)`. */
        fun location(location: Optional<String>) = location(location.getOrNull())

        /**
         * Fields to drop from each row, comma-separated. It takes the same names as fields. With
         * fields, it drops from the kept fields.
         */
        fun omit(omit: String?) = apply { this.omit = omit }

        /** Alias for calling [Builder.omit] with `omit.orElse(null)`. */
        fun omit(omit: Optional<String>) = omit(omit.getOrNull())

        /**
         * Region WOEID (1=Worldwide, 23424977=US, 23424975=UK, 23424969=Turkey). Wins over country
         * & location.
         */
        fun woeid(woeid: Long?) = apply { this.woeid = woeid }

        /** Alias for [Builder.woeid]. */
        fun woeid(woeid: Long) = woeid(woeid as Long?)

        /** Alias for calling [Builder.woeid] with `woeid.orElse(null)`. */
        fun woeid(woeid: Optional<Long>) = woeid(woeid.getOrNull())

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
         * Returns an immutable instance of [XGetTrendsParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): XGetTrendsParams =
            XGetTrendsParams(
                at,
                count,
                country,
                fields,
                location,
                omit,
                woeid,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                at?.let { put("at", it) }
                count?.let { put("count", it.toString()) }
                country?.let { put("country", it) }
                fields?.let { put("fields", it) }
                location?.let { put("location", it) }
                omit?.let { put("omit", it) }
                woeid?.let { put("woeid", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is XGetTrendsParams &&
            at == other.at &&
            count == other.count &&
            country == other.country &&
            fields == other.fields &&
            location == other.location &&
            omit == other.omit &&
            woeid == other.woeid &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            at,
            count,
            country,
            fields,
            location,
            omit,
            woeid,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "XGetTrendsParams{at=$at, count=$count, country=$country, fields=$fields, location=$location, omit=$omit, woeid=$woeid, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
