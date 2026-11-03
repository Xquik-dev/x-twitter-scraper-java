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

/** The game's live chat on X. */
class SportsGameAudienceChat
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val available: JsonField<Boolean>,
    private val broadcastId: JsonField<String>,
    private val opensIn: JsonField<SportsGameAudienceChatOpensIn>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("available") @ExcludeMissing available: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("broadcastId") @ExcludeMissing broadcastId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("opensIn") @ExcludeMissing opensIn: JsonField<SportsGameAudienceChatOpensIn> = JsonMissing.of(),
    ) : this(available, broadcastId, opensIn, mutableMapOf())

    /** Whether the chat is open now. */
    fun available(): Optional<Boolean> = available.getOptional("available")

    /** X's ID for the game's chat room. */
    fun broadcastId(): Optional<String> = broadcastId.getOptional("broadcastId")

    /** Time left until the chat opens. Null while it is open & after the game. */
    fun opensIn(): Optional<SportsGameAudienceChatOpensIn> = opensIn.getOptional("opensIn")

    /** Returns the raw JSON value of [available]. */
    @JsonProperty("available") @ExcludeMissing fun _available(): JsonField<Boolean> = available

    /** Returns the raw JSON value of [broadcastId]. */
    @JsonProperty("broadcastId") @ExcludeMissing fun _broadcastId(): JsonField<String> = broadcastId

    /** Returns the raw JSON value of [opensIn]. */
    @JsonProperty("opensIn") @ExcludeMissing fun _opensIn(): JsonField<SportsGameAudienceChatOpensIn> = opensIn

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

        /** Returns a mutable builder for constructing an instance of [SportsGameAudienceChat]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SportsGameAudienceChat]. */
    class Builder internal constructor() {

        private var available: JsonField<Boolean>? = null
        private var broadcastId: JsonField<String>? = null
        private var opensIn: JsonField<SportsGameAudienceChatOpensIn>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(sportsGameAudienceChat: SportsGameAudienceChat) = apply {
            available = sportsGameAudienceChat.available
            broadcastId = sportsGameAudienceChat.broadcastId
            opensIn = sportsGameAudienceChat.opensIn
            additionalProperties = sportsGameAudienceChat.additionalProperties.toMutableMap()
        }

        /** Whether the chat is open now. */
        fun available(available: Boolean?) = available(JsonField.ofNullable(available))

        fun available(available: Boolean) = available(available as Boolean?)

        fun available(available: Optional<Boolean>) = available(available.getOrNull())

        /** Sets [Builder.available] to an arbitrary JSON value. */
        fun available(available: JsonField<Boolean>) = apply { this.available = available }

        /** X's ID for the game's chat room. */
        fun broadcastId(broadcastId: String?) = broadcastId(JsonField.ofNullable(broadcastId))

        fun broadcastId(broadcastId: Optional<String>) = broadcastId(broadcastId.getOrNull())

        /** Sets [Builder.broadcastId] to an arbitrary JSON value. */
        fun broadcastId(broadcastId: JsonField<String>) = apply { this.broadcastId = broadcastId }

        /** Time left until the chat opens. Null while it is open & after the game. */
        fun opensIn(opensIn: SportsGameAudienceChatOpensIn?) = opensIn(JsonField.ofNullable(opensIn))

        fun opensIn(opensIn: Optional<SportsGameAudienceChatOpensIn>) = opensIn(opensIn.getOrNull())

        /** Sets [Builder.opensIn] to an arbitrary JSON value. */
        fun opensIn(opensIn: JsonField<SportsGameAudienceChatOpensIn>) = apply { this.opensIn = opensIn }

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
         * Returns an immutable instance of [SportsGameAudienceChat].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SportsGameAudienceChat =
            SportsGameAudienceChat(
                checkRequired("available", available),
                checkRequired("broadcastId", broadcastId),
                checkRequired("opensIn", opensIn),
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
    fun validate(): SportsGameAudienceChat = apply {
        if (validated) {
            return@apply
        }

        available()
        broadcastId()
        opensIn().ifPresent { it.validate() }
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
        (if (available.asKnown().isPresent) 1 else 0) +
            (if (broadcastId.asKnown().isPresent) 1 else 0) +
            (opensIn.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SportsGameAudienceChat &&
            available == other.available &&
            broadcastId == other.broadcastId &&
            opensIn == other.opensIn &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(available, broadcastId, opensIn, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SportsGameAudienceChat{available=$available, broadcastId=$broadcastId, opensIn=$opensIn, additionalProperties=$additionalProperties}"
}
