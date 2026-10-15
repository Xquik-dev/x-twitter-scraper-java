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
 * Returns the Twitter trends archive of a place, as the lists X showed there over a range of time.
 * Use it for trending on Twitter yesterday, last week or any day since 2026-10-13 02:20 UTC. Xquik
 * stores 1 list per place every 5 minutes and keeps it for 25 months. Pick the place by woeid,
 * country or location name, the range with from & to, and the step with every. from & to take a
 * time or a span back from now, such as 7d, so a schedule can read the last day on every run. Each
 * step returns the first list stored in it, with its own time. Each returned list costs 1 credit,
 * so 24 lists cost 24 credits. A step with no stored list returns none and costs nothing. 1 request
 * returns 24 lists, or up to 100 with limit.
 */
class XGetTrendsHistoryParams
private constructor(
    private val count: Long?,
    private val country: String?,
    private val cursor: String?,
    private val every: String?,
    private val fields: String?,
    private val from: String?,
    private val limit: Long?,
    private val location: String?,
    private val omit: String?,
    private val to: String?,
    private val woeid: Long?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Trends to return in each list, from 1 to 50. */
    fun count(): Optional<Long> = Optional.ofNullable(count)

    /**
     * Country to read trends history for, by name or 2-letter code, such as Turkey or TR. Case
     * insensitive.
     */
    fun country(): Optional<String> = Optional.ofNullable(country)

    /**
     * The next_cursor of the page before, for the next lists. It keeps the time of the first
     * request, so a range of spans stays the same on every page.
     */
    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    /**
     * Step between 2 returned lists, as a number & m, h or d, such as 15m, 1h or 1d. A step under
     * 5m returns every stored list.
     */
    fun every(): Optional<String> = Optional.ofNullable(every)

    /**
     * Fields to keep in each row, comma-separated. Use dots for nested fields, such as
     * author.username. A list keeps the field in each item. Case & underscores do not matter. A row
     * that lacks a field leaves it out. Cursors, counts & diagnostics always stay. An unknown name
     * answers 400 unknown_field with the valid names, before any read. The price stays the same.
     * SDK row types then hold only the named fields.
     */
    fun fields(): Optional<String> = Optional.ofNullable(fields)

    /**
     * Start of the range. Takes an ISO 8601 time, a date such as 2026-10-13, or Unix seconds. A
     * time without a zone reads as UTC. It also takes a span back from now, as a number & s, m, h
     * or d, so from=7d reads the last 7 days. Defaults to 24 hours before to. History starts
     * 2026-10-13 02:20 UTC, and a range that begins earlier returns the stored part. Alias
     * sinceTime.
     */
    fun from(): Optional<String> = Optional.ofNullable(from)

    /**
     * Maximum lists 1 request returns & charges. A wider range gives a next_cursor for the next
     * lists. A low credit balance can return fewer.
     */
    fun limit(): Optional<Long> = Optional.ofNullable(limit)

    /**
     * Town or country to read trends history for, by name, such as Istanbul. Case insensitive. Add
     * country when 2 towns share a name. /x/trends/locations lists every name.
     */
    fun location(): Optional<String> = Optional.ofNullable(location)

    /**
     * Fields to drop from each row, comma-separated. It takes the same names as fields. With
     * fields, it drops from the kept fields.
     */
    fun omit(): Optional<String> = Optional.ofNullable(omit)

    /**
     * End of the range, which it leaves out. Takes the forms of from, so from=2d with to=1d reads
     * the day before the last 24 hours. Defaults to now. Alias untilTime.
     */
    fun to(): Optional<String> = Optional.ofNullable(to)

    /**
     * WOEID of the place, such as 1 for Worldwide or 23424969 for Turkey. It wins over country &
     * location. /x/trends/locations lists every WOEID.
     */
    fun woeid(): Optional<Long> = Optional.ofNullable(woeid)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): XGetTrendsHistoryParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [XGetTrendsHistoryParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [XGetTrendsHistoryParams]. */
    class Builder internal constructor() {

        private var count: Long? = null
        private var country: String? = null
        private var cursor: String? = null
        private var every: String? = null
        private var fields: String? = null
        private var from: String? = null
        private var limit: Long? = null
        private var location: String? = null
        private var omit: String? = null
        private var to: String? = null
        private var woeid: Long? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(xGetTrendsHistoryParams: XGetTrendsHistoryParams) = apply {
            count = xGetTrendsHistoryParams.count
            country = xGetTrendsHistoryParams.country
            cursor = xGetTrendsHistoryParams.cursor
            every = xGetTrendsHistoryParams.every
            fields = xGetTrendsHistoryParams.fields
            from = xGetTrendsHistoryParams.from
            limit = xGetTrendsHistoryParams.limit
            location = xGetTrendsHistoryParams.location
            omit = xGetTrendsHistoryParams.omit
            to = xGetTrendsHistoryParams.to
            woeid = xGetTrendsHistoryParams.woeid
            additionalHeaders = xGetTrendsHistoryParams.additionalHeaders.toBuilder()
            additionalQueryParams = xGetTrendsHistoryParams.additionalQueryParams.toBuilder()
        }

        /** Trends to return in each list, from 1 to 50. */
        fun count(count: Long?) = apply { this.count = count }

        /** Alias for [Builder.count]. */
        fun count(count: Long) = count(count as Long?)

        /** Alias for calling [Builder.count] with `count.orElse(null)`. */
        fun count(count: Optional<Long>) = count(count.getOrNull())

        /**
         * Country to read trends history for, by name or 2-letter code, such as Turkey or TR. Case
         * insensitive.
         */
        fun country(country: String?) = apply { this.country = country }

        /** Alias for calling [Builder.country] with `country.orElse(null)`. */
        fun country(country: Optional<String>) = country(country.getOrNull())

        /**
         * The next_cursor of the page before, for the next lists. It keeps the time of the first
         * request, so a range of spans stays the same on every page.
         */
        fun cursor(cursor: String?) = apply { this.cursor = cursor }

        /** Alias for calling [Builder.cursor] with `cursor.orElse(null)`. */
        fun cursor(cursor: Optional<String>) = cursor(cursor.getOrNull())

        /**
         * Step between 2 returned lists, as a number & m, h or d, such as 15m, 1h or 1d. A step
         * under 5m returns every stored list.
         */
        fun every(every: String?) = apply { this.every = every }

        /** Alias for calling [Builder.every] with `every.orElse(null)`. */
        fun every(every: Optional<String>) = every(every.getOrNull())

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
         * Start of the range. Takes an ISO 8601 time, a date such as 2026-10-13, or Unix seconds. A
         * time without a zone reads as UTC. It also takes a span back from now, as a number & s, m,
         * h or d, so from=7d reads the last 7 days. Defaults to 24 hours before to. History starts
         * 2026-10-13 02:20 UTC, and a range that begins earlier returns the stored part. Alias
         * sinceTime.
         */
        fun from(from: String?) = apply { this.from = from }

        /** Alias for calling [Builder.from] with `from.orElse(null)`. */
        fun from(from: Optional<String>) = from(from.getOrNull())

        /**
         * Maximum lists 1 request returns & charges. A wider range gives a next_cursor for the next
         * lists. A low credit balance can return fewer.
         */
        fun limit(limit: Long?) = apply { this.limit = limit }

        /** Alias for [Builder.limit]. */
        fun limit(limit: Long) = limit(limit as Long?)

        /** Alias for calling [Builder.limit] with `limit.orElse(null)`. */
        fun limit(limit: Optional<Long>) = limit(limit.getOrNull())

        /**
         * Town or country to read trends history for, by name, such as Istanbul. Case insensitive.
         * Add country when 2 towns share a name. /x/trends/locations lists every name.
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
         * End of the range, which it leaves out. Takes the forms of from, so from=2d with to=1d
         * reads the day before the last 24 hours. Defaults to now. Alias untilTime.
         */
        fun to(to: String?) = apply { this.to = to }

        /** Alias for calling [Builder.to] with `to.orElse(null)`. */
        fun to(to: Optional<String>) = to(to.getOrNull())

        /**
         * WOEID of the place, such as 1 for Worldwide or 23424969 for Turkey. It wins over country
         * & location. /x/trends/locations lists every WOEID.
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
         * Returns an immutable instance of [XGetTrendsHistoryParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): XGetTrendsHistoryParams =
            XGetTrendsHistoryParams(
                count,
                country,
                cursor,
                every,
                fields,
                from,
                limit,
                location,
                omit,
                to,
                woeid,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                count?.let { put("count", it.toString()) }
                country?.let { put("country", it) }
                cursor?.let { put("cursor", it) }
                every?.let { put("every", it) }
                fields?.let { put("fields", it) }
                from?.let { put("from", it) }
                limit?.let { put("limit", it.toString()) }
                location?.let { put("location", it) }
                omit?.let { put("omit", it) }
                to?.let { put("to", it) }
                woeid?.let { put("woeid", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is XGetTrendsHistoryParams &&
            count == other.count &&
            country == other.country &&
            cursor == other.cursor &&
            every == other.every &&
            fields == other.fields &&
            from == other.from &&
            limit == other.limit &&
            location == other.location &&
            omit == other.omit &&
            to == other.to &&
            woeid == other.woeid &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            count,
            country,
            cursor,
            every,
            fields,
            from,
            limit,
            location,
            omit,
            to,
            woeid,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "XGetTrendsHistoryParams{count=$count, country=$country, cursor=$cursor, every=$every, fields=$fields, from=$from, limit=$limit, location=$location, omit=$omit, to=$to, woeid=$woeid, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
