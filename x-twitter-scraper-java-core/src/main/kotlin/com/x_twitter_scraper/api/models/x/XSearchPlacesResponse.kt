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

class XSearchPlacesResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val count: JsonField<Long>,
    private val places: JsonField<List<Place>>,
    private val total: JsonField<Long>,
    private val message: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("count") @ExcludeMissing count: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("places") @ExcludeMissing places: JsonField<List<Place>> = JsonMissing.of(),
        @JsonProperty("total") @ExcludeMissing total: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
    ) : this(count, places, total, message, mutableMapOf())

    /**
     * Places returned & charged.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun count(): Long = count.getRequired("count")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun places(): List<Place> = places.getRequired("places")

    /**
     * Places X found, before limit.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun total(): Long = total.getRequired("total")

    /**
     * What to send instead. Present only when X finds no place.
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
     * Returns the raw JSON value of [places].
     *
     * Unlike [places], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("places") @ExcludeMissing fun _places(): JsonField<List<Place>> = places

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
         * Returns a mutable builder for constructing an instance of [XSearchPlacesResponse].
         *
         * The following fields are required:
         * ```java
         * .count()
         * .places()
         * .total()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [XSearchPlacesResponse]. */
    class Builder internal constructor() {

        private var count: JsonField<Long>? = null
        private var places: JsonField<MutableList<Place>>? = null
        private var total: JsonField<Long>? = null
        private var message: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(xSearchPlacesResponse: XSearchPlacesResponse) = apply {
            count = xSearchPlacesResponse.count
            places = xSearchPlacesResponse.places.map { it.toMutableList() }
            total = xSearchPlacesResponse.total
            message = xSearchPlacesResponse.message
            additionalProperties = xSearchPlacesResponse.additionalProperties.toMutableMap()
        }

        /** Places returned & charged. */
        fun count(count: Long) = count(JsonField.of(count))

        /** Sets [Builder.count] to an arbitrary JSON value. */
        fun count(count: JsonField<Long>) = apply { this.count = count }

        fun places(places: List<Place>) = places(JsonField.of(places))

        /** Sets [Builder.places] to an arbitrary JSON value. */
        fun places(places: JsonField<List<Place>>) = apply {
            this.places = places.map { it.toMutableList() }
        }

        /**
         * Adds a single [Place] to [places].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addPlace(place: Place) = apply {
            places =
                (places ?: JsonField.of(mutableListOf())).also {
                    checkKnown("places", it).add(place)
                }
        }

        /** Places X found, before limit. */
        fun total(total: Long) = total(JsonField.of(total))

        /** Sets [Builder.total] to an arbitrary JSON value. */
        fun total(total: JsonField<Long>) = apply { this.total = total }

        /** What to send instead. Present only when X finds no place. */
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
         * Returns an immutable instance of [XSearchPlacesResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .count()
         * .places()
         * .total()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): XSearchPlacesResponse =
            XSearchPlacesResponse(
                checkRequired("count", count),
                checkRequired("places", places).map { it.toImmutable() },
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
    fun validate(): XSearchPlacesResponse = apply {
        if (validated) {
            return@apply
        }

        count()
        places().forEach { it.validate() }
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
            (places.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (if (total.asKnown().isPresent) 1 else 0) +
            (if (message.asKnown().isPresent) 1 else 0)

    /** A place X found, with the larger places it lies in. */
    class Place
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val attributes: JsonField<Attributes>,
        private val boundingBox: JsonField<BoundingBox>,
        private val centroid: JsonField<List<Double>>,
        private val containedWithin: JsonField<List<ContainedWithin>>,
        private val country: JsonField<String>,
        private val countryCode: JsonField<String>,
        private val fullName: JsonField<String>,
        private val id: JsonField<String>,
        private val name: JsonField<String>,
        private val placeType: JsonField<String>,
        private val url: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("attributes")
            @ExcludeMissing
            attributes: JsonField<Attributes> = JsonMissing.of(),
            @JsonProperty("boundingBox")
            @ExcludeMissing
            boundingBox: JsonField<BoundingBox> = JsonMissing.of(),
            @JsonProperty("centroid")
            @ExcludeMissing
            centroid: JsonField<List<Double>> = JsonMissing.of(),
            @JsonProperty("containedWithin")
            @ExcludeMissing
            containedWithin: JsonField<List<ContainedWithin>> = JsonMissing.of(),
            @JsonProperty("country") @ExcludeMissing country: JsonField<String> = JsonMissing.of(),
            @JsonProperty("countryCode")
            @ExcludeMissing
            countryCode: JsonField<String> = JsonMissing.of(),
            @JsonProperty("fullName")
            @ExcludeMissing
            fullName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("placeType")
            @ExcludeMissing
            placeType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        ) : this(
            attributes,
            boundingBox,
            centroid,
            containedWithin,
            country,
            countryCode,
            fullName,
            id,
            name,
            placeType,
            url,
            mutableMapOf(),
        )

        /**
         * Extra details X attaches to some places. Often empty.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun attributes(): Attributes = attributes.getRequired("attributes")

        /**
         * Outline of the place as GeoJSON. Each point holds longitude, then latitude.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun boundingBox(): Optional<BoundingBox> = boundingBox.getOptional("boundingBox")

        /**
         * Center of the place. Longitude, then latitude.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun centroid(): Optional<List<Double>> = centroid.getOptional("centroid")

        /**
         * Larger places this place lies in. Often 1.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun containedWithin(): List<ContainedWithin> =
            containedWithin.getRequired("containedWithin")

        /**
         * Country the place lies in.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun country(): Optional<String> = country.getOptional("country")

        /**
         * 2-letter code of the country the place lies in.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun countryCode(): Optional<String> = countryCode.getOptional("countryCode")

        /**
         * Name with the region or country around the place.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun fullName(): Optional<String> = fullName.getOptional("fullName")

        /**
         * Place ID. Pass it as place to /x/tweets/search.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun id(): String = id.getRequired("id")

        /**
         * Short name of the place.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun name(): String = name.getRequired("name")

        /**
         * X's kind of place, such as city, admin, neighborhood, poi or country.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun placeType(): Optional<String> = placeType.getOptional("placeType")

        /**
         * X's own reference URL for the place.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun url(): Optional<String> = url.getOptional("url")

        /**
         * Returns the raw JSON value of [attributes].
         *
         * Unlike [attributes], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("attributes")
        @ExcludeMissing
        fun _attributes(): JsonField<Attributes> = attributes

        /**
         * Returns the raw JSON value of [boundingBox].
         *
         * Unlike [boundingBox], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("boundingBox")
        @ExcludeMissing
        fun _boundingBox(): JsonField<BoundingBox> = boundingBox

        /**
         * Returns the raw JSON value of [centroid].
         *
         * Unlike [centroid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("centroid")
        @ExcludeMissing
        fun _centroid(): JsonField<List<Double>> = centroid

        /**
         * Returns the raw JSON value of [containedWithin].
         *
         * Unlike [containedWithin], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("containedWithin")
        @ExcludeMissing
        fun _containedWithin(): JsonField<List<ContainedWithin>> = containedWithin

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
         * Returns the raw JSON value of [fullName].
         *
         * Unlike [fullName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("fullName") @ExcludeMissing fun _fullName(): JsonField<String> = fullName

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [placeType].
         *
         * Unlike [placeType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("placeType") @ExcludeMissing fun _placeType(): JsonField<String> = placeType

        /**
         * Returns the raw JSON value of [url].
         *
         * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

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
             * Returns a mutable builder for constructing an instance of [Place].
             *
             * The following fields are required:
             * ```java
             * .attributes()
             * .boundingBox()
             * .centroid()
             * .containedWithin()
             * .country()
             * .countryCode()
             * .fullName()
             * .id()
             * .name()
             * .placeType()
             * .url()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Place]. */
        class Builder internal constructor() {

            private var attributes: JsonField<Attributes>? = null
            private var boundingBox: JsonField<BoundingBox>? = null
            private var centroid: JsonField<MutableList<Double>>? = null
            private var containedWithin: JsonField<MutableList<ContainedWithin>>? = null
            private var country: JsonField<String>? = null
            private var countryCode: JsonField<String>? = null
            private var fullName: JsonField<String>? = null
            private var id: JsonField<String>? = null
            private var name: JsonField<String>? = null
            private var placeType: JsonField<String>? = null
            private var url: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(place: Place) = apply {
                attributes = place.attributes
                boundingBox = place.boundingBox
                centroid = place.centroid.map { it.toMutableList() }
                containedWithin = place.containedWithin.map { it.toMutableList() }
                country = place.country
                countryCode = place.countryCode
                fullName = place.fullName
                id = place.id
                name = place.name
                placeType = place.placeType
                url = place.url
                additionalProperties = place.additionalProperties.toMutableMap()
            }

            /** Extra details X attaches to some places. Often empty. */
            fun attributes(attributes: Attributes) = attributes(JsonField.of(attributes))

            /** Sets [Builder.attributes] to an arbitrary JSON value. */
            fun attributes(attributes: JsonField<Attributes>) = apply {
                this.attributes = attributes
            }

            /** Outline of the place as GeoJSON. Each point holds longitude, then latitude. */
            fun boundingBox(boundingBox: BoundingBox?) =
                boundingBox(JsonField.ofNullable(boundingBox))

            /** Alias for calling [Builder.boundingBox] with `boundingBox.orElse(null)`. */
            fun boundingBox(boundingBox: Optional<BoundingBox>) =
                boundingBox(boundingBox.getOrNull())

            /** Sets [Builder.boundingBox] to an arbitrary JSON value. */
            fun boundingBox(boundingBox: JsonField<BoundingBox>) = apply {
                this.boundingBox = boundingBox
            }

            /** Center of the place. Longitude, then latitude. */
            fun centroid(centroid: List<Double>?) = centroid(JsonField.ofNullable(centroid))

            /** Alias for calling [Builder.centroid] with `centroid.orElse(null)`. */
            fun centroid(centroid: Optional<List<Double>>) = centroid(centroid.getOrNull())

            /** Sets [Builder.centroid] to an arbitrary JSON value. */
            fun centroid(centroid: JsonField<List<Double>>) = apply {
                this.centroid = centroid.map { it.toMutableList() }
            }

            /**
             * Adds a single [Double] to [centroid].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addCentroid(centroid: Double) = apply {
                this.centroid =
                    (this.centroid ?: JsonField.of(mutableListOf())).also {
                        checkKnown("centroid", it).add(centroid)
                    }
            }

            /** Larger places this place lies in. Often 1. */
            fun containedWithin(containedWithin: List<ContainedWithin>) =
                containedWithin(JsonField.of(containedWithin))

            /** Sets [Builder.containedWithin] to an arbitrary JSON value. */
            fun containedWithin(containedWithin: JsonField<List<ContainedWithin>>) = apply {
                this.containedWithin = containedWithin.map { it.toMutableList() }
            }

            /**
             * Adds a single [ContainedWithin] to [containedWithin].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addContainedWithin(containedWithin: ContainedWithin) = apply {
                this.containedWithin =
                    (this.containedWithin ?: JsonField.of(mutableListOf())).also {
                        checkKnown("containedWithin", it).add(containedWithin)
                    }
            }

            /** Country the place lies in. */
            fun country(country: String?) = country(JsonField.ofNullable(country))

            /** Alias for calling [Builder.country] with `country.orElse(null)`. */
            fun country(country: Optional<String>) = country(country.getOrNull())

            /** Sets [Builder.country] to an arbitrary JSON value. */
            fun country(country: JsonField<String>) = apply { this.country = country }

            /** 2-letter code of the country the place lies in. */
            fun countryCode(countryCode: String?) = countryCode(JsonField.ofNullable(countryCode))

            /** Alias for calling [Builder.countryCode] with `countryCode.orElse(null)`. */
            fun countryCode(countryCode: Optional<String>) = countryCode(countryCode.getOrNull())

            /** Sets [Builder.countryCode] to an arbitrary JSON value. */
            fun countryCode(countryCode: JsonField<String>) = apply {
                this.countryCode = countryCode
            }

            /** Name with the region or country around the place. */
            fun fullName(fullName: String?) = fullName(JsonField.ofNullable(fullName))

            /** Alias for calling [Builder.fullName] with `fullName.orElse(null)`. */
            fun fullName(fullName: Optional<String>) = fullName(fullName.getOrNull())

            /** Sets [Builder.fullName] to an arbitrary JSON value. */
            fun fullName(fullName: JsonField<String>) = apply { this.fullName = fullName }

            /** Place ID. Pass it as place to /x/tweets/search. */
            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Short name of the place. */
            fun name(name: String) = name(JsonField.of(name))

            /** Sets [Builder.name] to an arbitrary JSON value. */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** X's kind of place, such as city, admin, neighborhood, poi or country. */
            fun placeType(placeType: String?) = placeType(JsonField.ofNullable(placeType))

            /** Alias for calling [Builder.placeType] with `placeType.orElse(null)`. */
            fun placeType(placeType: Optional<String>) = placeType(placeType.getOrNull())

            /** Sets [Builder.placeType] to an arbitrary JSON value. */
            fun placeType(placeType: JsonField<String>) = apply { this.placeType = placeType }

            /** X's own reference URL for the place. */
            fun url(url: String?) = url(JsonField.ofNullable(url))

            /** Alias for calling [Builder.url] with `url.orElse(null)`. */
            fun url(url: Optional<String>) = url(url.getOrNull())

            /** Sets [Builder.url] to an arbitrary JSON value. */
            fun url(url: JsonField<String>) = apply { this.url = url }

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
             * Returns an immutable instance of [Place].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .attributes()
             * .boundingBox()
             * .centroid()
             * .containedWithin()
             * .country()
             * .countryCode()
             * .fullName()
             * .id()
             * .name()
             * .placeType()
             * .url()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Place =
                Place(
                    checkRequired("attributes", attributes),
                    checkRequired("boundingBox", boundingBox),
                    checkRequired("centroid", centroid).map { it.toImmutable() },
                    checkRequired("containedWithin", containedWithin).map { it.toImmutable() },
                    checkRequired("country", country),
                    checkRequired("countryCode", countryCode),
                    checkRequired("fullName", fullName),
                    checkRequired("id", id),
                    checkRequired("name", name),
                    checkRequired("placeType", placeType),
                    checkRequired("url", url),
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
        fun validate(): Place = apply {
            if (validated) {
                return@apply
            }

            attributes().validate()
            boundingBox().ifPresent { it.validate() }
            centroid()
            containedWithin().forEach { it.validate() }
            country()
            countryCode()
            fullName()
            id()
            name()
            placeType()
            url()
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
            (attributes.asKnown().getOrNull()?.validity() ?: 0) +
                (boundingBox.asKnown().getOrNull()?.validity() ?: 0) +
                (centroid.asKnown().getOrNull()?.size ?: 0) +
                (containedWithin.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (country.asKnown().isPresent) 1 else 0) +
                (if (countryCode.asKnown().isPresent) 1 else 0) +
                (if (fullName.asKnown().isPresent) 1 else 0) +
                (if (id.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (placeType.asKnown().isPresent) 1 else 0) +
                (if (url.asKnown().isPresent) 1 else 0)

        /** Public metadata whose fields X defines. */
        class Attributes
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Attributes]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Attributes]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(attributes: Attributes) = apply {
                    additionalProperties = attributes.additionalProperties.toMutableMap()
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Attributes].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Attributes = Attributes(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
             *   match its expected type.
             */
            fun validate(): Attributes = apply {
                if (validated) {
                    return@apply
                }

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
            internal fun validity(): Int = additionalProperties.count { (_, value) ->
                !value.isNull() && !value.isMissing()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Attributes && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Attributes{additionalProperties=$additionalProperties}"
        }

        /** Outline of the place as GeoJSON. Each point holds longitude, then latitude. */
        class BoundingBox
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val coordinates: JsonField<List<List<List<Double>>>>,
            private val type: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("coordinates")
                @ExcludeMissing
                coordinates: JsonField<List<List<List<Double>>>> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
            ) : this(coordinates, type, mutableMapOf())

            /**
             * Rings of points that draw the outline.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun coordinates(): List<List<List<Double>>> = coordinates.getRequired("coordinates")

            /**
             * GeoJSON shape of the outline.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun type(): String = type.getRequired("type")

            /**
             * Returns the raw JSON value of [coordinates].
             *
             * Unlike [coordinates], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("coordinates")
            @ExcludeMissing
            fun _coordinates(): JsonField<List<List<List<Double>>>> = coordinates

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

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
                 * Returns a mutable builder for constructing an instance of [BoundingBox].
                 *
                 * The following fields are required:
                 * ```java
                 * .coordinates()
                 * .type()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [BoundingBox]. */
            class Builder internal constructor() {

                private var coordinates: JsonField<MutableList<List<List<Double>>>>? = null
                private var type: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(boundingBox: BoundingBox) = apply {
                    coordinates = boundingBox.coordinates.map { it.toMutableList() }
                    type = boundingBox.type
                    additionalProperties = boundingBox.additionalProperties.toMutableMap()
                }

                /** Rings of points that draw the outline. */
                fun coordinates(coordinates: List<List<List<Double>>>) =
                    coordinates(JsonField.of(coordinates))

                /** Sets [Builder.coordinates] to an arbitrary JSON value. */
                fun coordinates(coordinates: JsonField<List<List<List<Double>>>>) = apply {
                    this.coordinates = coordinates.map { it.toMutableList() }
                }

                /**
                 * Adds a single [List<List<Double>>] to [coordinates].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addCoordinate(coordinate: List<List<Double>>) = apply {
                    coordinates =
                        (coordinates ?: JsonField.of(mutableListOf())).also {
                            checkKnown("coordinates", it).add(coordinate)
                        }
                }

                /** GeoJSON shape of the outline. */
                fun type(type: String) = type(JsonField.of(type))

                /** Sets [Builder.type] to an arbitrary JSON value. */
                fun type(type: JsonField<String>) = apply { this.type = type }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [BoundingBox].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .coordinates()
                 * .type()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): BoundingBox =
                    BoundingBox(
                        checkRequired("coordinates", coordinates).map { it.toImmutable() },
                        checkRequired("type", type),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
             *   match its expected type.
             */
            fun validate(): BoundingBox = apply {
                if (validated) {
                    return@apply
                }

                coordinates()
                type()
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
                (coordinates.asKnown().getOrNull()?.size ?: 0) +
                    (if (type.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is BoundingBox &&
                    coordinates == other.coordinates &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(coordinates, type, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "BoundingBox{coordinates=$coordinates, type=$type, additionalProperties=$additionalProperties}"
        }

        /** A place on X, such as a city or a neighborhood. */
        class ContainedWithin
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val attributes: JsonField<Attributes>,
            private val boundingBox: JsonField<BoundingBox>,
            private val centroid: JsonField<List<Double>>,
            private val country: JsonField<String>,
            private val countryCode: JsonField<String>,
            private val fullName: JsonField<String>,
            private val id: JsonField<String>,
            private val name: JsonField<String>,
            private val placeType: JsonField<String>,
            private val url: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("attributes")
                @ExcludeMissing
                attributes: JsonField<Attributes> = JsonMissing.of(),
                @JsonProperty("boundingBox")
                @ExcludeMissing
                boundingBox: JsonField<BoundingBox> = JsonMissing.of(),
                @JsonProperty("centroid")
                @ExcludeMissing
                centroid: JsonField<List<Double>> = JsonMissing.of(),
                @JsonProperty("country")
                @ExcludeMissing
                country: JsonField<String> = JsonMissing.of(),
                @JsonProperty("countryCode")
                @ExcludeMissing
                countryCode: JsonField<String> = JsonMissing.of(),
                @JsonProperty("fullName")
                @ExcludeMissing
                fullName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("placeType")
                @ExcludeMissing
                placeType: JsonField<String> = JsonMissing.of(),
                @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
            ) : this(
                attributes,
                boundingBox,
                centroid,
                country,
                countryCode,
                fullName,
                id,
                name,
                placeType,
                url,
                mutableMapOf(),
            )

            /**
             * Extra details X attaches to some places. Often empty.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun attributes(): Attributes = attributes.getRequired("attributes")

            /**
             * Outline of the place as GeoJSON. Each point holds longitude, then latitude.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun boundingBox(): Optional<BoundingBox> = boundingBox.getOptional("boundingBox")

            /**
             * Center of the place. Longitude, then latitude.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun centroid(): Optional<List<Double>> = centroid.getOptional("centroid")

            /**
             * Country the place lies in.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun country(): Optional<String> = country.getOptional("country")

            /**
             * 2-letter code of the country the place lies in.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun countryCode(): Optional<String> = countryCode.getOptional("countryCode")

            /**
             * Name with the region or country around the place.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun fullName(): Optional<String> = fullName.getOptional("fullName")

            /**
             * Place ID. Pass it as place to /x/tweets/search.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun id(): String = id.getRequired("id")

            /**
             * Short name of the place.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun name(): String = name.getRequired("name")

            /**
             * X's kind of place, such as city, admin, neighborhood, poi or country.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun placeType(): Optional<String> = placeType.getOptional("placeType")

            /**
             * X's own reference URL for the place.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun url(): Optional<String> = url.getOptional("url")

            /**
             * Returns the raw JSON value of [attributes].
             *
             * Unlike [attributes], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("attributes")
            @ExcludeMissing
            fun _attributes(): JsonField<Attributes> = attributes

            /**
             * Returns the raw JSON value of [boundingBox].
             *
             * Unlike [boundingBox], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("boundingBox")
            @ExcludeMissing
            fun _boundingBox(): JsonField<BoundingBox> = boundingBox

            /**
             * Returns the raw JSON value of [centroid].
             *
             * Unlike [centroid], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("centroid")
            @ExcludeMissing
            fun _centroid(): JsonField<List<Double>> = centroid

            /**
             * Returns the raw JSON value of [country].
             *
             * Unlike [country], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("country") @ExcludeMissing fun _country(): JsonField<String> = country

            /**
             * Returns the raw JSON value of [countryCode].
             *
             * Unlike [countryCode], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("countryCode")
            @ExcludeMissing
            fun _countryCode(): JsonField<String> = countryCode

            /**
             * Returns the raw JSON value of [fullName].
             *
             * Unlike [fullName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("fullName") @ExcludeMissing fun _fullName(): JsonField<String> = fullName

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [placeType].
             *
             * Unlike [placeType], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("placeType")
            @ExcludeMissing
            fun _placeType(): JsonField<String> = placeType

            /**
             * Returns the raw JSON value of [url].
             *
             * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

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
                 * Returns a mutable builder for constructing an instance of [ContainedWithin].
                 *
                 * The following fields are required:
                 * ```java
                 * .attributes()
                 * .boundingBox()
                 * .centroid()
                 * .country()
                 * .countryCode()
                 * .fullName()
                 * .id()
                 * .name()
                 * .placeType()
                 * .url()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ContainedWithin]. */
            class Builder internal constructor() {

                private var attributes: JsonField<Attributes>? = null
                private var boundingBox: JsonField<BoundingBox>? = null
                private var centroid: JsonField<MutableList<Double>>? = null
                private var country: JsonField<String>? = null
                private var countryCode: JsonField<String>? = null
                private var fullName: JsonField<String>? = null
                private var id: JsonField<String>? = null
                private var name: JsonField<String>? = null
                private var placeType: JsonField<String>? = null
                private var url: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(containedWithin: ContainedWithin) = apply {
                    attributes = containedWithin.attributes
                    boundingBox = containedWithin.boundingBox
                    centroid = containedWithin.centroid.map { it.toMutableList() }
                    country = containedWithin.country
                    countryCode = containedWithin.countryCode
                    fullName = containedWithin.fullName
                    id = containedWithin.id
                    name = containedWithin.name
                    placeType = containedWithin.placeType
                    url = containedWithin.url
                    additionalProperties = containedWithin.additionalProperties.toMutableMap()
                }

                /** Extra details X attaches to some places. Often empty. */
                fun attributes(attributes: Attributes) = attributes(JsonField.of(attributes))

                /** Sets [Builder.attributes] to an arbitrary JSON value. */
                fun attributes(attributes: JsonField<Attributes>) = apply {
                    this.attributes = attributes
                }

                /** Outline of the place as GeoJSON. Each point holds longitude, then latitude. */
                fun boundingBox(boundingBox: BoundingBox?) =
                    boundingBox(JsonField.ofNullable(boundingBox))

                /** Alias for calling [Builder.boundingBox] with `boundingBox.orElse(null)`. */
                fun boundingBox(boundingBox: Optional<BoundingBox>) =
                    boundingBox(boundingBox.getOrNull())

                /** Sets [Builder.boundingBox] to an arbitrary JSON value. */
                fun boundingBox(boundingBox: JsonField<BoundingBox>) = apply {
                    this.boundingBox = boundingBox
                }

                /** Center of the place. Longitude, then latitude. */
                fun centroid(centroid: List<Double>?) = centroid(JsonField.ofNullable(centroid))

                /** Alias for calling [Builder.centroid] with `centroid.orElse(null)`. */
                fun centroid(centroid: Optional<List<Double>>) = centroid(centroid.getOrNull())

                /** Sets [Builder.centroid] to an arbitrary JSON value. */
                fun centroid(centroid: JsonField<List<Double>>) = apply {
                    this.centroid = centroid.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Double] to [centroid].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addCentroid(centroid: Double) = apply {
                    this.centroid =
                        (this.centroid ?: JsonField.of(mutableListOf())).also {
                            checkKnown("centroid", it).add(centroid)
                        }
                }

                /** Country the place lies in. */
                fun country(country: String?) = country(JsonField.ofNullable(country))

                /** Alias for calling [Builder.country] with `country.orElse(null)`. */
                fun country(country: Optional<String>) = country(country.getOrNull())

                /** Sets [Builder.country] to an arbitrary JSON value. */
                fun country(country: JsonField<String>) = apply { this.country = country }

                /** 2-letter code of the country the place lies in. */
                fun countryCode(countryCode: String?) =
                    countryCode(JsonField.ofNullable(countryCode))

                /** Alias for calling [Builder.countryCode] with `countryCode.orElse(null)`. */
                fun countryCode(countryCode: Optional<String>) =
                    countryCode(countryCode.getOrNull())

                /** Sets [Builder.countryCode] to an arbitrary JSON value. */
                fun countryCode(countryCode: JsonField<String>) = apply {
                    this.countryCode = countryCode
                }

                /** Name with the region or country around the place. */
                fun fullName(fullName: String?) = fullName(JsonField.ofNullable(fullName))

                /** Alias for calling [Builder.fullName] with `fullName.orElse(null)`. */
                fun fullName(fullName: Optional<String>) = fullName(fullName.getOrNull())

                /** Sets [Builder.fullName] to an arbitrary JSON value. */
                fun fullName(fullName: JsonField<String>) = apply { this.fullName = fullName }

                /** Place ID. Pass it as place to /x/tweets/search. */
                fun id(id: String) = id(JsonField.of(id))

                /** Sets [Builder.id] to an arbitrary JSON value. */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** Short name of the place. */
                fun name(name: String) = name(JsonField.of(name))

                /** Sets [Builder.name] to an arbitrary JSON value. */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /** X's kind of place, such as city, admin, neighborhood, poi or country. */
                fun placeType(placeType: String?) = placeType(JsonField.ofNullable(placeType))

                /** Alias for calling [Builder.placeType] with `placeType.orElse(null)`. */
                fun placeType(placeType: Optional<String>) = placeType(placeType.getOrNull())

                /** Sets [Builder.placeType] to an arbitrary JSON value. */
                fun placeType(placeType: JsonField<String>) = apply { this.placeType = placeType }

                /** X's own reference URL for the place. */
                fun url(url: String?) = url(JsonField.ofNullable(url))

                /** Alias for calling [Builder.url] with `url.orElse(null)`. */
                fun url(url: Optional<String>) = url(url.getOrNull())

                /** Sets [Builder.url] to an arbitrary JSON value. */
                fun url(url: JsonField<String>) = apply { this.url = url }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ContainedWithin].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .attributes()
                 * .boundingBox()
                 * .centroid()
                 * .country()
                 * .countryCode()
                 * .fullName()
                 * .id()
                 * .name()
                 * .placeType()
                 * .url()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ContainedWithin =
                    ContainedWithin(
                        checkRequired("attributes", attributes),
                        checkRequired("boundingBox", boundingBox),
                        checkRequired("centroid", centroid).map { it.toImmutable() },
                        checkRequired("country", country),
                        checkRequired("countryCode", countryCode),
                        checkRequired("fullName", fullName),
                        checkRequired("id", id),
                        checkRequired("name", name),
                        checkRequired("placeType", placeType),
                        checkRequired("url", url),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
             *   match its expected type.
             */
            fun validate(): ContainedWithin = apply {
                if (validated) {
                    return@apply
                }

                attributes().validate()
                boundingBox().ifPresent { it.validate() }
                centroid()
                country()
                countryCode()
                fullName()
                id()
                name()
                placeType()
                url()
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
                (attributes.asKnown().getOrNull()?.validity() ?: 0) +
                    (boundingBox.asKnown().getOrNull()?.validity() ?: 0) +
                    (centroid.asKnown().getOrNull()?.size ?: 0) +
                    (if (country.asKnown().isPresent) 1 else 0) +
                    (if (countryCode.asKnown().isPresent) 1 else 0) +
                    (if (fullName.asKnown().isPresent) 1 else 0) +
                    (if (id.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (placeType.asKnown().isPresent) 1 else 0) +
                    (if (url.asKnown().isPresent) 1 else 0)

            /** Public metadata whose fields X defines. */
            class Attributes
            @JsonCreator
            private constructor(
                @com.fasterxml.jackson.annotation.JsonValue
                private val additionalProperties: Map<String, JsonValue>
            ) {

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun toBuilder() = Builder().from(this)

                companion object {

                    /** Returns a mutable builder for constructing an instance of [Attributes]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Attributes]. */
                class Builder internal constructor() {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(attributes: Attributes) = apply {
                        additionalProperties = attributes.additionalProperties.toMutableMap()
                    }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [Attributes].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Attributes = Attributes(additionalProperties.toImmutable())
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): Attributes = apply {
                    if (validated) {
                        return@apply
                    }

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
                internal fun validity(): Int = additionalProperties.count { (_, value) ->
                    !value.isNull() && !value.isMissing()
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Attributes && additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() = "Attributes{additionalProperties=$additionalProperties}"
            }

            /** Outline of the place as GeoJSON. Each point holds longitude, then latitude. */
            class BoundingBox
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val coordinates: JsonField<List<List<List<Double>>>>,
                private val type: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("coordinates")
                    @ExcludeMissing
                    coordinates: JsonField<List<List<List<Double>>>> = JsonMissing.of(),
                    @JsonProperty("type")
                    @ExcludeMissing
                    type: JsonField<String> = JsonMissing.of(),
                ) : this(coordinates, type, mutableMapOf())

                /**
                 * Rings of points that draw the outline.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun coordinates(): List<List<List<Double>>> = coordinates.getRequired("coordinates")

                /**
                 * GeoJSON shape of the outline.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun type(): String = type.getRequired("type")

                /**
                 * Returns the raw JSON value of [coordinates].
                 *
                 * Unlike [coordinates], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("coordinates")
                @ExcludeMissing
                fun _coordinates(): JsonField<List<List<List<Double>>>> = coordinates

                /**
                 * Returns the raw JSON value of [type].
                 *
                 * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

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
                     * Returns a mutable builder for constructing an instance of [BoundingBox].
                     *
                     * The following fields are required:
                     * ```java
                     * .coordinates()
                     * .type()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [BoundingBox]. */
                class Builder internal constructor() {

                    private var coordinates: JsonField<MutableList<List<List<Double>>>>? = null
                    private var type: JsonField<String>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(boundingBox: BoundingBox) = apply {
                        coordinates = boundingBox.coordinates.map { it.toMutableList() }
                        type = boundingBox.type
                        additionalProperties = boundingBox.additionalProperties.toMutableMap()
                    }

                    /** Rings of points that draw the outline. */
                    fun coordinates(coordinates: List<List<List<Double>>>) =
                        coordinates(JsonField.of(coordinates))

                    /** Sets [Builder.coordinates] to an arbitrary JSON value. */
                    fun coordinates(coordinates: JsonField<List<List<List<Double>>>>) = apply {
                        this.coordinates = coordinates.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [List<List<Double>>] to [coordinates].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addCoordinate(coordinate: List<List<Double>>) = apply {
                        coordinates =
                            (coordinates ?: JsonField.of(mutableListOf())).also {
                                checkKnown("coordinates", it).add(coordinate)
                            }
                    }

                    /** GeoJSON shape of the outline. */
                    fun type(type: String) = type(JsonField.of(type))

                    /** Sets [Builder.type] to an arbitrary JSON value. */
                    fun type(type: JsonField<String>) = apply { this.type = type }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [BoundingBox].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .coordinates()
                     * .type()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): BoundingBox =
                        BoundingBox(
                            checkRequired("coordinates", coordinates).map { it.toImmutable() },
                            checkRequired("type", type),
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): BoundingBox = apply {
                    if (validated) {
                        return@apply
                    }

                    coordinates()
                    type()
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
                    (coordinates.asKnown().getOrNull()?.size ?: 0) +
                        (if (type.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is BoundingBox &&
                        coordinates == other.coordinates &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(coordinates, type, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "BoundingBox{coordinates=$coordinates, type=$type, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ContainedWithin &&
                    attributes == other.attributes &&
                    boundingBox == other.boundingBox &&
                    centroid == other.centroid &&
                    country == other.country &&
                    countryCode == other.countryCode &&
                    fullName == other.fullName &&
                    id == other.id &&
                    name == other.name &&
                    placeType == other.placeType &&
                    url == other.url &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    attributes,
                    boundingBox,
                    centroid,
                    country,
                    countryCode,
                    fullName,
                    id,
                    name,
                    placeType,
                    url,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ContainedWithin{attributes=$attributes, boundingBox=$boundingBox, centroid=$centroid, country=$country, countryCode=$countryCode, fullName=$fullName, id=$id, name=$name, placeType=$placeType, url=$url, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Place &&
                attributes == other.attributes &&
                boundingBox == other.boundingBox &&
                centroid == other.centroid &&
                containedWithin == other.containedWithin &&
                country == other.country &&
                countryCode == other.countryCode &&
                fullName == other.fullName &&
                id == other.id &&
                name == other.name &&
                placeType == other.placeType &&
                url == other.url &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                attributes,
                boundingBox,
                centroid,
                containedWithin,
                country,
                countryCode,
                fullName,
                id,
                name,
                placeType,
                url,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Place{attributes=$attributes, boundingBox=$boundingBox, centroid=$centroid, containedWithin=$containedWithin, country=$country, countryCode=$countryCode, fullName=$fullName, id=$id, name=$name, placeType=$placeType, url=$url, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is XSearchPlacesResponse &&
            count == other.count &&
            places == other.places &&
            total == other.total &&
            message == other.message &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(count, places, total, message, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "XSearchPlacesResponse{count=$count, places=$places, total=$total, message=$message, additionalProperties=$additionalProperties}"
}
