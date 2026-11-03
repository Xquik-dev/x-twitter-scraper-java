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
import kotlin.jvm.optionals.getOrNull

/** Betting odds for each team, or null when X has none. */
class FootballScheduleGameOdds
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val home: JsonField<FootballOdds>,
    private val away: JsonField<FootballOdds>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("home") @ExcludeMissing home: JsonField<FootballOdds> = JsonMissing.of(),
        @JsonProperty("away") @ExcludeMissing away: JsonField<FootballOdds> = JsonMissing.of(),
    ) : this(home, away, mutableMapOf())

    /** Betting odds titles for 1 team, as X shows them. */
    fun home(): FootballOdds = home.getRequired("home")

    /** Betting odds titles for 1 team, as X shows them. */
    fun away(): FootballOdds = away.getRequired("away")

    /** Returns the raw JSON value of [home]. */
    @JsonProperty("home") @ExcludeMissing fun _home(): JsonField<FootballOdds> = home

    /** Returns the raw JSON value of [away]. */
    @JsonProperty("away") @ExcludeMissing fun _away(): JsonField<FootballOdds> = away

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

        /** Returns a mutable builder for constructing an instance of [FootballScheduleGameOdds]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballScheduleGameOdds]. */
    class Builder internal constructor() {

        private var home: JsonField<FootballOdds>? = null
        private var away: JsonField<FootballOdds>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballScheduleGameOdds: FootballScheduleGameOdds) = apply {
            home = footballScheduleGameOdds.home
            away = footballScheduleGameOdds.away
            additionalProperties = footballScheduleGameOdds.additionalProperties.toMutableMap()
        }

        /** Betting odds titles for 1 team, as X shows them. */
        fun home(home: FootballOdds) = home(JsonField.of(home))

        /** Sets [Builder.home] to an arbitrary JSON value. */
        fun home(home: JsonField<FootballOdds>) = apply { this.home = home }

        /** Betting odds titles for 1 team, as X shows them. */
        fun away(away: FootballOdds) = away(JsonField.of(away))

        /** Sets [Builder.away] to an arbitrary JSON value. */
        fun away(away: JsonField<FootballOdds>) = apply { this.away = away }

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
         * Returns an immutable instance of [FootballScheduleGameOdds].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballScheduleGameOdds =
            FootballScheduleGameOdds(
                checkRequired("home", home),
                checkRequired("away", away),
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
    fun validate(): FootballScheduleGameOdds = apply {
        if (validated) {
            return@apply
        }

        home().validate()
        away().validate()
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
        (home.asKnown().getOrNull()?.validity() ?: 0) +
            (away.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballScheduleGameOdds &&
            home == other.home &&
            away == other.away &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(home, away, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballScheduleGameOdds{home=$home, away=$away, additionalProperties=$additionalProperties}"
}
