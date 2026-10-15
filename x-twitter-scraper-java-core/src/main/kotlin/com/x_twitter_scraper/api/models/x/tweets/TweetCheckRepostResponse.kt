// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.tweets

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

class TweetCheckRepostResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val checkedPosts: JsonField<Long>,
    private val complete: JsonField<Boolean>,
    private val isRetweeted: JsonField<Boolean>,
    private val retweetedAt: JsonField<String>,
    private val retweetId: JsonField<String>,
    private val tweetId: JsonField<String>,
    private val userId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("checkedPosts")
        @ExcludeMissing
        checkedPosts: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("complete") @ExcludeMissing complete: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("isRetweeted")
        @ExcludeMissing
        isRetweeted: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("retweetedAt")
        @ExcludeMissing
        retweetedAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("retweetId") @ExcludeMissing retweetId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("tweetId") @ExcludeMissing tweetId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("userId") @ExcludeMissing userId: JsonField<String> = JsonMissing.of(),
    ) : this(
        checkedPosts,
        complete,
        isRetweeted,
        retweetedAt,
        retweetId,
        tweetId,
        userId,
        mutableMapOf(),
    )

    /**
     * How many of the account's newest posts the check read.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun checkedPosts(): Long = checkedPosts.getRequired("checkedPosts")

    /**
     * Whether the check read the account's whole timeline.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun complete(): Boolean = complete.getRequired("complete")

    /**
     * Whether the account reposted the post.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun isRetweeted(): Boolean = isRetweeted.getRequired("isRetweeted")

    /**
     * When the account reposted it, else null.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun retweetedAt(): Optional<String> = retweetedAt.getOptional("retweetedAt")

    /**
     * The ID of the account's repost, else null.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun retweetId(): Optional<String> = retweetId.getOptional("retweetId")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun tweetId(): String = tweetId.getRequired("tweetId")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun userId(): String = userId.getRequired("userId")

    /**
     * Returns the raw JSON value of [checkedPosts].
     *
     * Unlike [checkedPosts], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("checkedPosts")
    @ExcludeMissing
    fun _checkedPosts(): JsonField<Long> = checkedPosts

    /**
     * Returns the raw JSON value of [complete].
     *
     * Unlike [complete], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("complete") @ExcludeMissing fun _complete(): JsonField<Boolean> = complete

    /**
     * Returns the raw JSON value of [isRetweeted].
     *
     * Unlike [isRetweeted], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isRetweeted")
    @ExcludeMissing
    fun _isRetweeted(): JsonField<Boolean> = isRetweeted

    /**
     * Returns the raw JSON value of [retweetedAt].
     *
     * Unlike [retweetedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("retweetedAt") @ExcludeMissing fun _retweetedAt(): JsonField<String> = retweetedAt

    /**
     * Returns the raw JSON value of [retweetId].
     *
     * Unlike [retweetId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("retweetId") @ExcludeMissing fun _retweetId(): JsonField<String> = retweetId

    /**
     * Returns the raw JSON value of [tweetId].
     *
     * Unlike [tweetId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tweetId") @ExcludeMissing fun _tweetId(): JsonField<String> = tweetId

    /**
     * Returns the raw JSON value of [userId].
     *
     * Unlike [userId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("userId") @ExcludeMissing fun _userId(): JsonField<String> = userId

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
         * Returns a mutable builder for constructing an instance of [TweetCheckRepostResponse].
         *
         * The following fields are required:
         * ```java
         * .checkedPosts()
         * .complete()
         * .isRetweeted()
         * .retweetedAt()
         * .retweetId()
         * .tweetId()
         * .userId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TweetCheckRepostResponse]. */
    class Builder internal constructor() {

        private var checkedPosts: JsonField<Long>? = null
        private var complete: JsonField<Boolean>? = null
        private var isRetweeted: JsonField<Boolean>? = null
        private var retweetedAt: JsonField<String>? = null
        private var retweetId: JsonField<String>? = null
        private var tweetId: JsonField<String>? = null
        private var userId: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(tweetCheckRepostResponse: TweetCheckRepostResponse) = apply {
            checkedPosts = tweetCheckRepostResponse.checkedPosts
            complete = tweetCheckRepostResponse.complete
            isRetweeted = tweetCheckRepostResponse.isRetweeted
            retweetedAt = tweetCheckRepostResponse.retweetedAt
            retweetId = tweetCheckRepostResponse.retweetId
            tweetId = tweetCheckRepostResponse.tweetId
            userId = tweetCheckRepostResponse.userId
            additionalProperties = tweetCheckRepostResponse.additionalProperties.toMutableMap()
        }

        /** How many of the account's newest posts the check read. */
        fun checkedPosts(checkedPosts: Long) = checkedPosts(JsonField.of(checkedPosts))

        /** Sets [Builder.checkedPosts] to an arbitrary JSON value. */
        fun checkedPosts(checkedPosts: JsonField<Long>) = apply { this.checkedPosts = checkedPosts }

        /** Whether the check read the account's whole timeline. */
        fun complete(complete: Boolean) = complete(JsonField.of(complete))

        /** Sets [Builder.complete] to an arbitrary JSON value. */
        fun complete(complete: JsonField<Boolean>) = apply { this.complete = complete }

        /** Whether the account reposted the post. */
        fun isRetweeted(isRetweeted: Boolean) = isRetweeted(JsonField.of(isRetweeted))

        /** Sets [Builder.isRetweeted] to an arbitrary JSON value. */
        fun isRetweeted(isRetweeted: JsonField<Boolean>) = apply { this.isRetweeted = isRetweeted }

        /** When the account reposted it, else null. */
        fun retweetedAt(retweetedAt: String?) = retweetedAt(JsonField.ofNullable(retweetedAt))

        /** Alias for calling [Builder.retweetedAt] with `retweetedAt.orElse(null)`. */
        fun retweetedAt(retweetedAt: Optional<String>) = retweetedAt(retweetedAt.getOrNull())

        /** Sets [Builder.retweetedAt] to an arbitrary JSON value. */
        fun retweetedAt(retweetedAt: JsonField<String>) = apply { this.retweetedAt = retweetedAt }

        /** The ID of the account's repost, else null. */
        fun retweetId(retweetId: String?) = retweetId(JsonField.ofNullable(retweetId))

        /** Alias for calling [Builder.retweetId] with `retweetId.orElse(null)`. */
        fun retweetId(retweetId: Optional<String>) = retweetId(retweetId.getOrNull())

        /** Sets [Builder.retweetId] to an arbitrary JSON value. */
        fun retweetId(retweetId: JsonField<String>) = apply { this.retweetId = retweetId }

        fun tweetId(tweetId: String) = tweetId(JsonField.of(tweetId))

        /** Sets [Builder.tweetId] to an arbitrary JSON value. */
        fun tweetId(tweetId: JsonField<String>) = apply { this.tweetId = tweetId }

        fun userId(userId: String) = userId(JsonField.of(userId))

        /** Sets [Builder.userId] to an arbitrary JSON value. */
        fun userId(userId: JsonField<String>) = apply { this.userId = userId }

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
         * Returns an immutable instance of [TweetCheckRepostResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .checkedPosts()
         * .complete()
         * .isRetweeted()
         * .retweetedAt()
         * .retweetId()
         * .tweetId()
         * .userId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TweetCheckRepostResponse =
            TweetCheckRepostResponse(
                checkRequired("checkedPosts", checkedPosts),
                checkRequired("complete", complete),
                checkRequired("isRetweeted", isRetweeted),
                checkRequired("retweetedAt", retweetedAt),
                checkRequired("retweetId", retweetId),
                checkRequired("tweetId", tweetId),
                checkRequired("userId", userId),
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
    fun validate(): TweetCheckRepostResponse = apply {
        if (validated) {
            return@apply
        }

        checkedPosts()
        complete()
        isRetweeted()
        retweetedAt()
        retweetId()
        tweetId()
        userId()
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
        (if (checkedPosts.asKnown().isPresent) 1 else 0) +
            (if (complete.asKnown().isPresent) 1 else 0) +
            (if (isRetweeted.asKnown().isPresent) 1 else 0) +
            (if (retweetedAt.asKnown().isPresent) 1 else 0) +
            (if (retweetId.asKnown().isPresent) 1 else 0) +
            (if (tweetId.asKnown().isPresent) 1 else 0) +
            (if (userId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TweetCheckRepostResponse &&
            checkedPosts == other.checkedPosts &&
            complete == other.complete &&
            isRetweeted == other.isRetweeted &&
            retweetedAt == other.retweetedAt &&
            retweetId == other.retweetId &&
            tweetId == other.tweetId &&
            userId == other.userId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            checkedPosts,
            complete,
            isRetweeted,
            retweetedAt,
            retweetId,
            tweetId,
            userId,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TweetCheckRepostResponse{checkedPosts=$checkedPosts, complete=$complete, isRetweeted=$isRetweeted, retweetedAt=$retweetedAt, retweetId=$retweetId, tweetId=$tweetId, userId=$userId, additionalProperties=$additionalProperties}"
}
