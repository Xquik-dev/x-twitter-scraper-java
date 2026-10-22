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
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** 1 game's drives & plays, by quarter. */
class FootballPlays
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val league: JsonField<League>,
    private val homeTeamId: JsonField<String>,
    private val awayTeamId: JsonField<String>,
    private val quarters: JsonField<List<FootballQuarter>>,
    private val teams: JsonField<Map<String, SportsTeam>>,
    private val players: JsonField<Map<String, FootballPlayer>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("league") @ExcludeMissing league: JsonField<League> = JsonMissing.of(),
        @JsonProperty("homeTeamId") @ExcludeMissing homeTeamId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("awayTeamId") @ExcludeMissing awayTeamId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("quarters") @ExcludeMissing quarters: JsonField<List<FootballQuarter>> = JsonMissing.of(),
        @JsonProperty("teams") @ExcludeMissing teams: JsonField<Map<String, SportsTeam>> = JsonMissing.of(),
        @JsonProperty("players") @ExcludeMissing players: JsonField<Map<String, FootballPlayer>> = JsonMissing.of(),
    ) : this(id, league, homeTeamId, awayTeamId, quarters, teams, players, mutableMapOf())

    /** The ID of the game these plays come from. */
    fun id(): String = id.getRequired("id")

    /** The league of the game these plays come from. */
    fun league(): League = league.getRequired("league")

    /** The home team, a key of teams. */
    fun homeTeamId(): Optional<String> = homeTeamId.getOptional("homeTeamId")

    /** The away team, a key of teams. */
    fun awayTeamId(): Optional<String> = awayTeamId.getOptional("awayTeamId")

    /** The game's quarters, in order. Empty before kickoff. */
    fun quarters(): List<FootballQuarter> = quarters.getRequired("quarters")

    /** The teams these plays name, by team ID. */
    fun teams(): Map<String, SportsTeam> = teams.getRequired("teams")

    /** The players these plays name, by player ID. */
    fun players(): Map<String, FootballPlayer> = players.getRequired("players")

    /** Returns the raw JSON value of [id]. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** Returns the raw JSON value of [league]. */
    @JsonProperty("league") @ExcludeMissing fun _league(): JsonField<League> = league

    /** Returns the raw JSON value of [homeTeamId]. */
    @JsonProperty("homeTeamId") @ExcludeMissing fun _homeTeamId(): JsonField<String> = homeTeamId

    /** Returns the raw JSON value of [awayTeamId]. */
    @JsonProperty("awayTeamId") @ExcludeMissing fun _awayTeamId(): JsonField<String> = awayTeamId

    /** Returns the raw JSON value of [quarters]. */
    @JsonProperty("quarters") @ExcludeMissing fun _quarters(): JsonField<List<FootballQuarter>> = quarters

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

        /** Returns a mutable builder for constructing an instance of [FootballPlays]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballPlays]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var league: JsonField<League>? = null
        private var homeTeamId: JsonField<String>? = null
        private var awayTeamId: JsonField<String>? = null
        private var quarters: JsonField<MutableList<FootballQuarter>>? = null
        private var teams: JsonField<Map<String, SportsTeam>>? = null
        private var players: JsonField<Map<String, FootballPlayer>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballPlays: FootballPlays) = apply {
            id = footballPlays.id
            league = footballPlays.league
            homeTeamId = footballPlays.homeTeamId
            awayTeamId = footballPlays.awayTeamId
            quarters = footballPlays.quarters.map { it.toMutableList() }
            teams = footballPlays.teams
            players = footballPlays.players
            additionalProperties = footballPlays.additionalProperties.toMutableMap()
        }

        /** The ID of the game these plays come from. */
        fun id(id: String) = id(JsonField.of(id))

        /** Sets [Builder.id] to an arbitrary JSON value. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The league of the game these plays come from. */
        fun league(league: League) = league(JsonField.of(league))

        /** Sets [Builder.league] to an arbitrary JSON value. */
        fun league(league: JsonField<League>) = apply { this.league = league }

        /** The home team, a key of teams. */
        fun homeTeamId(homeTeamId: String?) = homeTeamId(JsonField.ofNullable(homeTeamId))

        fun homeTeamId(homeTeamId: Optional<String>) = homeTeamId(homeTeamId.getOrNull())

        /** Sets [Builder.homeTeamId] to an arbitrary JSON value. */
        fun homeTeamId(homeTeamId: JsonField<String>) = apply { this.homeTeamId = homeTeamId }

        /** The away team, a key of teams. */
        fun awayTeamId(awayTeamId: String?) = awayTeamId(JsonField.ofNullable(awayTeamId))

        fun awayTeamId(awayTeamId: Optional<String>) = awayTeamId(awayTeamId.getOrNull())

        /** Sets [Builder.awayTeamId] to an arbitrary JSON value. */
        fun awayTeamId(awayTeamId: JsonField<String>) = apply { this.awayTeamId = awayTeamId }

        /** The game's quarters, in order. Empty before kickoff. */
        fun quarters(quarters: List<FootballQuarter>) = quarters(JsonField.of(quarters))

        /** Sets [Builder.quarters] to an arbitrary JSON value. */
        fun quarters(quarters: JsonField<List<FootballQuarter>>) = apply { this.quarters = quarters.map { it.toMutableList() } }

        /** Adds a single [FootballQuarter] to [quarters]. */
        fun addQuarter(quarter: FootballQuarter) = apply {
            quarters =
                (quarters ?: JsonField.of(mutableListOf())).also {
                    checkKnown("quarters", it).add(quarter)
                }
        }

        /** The teams these plays name, by team ID. */
        fun teams(teams: Map<String, SportsTeam>) = teams(JsonField.of(teams))

        /** Sets [Builder.teams] to an arbitrary JSON value. */
        fun teams(teams: JsonField<Map<String, SportsTeam>>) = apply { this.teams = teams }

        /** The players these plays name, by player ID. */
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
         * Returns an immutable instance of [FootballPlays].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballPlays =
            FootballPlays(
                checkRequired("id", id),
                checkRequired("league", league),
                checkRequired("homeTeamId", homeTeamId),
                checkRequired("awayTeamId", awayTeamId),
                checkRequired("quarters", quarters).map { it.toImmutable() },
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
    fun validate(): FootballPlays = apply {
        if (validated) {
            return@apply
        }

        id()
        league().validate()
        homeTeamId()
        awayTeamId()
        quarters().forEach { it.validate() }
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
            (if (homeTeamId.asKnown().isPresent) 1 else 0) +
            (if (awayTeamId.asKnown().isPresent) 1 else 0) +
            (quarters.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (teams.asKnown().getOrNull()?.values?.sumOf { it.validity() } ?: 0) +
            (players.asKnown().getOrNull()?.values?.sumOf { it.validity() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballPlays &&
            id == other.id &&
            league == other.league &&
            homeTeamId == other.homeTeamId &&
            awayTeamId == other.awayTeamId &&
            quarters == other.quarters &&
            teams == other.teams &&
            players == other.players &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(id, league, homeTeamId, awayTeamId, quarters, teams, players, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballPlays{id=$id, league=$league, homeTeamId=$homeTeamId, awayTeamId=$awayTeamId, quarters=$quarters, teams=$teams, players=$players, additionalProperties=$additionalProperties}"

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
