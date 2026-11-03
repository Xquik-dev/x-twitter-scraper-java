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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** People watching the game on X at X's last count. Null before X counts any, as before kickoff. */
class SportsGameAudienceViewers
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val count: JsonField<Long>,
    private val asOf: JsonField<OffsetDateTime>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("count") @ExcludeMissing count: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("asOf") @ExcludeMissing asOf: JsonField<OffsetDateTime> = JsonMissing.of(),
    ) : this(count, asOf, mutableMapOf())

    /** How many people watched the game on X. */
    fun count(): Long = count.getRequired("count")

    /** When X counted them. */
    fun asOf(): OffsetDateTime = asOf.getRequired("asOf")

    /** Returns the raw JSON value of [count]. */
    @JsonProperty("count") @ExcludeMissing fun _count(): JsonField<Long> = count

    /** Returns the raw JSON value of [asOf]. */
    @JsonProperty("asOf") @ExcludeMissing fun _asOf(): JsonField<OffsetDateTime> = asOf

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

        /** Returns a mutable builder for constructing an instance of [SportsGameAudienceViewers]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SportsGameAudienceViewers]. */
    class Builder internal constructor() {

        private var count: JsonField<Long>? = null
        private var asOf: JsonField<OffsetDateTime>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(sportsGameAudienceViewers: SportsGameAudienceViewers) = apply {
            count = sportsGameAudienceViewers.count
            asOf = sportsGameAudienceViewers.asOf
            additionalProperties = sportsGameAudienceViewers.additionalProperties.toMutableMap()
        }

        /** How many people watched the game on X. */
        fun count(count: Long) = count(JsonField.of(count))

        /** Sets [Builder.count] to an arbitrary JSON value. */
        fun count(count: JsonField<Long>) = apply { this.count = count }

        /** When X counted them. */
        fun asOf(asOf: OffsetDateTime) = asOf(JsonField.of(asOf))

        /** Sets [Builder.asOf] to an arbitrary JSON value. */
        fun asOf(asOf: JsonField<OffsetDateTime>) = apply { this.asOf = asOf }

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
         * Returns an immutable instance of [SportsGameAudienceViewers].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SportsGameAudienceViewers =
            SportsGameAudienceViewers(
                checkRequired("count", count),
                checkRequired("asOf", asOf),
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
    fun validate(): SportsGameAudienceViewers = apply {
        if (validated) {
            return@apply
        }

        count()
        asOf()
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
            (if (asOf.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SportsGameAudienceViewers &&
            count == other.count &&
            asOf == other.asOf &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(count, asOf, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SportsGameAudienceViewers{count=$count, asOf=$asOf, additionalProperties=$additionalProperties}"
}
