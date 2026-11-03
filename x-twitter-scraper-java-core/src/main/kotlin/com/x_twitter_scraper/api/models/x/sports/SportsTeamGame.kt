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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A recent game of a team, as X lists it with the team. */
class SportsTeamGame
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val startsAt: JsonField<OffsetDateTime>,
    private val venue: JsonField<String>,
    private val status: JsonField<String>,
    private val clock: JsonField<String>,
    private val quarter: JsonField<Long>,
    private val home: JsonField<FootballTeamScore>,
    private val away: JsonField<FootballTeamScore>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("startsAt")
        @ExcludeMissing
        startsAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("venue") @ExcludeMissing venue: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        @JsonProperty("clock") @ExcludeMissing clock: JsonField<String> = JsonMissing.of(),
        @JsonProperty("quarter") @ExcludeMissing quarter: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("home") @ExcludeMissing home: JsonField<FootballTeamScore> = JsonMissing.of(),
        @JsonProperty("away") @ExcludeMissing away: JsonField<FootballTeamScore> = JsonMissing.of(),
    ) : this(id, startsAt, venue, status, clock, quarter, home, away, mutableMapOf())

    /** The game ID, which the game routes take. */
    fun id(): String = id.getRequired("id")

    /** When this game kicked off, in UTC. Null when Xquik can't read X's time. */
    fun startsAt(): Optional<OffsetDateTime> = startsAt.getOptional("startsAt")

    /** The stadium. X has sent none in recent games so far. */
    fun venue(): Optional<String> = venue.getOptional("venue")

    /** This game's status as X names it, such as Closed. */
    fun status(): Optional<String> = status.getOptional("status")

    /** The game clock, as X writes it. X has sent none so far. */
    fun clock(): Optional<String> = clock.getOptional("clock")

    /** The current or last quarter. X has sent none so far. */
    fun quarter(): Optional<Long> = quarter.getOptional("quarter")

    /** A team's side of a game & its points. */
    fun home(): FootballTeamScore = home.getRequired("home")

    /** A team's side of a game & its points. */
    fun away(): FootballTeamScore = away.getRequired("away")

    /** Returns the raw JSON value of [id]. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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

    /** Returns the raw JSON value of [home]. */
    @JsonProperty("home") @ExcludeMissing fun _home(): JsonField<FootballTeamScore> = home

    /** Returns the raw JSON value of [away]. */
    @JsonProperty("away") @ExcludeMissing fun _away(): JsonField<FootballTeamScore> = away

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

        /** Returns a mutable builder for constructing an instance of [SportsTeamGame]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SportsTeamGame]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var startsAt: JsonField<OffsetDateTime>? = null
        private var venue: JsonField<String>? = null
        private var status: JsonField<String>? = null
        private var clock: JsonField<String>? = null
        private var quarter: JsonField<Long>? = null
        private var home: JsonField<FootballTeamScore>? = null
        private var away: JsonField<FootballTeamScore>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(sportsTeamGame: SportsTeamGame) = apply {
            id = sportsTeamGame.id
            startsAt = sportsTeamGame.startsAt
            venue = sportsTeamGame.venue
            status = sportsTeamGame.status
            clock = sportsTeamGame.clock
            quarter = sportsTeamGame.quarter
            home = sportsTeamGame.home
            away = sportsTeamGame.away
            additionalProperties = sportsTeamGame.additionalProperties.toMutableMap()
        }

        /** The game ID, which the game routes take. */
        fun id(id: String) = id(JsonField.of(id))

        /** Sets [Builder.id] to an arbitrary JSON value. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** When this game kicked off, in UTC. Null when Xquik can't read X's time. */
        fun startsAt(startsAt: OffsetDateTime?) = startsAt(JsonField.ofNullable(startsAt))

        /** Alias for calling [Builder.startsAt] with `startsAt.orElse(null)`. */
        fun startsAt(startsAt: Optional<OffsetDateTime>) = startsAt(startsAt.getOrNull())

        /** Sets [Builder.startsAt] to an arbitrary JSON value. */
        fun startsAt(startsAt: JsonField<OffsetDateTime>) = apply { this.startsAt = startsAt }

        /** The stadium. X has sent none in recent games so far. */
        fun venue(venue: String?) = venue(JsonField.ofNullable(venue))

        /** Alias for calling [Builder.venue] with `venue.orElse(null)`. */
        fun venue(venue: Optional<String>) = venue(venue.getOrNull())

        /** Sets [Builder.venue] to an arbitrary JSON value. */
        fun venue(venue: JsonField<String>) = apply { this.venue = venue }

        /** This game's status as X names it, such as Closed. */
        fun status(status: String?) = status(JsonField.ofNullable(status))

        /** Alias for calling [Builder.status] with `status.orElse(null)`. */
        fun status(status: Optional<String>) = status(status.getOrNull())

        /** Sets [Builder.status] to an arbitrary JSON value. */
        fun status(status: JsonField<String>) = apply { this.status = status }

        /** The game clock, as X writes it. X has sent none so far. */
        fun clock(clock: String?) = clock(JsonField.ofNullable(clock))

        /** Alias for calling [Builder.clock] with `clock.orElse(null)`. */
        fun clock(clock: Optional<String>) = clock(clock.getOrNull())

        /** Sets [Builder.clock] to an arbitrary JSON value. */
        fun clock(clock: JsonField<String>) = apply { this.clock = clock }

        /** The current or last quarter. X has sent none so far. */
        fun quarter(quarter: Long?) = quarter(JsonField.ofNullable(quarter))

        /**
         * Alias for [Builder.quarter].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun quarter(quarter: Long) = quarter(quarter as Long?)

        /** Alias for calling [Builder.quarter] with `quarter.orElse(null)`. */
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
         * Returns an immutable instance of [SportsTeamGame].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SportsTeamGame =
            SportsTeamGame(
                checkRequired("id", id),
                checkRequired("startsAt", startsAt),
                checkRequired("venue", venue),
                checkRequired("status", status),
                checkRequired("clock", clock),
                checkRequired("quarter", quarter),
                checkRequired("home", home),
                checkRequired("away", away),
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
    fun validate(): SportsTeamGame = apply {
        if (validated) {
            return@apply
        }

        id()
        startsAt()
        venue()
        status()
        clock()
        quarter()
        home().validate()
        away().validate()
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
            (if (startsAt.asKnown().isPresent) 1 else 0) +
            (if (venue.asKnown().isPresent) 1 else 0) +
            (if (status.asKnown().isPresent) 1 else 0) +
            (if (clock.asKnown().isPresent) 1 else 0) +
            (if (quarter.asKnown().isPresent) 1 else 0) +
            (home.asKnown().getOrNull()?.validity() ?: 0) +
            (away.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SportsTeamGame &&
            id == other.id &&
            startsAt == other.startsAt &&
            venue == other.venue &&
            status == other.status &&
            clock == other.clock &&
            quarter == other.quarter &&
            home == other.home &&
            away == other.away &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, startsAt, venue, status, clock, quarter, home, away, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SportsTeamGame{id=$id, startsAt=$startsAt, venue=$venue, status=$status, clock=$clock, quarter=$quarter, home=$home, away=$away, additionalProperties=$additionalProperties}"
}
