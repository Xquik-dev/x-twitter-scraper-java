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
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** 1 game's team totals & player stats. */
class FootballBoxScore
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val league: JsonField<League>,
    private val home: JsonField<FootballTeamBox>,
    private val away: JsonField<FootballTeamBox>,
    private val teams: JsonField<Map<String, SportsTeam>>,
    private val players: JsonField<Map<String, FootballPlayer>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("league") @ExcludeMissing league: JsonField<League> = JsonMissing.of(),
        @JsonProperty("home") @ExcludeMissing home: JsonField<FootballTeamBox> = JsonMissing.of(),
        @JsonProperty("away") @ExcludeMissing away: JsonField<FootballTeamBox> = JsonMissing.of(),
        @JsonProperty("teams") @ExcludeMissing teams: JsonField<Map<String, SportsTeam>> = JsonMissing.of(),
        @JsonProperty("players") @ExcludeMissing players: JsonField<Map<String, FootballPlayer>> = JsonMissing.of(),
    ) : this(id, league, home, away, teams, players, mutableMapOf())

    /** The ID of the game this box score covers. */
    fun id(): String = id.getRequired("id")

    /** The league of the game this box score covers. */
    fun league(): League = league.getRequired("league")

    /** 1 team's totals & player stats. */
    fun home(): FootballTeamBox = home.getRequired("home")

    /** 1 team's totals & player stats. */
    fun away(): FootballTeamBox = away.getRequired("away")

    /** The teams this box score names, by team ID. */
    fun teams(): Map<String, SportsTeam> = teams.getRequired("teams")

    /** The players this box score names, by player ID. */
    fun players(): Map<String, FootballPlayer> = players.getRequired("players")

    /** Returns the raw JSON value of [id]. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** Returns the raw JSON value of [league]. */
    @JsonProperty("league") @ExcludeMissing fun _league(): JsonField<League> = league

    /** Returns the raw JSON value of [home]. */
    @JsonProperty("home") @ExcludeMissing fun _home(): JsonField<FootballTeamBox> = home

    /** Returns the raw JSON value of [away]. */
    @JsonProperty("away") @ExcludeMissing fun _away(): JsonField<FootballTeamBox> = away

    /** Returns the raw JSON value of [teams]. */
    @JsonProperty("teams") @ExcludeMissing fun _teams(): JsonField<Map<String, SportsTeam>> = teams

    /** Returns the raw JSON value of [players]. */
    @JsonProperty("players") @ExcludeMissing fun _players(): JsonField<Map<String, FootballPlayer>> = players

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

        /** Returns a mutable builder for constructing an instance of [FootballBoxScore]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballBoxScore]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var league: JsonField<League>? = null
        private var home: JsonField<FootballTeamBox>? = null
        private var away: JsonField<FootballTeamBox>? = null
        private var teams: JsonField<Map<String, SportsTeam>>? = null
        private var players: JsonField<Map<String, FootballPlayer>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballBoxScore: FootballBoxScore) = apply {
            id = footballBoxScore.id
            league = footballBoxScore.league
            home = footballBoxScore.home
            away = footballBoxScore.away
            teams = footballBoxScore.teams
            players = footballBoxScore.players
            additionalProperties = footballBoxScore.additionalProperties.toMutableMap()
        }

        /** The ID of the game this box score covers. */
        fun id(id: String) = id(JsonField.of(id))

        /** Sets [Builder.id] to an arbitrary JSON value. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The league of the game this box score covers. */
        fun league(league: League) = league(JsonField.of(league))

        /** Sets [Builder.league] to an arbitrary JSON value. */
        fun league(league: JsonField<League>) = apply { this.league = league }

        /** 1 team's totals & player stats. */
        fun home(home: FootballTeamBox) = home(JsonField.of(home))

        /** Sets [Builder.home] to an arbitrary JSON value. */
        fun home(home: JsonField<FootballTeamBox>) = apply { this.home = home }

        /** 1 team's totals & player stats. */
        fun away(away: FootballTeamBox) = away(JsonField.of(away))

        /** Sets [Builder.away] to an arbitrary JSON value. */
        fun away(away: JsonField<FootballTeamBox>) = apply { this.away = away }

        /** The teams this box score names, by team ID. */
        fun teams(teams: Map<String, SportsTeam>) = teams(JsonField.of(teams))

        /** Sets [Builder.teams] to an arbitrary JSON value. */
        fun teams(teams: JsonField<Map<String, SportsTeam>>) = apply { this.teams = teams }

        /** The players this box score names, by player ID. */
        fun players(players: Map<String, FootballPlayer>) = players(JsonField.of(players))

        /** Sets [Builder.players] to an arbitrary JSON value. */
        fun players(players: JsonField<Map<String, FootballPlayer>>) = apply { this.players = players }

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
         * Returns an immutable instance of [FootballBoxScore].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballBoxScore =
            FootballBoxScore(
                checkRequired("id", id),
                checkRequired("league", league),
                checkRequired("home", home),
                checkRequired("away", away),
                checkRequired("teams", teams),
                checkRequired("players", players),
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
    fun validate(): FootballBoxScore = apply {
        if (validated) {
            return@apply
        }

        id()
        league().validate()
        home().validate()
        away().validate()
        teams().values.forEach { it.validate() }
        players().values.forEach { it.validate() }
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
            (league.asKnown().getOrNull()?.validity() ?: 0) +
            (home.asKnown().getOrNull()?.validity() ?: 0) +
            (away.asKnown().getOrNull()?.validity() ?: 0) +
            (teams.asKnown().getOrNull()?.values?.sumOf { it.validity() } ?: 0) +
            (players.asKnown().getOrNull()?.values?.sumOf { it.validity() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballBoxScore &&
            id == other.id &&
            league == other.league &&
            home == other.home &&
            away == other.away &&
            teams == other.teams &&
            players == other.players &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(id, league, home, away, teams, players, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballBoxScore{id=$id, league=$league, home=$home, away=$away, teams=$teams, players=$players, additionalProperties=$additionalProperties}"

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
