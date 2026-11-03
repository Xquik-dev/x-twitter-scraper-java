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

/** Third downs tried & converted. */
class FootballTeamTotalsThirdDowns
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val attempts: JsonField<Long>,
    private val successes: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("attempts") @ExcludeMissing attempts: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("successes") @ExcludeMissing successes: JsonField<Long> = JsonMissing.of(),
    ) : this(attempts, successes, mutableMapOf())

    /** Third downs tried. */
    fun attempts(): Optional<Long> = attempts.getOptional("attempts")

    /** Third downs converted. */
    fun successes(): Optional<Long> = successes.getOptional("successes")

    /** Returns the raw JSON value of [attempts]. */
    @JsonProperty("attempts") @ExcludeMissing fun _attempts(): JsonField<Long> = attempts

    /** Returns the raw JSON value of [successes]. */
    @JsonProperty("successes") @ExcludeMissing fun _successes(): JsonField<Long> = successes

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

        /** Returns a mutable builder for constructing an instance of [FootballTeamTotalsThirdDowns]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballTeamTotalsThirdDowns]. */
    class Builder internal constructor() {

        private var attempts: JsonField<Long>? = null
        private var successes: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballTeamTotalsThirdDowns: FootballTeamTotalsThirdDowns) = apply {
            attempts = footballTeamTotalsThirdDowns.attempts
            successes = footballTeamTotalsThirdDowns.successes
            additionalProperties = footballTeamTotalsThirdDowns.additionalProperties.toMutableMap()
        }

        /** Third downs tried. */
        fun attempts(attempts: Long?) = attempts(JsonField.ofNullable(attempts))

        fun attempts(attempts: Long) = attempts(attempts as Long?)

        fun attempts(attempts: Optional<Long>) = attempts(attempts.getOrNull())

        /** Sets [Builder.attempts] to an arbitrary JSON value. */
        fun attempts(attempts: JsonField<Long>) = apply { this.attempts = attempts }

        /** Third downs converted. */
        fun successes(successes: Long?) = successes(JsonField.ofNullable(successes))

        fun successes(successes: Long) = successes(successes as Long?)

        fun successes(successes: Optional<Long>) = successes(successes.getOrNull())

        /** Sets [Builder.successes] to an arbitrary JSON value. */
        fun successes(successes: JsonField<Long>) = apply { this.successes = successes }

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
         * Returns an immutable instance of [FootballTeamTotalsThirdDowns].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballTeamTotalsThirdDowns =
            FootballTeamTotalsThirdDowns(
                checkRequired("attempts", attempts),
                checkRequired("successes", successes),
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
    fun validate(): FootballTeamTotalsThirdDowns = apply {
        if (validated) {
            return@apply
        }

        attempts()
        successes()
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
            (if (successes.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballTeamTotalsThirdDowns &&
            attempts == other.attempts &&
            successes == other.successes &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(attempts, successes, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballTeamTotalsThirdDowns{attempts=$attempts, successes=$successes, additionalProperties=$additionalProperties}"
}
