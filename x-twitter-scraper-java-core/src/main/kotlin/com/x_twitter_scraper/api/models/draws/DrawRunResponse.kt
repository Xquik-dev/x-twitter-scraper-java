// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.draws

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

class DrawRunResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val totalEntries: JsonField<Long>,
    private val tweetId: JsonField<String>,
    private val validEntries: JsonField<Long>,
    private val winners: JsonField<List<Winner>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("totalEntries")
        @ExcludeMissing
        totalEntries: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("tweetId") @ExcludeMissing tweetId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("validEntries")
        @ExcludeMissing
        validEntries: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("winners") @ExcludeMissing winners: JsonField<List<Winner>> = JsonMissing.of(),
    ) : this(id, totalEntries, tweetId, validEntries, winners, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun totalEntries(): Long = totalEntries.getRequired("totalEntries")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun tweetId(): String = tweetId.getRequired("tweetId")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun validEntries(): Long = validEntries.getRequired("validEntries")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun winners(): List<Winner> = winners.getRequired("winners")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [totalEntries].
     *
     * Unlike [totalEntries], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("totalEntries")
    @ExcludeMissing
    fun _totalEntries(): JsonField<Long> = totalEntries

    /**
     * Returns the raw JSON value of [tweetId].
     *
     * Unlike [tweetId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tweetId") @ExcludeMissing fun _tweetId(): JsonField<String> = tweetId

    /**
     * Returns the raw JSON value of [validEntries].
     *
     * Unlike [validEntries], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("validEntries")
    @ExcludeMissing
    fun _validEntries(): JsonField<Long> = validEntries

    /**
     * Returns the raw JSON value of [winners].
     *
     * Unlike [winners], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("winners") @ExcludeMissing fun _winners(): JsonField<List<Winner>> = winners

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
         * Returns a mutable builder for constructing an instance of [DrawRunResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .totalEntries()
         * .tweetId()
         * .validEntries()
         * .winners()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DrawRunResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var totalEntries: JsonField<Long>? = null
        private var tweetId: JsonField<String>? = null
        private var validEntries: JsonField<Long>? = null
        private var winners: JsonField<MutableList<Winner>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(drawRunResponse: DrawRunResponse) = apply {
            id = drawRunResponse.id
            totalEntries = drawRunResponse.totalEntries
            tweetId = drawRunResponse.tweetId
            validEntries = drawRunResponse.validEntries
            winners = drawRunResponse.winners.map { it.toMutableList() }
            additionalProperties = drawRunResponse.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun totalEntries(totalEntries: Long) = totalEntries(JsonField.of(totalEntries))

        /**
         * Sets [Builder.totalEntries] to an arbitrary JSON value.
         *
         * You should usually call [Builder.totalEntries] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun totalEntries(totalEntries: JsonField<Long>) = apply { this.totalEntries = totalEntries }

        fun tweetId(tweetId: String) = tweetId(JsonField.of(tweetId))

        /**
         * Sets [Builder.tweetId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tweetId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tweetId(tweetId: JsonField<String>) = apply { this.tweetId = tweetId }

        fun validEntries(validEntries: Long) = validEntries(JsonField.of(validEntries))

        /**
         * Sets [Builder.validEntries] to an arbitrary JSON value.
         *
         * You should usually call [Builder.validEntries] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun validEntries(validEntries: JsonField<Long>) = apply { this.validEntries = validEntries }

        fun winners(winners: List<Winner>) = winners(JsonField.of(winners))

        /**
         * Sets [Builder.winners] to an arbitrary JSON value.
         *
         * You should usually call [Builder.winners] with a well-typed `List<Winner>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun winners(winners: JsonField<List<Winner>>) = apply {
            this.winners = winners.map { it.toMutableList() }
        }

        /**
         * Adds a single [Winner] to [winners].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addWinner(winner: Winner) = apply {
            winners =
                (winners ?: JsonField.of(mutableListOf())).also {
                    checkKnown("winners", it).add(winner)
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
         * Returns an immutable instance of [DrawRunResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .totalEntries()
         * .tweetId()
         * .validEntries()
         * .winners()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): DrawRunResponse =
            DrawRunResponse(
                checkRequired("id", id),
                checkRequired("totalEntries", totalEntries),
                checkRequired("tweetId", tweetId),
                checkRequired("validEntries", validEntries),
                checkRequired("winners", winners).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): DrawRunResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        totalEntries()
        tweetId()
        validEntries()
        winners().forEach { it.validate() }
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: XTwitterScraperInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (totalEntries.asKnown().isPresent) 1 else 0) +
            (if (tweetId.asKnown().isPresent) 1 else 0) +
            (if (validEntries.asKnown().isPresent) 1 else 0) +
            (winners.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    class Winner
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val authorUsername: JsonField<String>,
        private val isBackup: JsonField<Boolean>,
        private val position: JsonField<Long>,
        private val tweetId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("authorUsername")
            @ExcludeMissing
            authorUsername: JsonField<String> = JsonMissing.of(),
            @JsonProperty("isBackup")
            @ExcludeMissing
            isBackup: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("position") @ExcludeMissing position: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("tweetId") @ExcludeMissing tweetId: JsonField<String> = JsonMissing.of(),
        ) : this(authorUsername, isBackup, position, tweetId, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun authorUsername(): String = authorUsername.getRequired("authorUsername")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun isBackup(): Boolean = isBackup.getRequired("isBackup")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun position(): Long = position.getRequired("position")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun tweetId(): String = tweetId.getRequired("tweetId")

        /**
         * Returns the raw JSON value of [authorUsername].
         *
         * Unlike [authorUsername], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("authorUsername")
        @ExcludeMissing
        fun _authorUsername(): JsonField<String> = authorUsername

        /**
         * Returns the raw JSON value of [isBackup].
         *
         * Unlike [isBackup], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("isBackup") @ExcludeMissing fun _isBackup(): JsonField<Boolean> = isBackup

        /**
         * Returns the raw JSON value of [position].
         *
         * Unlike [position], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("position") @ExcludeMissing fun _position(): JsonField<Long> = position

        /**
         * Returns the raw JSON value of [tweetId].
         *
         * Unlike [tweetId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tweetId") @ExcludeMissing fun _tweetId(): JsonField<String> = tweetId

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
             * Returns a mutable builder for constructing an instance of [Winner].
             *
             * The following fields are required:
             * ```java
             * .authorUsername()
             * .isBackup()
             * .position()
             * .tweetId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Winner]. */
        class Builder internal constructor() {

            private var authorUsername: JsonField<String>? = null
            private var isBackup: JsonField<Boolean>? = null
            private var position: JsonField<Long>? = null
            private var tweetId: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(winner: Winner) = apply {
                authorUsername = winner.authorUsername
                isBackup = winner.isBackup
                position = winner.position
                tweetId = winner.tweetId
                additionalProperties = winner.additionalProperties.toMutableMap()
            }

            fun authorUsername(authorUsername: String) =
                authorUsername(JsonField.of(authorUsername))

            /**
             * Sets [Builder.authorUsername] to an arbitrary JSON value.
             *
             * You should usually call [Builder.authorUsername] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun authorUsername(authorUsername: JsonField<String>) = apply {
                this.authorUsername = authorUsername
            }

            fun isBackup(isBackup: Boolean) = isBackup(JsonField.of(isBackup))

            /**
             * Sets [Builder.isBackup] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isBackup] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isBackup(isBackup: JsonField<Boolean>) = apply { this.isBackup = isBackup }

            fun position(position: Long) = position(JsonField.of(position))

            /**
             * Sets [Builder.position] to an arbitrary JSON value.
             *
             * You should usually call [Builder.position] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun position(position: JsonField<Long>) = apply { this.position = position }

            fun tweetId(tweetId: String) = tweetId(JsonField.of(tweetId))

            /**
             * Sets [Builder.tweetId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tweetId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tweetId(tweetId: JsonField<String>) = apply { this.tweetId = tweetId }

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
             * Returns an immutable instance of [Winner].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .authorUsername()
             * .isBackup()
             * .position()
             * .tweetId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Winner =
                Winner(
                    checkRequired("authorUsername", authorUsername),
                    checkRequired("isBackup", isBackup),
                    checkRequired("position", position),
                    checkRequired("tweetId", tweetId),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Winner = apply {
            if (validated) {
                return@apply
            }

            authorUsername()
            isBackup()
            position()
            tweetId()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (authorUsername.asKnown().isPresent) 1 else 0) +
                (if (isBackup.asKnown().isPresent) 1 else 0) +
                (if (position.asKnown().isPresent) 1 else 0) +
                (if (tweetId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Winner &&
                authorUsername == other.authorUsername &&
                isBackup == other.isBackup &&
                position == other.position &&
                tweetId == other.tweetId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(authorUsername, isBackup, position, tweetId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Winner{authorUsername=$authorUsername, isBackup=$isBackup, position=$position, tweetId=$tweetId, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DrawRunResponse &&
            id == other.id &&
            totalEntries == other.totalEntries &&
            tweetId == other.tweetId &&
            validEntries == other.validEntries &&
            winners == other.winners &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, totalEntries, tweetId, validEntries, winners, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DrawRunResponse{id=$id, totalEntries=$totalEntries, tweetId=$tweetId, validEntries=$validEntries, winners=$winners, additionalProperties=$additionalProperties}"
}
