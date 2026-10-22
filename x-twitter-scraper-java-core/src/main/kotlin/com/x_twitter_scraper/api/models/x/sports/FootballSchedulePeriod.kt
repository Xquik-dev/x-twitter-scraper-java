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

/** A period of a listed game. */
class FootballSchedulePeriod
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val type: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
    ) : this(type, mutableMapOf())

    /** X's name for the period, such as Quarter. */
    fun type(): Optional<String> = type.getOptional("type")

    /** Returns the raw JSON value of [type]. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

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

        /** Returns a mutable builder for constructing an instance of [FootballSchedulePeriod]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballSchedulePeriod]. */
    class Builder internal constructor() {

        private var type: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballSchedulePeriod: FootballSchedulePeriod) = apply {
            type = footballSchedulePeriod.type
            additionalProperties = footballSchedulePeriod.additionalProperties.toMutableMap()
        }

        /** X's name for the period, such as Quarter. */
        fun type(type: String?) = type(JsonField.ofNullable(type))

        fun type(type: Optional<String>) = type(type.getOrNull())

        /** Sets [Builder.type] to an arbitrary JSON value. */
        fun type(type: JsonField<String>) = apply { this.type = type }

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
         * Returns an immutable instance of [FootballSchedulePeriod].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballSchedulePeriod =
            FootballSchedulePeriod(
                checkRequired("type", type),
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
    fun validate(): FootballSchedulePeriod = apply {
        if (validated) {
            return@apply
        }

        type()
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
        (if (type.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballSchedulePeriod &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(type, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballSchedulePeriod{type=$type, additionalProperties=$additionalProperties}"
}
