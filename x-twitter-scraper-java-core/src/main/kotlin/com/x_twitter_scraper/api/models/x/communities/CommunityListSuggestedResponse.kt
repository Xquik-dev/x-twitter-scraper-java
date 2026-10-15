// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.communities

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
import com.x_twitter_scraper.api.models.Community
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class CommunityListSuggestedResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val communities: JsonField<List<Community>>,
    private val count: JsonField<Long>,
    private val message: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("communities")
        @ExcludeMissing
        communities: JsonField<List<Community>> = JsonMissing.of(),
        @JsonProperty("count") @ExcludeMissing count: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
    ) : this(communities, count, message, mutableMapOf())

    /**
     * Suggested communities in X's order
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun communities(): List<Community> = communities.getRequired("communities")

    /**
     * Communities returned & charged
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun count(): Long = count.getRequired("count")

    /**
     * What to do next. Present only when X suggests none.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun message(): Optional<String> = message.getOptional("message")

    /**
     * Returns the raw JSON value of [communities].
     *
     * Unlike [communities], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("communities")
    @ExcludeMissing
    fun _communities(): JsonField<List<Community>> = communities

    /**
     * Returns the raw JSON value of [count].
     *
     * Unlike [count], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("count") @ExcludeMissing fun _count(): JsonField<Long> = count

    /**
     * Returns the raw JSON value of [message].
     *
     * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

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
         * Returns a mutable builder for constructing an instance of
         * [CommunityListSuggestedResponse].
         *
         * The following fields are required:
         * ```java
         * .communities()
         * .count()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CommunityListSuggestedResponse]. */
    class Builder internal constructor() {

        private var communities: JsonField<MutableList<Community>>? = null
        private var count: JsonField<Long>? = null
        private var message: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(communityListSuggestedResponse: CommunityListSuggestedResponse) = apply {
            communities = communityListSuggestedResponse.communities.map { it.toMutableList() }
            count = communityListSuggestedResponse.count
            message = communityListSuggestedResponse.message
            additionalProperties =
                communityListSuggestedResponse.additionalProperties.toMutableMap()
        }

        /** Suggested communities in X's order */
        fun communities(communities: List<Community>) = communities(JsonField.of(communities))

        /** Sets [Builder.communities] to an arbitrary JSON value. */
        fun communities(communities: JsonField<List<Community>>) = apply {
            this.communities = communities.map { it.toMutableList() }
        }

        /**
         * Adds a single [Community] to [communities].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addCommunity(community: Community) = apply {
            communities =
                (communities ?: JsonField.of(mutableListOf())).also {
                    checkKnown("communities", it).add(community)
                }
        }

        /** Communities returned & charged */
        fun count(count: Long) = count(JsonField.of(count))

        /** Sets [Builder.count] to an arbitrary JSON value. */
        fun count(count: JsonField<Long>) = apply { this.count = count }

        /** What to do next. Present only when X suggests none. */
        fun message(message: String) = message(JsonField.of(message))

        /** Sets [Builder.message] to an arbitrary JSON value. */
        fun message(message: JsonField<String>) = apply { this.message = message }

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
         * Returns an immutable instance of [CommunityListSuggestedResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .communities()
         * .count()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CommunityListSuggestedResponse =
            CommunityListSuggestedResponse(
                checkRequired("communities", communities).map { it.toImmutable() },
                checkRequired("count", count),
                message,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match
     *   its expected type.
     */
    fun validate(): CommunityListSuggestedResponse = apply {
        if (validated) {
            return@apply
        }

        communities().forEach { it.validate() }
        count()
        message()
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
        (communities.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (if (count.asKnown().isPresent) 1 else 0) +
            (if (message.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CommunityListSuggestedResponse &&
            communities == other.communities &&
            count == other.count &&
            message == other.message &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(communities, count, message, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CommunityListSuggestedResponse{communities=$communities, count=$count, message=$message, additionalProperties=$additionalProperties}"
}
