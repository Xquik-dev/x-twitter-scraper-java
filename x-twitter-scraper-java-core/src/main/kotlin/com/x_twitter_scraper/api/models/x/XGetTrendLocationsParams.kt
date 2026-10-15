// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x

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

/**
 * Returns the places X offers trends for. Pass a location's woeid to /x/trends. Each returned
 * location costs 1 credit.
 */
class XGetTrendLocationsParams
private constructor(
    private val country: String?,
    private val fields: String?,
    private val limit: Long?,
    private val omit: String?,
    private val placeType: PlaceType?,
    private val q: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Country name or 2-letter code, such as Turkey or TR. Case insensitive. Returns the country &
     * its towns.
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
     * Maximum locations to return. Omit it for every match. A low credit balance can return fewer.
     * Aliases pageSize, count, max_results, maxItems, max_items & per_page.
     */
    fun limit(): Optional<Long> = Optional.ofNullable(limit)

    /**
     * Fields to drop from each row, comma-separated. It takes the same names as fields. With
     * fields, it drops from the kept fields.
     */
    fun omit(): Optional<String> = Optional.ofNullable(omit)

    /** Kind of place. Case insensitive. X labels a few towns unknown. */
    fun placeType(): Optional<PlaceType> = Optional.ofNullable(placeType)

    /** Text the location name contains, such as york. Case insensitive. Alias query. */
    fun q(): Optional<String> = Optional.ofNullable(q)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): XGetTrendLocationsParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [XGetTrendLocationsParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [XGetTrendLocationsParams]. */
    class Builder internal constructor() {

        private var country: String? = null
        private var fields: String? = null
        private var limit: Long? = null
        private var omit: String? = null
        private var placeType: PlaceType? = null
        private var q: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(xGetTrendLocationsParams: XGetTrendLocationsParams) = apply {
            country = xGetTrendLocationsParams.country
            fields = xGetTrendLocationsParams.fields
            limit = xGetTrendLocationsParams.limit
            omit = xGetTrendLocationsParams.omit
            placeType = xGetTrendLocationsParams.placeType
            q = xGetTrendLocationsParams.q
            additionalHeaders = xGetTrendLocationsParams.additionalHeaders.toBuilder()
            additionalQueryParams = xGetTrendLocationsParams.additionalQueryParams.toBuilder()
        }

        /**
         * Country name or 2-letter code, such as Turkey or TR. Case insensitive. Returns the
         * country & its towns.
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
         * Maximum locations to return. Omit it for every match. A low credit balance can return
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

        /** Kind of place. Case insensitive. X labels a few towns unknown. */
        fun placeType(placeType: PlaceType?) = apply { this.placeType = placeType }

        /** Alias for calling [Builder.placeType] with `placeType.orElse(null)`. */
        fun placeType(placeType: Optional<PlaceType>) = placeType(placeType.getOrNull())

        /** Text the location name contains, such as york. Case insensitive. Alias query. */
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
         * Returns an immutable instance of [XGetTrendLocationsParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): XGetTrendLocationsParams =
            XGetTrendLocationsParams(
                country,
                fields,
                limit,
                omit,
                placeType,
                q,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                country?.let { put("country", it) }
                fields?.let { put("fields", it) }
                limit?.let { put("limit", it.toString()) }
                omit?.let { put("omit", it) }
                placeType?.let { put("placeType", it.toString()) }
                q?.let { put("q", it) }
                putAll(additionalQueryParams)
            }
            .build()

    class PlaceType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val COUNTRY = of("country")

            @JvmField val TOWN = of("town")

            @JvmField val WORLDWIDE = of("worldwide")

            @JvmField val UNKNOWN = of("unknown")

            @JvmStatic fun of(value: String) = PlaceType(JsonField.of(value))
        }

        /** An enum containing [PlaceType]'s known values. */
        enum class Known {
            COUNTRY,
            TOWN,
            WORLDWIDE,
            UNKNOWN,
        }

        /**
         * An enum containing [PlaceType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [PlaceType] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            COUNTRY,
            TOWN,
            WORLDWIDE,
            UNKNOWN,
            /**
             * An enum member indicating that [PlaceType] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         */
        fun value(): Value =
            when (this) {
                COUNTRY -> Value.COUNTRY
                TOWN -> Value.TOWN
                WORLDWIDE -> Value.WORLDWIDE
                UNKNOWN -> Value.UNKNOWN
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
                COUNTRY -> Known.COUNTRY
                TOWN -> Known.TOWN
                WORLDWIDE -> Known.WORLDWIDE
                UNKNOWN -> Known.UNKNOWN
                else -> throw XTwitterScraperInvalidDataException("Unknown PlaceType: $value")
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
        fun validate(): PlaceType = apply {
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

            return other is PlaceType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is XGetTrendLocationsParams &&
            country == other.country &&
            fields == other.fields &&
            limit == other.limit &&
            omit == other.omit &&
            placeType == other.placeType &&
            q == other.q &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            country,
            fields,
            limit,
            omit,
            placeType,
            q,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "XGetTrendLocationsParams{country=$country, fields=$fields, limit=$limit, omit=$omit, placeType=$placeType, q=$q, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
