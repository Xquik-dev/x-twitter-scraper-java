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
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** 1 team's roster. */
class FootballRosterTeam
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val teamId: JsonField<String>,
    private val playerIds: JsonField<List<String>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("teamId") @ExcludeMissing teamId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("playerIds")
        @ExcludeMissing
        playerIds: JsonField<List<String>> = JsonMissing.of(),
    ) : this(teamId, playerIds, mutableMapOf())

    /** The team this roster belongs to, a key of teams. */
    fun teamId(): String = teamId.getRequired("teamId")

    /** The team's players in X's order, keys of players. */
    fun playerIds(): List<String> = playerIds.getRequired("playerIds")

    /** Returns the raw JSON value of [teamId]. */
    @JsonProperty("teamId") @ExcludeMissing fun _teamId(): JsonField<String> = teamId

    /** Returns the raw JSON value of [playerIds]. */
    @JsonProperty("playerIds") @ExcludeMissing fun _playerIds(): JsonField<List<String>> = playerIds

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

        /** Returns a mutable builder for constructing an instance of [FootballRosterTeam]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballRosterTeam]. */
    class Builder internal constructor() {

        private var teamId: JsonField<String>? = null
        private var playerIds: JsonField<MutableList<String>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(footballRosterTeam: FootballRosterTeam) = apply {
            teamId = footballRosterTeam.teamId
            playerIds = footballRosterTeam.playerIds.map { it.toMutableList() }
            additionalProperties = footballRosterTeam.additionalProperties.toMutableMap()
        }

        /** The team this roster belongs to, a key of teams. */
        fun teamId(teamId: String) = teamId(JsonField.of(teamId))

        /** Sets [Builder.teamId] to an arbitrary JSON value. */
        fun teamId(teamId: JsonField<String>) = apply { this.teamId = teamId }

        /** The team's players in X's order, keys of players. */
        fun playerIds(playerIds: List<String>) = playerIds(JsonField.of(playerIds))

        /** Sets [Builder.playerIds] to an arbitrary JSON value. */
        fun playerIds(playerIds: JsonField<List<String>>) = apply {
            this.playerIds = playerIds.map { it.toMutableList() }
        }

        /** Adds a single [String] to [playerIds]. */
        fun addPlayerId(playerId: String) = apply {
            playerIds =
                (playerIds ?: JsonField.of(mutableListOf())).also {
                    checkKnown("playerIds", it).add(playerId)
                }
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
         * Returns an immutable instance of [FootballRosterTeam].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballRosterTeam =
            FootballRosterTeam(
                checkRequired("teamId", teamId),
                checkRequired("playerIds", playerIds).map { it.toImmutable() },
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
    fun validate(): FootballRosterTeam = apply {
        if (validated) {
            return@apply
        }

        teamId()
        playerIds()
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
        (if (teamId.asKnown().isPresent) 1 else 0) + (playerIds.asKnown().getOrNull()?.size ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballRosterTeam &&
            teamId == other.teamId &&
            playerIds == other.playerIds &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(teamId, playerIds, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballRosterTeam{teamId=$teamId, playerIds=$playerIds, additionalProperties=$additionalProperties}"
}
