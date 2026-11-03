// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.monitors.posts

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

/** A metric's value at the hour's end & its gain over that hour. Both are null when X shows no count. */
class PostMetricPoint
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val value: JsonField<Long>,
    private val gain: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("value") @ExcludeMissing value: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("gain") @ExcludeMissing gain: JsonField<Long> = JsonMissing.of(),
    ) : this(value, gain, mutableMapOf())

    fun value(): Optional<Long> = value.getOptional("value")

    fun gain(): Optional<Long> = gain.getOptional("gain")

    /** Returns the raw JSON value of [value]. */
    @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<Long> = value

    /** Returns the raw JSON value of [gain]. */
    @JsonProperty("gain") @ExcludeMissing fun _gain(): JsonField<Long> = gain

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

        /** Returns a mutable builder for constructing an instance of [PostMetricPoint]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [PostMetricPoint]. */
    class Builder internal constructor() {

        private var value: JsonField<Long>? = null
        private var gain: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(postMetricPoint: PostMetricPoint) = apply {
            value = postMetricPoint.value
            gain = postMetricPoint.gain
            additionalProperties = postMetricPoint.additionalProperties.toMutableMap()
        }

        fun value(value: Long?) = value(JsonField.ofNullable(value))

        fun value(value: Long) = value(value as Long?)

        fun value(value: Optional<Long>) = value(value.getOrNull())

        /** Sets [Builder.value] to an arbitrary JSON value. */
        fun value(value: JsonField<Long>) = apply { this.value = value }

        fun gain(gain: Long?) = gain(JsonField.ofNullable(gain))

        fun gain(gain: Long) = gain(gain as Long?)

        fun gain(gain: Optional<Long>) = gain(gain.getOrNull())

        /** Sets [Builder.gain] to an arbitrary JSON value. */
        fun gain(gain: JsonField<Long>) = apply { this.gain = gain }

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
         * Returns an immutable instance of [PostMetricPoint].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): PostMetricPoint =
            PostMetricPoint(
                checkRequired("value", value),
                checkRequired("gain", gain),
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
    fun validate(): PostMetricPoint = apply {
        if (validated) {
            return@apply
        }

        value()
        gain()
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
        (if (value.asKnown().isPresent) 1 else 0) +
            (if (gain.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PostMetricPoint &&
            value == other.value &&
            gain == other.gain &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(value, gain, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "PostMetricPoint{value=$value, gain=$gain, additionalProperties=$additionalProperties}"
}
