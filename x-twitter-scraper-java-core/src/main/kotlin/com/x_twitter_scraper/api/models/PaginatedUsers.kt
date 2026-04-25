// File generated from our OpenAPI spec by Stainless.

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

/** Paginated list of user profiles with cursor-based navigation. */
class PaginatedUsers
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val hasNextPage: JsonField<Boolean>,
    private val nextCursor: JsonField<String>,
    private val users: JsonField<List<UserProfile>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("has_next_page")
        @ExcludeMissing
        hasNextPage: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("next_cursor")
        @ExcludeMissing
        nextCursor: JsonField<String> = JsonMissing.of(),
        @JsonProperty("users")
        @ExcludeMissing
        users: JsonField<List<UserProfile>> = JsonMissing.of(),
    ) : this(hasNextPage, nextCursor, users, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun hasNextPage(): Boolean = hasNextPage.getRequired("has_next_page")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun nextCursor(): String = nextCursor.getRequired("next_cursor")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun users(): List<UserProfile> = users.getRequired("users")

    /**
     * Returns the raw JSON value of [hasNextPage].
     *
     * Unlike [hasNextPage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("has_next_page")
    @ExcludeMissing
    fun _hasNextPage(): JsonField<Boolean> = hasNextPage

    /**
     * Returns the raw JSON value of [nextCursor].
     *
     * Unlike [nextCursor], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("next_cursor") @ExcludeMissing fun _nextCursor(): JsonField<String> = nextCursor

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
         * Returns a mutable builder for constructing an instance of [PaginatedUsers].
         *
         * The following fields are required:
         * ```java
         * .hasNextPage()
         * .nextCursor()
         * .users()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [PaginatedUsers]. */
    class Builder internal constructor() {

        private var hasNextPage: JsonField<Boolean>? = null
        private var nextCursor: JsonField<String>? = null
        private var users: JsonField<MutableList<UserProfile>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(paginatedUsers: PaginatedUsers) = apply {
            hasNextPage = paginatedUsers.hasNextPage
            nextCursor = paginatedUsers.nextCursor
            users = paginatedUsers.users.map { it.toMutableList() }
            additionalProperties = paginatedUsers.additionalProperties.toMutableMap()
        }

        fun hasNextPage(hasNextPage: Boolean) = hasNextPage(JsonField.of(hasNextPage))

        /**
         * Sets [Builder.hasNextPage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasNextPage] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun hasNextPage(hasNextPage: JsonField<Boolean>) = apply { this.hasNextPage = hasNextPage }

        fun nextCursor(nextCursor: String) = nextCursor(JsonField.of(nextCursor))

        /**
         * Sets [Builder.nextCursor] to an arbitrary JSON value.
         *
         * You should usually call [Builder.nextCursor] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun nextCursor(nextCursor: JsonField<String>) = apply { this.nextCursor = nextCursor }

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
         * Returns an immutable instance of [PaginatedUsers].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .hasNextPage()
         * .nextCursor()
         * .users()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): PaginatedUsers =
            PaginatedUsers(
                checkRequired("hasNextPage", hasNextPage),
                checkRequired("nextCursor", nextCursor),
                checkRequired("users", users).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): PaginatedUsers = apply {
        if (validated) {
            return@apply
        }

        hasNextPage()
        nextCursor()
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
        (if (hasNextPage.asKnown().isPresent) 1 else 0) +
            (if (nextCursor.asKnown().isPresent) 1 else 0) +
            (users.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PaginatedUsers &&
            hasNextPage == other.hasNextPage &&
            nextCursor == other.nextCursor &&
            users == other.users &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(hasNextPage, nextCursor, users, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "PaginatedUsers{hasNextPage=$hasNextPage, nextCursor=$nextCursor, users=$users, additionalProperties=$additionalProperties}"
}
