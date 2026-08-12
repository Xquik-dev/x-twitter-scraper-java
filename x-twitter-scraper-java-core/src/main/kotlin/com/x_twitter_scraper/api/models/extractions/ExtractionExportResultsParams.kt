// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.extractions

import com.fasterxml.jackson.annotation.JsonCreator
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.time.LocalDate
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Export extraction results */
class ExtractionExportResultsParams
private constructor(
    private val id: String?,
    private val format: Format,
    private val hasDescription: Boolean?,
    private val hasLocation: Boolean?,
    private val hasMedia: Boolean?,
    private val lang: String?,
    private val maxFollowers: Long?,
    private val maxFollowing: Long?,
    private val maxPosts: Long?,
    private val minFollowers: Long?,
    private val minFollowing: Long?,
    private val minLikes: Long?,
    private val minPosts: Long?,
    private val minReplies: Long?,
    private val minRetweets: Long?,
    private val minViews: Long?,
    private val search: String?,
    private val sinceDate: LocalDate?,
    private val untilDate: LocalDate?,
    private val verified: Boolean?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun id(): Optional<String> = Optional.ofNullable(id)

    /** Export file format */
    fun format(): Format = format

    /** Require a non-empty description. */
    fun hasDescription(): Optional<Boolean> = Optional.ofNullable(hasDescription)

    /** Require a non-empty location. */
    fun hasLocation(): Optional<Boolean> = Optional.ofNullable(hasLocation)

    /** Require media. */
    fun hasMedia(): Optional<Boolean> = Optional.ofNullable(hasMedia)

    /** Filter by language code. */
    fun lang(): Optional<String> = Optional.ofNullable(lang)

    /** Maximum follower count. */
    fun maxFollowers(): Optional<Long> = Optional.ofNullable(maxFollowers)

    /** Maximum following count. */
    fun maxFollowing(): Optional<Long> = Optional.ofNullable(maxFollowing)

    /** Maximum post count. */
    fun maxPosts(): Optional<Long> = Optional.ofNullable(maxPosts)

    /** Minimum follower count. */
    fun minFollowers(): Optional<Long> = Optional.ofNullable(minFollowers)

    /** Minimum following count. */
    fun minFollowing(): Optional<Long> = Optional.ofNullable(minFollowing)

    /** Minimum like count. */
    fun minLikes(): Optional<Long> = Optional.ofNullable(minLikes)

    /** Minimum post count. */
    fun minPosts(): Optional<Long> = Optional.ofNullable(minPosts)

    /** Minimum reply count. */
    fun minReplies(): Optional<Long> = Optional.ofNullable(minReplies)

    /** Minimum repost count. */
    fun minRetweets(): Optional<Long> = Optional.ofNullable(minRetweets)

    /** Minimum view count. */
    fun minViews(): Optional<Long> = Optional.ofNullable(minViews)

    /** Search exported result text. */
    fun search(): Optional<String> = Optional.ofNullable(search)

    /** Include results on or after this date. */
    fun sinceDate(): Optional<LocalDate> = Optional.ofNullable(sinceDate)

    /** Include results on or before this date. */
    fun untilDate(): Optional<LocalDate> = Optional.ofNullable(untilDate)

    /** Filter by verified status. */
    fun verified(): Optional<Boolean> = Optional.ofNullable(verified)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [ExtractionExportResultsParams].
         *
         * The following fields are required:
         * ```java
         * .format()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ExtractionExportResultsParams]. */
    class Builder internal constructor() {

        private var id: String? = null
        private var format: Format? = null
        private var hasDescription: Boolean? = null
        private var hasLocation: Boolean? = null
        private var hasMedia: Boolean? = null
        private var lang: String? = null
        private var maxFollowers: Long? = null
        private var maxFollowing: Long? = null
        private var maxPosts: Long? = null
        private var minFollowers: Long? = null
        private var minFollowing: Long? = null
        private var minLikes: Long? = null
        private var minPosts: Long? = null
        private var minReplies: Long? = null
        private var minRetweets: Long? = null
        private var minViews: Long? = null
        private var search: String? = null
        private var sinceDate: LocalDate? = null
        private var untilDate: LocalDate? = null
        private var verified: Boolean? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(extractionExportResultsParams: ExtractionExportResultsParams) = apply {
            id = extractionExportResultsParams.id
            format = extractionExportResultsParams.format
            hasDescription = extractionExportResultsParams.hasDescription
            hasLocation = extractionExportResultsParams.hasLocation
            hasMedia = extractionExportResultsParams.hasMedia
            lang = extractionExportResultsParams.lang
            maxFollowers = extractionExportResultsParams.maxFollowers
            maxFollowing = extractionExportResultsParams.maxFollowing
            maxPosts = extractionExportResultsParams.maxPosts
            minFollowers = extractionExportResultsParams.minFollowers
            minFollowing = extractionExportResultsParams.minFollowing
            minLikes = extractionExportResultsParams.minLikes
            minPosts = extractionExportResultsParams.minPosts
            minReplies = extractionExportResultsParams.minReplies
            minRetweets = extractionExportResultsParams.minRetweets
            minViews = extractionExportResultsParams.minViews
            search = extractionExportResultsParams.search
            sinceDate = extractionExportResultsParams.sinceDate
            untilDate = extractionExportResultsParams.untilDate
            verified = extractionExportResultsParams.verified
            additionalHeaders = extractionExportResultsParams.additionalHeaders.toBuilder()
            additionalQueryParams = extractionExportResultsParams.additionalQueryParams.toBuilder()
        }

        fun id(id: String?) = apply { this.id = id }

        /** Alias for calling [Builder.id] with `id.orElse(null)`. */
        fun id(id: Optional<String>) = id(id.getOrNull())

        /** Export file format */
        fun format(format: Format) = apply { this.format = format }

        /** Require a non-empty description. */
        fun hasDescription(hasDescription: Boolean?) = apply {
            this.hasDescription = hasDescription
        }

        /**
         * Alias for [Builder.hasDescription].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun hasDescription(hasDescription: Boolean) = hasDescription(hasDescription as Boolean?)

        /** Alias for calling [Builder.hasDescription] with `hasDescription.orElse(null)`. */
        fun hasDescription(hasDescription: Optional<Boolean>) =
            hasDescription(hasDescription.getOrNull())

        /** Require a non-empty location. */
        fun hasLocation(hasLocation: Boolean?) = apply { this.hasLocation = hasLocation }

        /**
         * Alias for [Builder.hasLocation].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun hasLocation(hasLocation: Boolean) = hasLocation(hasLocation as Boolean?)

        /** Alias for calling [Builder.hasLocation] with `hasLocation.orElse(null)`. */
        fun hasLocation(hasLocation: Optional<Boolean>) = hasLocation(hasLocation.getOrNull())

        /** Require media. */
        fun hasMedia(hasMedia: Boolean?) = apply { this.hasMedia = hasMedia }

        /**
         * Alias for [Builder.hasMedia].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun hasMedia(hasMedia: Boolean) = hasMedia(hasMedia as Boolean?)

        /** Alias for calling [Builder.hasMedia] with `hasMedia.orElse(null)`. */
        fun hasMedia(hasMedia: Optional<Boolean>) = hasMedia(hasMedia.getOrNull())

        /** Filter by language code. */
        fun lang(lang: String?) = apply { this.lang = lang }

        /** Alias for calling [Builder.lang] with `lang.orElse(null)`. */
        fun lang(lang: Optional<String>) = lang(lang.getOrNull())

        /** Maximum follower count. */
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

        /** Maximum post count. */
        fun maxPosts(maxPosts: Long?) = apply { this.maxPosts = maxPosts }

        /**
         * Alias for [Builder.maxPosts].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun maxPosts(maxPosts: Long) = maxPosts(maxPosts as Long?)

        /** Alias for calling [Builder.maxPosts] with `maxPosts.orElse(null)`. */
        fun maxPosts(maxPosts: Optional<Long>) = maxPosts(maxPosts.getOrNull())

        /** Minimum follower count. */
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

        /** Minimum like count. */
        fun minLikes(minLikes: Long?) = apply { this.minLikes = minLikes }

        /**
         * Alias for [Builder.minLikes].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun minLikes(minLikes: Long) = minLikes(minLikes as Long?)

        /** Alias for calling [Builder.minLikes] with `minLikes.orElse(null)`. */
        fun minLikes(minLikes: Optional<Long>) = minLikes(minLikes.getOrNull())

        /** Minimum post count. */
        fun minPosts(minPosts: Long?) = apply { this.minPosts = minPosts }

        /**
         * Alias for [Builder.minPosts].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun minPosts(minPosts: Long) = minPosts(minPosts as Long?)

        /** Alias for calling [Builder.minPosts] with `minPosts.orElse(null)`. */
        fun minPosts(minPosts: Optional<Long>) = minPosts(minPosts.getOrNull())

        /** Minimum reply count. */
        fun minReplies(minReplies: Long?) = apply { this.minReplies = minReplies }

        /**
         * Alias for [Builder.minReplies].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun minReplies(minReplies: Long) = minReplies(minReplies as Long?)

        /** Alias for calling [Builder.minReplies] with `minReplies.orElse(null)`. */
        fun minReplies(minReplies: Optional<Long>) = minReplies(minReplies.getOrNull())

        /** Minimum repost count. */
        fun minRetweets(minRetweets: Long?) = apply { this.minRetweets = minRetweets }

        /**
         * Alias for [Builder.minRetweets].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun minRetweets(minRetweets: Long) = minRetweets(minRetweets as Long?)

        /** Alias for calling [Builder.minRetweets] with `minRetweets.orElse(null)`. */
        fun minRetweets(minRetweets: Optional<Long>) = minRetweets(minRetweets.getOrNull())

        /** Minimum view count. */
        fun minViews(minViews: Long?) = apply { this.minViews = minViews }

        /**
         * Alias for [Builder.minViews].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun minViews(minViews: Long) = minViews(minViews as Long?)

        /** Alias for calling [Builder.minViews] with `minViews.orElse(null)`. */
        fun minViews(minViews: Optional<Long>) = minViews(minViews.getOrNull())

        /** Search exported result text. */
        fun search(search: String?) = apply { this.search = search }

        /** Alias for calling [Builder.search] with `search.orElse(null)`. */
        fun search(search: Optional<String>) = search(search.getOrNull())

        /** Include results on or after this date. */
        fun sinceDate(sinceDate: LocalDate?) = apply { this.sinceDate = sinceDate }

        /** Alias for calling [Builder.sinceDate] with `sinceDate.orElse(null)`. */
        fun sinceDate(sinceDate: Optional<LocalDate>) = sinceDate(sinceDate.getOrNull())

        /** Include results on or before this date. */
        fun untilDate(untilDate: LocalDate?) = apply { this.untilDate = untilDate }

        /** Alias for calling [Builder.untilDate] with `untilDate.orElse(null)`. */
        fun untilDate(untilDate: Optional<LocalDate>) = untilDate(untilDate.getOrNull())

        /** Filter by verified status. */
        fun verified(verified: Boolean?) = apply { this.verified = verified }

        /**
         * Alias for [Builder.verified].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun verified(verified: Boolean) = verified(verified as Boolean?)

        /** Alias for calling [Builder.verified] with `verified.orElse(null)`. */
        fun verified(verified: Optional<Boolean>) = verified(verified.getOrNull())

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
         * Returns an immutable instance of [ExtractionExportResultsParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .format()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ExtractionExportResultsParams =
            ExtractionExportResultsParams(
                id,
                checkRequired("format", format),
                hasDescription,
                hasLocation,
                hasMedia,
                lang,
                maxFollowers,
                maxFollowing,
                maxPosts,
                minFollowers,
                minFollowing,
                minLikes,
                minPosts,
                minReplies,
                minRetweets,
                minViews,
                search,
                sinceDate,
                untilDate,
                verified,
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
                put("format", format.toString())
                hasDescription?.let { put("hasDescription", it.toString()) }
                hasLocation?.let { put("hasLocation", it.toString()) }
                hasMedia?.let { put("hasMedia", it.toString()) }
                lang?.let { put("lang", it) }
                maxFollowers?.let { put("maxFollowers", it.toString()) }
                maxFollowing?.let { put("maxFollowing", it.toString()) }
                maxPosts?.let { put("maxPosts", it.toString()) }
                minFollowers?.let { put("minFollowers", it.toString()) }
                minFollowing?.let { put("minFollowing", it.toString()) }
                minLikes?.let { put("minLikes", it.toString()) }
                minPosts?.let { put("minPosts", it.toString()) }
                minReplies?.let { put("minReplies", it.toString()) }
                minRetweets?.let { put("minRetweets", it.toString()) }
                minViews?.let { put("minViews", it.toString()) }
                search?.let { put("search", it) }
                sinceDate?.let { put("sinceDate", it.toString()) }
                untilDate?.let { put("untilDate", it.toString()) }
                verified?.let { put("verified", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    /** Export file format */
    class Format @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val CSV = of("csv")

            @JvmField val JSON = of("json")

            @JvmField val MD = of("md")

            @JvmField val MD_DOCUMENT = of("md-document")

            @JvmField val PDF = of("pdf")

            @JvmField val TXT = of("txt")

            @JvmField val XLSX = of("xlsx")

            @JvmStatic fun of(value: String) = Format(JsonField.of(value))
        }

        /** An enum containing [Format]'s known values. */
        enum class Known {
            CSV,
            JSON,
            MD,
            MD_DOCUMENT,
            PDF,
            TXT,
            XLSX,
        }

        /**
         * An enum containing [Format]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Format] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            CSV,
            JSON,
            MD,
            MD_DOCUMENT,
            PDF,
            TXT,
            XLSX,
            /** An enum member indicating that [Format] was instantiated with an unknown value. */
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
                CSV -> Value.CSV
                JSON -> Value.JSON
                MD -> Value.MD
                MD_DOCUMENT -> Value.MD_DOCUMENT
                PDF -> Value.PDF
                TXT -> Value.TXT
                XLSX -> Value.XLSX
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
                CSV -> Known.CSV
                JSON -> Known.JSON
                MD -> Known.MD
                MD_DOCUMENT -> Known.MD_DOCUMENT
                PDF -> Known.PDF
                TXT -> Known.TXT
                XLSX -> Known.XLSX
                else -> throw XTwitterScraperInvalidDataException("Unknown Format: $value")
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
        fun validate(): Format = apply {
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

            return other is Format && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ExtractionExportResultsParams &&
            id == other.id &&
            format == other.format &&
            hasDescription == other.hasDescription &&
            hasLocation == other.hasLocation &&
            hasMedia == other.hasMedia &&
            lang == other.lang &&
            maxFollowers == other.maxFollowers &&
            maxFollowing == other.maxFollowing &&
            maxPosts == other.maxPosts &&
            minFollowers == other.minFollowers &&
            minFollowing == other.minFollowing &&
            minLikes == other.minLikes &&
            minPosts == other.minPosts &&
            minReplies == other.minReplies &&
            minRetweets == other.minRetweets &&
            minViews == other.minViews &&
            search == other.search &&
            sinceDate == other.sinceDate &&
            untilDate == other.untilDate &&
            verified == other.verified &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            id,
            format,
            hasDescription,
            hasLocation,
            hasMedia,
            lang,
            maxFollowers,
            maxFollowing,
            maxPosts,
            minFollowers,
            minFollowing,
            minLikes,
            minPosts,
            minReplies,
            minRetweets,
            minViews,
            search,
            sinceDate,
            untilDate,
            verified,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "ExtractionExportResultsParams{id=$id, format=$format, hasDescription=$hasDescription, hasLocation=$hasLocation, hasMedia=$hasMedia, lang=$lang, maxFollowers=$maxFollowers, maxFollowing=$maxFollowing, maxPosts=$maxPosts, minFollowers=$minFollowers, minFollowing=$minFollowing, minLikes=$minLikes, minPosts=$minPosts, minReplies=$minReplies, minRetweets=$minRetweets, minViews=$minViews, search=$search, sinceDate=$sinceDate, untilDate=$untilDate, verified=$verified, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
