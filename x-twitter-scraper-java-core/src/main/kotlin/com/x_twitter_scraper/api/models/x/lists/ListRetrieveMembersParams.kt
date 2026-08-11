// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.lists

import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** List members of an X List */
class ListRetrieveMembersParams
private constructor(
    private val id: String?,
    private val bioContains: String?,
    private val cursor: String?,
    private val hasLocation: Boolean?,
    private val hasWebsite: Boolean?,
    private val locationContains: String?,
    private val maxFollowers: Long?,
    private val maxFollowing: Long?,
    private val maxStatuses: Long?,
    private val minAccountAgeDays: Long?,
    private val minFollowers: Long?,
    private val minFollowing: Long?,
    private val minStatuses: Long?,
    private val pageSize: Long?,
    private val usernameContains: String?,
    private val verifiedOnly: Boolean?,
    private val verifiedType: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun id(): Optional<String> = Optional.ofNullable(id)

    /** Match any comma-separated or line-separated bio term, ignoring case. */
    fun bioContains(): Optional<String> = Optional.ofNullable(bioContains)

    /** Pagination cursor for list members */
    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

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

    /** Members per page (20-200, default 20) */
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

        @JvmStatic fun none(): ListRetrieveMembersParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of [ListRetrieveMembersParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ListRetrieveMembersParams]. */
    class Builder internal constructor() {

        private var id: String? = null
        private var bioContains: String? = null
        private var cursor: String? = null
        private var hasLocation: Boolean? = null
        private var hasWebsite: Boolean? = null
        private var locationContains: String? = null
        private var maxFollowers: Long? = null
        private var maxFollowing: Long? = null
        private var maxStatuses: Long? = null
        private var minAccountAgeDays: Long? = null
        private var minFollowers: Long? = null
        private var minFollowing: Long? = null
        private var minStatuses: Long? = null
        private var pageSize: Long? = null
        private var usernameContains: String? = null
        private var verifiedOnly: Boolean? = null
        private var verifiedType: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(listRetrieveMembersParams: ListRetrieveMembersParams) = apply {
            id = listRetrieveMembersParams.id
            bioContains = listRetrieveMembersParams.bioContains
            cursor = listRetrieveMembersParams.cursor
            hasLocation = listRetrieveMembersParams.hasLocation
            hasWebsite = listRetrieveMembersParams.hasWebsite
            locationContains = listRetrieveMembersParams.locationContains
            maxFollowers = listRetrieveMembersParams.maxFollowers
            maxFollowing = listRetrieveMembersParams.maxFollowing
            maxStatuses = listRetrieveMembersParams.maxStatuses
            minAccountAgeDays = listRetrieveMembersParams.minAccountAgeDays
            minFollowers = listRetrieveMembersParams.minFollowers
            minFollowing = listRetrieveMembersParams.minFollowing
            minStatuses = listRetrieveMembersParams.minStatuses
            pageSize = listRetrieveMembersParams.pageSize
            usernameContains = listRetrieveMembersParams.usernameContains
            verifiedOnly = listRetrieveMembersParams.verifiedOnly
            verifiedType = listRetrieveMembersParams.verifiedType
            additionalHeaders = listRetrieveMembersParams.additionalHeaders.toBuilder()
            additionalQueryParams = listRetrieveMembersParams.additionalQueryParams.toBuilder()
        }

        fun id(id: String?) = apply { this.id = id }

        /** Alias for calling [Builder.id] with `id.orElse(null)`. */
        fun id(id: Optional<String>) = id(id.getOrNull())

        /** Match any comma-separated or line-separated bio term, ignoring case. */
        fun bioContains(bioContains: String?) = apply { this.bioContains = bioContains }

        /** Alias for calling [Builder.bioContains] with `bioContains.orElse(null)`. */
        fun bioContains(bioContains: Optional<String>) = bioContains(bioContains.getOrNull())

        /** Pagination cursor for list members */
        fun cursor(cursor: String?) = apply { this.cursor = cursor }

        /** Alias for calling [Builder.cursor] with `cursor.orElse(null)`. */
        fun cursor(cursor: Optional<String>) = cursor(cursor.getOrNull())

        /** Only return profiles with a location. */
        fun hasLocation(hasLocation: Boolean?) = apply { this.hasLocation = hasLocation }

        /**
         * Alias for [Builder.hasLocation].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun hasLocation(hasLocation: Boolean) = hasLocation(hasLocation as Boolean?)

        /** Alias for calling [Builder.hasLocation] with `hasLocation.orElse(null)`. */
        fun hasLocation(hasLocation: Optional<Boolean>) = hasLocation(hasLocation.getOrNull())

        /** Only return profiles with a website. */
        fun hasWebsite(hasWebsite: Boolean?) = apply { this.hasWebsite = hasWebsite }

        /**
         * Alias for [Builder.hasWebsite].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
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

        /**
         * Alias for [Builder.maxFollowers].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun maxFollowers(maxFollowers: Long) = maxFollowers(maxFollowers as Long?)

        /** Alias for calling [Builder.maxFollowers] with `maxFollowers.orElse(null)`. */
        fun maxFollowers(maxFollowers: Optional<Long>) = maxFollowers(maxFollowers.getOrNull())

        /** Maximum following count. */
        fun maxFollowing(maxFollowing: Long?) = apply { this.maxFollowing = maxFollowing }

        /**
         * Alias for [Builder.maxFollowing].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun maxFollowing(maxFollowing: Long) = maxFollowing(maxFollowing as Long?)

        /** Alias for calling [Builder.maxFollowing] with `maxFollowing.orElse(null)`. */
        fun maxFollowing(maxFollowing: Optional<Long>) = maxFollowing(maxFollowing.getOrNull())

        /** Maximum post count. maxPosts is also accepted. */
        fun maxStatuses(maxStatuses: Long?) = apply { this.maxStatuses = maxStatuses }

        /**
         * Alias for [Builder.maxStatuses].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun maxStatuses(maxStatuses: Long) = maxStatuses(maxStatuses as Long?)

        /** Alias for calling [Builder.maxStatuses] with `maxStatuses.orElse(null)`. */
        fun maxStatuses(maxStatuses: Optional<Long>) = maxStatuses(maxStatuses.getOrNull())

        /** Minimum account age in whole days. */
        fun minAccountAgeDays(minAccountAgeDays: Long?) = apply {
            this.minAccountAgeDays = minAccountAgeDays
        }

        /**
         * Alias for [Builder.minAccountAgeDays].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun minAccountAgeDays(minAccountAgeDays: Long) =
            minAccountAgeDays(minAccountAgeDays as Long?)

        /** Alias for calling [Builder.minAccountAgeDays] with `minAccountAgeDays.orElse(null)`. */
        fun minAccountAgeDays(minAccountAgeDays: Optional<Long>) =
            minAccountAgeDays(minAccountAgeDays.getOrNull())

        /** Minimum follower count. Filtering happens before billing. */
        fun minFollowers(minFollowers: Long?) = apply { this.minFollowers = minFollowers }

        /**
         * Alias for [Builder.minFollowers].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun minFollowers(minFollowers: Long) = minFollowers(minFollowers as Long?)

        /** Alias for calling [Builder.minFollowers] with `minFollowers.orElse(null)`. */
        fun minFollowers(minFollowers: Optional<Long>) = minFollowers(minFollowers.getOrNull())

        /** Minimum following count. */
        fun minFollowing(minFollowing: Long?) = apply { this.minFollowing = minFollowing }

        /**
         * Alias for [Builder.minFollowing].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun minFollowing(minFollowing: Long) = minFollowing(minFollowing as Long?)

        /** Alias for calling [Builder.minFollowing] with `minFollowing.orElse(null)`. */
        fun minFollowing(minFollowing: Optional<Long>) = minFollowing(minFollowing.getOrNull())

        /** Minimum post count. minPosts is also accepted. */
        fun minStatuses(minStatuses: Long?) = apply { this.minStatuses = minStatuses }

        /**
         * Alias for [Builder.minStatuses].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun minStatuses(minStatuses: Long) = minStatuses(minStatuses as Long?)

        /** Alias for calling [Builder.minStatuses] with `minStatuses.orElse(null)`. */
        fun minStatuses(minStatuses: Optional<Long>) = minStatuses(minStatuses.getOrNull())

        /** Members per page (20-200, default 20) */
        fun pageSize(pageSize: Long?) = apply { this.pageSize = pageSize }

        /**
         * Alias for [Builder.pageSize].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
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

        /**
         * Alias for [Builder.verifiedOnly].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
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
         * Returns an immutable instance of [ListRetrieveMembersParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ListRetrieveMembersParams =
            ListRetrieveMembersParams(
                id,
                bioContains,
                cursor,
                hasLocation,
                hasWebsite,
                locationContains,
                maxFollowers,
                maxFollowing,
                maxStatuses,
                minAccountAgeDays,
                minFollowers,
                minFollowing,
                minStatuses,
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
                bioContains?.let { put("bioContains", it) }
                cursor?.let { put("cursor", it) }
                hasLocation?.let { put("hasLocation", it.toString()) }
                hasWebsite?.let { put("hasWebsite", it.toString()) }
                locationContains?.let { put("locationContains", it) }
                maxFollowers?.let { put("maxFollowers", it.toString()) }
                maxFollowing?.let { put("maxFollowing", it.toString()) }
                maxStatuses?.let { put("maxStatuses", it.toString()) }
                minAccountAgeDays?.let { put("minAccountAgeDays", it.toString()) }
                minFollowers?.let { put("minFollowers", it.toString()) }
                minFollowing?.let { put("minFollowing", it.toString()) }
                minStatuses?.let { put("minStatuses", it.toString()) }
                pageSize?.let { put("pageSize", it.toString()) }
                usernameContains?.let { put("usernameContains", it) }
                verifiedOnly?.let { put("verifiedOnly", it.toString()) }
                verifiedType?.let { put("verifiedType", it) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ListRetrieveMembersParams &&
            id == other.id &&
            bioContains == other.bioContains &&
            cursor == other.cursor &&
            hasLocation == other.hasLocation &&
            hasWebsite == other.hasWebsite &&
            locationContains == other.locationContains &&
            maxFollowers == other.maxFollowers &&
            maxFollowing == other.maxFollowing &&
            maxStatuses == other.maxStatuses &&
            minAccountAgeDays == other.minAccountAgeDays &&
            minFollowers == other.minFollowers &&
            minFollowing == other.minFollowing &&
            minStatuses == other.minStatuses &&
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
            bioContains,
            cursor,
            hasLocation,
            hasWebsite,
            locationContains,
            maxFollowers,
            maxFollowing,
            maxStatuses,
            minAccountAgeDays,
            minFollowers,
            minFollowing,
            minStatuses,
            pageSize,
            usernameContains,
            verifiedOnly,
            verifiedType,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "ListRetrieveMembersParams{id=$id, bioContains=$bioContains, cursor=$cursor, hasLocation=$hasLocation, hasWebsite=$hasWebsite, locationContains=$locationContains, maxFollowers=$maxFollowers, maxFollowing=$maxFollowing, maxStatuses=$maxStatuses, minAccountAgeDays=$minAccountAgeDays, minFollowers=$minFollowers, minFollowing=$minFollowing, minStatuses=$minStatuses, pageSize=$pageSize, usernameContains=$usernameContains, verifiedOnly=$verifiedOnly, verifiedType=$verifiedType, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
