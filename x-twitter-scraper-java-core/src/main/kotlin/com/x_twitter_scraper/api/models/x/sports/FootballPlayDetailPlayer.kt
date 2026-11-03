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

class FootballPlayDetailPlayer
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val playerId: JsonField<String>,
    private val playerRole: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("playerId") @ExcludeMissing playerId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("playerRole") @ExcludeMissing playerRole: JsonField<String> = JsonMissing.of(),
    ) : this(playerId, playerRole, mutableMapOf())

    /** The player, a key of players. */
    fun playerId(): Optional<String> = playerId.getOptional("playerId")

    /** The player's role, such as Pass, Receive or Tackle. */
    fun playerRole(): Optional<String> = playerRole.getOptional("playerRole")

    /** Returns the raw JSON value of [playerId]. */
    @JsonProperty("playerId") @ExcludeMissing fun _playerId(): JsonField<String> = playerId

    /** Returns the raw JSON value of [playerRole]. */
    @JsonProperty("playerRole") @ExcludeMissing fun _playerRole(): JsonField<String> = playerRole

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

        /** Returns a mutable builder for constructing an instance of [FootballPlayDetailPlayer]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballPlayDetailPlayer]. */
    class Builder internal constructor() {

        private var playerId: JsonField<String>? = null
        private var playerRole: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballPlayDetailPlayer: FootballPlayDetailPlayer) = apply {
            playerId = footballPlayDetailPlayer.playerId
            playerRole = footballPlayDetailPlayer.playerRole
            additionalProperties = footballPlayDetailPlayer.additionalProperties.toMutableMap()
        }

        /** The player, a key of players. */
        fun playerId(playerId: String?) = playerId(JsonField.ofNullable(playerId))

        fun playerId(playerId: Optional<String>) = playerId(playerId.getOrNull())

        /** Sets [Builder.playerId] to an arbitrary JSON value. */
        fun playerId(playerId: JsonField<String>) = apply { this.playerId = playerId }

        /** The player's role, such as Pass, Receive or Tackle. */
        fun playerRole(playerRole: String?) = playerRole(JsonField.ofNullable(playerRole))

        fun playerRole(playerRole: Optional<String>) = playerRole(playerRole.getOrNull())

        /** Sets [Builder.playerRole] to an arbitrary JSON value. */
        fun playerRole(playerRole: JsonField<String>) = apply { this.playerRole = playerRole }

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
         * Returns an immutable instance of [FootballPlayDetailPlayer].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballPlayDetailPlayer =
            FootballPlayDetailPlayer(
                checkRequired("playerId", playerId),
                checkRequired("playerRole", playerRole),
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
    fun validate(): FootballPlayDetailPlayer = apply {
        if (validated) {
            return@apply
        }

        playerId()
        playerRole()
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
        (if (playerId.asKnown().isPresent) 1 else 0) +
            (if (playerRole.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballPlayDetailPlayer &&
            playerId == other.playerId &&
            playerRole == other.playerRole &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(playerId, playerRole, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballPlayDetailPlayer{playerId=$playerId, playerRole=$playerRole, additionalProperties=$additionalProperties}"
}
