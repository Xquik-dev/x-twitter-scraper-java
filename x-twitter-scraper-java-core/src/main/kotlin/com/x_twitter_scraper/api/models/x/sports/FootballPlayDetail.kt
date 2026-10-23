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

/** 1 step of a play, such as a pass, a tackle or a penalty. */
class FootballPlayDetail
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val sequence: JsonField<Long>,
    private val category: JsonField<String>,
    private val description: JsonField<String>,
    private val direction: JsonField<String>,
    private val yards: JsonField<Long>,
    private val players: JsonField<List<FootballPlayDetailPlayer>>,
    private val penalty: JsonField<FootballPlayDetailPenalty>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("sequence") @ExcludeMissing sequence: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("category") @ExcludeMissing category: JsonField<String> = JsonMissing.of(),
        @JsonProperty("description") @ExcludeMissing description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("direction") @ExcludeMissing direction: JsonField<String> = JsonMissing.of(),
        @JsonProperty("yards") @ExcludeMissing yards: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("players") @ExcludeMissing players: JsonField<List<FootballPlayDetailPlayer>> = JsonMissing.of(),
        @JsonProperty("penalty") @ExcludeMissing penalty: JsonField<FootballPlayDetailPenalty> = JsonMissing.of(),
    ) : this(sequence, category, description, direction, yards, players, penalty, mutableMapOf())

    /** The step's place in the play, from 1. */
    fun sequence(): Optional<Long> = sequence.getOptional("sequence")

    /** X's kind of step, such as Pass, Tackle or Penalty. */
    fun category(): Optional<String> = category.getOptional("category")

    /** What happened in the step. */
    fun description(): Optional<String> = description.getOptional("description")

    /** The direction X gives for the step. */
    fun direction(): Optional<String> = direction.getOptional("direction")

    /** The yards the step gained or lost. */
    fun yards(): Optional<Long> = yards.getOptional("yards")

    /** The players in the step & their roles. */
    fun players(): List<FootballPlayDetailPlayer> = players.getRequired("players")

    /** The penalty this step called, or null. */
    fun penalty(): Optional<FootballPlayDetailPenalty> = penalty.getOptional("penalty")

    /** Returns the raw JSON value of [sequence]. */
    @JsonProperty("sequence") @ExcludeMissing fun _sequence(): JsonField<Long> = sequence

    /** Returns the raw JSON value of [category]. */
    @JsonProperty("category") @ExcludeMissing fun _category(): JsonField<String> = category

    /** Returns the raw JSON value of [description]. */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

    /** Returns the raw JSON value of [direction]. */
    @JsonProperty("direction") @ExcludeMissing fun _direction(): JsonField<String> = direction

    /** Returns the raw JSON value of [yards]. */
    @JsonProperty("yards") @ExcludeMissing fun _yards(): JsonField<Long> = yards

    /** Returns the raw JSON value of [players]. */
    @JsonProperty("players") @ExcludeMissing fun _players(): JsonField<List<FootballPlayDetailPlayer>> = players

    /** Returns the raw JSON value of [penalty]. */
    @JsonProperty("penalty") @ExcludeMissing fun _penalty(): JsonField<FootballPlayDetailPenalty> = penalty

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

        /** Returns a mutable builder for constructing an instance of [FootballPlayDetail]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballPlayDetail]. */
    class Builder internal constructor() {

        private var sequence: JsonField<Long>? = null
        private var category: JsonField<String>? = null
        private var description: JsonField<String>? = null
        private var direction: JsonField<String>? = null
        private var yards: JsonField<Long>? = null
        private var players: JsonField<MutableList<FootballPlayDetailPlayer>>? = null
        private var penalty: JsonField<FootballPlayDetailPenalty>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballPlayDetail: FootballPlayDetail) = apply {
            sequence = footballPlayDetail.sequence
            category = footballPlayDetail.category
            description = footballPlayDetail.description
            direction = footballPlayDetail.direction
            yards = footballPlayDetail.yards
            players = footballPlayDetail.players.map { it.toMutableList() }
            penalty = footballPlayDetail.penalty
            additionalProperties = footballPlayDetail.additionalProperties.toMutableMap()
        }

        /** The step's place in the play, from 1. */
        fun sequence(sequence: Long?) = sequence(JsonField.ofNullable(sequence))

        fun sequence(sequence: Long) = sequence(sequence as Long?)

        fun sequence(sequence: Optional<Long>) = sequence(sequence.getOrNull())

        /** Sets [Builder.sequence] to an arbitrary JSON value. */
        fun sequence(sequence: JsonField<Long>) = apply { this.sequence = sequence }

        /** X's kind of step, such as Pass, Tackle or Penalty. */
        fun category(category: String?) = category(JsonField.ofNullable(category))

        fun category(category: Optional<String>) = category(category.getOrNull())

        /** Sets [Builder.category] to an arbitrary JSON value. */
        fun category(category: JsonField<String>) = apply { this.category = category }

        /** What happened in the step. */
        fun description(description: String?) = description(JsonField.ofNullable(description))

        fun description(description: Optional<String>) = description(description.getOrNull())

        /** Sets [Builder.description] to an arbitrary JSON value. */
        fun description(description: JsonField<String>) = apply { this.description = description }

        /** The direction X gives for the step. */
        fun direction(direction: String?) = direction(JsonField.ofNullable(direction))

        fun direction(direction: Optional<String>) = direction(direction.getOrNull())

        /** Sets [Builder.direction] to an arbitrary JSON value. */
        fun direction(direction: JsonField<String>) = apply { this.direction = direction }

        /** The yards the step gained or lost. */
        fun yards(yards: Long?) = yards(JsonField.ofNullable(yards))

        fun yards(yards: Long) = yards(yards as Long?)

        fun yards(yards: Optional<Long>) = yards(yards.getOrNull())

        /** Sets [Builder.yards] to an arbitrary JSON value. */
        fun yards(yards: JsonField<Long>) = apply { this.yards = yards }

        /** The players in the step & their roles. */
        fun players(players: List<FootballPlayDetailPlayer>) = players(JsonField.of(players))

        /** Sets [Builder.players] to an arbitrary JSON value. */
        fun players(players: JsonField<List<FootballPlayDetailPlayer>>) = apply { this.players = players.map { it.toMutableList() } }

        /** Adds a single [FootballPlayDetailPlayer] to [players]. */
        fun addPlayer(player: FootballPlayDetailPlayer) = apply {
            players =
                (players ?: JsonField.of(mutableListOf())).also {
                    checkKnown("players", it).add(player)
                }
        }

        /** The penalty this step called, or null. */
        fun penalty(penalty: FootballPlayDetailPenalty?) = penalty(JsonField.ofNullable(penalty))

        fun penalty(penalty: Optional<FootballPlayDetailPenalty>) = penalty(penalty.getOrNull())

        /** Sets [Builder.penalty] to an arbitrary JSON value. */
        fun penalty(penalty: JsonField<FootballPlayDetailPenalty>) = apply { this.penalty = penalty }

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
         * Returns an immutable instance of [FootballPlayDetail].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballPlayDetail =
            FootballPlayDetail(
                checkRequired("sequence", sequence),
                checkRequired("category", category),
                checkRequired("description", description),
                checkRequired("direction", direction),
                checkRequired("yards", yards),
                checkRequired("players", players).map { it.toImmutable() },
                checkRequired("penalty", penalty),
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
    fun validate(): FootballPlayDetail = apply {
        if (validated) {
            return@apply
        }

        sequence()
        category()
        description()
        direction()
        yards()
        players().forEach { it.validate() }
        penalty().ifPresent { it.validate() }
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
        (if (sequence.asKnown().isPresent) 1 else 0) +
            (if (category.asKnown().isPresent) 1 else 0) +
            (if (description.asKnown().isPresent) 1 else 0) +
            (if (direction.asKnown().isPresent) 1 else 0) +
            (if (yards.asKnown().isPresent) 1 else 0) +
            (players.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (penalty.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballPlayDetail &&
            sequence == other.sequence &&
            category == other.category &&
            description == other.description &&
            direction == other.direction &&
            yards == other.yards &&
            players == other.players &&
            penalty == other.penalty &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(sequence, category, description, direction, yards, players, penalty, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballPlayDetail{sequence=$sequence, category=$category, description=$description, direction=$direction, yards=$yards, players=$players, penalty=$penalty, additionalProperties=$additionalProperties}"
}
