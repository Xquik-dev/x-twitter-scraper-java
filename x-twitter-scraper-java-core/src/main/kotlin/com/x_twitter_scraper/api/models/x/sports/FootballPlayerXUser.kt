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

/** The player's X account, or null without one. */
class FootballPlayerXUser
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val username: JsonField<String>,
    private val blueVerified: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("username") @ExcludeMissing username: JsonField<String> = JsonMissing.of(),
        @JsonProperty("blueVerified") @ExcludeMissing blueVerified: JsonField<Boolean> = JsonMissing.of(),
    ) : this(id, username, blueVerified, mutableMapOf())

    /** The account's user ID. */
    fun id(): String = id.getRequired("id")

    /** The account's username, without @. */
    fun username(): Optional<String> = username.getOptional("username")

    /** Whether the account has a blue check. */
    fun blueVerified(): Optional<Boolean> = blueVerified.getOptional("blueVerified")

    /** Returns the raw JSON value of [id]. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** Returns the raw JSON value of [username]. */
    @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username

    /** Returns the raw JSON value of [blueVerified]. */
    @JsonProperty("blueVerified") @ExcludeMissing fun _blueVerified(): JsonField<Boolean> = blueVerified

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

        /** Returns a mutable builder for constructing an instance of [FootballPlayerXUser]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballPlayerXUser]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var username: JsonField<String>? = null
        private var blueVerified: JsonField<Boolean>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballPlayerXUser: FootballPlayerXUser) = apply {
            id = footballPlayerXUser.id
            username = footballPlayerXUser.username
            blueVerified = footballPlayerXUser.blueVerified
            additionalProperties = footballPlayerXUser.additionalProperties.toMutableMap()
        }

        /** The account's user ID. */
        fun id(id: String) = id(JsonField.of(id))

        /** Sets [Builder.id] to an arbitrary JSON value. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The account's username, without @. */
        fun username(username: String?) = username(JsonField.ofNullable(username))

        fun username(username: Optional<String>) = username(username.getOrNull())

        /** Sets [Builder.username] to an arbitrary JSON value. */
        fun username(username: JsonField<String>) = apply { this.username = username }

        /** Whether the account has a blue check. */
        fun blueVerified(blueVerified: Boolean?) = blueVerified(JsonField.ofNullable(blueVerified))

        fun blueVerified(blueVerified: Boolean) = blueVerified(blueVerified as Boolean?)

        fun blueVerified(blueVerified: Optional<Boolean>) = blueVerified(blueVerified.getOrNull())

        /** Sets [Builder.blueVerified] to an arbitrary JSON value. */
        fun blueVerified(blueVerified: JsonField<Boolean>) = apply { this.blueVerified = blueVerified }

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
         * Returns an immutable instance of [FootballPlayerXUser].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballPlayerXUser =
            FootballPlayerXUser(
                checkRequired("id", id),
                checkRequired("username", username),
                checkRequired("blueVerified", blueVerified),
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
    fun validate(): FootballPlayerXUser = apply {
        if (validated) {
            return@apply
        }

        id()
        username()
        blueVerified()
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (username.asKnown().isPresent) 1 else 0) +
            (if (blueVerified.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballPlayerXUser &&
            id == other.id &&
            username == other.username &&
            blueVerified == other.blueVerified &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(id, username, blueVerified, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballPlayerXUser{id=$id, username=$username, blueVerified=$blueVerified, additionalProperties=$additionalProperties}"
}
