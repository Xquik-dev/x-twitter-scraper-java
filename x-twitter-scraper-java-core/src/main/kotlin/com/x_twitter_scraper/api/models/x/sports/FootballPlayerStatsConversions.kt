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

/** 2-point conversions. */
class FootballPlayerStatsConversions
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val defenseSuccesses: JsonField<Long>,
    private val passSuccesses: JsonField<Long>,
    private val rushSuccesses: JsonField<Long>,
    private val turnoverSuccesses: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("defenseSuccesses") @ExcludeMissing defenseSuccesses: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("passSuccesses") @ExcludeMissing passSuccesses: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("rushSuccesses") @ExcludeMissing rushSuccesses: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("turnoverSuccesses") @ExcludeMissing turnoverSuccesses: JsonField<Long> = JsonMissing.of(),
    ) : this(defenseSuccesses, passSuccesses, rushSuccesses, turnoverSuccesses, mutableMapOf())

    /** Defensive 2-point returns. */
    fun defenseSuccesses(): Optional<Long> = defenseSuccesses.getOptional("defenseSuccesses")

    /** 2-point conversions by pass. */
    fun passSuccesses(): Optional<Long> = passSuccesses.getOptional("passSuccesses")

    /** 2-point conversions by rush. */
    fun rushSuccesses(): Optional<Long> = rushSuccesses.getOptional("rushSuccesses")

    /** 2-point conversions after a turnover. */
    fun turnoverSuccesses(): Optional<Long> = turnoverSuccesses.getOptional("turnoverSuccesses")

    /** Returns the raw JSON value of [defenseSuccesses]. */
    @JsonProperty("defenseSuccesses") @ExcludeMissing fun _defenseSuccesses(): JsonField<Long> = defenseSuccesses

    /** Returns the raw JSON value of [passSuccesses]. */
    @JsonProperty("passSuccesses") @ExcludeMissing fun _passSuccesses(): JsonField<Long> = passSuccesses

    /** Returns the raw JSON value of [rushSuccesses]. */
    @JsonProperty("rushSuccesses") @ExcludeMissing fun _rushSuccesses(): JsonField<Long> = rushSuccesses

    /** Returns the raw JSON value of [turnoverSuccesses]. */
    @JsonProperty("turnoverSuccesses") @ExcludeMissing fun _turnoverSuccesses(): JsonField<Long> = turnoverSuccesses

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

        /** Returns a mutable builder for constructing an instance of [FootballPlayerStatsConversions]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballPlayerStatsConversions]. */
    class Builder internal constructor() {

        private var defenseSuccesses: JsonField<Long>? = null
        private var passSuccesses: JsonField<Long>? = null
        private var rushSuccesses: JsonField<Long>? = null
        private var turnoverSuccesses: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballPlayerStatsConversions: FootballPlayerStatsConversions) = apply {
            defenseSuccesses = footballPlayerStatsConversions.defenseSuccesses
            passSuccesses = footballPlayerStatsConversions.passSuccesses
            rushSuccesses = footballPlayerStatsConversions.rushSuccesses
            turnoverSuccesses = footballPlayerStatsConversions.turnoverSuccesses
            additionalProperties = footballPlayerStatsConversions.additionalProperties.toMutableMap()
        }

        /** Defensive 2-point returns. */
        fun defenseSuccesses(defenseSuccesses: Long?) = defenseSuccesses(JsonField.ofNullable(defenseSuccesses))

        fun defenseSuccesses(defenseSuccesses: Long) = defenseSuccesses(defenseSuccesses as Long?)

        fun defenseSuccesses(defenseSuccesses: Optional<Long>) = defenseSuccesses(defenseSuccesses.getOrNull())

        /** Sets [Builder.defenseSuccesses] to an arbitrary JSON value. */
        fun defenseSuccesses(defenseSuccesses: JsonField<Long>) = apply { this.defenseSuccesses = defenseSuccesses }

        /** 2-point conversions by pass. */
        fun passSuccesses(passSuccesses: Long?) = passSuccesses(JsonField.ofNullable(passSuccesses))

        fun passSuccesses(passSuccesses: Long) = passSuccesses(passSuccesses as Long?)

        fun passSuccesses(passSuccesses: Optional<Long>) = passSuccesses(passSuccesses.getOrNull())

        /** Sets [Builder.passSuccesses] to an arbitrary JSON value. */
        fun passSuccesses(passSuccesses: JsonField<Long>) = apply { this.passSuccesses = passSuccesses }

        /** 2-point conversions by rush. */
        fun rushSuccesses(rushSuccesses: Long?) = rushSuccesses(JsonField.ofNullable(rushSuccesses))

        fun rushSuccesses(rushSuccesses: Long) = rushSuccesses(rushSuccesses as Long?)

        fun rushSuccesses(rushSuccesses: Optional<Long>) = rushSuccesses(rushSuccesses.getOrNull())

        /** Sets [Builder.rushSuccesses] to an arbitrary JSON value. */
        fun rushSuccesses(rushSuccesses: JsonField<Long>) = apply { this.rushSuccesses = rushSuccesses }

        /** 2-point conversions after a turnover. */
        fun turnoverSuccesses(turnoverSuccesses: Long?) = turnoverSuccesses(JsonField.ofNullable(turnoverSuccesses))

        fun turnoverSuccesses(turnoverSuccesses: Long) = turnoverSuccesses(turnoverSuccesses as Long?)

        fun turnoverSuccesses(turnoverSuccesses: Optional<Long>) = turnoverSuccesses(turnoverSuccesses.getOrNull())

        /** Sets [Builder.turnoverSuccesses] to an arbitrary JSON value. */
        fun turnoverSuccesses(turnoverSuccesses: JsonField<Long>) = apply { this.turnoverSuccesses = turnoverSuccesses }

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
         * Returns an immutable instance of [FootballPlayerStatsConversions].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballPlayerStatsConversions =
            FootballPlayerStatsConversions(
                checkRequired("defenseSuccesses", defenseSuccesses),
                checkRequired("passSuccesses", passSuccesses),
                checkRequired("rushSuccesses", rushSuccesses),
                checkRequired("turnoverSuccesses", turnoverSuccesses),
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
    fun validate(): FootballPlayerStatsConversions = apply {
        if (validated) {
            return@apply
        }

        defenseSuccesses()
        passSuccesses()
        rushSuccesses()
        turnoverSuccesses()
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
        (if (defenseSuccesses.asKnown().isPresent) 1 else 0) +
            (if (passSuccesses.asKnown().isPresent) 1 else 0) +
            (if (rushSuccesses.asKnown().isPresent) 1 else 0) +
            (if (turnoverSuccesses.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballPlayerStatsConversions &&
            defenseSuccesses == other.defenseSuccesses &&
            passSuccesses == other.passSuccesses &&
            rushSuccesses == other.rushSuccesses &&
            turnoverSuccesses == other.turnoverSuccesses &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(defenseSuccesses, passSuccesses, rushSuccesses, turnoverSuccesses, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballPlayerStatsConversions{defenseSuccesses=$defenseSuccesses, passSuccesses=$passSuccesses, rushSuccesses=$rushSuccesses, turnoverSuccesses=$turnoverSuccesses, additionalProperties=$additionalProperties}"
}
