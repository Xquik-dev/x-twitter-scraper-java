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

/** Kick, punt or interception return stats. */
class FootballReturnStats
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val avgYards: JsonField<Double>,
    private val longest: JsonField<Long>,
    private val returns: JsonField<Long>,
    private val touchdowns: JsonField<Long>,
    private val yards: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("avgYards") @ExcludeMissing avgYards: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("longest") @ExcludeMissing longest: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("returns") @ExcludeMissing returns: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("touchdowns") @ExcludeMissing touchdowns: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("yards") @ExcludeMissing yards: JsonField<Long> = JsonMissing.of(),
    ) : this(avgYards, longest, returns, touchdowns, yards, mutableMapOf())

    /** Yards per return. */
    fun avgYards(): Optional<Double> = avgYards.getOptional("avgYards")

    /** The longest return, in yards. */
    fun longest(): Optional<Long> = longest.getOptional("longest")

    /** Returns. */
    fun returns(): Optional<Long> = returns.getOptional("returns")

    /** Return touchdowns. */
    fun touchdowns(): Optional<Long> = touchdowns.getOptional("touchdowns")

    /** Return yards. */
    fun yards(): Optional<Long> = yards.getOptional("yards")

    /** Returns the raw JSON value of [avgYards]. */
    @JsonProperty("avgYards") @ExcludeMissing fun _avgYards(): JsonField<Double> = avgYards

    /** Returns the raw JSON value of [longest]. */
    @JsonProperty("longest") @ExcludeMissing fun _longest(): JsonField<Long> = longest

    /** Returns the raw JSON value of [returns]. */
    @JsonProperty("returns") @ExcludeMissing fun _returns(): JsonField<Long> = returns

    /** Returns the raw JSON value of [touchdowns]. */
    @JsonProperty("touchdowns") @ExcludeMissing fun _touchdowns(): JsonField<Long> = touchdowns

    /** Returns the raw JSON value of [yards]. */
    @JsonProperty("yards") @ExcludeMissing fun _yards(): JsonField<Long> = yards

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

        /** Returns a mutable builder for constructing an instance of [FootballReturnStats]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballReturnStats]. */
    class Builder internal constructor() {

        private var avgYards: JsonField<Double>? = null
        private var longest: JsonField<Long>? = null
        private var returns: JsonField<Long>? = null
        private var touchdowns: JsonField<Long>? = null
        private var yards: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballReturnStats: FootballReturnStats) = apply {
            avgYards = footballReturnStats.avgYards
            longest = footballReturnStats.longest
            returns = footballReturnStats.returns
            touchdowns = footballReturnStats.touchdowns
            yards = footballReturnStats.yards
            additionalProperties = footballReturnStats.additionalProperties.toMutableMap()
        }

        /** Yards per return. */
        fun avgYards(avgYards: Double?) = avgYards(JsonField.ofNullable(avgYards))

        fun avgYards(avgYards: Double) = avgYards(avgYards as Double?)

        fun avgYards(avgYards: Optional<Double>) = avgYards(avgYards.getOrNull())

        /** Sets [Builder.avgYards] to an arbitrary JSON value. */
        fun avgYards(avgYards: JsonField<Double>) = apply { this.avgYards = avgYards }

        /** The longest return, in yards. */
        fun longest(longest: Long?) = longest(JsonField.ofNullable(longest))

        fun longest(longest: Long) = longest(longest as Long?)

        fun longest(longest: Optional<Long>) = longest(longest.getOrNull())

        /** Sets [Builder.longest] to an arbitrary JSON value. */
        fun longest(longest: JsonField<Long>) = apply { this.longest = longest }

        /** Returns. */
        fun returns(returns: Long?) = returns(JsonField.ofNullable(returns))

        fun returns(returns: Long) = returns(returns as Long?)

        fun returns(returns: Optional<Long>) = returns(returns.getOrNull())

        /** Sets [Builder.returns] to an arbitrary JSON value. */
        fun returns(returns: JsonField<Long>) = apply { this.returns = returns }

        /** Return touchdowns. */
        fun touchdowns(touchdowns: Long?) = touchdowns(JsonField.ofNullable(touchdowns))

        fun touchdowns(touchdowns: Long) = touchdowns(touchdowns as Long?)

        fun touchdowns(touchdowns: Optional<Long>) = touchdowns(touchdowns.getOrNull())

        /** Sets [Builder.touchdowns] to an arbitrary JSON value. */
        fun touchdowns(touchdowns: JsonField<Long>) = apply { this.touchdowns = touchdowns }

        /** Return yards. */
        fun yards(yards: Long?) = yards(JsonField.ofNullable(yards))

        fun yards(yards: Long) = yards(yards as Long?)

        fun yards(yards: Optional<Long>) = yards(yards.getOrNull())

        /** Sets [Builder.yards] to an arbitrary JSON value. */
        fun yards(yards: JsonField<Long>) = apply { this.yards = yards }

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
         * Returns an immutable instance of [FootballReturnStats].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballReturnStats =
            FootballReturnStats(
                checkRequired("avgYards", avgYards),
                checkRequired("longest", longest),
                checkRequired("returns", returns),
                checkRequired("touchdowns", touchdowns),
                checkRequired("yards", yards),
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
    fun validate(): FootballReturnStats = apply {
        if (validated) {
            return@apply
        }

        avgYards()
        longest()
        returns()
        touchdowns()
        yards()
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
        (if (avgYards.asKnown().isPresent) 1 else 0) +
            (if (longest.asKnown().isPresent) 1 else 0) +
            (if (returns.asKnown().isPresent) 1 else 0) +
            (if (touchdowns.asKnown().isPresent) 1 else 0) +
            (if (yards.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballReturnStats &&
            avgYards == other.avgYards &&
            longest == other.longest &&
            returns == other.returns &&
            touchdowns == other.touchdowns &&
            yards == other.yards &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(avgYards, longest, returns, touchdowns, yards, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballReturnStats{avgYards=$avgYards, longest=$longest, returns=$returns, touchdowns=$touchdowns, yards=$yards, additionalProperties=$additionalProperties}"
}
