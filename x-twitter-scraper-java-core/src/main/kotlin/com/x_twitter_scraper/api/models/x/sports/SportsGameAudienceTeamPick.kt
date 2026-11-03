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

class SportsGameAudienceTeamPick
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val teamId: JsonField<String>,
    private val count: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("teamId") @ExcludeMissing teamId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("count") @ExcludeMissing count: JsonField<Long> = JsonMissing.of(),
    ) : this(teamId, count, mutableMapOf())

    /** The team ID, a key in teams. */
    fun teamId(): String = teamId.getRequired("teamId")

    /** How many people picked this team. */
    fun count(): Optional<Long> = count.getOptional("count")

    /** Returns the raw JSON value of [teamId]. */
    @JsonProperty("teamId") @ExcludeMissing fun _teamId(): JsonField<String> = teamId

    /** Returns the raw JSON value of [count]. */
    @JsonProperty("count") @ExcludeMissing fun _count(): JsonField<Long> = count

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

        /** Returns a mutable builder for constructing an instance of [SportsGameAudienceTeamPick]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SportsGameAudienceTeamPick]. */
    class Builder internal constructor() {

        private var teamId: JsonField<String>? = null
        private var count: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(sportsGameAudienceTeamPicksTeams: SportsGameAudienceTeamPick) = apply {
            teamId = sportsGameAudienceTeamPicksTeams.teamId
            count = sportsGameAudienceTeamPicksTeams.count
            additionalProperties = sportsGameAudienceTeamPicksTeams.additionalProperties.toMutableMap()
        }

        /** The team ID, a key in teams. */
        fun teamId(teamId: String) = teamId(JsonField.of(teamId))

        /** Sets [Builder.teamId] to an arbitrary JSON value. */
        fun teamId(teamId: JsonField<String>) = apply { this.teamId = teamId }

        /** How many people picked this team. */
        fun count(count: Long?) = count(JsonField.ofNullable(count))

        fun count(count: Long) = count(count as Long?)

        fun count(count: Optional<Long>) = count(count.getOrNull())

        /** Sets [Builder.count] to an arbitrary JSON value. */
        fun count(count: JsonField<Long>) = apply { this.count = count }

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
         * Returns an immutable instance of [SportsGameAudienceTeamPick].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SportsGameAudienceTeamPick =
            SportsGameAudienceTeamPick(
                checkRequired("teamId", teamId),
                checkRequired("count", count),
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
    fun validate(): SportsGameAudienceTeamPick = apply {
        if (validated) {
            return@apply
        }

        teamId()
        count()
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
        (if (teamId.asKnown().isPresent) 1 else 0) +
            (if (count.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SportsGameAudienceTeamPick &&
            teamId == other.teamId &&
            count == other.count &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(teamId, count, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SportsGameAudienceTeamPick{teamId=$teamId, count=$count, additionalProperties=$additionalProperties}"
}
