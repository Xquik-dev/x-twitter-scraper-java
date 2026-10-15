// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.jobs

import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Returns job listings with title, location, salary, company & apply link. Add filters to narrow
 * them. A closed job does not appear & costs nothing. Follow next_cursor for more.
 */
class JobSearchParams
private constructor(
    private val q: String,
    private val company: String?,
    private val cursor: String?,
    private val employmentType: String?,
    private val fields: String?,
    private val location: String?,
    private val locationId: String?,
    private val locationType: String?,
    private val omit: String?,
    private val pageSize: Long?,
    private val seniority: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Keyword, such as a job title or skill. Its alias is query. */
    fun q(): String = q

    /** Company name to match. */
    fun company(): Optional<String> = Optional.ofNullable(company)

    /**
     * Pagination cursor for collection results. Also read as next_cursor, next_token,
     * pagination_token or continuation_token.
     */
    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    /**
     * Comma-separated list of full_time, full_time_contract, part_time & contract_to_hire. Any case
     * works, with spaces or hyphens between words.
     */
    fun employmentType(): Optional<String> = Optional.ofNullable(employmentType)

    /**
     * Fields to keep in each row, comma-separated. Use dots for nested fields, such as
     * author.username. A list keeps the field in each item. Case & underscores do not matter. A row
     * that lacks a field leaves it out. Cursors, counts & diagnostics always stay. An unknown name
     * answers 400 unknown_field with the valid names, before any read. The price stays the same.
     * SDK row types then hold only the named fields.
     */
    fun fields(): Optional<String> = Optional.ofNullable(fields)

    /** City, region or country as text, such as Berlin. */
    fun location(): Optional<String> = Optional.ofNullable(location)

    /** Location ID from GET /x/jobs/locations. Replaces location when both are sent. */
    fun locationId(): Optional<String> = Optional.ofNullable(locationId)

    /**
     * Where the work happens. Comma-separated list of onsite, remote & hybrid. Any case works, with
     * spaces or hyphens between words.
     */
    fun locationType(): Optional<String> = Optional.ofNullable(locationType)

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
     * Comma-separated list of intern, entry_level, junior, mid_level, senior, lead, manager &
     * executive. Any case works, with spaces or hyphens between words.
     */
    fun seniority(): Optional<String> = Optional.ofNullable(seniority)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [JobSearchParams].
         *
         * The following fields are required:
         * ```java
         * .q()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [JobSearchParams]. */
    class Builder internal constructor() {

        private var q: String? = null
        private var company: String? = null
        private var cursor: String? = null
        private var employmentType: String? = null
        private var fields: String? = null
        private var location: String? = null
        private var locationId: String? = null
        private var locationType: String? = null
        private var omit: String? = null
        private var pageSize: Long? = null
        private var seniority: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(jobSearchParams: JobSearchParams) = apply {
            q = jobSearchParams.q
            company = jobSearchParams.company
            cursor = jobSearchParams.cursor
            employmentType = jobSearchParams.employmentType
            fields = jobSearchParams.fields
            location = jobSearchParams.location
            locationId = jobSearchParams.locationId
            locationType = jobSearchParams.locationType
            omit = jobSearchParams.omit
            pageSize = jobSearchParams.pageSize
            seniority = jobSearchParams.seniority
            additionalHeaders = jobSearchParams.additionalHeaders.toBuilder()
            additionalQueryParams = jobSearchParams.additionalQueryParams.toBuilder()
        }

        /** Keyword, such as a job title or skill. Its alias is query. */
        fun q(q: String) = apply { this.q = q }

        /** Company name to match. */
        fun company(company: String?) = apply { this.company = company }

        /** Alias for calling [Builder.company] with `company.orElse(null)`. */
        fun company(company: Optional<String>) = company(company.getOrNull())

        /**
         * Pagination cursor for collection results. Also read as next_cursor, next_token,
         * pagination_token or continuation_token.
         */
        fun cursor(cursor: String?) = apply { this.cursor = cursor }

        /** Alias for calling [Builder.cursor] with `cursor.orElse(null)`. */
        fun cursor(cursor: Optional<String>) = cursor(cursor.getOrNull())

        /**
         * Comma-separated list of full_time, full_time_contract, part_time & contract_to_hire. Any
         * case works, with spaces or hyphens between words.
         */
        fun employmentType(employmentType: String?) = apply { this.employmentType = employmentType }

        /** Alias for calling [Builder.employmentType] with `employmentType.orElse(null)`. */
        fun employmentType(employmentType: Optional<String>) =
            employmentType(employmentType.getOrNull())

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

        /** City, region or country as text, such as Berlin. */
        fun location(location: String?) = apply { this.location = location }

        /** Alias for calling [Builder.location] with `location.orElse(null)`. */
        fun location(location: Optional<String>) = location(location.getOrNull())

        /** Location ID from GET /x/jobs/locations. Replaces location when both are sent. */
        fun locationId(locationId: String?) = apply { this.locationId = locationId }

        /** Alias for calling [Builder.locationId] with `locationId.orElse(null)`. */
        fun locationId(locationId: Optional<String>) = locationId(locationId.getOrNull())

        /**
         * Where the work happens. Comma-separated list of onsite, remote & hybrid. Any case works,
         * with spaces or hyphens between words.
         */
        fun locationType(locationType: String?) = apply { this.locationType = locationType }

        /** Alias for calling [Builder.locationType] with `locationType.orElse(null)`. */
        fun locationType(locationType: Optional<String>) = locationType(locationType.getOrNull())

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
         * Comma-separated list of intern, entry_level, junior, mid_level, senior, lead, manager &
         * executive. Any case works, with spaces or hyphens between words.
         */
        fun seniority(seniority: String?) = apply { this.seniority = seniority }

        /** Alias for calling [Builder.seniority] with `seniority.orElse(null)`. */
        fun seniority(seniority: Optional<String>) = seniority(seniority.getOrNull())

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
         * Returns an immutable instance of [JobSearchParams].
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
        fun build(): JobSearchParams =
            JobSearchParams(
                checkRequired("q", q),
                company,
                cursor,
                employmentType,
                fields,
                location,
                locationId,
                locationType,
                omit,
                pageSize,
                seniority,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                put("q", q)
                company?.let { put("company", it) }
                cursor?.let { put("cursor", it) }
                employmentType?.let { put("employmentType", it) }
                fields?.let { put("fields", it) }
                location?.let { put("location", it) }
                locationId?.let { put("locationId", it) }
                locationType?.let { put("locationType", it) }
                omit?.let { put("omit", it) }
                pageSize?.let { put("pageSize", it.toString()) }
                seniority?.let { put("seniority", it) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is JobSearchParams &&
            q == other.q &&
            company == other.company &&
            cursor == other.cursor &&
            employmentType == other.employmentType &&
            fields == other.fields &&
            location == other.location &&
            locationId == other.locationId &&
            locationType == other.locationType &&
            omit == other.omit &&
            pageSize == other.pageSize &&
            seniority == other.seniority &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            q,
            company,
            cursor,
            employmentType,
            fields,
            location,
            locationId,
            locationType,
            omit,
            pageSize,
            seniority,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "JobSearchParams{q=$q, company=$company, cursor=$cursor, employmentType=$employmentType, fields=$fields, location=$location, locationId=$locationId, locationType=$locationType, omit=$omit, pageSize=$pageSize, seniority=$seniority, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
