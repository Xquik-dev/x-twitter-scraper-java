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
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import com.x_twitter_scraper.api.models.SearchTweet
import com.x_twitter_scraper.api.models.UserProfile
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Says whether a user broadcasts live video on X now. `broadcast` is their latest broadcast, live
 * or ended, and null when X shows none.
 */
class UserRetrieveLiveResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val broadcast: JsonField<Broadcast>,
    private val live: JsonField<Boolean>,
    private val userId: JsonField<String>,
    private val userName: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("broadcast")
        @ExcludeMissing
        broadcast: JsonField<Broadcast> = JsonMissing.of(),
        @JsonProperty("live") @ExcludeMissing live: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("userId") @ExcludeMissing userId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("userName") @ExcludeMissing userName: JsonField<String> = JsonMissing.of(),
    ) : this(broadcast, live, userId, userName, mutableMapOf())

    /**
     * Latest broadcast, live or ended. Null when X shows none.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun broadcast(): Optional<Broadcast> = broadcast.getOptional("broadcast")

    /**
     * True while the user's latest broadcast is running.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun live(): Boolean = live.getRequired("live")

    /**
     * ID of the user.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun userId(): String = userId.getRequired("userId")

    /**
     * Username of the user.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun userName(): String = userName.getRequired("userName")

    /**
     * Returns the raw JSON value of [broadcast].
     *
     * Unlike [broadcast], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("broadcast") @ExcludeMissing fun _broadcast(): JsonField<Broadcast> = broadcast

    /**
     * Returns the raw JSON value of [live].
     *
     * Unlike [live], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("live") @ExcludeMissing fun _live(): JsonField<Boolean> = live

    /**
     * Returns the raw JSON value of [userId].
     *
     * Unlike [userId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("userId") @ExcludeMissing fun _userId(): JsonField<String> = userId

    /**
     * Returns the raw JSON value of [userName].
     *
     * Unlike [userName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("userName") @ExcludeMissing fun _userName(): JsonField<String> = userName

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
         * Returns a mutable builder for constructing an instance of [UserRetrieveLiveResponse].
         *
         * The following fields are required:
         * ```java
         * .broadcast()
         * .live()
         * .userId()
         * .userName()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UserRetrieveLiveResponse]. */
    class Builder internal constructor() {

        private var broadcast: JsonField<Broadcast>? = null
        private var live: JsonField<Boolean>? = null
        private var userId: JsonField<String>? = null
        private var userName: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(userRetrieveLiveResponse: UserRetrieveLiveResponse) = apply {
            broadcast = userRetrieveLiveResponse.broadcast
            live = userRetrieveLiveResponse.live
            userId = userRetrieveLiveResponse.userId
            userName = userRetrieveLiveResponse.userName
            additionalProperties = userRetrieveLiveResponse.additionalProperties.toMutableMap()
        }

        /** Latest broadcast, live or ended. Null when X shows none. */
        fun broadcast(broadcast: Broadcast?) = broadcast(JsonField.ofNullable(broadcast))

        /** Alias for calling [Builder.broadcast] with `broadcast.orElse(null)`. */
        fun broadcast(broadcast: Optional<Broadcast>) = broadcast(broadcast.getOrNull())

        /** Sets [Builder.broadcast] to an arbitrary JSON value. */
        fun broadcast(broadcast: JsonField<Broadcast>) = apply { this.broadcast = broadcast }

        /** True while the user's latest broadcast is running. */
        fun live(live: Boolean) = live(JsonField.of(live))

        /** Sets [Builder.live] to an arbitrary JSON value. */
        fun live(live: JsonField<Boolean>) = apply { this.live = live }

        /** ID of the user. */
        fun userId(userId: String) = userId(JsonField.of(userId))

        /** Sets [Builder.userId] to an arbitrary JSON value. */
        fun userId(userId: JsonField<String>) = apply { this.userId = userId }

        /** Username of the user. */
        fun userName(userName: String) = userName(JsonField.of(userName))

        /** Sets [Builder.userName] to an arbitrary JSON value. */
        fun userName(userName: JsonField<String>) = apply { this.userName = userName }

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
         * Returns an immutable instance of [UserRetrieveLiveResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .broadcast()
         * .live()
         * .userId()
         * .userName()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): UserRetrieveLiveResponse =
            UserRetrieveLiveResponse(
                checkRequired("broadcast", broadcast),
                checkRequired("live", live),
                checkRequired("userId", userId),
                checkRequired("userName", userName),
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
    fun validate(): UserRetrieveLiveResponse = apply {
        if (validated) {
            return@apply
        }

        broadcast().ifPresent { it.validate() }
        live()
        userId()
        userName()
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
        (broadcast.asKnown().getOrNull()?.validity() ?: 0) +
            (if (live.asKnown().isPresent) 1 else 0) +
            (if (userId.asKnown().isPresent) 1 else 0) +
            (if (userName.asKnown().isPresent) 1 else 0)

    /** X broadcast, a live video */
    class Broadcast
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val cameraRotation: JsonField<Long>,
        private val chatOption: JsonField<Long>,
        private val creator: JsonField<UserProfile>,
        private val endedAt: JsonField<OffsetDateTime>,
        private val height: JsonField<Long>,
        private val isAvailableForReplay: JsonField<Boolean>,
        private val isHighLatency: JsonField<Boolean>,
        private val isPrivateChat: JsonField<Boolean>,
        private val isTitleEdited: JsonField<Boolean>,
        private val lastPingAt: JsonField<OffsetDateTime>,
        private val mediaKey: JsonField<String>,
        private val periscopeUser: JsonField<PeriscopeUser>,
        private val preLiveSlateUrl: JsonField<String>,
        private val scheduledStart: JsonField<OffsetDateTime>,
        private val source: JsonField<String>,
        private val startedAt: JsonField<OffsetDateTime>,
        private val state: JsonField<String>,
        private val title: JsonField<String>,
        private val totalWatched: JsonField<Long>,
        private val totalWatching: JsonField<Long>,
        private val tweet: JsonField<SearchTweet>,
        private val tweetId: JsonField<String>,
        private val version: JsonField<Long>,
        private val width: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("cameraRotation")
            @ExcludeMissing
            cameraRotation: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("chatOption")
            @ExcludeMissing
            chatOption: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("creator")
            @ExcludeMissing
            creator: JsonField<UserProfile> = JsonMissing.of(),
            @JsonProperty("endedAt")
            @ExcludeMissing
            endedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("height") @ExcludeMissing height: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("isAvailableForReplay")
            @ExcludeMissing
            isAvailableForReplay: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("isHighLatency")
            @ExcludeMissing
            isHighLatency: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("isPrivateChat")
            @ExcludeMissing
            isPrivateChat: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("isTitleEdited")
            @ExcludeMissing
            isTitleEdited: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("lastPingAt")
            @ExcludeMissing
            lastPingAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("mediaKey")
            @ExcludeMissing
            mediaKey: JsonField<String> = JsonMissing.of(),
            @JsonProperty("periscopeUser")
            @ExcludeMissing
            periscopeUser: JsonField<PeriscopeUser> = JsonMissing.of(),
            @JsonProperty("preLiveSlateUrl")
            @ExcludeMissing
            preLiveSlateUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("scheduledStart")
            @ExcludeMissing
            scheduledStart: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("source") @ExcludeMissing source: JsonField<String> = JsonMissing.of(),
            @JsonProperty("startedAt")
            @ExcludeMissing
            startedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("state") @ExcludeMissing state: JsonField<String> = JsonMissing.of(),
            @JsonProperty("title") @ExcludeMissing title: JsonField<String> = JsonMissing.of(),
            @JsonProperty("totalWatched")
            @ExcludeMissing
            totalWatched: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("totalWatching")
            @ExcludeMissing
            totalWatching: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("tweet") @ExcludeMissing tweet: JsonField<SearchTweet> = JsonMissing.of(),
            @JsonProperty("tweetId") @ExcludeMissing tweetId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("version") @ExcludeMissing version: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("width") @ExcludeMissing width: JsonField<Long> = JsonMissing.of(),
        ) : this(
            id,
            cameraRotation,
            chatOption,
            creator,
            endedAt,
            height,
            isAvailableForReplay,
            isHighLatency,
            isPrivateChat,
            isTitleEdited,
            lastPingAt,
            mediaKey,
            periscopeUser,
            preLiveSlateUrl,
            scheduledStart,
            source,
            startedAt,
            state,
            title,
            totalWatched,
            totalWatching,
            tweet,
            tweetId,
            version,
            width,
            mutableMapOf(),
        )

        /**
         * Broadcast ID
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun id(): String = id.getRequired("id")

        /**
         * Camera rotation in degrees
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun cameraRotation(): Optional<Long> = cameraRotation.getOptional("cameraRotation")

        /**
         * X's code for who may chat
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun chatOption(): Optional<Long> = chatOption.getOptional("chatOption")

        /**
         * Public X profile.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun creator(): Optional<UserProfile> = creator.getOptional("creator")

        /**
         * When the broadcast ended
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun endedAt(): Optional<OffsetDateTime> = endedAt.getOptional("endedAt")

        /**
         * Video height in pixels
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun height(): Optional<Long> = height.getOptional("height")

        /**
         * Whether X offers a recording of the broadcast
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun isAvailableForReplay(): Optional<Boolean> =
            isAvailableForReplay.getOptional("isAvailableForReplay")

        /**
         * Whether the video stream runs in high-latency mode
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun isHighLatency(): Optional<Boolean> = isHighLatency.getOptional("isHighLatency")

        /**
         * Whether X marks the chat private
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun isPrivateChat(): Optional<Boolean> = isPrivateChat.getOptional("isPrivateChat")

        /**
         * Whether the broadcaster edited the title of the replay
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun isTitleEdited(): Optional<Boolean> = isTitleEdited.getOptional("isTitleEdited")

        /**
         * When the video stream last reached X
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun lastPingAt(): Optional<OffsetDateTime> = lastPingAt.getOptional("lastPingAt")

        /**
         * X's media key for the video
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun mediaKey(): Optional<String> = mediaKey.getOptional("mediaKey")

        /**
         * Broadcaster, as X's live video service names the account
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun periscopeUser(): Optional<PeriscopeUser> = periscopeUser.getOptional("periscopeUser")

        /**
         * Image X shows before the broadcast starts
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun preLiveSlateUrl(): Optional<String> = preLiveSlateUrl.getOptional("preLiveSlateUrl")

        /**
         * When the broadcast was set to start
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun scheduledStart(): Optional<OffsetDateTime> =
            scheduledStart.getOptional("scheduledStart")

        /**
         * What produced the video stream, as X names it
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun source(): Optional<String> = source.getOptional("source")

        /**
         * When the broadcast went live
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun startedAt(): Optional<OffsetDateTime> = startedAt.getOptional("startedAt")

        /**
         * State, such as NotStarted, Running or Ended, as X names it
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun state(): Optional<String> = state.getOptional("state")

        /**
         * Broadcast title
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun title(): Optional<String> = title.getOptional("title")

        /**
         * Accounts that watched, live or after
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun totalWatched(): Optional<Long> = totalWatched.getOptional("totalWatched")

        /**
         * Accounts watching, as X counts them
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun totalWatching(): Optional<Long> = totalWatching.getOptional("totalWatching")

        /**
         * Search tweet with author. Zero metrics may mean X omitted counts.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun tweet(): Optional<SearchTweet> = tweet.getOptional("tweet")

        /**
         * ID of the post that announces the broadcast
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun tweetId(): Optional<String> = tweetId.getOptional("tweetId")

        /**
         * X's revision number of the broadcast
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun version(): Optional<Long> = version.getOptional("version")

        /**
         * Video width in pixels
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun width(): Optional<Long> = width.getOptional("width")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [cameraRotation].
         *
         * Unlike [cameraRotation], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("cameraRotation")
        @ExcludeMissing
        fun _cameraRotation(): JsonField<Long> = cameraRotation

        /**
         * Returns the raw JSON value of [chatOption].
         *
         * Unlike [chatOption], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("chatOption") @ExcludeMissing fun _chatOption(): JsonField<Long> = chatOption

        /**
         * Returns the raw JSON value of [creator].
         *
         * Unlike [creator], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("creator") @ExcludeMissing fun _creator(): JsonField<UserProfile> = creator

        /**
         * Returns the raw JSON value of [endedAt].
         *
         * Unlike [endedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("endedAt") @ExcludeMissing fun _endedAt(): JsonField<OffsetDateTime> = endedAt

        /**
         * Returns the raw JSON value of [height].
         *
         * Unlike [height], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("height") @ExcludeMissing fun _height(): JsonField<Long> = height

        /**
         * Returns the raw JSON value of [isAvailableForReplay].
         *
         * Unlike [isAvailableForReplay], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("isAvailableForReplay")
        @ExcludeMissing
        fun _isAvailableForReplay(): JsonField<Boolean> = isAvailableForReplay

        /**
         * Returns the raw JSON value of [isHighLatency].
         *
         * Unlike [isHighLatency], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("isHighLatency")
        @ExcludeMissing
        fun _isHighLatency(): JsonField<Boolean> = isHighLatency

        /**
         * Returns the raw JSON value of [isPrivateChat].
         *
         * Unlike [isPrivateChat], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("isPrivateChat")
        @ExcludeMissing
        fun _isPrivateChat(): JsonField<Boolean> = isPrivateChat

        /**
         * Returns the raw JSON value of [isTitleEdited].
         *
         * Unlike [isTitleEdited], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("isTitleEdited")
        @ExcludeMissing
        fun _isTitleEdited(): JsonField<Boolean> = isTitleEdited

        /**
         * Returns the raw JSON value of [lastPingAt].
         *
         * Unlike [lastPingAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("lastPingAt")
        @ExcludeMissing
        fun _lastPingAt(): JsonField<OffsetDateTime> = lastPingAt

        /**
         * Returns the raw JSON value of [mediaKey].
         *
         * Unlike [mediaKey], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("mediaKey") @ExcludeMissing fun _mediaKey(): JsonField<String> = mediaKey

        /**
         * Returns the raw JSON value of [periscopeUser].
         *
         * Unlike [periscopeUser], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("periscopeUser")
        @ExcludeMissing
        fun _periscopeUser(): JsonField<PeriscopeUser> = periscopeUser

        /**
         * Returns the raw JSON value of [preLiveSlateUrl].
         *
         * Unlike [preLiveSlateUrl], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("preLiveSlateUrl")
        @ExcludeMissing
        fun _preLiveSlateUrl(): JsonField<String> = preLiveSlateUrl

        /**
         * Returns the raw JSON value of [scheduledStart].
         *
         * Unlike [scheduledStart], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("scheduledStart")
        @ExcludeMissing
        fun _scheduledStart(): JsonField<OffsetDateTime> = scheduledStart

        /**
         * Returns the raw JSON value of [source].
         *
         * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<String> = source

        /**
         * Returns the raw JSON value of [startedAt].
         *
         * Unlike [startedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("startedAt")
        @ExcludeMissing
        fun _startedAt(): JsonField<OffsetDateTime> = startedAt

        /**
         * Returns the raw JSON value of [state].
         *
         * Unlike [state], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("state") @ExcludeMissing fun _state(): JsonField<String> = state

        /**
         * Returns the raw JSON value of [title].
         *
         * Unlike [title], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("title") @ExcludeMissing fun _title(): JsonField<String> = title

        /**
         * Returns the raw JSON value of [totalWatched].
         *
         * Unlike [totalWatched], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("totalWatched")
        @ExcludeMissing
        fun _totalWatched(): JsonField<Long> = totalWatched

        /**
         * Returns the raw JSON value of [totalWatching].
         *
         * Unlike [totalWatching], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("totalWatching")
        @ExcludeMissing
        fun _totalWatching(): JsonField<Long> = totalWatching

        /**
         * Returns the raw JSON value of [tweet].
         *
         * Unlike [tweet], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tweet") @ExcludeMissing fun _tweet(): JsonField<SearchTweet> = tweet

        /**
         * Returns the raw JSON value of [tweetId].
         *
         * Unlike [tweetId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tweetId") @ExcludeMissing fun _tweetId(): JsonField<String> = tweetId

        /**
         * Returns the raw JSON value of [version].
         *
         * Unlike [version], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("version") @ExcludeMissing fun _version(): JsonField<Long> = version

        /**
         * Returns the raw JSON value of [width].
         *
         * Unlike [width], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("width") @ExcludeMissing fun _width(): JsonField<Long> = width

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
             * Returns a mutable builder for constructing an instance of [Broadcast].
             *
             * The following fields are required:
             * ```java
             * .id()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Broadcast]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var cameraRotation: JsonField<Long> = JsonMissing.of()
            private var chatOption: JsonField<Long> = JsonMissing.of()
            private var creator: JsonField<UserProfile> = JsonMissing.of()
            private var endedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var height: JsonField<Long> = JsonMissing.of()
            private var isAvailableForReplay: JsonField<Boolean> = JsonMissing.of()
            private var isHighLatency: JsonField<Boolean> = JsonMissing.of()
            private var isPrivateChat: JsonField<Boolean> = JsonMissing.of()
            private var isTitleEdited: JsonField<Boolean> = JsonMissing.of()
            private var lastPingAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var mediaKey: JsonField<String> = JsonMissing.of()
            private var periscopeUser: JsonField<PeriscopeUser> = JsonMissing.of()
            private var preLiveSlateUrl: JsonField<String> = JsonMissing.of()
            private var scheduledStart: JsonField<OffsetDateTime> = JsonMissing.of()
            private var source: JsonField<String> = JsonMissing.of()
            private var startedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var state: JsonField<String> = JsonMissing.of()
            private var title: JsonField<String> = JsonMissing.of()
            private var totalWatched: JsonField<Long> = JsonMissing.of()
            private var totalWatching: JsonField<Long> = JsonMissing.of()
            private var tweet: JsonField<SearchTweet> = JsonMissing.of()
            private var tweetId: JsonField<String> = JsonMissing.of()
            private var version: JsonField<Long> = JsonMissing.of()
            private var width: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(broadcast: Broadcast) = apply {
                id = broadcast.id
                cameraRotation = broadcast.cameraRotation
                chatOption = broadcast.chatOption
                creator = broadcast.creator
                endedAt = broadcast.endedAt
                height = broadcast.height
                isAvailableForReplay = broadcast.isAvailableForReplay
                isHighLatency = broadcast.isHighLatency
                isPrivateChat = broadcast.isPrivateChat
                isTitleEdited = broadcast.isTitleEdited
                lastPingAt = broadcast.lastPingAt
                mediaKey = broadcast.mediaKey
                periscopeUser = broadcast.periscopeUser
                preLiveSlateUrl = broadcast.preLiveSlateUrl
                scheduledStart = broadcast.scheduledStart
                source = broadcast.source
                startedAt = broadcast.startedAt
                state = broadcast.state
                title = broadcast.title
                totalWatched = broadcast.totalWatched
                totalWatching = broadcast.totalWatching
                tweet = broadcast.tweet
                tweetId = broadcast.tweetId
                version = broadcast.version
                width = broadcast.width
                additionalProperties = broadcast.additionalProperties.toMutableMap()
            }

            /** Broadcast ID */
            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Camera rotation in degrees */
            fun cameraRotation(cameraRotation: Long) = cameraRotation(JsonField.of(cameraRotation))

            /** Sets [Builder.cameraRotation] to an arbitrary JSON value. */
            fun cameraRotation(cameraRotation: JsonField<Long>) = apply {
                this.cameraRotation = cameraRotation
            }

            /** X's code for who may chat */
            fun chatOption(chatOption: Long) = chatOption(JsonField.of(chatOption))

            /** Sets [Builder.chatOption] to an arbitrary JSON value. */
            fun chatOption(chatOption: JsonField<Long>) = apply { this.chatOption = chatOption }

            /** Public X profile. */
            fun creator(creator: UserProfile) = creator(JsonField.of(creator))

            /** Sets [Builder.creator] to an arbitrary JSON value. */
            fun creator(creator: JsonField<UserProfile>) = apply { this.creator = creator }

            /** When the broadcast ended */
            fun endedAt(endedAt: OffsetDateTime) = endedAt(JsonField.of(endedAt))

            /** Sets [Builder.endedAt] to an arbitrary JSON value. */
            fun endedAt(endedAt: JsonField<OffsetDateTime>) = apply { this.endedAt = endedAt }

            /** Video height in pixels */
            fun height(height: Long) = height(JsonField.of(height))

            /** Sets [Builder.height] to an arbitrary JSON value. */
            fun height(height: JsonField<Long>) = apply { this.height = height }

            /** Whether X offers a recording of the broadcast */
            fun isAvailableForReplay(isAvailableForReplay: Boolean) =
                isAvailableForReplay(JsonField.of(isAvailableForReplay))

            /** Sets [Builder.isAvailableForReplay] to an arbitrary JSON value. */
            fun isAvailableForReplay(isAvailableForReplay: JsonField<Boolean>) = apply {
                this.isAvailableForReplay = isAvailableForReplay
            }

            /** Whether the video stream runs in high-latency mode */
            fun isHighLatency(isHighLatency: Boolean) = isHighLatency(JsonField.of(isHighLatency))

            /** Sets [Builder.isHighLatency] to an arbitrary JSON value. */
            fun isHighLatency(isHighLatency: JsonField<Boolean>) = apply {
                this.isHighLatency = isHighLatency
            }

            /** Whether X marks the chat private */
            fun isPrivateChat(isPrivateChat: Boolean) = isPrivateChat(JsonField.of(isPrivateChat))

            /** Sets [Builder.isPrivateChat] to an arbitrary JSON value. */
            fun isPrivateChat(isPrivateChat: JsonField<Boolean>) = apply {
                this.isPrivateChat = isPrivateChat
            }

            /** Whether the broadcaster edited the title of the replay */
            fun isTitleEdited(isTitleEdited: Boolean) = isTitleEdited(JsonField.of(isTitleEdited))

            /** Sets [Builder.isTitleEdited] to an arbitrary JSON value. */
            fun isTitleEdited(isTitleEdited: JsonField<Boolean>) = apply {
                this.isTitleEdited = isTitleEdited
            }

            /** When the video stream last reached X */
            fun lastPingAt(lastPingAt: OffsetDateTime) = lastPingAt(JsonField.of(lastPingAt))

            /** Sets [Builder.lastPingAt] to an arbitrary JSON value. */
            fun lastPingAt(lastPingAt: JsonField<OffsetDateTime>) = apply {
                this.lastPingAt = lastPingAt
            }

            /** X's media key for the video */
            fun mediaKey(mediaKey: String) = mediaKey(JsonField.of(mediaKey))

            /** Sets [Builder.mediaKey] to an arbitrary JSON value. */
            fun mediaKey(mediaKey: JsonField<String>) = apply { this.mediaKey = mediaKey }

            /** Broadcaster, as X's live video service names the account */
            fun periscopeUser(periscopeUser: PeriscopeUser) =
                periscopeUser(JsonField.of(periscopeUser))

            /** Sets [Builder.periscopeUser] to an arbitrary JSON value. */
            fun periscopeUser(periscopeUser: JsonField<PeriscopeUser>) = apply {
                this.periscopeUser = periscopeUser
            }

            /** Image X shows before the broadcast starts */
            fun preLiveSlateUrl(preLiveSlateUrl: String) =
                preLiveSlateUrl(JsonField.of(preLiveSlateUrl))

            /** Sets [Builder.preLiveSlateUrl] to an arbitrary JSON value. */
            fun preLiveSlateUrl(preLiveSlateUrl: JsonField<String>) = apply {
                this.preLiveSlateUrl = preLiveSlateUrl
            }

            /** When the broadcast was set to start */
            fun scheduledStart(scheduledStart: OffsetDateTime) =
                scheduledStart(JsonField.of(scheduledStart))

            /** Sets [Builder.scheduledStart] to an arbitrary JSON value. */
            fun scheduledStart(scheduledStart: JsonField<OffsetDateTime>) = apply {
                this.scheduledStart = scheduledStart
            }

            /** What produced the video stream, as X names it */
            fun source(source: String) = source(JsonField.of(source))

            /** Sets [Builder.source] to an arbitrary JSON value. */
            fun source(source: JsonField<String>) = apply { this.source = source }

            /** When the broadcast went live */
            fun startedAt(startedAt: OffsetDateTime) = startedAt(JsonField.of(startedAt))

            /** Sets [Builder.startedAt] to an arbitrary JSON value. */
            fun startedAt(startedAt: JsonField<OffsetDateTime>) = apply {
                this.startedAt = startedAt
            }

            /** State, such as NotStarted, Running or Ended, as X names it */
            fun state(state: String) = state(JsonField.of(state))

            /** Sets [Builder.state] to an arbitrary JSON value. */
            fun state(state: JsonField<String>) = apply { this.state = state }

            /** Broadcast title */
            fun title(title: String) = title(JsonField.of(title))

            /** Sets [Builder.title] to an arbitrary JSON value. */
            fun title(title: JsonField<String>) = apply { this.title = title }

            /** Accounts that watched, live or after */
            fun totalWatched(totalWatched: Long) = totalWatched(JsonField.of(totalWatched))

            /** Sets [Builder.totalWatched] to an arbitrary JSON value. */
            fun totalWatched(totalWatched: JsonField<Long>) = apply {
                this.totalWatched = totalWatched
            }

            /** Accounts watching, as X counts them */
            fun totalWatching(totalWatching: Long) = totalWatching(JsonField.of(totalWatching))

            /** Sets [Builder.totalWatching] to an arbitrary JSON value. */
            fun totalWatching(totalWatching: JsonField<Long>) = apply {
                this.totalWatching = totalWatching
            }

            /** Search tweet with author. Zero metrics may mean X omitted counts. */
            fun tweet(tweet: SearchTweet) = tweet(JsonField.of(tweet))

            /** Sets [Builder.tweet] to an arbitrary JSON value. */
            fun tweet(tweet: JsonField<SearchTweet>) = apply { this.tweet = tweet }

            /** ID of the post that announces the broadcast */
            fun tweetId(tweetId: String) = tweetId(JsonField.of(tweetId))

            /** Sets [Builder.tweetId] to an arbitrary JSON value. */
            fun tweetId(tweetId: JsonField<String>) = apply { this.tweetId = tweetId }

            /** X's revision number of the broadcast */
            fun version(version: Long) = version(JsonField.of(version))

            /** Sets [Builder.version] to an arbitrary JSON value. */
            fun version(version: JsonField<Long>) = apply { this.version = version }

            /** Video width in pixels */
            fun width(width: Long) = width(JsonField.of(width))

            /** Sets [Builder.width] to an arbitrary JSON value. */
            fun width(width: JsonField<Long>) = apply { this.width = width }

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
             * Returns an immutable instance of [Broadcast].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Broadcast =
                Broadcast(
                    checkRequired("id", id),
                    cameraRotation,
                    chatOption,
                    creator,
                    endedAt,
                    height,
                    isAvailableForReplay,
                    isHighLatency,
                    isPrivateChat,
                    isTitleEdited,
                    lastPingAt,
                    mediaKey,
                    periscopeUser,
                    preLiveSlateUrl,
                    scheduledStart,
                    source,
                    startedAt,
                    state,
                    title,
                    totalWatched,
                    totalWatching,
                    tweet,
                    tweetId,
                    version,
                    width,
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
        fun validate(): Broadcast = apply {
            if (validated) {
                return@apply
            }

            id()
            cameraRotation()
            chatOption()
            creator().ifPresent { it.validate() }
            endedAt()
            height()
            isAvailableForReplay()
            isHighLatency()
            isPrivateChat()
            isTitleEdited()
            lastPingAt()
            mediaKey()
            periscopeUser().ifPresent { it.validate() }
            preLiveSlateUrl()
            scheduledStart()
            source()
            startedAt()
            state()
            title()
            totalWatched()
            totalWatching()
            tweet().ifPresent { it.validate() }
            tweetId()
            version()
            width()
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
                (if (cameraRotation.asKnown().isPresent) 1 else 0) +
                (if (chatOption.asKnown().isPresent) 1 else 0) +
                (creator.asKnown().getOrNull()?.validity() ?: 0) +
                (if (endedAt.asKnown().isPresent) 1 else 0) +
                (if (height.asKnown().isPresent) 1 else 0) +
                (if (isAvailableForReplay.asKnown().isPresent) 1 else 0) +
                (if (isHighLatency.asKnown().isPresent) 1 else 0) +
                (if (isPrivateChat.asKnown().isPresent) 1 else 0) +
                (if (isTitleEdited.asKnown().isPresent) 1 else 0) +
                (if (lastPingAt.asKnown().isPresent) 1 else 0) +
                (if (mediaKey.asKnown().isPresent) 1 else 0) +
                (periscopeUser.asKnown().getOrNull()?.validity() ?: 0) +
                (if (preLiveSlateUrl.asKnown().isPresent) 1 else 0) +
                (if (scheduledStart.asKnown().isPresent) 1 else 0) +
                (if (source.asKnown().isPresent) 1 else 0) +
                (if (startedAt.asKnown().isPresent) 1 else 0) +
                (if (state.asKnown().isPresent) 1 else 0) +
                (if (title.asKnown().isPresent) 1 else 0) +
                (if (totalWatched.asKnown().isPresent) 1 else 0) +
                (if (totalWatching.asKnown().isPresent) 1 else 0) +
                (tweet.asKnown().getOrNull()?.validity() ?: 0) +
                (if (tweetId.asKnown().isPresent) 1 else 0) +
                (if (version.asKnown().isPresent) 1 else 0) +
                (if (width.asKnown().isPresent) 1 else 0)

        /** Broadcaster, as X's live video service names the account */
        class PeriscopeUser
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val displayName: JsonField<String>,
            private val id: JsonField<String>,
            private val profilePicture: JsonField<String>,
            private val profilePictureOriginal: JsonField<String>,
            private val username: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("displayName")
                @ExcludeMissing
                displayName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profilePicture")
                @ExcludeMissing
                profilePicture: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profilePictureOriginal")
                @ExcludeMissing
                profilePictureOriginal: JsonField<String> = JsonMissing.of(),
                @JsonProperty("username")
                @ExcludeMissing
                username: JsonField<String> = JsonMissing.of(),
            ) : this(
                displayName,
                id,
                profilePicture,
                profilePictureOriginal,
                username,
                mutableMapOf(),
            )

            /**
             * Live video display name
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun displayName(): Optional<String> = displayName.getOptional("displayName")

            /**
             * Live video account ID
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun id(): Optional<String> = id.getOptional("id")

            /**
             * Live video avatar URL
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profilePicture(): Optional<String> = profilePicture.getOptional("profilePicture")

            /**
             * The broadcaster's avatar at full size
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profilePictureOriginal(): Optional<String> =
                profilePictureOriginal.getOptional("profilePictureOriginal")

            /**
             * Live video username
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun username(): Optional<String> = username.getOptional("username")

            /**
             * Returns the raw JSON value of [displayName].
             *
             * Unlike [displayName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("displayName")
            @ExcludeMissing
            fun _displayName(): JsonField<String> = displayName

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [profilePicture].
             *
             * Unlike [profilePicture], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("profilePicture")
            @ExcludeMissing
            fun _profilePicture(): JsonField<String> = profilePicture

            /**
             * Returns the raw JSON value of [profilePictureOriginal].
             *
             * Unlike [profilePictureOriginal], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("profilePictureOriginal")
            @ExcludeMissing
            fun _profilePictureOriginal(): JsonField<String> = profilePictureOriginal

            /**
             * Returns the raw JSON value of [username].
             *
             * Unlike [username], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username

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

                /** Returns a mutable builder for constructing an instance of [PeriscopeUser]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [PeriscopeUser]. */
            class Builder internal constructor() {

                private var displayName: JsonField<String> = JsonMissing.of()
                private var id: JsonField<String> = JsonMissing.of()
                private var profilePicture: JsonField<String> = JsonMissing.of()
                private var profilePictureOriginal: JsonField<String> = JsonMissing.of()
                private var username: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(periscopeUser: PeriscopeUser) = apply {
                    displayName = periscopeUser.displayName
                    id = periscopeUser.id
                    profilePicture = periscopeUser.profilePicture
                    profilePictureOriginal = periscopeUser.profilePictureOriginal
                    username = periscopeUser.username
                    additionalProperties = periscopeUser.additionalProperties.toMutableMap()
                }

                /** Live video display name */
                fun displayName(displayName: String) = displayName(JsonField.of(displayName))

                /** Sets [Builder.displayName] to an arbitrary JSON value. */
                fun displayName(displayName: JsonField<String>) = apply {
                    this.displayName = displayName
                }

                /** Live video account ID */
                fun id(id: String) = id(JsonField.of(id))

                /** Sets [Builder.id] to an arbitrary JSON value. */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** Live video avatar URL */
                fun profilePicture(profilePicture: String) =
                    profilePicture(JsonField.of(profilePicture))

                /** Sets [Builder.profilePicture] to an arbitrary JSON value. */
                fun profilePicture(profilePicture: JsonField<String>) = apply {
                    this.profilePicture = profilePicture
                }

                /** The broadcaster's avatar at full size */
                fun profilePictureOriginal(profilePictureOriginal: String) =
                    profilePictureOriginal(JsonField.of(profilePictureOriginal))

                /** Sets [Builder.profilePictureOriginal] to an arbitrary JSON value. */
                fun profilePictureOriginal(profilePictureOriginal: JsonField<String>) = apply {
                    this.profilePictureOriginal = profilePictureOriginal
                }

                /** Live video username */
                fun username(username: String) = username(JsonField.of(username))

                /** Sets [Builder.username] to an arbitrary JSON value. */
                fun username(username: JsonField<String>) = apply { this.username = username }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [PeriscopeUser].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): PeriscopeUser =
                    PeriscopeUser(
                        displayName,
                        id,
                        profilePicture,
                        profilePictureOriginal,
                        username,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
             *   match its expected type.
             */
            fun validate(): PeriscopeUser = apply {
                if (validated) {
                    return@apply
                }

                displayName()
                id()
                profilePicture()
                profilePictureOriginal()
                username()
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
                (if (displayName.asKnown().isPresent) 1 else 0) +
                    (if (id.asKnown().isPresent) 1 else 0) +
                    (if (profilePicture.asKnown().isPresent) 1 else 0) +
                    (if (profilePictureOriginal.asKnown().isPresent) 1 else 0) +
                    (if (username.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is PeriscopeUser &&
                    displayName == other.displayName &&
                    id == other.id &&
                    profilePicture == other.profilePicture &&
                    profilePictureOriginal == other.profilePictureOriginal &&
                    username == other.username &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    displayName,
                    id,
                    profilePicture,
                    profilePictureOriginal,
                    username,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "PeriscopeUser{displayName=$displayName, id=$id, profilePicture=$profilePicture, profilePictureOriginal=$profilePictureOriginal, username=$username, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Broadcast &&
                id == other.id &&
                cameraRotation == other.cameraRotation &&
                chatOption == other.chatOption &&
                creator == other.creator &&
                endedAt == other.endedAt &&
                height == other.height &&
                isAvailableForReplay == other.isAvailableForReplay &&
                isHighLatency == other.isHighLatency &&
                isPrivateChat == other.isPrivateChat &&
                isTitleEdited == other.isTitleEdited &&
                lastPingAt == other.lastPingAt &&
                mediaKey == other.mediaKey &&
                periscopeUser == other.periscopeUser &&
                preLiveSlateUrl == other.preLiveSlateUrl &&
                scheduledStart == other.scheduledStart &&
                source == other.source &&
                startedAt == other.startedAt &&
                state == other.state &&
                title == other.title &&
                totalWatched == other.totalWatched &&
                totalWatching == other.totalWatching &&
                tweet == other.tweet &&
                tweetId == other.tweetId &&
                version == other.version &&
                width == other.width &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                cameraRotation,
                chatOption,
                creator,
                endedAt,
                height,
                isAvailableForReplay,
                isHighLatency,
                isPrivateChat,
                isTitleEdited,
                lastPingAt,
                mediaKey,
                periscopeUser,
                preLiveSlateUrl,
                scheduledStart,
                source,
                startedAt,
                state,
                title,
                totalWatched,
                totalWatching,
                tweet,
                tweetId,
                version,
                width,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Broadcast{id=$id, cameraRotation=$cameraRotation, chatOption=$chatOption, creator=$creator, endedAt=$endedAt, height=$height, isAvailableForReplay=$isAvailableForReplay, isHighLatency=$isHighLatency, isPrivateChat=$isPrivateChat, isTitleEdited=$isTitleEdited, lastPingAt=$lastPingAt, mediaKey=$mediaKey, periscopeUser=$periscopeUser, preLiveSlateUrl=$preLiveSlateUrl, scheduledStart=$scheduledStart, source=$source, startedAt=$startedAt, state=$state, title=$title, totalWatched=$totalWatched, totalWatching=$totalWatching, tweet=$tweet, tweetId=$tweetId, version=$version, width=$width, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UserRetrieveLiveResponse &&
            broadcast == other.broadcast &&
            live == other.live &&
            userId == other.userId &&
            userName == other.userName &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(broadcast, live, userId, userName, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "UserRetrieveLiveResponse{broadcast=$broadcast, live=$live, userId=$userId, userName=$userName, additionalProperties=$additionalProperties}"
}
