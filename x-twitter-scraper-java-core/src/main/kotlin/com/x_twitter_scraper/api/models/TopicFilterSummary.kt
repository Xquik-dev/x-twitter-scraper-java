// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models

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

/** What the topic filter asked & how many posts it kept. */
class TopicFilterSummary
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val topic: JsonField<String>,
    private val question: JsonField<String>,
    private val cutoff: JsonField<Double>,
    private val checked: JsonField<Long>,
    private val kept: JsonField<Long>,
    private val unchecked: JsonField<List<Unchecked>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("topic") @ExcludeMissing topic: JsonField<String> = JsonMissing.of(),
        @JsonProperty("question") @ExcludeMissing question: JsonField<String> = JsonMissing.of(),
        @JsonProperty("cutoff") @ExcludeMissing cutoff: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("checked") @ExcludeMissing checked: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("kept") @ExcludeMissing kept: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("unchecked")
        @ExcludeMissing
        unchecked: JsonField<List<Unchecked>> = JsonMissing.of(),
    ) : this(topic, question, cutoff, checked, kept, unchecked, mutableMapOf())

    /**
     * The topic you sent.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun topic(): String = topic.getRequired("topic")

    /**
     * The question asked of each post.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun question(): String = question.getRequired("question")

    /**
     * The lowest topicScore a kept post has.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun cutoff(): Double = cutoff.getRequired("cutoff")

    /**
     * Posts checked. Only kept posts are billed.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun checked(): Long = checked.getRequired("checked")

    /**
     * Posts about the topic, all returned & billed at 2 credits each.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun kept(): Long = kept.getRequired("kept")

    /**
     * Posts the check couldn't answer. They aren't billed or returned.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun unchecked(): List<Unchecked> = unchecked.getRequired("unchecked")

    /**
     * Returns the raw JSON value of [topic].
     *
     * Unlike [topic], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("topic") @ExcludeMissing fun _topic(): JsonField<String> = topic

    /**
     * Returns the raw JSON value of [question].
     *
     * Unlike [question], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("question") @ExcludeMissing fun _question(): JsonField<String> = question

    /**
     * Returns the raw JSON value of [cutoff].
     *
     * Unlike [cutoff], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("cutoff") @ExcludeMissing fun _cutoff(): JsonField<Double> = cutoff

    /**
     * Returns the raw JSON value of [checked].
     *
     * Unlike [checked], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("checked") @ExcludeMissing fun _checked(): JsonField<Long> = checked

    /**
     * Returns the raw JSON value of [kept].
     *
     * Unlike [kept], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("kept") @ExcludeMissing fun _kept(): JsonField<Long> = kept

    /**
     * Returns the raw JSON value of [unchecked].
     *
     * Unlike [unchecked], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("unchecked")
    @ExcludeMissing
    fun _unchecked(): JsonField<List<Unchecked>> = unchecked

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
         * Returns a mutable builder for constructing an instance of [TopicFilterSummary].
         *
         * The following fields are required:
         * ```java
         * .topic()
         * .question()
         * .cutoff()
         * .checked()
         * .kept()
         * .unchecked()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TopicFilterSummary]. */
    class Builder internal constructor() {

        private var topic: JsonField<String>? = null
        private var question: JsonField<String>? = null
        private var cutoff: JsonField<Double>? = null
        private var checked: JsonField<Long>? = null
        private var kept: JsonField<Long>? = null
        private var unchecked: JsonField<MutableList<Unchecked>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(topicFilterSummary: TopicFilterSummary) = apply {
            topic = topicFilterSummary.topic
            question = topicFilterSummary.question
            cutoff = topicFilterSummary.cutoff
            checked = topicFilterSummary.checked
            kept = topicFilterSummary.kept
            unchecked = topicFilterSummary.unchecked.map { it.toMutableList() }
            additionalProperties = topicFilterSummary.additionalProperties.toMutableMap()
        }

        /** The topic you sent. */
        fun topic(topic: String) = topic(JsonField.of(topic))

        /** Sets [Builder.topic] to an arbitrary JSON value. */
        fun topic(topic: JsonField<String>) = apply { this.topic = topic }

        /** The question asked of each post. */
        fun question(question: String) = question(JsonField.of(question))

        /** Sets [Builder.question] to an arbitrary JSON value. */
        fun question(question: JsonField<String>) = apply { this.question = question }

        /** The lowest topicScore a kept post has. */
        fun cutoff(cutoff: Double) = cutoff(JsonField.of(cutoff))

        /** Sets [Builder.cutoff] to an arbitrary JSON value. */
        fun cutoff(cutoff: JsonField<Double>) = apply { this.cutoff = cutoff }

        /** Posts checked. Only kept posts are billed. */
        fun checked(checked: Long) = checked(JsonField.of(checked))

        /** Sets [Builder.checked] to an arbitrary JSON value. */
        fun checked(checked: JsonField<Long>) = apply { this.checked = checked }

        /** Posts about the topic, all returned & billed at 2 credits each. */
        fun kept(kept: Long) = kept(JsonField.of(kept))

        /** Sets [Builder.kept] to an arbitrary JSON value. */
        fun kept(kept: JsonField<Long>) = apply { this.kept = kept }

        /** Posts the check couldn't answer. They aren't billed or returned. */
        fun unchecked(unchecked: List<Unchecked>) = unchecked(JsonField.of(unchecked))

        /** Sets [Builder.unchecked] to an arbitrary JSON value. */
        fun unchecked(unchecked: JsonField<List<Unchecked>>) = apply {
            this.unchecked = unchecked.map { it.toMutableList() }
        }

        /**
         * Adds a single [Unchecked] to [unchecked].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addUnchecked(unchecked: Unchecked) = apply {
            this.unchecked =
                (this.unchecked ?: JsonField.of(mutableListOf())).also {
                    checkKnown("unchecked", it).add(unchecked)
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
         * Returns an immutable instance of [TopicFilterSummary].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .topic()
         * .question()
         * .cutoff()
         * .checked()
         * .kept()
         * .unchecked()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TopicFilterSummary =
            TopicFilterSummary(
                checkRequired("topic", topic),
                checkRequired("question", question),
                checkRequired("cutoff", cutoff),
                checkRequired("checked", checked),
                checkRequired("kept", kept),
                checkRequired("unchecked", unchecked).map { it.toImmutable() },
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
    fun validate(): TopicFilterSummary = apply {
        if (validated) {
            return@apply
        }

        topic()
        question()
        cutoff()
        checked()
        kept()
        unchecked().forEach { it.validate() }
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
        (if (topic.asKnown().isPresent) 1 else 0) +
            (if (question.asKnown().isPresent) 1 else 0) +
            (if (cutoff.asKnown().isPresent) 1 else 0) +
            (if (checked.asKnown().isPresent) 1 else 0) +
            (if (kept.asKnown().isPresent) 1 else 0) +
            (unchecked.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0)

    /** 1 post the filter did not check, with the reason. */
    class Unchecked
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val reason: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("reason") @ExcludeMissing reason: JsonField<String> = JsonMissing.of(),
        ) : this(id, reason, mutableMapOf())

        /**
         * ID of the post.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun id(): String = id.getRequired("id")

        /**
         * Why the check skipped the post.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun reason(): String = reason.getRequired("reason")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [reason].
         *
         * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<String> = reason

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
             * Returns a mutable builder for constructing an instance of [Unchecked].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .reason()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Unchecked]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var reason: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(unchecked: Unchecked) = apply {
                id = unchecked.id
                reason = unchecked.reason
                additionalProperties = unchecked.additionalProperties.toMutableMap()
            }

            /** ID of the post. */
            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Why the check skipped the post. */
            fun reason(reason: String) = reason(JsonField.of(reason))

            /** Sets [Builder.reason] to an arbitrary JSON value. */
            fun reason(reason: JsonField<String>) = apply { this.reason = reason }

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
             * Returns an immutable instance of [Unchecked].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .reason()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Unchecked =
                Unchecked(
                    checkRequired("id", id),
                    checkRequired("reason", reason),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): Unchecked = apply {
            if (validated) {
                return@apply
            }

            id()
            reason()
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
            (if (id.asKnown().isPresent) 1 else 0) + (if (reason.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Unchecked &&
                id == other.id &&
                reason == other.reason &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, reason, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Unchecked{id=$id, reason=$reason, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TopicFilterSummary &&
            topic == other.topic &&
            question == other.question &&
            cutoff == other.cutoff &&
            checked == other.checked &&
            kept == other.kept &&
            unchecked == other.unchecked &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(topic, question, cutoff, checked, kept, unchecked, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TopicFilterSummary{topic=$topic, question=$question, cutoff=$cutoff, checked=$checked, kept=$kept, unchecked=$unchecked, additionalProperties=$additionalProperties}"
}
