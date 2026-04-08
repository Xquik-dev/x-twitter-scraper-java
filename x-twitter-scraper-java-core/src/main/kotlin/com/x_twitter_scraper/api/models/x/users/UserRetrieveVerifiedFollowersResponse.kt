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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Paginated list of user profiles with cursor-based navigation. */
class UserRetrieveVerifiedFollowersResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val hasNextPage: JsonField<Boolean>,
    private val nextCursor: JsonField<String>,
    private val users: JsonField<List<User>>,
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
        @JsonProperty("users") @ExcludeMissing users: JsonField<List<User>> = JsonMissing.of(),
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
    fun users(): List<User> = users.getRequired("users")

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
    @JsonProperty("users") @ExcludeMissing fun _users(): JsonField<List<User>> = users

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
         * [UserRetrieveVerifiedFollowersResponse].
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

    /** A builder for [UserRetrieveVerifiedFollowersResponse]. */
    class Builder internal constructor() {

        private var hasNextPage: JsonField<Boolean>? = null
        private var nextCursor: JsonField<String>? = null
        private var users: JsonField<MutableList<User>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            userRetrieveVerifiedFollowersResponse: UserRetrieveVerifiedFollowersResponse
        ) = apply {
            hasNextPage = userRetrieveVerifiedFollowersResponse.hasNextPage
            nextCursor = userRetrieveVerifiedFollowersResponse.nextCursor
            users = userRetrieveVerifiedFollowersResponse.users.map { it.toMutableList() }
            additionalProperties =
                userRetrieveVerifiedFollowersResponse.additionalProperties.toMutableMap()
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

        fun users(users: List<User>) = users(JsonField.of(users))

        /**
         * Sets [Builder.users] to an arbitrary JSON value.
         *
         * You should usually call [Builder.users] with a well-typed `List<User>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun users(users: JsonField<List<User>>) = apply {
            this.users = users.map { it.toMutableList() }
        }

        /**
         * Adds a single [User] to [users].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addUser(user: User) = apply {
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
         * Returns an immutable instance of [UserRetrieveVerifiedFollowersResponse].
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
        fun build(): UserRetrieveVerifiedFollowersResponse =
            UserRetrieveVerifiedFollowersResponse(
                checkRequired("hasNextPage", hasNextPage),
                checkRequired("nextCursor", nextCursor),
                checkRequired("users", users).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): UserRetrieveVerifiedFollowersResponse = apply {
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

    /** X user profile with bio, follower counts, and verification status. */
    class User
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val name: JsonField<String>,
        private val username: JsonField<String>,
        private val createdAt: JsonField<String>,
        private val description: JsonField<String>,
        private val followers: JsonField<Long>,
        private val following: JsonField<Long>,
        private val location: JsonField<String>,
        private val profilePicture: JsonField<String>,
        private val statusesCount: JsonField<Long>,
        private val verified: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("username")
            @ExcludeMissing
            username: JsonField<String> = JsonMissing.of(),
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("followers")
            @ExcludeMissing
            followers: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("following")
            @ExcludeMissing
            following: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("location")
            @ExcludeMissing
            location: JsonField<String> = JsonMissing.of(),
            @JsonProperty("profilePicture")
            @ExcludeMissing
            profilePicture: JsonField<String> = JsonMissing.of(),
            @JsonProperty("statusesCount")
            @ExcludeMissing
            statusesCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("verified")
            @ExcludeMissing
            verified: JsonField<Boolean> = JsonMissing.of(),
        ) : this(
            id,
            name,
            username,
            createdAt,
            description,
            followers,
            following,
            location,
            profilePicture,
            statusesCount,
            verified,
            mutableMapOf(),
        )

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun username(): String = username.getRequired("username")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun createdAt(): Optional<String> = createdAt.getOptional("createdAt")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun description(): Optional<String> = description.getOptional("description")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun followers(): Optional<Long> = followers.getOptional("followers")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun following(): Optional<Long> = following.getOptional("following")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun location(): Optional<String> = location.getOptional("location")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun profilePicture(): Optional<String> = profilePicture.getOptional("profilePicture")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun statusesCount(): Optional<Long> = statusesCount.getOptional("statusesCount")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun verified(): Optional<Boolean> = verified.getOptional("verified")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [username].
         *
         * Unlike [username], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username

        /**
         * Returns the raw JSON value of [createdAt].
         *
         * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("createdAt") @ExcludeMissing fun _createdAt(): JsonField<String> = createdAt

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [followers].
         *
         * Unlike [followers], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("followers") @ExcludeMissing fun _followers(): JsonField<Long> = followers

        /**
         * Returns the raw JSON value of [following].
         *
         * Unlike [following], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("following") @ExcludeMissing fun _following(): JsonField<Long> = following

        /**
         * Returns the raw JSON value of [location].
         *
         * Unlike [location], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("location") @ExcludeMissing fun _location(): JsonField<String> = location

        /**
         * Returns the raw JSON value of [profilePicture].
         *
         * Unlike [profilePicture], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("profilePicture")
        @ExcludeMissing
        fun _profilePicture(): JsonField<String> = profilePicture

        /**
         * Returns the raw JSON value of [statusesCount].
         *
         * Unlike [statusesCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("statusesCount")
        @ExcludeMissing
        fun _statusesCount(): JsonField<Long> = statusesCount

        /**
         * Returns the raw JSON value of [verified].
         *
         * Unlike [verified], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("verified") @ExcludeMissing fun _verified(): JsonField<Boolean> = verified

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
             * Returns a mutable builder for constructing an instance of [User].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .name()
             * .username()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [User]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var name: JsonField<String>? = null
            private var username: JsonField<String>? = null
            private var createdAt: JsonField<String> = JsonMissing.of()
            private var description: JsonField<String> = JsonMissing.of()
            private var followers: JsonField<Long> = JsonMissing.of()
            private var following: JsonField<Long> = JsonMissing.of()
            private var location: JsonField<String> = JsonMissing.of()
            private var profilePicture: JsonField<String> = JsonMissing.of()
            private var statusesCount: JsonField<Long> = JsonMissing.of()
            private var verified: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(user: User) = apply {
                id = user.id
                name = user.name
                username = user.username
                createdAt = user.createdAt
                description = user.description
                followers = user.followers
                following = user.following
                location = user.location
                profilePicture = user.profilePicture
                statusesCount = user.statusesCount
                verified = user.verified
                additionalProperties = user.additionalProperties.toMutableMap()
            }

            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            fun username(username: String) = username(JsonField.of(username))

            /**
             * Sets [Builder.username] to an arbitrary JSON value.
             *
             * You should usually call [Builder.username] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun username(username: JsonField<String>) = apply { this.username = username }

            fun createdAt(createdAt: String) = createdAt(JsonField.of(createdAt))

            /**
             * Sets [Builder.createdAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.createdAt] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun createdAt(createdAt: JsonField<String>) = apply { this.createdAt = createdAt }

            fun description(description: String) = description(JsonField.of(description))

            /**
             * Sets [Builder.description] to an arbitrary JSON value.
             *
             * You should usually call [Builder.description] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

            fun followers(followers: Long) = followers(JsonField.of(followers))

            /**
             * Sets [Builder.followers] to an arbitrary JSON value.
             *
             * You should usually call [Builder.followers] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun followers(followers: JsonField<Long>) = apply { this.followers = followers }

            fun following(following: Long) = following(JsonField.of(following))

            /**
             * Sets [Builder.following] to an arbitrary JSON value.
             *
             * You should usually call [Builder.following] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun following(following: JsonField<Long>) = apply { this.following = following }

            fun location(location: String) = location(JsonField.of(location))

            /**
             * Sets [Builder.location] to an arbitrary JSON value.
             *
             * You should usually call [Builder.location] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun location(location: JsonField<String>) = apply { this.location = location }

            fun profilePicture(profilePicture: String) =
                profilePicture(JsonField.of(profilePicture))

            /**
             * Sets [Builder.profilePicture] to an arbitrary JSON value.
             *
             * You should usually call [Builder.profilePicture] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun profilePicture(profilePicture: JsonField<String>) = apply {
                this.profilePicture = profilePicture
            }

            fun statusesCount(statusesCount: Long) = statusesCount(JsonField.of(statusesCount))

            /**
             * Sets [Builder.statusesCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.statusesCount] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun statusesCount(statusesCount: JsonField<Long>) = apply {
                this.statusesCount = statusesCount
            }

            fun verified(verified: Boolean) = verified(JsonField.of(verified))

            /**
             * Sets [Builder.verified] to an arbitrary JSON value.
             *
             * You should usually call [Builder.verified] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun verified(verified: JsonField<Boolean>) = apply { this.verified = verified }

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
             * Returns an immutable instance of [User].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .name()
             * .username()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): User =
                User(
                    checkRequired("id", id),
                    checkRequired("name", name),
                    checkRequired("username", username),
                    createdAt,
                    description,
                    followers,
                    following,
                    location,
                    profilePicture,
                    statusesCount,
                    verified,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): User = apply {
            if (validated) {
                return@apply
            }

            id()
            name()
            username()
            createdAt()
            description()
            followers()
            following()
            location()
            profilePicture()
            statusesCount()
            verified()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (username.asKnown().isPresent) 1 else 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (description.asKnown().isPresent) 1 else 0) +
                (if (followers.asKnown().isPresent) 1 else 0) +
                (if (following.asKnown().isPresent) 1 else 0) +
                (if (location.asKnown().isPresent) 1 else 0) +
                (if (profilePicture.asKnown().isPresent) 1 else 0) +
                (if (statusesCount.asKnown().isPresent) 1 else 0) +
                (if (verified.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is User &&
                id == other.id &&
                name == other.name &&
                username == other.username &&
                createdAt == other.createdAt &&
                description == other.description &&
                followers == other.followers &&
                following == other.following &&
                location == other.location &&
                profilePicture == other.profilePicture &&
                statusesCount == other.statusesCount &&
                verified == other.verified &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                name,
                username,
                createdAt,
                description,
                followers,
                following,
                location,
                profilePicture,
                statusesCount,
                verified,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "User{id=$id, name=$name, username=$username, createdAt=$createdAt, description=$description, followers=$followers, following=$following, location=$location, profilePicture=$profilePicture, statusesCount=$statusesCount, verified=$verified, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UserRetrieveVerifiedFollowersResponse &&
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
        "UserRetrieveVerifiedFollowersResponse{hasNextPage=$hasNextPage, nextCursor=$nextCursor, users=$users, additionalProperties=$additionalProperties}"
}
