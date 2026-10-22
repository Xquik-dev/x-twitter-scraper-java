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

/** A team's side of a scoreboard. */
class FootballSide
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val teamId: JsonField<String>,
    private val points: JsonField<Long>,
    private val timeoutsLeft: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("teamId") @ExcludeMissing teamId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("points") @ExcludeMissing points: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("timeoutsLeft") @ExcludeMissing timeoutsLeft: JsonField<Long> = JsonMissing.of(),
    ) : this(teamId, points, timeoutsLeft, mutableMapOf())

    /** The team, a key of teams. */
    fun teamId(): Optional<String> = teamId.getOptional("teamId")

    /** The team's points so far. */
    fun points(): Optional<Long> = points.getOptional("points")

    /** The timeouts the team has left. */
    fun timeoutsLeft(): Optional<Long> = timeoutsLeft.getOptional("timeoutsLeft")

    /** Returns the raw JSON value of [teamId]. */
    @JsonProperty("teamId") @ExcludeMissing fun _teamId(): JsonField<String> = teamId

    /** Returns the raw JSON value of [points]. */
    @JsonProperty("points") @ExcludeMissing fun _points(): JsonField<Long> = points

    /** Returns the raw JSON value of [timeoutsLeft]. */
    @JsonProperty("timeoutsLeft") @ExcludeMissing fun _timeoutsLeft(): JsonField<Long> = timeoutsLeft

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

        /** Returns a mutable builder for constructing an instance of [FootballSide]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballSide]. */
    class Builder internal constructor() {

        private var teamId: JsonField<String>? = null
        private var points: JsonField<Long>? = null
        private var timeoutsLeft: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballSide: FootballSide) = apply {
            teamId = footballSide.teamId
            points = footballSide.points
            timeoutsLeft = footballSide.timeoutsLeft
            additionalProperties = footballSide.additionalProperties.toMutableMap()
        }

        /** The team, a key of teams. */
        fun teamId(teamId: String?) = teamId(JsonField.ofNullable(teamId))

        fun teamId(teamId: Optional<String>) = teamId(teamId.getOrNull())

        /** Sets [Builder.teamId] to an arbitrary JSON value. */
        fun teamId(teamId: JsonField<String>) = apply { this.teamId = teamId }

        /** The team's points so far. */
        fun points(points: Long?) = points(JsonField.ofNullable(points))

        fun points(points: Long) = points(points as Long?)

        fun points(points: Optional<Long>) = points(points.getOrNull())

        /** Sets [Builder.points] to an arbitrary JSON value. */
        fun points(points: JsonField<Long>) = apply { this.points = points }

        /** The timeouts the team has left. */
        fun timeoutsLeft(timeoutsLeft: Long?) = timeoutsLeft(JsonField.ofNullable(timeoutsLeft))

        fun timeoutsLeft(timeoutsLeft: Long) = timeoutsLeft(timeoutsLeft as Long?)

        fun timeoutsLeft(timeoutsLeft: Optional<Long>) = timeoutsLeft(timeoutsLeft.getOrNull())

        /** Sets [Builder.timeoutsLeft] to an arbitrary JSON value. */
        fun timeoutsLeft(timeoutsLeft: JsonField<Long>) = apply { this.timeoutsLeft = timeoutsLeft }

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
         * Returns an immutable instance of [FootballSide].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballSide =
            FootballSide(
                checkRequired("teamId", teamId),
                checkRequired("points", points),
                checkRequired("timeoutsLeft", timeoutsLeft),
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
    fun validate(): FootballSide = apply {
        if (validated) {
            return@apply
        }

        teamId()
        points()
        timeoutsLeft()
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
        (if (teamId.asKnown().isPresent) 1 else 0) +
            (if (points.asKnown().isPresent) 1 else 0) +
            (if (timeoutsLeft.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballSide &&
            teamId == other.teamId &&
            points == other.points &&
            timeoutsLeft == other.timeoutsLeft &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(teamId, points, timeoutsLeft, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballSide{teamId=$teamId, points=$points, timeoutsLeft=$timeoutsLeft, additionalProperties=$additionalProperties}"
}
