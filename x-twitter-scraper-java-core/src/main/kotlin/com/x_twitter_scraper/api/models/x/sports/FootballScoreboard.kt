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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** 1 game's scoreboard. */
class FootballScoreboard
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val league: JsonField<League>,
    private val seasonId: JsonField<String>,
    private val seasonType: JsonField<String>,
    private val week: JsonField<Long>,
    private val startsAt: JsonField<OffsetDateTime>,
    private val venue: JsonField<String>,
    private val status: JsonField<String>,
    private val clock: JsonField<String>,
    private val quarter: JsonField<Long>,
    private val situation: JsonField<FootballScoreboardSituation>,
    private val home: JsonField<FootballSide>,
    private val away: JsonField<FootballSide>,
    private val periods: JsonField<List<FootballPeriod>>,
    private val lastPlay: JsonField<FootballPlay>,
    private val teams: JsonField<Map<String, SportsTeam>>,
    private val players: JsonField<Map<String, FootballPlayer>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("league") @ExcludeMissing league: JsonField<League> = JsonMissing.of(),
        @JsonProperty("seasonId") @ExcludeMissing seasonId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("seasonType") @ExcludeMissing seasonType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("week") @ExcludeMissing week: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("startsAt") @ExcludeMissing startsAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("venue") @ExcludeMissing venue: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        @JsonProperty("clock") @ExcludeMissing clock: JsonField<String> = JsonMissing.of(),
        @JsonProperty("quarter") @ExcludeMissing quarter: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("situation") @ExcludeMissing situation: JsonField<FootballScoreboardSituation> = JsonMissing.of(),
        @JsonProperty("home") @ExcludeMissing home: JsonField<FootballSide> = JsonMissing.of(),
        @JsonProperty("away") @ExcludeMissing away: JsonField<FootballSide> = JsonMissing.of(),
        @JsonProperty("periods") @ExcludeMissing periods: JsonField<List<FootballPeriod>> = JsonMissing.of(),
        @JsonProperty("lastPlay") @ExcludeMissing lastPlay: JsonField<FootballPlay> = JsonMissing.of(),
        @JsonProperty("teams") @ExcludeMissing teams: JsonField<Map<String, SportsTeam>> = JsonMissing.of(),
        @JsonProperty("players") @ExcludeMissing players: JsonField<Map<String, FootballPlayer>> = JsonMissing.of(),
    ) : this(id, league, seasonId, seasonType, week, startsAt, venue, status, clock, quarter, situation, home, away, periods, lastPlay, teams, players, mutableMapOf())

    /** The game ID from your request. */
    fun id(): String = id.getRequired("id")

    /** The league from your request. */
    fun league(): League = league.getRequired("league")

    /** X's ID for the season. NFL games have one. */
    fun seasonId(): Optional<String> = seasonId.getOptional("seasonId")

    /** The part of the season, such as RegularSeason. */
    fun seasonType(): Optional<String> = seasonType.getOptional("seasonType")

    /** The week of the season. */
    fun week(): Optional<Long> = week.getOptional("week")

    /** The kickoff time in UTC, or null when X sends none Xquik can read. */
    fun startsAt(): Optional<OffsetDateTime> = startsAt.getOptional("startsAt")

    /** The stadium. */
    fun venue(): Optional<String> = venue.getOptional("venue")

    /** X's game status, such as Scheduled, InProgress or Closed. */
    fun status(): Optional<String> = status.getOptional("status")

    /** The game clock, as X writes it. */
    fun clock(): Optional<String> = clock.getOptional("clock")

    /** The current or last quarter. */
    fun quarter(): Optional<Long> = quarter.getOptional("quarter")

    /** Down & distance now, or null before kickoff. */
    fun situation(): Optional<FootballScoreboardSituation> = situation.getOptional("situation")

    /** A team's side of a scoreboard. */
    fun home(): FootballSide = home.getRequired("home")

    /** A team's side of a scoreboard. */
    fun away(): FootballSide = away.getRequired("away")

    /** Points by period, in order. */
    fun periods(): List<FootballPeriod> = periods.getRequired("periods")

    /** The latest play, or null before kickoff. */
    fun lastPlay(): Optional<FootballPlay> = lastPlay.getOptional("lastPlay")

    /** The teams this answer names, by team ID. */
    fun teams(): Map<String, SportsTeam> = teams.getRequired("teams")

    /** The players this answer names, by player ID. */
    fun players(): Map<String, FootballPlayer> = players.getRequired("players")

    /** Returns the raw JSON value of [id]. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** Returns the raw JSON value of [league]. */
    @JsonProperty("league") @ExcludeMissing fun _league(): JsonField<League> = league

    /** Returns the raw JSON value of [seasonId]. */
    @JsonProperty("seasonId") @ExcludeMissing fun _seasonId(): JsonField<String> = seasonId

    /** Returns the raw JSON value of [seasonType]. */
    @JsonProperty("seasonType") @ExcludeMissing fun _seasonType(): JsonField<String> = seasonType

    /** Returns the raw JSON value of [week]. */
    @JsonProperty("week") @ExcludeMissing fun _week(): JsonField<Long> = week

    /** Returns the raw JSON value of [startsAt]. */
    @JsonProperty("startsAt") @ExcludeMissing fun _startsAt(): JsonField<OffsetDateTime> = startsAt

    /** Returns the raw JSON value of [venue]. */
    @JsonProperty("venue") @ExcludeMissing fun _venue(): JsonField<String> = venue

    /** Returns the raw JSON value of [status]. */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

    /** Returns the raw JSON value of [clock]. */
    @JsonProperty("clock") @ExcludeMissing fun _clock(): JsonField<String> = clock

    /** Returns the raw JSON value of [quarter]. */
    @JsonProperty("quarter") @ExcludeMissing fun _quarter(): JsonField<Long> = quarter

    /** Returns the raw JSON value of [situation]. */
    @JsonProperty("situation") @ExcludeMissing fun _situation(): JsonField<FootballScoreboardSituation> = situation

    /** Returns the raw JSON value of [home]. */
    @JsonProperty("home") @ExcludeMissing fun _home(): JsonField<FootballSide> = home

    /** Returns the raw JSON value of [away]. */
    @JsonProperty("away") @ExcludeMissing fun _away(): JsonField<FootballSide> = away

    /** Returns the raw JSON value of [periods]. */
    @JsonProperty("periods") @ExcludeMissing fun _periods(): JsonField<List<FootballPeriod>> = periods

    /** Returns the raw JSON value of [lastPlay]. */
    @JsonProperty("lastPlay") @ExcludeMissing fun _lastPlay(): JsonField<FootballPlay> = lastPlay

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

        /** Returns a mutable builder for constructing an instance of [FootballScoreboard]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballScoreboard]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var league: JsonField<League>? = null
        private var seasonId: JsonField<String>? = null
        private var seasonType: JsonField<String>? = null
        private var week: JsonField<Long>? = null
        private var startsAt: JsonField<OffsetDateTime>? = null
        private var venue: JsonField<String>? = null
        private var status: JsonField<String>? = null
        private var clock: JsonField<String>? = null
        private var quarter: JsonField<Long>? = null
        private var situation: JsonField<FootballScoreboardSituation>? = null
        private var home: JsonField<FootballSide>? = null
        private var away: JsonField<FootballSide>? = null
        private var periods: JsonField<MutableList<FootballPeriod>>? = null
        private var lastPlay: JsonField<FootballPlay>? = null
        private var teams: JsonField<Map<String, SportsTeam>>? = null
        private var players: JsonField<Map<String, FootballPlayer>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballScoreboard: FootballScoreboard) = apply {
            id = footballScoreboard.id
            league = footballScoreboard.league
            seasonId = footballScoreboard.seasonId
            seasonType = footballScoreboard.seasonType
            week = footballScoreboard.week
            startsAt = footballScoreboard.startsAt
            venue = footballScoreboard.venue
            status = footballScoreboard.status
            clock = footballScoreboard.clock
            quarter = footballScoreboard.quarter
            situation = footballScoreboard.situation
            home = footballScoreboard.home
            away = footballScoreboard.away
            periods = footballScoreboard.periods.map { it.toMutableList() }
            lastPlay = footballScoreboard.lastPlay
            teams = footballScoreboard.teams
            players = footballScoreboard.players
            additionalProperties = footballScoreboard.additionalProperties.toMutableMap()
        }

        /** The game ID from your request. */
        fun id(id: String) = id(JsonField.of(id))

        /** Sets [Builder.id] to an arbitrary JSON value. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The league from your request. */
        fun league(league: League) = league(JsonField.of(league))

        /** Sets [Builder.league] to an arbitrary JSON value. */
        fun league(league: JsonField<League>) = apply { this.league = league }

        /** X's ID for the season. NFL games have one. */
        fun seasonId(seasonId: String?) = seasonId(JsonField.ofNullable(seasonId))

        fun seasonId(seasonId: Optional<String>) = seasonId(seasonId.getOrNull())

        /** Sets [Builder.seasonId] to an arbitrary JSON value. */
        fun seasonId(seasonId: JsonField<String>) = apply { this.seasonId = seasonId }

        /** The part of the season, such as RegularSeason. */
        fun seasonType(seasonType: String?) = seasonType(JsonField.ofNullable(seasonType))

        fun seasonType(seasonType: Optional<String>) = seasonType(seasonType.getOrNull())

        /** Sets [Builder.seasonType] to an arbitrary JSON value. */
        fun seasonType(seasonType: JsonField<String>) = apply { this.seasonType = seasonType }

        /** The week of the season. */
        fun week(week: Long?) = week(JsonField.ofNullable(week))

        fun week(week: Long) = week(week as Long?)

        fun week(week: Optional<Long>) = week(week.getOrNull())

        /** Sets [Builder.week] to an arbitrary JSON value. */
        fun week(week: JsonField<Long>) = apply { this.week = week }

        /** The kickoff time in UTC, or null when X sends none Xquik can read. */
        fun startsAt(startsAt: OffsetDateTime?) = startsAt(JsonField.ofNullable(startsAt))

        fun startsAt(startsAt: Optional<OffsetDateTime>) = startsAt(startsAt.getOrNull())

        /** Sets [Builder.startsAt] to an arbitrary JSON value. */
        fun startsAt(startsAt: JsonField<OffsetDateTime>) = apply { this.startsAt = startsAt }

        /** The stadium. */
        fun venue(venue: String?) = venue(JsonField.ofNullable(venue))

        fun venue(venue: Optional<String>) = venue(venue.getOrNull())

        /** Sets [Builder.venue] to an arbitrary JSON value. */
        fun venue(venue: JsonField<String>) = apply { this.venue = venue }

        /** X's game status, such as Scheduled, InProgress or Closed. */
        fun status(status: String?) = status(JsonField.ofNullable(status))

        fun status(status: Optional<String>) = status(status.getOrNull())

        /** Sets [Builder.status] to an arbitrary JSON value. */
        fun status(status: JsonField<String>) = apply { this.status = status }

        /** The game clock, as X writes it. */
        fun clock(clock: String?) = clock(JsonField.ofNullable(clock))

        fun clock(clock: Optional<String>) = clock(clock.getOrNull())

        /** Sets [Builder.clock] to an arbitrary JSON value. */
        fun clock(clock: JsonField<String>) = apply { this.clock = clock }

        /** The current or last quarter. */
        fun quarter(quarter: Long?) = quarter(JsonField.ofNullable(quarter))

        fun quarter(quarter: Long) = quarter(quarter as Long?)

        fun quarter(quarter: Optional<Long>) = quarter(quarter.getOrNull())

        /** Sets [Builder.quarter] to an arbitrary JSON value. */
        fun quarter(quarter: JsonField<Long>) = apply { this.quarter = quarter }

        /** Down & distance now, or null before kickoff. */
        fun situation(situation: FootballScoreboardSituation?) = situation(JsonField.ofNullable(situation))

        fun situation(situation: Optional<FootballScoreboardSituation>) = situation(situation.getOrNull())

        /** Sets [Builder.situation] to an arbitrary JSON value. */
        fun situation(situation: JsonField<FootballScoreboardSituation>) = apply { this.situation = situation }

        /** A team's side of a scoreboard. */
        fun home(home: FootballSide) = home(JsonField.of(home))

        /** Sets [Builder.home] to an arbitrary JSON value. */
        fun home(home: JsonField<FootballSide>) = apply { this.home = home }

        /** A team's side of a scoreboard. */
        fun away(away: FootballSide) = away(JsonField.of(away))

        /** Sets [Builder.away] to an arbitrary JSON value. */
        fun away(away: JsonField<FootballSide>) = apply { this.away = away }

        /** Points by period, in order. */
        fun periods(periods: List<FootballPeriod>) = periods(JsonField.of(periods))

        /** Sets [Builder.periods] to an arbitrary JSON value. */
        fun periods(periods: JsonField<List<FootballPeriod>>) = apply { this.periods = periods.map { it.toMutableList() } }

        /** Adds a single [FootballPeriod] to [periods]. */
        fun addPeriod(period: FootballPeriod) = apply {
            periods =
                (periods ?: JsonField.of(mutableListOf())).also {
                    checkKnown("periods", it).add(period)
                }
        }

        /** The latest play, or null before kickoff. */
        fun lastPlay(lastPlay: FootballPlay?) = lastPlay(JsonField.ofNullable(lastPlay))

        fun lastPlay(lastPlay: Optional<FootballPlay>) = lastPlay(lastPlay.getOrNull())

        /** Sets [Builder.lastPlay] to an arbitrary JSON value. */
        fun lastPlay(lastPlay: JsonField<FootballPlay>) = apply { this.lastPlay = lastPlay }

        /** The teams this answer names, by team ID. */
        fun teams(teams: Map<String, SportsTeam>) = teams(JsonField.of(teams))

        /** Sets [Builder.teams] to an arbitrary JSON value. */
        fun teams(teams: JsonField<Map<String, SportsTeam>>) = apply { this.teams = teams }

        /** The players this answer names, by player ID. */
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
         * Returns an immutable instance of [FootballScoreboard].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballScoreboard =
            FootballScoreboard(
                checkRequired("id", id),
                checkRequired("league", league),
                checkRequired("seasonId", seasonId),
                checkRequired("seasonType", seasonType),
                checkRequired("week", week),
                checkRequired("startsAt", startsAt),
                checkRequired("venue", venue),
                checkRequired("status", status),
                checkRequired("clock", clock),
                checkRequired("quarter", quarter),
                checkRequired("situation", situation),
                checkRequired("home", home),
                checkRequired("away", away),
                checkRequired("periods", periods).map { it.toImmutable() },
                checkRequired("lastPlay", lastPlay),
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
    fun validate(): FootballScoreboard = apply {
        if (validated) {
            return@apply
        }

        id()
        league().validate()
        seasonId()
        seasonType()
        week()
        startsAt()
        venue()
        status()
        clock()
        quarter()
        situation().ifPresent { it.validate() }
        home().validate()
        away().validate()
        periods().forEach { it.validate() }
        lastPlay().ifPresent { it.validate() }
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
            (if (seasonId.asKnown().isPresent) 1 else 0) +
            (if (seasonType.asKnown().isPresent) 1 else 0) +
            (if (week.asKnown().isPresent) 1 else 0) +
            (if (startsAt.asKnown().isPresent) 1 else 0) +
            (if (venue.asKnown().isPresent) 1 else 0) +
            (if (status.asKnown().isPresent) 1 else 0) +
            (if (clock.asKnown().isPresent) 1 else 0) +
            (if (quarter.asKnown().isPresent) 1 else 0) +
            (situation.asKnown().getOrNull()?.validity() ?: 0) +
            (home.asKnown().getOrNull()?.validity() ?: 0) +
            (away.asKnown().getOrNull()?.validity() ?: 0) +
            (periods.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (lastPlay.asKnown().getOrNull()?.validity() ?: 0) +
            (teams.asKnown().getOrNull()?.values?.sumOf { it.validity() } ?: 0) +
            (players.asKnown().getOrNull()?.values?.sumOf { it.validity() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballScoreboard &&
            id == other.id &&
            league == other.league &&
            seasonId == other.seasonId &&
            seasonType == other.seasonType &&
            week == other.week &&
            startsAt == other.startsAt &&
            venue == other.venue &&
            status == other.status &&
            clock == other.clock &&
            quarter == other.quarter &&
            situation == other.situation &&
            home == other.home &&
            away == other.away &&
            periods == other.periods &&
            lastPlay == other.lastPlay &&
            teams == other.teams &&
            players == other.players &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(id, league, seasonId, seasonType, week, startsAt, venue, status, clock, quarter, situation, home, away, periods, lastPlay, teams, players, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballScoreboard{id=$id, league=$league, seasonId=$seasonId, seasonType=$seasonType, week=$week, startsAt=$startsAt, venue=$venue, status=$status, clock=$clock, quarter=$quarter, situation=$situation, home=$home, away=$away, periods=$periods, lastPlay=$lastPlay, teams=$teams, players=$players, additionalProperties=$additionalProperties}"

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
