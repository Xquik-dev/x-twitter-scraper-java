// File generated from our OpenAPI spec by Stainless.

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

/** Author of a tweet with follower count and verification status. */
class TweetAuthor
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val followers: JsonField<Long>,
    private val username: JsonField<String>,
    private val verified: JsonField<Boolean>,
    private val profilePicture: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("followers") @ExcludeMissing followers: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("username") @ExcludeMissing username: JsonField<String> = JsonMissing.of(),
        @JsonProperty("verified") @ExcludeMissing verified: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("profilePicture")
        @ExcludeMissing
        profilePicture: JsonField<String> = JsonMissing.of(),
    ) : this(id, followers, username, verified, profilePicture, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun followers(): Long = followers.getRequired("followers")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun username(): String = username.getRequired("username")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun verified(): Boolean = verified.getRequired("verified")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun profilePicture(): Optional<String> = profilePicture.getOptional("profilePicture")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [followers].
     *
     * Unlike [followers], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("followers") @ExcludeMissing fun _followers(): JsonField<Long> = followers

    /**
     * Returns the raw JSON value of [username].
     *
     * Unlike [username], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username

    /**
     * Returns the raw JSON value of [verified].
     *
     * Unlike [verified], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("verified") @ExcludeMissing fun _verified(): JsonField<Boolean> = verified

    /**
     * Returns the raw JSON value of [profilePicture].
     *
     * Unlike [profilePicture], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("profilePicture")
    @ExcludeMissing
    fun _profilePicture(): JsonField<String> = profilePicture

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
         * Returns a mutable builder for constructing an instance of [TweetAuthor].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .followers()
         * .username()
         * .verified()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TweetAuthor]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var followers: JsonField<Long>? = null
        private var username: JsonField<String>? = null
        private var verified: JsonField<Boolean>? = null
        private var profilePicture: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(tweetAuthor: TweetAuthor) = apply {
            id = tweetAuthor.id
            followers = tweetAuthor.followers
            username = tweetAuthor.username
            verified = tweetAuthor.verified
            profilePicture = tweetAuthor.profilePicture
            additionalProperties = tweetAuthor.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun followers(followers: Long) = followers(JsonField.of(followers))

        /**
         * Sets [Builder.followers] to an arbitrary JSON value.
         *
         * You should usually call [Builder.followers] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun followers(followers: JsonField<Long>) = apply { this.followers = followers }

        fun username(username: String) = username(JsonField.of(username))

        /**
         * Sets [Builder.username] to an arbitrary JSON value.
         *
         * You should usually call [Builder.username] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun username(username: JsonField<String>) = apply { this.username = username }

        fun verified(verified: Boolean) = verified(JsonField.of(verified))

        /**
         * Sets [Builder.verified] to an arbitrary JSON value.
         *
         * You should usually call [Builder.verified] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun verified(verified: JsonField<Boolean>) = apply { this.verified = verified }

        fun profilePicture(profilePicture: String) = profilePicture(JsonField.of(profilePicture))

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
         * Returns an immutable instance of [TweetAuthor].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .followers()
         * .username()
         * .verified()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TweetAuthor =
            TweetAuthor(
                checkRequired("id", id),
                checkRequired("followers", followers),
                checkRequired("username", username),
                checkRequired("verified", verified),
                profilePicture,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): TweetAuthor = apply {
        if (validated) {
            return@apply
        }

        id()
        followers()
        username()
        verified()
        profilePicture()
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
            (if (followers.asKnown().isPresent) 1 else 0) +
            (if (username.asKnown().isPresent) 1 else 0) +
            (if (verified.asKnown().isPresent) 1 else 0) +
            (if (profilePicture.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TweetAuthor &&
            id == other.id &&
            followers == other.followers &&
            username == other.username &&
            verified == other.verified &&
            profilePicture == other.profilePicture &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, followers, username, verified, profilePicture, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TweetAuthor{id=$id, followers=$followers, username=$username, verified=$verified, profilePicture=$profilePicture, additionalProperties=$additionalProperties}"
}
