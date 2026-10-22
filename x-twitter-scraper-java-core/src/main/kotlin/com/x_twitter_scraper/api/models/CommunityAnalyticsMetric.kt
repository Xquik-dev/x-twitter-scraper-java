// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models

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

/** A community metric for X's latest period & its percent change. */
class CommunityAnalyticsMetric
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val count: JsonField<Long>,
    private val changePercent: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("count") @ExcludeMissing count: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("changePercent")
        @ExcludeMissing
        changePercent: JsonField<Double> = JsonMissing.of(),
    ) : this(count, changePercent, mutableMapOf())

    /**
     * Total for this metric during X's latest period.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun count(): Long = count.getRequired("count")

    /**
     * Change in percent from the same figure 1 day earlier. Values stay unrounded.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun changePercent(): Double = changePercent.getRequired("changePercent")

    /**
     * Returns the raw JSON value of [count].
     *
     * Unlike [count], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("count") @ExcludeMissing fun _count(): JsonField<Long> = count

    /**
     * Returns the raw JSON value of [changePercent].
     *
     * Unlike [changePercent], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("changePercent")
    @ExcludeMissing
    fun _changePercent(): JsonField<Double> = changePercent

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

        /**
         * Returns a mutable builder for constructing an instance of [CommunityAnalyticsMetric].
         *
         * The following fields are required:
         * ```java
         * .count()
         * .changePercent()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CommunityAnalyticsMetric]. */
    class Builder internal constructor() {

        private var count: JsonField<Long>? = null
        private var changePercent: JsonField<Double>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(communityAnalyticsMetric: CommunityAnalyticsMetric) = apply {
            count = communityAnalyticsMetric.count
            changePercent = communityAnalyticsMetric.changePercent
            additionalProperties = communityAnalyticsMetric.additionalProperties.toMutableMap()
        }

        /** Total for this metric during X's latest period. */
        fun count(count: Long) = count(JsonField.of(count))

        /** Sets [Builder.count] to an arbitrary JSON value. */
        fun count(count: JsonField<Long>) = apply { this.count = count }

        /** Change in percent from the same figure 1 day earlier. Values stay unrounded. */
        fun changePercent(changePercent: Double) = changePercent(JsonField.of(changePercent))

        /** Sets [Builder.changePercent] to an arbitrary JSON value. */
        fun changePercent(changePercent: JsonField<Double>) = apply {
            this.changePercent = changePercent
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
         * Returns an immutable instance of [CommunityAnalyticsMetric].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .count()
         * .changePercent()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CommunityAnalyticsMetric =
            CommunityAnalyticsMetric(
                checkRequired("count", count),
                checkRequired("changePercent", changePercent),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match
     *   its expected type.
     */
    fun validate(): CommunityAnalyticsMetric = apply {
        if (validated) {
            return@apply
        }

        count()
        changePercent()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: XTwitterScraperInvalidDataException) {
            false
        }

    @JvmSynthetic
    internal fun validity(): Int =
        (if (count.asKnown().isPresent) 1 else 0) +
            (if (changePercent.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CommunityAnalyticsMetric &&
            count == other.count &&
            changePercent == other.changePercent &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(count, changePercent, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CommunityAnalyticsMetric{count=$count, changePercent=$changePercent, additionalProperties=$additionalProperties}"
}
