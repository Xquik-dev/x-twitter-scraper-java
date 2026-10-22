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

/** Fumble stats. */
class FootballFumbleStats
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val lost: JsonField<Long>,
    private val opponentRecoveryTouchdowns: JsonField<Long>,
    private val ownRecoveryTouchdowns: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("lost") @ExcludeMissing lost: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("opponentRecoveryTouchdowns") @ExcludeMissing opponentRecoveryTouchdowns: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("ownRecoveryTouchdowns") @ExcludeMissing ownRecoveryTouchdowns: JsonField<Long> = JsonMissing.of(),
    ) : this(lost, opponentRecoveryTouchdowns, ownRecoveryTouchdowns, mutableMapOf())

    /** Fumbles the other team recovered. */
    fun lost(): Optional<Long> = lost.getOptional("lost")

    /** Touchdowns scored after recovering the other team's fumble. */
    fun opponentRecoveryTouchdowns(): Optional<Long> = opponentRecoveryTouchdowns.getOptional("opponentRecoveryTouchdowns")

    /** Touchdowns scored after recovering an own fumble. */
    fun ownRecoveryTouchdowns(): Optional<Long> = ownRecoveryTouchdowns.getOptional("ownRecoveryTouchdowns")

    /** Returns the raw JSON value of [lost]. */
    @JsonProperty("lost") @ExcludeMissing fun _lost(): JsonField<Long> = lost

    /** Returns the raw JSON value of [opponentRecoveryTouchdowns]. */
    @JsonProperty("opponentRecoveryTouchdowns") @ExcludeMissing fun _opponentRecoveryTouchdowns(): JsonField<Long> = opponentRecoveryTouchdowns

    /** Returns the raw JSON value of [ownRecoveryTouchdowns]. */
    @JsonProperty("ownRecoveryTouchdowns") @ExcludeMissing fun _ownRecoveryTouchdowns(): JsonField<Long> = ownRecoveryTouchdowns

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

        /** Returns a mutable builder for constructing an instance of [FootballFumbleStats]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballFumbleStats]. */
    class Builder internal constructor() {

        private var lost: JsonField<Long>? = null
        private var opponentRecoveryTouchdowns: JsonField<Long>? = null
        private var ownRecoveryTouchdowns: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballFumbleStats: FootballFumbleStats) = apply {
            lost = footballFumbleStats.lost
            opponentRecoveryTouchdowns = footballFumbleStats.opponentRecoveryTouchdowns
            ownRecoveryTouchdowns = footballFumbleStats.ownRecoveryTouchdowns
            additionalProperties = footballFumbleStats.additionalProperties.toMutableMap()
        }

        /** Fumbles the other team recovered. */
        fun lost(lost: Long?) = lost(JsonField.ofNullable(lost))

        fun lost(lost: Long) = lost(lost as Long?)

        fun lost(lost: Optional<Long>) = lost(lost.getOrNull())

        /** Sets [Builder.lost] to an arbitrary JSON value. */
        fun lost(lost: JsonField<Long>) = apply { this.lost = lost }

        /** Touchdowns scored after recovering the other team's fumble. */
        fun opponentRecoveryTouchdowns(opponentRecoveryTouchdowns: Long?) = opponentRecoveryTouchdowns(JsonField.ofNullable(opponentRecoveryTouchdowns))

        fun opponentRecoveryTouchdowns(opponentRecoveryTouchdowns: Long) = opponentRecoveryTouchdowns(opponentRecoveryTouchdowns as Long?)

        fun opponentRecoveryTouchdowns(opponentRecoveryTouchdowns: Optional<Long>) = opponentRecoveryTouchdowns(opponentRecoveryTouchdowns.getOrNull())

        /** Sets [Builder.opponentRecoveryTouchdowns] to an arbitrary JSON value. */
        fun opponentRecoveryTouchdowns(opponentRecoveryTouchdowns: JsonField<Long>) = apply { this.opponentRecoveryTouchdowns = opponentRecoveryTouchdowns }

        /** Touchdowns scored after recovering an own fumble. */
        fun ownRecoveryTouchdowns(ownRecoveryTouchdowns: Long?) = ownRecoveryTouchdowns(JsonField.ofNullable(ownRecoveryTouchdowns))

        fun ownRecoveryTouchdowns(ownRecoveryTouchdowns: Long) = ownRecoveryTouchdowns(ownRecoveryTouchdowns as Long?)

        fun ownRecoveryTouchdowns(ownRecoveryTouchdowns: Optional<Long>) = ownRecoveryTouchdowns(ownRecoveryTouchdowns.getOrNull())

        /** Sets [Builder.ownRecoveryTouchdowns] to an arbitrary JSON value. */
        fun ownRecoveryTouchdowns(ownRecoveryTouchdowns: JsonField<Long>) = apply { this.ownRecoveryTouchdowns = ownRecoveryTouchdowns }

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
         * Returns an immutable instance of [FootballFumbleStats].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballFumbleStats =
            FootballFumbleStats(
                checkRequired("lost", lost),
                checkRequired("opponentRecoveryTouchdowns", opponentRecoveryTouchdowns),
                checkRequired("ownRecoveryTouchdowns", ownRecoveryTouchdowns),
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
    fun validate(): FootballFumbleStats = apply {
        if (validated) {
            return@apply
        }

        lost()
        opponentRecoveryTouchdowns()
        ownRecoveryTouchdowns()
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
        (if (lost.asKnown().isPresent) 1 else 0) +
            (if (opponentRecoveryTouchdowns.asKnown().isPresent) 1 else 0) +
            (if (ownRecoveryTouchdowns.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballFumbleStats &&
            lost == other.lost &&
            opponentRecoveryTouchdowns == other.opponentRecoveryTouchdowns &&
            ownRecoveryTouchdowns == other.ownRecoveryTouchdowns &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(lost, opponentRecoveryTouchdowns, ownRecoveryTouchdowns, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballFumbleStats{lost=$lost, opponentRecoveryTouchdowns=$opponentRecoveryTouchdowns, ownRecoveryTouchdowns=$ownRecoveryTouchdowns, additionalProperties=$additionalProperties}"
}
