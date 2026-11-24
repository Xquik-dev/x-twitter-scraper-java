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

/** A team's rank in X's college football poll. */
class FootballPollRanking
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val teamId: JsonField<String>,
    private val rank: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("teamId") @ExcludeMissing teamId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("rank") @ExcludeMissing rank: JsonField<Long> = JsonMissing.of(),
    ) : this(teamId, rank, mutableMapOf())

    /** The ranked team, a key of teams. */
    fun teamId(): Optional<String> = teamId.getOptional("teamId")

    /** The team's rank, where 1 is the top. */
    fun rank(): Optional<Long> = rank.getOptional("rank")

    /** Returns the raw JSON value of [teamId]. */
    @JsonProperty("teamId") @ExcludeMissing fun _teamId(): JsonField<String> = teamId

    /** Returns the raw JSON value of [rank]. */
    @JsonProperty("rank") @ExcludeMissing fun _rank(): JsonField<Long> = rank

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
         * Returns a mutable builder for constructing an instance of [FootballPollRanking].
         *
         * The following fields are required:
         * ```java
         * .teamId()
         * .rank()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballPollRanking]. */
    class Builder internal constructor() {

        private var teamId: JsonField<String>? = null
        private var rank: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(footballPollRanking: FootballPollRanking) = apply {
            teamId = footballPollRanking.teamId
            rank = footballPollRanking.rank
            additionalProperties = footballPollRanking.additionalProperties.toMutableMap()
        }

        /** The ranked team, a key of teams. */
        fun teamId(teamId: String?) = teamId(JsonField.ofNullable(teamId))

        fun teamId(teamId: Optional<String>) = teamId(teamId.getOrNull())

        /** Sets [Builder.teamId] to an arbitrary JSON value. */
        fun teamId(teamId: JsonField<String>) = apply { this.teamId = teamId }

        /** The team's rank, where 1 is the top. */
        fun rank(rank: Long?) = rank(JsonField.ofNullable(rank))

        fun rank(rank: Long) = rank(rank as Long?)

        fun rank(rank: Optional<Long>) = rank(rank.getOrNull())

        /** Sets [Builder.rank] to an arbitrary JSON value. */
        fun rank(rank: JsonField<Long>) = apply { this.rank = rank }

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
         * Returns an immutable instance of [FootballPollRanking].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .teamId()
         * .rank()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballPollRanking =
            FootballPollRanking(
                checkRequired("teamId", teamId),
                checkRequired("rank", rank),
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
    fun validate(): FootballPollRanking = apply {
        if (validated) {
            return@apply
        }

        teamId()
        rank()
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
        (if (teamId.asKnown().isPresent) 1 else 0) + (if (rank.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballPollRanking &&
            teamId == other.teamId &&
            rank == other.rank &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(teamId, rank, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballPollRanking{teamId=$teamId, rank=$rank, additionalProperties=$additionalProperties}"
}
