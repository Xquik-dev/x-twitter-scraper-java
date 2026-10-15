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
import com.x_twitter_scraper.api.models.CommunityTopic
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class CommunityListTopicsResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val count: JsonField<Long>,
    private val topics: JsonField<List<CommunityTopic>>,
    private val message: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("count") @ExcludeMissing count: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("topics")
        @ExcludeMissing
        topics: JsonField<List<CommunityTopic>> = JsonMissing.of(),
        @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
    ) : this(count, topics, message, mutableMapOf())

    /**
     * Top-level topics returned & charged
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun count(): Long = count.getRequired("count")

    /**
     * Topics in X's order
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun topics(): List<CommunityTopic> = topics.getRequired("topics")

    /**
     * What to do next. Present only when X lists no topic.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun message(): Optional<String> = message.getOptional("message")

    /**
     * Returns the raw JSON value of [count].
     *
     * Unlike [count], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("count") @ExcludeMissing fun _count(): JsonField<Long> = count

    /**
     * Returns the raw JSON value of [topics].
     *
     * Unlike [topics], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("topics") @ExcludeMissing fun _topics(): JsonField<List<CommunityTopic>> = topics

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
         * Returns a mutable builder for constructing an instance of [CommunityListTopicsResponse].
         *
         * The following fields are required:
         * ```java
         * .count()
         * .topics()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CommunityListTopicsResponse]. */
    class Builder internal constructor() {

        private var count: JsonField<Long>? = null
        private var topics: JsonField<MutableList<CommunityTopic>>? = null
        private var message: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(communityListTopicsResponse: CommunityListTopicsResponse) = apply {
            count = communityListTopicsResponse.count
            topics = communityListTopicsResponse.topics.map { it.toMutableList() }
            message = communityListTopicsResponse.message
            additionalProperties = communityListTopicsResponse.additionalProperties.toMutableMap()
        }

        /** Top-level topics returned & charged */
        fun count(count: Long) = count(JsonField.of(count))

        /** Sets [Builder.count] to an arbitrary JSON value. */
        fun count(count: JsonField<Long>) = apply { this.count = count }

        /** Topics in X's order */
        fun topics(topics: List<CommunityTopic>) = topics(JsonField.of(topics))

        /** Sets [Builder.topics] to an arbitrary JSON value. */
        fun topics(topics: JsonField<List<CommunityTopic>>) = apply {
            this.topics = topics.map { it.toMutableList() }
        }

        /**
         * Adds a single [CommunityTopic] to [topics].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTopic(topic: CommunityTopic) = apply {
            topics =
                (topics ?: JsonField.of(mutableListOf())).also {
                    checkKnown("topics", it).add(topic)
                }
        }

        /** What to do next. Present only when X lists no topic. */
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
         * Returns an immutable instance of [CommunityListTopicsResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .count()
         * .topics()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CommunityListTopicsResponse =
            CommunityListTopicsResponse(
                checkRequired("count", count),
                checkRequired("topics", topics).map { it.toImmutable() },
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
    fun validate(): CommunityListTopicsResponse = apply {
        if (validated) {
            return@apply
        }

        count()
        topics().forEach { it.validate() }
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
        (if (count.asKnown().isPresent) 1 else 0) +
            (topics.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (if (message.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CommunityListTopicsResponse &&
            count == other.count &&
            topics == other.topics &&
            message == other.message &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(count, topics, message, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CommunityListTopicsResponse{count=$count, topics=$topics, message=$message, additionalProperties=$additionalProperties}"
}
