// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.followers

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

class FollowerRetrieveCheckResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val isFollowedBy: JsonField<Boolean>,
    private val isFollowing: JsonField<Boolean>,
    private val sourceUsername: JsonField<String>,
    private val targetUsername: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("isFollowedBy")
        @ExcludeMissing
        isFollowedBy: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("isFollowing")
        @ExcludeMissing
        isFollowing: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("sourceUsername")
        @ExcludeMissing
        sourceUsername: JsonField<String> = JsonMissing.of(),
        @JsonProperty("targetUsername")
        @ExcludeMissing
        targetUsername: JsonField<String> = JsonMissing.of(),
    ) : this(isFollowedBy, isFollowing, sourceUsername, targetUsername, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun isFollowedBy(): Boolean = isFollowedBy.getRequired("isFollowedBy")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun isFollowing(): Boolean = isFollowing.getRequired("isFollowing")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sourceUsername(): String = sourceUsername.getRequired("sourceUsername")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun targetUsername(): String = targetUsername.getRequired("targetUsername")

    /**
     * Returns the raw JSON value of [isFollowedBy].
     *
     * Unlike [isFollowedBy], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isFollowedBy")
    @ExcludeMissing
    fun _isFollowedBy(): JsonField<Boolean> = isFollowedBy

    /**
     * Returns the raw JSON value of [isFollowing].
     *
     * Unlike [isFollowing], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isFollowing")
    @ExcludeMissing
    fun _isFollowing(): JsonField<Boolean> = isFollowing

    /**
     * Returns the raw JSON value of [sourceUsername].
     *
     * Unlike [sourceUsername], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sourceUsername")
    @ExcludeMissing
    fun _sourceUsername(): JsonField<String> = sourceUsername

    /**
     * Returns the raw JSON value of [targetUsername].
     *
     * Unlike [targetUsername], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("targetUsername")
    @ExcludeMissing
    fun _targetUsername(): JsonField<String> = targetUsername

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
         * [FollowerRetrieveCheckResponse].
         *
         * The following fields are required:
         * ```java
         * .isFollowedBy()
         * .isFollowing()
         * .sourceUsername()
         * .targetUsername()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FollowerRetrieveCheckResponse]. */
    class Builder internal constructor() {

        private var isFollowedBy: JsonField<Boolean>? = null
        private var isFollowing: JsonField<Boolean>? = null
        private var sourceUsername: JsonField<String>? = null
        private var targetUsername: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(followerRetrieveCheckResponse: FollowerRetrieveCheckResponse) = apply {
            isFollowedBy = followerRetrieveCheckResponse.isFollowedBy
            isFollowing = followerRetrieveCheckResponse.isFollowing
            sourceUsername = followerRetrieveCheckResponse.sourceUsername
            targetUsername = followerRetrieveCheckResponse.targetUsername
            additionalProperties = followerRetrieveCheckResponse.additionalProperties.toMutableMap()
        }

        fun isFollowedBy(isFollowedBy: Boolean) = isFollowedBy(JsonField.of(isFollowedBy))

        /**
         * Sets [Builder.isFollowedBy] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isFollowedBy] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isFollowedBy(isFollowedBy: JsonField<Boolean>) = apply {
            this.isFollowedBy = isFollowedBy
        }

        fun isFollowing(isFollowing: Boolean) = isFollowing(JsonField.of(isFollowing))

        /**
         * Sets [Builder.isFollowing] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isFollowing] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isFollowing(isFollowing: JsonField<Boolean>) = apply { this.isFollowing = isFollowing }

        fun sourceUsername(sourceUsername: String) = sourceUsername(JsonField.of(sourceUsername))

        /**
         * Sets [Builder.sourceUsername] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sourceUsername] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun sourceUsername(sourceUsername: JsonField<String>) = apply {
            this.sourceUsername = sourceUsername
        }

        fun targetUsername(targetUsername: String) = targetUsername(JsonField.of(targetUsername))

        /**
         * Sets [Builder.targetUsername] to an arbitrary JSON value.
         *
         * You should usually call [Builder.targetUsername] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun targetUsername(targetUsername: JsonField<String>) = apply {
            this.targetUsername = targetUsername
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
         * Returns an immutable instance of [FollowerRetrieveCheckResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .isFollowedBy()
         * .isFollowing()
         * .sourceUsername()
         * .targetUsername()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FollowerRetrieveCheckResponse =
            FollowerRetrieveCheckResponse(
                checkRequired("isFollowedBy", isFollowedBy),
                checkRequired("isFollowing", isFollowing),
                checkRequired("sourceUsername", sourceUsername),
                checkRequired("targetUsername", targetUsername),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): FollowerRetrieveCheckResponse = apply {
        if (validated) {
            return@apply
        }

        isFollowedBy()
        isFollowing()
        sourceUsername()
        targetUsername()
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
        (if (isFollowedBy.asKnown().isPresent) 1 else 0) +
            (if (isFollowing.asKnown().isPresent) 1 else 0) +
            (if (sourceUsername.asKnown().isPresent) 1 else 0) +
            (if (targetUsername.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FollowerRetrieveCheckResponse &&
            isFollowedBy == other.isFollowedBy &&
            isFollowing == other.isFollowing &&
            sourceUsername == other.sourceUsername &&
            targetUsername == other.targetUsername &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            isFollowedBy,
            isFollowing,
            sourceUsername,
            targetUsername,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FollowerRetrieveCheckResponse{isFollowedBy=$isFollowedBy, isFollowing=$isFollowing, sourceUsername=$sourceUsername, targetUsername=$targetUsername, additionalProperties=$additionalProperties}"
}
