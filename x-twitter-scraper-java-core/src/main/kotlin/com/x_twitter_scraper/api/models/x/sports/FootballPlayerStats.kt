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

/** 1 player's stats for 1 game. Only the stat groups X sent are present. */
class FootballPlayerStats
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val playerId: JsonField<String>,
    private val passing: JsonField<FootballPassingStats>,
    private val rushing: JsonField<FootballRushingStats>,
    private val receiving: JsonField<FootballPlayerStatsReceiving>,
    private val defense: JsonField<FootballPlayerStatsDefense>,
    private val fumbles: JsonField<FootballFumbleStats>,
    private val kickReturns: JsonField<FootballReturnStats>,
    private val puntReturns: JsonField<FootballReturnStats>,
    private val interceptionReturns: JsonField<FootballReturnStats>,
    private val punts: JsonField<FootballPlayerStatsPunts>,
    private val fieldGoals: JsonField<FootballPlayerStatsFieldGoals>,
    private val extraPoints: JsonField<FootballPlayerStatsExtraPoints>,
    private val conversions: JsonField<FootballPlayerStatsConversions>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("playerId") @ExcludeMissing playerId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("passing") @ExcludeMissing passing: JsonField<FootballPassingStats> = JsonMissing.of(),
        @JsonProperty("rushing") @ExcludeMissing rushing: JsonField<FootballRushingStats> = JsonMissing.of(),
        @JsonProperty("receiving") @ExcludeMissing receiving: JsonField<FootballPlayerStatsReceiving> = JsonMissing.of(),
        @JsonProperty("defense") @ExcludeMissing defense: JsonField<FootballPlayerStatsDefense> = JsonMissing.of(),
        @JsonProperty("fumbles") @ExcludeMissing fumbles: JsonField<FootballFumbleStats> = JsonMissing.of(),
        @JsonProperty("kickReturns") @ExcludeMissing kickReturns: JsonField<FootballReturnStats> = JsonMissing.of(),
        @JsonProperty("puntReturns") @ExcludeMissing puntReturns: JsonField<FootballReturnStats> = JsonMissing.of(),
        @JsonProperty("interceptionReturns") @ExcludeMissing interceptionReturns: JsonField<FootballReturnStats> = JsonMissing.of(),
        @JsonProperty("punts") @ExcludeMissing punts: JsonField<FootballPlayerStatsPunts> = JsonMissing.of(),
        @JsonProperty("fieldGoals") @ExcludeMissing fieldGoals: JsonField<FootballPlayerStatsFieldGoals> = JsonMissing.of(),
        @JsonProperty("extraPoints") @ExcludeMissing extraPoints: JsonField<FootballPlayerStatsExtraPoints> = JsonMissing.of(),
        @JsonProperty("conversions") @ExcludeMissing conversions: JsonField<FootballPlayerStatsConversions> = JsonMissing.of(),
    ) : this(playerId, passing, rushing, receiving, defense, fumbles, kickReturns, puntReturns, interceptionReturns, punts, fieldGoals, extraPoints, conversions, mutableMapOf())

    /** The player these stats belong to, a key of players. */
    fun playerId(): Optional<String> = playerId.getOptional("playerId")

    /** Passing stats. */
    fun passing(): Optional<FootballPassingStats> = passing.getOptional("passing")

    /** Rushing stats. */
    fun rushing(): Optional<FootballRushingStats> = rushing.getOptional("rushing")

    /** Receiving stats. */
    fun receiving(): Optional<FootballPlayerStatsReceiving> = receiving.getOptional("receiving")

    /** Defensive stats. */
    fun defense(): Optional<FootballPlayerStatsDefense> = defense.getOptional("defense")

    /** Fumble stats. */
    fun fumbles(): Optional<FootballFumbleStats> = fumbles.getOptional("fumbles")

    /** Kick, punt or interception return stats. */
    fun kickReturns(): Optional<FootballReturnStats> = kickReturns.getOptional("kickReturns")

    /** Kick, punt or interception return stats. */
    fun puntReturns(): Optional<FootballReturnStats> = puntReturns.getOptional("puntReturns")

    /** Kick, punt or interception return stats. */
    fun interceptionReturns(): Optional<FootballReturnStats> = interceptionReturns.getOptional("interceptionReturns")

    /** Punting stats. */
    fun punts(): Optional<FootballPlayerStatsPunts> = punts.getOptional("punts")

    /** Field goal stats. */
    fun fieldGoals(): Optional<FootballPlayerStatsFieldGoals> = fieldGoals.getOptional("fieldGoals")

    /** Extra point kicks. */
    fun extraPoints(): Optional<FootballPlayerStatsExtraPoints> = extraPoints.getOptional("extraPoints")

    /** 2-point conversions. */
    fun conversions(): Optional<FootballPlayerStatsConversions> = conversions.getOptional("conversions")

    /** Returns the raw JSON value of [playerId]. */
    @JsonProperty("playerId") @ExcludeMissing fun _playerId(): JsonField<String> = playerId

    /** Returns the raw JSON value of [passing]. */
    @JsonProperty("passing") @ExcludeMissing fun _passing(): JsonField<FootballPassingStats> = passing

    /** Returns the raw JSON value of [rushing]. */
    @JsonProperty("rushing") @ExcludeMissing fun _rushing(): JsonField<FootballRushingStats> = rushing

    /** Returns the raw JSON value of [receiving]. */
    @JsonProperty("receiving") @ExcludeMissing fun _receiving(): JsonField<FootballPlayerStatsReceiving> = receiving

    /** Returns the raw JSON value of [defense]. */
    @JsonProperty("defense") @ExcludeMissing fun _defense(): JsonField<FootballPlayerStatsDefense> = defense

    /** Returns the raw JSON value of [fumbles]. */
    @JsonProperty("fumbles") @ExcludeMissing fun _fumbles(): JsonField<FootballFumbleStats> = fumbles

    /** Returns the raw JSON value of [kickReturns]. */
    @JsonProperty("kickReturns") @ExcludeMissing fun _kickReturns(): JsonField<FootballReturnStats> = kickReturns

    /** Returns the raw JSON value of [puntReturns]. */
    @JsonProperty("puntReturns") @ExcludeMissing fun _puntReturns(): JsonField<FootballReturnStats> = puntReturns

    /** Returns the raw JSON value of [interceptionReturns]. */
    @JsonProperty("interceptionReturns") @ExcludeMissing fun _interceptionReturns(): JsonField<FootballReturnStats> = interceptionReturns

    /** Returns the raw JSON value of [punts]. */
    @JsonProperty("punts") @ExcludeMissing fun _punts(): JsonField<FootballPlayerStatsPunts> = punts

    /** Returns the raw JSON value of [fieldGoals]. */
    @JsonProperty("fieldGoals") @ExcludeMissing fun _fieldGoals(): JsonField<FootballPlayerStatsFieldGoals> = fieldGoals

    /** Returns the raw JSON value of [extraPoints]. */
    @JsonProperty("extraPoints") @ExcludeMissing fun _extraPoints(): JsonField<FootballPlayerStatsExtraPoints> = extraPoints

    /** Returns the raw JSON value of [conversions]. */
    @JsonProperty("conversions") @ExcludeMissing fun _conversions(): JsonField<FootballPlayerStatsConversions> = conversions

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

        /** Returns a mutable builder for constructing an instance of [FootballPlayerStats]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballPlayerStats]. */
    class Builder internal constructor() {

        private var playerId: JsonField<String>? = null
        private var passing: JsonField<FootballPassingStats> = JsonMissing.of()
        private var rushing: JsonField<FootballRushingStats> = JsonMissing.of()
        private var receiving: JsonField<FootballPlayerStatsReceiving> = JsonMissing.of()
        private var defense: JsonField<FootballPlayerStatsDefense> = JsonMissing.of()
        private var fumbles: JsonField<FootballFumbleStats> = JsonMissing.of()
        private var kickReturns: JsonField<FootballReturnStats> = JsonMissing.of()
        private var puntReturns: JsonField<FootballReturnStats> = JsonMissing.of()
        private var interceptionReturns: JsonField<FootballReturnStats> = JsonMissing.of()
        private var punts: JsonField<FootballPlayerStatsPunts> = JsonMissing.of()
        private var fieldGoals: JsonField<FootballPlayerStatsFieldGoals> = JsonMissing.of()
        private var extraPoints: JsonField<FootballPlayerStatsExtraPoints> = JsonMissing.of()
        private var conversions: JsonField<FootballPlayerStatsConversions> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballPlayerStats: FootballPlayerStats) = apply {
            playerId = footballPlayerStats.playerId
            passing = footballPlayerStats.passing
            rushing = footballPlayerStats.rushing
            receiving = footballPlayerStats.receiving
            defense = footballPlayerStats.defense
            fumbles = footballPlayerStats.fumbles
            kickReturns = footballPlayerStats.kickReturns
            puntReturns = footballPlayerStats.puntReturns
            interceptionReturns = footballPlayerStats.interceptionReturns
            punts = footballPlayerStats.punts
            fieldGoals = footballPlayerStats.fieldGoals
            extraPoints = footballPlayerStats.extraPoints
            conversions = footballPlayerStats.conversions
            additionalProperties = footballPlayerStats.additionalProperties.toMutableMap()
        }

        /** The player these stats belong to, a key of players. */
        fun playerId(playerId: String?) = playerId(JsonField.ofNullable(playerId))

        fun playerId(playerId: Optional<String>) = playerId(playerId.getOrNull())

        /** Sets [Builder.playerId] to an arbitrary JSON value. */
        fun playerId(playerId: JsonField<String>) = apply { this.playerId = playerId }

        /** Passing stats. */
        fun passing(passing: FootballPassingStats) = passing(JsonField.of(passing))

        /** Sets [Builder.passing] to an arbitrary JSON value. */
        fun passing(passing: JsonField<FootballPassingStats>) = apply { this.passing = passing }

        /** Rushing stats. */
        fun rushing(rushing: FootballRushingStats) = rushing(JsonField.of(rushing))

        /** Sets [Builder.rushing] to an arbitrary JSON value. */
        fun rushing(rushing: JsonField<FootballRushingStats>) = apply { this.rushing = rushing }

        /** Receiving stats. */
        fun receiving(receiving: FootballPlayerStatsReceiving) = receiving(JsonField.of(receiving))

        /** Sets [Builder.receiving] to an arbitrary JSON value. */
        fun receiving(receiving: JsonField<FootballPlayerStatsReceiving>) = apply { this.receiving = receiving }

        /** Defensive stats. */
        fun defense(defense: FootballPlayerStatsDefense) = defense(JsonField.of(defense))

        /** Sets [Builder.defense] to an arbitrary JSON value. */
        fun defense(defense: JsonField<FootballPlayerStatsDefense>) = apply { this.defense = defense }

        /** Fumble stats. */
        fun fumbles(fumbles: FootballFumbleStats) = fumbles(JsonField.of(fumbles))

        /** Sets [Builder.fumbles] to an arbitrary JSON value. */
        fun fumbles(fumbles: JsonField<FootballFumbleStats>) = apply { this.fumbles = fumbles }

        /** Kick, punt or interception return stats. */
        fun kickReturns(kickReturns: FootballReturnStats) = kickReturns(JsonField.of(kickReturns))

        /** Sets [Builder.kickReturns] to an arbitrary JSON value. */
        fun kickReturns(kickReturns: JsonField<FootballReturnStats>) = apply { this.kickReturns = kickReturns }

        /** Kick, punt or interception return stats. */
        fun puntReturns(puntReturns: FootballReturnStats) = puntReturns(JsonField.of(puntReturns))

        /** Sets [Builder.puntReturns] to an arbitrary JSON value. */
        fun puntReturns(puntReturns: JsonField<FootballReturnStats>) = apply { this.puntReturns = puntReturns }

        /** Kick, punt or interception return stats. */
        fun interceptionReturns(interceptionReturns: FootballReturnStats) = interceptionReturns(JsonField.of(interceptionReturns))

        /** Sets [Builder.interceptionReturns] to an arbitrary JSON value. */
        fun interceptionReturns(interceptionReturns: JsonField<FootballReturnStats>) = apply { this.interceptionReturns = interceptionReturns }

        /** Punting stats. */
        fun punts(punts: FootballPlayerStatsPunts) = punts(JsonField.of(punts))

        /** Sets [Builder.punts] to an arbitrary JSON value. */
        fun punts(punts: JsonField<FootballPlayerStatsPunts>) = apply { this.punts = punts }

        /** Field goal stats. */
        fun fieldGoals(fieldGoals: FootballPlayerStatsFieldGoals) = fieldGoals(JsonField.of(fieldGoals))

        /** Sets [Builder.fieldGoals] to an arbitrary JSON value. */
        fun fieldGoals(fieldGoals: JsonField<FootballPlayerStatsFieldGoals>) = apply { this.fieldGoals = fieldGoals }

        /** Extra point kicks. */
        fun extraPoints(extraPoints: FootballPlayerStatsExtraPoints) = extraPoints(JsonField.of(extraPoints))

        /** Sets [Builder.extraPoints] to an arbitrary JSON value. */
        fun extraPoints(extraPoints: JsonField<FootballPlayerStatsExtraPoints>) = apply { this.extraPoints = extraPoints }

        /** 2-point conversions. */
        fun conversions(conversions: FootballPlayerStatsConversions) = conversions(JsonField.of(conversions))

        /** Sets [Builder.conversions] to an arbitrary JSON value. */
        fun conversions(conversions: JsonField<FootballPlayerStatsConversions>) = apply { this.conversions = conversions }

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
         * Returns an immutable instance of [FootballPlayerStats].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballPlayerStats =
            FootballPlayerStats(
                checkRequired("playerId", playerId),
                passing,
                rushing,
                receiving,
                defense,
                fumbles,
                kickReturns,
                puntReturns,
                interceptionReturns,
                punts,
                fieldGoals,
                extraPoints,
                conversions,
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
    fun validate(): FootballPlayerStats = apply {
        if (validated) {
            return@apply
        }

        playerId()
        passing().ifPresent { it.validate() }
        rushing().ifPresent { it.validate() }
        receiving().ifPresent { it.validate() }
        defense().ifPresent { it.validate() }
        fumbles().ifPresent { it.validate() }
        kickReturns().ifPresent { it.validate() }
        puntReturns().ifPresent { it.validate() }
        interceptionReturns().ifPresent { it.validate() }
        punts().ifPresent { it.validate() }
        fieldGoals().ifPresent { it.validate() }
        extraPoints().ifPresent { it.validate() }
        conversions().ifPresent { it.validate() }
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
        (if (playerId.asKnown().isPresent) 1 else 0) +
            (passing.asKnown().getOrNull()?.validity() ?: 0) +
            (rushing.asKnown().getOrNull()?.validity() ?: 0) +
            (receiving.asKnown().getOrNull()?.validity() ?: 0) +
            (defense.asKnown().getOrNull()?.validity() ?: 0) +
            (fumbles.asKnown().getOrNull()?.validity() ?: 0) +
            (kickReturns.asKnown().getOrNull()?.validity() ?: 0) +
            (puntReturns.asKnown().getOrNull()?.validity() ?: 0) +
            (interceptionReturns.asKnown().getOrNull()?.validity() ?: 0) +
            (punts.asKnown().getOrNull()?.validity() ?: 0) +
            (fieldGoals.asKnown().getOrNull()?.validity() ?: 0) +
            (extraPoints.asKnown().getOrNull()?.validity() ?: 0) +
            (conversions.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballPlayerStats &&
            playerId == other.playerId &&
            passing == other.passing &&
            rushing == other.rushing &&
            receiving == other.receiving &&
            defense == other.defense &&
            fumbles == other.fumbles &&
            kickReturns == other.kickReturns &&
            puntReturns == other.puntReturns &&
            interceptionReturns == other.interceptionReturns &&
            punts == other.punts &&
            fieldGoals == other.fieldGoals &&
            extraPoints == other.extraPoints &&
            conversions == other.conversions &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(playerId, passing, rushing, receiving, defense, fumbles, kickReturns, puntReturns, interceptionReturns, punts, fieldGoals, extraPoints, conversions, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballPlayerStats{playerId=$playerId, passing=$passing, rushing=$rushing, receiving=$receiving, defense=$defense, fumbles=$fumbles, kickReturns=$kickReturns, puntReturns=$puntReturns, interceptionReturns=$interceptionReturns, punts=$punts, fieldGoals=$fieldGoals, extraPoints=$extraPoints, conversions=$conversions, additionalProperties=$additionalProperties}"
}
