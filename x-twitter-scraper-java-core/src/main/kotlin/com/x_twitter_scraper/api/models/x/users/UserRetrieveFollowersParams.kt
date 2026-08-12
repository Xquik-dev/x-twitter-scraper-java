// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.users

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

/** List followers of a user */
class UserRetrieveFollowersParams
private constructor(
    private val id: String?,
    private val after: String?,
    private val bioContains: String?,
    private val cursor: String?,
    private val hasLocation: Boolean?,
    private val hasWebsite: Boolean?,
    private val limit: Long?,
    private val locationContains: String?,
    private val maxFollowers: Long?,
    private val maxFollowing: Long?,
    private val maxStatuses: Long?,
    private val minAccountAgeDays: Long?,
    private val minFollowers: Long?,
    private val minFollowing: Long?,
    private val minStatuses: Long?,
    private val mode: Mode?,
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
     * Cursor from the previous response. Xquik cursors resume automatic coverage. Existing
     * unprefixed cursors keep legacy standard behavior.
     */
    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    /** Only return profiles with a location. */
    fun hasLocation(): Optional<Boolean> = Optional.ofNullable(hasLocation)

    /** Only return profiles with a website. */
    fun hasWebsite(): Optional<Boolean> = Optional.ofNullable(hasWebsite)

    /**
     * Legacy page-size alias outside explicit coverage mode. Coverage accepts 1-10000. Prefer
     * pageSize.
     */
    fun limit(): Optional<Long> = Optional.ofNullable(limit)

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

    /**
     * Omit mode for resumable maximum coverage. Standard keeps legacy pagination. Coverage returns
     * diagnostics once and rejects cursors.
     */
    fun mode(): Optional<Mode> = Optional.ofNullable(mode)

    /**
     * Maximum user profiles: automatic 300; standard 200. Sources return fewer profiles. Continue
     * with has_next_page.
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

        @JvmStatic fun none(): UserRetrieveFollowersParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of [UserRetrieveFollowersParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UserRetrieveFollowersParams]. */
    class Builder internal constructor() {

        private var id: String? = null
        private var after: String? = null
        private var bioContains: String? = null
        private var cursor: String? = null
        private var hasLocation: Boolean? = null
        private var hasWebsite: Boolean? = null
        private var limit: Long? = null
        private var locationContains: String? = null
        private var maxFollowers: Long? = null
        private var maxFollowing: Long? = null
        private var maxStatuses: Long? = null
        private var minAccountAgeDays: Long? = null
        private var minFollowers: Long? = null
        private var minFollowing: Long? = null
        private var minStatuses: Long? = null
        private var mode: Mode? = null
        private var pageSize: Long? = null
        private var usernameContains: String? = null
        private var verifiedOnly: Boolean? = null
        private var verifiedType: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(userRetrieveFollowersParams: UserRetrieveFollowersParams) = apply {
            id = userRetrieveFollowersParams.id
            after = userRetrieveFollowersParams.after
            bioContains = userRetrieveFollowersParams.bioContains
            cursor = userRetrieveFollowersParams.cursor
            hasLocation = userRetrieveFollowersParams.hasLocation
            hasWebsite = userRetrieveFollowersParams.hasWebsite
            limit = userRetrieveFollowersParams.limit
            locationContains = userRetrieveFollowersParams.locationContains
            maxFollowers = userRetrieveFollowersParams.maxFollowers
            maxFollowing = userRetrieveFollowersParams.maxFollowing
            maxStatuses = userRetrieveFollowersParams.maxStatuses
            minAccountAgeDays = userRetrieveFollowersParams.minAccountAgeDays
            minFollowers = userRetrieveFollowersParams.minFollowers
            minFollowing = userRetrieveFollowersParams.minFollowing
            minStatuses = userRetrieveFollowersParams.minStatuses
            mode = userRetrieveFollowersParams.mode
            pageSize = userRetrieveFollowersParams.pageSize
            usernameContains = userRetrieveFollowersParams.usernameContains
            verifiedOnly = userRetrieveFollowersParams.verifiedOnly
            verifiedType = userRetrieveFollowersParams.verifiedType
            additionalHeaders = userRetrieveFollowersParams.additionalHeaders.toBuilder()
            additionalQueryParams = userRetrieveFollowersParams.additionalQueryParams.toBuilder()
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
         * Cursor from the previous response. Xquik cursors resume automatic coverage. Existing
         * unprefixed cursors keep legacy standard behavior.
         */
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

        /**
         * Legacy page-size alias outside explicit coverage mode. Coverage accepts 1-10000. Prefer
         * pageSize.
         */
        fun limit(limit: Long?) = apply { this.limit = limit }

        /**
         * Alias for [Builder.limit].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun limit(limit: Long) = limit(limit as Long?)

        /** Alias for calling [Builder.limit] with `limit.orElse(null)`. */
        fun limit(limit: Optional<Long>) = limit(limit.getOrNull())

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

        /**
         * Omit mode for resumable maximum coverage. Standard keeps legacy pagination. Coverage
         * returns diagnostics once and rejects cursors.
         */
        fun mode(mode: Mode?) = apply { this.mode = mode }

        /** Alias for calling [Builder.mode] with `mode.orElse(null)`. */
        fun mode(mode: Optional<Mode>) = mode(mode.getOrNull())

        /**
         * Maximum user profiles: automatic 300; standard 200. Sources return fewer profiles.
         * Continue with has_next_page.
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
         * Returns an immutable instance of [UserRetrieveFollowersParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): UserRetrieveFollowersParams =
            UserRetrieveFollowersParams(
                id,
                after,
                bioContains,
                cursor,
                hasLocation,
                hasWebsite,
                limit,
                locationContains,
                maxFollowers,
                maxFollowing,
                maxStatuses,
                minAccountAgeDays,
                minFollowers,
                minFollowing,
                minStatuses,
                mode,
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
                cursor?.let { put("cursor", it) }
                hasLocation?.let { put("hasLocation", it.toString()) }
                hasWebsite?.let { put("hasWebsite", it.toString()) }
                limit?.let { put("limit", it.toString()) }
                locationContains?.let { put("locationContains", it) }
                maxFollowers?.let { put("maxFollowers", it.toString()) }
                maxFollowing?.let { put("maxFollowing", it.toString()) }
                maxStatuses?.let { put("maxStatuses", it.toString()) }
                minAccountAgeDays?.let { put("minAccountAgeDays", it.toString()) }
                minFollowers?.let { put("minFollowers", it.toString()) }
                minFollowing?.let { put("minFollowing", it.toString()) }
                minStatuses?.let { put("minStatuses", it.toString()) }
                mode?.let { put("mode", it.toString()) }
                pageSize?.let { put("pageSize", it.toString()) }
                usernameContains?.let { put("usernameContains", it) }
                verifiedOnly?.let { put("verifiedOnly", it.toString()) }
                verifiedType?.let { put("verifiedType", it) }
                putAll(additionalQueryParams)
            }
            .build()

    /**
     * Omit mode for resumable maximum coverage. Standard keeps legacy pagination. Coverage returns
     * diagnostics once and rejects cursors.
     */
    class Mode @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
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
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
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

            return other is Mode && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UserRetrieveFollowersParams &&
            id == other.id &&
            after == other.after &&
            bioContains == other.bioContains &&
            cursor == other.cursor &&
            hasLocation == other.hasLocation &&
            hasWebsite == other.hasWebsite &&
            limit == other.limit &&
            locationContains == other.locationContains &&
            maxFollowers == other.maxFollowers &&
            maxFollowing == other.maxFollowing &&
            maxStatuses == other.maxStatuses &&
            minAccountAgeDays == other.minAccountAgeDays &&
            minFollowers == other.minFollowers &&
            minFollowing == other.minFollowing &&
            minStatuses == other.minStatuses &&
            mode == other.mode &&
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
            cursor,
            hasLocation,
            hasWebsite,
            limit,
            locationContains,
            maxFollowers,
            maxFollowing,
            maxStatuses,
            minAccountAgeDays,
            minFollowers,
            minFollowing,
            minStatuses,
            mode,
            pageSize,
            usernameContains,
            verifiedOnly,
            verifiedType,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "UserRetrieveFollowersParams{id=$id, after=$after, bioContains=$bioContains, cursor=$cursor, hasLocation=$hasLocation, hasWebsite=$hasWebsite, limit=$limit, locationContains=$locationContains, maxFollowers=$maxFollowers, maxFollowing=$maxFollowing, maxStatuses=$maxStatuses, minAccountAgeDays=$minAccountAgeDays, minFollowers=$minFollowers, minFollowing=$minFollowing, minStatuses=$minStatuses, mode=$mode, pageSize=$pageSize, usernameContains=$usernameContains, verifiedOnly=$verifiedOnly, verifiedType=$verifiedType, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
