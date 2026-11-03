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

/** Both teams' rosters for 1 NFL game. */
class FootballRoster
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val league: JsonField<League>,
    private val rosters: JsonField<List<FootballRosterTeam>>,
    private val teams: JsonField<Map<String, SportsTeam>>,
    private val players: JsonField<Map<String, FootballPlayer>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("league") @ExcludeMissing league: JsonField<League> = JsonMissing.of(),
        @JsonProperty("rosters")
        @ExcludeMissing
        rosters: JsonField<List<FootballRosterTeam>> = JsonMissing.of(),
        @JsonProperty("teams")
        @ExcludeMissing
        teams: JsonField<Map<String, SportsTeam>> = JsonMissing.of(),
        @JsonProperty("players")
        @ExcludeMissing
        players: JsonField<Map<String, FootballPlayer>> = JsonMissing.of(),
    ) : this(id, league, rosters, teams, players, mutableMapOf())

    /** The ID of the game these rosters cover. */
    fun id(): String = id.getRequired("id")

    /** The league of the game these rosters cover. */
    fun league(): League = league.getRequired("league")

    /** Each team's roster, in X's order. */
    fun rosters(): List<FootballRosterTeam> = rosters.getRequired("rosters")

    /** The 2 teams, by team ID. */
    fun teams(): Map<String, SportsTeam> = teams.getRequired("teams")

    /**
     * Every rostered player, by player ID. Rosters carry no college or birth details & only a
     * medium headshot, so the rest are null.
     */
    fun players(): Map<String, FootballPlayer> = players.getRequired("players")

    /** Returns the raw JSON value of [id]. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** Returns the raw JSON value of [league]. */
    @JsonProperty("league") @ExcludeMissing fun _league(): JsonField<League> = league

    /** Returns the raw JSON value of [rosters]. */
    @JsonProperty("rosters")
    @ExcludeMissing
    fun _rosters(): JsonField<List<FootballRosterTeam>> = rosters

    /** Returns the raw JSON value of [teams]. */
    @JsonProperty("teams") @ExcludeMissing fun _teams(): JsonField<Map<String, SportsTeam>> = teams

    /** Returns the raw JSON value of [players]. */
    @JsonProperty("players")
    @ExcludeMissing
    fun _players(): JsonField<Map<String, FootballPlayer>> = players

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

        /** Returns a mutable builder for constructing an instance of [FootballRoster]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballRoster]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var league: JsonField<League>? = null
        private var rosters: JsonField<MutableList<FootballRosterTeam>>? = null
        private var teams: JsonField<Map<String, SportsTeam>>? = null
        private var players: JsonField<Map<String, FootballPlayer>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(footballRoster: FootballRoster) = apply {
            id = footballRoster.id
            league = footballRoster.league
            rosters = footballRoster.rosters.map { it.toMutableList() }
            teams = footballRoster.teams
            players = footballRoster.players
            additionalProperties = footballRoster.additionalProperties.toMutableMap()
        }

        /** The ID of the game these rosters cover. */
        fun id(id: String) = id(JsonField.of(id))

        /** Sets [Builder.id] to an arbitrary JSON value. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The league of the game these rosters cover. */
        fun league(league: League) = league(JsonField.of(league))

        /** Sets [Builder.league] to an arbitrary JSON value. */
        fun league(league: JsonField<League>) = apply { this.league = league }

        /** Each team's roster, in X's order. */
        fun rosters(rosters: List<FootballRosterTeam>) = rosters(JsonField.of(rosters))

        /** Sets [Builder.rosters] to an arbitrary JSON value. */
        fun rosters(rosters: JsonField<List<FootballRosterTeam>>) = apply {
            this.rosters = rosters.map { it.toMutableList() }
        }

        /** Adds a single [FootballRosterTeam] to [rosters]. */
        fun addRoster(roster: FootballRosterTeam) = apply {
            rosters =
                (rosters ?: JsonField.of(mutableListOf())).also {
                    checkKnown("rosters", it).add(roster)
                }
        }

        /** The 2 teams, by team ID. */
        fun teams(teams: Map<String, SportsTeam>) = teams(JsonField.of(teams))

        /** Sets [Builder.teams] to an arbitrary JSON value. */
        fun teams(teams: JsonField<Map<String, SportsTeam>>) = apply { this.teams = teams }

        /**
         * Every rostered player, by player ID. Rosters carry no college or birth details & only a
         * medium headshot, so the rest are null.
         */
        fun players(players: Map<String, FootballPlayer>) = players(JsonField.of(players))

        /** Sets [Builder.players] to an arbitrary JSON value. */
        fun players(players: JsonField<Map<String, FootballPlayer>>) = apply {
            this.players = players
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
         * Returns an immutable instance of [FootballRoster].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballRoster =
            FootballRoster(
                checkRequired("id", id),
                checkRequired("league", league),
                checkRequired("rosters", rosters).map { it.toImmutable() },
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
    fun validate(): FootballRoster = apply {
        if (validated) {
            return@apply
        }

        id()
        league().validate()
        rosters().forEach { it.validate() }
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

    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (league.asKnown().getOrNull()?.validity() ?: 0) +
            (rosters.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (teams.asKnown().getOrNull()?.values?.sumOf { it.validity() } ?: 0) +
            (players.asKnown().getOrNull()?.values?.sumOf { it.validity() } ?: 0)

    /** The league of the game these rosters cover. */
    class League @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val NFL = of("nfl")

            @JvmStatic fun of(value: String) = League(JsonField.of(value))
        }

        /** An enum containing [League]'s known values. */
        enum class Known {
            NFL
        }

        /** An enum containing [League]'s known values, as well as an [_UNKNOWN] member. */
        enum class Value {
            NFL,
            /** An enum member indicating that [League] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if unknown.
         */
        fun value(): Value =
            when (this) {
                NFL -> Value.NFL
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballRoster &&
            id == other.id &&
            league == other.league &&
            rosters == other.rosters &&
            teams == other.teams &&
            players == other.players &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, league, rosters, teams, players, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballRoster{id=$id, league=$league, rosters=$rosters, teams=$teams, players=$players, additionalProperties=$additionalProperties}"
}
