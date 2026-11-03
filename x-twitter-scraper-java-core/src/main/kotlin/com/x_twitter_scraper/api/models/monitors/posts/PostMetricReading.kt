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

/** A metric's current value & its gain since tracking began. Both are null when X shows no count, as for views on old posts. */
class PostMetricReading
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val current: JsonField<Long>,
    private val gain: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("current") @ExcludeMissing current: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("gain") @ExcludeMissing gain: JsonField<Long> = JsonMissing.of(),
    ) : this(current, gain, mutableMapOf())

    fun current(): Optional<Long> = current.getOptional("current")

    fun gain(): Optional<Long> = gain.getOptional("gain")

    /** Returns the raw JSON value of [current]. */
    @JsonProperty("current") @ExcludeMissing fun _current(): JsonField<Long> = current

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

        /** Returns a mutable builder for constructing an instance of [PostMetricReading]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [PostMetricReading]. */
    class Builder internal constructor() {

        private var current: JsonField<Long>? = null
        private var gain: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(postMetricReading: PostMetricReading) = apply {
            current = postMetricReading.current
            gain = postMetricReading.gain
            additionalProperties = postMetricReading.additionalProperties.toMutableMap()
        }

        fun current(current: Long?) = current(JsonField.ofNullable(current))

        fun current(current: Long) = current(current as Long?)

        fun current(current: Optional<Long>) = current(current.getOrNull())

        /** Sets [Builder.current] to an arbitrary JSON value. */
        fun current(current: JsonField<Long>) = apply { this.current = current }

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
         * Returns an immutable instance of [PostMetricReading].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): PostMetricReading =
            PostMetricReading(
                checkRequired("current", current),
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
    fun validate(): PostMetricReading = apply {
        if (validated) {
            return@apply
        }

        current()
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
        (if (current.asKnown().isPresent) 1 else 0) +
            (if (gain.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PostMetricReading &&
            current == other.current &&
            gain == other.gain &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(current, gain, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "PostMetricReading{current=$current, gain=$gain, additionalProperties=$additionalProperties}"
}
