// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class XGetTrendLocationsResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val count: JsonField<Long>,
    private val locations: JsonField<List<Location>>,
    private val total: JsonField<Long>,
    private val message: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("count") @ExcludeMissing count: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("locations")
        @ExcludeMissing
        locations: JsonField<List<Location>> = JsonMissing.of(),
        @JsonProperty("total") @ExcludeMissing total: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
    ) : this(count, locations, total, message, mutableMapOf())

    /**
     * Locations returned & charged.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun count(): Long = count.getRequired("count")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun locations(): List<Location> = locations.getRequired("locations")

    /**
     * Locations that match the filters, before limit.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun total(): Long = total.getRequired("total")

    /**
     * What to send instead. Present only when no location matches.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun message(): Optional<String> = message.getOptional("message")

    /**
     * Returns the raw JSON value of [count].
     *
     * Unlike [count], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("count") @ExcludeMissing fun _count(): JsonField<Long> = count

    /**
     * Returns the raw JSON value of [locations].
     *
     * Unlike [locations], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("locations")
    @ExcludeMissing
    fun _locations(): JsonField<List<Location>> = locations

    /**
     * Returns the raw JSON value of [total].
     *
     * Unlike [total], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("total") @ExcludeMissing fun _total(): JsonField<Long> = total

    /**
     * Returns the raw JSON value of [message].
     *
     * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [XGetTrendLocationsResponse].
         *
         * The following fields are required:
         * ```java
         * .count()
         * .locations()
         * .total()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [XGetTrendLocationsResponse]. */
    class Builder internal constructor() {

        private var count: JsonField<Long>? = null
        private var locations: JsonField<MutableList<Location>>? = null
        private var total: JsonField<Long>? = null
        private var message: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(xGetTrendLocationsResponse: XGetTrendLocationsResponse) = apply {
            count = xGetTrendLocationsResponse.count
            locations = xGetTrendLocationsResponse.locations.map { it.toMutableList() }
            total = xGetTrendLocationsResponse.total
            message = xGetTrendLocationsResponse.message
            additionalProperties = xGetTrendLocationsResponse.additionalProperties.toMutableMap()
        }

        /** Locations returned & charged. */
        fun count(count: Long) = count(JsonField.of(count))

        /** Sets [Builder.count] to an arbitrary JSON value. */
        fun count(count: JsonField<Long>) = apply { this.count = count }

        fun locations(locations: List<Location>) = locations(JsonField.of(locations))

        /** Sets [Builder.locations] to an arbitrary JSON value. */
        fun locations(locations: JsonField<List<Location>>) = apply {
            this.locations = locations.map { it.toMutableList() }
        }

        /**
         * Adds a single [Location] to [locations].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addLocation(location: Location) = apply {
            locations =
                (locations ?: JsonField.of(mutableListOf())).also {
                    checkKnown("locations", it).add(location)
                }
        }

        /** Locations that match the filters, before limit. */
        fun total(total: Long) = total(JsonField.of(total))

        /** Sets [Builder.total] to an arbitrary JSON value. */
        fun total(total: JsonField<Long>) = apply { this.total = total }

        /** What to send instead. Present only when no location matches. */
        fun message(message: String) = message(JsonField.of(message))

        /** Sets [Builder.message] to an arbitrary JSON value. */
        fun message(message: JsonField<String>) = apply { this.message = message }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [XGetTrendLocationsResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .count()
         * .locations()
         * .total()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): XGetTrendLocationsResponse =
            XGetTrendLocationsResponse(
                checkRequired("count", count),
                checkRequired("locations", locations).map { it.toImmutable() },
                checkRequired("total", total),
                message,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match
     *   its expected type.
     */
    fun validate(): XGetTrendLocationsResponse = apply {
        if (validated) {
            return@apply
        }

        count()
        locations().forEach { it.validate() }
        total()
        message()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: XTwitterScraperInvalidDataException) {
            false
        }

    @JvmSynthetic
    internal fun validity(): Int =
        (if (count.asKnown().isPresent) 1 else 0) +
            (locations.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (if (total.asKnown().isPresent) 1 else 0) +
            (if (message.asKnown().isPresent) 1 else 0)

    /** A place X offers trends for. */
    class Location
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val country: JsonField<String>,
        private val countryCode: JsonField<String>,
        private val name: JsonField<String>,
        private val parentWoeid: JsonField<Long>,
        private val placeType: JsonField<String>,
        private val placeTypeCode: JsonField<Long>,
        private val url: JsonField<String>,
        private val woeid: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("country") @ExcludeMissing country: JsonField<String> = JsonMissing.of(),
            @JsonProperty("countryCode")
            @ExcludeMissing
            countryCode: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("parentWoeid")
            @ExcludeMissing
            parentWoeid: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("placeType")
            @ExcludeMissing
            placeType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("placeTypeCode")
            @ExcludeMissing
            placeTypeCode: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
            @JsonProperty("woeid") @ExcludeMissing woeid: JsonField<Long> = JsonMissing.of(),
        ) : this(
            country,
            countryCode,
            name,
            parentWoeid,
            placeType,
            placeTypeCode,
            url,
            woeid,
            mutableMapOf(),
        )

        /**
         * Country name. Null for Worldwide.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun country(): Optional<String> = country.getOptional("country")

        /**
         * 2-letter country code. Null for Worldwide.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun countryCode(): Optional<String> = countryCode.getOptional("countryCode")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun name(): String = name.getRequired("name")

        /**
         * WOEID of the country or region above it. Null for Worldwide.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun parentWoeid(): Optional<Long> = parentWoeid.getOptional("parentWoeid")

        /**
         * X's kind of place. Town, Country, Supername for Worldwide, or Unknown.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun placeType(): Optional<String> = placeType.getOptional("placeType")

        /**
         * X's numeric code for the kind of place.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun placeTypeCode(): Optional<Long> = placeTypeCode.getOptional("placeTypeCode")

        /**
         * X's legacy Yahoo GeoPlanet reference. It may not resolve.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun url(): Optional<String> = url.getOptional("url")

        /**
         * Location ID. Pass it as woeid to /x/trends.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun woeid(): Long = woeid.getRequired("woeid")

        /**
         * Returns the raw JSON value of [country].
         *
         * Unlike [country], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("country") @ExcludeMissing fun _country(): JsonField<String> = country

        /**
         * Returns the raw JSON value of [countryCode].
         *
         * Unlike [countryCode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("countryCode")
        @ExcludeMissing
        fun _countryCode(): JsonField<String> = countryCode

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [parentWoeid].
         *
         * Unlike [parentWoeid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("parentWoeid")
        @ExcludeMissing
        fun _parentWoeid(): JsonField<Long> = parentWoeid

        /**
         * Returns the raw JSON value of [placeType].
         *
         * Unlike [placeType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("placeType") @ExcludeMissing fun _placeType(): JsonField<String> = placeType

        /**
         * Returns the raw JSON value of [placeTypeCode].
         *
         * Unlike [placeTypeCode], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("placeTypeCode")
        @ExcludeMissing
        fun _placeTypeCode(): JsonField<Long> = placeTypeCode

        /**
         * Returns the raw JSON value of [url].
         *
         * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

        /**
         * Returns the raw JSON value of [woeid].
         *
         * Unlike [woeid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("woeid") @ExcludeMissing fun _woeid(): JsonField<Long> = woeid

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Location].
             *
             * The following fields are required:
             * ```java
             * .country()
             * .countryCode()
             * .name()
             * .parentWoeid()
             * .placeType()
             * .placeTypeCode()
             * .url()
             * .woeid()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Location]. */
        class Builder internal constructor() {

            private var country: JsonField<String>? = null
            private var countryCode: JsonField<String>? = null
            private var name: JsonField<String>? = null
            private var parentWoeid: JsonField<Long>? = null
            private var placeType: JsonField<String>? = null
            private var placeTypeCode: JsonField<Long>? = null
            private var url: JsonField<String>? = null
            private var woeid: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(location: Location) = apply {
                country = location.country
                countryCode = location.countryCode
                name = location.name
                parentWoeid = location.parentWoeid
                placeType = location.placeType
                placeTypeCode = location.placeTypeCode
                url = location.url
                woeid = location.woeid
                additionalProperties = location.additionalProperties.toMutableMap()
            }

            /** Country name. Null for Worldwide. */
            fun country(country: String?) = country(JsonField.ofNullable(country))

            /** Alias for calling [Builder.country] with `country.orElse(null)`. */
            fun country(country: Optional<String>) = country(country.getOrNull())

            /** Sets [Builder.country] to an arbitrary JSON value. */
            fun country(country: JsonField<String>) = apply { this.country = country }

            /** 2-letter country code. Null for Worldwide. */
            fun countryCode(countryCode: String?) = countryCode(JsonField.ofNullable(countryCode))

            /** Alias for calling [Builder.countryCode] with `countryCode.orElse(null)`. */
            fun countryCode(countryCode: Optional<String>) = countryCode(countryCode.getOrNull())

            /** Sets [Builder.countryCode] to an arbitrary JSON value. */
            fun countryCode(countryCode: JsonField<String>) = apply {
                this.countryCode = countryCode
            }

            fun name(name: String) = name(JsonField.of(name))

            /** Sets [Builder.name] to an arbitrary JSON value. */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** WOEID of the country or region above it. Null for Worldwide. */
            fun parentWoeid(parentWoeid: Long?) = parentWoeid(JsonField.ofNullable(parentWoeid))

            /** Alias for [Builder.parentWoeid]. */
            fun parentWoeid(parentWoeid: Long) = parentWoeid(parentWoeid as Long?)

            /** Alias for calling [Builder.parentWoeid] with `parentWoeid.orElse(null)`. */
            fun parentWoeid(parentWoeid: Optional<Long>) = parentWoeid(parentWoeid.getOrNull())

            /** Sets [Builder.parentWoeid] to an arbitrary JSON value. */
            fun parentWoeid(parentWoeid: JsonField<Long>) = apply { this.parentWoeid = parentWoeid }

            /** X's kind of place. Town, Country, Supername for Worldwide, or Unknown. */
            fun placeType(placeType: String?) = placeType(JsonField.ofNullable(placeType))

            /** Alias for calling [Builder.placeType] with `placeType.orElse(null)`. */
            fun placeType(placeType: Optional<String>) = placeType(placeType.getOrNull())

            /** Sets [Builder.placeType] to an arbitrary JSON value. */
            fun placeType(placeType: JsonField<String>) = apply { this.placeType = placeType }

            /** X's numeric code for the kind of place. */
            fun placeTypeCode(placeTypeCode: Long?) =
                placeTypeCode(JsonField.ofNullable(placeTypeCode))

            /** Alias for [Builder.placeTypeCode]. */
            fun placeTypeCode(placeTypeCode: Long) = placeTypeCode(placeTypeCode as Long?)

            /** Alias for calling [Builder.placeTypeCode] with `placeTypeCode.orElse(null)`. */
            fun placeTypeCode(placeTypeCode: Optional<Long>) =
                placeTypeCode(placeTypeCode.getOrNull())

            /** Sets [Builder.placeTypeCode] to an arbitrary JSON value. */
            fun placeTypeCode(placeTypeCode: JsonField<Long>) = apply {
                this.placeTypeCode = placeTypeCode
            }

            /** X's legacy Yahoo GeoPlanet reference. It may not resolve. */
            fun url(url: String?) = url(JsonField.ofNullable(url))

            /** Alias for calling [Builder.url] with `url.orElse(null)`. */
            fun url(url: Optional<String>) = url(url.getOrNull())

            /** Sets [Builder.url] to an arbitrary JSON value. */
            fun url(url: JsonField<String>) = apply { this.url = url }

            /** Location ID. Pass it as woeid to /x/trends. */
            fun woeid(woeid: Long) = woeid(JsonField.of(woeid))

            /** Sets [Builder.woeid] to an arbitrary JSON value. */
            fun woeid(woeid: JsonField<Long>) = apply { this.woeid = woeid }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Location].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .country()
             * .countryCode()
             * .name()
             * .parentWoeid()
             * .placeType()
             * .placeTypeCode()
             * .url()
             * .woeid()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Location =
                Location(
                    checkRequired("country", country),
                    checkRequired("countryCode", countryCode),
                    checkRequired("name", name),
                    checkRequired("parentWoeid", parentWoeid),
                    checkRequired("placeType", placeType),
                    checkRequired("placeTypeCode", placeTypeCode),
                    checkRequired("url", url),
                    checkRequired("woeid", woeid),
                    additionalProperties.toMutableMap(),
                )
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
        fun validate(): Location = apply {
            if (validated) {
                return@apply
            }

            country()
            countryCode()
            name()
            parentWoeid()
            placeType()
            placeTypeCode()
            url()
            woeid()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        @JvmSynthetic
        internal fun validity(): Int =
            (if (country.asKnown().isPresent) 1 else 0) +
                (if (countryCode.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (parentWoeid.asKnown().isPresent) 1 else 0) +
                (if (placeType.asKnown().isPresent) 1 else 0) +
                (if (placeTypeCode.asKnown().isPresent) 1 else 0) +
                (if (url.asKnown().isPresent) 1 else 0) +
                (if (woeid.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Location &&
                country == other.country &&
                countryCode == other.countryCode &&
                name == other.name &&
                parentWoeid == other.parentWoeid &&
                placeType == other.placeType &&
                placeTypeCode == other.placeTypeCode &&
                url == other.url &&
                woeid == other.woeid &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                country,
                countryCode,
                name,
                parentWoeid,
                placeType,
                placeTypeCode,
                url,
                woeid,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Location{country=$country, countryCode=$countryCode, name=$name, parentWoeid=$parentWoeid, placeType=$placeType, placeTypeCode=$placeTypeCode, url=$url, woeid=$woeid, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is XGetTrendLocationsResponse &&
            count == other.count &&
            locations == other.locations &&
            total == other.total &&
            message == other.message &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(count, locations, total, message, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "XGetTrendLocationsResponse{count=$count, locations=$locations, total=$total, message=$message, additionalProperties=$additionalProperties}"
}
