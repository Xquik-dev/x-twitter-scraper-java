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

/** A team's side of a game & its points. */
class FootballTeamScore
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val teamId: JsonField<String>,
    private val points: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("teamId") @ExcludeMissing teamId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("points") @ExcludeMissing points: JsonField<Long> = JsonMissing.of(),
    ) : this(teamId, points, mutableMapOf())

    /** The team, a key of teams. */
    fun teamId(): Optional<String> = teamId.getOptional("teamId")

    /** The team's points so far. */
    fun points(): Optional<Long> = points.getOptional("points")

    /** Returns the raw JSON value of [teamId]. */
    @JsonProperty("teamId") @ExcludeMissing fun _teamId(): JsonField<String> = teamId

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

        /** Returns a mutable builder for constructing an instance of [FootballTeamScore]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballTeamScore]. */
    class Builder internal constructor() {

        private var teamId: JsonField<String>? = null
        private var points: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballTeamScore: FootballTeamScore) = apply {
            teamId = footballTeamScore.teamId
            points = footballTeamScore.points
            additionalProperties = footballTeamScore.additionalProperties.toMutableMap()
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
         * Returns an immutable instance of [FootballTeamScore].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballTeamScore =
            FootballTeamScore(
                checkRequired("teamId", teamId),
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
    fun validate(): FootballTeamScore = apply {
        if (validated) {
            return@apply
        }

        teamId()
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
        (if (teamId.asKnown().isPresent) 1 else 0) +
            (if (points.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballTeamScore &&
            teamId == other.teamId &&
            points == other.points &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(teamId, points, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballTeamScore{teamId=$teamId, points=$points, additionalProperties=$additionalProperties}"
}
