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

/** Betting odds titles for 1 team, as X shows them. */
class FootballOdds
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val moneyLine: JsonField<String>,
    private val spread: JsonField<String>,
    private val total: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("moneyLine") @ExcludeMissing moneyLine: JsonField<String> = JsonMissing.of(),
        @JsonProperty("spread") @ExcludeMissing spread: JsonField<String> = JsonMissing.of(),
        @JsonProperty("total") @ExcludeMissing total: JsonField<String> = JsonMissing.of(),
    ) : this(moneyLine, spread, total, mutableMapOf())

    /** The money line. X sends it for the away team only. */
    fun moneyLine(): Optional<String> = moneyLine.getOptional("moneyLine")

    /** The point spread. */
    fun spread(): Optional<String> = spread.getOptional("spread")

    /** The over or under total. */
    fun total(): Optional<String> = total.getOptional("total")

    /** Returns the raw JSON value of [moneyLine]. */
    @JsonProperty("moneyLine") @ExcludeMissing fun _moneyLine(): JsonField<String> = moneyLine

    /** Returns the raw JSON value of [spread]. */
    @JsonProperty("spread") @ExcludeMissing fun _spread(): JsonField<String> = spread

    /** Returns the raw JSON value of [total]. */
    @JsonProperty("total") @ExcludeMissing fun _total(): JsonField<String> = total

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

        /** Returns a mutable builder for constructing an instance of [FootballOdds]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballOdds]. */
    class Builder internal constructor() {

        private var moneyLine: JsonField<String>? = null
        private var spread: JsonField<String>? = null
        private var total: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballOdds: FootballOdds) = apply {
            moneyLine = footballOdds.moneyLine
            spread = footballOdds.spread
            total = footballOdds.total
            additionalProperties = footballOdds.additionalProperties.toMutableMap()
        }

        /** The money line. X sends it for the away team only. */
        fun moneyLine(moneyLine: String?) = moneyLine(JsonField.ofNullable(moneyLine))

        fun moneyLine(moneyLine: Optional<String>) = moneyLine(moneyLine.getOrNull())

        /** Sets [Builder.moneyLine] to an arbitrary JSON value. */
        fun moneyLine(moneyLine: JsonField<String>) = apply { this.moneyLine = moneyLine }

        /** The point spread. */
        fun spread(spread: String?) = spread(JsonField.ofNullable(spread))

        fun spread(spread: Optional<String>) = spread(spread.getOrNull())

        /** Sets [Builder.spread] to an arbitrary JSON value. */
        fun spread(spread: JsonField<String>) = apply { this.spread = spread }

        /** The over or under total. */
        fun total(total: String?) = total(JsonField.ofNullable(total))

        fun total(total: Optional<String>) = total(total.getOrNull())

        /** Sets [Builder.total] to an arbitrary JSON value. */
        fun total(total: JsonField<String>) = apply { this.total = total }

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
         * Returns an immutable instance of [FootballOdds].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballOdds =
            FootballOdds(
                checkRequired("moneyLine", moneyLine),
                checkRequired("spread", spread),
                checkRequired("total", total),
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
    fun validate(): FootballOdds = apply {
        if (validated) {
            return@apply
        }

        moneyLine()
        spread()
        total()
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
        (if (moneyLine.asKnown().isPresent) 1 else 0) +
            (if (spread.asKnown().isPresent) 1 else 0) +
            (if (total.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballOdds &&
            moneyLine == other.moneyLine &&
            spread == other.spread &&
            total == other.total &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(moneyLine, spread, total, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballOdds{moneyLine=$moneyLine, spread=$spread, total=$total, additionalProperties=$additionalProperties}"
}
