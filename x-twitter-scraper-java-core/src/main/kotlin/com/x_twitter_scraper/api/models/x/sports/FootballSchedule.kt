// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.sports

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.Enum
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
import kotlin.jvm.optionals.getOrNull

/** A league's games in a time window. */
class FootballSchedule
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val league: JsonField<League>,
    private val games: JsonField<List<FootballScheduleGame>>,
    private val teams: JsonField<Map<String, SportsTeam>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("league") @ExcludeMissing league: JsonField<League> = JsonMissing.of(),
        @JsonProperty("games") @ExcludeMissing games: JsonField<List<FootballScheduleGame>> = JsonMissing.of(),
        @JsonProperty("teams") @ExcludeMissing teams: JsonField<Map<String, SportsTeam>> = JsonMissing.of(),
    ) : this(league, games, teams, mutableMapOf())

    /** The league whose games this list holds. */
    fun league(): League = league.getRequired("league")

    /** The games, earliest first. */
    fun games(): List<FootballScheduleGame> = games.getRequired("games")

    /** The teams the games name, by team ID. */
    fun teams(): Map<String, SportsTeam> = teams.getRequired("teams")

    /** Returns the raw JSON value of [league]. */
    @JsonProperty("league") @ExcludeMissing fun _league(): JsonField<League> = league

    /** Returns the raw JSON value of [games]. */
    @JsonProperty("games") @ExcludeMissing fun _games(): JsonField<List<FootballScheduleGame>> = games

    /** Returns the raw JSON value of [teams]. */
    @JsonProperty("teams") @ExcludeMissing fun _teams(): JsonField<Map<String, SportsTeam>> = teams

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

        /** Returns a mutable builder for constructing an instance of [FootballSchedule]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballSchedule]. */
    class Builder internal constructor() {

        private var league: JsonField<League>? = null
        private var games: JsonField<MutableList<FootballScheduleGame>>? = null
        private var teams: JsonField<Map<String, SportsTeam>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballSchedule: FootballSchedule) = apply {
            league = footballSchedule.league
            games = footballSchedule.games.map { it.toMutableList() }
            teams = footballSchedule.teams
            additionalProperties = footballSchedule.additionalProperties.toMutableMap()
        }

        /** The league whose games this list holds. */
        fun league(league: League) = league(JsonField.of(league))

        /** Sets [Builder.league] to an arbitrary JSON value. */
        fun league(league: JsonField<League>) = apply { this.league = league }

        /** The games, earliest first. */
        fun games(games: List<FootballScheduleGame>) = games(JsonField.of(games))

        /** Sets [Builder.games] to an arbitrary JSON value. */
        fun games(games: JsonField<List<FootballScheduleGame>>) = apply { this.games = games.map { it.toMutableList() } }

        /** Adds a single [FootballScheduleGame] to [games]. */
        fun addGame(game: FootballScheduleGame) = apply {
            games =
                (games ?: JsonField.of(mutableListOf())).also {
                    checkKnown("games", it).add(game)
                }
        }

        /** The teams the games name, by team ID. */
        fun teams(teams: Map<String, SportsTeam>) = teams(JsonField.of(teams))

        /** Sets [Builder.teams] to an arbitrary JSON value. */
        fun teams(teams: JsonField<Map<String, SportsTeam>>) = apply { this.teams = teams }

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
         * Returns an immutable instance of [FootballSchedule].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballSchedule =
            FootballSchedule(
                checkRequired("league", league),
                checkRequired("games", games).map { it.toImmutable() },
                checkRequired("teams", teams),
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
    fun validate(): FootballSchedule = apply {
        if (validated) {
            return@apply
        }

        league().validate()
        games().forEach { it.validate() }
        teams().values.forEach { it.validate() }
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
        (league.asKnown().getOrNull()?.validity() ?: 0) +
            (games.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (teams.asKnown().getOrNull()?.values?.sumOf { it.validity() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballSchedule &&
            league == other.league &&
            games == other.games &&
            teams == other.teams &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(league, games, teams, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballSchedule{league=$league, games=$games, teams=$teams, additionalProperties=$additionalProperties}"

    class League @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val NFL = of("nfl")

            @JvmField val NCAAFB = of("ncaafb")

            @JvmStatic fun of(value: String) = League(JsonField.of(value))
        }

        /** An enum containing [League]'s known values. */
        enum class Known {
            NFL,
            NCAAFB,
        }

        /** An enum containing [League]'s known values, as well as an [_UNKNOWN] member. */
        enum class Value {
            NFL,
            NCAAFB,
            /** An enum member indicating that [League] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /** Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if unknown. */
        fun value(): Value =
            when (this) {
                NFL -> Value.NFL
                NCAAFB -> Value.NCAAFB
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                NFL -> Known.NFL
                NCAAFB -> Known.NCAAFB
                else -> throw XTwitterScraperInvalidDataException("Unknown League: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        /** Validates that this value is a known member. */
        fun validate(): League = apply {
            if (validated) {
                return@apply
            }

            known()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is League && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }
}
