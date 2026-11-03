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

/** Defensive stats. */
class FootballPlayerStatsDefense
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val combined: JsonField<Double>,
    private val forcedFumbles: JsonField<Long>,
    private val interceptions: JsonField<Long>,
    private val passesDefended: JsonField<Long>,
    private val sacks: JsonField<Double>,
    private val tackles: JsonField<Double>,
    private val tacklesForLoss: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("combined") @ExcludeMissing combined: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("forcedFumbles") @ExcludeMissing forcedFumbles: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("interceptions") @ExcludeMissing interceptions: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("passesDefended") @ExcludeMissing passesDefended: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("sacks") @ExcludeMissing sacks: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("tackles") @ExcludeMissing tackles: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("tacklesForLoss") @ExcludeMissing tacklesForLoss: JsonField<Double> = JsonMissing.of(),
    ) : this(combined, forcedFumbles, interceptions, passesDefended, sacks, tackles, tacklesForLoss, mutableMapOf())

    /** Solo & assisted tackles together. */
    fun combined(): Optional<Double> = combined.getOptional("combined")

    /** Fumbles forced. */
    fun forcedFumbles(): Optional<Long> = forcedFumbles.getOptional("forcedFumbles")

    /** Interceptions. */
    fun interceptions(): Optional<Long> = interceptions.getOptional("interceptions")

    /** Passes defended. */
    fun passesDefended(): Optional<Long> = passesDefended.getOptional("passesDefended")

    /** Sacks, with a shared sack as 0.5. */
    fun sacks(): Optional<Double> = sacks.getOptional("sacks")

    /** Solo tackles. */
    fun tackles(): Optional<Double> = tackles.getOptional("tackles")

    /** Tackles for a loss. */
    fun tacklesForLoss(): Optional<Double> = tacklesForLoss.getOptional("tacklesForLoss")

    /** Returns the raw JSON value of [combined]. */
    @JsonProperty("combined") @ExcludeMissing fun _combined(): JsonField<Double> = combined

    /** Returns the raw JSON value of [forcedFumbles]. */
    @JsonProperty("forcedFumbles") @ExcludeMissing fun _forcedFumbles(): JsonField<Long> = forcedFumbles

    /** Returns the raw JSON value of [interceptions]. */
    @JsonProperty("interceptions") @ExcludeMissing fun _interceptions(): JsonField<Long> = interceptions

    /** Returns the raw JSON value of [passesDefended]. */
    @JsonProperty("passesDefended") @ExcludeMissing fun _passesDefended(): JsonField<Long> = passesDefended

    /** Returns the raw JSON value of [sacks]. */
    @JsonProperty("sacks") @ExcludeMissing fun _sacks(): JsonField<Double> = sacks

    /** Returns the raw JSON value of [tackles]. */
    @JsonProperty("tackles") @ExcludeMissing fun _tackles(): JsonField<Double> = tackles

    /** Returns the raw JSON value of [tacklesForLoss]. */
    @JsonProperty("tacklesForLoss") @ExcludeMissing fun _tacklesForLoss(): JsonField<Double> = tacklesForLoss

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

        /** Returns a mutable builder for constructing an instance of [FootballPlayerStatsDefense]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballPlayerStatsDefense]. */
    class Builder internal constructor() {

        private var combined: JsonField<Double>? = null
        private var forcedFumbles: JsonField<Long>? = null
        private var interceptions: JsonField<Long>? = null
        private var passesDefended: JsonField<Long>? = null
        private var sacks: JsonField<Double>? = null
        private var tackles: JsonField<Double>? = null
        private var tacklesForLoss: JsonField<Double>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballPlayerStatsDefense: FootballPlayerStatsDefense) = apply {
            combined = footballPlayerStatsDefense.combined
            forcedFumbles = footballPlayerStatsDefense.forcedFumbles
            interceptions = footballPlayerStatsDefense.interceptions
            passesDefended = footballPlayerStatsDefense.passesDefended
            sacks = footballPlayerStatsDefense.sacks
            tackles = footballPlayerStatsDefense.tackles
            tacklesForLoss = footballPlayerStatsDefense.tacklesForLoss
            additionalProperties = footballPlayerStatsDefense.additionalProperties.toMutableMap()
        }

        /** Solo & assisted tackles together. */
        fun combined(combined: Double?) = combined(JsonField.ofNullable(combined))

        fun combined(combined: Double) = combined(combined as Double?)

        fun combined(combined: Optional<Double>) = combined(combined.getOrNull())

        /** Sets [Builder.combined] to an arbitrary JSON value. */
        fun combined(combined: JsonField<Double>) = apply { this.combined = combined }

        /** Fumbles forced. */
        fun forcedFumbles(forcedFumbles: Long?) = forcedFumbles(JsonField.ofNullable(forcedFumbles))

        fun forcedFumbles(forcedFumbles: Long) = forcedFumbles(forcedFumbles as Long?)

        fun forcedFumbles(forcedFumbles: Optional<Long>) = forcedFumbles(forcedFumbles.getOrNull())

        /** Sets [Builder.forcedFumbles] to an arbitrary JSON value. */
        fun forcedFumbles(forcedFumbles: JsonField<Long>) = apply { this.forcedFumbles = forcedFumbles }

        /** Interceptions. */
        fun interceptions(interceptions: Long?) = interceptions(JsonField.ofNullable(interceptions))

        fun interceptions(interceptions: Long) = interceptions(interceptions as Long?)

        fun interceptions(interceptions: Optional<Long>) = interceptions(interceptions.getOrNull())

        /** Sets [Builder.interceptions] to an arbitrary JSON value. */
        fun interceptions(interceptions: JsonField<Long>) = apply { this.interceptions = interceptions }

        /** Passes defended. */
        fun passesDefended(passesDefended: Long?) = passesDefended(JsonField.ofNullable(passesDefended))

        fun passesDefended(passesDefended: Long) = passesDefended(passesDefended as Long?)

        fun passesDefended(passesDefended: Optional<Long>) = passesDefended(passesDefended.getOrNull())

        /** Sets [Builder.passesDefended] to an arbitrary JSON value. */
        fun passesDefended(passesDefended: JsonField<Long>) = apply { this.passesDefended = passesDefended }

        /** Sacks, with a shared sack as 0.5. */
        fun sacks(sacks: Double?) = sacks(JsonField.ofNullable(sacks))

        fun sacks(sacks: Double) = sacks(sacks as Double?)

        fun sacks(sacks: Optional<Double>) = sacks(sacks.getOrNull())

        /** Sets [Builder.sacks] to an arbitrary JSON value. */
        fun sacks(sacks: JsonField<Double>) = apply { this.sacks = sacks }

        /** Solo tackles. */
        fun tackles(tackles: Double?) = tackles(JsonField.ofNullable(tackles))

        fun tackles(tackles: Double) = tackles(tackles as Double?)

        fun tackles(tackles: Optional<Double>) = tackles(tackles.getOrNull())

        /** Sets [Builder.tackles] to an arbitrary JSON value. */
        fun tackles(tackles: JsonField<Double>) = apply { this.tackles = tackles }

        /** Tackles for a loss. */
        fun tacklesForLoss(tacklesForLoss: Double?) = tacklesForLoss(JsonField.ofNullable(tacklesForLoss))

        fun tacklesForLoss(tacklesForLoss: Double) = tacklesForLoss(tacklesForLoss as Double?)

        fun tacklesForLoss(tacklesForLoss: Optional<Double>) = tacklesForLoss(tacklesForLoss.getOrNull())

        /** Sets [Builder.tacklesForLoss] to an arbitrary JSON value. */
        fun tacklesForLoss(tacklesForLoss: JsonField<Double>) = apply { this.tacklesForLoss = tacklesForLoss }

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
         * Returns an immutable instance of [FootballPlayerStatsDefense].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballPlayerStatsDefense =
            FootballPlayerStatsDefense(
                checkRequired("combined", combined),
                checkRequired("forcedFumbles", forcedFumbles),
                checkRequired("interceptions", interceptions),
                checkRequired("passesDefended", passesDefended),
                checkRequired("sacks", sacks),
                checkRequired("tackles", tackles),
                checkRequired("tacklesForLoss", tacklesForLoss),
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
    fun validate(): FootballPlayerStatsDefense = apply {
        if (validated) {
            return@apply
        }

        combined()
        forcedFumbles()
        interceptions()
        passesDefended()
        sacks()
        tackles()
        tacklesForLoss()
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
        (if (combined.asKnown().isPresent) 1 else 0) +
            (if (forcedFumbles.asKnown().isPresent) 1 else 0) +
            (if (interceptions.asKnown().isPresent) 1 else 0) +
            (if (passesDefended.asKnown().isPresent) 1 else 0) +
            (if (sacks.asKnown().isPresent) 1 else 0) +
            (if (tackles.asKnown().isPresent) 1 else 0) +
            (if (tacklesForLoss.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballPlayerStatsDefense &&
            combined == other.combined &&
            forcedFumbles == other.forcedFumbles &&
            interceptions == other.interceptions &&
            passesDefended == other.passesDefended &&
            sacks == other.sacks &&
            tackles == other.tackles &&
            tacklesForLoss == other.tacklesForLoss &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(combined, forcedFumbles, interceptions, passesDefended, sacks, tackles, tacklesForLoss, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballPlayerStatsDefense{combined=$combined, forcedFumbles=$forcedFumbles, interceptions=$interceptions, passesDefended=$passesDefended, sacks=$sacks, tackles=$tackles, tacklesForLoss=$tacklesForLoss, additionalProperties=$additionalProperties}"
}
