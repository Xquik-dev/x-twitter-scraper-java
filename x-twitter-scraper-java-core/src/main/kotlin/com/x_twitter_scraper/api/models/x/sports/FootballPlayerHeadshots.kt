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

/** Photos of the player. Any of them can be null. */
class FootballPlayerHeadshots
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val original: JsonField<String>,
    private val large: JsonField<String>,
    private val medium: JsonField<String>,
    private val small: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("original") @ExcludeMissing original: JsonField<String> = JsonMissing.of(),
        @JsonProperty("large") @ExcludeMissing large: JsonField<String> = JsonMissing.of(),
        @JsonProperty("medium") @ExcludeMissing medium: JsonField<String> = JsonMissing.of(),
        @JsonProperty("small") @ExcludeMissing small: JsonField<String> = JsonMissing.of(),
    ) : this(original, large, medium, small, mutableMapOf())

    /** The photo X shows on the player's card. */
    fun original(): Optional<String> = original.getOptional("original")

    /** The large photo. */
    fun large(): Optional<String> = large.getOptional("large")

    /** The medium photo. */
    fun medium(): Optional<String> = medium.getOptional("medium")

    /** The small photo. */
    fun small(): Optional<String> = small.getOptional("small")

    /** Returns the raw JSON value of [original]. */
    @JsonProperty("original") @ExcludeMissing fun _original(): JsonField<String> = original

    /** Returns the raw JSON value of [large]. */
    @JsonProperty("large") @ExcludeMissing fun _large(): JsonField<String> = large

    /** Returns the raw JSON value of [medium]. */
    @JsonProperty("medium") @ExcludeMissing fun _medium(): JsonField<String> = medium

    /** Returns the raw JSON value of [small]. */
    @JsonProperty("small") @ExcludeMissing fun _small(): JsonField<String> = small

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

        /** Returns a mutable builder for constructing an instance of [FootballPlayerHeadshots]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballPlayerHeadshots]. */
    class Builder internal constructor() {

        private var original: JsonField<String>? = null
        private var large: JsonField<String>? = null
        private var medium: JsonField<String>? = null
        private var small: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballPlayerHeadshots: FootballPlayerHeadshots) = apply {
            original = footballPlayerHeadshots.original
            large = footballPlayerHeadshots.large
            medium = footballPlayerHeadshots.medium
            small = footballPlayerHeadshots.small
            additionalProperties = footballPlayerHeadshots.additionalProperties.toMutableMap()
        }

        /** The photo X shows on the player's card. */
        fun original(original: String?) = original(JsonField.ofNullable(original))

        fun original(original: Optional<String>) = original(original.getOrNull())

        /** Sets [Builder.original] to an arbitrary JSON value. */
        fun original(original: JsonField<String>) = apply { this.original = original }

        /** The large photo. */
        fun large(large: String?) = large(JsonField.ofNullable(large))

        fun large(large: Optional<String>) = large(large.getOrNull())

        /** Sets [Builder.large] to an arbitrary JSON value. */
        fun large(large: JsonField<String>) = apply { this.large = large }

        /** The medium photo. */
        fun medium(medium: String?) = medium(JsonField.ofNullable(medium))

        fun medium(medium: Optional<String>) = medium(medium.getOrNull())

        /** Sets [Builder.medium] to an arbitrary JSON value. */
        fun medium(medium: JsonField<String>) = apply { this.medium = medium }

        /** The small photo. */
        fun small(small: String?) = small(JsonField.ofNullable(small))

        fun small(small: Optional<String>) = small(small.getOrNull())

        /** Sets [Builder.small] to an arbitrary JSON value. */
        fun small(small: JsonField<String>) = apply { this.small = small }

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
         * Returns an immutable instance of [FootballPlayerHeadshots].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballPlayerHeadshots =
            FootballPlayerHeadshots(
                checkRequired("original", original),
                checkRequired("large", large),
                checkRequired("medium", medium),
                checkRequired("small", small),
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
    fun validate(): FootballPlayerHeadshots = apply {
        if (validated) {
            return@apply
        }

        original()
        large()
        medium()
        small()
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
        (if (original.asKnown().isPresent) 1 else 0) +
            (if (large.asKnown().isPresent) 1 else 0) +
            (if (medium.asKnown().isPresent) 1 else 0) +
            (if (small.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballPlayerHeadshots &&
            original == other.original &&
            large == other.large &&
            medium == other.medium &&
            small == other.small &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(original, large, medium, small, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballPlayerHeadshots{original=$original, large=$large, medium=$medium, small=$small, additionalProperties=$additionalProperties}"
}
