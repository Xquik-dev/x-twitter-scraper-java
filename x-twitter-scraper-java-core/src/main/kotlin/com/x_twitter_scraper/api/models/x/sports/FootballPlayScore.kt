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

/** The points a scoring play added, or null. */
class FootballPlayScore
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val homePoints: JsonField<Long>,
    private val awayPoints: JsonField<Long>,
    private val points: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("homePoints") @ExcludeMissing homePoints: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("awayPoints") @ExcludeMissing awayPoints: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("points") @ExcludeMissing points: JsonField<Long> = JsonMissing.of(),
    ) : this(homePoints, awayPoints, points, mutableMapOf())

    /** The home team's score once this scoring play counted. */
    fun homePoints(): Optional<Long> = homePoints.getOptional("homePoints")

    /** The away team's score once this scoring play counted. */
    fun awayPoints(): Optional<Long> = awayPoints.getOptional("awayPoints")

    /** The points the play scored. */
    fun points(): Optional<Long> = points.getOptional("points")

    /** Returns the raw JSON value of [homePoints]. */
    @JsonProperty("homePoints") @ExcludeMissing fun _homePoints(): JsonField<Long> = homePoints

    /** Returns the raw JSON value of [awayPoints]. */
    @JsonProperty("awayPoints") @ExcludeMissing fun _awayPoints(): JsonField<Long> = awayPoints

    /** Returns the raw JSON value of [points]. */
    @JsonProperty("points") @ExcludeMissing fun _points(): JsonField<Long> = points

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

        /** Returns a mutable builder for constructing an instance of [FootballPlayScore]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballPlayScore]. */
    class Builder internal constructor() {

        private var homePoints: JsonField<Long>? = null
        private var awayPoints: JsonField<Long>? = null
        private var points: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballPlayScore: FootballPlayScore) = apply {
            homePoints = footballPlayScore.homePoints
            awayPoints = footballPlayScore.awayPoints
            points = footballPlayScore.points
            additionalProperties = footballPlayScore.additionalProperties.toMutableMap()
        }

        /** The home team's score once this scoring play counted. */
        fun homePoints(homePoints: Long?) = homePoints(JsonField.ofNullable(homePoints))

        fun homePoints(homePoints: Long) = homePoints(homePoints as Long?)

        fun homePoints(homePoints: Optional<Long>) = homePoints(homePoints.getOrNull())

        /** Sets [Builder.homePoints] to an arbitrary JSON value. */
        fun homePoints(homePoints: JsonField<Long>) = apply { this.homePoints = homePoints }

        /** The away team's score once this scoring play counted. */
        fun awayPoints(awayPoints: Long?) = awayPoints(JsonField.ofNullable(awayPoints))

        fun awayPoints(awayPoints: Long) = awayPoints(awayPoints as Long?)

        fun awayPoints(awayPoints: Optional<Long>) = awayPoints(awayPoints.getOrNull())

        /** Sets [Builder.awayPoints] to an arbitrary JSON value. */
        fun awayPoints(awayPoints: JsonField<Long>) = apply { this.awayPoints = awayPoints }

        /** The points the play scored. */
        fun points(points: Long?) = points(JsonField.ofNullable(points))

        fun points(points: Long) = points(points as Long?)

        fun points(points: Optional<Long>) = points(points.getOrNull())

        /** Sets [Builder.points] to an arbitrary JSON value. */
        fun points(points: JsonField<Long>) = apply { this.points = points }

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
         * Returns an immutable instance of [FootballPlayScore].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballPlayScore =
            FootballPlayScore(
                checkRequired("homePoints", homePoints),
                checkRequired("awayPoints", awayPoints),
                checkRequired("points", points),
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
    fun validate(): FootballPlayScore = apply {
        if (validated) {
            return@apply
        }

        homePoints()
        awayPoints()
        points()
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
        (if (homePoints.asKnown().isPresent) 1 else 0) +
            (if (awayPoints.asKnown().isPresent) 1 else 0) +
            (if (points.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballPlayScore &&
            homePoints == other.homePoints &&
            awayPoints == other.awayPoints &&
            points == other.points &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(homePoints, awayPoints, points, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballPlayScore{homePoints=$homePoints, awayPoints=$awayPoints, points=$points, additionalProperties=$additionalProperties}"
}
