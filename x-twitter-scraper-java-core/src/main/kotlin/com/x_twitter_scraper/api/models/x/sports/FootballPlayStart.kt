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

/** Down & distance when the play started, or null. */
class FootballPlayStart
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val down: JsonField<Long>,
    private val yardsToGo: JsonField<Long>,
    private val yardline: JsonField<Long>,
    private val yardlineSide: JsonField<String>,
    private val possession: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("down") @ExcludeMissing down: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("yardsToGo") @ExcludeMissing yardsToGo: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("yardline") @ExcludeMissing yardline: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("yardlineSide") @ExcludeMissing yardlineSide: JsonField<String> = JsonMissing.of(),
        @JsonProperty("possession") @ExcludeMissing possession: JsonField<String> = JsonMissing.of(),
    ) : this(down, yardsToGo, yardline, yardlineSide, possession, mutableMapOf())

    /** The down, from 1 to 4. */
    fun down(): Optional<Long> = down.getOptional("down")

    /** The yards needed for a first down. */
    fun yardsToGo(): Optional<Long> = yardsToGo.getOptional("yardsToGo")

    /** The yard line of the ball. */
    fun yardline(): Optional<Long> = yardline.getOptional("yardline")

    /** Whose half the ball was in. Home or Away in NFL games, the team's alternateId in college games. */
    fun yardlineSide(): Optional<String> = yardlineSide.getOptional("yardlineSide")

    /** The team with the ball. Home or Away in NFL games, the team's alternateId in college games. */
    fun possession(): Optional<String> = possession.getOptional("possession")

    /** Returns the raw JSON value of [down]. */
    @JsonProperty("down") @ExcludeMissing fun _down(): JsonField<Long> = down

    /** Returns the raw JSON value of [yardsToGo]. */
    @JsonProperty("yardsToGo") @ExcludeMissing fun _yardsToGo(): JsonField<Long> = yardsToGo

    /** Returns the raw JSON value of [yardline]. */
    @JsonProperty("yardline") @ExcludeMissing fun _yardline(): JsonField<Long> = yardline

    /** Returns the raw JSON value of [yardlineSide]. */
    @JsonProperty("yardlineSide") @ExcludeMissing fun _yardlineSide(): JsonField<String> = yardlineSide

    /** Returns the raw JSON value of [possession]. */
    @JsonProperty("possession") @ExcludeMissing fun _possession(): JsonField<String> = possession

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

        /** Returns a mutable builder for constructing an instance of [FootballPlayStart]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballPlayStart]. */
    class Builder internal constructor() {

        private var down: JsonField<Long>? = null
        private var yardsToGo: JsonField<Long>? = null
        private var yardline: JsonField<Long>? = null
        private var yardlineSide: JsonField<String>? = null
        private var possession: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballPlayStart: FootballPlayStart) = apply {
            down = footballPlayStart.down
            yardsToGo = footballPlayStart.yardsToGo
            yardline = footballPlayStart.yardline
            yardlineSide = footballPlayStart.yardlineSide
            possession = footballPlayStart.possession
            additionalProperties = footballPlayStart.additionalProperties.toMutableMap()
        }

        /** The down, from 1 to 4. */
        fun down(down: Long?) = down(JsonField.ofNullable(down))

        fun down(down: Long) = down(down as Long?)

        fun down(down: Optional<Long>) = down(down.getOrNull())

        /** Sets [Builder.down] to an arbitrary JSON value. */
        fun down(down: JsonField<Long>) = apply { this.down = down }

        /** The yards needed for a first down. */
        fun yardsToGo(yardsToGo: Long?) = yardsToGo(JsonField.ofNullable(yardsToGo))

        fun yardsToGo(yardsToGo: Long) = yardsToGo(yardsToGo as Long?)

        fun yardsToGo(yardsToGo: Optional<Long>) = yardsToGo(yardsToGo.getOrNull())

        /** Sets [Builder.yardsToGo] to an arbitrary JSON value. */
        fun yardsToGo(yardsToGo: JsonField<Long>) = apply { this.yardsToGo = yardsToGo }

        /** The yard line of the ball. */
        fun yardline(yardline: Long?) = yardline(JsonField.ofNullable(yardline))

        fun yardline(yardline: Long) = yardline(yardline as Long?)

        fun yardline(yardline: Optional<Long>) = yardline(yardline.getOrNull())

        /** Sets [Builder.yardline] to an arbitrary JSON value. */
        fun yardline(yardline: JsonField<Long>) = apply { this.yardline = yardline }

        /** Whose half the ball was in. Home or Away in NFL games, the team's alternateId in college games. */
        fun yardlineSide(yardlineSide: String?) = yardlineSide(JsonField.ofNullable(yardlineSide))

        fun yardlineSide(yardlineSide: Optional<String>) = yardlineSide(yardlineSide.getOrNull())

        /** Sets [Builder.yardlineSide] to an arbitrary JSON value. */
        fun yardlineSide(yardlineSide: JsonField<String>) = apply { this.yardlineSide = yardlineSide }

        /** The team with the ball. Home or Away in NFL games, the team's alternateId in college games. */
        fun possession(possession: String?) = possession(JsonField.ofNullable(possession))

        fun possession(possession: Optional<String>) = possession(possession.getOrNull())

        /** Sets [Builder.possession] to an arbitrary JSON value. */
        fun possession(possession: JsonField<String>) = apply { this.possession = possession }

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
         * Returns an immutable instance of [FootballPlayStart].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballPlayStart =
            FootballPlayStart(
                checkRequired("down", down),
                checkRequired("yardsToGo", yardsToGo),
                checkRequired("yardline", yardline),
                checkRequired("yardlineSide", yardlineSide),
                checkRequired("possession", possession),
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
    fun validate(): FootballPlayStart = apply {
        if (validated) {
            return@apply
        }

        down()
        yardsToGo()
        yardline()
        yardlineSide()
        possession()
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
        (if (down.asKnown().isPresent) 1 else 0) +
            (if (yardsToGo.asKnown().isPresent) 1 else 0) +
            (if (yardline.asKnown().isPresent) 1 else 0) +
            (if (yardlineSide.asKnown().isPresent) 1 else 0) +
            (if (possession.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballPlayStart &&
            down == other.down &&
            yardsToGo == other.yardsToGo &&
            yardline == other.yardline &&
            yardlineSide == other.yardlineSide &&
            possession == other.possession &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(down, yardsToGo, yardline, yardlineSide, possession, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballPlayStart{down=$down, yardsToGo=$yardsToGo, yardline=$yardline, yardlineSide=$yardlineSide, possession=$possession, additionalProperties=$additionalProperties}"
}
