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

/** Extra point kicks. */
class FootballPlayerStatsExtraPoints
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val attempts: JsonField<Long>,
    private val made: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("attempts") @ExcludeMissing attempts: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("made") @ExcludeMissing made: JsonField<Long> = JsonMissing.of(),
    ) : this(attempts, made, mutableMapOf())

    /** Extra points tried. */
    fun attempts(): Optional<Long> = attempts.getOptional("attempts")

    /** Extra points made. */
    fun made(): Optional<Long> = made.getOptional("made")

    /** Returns the raw JSON value of [attempts]. */
    @JsonProperty("attempts") @ExcludeMissing fun _attempts(): JsonField<Long> = attempts

    /** Returns the raw JSON value of [made]. */
    @JsonProperty("made") @ExcludeMissing fun _made(): JsonField<Long> = made

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

        /** Returns a mutable builder for constructing an instance of [FootballPlayerStatsExtraPoints]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballPlayerStatsExtraPoints]. */
    class Builder internal constructor() {

        private var attempts: JsonField<Long>? = null
        private var made: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballPlayerStatsExtraPoints: FootballPlayerStatsExtraPoints) = apply {
            attempts = footballPlayerStatsExtraPoints.attempts
            made = footballPlayerStatsExtraPoints.made
            additionalProperties = footballPlayerStatsExtraPoints.additionalProperties.toMutableMap()
        }

        /** Extra points tried. */
        fun attempts(attempts: Long?) = attempts(JsonField.ofNullable(attempts))

        fun attempts(attempts: Long) = attempts(attempts as Long?)

        fun attempts(attempts: Optional<Long>) = attempts(attempts.getOrNull())

        /** Sets [Builder.attempts] to an arbitrary JSON value. */
        fun attempts(attempts: JsonField<Long>) = apply { this.attempts = attempts }

        /** Extra points made. */
        fun made(made: Long?) = made(JsonField.ofNullable(made))

        fun made(made: Long) = made(made as Long?)

        fun made(made: Optional<Long>) = made(made.getOrNull())

        /** Sets [Builder.made] to an arbitrary JSON value. */
        fun made(made: JsonField<Long>) = apply { this.made = made }

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
         * Returns an immutable instance of [FootballPlayerStatsExtraPoints].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballPlayerStatsExtraPoints =
            FootballPlayerStatsExtraPoints(
                checkRequired("attempts", attempts),
                checkRequired("made", made),
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
    fun validate(): FootballPlayerStatsExtraPoints = apply {
        if (validated) {
            return@apply
        }

        attempts()
        made()
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
            (if (made.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballPlayerStatsExtraPoints &&
            attempts == other.attempts &&
            made == other.made &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(attempts, made, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballPlayerStatsExtraPoints{attempts=$attempts, made=$made, additionalProperties=$additionalProperties}"
}
