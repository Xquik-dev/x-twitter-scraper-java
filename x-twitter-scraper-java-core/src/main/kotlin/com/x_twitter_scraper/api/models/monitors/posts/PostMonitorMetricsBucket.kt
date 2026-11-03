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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

class PostMonitorMetricsBucket
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val at: JsonField<OffsetDateTime>,
    private val metrics: JsonField<PostMonitorMetricsBucketMetrics>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("at") @ExcludeMissing at: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("metrics") @ExcludeMissing metrics: JsonField<PostMonitorMetricsBucketMetrics> = JsonMissing.of(),
    ) : this(at, metrics, mutableMapOf())

    /** Start of the hour. */
    fun at(): OffsetDateTime = at.getRequired("at")

    fun metrics(): PostMonitorMetricsBucketMetrics = metrics.getRequired("metrics")

    /** Returns the raw JSON value of [at]. */
    @JsonProperty("at") @ExcludeMissing fun _at(): JsonField<OffsetDateTime> = at

    /** Returns the raw JSON value of [metrics]. */
    @JsonProperty("metrics") @ExcludeMissing fun _metrics(): JsonField<PostMonitorMetricsBucketMetrics> = metrics

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

        /** Returns a mutable builder for constructing an instance of [PostMonitorMetricsBucket]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [PostMonitorMetricsBucket]. */
    class Builder internal constructor() {

        private var at: JsonField<OffsetDateTime>? = null
        private var metrics: JsonField<PostMonitorMetricsBucketMetrics>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(postMonitorMetricsBucket: PostMonitorMetricsBucket) = apply {
            at = postMonitorMetricsBucket.at
            metrics = postMonitorMetricsBucket.metrics
            additionalProperties = postMonitorMetricsBucket.additionalProperties.toMutableMap()
        }

        /** Start of the hour. */
        fun at(at: OffsetDateTime) = at(JsonField.of(at))

        /** Sets [Builder.at] to an arbitrary JSON value. */
        fun at(at: JsonField<OffsetDateTime>) = apply { this.at = at }

        fun metrics(metrics: PostMonitorMetricsBucketMetrics) = metrics(JsonField.of(metrics))

        /** Sets [Builder.metrics] to an arbitrary JSON value. */
        fun metrics(metrics: JsonField<PostMonitorMetricsBucketMetrics>) = apply { this.metrics = metrics }

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
         * Returns an immutable instance of [PostMonitorMetricsBucket].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): PostMonitorMetricsBucket =
            PostMonitorMetricsBucket(
                checkRequired("at", at),
                checkRequired("metrics", metrics),
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
    fun validate(): PostMonitorMetricsBucket = apply {
        if (validated) {
            return@apply
        }

        at()
        metrics().validate()
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
        (if (at.asKnown().isPresent) 1 else 0) +
            (metrics.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PostMonitorMetricsBucket &&
            at == other.at &&
            metrics == other.metrics &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(at, metrics, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "PostMonitorMetricsBucket{at=$at, metrics=$metrics, additionalProperties=$additionalProperties}"
}
