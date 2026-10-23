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

/** The team's wins, losses & ties this season. X sends it only in college football games. */
class SportsTeamRecord
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val wins: JsonField<Long>,
    private val losses: JsonField<Long>,
    private val ties: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("wins") @ExcludeMissing wins: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("losses") @ExcludeMissing losses: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("ties") @ExcludeMissing ties: JsonField<Long> = JsonMissing.of(),
    ) : this(wins, losses, ties, mutableMapOf())

    /** Games the team won this season. */
    fun wins(): Optional<Long> = wins.getOptional("wins")

    /** Games the team lost this season. */
    fun losses(): Optional<Long> = losses.getOptional("losses")

    /** Games the team tied this season. */
    fun ties(): Optional<Long> = ties.getOptional("ties")

    /** Returns the raw JSON value of [wins]. */
    @JsonProperty("wins") @ExcludeMissing fun _wins(): JsonField<Long> = wins

    /** Returns the raw JSON value of [losses]. */
    @JsonProperty("losses") @ExcludeMissing fun _losses(): JsonField<Long> = losses

    /** Returns the raw JSON value of [ties]. */
    @JsonProperty("ties") @ExcludeMissing fun _ties(): JsonField<Long> = ties

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

        /** Returns a mutable builder for constructing an instance of [SportsTeamRecord]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SportsTeamRecord]. */
    class Builder internal constructor() {

        private var wins: JsonField<Long>? = null
        private var losses: JsonField<Long>? = null
        private var ties: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(sportsTeamRecord: SportsTeamRecord) = apply {
            wins = sportsTeamRecord.wins
            losses = sportsTeamRecord.losses
            ties = sportsTeamRecord.ties
            additionalProperties = sportsTeamRecord.additionalProperties.toMutableMap()
        }

        /** Games the team won this season. */
        fun wins(wins: Long?) = wins(JsonField.ofNullable(wins))

        fun wins(wins: Long) = wins(wins as Long?)

        fun wins(wins: Optional<Long>) = wins(wins.getOrNull())

        /** Sets [Builder.wins] to an arbitrary JSON value. */
        fun wins(wins: JsonField<Long>) = apply { this.wins = wins }

        /** Games the team lost this season. */
        fun losses(losses: Long?) = losses(JsonField.ofNullable(losses))

        fun losses(losses: Long) = losses(losses as Long?)

        fun losses(losses: Optional<Long>) = losses(losses.getOrNull())

        /** Sets [Builder.losses] to an arbitrary JSON value. */
        fun losses(losses: JsonField<Long>) = apply { this.losses = losses }

        /** Games the team tied this season. */
        fun ties(ties: Long?) = ties(JsonField.ofNullable(ties))

        fun ties(ties: Long) = ties(ties as Long?)

        fun ties(ties: Optional<Long>) = ties(ties.getOrNull())

        /** Sets [Builder.ties] to an arbitrary JSON value. */
        fun ties(ties: JsonField<Long>) = apply { this.ties = ties }

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
         * Returns an immutable instance of [SportsTeamRecord].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SportsTeamRecord =
            SportsTeamRecord(
                checkRequired("wins", wins),
                checkRequired("losses", losses),
                checkRequired("ties", ties),
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
    fun validate(): SportsTeamRecord = apply {
        if (validated) {
            return@apply
        }

        wins()
        losses()
        ties()
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
        (if (wins.asKnown().isPresent) 1 else 0) +
            (if (losses.asKnown().isPresent) 1 else 0) +
            (if (ties.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SportsTeamRecord &&
            wins == other.wins &&
            losses == other.losses &&
            ties == other.ties &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(wins, losses, ties, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SportsTeamRecord{wins=$wins, losses=$losses, ties=$ties, additionalProperties=$additionalProperties}"
}
