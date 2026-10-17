// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.drafts

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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional

/** Full tweet draft including update timestamp. */
class DraftDetail
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val text: JsonField<String>,
    private val updatedAt: JsonField<OffsetDateTime>,
    private val goal: JsonField<String>,
    private val topic: JsonField<String>,
    private val ignoredFields: JsonField<List<String>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("createdAt")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        @JsonProperty("updatedAt")
        @ExcludeMissing
        updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("goal") @ExcludeMissing goal: JsonField<String> = JsonMissing.of(),
        @JsonProperty("topic") @ExcludeMissing topic: JsonField<String> = JsonMissing.of(),
        @JsonProperty("ignoredFields")
        @ExcludeMissing
        ignoredFields: JsonField<List<String>> = JsonMissing.of(),
    ) : this(
        id,
        createdAt,
        text,
        updatedAt,
        goal,
        topic,
        ignoredFields,
        mutableMapOf(),
    )

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun id(): String = id.getRequired("id")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun text(): String = text.getRequired("text")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun updatedAt(): OffsetDateTime = updatedAt.getRequired("updatedAt")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun goal(): Optional<String> = goal.getOptional("goal")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun topic(): Optional<String> = topic.getOptional("topic")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun ignoredFields(): Optional<List<String>> = ignoredFields.getOptional("ignoredFields")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("createdAt")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updatedAt")
    @ExcludeMissing
    fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

    /**
     * Returns the raw JSON value of [goal].
     *
     * Unlike [goal], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("goal") @ExcludeMissing fun _goal(): JsonField<String> = goal

    /**
     * Returns the raw JSON value of [topic].
     *
     * Unlike [topic], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("topic") @ExcludeMissing fun _topic(): JsonField<String> = topic

    /**
     * Returns the raw JSON value of [ignoredFields].
     *
     * Unlike [ignoredFields], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ignoredFields")
    @ExcludeMissing
    fun _ignoredFields(): JsonField<List<String>> = ignoredFields

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
         * Returns a mutable builder for constructing an instance of [DraftDetail].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .text()
         * .updatedAt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DraftDetail]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<OffsetDateTime>? = null
        private var text: JsonField<String>? = null
        private var updatedAt: JsonField<OffsetDateTime>? = null
        private var goal: JsonField<String> = JsonMissing.of()
        private var topic: JsonField<String> = JsonMissing.of()
        private var ignoredFields: JsonField<MutableList<String>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(draftDetail: DraftDetail) = apply {
            id = draftDetail.id
            createdAt = draftDetail.createdAt
            text = draftDetail.text
            updatedAt = draftDetail.updatedAt
            goal = draftDetail.goal
            topic = draftDetail.topic
            ignoredFields = draftDetail.ignoredFields.map { it.toMutableList() }
            additionalProperties = draftDetail.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /** Sets [Builder.id] to an arbitrary JSON value. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /** Sets [Builder.createdAt] to an arbitrary JSON value. */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        fun text(text: String) = text(JsonField.of(text))

        /** Sets [Builder.text] to an arbitrary JSON value. */
        fun text(text: JsonField<String>) = apply { this.text = text }

        fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

        /** Sets [Builder.updatedAt] to an arbitrary JSON value. */
        fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply { this.updatedAt = updatedAt }

        fun goal(goal: String) = goal(JsonField.of(goal))

        /** Sets [Builder.goal] to an arbitrary JSON value. */
        fun goal(goal: JsonField<String>) = apply { this.goal = goal }

        fun topic(topic: String) = topic(JsonField.of(topic))

        /** Sets [Builder.topic] to an arbitrary JSON value. */
        fun topic(topic: JsonField<String>) = apply { this.topic = topic }

        fun ignoredFields(ignoredFields: List<String>) = ignoredFields(JsonField.of(ignoredFields))

        /** Sets [Builder.ignoredFields] to an arbitrary JSON value. */
        fun ignoredFields(ignoredFields: JsonField<List<String>>) = apply {
            this.ignoredFields = ignoredFields.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [ignoredFields].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addIgnoredField(ignoredField: String) = apply {
            this.ignoredFields =
                (this.ignoredFields ?: JsonField.of(mutableListOf())).also {
                    checkKnown("ignoredFields", it).add(ignoredField)
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
         * Returns an immutable instance of [DraftDetail].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .text()
         * .updatedAt()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): DraftDetail =
            DraftDetail(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("text", text),
                checkRequired("updatedAt", updatedAt),
                goal,
                topic,
                (ignoredFields ?: JsonMissing.of()).map { it.toImmutable() },
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
    fun validate(): DraftDetail = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        text()
        updatedAt()
        goal()
        topic()
        ignoredFields()
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (text.asKnown().isPresent) 1 else 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0) +
            (if (goal.asKnown().isPresent) 1 else 0) +
            (if (topic.asKnown().isPresent) 1 else 0) +
            (if (ignoredFields.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DraftDetail &&
            id == other.id &&
            createdAt == other.createdAt &&
            text == other.text &&
            updatedAt == other.updatedAt &&
            goal == other.goal &&
            topic == other.topic &&
            ignoredFields == other.ignoredFields &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            createdAt,
            text,
            updatedAt,
            goal,
            topic,
            ignoredFields,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DraftDetail{id=$id, createdAt=$createdAt, text=$text, updatedAt=$updatedAt, goal=$goal, topic=$topic, ignoredFields=$ignoredFields, additionalProperties=$additionalProperties}"
}
