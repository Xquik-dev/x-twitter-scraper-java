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

/** The team's logo images. */
class SportsTeamLogos
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val default_: JsonField<String>,
    private val light: JsonField<String>,
    private val dark: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("default") @ExcludeMissing default_: JsonField<String> = JsonMissing.of(),
        @JsonProperty("light") @ExcludeMissing light: JsonField<String> = JsonMissing.of(),
        @JsonProperty("dark") @ExcludeMissing dark: JsonField<String> = JsonMissing.of(),
    ) : this(default_, light, dark, mutableMapOf())

    /** The logo X shows by default. */
    fun default_(): Optional<String> = default_.getOptional("default")

    /** The logo for light backgrounds. */
    fun light(): Optional<String> = light.getOptional("light")

    /** The logo for dark backgrounds. */
    fun dark(): Optional<String> = dark.getOptional("dark")

    /** Returns the raw JSON value of [default_]. */
    @JsonProperty("default") @ExcludeMissing fun _default_(): JsonField<String> = default_

    /** Returns the raw JSON value of [light]. */
    @JsonProperty("light") @ExcludeMissing fun _light(): JsonField<String> = light

    /** Returns the raw JSON value of [dark]. */
    @JsonProperty("dark") @ExcludeMissing fun _dark(): JsonField<String> = dark

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

        /** Returns a mutable builder for constructing an instance of [SportsTeamLogos]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SportsTeamLogos]. */
    class Builder internal constructor() {

        private var default_: JsonField<String>? = null
        private var light: JsonField<String>? = null
        private var dark: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(sportsTeamLogos: SportsTeamLogos) = apply {
            default_ = sportsTeamLogos.default_
            light = sportsTeamLogos.light
            dark = sportsTeamLogos.dark
            additionalProperties = sportsTeamLogos.additionalProperties.toMutableMap()
        }

        /** The logo X shows by default. */
        fun default_(default_: String?) = default_(JsonField.ofNullable(default_))

        fun default_(default_: Optional<String>) = default_(default_.getOrNull())

        /** Sets [Builder.default_] to an arbitrary JSON value. */
        fun default_(default_: JsonField<String>) = apply { this.default_ = default_ }

        /** The logo for light backgrounds. */
        fun light(light: String?) = light(JsonField.ofNullable(light))

        fun light(light: Optional<String>) = light(light.getOrNull())

        /** Sets [Builder.light] to an arbitrary JSON value. */
        fun light(light: JsonField<String>) = apply { this.light = light }

        /** The logo for dark backgrounds. */
        fun dark(dark: String?) = dark(JsonField.ofNullable(dark))

        fun dark(dark: Optional<String>) = dark(dark.getOrNull())

        /** Sets [Builder.dark] to an arbitrary JSON value. */
        fun dark(dark: JsonField<String>) = apply { this.dark = dark }

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
         * Returns an immutable instance of [SportsTeamLogos].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SportsTeamLogos =
            SportsTeamLogos(
                checkRequired("default", default_),
                checkRequired("light", light),
                checkRequired("dark", dark),
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
    fun validate(): SportsTeamLogos = apply {
        if (validated) {
            return@apply
        }

        default_()
        light()
        dark()
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
        (if (default_.asKnown().isPresent) 1 else 0) +
            (if (light.asKnown().isPresent) 1 else 0) +
            (if (dark.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SportsTeamLogos &&
            default_ == other.default_ &&
            light == other.light &&
            dark == other.dark &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(default_, light, dark, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SportsTeamLogos{default_=$default_, light=$light, dark=$dark, additionalProperties=$additionalProperties}"
}
