// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.users

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
import com.x_twitter_scraper.api.models.SearchTweet
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/**
 * Each user's newest posts, in the order the users were named, with the pinned post first. The ID
 * lists name the requested IDs or usernames. They name a profile link by its username.
 */
class UserRetrieveBatchTweetsResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val hasNextPage: JsonValue,
    private val nextCursor: JsonField<String>,
    private val tweets: JsonField<List<SearchTweet>>,
    private val unavailableIds: JsonField<List<String>>,
    private val unprocessedIds: JsonField<List<String>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("has_next_page") @ExcludeMissing hasNextPage: JsonValue = JsonMissing.of(),
        @JsonProperty("next_cursor")
        @ExcludeMissing
        nextCursor: JsonField<String> = JsonMissing.of(),
        @JsonProperty("tweets")
        @ExcludeMissing
        tweets: JsonField<List<SearchTweet>> = JsonMissing.of(),
        @JsonProperty("unavailable_ids")
        @ExcludeMissing
        unavailableIds: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("unprocessed_ids")
        @ExcludeMissing
        unprocessedIds: JsonField<List<String>> = JsonMissing.of(),
    ) : this(hasNextPage, nextCursor, tweets, unavailableIds, unprocessedIds, mutableMapOf())

    /**
     * Always false. The answer holds every post in 1 page.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from(false)
     * ```
     */
    @JsonProperty("has_next_page") @ExcludeMissing fun _hasNextPage(): JsonValue = hasNextPage

    /**
     * Always empty. The answer holds every post in 1 page.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun nextCursor(): String = nextCursor.getRequired("next_cursor")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun tweets(): List<SearchTweet> = tweets.getRequired("tweets")

    /**
     * Users with no account on X or with protected posts, in first-seen request order. They cost
     * nothing.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun unavailableIds(): List<String> = unavailableIds.getRequired("unavailable_ids")

    /**
     * Users the call did not read, in first-seen request order. Their read failed, the call ran out
     * of time or credits ran out. They cost nothing. Send them again.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun unprocessedIds(): List<String> = unprocessedIds.getRequired("unprocessed_ids")

    /**
     * Returns the raw JSON value of [nextCursor].
     *
     * Unlike [nextCursor], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("next_cursor") @ExcludeMissing fun _nextCursor(): JsonField<String> = nextCursor

    /**
     * Returns the raw JSON value of [tweets].
     *
     * Unlike [tweets], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tweets") @ExcludeMissing fun _tweets(): JsonField<List<SearchTweet>> = tweets

    /**
     * Returns the raw JSON value of [unavailableIds].
     *
     * Unlike [unavailableIds], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("unavailable_ids")
    @ExcludeMissing
    fun _unavailableIds(): JsonField<List<String>> = unavailableIds

    /**
     * Returns the raw JSON value of [unprocessedIds].
     *
     * Unlike [unprocessedIds], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("unprocessed_ids")
    @ExcludeMissing
    fun _unprocessedIds(): JsonField<List<String>> = unprocessedIds

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
         * [UserRetrieveBatchTweetsResponse].
         *
         * The following fields are required:
         * ```java
         * .nextCursor()
         * .tweets()
         * .unavailableIds()
         * .unprocessedIds()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UserRetrieveBatchTweetsResponse]. */
    class Builder internal constructor() {

        private var hasNextPage: JsonValue = JsonValue.from(false)
        private var nextCursor: JsonField<String>? = null
        private var tweets: JsonField<MutableList<SearchTweet>>? = null
        private var unavailableIds: JsonField<MutableList<String>>? = null
        private var unprocessedIds: JsonField<MutableList<String>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(userRetrieveBatchTweetsResponse: UserRetrieveBatchTweetsResponse) =
            apply {
                hasNextPage = userRetrieveBatchTweetsResponse.hasNextPage
                nextCursor = userRetrieveBatchTweetsResponse.nextCursor
                tweets = userRetrieveBatchTweetsResponse.tweets.map { it.toMutableList() }
                unavailableIds =
                    userRetrieveBatchTweetsResponse.unavailableIds.map { it.toMutableList() }
                unprocessedIds =
                    userRetrieveBatchTweetsResponse.unprocessedIds.map { it.toMutableList() }
                additionalProperties =
                    userRetrieveBatchTweetsResponse.additionalProperties.toMutableMap()
            }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * Defaults to the following:
         * ```java
         * JsonValue.from(false)
         * ```
         */
        fun hasNextPage(hasNextPage: JsonValue) = apply { this.hasNextPage = hasNextPage }

        /** Always empty. The answer holds every post in 1 page. */
        fun nextCursor(nextCursor: String) = nextCursor(JsonField.of(nextCursor))

        /** Sets [Builder.nextCursor] to an arbitrary JSON value. */
        fun nextCursor(nextCursor: JsonField<String>) = apply { this.nextCursor = nextCursor }

        fun tweets(tweets: List<SearchTweet>) = tweets(JsonField.of(tweets))

        /** Sets [Builder.tweets] to an arbitrary JSON value. */
        fun tweets(tweets: JsonField<List<SearchTweet>>) = apply {
            this.tweets = tweets.map { it.toMutableList() }
        }

        /**
         * Adds a single [SearchTweet] to [tweets].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTweet(tweet: SearchTweet) = apply {
            tweets =
                (tweets ?: JsonField.of(mutableListOf())).also {
                    checkKnown("tweets", it).add(tweet)
                }
        }

        /**
         * Users with no account on X or with protected posts, in first-seen request order. They
         * cost nothing.
         */
        fun unavailableIds(unavailableIds: List<String>) =
            unavailableIds(JsonField.of(unavailableIds))

        /** Sets [Builder.unavailableIds] to an arbitrary JSON value. */
        fun unavailableIds(unavailableIds: JsonField<List<String>>) = apply {
            this.unavailableIds = unavailableIds.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [unavailableIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addUnavailableId(unavailableId: String) = apply {
            unavailableIds =
                (unavailableIds ?: JsonField.of(mutableListOf())).also {
                    checkKnown("unavailableIds", it).add(unavailableId)
                }
        }

        /**
         * Users the call did not read, in first-seen request order. Their read failed, the call ran
         * out of time or credits ran out. They cost nothing. Send them again.
         */
        fun unprocessedIds(unprocessedIds: List<String>) =
            unprocessedIds(JsonField.of(unprocessedIds))

        /** Sets [Builder.unprocessedIds] to an arbitrary JSON value. */
        fun unprocessedIds(unprocessedIds: JsonField<List<String>>) = apply {
            this.unprocessedIds = unprocessedIds.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [unprocessedIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addUnprocessedId(unprocessedId: String) = apply {
            unprocessedIds =
                (unprocessedIds ?: JsonField.of(mutableListOf())).also {
                    checkKnown("unprocessedIds", it).add(unprocessedId)
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
         * Returns an immutable instance of [UserRetrieveBatchTweetsResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .nextCursor()
         * .tweets()
         * .unavailableIds()
         * .unprocessedIds()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): UserRetrieveBatchTweetsResponse =
            UserRetrieveBatchTweetsResponse(
                hasNextPage,
                checkRequired("nextCursor", nextCursor),
                checkRequired("tweets", tweets).map { it.toImmutable() },
                checkRequired("unavailableIds", unavailableIds).map { it.toImmutable() },
                checkRequired("unprocessedIds", unprocessedIds).map { it.toImmutable() },
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
    fun validate(): UserRetrieveBatchTweetsResponse = apply {
        if (validated) {
            return@apply
        }

        _hasNextPage().let {
            if (it != JsonValue.from(false)) {
                throw XTwitterScraperInvalidDataException("'hasNextPage' is invalid, received $it")
            }
        }
        nextCursor()
        tweets().forEach { it.validate() }
        unavailableIds()
        unprocessedIds()
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
        hasNextPage.let { if (it == JsonValue.from(false)) 1 else 0 } +
            (if (nextCursor.asKnown().isPresent) 1 else 0) +
            (tweets.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (unavailableIds.asKnown().getOrNull()?.size ?: 0) +
            (unprocessedIds.asKnown().getOrNull()?.size ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UserRetrieveBatchTweetsResponse &&
            hasNextPage == other.hasNextPage &&
            nextCursor == other.nextCursor &&
            tweets == other.tweets &&
            unavailableIds == other.unavailableIds &&
            unprocessedIds == other.unprocessedIds &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            hasNextPage,
            nextCursor,
            tweets,
            unavailableIds,
            unprocessedIds,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "UserRetrieveBatchTweetsResponse{hasNextPage=$hasNextPage, nextCursor=$nextCursor, tweets=$tweets, unavailableIds=$unavailableIds, unprocessedIds=$unprocessedIds, additionalProperties=$additionalProperties}"
}
