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
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** Hourly metric buckets of 1 post monitor, oldest first. */
class PostMonitorMetrics
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val hours: JsonField<Long>,
    private val buckets: JsonField<List<PostMonitorMetricsBucket>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("hours") @ExcludeMissing hours: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("buckets") @ExcludeMissing buckets: JsonField<List<PostMonitorMetricsBucket>> = JsonMissing.of(),
    ) : this(hours, buckets, mutableMapOf())

    fun hours(): Long = hours.getRequired("hours")

    fun buckets(): List<PostMonitorMetricsBucket> = buckets.getRequired("buckets")

    /** Returns the raw JSON value of [hours]. */
    @JsonProperty("hours") @ExcludeMissing fun _hours(): JsonField<Long> = hours

    /** Returns the raw JSON value of [buckets]. */
    @JsonProperty("buckets") @ExcludeMissing fun _buckets(): JsonField<List<PostMonitorMetricsBucket>> = buckets

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

        /** Returns a mutable builder for constructing an instance of [PostMonitorMetrics]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [PostMonitorMetrics]. */
    class Builder internal constructor() {

        private var hours: JsonField<Long>? = null
        private var buckets: JsonField<MutableList<PostMonitorMetricsBucket>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(postMonitorMetrics: PostMonitorMetrics) = apply {
            hours = postMonitorMetrics.hours
            buckets = postMonitorMetrics.buckets.map { it.toMutableList() }
            additionalProperties = postMonitorMetrics.additionalProperties.toMutableMap()
        }

        fun hours(hours: Long) = hours(JsonField.of(hours))

        /** Sets [Builder.hours] to an arbitrary JSON value. */
        fun hours(hours: JsonField<Long>) = apply { this.hours = hours }

        fun buckets(buckets: List<PostMonitorMetricsBucket>) = buckets(JsonField.of(buckets))

        /** Sets [Builder.buckets] to an arbitrary JSON value. */
        fun buckets(buckets: JsonField<List<PostMonitorMetricsBucket>>) = apply { this.buckets = buckets.map { it.toMutableList() } }

        /** Adds a single [PostMonitorMetricsBucket] to [buckets]. */
        fun addBucket(bucket: PostMonitorMetricsBucket) = apply {
            buckets =
                (buckets ?: JsonField.of(mutableListOf())).also {
                    checkKnown("buckets", it).add(bucket)
                }
        }

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
         * Returns an immutable instance of [PostMonitorMetrics].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): PostMonitorMetrics =
            PostMonitorMetrics(
                checkRequired("hours", hours),
                checkRequired("buckets", buckets).map { it.toImmutable() },
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
    fun validate(): PostMonitorMetrics = apply {
        if (validated) {
            return@apply
        }

        hours()
        buckets().forEach { it.validate() }
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
        (if (hours.asKnown().isPresent) 1 else 0) +
            (buckets.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PostMonitorMetrics &&
            hours == other.hours &&
            buckets == other.buckets &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(hours, buckets, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "PostMonitorMetrics{hours=$hours, buckets=$buckets, additionalProperties=$additionalProperties}"
}
