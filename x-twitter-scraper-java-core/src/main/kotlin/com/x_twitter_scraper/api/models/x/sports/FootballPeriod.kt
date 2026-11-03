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
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A period of a game & its points. */
class FootballPeriod
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val type: JsonField<String>,
    private val number: JsonField<Long>,
    private val sequence: JsonField<Long>,
    private val homePoints: JsonField<Long>,
    private val awayPoints: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
        @JsonProperty("number") @ExcludeMissing number: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("sequence") @ExcludeMissing sequence: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("homePoints") @ExcludeMissing homePoints: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("awayPoints") @ExcludeMissing awayPoints: JsonField<Long> = JsonMissing.of(),
    ) : this(type, number, sequence, homePoints, awayPoints, mutableMapOf())

    /** X's name for the period, such as Quarter. */
    fun type(): Optional<String> = type.getOptional("type")

    /** The period's number, or null when X sends no digits. */
    fun number(): Optional<Long> = number.getOptional("number")

    /** The period's place in the game, from 1. */
    fun sequence(): Optional<Long> = sequence.getOptional("sequence")

    /** The home team's points in the period. */
    fun homePoints(): Optional<Long> = homePoints.getOptional("homePoints")

    /** The away team's points in the period. */
    fun awayPoints(): Optional<Long> = awayPoints.getOptional("awayPoints")

    /** Returns the raw JSON value of [type]. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

    /** Returns the raw JSON value of [number]. */
    @JsonProperty("number") @ExcludeMissing fun _number(): JsonField<Long> = number

    /** Returns the raw JSON value of [sequence]. */
    @JsonProperty("sequence") @ExcludeMissing fun _sequence(): JsonField<Long> = sequence

    /** Returns the raw JSON value of [homePoints]. */
    @JsonProperty("homePoints") @ExcludeMissing fun _homePoints(): JsonField<Long> = homePoints

    /** Returns the raw JSON value of [awayPoints]. */
    @JsonProperty("awayPoints") @ExcludeMissing fun _awayPoints(): JsonField<Long> = awayPoints

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

        /** Returns a mutable builder for constructing an instance of [FootballPeriod]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballPeriod]. */
    class Builder internal constructor() {

        private var type: JsonField<String>? = null
        private var number: JsonField<Long>? = null
        private var sequence: JsonField<Long>? = null
        private var homePoints: JsonField<Long>? = null
        private var awayPoints: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballPeriod: FootballPeriod) = apply {
            type = footballPeriod.type
            number = footballPeriod.number
            sequence = footballPeriod.sequence
            homePoints = footballPeriod.homePoints
            awayPoints = footballPeriod.awayPoints
            additionalProperties = footballPeriod.additionalProperties.toMutableMap()
        }

        /** X's name for the period, such as Quarter. */
        fun type(type: String?) = type(JsonField.ofNullable(type))

        fun type(type: Optional<String>) = type(type.getOrNull())

        /** Sets [Builder.type] to an arbitrary JSON value. */
        fun type(type: JsonField<String>) = apply { this.type = type }

        /** The period's number, or null when X sends no digits. */
        fun number(number: Long?) = number(JsonField.ofNullable(number))

        fun number(number: Long) = number(number as Long?)

        fun number(number: Optional<Long>) = number(number.getOrNull())

        /** Sets [Builder.number] to an arbitrary JSON value. */
        fun number(number: JsonField<Long>) = apply { this.number = number }

        /** The period's place in the game, from 1. */
        fun sequence(sequence: Long?) = sequence(JsonField.ofNullable(sequence))

        fun sequence(sequence: Long) = sequence(sequence as Long?)

        fun sequence(sequence: Optional<Long>) = sequence(sequence.getOrNull())

        /** Sets [Builder.sequence] to an arbitrary JSON value. */
        fun sequence(sequence: JsonField<Long>) = apply { this.sequence = sequence }

        /** The home team's points in the period. */
        fun homePoints(homePoints: Long?) = homePoints(JsonField.ofNullable(homePoints))

        fun homePoints(homePoints: Long) = homePoints(homePoints as Long?)

        fun homePoints(homePoints: Optional<Long>) = homePoints(homePoints.getOrNull())

        /** Sets [Builder.homePoints] to an arbitrary JSON value. */
        fun homePoints(homePoints: JsonField<Long>) = apply { this.homePoints = homePoints }

        /** The away team's points in the period. */
        fun awayPoints(awayPoints: Long?) = awayPoints(JsonField.ofNullable(awayPoints))

        fun awayPoints(awayPoints: Long) = awayPoints(awayPoints as Long?)

        fun awayPoints(awayPoints: Optional<Long>) = awayPoints(awayPoints.getOrNull())

        /** Sets [Builder.awayPoints] to an arbitrary JSON value. */
        fun awayPoints(awayPoints: JsonField<Long>) = apply { this.awayPoints = awayPoints }

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
         * Returns an immutable instance of [FootballPeriod].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballPeriod =
            FootballPeriod(
                checkRequired("type", type),
                checkRequired("number", number),
                checkRequired("sequence", sequence),
                checkRequired("homePoints", homePoints),
                checkRequired("awayPoints", awayPoints),
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
    fun validate(): FootballPeriod = apply {
        if (validated) {
            return@apply
        }

        type()
        number()
        sequence()
        homePoints()
        awayPoints()
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
        (if (type.asKnown().isPresent) 1 else 0) +
            (if (number.asKnown().isPresent) 1 else 0) +
            (if (sequence.asKnown().isPresent) 1 else 0) +
            (if (homePoints.asKnown().isPresent) 1 else 0) +
            (if (awayPoints.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballPeriod &&
            type == other.type &&
            number == other.number &&
            sequence == other.sequence &&
            homePoints == other.homePoints &&
            awayPoints == other.awayPoints &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(type, number, sequence, homePoints, awayPoints, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballPeriod{type=$type, number=$number, sequence=$sequence, homePoints=$homePoints, awayPoints=$awayPoints, additionalProperties=$additionalProperties}"
}
