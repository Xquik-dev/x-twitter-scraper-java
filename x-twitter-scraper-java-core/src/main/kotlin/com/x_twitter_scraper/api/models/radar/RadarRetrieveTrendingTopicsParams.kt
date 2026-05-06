// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.radar

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

/** Get trending topics from curated sources */
class RadarRetrieveTrendingTopicsParams
private constructor(
    private val after: String?,
    private val category: Category?,
    private val hours: Long?,
    private val limit: Long?,
    private val region: String?,
    private val source: Source?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Cursor for pagination (from prior response nextCursor). */
    fun after(): Optional<String> = Optional.ofNullable(after)

    /** Filter by category. */
    fun category(): Optional<Category> = Optional.ofNullable(category)

    /** Lookback window in hours (1-168, default 24). */
    fun hours(): Optional<Long> = Optional.ofNullable(hours)

    /** Number of items to return (1-100, default 50). */
    fun limit(): Optional<Long> = Optional.ofNullable(limit)

    /** Region filter (us, global, etc.) */
    fun region(): Optional<String> = Optional.ofNullable(region)

    /**
     * Source filter. One of: github, google_trends, hacker_news, polymarket, reddit, trustmrr,
     * wikipedia
     */
    fun source(): Optional<Source> = Optional.ofNullable(source)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): RadarRetrieveTrendingTopicsParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of
         * [RadarRetrieveTrendingTopicsParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RadarRetrieveTrendingTopicsParams]. */
    class Builder internal constructor() {

        private var after: String? = null
        private var category: Category? = null
        private var hours: Long? = null
        private var limit: Long? = null
        private var region: String? = null
        private var source: Source? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(radarRetrieveTrendingTopicsParams: RadarRetrieveTrendingTopicsParams) =
            apply {
                after = radarRetrieveTrendingTopicsParams.after
                category = radarRetrieveTrendingTopicsParams.category
                hours = radarRetrieveTrendingTopicsParams.hours
                limit = radarRetrieveTrendingTopicsParams.limit
                region = radarRetrieveTrendingTopicsParams.region
                source = radarRetrieveTrendingTopicsParams.source
                additionalHeaders = radarRetrieveTrendingTopicsParams.additionalHeaders.toBuilder()
                additionalQueryParams =
                    radarRetrieveTrendingTopicsParams.additionalQueryParams.toBuilder()
            }

        /** Cursor for pagination (from prior response nextCursor). */
        fun after(after: String?) = apply { this.after = after }

        /** Alias for calling [Builder.after] with `after.orElse(null)`. */
        fun after(after: Optional<String>) = after(after.getOrNull())

        /** Filter by category. */
        fun category(category: Category?) = apply { this.category = category }

        /** Alias for calling [Builder.category] with `category.orElse(null)`. */
        fun category(category: Optional<Category>) = category(category.getOrNull())

        /** Lookback window in hours (1-168, default 24). */
        fun hours(hours: Long?) = apply { this.hours = hours }

        /**
         * Alias for [Builder.hours].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun hours(hours: Long) = hours(hours as Long?)

        /** Alias for calling [Builder.hours] with `hours.orElse(null)`. */
        fun hours(hours: Optional<Long>) = hours(hours.getOrNull())

        /** Number of items to return (1-100, default 50). */
        fun limit(limit: Long?) = apply { this.limit = limit }

        /**
         * Alias for [Builder.limit].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun limit(limit: Long) = limit(limit as Long?)

        /** Alias for calling [Builder.limit] with `limit.orElse(null)`. */
        fun limit(limit: Optional<Long>) = limit(limit.getOrNull())

        /** Region filter (us, global, etc.) */
        fun region(region: String?) = apply { this.region = region }

        /** Alias for calling [Builder.region] with `region.orElse(null)`. */
        fun region(region: Optional<String>) = region(region.getOrNull())

        /**
         * Source filter. One of: github, google_trends, hacker_news, polymarket, reddit, trustmrr,
         * wikipedia
         */
        fun source(source: Source?) = apply { this.source = source }

        /** Alias for calling [Builder.source] with `source.orElse(null)`. */
        fun source(source: Optional<Source>) = source(source.getOrNull())

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
         * Returns an immutable instance of [RadarRetrieveTrendingTopicsParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RadarRetrieveTrendingTopicsParams =
            RadarRetrieveTrendingTopicsParams(
                after,
                category,
                hours,
                limit,
                region,
                source,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                after?.let { put("after", it) }
                category?.let { put("category", it.toString()) }
                hours?.let { put("hours", it.toString()) }
                limit?.let { put("limit", it.toString()) }
                region?.let { put("region", it) }
                source?.let { put("source", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    /** Filter by category. */
    class Category @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val GENERAL = of("general")

            @JvmField val TECH = of("tech")

            @JvmField val DEV = of("dev")

            @JvmField val SCIENCE = of("science")

            @JvmField val CULTURE = of("culture")

            @JvmField val POLITICS = of("politics")

            @JvmField val BUSINESS = of("business")

            @JvmField val ENTERTAINMENT = of("entertainment")

            @JvmStatic fun of(value: String) = Category(JsonField.of(value))
        }

        /** An enum containing [Category]'s known values. */
        enum class Known {
            GENERAL,
            TECH,
            DEV,
            SCIENCE,
            CULTURE,
            POLITICS,
            BUSINESS,
            ENTERTAINMENT,
        }

        /**
         * An enum containing [Category]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Category] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            GENERAL,
            TECH,
            DEV,
            SCIENCE,
            CULTURE,
            POLITICS,
            BUSINESS,
            ENTERTAINMENT,
            /** An enum member indicating that [Category] was instantiated with an unknown value. */
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
                GENERAL -> Value.GENERAL
                TECH -> Value.TECH
                DEV -> Value.DEV
                SCIENCE -> Value.SCIENCE
                CULTURE -> Value.CULTURE
                POLITICS -> Value.POLITICS
                BUSINESS -> Value.BUSINESS
                ENTERTAINMENT -> Value.ENTERTAINMENT
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
                GENERAL -> Known.GENERAL
                TECH -> Known.TECH
                DEV -> Known.DEV
                SCIENCE -> Known.SCIENCE
                CULTURE -> Known.CULTURE
                POLITICS -> Known.POLITICS
                BUSINESS -> Known.BUSINESS
                ENTERTAINMENT -> Known.ENTERTAINMENT
                else -> throw XTwitterScraperInvalidDataException("Unknown Category: $value")
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

        fun validate(): Category = apply {
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

            return other is Category && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Source filter. One of: github, google_trends, hacker_news, polymarket, reddit, trustmrr,
     * wikipedia
     */
    class Source @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val GITHUB = of("github")

            @JvmField val GOOGLE_TRENDS = of("google_trends")

            @JvmField val HACKER_NEWS = of("hacker_news")

            @JvmField val POLYMARKET = of("polymarket")

            @JvmField val REDDIT = of("reddit")

            @JvmField val TRUSTMRR = of("trustmrr")

            @JvmField val WIKIPEDIA = of("wikipedia")

            @JvmStatic fun of(value: String) = Source(JsonField.of(value))
        }

        /** An enum containing [Source]'s known values. */
        enum class Known {
            GITHUB,
            GOOGLE_TRENDS,
            HACKER_NEWS,
            POLYMARKET,
            REDDIT,
            TRUSTMRR,
            WIKIPEDIA,
        }

        /**
         * An enum containing [Source]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Source] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            GITHUB,
            GOOGLE_TRENDS,
            HACKER_NEWS,
            POLYMARKET,
            REDDIT,
            TRUSTMRR,
            WIKIPEDIA,
            /** An enum member indicating that [Source] was instantiated with an unknown value. */
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
                GITHUB -> Value.GITHUB
                GOOGLE_TRENDS -> Value.GOOGLE_TRENDS
                HACKER_NEWS -> Value.HACKER_NEWS
                POLYMARKET -> Value.POLYMARKET
                REDDIT -> Value.REDDIT
                TRUSTMRR -> Value.TRUSTMRR
                WIKIPEDIA -> Value.WIKIPEDIA
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
                GITHUB -> Known.GITHUB
                GOOGLE_TRENDS -> Known.GOOGLE_TRENDS
                HACKER_NEWS -> Known.HACKER_NEWS
                POLYMARKET -> Known.POLYMARKET
                REDDIT -> Known.REDDIT
                TRUSTMRR -> Known.TRUSTMRR
                WIKIPEDIA -> Known.WIKIPEDIA
                else -> throw XTwitterScraperInvalidDataException("Unknown Source: $value")
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

        fun validate(): Source = apply {
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

            return other is Source && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RadarRetrieveTrendingTopicsParams &&
            after == other.after &&
            category == other.category &&
            hours == other.hours &&
            limit == other.limit &&
            region == other.region &&
            source == other.source &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            after,
            category,
            hours,
            limit,
            region,
            source,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "RadarRetrieveTrendingTopicsParams{after=$after, category=$category, hours=$hours, limit=$limit, region=$region, source=$source, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
