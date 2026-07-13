// File generated from our OpenAPI spec by Stainless.

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
import com.x_twitter_scraper.api.models.UserProfile
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/**
 * Batch user lookup results. Duplicate requested IDs are ignored while preserving first-seen order.
 * unavailable_ids identifies processed IDs with no returned profile. unprocessed_ids identifies IDs
 * skipped when available credits limit processing.
 */
class UserRetrieveBatchResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val hasNextPage: JsonValue,
    private val nextCursor: JsonField<String>,
    private val processedCount: JsonField<Long>,
    private val requestedCount: JsonField<Long>,
    private val returnedCount: JsonField<Long>,
    private val unavailableIds: JsonField<List<String>>,
    private val unprocessedIds: JsonField<List<String>>,
    private val users: JsonField<List<UserProfile>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("has_next_page") @ExcludeMissing hasNextPage: JsonValue = JsonMissing.of(),
        @JsonProperty("next_cursor")
        @ExcludeMissing
        nextCursor: JsonField<String> = JsonMissing.of(),
        @JsonProperty("processed_count")
        @ExcludeMissing
        processedCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("requested_count")
        @ExcludeMissing
        requestedCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("returned_count")
        @ExcludeMissing
        returnedCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("unavailable_ids")
        @ExcludeMissing
        unavailableIds: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("unprocessed_ids")
        @ExcludeMissing
        unprocessedIds: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("users")
        @ExcludeMissing
        users: JsonField<List<UserProfile>> = JsonMissing.of(),
    ) : this(
        hasNextPage,
        nextCursor,
        processedCount,
        requestedCount,
        returnedCount,
        unavailableIds,
        unprocessedIds,
        users,
        mutableMapOf(),
    )

    /**
     * Batch lookups never paginate.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from(false)
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("has_next_page") @ExcludeMissing fun _hasNextPage(): JsonValue = hasNextPage

    /**
     * Empty because batch lookups never paginate.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun nextCursor(): String = nextCursor.getRequired("next_cursor")

    /**
     * Number of requested IDs included in the lookup.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun processedCount(): Long = processedCount.getRequired("processed_count")

    /**
     * Number of unique IDs requested.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun requestedCount(): Long = requestedCount.getRequired("requested_count")

    /**
     * Number of user profiles returned and charged.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun returnedCount(): Long = returnedCount.getRequired("returned_count")

    /**
     * Processed IDs with no returned profile, in first-seen request order.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun unavailableIds(): List<String> = unavailableIds.getRequired("unavailable_ids")

    /**
     * Requested IDs skipped because available credits limited processing. Retry these IDs after
     * adding credits.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun unprocessedIds(): List<String> = unprocessedIds.getRequired("unprocessed_ids")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun users(): List<UserProfile> = users.getRequired("users")

    /**
     * Returns the raw JSON value of [nextCursor].
     *
     * Unlike [nextCursor], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("next_cursor") @ExcludeMissing fun _nextCursor(): JsonField<String> = nextCursor

    /**
     * Returns the raw JSON value of [processedCount].
     *
     * Unlike [processedCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("processed_count")
    @ExcludeMissing
    fun _processedCount(): JsonField<Long> = processedCount

    /**
     * Returns the raw JSON value of [requestedCount].
     *
     * Unlike [requestedCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("requested_count")
    @ExcludeMissing
    fun _requestedCount(): JsonField<Long> = requestedCount

    /**
     * Returns the raw JSON value of [returnedCount].
     *
     * Unlike [returnedCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("returned_count")
    @ExcludeMissing
    fun _returnedCount(): JsonField<Long> = returnedCount

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

    /**
     * Returns the raw JSON value of [users].
     *
     * Unlike [users], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("users") @ExcludeMissing fun _users(): JsonField<List<UserProfile>> = users

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
         * Returns a mutable builder for constructing an instance of [UserRetrieveBatchResponse].
         *
         * The following fields are required:
         * ```java
         * .nextCursor()
         * .processedCount()
         * .requestedCount()
         * .returnedCount()
         * .unavailableIds()
         * .unprocessedIds()
         * .users()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UserRetrieveBatchResponse]. */
    class Builder internal constructor() {

        private var hasNextPage: JsonValue = JsonValue.from(false)
        private var nextCursor: JsonField<String>? = null
        private var processedCount: JsonField<Long>? = null
        private var requestedCount: JsonField<Long>? = null
        private var returnedCount: JsonField<Long>? = null
        private var unavailableIds: JsonField<MutableList<String>>? = null
        private var unprocessedIds: JsonField<MutableList<String>>? = null
        private var users: JsonField<MutableList<UserProfile>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(userRetrieveBatchResponse: UserRetrieveBatchResponse) = apply {
            hasNextPage = userRetrieveBatchResponse.hasNextPage
            nextCursor = userRetrieveBatchResponse.nextCursor
            processedCount = userRetrieveBatchResponse.processedCount
            requestedCount = userRetrieveBatchResponse.requestedCount
            returnedCount = userRetrieveBatchResponse.returnedCount
            unavailableIds = userRetrieveBatchResponse.unavailableIds.map { it.toMutableList() }
            unprocessedIds = userRetrieveBatchResponse.unprocessedIds.map { it.toMutableList() }
            users = userRetrieveBatchResponse.users.map { it.toMutableList() }
            additionalProperties = userRetrieveBatchResponse.additionalProperties.toMutableMap()
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from(false)
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun hasNextPage(hasNextPage: JsonValue) = apply { this.hasNextPage = hasNextPage }

        /** Empty because batch lookups never paginate. */
        fun nextCursor(nextCursor: String) = nextCursor(JsonField.of(nextCursor))

        /**
         * Sets [Builder.nextCursor] to an arbitrary JSON value.
         *
         * You should usually call [Builder.nextCursor] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun nextCursor(nextCursor: JsonField<String>) = apply { this.nextCursor = nextCursor }

        /** Number of requested IDs included in the lookup. */
        fun processedCount(processedCount: Long) = processedCount(JsonField.of(processedCount))

        /**
         * Sets [Builder.processedCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.processedCount] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun processedCount(processedCount: JsonField<Long>) = apply {
            this.processedCount = processedCount
        }

        /** Number of unique IDs requested. */
        fun requestedCount(requestedCount: Long) = requestedCount(JsonField.of(requestedCount))

        /**
         * Sets [Builder.requestedCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requestedCount] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun requestedCount(requestedCount: JsonField<Long>) = apply {
            this.requestedCount = requestedCount
        }

        /** Number of user profiles returned and charged. */
        fun returnedCount(returnedCount: Long) = returnedCount(JsonField.of(returnedCount))

        /**
         * Sets [Builder.returnedCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.returnedCount] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun returnedCount(returnedCount: JsonField<Long>) = apply {
            this.returnedCount = returnedCount
        }

        /** Processed IDs with no returned profile, in first-seen request order. */
        fun unavailableIds(unavailableIds: List<String>) =
            unavailableIds(JsonField.of(unavailableIds))

        /**
         * Sets [Builder.unavailableIds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.unavailableIds] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
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
         * Requested IDs skipped because available credits limited processing. Retry these IDs after
         * adding credits.
         */
        fun unprocessedIds(unprocessedIds: List<String>) =
            unprocessedIds(JsonField.of(unprocessedIds))

        /**
         * Sets [Builder.unprocessedIds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.unprocessedIds] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
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

        fun users(users: List<UserProfile>) = users(JsonField.of(users))

        /**
         * Sets [Builder.users] to an arbitrary JSON value.
         *
         * You should usually call [Builder.users] with a well-typed `List<UserProfile>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun users(users: JsonField<List<UserProfile>>) = apply {
            this.users = users.map { it.toMutableList() }
        }

        /**
         * Adds a single [UserProfile] to [users].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addUser(user: UserProfile) = apply {
            users =
                (users ?: JsonField.of(mutableListOf())).also { checkKnown("users", it).add(user) }
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
         * Returns an immutable instance of [UserRetrieveBatchResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .nextCursor()
         * .processedCount()
         * .requestedCount()
         * .returnedCount()
         * .unavailableIds()
         * .unprocessedIds()
         * .users()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): UserRetrieveBatchResponse =
            UserRetrieveBatchResponse(
                hasNextPage,
                checkRequired("nextCursor", nextCursor),
                checkRequired("processedCount", processedCount),
                checkRequired("requestedCount", requestedCount),
                checkRequired("returnedCount", returnedCount),
                checkRequired("unavailableIds", unavailableIds).map { it.toImmutable() },
                checkRequired("unprocessedIds", unprocessedIds).map { it.toImmutable() },
                checkRequired("users", users).map { it.toImmutable() },
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
    fun validate(): UserRetrieveBatchResponse = apply {
        if (validated) {
            return@apply
        }

        _hasNextPage().let {
            if (it != JsonValue.from(false)) {
                throw XTwitterScraperInvalidDataException("'hasNextPage' is invalid, received $it")
            }
        }
        nextCursor()
        processedCount()
        requestedCount()
        returnedCount()
        unavailableIds()
        unprocessedIds()
        users().forEach { it.validate() }
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
        hasNextPage.let { if (it == JsonValue.from(false)) 1 else 0 } +
            (if (nextCursor.asKnown().isPresent) 1 else 0) +
            (if (processedCount.asKnown().isPresent) 1 else 0) +
            (if (requestedCount.asKnown().isPresent) 1 else 0) +
            (if (returnedCount.asKnown().isPresent) 1 else 0) +
            (unavailableIds.asKnown().getOrNull()?.size ?: 0) +
            (unprocessedIds.asKnown().getOrNull()?.size ?: 0) +
            (users.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UserRetrieveBatchResponse &&
            hasNextPage == other.hasNextPage &&
            nextCursor == other.nextCursor &&
            processedCount == other.processedCount &&
            requestedCount == other.requestedCount &&
            returnedCount == other.returnedCount &&
            unavailableIds == other.unavailableIds &&
            unprocessedIds == other.unprocessedIds &&
            users == other.users &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            hasNextPage,
            nextCursor,
            processedCount,
            requestedCount,
            returnedCount,
            unavailableIds,
            unprocessedIds,
            users,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "UserRetrieveBatchResponse{hasNextPage=$hasNextPage, nextCursor=$nextCursor, processedCount=$processedCount, requestedCount=$requestedCount, returnedCount=$returnedCount, unavailableIds=$unavailableIds, unprocessedIds=$unprocessedIds, users=$users, additionalProperties=$additionalProperties}"
}
