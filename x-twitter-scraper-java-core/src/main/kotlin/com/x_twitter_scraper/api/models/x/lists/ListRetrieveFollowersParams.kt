// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.lists

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

/** List followers of an X List */
class ListRetrieveFollowersParams
private constructor(
    private val id: String?,
    private val after: String?,
    private val bioContains: String?,
    private val blueVerifiedOnly: Boolean?,
    private val businessEmailOnly: Boolean?,
    private val cursor: String?,
    private val emailDomains: String?,
    private val fields: String?,
    private val hasEmail: Boolean?,
    private val hasLocation: Boolean?,
    private val hasWebsite: Boolean?,
    private val locationContains: String?,
    private val maxFollowers: Long?,
    private val maxFollowing: Long?,
    private val maxScan: Long?,
    private val maxStatuses: Long?,
    private val minAccountAgeDays: Long?,
    private val minFollowers: Long?,
    private val minFollowing: Long?,
    private val minStatuses: Long?,
    private val mode: Mode?,
    private val omit: String?,
    private val pageSize: Long?,
    private val usernameContains: String?,
    private val verifiedOnly: Boolean?,
    private val verifiedType: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun id(): Optional<String> = Optional.ofNullable(id)

    /** Legacy cursor alias. Prefer cursor. */
    fun after(): Optional<String> = Optional.ofNullable(after)

    /** Match any comma-separated or line-separated bio term, ignoring case. */
    fun bioContains(): Optional<String> = Optional.ofNullable(bioContains)

    /**
     * Only return profiles X marks as blue verified. X marks many business & government accounts
     * blue too. Use verifiedType for 1 badge type.
     */
    fun blueVerifiedOnly(): Optional<Boolean> = Optional.ofNullable(blueVerifiedOnly)

    /** Only return profiles that publish an email outside free webmail, such as Gmail. */
    fun businessEmailOnly(): Optional<Boolean> = Optional.ofNullable(businessEmailOnly)

    /** Pagination cursor for list followers */
    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    /**
     * Only return profiles with an email at one of these domains. Separate domains with commas.
     * Subdomains match.
     */
    fun emailDomains(): Optional<String> = Optional.ofNullable(emailDomains)

    /**
     * Fields to keep in each row, comma-separated. Use dots for nested fields, such as
     * author.username. A list keeps the field in each item. Case & underscores do not matter. A row
     * that lacks a field leaves it out. Cursors, counts & diagnostics always stay. An unknown name
     * answers 400 unknown_field with the valid names, before any read. The price stays the same. A
     * required getter throws when you leave its field out, and response validation fails.
     */
    fun fields(): Optional<String> = Optional.ofNullable(fields)

    /** Only return profiles that publish an email. */
    fun hasEmail(): Optional<Boolean> = Optional.ofNullable(hasEmail)

    /** Only return profiles with a location. */
    fun hasLocation(): Optional<Boolean> = Optional.ofNullable(hasLocation)

    /** Only return profiles with a website. */
    fun hasWebsite(): Optional<Boolean> = Optional.ofNullable(hasWebsite)

    /** Match a location substring, ignoring case. */
    fun locationContains(): Optional<String> = Optional.ofNullable(locationContains)

    /** Maximum follower count. Missing counts pass this maximum. */
    fun maxFollowers(): Optional<Long> = Optional.ofNullable(maxFollowers)

    /** Maximum following count. */
    fun maxFollowing(): Optional<Long> = Optional.ofNullable(maxFollowing)

    /**
     * Most profiles 1 request reads, kept or dropped by the filters. The request then answers the
     * profiles it kept, the count it dropped & the cursor to read on. Each request of a cursor may
     * send its own value. Without it, a filtered read scans at most 100,000 profiles of the list
     * across all its pages, & the page that reaches them ends the list with `scanLimit`. An
     * unfiltered read has no scan limit. Automatic mode only.
     */
    fun maxScan(): Optional<Long> = Optional.ofNullable(maxScan)

    /** Maximum post count. maxPosts is also accepted. */
    fun maxStatuses(): Optional<Long> = Optional.ofNullable(maxStatuses)

    /** Minimum account age in whole days. */
    fun minAccountAgeDays(): Optional<Long> = Optional.ofNullable(minAccountAgeDays)

    /** Minimum follower count. Filtering happens before billing. */
    fun minFollowers(): Optional<Long> = Optional.ofNullable(minFollowers)

    /** Minimum following count. */
    fun minFollowing(): Optional<Long> = Optional.ofNullable(minFollowing)

    /** Minimum post count. minPosts is also accepted. */
    fun minStatuses(): Optional<Long> = Optional.ofNullable(minStatuses)

    /**
     * Omit mode for resumable maximum coverage. Standard keeps legacy pagination. Coverage returns
     * diagnostics once and rejects cursors.
     */
    fun mode(): Optional<Mode> = Optional.ofNullable(mode)

    /**
     * Fields to drop from each row, comma-separated. It takes the same names as fields. With
     * fields, it drops from the kept fields.
     */
    fun omit(): Optional<String> = Optional.ofNullable(omit)

    /**
     * Maximum user profiles requested from this page (20-200, default 200). Source, filters, or
     * credits can return fewer profiles. Keep requesting next_cursor while has_next_page is true.
     * Deprecated aliases remain accepted.
     */
    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    /** Match a username substring, ignoring case. */
    fun usernameContains(): Optional<String> = Optional.ofNullable(usernameContains)

    /** Only return verified profiles. */
    fun verifiedOnly(): Optional<Boolean> = Optional.ofNullable(verifiedOnly)

    /** Match the verification type exactly, ignoring case. */
    fun verifiedType(): Optional<String> = Optional.ofNullable(verifiedType)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): ListRetrieveFollowersParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of [ListRetrieveFollowersParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ListRetrieveFollowersParams]. */
    class Builder internal constructor() {

        private var id: String? = null
        private var after: String? = null
        private var bioContains: String? = null
        private var blueVerifiedOnly: Boolean? = null
        private var businessEmailOnly: Boolean? = null
        private var cursor: String? = null
        private var emailDomains: String? = null
        private var fields: String? = null
        private var hasEmail: Boolean? = null
        private var hasLocation: Boolean? = null
        private var hasWebsite: Boolean? = null
        private var locationContains: String? = null
        private var maxFollowers: Long? = null
        private var maxFollowing: Long? = null
        private var maxScan: Long? = null
        private var maxStatuses: Long? = null
        private var minAccountAgeDays: Long? = null
        private var minFollowers: Long? = null
        private var minFollowing: Long? = null
        private var minStatuses: Long? = null
        private var mode: Mode? = null
        private var omit: String? = null
        private var pageSize: Long? = null
        private var usernameContains: String? = null
        private var verifiedOnly: Boolean? = null
        private var verifiedType: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(listRetrieveFollowersParams: ListRetrieveFollowersParams) = apply {
            id = listRetrieveFollowersParams.id
            after = listRetrieveFollowersParams.after
            bioContains = listRetrieveFollowersParams.bioContains
            blueVerifiedOnly = listRetrieveFollowersParams.blueVerifiedOnly
            businessEmailOnly = listRetrieveFollowersParams.businessEmailOnly
            cursor = listRetrieveFollowersParams.cursor
            emailDomains = listRetrieveFollowersParams.emailDomains
            fields = listRetrieveFollowersParams.fields
            hasEmail = listRetrieveFollowersParams.hasEmail
            hasLocation = listRetrieveFollowersParams.hasLocation
            hasWebsite = listRetrieveFollowersParams.hasWebsite
            locationContains = listRetrieveFollowersParams.locationContains
            maxFollowers = listRetrieveFollowersParams.maxFollowers
            maxFollowing = listRetrieveFollowersParams.maxFollowing
            maxScan = listRetrieveFollowersParams.maxScan
            maxStatuses = listRetrieveFollowersParams.maxStatuses
            minAccountAgeDays = listRetrieveFollowersParams.minAccountAgeDays
            minFollowers = listRetrieveFollowersParams.minFollowers
            minFollowing = listRetrieveFollowersParams.minFollowing
            minStatuses = listRetrieveFollowersParams.minStatuses
            mode = listRetrieveFollowersParams.mode
            omit = listRetrieveFollowersParams.omit
            pageSize = listRetrieveFollowersParams.pageSize
            usernameContains = listRetrieveFollowersParams.usernameContains
            verifiedOnly = listRetrieveFollowersParams.verifiedOnly
            verifiedType = listRetrieveFollowersParams.verifiedType
            additionalHeaders = listRetrieveFollowersParams.additionalHeaders.toBuilder()
            additionalQueryParams = listRetrieveFollowersParams.additionalQueryParams.toBuilder()
        }

        fun id(id: String?) = apply { this.id = id }

        /** Alias for calling [Builder.id] with `id.orElse(null)`. */
        fun id(id: Optional<String>) = id(id.getOrNull())

        /** Legacy cursor alias. Prefer cursor. */
        fun after(after: String?) = apply { this.after = after }

        /** Alias for calling [Builder.after] with `after.orElse(null)`. */
        fun after(after: Optional<String>) = after(after.getOrNull())

        /** Match any comma-separated or line-separated bio term, ignoring case. */
        fun bioContains(bioContains: String?) = apply { this.bioContains = bioContains }

        /** Alias for calling [Builder.bioContains] with `bioContains.orElse(null)`. */
        fun bioContains(bioContains: Optional<String>) = bioContains(bioContains.getOrNull())

        /**
         * Only return profiles X marks as blue verified. X marks many business & government
         * accounts blue too. Use verifiedType for 1 badge type.
         */
        fun blueVerifiedOnly(blueVerifiedOnly: Boolean?) = apply {
            this.blueVerifiedOnly = blueVerifiedOnly
        }

        /** Alias for [Builder.blueVerifiedOnly]. */
        fun blueVerifiedOnly(blueVerifiedOnly: Boolean) =
            blueVerifiedOnly(blueVerifiedOnly as Boolean?)

        /** Alias for calling [Builder.blueVerifiedOnly] with `blueVerifiedOnly.orElse(null)`. */
        fun blueVerifiedOnly(blueVerifiedOnly: Optional<Boolean>) =
            blueVerifiedOnly(blueVerifiedOnly.getOrNull())

        /** Only return profiles that publish an email outside free webmail, such as Gmail. */
        fun businessEmailOnly(businessEmailOnly: Boolean?) = apply {
            this.businessEmailOnly = businessEmailOnly
        }

        /** Alias for [Builder.businessEmailOnly]. */
        fun businessEmailOnly(businessEmailOnly: Boolean) =
            businessEmailOnly(businessEmailOnly as Boolean?)

        /** Alias for calling [Builder.businessEmailOnly] with `businessEmailOnly.orElse(null)`. */
        fun businessEmailOnly(businessEmailOnly: Optional<Boolean>) =
            businessEmailOnly(businessEmailOnly.getOrNull())

        /** Pagination cursor for list followers */
        fun cursor(cursor: String?) = apply { this.cursor = cursor }

        /** Alias for calling [Builder.cursor] with `cursor.orElse(null)`. */
        fun cursor(cursor: Optional<String>) = cursor(cursor.getOrNull())

        /**
         * Only return profiles with an email at one of these domains. Separate domains with commas.
         * Subdomains match.
         */
        fun emailDomains(emailDomains: String?) = apply { this.emailDomains = emailDomains }

        /** Alias for calling [Builder.emailDomains] with `emailDomains.orElse(null)`. */
        fun emailDomains(emailDomains: Optional<String>) = emailDomains(emailDomains.getOrNull())

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

        /** Only return profiles that publish an email. */
        fun hasEmail(hasEmail: Boolean?) = apply { this.hasEmail = hasEmail }

        /** Alias for [Builder.hasEmail]. */
        fun hasEmail(hasEmail: Boolean) = hasEmail(hasEmail as Boolean?)

        /** Alias for calling [Builder.hasEmail] with `hasEmail.orElse(null)`. */
        fun hasEmail(hasEmail: Optional<Boolean>) = hasEmail(hasEmail.getOrNull())

        /** Only return profiles with a location. */
        fun hasLocation(hasLocation: Boolean?) = apply { this.hasLocation = hasLocation }

        /** Alias for [Builder.hasLocation]. */
        fun hasLocation(hasLocation: Boolean) = hasLocation(hasLocation as Boolean?)

        /** Alias for calling [Builder.hasLocation] with `hasLocation.orElse(null)`. */
        fun hasLocation(hasLocation: Optional<Boolean>) = hasLocation(hasLocation.getOrNull())

        /** Only return profiles with a website. */
        fun hasWebsite(hasWebsite: Boolean?) = apply { this.hasWebsite = hasWebsite }

        /** Alias for [Builder.hasWebsite]. */
        fun hasWebsite(hasWebsite: Boolean) = hasWebsite(hasWebsite as Boolean?)

        /** Alias for calling [Builder.hasWebsite] with `hasWebsite.orElse(null)`. */
        fun hasWebsite(hasWebsite: Optional<Boolean>) = hasWebsite(hasWebsite.getOrNull())

        /** Match a location substring, ignoring case. */
        fun locationContains(locationContains: String?) = apply {
            this.locationContains = locationContains
        }

        /** Alias for calling [Builder.locationContains] with `locationContains.orElse(null)`. */
        fun locationContains(locationContains: Optional<String>) =
            locationContains(locationContains.getOrNull())

        /** Maximum follower count. Missing counts pass this maximum. */
        fun maxFollowers(maxFollowers: Long?) = apply { this.maxFollowers = maxFollowers }

        /** Alias for [Builder.maxFollowers]. */
        fun maxFollowers(maxFollowers: Long) = maxFollowers(maxFollowers as Long?)

        /** Alias for calling [Builder.maxFollowers] with `maxFollowers.orElse(null)`. */
        fun maxFollowers(maxFollowers: Optional<Long>) = maxFollowers(maxFollowers.getOrNull())

        /** Maximum following count. */
        fun maxFollowing(maxFollowing: Long?) = apply { this.maxFollowing = maxFollowing }

        /** Alias for [Builder.maxFollowing]. */
        fun maxFollowing(maxFollowing: Long) = maxFollowing(maxFollowing as Long?)

        /** Alias for calling [Builder.maxFollowing] with `maxFollowing.orElse(null)`. */
        fun maxFollowing(maxFollowing: Optional<Long>) = maxFollowing(maxFollowing.getOrNull())

        /**
         * Most profiles 1 request reads, kept or dropped by the filters. The request then answers
         * the profiles it kept, the count it dropped & the cursor to read on. Each request of a
         * cursor may send its own value. Without it, a filtered read scans at most 100,000 profiles
         * of the list across all its pages, & the page that reaches them ends the list with
         * `scanLimit`. An unfiltered read has no scan limit. Automatic mode only.
         */
        fun maxScan(maxScan: Long?) = apply { this.maxScan = maxScan }

        /** Alias for [Builder.maxScan]. */
        fun maxScan(maxScan: Long) = maxScan(maxScan as Long?)

        /** Alias for calling [Builder.maxScan] with `maxScan.orElse(null)`. */
        fun maxScan(maxScan: Optional<Long>) = maxScan(maxScan.getOrNull())

        /** Maximum post count. maxPosts is also accepted. */
        fun maxStatuses(maxStatuses: Long?) = apply { this.maxStatuses = maxStatuses }

        /** Alias for [Builder.maxStatuses]. */
        fun maxStatuses(maxStatuses: Long) = maxStatuses(maxStatuses as Long?)

        /** Alias for calling [Builder.maxStatuses] with `maxStatuses.orElse(null)`. */
        fun maxStatuses(maxStatuses: Optional<Long>) = maxStatuses(maxStatuses.getOrNull())

        /** Minimum account age in whole days. */
        fun minAccountAgeDays(minAccountAgeDays: Long?) = apply {
            this.minAccountAgeDays = minAccountAgeDays
        }

        /** Alias for [Builder.minAccountAgeDays]. */
        fun minAccountAgeDays(minAccountAgeDays: Long) =
            minAccountAgeDays(minAccountAgeDays as Long?)

        /** Alias for calling [Builder.minAccountAgeDays] with `minAccountAgeDays.orElse(null)`. */
        fun minAccountAgeDays(minAccountAgeDays: Optional<Long>) =
            minAccountAgeDays(minAccountAgeDays.getOrNull())

        /** Minimum follower count. Filtering happens before billing. */
        fun minFollowers(minFollowers: Long?) = apply { this.minFollowers = minFollowers }

        /** Alias for [Builder.minFollowers]. */
        fun minFollowers(minFollowers: Long) = minFollowers(minFollowers as Long?)

        /** Alias for calling [Builder.minFollowers] with `minFollowers.orElse(null)`. */
        fun minFollowers(minFollowers: Optional<Long>) = minFollowers(minFollowers.getOrNull())

        /** Minimum following count. */
        fun minFollowing(minFollowing: Long?) = apply { this.minFollowing = minFollowing }

        /** Alias for [Builder.minFollowing]. */
        fun minFollowing(minFollowing: Long) = minFollowing(minFollowing as Long?)

        /** Alias for calling [Builder.minFollowing] with `minFollowing.orElse(null)`. */
        fun minFollowing(minFollowing: Optional<Long>) = minFollowing(minFollowing.getOrNull())

        /** Minimum post count. minPosts is also accepted. */
        fun minStatuses(minStatuses: Long?) = apply { this.minStatuses = minStatuses }

        /** Alias for [Builder.minStatuses]. */
        fun minStatuses(minStatuses: Long) = minStatuses(minStatuses as Long?)

        /** Alias for calling [Builder.minStatuses] with `minStatuses.orElse(null)`. */
        fun minStatuses(minStatuses: Optional<Long>) = minStatuses(minStatuses.getOrNull())

        /**
         * Omit mode for resumable maximum coverage. Standard keeps legacy pagination. Coverage
         * returns diagnostics once and rejects cursors.
         */
        fun mode(mode: Mode?) = apply { this.mode = mode }

        /** Alias for calling [Builder.mode] with `mode.orElse(null)`. */
        fun mode(mode: Optional<Mode>) = mode(mode.getOrNull())

        /**
         * Fields to drop from each row, comma-separated. It takes the same names as fields. With
         * fields, it drops from the kept fields.
         */
        fun omit(omit: String?) = apply { this.omit = omit }

        /** Alias for calling [Builder.omit] with `omit.orElse(null)`. */
        fun omit(omit: Optional<String>) = omit(omit.getOrNull())

        /**
         * Maximum user profiles requested from this page (20-200, default 200). Source, filters, or
         * credits can return fewer profiles. Keep requesting next_cursor while has_next_page is
         * true. Deprecated aliases remain accepted.
         */
        fun pageSize(pageSize: Long?) = apply { this.pageSize = pageSize }

        /** Alias for [Builder.pageSize]. */
        fun pageSize(pageSize: Long) = pageSize(pageSize as Long?)

        /** Alias for calling [Builder.pageSize] with `pageSize.orElse(null)`. */
        fun pageSize(pageSize: Optional<Long>) = pageSize(pageSize.getOrNull())

        /** Match a username substring, ignoring case. */
        fun usernameContains(usernameContains: String?) = apply {
            this.usernameContains = usernameContains
        }

        /** Alias for calling [Builder.usernameContains] with `usernameContains.orElse(null)`. */
        fun usernameContains(usernameContains: Optional<String>) =
            usernameContains(usernameContains.getOrNull())

        /** Only return verified profiles. */
        fun verifiedOnly(verifiedOnly: Boolean?) = apply { this.verifiedOnly = verifiedOnly }

        /** Alias for [Builder.verifiedOnly]. */
        fun verifiedOnly(verifiedOnly: Boolean) = verifiedOnly(verifiedOnly as Boolean?)

        /** Alias for calling [Builder.verifiedOnly] with `verifiedOnly.orElse(null)`. */
        fun verifiedOnly(verifiedOnly: Optional<Boolean>) = verifiedOnly(verifiedOnly.getOrNull())

        /** Match the verification type exactly, ignoring case. */
        fun verifiedType(verifiedType: String?) = apply { this.verifiedType = verifiedType }

        /** Alias for calling [Builder.verifiedType] with `verifiedType.orElse(null)`. */
        fun verifiedType(verifiedType: Optional<String>) = verifiedType(verifiedType.getOrNull())

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
         * Returns an immutable instance of [ListRetrieveFollowersParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ListRetrieveFollowersParams =
            ListRetrieveFollowersParams(
                id,
                after,
                bioContains,
                blueVerifiedOnly,
                businessEmailOnly,
                cursor,
                emailDomains,
                fields,
                hasEmail,
                hasLocation,
                hasWebsite,
                locationContains,
                maxFollowers,
                maxFollowing,
                maxScan,
                maxStatuses,
                minAccountAgeDays,
                minFollowers,
                minFollowing,
                minStatuses,
                mode,
                omit,
                pageSize,
                usernameContains,
                verifiedOnly,
                verifiedType,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> id ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                after?.let { put("after", it) }
                bioContains?.let { put("bioContains", it) }
                blueVerifiedOnly?.let { put("blueVerifiedOnly", it.toString()) }
                businessEmailOnly?.let { put("businessEmailOnly", it.toString()) }
                cursor?.let { put("cursor", it) }
                emailDomains?.let { put("emailDomains", it) }
                fields?.let { put("fields", it) }
                hasEmail?.let { put("hasEmail", it.toString()) }
                hasLocation?.let { put("hasLocation", it.toString()) }
                hasWebsite?.let { put("hasWebsite", it.toString()) }
                locationContains?.let { put("locationContains", it) }
                maxFollowers?.let { put("maxFollowers", it.toString()) }
                maxFollowing?.let { put("maxFollowing", it.toString()) }
                maxScan?.let { put("maxScan", it.toString()) }
                maxStatuses?.let { put("maxStatuses", it.toString()) }
                minAccountAgeDays?.let { put("minAccountAgeDays", it.toString()) }
                minFollowers?.let { put("minFollowers", it.toString()) }
                minFollowing?.let { put("minFollowing", it.toString()) }
                minStatuses?.let { put("minStatuses", it.toString()) }
                mode?.let { put("mode", it.toString()) }
                omit?.let { put("omit", it) }
                pageSize?.let { put("pageSize", it.toString()) }
                usernameContains?.let { put("usernameContains", it) }
                verifiedOnly?.let { put("verifiedOnly", it.toString()) }
                verifiedType?.let { put("verifiedType", it) }
                putAll(additionalQueryParams)
            }
            .build()

    class Mode @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val STANDARD = of("standard")

            @JvmField val COVERAGE = of("coverage")

            @JvmStatic fun of(value: String) = Mode(JsonField.of(value))
        }

        /** An enum containing [Mode]'s known values. */
        enum class Known {
            STANDARD,
            COVERAGE,
        }

        /**
         * An enum containing [Mode]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Mode] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            STANDARD,
            COVERAGE,
            /** An enum member indicating that [Mode] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         */
        fun value(): Value =
            when (this) {
                STANDARD -> Value.STANDARD
                COVERAGE -> Value.COVERAGE
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
                STANDARD -> Known.STANDARD
                COVERAGE -> Known.COVERAGE
                else -> throw XTwitterScraperInvalidDataException("Unknown Mode: $value")
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
        fun validate(): Mode = apply {
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

            return other is Mode && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ListRetrieveFollowersParams &&
            id == other.id &&
            after == other.after &&
            bioContains == other.bioContains &&
            blueVerifiedOnly == other.blueVerifiedOnly &&
            businessEmailOnly == other.businessEmailOnly &&
            cursor == other.cursor &&
            emailDomains == other.emailDomains &&
            fields == other.fields &&
            hasEmail == other.hasEmail &&
            hasLocation == other.hasLocation &&
            hasWebsite == other.hasWebsite &&
            locationContains == other.locationContains &&
            maxFollowers == other.maxFollowers &&
            maxFollowing == other.maxFollowing &&
            maxScan == other.maxScan &&
            maxStatuses == other.maxStatuses &&
            minAccountAgeDays == other.minAccountAgeDays &&
            minFollowers == other.minFollowers &&
            minFollowing == other.minFollowing &&
            minStatuses == other.minStatuses &&
            mode == other.mode &&
            omit == other.omit &&
            pageSize == other.pageSize &&
            usernameContains == other.usernameContains &&
            verifiedOnly == other.verifiedOnly &&
            verifiedType == other.verifiedType &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            id,
            after,
            bioContains,
            blueVerifiedOnly,
            businessEmailOnly,
            cursor,
            emailDomains,
            fields,
            hasEmail,
            hasLocation,
            hasWebsite,
            locationContains,
            maxFollowers,
            maxFollowing,
            maxScan,
            maxStatuses,
            minAccountAgeDays,
            minFollowers,
            minFollowing,
            minStatuses,
            mode,
            omit,
            pageSize,
            usernameContains,
            verifiedOnly,
            verifiedType,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "ListRetrieveFollowersParams{id=$id, after=$after, bioContains=$bioContains, blueVerifiedOnly=$blueVerifiedOnly, businessEmailOnly=$businessEmailOnly, cursor=$cursor, emailDomains=$emailDomains, fields=$fields, hasEmail=$hasEmail, hasLocation=$hasLocation, hasWebsite=$hasWebsite, locationContains=$locationContains, maxFollowers=$maxFollowers, maxFollowing=$maxFollowing, maxScan=$maxScan, maxStatuses=$maxStatuses, minAccountAgeDays=$minAccountAgeDays, minFollowers=$minFollowers, minFollowing=$minFollowing, minStatuses=$minStatuses, mode=$mode, omit=$omit, pageSize=$pageSize, usernameContains=$usernameContains, verifiedOnly=$verifiedOnly, verifiedType=$verifiedType, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
