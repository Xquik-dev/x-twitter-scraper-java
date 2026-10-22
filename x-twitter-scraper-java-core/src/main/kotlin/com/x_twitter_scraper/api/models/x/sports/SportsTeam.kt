// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.sports

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

/** A team, as X's sports pages show it. */
class SportsTeam
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val name: JsonField<String>,
    private val shortName: JsonField<String>,
    private val abbreviation: JsonField<String>,
    private val alternateId: JsonField<String>,
    private val location: JsonField<String>,
    private val colors: JsonField<List<SportsTeamColor>>,
    private val logos: JsonField<SportsTeamLogos>,
    private val xUserId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("shortName") @ExcludeMissing shortName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("abbreviation") @ExcludeMissing abbreviation: JsonField<String> = JsonMissing.of(),
        @JsonProperty("alternateId") @ExcludeMissing alternateId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("location") @ExcludeMissing location: JsonField<String> = JsonMissing.of(),
        @JsonProperty("colors") @ExcludeMissing colors: JsonField<List<SportsTeamColor>> = JsonMissing.of(),
        @JsonProperty("logos") @ExcludeMissing logos: JsonField<SportsTeamLogos> = JsonMissing.of(),
        @JsonProperty("xUserId") @ExcludeMissing xUserId: JsonField<String> = JsonMissing.of(),
    ) : this(id, name, shortName, abbreviation, alternateId, location, colors, logos, xUserId, mutableMapOf())

    /** The team ID that games & players refer to. */
    fun id(): String = id.getRequired("id")

    /** The team's full name. */
    fun name(): Optional<String> = name.getOptional("name")

    /** The team's short name. */
    fun shortName(): Optional<String> = shortName.getOptional("shortName")

    /** The team's abbreviation. */
    fun abbreviation(): Optional<String> = abbreviation.getOptional("abbreviation")

    /** Another ID X keeps for the team. */
    fun alternateId(): Optional<String> = alternateId.getOptional("alternateId")

    /** The school or place a college team plays for. X sends it only in college football schedules. */
    fun location(): Optional<String> = location.getOptional("location")

    /** The team's colors, as red, green & blue from 0 to 255. */
    fun colors(): List<SportsTeamColor> = colors.getRequired("colors")

    /** The team's logo images. */
    fun logos(): SportsTeamLogos = logos.getRequired("logos")

    /** The user ID of the team's X account. */
    fun xUserId(): Optional<String> = xUserId.getOptional("xUserId")

    /** Returns the raw JSON value of [id]. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** Returns the raw JSON value of [name]. */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /** Returns the raw JSON value of [shortName]. */
    @JsonProperty("shortName") @ExcludeMissing fun _shortName(): JsonField<String> = shortName

    /** Returns the raw JSON value of [abbreviation]. */
    @JsonProperty("abbreviation") @ExcludeMissing fun _abbreviation(): JsonField<String> = abbreviation

    /** Returns the raw JSON value of [alternateId]. */
    @JsonProperty("alternateId") @ExcludeMissing fun _alternateId(): JsonField<String> = alternateId

    /** Returns the raw JSON value of [location]. */
    @JsonProperty("location") @ExcludeMissing fun _location(): JsonField<String> = location

    /** Returns the raw JSON value of [colors]. */
    @JsonProperty("colors") @ExcludeMissing fun _colors(): JsonField<List<SportsTeamColor>> = colors

    /** Returns the raw JSON value of [logos]. */
    @JsonProperty("logos") @ExcludeMissing fun _logos(): JsonField<SportsTeamLogos> = logos

    /** Returns the raw JSON value of [xUserId]. */
    @JsonProperty("xUserId") @ExcludeMissing fun _xUserId(): JsonField<String> = xUserId

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

        /** Returns a mutable builder for constructing an instance of [SportsTeam]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SportsTeam]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var name: JsonField<String>? = null
        private var shortName: JsonField<String>? = null
        private var abbreviation: JsonField<String>? = null
        private var alternateId: JsonField<String>? = null
        private var location: JsonField<String>? = null
        private var colors: JsonField<MutableList<SportsTeamColor>>? = null
        private var logos: JsonField<SportsTeamLogos>? = null
        private var xUserId: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(sportsTeam: SportsTeam) = apply {
            id = sportsTeam.id
            name = sportsTeam.name
            shortName = sportsTeam.shortName
            abbreviation = sportsTeam.abbreviation
            alternateId = sportsTeam.alternateId
            location = sportsTeam.location
            colors = sportsTeam.colors.map { it.toMutableList() }
            logos = sportsTeam.logos
            xUserId = sportsTeam.xUserId
            additionalProperties = sportsTeam.additionalProperties.toMutableMap()
        }

        /** The team ID that games & players refer to. */
        fun id(id: String) = id(JsonField.of(id))

        /** Sets [Builder.id] to an arbitrary JSON value. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The team's full name. */
        fun name(name: String?) = name(JsonField.ofNullable(name))

        fun name(name: Optional<String>) = name(name.getOrNull())

        /** Sets [Builder.name] to an arbitrary JSON value. */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The team's short name. */
        fun shortName(shortName: String?) = shortName(JsonField.ofNullable(shortName))

        fun shortName(shortName: Optional<String>) = shortName(shortName.getOrNull())

        /** Sets [Builder.shortName] to an arbitrary JSON value. */
        fun shortName(shortName: JsonField<String>) = apply { this.shortName = shortName }

        /** The team's abbreviation. */
        fun abbreviation(abbreviation: String?) = abbreviation(JsonField.ofNullable(abbreviation))

        fun abbreviation(abbreviation: Optional<String>) = abbreviation(abbreviation.getOrNull())

        /** Sets [Builder.abbreviation] to an arbitrary JSON value. */
        fun abbreviation(abbreviation: JsonField<String>) = apply { this.abbreviation = abbreviation }

        /** Another ID X keeps for the team. */
        fun alternateId(alternateId: String?) = alternateId(JsonField.ofNullable(alternateId))

        fun alternateId(alternateId: Optional<String>) = alternateId(alternateId.getOrNull())

        /** Sets [Builder.alternateId] to an arbitrary JSON value. */
        fun alternateId(alternateId: JsonField<String>) = apply { this.alternateId = alternateId }

        /** The school or place a college team plays for. X sends it only in college football schedules. */
        fun location(location: String?) = location(JsonField.ofNullable(location))

        fun location(location: Optional<String>) = location(location.getOrNull())

        /** Sets [Builder.location] to an arbitrary JSON value. */
        fun location(location: JsonField<String>) = apply { this.location = location }

        /** The team's colors, as red, green & blue from 0 to 255. */
        fun colors(colors: List<SportsTeamColor>) = colors(JsonField.of(colors))

        /** Sets [Builder.colors] to an arbitrary JSON value. */
        fun colors(colors: JsonField<List<SportsTeamColor>>) = apply { this.colors = colors.map { it.toMutableList() } }

        /** Adds a single [SportsTeamColor] to [colors]. */
        fun addColor(color: SportsTeamColor) = apply {
            colors =
                (colors ?: JsonField.of(mutableListOf())).also {
                    checkKnown("colors", it).add(color)
                }
        }

        /** The team's logo images. */
        fun logos(logos: SportsTeamLogos) = logos(JsonField.of(logos))

        /** Sets [Builder.logos] to an arbitrary JSON value. */
        fun logos(logos: JsonField<SportsTeamLogos>) = apply { this.logos = logos }

        /** The user ID of the team's X account. */
        fun xUserId(xUserId: String?) = xUserId(JsonField.ofNullable(xUserId))

        fun xUserId(xUserId: Optional<String>) = xUserId(xUserId.getOrNull())

        /** Sets [Builder.xUserId] to an arbitrary JSON value. */
        fun xUserId(xUserId: JsonField<String>) = apply { this.xUserId = xUserId }

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
         * Returns an immutable instance of [SportsTeam].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SportsTeam =
            SportsTeam(
                checkRequired("id", id),
                checkRequired("name", name),
                checkRequired("shortName", shortName),
                checkRequired("abbreviation", abbreviation),
                checkRequired("alternateId", alternateId),
                checkRequired("location", location),
                checkRequired("colors", colors).map { it.toImmutable() },
                checkRequired("logos", logos),
                checkRequired("xUserId", xUserId),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match
     *   its expected type.
     */
    fun validate(): SportsTeam = apply {
        if (validated) {
            return@apply
        }

        id()
        name()
        shortName()
        abbreviation()
        alternateId()
        location()
        colors().forEach { it.validate() }
        logos().validate()
        xUserId()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: XTwitterScraperInvalidDataException) {
            false
        }

    @JvmSynthetic internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (shortName.asKnown().isPresent) 1 else 0) +
            (if (abbreviation.asKnown().isPresent) 1 else 0) +
            (if (alternateId.asKnown().isPresent) 1 else 0) +
            (if (location.asKnown().isPresent) 1 else 0) +
            (colors.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (logos.asKnown().getOrNull()?.validity() ?: 0) +
            (if (xUserId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SportsTeam &&
            id == other.id &&
            name == other.name &&
            shortName == other.shortName &&
            abbreviation == other.abbreviation &&
            alternateId == other.alternateId &&
            location == other.location &&
            colors == other.colors &&
            logos == other.logos &&
            xUserId == other.xUserId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(id, name, shortName, abbreviation, alternateId, location, colors, logos, xUserId, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SportsTeam{id=$id, name=$name, shortName=$shortName, abbreviation=$abbreviation, alternateId=$alternateId, location=$location, colors=$colors, logos=$logos, xUserId=$xUserId, additionalProperties=$additionalProperties}"
}
