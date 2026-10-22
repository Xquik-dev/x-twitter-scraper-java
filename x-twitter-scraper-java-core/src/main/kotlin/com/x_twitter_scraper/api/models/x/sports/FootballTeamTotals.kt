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

/** A team's totals for 1 game. */
class FootballTeamTotals
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val firstDowns: JsonField<Long>,
    private val thirdDowns: JsonField<FootballTeamTotalsThirdDowns>,
    private val fumbles: JsonField<FootballFumbleStats>,
    private val passing: JsonField<FootballPassingStats>,
    private val penalties: JsonField<FootballTeamTotalsPenalties>,
    private val rushing: JsonField<FootballRushingStats>,
    private val timeOfPossessionSeconds: JsonField<Long>,
    private val totalYards: JsonField<Long>,
    private val turnovers: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("firstDowns") @ExcludeMissing firstDowns: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("thirdDowns") @ExcludeMissing thirdDowns: JsonField<FootballTeamTotalsThirdDowns> = JsonMissing.of(),
        @JsonProperty("fumbles") @ExcludeMissing fumbles: JsonField<FootballFumbleStats> = JsonMissing.of(),
        @JsonProperty("passing") @ExcludeMissing passing: JsonField<FootballPassingStats> = JsonMissing.of(),
        @JsonProperty("penalties") @ExcludeMissing penalties: JsonField<FootballTeamTotalsPenalties> = JsonMissing.of(),
        @JsonProperty("rushing") @ExcludeMissing rushing: JsonField<FootballRushingStats> = JsonMissing.of(),
        @JsonProperty("timeOfPossessionSeconds") @ExcludeMissing timeOfPossessionSeconds: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("totalYards") @ExcludeMissing totalYards: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("turnovers") @ExcludeMissing turnovers: JsonField<Long> = JsonMissing.of(),
    ) : this(firstDowns, thirdDowns, fumbles, passing, penalties, rushing, timeOfPossessionSeconds, totalYards, turnovers, mutableMapOf())

    /** First downs. */
    fun firstDowns(): Optional<Long> = firstDowns.getOptional("firstDowns")

    /** Third downs tried & converted. */
    fun thirdDowns(): Optional<FootballTeamTotalsThirdDowns> = thirdDowns.getOptional("thirdDowns")

    /** The team's fumbles, or null. */
    fun fumbles(): Optional<FootballFumbleStats> = fumbles.getOptional("fumbles")

    /** The team's passing, or null. */
    fun passing(): Optional<FootballPassingStats> = passing.getOptional("passing")

    /** Penalties against the team. */
    fun penalties(): Optional<FootballTeamTotalsPenalties> = penalties.getOptional("penalties")

    /** The team's rushing, or null. */
    fun rushing(): Optional<FootballRushingStats> = rushing.getOptional("rushing")

    /** Time with the ball, in seconds. */
    fun timeOfPossessionSeconds(): Optional<Long> = timeOfPossessionSeconds.getOptional("timeOfPossessionSeconds")

    /** Total yards. */
    fun totalYards(): Optional<Long> = totalYards.getOptional("totalYards")

    /** Turnovers. */
    fun turnovers(): Optional<Long> = turnovers.getOptional("turnovers")

    /** Returns the raw JSON value of [firstDowns]. */
    @JsonProperty("firstDowns") @ExcludeMissing fun _firstDowns(): JsonField<Long> = firstDowns

    /** Returns the raw JSON value of [thirdDowns]. */
    @JsonProperty("thirdDowns") @ExcludeMissing fun _thirdDowns(): JsonField<FootballTeamTotalsThirdDowns> = thirdDowns

    /** Returns the raw JSON value of [fumbles]. */
    @JsonProperty("fumbles") @ExcludeMissing fun _fumbles(): JsonField<FootballFumbleStats> = fumbles

    /** Returns the raw JSON value of [passing]. */
    @JsonProperty("passing") @ExcludeMissing fun _passing(): JsonField<FootballPassingStats> = passing

    /** Returns the raw JSON value of [penalties]. */
    @JsonProperty("penalties") @ExcludeMissing fun _penalties(): JsonField<FootballTeamTotalsPenalties> = penalties

    /** Returns the raw JSON value of [rushing]. */
    @JsonProperty("rushing") @ExcludeMissing fun _rushing(): JsonField<FootballRushingStats> = rushing

    /** Returns the raw JSON value of [timeOfPossessionSeconds]. */
    @JsonProperty("timeOfPossessionSeconds") @ExcludeMissing fun _timeOfPossessionSeconds(): JsonField<Long> = timeOfPossessionSeconds

    /** Returns the raw JSON value of [totalYards]. */
    @JsonProperty("totalYards") @ExcludeMissing fun _totalYards(): JsonField<Long> = totalYards

    /** Returns the raw JSON value of [turnovers]. */
    @JsonProperty("turnovers") @ExcludeMissing fun _turnovers(): JsonField<Long> = turnovers

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

        /** Returns a mutable builder for constructing an instance of [FootballTeamTotals]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballTeamTotals]. */
    class Builder internal constructor() {

        private var firstDowns: JsonField<Long>? = null
        private var thirdDowns: JsonField<FootballTeamTotalsThirdDowns>? = null
        private var fumbles: JsonField<FootballFumbleStats>? = null
        private var passing: JsonField<FootballPassingStats>? = null
        private var penalties: JsonField<FootballTeamTotalsPenalties>? = null
        private var rushing: JsonField<FootballRushingStats>? = null
        private var timeOfPossessionSeconds: JsonField<Long>? = null
        private var totalYards: JsonField<Long>? = null
        private var turnovers: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballTeamTotals: FootballTeamTotals) = apply {
            firstDowns = footballTeamTotals.firstDowns
            thirdDowns = footballTeamTotals.thirdDowns
            fumbles = footballTeamTotals.fumbles
            passing = footballTeamTotals.passing
            penalties = footballTeamTotals.penalties
            rushing = footballTeamTotals.rushing
            timeOfPossessionSeconds = footballTeamTotals.timeOfPossessionSeconds
            totalYards = footballTeamTotals.totalYards
            turnovers = footballTeamTotals.turnovers
            additionalProperties = footballTeamTotals.additionalProperties.toMutableMap()
        }

        /** First downs. */
        fun firstDowns(firstDowns: Long?) = firstDowns(JsonField.ofNullable(firstDowns))

        fun firstDowns(firstDowns: Long) = firstDowns(firstDowns as Long?)

        fun firstDowns(firstDowns: Optional<Long>) = firstDowns(firstDowns.getOrNull())

        /** Sets [Builder.firstDowns] to an arbitrary JSON value. */
        fun firstDowns(firstDowns: JsonField<Long>) = apply { this.firstDowns = firstDowns }

        /** Third downs tried & converted. */
        fun thirdDowns(thirdDowns: FootballTeamTotalsThirdDowns?) = thirdDowns(JsonField.ofNullable(thirdDowns))

        fun thirdDowns(thirdDowns: Optional<FootballTeamTotalsThirdDowns>) = thirdDowns(thirdDowns.getOrNull())

        /** Sets [Builder.thirdDowns] to an arbitrary JSON value. */
        fun thirdDowns(thirdDowns: JsonField<FootballTeamTotalsThirdDowns>) = apply { this.thirdDowns = thirdDowns }

        /** The team's fumbles, or null. */
        fun fumbles(fumbles: FootballFumbleStats?) = fumbles(JsonField.ofNullable(fumbles))

        fun fumbles(fumbles: Optional<FootballFumbleStats>) = fumbles(fumbles.getOrNull())

        /** Sets [Builder.fumbles] to an arbitrary JSON value. */
        fun fumbles(fumbles: JsonField<FootballFumbleStats>) = apply { this.fumbles = fumbles }

        /** The team's passing, or null. */
        fun passing(passing: FootballPassingStats?) = passing(JsonField.ofNullable(passing))

        fun passing(passing: Optional<FootballPassingStats>) = passing(passing.getOrNull())

        /** Sets [Builder.passing] to an arbitrary JSON value. */
        fun passing(passing: JsonField<FootballPassingStats>) = apply { this.passing = passing }

        /** Penalties against the team. */
        fun penalties(penalties: FootballTeamTotalsPenalties?) = penalties(JsonField.ofNullable(penalties))

        fun penalties(penalties: Optional<FootballTeamTotalsPenalties>) = penalties(penalties.getOrNull())

        /** Sets [Builder.penalties] to an arbitrary JSON value. */
        fun penalties(penalties: JsonField<FootballTeamTotalsPenalties>) = apply { this.penalties = penalties }

        /** The team's rushing, or null. */
        fun rushing(rushing: FootballRushingStats?) = rushing(JsonField.ofNullable(rushing))

        fun rushing(rushing: Optional<FootballRushingStats>) = rushing(rushing.getOrNull())

        /** Sets [Builder.rushing] to an arbitrary JSON value. */
        fun rushing(rushing: JsonField<FootballRushingStats>) = apply { this.rushing = rushing }

        /** Time with the ball, in seconds. */
        fun timeOfPossessionSeconds(timeOfPossessionSeconds: Long?) = timeOfPossessionSeconds(JsonField.ofNullable(timeOfPossessionSeconds))

        fun timeOfPossessionSeconds(timeOfPossessionSeconds: Long) = timeOfPossessionSeconds(timeOfPossessionSeconds as Long?)

        fun timeOfPossessionSeconds(timeOfPossessionSeconds: Optional<Long>) = timeOfPossessionSeconds(timeOfPossessionSeconds.getOrNull())

        /** Sets [Builder.timeOfPossessionSeconds] to an arbitrary JSON value. */
        fun timeOfPossessionSeconds(timeOfPossessionSeconds: JsonField<Long>) = apply { this.timeOfPossessionSeconds = timeOfPossessionSeconds }

        /** Total yards. */
        fun totalYards(totalYards: Long?) = totalYards(JsonField.ofNullable(totalYards))

        fun totalYards(totalYards: Long) = totalYards(totalYards as Long?)

        fun totalYards(totalYards: Optional<Long>) = totalYards(totalYards.getOrNull())

        /** Sets [Builder.totalYards] to an arbitrary JSON value. */
        fun totalYards(totalYards: JsonField<Long>) = apply { this.totalYards = totalYards }

        /** Turnovers. */
        fun turnovers(turnovers: Long?) = turnovers(JsonField.ofNullable(turnovers))

        fun turnovers(turnovers: Long) = turnovers(turnovers as Long?)

        fun turnovers(turnovers: Optional<Long>) = turnovers(turnovers.getOrNull())

        /** Sets [Builder.turnovers] to an arbitrary JSON value. */
        fun turnovers(turnovers: JsonField<Long>) = apply { this.turnovers = turnovers }

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
         * Returns an immutable instance of [FootballTeamTotals].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballTeamTotals =
            FootballTeamTotals(
                checkRequired("firstDowns", firstDowns),
                checkRequired("thirdDowns", thirdDowns),
                checkRequired("fumbles", fumbles),
                checkRequired("passing", passing),
                checkRequired("penalties", penalties),
                checkRequired("rushing", rushing),
                checkRequired("timeOfPossessionSeconds", timeOfPossessionSeconds),
                checkRequired("totalYards", totalYards),
                checkRequired("turnovers", turnovers),
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
    fun validate(): FootballTeamTotals = apply {
        if (validated) {
            return@apply
        }

        firstDowns()
        thirdDowns().ifPresent { it.validate() }
        fumbles().ifPresent { it.validate() }
        passing().ifPresent { it.validate() }
        penalties().ifPresent { it.validate() }
        rushing().ifPresent { it.validate() }
        timeOfPossessionSeconds()
        totalYards()
        turnovers()
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
        (if (firstDowns.asKnown().isPresent) 1 else 0) +
            (thirdDowns.asKnown().getOrNull()?.validity() ?: 0) +
            (fumbles.asKnown().getOrNull()?.validity() ?: 0) +
            (passing.asKnown().getOrNull()?.validity() ?: 0) +
            (penalties.asKnown().getOrNull()?.validity() ?: 0) +
            (rushing.asKnown().getOrNull()?.validity() ?: 0) +
            (if (timeOfPossessionSeconds.asKnown().isPresent) 1 else 0) +
            (if (totalYards.asKnown().isPresent) 1 else 0) +
            (if (turnovers.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballTeamTotals &&
            firstDowns == other.firstDowns &&
            thirdDowns == other.thirdDowns &&
            fumbles == other.fumbles &&
            passing == other.passing &&
            penalties == other.penalties &&
            rushing == other.rushing &&
            timeOfPossessionSeconds == other.timeOfPossessionSeconds &&
            totalYards == other.totalYards &&
            turnovers == other.turnovers &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(firstDowns, thirdDowns, fumbles, passing, penalties, rushing, timeOfPossessionSeconds, totalYards, turnovers, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballTeamTotals{firstDowns=$firstDowns, thirdDowns=$thirdDowns, fumbles=$fumbles, passing=$passing, penalties=$penalties, rushing=$rushing, timeOfPossessionSeconds=$timeOfPossessionSeconds, totalYards=$totalYards, turnovers=$turnovers, additionalProperties=$additionalProperties}"
}
