// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.spaces

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
import com.x_twitter_scraper.api.models.UserProfile
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class SpaceRetrieveResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val space: JsonField<Space>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("space") @ExcludeMissing space: JsonField<Space> = JsonMissing.of()
    ) : this(space, mutableMapOf())

    /**
     * X Space
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun space(): Space = space.getRequired("space")

    /**
     * Returns the raw JSON value of [space].
     *
     * Unlike [space], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("space") @ExcludeMissing fun _space(): JsonField<Space> = space

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
         * Returns a mutable builder for constructing an instance of [SpaceRetrieveResponse].
         *
         * The following fields are required:
         * ```java
         * .space()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SpaceRetrieveResponse]. */
    class Builder internal constructor() {

        private var space: JsonField<Space>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(spaceRetrieveResponse: SpaceRetrieveResponse) = apply {
            space = spaceRetrieveResponse.space
            additionalProperties = spaceRetrieveResponse.additionalProperties.toMutableMap()
        }

        /** X Space */
        fun space(space: Space) = space(JsonField.of(space))

        /** Sets [Builder.space] to an arbitrary JSON value. */
        fun space(space: JsonField<Space>) = apply { this.space = space }

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
         * Returns an immutable instance of [SpaceRetrieveResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .space()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SpaceRetrieveResponse =
            SpaceRetrieveResponse(
                checkRequired("space", space),
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
    fun validate(): SpaceRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        space().validate()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: XTwitterScraperInvalidDataException) {
            false
        }

    @JvmSynthetic internal fun validity(): Int = (space.asKnown().getOrNull()?.validity() ?: 0)

    /** X Space */
    class Space
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val admins: JsonField<List<Admin>>,
        private val id: JsonField<String>,
        private val listeners: JsonField<List<Listener>>,
        private val speakers: JsonField<List<Speaker>>,
        private val contentType: JsonField<String>,
        private val conversationControls: JsonField<Long>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val creator: JsonField<UserProfile>,
        private val disallowJoin: JsonField<Boolean>,
        private val endedAt: JsonField<OffsetDateTime>,
        private val isAvailableForClipping: JsonField<Boolean>,
        private val isAvailableForReplay: JsonField<Boolean>,
        private val isEmployeeOnly: JsonField<Boolean>,
        private val isLocked: JsonField<Boolean>,
        private val maxAdminCapacity: JsonField<Long>,
        private val mediaKey: JsonField<String>,
        private val mentionedUserIds: JsonField<List<String>>,
        private val noIncognito: JsonField<Boolean>,
        private val participantCount: JsonField<Long>,
        private val scheduledStart: JsonField<OffsetDateTime>,
        private val sharings: JsonField<List<Sharing>>,
        private val startedAt: JsonField<OffsetDateTime>,
        private val state: JsonField<String>,
        private val title: JsonField<String>,
        private val totalLiveListeners: JsonField<Long>,
        private val totalReplayWatched: JsonField<Long>,
        private val tweet: JsonField<SearchTweet>,
        private val tweetId: JsonField<String>,
        private val updatedAt: JsonField<OffsetDateTime>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("admins")
            @ExcludeMissing
            admins: JsonField<List<Admin>> = JsonMissing.of(),
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("listeners")
            @ExcludeMissing
            listeners: JsonField<List<Listener>> = JsonMissing.of(),
            @JsonProperty("speakers")
            @ExcludeMissing
            speakers: JsonField<List<Speaker>> = JsonMissing.of(),
            @JsonProperty("contentType")
            @ExcludeMissing
            contentType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("conversationControls")
            @ExcludeMissing
            conversationControls: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("creator")
            @ExcludeMissing
            creator: JsonField<UserProfile> = JsonMissing.of(),
            @JsonProperty("disallowJoin")
            @ExcludeMissing
            disallowJoin: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("endedAt")
            @ExcludeMissing
            endedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("isAvailableForClipping")
            @ExcludeMissing
            isAvailableForClipping: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("isAvailableForReplay")
            @ExcludeMissing
            isAvailableForReplay: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("isEmployeeOnly")
            @ExcludeMissing
            isEmployeeOnly: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("isLocked")
            @ExcludeMissing
            isLocked: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("maxAdminCapacity")
            @ExcludeMissing
            maxAdminCapacity: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("mediaKey")
            @ExcludeMissing
            mediaKey: JsonField<String> = JsonMissing.of(),
            @JsonProperty("mentionedUserIds")
            @ExcludeMissing
            mentionedUserIds: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("noIncognito")
            @ExcludeMissing
            noIncognito: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("participantCount")
            @ExcludeMissing
            participantCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("scheduledStart")
            @ExcludeMissing
            scheduledStart: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("sharings")
            @ExcludeMissing
            sharings: JsonField<List<Sharing>> = JsonMissing.of(),
            @JsonProperty("startedAt")
            @ExcludeMissing
            startedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("state") @ExcludeMissing state: JsonField<String> = JsonMissing.of(),
            @JsonProperty("title") @ExcludeMissing title: JsonField<String> = JsonMissing.of(),
            @JsonProperty("totalLiveListeners")
            @ExcludeMissing
            totalLiveListeners: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("totalReplayWatched")
            @ExcludeMissing
            totalReplayWatched: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("tweet") @ExcludeMissing tweet: JsonField<SearchTweet> = JsonMissing.of(),
            @JsonProperty("tweetId") @ExcludeMissing tweetId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("updatedAt")
            @ExcludeMissing
            updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        ) : this(
            admins,
            id,
            listeners,
            speakers,
            contentType,
            conversationControls,
            createdAt,
            creator,
            disallowJoin,
            endedAt,
            isAvailableForClipping,
            isAvailableForReplay,
            isEmployeeOnly,
            isLocked,
            maxAdminCapacity,
            mediaKey,
            mentionedUserIds,
            noIncognito,
            participantCount,
            scheduledStart,
            sharings,
            startedAt,
            state,
            title,
            totalLiveListeners,
            totalReplayWatched,
            tweet,
            tweetId,
            updatedAt,
            mutableMapOf(),
        )

        /**
         * Hosts and co-hosts
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun admins(): List<Admin> = admins.getRequired("admins")

        /**
         * Space ID
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun id(): String = id.getRequired("id")

        /**
         * Accounts X lists as listeners
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun listeners(): List<Listener> = listeners.getRequired("listeners")

        /**
         * Accounts X lists as speakers
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun speakers(): List<Speaker> = speakers.getRequired("speakers")

        /**
         * Audio or video kind, as X names it
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun contentType(): Optional<String> = contentType.getOptional("contentType")

        /**
         * X's code for who may speak
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun conversationControls(): Optional<Long> =
            conversationControls.getOptional("conversationControls")

        /**
         * When the Space was made
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("createdAt")

        /**
         * Public X profile.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun creator(): Optional<UserProfile> = creator.getOptional("creator")

        /**
         * Whether X lets no more accounts join
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun disallowJoin(): Optional<Boolean> = disallowJoin.getOptional("disallowJoin")

        /**
         * When the Space ended
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun endedAt(): Optional<OffsetDateTime> = endedAt.getOptional("endedAt")

        /**
         * Whether listeners may clip the Space
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun isAvailableForClipping(): Optional<Boolean> =
            isAvailableForClipping.getOptional("isAvailableForClipping")

        /**
         * Whether X offers a recording
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun isAvailableForReplay(): Optional<Boolean> =
            isAvailableForReplay.getOptional("isAvailableForReplay")

        /**
         * Whether only X employees may join
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun isEmployeeOnly(): Optional<Boolean> = isEmployeeOnly.getOptional("isEmployeeOnly")

        /**
         * Whether the host locked the Space
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun isLocked(): Optional<Boolean> = isLocked.getOptional("isLocked")

        /**
         * Most hosts and co-hosts the Space allows
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun maxAdminCapacity(): Optional<Long> = maxAdminCapacity.getOptional("maxAdminCapacity")

        /**
         * X's media key for the Space's audio
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun mediaKey(): Optional<String> = mediaKey.getOptional("mediaKey")

        /**
         * IDs of the accounts the host tagged
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun mentionedUserIds(): Optional<List<String>> =
            mentionedUserIds.getOptional("mentionedUserIds")

        /**
         * Whether anonymous listening is off
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun noIncognito(): Optional<Boolean> = noIncognito.getOptional("noIncognito")

        /**
         * Accounts in the Space now, while it is live
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun participantCount(): Optional<Long> = participantCount.getOptional("participantCount")

        /**
         * When the Space was set to start
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun scheduledStart(): Optional<OffsetDateTime> =
            scheduledStart.getOptional("scheduledStart")

        /**
         * Posts the hosts and speakers shared in the Space, in X's order. Present only when X lists
         * them.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun sharings(): Optional<List<Sharing>> = sharings.getOptional("sharings")

        /**
         * When the Space went live
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun startedAt(): Optional<OffsetDateTime> = startedAt.getOptional("startedAt")

        /**
         * NotStarted (scheduled), Running (live), Ended, Canceled (scheduled, never started) or
         * TimedOut (closed by X, not by its host)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun state(): Optional<String> = state.getOptional("state")

        /**
         * Space title
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun title(): Optional<String> = title.getOptional("title")

        /**
         * Accounts that listened live
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun totalLiveListeners(): Optional<Long> =
            totalLiveListeners.getOptional("totalLiveListeners")

        /**
         * Accounts that played the recording
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun totalReplayWatched(): Optional<Long> =
            totalReplayWatched.getOptional("totalReplayWatched")

        /**
         * Search tweet with author. Zero metrics may mean X omitted counts.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun tweet(): Optional<SearchTweet> = tweet.getOptional("tweet")

        /**
         * ID of the post that announces the Space
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun tweetId(): Optional<String> = tweetId.getOptional("tweetId")

        /**
         * When X last changed the Space
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updatedAt")

        /**
         * Returns the raw JSON value of [admins].
         *
         * Unlike [admins], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("admins") @ExcludeMissing fun _admins(): JsonField<List<Admin>> = admins

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [listeners].
         *
         * Unlike [listeners], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("listeners")
        @ExcludeMissing
        fun _listeners(): JsonField<List<Listener>> = listeners

        /**
         * Returns the raw JSON value of [speakers].
         *
         * Unlike [speakers], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("speakers")
        @ExcludeMissing
        fun _speakers(): JsonField<List<Speaker>> = speakers

        /**
         * Returns the raw JSON value of [contentType].
         *
         * Unlike [contentType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("contentType")
        @ExcludeMissing
        fun _contentType(): JsonField<String> = contentType

        /**
         * Returns the raw JSON value of [conversationControls].
         *
         * Unlike [conversationControls], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("conversationControls")
        @ExcludeMissing
        fun _conversationControls(): JsonField<Long> = conversationControls

        /**
         * Returns the raw JSON value of [createdAt].
         *
         * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("createdAt")
        @ExcludeMissing
        fun _createdAt(): JsonField<OffsetDateTime> = createdAt

        /**
         * Returns the raw JSON value of [creator].
         *
         * Unlike [creator], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("creator") @ExcludeMissing fun _creator(): JsonField<UserProfile> = creator

        /**
         * Returns the raw JSON value of [disallowJoin].
         *
         * Unlike [disallowJoin], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("disallowJoin")
        @ExcludeMissing
        fun _disallowJoin(): JsonField<Boolean> = disallowJoin

        /**
         * Returns the raw JSON value of [endedAt].
         *
         * Unlike [endedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("endedAt") @ExcludeMissing fun _endedAt(): JsonField<OffsetDateTime> = endedAt

        /**
         * Returns the raw JSON value of [isAvailableForClipping].
         *
         * Unlike [isAvailableForClipping], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("isAvailableForClipping")
        @ExcludeMissing
        fun _isAvailableForClipping(): JsonField<Boolean> = isAvailableForClipping

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
         * Returns the raw JSON value of [isEmployeeOnly].
         *
         * Unlike [isEmployeeOnly], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("isEmployeeOnly")
        @ExcludeMissing
        fun _isEmployeeOnly(): JsonField<Boolean> = isEmployeeOnly

        /**
         * Returns the raw JSON value of [isLocked].
         *
         * Unlike [isLocked], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("isLocked") @ExcludeMissing fun _isLocked(): JsonField<Boolean> = isLocked

        /**
         * Returns the raw JSON value of [maxAdminCapacity].
         *
         * Unlike [maxAdminCapacity], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("maxAdminCapacity")
        @ExcludeMissing
        fun _maxAdminCapacity(): JsonField<Long> = maxAdminCapacity

        /**
         * Returns the raw JSON value of [mediaKey].
         *
         * Unlike [mediaKey], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("mediaKey") @ExcludeMissing fun _mediaKey(): JsonField<String> = mediaKey

        /**
         * Returns the raw JSON value of [mentionedUserIds].
         *
         * Unlike [mentionedUserIds], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("mentionedUserIds")
        @ExcludeMissing
        fun _mentionedUserIds(): JsonField<List<String>> = mentionedUserIds

        /**
         * Returns the raw JSON value of [noIncognito].
         *
         * Unlike [noIncognito], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("noIncognito")
        @ExcludeMissing
        fun _noIncognito(): JsonField<Boolean> = noIncognito

        /**
         * Returns the raw JSON value of [participantCount].
         *
         * Unlike [participantCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("participantCount")
        @ExcludeMissing
        fun _participantCount(): JsonField<Long> = participantCount

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
         * Returns the raw JSON value of [sharings].
         *
         * Unlike [sharings], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sharings")
        @ExcludeMissing
        fun _sharings(): JsonField<List<Sharing>> = sharings

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
         * Returns the raw JSON value of [totalLiveListeners].
         *
         * Unlike [totalLiveListeners], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("totalLiveListeners")
        @ExcludeMissing
        fun _totalLiveListeners(): JsonField<Long> = totalLiveListeners

        /**
         * Returns the raw JSON value of [totalReplayWatched].
         *
         * Unlike [totalReplayWatched], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("totalReplayWatched")
        @ExcludeMissing
        fun _totalReplayWatched(): JsonField<Long> = totalReplayWatched

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
         * Returns the raw JSON value of [updatedAt].
         *
         * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("updatedAt")
        @ExcludeMissing
        fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

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
             * Returns a mutable builder for constructing an instance of [Space].
             *
             * The following fields are required:
             * ```java
             * .admins()
             * .id()
             * .listeners()
             * .speakers()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Space]. */
        class Builder internal constructor() {

            private var admins: JsonField<MutableList<Admin>>? = null
            private var id: JsonField<String>? = null
            private var listeners: JsonField<MutableList<Listener>>? = null
            private var speakers: JsonField<MutableList<Speaker>>? = null
            private var contentType: JsonField<String> = JsonMissing.of()
            private var conversationControls: JsonField<Long> = JsonMissing.of()
            private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var creator: JsonField<UserProfile> = JsonMissing.of()
            private var disallowJoin: JsonField<Boolean> = JsonMissing.of()
            private var endedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var isAvailableForClipping: JsonField<Boolean> = JsonMissing.of()
            private var isAvailableForReplay: JsonField<Boolean> = JsonMissing.of()
            private var isEmployeeOnly: JsonField<Boolean> = JsonMissing.of()
            private var isLocked: JsonField<Boolean> = JsonMissing.of()
            private var maxAdminCapacity: JsonField<Long> = JsonMissing.of()
            private var mediaKey: JsonField<String> = JsonMissing.of()
            private var mentionedUserIds: JsonField<MutableList<String>>? = null
            private var noIncognito: JsonField<Boolean> = JsonMissing.of()
            private var participantCount: JsonField<Long> = JsonMissing.of()
            private var scheduledStart: JsonField<OffsetDateTime> = JsonMissing.of()
            private var sharings: JsonField<MutableList<Sharing>>? = null
            private var startedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var state: JsonField<String> = JsonMissing.of()
            private var title: JsonField<String> = JsonMissing.of()
            private var totalLiveListeners: JsonField<Long> = JsonMissing.of()
            private var totalReplayWatched: JsonField<Long> = JsonMissing.of()
            private var tweet: JsonField<SearchTweet> = JsonMissing.of()
            private var tweetId: JsonField<String> = JsonMissing.of()
            private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(space: Space) = apply {
                admins = space.admins.map { it.toMutableList() }
                id = space.id
                listeners = space.listeners.map { it.toMutableList() }
                speakers = space.speakers.map { it.toMutableList() }
                contentType = space.contentType
                conversationControls = space.conversationControls
                createdAt = space.createdAt
                creator = space.creator
                disallowJoin = space.disallowJoin
                endedAt = space.endedAt
                isAvailableForClipping = space.isAvailableForClipping
                isAvailableForReplay = space.isAvailableForReplay
                isEmployeeOnly = space.isEmployeeOnly
                isLocked = space.isLocked
                maxAdminCapacity = space.maxAdminCapacity
                mediaKey = space.mediaKey
                mentionedUserIds = space.mentionedUserIds.map { it.toMutableList() }
                noIncognito = space.noIncognito
                participantCount = space.participantCount
                scheduledStart = space.scheduledStart
                sharings = space.sharings.map { it.toMutableList() }
                startedAt = space.startedAt
                state = space.state
                title = space.title
                totalLiveListeners = space.totalLiveListeners
                totalReplayWatched = space.totalReplayWatched
                tweet = space.tweet
                tweetId = space.tweetId
                updatedAt = space.updatedAt
                additionalProperties = space.additionalProperties.toMutableMap()
            }

            /** Hosts and co-hosts */
            fun admins(admins: List<Admin>) = admins(JsonField.of(admins))

            /** Sets [Builder.admins] to an arbitrary JSON value. */
            fun admins(admins: JsonField<List<Admin>>) = apply {
                this.admins = admins.map { it.toMutableList() }
            }

            /**
             * Adds a single [Admin] to [admins].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addAdmin(admin: Admin) = apply {
                admins =
                    (admins ?: JsonField.of(mutableListOf())).also {
                        checkKnown("admins", it).add(admin)
                    }
            }

            /** Space ID */
            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Accounts X lists as listeners */
            fun listeners(listeners: List<Listener>) = listeners(JsonField.of(listeners))

            /** Sets [Builder.listeners] to an arbitrary JSON value. */
            fun listeners(listeners: JsonField<List<Listener>>) = apply {
                this.listeners = listeners.map { it.toMutableList() }
            }

            /**
             * Adds a single [Listener] to [listeners].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addListener(listener: Listener) = apply {
                listeners =
                    (listeners ?: JsonField.of(mutableListOf())).also {
                        checkKnown("listeners", it).add(listener)
                    }
            }

            /** Accounts X lists as speakers */
            fun speakers(speakers: List<Speaker>) = speakers(JsonField.of(speakers))

            /** Sets [Builder.speakers] to an arbitrary JSON value. */
            fun speakers(speakers: JsonField<List<Speaker>>) = apply {
                this.speakers = speakers.map { it.toMutableList() }
            }

            /**
             * Adds a single [Speaker] to [speakers].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addSpeaker(speaker: Speaker) = apply {
                speakers =
                    (speakers ?: JsonField.of(mutableListOf())).also {
                        checkKnown("speakers", it).add(speaker)
                    }
            }

            /** Audio or video kind, as X names it */
            fun contentType(contentType: String) = contentType(JsonField.of(contentType))

            /** Sets [Builder.contentType] to an arbitrary JSON value. */
            fun contentType(contentType: JsonField<String>) = apply {
                this.contentType = contentType
            }

            /** X's code for who may speak */
            fun conversationControls(conversationControls: Long) =
                conversationControls(JsonField.of(conversationControls))

            /** Sets [Builder.conversationControls] to an arbitrary JSON value. */
            fun conversationControls(conversationControls: JsonField<Long>) = apply {
                this.conversationControls = conversationControls
            }

            /** When the Space was made */
            fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

            /** Sets [Builder.createdAt] to an arbitrary JSON value. */
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                this.createdAt = createdAt
            }

            /** Public X profile. */
            fun creator(creator: UserProfile) = creator(JsonField.of(creator))

            /** Sets [Builder.creator] to an arbitrary JSON value. */
            fun creator(creator: JsonField<UserProfile>) = apply { this.creator = creator }

            /** Whether X lets no more accounts join */
            fun disallowJoin(disallowJoin: Boolean) = disallowJoin(JsonField.of(disallowJoin))

            /** Sets [Builder.disallowJoin] to an arbitrary JSON value. */
            fun disallowJoin(disallowJoin: JsonField<Boolean>) = apply {
                this.disallowJoin = disallowJoin
            }

            /** When the Space ended */
            fun endedAt(endedAt: OffsetDateTime) = endedAt(JsonField.of(endedAt))

            /** Sets [Builder.endedAt] to an arbitrary JSON value. */
            fun endedAt(endedAt: JsonField<OffsetDateTime>) = apply { this.endedAt = endedAt }

            /** Whether listeners may clip the Space */
            fun isAvailableForClipping(isAvailableForClipping: Boolean) =
                isAvailableForClipping(JsonField.of(isAvailableForClipping))

            /** Sets [Builder.isAvailableForClipping] to an arbitrary JSON value. */
            fun isAvailableForClipping(isAvailableForClipping: JsonField<Boolean>) = apply {
                this.isAvailableForClipping = isAvailableForClipping
            }

            /** Whether X offers a recording */
            fun isAvailableForReplay(isAvailableForReplay: Boolean) =
                isAvailableForReplay(JsonField.of(isAvailableForReplay))

            /** Sets [Builder.isAvailableForReplay] to an arbitrary JSON value. */
            fun isAvailableForReplay(isAvailableForReplay: JsonField<Boolean>) = apply {
                this.isAvailableForReplay = isAvailableForReplay
            }

            /** Whether only X employees may join */
            fun isEmployeeOnly(isEmployeeOnly: Boolean) =
                isEmployeeOnly(JsonField.of(isEmployeeOnly))

            /** Sets [Builder.isEmployeeOnly] to an arbitrary JSON value. */
            fun isEmployeeOnly(isEmployeeOnly: JsonField<Boolean>) = apply {
                this.isEmployeeOnly = isEmployeeOnly
            }

            /** Whether the host locked the Space */
            fun isLocked(isLocked: Boolean) = isLocked(JsonField.of(isLocked))

            /** Sets [Builder.isLocked] to an arbitrary JSON value. */
            fun isLocked(isLocked: JsonField<Boolean>) = apply { this.isLocked = isLocked }

            /** Most hosts and co-hosts the Space allows */
            fun maxAdminCapacity(maxAdminCapacity: Long) =
                maxAdminCapacity(JsonField.of(maxAdminCapacity))

            /** Sets [Builder.maxAdminCapacity] to an arbitrary JSON value. */
            fun maxAdminCapacity(maxAdminCapacity: JsonField<Long>) = apply {
                this.maxAdminCapacity = maxAdminCapacity
            }

            /** X's media key for the Space's audio */
            fun mediaKey(mediaKey: String) = mediaKey(JsonField.of(mediaKey))

            /** Sets [Builder.mediaKey] to an arbitrary JSON value. */
            fun mediaKey(mediaKey: JsonField<String>) = apply { this.mediaKey = mediaKey }

            /** IDs of the accounts the host tagged */
            fun mentionedUserIds(mentionedUserIds: List<String>) =
                mentionedUserIds(JsonField.of(mentionedUserIds))

            /** Sets [Builder.mentionedUserIds] to an arbitrary JSON value. */
            fun mentionedUserIds(mentionedUserIds: JsonField<List<String>>) = apply {
                this.mentionedUserIds = mentionedUserIds.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [mentionedUserIds].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addMentionedUserId(mentionedUserId: String) = apply {
                mentionedUserIds =
                    (mentionedUserIds ?: JsonField.of(mutableListOf())).also {
                        checkKnown("mentionedUserIds", it).add(mentionedUserId)
                    }
            }

            /** Whether anonymous listening is off */
            fun noIncognito(noIncognito: Boolean) = noIncognito(JsonField.of(noIncognito))

            /** Sets [Builder.noIncognito] to an arbitrary JSON value. */
            fun noIncognito(noIncognito: JsonField<Boolean>) = apply {
                this.noIncognito = noIncognito
            }

            /** Accounts in the Space now, while it is live */
            fun participantCount(participantCount: Long) =
                participantCount(JsonField.of(participantCount))

            /** Sets [Builder.participantCount] to an arbitrary JSON value. */
            fun participantCount(participantCount: JsonField<Long>) = apply {
                this.participantCount = participantCount
            }

            /** When the Space was set to start */
            fun scheduledStart(scheduledStart: OffsetDateTime) =
                scheduledStart(JsonField.of(scheduledStart))

            /** Sets [Builder.scheduledStart] to an arbitrary JSON value. */
            fun scheduledStart(scheduledStart: JsonField<OffsetDateTime>) = apply {
                this.scheduledStart = scheduledStart
            }

            /**
             * Posts the hosts and speakers shared in the Space, in X's order. Present only when X
             * lists them.
             */
            fun sharings(sharings: List<Sharing>) = sharings(JsonField.of(sharings))

            /** Sets [Builder.sharings] to an arbitrary JSON value. */
            fun sharings(sharings: JsonField<List<Sharing>>) = apply {
                this.sharings = sharings.map { it.toMutableList() }
            }

            /**
             * Adds a single [Sharing] to [sharings].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addSharing(sharing: Sharing) = apply {
                sharings =
                    (sharings ?: JsonField.of(mutableListOf())).also {
                        checkKnown("sharings", it).add(sharing)
                    }
            }

            /** When the Space went live */
            fun startedAt(startedAt: OffsetDateTime) = startedAt(JsonField.of(startedAt))

            /** Sets [Builder.startedAt] to an arbitrary JSON value. */
            fun startedAt(startedAt: JsonField<OffsetDateTime>) = apply {
                this.startedAt = startedAt
            }

            /**
             * NotStarted (scheduled), Running (live), Ended, Canceled (scheduled, never started) or
             * TimedOut (closed by X, not by its host)
             */
            fun state(state: String) = state(JsonField.of(state))

            /** Sets [Builder.state] to an arbitrary JSON value. */
            fun state(state: JsonField<String>) = apply { this.state = state }

            /** Space title */
            fun title(title: String) = title(JsonField.of(title))

            /** Sets [Builder.title] to an arbitrary JSON value. */
            fun title(title: JsonField<String>) = apply { this.title = title }

            /** Accounts that listened live */
            fun totalLiveListeners(totalLiveListeners: Long) =
                totalLiveListeners(JsonField.of(totalLiveListeners))

            /** Sets [Builder.totalLiveListeners] to an arbitrary JSON value. */
            fun totalLiveListeners(totalLiveListeners: JsonField<Long>) = apply {
                this.totalLiveListeners = totalLiveListeners
            }

            /** Accounts that played the recording */
            fun totalReplayWatched(totalReplayWatched: Long) =
                totalReplayWatched(JsonField.of(totalReplayWatched))

            /** Sets [Builder.totalReplayWatched] to an arbitrary JSON value. */
            fun totalReplayWatched(totalReplayWatched: JsonField<Long>) = apply {
                this.totalReplayWatched = totalReplayWatched
            }

            /** Search tweet with author. Zero metrics may mean X omitted counts. */
            fun tweet(tweet: SearchTweet) = tweet(JsonField.of(tweet))

            /** Sets [Builder.tweet] to an arbitrary JSON value. */
            fun tweet(tweet: JsonField<SearchTweet>) = apply { this.tweet = tweet }

            /** ID of the post that announces the Space */
            fun tweetId(tweetId: String) = tweetId(JsonField.of(tweetId))

            /** Sets [Builder.tweetId] to an arbitrary JSON value. */
            fun tweetId(tweetId: JsonField<String>) = apply { this.tweetId = tweetId }

            /** When X last changed the Space */
            fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

            /** Sets [Builder.updatedAt] to an arbitrary JSON value. */
            fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply {
                this.updatedAt = updatedAt
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
             * Returns an immutable instance of [Space].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .admins()
             * .id()
             * .listeners()
             * .speakers()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Space =
                Space(
                    checkRequired("admins", admins).map { it.toImmutable() },
                    checkRequired("id", id),
                    checkRequired("listeners", listeners).map { it.toImmutable() },
                    checkRequired("speakers", speakers).map { it.toImmutable() },
                    contentType,
                    conversationControls,
                    createdAt,
                    creator,
                    disallowJoin,
                    endedAt,
                    isAvailableForClipping,
                    isAvailableForReplay,
                    isEmployeeOnly,
                    isLocked,
                    maxAdminCapacity,
                    mediaKey,
                    (mentionedUserIds ?: JsonMissing.of()).map { it.toImmutable() },
                    noIncognito,
                    participantCount,
                    scheduledStart,
                    (sharings ?: JsonMissing.of()).map { it.toImmutable() },
                    startedAt,
                    state,
                    title,
                    totalLiveListeners,
                    totalReplayWatched,
                    tweet,
                    tweetId,
                    updatedAt,
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
        fun validate(): Space = apply {
            if (validated) {
                return@apply
            }

            admins().forEach { it.validate() }
            id()
            listeners().forEach { it.validate() }
            speakers().forEach { it.validate() }
            contentType()
            conversationControls()
            createdAt()
            creator().ifPresent { it.validate() }
            disallowJoin()
            endedAt()
            isAvailableForClipping()
            isAvailableForReplay()
            isEmployeeOnly()
            isLocked()
            maxAdminCapacity()
            mediaKey()
            mentionedUserIds()
            noIncognito()
            participantCount()
            scheduledStart()
            sharings().ifPresent { it.forEach { it.validate() } }
            startedAt()
            state()
            title()
            totalLiveListeners()
            totalReplayWatched()
            tweet().ifPresent { it.validate() }
            tweetId()
            updatedAt()
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
            (admins.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (id.asKnown().isPresent) 1 else 0) +
                (listeners.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (speakers.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (contentType.asKnown().isPresent) 1 else 0) +
                (if (conversationControls.asKnown().isPresent) 1 else 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (creator.asKnown().getOrNull()?.validity() ?: 0) +
                (if (disallowJoin.asKnown().isPresent) 1 else 0) +
                (if (endedAt.asKnown().isPresent) 1 else 0) +
                (if (isAvailableForClipping.asKnown().isPresent) 1 else 0) +
                (if (isAvailableForReplay.asKnown().isPresent) 1 else 0) +
                (if (isEmployeeOnly.asKnown().isPresent) 1 else 0) +
                (if (isLocked.asKnown().isPresent) 1 else 0) +
                (if (maxAdminCapacity.asKnown().isPresent) 1 else 0) +
                (if (mediaKey.asKnown().isPresent) 1 else 0) +
                (mentionedUserIds.asKnown().getOrNull()?.size ?: 0) +
                (if (noIncognito.asKnown().isPresent) 1 else 0) +
                (if (participantCount.asKnown().isPresent) 1 else 0) +
                (if (scheduledStart.asKnown().isPresent) 1 else 0) +
                (sharings.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (startedAt.asKnown().isPresent) 1 else 0) +
                (if (state.asKnown().isPresent) 1 else 0) +
                (if (title.asKnown().isPresent) 1 else 0) +
                (if (totalLiveListeners.asKnown().isPresent) 1 else 0) +
                (if (totalReplayWatched.asKnown().isPresent) 1 else 0) +
                (tweet.asKnown().getOrNull()?.validity() ?: 0) +
                (if (tweetId.asKnown().isPresent) 1 else 0) +
                (if (updatedAt.asKnown().isPresent) 1 else 0)

        /** An account on a Space's stage or in its audience, as X lists it there. */
        class Admin
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val name: JsonField<String>,
            private val username: JsonField<String>,
            private val affiliatesHighlightedLabel: JsonField<AffiliatesHighlightedLabel>,
            private val isBlueVerified: JsonField<Boolean>,
            private val isMutedByAdmin: JsonField<Boolean>,
            private val isMutedByGuest: JsonField<Boolean>,
            private val isVerified: JsonField<Boolean>,
            private val joinedAt: JsonField<OffsetDateTime>,
            private val periscopeUserId: JsonField<String>,
            private val profilePicture: JsonField<String>,
            private val profilePictureOriginal: JsonField<String>,
            private val verifiedType: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("username")
                @ExcludeMissing
                username: JsonField<String> = JsonMissing.of(),
                @JsonProperty("affiliatesHighlightedLabel")
                @ExcludeMissing
                affiliatesHighlightedLabel: JsonField<AffiliatesHighlightedLabel> =
                    JsonMissing.of(),
                @JsonProperty("isBlueVerified")
                @ExcludeMissing
                isBlueVerified: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("isMutedByAdmin")
                @ExcludeMissing
                isMutedByAdmin: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("isMutedByGuest")
                @ExcludeMissing
                isMutedByGuest: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("isVerified")
                @ExcludeMissing
                isVerified: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("joinedAt")
                @ExcludeMissing
                joinedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
                @JsonProperty("periscopeUserId")
                @ExcludeMissing
                periscopeUserId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profilePicture")
                @ExcludeMissing
                profilePicture: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profilePictureOriginal")
                @ExcludeMissing
                profilePictureOriginal: JsonField<String> = JsonMissing.of(),
                @JsonProperty("verifiedType")
                @ExcludeMissing
                verifiedType: JsonField<String> = JsonMissing.of(),
            ) : this(
                id,
                name,
                username,
                affiliatesHighlightedLabel,
                isBlueVerified,
                isMutedByAdmin,
                isMutedByGuest,
                isVerified,
                joinedAt,
                periscopeUserId,
                profilePicture,
                profilePictureOriginal,
                verifiedType,
                mutableMapOf(),
            )

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun id(): String = id.getRequired("id")

            /**
             * Name the account shows in the Space
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun name(): String = name.getRequired("name")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun username(): String = username.getRequired("username")

            /**
             * Organization affiliation label shown on an X profile.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun affiliatesHighlightedLabel(): Optional<AffiliatesHighlightedLabel> =
                affiliatesHighlightedLabel.getOptional("affiliatesHighlightedLabel")

            /**
             * Whether the account has X Premium verification
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun isBlueVerified(): Optional<Boolean> = isBlueVerified.getOptional("isBlueVerified")

            /**
             * Whether a host muted the account
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun isMutedByAdmin(): Optional<Boolean> = isMutedByAdmin.getOptional("isMutedByAdmin")

            /**
             * Whether the account muted itself
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun isMutedByGuest(): Optional<Boolean> = isMutedByGuest.getOptional("isMutedByGuest")

            /**
             * Whether X shows a verified badge in the Space
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun isVerified(): Optional<Boolean> = isVerified.getOptional("isVerified")

            /**
             * When the account joined the Space
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun joinedAt(): Optional<OffsetDateTime> = joinedAt.getOptional("joinedAt")

            /**
             * The account's ID in X's broadcast service
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun periscopeUserId(): Optional<String> = periscopeUserId.getOptional("periscopeUserId")

            /**
             * Profile picture URL
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profilePicture(): Optional<String> = profilePicture.getOptional("profilePicture")

            /**
             * The participant's profile picture at full size
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profilePictureOriginal(): Optional<String> =
                profilePictureOriginal.getOptional("profilePictureOriginal")

            /**
             * Business or Government badge type
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun verifiedType(): Optional<String> = verifiedType.getOptional("verifiedType")

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
             * Unlike [username], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username

            /**
             * Returns the raw JSON value of [affiliatesHighlightedLabel].
             *
             * Unlike [affiliatesHighlightedLabel], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("affiliatesHighlightedLabel")
            @ExcludeMissing
            fun _affiliatesHighlightedLabel(): JsonField<AffiliatesHighlightedLabel> =
                affiliatesHighlightedLabel

            /**
             * Returns the raw JSON value of [isBlueVerified].
             *
             * Unlike [isBlueVerified], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("isBlueVerified")
            @ExcludeMissing
            fun _isBlueVerified(): JsonField<Boolean> = isBlueVerified

            /**
             * Returns the raw JSON value of [isMutedByAdmin].
             *
             * Unlike [isMutedByAdmin], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("isMutedByAdmin")
            @ExcludeMissing
            fun _isMutedByAdmin(): JsonField<Boolean> = isMutedByAdmin

            /**
             * Returns the raw JSON value of [isMutedByGuest].
             *
             * Unlike [isMutedByGuest], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("isMutedByGuest")
            @ExcludeMissing
            fun _isMutedByGuest(): JsonField<Boolean> = isMutedByGuest

            /**
             * Returns the raw JSON value of [isVerified].
             *
             * Unlike [isVerified], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("isVerified")
            @ExcludeMissing
            fun _isVerified(): JsonField<Boolean> = isVerified

            /**
             * Returns the raw JSON value of [joinedAt].
             *
             * Unlike [joinedAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("joinedAt")
            @ExcludeMissing
            fun _joinedAt(): JsonField<OffsetDateTime> = joinedAt

            /**
             * Returns the raw JSON value of [periscopeUserId].
             *
             * Unlike [periscopeUserId], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("periscopeUserId")
            @ExcludeMissing
            fun _periscopeUserId(): JsonField<String> = periscopeUserId

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
             * Returns the raw JSON value of [verifiedType].
             *
             * Unlike [verifiedType], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("verifiedType")
            @ExcludeMissing
            fun _verifiedType(): JsonField<String> = verifiedType

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
                 * Returns a mutable builder for constructing an instance of [Admin].
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

            /** A builder for [Admin]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var name: JsonField<String>? = null
                private var username: JsonField<String>? = null
                private var affiliatesHighlightedLabel: JsonField<AffiliatesHighlightedLabel> =
                    JsonMissing.of()
                private var isBlueVerified: JsonField<Boolean> = JsonMissing.of()
                private var isMutedByAdmin: JsonField<Boolean> = JsonMissing.of()
                private var isMutedByGuest: JsonField<Boolean> = JsonMissing.of()
                private var isVerified: JsonField<Boolean> = JsonMissing.of()
                private var joinedAt: JsonField<OffsetDateTime> = JsonMissing.of()
                private var periscopeUserId: JsonField<String> = JsonMissing.of()
                private var profilePicture: JsonField<String> = JsonMissing.of()
                private var profilePictureOriginal: JsonField<String> = JsonMissing.of()
                private var verifiedType: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(admin: Admin) = apply {
                    id = admin.id
                    name = admin.name
                    username = admin.username
                    affiliatesHighlightedLabel = admin.affiliatesHighlightedLabel
                    isBlueVerified = admin.isBlueVerified
                    isMutedByAdmin = admin.isMutedByAdmin
                    isMutedByGuest = admin.isMutedByGuest
                    isVerified = admin.isVerified
                    joinedAt = admin.joinedAt
                    periscopeUserId = admin.periscopeUserId
                    profilePicture = admin.profilePicture
                    profilePictureOriginal = admin.profilePictureOriginal
                    verifiedType = admin.verifiedType
                    additionalProperties = admin.additionalProperties.toMutableMap()
                }

                fun id(id: String) = id(JsonField.of(id))

                /** Sets [Builder.id] to an arbitrary JSON value. */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** Name the account shows in the Space */
                fun name(name: String) = name(JsonField.of(name))

                /** Sets [Builder.name] to an arbitrary JSON value. */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun username(username: String) = username(JsonField.of(username))

                /** Sets [Builder.username] to an arbitrary JSON value. */
                fun username(username: JsonField<String>) = apply { this.username = username }

                /** Organization affiliation label shown on an X profile. */
                fun affiliatesHighlightedLabel(
                    affiliatesHighlightedLabel: AffiliatesHighlightedLabel
                ) = affiliatesHighlightedLabel(JsonField.of(affiliatesHighlightedLabel))

                /** Sets [Builder.affiliatesHighlightedLabel] to an arbitrary JSON value. */
                fun affiliatesHighlightedLabel(
                    affiliatesHighlightedLabel: JsonField<AffiliatesHighlightedLabel>
                ) = apply { this.affiliatesHighlightedLabel = affiliatesHighlightedLabel }

                /** Whether the account has X Premium verification */
                fun isBlueVerified(isBlueVerified: Boolean) =
                    isBlueVerified(JsonField.of(isBlueVerified))

                /** Sets [Builder.isBlueVerified] to an arbitrary JSON value. */
                fun isBlueVerified(isBlueVerified: JsonField<Boolean>) = apply {
                    this.isBlueVerified = isBlueVerified
                }

                /** Whether a host muted the account */
                fun isMutedByAdmin(isMutedByAdmin: Boolean) =
                    isMutedByAdmin(JsonField.of(isMutedByAdmin))

                /** Sets [Builder.isMutedByAdmin] to an arbitrary JSON value. */
                fun isMutedByAdmin(isMutedByAdmin: JsonField<Boolean>) = apply {
                    this.isMutedByAdmin = isMutedByAdmin
                }

                /** Whether the account muted itself */
                fun isMutedByGuest(isMutedByGuest: Boolean) =
                    isMutedByGuest(JsonField.of(isMutedByGuest))

                /** Sets [Builder.isMutedByGuest] to an arbitrary JSON value. */
                fun isMutedByGuest(isMutedByGuest: JsonField<Boolean>) = apply {
                    this.isMutedByGuest = isMutedByGuest
                }

                /** Whether X shows a verified badge in the Space */
                fun isVerified(isVerified: Boolean) = isVerified(JsonField.of(isVerified))

                /** Sets [Builder.isVerified] to an arbitrary JSON value. */
                fun isVerified(isVerified: JsonField<Boolean>) = apply {
                    this.isVerified = isVerified
                }

                /** When the account joined the Space */
                fun joinedAt(joinedAt: OffsetDateTime) = joinedAt(JsonField.of(joinedAt))

                /** Sets [Builder.joinedAt] to an arbitrary JSON value. */
                fun joinedAt(joinedAt: JsonField<OffsetDateTime>) = apply {
                    this.joinedAt = joinedAt
                }

                /** The account's ID in X's broadcast service */
                fun periscopeUserId(periscopeUserId: String) =
                    periscopeUserId(JsonField.of(periscopeUserId))

                /** Sets [Builder.periscopeUserId] to an arbitrary JSON value. */
                fun periscopeUserId(periscopeUserId: JsonField<String>) = apply {
                    this.periscopeUserId = periscopeUserId
                }

                /** Profile picture URL */
                fun profilePicture(profilePicture: String) =
                    profilePicture(JsonField.of(profilePicture))

                /** Sets [Builder.profilePicture] to an arbitrary JSON value. */
                fun profilePicture(profilePicture: JsonField<String>) = apply {
                    this.profilePicture = profilePicture
                }

                /** The participant's profile picture at full size */
                fun profilePictureOriginal(profilePictureOriginal: String) =
                    profilePictureOriginal(JsonField.of(profilePictureOriginal))

                /** Sets [Builder.profilePictureOriginal] to an arbitrary JSON value. */
                fun profilePictureOriginal(profilePictureOriginal: JsonField<String>) = apply {
                    this.profilePictureOriginal = profilePictureOriginal
                }

                /** Business or Government badge type */
                fun verifiedType(verifiedType: String) = verifiedType(JsonField.of(verifiedType))

                /** Sets [Builder.verifiedType] to an arbitrary JSON value. */
                fun verifiedType(verifiedType: JsonField<String>) = apply {
                    this.verifiedType = verifiedType
                }

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
                 * Returns an immutable instance of [Admin].
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
                fun build(): Admin =
                    Admin(
                        checkRequired("id", id),
                        checkRequired("name", name),
                        checkRequired("username", username),
                        affiliatesHighlightedLabel,
                        isBlueVerified,
                        isMutedByAdmin,
                        isMutedByGuest,
                        isVerified,
                        joinedAt,
                        periscopeUserId,
                        profilePicture,
                        profilePictureOriginal,
                        verifiedType,
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
            fun validate(): Admin = apply {
                if (validated) {
                    return@apply
                }

                id()
                name()
                username()
                affiliatesHighlightedLabel().ifPresent { it.validate() }
                isBlueVerified()
                isMutedByAdmin()
                isMutedByGuest()
                isVerified()
                joinedAt()
                periscopeUserId()
                profilePicture()
                profilePictureOriginal()
                verifiedType()
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
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (username.asKnown().isPresent) 1 else 0) +
                    (affiliatesHighlightedLabel.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (isBlueVerified.asKnown().isPresent) 1 else 0) +
                    (if (isMutedByAdmin.asKnown().isPresent) 1 else 0) +
                    (if (isMutedByGuest.asKnown().isPresent) 1 else 0) +
                    (if (isVerified.asKnown().isPresent) 1 else 0) +
                    (if (joinedAt.asKnown().isPresent) 1 else 0) +
                    (if (periscopeUserId.asKnown().isPresent) 1 else 0) +
                    (if (profilePicture.asKnown().isPresent) 1 else 0) +
                    (if (profilePictureOriginal.asKnown().isPresent) 1 else 0) +
                    (if (verifiedType.asKnown().isPresent) 1 else 0)

            /** Organization affiliation label shown on an X profile. */
            class AffiliatesHighlightedLabel
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val badgeUrl: JsonField<String>,
                private val description: JsonField<String>,
                private val longDescription: JsonField<LongDescription>,
                private val url: JsonField<String>,
                private val urlType: JsonField<String>,
                private val userLabelDisplayType: JsonField<String>,
                private val userLabelType: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("badgeUrl")
                    @ExcludeMissing
                    badgeUrl: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("description")
                    @ExcludeMissing
                    description: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("longDescription")
                    @ExcludeMissing
                    longDescription: JsonField<LongDescription> = JsonMissing.of(),
                    @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("urlType")
                    @ExcludeMissing
                    urlType: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("userLabelDisplayType")
                    @ExcludeMissing
                    userLabelDisplayType: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("userLabelType")
                    @ExcludeMissing
                    userLabelType: JsonField<String> = JsonMissing.of(),
                ) : this(
                    badgeUrl,
                    description,
                    longDescription,
                    url,
                    urlType,
                    userLabelDisplayType,
                    userLabelType,
                    mutableMapOf(),
                )

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun badgeUrl(): Optional<String> = badgeUrl.getOptional("badgeUrl")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun description(): Optional<String> = description.getOptional("description")

                /**
                 * Public text, ranges, references, and mention data.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun longDescription(): Optional<LongDescription> =
                    longDescription.getOptional("longDescription")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun url(): Optional<String> = url.getOptional("url")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun urlType(): Optional<String> = urlType.getOptional("urlType")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun userLabelDisplayType(): Optional<String> =
                    userLabelDisplayType.getOptional("userLabelDisplayType")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun userLabelType(): Optional<String> = userLabelType.getOptional("userLabelType")

                /**
                 * Returns the raw JSON value of [badgeUrl].
                 *
                 * Unlike [badgeUrl], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("badgeUrl")
                @ExcludeMissing
                fun _badgeUrl(): JsonField<String> = badgeUrl

                /**
                 * Returns the raw JSON value of [description].
                 *
                 * Unlike [description], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("description")
                @ExcludeMissing
                fun _description(): JsonField<String> = description

                /**
                 * Returns the raw JSON value of [longDescription].
                 *
                 * Unlike [longDescription], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("longDescription")
                @ExcludeMissing
                fun _longDescription(): JsonField<LongDescription> = longDescription

                /**
                 * Returns the raw JSON value of [url].
                 *
                 * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

                /**
                 * Returns the raw JSON value of [urlType].
                 *
                 * Unlike [urlType], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("urlType") @ExcludeMissing fun _urlType(): JsonField<String> = urlType

                /**
                 * Returns the raw JSON value of [userLabelDisplayType].
                 *
                 * Unlike [userLabelDisplayType], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("userLabelDisplayType")
                @ExcludeMissing
                fun _userLabelDisplayType(): JsonField<String> = userLabelDisplayType

                /**
                 * Returns the raw JSON value of [userLabelType].
                 *
                 * Unlike [userLabelType], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("userLabelType")
                @ExcludeMissing
                fun _userLabelType(): JsonField<String> = userLabelType

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
                     * [AffiliatesHighlightedLabel].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [AffiliatesHighlightedLabel]. */
                class Builder internal constructor() {

                    private var badgeUrl: JsonField<String> = JsonMissing.of()
                    private var description: JsonField<String> = JsonMissing.of()
                    private var longDescription: JsonField<LongDescription> = JsonMissing.of()
                    private var url: JsonField<String> = JsonMissing.of()
                    private var urlType: JsonField<String> = JsonMissing.of()
                    private var userLabelDisplayType: JsonField<String> = JsonMissing.of()
                    private var userLabelType: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(affiliatesHighlightedLabel: AffiliatesHighlightedLabel) =
                        apply {
                            badgeUrl = affiliatesHighlightedLabel.badgeUrl
                            description = affiliatesHighlightedLabel.description
                            longDescription = affiliatesHighlightedLabel.longDescription
                            url = affiliatesHighlightedLabel.url
                            urlType = affiliatesHighlightedLabel.urlType
                            userLabelDisplayType = affiliatesHighlightedLabel.userLabelDisplayType
                            userLabelType = affiliatesHighlightedLabel.userLabelType
                            additionalProperties =
                                affiliatesHighlightedLabel.additionalProperties.toMutableMap()
                        }

                    fun badgeUrl(badgeUrl: String) = badgeUrl(JsonField.of(badgeUrl))

                    /** Sets [Builder.badgeUrl] to an arbitrary JSON value. */
                    fun badgeUrl(badgeUrl: JsonField<String>) = apply { this.badgeUrl = badgeUrl }

                    fun description(description: String) = description(JsonField.of(description))

                    /** Sets [Builder.description] to an arbitrary JSON value. */
                    fun description(description: JsonField<String>) = apply {
                        this.description = description
                    }

                    /** Public text, ranges, references, and mention data. */
                    fun longDescription(longDescription: LongDescription) =
                        longDescription(JsonField.of(longDescription))

                    /** Sets [Builder.longDescription] to an arbitrary JSON value. */
                    fun longDescription(longDescription: JsonField<LongDescription>) = apply {
                        this.longDescription = longDescription
                    }

                    fun url(url: String) = url(JsonField.of(url))

                    /** Sets [Builder.url] to an arbitrary JSON value. */
                    fun url(url: JsonField<String>) = apply { this.url = url }

                    fun urlType(urlType: String) = urlType(JsonField.of(urlType))

                    /** Sets [Builder.urlType] to an arbitrary JSON value. */
                    fun urlType(urlType: JsonField<String>) = apply { this.urlType = urlType }

                    fun userLabelDisplayType(userLabelDisplayType: String) =
                        userLabelDisplayType(JsonField.of(userLabelDisplayType))

                    /** Sets [Builder.userLabelDisplayType] to an arbitrary JSON value. */
                    fun userLabelDisplayType(userLabelDisplayType: JsonField<String>) = apply {
                        this.userLabelDisplayType = userLabelDisplayType
                    }

                    fun userLabelType(userLabelType: String) =
                        userLabelType(JsonField.of(userLabelType))

                    /** Sets [Builder.userLabelType] to an arbitrary JSON value. */
                    fun userLabelType(userLabelType: JsonField<String>) = apply {
                        this.userLabelType = userLabelType
                    }

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
                     * Returns an immutable instance of [AffiliatesHighlightedLabel].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): AffiliatesHighlightedLabel =
                        AffiliatesHighlightedLabel(
                            badgeUrl,
                            description,
                            longDescription,
                            url,
                            urlType,
                            userLabelDisplayType,
                            userLabelType,
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
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): AffiliatesHighlightedLabel = apply {
                    if (validated) {
                        return@apply
                    }

                    badgeUrl()
                    description()
                    longDescription().ifPresent { it.validate() }
                    url()
                    urlType()
                    userLabelDisplayType()
                    userLabelType()
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
                    (if (badgeUrl.asKnown().isPresent) 1 else 0) +
                        (if (description.asKnown().isPresent) 1 else 0) +
                        (longDescription.asKnown().getOrNull()?.validity() ?: 0) +
                        (if (url.asKnown().isPresent) 1 else 0) +
                        (if (urlType.asKnown().isPresent) 1 else 0) +
                        (if (userLabelDisplayType.asKnown().isPresent) 1 else 0) +
                        (if (userLabelType.asKnown().isPresent) 1 else 0)

                /** Public metadata whose fields X defines. */
                class LongDescription
                @JsonCreator
                private constructor(
                    @com.fasterxml.jackson.annotation.JsonValue
                    private val additionalProperties: Map<String, JsonValue>
                ) {

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /**
                         * Returns a mutable builder for constructing an instance of
                         * [LongDescription].
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [LongDescription]. */
                    class Builder internal constructor() {

                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(longDescription: LongDescription) = apply {
                            additionalProperties =
                                longDescription.additionalProperties.toMutableMap()
                        }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [LongDescription].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): LongDescription =
                            LongDescription(additionalProperties.toImmutable())
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws XTwitterScraperInvalidDataException if any value type in this object
                     *   doesn't match its expected type.
                     */
                    fun validate(): LongDescription = apply {
                        if (validated) {
                            return@apply
                        }

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
                    internal fun validity(): Int = additionalProperties.count { (_, value) ->
                        !value.isNull() && !value.isMissing()
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is LongDescription &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "LongDescription{additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is AffiliatesHighlightedLabel &&
                        badgeUrl == other.badgeUrl &&
                        description == other.description &&
                        longDescription == other.longDescription &&
                        url == other.url &&
                        urlType == other.urlType &&
                        userLabelDisplayType == other.userLabelDisplayType &&
                        userLabelType == other.userLabelType &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        badgeUrl,
                        description,
                        longDescription,
                        url,
                        urlType,
                        userLabelDisplayType,
                        userLabelType,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "AffiliatesHighlightedLabel{badgeUrl=$badgeUrl, description=$description, longDescription=$longDescription, url=$url, urlType=$urlType, userLabelDisplayType=$userLabelDisplayType, userLabelType=$userLabelType, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Admin &&
                    id == other.id &&
                    name == other.name &&
                    username == other.username &&
                    affiliatesHighlightedLabel == other.affiliatesHighlightedLabel &&
                    isBlueVerified == other.isBlueVerified &&
                    isMutedByAdmin == other.isMutedByAdmin &&
                    isMutedByGuest == other.isMutedByGuest &&
                    isVerified == other.isVerified &&
                    joinedAt == other.joinedAt &&
                    periscopeUserId == other.periscopeUserId &&
                    profilePicture == other.profilePicture &&
                    profilePictureOriginal == other.profilePictureOriginal &&
                    verifiedType == other.verifiedType &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    id,
                    name,
                    username,
                    affiliatesHighlightedLabel,
                    isBlueVerified,
                    isMutedByAdmin,
                    isMutedByGuest,
                    isVerified,
                    joinedAt,
                    periscopeUserId,
                    profilePicture,
                    profilePictureOriginal,
                    verifiedType,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Admin{id=$id, name=$name, username=$username, affiliatesHighlightedLabel=$affiliatesHighlightedLabel, isBlueVerified=$isBlueVerified, isMutedByAdmin=$isMutedByAdmin, isMutedByGuest=$isMutedByGuest, isVerified=$isVerified, joinedAt=$joinedAt, periscopeUserId=$periscopeUserId, profilePicture=$profilePicture, profilePictureOriginal=$profilePictureOriginal, verifiedType=$verifiedType, additionalProperties=$additionalProperties}"
        }

        /** An account on a Space's stage or in its audience, as X lists it there. */
        class Listener
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val name: JsonField<String>,
            private val username: JsonField<String>,
            private val affiliatesHighlightedLabel: JsonField<AffiliatesHighlightedLabel>,
            private val isBlueVerified: JsonField<Boolean>,
            private val isMutedByAdmin: JsonField<Boolean>,
            private val isMutedByGuest: JsonField<Boolean>,
            private val isVerified: JsonField<Boolean>,
            private val joinedAt: JsonField<OffsetDateTime>,
            private val periscopeUserId: JsonField<String>,
            private val profilePicture: JsonField<String>,
            private val profilePictureOriginal: JsonField<String>,
            private val verifiedType: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("username")
                @ExcludeMissing
                username: JsonField<String> = JsonMissing.of(),
                @JsonProperty("affiliatesHighlightedLabel")
                @ExcludeMissing
                affiliatesHighlightedLabel: JsonField<AffiliatesHighlightedLabel> =
                    JsonMissing.of(),
                @JsonProperty("isBlueVerified")
                @ExcludeMissing
                isBlueVerified: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("isMutedByAdmin")
                @ExcludeMissing
                isMutedByAdmin: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("isMutedByGuest")
                @ExcludeMissing
                isMutedByGuest: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("isVerified")
                @ExcludeMissing
                isVerified: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("joinedAt")
                @ExcludeMissing
                joinedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
                @JsonProperty("periscopeUserId")
                @ExcludeMissing
                periscopeUserId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profilePicture")
                @ExcludeMissing
                profilePicture: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profilePictureOriginal")
                @ExcludeMissing
                profilePictureOriginal: JsonField<String> = JsonMissing.of(),
                @JsonProperty("verifiedType")
                @ExcludeMissing
                verifiedType: JsonField<String> = JsonMissing.of(),
            ) : this(
                id,
                name,
                username,
                affiliatesHighlightedLabel,
                isBlueVerified,
                isMutedByAdmin,
                isMutedByGuest,
                isVerified,
                joinedAt,
                periscopeUserId,
                profilePicture,
                profilePictureOriginal,
                verifiedType,
                mutableMapOf(),
            )

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun id(): String = id.getRequired("id")

            /**
             * Name the account shows in the Space
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun name(): String = name.getRequired("name")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun username(): String = username.getRequired("username")

            /**
             * Organization affiliation label shown on an X profile.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun affiliatesHighlightedLabel(): Optional<AffiliatesHighlightedLabel> =
                affiliatesHighlightedLabel.getOptional("affiliatesHighlightedLabel")

            /**
             * Whether the account has X Premium verification
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun isBlueVerified(): Optional<Boolean> = isBlueVerified.getOptional("isBlueVerified")

            /**
             * Whether a host muted the account
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun isMutedByAdmin(): Optional<Boolean> = isMutedByAdmin.getOptional("isMutedByAdmin")

            /**
             * Whether the account muted itself
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun isMutedByGuest(): Optional<Boolean> = isMutedByGuest.getOptional("isMutedByGuest")

            /**
             * Whether X shows a verified badge in the Space
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun isVerified(): Optional<Boolean> = isVerified.getOptional("isVerified")

            /**
             * When the account joined the Space
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun joinedAt(): Optional<OffsetDateTime> = joinedAt.getOptional("joinedAt")

            /**
             * The account's ID in X's broadcast service
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun periscopeUserId(): Optional<String> = periscopeUserId.getOptional("periscopeUserId")

            /**
             * Profile picture URL
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profilePicture(): Optional<String> = profilePicture.getOptional("profilePicture")

            /**
             * The participant's profile picture at full size
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profilePictureOriginal(): Optional<String> =
                profilePictureOriginal.getOptional("profilePictureOriginal")

            /**
             * Business or Government badge type
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun verifiedType(): Optional<String> = verifiedType.getOptional("verifiedType")

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
             * Unlike [username], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username

            /**
             * Returns the raw JSON value of [affiliatesHighlightedLabel].
             *
             * Unlike [affiliatesHighlightedLabel], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("affiliatesHighlightedLabel")
            @ExcludeMissing
            fun _affiliatesHighlightedLabel(): JsonField<AffiliatesHighlightedLabel> =
                affiliatesHighlightedLabel

            /**
             * Returns the raw JSON value of [isBlueVerified].
             *
             * Unlike [isBlueVerified], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("isBlueVerified")
            @ExcludeMissing
            fun _isBlueVerified(): JsonField<Boolean> = isBlueVerified

            /**
             * Returns the raw JSON value of [isMutedByAdmin].
             *
             * Unlike [isMutedByAdmin], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("isMutedByAdmin")
            @ExcludeMissing
            fun _isMutedByAdmin(): JsonField<Boolean> = isMutedByAdmin

            /**
             * Returns the raw JSON value of [isMutedByGuest].
             *
             * Unlike [isMutedByGuest], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("isMutedByGuest")
            @ExcludeMissing
            fun _isMutedByGuest(): JsonField<Boolean> = isMutedByGuest

            /**
             * Returns the raw JSON value of [isVerified].
             *
             * Unlike [isVerified], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("isVerified")
            @ExcludeMissing
            fun _isVerified(): JsonField<Boolean> = isVerified

            /**
             * Returns the raw JSON value of [joinedAt].
             *
             * Unlike [joinedAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("joinedAt")
            @ExcludeMissing
            fun _joinedAt(): JsonField<OffsetDateTime> = joinedAt

            /**
             * Returns the raw JSON value of [periscopeUserId].
             *
             * Unlike [periscopeUserId], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("periscopeUserId")
            @ExcludeMissing
            fun _periscopeUserId(): JsonField<String> = periscopeUserId

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
             * Returns the raw JSON value of [verifiedType].
             *
             * Unlike [verifiedType], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("verifiedType")
            @ExcludeMissing
            fun _verifiedType(): JsonField<String> = verifiedType

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
                 * Returns a mutable builder for constructing an instance of [Listener].
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

            /** A builder for [Listener]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var name: JsonField<String>? = null
                private var username: JsonField<String>? = null
                private var affiliatesHighlightedLabel: JsonField<AffiliatesHighlightedLabel> =
                    JsonMissing.of()
                private var isBlueVerified: JsonField<Boolean> = JsonMissing.of()
                private var isMutedByAdmin: JsonField<Boolean> = JsonMissing.of()
                private var isMutedByGuest: JsonField<Boolean> = JsonMissing.of()
                private var isVerified: JsonField<Boolean> = JsonMissing.of()
                private var joinedAt: JsonField<OffsetDateTime> = JsonMissing.of()
                private var periscopeUserId: JsonField<String> = JsonMissing.of()
                private var profilePicture: JsonField<String> = JsonMissing.of()
                private var profilePictureOriginal: JsonField<String> = JsonMissing.of()
                private var verifiedType: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(listener: Listener) = apply {
                    id = listener.id
                    name = listener.name
                    username = listener.username
                    affiliatesHighlightedLabel = listener.affiliatesHighlightedLabel
                    isBlueVerified = listener.isBlueVerified
                    isMutedByAdmin = listener.isMutedByAdmin
                    isMutedByGuest = listener.isMutedByGuest
                    isVerified = listener.isVerified
                    joinedAt = listener.joinedAt
                    periscopeUserId = listener.periscopeUserId
                    profilePicture = listener.profilePicture
                    profilePictureOriginal = listener.profilePictureOriginal
                    verifiedType = listener.verifiedType
                    additionalProperties = listener.additionalProperties.toMutableMap()
                }

                fun id(id: String) = id(JsonField.of(id))

                /** Sets [Builder.id] to an arbitrary JSON value. */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** Name the account shows in the Space */
                fun name(name: String) = name(JsonField.of(name))

                /** Sets [Builder.name] to an arbitrary JSON value. */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun username(username: String) = username(JsonField.of(username))

                /** Sets [Builder.username] to an arbitrary JSON value. */
                fun username(username: JsonField<String>) = apply { this.username = username }

                /** Organization affiliation label shown on an X profile. */
                fun affiliatesHighlightedLabel(
                    affiliatesHighlightedLabel: AffiliatesHighlightedLabel
                ) = affiliatesHighlightedLabel(JsonField.of(affiliatesHighlightedLabel))

                /** Sets [Builder.affiliatesHighlightedLabel] to an arbitrary JSON value. */
                fun affiliatesHighlightedLabel(
                    affiliatesHighlightedLabel: JsonField<AffiliatesHighlightedLabel>
                ) = apply { this.affiliatesHighlightedLabel = affiliatesHighlightedLabel }

                /** Whether the account has X Premium verification */
                fun isBlueVerified(isBlueVerified: Boolean) =
                    isBlueVerified(JsonField.of(isBlueVerified))

                /** Sets [Builder.isBlueVerified] to an arbitrary JSON value. */
                fun isBlueVerified(isBlueVerified: JsonField<Boolean>) = apply {
                    this.isBlueVerified = isBlueVerified
                }

                /** Whether a host muted the account */
                fun isMutedByAdmin(isMutedByAdmin: Boolean) =
                    isMutedByAdmin(JsonField.of(isMutedByAdmin))

                /** Sets [Builder.isMutedByAdmin] to an arbitrary JSON value. */
                fun isMutedByAdmin(isMutedByAdmin: JsonField<Boolean>) = apply {
                    this.isMutedByAdmin = isMutedByAdmin
                }

                /** Whether the account muted itself */
                fun isMutedByGuest(isMutedByGuest: Boolean) =
                    isMutedByGuest(JsonField.of(isMutedByGuest))

                /** Sets [Builder.isMutedByGuest] to an arbitrary JSON value. */
                fun isMutedByGuest(isMutedByGuest: JsonField<Boolean>) = apply {
                    this.isMutedByGuest = isMutedByGuest
                }

                /** Whether X shows a verified badge in the Space */
                fun isVerified(isVerified: Boolean) = isVerified(JsonField.of(isVerified))

                /** Sets [Builder.isVerified] to an arbitrary JSON value. */
                fun isVerified(isVerified: JsonField<Boolean>) = apply {
                    this.isVerified = isVerified
                }

                /** When the account joined the Space */
                fun joinedAt(joinedAt: OffsetDateTime) = joinedAt(JsonField.of(joinedAt))

                /** Sets [Builder.joinedAt] to an arbitrary JSON value. */
                fun joinedAt(joinedAt: JsonField<OffsetDateTime>) = apply {
                    this.joinedAt = joinedAt
                }

                /** The account's ID in X's broadcast service */
                fun periscopeUserId(periscopeUserId: String) =
                    periscopeUserId(JsonField.of(periscopeUserId))

                /** Sets [Builder.periscopeUserId] to an arbitrary JSON value. */
                fun periscopeUserId(periscopeUserId: JsonField<String>) = apply {
                    this.periscopeUserId = periscopeUserId
                }

                /** Profile picture URL */
                fun profilePicture(profilePicture: String) =
                    profilePicture(JsonField.of(profilePicture))

                /** Sets [Builder.profilePicture] to an arbitrary JSON value. */
                fun profilePicture(profilePicture: JsonField<String>) = apply {
                    this.profilePicture = profilePicture
                }

                /** The participant's profile picture at full size */
                fun profilePictureOriginal(profilePictureOriginal: String) =
                    profilePictureOriginal(JsonField.of(profilePictureOriginal))

                /** Sets [Builder.profilePictureOriginal] to an arbitrary JSON value. */
                fun profilePictureOriginal(profilePictureOriginal: JsonField<String>) = apply {
                    this.profilePictureOriginal = profilePictureOriginal
                }

                /** Business or Government badge type */
                fun verifiedType(verifiedType: String) = verifiedType(JsonField.of(verifiedType))

                /** Sets [Builder.verifiedType] to an arbitrary JSON value. */
                fun verifiedType(verifiedType: JsonField<String>) = apply {
                    this.verifiedType = verifiedType
                }

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
                 * Returns an immutable instance of [Listener].
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
                fun build(): Listener =
                    Listener(
                        checkRequired("id", id),
                        checkRequired("name", name),
                        checkRequired("username", username),
                        affiliatesHighlightedLabel,
                        isBlueVerified,
                        isMutedByAdmin,
                        isMutedByGuest,
                        isVerified,
                        joinedAt,
                        periscopeUserId,
                        profilePicture,
                        profilePictureOriginal,
                        verifiedType,
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
            fun validate(): Listener = apply {
                if (validated) {
                    return@apply
                }

                id()
                name()
                username()
                affiliatesHighlightedLabel().ifPresent { it.validate() }
                isBlueVerified()
                isMutedByAdmin()
                isMutedByGuest()
                isVerified()
                joinedAt()
                periscopeUserId()
                profilePicture()
                profilePictureOriginal()
                verifiedType()
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
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (username.asKnown().isPresent) 1 else 0) +
                    (affiliatesHighlightedLabel.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (isBlueVerified.asKnown().isPresent) 1 else 0) +
                    (if (isMutedByAdmin.asKnown().isPresent) 1 else 0) +
                    (if (isMutedByGuest.asKnown().isPresent) 1 else 0) +
                    (if (isVerified.asKnown().isPresent) 1 else 0) +
                    (if (joinedAt.asKnown().isPresent) 1 else 0) +
                    (if (periscopeUserId.asKnown().isPresent) 1 else 0) +
                    (if (profilePicture.asKnown().isPresent) 1 else 0) +
                    (if (profilePictureOriginal.asKnown().isPresent) 1 else 0) +
                    (if (verifiedType.asKnown().isPresent) 1 else 0)

            /** Organization affiliation label shown on an X profile. */
            class AffiliatesHighlightedLabel
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val badgeUrl: JsonField<String>,
                private val description: JsonField<String>,
                private val longDescription: JsonField<LongDescription>,
                private val url: JsonField<String>,
                private val urlType: JsonField<String>,
                private val userLabelDisplayType: JsonField<String>,
                private val userLabelType: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("badgeUrl")
                    @ExcludeMissing
                    badgeUrl: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("description")
                    @ExcludeMissing
                    description: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("longDescription")
                    @ExcludeMissing
                    longDescription: JsonField<LongDescription> = JsonMissing.of(),
                    @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("urlType")
                    @ExcludeMissing
                    urlType: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("userLabelDisplayType")
                    @ExcludeMissing
                    userLabelDisplayType: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("userLabelType")
                    @ExcludeMissing
                    userLabelType: JsonField<String> = JsonMissing.of(),
                ) : this(
                    badgeUrl,
                    description,
                    longDescription,
                    url,
                    urlType,
                    userLabelDisplayType,
                    userLabelType,
                    mutableMapOf(),
                )

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun badgeUrl(): Optional<String> = badgeUrl.getOptional("badgeUrl")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun description(): Optional<String> = description.getOptional("description")

                /**
                 * Public text, ranges, references, and mention data.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun longDescription(): Optional<LongDescription> =
                    longDescription.getOptional("longDescription")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun url(): Optional<String> = url.getOptional("url")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun urlType(): Optional<String> = urlType.getOptional("urlType")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun userLabelDisplayType(): Optional<String> =
                    userLabelDisplayType.getOptional("userLabelDisplayType")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun userLabelType(): Optional<String> = userLabelType.getOptional("userLabelType")

                /**
                 * Returns the raw JSON value of [badgeUrl].
                 *
                 * Unlike [badgeUrl], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("badgeUrl")
                @ExcludeMissing
                fun _badgeUrl(): JsonField<String> = badgeUrl

                /**
                 * Returns the raw JSON value of [description].
                 *
                 * Unlike [description], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("description")
                @ExcludeMissing
                fun _description(): JsonField<String> = description

                /**
                 * Returns the raw JSON value of [longDescription].
                 *
                 * Unlike [longDescription], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("longDescription")
                @ExcludeMissing
                fun _longDescription(): JsonField<LongDescription> = longDescription

                /**
                 * Returns the raw JSON value of [url].
                 *
                 * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

                /**
                 * Returns the raw JSON value of [urlType].
                 *
                 * Unlike [urlType], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("urlType") @ExcludeMissing fun _urlType(): JsonField<String> = urlType

                /**
                 * Returns the raw JSON value of [userLabelDisplayType].
                 *
                 * Unlike [userLabelDisplayType], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("userLabelDisplayType")
                @ExcludeMissing
                fun _userLabelDisplayType(): JsonField<String> = userLabelDisplayType

                /**
                 * Returns the raw JSON value of [userLabelType].
                 *
                 * Unlike [userLabelType], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("userLabelType")
                @ExcludeMissing
                fun _userLabelType(): JsonField<String> = userLabelType

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
                     * [AffiliatesHighlightedLabel].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [AffiliatesHighlightedLabel]. */
                class Builder internal constructor() {

                    private var badgeUrl: JsonField<String> = JsonMissing.of()
                    private var description: JsonField<String> = JsonMissing.of()
                    private var longDescription: JsonField<LongDescription> = JsonMissing.of()
                    private var url: JsonField<String> = JsonMissing.of()
                    private var urlType: JsonField<String> = JsonMissing.of()
                    private var userLabelDisplayType: JsonField<String> = JsonMissing.of()
                    private var userLabelType: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(affiliatesHighlightedLabel: AffiliatesHighlightedLabel) =
                        apply {
                            badgeUrl = affiliatesHighlightedLabel.badgeUrl
                            description = affiliatesHighlightedLabel.description
                            longDescription = affiliatesHighlightedLabel.longDescription
                            url = affiliatesHighlightedLabel.url
                            urlType = affiliatesHighlightedLabel.urlType
                            userLabelDisplayType = affiliatesHighlightedLabel.userLabelDisplayType
                            userLabelType = affiliatesHighlightedLabel.userLabelType
                            additionalProperties =
                                affiliatesHighlightedLabel.additionalProperties.toMutableMap()
                        }

                    fun badgeUrl(badgeUrl: String) = badgeUrl(JsonField.of(badgeUrl))

                    /** Sets [Builder.badgeUrl] to an arbitrary JSON value. */
                    fun badgeUrl(badgeUrl: JsonField<String>) = apply { this.badgeUrl = badgeUrl }

                    fun description(description: String) = description(JsonField.of(description))

                    /** Sets [Builder.description] to an arbitrary JSON value. */
                    fun description(description: JsonField<String>) = apply {
                        this.description = description
                    }

                    /** Public text, ranges, references, and mention data. */
                    fun longDescription(longDescription: LongDescription) =
                        longDescription(JsonField.of(longDescription))

                    /** Sets [Builder.longDescription] to an arbitrary JSON value. */
                    fun longDescription(longDescription: JsonField<LongDescription>) = apply {
                        this.longDescription = longDescription
                    }

                    fun url(url: String) = url(JsonField.of(url))

                    /** Sets [Builder.url] to an arbitrary JSON value. */
                    fun url(url: JsonField<String>) = apply { this.url = url }

                    fun urlType(urlType: String) = urlType(JsonField.of(urlType))

                    /** Sets [Builder.urlType] to an arbitrary JSON value. */
                    fun urlType(urlType: JsonField<String>) = apply { this.urlType = urlType }

                    fun userLabelDisplayType(userLabelDisplayType: String) =
                        userLabelDisplayType(JsonField.of(userLabelDisplayType))

                    /** Sets [Builder.userLabelDisplayType] to an arbitrary JSON value. */
                    fun userLabelDisplayType(userLabelDisplayType: JsonField<String>) = apply {
                        this.userLabelDisplayType = userLabelDisplayType
                    }

                    fun userLabelType(userLabelType: String) =
                        userLabelType(JsonField.of(userLabelType))

                    /** Sets [Builder.userLabelType] to an arbitrary JSON value. */
                    fun userLabelType(userLabelType: JsonField<String>) = apply {
                        this.userLabelType = userLabelType
                    }

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
                     * Returns an immutable instance of [AffiliatesHighlightedLabel].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): AffiliatesHighlightedLabel =
                        AffiliatesHighlightedLabel(
                            badgeUrl,
                            description,
                            longDescription,
                            url,
                            urlType,
                            userLabelDisplayType,
                            userLabelType,
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
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): AffiliatesHighlightedLabel = apply {
                    if (validated) {
                        return@apply
                    }

                    badgeUrl()
                    description()
                    longDescription().ifPresent { it.validate() }
                    url()
                    urlType()
                    userLabelDisplayType()
                    userLabelType()
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
                    (if (badgeUrl.asKnown().isPresent) 1 else 0) +
                        (if (description.asKnown().isPresent) 1 else 0) +
                        (longDescription.asKnown().getOrNull()?.validity() ?: 0) +
                        (if (url.asKnown().isPresent) 1 else 0) +
                        (if (urlType.asKnown().isPresent) 1 else 0) +
                        (if (userLabelDisplayType.asKnown().isPresent) 1 else 0) +
                        (if (userLabelType.asKnown().isPresent) 1 else 0)

                /** Public metadata whose fields X defines. */
                class LongDescription
                @JsonCreator
                private constructor(
                    @com.fasterxml.jackson.annotation.JsonValue
                    private val additionalProperties: Map<String, JsonValue>
                ) {

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /**
                         * Returns a mutable builder for constructing an instance of
                         * [LongDescription].
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [LongDescription]. */
                    class Builder internal constructor() {

                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(longDescription: LongDescription) = apply {
                            additionalProperties =
                                longDescription.additionalProperties.toMutableMap()
                        }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [LongDescription].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): LongDescription =
                            LongDescription(additionalProperties.toImmutable())
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws XTwitterScraperInvalidDataException if any value type in this object
                     *   doesn't match its expected type.
                     */
                    fun validate(): LongDescription = apply {
                        if (validated) {
                            return@apply
                        }

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
                    internal fun validity(): Int = additionalProperties.count { (_, value) ->
                        !value.isNull() && !value.isMissing()
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is LongDescription &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "LongDescription{additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is AffiliatesHighlightedLabel &&
                        badgeUrl == other.badgeUrl &&
                        description == other.description &&
                        longDescription == other.longDescription &&
                        url == other.url &&
                        urlType == other.urlType &&
                        userLabelDisplayType == other.userLabelDisplayType &&
                        userLabelType == other.userLabelType &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        badgeUrl,
                        description,
                        longDescription,
                        url,
                        urlType,
                        userLabelDisplayType,
                        userLabelType,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "AffiliatesHighlightedLabel{badgeUrl=$badgeUrl, description=$description, longDescription=$longDescription, url=$url, urlType=$urlType, userLabelDisplayType=$userLabelDisplayType, userLabelType=$userLabelType, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Listener &&
                    id == other.id &&
                    name == other.name &&
                    username == other.username &&
                    affiliatesHighlightedLabel == other.affiliatesHighlightedLabel &&
                    isBlueVerified == other.isBlueVerified &&
                    isMutedByAdmin == other.isMutedByAdmin &&
                    isMutedByGuest == other.isMutedByGuest &&
                    isVerified == other.isVerified &&
                    joinedAt == other.joinedAt &&
                    periscopeUserId == other.periscopeUserId &&
                    profilePicture == other.profilePicture &&
                    profilePictureOriginal == other.profilePictureOriginal &&
                    verifiedType == other.verifiedType &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    id,
                    name,
                    username,
                    affiliatesHighlightedLabel,
                    isBlueVerified,
                    isMutedByAdmin,
                    isMutedByGuest,
                    isVerified,
                    joinedAt,
                    periscopeUserId,
                    profilePicture,
                    profilePictureOriginal,
                    verifiedType,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Listener{id=$id, name=$name, username=$username, affiliatesHighlightedLabel=$affiliatesHighlightedLabel, isBlueVerified=$isBlueVerified, isMutedByAdmin=$isMutedByAdmin, isMutedByGuest=$isMutedByGuest, isVerified=$isVerified, joinedAt=$joinedAt, periscopeUserId=$periscopeUserId, profilePicture=$profilePicture, profilePictureOriginal=$profilePictureOriginal, verifiedType=$verifiedType, additionalProperties=$additionalProperties}"
        }

        /** An account on a Space's stage or in its audience, as X lists it there. */
        class Speaker
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val name: JsonField<String>,
            private val username: JsonField<String>,
            private val affiliatesHighlightedLabel: JsonField<AffiliatesHighlightedLabel>,
            private val isBlueVerified: JsonField<Boolean>,
            private val isMutedByAdmin: JsonField<Boolean>,
            private val isMutedByGuest: JsonField<Boolean>,
            private val isVerified: JsonField<Boolean>,
            private val joinedAt: JsonField<OffsetDateTime>,
            private val periscopeUserId: JsonField<String>,
            private val profilePicture: JsonField<String>,
            private val profilePictureOriginal: JsonField<String>,
            private val verifiedType: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("username")
                @ExcludeMissing
                username: JsonField<String> = JsonMissing.of(),
                @JsonProperty("affiliatesHighlightedLabel")
                @ExcludeMissing
                affiliatesHighlightedLabel: JsonField<AffiliatesHighlightedLabel> =
                    JsonMissing.of(),
                @JsonProperty("isBlueVerified")
                @ExcludeMissing
                isBlueVerified: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("isMutedByAdmin")
                @ExcludeMissing
                isMutedByAdmin: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("isMutedByGuest")
                @ExcludeMissing
                isMutedByGuest: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("isVerified")
                @ExcludeMissing
                isVerified: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("joinedAt")
                @ExcludeMissing
                joinedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
                @JsonProperty("periscopeUserId")
                @ExcludeMissing
                periscopeUserId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profilePicture")
                @ExcludeMissing
                profilePicture: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profilePictureOriginal")
                @ExcludeMissing
                profilePictureOriginal: JsonField<String> = JsonMissing.of(),
                @JsonProperty("verifiedType")
                @ExcludeMissing
                verifiedType: JsonField<String> = JsonMissing.of(),
            ) : this(
                id,
                name,
                username,
                affiliatesHighlightedLabel,
                isBlueVerified,
                isMutedByAdmin,
                isMutedByGuest,
                isVerified,
                joinedAt,
                periscopeUserId,
                profilePicture,
                profilePictureOriginal,
                verifiedType,
                mutableMapOf(),
            )

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun id(): String = id.getRequired("id")

            /**
             * Name the account shows in the Space
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun name(): String = name.getRequired("name")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun username(): String = username.getRequired("username")

            /**
             * Organization affiliation label shown on an X profile.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun affiliatesHighlightedLabel(): Optional<AffiliatesHighlightedLabel> =
                affiliatesHighlightedLabel.getOptional("affiliatesHighlightedLabel")

            /**
             * Whether the account has X Premium verification
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun isBlueVerified(): Optional<Boolean> = isBlueVerified.getOptional("isBlueVerified")

            /**
             * Whether a host muted the account
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun isMutedByAdmin(): Optional<Boolean> = isMutedByAdmin.getOptional("isMutedByAdmin")

            /**
             * Whether the account muted itself
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun isMutedByGuest(): Optional<Boolean> = isMutedByGuest.getOptional("isMutedByGuest")

            /**
             * Whether X shows a verified badge in the Space
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun isVerified(): Optional<Boolean> = isVerified.getOptional("isVerified")

            /**
             * When the account joined the Space
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun joinedAt(): Optional<OffsetDateTime> = joinedAt.getOptional("joinedAt")

            /**
             * The account's ID in X's broadcast service
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun periscopeUserId(): Optional<String> = periscopeUserId.getOptional("periscopeUserId")

            /**
             * Profile picture URL
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profilePicture(): Optional<String> = profilePicture.getOptional("profilePicture")

            /**
             * The participant's profile picture at full size
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profilePictureOriginal(): Optional<String> =
                profilePictureOriginal.getOptional("profilePictureOriginal")

            /**
             * Business or Government badge type
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun verifiedType(): Optional<String> = verifiedType.getOptional("verifiedType")

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
             * Unlike [username], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username

            /**
             * Returns the raw JSON value of [affiliatesHighlightedLabel].
             *
             * Unlike [affiliatesHighlightedLabel], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("affiliatesHighlightedLabel")
            @ExcludeMissing
            fun _affiliatesHighlightedLabel(): JsonField<AffiliatesHighlightedLabel> =
                affiliatesHighlightedLabel

            /**
             * Returns the raw JSON value of [isBlueVerified].
             *
             * Unlike [isBlueVerified], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("isBlueVerified")
            @ExcludeMissing
            fun _isBlueVerified(): JsonField<Boolean> = isBlueVerified

            /**
             * Returns the raw JSON value of [isMutedByAdmin].
             *
             * Unlike [isMutedByAdmin], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("isMutedByAdmin")
            @ExcludeMissing
            fun _isMutedByAdmin(): JsonField<Boolean> = isMutedByAdmin

            /**
             * Returns the raw JSON value of [isMutedByGuest].
             *
             * Unlike [isMutedByGuest], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("isMutedByGuest")
            @ExcludeMissing
            fun _isMutedByGuest(): JsonField<Boolean> = isMutedByGuest

            /**
             * Returns the raw JSON value of [isVerified].
             *
             * Unlike [isVerified], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("isVerified")
            @ExcludeMissing
            fun _isVerified(): JsonField<Boolean> = isVerified

            /**
             * Returns the raw JSON value of [joinedAt].
             *
             * Unlike [joinedAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("joinedAt")
            @ExcludeMissing
            fun _joinedAt(): JsonField<OffsetDateTime> = joinedAt

            /**
             * Returns the raw JSON value of [periscopeUserId].
             *
             * Unlike [periscopeUserId], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("periscopeUserId")
            @ExcludeMissing
            fun _periscopeUserId(): JsonField<String> = periscopeUserId

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
             * Returns the raw JSON value of [verifiedType].
             *
             * Unlike [verifiedType], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("verifiedType")
            @ExcludeMissing
            fun _verifiedType(): JsonField<String> = verifiedType

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
                 * Returns a mutable builder for constructing an instance of [Speaker].
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

            /** A builder for [Speaker]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var name: JsonField<String>? = null
                private var username: JsonField<String>? = null
                private var affiliatesHighlightedLabel: JsonField<AffiliatesHighlightedLabel> =
                    JsonMissing.of()
                private var isBlueVerified: JsonField<Boolean> = JsonMissing.of()
                private var isMutedByAdmin: JsonField<Boolean> = JsonMissing.of()
                private var isMutedByGuest: JsonField<Boolean> = JsonMissing.of()
                private var isVerified: JsonField<Boolean> = JsonMissing.of()
                private var joinedAt: JsonField<OffsetDateTime> = JsonMissing.of()
                private var periscopeUserId: JsonField<String> = JsonMissing.of()
                private var profilePicture: JsonField<String> = JsonMissing.of()
                private var profilePictureOriginal: JsonField<String> = JsonMissing.of()
                private var verifiedType: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(speaker: Speaker) = apply {
                    id = speaker.id
                    name = speaker.name
                    username = speaker.username
                    affiliatesHighlightedLabel = speaker.affiliatesHighlightedLabel
                    isBlueVerified = speaker.isBlueVerified
                    isMutedByAdmin = speaker.isMutedByAdmin
                    isMutedByGuest = speaker.isMutedByGuest
                    isVerified = speaker.isVerified
                    joinedAt = speaker.joinedAt
                    periscopeUserId = speaker.periscopeUserId
                    profilePicture = speaker.profilePicture
                    profilePictureOriginal = speaker.profilePictureOriginal
                    verifiedType = speaker.verifiedType
                    additionalProperties = speaker.additionalProperties.toMutableMap()
                }

                fun id(id: String) = id(JsonField.of(id))

                /** Sets [Builder.id] to an arbitrary JSON value. */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** Name the account shows in the Space */
                fun name(name: String) = name(JsonField.of(name))

                /** Sets [Builder.name] to an arbitrary JSON value. */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun username(username: String) = username(JsonField.of(username))

                /** Sets [Builder.username] to an arbitrary JSON value. */
                fun username(username: JsonField<String>) = apply { this.username = username }

                /** Organization affiliation label shown on an X profile. */
                fun affiliatesHighlightedLabel(
                    affiliatesHighlightedLabel: AffiliatesHighlightedLabel
                ) = affiliatesHighlightedLabel(JsonField.of(affiliatesHighlightedLabel))

                /** Sets [Builder.affiliatesHighlightedLabel] to an arbitrary JSON value. */
                fun affiliatesHighlightedLabel(
                    affiliatesHighlightedLabel: JsonField<AffiliatesHighlightedLabel>
                ) = apply { this.affiliatesHighlightedLabel = affiliatesHighlightedLabel }

                /** Whether the account has X Premium verification */
                fun isBlueVerified(isBlueVerified: Boolean) =
                    isBlueVerified(JsonField.of(isBlueVerified))

                /** Sets [Builder.isBlueVerified] to an arbitrary JSON value. */
                fun isBlueVerified(isBlueVerified: JsonField<Boolean>) = apply {
                    this.isBlueVerified = isBlueVerified
                }

                /** Whether a host muted the account */
                fun isMutedByAdmin(isMutedByAdmin: Boolean) =
                    isMutedByAdmin(JsonField.of(isMutedByAdmin))

                /** Sets [Builder.isMutedByAdmin] to an arbitrary JSON value. */
                fun isMutedByAdmin(isMutedByAdmin: JsonField<Boolean>) = apply {
                    this.isMutedByAdmin = isMutedByAdmin
                }

                /** Whether the account muted itself */
                fun isMutedByGuest(isMutedByGuest: Boolean) =
                    isMutedByGuest(JsonField.of(isMutedByGuest))

                /** Sets [Builder.isMutedByGuest] to an arbitrary JSON value. */
                fun isMutedByGuest(isMutedByGuest: JsonField<Boolean>) = apply {
                    this.isMutedByGuest = isMutedByGuest
                }

                /** Whether X shows a verified badge in the Space */
                fun isVerified(isVerified: Boolean) = isVerified(JsonField.of(isVerified))

                /** Sets [Builder.isVerified] to an arbitrary JSON value. */
                fun isVerified(isVerified: JsonField<Boolean>) = apply {
                    this.isVerified = isVerified
                }

                /** When the account joined the Space */
                fun joinedAt(joinedAt: OffsetDateTime) = joinedAt(JsonField.of(joinedAt))

                /** Sets [Builder.joinedAt] to an arbitrary JSON value. */
                fun joinedAt(joinedAt: JsonField<OffsetDateTime>) = apply {
                    this.joinedAt = joinedAt
                }

                /** The account's ID in X's broadcast service */
                fun periscopeUserId(periscopeUserId: String) =
                    periscopeUserId(JsonField.of(periscopeUserId))

                /** Sets [Builder.periscopeUserId] to an arbitrary JSON value. */
                fun periscopeUserId(periscopeUserId: JsonField<String>) = apply {
                    this.periscopeUserId = periscopeUserId
                }

                /** Profile picture URL */
                fun profilePicture(profilePicture: String) =
                    profilePicture(JsonField.of(profilePicture))

                /** Sets [Builder.profilePicture] to an arbitrary JSON value. */
                fun profilePicture(profilePicture: JsonField<String>) = apply {
                    this.profilePicture = profilePicture
                }

                /** The participant's profile picture at full size */
                fun profilePictureOriginal(profilePictureOriginal: String) =
                    profilePictureOriginal(JsonField.of(profilePictureOriginal))

                /** Sets [Builder.profilePictureOriginal] to an arbitrary JSON value. */
                fun profilePictureOriginal(profilePictureOriginal: JsonField<String>) = apply {
                    this.profilePictureOriginal = profilePictureOriginal
                }

                /** Business or Government badge type */
                fun verifiedType(verifiedType: String) = verifiedType(JsonField.of(verifiedType))

                /** Sets [Builder.verifiedType] to an arbitrary JSON value. */
                fun verifiedType(verifiedType: JsonField<String>) = apply {
                    this.verifiedType = verifiedType
                }

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
                 * Returns an immutable instance of [Speaker].
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
                fun build(): Speaker =
                    Speaker(
                        checkRequired("id", id),
                        checkRequired("name", name),
                        checkRequired("username", username),
                        affiliatesHighlightedLabel,
                        isBlueVerified,
                        isMutedByAdmin,
                        isMutedByGuest,
                        isVerified,
                        joinedAt,
                        periscopeUserId,
                        profilePicture,
                        profilePictureOriginal,
                        verifiedType,
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
            fun validate(): Speaker = apply {
                if (validated) {
                    return@apply
                }

                id()
                name()
                username()
                affiliatesHighlightedLabel().ifPresent { it.validate() }
                isBlueVerified()
                isMutedByAdmin()
                isMutedByGuest()
                isVerified()
                joinedAt()
                periscopeUserId()
                profilePicture()
                profilePictureOriginal()
                verifiedType()
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
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (username.asKnown().isPresent) 1 else 0) +
                    (affiliatesHighlightedLabel.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (isBlueVerified.asKnown().isPresent) 1 else 0) +
                    (if (isMutedByAdmin.asKnown().isPresent) 1 else 0) +
                    (if (isMutedByGuest.asKnown().isPresent) 1 else 0) +
                    (if (isVerified.asKnown().isPresent) 1 else 0) +
                    (if (joinedAt.asKnown().isPresent) 1 else 0) +
                    (if (periscopeUserId.asKnown().isPresent) 1 else 0) +
                    (if (profilePicture.asKnown().isPresent) 1 else 0) +
                    (if (profilePictureOriginal.asKnown().isPresent) 1 else 0) +
                    (if (verifiedType.asKnown().isPresent) 1 else 0)

            /** Organization affiliation label shown on an X profile. */
            class AffiliatesHighlightedLabel
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val badgeUrl: JsonField<String>,
                private val description: JsonField<String>,
                private val longDescription: JsonField<LongDescription>,
                private val url: JsonField<String>,
                private val urlType: JsonField<String>,
                private val userLabelDisplayType: JsonField<String>,
                private val userLabelType: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("badgeUrl")
                    @ExcludeMissing
                    badgeUrl: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("description")
                    @ExcludeMissing
                    description: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("longDescription")
                    @ExcludeMissing
                    longDescription: JsonField<LongDescription> = JsonMissing.of(),
                    @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("urlType")
                    @ExcludeMissing
                    urlType: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("userLabelDisplayType")
                    @ExcludeMissing
                    userLabelDisplayType: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("userLabelType")
                    @ExcludeMissing
                    userLabelType: JsonField<String> = JsonMissing.of(),
                ) : this(
                    badgeUrl,
                    description,
                    longDescription,
                    url,
                    urlType,
                    userLabelDisplayType,
                    userLabelType,
                    mutableMapOf(),
                )

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun badgeUrl(): Optional<String> = badgeUrl.getOptional("badgeUrl")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun description(): Optional<String> = description.getOptional("description")

                /**
                 * Public text, ranges, references, and mention data.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun longDescription(): Optional<LongDescription> =
                    longDescription.getOptional("longDescription")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun url(): Optional<String> = url.getOptional("url")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun urlType(): Optional<String> = urlType.getOptional("urlType")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun userLabelDisplayType(): Optional<String> =
                    userLabelDisplayType.getOptional("userLabelDisplayType")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun userLabelType(): Optional<String> = userLabelType.getOptional("userLabelType")

                /**
                 * Returns the raw JSON value of [badgeUrl].
                 *
                 * Unlike [badgeUrl], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("badgeUrl")
                @ExcludeMissing
                fun _badgeUrl(): JsonField<String> = badgeUrl

                /**
                 * Returns the raw JSON value of [description].
                 *
                 * Unlike [description], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("description")
                @ExcludeMissing
                fun _description(): JsonField<String> = description

                /**
                 * Returns the raw JSON value of [longDescription].
                 *
                 * Unlike [longDescription], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("longDescription")
                @ExcludeMissing
                fun _longDescription(): JsonField<LongDescription> = longDescription

                /**
                 * Returns the raw JSON value of [url].
                 *
                 * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

                /**
                 * Returns the raw JSON value of [urlType].
                 *
                 * Unlike [urlType], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("urlType") @ExcludeMissing fun _urlType(): JsonField<String> = urlType

                /**
                 * Returns the raw JSON value of [userLabelDisplayType].
                 *
                 * Unlike [userLabelDisplayType], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("userLabelDisplayType")
                @ExcludeMissing
                fun _userLabelDisplayType(): JsonField<String> = userLabelDisplayType

                /**
                 * Returns the raw JSON value of [userLabelType].
                 *
                 * Unlike [userLabelType], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("userLabelType")
                @ExcludeMissing
                fun _userLabelType(): JsonField<String> = userLabelType

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
                     * [AffiliatesHighlightedLabel].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [AffiliatesHighlightedLabel]. */
                class Builder internal constructor() {

                    private var badgeUrl: JsonField<String> = JsonMissing.of()
                    private var description: JsonField<String> = JsonMissing.of()
                    private var longDescription: JsonField<LongDescription> = JsonMissing.of()
                    private var url: JsonField<String> = JsonMissing.of()
                    private var urlType: JsonField<String> = JsonMissing.of()
                    private var userLabelDisplayType: JsonField<String> = JsonMissing.of()
                    private var userLabelType: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(affiliatesHighlightedLabel: AffiliatesHighlightedLabel) =
                        apply {
                            badgeUrl = affiliatesHighlightedLabel.badgeUrl
                            description = affiliatesHighlightedLabel.description
                            longDescription = affiliatesHighlightedLabel.longDescription
                            url = affiliatesHighlightedLabel.url
                            urlType = affiliatesHighlightedLabel.urlType
                            userLabelDisplayType = affiliatesHighlightedLabel.userLabelDisplayType
                            userLabelType = affiliatesHighlightedLabel.userLabelType
                            additionalProperties =
                                affiliatesHighlightedLabel.additionalProperties.toMutableMap()
                        }

                    fun badgeUrl(badgeUrl: String) = badgeUrl(JsonField.of(badgeUrl))

                    /** Sets [Builder.badgeUrl] to an arbitrary JSON value. */
                    fun badgeUrl(badgeUrl: JsonField<String>) = apply { this.badgeUrl = badgeUrl }

                    fun description(description: String) = description(JsonField.of(description))

                    /** Sets [Builder.description] to an arbitrary JSON value. */
                    fun description(description: JsonField<String>) = apply {
                        this.description = description
                    }

                    /** Public text, ranges, references, and mention data. */
                    fun longDescription(longDescription: LongDescription) =
                        longDescription(JsonField.of(longDescription))

                    /** Sets [Builder.longDescription] to an arbitrary JSON value. */
                    fun longDescription(longDescription: JsonField<LongDescription>) = apply {
                        this.longDescription = longDescription
                    }

                    fun url(url: String) = url(JsonField.of(url))

                    /** Sets [Builder.url] to an arbitrary JSON value. */
                    fun url(url: JsonField<String>) = apply { this.url = url }

                    fun urlType(urlType: String) = urlType(JsonField.of(urlType))

                    /** Sets [Builder.urlType] to an arbitrary JSON value. */
                    fun urlType(urlType: JsonField<String>) = apply { this.urlType = urlType }

                    fun userLabelDisplayType(userLabelDisplayType: String) =
                        userLabelDisplayType(JsonField.of(userLabelDisplayType))

                    /** Sets [Builder.userLabelDisplayType] to an arbitrary JSON value. */
                    fun userLabelDisplayType(userLabelDisplayType: JsonField<String>) = apply {
                        this.userLabelDisplayType = userLabelDisplayType
                    }

                    fun userLabelType(userLabelType: String) =
                        userLabelType(JsonField.of(userLabelType))

                    /** Sets [Builder.userLabelType] to an arbitrary JSON value. */
                    fun userLabelType(userLabelType: JsonField<String>) = apply {
                        this.userLabelType = userLabelType
                    }

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
                     * Returns an immutable instance of [AffiliatesHighlightedLabel].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): AffiliatesHighlightedLabel =
                        AffiliatesHighlightedLabel(
                            badgeUrl,
                            description,
                            longDescription,
                            url,
                            urlType,
                            userLabelDisplayType,
                            userLabelType,
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
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): AffiliatesHighlightedLabel = apply {
                    if (validated) {
                        return@apply
                    }

                    badgeUrl()
                    description()
                    longDescription().ifPresent { it.validate() }
                    url()
                    urlType()
                    userLabelDisplayType()
                    userLabelType()
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
                    (if (badgeUrl.asKnown().isPresent) 1 else 0) +
                        (if (description.asKnown().isPresent) 1 else 0) +
                        (longDescription.asKnown().getOrNull()?.validity() ?: 0) +
                        (if (url.asKnown().isPresent) 1 else 0) +
                        (if (urlType.asKnown().isPresent) 1 else 0) +
                        (if (userLabelDisplayType.asKnown().isPresent) 1 else 0) +
                        (if (userLabelType.asKnown().isPresent) 1 else 0)

                /** Public metadata whose fields X defines. */
                class LongDescription
                @JsonCreator
                private constructor(
                    @com.fasterxml.jackson.annotation.JsonValue
                    private val additionalProperties: Map<String, JsonValue>
                ) {

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /**
                         * Returns a mutable builder for constructing an instance of
                         * [LongDescription].
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [LongDescription]. */
                    class Builder internal constructor() {

                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(longDescription: LongDescription) = apply {
                            additionalProperties =
                                longDescription.additionalProperties.toMutableMap()
                        }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [LongDescription].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): LongDescription =
                            LongDescription(additionalProperties.toImmutable())
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws XTwitterScraperInvalidDataException if any value type in this object
                     *   doesn't match its expected type.
                     */
                    fun validate(): LongDescription = apply {
                        if (validated) {
                            return@apply
                        }

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
                    internal fun validity(): Int = additionalProperties.count { (_, value) ->
                        !value.isNull() && !value.isMissing()
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is LongDescription &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "LongDescription{additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is AffiliatesHighlightedLabel &&
                        badgeUrl == other.badgeUrl &&
                        description == other.description &&
                        longDescription == other.longDescription &&
                        url == other.url &&
                        urlType == other.urlType &&
                        userLabelDisplayType == other.userLabelDisplayType &&
                        userLabelType == other.userLabelType &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        badgeUrl,
                        description,
                        longDescription,
                        url,
                        urlType,
                        userLabelDisplayType,
                        userLabelType,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "AffiliatesHighlightedLabel{badgeUrl=$badgeUrl, description=$description, longDescription=$longDescription, url=$url, urlType=$urlType, userLabelDisplayType=$userLabelDisplayType, userLabelType=$userLabelType, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Speaker &&
                    id == other.id &&
                    name == other.name &&
                    username == other.username &&
                    affiliatesHighlightedLabel == other.affiliatesHighlightedLabel &&
                    isBlueVerified == other.isBlueVerified &&
                    isMutedByAdmin == other.isMutedByAdmin &&
                    isMutedByGuest == other.isMutedByGuest &&
                    isVerified == other.isVerified &&
                    joinedAt == other.joinedAt &&
                    periscopeUserId == other.periscopeUserId &&
                    profilePicture == other.profilePicture &&
                    profilePictureOriginal == other.profilePictureOriginal &&
                    verifiedType == other.verifiedType &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    id,
                    name,
                    username,
                    affiliatesHighlightedLabel,
                    isBlueVerified,
                    isMutedByAdmin,
                    isMutedByGuest,
                    isVerified,
                    joinedAt,
                    periscopeUserId,
                    profilePicture,
                    profilePictureOriginal,
                    verifiedType,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Speaker{id=$id, name=$name, username=$username, affiliatesHighlightedLabel=$affiliatesHighlightedLabel, isBlueVerified=$isBlueVerified, isMutedByAdmin=$isMutedByAdmin, isMutedByGuest=$isMutedByGuest, isVerified=$isVerified, joinedAt=$joinedAt, periscopeUserId=$periscopeUserId, profilePicture=$profilePicture, profilePictureOriginal=$profilePictureOriginal, verifiedType=$verifiedType, additionalProperties=$additionalProperties}"
        }

        /** A post shared in a Space, & the account that shared it. */
        class Sharing
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val sharedAt: JsonField<OffsetDateTime>,
            private val sharedBy: JsonField<UserProfile>,
            private val tweet: JsonField<SearchTweet>,
            private val updatedAt: JsonField<OffsetDateTime>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("sharedAt")
                @ExcludeMissing
                sharedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
                @JsonProperty("sharedBy")
                @ExcludeMissing
                sharedBy: JsonField<UserProfile> = JsonMissing.of(),
                @JsonProperty("tweet")
                @ExcludeMissing
                tweet: JsonField<SearchTweet> = JsonMissing.of(),
                @JsonProperty("updatedAt")
                @ExcludeMissing
                updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            ) : this(id, sharedAt, sharedBy, tweet, updatedAt, mutableMapOf())

            /**
             * X's ID of the sharing, not of the post
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun id(): Optional<String> = id.getOptional("id")

            /**
             * When the post was shared
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun sharedAt(): Optional<OffsetDateTime> = sharedAt.getOptional("sharedAt")

            /**
             * Public X profile.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun sharedBy(): Optional<UserProfile> = sharedBy.getOptional("sharedBy")

            /**
             * Search tweet with author. Zero metrics may mean X omitted counts.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun tweet(): Optional<SearchTweet> = tweet.getOptional("tweet")

            /**
             * When X last changed the sharing
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updatedAt")

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [sharedAt].
             *
             * Unlike [sharedAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("sharedAt")
            @ExcludeMissing
            fun _sharedAt(): JsonField<OffsetDateTime> = sharedAt

            /**
             * Returns the raw JSON value of [sharedBy].
             *
             * Unlike [sharedBy], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("sharedBy")
            @ExcludeMissing
            fun _sharedBy(): JsonField<UserProfile> = sharedBy

            /**
             * Returns the raw JSON value of [tweet].
             *
             * Unlike [tweet], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("tweet") @ExcludeMissing fun _tweet(): JsonField<SearchTweet> = tweet

            /**
             * Returns the raw JSON value of [updatedAt].
             *
             * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("updatedAt")
            @ExcludeMissing
            fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

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

                /** Returns a mutable builder for constructing an instance of [Sharing]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Sharing]. */
            class Builder internal constructor() {

                private var id: JsonField<String> = JsonMissing.of()
                private var sharedAt: JsonField<OffsetDateTime> = JsonMissing.of()
                private var sharedBy: JsonField<UserProfile> = JsonMissing.of()
                private var tweet: JsonField<SearchTweet> = JsonMissing.of()
                private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(sharing: Sharing) = apply {
                    id = sharing.id
                    sharedAt = sharing.sharedAt
                    sharedBy = sharing.sharedBy
                    tweet = sharing.tweet
                    updatedAt = sharing.updatedAt
                    additionalProperties = sharing.additionalProperties.toMutableMap()
                }

                /** X's ID of the sharing, not of the post */
                fun id(id: String) = id(JsonField.of(id))

                /** Sets [Builder.id] to an arbitrary JSON value. */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** When the post was shared */
                fun sharedAt(sharedAt: OffsetDateTime) = sharedAt(JsonField.of(sharedAt))

                /** Sets [Builder.sharedAt] to an arbitrary JSON value. */
                fun sharedAt(sharedAt: JsonField<OffsetDateTime>) = apply {
                    this.sharedAt = sharedAt
                }

                /** Public X profile. */
                fun sharedBy(sharedBy: UserProfile) = sharedBy(JsonField.of(sharedBy))

                /** Sets [Builder.sharedBy] to an arbitrary JSON value. */
                fun sharedBy(sharedBy: JsonField<UserProfile>) = apply { this.sharedBy = sharedBy }

                /** Search tweet with author. Zero metrics may mean X omitted counts. */
                fun tweet(tweet: SearchTweet) = tweet(JsonField.of(tweet))

                /** Sets [Builder.tweet] to an arbitrary JSON value. */
                fun tweet(tweet: JsonField<SearchTweet>) = apply { this.tweet = tweet }

                /** When X last changed the sharing */
                fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

                /** Sets [Builder.updatedAt] to an arbitrary JSON value. */
                fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply {
                    this.updatedAt = updatedAt
                }

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
                 * Returns an immutable instance of [Sharing].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Sharing =
                    Sharing(
                        id,
                        sharedAt,
                        sharedBy,
                        tweet,
                        updatedAt,
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
            fun validate(): Sharing = apply {
                if (validated) {
                    return@apply
                }

                id()
                sharedAt()
                sharedBy().ifPresent { it.validate() }
                tweet().ifPresent { it.validate() }
                updatedAt()
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
                    (if (sharedAt.asKnown().isPresent) 1 else 0) +
                    (sharedBy.asKnown().getOrNull()?.validity() ?: 0) +
                    (tweet.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (updatedAt.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Sharing &&
                    id == other.id &&
                    sharedAt == other.sharedAt &&
                    sharedBy == other.sharedBy &&
                    tweet == other.tweet &&
                    updatedAt == other.updatedAt &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(id, sharedAt, sharedBy, tweet, updatedAt, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Sharing{id=$id, sharedAt=$sharedAt, sharedBy=$sharedBy, tweet=$tweet, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Space &&
                admins == other.admins &&
                id == other.id &&
                listeners == other.listeners &&
                speakers == other.speakers &&
                contentType == other.contentType &&
                conversationControls == other.conversationControls &&
                createdAt == other.createdAt &&
                creator == other.creator &&
                disallowJoin == other.disallowJoin &&
                endedAt == other.endedAt &&
                isAvailableForClipping == other.isAvailableForClipping &&
                isAvailableForReplay == other.isAvailableForReplay &&
                isEmployeeOnly == other.isEmployeeOnly &&
                isLocked == other.isLocked &&
                maxAdminCapacity == other.maxAdminCapacity &&
                mediaKey == other.mediaKey &&
                mentionedUserIds == other.mentionedUserIds &&
                noIncognito == other.noIncognito &&
                participantCount == other.participantCount &&
                scheduledStart == other.scheduledStart &&
                sharings == other.sharings &&
                startedAt == other.startedAt &&
                state == other.state &&
                title == other.title &&
                totalLiveListeners == other.totalLiveListeners &&
                totalReplayWatched == other.totalReplayWatched &&
                tweet == other.tweet &&
                tweetId == other.tweetId &&
                updatedAt == other.updatedAt &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                admins,
                id,
                listeners,
                speakers,
                contentType,
                conversationControls,
                createdAt,
                creator,
                disallowJoin,
                endedAt,
                isAvailableForClipping,
                isAvailableForReplay,
                isEmployeeOnly,
                isLocked,
                maxAdminCapacity,
                mediaKey,
                mentionedUserIds,
                noIncognito,
                participantCount,
                scheduledStart,
                sharings,
                startedAt,
                state,
                title,
                totalLiveListeners,
                totalReplayWatched,
                tweet,
                tweetId,
                updatedAt,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Space{admins=$admins, id=$id, listeners=$listeners, speakers=$speakers, contentType=$contentType, conversationControls=$conversationControls, createdAt=$createdAt, creator=$creator, disallowJoin=$disallowJoin, endedAt=$endedAt, isAvailableForClipping=$isAvailableForClipping, isAvailableForReplay=$isAvailableForReplay, isEmployeeOnly=$isEmployeeOnly, isLocked=$isLocked, maxAdminCapacity=$maxAdminCapacity, mediaKey=$mediaKey, mentionedUserIds=$mentionedUserIds, noIncognito=$noIncognito, participantCount=$participantCount, scheduledStart=$scheduledStart, sharings=$sharings, startedAt=$startedAt, state=$state, title=$title, totalLiveListeners=$totalLiveListeners, totalReplayWatched=$totalReplayWatched, tweet=$tweet, tweetId=$tweetId, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SpaceRetrieveResponse &&
            space == other.space &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(space, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SpaceRetrieveResponse{space=$space, additionalProperties=$additionalProperties}"
}
