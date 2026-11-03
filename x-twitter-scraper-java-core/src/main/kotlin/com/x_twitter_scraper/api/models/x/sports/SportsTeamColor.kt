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

class SportsTeamColor
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val r: JsonField<Long>,
    private val g: JsonField<Long>,
    private val b: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("r") @ExcludeMissing r: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("g") @ExcludeMissing g: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("b") @ExcludeMissing b: JsonField<Long> = JsonMissing.of(),
    ) : this(r, g, b, mutableMapOf())

    /** Red, from 0 to 255. */
    fun r(): Optional<Long> = r.getOptional("r")

    /** Green, from 0 to 255. */
    fun g(): Optional<Long> = g.getOptional("g")

    /** Blue, from 0 to 255. */
    fun b(): Optional<Long> = b.getOptional("b")

    /** Returns the raw JSON value of [r]. */
    @JsonProperty("r") @ExcludeMissing fun _r(): JsonField<Long> = r

    /** Returns the raw JSON value of [g]. */
    @JsonProperty("g") @ExcludeMissing fun _g(): JsonField<Long> = g

    /** Returns the raw JSON value of [b]. */
    @JsonProperty("b") @ExcludeMissing fun _b(): JsonField<Long> = b

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

        /** Returns a mutable builder for constructing an instance of [SportsTeamColor]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SportsTeamColor]. */
    class Builder internal constructor() {

        private var r: JsonField<Long>? = null
        private var g: JsonField<Long>? = null
        private var b: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(sportsTeamColor: SportsTeamColor) = apply {
            r = sportsTeamColor.r
            g = sportsTeamColor.g
            b = sportsTeamColor.b
            additionalProperties = sportsTeamColor.additionalProperties.toMutableMap()
        }

        /** Red, from 0 to 255. */
        fun r(r: Long?) = r(JsonField.ofNullable(r))

        fun r(r: Long) = r(r as Long?)

        fun r(r: Optional<Long>) = r(r.getOrNull())

        /** Sets [Builder.r] to an arbitrary JSON value. */
        fun r(r: JsonField<Long>) = apply { this.r = r }

        /** Green, from 0 to 255. */
        fun g(g: Long?) = g(JsonField.ofNullable(g))

        fun g(g: Long) = g(g as Long?)

        fun g(g: Optional<Long>) = g(g.getOrNull())

        /** Sets [Builder.g] to an arbitrary JSON value. */
        fun g(g: JsonField<Long>) = apply { this.g = g }

        /** Blue, from 0 to 255. */
        fun b(b: Long?) = b(JsonField.ofNullable(b))

        fun b(b: Long) = b(b as Long?)

        fun b(b: Optional<Long>) = b(b.getOrNull())

        /** Sets [Builder.b] to an arbitrary JSON value. */
        fun b(b: JsonField<Long>) = apply { this.b = b }

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
         * Returns an immutable instance of [SportsTeamColor].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SportsTeamColor =
            SportsTeamColor(
                checkRequired("r", r),
                checkRequired("g", g),
                checkRequired("b", b),
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
    fun validate(): SportsTeamColor = apply {
        if (validated) {
            return@apply
        }

        r()
        g()
        b()
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
        (if (r.asKnown().isPresent) 1 else 0) +
            (if (g.asKnown().isPresent) 1 else 0) +
            (if (b.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SportsTeamColor &&
            r == other.r &&
            g == other.g &&
            b == other.b &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(r, g, b, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SportsTeamColor{r=$r, g=$g, b=$b, additionalProperties=$additionalProperties}"
}
