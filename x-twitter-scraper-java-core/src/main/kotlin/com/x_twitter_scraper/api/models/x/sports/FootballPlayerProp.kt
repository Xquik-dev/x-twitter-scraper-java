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

/** 1 player's line & odds in a prop category. */
class FootballPlayerProp
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val playerId: JsonField<String>,
    private val rank: JsonField<Double>,
    private val line: JsonField<Double>,
    private val odds: JsonField<Double>,
    private val alternateOdds: JsonField<Double>,
    private val openForBetting: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("playerId") @ExcludeMissing playerId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("rank") @ExcludeMissing rank: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("line") @ExcludeMissing line: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("odds") @ExcludeMissing odds: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("alternateOdds")
        @ExcludeMissing
        alternateOdds: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("openForBetting")
        @ExcludeMissing
        openForBetting: JsonField<Boolean> = JsonMissing.of(),
    ) : this(playerId, rank, line, odds, alternateOdds, openForBetting, mutableMapOf())

    /** The player the line is for, a key of players. */
    fun playerId(): Optional<String> = playerId.getOptional("playerId")

    /** The line's place in its category, from 1. */
    fun rank(): Optional<Double> = rank.getOptional("rank")

    /**
     * The line the odds price, such as 248.5 yards. Null when the prop has no line, such as the
     * first touchdown scorer.
     */
    fun line(): Optional<Double> = line.getOptional("line")

    /** The American odds X shows first, such as -115 or 240. */
    fun odds(): Optional<Double> = odds.getOptional("odds")

    /** The American odds X shows second. Null for a prop with 1 price. */
    fun alternateOdds(): Optional<Double> = alternateOdds.getOptional("alternateOdds")

    /** Whether the sportsbook takes bets on the line. */
    fun openForBetting(): Optional<Boolean> = openForBetting.getOptional("openForBetting")

    /** Returns the raw JSON value of [playerId]. */
    @JsonProperty("playerId") @ExcludeMissing fun _playerId(): JsonField<String> = playerId

    /** Returns the raw JSON value of [rank]. */
    @JsonProperty("rank") @ExcludeMissing fun _rank(): JsonField<Double> = rank

    /** Returns the raw JSON value of [line]. */
    @JsonProperty("line") @ExcludeMissing fun _line(): JsonField<Double> = line

    /** Returns the raw JSON value of [odds]. */
    @JsonProperty("odds") @ExcludeMissing fun _odds(): JsonField<Double> = odds

    /** Returns the raw JSON value of [alternateOdds]. */
    @JsonProperty("alternateOdds")
    @ExcludeMissing
    fun _alternateOdds(): JsonField<Double> = alternateOdds

    /** Returns the raw JSON value of [openForBetting]. */
    @JsonProperty("openForBetting")
    @ExcludeMissing
    fun _openForBetting(): JsonField<Boolean> = openForBetting

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

        /** Returns a mutable builder for constructing an instance of [FootballPlayerProp]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballPlayerProp]. */
    class Builder internal constructor() {

        private var playerId: JsonField<String>? = null
        private var rank: JsonField<Double>? = null
        private var line: JsonField<Double>? = null
        private var odds: JsonField<Double>? = null
        private var alternateOdds: JsonField<Double>? = null
        private var openForBetting: JsonField<Boolean>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(footballPlayerProp: FootballPlayerProp) = apply {
            playerId = footballPlayerProp.playerId
            rank = footballPlayerProp.rank
            line = footballPlayerProp.line
            odds = footballPlayerProp.odds
            alternateOdds = footballPlayerProp.alternateOdds
            openForBetting = footballPlayerProp.openForBetting
            additionalProperties = footballPlayerProp.additionalProperties.toMutableMap()
        }

        /** The player the line is for, a key of players. */
        fun playerId(playerId: String?) = playerId(JsonField.ofNullable(playerId))

        /** Alias for calling [Builder.playerId] with `playerId.orElse(null)`. */
        fun playerId(playerId: Optional<String>) = playerId(playerId.getOrNull())

        /** Sets [Builder.playerId] to an arbitrary JSON value. */
        fun playerId(playerId: JsonField<String>) = apply { this.playerId = playerId }

        /** The line's place in its category, from 1. */
        fun rank(rank: Double?) = rank(JsonField.ofNullable(rank))

        /**
         * Alias for [Builder.rank].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun rank(rank: Double) = rank(rank as Double?)

        /** Alias for calling [Builder.rank] with `rank.orElse(null)`. */
        fun rank(rank: Optional<Double>) = rank(rank.getOrNull())

        /** Sets [Builder.rank] to an arbitrary JSON value. */
        fun rank(rank: JsonField<Double>) = apply { this.rank = rank }

        /**
         * The line the odds price, such as 248.5 yards. Null when the prop has no line, such as the
         * first touchdown scorer.
         */
        fun line(line: Double?) = line(JsonField.ofNullable(line))

        /**
         * Alias for [Builder.line].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun line(line: Double) = line(line as Double?)

        /** Alias for calling [Builder.line] with `line.orElse(null)`. */
        fun line(line: Optional<Double>) = line(line.getOrNull())

        /** Sets [Builder.line] to an arbitrary JSON value. */
        fun line(line: JsonField<Double>) = apply { this.line = line }

        /** The American odds X shows first, such as -115 or 240. */
        fun odds(odds: Double?) = odds(JsonField.ofNullable(odds))

        /**
         * Alias for [Builder.odds].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun odds(odds: Double) = odds(odds as Double?)

        /** Alias for calling [Builder.odds] with `odds.orElse(null)`. */
        fun odds(odds: Optional<Double>) = odds(odds.getOrNull())

        /** Sets [Builder.odds] to an arbitrary JSON value. */
        fun odds(odds: JsonField<Double>) = apply { this.odds = odds }

        /** The American odds X shows second. Null for a prop with 1 price. */
        fun alternateOdds(alternateOdds: Double?) =
            alternateOdds(JsonField.ofNullable(alternateOdds))

        /**
         * Alias for [Builder.alternateOdds].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun alternateOdds(alternateOdds: Double) = alternateOdds(alternateOdds as Double?)

        /** Alias for calling [Builder.alternateOdds] with `alternateOdds.orElse(null)`. */
        fun alternateOdds(alternateOdds: Optional<Double>) =
            alternateOdds(alternateOdds.getOrNull())

        /** Sets [Builder.alternateOdds] to an arbitrary JSON value. */
        fun alternateOdds(alternateOdds: JsonField<Double>) = apply {
            this.alternateOdds = alternateOdds
        }

        /** Whether the sportsbook takes bets on the line. */
        fun openForBetting(openForBetting: Boolean?) =
            openForBetting(JsonField.ofNullable(openForBetting))

        /**
         * Alias for [Builder.openForBetting].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun openForBetting(openForBetting: Boolean) = openForBetting(openForBetting as Boolean?)

        /** Alias for calling [Builder.openForBetting] with `openForBetting.orElse(null)`. */
        fun openForBetting(openForBetting: Optional<Boolean>) =
            openForBetting(openForBetting.getOrNull())

        /** Sets [Builder.openForBetting] to an arbitrary JSON value. */
        fun openForBetting(openForBetting: JsonField<Boolean>) = apply {
            this.openForBetting = openForBetting
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
         * Returns an immutable instance of [FootballPlayerProp].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballPlayerProp =
            FootballPlayerProp(
                checkRequired("playerId", playerId),
                checkRequired("rank", rank),
                checkRequired("line", line),
                checkRequired("odds", odds),
                checkRequired("alternateOdds", alternateOdds),
                checkRequired("openForBetting", openForBetting),
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
    fun validate(): FootballPlayerProp = apply {
        if (validated) {
            return@apply
        }

        playerId()
        rank()
        line()
        odds()
        alternateOdds()
        openForBetting()
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
        (if (playerId.asKnown().isPresent) 1 else 0) +
            (if (rank.asKnown().isPresent) 1 else 0) +
            (if (line.asKnown().isPresent) 1 else 0) +
            (if (odds.asKnown().isPresent) 1 else 0) +
            (if (alternateOdds.asKnown().isPresent) 1 else 0) +
            (if (openForBetting.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballPlayerProp &&
            playerId == other.playerId &&
            rank == other.rank &&
            line == other.line &&
            odds == other.odds &&
            alternateOdds == other.alternateOdds &&
            openForBetting == other.openForBetting &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            playerId,
            rank,
            line,
            odds,
            alternateOdds,
            openForBetting,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballPlayerProp{playerId=$playerId, rank=$rank, line=$line, odds=$odds, alternateOdds=$alternateOdds, openForBetting=$openForBetting, additionalProperties=$additionalProperties}"
}
