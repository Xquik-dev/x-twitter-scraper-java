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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A listed game, with its teams & score. */
class FootballScheduleGame
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val seasonType: JsonField<String>,
    private val week: JsonField<Long>,
    private val startsAt: JsonField<OffsetDateTime>,
    private val status: JsonField<String>,
    private val clock: JsonField<String>,
    private val quarter: JsonField<Long>,
    private val home: JsonField<FootballTeamScore>,
    private val away: JsonField<FootballTeamScore>,
    private val teamIds: JsonField<List<String>>,
    private val periods: JsonField<List<FootballSchedulePeriod>>,
    private val odds: JsonField<FootballScheduleGameOdds>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("seasonType") @ExcludeMissing seasonType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("week") @ExcludeMissing week: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("startsAt") @ExcludeMissing startsAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        @JsonProperty("clock") @ExcludeMissing clock: JsonField<String> = JsonMissing.of(),
        @JsonProperty("quarter") @ExcludeMissing quarter: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("home") @ExcludeMissing home: JsonField<FootballTeamScore> = JsonMissing.of(),
        @JsonProperty("away") @ExcludeMissing away: JsonField<FootballTeamScore> = JsonMissing.of(),
        @JsonProperty("teamIds") @ExcludeMissing teamIds: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("periods") @ExcludeMissing periods: JsonField<List<FootballSchedulePeriod>> = JsonMissing.of(),
        @JsonProperty("odds") @ExcludeMissing odds: JsonField<FootballScheduleGameOdds> = JsonMissing.of(),
    ) : this(id, seasonType, week, startsAt, status, clock, quarter, home, away, teamIds, periods, odds, mutableMapOf())

    /** The game ID the other sports routes take. */
    fun id(): String = id.getRequired("id")

    /** This game's part of the season, such as RegularSeason. */
    fun seasonType(): Optional<String> = seasonType.getOptional("seasonType")

    /** This game's week of the season. */
    fun week(): Optional<Long> = week.getOptional("week")

    /** This game's kickoff time in UTC, or null when Xquik cannot read it. */
    fun startsAt(): Optional<OffsetDateTime> = startsAt.getOptional("startsAt")

    /** This game's status from X, such as Scheduled, InProgress or Closed. */
    fun status(): Optional<String> = status.getOptional("status")

    /** This game's clock, as X writes it. */
    fun clock(): Optional<String> = clock.getOptional("clock")

    /** This game's current or last quarter. */
    fun quarter(): Optional<Long> = quarter.getOptional("quarter")

    /** A team's side of a game & its points. */
    fun home(): FootballTeamScore = home.getRequired("home")

    /** A team's side of a game & its points. */
    fun away(): FootballTeamScore = away.getRequired("away")

    /** The game's teams, keys of teams. */
    fun teamIds(): List<String> = teamIds.getRequired("teamIds")

    /** The periods played so far. */
    fun periods(): List<FootballSchedulePeriod> = periods.getRequired("periods")

    /** Betting odds for each team, or null when X has none. */
    fun odds(): Optional<FootballScheduleGameOdds> = odds.getOptional("odds")

    /** Returns the raw JSON value of [id]. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** Returns the raw JSON value of [seasonType]. */
    @JsonProperty("seasonType") @ExcludeMissing fun _seasonType(): JsonField<String> = seasonType

    /** Returns the raw JSON value of [week]. */
    @JsonProperty("week") @ExcludeMissing fun _week(): JsonField<Long> = week

    /** Returns the raw JSON value of [startsAt]. */
    @JsonProperty("startsAt") @ExcludeMissing fun _startsAt(): JsonField<OffsetDateTime> = startsAt

    /** Returns the raw JSON value of [status]. */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

    /** Returns the raw JSON value of [clock]. */
    @JsonProperty("clock") @ExcludeMissing fun _clock(): JsonField<String> = clock

    /** Returns the raw JSON value of [quarter]. */
    @JsonProperty("quarter") @ExcludeMissing fun _quarter(): JsonField<Long> = quarter

    /** Returns the raw JSON value of [home]. */
    @JsonProperty("home") @ExcludeMissing fun _home(): JsonField<FootballTeamScore> = home

    /** Returns the raw JSON value of [away]. */
    @JsonProperty("away") @ExcludeMissing fun _away(): JsonField<FootballTeamScore> = away

    /** Returns the raw JSON value of [teamIds]. */
    @JsonProperty("teamIds") @ExcludeMissing fun _teamIds(): JsonField<List<String>> = teamIds

    /** Returns the raw JSON value of [periods]. */
    @JsonProperty("periods") @ExcludeMissing fun _periods(): JsonField<List<FootballSchedulePeriod>> = periods

    /** Returns the raw JSON value of [odds]. */
    @JsonProperty("odds") @ExcludeMissing fun _odds(): JsonField<FootballScheduleGameOdds> = odds

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

        /** Returns a mutable builder for constructing an instance of [FootballScheduleGame]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballScheduleGame]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var seasonType: JsonField<String>? = null
        private var week: JsonField<Long>? = null
        private var startsAt: JsonField<OffsetDateTime>? = null
        private var status: JsonField<String>? = null
        private var clock: JsonField<String>? = null
        private var quarter: JsonField<Long>? = null
        private var home: JsonField<FootballTeamScore>? = null
        private var away: JsonField<FootballTeamScore>? = null
        private var teamIds: JsonField<MutableList<String>>? = null
        private var periods: JsonField<MutableList<FootballSchedulePeriod>>? = null
        private var odds: JsonField<FootballScheduleGameOdds>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballScheduleGame: FootballScheduleGame) = apply {
            id = footballScheduleGame.id
            seasonType = footballScheduleGame.seasonType
            week = footballScheduleGame.week
            startsAt = footballScheduleGame.startsAt
            status = footballScheduleGame.status
            clock = footballScheduleGame.clock
            quarter = footballScheduleGame.quarter
            home = footballScheduleGame.home
            away = footballScheduleGame.away
            teamIds = footballScheduleGame.teamIds.map { it.toMutableList() }
            periods = footballScheduleGame.periods.map { it.toMutableList() }
            odds = footballScheduleGame.odds
            additionalProperties = footballScheduleGame.additionalProperties.toMutableMap()
        }

        /** The game ID the other sports routes take. */
        fun id(id: String) = id(JsonField.of(id))

        /** Sets [Builder.id] to an arbitrary JSON value. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** This game's part of the season, such as RegularSeason. */
        fun seasonType(seasonType: String?) = seasonType(JsonField.ofNullable(seasonType))

        fun seasonType(seasonType: Optional<String>) = seasonType(seasonType.getOrNull())

        /** Sets [Builder.seasonType] to an arbitrary JSON value. */
        fun seasonType(seasonType: JsonField<String>) = apply { this.seasonType = seasonType }

        /** This game's week of the season. */
        fun week(week: Long?) = week(JsonField.ofNullable(week))

        fun week(week: Long) = week(week as Long?)

        fun week(week: Optional<Long>) = week(week.getOrNull())

        /** Sets [Builder.week] to an arbitrary JSON value. */
        fun week(week: JsonField<Long>) = apply { this.week = week }

        /** This game's kickoff time in UTC, or null when Xquik cannot read it. */
        fun startsAt(startsAt: OffsetDateTime?) = startsAt(JsonField.ofNullable(startsAt))

        fun startsAt(startsAt: Optional<OffsetDateTime>) = startsAt(startsAt.getOrNull())

        /** Sets [Builder.startsAt] to an arbitrary JSON value. */
        fun startsAt(startsAt: JsonField<OffsetDateTime>) = apply { this.startsAt = startsAt }

        /** This game's status from X, such as Scheduled, InProgress or Closed. */
        fun status(status: String?) = status(JsonField.ofNullable(status))

        fun status(status: Optional<String>) = status(status.getOrNull())

        /** Sets [Builder.status] to an arbitrary JSON value. */
        fun status(status: JsonField<String>) = apply { this.status = status }

        /** This game's clock, as X writes it. */
        fun clock(clock: String?) = clock(JsonField.ofNullable(clock))

        fun clock(clock: Optional<String>) = clock(clock.getOrNull())

        /** Sets [Builder.clock] to an arbitrary JSON value. */
        fun clock(clock: JsonField<String>) = apply { this.clock = clock }

        /** This game's current or last quarter. */
        fun quarter(quarter: Long?) = quarter(JsonField.ofNullable(quarter))

        fun quarter(quarter: Long) = quarter(quarter as Long?)

        fun quarter(quarter: Optional<Long>) = quarter(quarter.getOrNull())

        /** Sets [Builder.quarter] to an arbitrary JSON value. */
        fun quarter(quarter: JsonField<Long>) = apply { this.quarter = quarter }

        /** A team's side of a game & its points. */
        fun home(home: FootballTeamScore) = home(JsonField.of(home))

        /** Sets [Builder.home] to an arbitrary JSON value. */
        fun home(home: JsonField<FootballTeamScore>) = apply { this.home = home }

        /** A team's side of a game & its points. */
        fun away(away: FootballTeamScore) = away(JsonField.of(away))

        /** Sets [Builder.away] to an arbitrary JSON value. */
        fun away(away: JsonField<FootballTeamScore>) = apply { this.away = away }

        /** The game's teams, keys of teams. */
        fun teamIds(teamIds: List<String>) = teamIds(JsonField.of(teamIds))

        /** Sets [Builder.teamIds] to an arbitrary JSON value. */
        fun teamIds(teamIds: JsonField<List<String>>) = apply { this.teamIds = teamIds.map { it.toMutableList() } }

        /** Adds a single [String] to [teamIds]. */
        fun addTeamId(teamId: String) = apply {
            teamIds =
                (teamIds ?: JsonField.of(mutableListOf())).also {
                    checkKnown("teamIds", it).add(teamId)
                }
        }

        /** The periods played so far. */
        fun periods(periods: List<FootballSchedulePeriod>) = periods(JsonField.of(periods))

        /** Sets [Builder.periods] to an arbitrary JSON value. */
        fun periods(periods: JsonField<List<FootballSchedulePeriod>>) = apply { this.periods = periods.map { it.toMutableList() } }

        /** Adds a single [FootballSchedulePeriod] to [periods]. */
        fun addPeriod(period: FootballSchedulePeriod) = apply {
            periods =
                (periods ?: JsonField.of(mutableListOf())).also {
                    checkKnown("periods", it).add(period)
                }
        }

        /** Betting odds for each team, or null when X has none. */
        fun odds(odds: FootballScheduleGameOdds?) = odds(JsonField.ofNullable(odds))

        fun odds(odds: Optional<FootballScheduleGameOdds>) = odds(odds.getOrNull())

        /** Sets [Builder.odds] to an arbitrary JSON value. */
        fun odds(odds: JsonField<FootballScheduleGameOdds>) = apply { this.odds = odds }

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
         * Returns an immutable instance of [FootballScheduleGame].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballScheduleGame =
            FootballScheduleGame(
                checkRequired("id", id),
                checkRequired("seasonType", seasonType),
                checkRequired("week", week),
                checkRequired("startsAt", startsAt),
                checkRequired("status", status),
                checkRequired("clock", clock),
                checkRequired("quarter", quarter),
                checkRequired("home", home),
                checkRequired("away", away),
                checkRequired("teamIds", teamIds).map { it.toImmutable() },
                checkRequired("periods", periods).map { it.toImmutable() },
                checkRequired("odds", odds),
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
    fun validate(): FootballScheduleGame = apply {
        if (validated) {
            return@apply
        }

        id()
        seasonType()
        week()
        startsAt()
        status()
        clock()
        quarter()
        home().validate()
        away().validate()
        teamIds()
        periods().forEach { it.validate() }
        odds().ifPresent { it.validate() }
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
            (if (seasonType.asKnown().isPresent) 1 else 0) +
            (if (week.asKnown().isPresent) 1 else 0) +
            (if (startsAt.asKnown().isPresent) 1 else 0) +
            (if (status.asKnown().isPresent) 1 else 0) +
            (if (clock.asKnown().isPresent) 1 else 0) +
            (if (quarter.asKnown().isPresent) 1 else 0) +
            (home.asKnown().getOrNull()?.validity() ?: 0) +
            (away.asKnown().getOrNull()?.validity() ?: 0) +
            (teamIds.asKnown().getOrNull()?.size ?: 0) +
            (periods.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (odds.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballScheduleGame &&
            id == other.id &&
            seasonType == other.seasonType &&
            week == other.week &&
            startsAt == other.startsAt &&
            status == other.status &&
            clock == other.clock &&
            quarter == other.quarter &&
            home == other.home &&
            away == other.away &&
            teamIds == other.teamIds &&
            periods == other.periods &&
            odds == other.odds &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(id, seasonType, week, startsAt, status, clock, quarter, home, away, teamIds, periods, odds, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballScheduleGame{id=$id, seasonType=$seasonType, week=$week, startsAt=$startsAt, status=$status, clock=$clock, quarter=$quarter, home=$home, away=$away, teamIds=$teamIds, periods=$periods, odds=$odds, additionalProperties=$additionalProperties}"
}
