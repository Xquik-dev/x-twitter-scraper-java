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

/** Penalties against the team. */
class FootballTeamTotalsPenalties
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val count: JsonField<Long>,
    private val yards: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("count") @ExcludeMissing count: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("yards") @ExcludeMissing yards: JsonField<Long> = JsonMissing.of(),
    ) : this(count, yards, mutableMapOf())

    /** Penalties. */
    fun count(): Optional<Long> = count.getOptional("count")

    /** Penalty yards. */
    fun yards(): Optional<Long> = yards.getOptional("yards")

    /** Returns the raw JSON value of [count]. */
    @JsonProperty("count") @ExcludeMissing fun _count(): JsonField<Long> = count

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

        /** Returns a mutable builder for constructing an instance of [FootballTeamTotalsPenalties]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballTeamTotalsPenalties]. */
    class Builder internal constructor() {

        private var count: JsonField<Long>? = null
        private var yards: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballTeamTotalsPenalties: FootballTeamTotalsPenalties) = apply {
            count = footballTeamTotalsPenalties.count
            yards = footballTeamTotalsPenalties.yards
            additionalProperties = footballTeamTotalsPenalties.additionalProperties.toMutableMap()
        }

        /** Penalties. */
        fun count(count: Long?) = count(JsonField.ofNullable(count))

        fun count(count: Long) = count(count as Long?)

        fun count(count: Optional<Long>) = count(count.getOrNull())

        /** Sets [Builder.count] to an arbitrary JSON value. */
        fun count(count: JsonField<Long>) = apply { this.count = count }

        /** Penalty yards. */
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
         * Returns an immutable instance of [FootballTeamTotalsPenalties].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballTeamTotalsPenalties =
            FootballTeamTotalsPenalties(
                checkRequired("count", count),
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
    fun validate(): FootballTeamTotalsPenalties = apply {
        if (validated) {
            return@apply
        }

        count()
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
        (if (count.asKnown().isPresent) 1 else 0) +
            (if (yards.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballTeamTotalsPenalties &&
            count == other.count &&
            yards == other.yards &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(count, yards, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballTeamTotalsPenalties{count=$count, yards=$yards, additionalProperties=$additionalProperties}"
}
