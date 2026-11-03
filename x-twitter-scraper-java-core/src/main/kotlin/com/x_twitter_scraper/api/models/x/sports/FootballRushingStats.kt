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

/** Rushing stats. */
class FootballRushingStats
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val attempts: JsonField<Long>,
    private val avgYards: JsonField<Double>,
    private val longest: JsonField<Long>,
    private val touchdowns: JsonField<Long>,
    private val yards: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("attempts") @ExcludeMissing attempts: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("avgYards") @ExcludeMissing avgYards: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("longest") @ExcludeMissing longest: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("touchdowns") @ExcludeMissing touchdowns: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("yards") @ExcludeMissing yards: JsonField<Long> = JsonMissing.of(),
    ) : this(attempts, avgYards, longest, touchdowns, yards, mutableMapOf())

    /** Rushes. */
    fun attempts(): Optional<Long> = attempts.getOptional("attempts")

    /** Yards per rush. */
    fun avgYards(): Optional<Double> = avgYards.getOptional("avgYards")

    /** The longest rush, in yards. */
    fun longest(): Optional<Long> = longest.getOptional("longest")

    /** Rushing touchdowns. */
    fun touchdowns(): Optional<Long> = touchdowns.getOptional("touchdowns")

    /** Rushing yards. */
    fun yards(): Optional<Long> = yards.getOptional("yards")

    /** Returns the raw JSON value of [attempts]. */
    @JsonProperty("attempts") @ExcludeMissing fun _attempts(): JsonField<Long> = attempts

    /** Returns the raw JSON value of [avgYards]. */
    @JsonProperty("avgYards") @ExcludeMissing fun _avgYards(): JsonField<Double> = avgYards

    /** Returns the raw JSON value of [longest]. */
    @JsonProperty("longest") @ExcludeMissing fun _longest(): JsonField<Long> = longest

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

        /** Returns a mutable builder for constructing an instance of [FootballRushingStats]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballRushingStats]. */
    class Builder internal constructor() {

        private var attempts: JsonField<Long>? = null
        private var avgYards: JsonField<Double>? = null
        private var longest: JsonField<Long>? = null
        private var touchdowns: JsonField<Long>? = null
        private var yards: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballRushingStats: FootballRushingStats) = apply {
            attempts = footballRushingStats.attempts
            avgYards = footballRushingStats.avgYards
            longest = footballRushingStats.longest
            touchdowns = footballRushingStats.touchdowns
            yards = footballRushingStats.yards
            additionalProperties = footballRushingStats.additionalProperties.toMutableMap()
        }

        /** Rushes. */
        fun attempts(attempts: Long?) = attempts(JsonField.ofNullable(attempts))

        fun attempts(attempts: Long) = attempts(attempts as Long?)

        fun attempts(attempts: Optional<Long>) = attempts(attempts.getOrNull())

        /** Sets [Builder.attempts] to an arbitrary JSON value. */
        fun attempts(attempts: JsonField<Long>) = apply { this.attempts = attempts }

        /** Yards per rush. */
        fun avgYards(avgYards: Double?) = avgYards(JsonField.ofNullable(avgYards))

        fun avgYards(avgYards: Double) = avgYards(avgYards as Double?)

        fun avgYards(avgYards: Optional<Double>) = avgYards(avgYards.getOrNull())

        /** Sets [Builder.avgYards] to an arbitrary JSON value. */
        fun avgYards(avgYards: JsonField<Double>) = apply { this.avgYards = avgYards }

        /** The longest rush, in yards. */
        fun longest(longest: Long?) = longest(JsonField.ofNullable(longest))

        fun longest(longest: Long) = longest(longest as Long?)

        fun longest(longest: Optional<Long>) = longest(longest.getOrNull())

        /** Sets [Builder.longest] to an arbitrary JSON value. */
        fun longest(longest: JsonField<Long>) = apply { this.longest = longest }

        /** Rushing touchdowns. */
        fun touchdowns(touchdowns: Long?) = touchdowns(JsonField.ofNullable(touchdowns))

        fun touchdowns(touchdowns: Long) = touchdowns(touchdowns as Long?)

        fun touchdowns(touchdowns: Optional<Long>) = touchdowns(touchdowns.getOrNull())

        /** Sets [Builder.touchdowns] to an arbitrary JSON value. */
        fun touchdowns(touchdowns: JsonField<Long>) = apply { this.touchdowns = touchdowns }

        /** Rushing yards. */
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
         * Returns an immutable instance of [FootballRushingStats].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballRushingStats =
            FootballRushingStats(
                checkRequired("attempts", attempts),
                checkRequired("avgYards", avgYards),
                checkRequired("longest", longest),
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
    fun validate(): FootballRushingStats = apply {
        if (validated) {
            return@apply
        }

        attempts()
        avgYards()
        longest()
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
        (if (attempts.asKnown().isPresent) 1 else 0) +
            (if (avgYards.asKnown().isPresent) 1 else 0) +
            (if (longest.asKnown().isPresent) 1 else 0) +
            (if (touchdowns.asKnown().isPresent) 1 else 0) +
            (if (yards.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballRushingStats &&
            attempts == other.attempts &&
            avgYards == other.avgYards &&
            longest == other.longest &&
            touchdowns == other.touchdowns &&
            yards == other.yards &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(attempts, avgYards, longest, touchdowns, yards, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballRushingStats{attempts=$attempts, avgYards=$avgYards, longest=$longest, touchdowns=$touchdowns, yards=$yards, additionalProperties=$additionalProperties}"
}
