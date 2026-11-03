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

/** 1 team's totals & player stats. */
class FootballTeamBox
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val teamId: JsonField<String>,
    private val totals: JsonField<FootballTeamTotals>,
    private val players: JsonField<List<FootballPlayerStats>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("teamId") @ExcludeMissing teamId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("totals") @ExcludeMissing totals: JsonField<FootballTeamTotals> = JsonMissing.of(),
        @JsonProperty("players") @ExcludeMissing players: JsonField<List<FootballPlayerStats>> = JsonMissing.of(),
    ) : this(teamId, totals, players, mutableMapOf())

    /** The team these totals belong to, a key of teams. */
    fun teamId(): Optional<String> = teamId.getOptional("teamId")

    /** The team's totals, or null before kickoff. */
    fun totals(): Optional<FootballTeamTotals> = totals.getOptional("totals")

    /** Each player with stats, 1 entry per player. */
    fun players(): List<FootballPlayerStats> = players.getRequired("players")

    /** Returns the raw JSON value of [teamId]. */
    @JsonProperty("teamId") @ExcludeMissing fun _teamId(): JsonField<String> = teamId

    /** Returns the raw JSON value of [totals]. */
    @JsonProperty("totals") @ExcludeMissing fun _totals(): JsonField<FootballTeamTotals> = totals

    /** Returns the raw JSON value of [players]. */
    @JsonProperty("players") @ExcludeMissing fun _players(): JsonField<List<FootballPlayerStats>> = players

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

        /** Returns a mutable builder for constructing an instance of [FootballTeamBox]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballTeamBox]. */
    class Builder internal constructor() {

        private var teamId: JsonField<String>? = null
        private var totals: JsonField<FootballTeamTotals>? = null
        private var players: JsonField<MutableList<FootballPlayerStats>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballTeamBox: FootballTeamBox) = apply {
            teamId = footballTeamBox.teamId
            totals = footballTeamBox.totals
            players = footballTeamBox.players.map { it.toMutableList() }
            additionalProperties = footballTeamBox.additionalProperties.toMutableMap()
        }

        /** The team these totals belong to, a key of teams. */
        fun teamId(teamId: String?) = teamId(JsonField.ofNullable(teamId))

        fun teamId(teamId: Optional<String>) = teamId(teamId.getOrNull())

        /** Sets [Builder.teamId] to an arbitrary JSON value. */
        fun teamId(teamId: JsonField<String>) = apply { this.teamId = teamId }

        /** The team's totals, or null before kickoff. */
        fun totals(totals: FootballTeamTotals?) = totals(JsonField.ofNullable(totals))

        fun totals(totals: Optional<FootballTeamTotals>) = totals(totals.getOrNull())

        /** Sets [Builder.totals] to an arbitrary JSON value. */
        fun totals(totals: JsonField<FootballTeamTotals>) = apply { this.totals = totals }

        /** Each player with stats, 1 entry per player. */
        fun players(players: List<FootballPlayerStats>) = players(JsonField.of(players))

        /** Sets [Builder.players] to an arbitrary JSON value. */
        fun players(players: JsonField<List<FootballPlayerStats>>) = apply { this.players = players.map { it.toMutableList() } }

        /** Adds a single [FootballPlayerStats] to [players]. */
        fun addPlayer(player: FootballPlayerStats) = apply {
            players =
                (players ?: JsonField.of(mutableListOf())).also {
                    checkKnown("players", it).add(player)
                }
        }

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
         * Returns an immutable instance of [FootballTeamBox].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballTeamBox =
            FootballTeamBox(
                checkRequired("teamId", teamId),
                checkRequired("totals", totals),
                checkRequired("players", players).map { it.toImmutable() },
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
    fun validate(): FootballTeamBox = apply {
        if (validated) {
            return@apply
        }

        teamId()
        totals().ifPresent { it.validate() }
        players().forEach { it.validate() }
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
            (totals.asKnown().getOrNull()?.validity() ?: 0) +
            (players.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballTeamBox &&
            teamId == other.teamId &&
            totals == other.totals &&
            players == other.players &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(teamId, totals, players, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballTeamBox{teamId=$teamId, totals=$totals, players=$players, additionalProperties=$additionalProperties}"
}
