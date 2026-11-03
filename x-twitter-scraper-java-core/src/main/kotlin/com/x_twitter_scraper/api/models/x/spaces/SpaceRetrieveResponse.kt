// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.spaces

import com.x_twitter_scraper.api.models.UserAuxiliaryLabel
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
                private val auxiliaryLabels: JsonField<List<UserAuxiliaryLabel>>,
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
                    @JsonProperty("auxiliaryLabels") @ExcludeMissing auxiliaryLabels: JsonField<List<UserAuxiliaryLabel>> = JsonMissing.of(),
                ) : this(
                    badgeUrl,
                    description,
                    longDescription,
                    url,
                    urlType,
                    userLabelDisplayType,
                    userLabelType,
                    auxiliaryLabels, mutableMapOf(),
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

                /** X user profile with bio, follower counts, and verification status. */ class UserProfile @JsonCreator(mode = JsonCreator.Mode.DISABLED) private constructor( private val id: JsonField<String>, private val name: JsonField<String>, private val username: JsonField<String>, private val accountBasedIn: JsonField<AccountBasedIn>, private val accountBasedInAccurate: JsonField<Boolean>, private val accountBasedInUnavailable: JsonField<Boolean>, private val advertiserAccountServiceLevels: JsonField<List<String>>, private val advertiserAccountType: JsonField<String>, private val affiliatesHighlightedLabel: JsonField<AffiliatesHighlightedLabel>, private val affiliateUsername: JsonField<String>, private val automatedBy: JsonField<String>, private val birthdate: JsonField<Birthdate>, private val businessAccountAffiliatesCount: JsonField<Long>, private val businessProfileState: JsonField<String>, private val communityRole: JsonField<String>, private val connectedVia: JsonField<String>, private val connectedViaAccurate: JsonField<Boolean>, private val contactInfo: JsonField<ContactInfo>, private val coverPicture: JsonField<String>, private val createdAt: JsonField<String>, private val creatorSubscriptionsCount: JsonField<Long>, private val defaultProfile: JsonField<Boolean>, private val defaultProfileImage: JsonField<Boolean>, private val description: JsonField<String>, private val email: JsonField<String>, private val fastFollowersCount: JsonField<Long>, private val favouritesCount: JsonField<Long>, private val followers: JsonField<Long>, private val following: JsonField<Long>, private val geoEnabled: JsonField<Boolean>, private val grokTranslatedBio: JsonField<GrokTranslatedBio>, private val hasCustomTimelines: JsonField<Boolean>, private val hasExtendedProfile: JsonField<Boolean>, private val hasGraduatedAccess: JsonField<Boolean>, private val hasHiddenSubscriptionsOnProfile: JsonField<Boolean>, private val highlightsInfo: JsonField<HighlightsInfo>, private val identityVerification: JsonField<IdentityVerification>, private val isAutomated: JsonField<Boolean>, private val isBlueVerified: JsonField<Boolean>, private val isProfileTranslatable: JsonField<Boolean>, private val isTranslationEnabled: JsonField<Boolean>, private val isTranslator: JsonField<Boolean>, private val isVerified: JsonField<Boolean>, private val listedCount: JsonField<Long>, private val location: JsonField<String>, private val mediaCount: JsonField<Long>, private val normalFollowersCount: JsonField<Long>, private val parodyCommentaryFanLabel: JsonField<String>, private val pinnedTweetIds: JsonField<List<String>>, private val possiblySensitive: JsonField<Boolean>, private val professional: JsonField<Professional>, private val profileBio: JsonField<ProfileBio>, private val profileBannerUrl: JsonField<String>, private val profileDescriptionLanguage: JsonField<String>, private val profileImageShape: JsonField<String>, private val profileInterstitialType: JsonField<String>, private val profilePicture: JsonField<String>, private val profilePictureOriginal: JsonField<String>, private val profileSortEnabled: JsonField<Boolean>, private val profileTranslatorType: JsonField<String>, private val protected_: JsonField<Boolean>, private val redirectsToUsername: JsonField<String>, private val retweetedAt: JsonField<OffsetDateTime>, private val statusesCount: JsonField<Long>, private val subscribersCount: JsonField<Long>, private val superFollowEligible: JsonField<Boolean>, private val superFollowsUserProfileActive: JsonField<Boolean>, private val tipJar: JsonField<TipJar>, private val unavailable: JsonField<Boolean>, private val unavailableReason: JsonField<String>, private val url: JsonField<String>, private val usernameChanges: JsonField<UsernameChanges>, private val verificationReason: JsonField<VerificationReason>, private val verified: JsonField<Boolean>, private val verifiedType: JsonField<String>, private val withheldInCountries: JsonField<List<String>>, private val withheldScope: JsonField<String>, private val additionalProperties: MutableMap<String, JsonValue>, ) { @JsonCreator private constructor( @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(), @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(), @JsonProperty("username") @ExcludeMissing username: JsonField<String> = JsonMissing.of(), @JsonProperty("accountBasedIn") @ExcludeMissing accountBasedIn: JsonField<AccountBasedIn> = JsonMissing.of(), @JsonProperty("accountBasedInAccurate") @ExcludeMissing accountBasedInAccurate: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("accountBasedInUnavailable") @ExcludeMissing accountBasedInUnavailable: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("advertiserAccountServiceLevels") @ExcludeMissing advertiserAccountServiceLevels: JsonField<List<String>> = JsonMissing.of(), @JsonProperty("advertiserAccountType") @ExcludeMissing advertiserAccountType: JsonField<String> = JsonMissing.of(), @JsonProperty("affiliatesHighlightedLabel") @ExcludeMissing affiliatesHighlightedLabel: JsonField<AffiliatesHighlightedLabel> = JsonMissing.of(), @JsonProperty("affiliateUsername") @ExcludeMissing affiliateUsername: JsonField<String> = JsonMissing.of(), @JsonProperty("automatedBy") @ExcludeMissing automatedBy: JsonField<String> = JsonMissing.of(), @JsonProperty("birthdate") @ExcludeMissing birthdate: JsonField<Birthdate> = JsonMissing.of(), @JsonProperty("businessAccountAffiliatesCount") @ExcludeMissing businessAccountAffiliatesCount: JsonField<Long> = JsonMissing.of(), @JsonProperty("businessProfileState") @ExcludeMissing businessProfileState: JsonField<String> = JsonMissing.of(), @JsonProperty("communityRole") @ExcludeMissing communityRole: JsonField<String> = JsonMissing.of(), @JsonProperty("connectedVia") @ExcludeMissing connectedVia: JsonField<String> = JsonMissing.of(), @JsonProperty("connectedViaAccurate") @ExcludeMissing connectedViaAccurate: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("contactInfo") @ExcludeMissing contactInfo: JsonField<ContactInfo> = JsonMissing.of(), @JsonProperty("coverPicture") @ExcludeMissing coverPicture: JsonField<String> = JsonMissing.of(), @JsonProperty("createdAt") @ExcludeMissing createdAt: JsonField<String> = JsonMissing.of(), @JsonProperty("creatorSubscriptionsCount") @ExcludeMissing creatorSubscriptionsCount: JsonField<Long> = JsonMissing.of(), @JsonProperty("defaultProfile") @ExcludeMissing defaultProfile: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("defaultProfileImage") @ExcludeMissing defaultProfileImage: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("description") @ExcludeMissing description: JsonField<String> = JsonMissing.of(), @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(), @JsonProperty("fastFollowersCount") @ExcludeMissing fastFollowersCount: JsonField<Long> = JsonMissing.of(), @JsonProperty("favouritesCount") @ExcludeMissing favouritesCount: JsonField<Long> = JsonMissing.of(), @JsonProperty("followers") @ExcludeMissing followers: JsonField<Long> = JsonMissing.of(), @JsonProperty("following") @ExcludeMissing following: JsonField<Long> = JsonMissing.of(), @JsonProperty("geoEnabled") @ExcludeMissing geoEnabled: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("grokTranslatedBio") @ExcludeMissing grokTranslatedBio: JsonField<GrokTranslatedBio> = JsonMissing.of(), @JsonProperty("hasCustomTimelines") @ExcludeMissing hasCustomTimelines: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("hasExtendedProfile") @ExcludeMissing hasExtendedProfile: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("hasGraduatedAccess") @ExcludeMissing hasGraduatedAccess: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("hasHiddenSubscriptionsOnProfile") @ExcludeMissing hasHiddenSubscriptionsOnProfile: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("highlightsInfo") @ExcludeMissing highlightsInfo: JsonField<HighlightsInfo> = JsonMissing.of(), @JsonProperty("identityVerification") @ExcludeMissing identityVerification: JsonField<IdentityVerification> = JsonMissing.of(), @JsonProperty("isAutomated") @ExcludeMissing isAutomated: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("isBlueVerified") @ExcludeMissing isBlueVerified: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("isProfileTranslatable") @ExcludeMissing isProfileTranslatable: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("isTranslationEnabled") @ExcludeMissing isTranslationEnabled: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("isTranslator") @ExcludeMissing isTranslator: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("isVerified") @ExcludeMissing isVerified: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("listedCount") @ExcludeMissing listedCount: JsonField<Long> = JsonMissing.of(), @JsonProperty("location") @ExcludeMissing location: JsonField<String> = JsonMissing.of(), @JsonProperty("mediaCount") @ExcludeMissing mediaCount: JsonField<Long> = JsonMissing.of(), @JsonProperty("normalFollowersCount") @ExcludeMissing normalFollowersCount: JsonField<Long> = JsonMissing.of(), @JsonProperty("parodyCommentaryFanLabel") @ExcludeMissing parodyCommentaryFanLabel: JsonField<String> = JsonMissing.of(), @JsonProperty("pinnedTweetIds") @ExcludeMissing pinnedTweetIds: JsonField<List<String>> = JsonMissing.of(), @JsonProperty("possiblySensitive") @ExcludeMissing possiblySensitive: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("professional") @ExcludeMissing professional: JsonField<Professional> = JsonMissing.of(), @JsonProperty("profile_bio") @ExcludeMissing profileBio: JsonField<ProfileBio> = JsonMissing.of(), @JsonProperty("profileBannerUrl") @ExcludeMissing profileBannerUrl: JsonField<String> = JsonMissing.of(), @JsonProperty("profileDescriptionLanguage") @ExcludeMissing profileDescriptionLanguage: JsonField<String> = JsonMissing.of(), @JsonProperty("profileImageShape") @ExcludeMissing profileImageShape: JsonField<String> = JsonMissing.of(), @JsonProperty("profileInterstitialType") @ExcludeMissing profileInterstitialType: JsonField<String> = JsonMissing.of(), @JsonProperty("profilePicture") @ExcludeMissing profilePicture: JsonField<String> = JsonMissing.of(), @JsonProperty("profilePictureOriginal") @ExcludeMissing profilePictureOriginal: JsonField<String> = JsonMissing.of(), @JsonProperty("profileSortEnabled") @ExcludeMissing profileSortEnabled: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("profileTranslatorType") @ExcludeMissing profileTranslatorType: JsonField<String> = JsonMissing.of(), @JsonProperty("protected") @ExcludeMissing protected_: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("redirectsToUsername") @ExcludeMissing redirectsToUsername: JsonField<String> = JsonMissing.of(), @JsonProperty("retweetedAt") @ExcludeMissing retweetedAt: JsonField<OffsetDateTime> = JsonMissing.of(), @JsonProperty("statusesCount") @ExcludeMissing statusesCount: JsonField<Long> = JsonMissing.of(), @JsonProperty("subscribersCount") @ExcludeMissing subscribersCount: JsonField<Long> = JsonMissing.of(), @JsonProperty("superFollowEligible") @ExcludeMissing superFollowEligible: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("superFollowsUserProfileActive") @ExcludeMissing superFollowsUserProfileActive: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("tipJar") @ExcludeMissing tipJar: JsonField<TipJar> = JsonMissing.of(), @JsonProperty("unavailable") @ExcludeMissing unavailable: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("unavailableReason") @ExcludeMissing unavailableReason: JsonField<String> = JsonMissing.of(), @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(), @JsonProperty("usernameChanges") @ExcludeMissing usernameChanges: JsonField<UsernameChanges> = JsonMissing.of(), @JsonProperty("verificationReason") @ExcludeMissing verificationReason: JsonField<VerificationReason> = JsonMissing.of(), @JsonProperty("verified") @ExcludeMissing verified: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("verifiedType") @ExcludeMissing verifiedType: JsonField<String> = JsonMissing.of(), @JsonProperty("withheldInCountries") @ExcludeMissing withheldInCountries: JsonField<List<String>> = JsonMissing.of(), @JsonProperty("withheldScope") @ExcludeMissing withheldScope: JsonField<String> = JsonMissing.of(), ) : this( id, name, username, accountBasedIn, accountBasedInAccurate, accountBasedInUnavailable, advertiserAccountServiceLevels, advertiserAccountType, affiliatesHighlightedLabel, affiliateUsername, automatedBy, birthdate, businessAccountAffiliatesCount, businessProfileState, communityRole, connectedVia, connectedViaAccurate, contactInfo, coverPicture, createdAt, creatorSubscriptionsCount, defaultProfile, defaultProfileImage, description, email, fastFollowersCount, favouritesCount, followers, following, geoEnabled, grokTranslatedBio, hasCustomTimelines, hasExtendedProfile, hasGraduatedAccess, hasHiddenSubscriptionsOnProfile, highlightsInfo, identityVerification, isAutomated, isBlueVerified, isProfileTranslatable, isTranslationEnabled, isTranslator, isVerified, listedCount, location, mediaCount, normalFollowersCount, parodyCommentaryFanLabel, pinnedTweetIds, possiblySensitive, professional, profileBio, profileBannerUrl, profileDescriptionLanguage, profileImageShape, profileInterstitialType, profilePicture, profilePictureOriginal, profileSortEnabled, profileTranslatorType, protected_, redirectsToUsername, retweetedAt, statusesCount, subscribersCount, superFollowEligible, superFollowsUserProfileActive, tipJar, unavailable, unavailableReason, url, usernameChanges, verificationReason, verified, verifiedType, withheldInCountries, withheldScope, mutableMapOf(), ) /** * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is * unexpectedly missing or null. */ fun id(): String = id.getRequired("id") /** * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is * unexpectedly missing or null. */ fun name(): String = name.getRequired("name") /** * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is * unexpectedly missing or null. */ fun username(): String = username.getRequired("username") /** * Null when X shows no label. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun accountBasedIn(): Optional<AccountBasedIn> = accountBasedIn.getOptional("accountBasedIn") /** * False when X notes accountBasedIn may be inaccurate. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun accountBasedInAccurate(): Optional<Boolean> = accountBasedInAccurate.getOptional("accountBasedInAccurate") /** * True when X withheld accountBasedIn from this read. Retry later. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun accountBasedInUnavailable(): Optional<Boolean> = accountBasedInUnavailable.getOptional("accountBasedInUnavailable") /** * X Ads services the account uses, such as `analytics`, `media_studio` or `smb`. Empty for an * account without ads. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun advertiserAccountServiceLevels(): Optional<List<String>> = advertiserAccountServiceLevels.getOptional("advertiserAccountServiceLevels") /** * The account's X Ads type. `none` for an account without ads, or `promotable_user` for one * that may run them. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun advertiserAccountType(): Optional<String> = advertiserAccountType.getOptional("advertiserAccountType") /** * Organization affiliation label shown on an X profile. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun affiliatesHighlightedLabel(): Optional<AffiliatesHighlightedLabel> = affiliatesHighlightedLabel.getOptional("affiliatesHighlightedLabel") /** * Handle of the organization X shows the account is affiliated with, from its About page. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun affiliateUsername(): Optional<String> = affiliateUsername.getOptional("affiliateUsername") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun automatedBy(): Optional<String> = automatedBy.getOptional("automatedBy") /** * The parts of the birthday the account made public. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun birthdate(): Optional<Birthdate> = birthdate.getOptional("birthdate") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun businessAccountAffiliatesCount(): Optional<Long> = businessAccountAffiliatesCount.getOptional("businessAccountAffiliatesCount") /** * Whether X treats the profile as a business profile. `none` or `enabled`. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun businessProfileState(): Optional<String> = businessProfileState.getOptional("businessProfileState") /** * Community role when returned by community member reads * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun communityRole(): Optional<String> = communityRole.getOptional("communityRole") /** * How the account first connected to X. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun connectedVia(): Optional<String> = connectedVia.getOptional("connectedVia") /** * False when X notes that country may be inaccurate. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun connectedViaAccurate(): Optional<Boolean> = connectedViaAccurate.getOptional("connectedViaAccurate") /** * Emails, phone numbers & links the account publishes on its own profile. Omitted when it * publishes none. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun contactInfo(): Optional<ContactInfo> = contactInfo.getOptional("contactInfo") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun coverPicture(): Optional<String> = coverPicture.getOptional("coverPicture") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun createdAt(): Optional<String> = createdAt.getOptional("createdAt") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun creatorSubscriptionsCount(): Optional<Long> = creatorSubscriptionsCount.getOptional("creatorSubscriptionsCount") /** * Whether the profile keeps X's default theme. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun defaultProfile(): Optional<Boolean> = defaultProfile.getOptional("defaultProfile") /** * Whether the profile keeps X's default avatar. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun defaultProfileImage(): Optional<Boolean> = defaultProfileImage.getOptional("defaultProfileImage") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun description(): Optional<String> = description.getOptional("description") /** * First email the account publishes on its profile, lowercased. Omitted when it publishes none. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun email(): Optional<String> = email.getOptional("email") /** * Followers X counts as fast followers. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun fastFollowersCount(): Optional<Long> = fastFollowersCount.getOptional("fastFollowersCount") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun favouritesCount(): Optional<Long> = favouritesCount.getOptional("favouritesCount") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun followers(): Optional<Long> = followers.getOptional("followers") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun following(): Optional<Long> = following.getOptional("following") /** * Whether the profile may add a location to posts. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun geoEnabled(): Optional<Boolean> = geoEnabled.getOptional("geoEnabled") /** * Public profile bio translation returned by X * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun grokTranslatedBio(): Optional<GrokTranslatedBio> = grokTranslatedBio.getOptional("grokTranslatedBio") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun hasCustomTimelines(): Optional<Boolean> = hasCustomTimelines.getOptional("hasCustomTimelines") /** * Whether the profile filled X's extended fields, such as a birth date. True or false. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun hasExtendedProfile(): Optional<Boolean> = hasExtendedProfile.getOptional("hasExtendedProfile") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun hasGraduatedAccess(): Optional<Boolean> = hasGraduatedAccess.getOptional("hasGraduatedAccess") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun hasHiddenSubscriptionsOnProfile(): Optional<Boolean> = hasHiddenSubscriptionsOnProfile.getOptional("hasHiddenSubscriptionsOnProfile") /** * Profile highlight availability and count metadata. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun highlightsInfo(): Optional<HighlightsInfo> = highlightsInfo.getOptional("highlightsInfo") /** * Identity verification metadata displayed by X. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun identityVerification(): Optional<IdentityVerification> = identityVerification.getOptional("identityVerification") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun isAutomated(): Optional<Boolean> = isAutomated.getOptional("isAutomated") /** * Whether X shows a blue verification badge * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun isBlueVerified(): Optional<Boolean> = isBlueVerified.getOptional("isBlueVerified") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun isProfileTranslatable(): Optional<Boolean> = isProfileTranslatable.getOptional("isProfileTranslatable") /** * Whether the account turned on X's translation of its posts. True or false. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun isTranslationEnabled(): Optional<Boolean> = isTranslationEnabled.getOptional("isTranslationEnabled") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun isTranslator(): Optional<Boolean> = isTranslator.getOptional("isTranslator") /** * Whether X marks the profile as verified * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun isVerified(): Optional<Boolean> = isVerified.getOptional("isVerified") /** * Public lists that include the profile. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun listedCount(): Optional<Long> = listedCount.getOptional("listedCount") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun location(): Optional<String> = location.getOptional("location") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun mediaCount(): Optional<Long> = mediaCount.getOptional("mediaCount") /** * Followers minus fast followers. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun normalFollowersCount(): Optional<Long> = normalFollowersCount.getOptional("normalFollowersCount") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun parodyCommentaryFanLabel(): Optional<String> = parodyCommentaryFanLabel.getOptional("parodyCommentaryFanLabel") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun pinnedTweetIds(): Optional<List<String>> = pinnedTweetIds.getOptional("pinnedTweetIds") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun possiblySensitive(): Optional<Boolean> = possiblySensitive.getOptional("possiblySensitive") /** * Professional metadata with category display settings * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun professional(): Optional<Professional> = professional.getOptional("professional") /** * Structured profile bio with entity annotations * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun profileBio(): Optional<ProfileBio> = profileBio.getOptional("profile_bio") /** * Original X profile banner field when available * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun profileBannerUrl(): Optional<String> = profileBannerUrl.getOptional("profileBannerUrl") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun profileDescriptionLanguage(): Optional<String> = profileDescriptionLanguage.getOptional("profileDescriptionLanguage") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun profileImageShape(): Optional<String> = profileImageShape.getOptional("profileImageShape") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun profileInterstitialType(): Optional<String> = profileInterstitialType.getOptional("profileInterstitialType") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun profilePicture(): Optional<String> = profilePicture.getOptional("profilePicture") /** * The same profile picture at full size, as the account uploaded it. Download this one for the * image. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun profilePictureOriginal(): Optional<String> = profilePictureOriginal.getOptional("profilePictureOriginal") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun profileSortEnabled(): Optional<Boolean> = profileSortEnabled.getOptional("profileSortEnabled") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun profileTranslatorType(): Optional<String> = profileTranslatorType.getOptional("profileTranslatorType") /** * Whether the profile protects its posts * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun protected_(): Optional<Boolean> = protected_.getOptional("protected") /** * Handle x.com sends this profile's visitors to, such as the new handle of a renamed account * whose old handle now holds a placeholder. Missing when x.com shows the profile itself. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun redirectsToUsername(): Optional<String> = redirectsToUsername.getOptional("redirectsToUsername") /** * UTC repost time with includeRetweetTimestamp. Null if the newest profile page has no match or * lookup failed. Otherwise omitted. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun retweetedAt(): Optional<OffsetDateTime> = retweetedAt.getOptional("retweetedAt") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun statusesCount(): Optional<Long> = statusesCount.getOptional("statusesCount") /** * Accounts subscribed to the profile's paid Subscriptions. 0 when it has none. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun subscribersCount(): Optional<Long> = subscribersCount.getOptional("subscribersCount") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun superFollowEligible(): Optional<Boolean> = superFollowEligible.getOptional("superFollowEligible") /** * Whether X marks the subscription profile as active. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun superFollowsUserProfileActive(): Optional<Boolean> = superFollowsUserProfileActive.getOptional("superFollowsUserProfileActive") /** * Public payment and creator-support handles shown on X. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun tipJar(): Optional<TipJar> = tipJar.getOptional("tipJar") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun unavailable(): Optional<Boolean> = unavailable.getOptional("unavailable") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun unavailableReason(): Optional<String> = unavailableReason.getOptional("unavailableReason") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun url(): Optional<String> = url.getOptional("url") /** * How often the account changed its username. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun usernameChanges(): Optional<UsernameChanges> = usernameChanges.getOptional("usernameChanges") /** * X's text on why the profile is verified, with its links. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun verificationReason(): Optional<VerificationReason> = verificationReason.getOptional("verificationReason") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun verified(): Optional<Boolean> = verified.getOptional("verified") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun verifiedType(): Optional<String> = verifiedType.getOptional("verifiedType") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun withheldInCountries(): Optional<List<String>> = withheldInCountries.getOptional("withheldInCountries") /** * Whether X withholds a post or user * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun withheldScope(): Optional<String> = withheldScope.getOptional("withheldScope") /** * Returns the raw JSON value of [id]. * * Unlike [id], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id /** * Returns the raw JSON value of [name]. * * Unlike [name], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name /** * Returns the raw JSON value of [username]. * * Unlike [username], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username /** * Returns the raw JSON value of [accountBasedIn]. * * Unlike [accountBasedIn], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("accountBasedIn") @ExcludeMissing fun _accountBasedIn(): JsonField<AccountBasedIn> = accountBasedIn /** * Returns the raw JSON value of [accountBasedInAccurate]. * * Unlike [accountBasedInAccurate], this method doesn't throw if the JSON field has an * unexpected type. */ @JsonProperty("accountBasedInAccurate") @ExcludeMissing fun _accountBasedInAccurate(): JsonField<Boolean> = accountBasedInAccurate /** * Returns the raw JSON value of [accountBasedInUnavailable]. * * Unlike [accountBasedInUnavailable], this method doesn't throw if the JSON field has an * unexpected type. */ @JsonProperty("accountBasedInUnavailable") @ExcludeMissing fun _accountBasedInUnavailable(): JsonField<Boolean> = accountBasedInUnavailable /** * Returns the raw JSON value of [advertiserAccountServiceLevels]. * * Unlike [advertiserAccountServiceLevels], this method doesn't throw if the JSON field has an * unexpected type. */ @JsonProperty("advertiserAccountServiceLevels") @ExcludeMissing fun _advertiserAccountServiceLevels(): JsonField<List<String>> = advertiserAccountServiceLevels /** * Returns the raw JSON value of [advertiserAccountType]. * * Unlike [advertiserAccountType], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("advertiserAccountType") @ExcludeMissing fun _advertiserAccountType(): JsonField<String> = advertiserAccountType /** * Returns the raw JSON value of [affiliatesHighlightedLabel]. * * Unlike [affiliatesHighlightedLabel], this method doesn't throw if the JSON field has an * unexpected type. */ @JsonProperty("affiliatesHighlightedLabel") @ExcludeMissing fun _affiliatesHighlightedLabel(): JsonField<AffiliatesHighlightedLabel> = affiliatesHighlightedLabel /** * Returns the raw JSON value of [affiliateUsername]. * * Unlike [affiliateUsername], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("affiliateUsername") @ExcludeMissing fun _affiliateUsername(): JsonField<String> = affiliateUsername /** * Returns the raw JSON value of [automatedBy]. * * Unlike [automatedBy], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("automatedBy") @ExcludeMissing fun _automatedBy(): JsonField<String> = automatedBy /** * Returns the raw JSON value of [birthdate]. * * Unlike [birthdate], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("birthdate") @ExcludeMissing fun _birthdate(): JsonField<Birthdate> = birthdate /** * Returns the raw JSON value of [businessAccountAffiliatesCount]. * * Unlike [businessAccountAffiliatesCount], this method doesn't throw if the JSON field has an * unexpected type. */ @JsonProperty("businessAccountAffiliatesCount") @ExcludeMissing fun _businessAccountAffiliatesCount(): JsonField<Long> = businessAccountAffiliatesCount /** * Returns the raw JSON value of [businessProfileState]. * * Unlike [businessProfileState], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("businessProfileState") @ExcludeMissing fun _businessProfileState(): JsonField<String> = businessProfileState /** * Returns the raw JSON value of [communityRole]. * * Unlike [communityRole], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("communityRole") @ExcludeMissing fun _communityRole(): JsonField<String> = communityRole /** * Returns the raw JSON value of [connectedVia]. * * Unlike [connectedVia], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("connectedVia") @ExcludeMissing fun _connectedVia(): JsonField<String> = connectedVia /** * Returns the raw JSON value of [connectedViaAccurate]. * * Unlike [connectedViaAccurate], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("connectedViaAccurate") @ExcludeMissing fun _connectedViaAccurate(): JsonField<Boolean> = connectedViaAccurate /** * Returns the raw JSON value of [contactInfo]. * * Unlike [contactInfo], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("contactInfo") @ExcludeMissing fun _contactInfo(): JsonField<ContactInfo> = contactInfo /** * Returns the raw JSON value of [coverPicture]. * * Unlike [coverPicture], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("coverPicture") @ExcludeMissing fun _coverPicture(): JsonField<String> = coverPicture /** * Returns the raw JSON value of [createdAt]. * * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("createdAt") @ExcludeMissing fun _createdAt(): JsonField<String> = createdAt /** * Returns the raw JSON value of [creatorSubscriptionsCount]. * * Unlike [creatorSubscriptionsCount], this method doesn't throw if the JSON field has an * unexpected type. */ @JsonProperty("creatorSubscriptionsCount") @ExcludeMissing fun _creatorSubscriptionsCount(): JsonField<Long> = creatorSubscriptionsCount /** * Returns the raw JSON value of [defaultProfile]. * * Unlike [defaultProfile], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("defaultProfile") @ExcludeMissing fun _defaultProfile(): JsonField<Boolean> = defaultProfile /** * Returns the raw JSON value of [defaultProfileImage]. * * Unlike [defaultProfileImage], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("defaultProfileImage") @ExcludeMissing fun _defaultProfileImage(): JsonField<Boolean> = defaultProfileImage /** * Returns the raw JSON value of [description]. * * Unlike [description], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description /** * Returns the raw JSON value of [email]. * * Unlike [email], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email /** * Returns the raw JSON value of [fastFollowersCount]. * * Unlike [fastFollowersCount], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("fastFollowersCount") @ExcludeMissing fun _fastFollowersCount(): JsonField<Long> = fastFollowersCount /** * Returns the raw JSON value of [favouritesCount]. * * Unlike [favouritesCount], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("favouritesCount") @ExcludeMissing fun _favouritesCount(): JsonField<Long> = favouritesCount /** * Returns the raw JSON value of [followers]. * * Unlike [followers], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("followers") @ExcludeMissing fun _followers(): JsonField<Long> = followers /** * Returns the raw JSON value of [following]. * * Unlike [following], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("following") @ExcludeMissing fun _following(): JsonField<Long> = following /** * Returns the raw JSON value of [geoEnabled]. * * Unlike [geoEnabled], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("geoEnabled") @ExcludeMissing fun _geoEnabled(): JsonField<Boolean> = geoEnabled /** * Returns the raw JSON value of [grokTranslatedBio]. * * Unlike [grokTranslatedBio], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("grokTranslatedBio") @ExcludeMissing fun _grokTranslatedBio(): JsonField<GrokTranslatedBio> = grokTranslatedBio /** * Returns the raw JSON value of [hasCustomTimelines]. * * Unlike [hasCustomTimelines], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("hasCustomTimelines") @ExcludeMissing fun _hasCustomTimelines(): JsonField<Boolean> = hasCustomTimelines /** * Returns the raw JSON value of [hasExtendedProfile]. * * Unlike [hasExtendedProfile], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("hasExtendedProfile") @ExcludeMissing fun _hasExtendedProfile(): JsonField<Boolean> = hasExtendedProfile /** * Returns the raw JSON value of [hasGraduatedAccess]. * * Unlike [hasGraduatedAccess], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("hasGraduatedAccess") @ExcludeMissing fun _hasGraduatedAccess(): JsonField<Boolean> = hasGraduatedAccess /** * Returns the raw JSON value of [hasHiddenSubscriptionsOnProfile]. * * Unlike [hasHiddenSubscriptionsOnProfile], this method doesn't throw if the JSON field has an * unexpected type. */ @JsonProperty("hasHiddenSubscriptionsOnProfile") @ExcludeMissing fun _hasHiddenSubscriptionsOnProfile(): JsonField<Boolean> = hasHiddenSubscriptionsOnProfile /** * Returns the raw JSON value of [highlightsInfo]. * * Unlike [highlightsInfo], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("highlightsInfo") @ExcludeMissing fun _highlightsInfo(): JsonField<HighlightsInfo> = highlightsInfo /** * Returns the raw JSON value of [identityVerification]. * * Unlike [identityVerification], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("identityVerification") @ExcludeMissing fun _identityVerification(): JsonField<IdentityVerification> = identityVerification /** * Returns the raw JSON value of [isAutomated]. * * Unlike [isAutomated], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("isAutomated") @ExcludeMissing fun _isAutomated(): JsonField<Boolean> = isAutomated /** * Returns the raw JSON value of [isBlueVerified]. * * Unlike [isBlueVerified], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("isBlueVerified") @ExcludeMissing fun _isBlueVerified(): JsonField<Boolean> = isBlueVerified /** * Returns the raw JSON value of [isProfileTranslatable]. * * Unlike [isProfileTranslatable], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("isProfileTranslatable") @ExcludeMissing fun _isProfileTranslatable(): JsonField<Boolean> = isProfileTranslatable /** * Returns the raw JSON value of [isTranslationEnabled]. * * Unlike [isTranslationEnabled], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("isTranslationEnabled") @ExcludeMissing fun _isTranslationEnabled(): JsonField<Boolean> = isTranslationEnabled /** * Returns the raw JSON value of [isTranslator]. * * Unlike [isTranslator], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("isTranslator") @ExcludeMissing fun _isTranslator(): JsonField<Boolean> = isTranslator /** * Returns the raw JSON value of [isVerified]. * * Unlike [isVerified], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("isVerified") @ExcludeMissing fun _isVerified(): JsonField<Boolean> = isVerified /** * Returns the raw JSON value of [listedCount]. * * Unlike [listedCount], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("listedCount") @ExcludeMissing fun _listedCount(): JsonField<Long> = listedCount /** * Returns the raw JSON value of [location]. * * Unlike [location], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("location") @ExcludeMissing fun _location(): JsonField<String> = location /** * Returns the raw JSON value of [mediaCount]. * * Unlike [mediaCount], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("mediaCount") @ExcludeMissing fun _mediaCount(): JsonField<Long> = mediaCount /** * Returns the raw JSON value of [normalFollowersCount]. * * Unlike [normalFollowersCount], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("normalFollowersCount") @ExcludeMissing fun _normalFollowersCount(): JsonField<Long> = normalFollowersCount /** * Returns the raw JSON value of [parodyCommentaryFanLabel]. * * Unlike [parodyCommentaryFanLabel], this method doesn't throw if the JSON field has an * unexpected type. */ @JsonProperty("parodyCommentaryFanLabel") @ExcludeMissing fun _parodyCommentaryFanLabel(): JsonField<String> = parodyCommentaryFanLabel /** * Returns the raw JSON value of [pinnedTweetIds]. * * Unlike [pinnedTweetIds], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("pinnedTweetIds") @ExcludeMissing fun _pinnedTweetIds(): JsonField<List<String>> = pinnedTweetIds /** * Returns the raw JSON value of [possiblySensitive]. * * Unlike [possiblySensitive], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("possiblySensitive") @ExcludeMissing fun _possiblySensitive(): JsonField<Boolean> = possiblySensitive /** * Returns the raw JSON value of [professional]. * * Unlike [professional], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("professional") @ExcludeMissing fun _professional(): JsonField<Professional> = professional /** * Returns the raw JSON value of [profileBio]. * * Unlike [profileBio], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("profile_bio") @ExcludeMissing fun _profileBio(): JsonField<ProfileBio> = profileBio /** * Returns the raw JSON value of [profileBannerUrl]. * * Unlike [profileBannerUrl], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("profileBannerUrl") @ExcludeMissing fun _profileBannerUrl(): JsonField<String> = profileBannerUrl /** * Returns the raw JSON value of [profileDescriptionLanguage]. * * Unlike [profileDescriptionLanguage], this method doesn't throw if the JSON field has an * unexpected type. */ @JsonProperty("profileDescriptionLanguage") @ExcludeMissing fun _profileDescriptionLanguage(): JsonField<String> = profileDescriptionLanguage /** * Returns the raw JSON value of [profileImageShape]. * * Unlike [profileImageShape], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("profileImageShape") @ExcludeMissing fun _profileImageShape(): JsonField<String> = profileImageShape /** * Returns the raw JSON value of [profileInterstitialType]. * * Unlike [profileInterstitialType], this method doesn't throw if the JSON field has an * unexpected type. */ @JsonProperty("profileInterstitialType") @ExcludeMissing fun _profileInterstitialType(): JsonField<String> = profileInterstitialType /** * Returns the raw JSON value of [profilePicture]. * * Unlike [profilePicture], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("profilePicture") @ExcludeMissing fun _profilePicture(): JsonField<String> = profilePicture /** * Returns the raw JSON value of [profilePictureOriginal]. * * Unlike [profilePictureOriginal], this method doesn't throw if the JSON field has an * unexpected type. */ @JsonProperty("profilePictureOriginal") @ExcludeMissing fun _profilePictureOriginal(): JsonField<String> = profilePictureOriginal /** * Returns the raw JSON value of [profileSortEnabled]. * * Unlike [profileSortEnabled], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("profileSortEnabled") @ExcludeMissing fun _profileSortEnabled(): JsonField<Boolean> = profileSortEnabled /** * Returns the raw JSON value of [profileTranslatorType]. * * Unlike [profileTranslatorType], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("profileTranslatorType") @ExcludeMissing fun _profileTranslatorType(): JsonField<String> = profileTranslatorType /** * Returns the raw JSON value of [protected_]. * * Unlike [protected_], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("protected") @ExcludeMissing fun _protected_(): JsonField<Boolean> = protected_ /** * Returns the raw JSON value of [redirectsToUsername]. * * Unlike [redirectsToUsername], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("redirectsToUsername") @ExcludeMissing fun _redirectsToUsername(): JsonField<String> = redirectsToUsername /** * Returns the raw JSON value of [retweetedAt]. * * Unlike [retweetedAt], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("retweetedAt") @ExcludeMissing fun _retweetedAt(): JsonField<OffsetDateTime> = retweetedAt /** * Returns the raw JSON value of [statusesCount]. * * Unlike [statusesCount], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("statusesCount") @ExcludeMissing fun _statusesCount(): JsonField<Long> = statusesCount /** * Returns the raw JSON value of [subscribersCount]. * * Unlike [subscribersCount], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("subscribersCount") @ExcludeMissing fun _subscribersCount(): JsonField<Long> = subscribersCount /** * Returns the raw JSON value of [superFollowEligible]. * * Unlike [superFollowEligible], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("superFollowEligible") @ExcludeMissing fun _superFollowEligible(): JsonField<Boolean> = superFollowEligible /** * Returns the raw JSON value of [superFollowsUserProfileActive]. * * Unlike [superFollowsUserProfileActive], this method doesn't throw if the JSON field has an * unexpected type. */ @JsonProperty("superFollowsUserProfileActive") @ExcludeMissing fun _superFollowsUserProfileActive(): JsonField<Boolean> = superFollowsUserProfileActive /** * Returns the raw JSON value of [tipJar]. * * Unlike [tipJar], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("tipJar") @ExcludeMissing fun _tipJar(): JsonField<TipJar> = tipJar /** * Returns the raw JSON value of [unavailable]. * * Unlike [unavailable], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("unavailable") @ExcludeMissing fun _unavailable(): JsonField<Boolean> = unavailable /** * Returns the raw JSON value of [unavailableReason]. * * Unlike [unavailableReason], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("unavailableReason") @ExcludeMissing fun _unavailableReason(): JsonField<String> = unavailableReason /** * Returns the raw JSON value of [url]. * * Unlike [url], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url /** * Returns the raw JSON value of [usernameChanges]. * * Unlike [usernameChanges], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("usernameChanges") @ExcludeMissing fun _usernameChanges(): JsonField<UsernameChanges> = usernameChanges /** * Returns the raw JSON value of [verificationReason]. * * Unlike [verificationReason], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("verificationReason") @ExcludeMissing fun _verificationReason(): JsonField<VerificationReason> = verificationReason /** * Returns the raw JSON value of [verified]. * * Unlike [verified], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("verified") @ExcludeMissing fun _verified(): JsonField<Boolean> = verified /** * Returns the raw JSON value of [verifiedType]. * * Unlike [verifiedType], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("verifiedType") @ExcludeMissing fun _verifiedType(): JsonField<String> = verifiedType /** * Returns the raw JSON value of [withheldInCountries]. * * Unlike [withheldInCountries], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("withheldInCountries") @ExcludeMissing fun _withheldInCountries(): JsonField<List<String>> = withheldInCountries /** * Returns the raw JSON value of [withheldScope]. * * Unlike [withheldScope], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("withheldScope") @ExcludeMissing fun _withheldScope(): JsonField<String> = withheldScope @JsonAnySetter private fun putAdditionalProperty(key: String, value: JsonValue) { additionalProperties.put(key, value) } @JsonAnyGetter @ExcludeMissing fun _additionalProperties(): Map<String, JsonValue> = Collections.unmodifiableMap(additionalProperties) fun toBuilder() = Builder().from(this) companion object { /** * Returns a mutable builder for constructing an instance of [UserProfile]. * * The following fields are required: * ```java * .id() * .name() * .username() * ``` */ @JvmStatic fun builder() = Builder() } /** A builder for [UserProfile]. */ class Builder internal constructor() { private var id: JsonField<String>? = null private var name: JsonField<String>? = null private var username: JsonField<String>? = null private var accountBasedIn: JsonField<AccountBasedIn> = JsonMissing.of() private var accountBasedInAccurate: JsonField<Boolean> = JsonMissing.of() private var accountBasedInUnavailable: JsonField<Boolean> = JsonMissing.of() private var advertiserAccountServiceLevels: JsonField<MutableList<String>>? = null private var advertiserAccountType: JsonField<String> = JsonMissing.of() private var affiliatesHighlightedLabel: JsonField<AffiliatesHighlightedLabel> = JsonMissing.of() private var affiliateUsername: JsonField<String> = JsonMissing.of() private var automatedBy: JsonField<String> = JsonMissing.of() private var birthdate: JsonField<Birthdate> = JsonMissing.of() private var businessAccountAffiliatesCount: JsonField<Long> = JsonMissing.of() private var businessProfileState: JsonField<String> = JsonMissing.of() private var communityRole: JsonField<String> = JsonMissing.of() private var connectedVia: JsonField<String> = JsonMissing.of() private var connectedViaAccurate: JsonField<Boolean> = JsonMissing.of() private var contactInfo: JsonField<ContactInfo> = JsonMissing.of() private var coverPicture: JsonField<String> = JsonMissing.of() private var createdAt: JsonField<String> = JsonMissing.of() private var creatorSubscriptionsCount: JsonField<Long> = JsonMissing.of() private var defaultProfile: JsonField<Boolean> = JsonMissing.of() private var defaultProfileImage: JsonField<Boolean> = JsonMissing.of() private var description: JsonField<String> = JsonMissing.of() private var email: JsonField<String> = JsonMissing.of() private var fastFollowersCount: JsonField<Long> = JsonMissing.of() private var favouritesCount: JsonField<Long> = JsonMissing.of() private var followers: JsonField<Long> = JsonMissing.of() private var following: JsonField<Long> = JsonMissing.of() private var geoEnabled: JsonField<Boolean> = JsonMissing.of() private var grokTranslatedBio: JsonField<GrokTranslatedBio> = JsonMissing.of() private var hasCustomTimelines: JsonField<Boolean> = JsonMissing.of() private var hasExtendedProfile: JsonField<Boolean> = JsonMissing.of() private var hasGraduatedAccess: JsonField<Boolean> = JsonMissing.of() private var hasHiddenSubscriptionsOnProfile: JsonField<Boolean> = JsonMissing.of() private var highlightsInfo: JsonField<HighlightsInfo> = JsonMissing.of() private var identityVerification: JsonField<IdentityVerification> = JsonMissing.of() private var isAutomated: JsonField<Boolean> = JsonMissing.of() private var isBlueVerified: JsonField<Boolean> = JsonMissing.of() private var isProfileTranslatable: JsonField<Boolean> = JsonMissing.of() private var isTranslationEnabled: JsonField<Boolean> = JsonMissing.of() private var isTranslator: JsonField<Boolean> = JsonMissing.of() private var isVerified: JsonField<Boolean> = JsonMissing.of() private var listedCount: JsonField<Long> = JsonMissing.of() private var location: JsonField<String> = JsonMissing.of() private var mediaCount: JsonField<Long> = JsonMissing.of() private var normalFollowersCount: JsonField<Long> = JsonMissing.of() private var parodyCommentaryFanLabel: JsonField<String> = JsonMissing.of() private var pinnedTweetIds: JsonField<MutableList<String>>? = null private var possiblySensitive: JsonField<Boolean> = JsonMissing.of() private var professional: JsonField<Professional> = JsonMissing.of() private var profileBio: JsonField<ProfileBio> = JsonMissing.of() private var profileBannerUrl: JsonField<String> = JsonMissing.of() private var profileDescriptionLanguage: JsonField<String> = JsonMissing.of() private var profileImageShape: JsonField<String> = JsonMissing.of() private var profileInterstitialType: JsonField<String> = JsonMissing.of() private var profilePicture: JsonField<String> = JsonMissing.of() private var profilePictureOriginal: JsonField<String> = JsonMissing.of() private var profileSortEnabled: JsonField<Boolean> = JsonMissing.of() private var profileTranslatorType: JsonField<String> = JsonMissing.of() private var protected_: JsonField<Boolean> = JsonMissing.of() private var redirectsToUsername: JsonField<String> = JsonMissing.of() private var retweetedAt: JsonField<OffsetDateTime> = JsonMissing.of() private var statusesCount: JsonField<Long> = JsonMissing.of() private var subscribersCount: JsonField<Long> = JsonMissing.of() private var superFollowEligible: JsonField<Boolean> = JsonMissing.of() private var superFollowsUserProfileActive: JsonField<Boolean> = JsonMissing.of() private var tipJar: JsonField<TipJar> = JsonMissing.of() private var unavailable: JsonField<Boolean> = JsonMissing.of() private var unavailableReason: JsonField<String> = JsonMissing.of() private var url: JsonField<String> = JsonMissing.of() private var usernameChanges: JsonField<UsernameChanges> = JsonMissing.of() private var verificationReason: JsonField<VerificationReason> = JsonMissing.of() private var verified: JsonField<Boolean> = JsonMissing.of() private var verifiedType: JsonField<String> = JsonMissing.of() private var withheldInCountries: JsonField<MutableList<String>>? = null private var withheldScope: JsonField<String> = JsonMissing.of() private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf() @JvmSynthetic internal fun from(userProfile: UserProfile) = apply { id = userProfile.id name = userProfile.name username = userProfile.username accountBasedIn = userProfile.accountBasedIn accountBasedInAccurate = userProfile.accountBasedInAccurate accountBasedInUnavailable = userProfile.accountBasedInUnavailable advertiserAccountServiceLevels = userProfile.advertiserAccountServiceLevels.map { it.toMutableList() } advertiserAccountType = userProfile.advertiserAccountType affiliatesHighlightedLabel = userProfile.affiliatesHighlightedLabel affiliateUsername = userProfile.affiliateUsername automatedBy = userProfile.automatedBy birthdate = userProfile.birthdate businessAccountAffiliatesCount = userProfile.businessAccountAffiliatesCount businessProfileState = userProfile.businessProfileState communityRole = userProfile.communityRole connectedVia = userProfile.connectedVia connectedViaAccurate = userProfile.connectedViaAccurate contactInfo = userProfile.contactInfo coverPicture = userProfile.coverPicture createdAt = userProfile.createdAt creatorSubscriptionsCount = userProfile.creatorSubscriptionsCount defaultProfile = userProfile.defaultProfile defaultProfileImage = userProfile.defaultProfileImage description = userProfile.description email = userProfile.email fastFollowersCount = userProfile.fastFollowersCount favouritesCount = userProfile.favouritesCount followers = userProfile.followers following = userProfile.following geoEnabled = userProfile.geoEnabled grokTranslatedBio = userProfile.grokTranslatedBio hasCustomTimelines = userProfile.hasCustomTimelines hasExtendedProfile = userProfile.hasExtendedProfile hasGraduatedAccess = userProfile.hasGraduatedAccess hasHiddenSubscriptionsOnProfile = userProfile.hasHiddenSubscriptionsOnProfile highlightsInfo = userProfile.highlightsInfo identityVerification = userProfile.identityVerification isAutomated = userProfile.isAutomated isBlueVerified = userProfile.isBlueVerified isProfileTranslatable = userProfile.isProfileTranslatable isTranslationEnabled = userProfile.isTranslationEnabled isTranslator = userProfile.isTranslator isVerified = userProfile.isVerified listedCount = userProfile.listedCount location = userProfile.location mediaCount = userProfile.mediaCount normalFollowersCount = userProfile.normalFollowersCount parodyCommentaryFanLabel = userProfile.parodyCommentaryFanLabel pinnedTweetIds = userProfile.pinnedTweetIds.map { it.toMutableList() } possiblySensitive = userProfile.possiblySensitive professional = userProfile.professional profileBio = userProfile.profileBio profileBannerUrl = userProfile.profileBannerUrl profileDescriptionLanguage = userProfile.profileDescriptionLanguage profileImageShape = userProfile.profileImageShape profileInterstitialType = userProfile.profileInterstitialType profilePicture = userProfile.profilePicture profilePictureOriginal = userProfile.profilePictureOriginal profileSortEnabled = userProfile.profileSortEnabled profileTranslatorType = userProfile.profileTranslatorType protected_ = userProfile.protected_ redirectsToUsername = userProfile.redirectsToUsername retweetedAt = userProfile.retweetedAt statusesCount = userProfile.statusesCount subscribersCount = userProfile.subscribersCount superFollowEligible = userProfile.superFollowEligible superFollowsUserProfileActive = userProfile.superFollowsUserProfileActive tipJar = userProfile.tipJar unavailable = userProfile.unavailable unavailableReason = userProfile.unavailableReason url = userProfile.url usernameChanges = userProfile.usernameChanges verificationReason = userProfile.verificationReason verified = userProfile.verified verifiedType = userProfile.verifiedType withheldInCountries = userProfile.withheldInCountries.map { it.toMutableList() } withheldScope = userProfile.withheldScope additionalProperties = userProfile.additionalProperties.toMutableMap() } fun id(id: String) = id(JsonField.of(id)) /** Sets [Builder.id] to an arbitrary JSON value. */ fun id(id: JsonField<String>) = apply { this.id = id } fun name(name: String) = name(JsonField.of(name)) /** Sets [Builder.name] to an arbitrary JSON value. */ fun name(name: JsonField<String>) = apply { this.name = name } fun username(username: String) = username(JsonField.of(username)) /** Sets [Builder.username] to an arbitrary JSON value. */ fun username(username: JsonField<String>) = apply { this.username = username } /** Null when X shows no label. */ fun accountBasedIn(accountBasedIn: AccountBasedIn?) = accountBasedIn(JsonField.ofNullable(accountBasedIn)) /** Alias for calling [Builder.accountBasedIn] with `accountBasedIn.orElse(null)`. */ fun accountBasedIn(accountBasedIn: Optional<AccountBasedIn>) = accountBasedIn(accountBasedIn.getOrNull()) /** Sets [Builder.accountBasedIn] to an arbitrary JSON value. */ fun accountBasedIn(accountBasedIn: JsonField<AccountBasedIn>) = apply { this.accountBasedIn = accountBasedIn } /** False when X notes accountBasedIn may be inaccurate. */ fun accountBasedInAccurate(accountBasedInAccurate: Boolean) = accountBasedInAccurate(JsonField.of(accountBasedInAccurate)) /** Sets [Builder.accountBasedInAccurate] to an arbitrary JSON value. */ fun accountBasedInAccurate(accountBasedInAccurate: JsonField<Boolean>) = apply { this.accountBasedInAccurate = accountBasedInAccurate } /** True when X withheld accountBasedIn from this read. Retry later. */ fun accountBasedInUnavailable(accountBasedInUnavailable: Boolean) = accountBasedInUnavailable(JsonField.of(accountBasedInUnavailable)) /** Sets [Builder.accountBasedInUnavailable] to an arbitrary JSON value. */ fun accountBasedInUnavailable(accountBasedInUnavailable: JsonField<Boolean>) = apply { this.accountBasedInUnavailable = accountBasedInUnavailable } /** * X Ads services the account uses, such as `analytics`, `media_studio` or `smb`. Empty for * an account without ads. */ fun advertiserAccountServiceLevels(advertiserAccountServiceLevels: List<String>) = advertiserAccountServiceLevels(JsonField.of(advertiserAccountServiceLevels)) /** Sets [Builder.advertiserAccountServiceLevels] to an arbitrary JSON value. */ fun advertiserAccountServiceLevels( advertiserAccountServiceLevels: JsonField<List<String>> ) = apply { this.advertiserAccountServiceLevels = advertiserAccountServiceLevels.map { it.toMutableList() } } /** * Adds a single [String] to [advertiserAccountServiceLevels]. * * @throws IllegalStateException if the field was previously set to a non-list. */ fun addAdvertiserAccountServiceLevel(advertiserAccountServiceLevel: String) = apply { advertiserAccountServiceLevels = (advertiserAccountServiceLevels ?: JsonField.of(mutableListOf())).also { checkKnown("advertiserAccountServiceLevels", it) .add(advertiserAccountServiceLevel) } } /** * The account's X Ads type. `none` for an account without ads, or `promotable_user` for one * that may run them. */ fun advertiserAccountType(advertiserAccountType: String) = advertiserAccountType(JsonField.of(advertiserAccountType)) /** Sets [Builder.advertiserAccountType] to an arbitrary JSON value. */ fun advertiserAccountType(advertiserAccountType: JsonField<String>) = apply { this.advertiserAccountType = advertiserAccountType } /** Organization affiliation label shown on an X profile. */ fun affiliatesHighlightedLabel(affiliatesHighlightedLabel: AffiliatesHighlightedLabel) = affiliatesHighlightedLabel(JsonField.of(affiliatesHighlightedLabel)) /** Sets [Builder.affiliatesHighlightedLabel] to an arbitrary JSON value. */ fun affiliatesHighlightedLabel( affiliatesHighlightedLabel: JsonField<AffiliatesHighlightedLabel> ) = apply { this.affiliatesHighlightedLabel = affiliatesHighlightedLabel } /** * Handle of the organization X shows the account is affiliated with, from its About page. */ fun affiliateUsername(affiliateUsername: String) = affiliateUsername(JsonField.of(affiliateUsername)) /** Sets [Builder.affiliateUsername] to an arbitrary JSON value. */ fun affiliateUsername(affiliateUsername: JsonField<String>) = apply { this.affiliateUsername = affiliateUsername } fun automatedBy(automatedBy: String) = automatedBy(JsonField.of(automatedBy)) /** Sets [Builder.automatedBy] to an arbitrary JSON value. */ fun automatedBy(automatedBy: JsonField<String>) = apply { this.automatedBy = automatedBy } /** The parts of the birthday the account made public. */ fun birthdate(birthdate: Birthdate) = birthdate(JsonField.of(birthdate)) /** Sets [Builder.birthdate] to an arbitrary JSON value. */ fun birthdate(birthdate: JsonField<Birthdate>) = apply { this.birthdate = birthdate } fun businessAccountAffiliatesCount(businessAccountAffiliatesCount: Long) = businessAccountAffiliatesCount(JsonField.of(businessAccountAffiliatesCount)) /** Sets [Builder.businessAccountAffiliatesCount] to an arbitrary JSON value. */ fun businessAccountAffiliatesCount(businessAccountAffiliatesCount: JsonField<Long>) = apply { this.businessAccountAffiliatesCount = businessAccountAffiliatesCount } /** Whether X treats the profile as a business profile. `none` or `enabled`. */ fun businessProfileState(businessProfileState: String) = businessProfileState(JsonField.of(businessProfileState)) /** Sets [Builder.businessProfileState] to an arbitrary JSON value. */ fun businessProfileState(businessProfileState: JsonField<String>) = apply { this.businessProfileState = businessProfileState } /** Community role when returned by community member reads */ fun communityRole(communityRole: String) = communityRole(JsonField.of(communityRole)) /** Sets [Builder.communityRole] to an arbitrary JSON value. */ fun communityRole(communityRole: JsonField<String>) = apply { this.communityRole = communityRole } /** How the account first connected to X. */ fun connectedVia(connectedVia: String) = connectedVia(JsonField.of(connectedVia)) /** Sets [Builder.connectedVia] to an arbitrary JSON value. */ fun connectedVia(connectedVia: JsonField<String>) = apply { this.connectedVia = connectedVia } /** False when X notes that country may be inaccurate. */ fun connectedViaAccurate(connectedViaAccurate: Boolean) = connectedViaAccurate(JsonField.of(connectedViaAccurate)) /** Sets [Builder.connectedViaAccurate] to an arbitrary JSON value. */ fun connectedViaAccurate(connectedViaAccurate: JsonField<Boolean>) = apply { this.connectedViaAccurate = connectedViaAccurate } /** * Emails, phone numbers & links the account publishes on its own profile. Omitted when it * publishes none. */ fun contactInfo(contactInfo: ContactInfo) = contactInfo(JsonField.of(contactInfo)) /** Sets [Builder.contactInfo] to an arbitrary JSON value. */ fun contactInfo(contactInfo: JsonField<ContactInfo>) = apply { this.contactInfo = contactInfo } fun coverPicture(coverPicture: String) = coverPicture(JsonField.of(coverPicture)) /** Sets [Builder.coverPicture] to an arbitrary JSON value. */ fun coverPicture(coverPicture: JsonField<String>) = apply { this.coverPicture = coverPicture } fun createdAt(createdAt: String) = createdAt(JsonField.of(createdAt)) /** Sets [Builder.createdAt] to an arbitrary JSON value. */ fun createdAt(createdAt: JsonField<String>) = apply { this.createdAt = createdAt } fun creatorSubscriptionsCount(creatorSubscriptionsCount: Long) = creatorSubscriptionsCount(JsonField.of(creatorSubscriptionsCount)) /** Sets [Builder.creatorSubscriptionsCount] to an arbitrary JSON value. */ fun creatorSubscriptionsCount(creatorSubscriptionsCount: JsonField<Long>) = apply { this.creatorSubscriptionsCount = creatorSubscriptionsCount } /** Whether the profile keeps X's default theme. */ fun defaultProfile(defaultProfile: Boolean) = defaultProfile(JsonField.of(defaultProfile)) /** Sets [Builder.defaultProfile] to an arbitrary JSON value. */ fun defaultProfile(defaultProfile: JsonField<Boolean>) = apply { this.defaultProfile = defaultProfile } /** Whether the profile keeps X's default avatar. */ fun defaultProfileImage(defaultProfileImage: Boolean) = defaultProfileImage(JsonField.of(defaultProfileImage)) /** Sets [Builder.defaultProfileImage] to an arbitrary JSON value. */ fun defaultProfileImage(defaultProfileImage: JsonField<Boolean>) = apply { this.defaultProfileImage = defaultProfileImage } fun description(description: String) = description(JsonField.of(description)) /** Sets [Builder.description] to an arbitrary JSON value. */ fun description(description: JsonField<String>) = apply { this.description = description } /** * First email the account publishes on its profile, lowercased. Omitted when it publishes * none. */ fun email(email: String) = email(JsonField.of(email)) /** Sets [Builder.email] to an arbitrary JSON value. */ fun email(email: JsonField<String>) = apply { this.email = email } /** Followers X counts as fast followers. */ fun fastFollowersCount(fastFollowersCount: Long) = fastFollowersCount(JsonField.of(fastFollowersCount)) /** Sets [Builder.fastFollowersCount] to an arbitrary JSON value. */ fun fastFollowersCount(fastFollowersCount: JsonField<Long>) = apply { this.fastFollowersCount = fastFollowersCount } fun favouritesCount(favouritesCount: Long) = favouritesCount(JsonField.of(favouritesCount)) /** Sets [Builder.favouritesCount] to an arbitrary JSON value. */ fun favouritesCount(favouritesCount: JsonField<Long>) = apply { this.favouritesCount = favouritesCount } fun followers(followers: Long) = followers(JsonField.of(followers)) /** Sets [Builder.followers] to an arbitrary JSON value. */ fun followers(followers: JsonField<Long>) = apply { this.followers = followers } fun following(following: Long) = following(JsonField.of(following)) /** Sets [Builder.following] to an arbitrary JSON value. */ fun following(following: JsonField<Long>) = apply { this.following = following } /** Whether the profile may add a location to posts. */ fun geoEnabled(geoEnabled: Boolean) = geoEnabled(JsonField.of(geoEnabled)) /** Sets [Builder.geoEnabled] to an arbitrary JSON value. */ fun geoEnabled(geoEnabled: JsonField<Boolean>) = apply { this.geoEnabled = geoEnabled } /** Public profile bio translation returned by X */ fun grokTranslatedBio(grokTranslatedBio: GrokTranslatedBio) = grokTranslatedBio(JsonField.of(grokTranslatedBio)) /** Sets [Builder.grokTranslatedBio] to an arbitrary JSON value. */ fun grokTranslatedBio(grokTranslatedBio: JsonField<GrokTranslatedBio>) = apply { this.grokTranslatedBio = grokTranslatedBio } fun hasCustomTimelines(hasCustomTimelines: Boolean) = hasCustomTimelines(JsonField.of(hasCustomTimelines)) /** Sets [Builder.hasCustomTimelines] to an arbitrary JSON value. */ fun hasCustomTimelines(hasCustomTimelines: JsonField<Boolean>) = apply { this.hasCustomTimelines = hasCustomTimelines } /** Whether the profile filled X's extended fields, such as a birth date. True or false. */ fun hasExtendedProfile(hasExtendedProfile: Boolean) = hasExtendedProfile(JsonField.of(hasExtendedProfile)) /** Sets [Builder.hasExtendedProfile] to an arbitrary JSON value. */ fun hasExtendedProfile(hasExtendedProfile: JsonField<Boolean>) = apply { this.hasExtendedProfile = hasExtendedProfile } fun hasGraduatedAccess(hasGraduatedAccess: Boolean) = hasGraduatedAccess(JsonField.of(hasGraduatedAccess)) /** Sets [Builder.hasGraduatedAccess] to an arbitrary JSON value. */ fun hasGraduatedAccess(hasGraduatedAccess: JsonField<Boolean>) = apply { this.hasGraduatedAccess = hasGraduatedAccess } fun hasHiddenSubscriptionsOnProfile(hasHiddenSubscriptionsOnProfile: Boolean) = hasHiddenSubscriptionsOnProfile(JsonField.of(hasHiddenSubscriptionsOnProfile)) /** Sets [Builder.hasHiddenSubscriptionsOnProfile] to an arbitrary JSON value. */ fun hasHiddenSubscriptionsOnProfile(hasHiddenSubscriptionsOnProfile: JsonField<Boolean>) = apply { this.hasHiddenSubscriptionsOnProfile = hasHiddenSubscriptionsOnProfile } /** Profile highlight availability and count metadata. */ fun highlightsInfo(highlightsInfo: HighlightsInfo) = highlightsInfo(JsonField.of(highlightsInfo)) /** Sets [Builder.highlightsInfo] to an arbitrary JSON value. */ fun highlightsInfo(highlightsInfo: JsonField<HighlightsInfo>) = apply { this.highlightsInfo = highlightsInfo } /** Identity verification metadata displayed by X. */ fun identityVerification(identityVerification: IdentityVerification) = identityVerification(JsonField.of(identityVerification)) /** Sets [Builder.identityVerification] to an arbitrary JSON value. */ fun identityVerification(identityVerification: JsonField<IdentityVerification>) = apply { this.identityVerification = identityVerification } fun isAutomated(isAutomated: Boolean) = isAutomated(JsonField.of(isAutomated)) /** Sets [Builder.isAutomated] to an arbitrary JSON value. */ fun isAutomated(isAutomated: JsonField<Boolean>) = apply { this.isAutomated = isAutomated } /** Whether X shows a blue verification badge */ fun isBlueVerified(isBlueVerified: Boolean) = isBlueVerified(JsonField.of(isBlueVerified)) /** Sets [Builder.isBlueVerified] to an arbitrary JSON value. */ fun isBlueVerified(isBlueVerified: JsonField<Boolean>) = apply { this.isBlueVerified = isBlueVerified } fun isProfileTranslatable(isProfileTranslatable: Boolean) = isProfileTranslatable(JsonField.of(isProfileTranslatable)) /** Sets [Builder.isProfileTranslatable] to an arbitrary JSON value. */ fun isProfileTranslatable(isProfileTranslatable: JsonField<Boolean>) = apply { this.isProfileTranslatable = isProfileTranslatable } /** Whether the account turned on X's translation of its posts. True or false. */ fun isTranslationEnabled(isTranslationEnabled: Boolean) = isTranslationEnabled(JsonField.of(isTranslationEnabled)) /** Sets [Builder.isTranslationEnabled] to an arbitrary JSON value. */ fun isTranslationEnabled(isTranslationEnabled: JsonField<Boolean>) = apply { this.isTranslationEnabled = isTranslationEnabled } fun isTranslator(isTranslator: Boolean) = isTranslator(JsonField.of(isTranslator)) /** Sets [Builder.isTranslator] to an arbitrary JSON value. */ fun isTranslator(isTranslator: JsonField<Boolean>) = apply { this.isTranslator = isTranslator } /** Whether X marks the profile as verified */ fun isVerified(isVerified: Boolean) = isVerified(JsonField.of(isVerified)) /** Sets [Builder.isVerified] to an arbitrary JSON value. */ fun isVerified(isVerified: JsonField<Boolean>) = apply { this.isVerified = isVerified } /** Public lists that include the profile. */ fun listedCount(listedCount: Long) = listedCount(JsonField.of(listedCount)) /** Sets [Builder.listedCount] to an arbitrary JSON value. */ fun listedCount(listedCount: JsonField<Long>) = apply { this.listedCount = listedCount } fun location(location: String) = location(JsonField.of(location)) /** Sets [Builder.location] to an arbitrary JSON value. */ fun location(location: JsonField<String>) = apply { this.location = location } fun mediaCount(mediaCount: Long) = mediaCount(JsonField.of(mediaCount)) /** Sets [Builder.mediaCount] to an arbitrary JSON value. */ fun mediaCount(mediaCount: JsonField<Long>) = apply { this.mediaCount = mediaCount } /** Followers minus fast followers. */ fun normalFollowersCount(normalFollowersCount: Long) = normalFollowersCount(JsonField.of(normalFollowersCount)) /** Sets [Builder.normalFollowersCount] to an arbitrary JSON value. */ fun normalFollowersCount(normalFollowersCount: JsonField<Long>) = apply { this.normalFollowersCount = normalFollowersCount } fun parodyCommentaryFanLabel(parodyCommentaryFanLabel: String) = parodyCommentaryFanLabel(JsonField.of(parodyCommentaryFanLabel)) /** Sets [Builder.parodyCommentaryFanLabel] to an arbitrary JSON value. */ fun parodyCommentaryFanLabel(parodyCommentaryFanLabel: JsonField<String>) = apply { this.parodyCommentaryFanLabel = parodyCommentaryFanLabel } fun pinnedTweetIds(pinnedTweetIds: List<String>) = pinnedTweetIds(JsonField.of(pinnedTweetIds)) /** Sets [Builder.pinnedTweetIds] to an arbitrary JSON value. */ fun pinnedTweetIds(pinnedTweetIds: JsonField<List<String>>) = apply { this.pinnedTweetIds = pinnedTweetIds.map { it.toMutableList() } } /** * Adds a single [String] to [pinnedTweetIds]. * * @throws IllegalStateException if the field was previously set to a non-list. */ fun addPinnedTweetId(pinnedTweetId: String) = apply { pinnedTweetIds = (pinnedTweetIds ?: JsonField.of(mutableListOf())).also { checkKnown("pinnedTweetIds", it).add(pinnedTweetId) } } fun possiblySensitive(possiblySensitive: Boolean) = possiblySensitive(JsonField.of(possiblySensitive)) /** Sets [Builder.possiblySensitive] to an arbitrary JSON value. */ fun possiblySensitive(possiblySensitive: JsonField<Boolean>) = apply { this.possiblySensitive = possiblySensitive } /** Professional metadata with category display settings */ fun professional(professional: Professional) = professional(JsonField.of(professional)) /** Sets [Builder.professional] to an arbitrary JSON value. */ fun professional(professional: JsonField<Professional>) = apply { this.professional = professional } /** Structured profile bio with entity annotations */ fun profileBio(profileBio: ProfileBio) = profileBio(JsonField.of(profileBio)) /** Sets [Builder.profileBio] to an arbitrary JSON value. */ fun profileBio(profileBio: JsonField<ProfileBio>) = apply { this.profileBio = profileBio } /** Original X profile banner field when available */ fun profileBannerUrl(profileBannerUrl: String) = profileBannerUrl(JsonField.of(profileBannerUrl)) /** Sets [Builder.profileBannerUrl] to an arbitrary JSON value. */ fun profileBannerUrl(profileBannerUrl: JsonField<String>) = apply { this.profileBannerUrl = profileBannerUrl } fun profileDescriptionLanguage(profileDescriptionLanguage: String) = profileDescriptionLanguage(JsonField.of(profileDescriptionLanguage)) /** Sets [Builder.profileDescriptionLanguage] to an arbitrary JSON value. */ fun profileDescriptionLanguage(profileDescriptionLanguage: JsonField<String>) = apply { this.profileDescriptionLanguage = profileDescriptionLanguage } fun profileImageShape(profileImageShape: String) = profileImageShape(JsonField.of(profileImageShape)) /** Sets [Builder.profileImageShape] to an arbitrary JSON value. */ fun profileImageShape(profileImageShape: JsonField<String>) = apply { this.profileImageShape = profileImageShape } fun profileInterstitialType(profileInterstitialType: String) = profileInterstitialType(JsonField.of(profileInterstitialType)) /** Sets [Builder.profileInterstitialType] to an arbitrary JSON value. */ fun profileInterstitialType(profileInterstitialType: JsonField<String>) = apply { this.profileInterstitialType = profileInterstitialType } fun profilePicture(profilePicture: String) = profilePicture(JsonField.of(profilePicture)) /** Sets [Builder.profilePicture] to an arbitrary JSON value. */ fun profilePicture(profilePicture: JsonField<String>) = apply { this.profilePicture = profilePicture } /** * The same profile picture at full size, as the account uploaded it. Download this one for * the image. */ fun profilePictureOriginal(profilePictureOriginal: String) = profilePictureOriginal(JsonField.of(profilePictureOriginal)) /** Sets [Builder.profilePictureOriginal] to an arbitrary JSON value. */ fun profilePictureOriginal(profilePictureOriginal: JsonField<String>) = apply { this.profilePictureOriginal = profilePictureOriginal } fun profileSortEnabled(profileSortEnabled: Boolean) = profileSortEnabled(JsonField.of(profileSortEnabled)) /** Sets [Builder.profileSortEnabled] to an arbitrary JSON value. */ fun profileSortEnabled(profileSortEnabled: JsonField<Boolean>) = apply { this.profileSortEnabled = profileSortEnabled } fun profileTranslatorType(profileTranslatorType: String) = profileTranslatorType(JsonField.of(profileTranslatorType)) /** Sets [Builder.profileTranslatorType] to an arbitrary JSON value. */ fun profileTranslatorType(profileTranslatorType: JsonField<String>) = apply { this.profileTranslatorType = profileTranslatorType } /** Whether the profile protects its posts */ fun protected_(protected_: Boolean) = protected_(JsonField.of(protected_)) /** Sets [Builder.protected_] to an arbitrary JSON value. */ fun protected_(protected_: JsonField<Boolean>) = apply { this.protected_ = protected_ } /** * Handle x.com sends this profile's visitors to, such as the new handle of a renamed * account whose old handle now holds a placeholder. Missing when x.com shows the profile * itself. */ fun redirectsToUsername(redirectsToUsername: String) = redirectsToUsername(JsonField.of(redirectsToUsername)) /** Sets [Builder.redirectsToUsername] to an arbitrary JSON value. */ fun redirectsToUsername(redirectsToUsername: JsonField<String>) = apply { this.redirectsToUsername = redirectsToUsername } /** * UTC repost time with includeRetweetTimestamp. Null if the newest profile page has no * match or lookup failed. Otherwise omitted. */ fun retweetedAt(retweetedAt: OffsetDateTime?) = retweetedAt(JsonField.ofNullable(retweetedAt)) /** Alias for calling [Builder.retweetedAt] with `retweetedAt.orElse(null)`. */ fun retweetedAt(retweetedAt: Optional<OffsetDateTime>) = retweetedAt(retweetedAt.getOrNull()) /** Sets [Builder.retweetedAt] to an arbitrary JSON value. */ fun retweetedAt(retweetedAt: JsonField<OffsetDateTime>) = apply { this.retweetedAt = retweetedAt } fun statusesCount(statusesCount: Long) = statusesCount(JsonField.of(statusesCount)) /** Sets [Builder.statusesCount] to an arbitrary JSON value. */ fun statusesCount(statusesCount: JsonField<Long>) = apply { this.statusesCount = statusesCount } /** Accounts subscribed to the profile's paid Subscriptions. 0 when it has none. */ fun subscribersCount(subscribersCount: Long) = subscribersCount(JsonField.of(subscribersCount)) /** Sets [Builder.subscribersCount] to an arbitrary JSON value. */ fun subscribersCount(subscribersCount: JsonField<Long>) = apply { this.subscribersCount = subscribersCount } fun superFollowEligible(superFollowEligible: Boolean) = superFollowEligible(JsonField.of(superFollowEligible)) /** Sets [Builder.superFollowEligible] to an arbitrary JSON value. */ fun superFollowEligible(superFollowEligible: JsonField<Boolean>) = apply { this.superFollowEligible = superFollowEligible } /** Whether X marks the subscription profile as active. */ fun superFollowsUserProfileActive(superFollowsUserProfileActive: Boolean) = superFollowsUserProfileActive(JsonField.of(superFollowsUserProfileActive)) /** Sets [Builder.superFollowsUserProfileActive] to an arbitrary JSON value. */ fun superFollowsUserProfileActive(superFollowsUserProfileActive: JsonField<Boolean>) = apply { this.superFollowsUserProfileActive = superFollowsUserProfileActive } /** Public payment and creator-support handles shown on X. */ fun tipJar(tipJar: TipJar) = tipJar(JsonField.of(tipJar)) /** Sets [Builder.tipJar] to an arbitrary JSON value. */ fun tipJar(tipJar: JsonField<TipJar>) = apply { this.tipJar = tipJar } fun unavailable(unavailable: Boolean) = unavailable(JsonField.of(unavailable)) /** Sets [Builder.unavailable] to an arbitrary JSON value. */ fun unavailable(unavailable: JsonField<Boolean>) = apply { this.unavailable = unavailable } fun unavailableReason(unavailableReason: String) = unavailableReason(JsonField.of(unavailableReason)) /** Sets [Builder.unavailableReason] to an arbitrary JSON value. */ fun unavailableReason(unavailableReason: JsonField<String>) = apply { this.unavailableReason = unavailableReason } fun url(url: String) = url(JsonField.of(url)) /** Sets [Builder.url] to an arbitrary JSON value. */ fun url(url: JsonField<String>) = apply { this.url = url } /** How often the account changed its username. */ fun usernameChanges(usernameChanges: UsernameChanges) = usernameChanges(JsonField.of(usernameChanges)) /** Sets [Builder.usernameChanges] to an arbitrary JSON value. */ fun usernameChanges(usernameChanges: JsonField<UsernameChanges>) = apply { this.usernameChanges = usernameChanges } /** X's text on why the profile is verified, with its links. */ fun verificationReason(verificationReason: VerificationReason) = verificationReason(JsonField.of(verificationReason)) /** Sets [Builder.verificationReason] to an arbitrary JSON value. */ fun verificationReason(verificationReason: JsonField<VerificationReason>) = apply { this.verificationReason = verificationReason } fun verified(verified: Boolean) = verified(JsonField.of(verified)) /** Sets [Builder.verified] to an arbitrary JSON value. */ fun verified(verified: JsonField<Boolean>) = apply { this.verified = verified } fun verifiedType(verifiedType: String) = verifiedType(JsonField.of(verifiedType)) /** Sets [Builder.verifiedType] to an arbitrary JSON value. */ fun verifiedType(verifiedType: JsonField<String>) = apply { this.verifiedType = verifiedType } fun withheldInCountries(withheldInCountries: List<String>) = withheldInCountries(JsonField.of(withheldInCountries)) /** Sets [Builder.withheldInCountries] to an arbitrary JSON value. */ fun withheldInCountries(withheldInCountries: JsonField<List<String>>) = apply { this.withheldInCountries = withheldInCountries.map { it.toMutableList() } } /** * Adds a single [String] to [withheldInCountries]. * * @throws IllegalStateException if the field was previously set to a non-list. */ fun addWithheldInCountry(withheldInCountry: String) = apply { withheldInCountries = (withheldInCountries ?: JsonField.of(mutableListOf())).also { checkKnown("withheldInCountries", it).add(withheldInCountry) } } /** Whether X withholds a post or user */ fun withheldScope(withheldScope: String) = withheldScope(JsonField.of(withheldScope)) /** Sets [Builder.withheldScope] to an arbitrary JSON value. */ fun withheldScope(withheldScope: JsonField<String>) = apply { this.withheldScope = withheldScope } fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply { this.additionalProperties.clear() putAllAdditionalProperties(additionalProperties) } fun putAdditionalProperty(key: String, value: JsonValue) = apply { additionalProperties.put(key, value) } fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply { this.additionalProperties.putAll(additionalProperties) } fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) } fun removeAllAdditionalProperties(keys: Set<String>) = apply { keys.forEach(::removeAdditionalProperty) } /** * Returns an immutable instance of [UserProfile]. * * Further updates to this [Builder] will not mutate the returned instance. * * The following fields are required: * ```java * .id() * .name() * .username() * ``` * * @throws IllegalStateException if any required field is unset. */ fun build(): UserProfile = UserProfile( checkRequired("id", id), checkRequired("name", name), checkRequired("username", username), accountBasedIn, accountBasedInAccurate, accountBasedInUnavailable, (advertiserAccountServiceLevels ?: JsonMissing.of()).map { it.toImmutable() }, advertiserAccountType, affiliatesHighlightedLabel, affiliateUsername, automatedBy, birthdate, businessAccountAffiliatesCount, businessProfileState, communityRole, connectedVia, connectedViaAccurate, contactInfo, coverPicture, createdAt, creatorSubscriptionsCount, defaultProfile, defaultProfileImage, description, email, fastFollowersCount, favouritesCount, followers, following, geoEnabled, grokTranslatedBio, hasCustomTimelines, hasExtendedProfile, hasGraduatedAccess, hasHiddenSubscriptionsOnProfile, highlightsInfo, identityVerification, isAutomated, isBlueVerified, isProfileTranslatable, isTranslationEnabled, isTranslator, isVerified, listedCount, location, mediaCount, normalFollowersCount, parodyCommentaryFanLabel, (pinnedTweetIds ?: JsonMissing.of()).map { it.toImmutable() }, possiblySensitive, professional, profileBio, profileBannerUrl, profileDescriptionLanguage, profileImageShape, profileInterstitialType, profilePicture, profilePictureOriginal, profileSortEnabled, profileTranslatorType, protected_, redirectsToUsername, retweetedAt, statusesCount, subscribersCount, superFollowEligible, superFollowsUserProfileActive, tipJar, unavailable, unavailableReason, url, usernameChanges, verificationReason, verified, verifiedType, (withheldInCountries ?: JsonMissing.of()).map { it.toImmutable() }, withheldScope, additionalProperties.toMutableMap(), ) } private var validated: Boolean = false /** * Validates that the types of all values in this object match their expected types recursively. * * This method is _not_ forwards compatible with new types from the API for existing fields. * * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match * its expected type. */ fun validate(): UserProfile = apply { if (validated) { return@apply } id() name() username() accountBasedIn().ifPresent { it.validate() } accountBasedInAccurate() accountBasedInUnavailable() advertiserAccountServiceLevels() advertiserAccountType() affiliatesHighlightedLabel().ifPresent { it.validate() } affiliateUsername() automatedBy() birthdate().ifPresent { it.validate() } businessAccountAffiliatesCount() businessProfileState() communityRole() connectedVia() connectedViaAccurate() contactInfo().ifPresent { it.validate() } coverPicture() createdAt() creatorSubscriptionsCount() defaultProfile() defaultProfileImage() description() email() fastFollowersCount() favouritesCount() followers() following() geoEnabled() grokTranslatedBio().ifPresent { it.validate() } hasCustomTimelines() hasExtendedProfile() hasGraduatedAccess() hasHiddenSubscriptionsOnProfile() highlightsInfo().ifPresent { it.validate() } identityVerification().ifPresent { it.validate() } isAutomated() isBlueVerified() isProfileTranslatable() isTranslationEnabled() isTranslator() isVerified() listedCount() location() mediaCount() normalFollowersCount() parodyCommentaryFanLabel() pinnedTweetIds() possiblySensitive() professional().ifPresent { it.validate() } profileBio().ifPresent { it.validate() } profileBannerUrl() profileDescriptionLanguage() profileImageShape() profileInterstitialType() profilePicture() profilePictureOriginal() profileSortEnabled() profileTranslatorType() protected_() redirectsToUsername() retweetedAt() statusesCount() subscribersCount() superFollowEligible() superFollowsUserProfileActive() tipJar().ifPresent { it.validate() } unavailable() unavailableReason() url() usernameChanges().ifPresent { it.validate() } verificationReason().ifPresent { it.validate() } verified() verifiedType() withheldInCountries() withheldScope() validated = true } fun isValid(): Boolean = try { validate() true } catch (e: XTwitterScraperInvalidDataException) { false } @JvmSynthetic internal fun validity(): Int = (if (id.asKnown().isPresent) 1 else 0) + (if (name.asKnown().isPresent) 1 else 0) + (if (username.asKnown().isPresent) 1 else 0) + (accountBasedIn.asKnown().getOrNull()?.validity() ?: 0) + (if (accountBasedInAccurate.asKnown().isPresent) 1 else 0) + (if (accountBasedInUnavailable.asKnown().isPresent) 1 else 0) + (advertiserAccountServiceLevels.asKnown().getOrNull()?.size ?: 0) + (if (advertiserAccountType.asKnown().isPresent) 1 else 0) + (affiliatesHighlightedLabel.asKnown().getOrNull()?.validity() ?: 0) + (if (affiliateUsername.asKnown().isPresent) 1 else 0) + (if (automatedBy.asKnown().isPresent) 1 else 0) + (birthdate.asKnown().getOrNull()?.validity() ?: 0) + (if (businessAccountAffiliatesCount.asKnown().isPresent) 1 else 0) + (if (businessProfileState.asKnown().isPresent) 1 else 0) + (if (communityRole.asKnown().isPresent) 1 else 0) + (if (connectedVia.asKnown().isPresent) 1 else 0) + (if (connectedViaAccurate.asKnown().isPresent) 1 else 0) + (contactInfo.asKnown().getOrNull()?.validity() ?: 0) + (if (coverPicture.asKnown().isPresent) 1 else 0) + (if (createdAt.asKnown().isPresent) 1 else 0) + (if (creatorSubscriptionsCount.asKnown().isPresent) 1 else 0) + (if (defaultProfile.asKnown().isPresent) 1 else 0) + (if (defaultProfileImage.asKnown().isPresent) 1 else 0) + (if (description.asKnown().isPresent) 1 else 0) + (if (email.asKnown().isPresent) 1 else 0) + (if (fastFollowersCount.asKnown().isPresent) 1 else 0) + (if (favouritesCount.asKnown().isPresent) 1 else 0) + (if (followers.asKnown().isPresent) 1 else 0) + (if (following.asKnown().isPresent) 1 else 0) + (if (geoEnabled.asKnown().isPresent) 1 else 0) + (grokTranslatedBio.asKnown().getOrNull()?.validity() ?: 0) + (if (hasCustomTimelines.asKnown().isPresent) 1 else 0) + (if (hasExtendedProfile.asKnown().isPresent) 1 else 0) + (if (hasGraduatedAccess.asKnown().isPresent) 1 else 0) + (if (hasHiddenSubscriptionsOnProfile.asKnown().isPresent) 1 else 0) + (highlightsInfo.asKnown().getOrNull()?.validity() ?: 0) + (identityVerification.asKnown().getOrNull()?.validity() ?: 0) + (if (isAutomated.asKnown().isPresent) 1 else 0) + (if (isBlueVerified.asKnown().isPresent) 1 else 0) + (if (isProfileTranslatable.asKnown().isPresent) 1 else 0) + (if (isTranslationEnabled.asKnown().isPresent) 1 else 0) + (if (isTranslator.asKnown().isPresent) 1 else 0) + (if (isVerified.asKnown().isPresent) 1 else 0) + (if (listedCount.asKnown().isPresent) 1 else 0) + (if (location.asKnown().isPresent) 1 else 0) + (if (mediaCount.asKnown().isPresent) 1 else 0) + (if (normalFollowersCount.asKnown().isPresent) 1 else 0) + (if (parodyCommentaryFanLabel.asKnown().isPresent) 1 else 0) + (pinnedTweetIds.asKnown().getOrNull()?.size ?: 0) + (if (possiblySensitive.asKnown().isPresent) 1 else 0) + (professional.asKnown().getOrNull()?.validity() ?: 0) + (profileBio.asKnown().getOrNull()?.validity() ?: 0) + (if (profileBannerUrl.asKnown().isPresent) 1 else 0) + (if (profileDescriptionLanguage.asKnown().isPresent) 1 else 0) + (if (profileImageShape.asKnown().isPresent) 1 else 0) + (if (profileInterstitialType.asKnown().isPresent) 1 else 0) + (if (profilePicture.asKnown().isPresent) 1 else 0) + (if (profilePictureOriginal.asKnown().isPresent) 1 else 0) + (if (profileSortEnabled.asKnown().isPresent) 1 else 0) + (if (profileTranslatorType.asKnown().isPresent) 1 else 0) + (if (protected_.asKnown().isPresent) 1 else 0) + (if (redirectsToUsername.asKnown().isPresent) 1 else 0) + (if (retweetedAt.asKnown().isPresent) 1 else 0) + (if (statusesCount.asKnown().isPresent) 1 else 0) + (if (subscribersCount.asKnown().isPresent) 1 else 0) + (if (superFollowEligible.asKnown().isPresent) 1 else 0) + (if (superFollowsUserProfileActive.asKnown().isPresent) 1 else 0) + (tipJar.asKnown().getOrNull()?.validity() ?: 0) + (if (unavailable.asKnown().isPresent) 1 else 0) + (if (unavailableReason.asKnown().isPresent) 1 else 0) + (if (url.asKnown().isPresent) 1 else 0) + (usernameChanges.asKnown().getOrNull()?.validity() ?: 0) + (verificationReason.asKnown().getOrNull()?.validity() ?: 0) + (if (verified.asKnown().isPresent) 1 else 0) + (if (verifiedType.asKnown().isPresent) 1 else 0) + (withheldInCountries.asKnown().getOrNull()?.size ?: 0) + (if (withheldScope.asKnown().isPresent) 1 else 0) /** * X's best-effort public label inferred from aggregated account-access IP addresses. It does * not state nationality, residence, identity, registration, post location, or exact location. */ class AccountBasedIn @JsonCreator(mode = JsonCreator.Mode.DISABLED) private constructor( private val level: JsonField<Level>, private val observedAt: JsonField<OffsetDateTime>, private val value: JsonField<String>, private val additionalProperties: MutableMap<String, JsonValue>, ) { @JsonCreator private constructor( @JsonProperty("level") @ExcludeMissing level: JsonField<Level> = JsonMissing.of(), @JsonProperty("observedAt") @ExcludeMissing observedAt: JsonField<OffsetDateTime> = JsonMissing.of(), @JsonProperty("value") @ExcludeMissing value: JsonField<String> = JsonMissing.of(), ) : this(level, observedAt, value, mutableMapOf()) /** * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or * is unexpectedly missing or null. */ fun level(): Level = level.getRequired("level") /** * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or * is unexpectedly missing or null. */ fun observedAt(): OffsetDateTime = observedAt.getRequired("observedAt") /** * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or * is unexpectedly missing or null. */ fun value(): String = value.getRequired("value") /** * Returns the raw JSON value of [level]. * * Unlike [level], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("level") @ExcludeMissing fun _level(): JsonField<Level> = level /** * Returns the raw JSON value of [observedAt]. * * Unlike [observedAt], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("observedAt") @ExcludeMissing fun _observedAt(): JsonField<OffsetDateTime> = observedAt /** * Returns the raw JSON value of [value]. * * Unlike [value], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<String> = value @JsonAnySetter private fun putAdditionalProperty(key: String, value: JsonValue) { additionalProperties.put(key, value) } @JsonAnyGetter @ExcludeMissing fun _additionalProperties(): Map<String, JsonValue> = Collections.unmodifiableMap(additionalProperties) fun toBuilder() = Builder().from(this) companion object { /** * Returns a mutable builder for constructing an instance of [AccountBasedIn]. * * The following fields are required: * ```java * .level() * .observedAt() * .value() * ``` */ @JvmStatic fun builder() = Builder() } /** A builder for [AccountBasedIn]. */ class Builder internal constructor() { private var level: JsonField<Level>? = null private var observedAt: JsonField<OffsetDateTime>? = null private var value: JsonField<String>? = null private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf() @JvmSynthetic internal fun from(accountBasedIn: AccountBasedIn) = apply { level = accountBasedIn.level observedAt = accountBasedIn.observedAt value = accountBasedIn.value additionalProperties = accountBasedIn.additionalProperties.toMutableMap() } fun level(level: Level) = level(JsonField.of(level)) /** Sets [Builder.level] to an arbitrary JSON value. */ fun level(level: JsonField<Level>) = apply { this.level = level } fun observedAt(observedAt: OffsetDateTime) = observedAt(JsonField.of(observedAt)) /** Sets [Builder.observedAt] to an arbitrary JSON value. */ fun observedAt(observedAt: JsonField<OffsetDateTime>) = apply { this.observedAt = observedAt } fun value(value: String) = value(JsonField.of(value)) /** Sets [Builder.value] to an arbitrary JSON value. */ fun value(value: JsonField<String>) = apply { this.value = value } fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply { this.additionalProperties.clear() putAllAdditionalProperties(additionalProperties) } fun putAdditionalProperty(key: String, value: JsonValue) = apply { additionalProperties.put(key, value) } fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply { this.additionalProperties.putAll(additionalProperties) } fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) } fun removeAllAdditionalProperties(keys: Set<String>) = apply { keys.forEach(::removeAdditionalProperty) } /** * Returns an immutable instance of [AccountBasedIn]. * * Further updates to this [Builder] will not mutate the returned instance. * * The following fields are required: * ```java * .level() * .observedAt() * .value() * ``` * * @throws IllegalStateException if any required field is unset. */ fun build(): AccountBasedIn = AccountBasedIn( checkRequired("level", level), checkRequired("observedAt", observedAt), checkRequired("value", value), additionalProperties.toMutableMap(), ) } private var validated: Boolean = false /** * Validates that the types of all values in this object match their expected types * recursively. * * This method is _not_ forwards compatible with new types from the API for existing fields. * * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't * match its expected type. */ fun validate(): AccountBasedIn = apply { if (validated) { return@apply } level().validate() observedAt() value() validated = true } fun isValid(): Boolean = try { validate() true } catch (e: XTwitterScraperInvalidDataException) { false } @JvmSynthetic internal fun validity(): Int = (level.asKnown().getOrNull()?.validity() ?: 0) + (if (observedAt.asKnown().isPresent) 1 else 0) + (if (value.asKnown().isPresent) 1 else 0) class Level @JsonCreator private constructor(private val value: JsonField<String>) : Enum { /** Returns this class instance's raw value. */ @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value companion object { @JvmField val COUNTRY = of("country") @JvmField val REGION = of("region") @JvmStatic fun of(value: String) = Level(JsonField.of(value)) } /** An enum containing [Level]'s known values. */ enum class Known { COUNTRY, REGION, } /** * An enum containing [Level]'s known values, as well as an [_UNKNOWN] member. * * An instance of [Level] can contain an unknown value in a couple of cases: * - It was deserialized from data that doesn't match any known member. For example, if * the SDK is on an older version than the API, then the API may respond with new * members that the SDK is unaware of. * - It was constructed with an arbitrary value using the [of] method. */ enum class Value { COUNTRY, REGION, /** * An enum member indicating that [Level] was instantiated with an unknown value. */ _UNKNOWN, } /** * Returns an enum member corresponding to this class instance's value, or * [Value._UNKNOWN] if the class was instantiated with an unknown value. */ fun value(): Value = when (this) { COUNTRY -> Value.COUNTRY REGION -> Value.REGION else -> Value._UNKNOWN } /** * Returns an enum member corresponding to this class instance's value. * * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a * known member. */ fun known(): Known = when (this) { COUNTRY -> Known.COUNTRY REGION -> Known.REGION else -> throw XTwitterScraperInvalidDataException("Unknown Level: $value") } /** * Returns this class instance's primitive wire representation. * * @throws XTwitterScraperInvalidDataException if this class instance's value does not * have the expected primitive type. */ fun asString(): String = _value().asString().orElseThrow { XTwitterScraperInvalidDataException("Value is not a String") } private var validated: Boolean = false /** * Validates that the types of all values in this object match their expected types * recursively. * * This method is _not_ forwards compatible with new types from the API for existing * fields. * * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't * match its expected type. */ fun validate(): Level = apply { if (validated) { return@apply } known() validated = true } fun isValid(): Boolean = try { validate() true } catch (e: XTwitterScraperInvalidDataException) { false } @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1 override fun equals(other: Any?): Boolean { if (this === other) { return true } return other is Level && value == other.value } override fun hashCode() = value.hashCode() override fun toString() = value.toString() } override fun equals(other: Any?): Boolean { if (this === other) { return true } return other is AccountBasedIn && level == other.level && observedAt == other.observedAt && value == other.value && additionalProperties == other.additionalProperties } private val hashCode: Int by lazy { Objects.hash(level, observedAt, value, additionalProperties) } override fun hashCode(): Int = hashCode override fun toString() = "AccountBasedIn{level=$level, observedAt=$observedAt, value=$value, additionalProperties=$additionalProperties}" } /** Organization affiliation label shown on an X profile. */ class AffiliatesHighlightedLabel @JsonCreator(mode = JsonCreator.Mode.DISABLED) private constructor( private val badgeUrl: JsonField<String>, private val description: JsonField<String>, private val longDescription: JsonField<LongDescription>, private val url: JsonField<String>, private val urlType: JsonField<String>, private val userLabelDisplayType: JsonField<String>, private val userLabelType: JsonField<String>, private val auxiliaryLabels: JsonField<List<UserAuxiliaryLabel>>, private val additionalProperties: MutableMap<String, JsonValue>, ) { @JsonCreator private constructor( @JsonProperty("badgeUrl") @ExcludeMissing badgeUrl: JsonField<String> = JsonMissing.of(), @JsonProperty("description") @ExcludeMissing description: JsonField<String> = JsonMissing.of(), @JsonProperty("longDescription") @ExcludeMissing longDescription: JsonField<LongDescription> = JsonMissing.of(), @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(), @JsonProperty("urlType") @ExcludeMissing urlType: JsonField<String> = JsonMissing.of(), @JsonProperty("userLabelDisplayType") @ExcludeMissing userLabelDisplayType: JsonField<String> = JsonMissing.of(), @JsonProperty("userLabelType") @ExcludeMissing userLabelType: JsonField<String> = JsonMissing.of(), @JsonProperty("auxiliaryLabels") @ExcludeMissing auxiliaryLabels: JsonField<List<UserAuxiliaryLabel>> = JsonMissing.of(), ) : this( badgeUrl, description, longDescription, url, urlType, userLabelDisplayType, userLabelType, auxiliaryLabels, mutableMapOf(), ) /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun badgeUrl(): Optional<String> = badgeUrl.getOptional("badgeUrl") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun description(): Optional<String> = description.getOptional("description") /** * Public text, ranges, references, and mention data. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun longDescription(): Optional<LongDescription> = longDescription.getOptional("longDescription") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun url(): Optional<String> = url.getOptional("url") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun urlType(): Optional<String> = urlType.getOptional("urlType") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun userLabelDisplayType(): Optional<String> = userLabelDisplayType.getOptional("userLabelDisplayType") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun userLabelType(): Optional<String> = userLabelType.getOptional("userLabelType") /** More labels X shows beside the affiliation, such as an automated account's owner. */
                fun auxiliaryLabels(): Optional<List<UserAuxiliaryLabel>> = auxiliaryLabels.getOptional("auxiliaryLabels")

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

                /** Returns the raw JSON value of [auxiliaryLabels]. */
                @JsonProperty("auxiliaryLabels") @ExcludeMissing fun _auxiliaryLabels(): JsonField<List<UserAuxiliaryLabel>> = auxiliaryLabels

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
                    private var auxiliaryLabels: JsonField<MutableList<UserAuxiliaryLabel>>? = null
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
                            auxiliaryLabels = affiliatesHighlightedLabel.auxiliaryLabels.map { it.toMutableList() }
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

                    /** X user profile with bio, follower counts, and verification status. */ class UserProfile @JsonCreator(mode = JsonCreator.Mode.DISABLED) private constructor( private val id: JsonField<String>, private val name: JsonField<String>, private val username: JsonField<String>, private val accountBasedIn: JsonField<AccountBasedIn>, private val accountBasedInAccurate: JsonField<Boolean>, private val accountBasedInUnavailable: JsonField<Boolean>, private val advertiserAccountServiceLevels: JsonField<List<String>>, private val advertiserAccountType: JsonField<String>, private val affiliatesHighlightedLabel: JsonField<AffiliatesHighlightedLabel>, private val affiliateUsername: JsonField<String>, private val automatedBy: JsonField<String>, private val birthdate: JsonField<Birthdate>, private val businessAccountAffiliatesCount: JsonField<Long>, private val businessProfileState: JsonField<String>, private val communityRole: JsonField<String>, private val connectedVia: JsonField<String>, private val connectedViaAccurate: JsonField<Boolean>, private val contactInfo: JsonField<ContactInfo>, private val coverPicture: JsonField<String>, private val createdAt: JsonField<String>, private val creatorSubscriptionsCount: JsonField<Long>, private val defaultProfile: JsonField<Boolean>, private val defaultProfileImage: JsonField<Boolean>, private val description: JsonField<String>, private val email: JsonField<String>, private val fastFollowersCount: JsonField<Long>, private val favouritesCount: JsonField<Long>, private val followers: JsonField<Long>, private val following: JsonField<Long>, private val geoEnabled: JsonField<Boolean>, private val grokTranslatedBio: JsonField<GrokTranslatedBio>, private val hasCustomTimelines: JsonField<Boolean>, private val hasExtendedProfile: JsonField<Boolean>, private val hasGraduatedAccess: JsonField<Boolean>, private val hasHiddenSubscriptionsOnProfile: JsonField<Boolean>, private val highlightsInfo: JsonField<HighlightsInfo>, private val identityVerification: JsonField<IdentityVerification>, private val isAutomated: JsonField<Boolean>, private val isBlueVerified: JsonField<Boolean>, private val isProfileTranslatable: JsonField<Boolean>, private val isTranslationEnabled: JsonField<Boolean>, private val isTranslator: JsonField<Boolean>, private val isVerified: JsonField<Boolean>, private val listedCount: JsonField<Long>, private val location: JsonField<String>, private val mediaCount: JsonField<Long>, private val normalFollowersCount: JsonField<Long>, private val parodyCommentaryFanLabel: JsonField<String>, private val pinnedTweetIds: JsonField<List<String>>, private val possiblySensitive: JsonField<Boolean>, private val professional: JsonField<Professional>, private val profileBio: JsonField<ProfileBio>, private val profileBannerUrl: JsonField<String>, private val profileDescriptionLanguage: JsonField<String>, private val profileImageShape: JsonField<String>, private val profileInterstitialType: JsonField<String>, private val profilePicture: JsonField<String>, private val profilePictureOriginal: JsonField<String>, private val profileSortEnabled: JsonField<Boolean>, private val profileTranslatorType: JsonField<String>, private val protected_: JsonField<Boolean>, private val redirectsToUsername: JsonField<String>, private val retweetedAt: JsonField<OffsetDateTime>, private val statusesCount: JsonField<Long>, private val subscribersCount: JsonField<Long>, private val superFollowEligible: JsonField<Boolean>, private val superFollowsUserProfileActive: JsonField<Boolean>, private val tipJar: JsonField<TipJar>, private val unavailable: JsonField<Boolean>, private val unavailableReason: JsonField<String>, private val url: JsonField<String>, private val usernameChanges: JsonField<UsernameChanges>, private val verificationReason: JsonField<VerificationReason>, private val verified: JsonField<Boolean>, private val verifiedType: JsonField<String>, private val withheldInCountries: JsonField<List<String>>, private val withheldScope: JsonField<String>, private val additionalProperties: MutableMap<String, JsonValue>, ) { @JsonCreator private constructor( @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(), @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(), @JsonProperty("username") @ExcludeMissing username: JsonField<String> = JsonMissing.of(), @JsonProperty("accountBasedIn") @ExcludeMissing accountBasedIn: JsonField<AccountBasedIn> = JsonMissing.of(), @JsonProperty("accountBasedInAccurate") @ExcludeMissing accountBasedInAccurate: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("accountBasedInUnavailable") @ExcludeMissing accountBasedInUnavailable: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("advertiserAccountServiceLevels") @ExcludeMissing advertiserAccountServiceLevels: JsonField<List<String>> = JsonMissing.of(), @JsonProperty("advertiserAccountType") @ExcludeMissing advertiserAccountType: JsonField<String> = JsonMissing.of(), @JsonProperty("affiliatesHighlightedLabel") @ExcludeMissing affiliatesHighlightedLabel: JsonField<AffiliatesHighlightedLabel> = JsonMissing.of(), @JsonProperty("affiliateUsername") @ExcludeMissing affiliateUsername: JsonField<String> = JsonMissing.of(), @JsonProperty("automatedBy") @ExcludeMissing automatedBy: JsonField<String> = JsonMissing.of(), @JsonProperty("birthdate") @ExcludeMissing birthdate: JsonField<Birthdate> = JsonMissing.of(), @JsonProperty("businessAccountAffiliatesCount") @ExcludeMissing businessAccountAffiliatesCount: JsonField<Long> = JsonMissing.of(), @JsonProperty("businessProfileState") @ExcludeMissing businessProfileState: JsonField<String> = JsonMissing.of(), @JsonProperty("communityRole") @ExcludeMissing communityRole: JsonField<String> = JsonMissing.of(), @JsonProperty("connectedVia") @ExcludeMissing connectedVia: JsonField<String> = JsonMissing.of(), @JsonProperty("connectedViaAccurate") @ExcludeMissing connectedViaAccurate: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("contactInfo") @ExcludeMissing contactInfo: JsonField<ContactInfo> = JsonMissing.of(), @JsonProperty("coverPicture") @ExcludeMissing coverPicture: JsonField<String> = JsonMissing.of(), @JsonProperty("createdAt") @ExcludeMissing createdAt: JsonField<String> = JsonMissing.of(), @JsonProperty("creatorSubscriptionsCount") @ExcludeMissing creatorSubscriptionsCount: JsonField<Long> = JsonMissing.of(), @JsonProperty("defaultProfile") @ExcludeMissing defaultProfile: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("defaultProfileImage") @ExcludeMissing defaultProfileImage: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("description") @ExcludeMissing description: JsonField<String> = JsonMissing.of(), @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(), @JsonProperty("fastFollowersCount") @ExcludeMissing fastFollowersCount: JsonField<Long> = JsonMissing.of(), @JsonProperty("favouritesCount") @ExcludeMissing favouritesCount: JsonField<Long> = JsonMissing.of(), @JsonProperty("followers") @ExcludeMissing followers: JsonField<Long> = JsonMissing.of(), @JsonProperty("following") @ExcludeMissing following: JsonField<Long> = JsonMissing.of(), @JsonProperty("geoEnabled") @ExcludeMissing geoEnabled: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("grokTranslatedBio") @ExcludeMissing grokTranslatedBio: JsonField<GrokTranslatedBio> = JsonMissing.of(), @JsonProperty("hasCustomTimelines") @ExcludeMissing hasCustomTimelines: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("hasExtendedProfile") @ExcludeMissing hasExtendedProfile: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("hasGraduatedAccess") @ExcludeMissing hasGraduatedAccess: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("hasHiddenSubscriptionsOnProfile") @ExcludeMissing hasHiddenSubscriptionsOnProfile: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("highlightsInfo") @ExcludeMissing highlightsInfo: JsonField<HighlightsInfo> = JsonMissing.of(), @JsonProperty("identityVerification") @ExcludeMissing identityVerification: JsonField<IdentityVerification> = JsonMissing.of(), @JsonProperty("isAutomated") @ExcludeMissing isAutomated: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("isBlueVerified") @ExcludeMissing isBlueVerified: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("isProfileTranslatable") @ExcludeMissing isProfileTranslatable: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("isTranslationEnabled") @ExcludeMissing isTranslationEnabled: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("isTranslator") @ExcludeMissing isTranslator: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("isVerified") @ExcludeMissing isVerified: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("listedCount") @ExcludeMissing listedCount: JsonField<Long> = JsonMissing.of(), @JsonProperty("location") @ExcludeMissing location: JsonField<String> = JsonMissing.of(), @JsonProperty("mediaCount") @ExcludeMissing mediaCount: JsonField<Long> = JsonMissing.of(), @JsonProperty("normalFollowersCount") @ExcludeMissing normalFollowersCount: JsonField<Long> = JsonMissing.of(), @JsonProperty("parodyCommentaryFanLabel") @ExcludeMissing parodyCommentaryFanLabel: JsonField<String> = JsonMissing.of(), @JsonProperty("pinnedTweetIds") @ExcludeMissing pinnedTweetIds: JsonField<List<String>> = JsonMissing.of(), @JsonProperty("possiblySensitive") @ExcludeMissing possiblySensitive: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("professional") @ExcludeMissing professional: JsonField<Professional> = JsonMissing.of(), @JsonProperty("profile_bio") @ExcludeMissing profileBio: JsonField<ProfileBio> = JsonMissing.of(), @JsonProperty("profileBannerUrl") @ExcludeMissing profileBannerUrl: JsonField<String> = JsonMissing.of(), @JsonProperty("profileDescriptionLanguage") @ExcludeMissing profileDescriptionLanguage: JsonField<String> = JsonMissing.of(), @JsonProperty("profileImageShape") @ExcludeMissing profileImageShape: JsonField<String> = JsonMissing.of(), @JsonProperty("profileInterstitialType") @ExcludeMissing profileInterstitialType: JsonField<String> = JsonMissing.of(), @JsonProperty("profilePicture") @ExcludeMissing profilePicture: JsonField<String> = JsonMissing.of(), @JsonProperty("profilePictureOriginal") @ExcludeMissing profilePictureOriginal: JsonField<String> = JsonMissing.of(), @JsonProperty("profileSortEnabled") @ExcludeMissing profileSortEnabled: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("profileTranslatorType") @ExcludeMissing profileTranslatorType: JsonField<String> = JsonMissing.of(), @JsonProperty("protected") @ExcludeMissing protected_: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("redirectsToUsername") @ExcludeMissing redirectsToUsername: JsonField<String> = JsonMissing.of(), @JsonProperty("retweetedAt") @ExcludeMissing retweetedAt: JsonField<OffsetDateTime> = JsonMissing.of(), @JsonProperty("statusesCount") @ExcludeMissing statusesCount: JsonField<Long> = JsonMissing.of(), @JsonProperty("subscribersCount") @ExcludeMissing subscribersCount: JsonField<Long> = JsonMissing.of(), @JsonProperty("superFollowEligible") @ExcludeMissing superFollowEligible: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("superFollowsUserProfileActive") @ExcludeMissing superFollowsUserProfileActive: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("tipJar") @ExcludeMissing tipJar: JsonField<TipJar> = JsonMissing.of(), @JsonProperty("unavailable") @ExcludeMissing unavailable: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("unavailableReason") @ExcludeMissing unavailableReason: JsonField<String> = JsonMissing.of(), @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(), @JsonProperty("usernameChanges") @ExcludeMissing usernameChanges: JsonField<UsernameChanges> = JsonMissing.of(), @JsonProperty("verificationReason") @ExcludeMissing verificationReason: JsonField<VerificationReason> = JsonMissing.of(), @JsonProperty("verified") @ExcludeMissing verified: JsonField<Boolean> = JsonMissing.of(), @JsonProperty("verifiedType") @ExcludeMissing verifiedType: JsonField<String> = JsonMissing.of(), @JsonProperty("withheldInCountries") @ExcludeMissing withheldInCountries: JsonField<List<String>> = JsonMissing.of(), @JsonProperty("withheldScope") @ExcludeMissing withheldScope: JsonField<String> = JsonMissing.of(), ) : this( id, name, username, accountBasedIn, accountBasedInAccurate, accountBasedInUnavailable, advertiserAccountServiceLevels, advertiserAccountType, affiliatesHighlightedLabel, affiliateUsername, automatedBy, birthdate, businessAccountAffiliatesCount, businessProfileState, communityRole, connectedVia, connectedViaAccurate, contactInfo, coverPicture, createdAt, creatorSubscriptionsCount, defaultProfile, defaultProfileImage, description, email, fastFollowersCount, favouritesCount, followers, following, geoEnabled, grokTranslatedBio, hasCustomTimelines, hasExtendedProfile, hasGraduatedAccess, hasHiddenSubscriptionsOnProfile, highlightsInfo, identityVerification, isAutomated, isBlueVerified, isProfileTranslatable, isTranslationEnabled, isTranslator, isVerified, listedCount, location, mediaCount, normalFollowersCount, parodyCommentaryFanLabel, pinnedTweetIds, possiblySensitive, professional, profileBio, profileBannerUrl, profileDescriptionLanguage, profileImageShape, profileInterstitialType, profilePicture, profilePictureOriginal, profileSortEnabled, profileTranslatorType, protected_, redirectsToUsername, retweetedAt, statusesCount, subscribersCount, superFollowEligible, superFollowsUserProfileActive, tipJar, unavailable, unavailableReason, url, usernameChanges, verificationReason, verified, verifiedType, withheldInCountries, withheldScope, mutableMapOf(), ) /** * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is * unexpectedly missing or null. */ fun id(): String = id.getRequired("id") /** * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is * unexpectedly missing or null. */ fun name(): String = name.getRequired("name") /** * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is * unexpectedly missing or null. */ fun username(): String = username.getRequired("username") /** * Null when X shows no label. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun accountBasedIn(): Optional<AccountBasedIn> = accountBasedIn.getOptional("accountBasedIn") /** * False when X notes accountBasedIn may be inaccurate. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun accountBasedInAccurate(): Optional<Boolean> = accountBasedInAccurate.getOptional("accountBasedInAccurate") /** * True when X withheld accountBasedIn from this read. Retry later. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun accountBasedInUnavailable(): Optional<Boolean> = accountBasedInUnavailable.getOptional("accountBasedInUnavailable") /** * X Ads services the account uses, such as `analytics`, `media_studio` or `smb`. Empty for an * account without ads. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun advertiserAccountServiceLevels(): Optional<List<String>> = advertiserAccountServiceLevels.getOptional("advertiserAccountServiceLevels") /** * The account's X Ads type. `none` for an account without ads, or `promotable_user` for one * that may run them. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun advertiserAccountType(): Optional<String> = advertiserAccountType.getOptional("advertiserAccountType") /** * Organization affiliation label shown on an X profile. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun affiliatesHighlightedLabel(): Optional<AffiliatesHighlightedLabel> = affiliatesHighlightedLabel.getOptional("affiliatesHighlightedLabel") /** * Handle of the organization X shows the account is affiliated with, from its About page. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun affiliateUsername(): Optional<String> = affiliateUsername.getOptional("affiliateUsername") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun automatedBy(): Optional<String> = automatedBy.getOptional("automatedBy") /** * The parts of the birthday the account made public. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun birthdate(): Optional<Birthdate> = birthdate.getOptional("birthdate") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun businessAccountAffiliatesCount(): Optional<Long> = businessAccountAffiliatesCount.getOptional("businessAccountAffiliatesCount") /** * Whether X treats the profile as a business profile. `none` or `enabled`. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun businessProfileState(): Optional<String> = businessProfileState.getOptional("businessProfileState") /** * Community role when returned by community member reads * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun communityRole(): Optional<String> = communityRole.getOptional("communityRole") /** * How the account first connected to X. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun connectedVia(): Optional<String> = connectedVia.getOptional("connectedVia") /** * False when X notes that country may be inaccurate. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun connectedViaAccurate(): Optional<Boolean> = connectedViaAccurate.getOptional("connectedViaAccurate") /** * Emails, phone numbers & links the account publishes on its own profile. Omitted when it * publishes none. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun contactInfo(): Optional<ContactInfo> = contactInfo.getOptional("contactInfo") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun coverPicture(): Optional<String> = coverPicture.getOptional("coverPicture") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun createdAt(): Optional<String> = createdAt.getOptional("createdAt") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun creatorSubscriptionsCount(): Optional<Long> = creatorSubscriptionsCount.getOptional("creatorSubscriptionsCount") /** * Whether the profile keeps X's default theme. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun defaultProfile(): Optional<Boolean> = defaultProfile.getOptional("defaultProfile") /** * Whether the profile keeps X's default avatar. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun defaultProfileImage(): Optional<Boolean> = defaultProfileImage.getOptional("defaultProfileImage") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun description(): Optional<String> = description.getOptional("description") /** * First email the account publishes on its profile, lowercased. Omitted when it publishes none. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun email(): Optional<String> = email.getOptional("email") /** * Followers X counts as fast followers. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun fastFollowersCount(): Optional<Long> = fastFollowersCount.getOptional("fastFollowersCount") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun favouritesCount(): Optional<Long> = favouritesCount.getOptional("favouritesCount") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun followers(): Optional<Long> = followers.getOptional("followers") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun following(): Optional<Long> = following.getOptional("following") /** * Whether the profile may add a location to posts. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun geoEnabled(): Optional<Boolean> = geoEnabled.getOptional("geoEnabled") /** * Public profile bio translation returned by X * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun grokTranslatedBio(): Optional<GrokTranslatedBio> = grokTranslatedBio.getOptional("grokTranslatedBio") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun hasCustomTimelines(): Optional<Boolean> = hasCustomTimelines.getOptional("hasCustomTimelines") /** * Whether the profile filled X's extended fields, such as a birth date. True or false. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun hasExtendedProfile(): Optional<Boolean> = hasExtendedProfile.getOptional("hasExtendedProfile") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun hasGraduatedAccess(): Optional<Boolean> = hasGraduatedAccess.getOptional("hasGraduatedAccess") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun hasHiddenSubscriptionsOnProfile(): Optional<Boolean> = hasHiddenSubscriptionsOnProfile.getOptional("hasHiddenSubscriptionsOnProfile") /** * Profile highlight availability and count metadata. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun highlightsInfo(): Optional<HighlightsInfo> = highlightsInfo.getOptional("highlightsInfo") /** * Identity verification metadata displayed by X. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun identityVerification(): Optional<IdentityVerification> = identityVerification.getOptional("identityVerification") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun isAutomated(): Optional<Boolean> = isAutomated.getOptional("isAutomated") /** * Whether X shows a blue verification badge * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun isBlueVerified(): Optional<Boolean> = isBlueVerified.getOptional("isBlueVerified") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun isProfileTranslatable(): Optional<Boolean> = isProfileTranslatable.getOptional("isProfileTranslatable") /** * Whether the account turned on X's translation of its posts. True or false. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun isTranslationEnabled(): Optional<Boolean> = isTranslationEnabled.getOptional("isTranslationEnabled") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun isTranslator(): Optional<Boolean> = isTranslator.getOptional("isTranslator") /** * Whether X marks the profile as verified * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun isVerified(): Optional<Boolean> = isVerified.getOptional("isVerified") /** * Public lists that include the profile. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun listedCount(): Optional<Long> = listedCount.getOptional("listedCount") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun location(): Optional<String> = location.getOptional("location") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun mediaCount(): Optional<Long> = mediaCount.getOptional("mediaCount") /** * Followers minus fast followers. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun normalFollowersCount(): Optional<Long> = normalFollowersCount.getOptional("normalFollowersCount") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun parodyCommentaryFanLabel(): Optional<String> = parodyCommentaryFanLabel.getOptional("parodyCommentaryFanLabel") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun pinnedTweetIds(): Optional<List<String>> = pinnedTweetIds.getOptional("pinnedTweetIds") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun possiblySensitive(): Optional<Boolean> = possiblySensitive.getOptional("possiblySensitive") /** * Professional metadata with category display settings * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun professional(): Optional<Professional> = professional.getOptional("professional") /** * Structured profile bio with entity annotations * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun profileBio(): Optional<ProfileBio> = profileBio.getOptional("profile_bio") /** * Original X profile banner field when available * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun profileBannerUrl(): Optional<String> = profileBannerUrl.getOptional("profileBannerUrl") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun profileDescriptionLanguage(): Optional<String> = profileDescriptionLanguage.getOptional("profileDescriptionLanguage") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun profileImageShape(): Optional<String> = profileImageShape.getOptional("profileImageShape") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun profileInterstitialType(): Optional<String> = profileInterstitialType.getOptional("profileInterstitialType") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun profilePicture(): Optional<String> = profilePicture.getOptional("profilePicture") /** * The same profile picture at full size, as the account uploaded it. Download this one for the * image. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun profilePictureOriginal(): Optional<String> = profilePictureOriginal.getOptional("profilePictureOriginal") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun profileSortEnabled(): Optional<Boolean> = profileSortEnabled.getOptional("profileSortEnabled") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun profileTranslatorType(): Optional<String> = profileTranslatorType.getOptional("profileTranslatorType") /** * Whether the profile protects its posts * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun protected_(): Optional<Boolean> = protected_.getOptional("protected") /** * Handle x.com sends this profile's visitors to, such as the new handle of a renamed account * whose old handle now holds a placeholder. Missing when x.com shows the profile itself. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun redirectsToUsername(): Optional<String> = redirectsToUsername.getOptional("redirectsToUsername") /** * UTC repost time with includeRetweetTimestamp. Null if the newest profile page has no match or * lookup failed. Otherwise omitted. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun retweetedAt(): Optional<OffsetDateTime> = retweetedAt.getOptional("retweetedAt") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun statusesCount(): Optional<Long> = statusesCount.getOptional("statusesCount") /** * Accounts subscribed to the profile's paid Subscriptions. 0 when it has none. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun subscribersCount(): Optional<Long> = subscribersCount.getOptional("subscribersCount") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun superFollowEligible(): Optional<Boolean> = superFollowEligible.getOptional("superFollowEligible") /** * Whether X marks the subscription profile as active. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun superFollowsUserProfileActive(): Optional<Boolean> = superFollowsUserProfileActive.getOptional("superFollowsUserProfileActive") /** * Public payment and creator-support handles shown on X. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun tipJar(): Optional<TipJar> = tipJar.getOptional("tipJar") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun unavailable(): Optional<Boolean> = unavailable.getOptional("unavailable") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun unavailableReason(): Optional<String> = unavailableReason.getOptional("unavailableReason") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun url(): Optional<String> = url.getOptional("url") /** * How often the account changed its username. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun usernameChanges(): Optional<UsernameChanges> = usernameChanges.getOptional("usernameChanges") /** * X's text on why the profile is verified, with its links. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun verificationReason(): Optional<VerificationReason> = verificationReason.getOptional("verificationReason") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun verified(): Optional<Boolean> = verified.getOptional("verified") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun verifiedType(): Optional<String> = verifiedType.getOptional("verifiedType") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun withheldInCountries(): Optional<List<String>> = withheldInCountries.getOptional("withheldInCountries") /** * Whether X withholds a post or user * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun withheldScope(): Optional<String> = withheldScope.getOptional("withheldScope") /** * Returns the raw JSON value of [id]. * * Unlike [id], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id /** * Returns the raw JSON value of [name]. * * Unlike [name], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name /** * Returns the raw JSON value of [username]. * * Unlike [username], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username /** * Returns the raw JSON value of [accountBasedIn]. * * Unlike [accountBasedIn], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("accountBasedIn") @ExcludeMissing fun _accountBasedIn(): JsonField<AccountBasedIn> = accountBasedIn /** * Returns the raw JSON value of [accountBasedInAccurate]. * * Unlike [accountBasedInAccurate], this method doesn't throw if the JSON field has an * unexpected type. */ @JsonProperty("accountBasedInAccurate") @ExcludeMissing fun _accountBasedInAccurate(): JsonField<Boolean> = accountBasedInAccurate /** * Returns the raw JSON value of [accountBasedInUnavailable]. * * Unlike [accountBasedInUnavailable], this method doesn't throw if the JSON field has an * unexpected type. */ @JsonProperty("accountBasedInUnavailable") @ExcludeMissing fun _accountBasedInUnavailable(): JsonField<Boolean> = accountBasedInUnavailable /** * Returns the raw JSON value of [advertiserAccountServiceLevels]. * * Unlike [advertiserAccountServiceLevels], this method doesn't throw if the JSON field has an * unexpected type. */ @JsonProperty("advertiserAccountServiceLevels") @ExcludeMissing fun _advertiserAccountServiceLevels(): JsonField<List<String>> = advertiserAccountServiceLevels /** * Returns the raw JSON value of [advertiserAccountType]. * * Unlike [advertiserAccountType], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("advertiserAccountType") @ExcludeMissing fun _advertiserAccountType(): JsonField<String> = advertiserAccountType /** * Returns the raw JSON value of [affiliatesHighlightedLabel]. * * Unlike [affiliatesHighlightedLabel], this method doesn't throw if the JSON field has an * unexpected type. */ @JsonProperty("affiliatesHighlightedLabel") @ExcludeMissing fun _affiliatesHighlightedLabel(): JsonField<AffiliatesHighlightedLabel> = affiliatesHighlightedLabel /** * Returns the raw JSON value of [affiliateUsername]. * * Unlike [affiliateUsername], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("affiliateUsername") @ExcludeMissing fun _affiliateUsername(): JsonField<String> = affiliateUsername /** * Returns the raw JSON value of [automatedBy]. * * Unlike [automatedBy], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("automatedBy") @ExcludeMissing fun _automatedBy(): JsonField<String> = automatedBy /** * Returns the raw JSON value of [birthdate]. * * Unlike [birthdate], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("birthdate") @ExcludeMissing fun _birthdate(): JsonField<Birthdate> = birthdate /** * Returns the raw JSON value of [businessAccountAffiliatesCount]. * * Unlike [businessAccountAffiliatesCount], this method doesn't throw if the JSON field has an * unexpected type. */ @JsonProperty("businessAccountAffiliatesCount") @ExcludeMissing fun _businessAccountAffiliatesCount(): JsonField<Long> = businessAccountAffiliatesCount /** * Returns the raw JSON value of [businessProfileState]. * * Unlike [businessProfileState], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("businessProfileState") @ExcludeMissing fun _businessProfileState(): JsonField<String> = businessProfileState /** * Returns the raw JSON value of [communityRole]. * * Unlike [communityRole], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("communityRole") @ExcludeMissing fun _communityRole(): JsonField<String> = communityRole /** * Returns the raw JSON value of [connectedVia]. * * Unlike [connectedVia], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("connectedVia") @ExcludeMissing fun _connectedVia(): JsonField<String> = connectedVia /** * Returns the raw JSON value of [connectedViaAccurate]. * * Unlike [connectedViaAccurate], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("connectedViaAccurate") @ExcludeMissing fun _connectedViaAccurate(): JsonField<Boolean> = connectedViaAccurate /** * Returns the raw JSON value of [contactInfo]. * * Unlike [contactInfo], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("contactInfo") @ExcludeMissing fun _contactInfo(): JsonField<ContactInfo> = contactInfo /** * Returns the raw JSON value of [coverPicture]. * * Unlike [coverPicture], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("coverPicture") @ExcludeMissing fun _coverPicture(): JsonField<String> = coverPicture /** * Returns the raw JSON value of [createdAt]. * * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("createdAt") @ExcludeMissing fun _createdAt(): JsonField<String> = createdAt /** * Returns the raw JSON value of [creatorSubscriptionsCount]. * * Unlike [creatorSubscriptionsCount], this method doesn't throw if the JSON field has an * unexpected type. */ @JsonProperty("creatorSubscriptionsCount") @ExcludeMissing fun _creatorSubscriptionsCount(): JsonField<Long> = creatorSubscriptionsCount /** * Returns the raw JSON value of [defaultProfile]. * * Unlike [defaultProfile], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("defaultProfile") @ExcludeMissing fun _defaultProfile(): JsonField<Boolean> = defaultProfile /** * Returns the raw JSON value of [defaultProfileImage]. * * Unlike [defaultProfileImage], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("defaultProfileImage") @ExcludeMissing fun _defaultProfileImage(): JsonField<Boolean> = defaultProfileImage /** * Returns the raw JSON value of [description]. * * Unlike [description], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description /** * Returns the raw JSON value of [email]. * * Unlike [email], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email /** * Returns the raw JSON value of [fastFollowersCount]. * * Unlike [fastFollowersCount], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("fastFollowersCount") @ExcludeMissing fun _fastFollowersCount(): JsonField<Long> = fastFollowersCount /** * Returns the raw JSON value of [favouritesCount]. * * Unlike [favouritesCount], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("favouritesCount") @ExcludeMissing fun _favouritesCount(): JsonField<Long> = favouritesCount /** * Returns the raw JSON value of [followers]. * * Unlike [followers], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("followers") @ExcludeMissing fun _followers(): JsonField<Long> = followers /** * Returns the raw JSON value of [following]. * * Unlike [following], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("following") @ExcludeMissing fun _following(): JsonField<Long> = following /** * Returns the raw JSON value of [geoEnabled]. * * Unlike [geoEnabled], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("geoEnabled") @ExcludeMissing fun _geoEnabled(): JsonField<Boolean> = geoEnabled /** * Returns the raw JSON value of [grokTranslatedBio]. * * Unlike [grokTranslatedBio], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("grokTranslatedBio") @ExcludeMissing fun _grokTranslatedBio(): JsonField<GrokTranslatedBio> = grokTranslatedBio /** * Returns the raw JSON value of [hasCustomTimelines]. * * Unlike [hasCustomTimelines], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("hasCustomTimelines") @ExcludeMissing fun _hasCustomTimelines(): JsonField<Boolean> = hasCustomTimelines /** * Returns the raw JSON value of [hasExtendedProfile]. * * Unlike [hasExtendedProfile], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("hasExtendedProfile") @ExcludeMissing fun _hasExtendedProfile(): JsonField<Boolean> = hasExtendedProfile /** * Returns the raw JSON value of [hasGraduatedAccess]. * * Unlike [hasGraduatedAccess], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("hasGraduatedAccess") @ExcludeMissing fun _hasGraduatedAccess(): JsonField<Boolean> = hasGraduatedAccess /** * Returns the raw JSON value of [hasHiddenSubscriptionsOnProfile]. * * Unlike [hasHiddenSubscriptionsOnProfile], this method doesn't throw if the JSON field has an * unexpected type. */ @JsonProperty("hasHiddenSubscriptionsOnProfile") @ExcludeMissing fun _hasHiddenSubscriptionsOnProfile(): JsonField<Boolean> = hasHiddenSubscriptionsOnProfile /** * Returns the raw JSON value of [highlightsInfo]. * * Unlike [highlightsInfo], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("highlightsInfo") @ExcludeMissing fun _highlightsInfo(): JsonField<HighlightsInfo> = highlightsInfo /** * Returns the raw JSON value of [identityVerification]. * * Unlike [identityVerification], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("identityVerification") @ExcludeMissing fun _identityVerification(): JsonField<IdentityVerification> = identityVerification /** * Returns the raw JSON value of [isAutomated]. * * Unlike [isAutomated], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("isAutomated") @ExcludeMissing fun _isAutomated(): JsonField<Boolean> = isAutomated /** * Returns the raw JSON value of [isBlueVerified]. * * Unlike [isBlueVerified], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("isBlueVerified") @ExcludeMissing fun _isBlueVerified(): JsonField<Boolean> = isBlueVerified /** * Returns the raw JSON value of [isProfileTranslatable]. * * Unlike [isProfileTranslatable], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("isProfileTranslatable") @ExcludeMissing fun _isProfileTranslatable(): JsonField<Boolean> = isProfileTranslatable /** * Returns the raw JSON value of [isTranslationEnabled]. * * Unlike [isTranslationEnabled], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("isTranslationEnabled") @ExcludeMissing fun _isTranslationEnabled(): JsonField<Boolean> = isTranslationEnabled /** * Returns the raw JSON value of [isTranslator]. * * Unlike [isTranslator], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("isTranslator") @ExcludeMissing fun _isTranslator(): JsonField<Boolean> = isTranslator /** * Returns the raw JSON value of [isVerified]. * * Unlike [isVerified], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("isVerified") @ExcludeMissing fun _isVerified(): JsonField<Boolean> = isVerified /** * Returns the raw JSON value of [listedCount]. * * Unlike [listedCount], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("listedCount") @ExcludeMissing fun _listedCount(): JsonField<Long> = listedCount /** * Returns the raw JSON value of [location]. * * Unlike [location], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("location") @ExcludeMissing fun _location(): JsonField<String> = location /** * Returns the raw JSON value of [mediaCount]. * * Unlike [mediaCount], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("mediaCount") @ExcludeMissing fun _mediaCount(): JsonField<Long> = mediaCount /** * Returns the raw JSON value of [normalFollowersCount]. * * Unlike [normalFollowersCount], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("normalFollowersCount") @ExcludeMissing fun _normalFollowersCount(): JsonField<Long> = normalFollowersCount /** * Returns the raw JSON value of [parodyCommentaryFanLabel]. * * Unlike [parodyCommentaryFanLabel], this method doesn't throw if the JSON field has an * unexpected type. */ @JsonProperty("parodyCommentaryFanLabel") @ExcludeMissing fun _parodyCommentaryFanLabel(): JsonField<String> = parodyCommentaryFanLabel /** * Returns the raw JSON value of [pinnedTweetIds]. * * Unlike [pinnedTweetIds], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("pinnedTweetIds") @ExcludeMissing fun _pinnedTweetIds(): JsonField<List<String>> = pinnedTweetIds /** * Returns the raw JSON value of [possiblySensitive]. * * Unlike [possiblySensitive], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("possiblySensitive") @ExcludeMissing fun _possiblySensitive(): JsonField<Boolean> = possiblySensitive /** * Returns the raw JSON value of [professional]. * * Unlike [professional], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("professional") @ExcludeMissing fun _professional(): JsonField<Professional> = professional /** * Returns the raw JSON value of [profileBio]. * * Unlike [profileBio], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("profile_bio") @ExcludeMissing fun _profileBio(): JsonField<ProfileBio> = profileBio /** * Returns the raw JSON value of [profileBannerUrl]. * * Unlike [profileBannerUrl], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("profileBannerUrl") @ExcludeMissing fun _profileBannerUrl(): JsonField<String> = profileBannerUrl /** * Returns the raw JSON value of [profileDescriptionLanguage]. * * Unlike [profileDescriptionLanguage], this method doesn't throw if the JSON field has an * unexpected type. */ @JsonProperty("profileDescriptionLanguage") @ExcludeMissing fun _profileDescriptionLanguage(): JsonField<String> = profileDescriptionLanguage /** * Returns the raw JSON value of [profileImageShape]. * * Unlike [profileImageShape], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("profileImageShape") @ExcludeMissing fun _profileImageShape(): JsonField<String> = profileImageShape /** * Returns the raw JSON value of [profileInterstitialType]. * * Unlike [profileInterstitialType], this method doesn't throw if the JSON field has an * unexpected type. */ @JsonProperty("profileInterstitialType") @ExcludeMissing fun _profileInterstitialType(): JsonField<String> = profileInterstitialType /** * Returns the raw JSON value of [profilePicture]. * * Unlike [profilePicture], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("profilePicture") @ExcludeMissing fun _profilePicture(): JsonField<String> = profilePicture /** * Returns the raw JSON value of [profilePictureOriginal]. * * Unlike [profilePictureOriginal], this method doesn't throw if the JSON field has an * unexpected type. */ @JsonProperty("profilePictureOriginal") @ExcludeMissing fun _profilePictureOriginal(): JsonField<String> = profilePictureOriginal /** * Returns the raw JSON value of [profileSortEnabled]. * * Unlike [profileSortEnabled], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("profileSortEnabled") @ExcludeMissing fun _profileSortEnabled(): JsonField<Boolean> = profileSortEnabled /** * Returns the raw JSON value of [profileTranslatorType]. * * Unlike [profileTranslatorType], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("profileTranslatorType") @ExcludeMissing fun _profileTranslatorType(): JsonField<String> = profileTranslatorType /** * Returns the raw JSON value of [protected_]. * * Unlike [protected_], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("protected") @ExcludeMissing fun _protected_(): JsonField<Boolean> = protected_ /** * Returns the raw JSON value of [redirectsToUsername]. * * Unlike [redirectsToUsername], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("redirectsToUsername") @ExcludeMissing fun _redirectsToUsername(): JsonField<String> = redirectsToUsername /** * Returns the raw JSON value of [retweetedAt]. * * Unlike [retweetedAt], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("retweetedAt") @ExcludeMissing fun _retweetedAt(): JsonField<OffsetDateTime> = retweetedAt /** * Returns the raw JSON value of [statusesCount]. * * Unlike [statusesCount], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("statusesCount") @ExcludeMissing fun _statusesCount(): JsonField<Long> = statusesCount /** * Returns the raw JSON value of [subscribersCount]. * * Unlike [subscribersCount], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("subscribersCount") @ExcludeMissing fun _subscribersCount(): JsonField<Long> = subscribersCount /** * Returns the raw JSON value of [superFollowEligible]. * * Unlike [superFollowEligible], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("superFollowEligible") @ExcludeMissing fun _superFollowEligible(): JsonField<Boolean> = superFollowEligible /** * Returns the raw JSON value of [superFollowsUserProfileActive]. * * Unlike [superFollowsUserProfileActive], this method doesn't throw if the JSON field has an * unexpected type. */ @JsonProperty("superFollowsUserProfileActive") @ExcludeMissing fun _superFollowsUserProfileActive(): JsonField<Boolean> = superFollowsUserProfileActive /** * Returns the raw JSON value of [tipJar]. * * Unlike [tipJar], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("tipJar") @ExcludeMissing fun _tipJar(): JsonField<TipJar> = tipJar /** * Returns the raw JSON value of [unavailable]. * * Unlike [unavailable], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("unavailable") @ExcludeMissing fun _unavailable(): JsonField<Boolean> = unavailable /** * Returns the raw JSON value of [unavailableReason]. * * Unlike [unavailableReason], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("unavailableReason") @ExcludeMissing fun _unavailableReason(): JsonField<String> = unavailableReason /** * Returns the raw JSON value of [url]. * * Unlike [url], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url /** * Returns the raw JSON value of [usernameChanges]. * * Unlike [usernameChanges], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("usernameChanges") @ExcludeMissing fun _usernameChanges(): JsonField<UsernameChanges> = usernameChanges /** * Returns the raw JSON value of [verificationReason]. * * Unlike [verificationReason], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("verificationReason") @ExcludeMissing fun _verificationReason(): JsonField<VerificationReason> = verificationReason /** * Returns the raw JSON value of [verified]. * * Unlike [verified], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("verified") @ExcludeMissing fun _verified(): JsonField<Boolean> = verified /** * Returns the raw JSON value of [verifiedType]. * * Unlike [verifiedType], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("verifiedType") @ExcludeMissing fun _verifiedType(): JsonField<String> = verifiedType /** * Returns the raw JSON value of [withheldInCountries]. * * Unlike [withheldInCountries], this method doesn't throw if the JSON field has an unexpected * type. */ @JsonProperty("withheldInCountries") @ExcludeMissing fun _withheldInCountries(): JsonField<List<String>> = withheldInCountries /** * Returns the raw JSON value of [withheldScope]. * * Unlike [withheldScope], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("withheldScope") @ExcludeMissing fun _withheldScope(): JsonField<String> = withheldScope @JsonAnySetter private fun putAdditionalProperty(key: String, value: JsonValue) { additionalProperties.put(key, value) } @JsonAnyGetter @ExcludeMissing fun _additionalProperties(): Map<String, JsonValue> = Collections.unmodifiableMap(additionalProperties) fun toBuilder() = Builder().from(this) companion object { /** * Returns a mutable builder for constructing an instance of [UserProfile]. * * The following fields are required: * ```java * .id() * .name() * .username() * ``` */ @JvmStatic fun builder() = Builder() } /** A builder for [UserProfile]. */ class Builder internal constructor() { private var id: JsonField<String>? = null private var name: JsonField<String>? = null private var username: JsonField<String>? = null private var accountBasedIn: JsonField<AccountBasedIn> = JsonMissing.of() private var accountBasedInAccurate: JsonField<Boolean> = JsonMissing.of() private var accountBasedInUnavailable: JsonField<Boolean> = JsonMissing.of() private var advertiserAccountServiceLevels: JsonField<MutableList<String>>? = null private var advertiserAccountType: JsonField<String> = JsonMissing.of() private var affiliatesHighlightedLabel: JsonField<AffiliatesHighlightedLabel> = JsonMissing.of() private var affiliateUsername: JsonField<String> = JsonMissing.of() private var automatedBy: JsonField<String> = JsonMissing.of() private var birthdate: JsonField<Birthdate> = JsonMissing.of() private var businessAccountAffiliatesCount: JsonField<Long> = JsonMissing.of() private var businessProfileState: JsonField<String> = JsonMissing.of() private var communityRole: JsonField<String> = JsonMissing.of() private var connectedVia: JsonField<String> = JsonMissing.of() private var connectedViaAccurate: JsonField<Boolean> = JsonMissing.of() private var contactInfo: JsonField<ContactInfo> = JsonMissing.of() private var coverPicture: JsonField<String> = JsonMissing.of() private var createdAt: JsonField<String> = JsonMissing.of() private var creatorSubscriptionsCount: JsonField<Long> = JsonMissing.of() private var defaultProfile: JsonField<Boolean> = JsonMissing.of() private var defaultProfileImage: JsonField<Boolean> = JsonMissing.of() private var description: JsonField<String> = JsonMissing.of() private var email: JsonField<String> = JsonMissing.of() private var fastFollowersCount: JsonField<Long> = JsonMissing.of() private var favouritesCount: JsonField<Long> = JsonMissing.of() private var followers: JsonField<Long> = JsonMissing.of() private var following: JsonField<Long> = JsonMissing.of() private var geoEnabled: JsonField<Boolean> = JsonMissing.of() private var grokTranslatedBio: JsonField<GrokTranslatedBio> = JsonMissing.of() private var hasCustomTimelines: JsonField<Boolean> = JsonMissing.of() private var hasExtendedProfile: JsonField<Boolean> = JsonMissing.of() private var hasGraduatedAccess: JsonField<Boolean> = JsonMissing.of() private var hasHiddenSubscriptionsOnProfile: JsonField<Boolean> = JsonMissing.of() private var highlightsInfo: JsonField<HighlightsInfo> = JsonMissing.of() private var identityVerification: JsonField<IdentityVerification> = JsonMissing.of() private var isAutomated: JsonField<Boolean> = JsonMissing.of() private var isBlueVerified: JsonField<Boolean> = JsonMissing.of() private var isProfileTranslatable: JsonField<Boolean> = JsonMissing.of() private var isTranslationEnabled: JsonField<Boolean> = JsonMissing.of() private var isTranslator: JsonField<Boolean> = JsonMissing.of() private var isVerified: JsonField<Boolean> = JsonMissing.of() private var listedCount: JsonField<Long> = JsonMissing.of() private var location: JsonField<String> = JsonMissing.of() private var mediaCount: JsonField<Long> = JsonMissing.of() private var normalFollowersCount: JsonField<Long> = JsonMissing.of() private var parodyCommentaryFanLabel: JsonField<String> = JsonMissing.of() private var pinnedTweetIds: JsonField<MutableList<String>>? = null private var possiblySensitive: JsonField<Boolean> = JsonMissing.of() private var professional: JsonField<Professional> = JsonMissing.of() private var profileBio: JsonField<ProfileBio> = JsonMissing.of() private var profileBannerUrl: JsonField<String> = JsonMissing.of() private var profileDescriptionLanguage: JsonField<String> = JsonMissing.of() private var profileImageShape: JsonField<String> = JsonMissing.of() private var profileInterstitialType: JsonField<String> = JsonMissing.of() private var profilePicture: JsonField<String> = JsonMissing.of() private var profilePictureOriginal: JsonField<String> = JsonMissing.of() private var profileSortEnabled: JsonField<Boolean> = JsonMissing.of() private var profileTranslatorType: JsonField<String> = JsonMissing.of() private var protected_: JsonField<Boolean> = JsonMissing.of() private var redirectsToUsername: JsonField<String> = JsonMissing.of() private var retweetedAt: JsonField<OffsetDateTime> = JsonMissing.of() private var statusesCount: JsonField<Long> = JsonMissing.of() private var subscribersCount: JsonField<Long> = JsonMissing.of() private var superFollowEligible: JsonField<Boolean> = JsonMissing.of() private var superFollowsUserProfileActive: JsonField<Boolean> = JsonMissing.of() private var tipJar: JsonField<TipJar> = JsonMissing.of() private var unavailable: JsonField<Boolean> = JsonMissing.of() private var unavailableReason: JsonField<String> = JsonMissing.of() private var url: JsonField<String> = JsonMissing.of() private var usernameChanges: JsonField<UsernameChanges> = JsonMissing.of() private var verificationReason: JsonField<VerificationReason> = JsonMissing.of() private var verified: JsonField<Boolean> = JsonMissing.of() private var verifiedType: JsonField<String> = JsonMissing.of() private var withheldInCountries: JsonField<MutableList<String>>? = null private var withheldScope: JsonField<String> = JsonMissing.of() private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf() @JvmSynthetic internal fun from(userProfile: UserProfile) = apply { id = userProfile.id name = userProfile.name username = userProfile.username accountBasedIn = userProfile.accountBasedIn accountBasedInAccurate = userProfile.accountBasedInAccurate accountBasedInUnavailable = userProfile.accountBasedInUnavailable advertiserAccountServiceLevels = userProfile.advertiserAccountServiceLevels.map { it.toMutableList() } advertiserAccountType = userProfile.advertiserAccountType affiliatesHighlightedLabel = userProfile.affiliatesHighlightedLabel affiliateUsername = userProfile.affiliateUsername automatedBy = userProfile.automatedBy birthdate = userProfile.birthdate businessAccountAffiliatesCount = userProfile.businessAccountAffiliatesCount businessProfileState = userProfile.businessProfileState communityRole = userProfile.communityRole connectedVia = userProfile.connectedVia connectedViaAccurate = userProfile.connectedViaAccurate contactInfo = userProfile.contactInfo coverPicture = userProfile.coverPicture createdAt = userProfile.createdAt creatorSubscriptionsCount = userProfile.creatorSubscriptionsCount defaultProfile = userProfile.defaultProfile defaultProfileImage = userProfile.defaultProfileImage description = userProfile.description email = userProfile.email fastFollowersCount = userProfile.fastFollowersCount favouritesCount = userProfile.favouritesCount followers = userProfile.followers following = userProfile.following geoEnabled = userProfile.geoEnabled grokTranslatedBio = userProfile.grokTranslatedBio hasCustomTimelines = userProfile.hasCustomTimelines hasExtendedProfile = userProfile.hasExtendedProfile hasGraduatedAccess = userProfile.hasGraduatedAccess hasHiddenSubscriptionsOnProfile = userProfile.hasHiddenSubscriptionsOnProfile highlightsInfo = userProfile.highlightsInfo identityVerification = userProfile.identityVerification isAutomated = userProfile.isAutomated isBlueVerified = userProfile.isBlueVerified isProfileTranslatable = userProfile.isProfileTranslatable isTranslationEnabled = userProfile.isTranslationEnabled isTranslator = userProfile.isTranslator isVerified = userProfile.isVerified listedCount = userProfile.listedCount location = userProfile.location mediaCount = userProfile.mediaCount normalFollowersCount = userProfile.normalFollowersCount parodyCommentaryFanLabel = userProfile.parodyCommentaryFanLabel pinnedTweetIds = userProfile.pinnedTweetIds.map { it.toMutableList() } possiblySensitive = userProfile.possiblySensitive professional = userProfile.professional profileBio = userProfile.profileBio profileBannerUrl = userProfile.profileBannerUrl profileDescriptionLanguage = userProfile.profileDescriptionLanguage profileImageShape = userProfile.profileImageShape profileInterstitialType = userProfile.profileInterstitialType profilePicture = userProfile.profilePicture profilePictureOriginal = userProfile.profilePictureOriginal profileSortEnabled = userProfile.profileSortEnabled profileTranslatorType = userProfile.profileTranslatorType protected_ = userProfile.protected_ redirectsToUsername = userProfile.redirectsToUsername retweetedAt = userProfile.retweetedAt statusesCount = userProfile.statusesCount subscribersCount = userProfile.subscribersCount superFollowEligible = userProfile.superFollowEligible superFollowsUserProfileActive = userProfile.superFollowsUserProfileActive tipJar = userProfile.tipJar unavailable = userProfile.unavailable unavailableReason = userProfile.unavailableReason url = userProfile.url usernameChanges = userProfile.usernameChanges verificationReason = userProfile.verificationReason verified = userProfile.verified verifiedType = userProfile.verifiedType withheldInCountries = userProfile.withheldInCountries.map { it.toMutableList() } withheldScope = userProfile.withheldScope additionalProperties = userProfile.additionalProperties.toMutableMap() } fun id(id: String) = id(JsonField.of(id)) /** Sets [Builder.id] to an arbitrary JSON value. */ fun id(id: JsonField<String>) = apply { this.id = id } fun name(name: String) = name(JsonField.of(name)) /** Sets [Builder.name] to an arbitrary JSON value. */ fun name(name: JsonField<String>) = apply { this.name = name } fun username(username: String) = username(JsonField.of(username)) /** Sets [Builder.username] to an arbitrary JSON value. */ fun username(username: JsonField<String>) = apply { this.username = username } /** Null when X shows no label. */ fun accountBasedIn(accountBasedIn: AccountBasedIn?) = accountBasedIn(JsonField.ofNullable(accountBasedIn)) /** Alias for calling [Builder.accountBasedIn] with `accountBasedIn.orElse(null)`. */ fun accountBasedIn(accountBasedIn: Optional<AccountBasedIn>) = accountBasedIn(accountBasedIn.getOrNull()) /** Sets [Builder.accountBasedIn] to an arbitrary JSON value. */ fun accountBasedIn(accountBasedIn: JsonField<AccountBasedIn>) = apply { this.accountBasedIn = accountBasedIn } /** False when X notes accountBasedIn may be inaccurate. */ fun accountBasedInAccurate(accountBasedInAccurate: Boolean) = accountBasedInAccurate(JsonField.of(accountBasedInAccurate)) /** Sets [Builder.accountBasedInAccurate] to an arbitrary JSON value. */ fun accountBasedInAccurate(accountBasedInAccurate: JsonField<Boolean>) = apply { this.accountBasedInAccurate = accountBasedInAccurate } /** True when X withheld accountBasedIn from this read. Retry later. */ fun accountBasedInUnavailable(accountBasedInUnavailable: Boolean) = accountBasedInUnavailable(JsonField.of(accountBasedInUnavailable)) /** Sets [Builder.accountBasedInUnavailable] to an arbitrary JSON value. */ fun accountBasedInUnavailable(accountBasedInUnavailable: JsonField<Boolean>) = apply { this.accountBasedInUnavailable = accountBasedInUnavailable } /** * X Ads services the account uses, such as `analytics`, `media_studio` or `smb`. Empty for * an account without ads. */ fun advertiserAccountServiceLevels(advertiserAccountServiceLevels: List<String>) = advertiserAccountServiceLevels(JsonField.of(advertiserAccountServiceLevels)) /** Sets [Builder.advertiserAccountServiceLevels] to an arbitrary JSON value. */ fun advertiserAccountServiceLevels( advertiserAccountServiceLevels: JsonField<List<String>> ) = apply { this.advertiserAccountServiceLevels = advertiserAccountServiceLevels.map { it.toMutableList() } } /** * Adds a single [String] to [advertiserAccountServiceLevels]. * * @throws IllegalStateException if the field was previously set to a non-list. */ fun addAdvertiserAccountServiceLevel(advertiserAccountServiceLevel: String) = apply { advertiserAccountServiceLevels = (advertiserAccountServiceLevels ?: JsonField.of(mutableListOf())).also { checkKnown("advertiserAccountServiceLevels", it) .add(advertiserAccountServiceLevel) } } /** * The account's X Ads type. `none` for an account without ads, or `promotable_user` for one * that may run them. */ fun advertiserAccountType(advertiserAccountType: String) = advertiserAccountType(JsonField.of(advertiserAccountType)) /** Sets [Builder.advertiserAccountType] to an arbitrary JSON value. */ fun advertiserAccountType(advertiserAccountType: JsonField<String>) = apply { this.advertiserAccountType = advertiserAccountType } /** Organization affiliation label shown on an X profile. */ fun affiliatesHighlightedLabel(affiliatesHighlightedLabel: AffiliatesHighlightedLabel) = affiliatesHighlightedLabel(JsonField.of(affiliatesHighlightedLabel)) /** Sets [Builder.affiliatesHighlightedLabel] to an arbitrary JSON value. */ fun affiliatesHighlightedLabel( affiliatesHighlightedLabel: JsonField<AffiliatesHighlightedLabel> ) = apply { this.affiliatesHighlightedLabel = affiliatesHighlightedLabel } /** * Handle of the organization X shows the account is affiliated with, from its About page. */ fun affiliateUsername(affiliateUsername: String) = affiliateUsername(JsonField.of(affiliateUsername)) /** Sets [Builder.affiliateUsername] to an arbitrary JSON value. */ fun affiliateUsername(affiliateUsername: JsonField<String>) = apply { this.affiliateUsername = affiliateUsername } fun automatedBy(automatedBy: String) = automatedBy(JsonField.of(automatedBy)) /** Sets [Builder.automatedBy] to an arbitrary JSON value. */ fun automatedBy(automatedBy: JsonField<String>) = apply { this.automatedBy = automatedBy } /** The parts of the birthday the account made public. */ fun birthdate(birthdate: Birthdate) = birthdate(JsonField.of(birthdate)) /** Sets [Builder.birthdate] to an arbitrary JSON value. */ fun birthdate(birthdate: JsonField<Birthdate>) = apply { this.birthdate = birthdate } fun businessAccountAffiliatesCount(businessAccountAffiliatesCount: Long) = businessAccountAffiliatesCount(JsonField.of(businessAccountAffiliatesCount)) /** Sets [Builder.businessAccountAffiliatesCount] to an arbitrary JSON value. */ fun businessAccountAffiliatesCount(businessAccountAffiliatesCount: JsonField<Long>) = apply { this.businessAccountAffiliatesCount = businessAccountAffiliatesCount } /** Whether X treats the profile as a business profile. `none` or `enabled`. */ fun businessProfileState(businessProfileState: String) = businessProfileState(JsonField.of(businessProfileState)) /** Sets [Builder.businessProfileState] to an arbitrary JSON value. */ fun businessProfileState(businessProfileState: JsonField<String>) = apply { this.businessProfileState = businessProfileState } /** Community role when returned by community member reads */ fun communityRole(communityRole: String) = communityRole(JsonField.of(communityRole)) /** Sets [Builder.communityRole] to an arbitrary JSON value. */ fun communityRole(communityRole: JsonField<String>) = apply { this.communityRole = communityRole } /** How the account first connected to X. */ fun connectedVia(connectedVia: String) = connectedVia(JsonField.of(connectedVia)) /** Sets [Builder.connectedVia] to an arbitrary JSON value. */ fun connectedVia(connectedVia: JsonField<String>) = apply { this.connectedVia = connectedVia } /** False when X notes that country may be inaccurate. */ fun connectedViaAccurate(connectedViaAccurate: Boolean) = connectedViaAccurate(JsonField.of(connectedViaAccurate)) /** Sets [Builder.connectedViaAccurate] to an arbitrary JSON value. */ fun connectedViaAccurate(connectedViaAccurate: JsonField<Boolean>) = apply { this.connectedViaAccurate = connectedViaAccurate } /** * Emails, phone numbers & links the account publishes on its own profile. Omitted when it * publishes none. */ fun contactInfo(contactInfo: ContactInfo) = contactInfo(JsonField.of(contactInfo)) /** Sets [Builder.contactInfo] to an arbitrary JSON value. */ fun contactInfo(contactInfo: JsonField<ContactInfo>) = apply { this.contactInfo = contactInfo } fun coverPicture(coverPicture: String) = coverPicture(JsonField.of(coverPicture)) /** Sets [Builder.coverPicture] to an arbitrary JSON value. */ fun coverPicture(coverPicture: JsonField<String>) = apply { this.coverPicture = coverPicture } fun createdAt(createdAt: String) = createdAt(JsonField.of(createdAt)) /** Sets [Builder.createdAt] to an arbitrary JSON value. */ fun createdAt(createdAt: JsonField<String>) = apply { this.createdAt = createdAt } fun creatorSubscriptionsCount(creatorSubscriptionsCount: Long) = creatorSubscriptionsCount(JsonField.of(creatorSubscriptionsCount)) /** Sets [Builder.creatorSubscriptionsCount] to an arbitrary JSON value. */ fun creatorSubscriptionsCount(creatorSubscriptionsCount: JsonField<Long>) = apply { this.creatorSubscriptionsCount = creatorSubscriptionsCount } /** Whether the profile keeps X's default theme. */ fun defaultProfile(defaultProfile: Boolean) = defaultProfile(JsonField.of(defaultProfile)) /** Sets [Builder.defaultProfile] to an arbitrary JSON value. */ fun defaultProfile(defaultProfile: JsonField<Boolean>) = apply { this.defaultProfile = defaultProfile } /** Whether the profile keeps X's default avatar. */ fun defaultProfileImage(defaultProfileImage: Boolean) = defaultProfileImage(JsonField.of(defaultProfileImage)) /** Sets [Builder.defaultProfileImage] to an arbitrary JSON value. */ fun defaultProfileImage(defaultProfileImage: JsonField<Boolean>) = apply { this.defaultProfileImage = defaultProfileImage } fun description(description: String) = description(JsonField.of(description)) /** Sets [Builder.description] to an arbitrary JSON value. */ fun description(description: JsonField<String>) = apply { this.description = description } /** * First email the account publishes on its profile, lowercased. Omitted when it publishes * none. */ fun email(email: String) = email(JsonField.of(email)) /** Sets [Builder.email] to an arbitrary JSON value. */ fun email(email: JsonField<String>) = apply { this.email = email } /** Followers X counts as fast followers. */ fun fastFollowersCount(fastFollowersCount: Long) = fastFollowersCount(JsonField.of(fastFollowersCount)) /** Sets [Builder.fastFollowersCount] to an arbitrary JSON value. */ fun fastFollowersCount(fastFollowersCount: JsonField<Long>) = apply { this.fastFollowersCount = fastFollowersCount } fun favouritesCount(favouritesCount: Long) = favouritesCount(JsonField.of(favouritesCount)) /** Sets [Builder.favouritesCount] to an arbitrary JSON value. */ fun favouritesCount(favouritesCount: JsonField<Long>) = apply { this.favouritesCount = favouritesCount } fun followers(followers: Long) = followers(JsonField.of(followers)) /** Sets [Builder.followers] to an arbitrary JSON value. */ fun followers(followers: JsonField<Long>) = apply { this.followers = followers } fun following(following: Long) = following(JsonField.of(following)) /** Sets [Builder.following] to an arbitrary JSON value. */ fun following(following: JsonField<Long>) = apply { this.following = following } /** Whether the profile may add a location to posts. */ fun geoEnabled(geoEnabled: Boolean) = geoEnabled(JsonField.of(geoEnabled)) /** Sets [Builder.geoEnabled] to an arbitrary JSON value. */ fun geoEnabled(geoEnabled: JsonField<Boolean>) = apply { this.geoEnabled = geoEnabled } /** Public profile bio translation returned by X */ fun grokTranslatedBio(grokTranslatedBio: GrokTranslatedBio) = grokTranslatedBio(JsonField.of(grokTranslatedBio)) /** Sets [Builder.grokTranslatedBio] to an arbitrary JSON value. */ fun grokTranslatedBio(grokTranslatedBio: JsonField<GrokTranslatedBio>) = apply { this.grokTranslatedBio = grokTranslatedBio } fun hasCustomTimelines(hasCustomTimelines: Boolean) = hasCustomTimelines(JsonField.of(hasCustomTimelines)) /** Sets [Builder.hasCustomTimelines] to an arbitrary JSON value. */ fun hasCustomTimelines(hasCustomTimelines: JsonField<Boolean>) = apply { this.hasCustomTimelines = hasCustomTimelines } /** Whether the profile filled X's extended fields, such as a birth date. True or false. */ fun hasExtendedProfile(hasExtendedProfile: Boolean) = hasExtendedProfile(JsonField.of(hasExtendedProfile)) /** Sets [Builder.hasExtendedProfile] to an arbitrary JSON value. */ fun hasExtendedProfile(hasExtendedProfile: JsonField<Boolean>) = apply { this.hasExtendedProfile = hasExtendedProfile } fun hasGraduatedAccess(hasGraduatedAccess: Boolean) = hasGraduatedAccess(JsonField.of(hasGraduatedAccess)) /** Sets [Builder.hasGraduatedAccess] to an arbitrary JSON value. */ fun hasGraduatedAccess(hasGraduatedAccess: JsonField<Boolean>) = apply { this.hasGraduatedAccess = hasGraduatedAccess } fun hasHiddenSubscriptionsOnProfile(hasHiddenSubscriptionsOnProfile: Boolean) = hasHiddenSubscriptionsOnProfile(JsonField.of(hasHiddenSubscriptionsOnProfile)) /** Sets [Builder.hasHiddenSubscriptionsOnProfile] to an arbitrary JSON value. */ fun hasHiddenSubscriptionsOnProfile(hasHiddenSubscriptionsOnProfile: JsonField<Boolean>) = apply { this.hasHiddenSubscriptionsOnProfile = hasHiddenSubscriptionsOnProfile } /** Profile highlight availability and count metadata. */ fun highlightsInfo(highlightsInfo: HighlightsInfo) = highlightsInfo(JsonField.of(highlightsInfo)) /** Sets [Builder.highlightsInfo] to an arbitrary JSON value. */ fun highlightsInfo(highlightsInfo: JsonField<HighlightsInfo>) = apply { this.highlightsInfo = highlightsInfo } /** Identity verification metadata displayed by X. */ fun identityVerification(identityVerification: IdentityVerification) = identityVerification(JsonField.of(identityVerification)) /** Sets [Builder.identityVerification] to an arbitrary JSON value. */ fun identityVerification(identityVerification: JsonField<IdentityVerification>) = apply { this.identityVerification = identityVerification } fun isAutomated(isAutomated: Boolean) = isAutomated(JsonField.of(isAutomated)) /** Sets [Builder.isAutomated] to an arbitrary JSON value. */ fun isAutomated(isAutomated: JsonField<Boolean>) = apply { this.isAutomated = isAutomated } /** Whether X shows a blue verification badge */ fun isBlueVerified(isBlueVerified: Boolean) = isBlueVerified(JsonField.of(isBlueVerified)) /** Sets [Builder.isBlueVerified] to an arbitrary JSON value. */ fun isBlueVerified(isBlueVerified: JsonField<Boolean>) = apply { this.isBlueVerified = isBlueVerified } fun isProfileTranslatable(isProfileTranslatable: Boolean) = isProfileTranslatable(JsonField.of(isProfileTranslatable)) /** Sets [Builder.isProfileTranslatable] to an arbitrary JSON value. */ fun isProfileTranslatable(isProfileTranslatable: JsonField<Boolean>) = apply { this.isProfileTranslatable = isProfileTranslatable } /** Whether the account turned on X's translation of its posts. True or false. */ fun isTranslationEnabled(isTranslationEnabled: Boolean) = isTranslationEnabled(JsonField.of(isTranslationEnabled)) /** Sets [Builder.isTranslationEnabled] to an arbitrary JSON value. */ fun isTranslationEnabled(isTranslationEnabled: JsonField<Boolean>) = apply { this.isTranslationEnabled = isTranslationEnabled } fun isTranslator(isTranslator: Boolean) = isTranslator(JsonField.of(isTranslator)) /** Sets [Builder.isTranslator] to an arbitrary JSON value. */ fun isTranslator(isTranslator: JsonField<Boolean>) = apply { this.isTranslator = isTranslator } /** Whether X marks the profile as verified */ fun isVerified(isVerified: Boolean) = isVerified(JsonField.of(isVerified)) /** Sets [Builder.isVerified] to an arbitrary JSON value. */ fun isVerified(isVerified: JsonField<Boolean>) = apply { this.isVerified = isVerified } /** Public lists that include the profile. */ fun listedCount(listedCount: Long) = listedCount(JsonField.of(listedCount)) /** Sets [Builder.listedCount] to an arbitrary JSON value. */ fun listedCount(listedCount: JsonField<Long>) = apply { this.listedCount = listedCount } fun location(location: String) = location(JsonField.of(location)) /** Sets [Builder.location] to an arbitrary JSON value. */ fun location(location: JsonField<String>) = apply { this.location = location } fun mediaCount(mediaCount: Long) = mediaCount(JsonField.of(mediaCount)) /** Sets [Builder.mediaCount] to an arbitrary JSON value. */ fun mediaCount(mediaCount: JsonField<Long>) = apply { this.mediaCount = mediaCount } /** Followers minus fast followers. */ fun normalFollowersCount(normalFollowersCount: Long) = normalFollowersCount(JsonField.of(normalFollowersCount)) /** Sets [Builder.normalFollowersCount] to an arbitrary JSON value. */ fun normalFollowersCount(normalFollowersCount: JsonField<Long>) = apply { this.normalFollowersCount = normalFollowersCount } fun parodyCommentaryFanLabel(parodyCommentaryFanLabel: String) = parodyCommentaryFanLabel(JsonField.of(parodyCommentaryFanLabel)) /** Sets [Builder.parodyCommentaryFanLabel] to an arbitrary JSON value. */ fun parodyCommentaryFanLabel(parodyCommentaryFanLabel: JsonField<String>) = apply { this.parodyCommentaryFanLabel = parodyCommentaryFanLabel } fun pinnedTweetIds(pinnedTweetIds: List<String>) = pinnedTweetIds(JsonField.of(pinnedTweetIds)) /** Sets [Builder.pinnedTweetIds] to an arbitrary JSON value. */ fun pinnedTweetIds(pinnedTweetIds: JsonField<List<String>>) = apply { this.pinnedTweetIds = pinnedTweetIds.map { it.toMutableList() } } /** * Adds a single [String] to [pinnedTweetIds]. * * @throws IllegalStateException if the field was previously set to a non-list. */ fun addPinnedTweetId(pinnedTweetId: String) = apply { pinnedTweetIds = (pinnedTweetIds ?: JsonField.of(mutableListOf())).also { checkKnown("pinnedTweetIds", it).add(pinnedTweetId) } } fun possiblySensitive(possiblySensitive: Boolean) = possiblySensitive(JsonField.of(possiblySensitive)) /** Sets [Builder.possiblySensitive] to an arbitrary JSON value. */ fun possiblySensitive(possiblySensitive: JsonField<Boolean>) = apply { this.possiblySensitive = possiblySensitive } /** Professional metadata with category display settings */ fun professional(professional: Professional) = professional(JsonField.of(professional)) /** Sets [Builder.professional] to an arbitrary JSON value. */ fun professional(professional: JsonField<Professional>) = apply { this.professional = professional } /** Structured profile bio with entity annotations */ fun profileBio(profileBio: ProfileBio) = profileBio(JsonField.of(profileBio)) /** Sets [Builder.profileBio] to an arbitrary JSON value. */ fun profileBio(profileBio: JsonField<ProfileBio>) = apply { this.profileBio = profileBio } /** Original X profile banner field when available */ fun profileBannerUrl(profileBannerUrl: String) = profileBannerUrl(JsonField.of(profileBannerUrl)) /** Sets [Builder.profileBannerUrl] to an arbitrary JSON value. */ fun profileBannerUrl(profileBannerUrl: JsonField<String>) = apply { this.profileBannerUrl = profileBannerUrl } fun profileDescriptionLanguage(profileDescriptionLanguage: String) = profileDescriptionLanguage(JsonField.of(profileDescriptionLanguage)) /** Sets [Builder.profileDescriptionLanguage] to an arbitrary JSON value. */ fun profileDescriptionLanguage(profileDescriptionLanguage: JsonField<String>) = apply { this.profileDescriptionLanguage = profileDescriptionLanguage } fun profileImageShape(profileImageShape: String) = profileImageShape(JsonField.of(profileImageShape)) /** Sets [Builder.profileImageShape] to an arbitrary JSON value. */ fun profileImageShape(profileImageShape: JsonField<String>) = apply { this.profileImageShape = profileImageShape } fun profileInterstitialType(profileInterstitialType: String) = profileInterstitialType(JsonField.of(profileInterstitialType)) /** Sets [Builder.profileInterstitialType] to an arbitrary JSON value. */ fun profileInterstitialType(profileInterstitialType: JsonField<String>) = apply { this.profileInterstitialType = profileInterstitialType } fun profilePicture(profilePicture: String) = profilePicture(JsonField.of(profilePicture)) /** Sets [Builder.profilePicture] to an arbitrary JSON value. */ fun profilePicture(profilePicture: JsonField<String>) = apply { this.profilePicture = profilePicture } /** * The same profile picture at full size, as the account uploaded it. Download this one for * the image. */ fun profilePictureOriginal(profilePictureOriginal: String) = profilePictureOriginal(JsonField.of(profilePictureOriginal)) /** Sets [Builder.profilePictureOriginal] to an arbitrary JSON value. */ fun profilePictureOriginal(profilePictureOriginal: JsonField<String>) = apply { this.profilePictureOriginal = profilePictureOriginal } fun profileSortEnabled(profileSortEnabled: Boolean) = profileSortEnabled(JsonField.of(profileSortEnabled)) /** Sets [Builder.profileSortEnabled] to an arbitrary JSON value. */ fun profileSortEnabled(profileSortEnabled: JsonField<Boolean>) = apply { this.profileSortEnabled = profileSortEnabled } fun profileTranslatorType(profileTranslatorType: String) = profileTranslatorType(JsonField.of(profileTranslatorType)) /** Sets [Builder.profileTranslatorType] to an arbitrary JSON value. */ fun profileTranslatorType(profileTranslatorType: JsonField<String>) = apply { this.profileTranslatorType = profileTranslatorType } /** Whether the profile protects its posts */ fun protected_(protected_: Boolean) = protected_(JsonField.of(protected_)) /** Sets [Builder.protected_] to an arbitrary JSON value. */ fun protected_(protected_: JsonField<Boolean>) = apply { this.protected_ = protected_ } /** * Handle x.com sends this profile's visitors to, such as the new handle of a renamed * account whose old handle now holds a placeholder. Missing when x.com shows the profile * itself. */ fun redirectsToUsername(redirectsToUsername: String) = redirectsToUsername(JsonField.of(redirectsToUsername)) /** Sets [Builder.redirectsToUsername] to an arbitrary JSON value. */ fun redirectsToUsername(redirectsToUsername: JsonField<String>) = apply { this.redirectsToUsername = redirectsToUsername } /** * UTC repost time with includeRetweetTimestamp. Null if the newest profile page has no * match or lookup failed. Otherwise omitted. */ fun retweetedAt(retweetedAt: OffsetDateTime?) = retweetedAt(JsonField.ofNullable(retweetedAt)) /** Alias for calling [Builder.retweetedAt] with `retweetedAt.orElse(null)`. */ fun retweetedAt(retweetedAt: Optional<OffsetDateTime>) = retweetedAt(retweetedAt.getOrNull()) /** Sets [Builder.retweetedAt] to an arbitrary JSON value. */ fun retweetedAt(retweetedAt: JsonField<OffsetDateTime>) = apply { this.retweetedAt = retweetedAt } fun statusesCount(statusesCount: Long) = statusesCount(JsonField.of(statusesCount)) /** Sets [Builder.statusesCount] to an arbitrary JSON value. */ fun statusesCount(statusesCount: JsonField<Long>) = apply { this.statusesCount = statusesCount } /** Accounts subscribed to the profile's paid Subscriptions. 0 when it has none. */ fun subscribersCount(subscribersCount: Long) = subscribersCount(JsonField.of(subscribersCount)) /** Sets [Builder.subscribersCount] to an arbitrary JSON value. */ fun subscribersCount(subscribersCount: JsonField<Long>) = apply { this.subscribersCount = subscribersCount } fun superFollowEligible(superFollowEligible: Boolean) = superFollowEligible(JsonField.of(superFollowEligible)) /** Sets [Builder.superFollowEligible] to an arbitrary JSON value. */ fun superFollowEligible(superFollowEligible: JsonField<Boolean>) = apply { this.superFollowEligible = superFollowEligible } /** Whether X marks the subscription profile as active. */ fun superFollowsUserProfileActive(superFollowsUserProfileActive: Boolean) = superFollowsUserProfileActive(JsonField.of(superFollowsUserProfileActive)) /** Sets [Builder.superFollowsUserProfileActive] to an arbitrary JSON value. */ fun superFollowsUserProfileActive(superFollowsUserProfileActive: JsonField<Boolean>) = apply { this.superFollowsUserProfileActive = superFollowsUserProfileActive } /** Public payment and creator-support handles shown on X. */ fun tipJar(tipJar: TipJar) = tipJar(JsonField.of(tipJar)) /** Sets [Builder.tipJar] to an arbitrary JSON value. */ fun tipJar(tipJar: JsonField<TipJar>) = apply { this.tipJar = tipJar } fun unavailable(unavailable: Boolean) = unavailable(JsonField.of(unavailable)) /** Sets [Builder.unavailable] to an arbitrary JSON value. */ fun unavailable(unavailable: JsonField<Boolean>) = apply { this.unavailable = unavailable } fun unavailableReason(unavailableReason: String) = unavailableReason(JsonField.of(unavailableReason)) /** Sets [Builder.unavailableReason] to an arbitrary JSON value. */ fun unavailableReason(unavailableReason: JsonField<String>) = apply { this.unavailableReason = unavailableReason } fun url(url: String) = url(JsonField.of(url)) /** Sets [Builder.url] to an arbitrary JSON value. */ fun url(url: JsonField<String>) = apply { this.url = url } /** How often the account changed its username. */ fun usernameChanges(usernameChanges: UsernameChanges) = usernameChanges(JsonField.of(usernameChanges)) /** Sets [Builder.usernameChanges] to an arbitrary JSON value. */ fun usernameChanges(usernameChanges: JsonField<UsernameChanges>) = apply { this.usernameChanges = usernameChanges } /** X's text on why the profile is verified, with its links. */ fun verificationReason(verificationReason: VerificationReason) = verificationReason(JsonField.of(verificationReason)) /** Sets [Builder.verificationReason] to an arbitrary JSON value. */ fun verificationReason(verificationReason: JsonField<VerificationReason>) = apply { this.verificationReason = verificationReason } fun verified(verified: Boolean) = verified(JsonField.of(verified)) /** Sets [Builder.verified] to an arbitrary JSON value. */ fun verified(verified: JsonField<Boolean>) = apply { this.verified = verified } fun verifiedType(verifiedType: String) = verifiedType(JsonField.of(verifiedType)) /** Sets [Builder.verifiedType] to an arbitrary JSON value. */ fun verifiedType(verifiedType: JsonField<String>) = apply { this.verifiedType = verifiedType } fun withheldInCountries(withheldInCountries: List<String>) = withheldInCountries(JsonField.of(withheldInCountries)) /** Sets [Builder.withheldInCountries] to an arbitrary JSON value. */ fun withheldInCountries(withheldInCountries: JsonField<List<String>>) = apply { this.withheldInCountries = withheldInCountries.map { it.toMutableList() } } /** * Adds a single [String] to [withheldInCountries]. * * @throws IllegalStateException if the field was previously set to a non-list. */ fun addWithheldInCountry(withheldInCountry: String) = apply { withheldInCountries = (withheldInCountries ?: JsonField.of(mutableListOf())).also { checkKnown("withheldInCountries", it).add(withheldInCountry) } } /** Whether X withholds a post or user */ fun withheldScope(withheldScope: String) = withheldScope(JsonField.of(withheldScope)) /** Sets [Builder.withheldScope] to an arbitrary JSON value. */ fun withheldScope(withheldScope: JsonField<String>) = apply { this.withheldScope = withheldScope } fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply { this.additionalProperties.clear() putAllAdditionalProperties(additionalProperties) } fun putAdditionalProperty(key: String, value: JsonValue) = apply { additionalProperties.put(key, value) } fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply { this.additionalProperties.putAll(additionalProperties) } fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) } fun removeAllAdditionalProperties(keys: Set<String>) = apply { keys.forEach(::removeAdditionalProperty) } /** * Returns an immutable instance of [UserProfile]. * * Further updates to this [Builder] will not mutate the returned instance. * * The following fields are required: * ```java * .id() * .name() * .username() * ``` * * @throws IllegalStateException if any required field is unset. */ fun build(): UserProfile = UserProfile( checkRequired("id", id), checkRequired("name", name), checkRequired("username", username), accountBasedIn, accountBasedInAccurate, accountBasedInUnavailable, (advertiserAccountServiceLevels ?: JsonMissing.of()).map { it.toImmutable() }, advertiserAccountType, affiliatesHighlightedLabel, affiliateUsername, automatedBy, birthdate, businessAccountAffiliatesCount, businessProfileState, communityRole, connectedVia, connectedViaAccurate, contactInfo, coverPicture, createdAt, creatorSubscriptionsCount, defaultProfile, defaultProfileImage, description, email, fastFollowersCount, favouritesCount, followers, following, geoEnabled, grokTranslatedBio, hasCustomTimelines, hasExtendedProfile, hasGraduatedAccess, hasHiddenSubscriptionsOnProfile, highlightsInfo, identityVerification, isAutomated, isBlueVerified, isProfileTranslatable, isTranslationEnabled, isTranslator, isVerified, listedCount, location, mediaCount, normalFollowersCount, parodyCommentaryFanLabel, (pinnedTweetIds ?: JsonMissing.of()).map { it.toImmutable() }, possiblySensitive, professional, profileBio, profileBannerUrl, profileDescriptionLanguage, profileImageShape, profileInterstitialType, profilePicture, profilePictureOriginal, profileSortEnabled, profileTranslatorType, protected_, redirectsToUsername, retweetedAt, statusesCount, subscribersCount, superFollowEligible, superFollowsUserProfileActive, tipJar, unavailable, unavailableReason, url, usernameChanges, verificationReason, verified, verifiedType, (withheldInCountries ?: JsonMissing.of()).map { it.toImmutable() }, withheldScope, additionalProperties.toMutableMap(), ) } private var validated: Boolean = false /** * Validates that the types of all values in this object match their expected types recursively. * * This method is _not_ forwards compatible with new types from the API for existing fields. * * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match * its expected type. */ fun validate(): UserProfile = apply { if (validated) { return@apply } id() name() username() accountBasedIn().ifPresent { it.validate() } accountBasedInAccurate() accountBasedInUnavailable() advertiserAccountServiceLevels() advertiserAccountType() affiliatesHighlightedLabel().ifPresent { it.validate() } affiliateUsername() automatedBy() birthdate().ifPresent { it.validate() } businessAccountAffiliatesCount() businessProfileState() communityRole() connectedVia() connectedViaAccurate() contactInfo().ifPresent { it.validate() } coverPicture() createdAt() creatorSubscriptionsCount() defaultProfile() defaultProfileImage() description() email() fastFollowersCount() favouritesCount() followers() following() geoEnabled() grokTranslatedBio().ifPresent { it.validate() } hasCustomTimelines() hasExtendedProfile() hasGraduatedAccess() hasHiddenSubscriptionsOnProfile() highlightsInfo().ifPresent { it.validate() } identityVerification().ifPresent { it.validate() } isAutomated() isBlueVerified() isProfileTranslatable() isTranslationEnabled() isTranslator() isVerified() listedCount() location() mediaCount() normalFollowersCount() parodyCommentaryFanLabel() pinnedTweetIds() possiblySensitive() professional().ifPresent { it.validate() } profileBio().ifPresent { it.validate() } profileBannerUrl() profileDescriptionLanguage() profileImageShape() profileInterstitialType() profilePicture() profilePictureOriginal() profileSortEnabled() profileTranslatorType() protected_() redirectsToUsername() retweetedAt() statusesCount() subscribersCount() superFollowEligible() superFollowsUserProfileActive() tipJar().ifPresent { it.validate() } unavailable() unavailableReason() url() usernameChanges().ifPresent { it.validate() } verificationReason().ifPresent { it.validate() } verified() verifiedType() withheldInCountries() withheldScope() validated = true } fun isValid(): Boolean = try { validate() true } catch (e: XTwitterScraperInvalidDataException) { false } @JvmSynthetic internal fun validity(): Int = (if (id.asKnown().isPresent) 1 else 0) + (if (name.asKnown().isPresent) 1 else 0) + (if (username.asKnown().isPresent) 1 else 0) + (accountBasedIn.asKnown().getOrNull()?.validity() ?: 0) + (if (accountBasedInAccurate.asKnown().isPresent) 1 else 0) + (if (accountBasedInUnavailable.asKnown().isPresent) 1 else 0) + (advertiserAccountServiceLevels.asKnown().getOrNull()?.size ?: 0) + (if (advertiserAccountType.asKnown().isPresent) 1 else 0) + (affiliatesHighlightedLabel.asKnown().getOrNull()?.validity() ?: 0) + (if (affiliateUsername.asKnown().isPresent) 1 else 0) + (if (automatedBy.asKnown().isPresent) 1 else 0) + (birthdate.asKnown().getOrNull()?.validity() ?: 0) + (if (businessAccountAffiliatesCount.asKnown().isPresent) 1 else 0) + (if (businessProfileState.asKnown().isPresent) 1 else 0) + (if (communityRole.asKnown().isPresent) 1 else 0) + (if (connectedVia.asKnown().isPresent) 1 else 0) + (if (connectedViaAccurate.asKnown().isPresent) 1 else 0) + (contactInfo.asKnown().getOrNull()?.validity() ?: 0) + (if (coverPicture.asKnown().isPresent) 1 else 0) + (if (createdAt.asKnown().isPresent) 1 else 0) + (if (creatorSubscriptionsCount.asKnown().isPresent) 1 else 0) + (if (defaultProfile.asKnown().isPresent) 1 else 0) + (if (defaultProfileImage.asKnown().isPresent) 1 else 0) + (if (description.asKnown().isPresent) 1 else 0) + (if (email.asKnown().isPresent) 1 else 0) + (if (fastFollowersCount.asKnown().isPresent) 1 else 0) + (if (favouritesCount.asKnown().isPresent) 1 else 0) + (if (followers.asKnown().isPresent) 1 else 0) + (if (following.asKnown().isPresent) 1 else 0) + (if (geoEnabled.asKnown().isPresent) 1 else 0) + (grokTranslatedBio.asKnown().getOrNull()?.validity() ?: 0) + (if (hasCustomTimelines.asKnown().isPresent) 1 else 0) + (if (hasExtendedProfile.asKnown().isPresent) 1 else 0) + (if (hasGraduatedAccess.asKnown().isPresent) 1 else 0) + (if (hasHiddenSubscriptionsOnProfile.asKnown().isPresent) 1 else 0) + (highlightsInfo.asKnown().getOrNull()?.validity() ?: 0) + (identityVerification.asKnown().getOrNull()?.validity() ?: 0) + (if (isAutomated.asKnown().isPresent) 1 else 0) + (if (isBlueVerified.asKnown().isPresent) 1 else 0) + (if (isProfileTranslatable.asKnown().isPresent) 1 else 0) + (if (isTranslationEnabled.asKnown().isPresent) 1 else 0) + (if (isTranslator.asKnown().isPresent) 1 else 0) + (if (isVerified.asKnown().isPresent) 1 else 0) + (if (listedCount.asKnown().isPresent) 1 else 0) + (if (location.asKnown().isPresent) 1 else 0) + (if (mediaCount.asKnown().isPresent) 1 else 0) + (if (normalFollowersCount.asKnown().isPresent) 1 else 0) + (if (parodyCommentaryFanLabel.asKnown().isPresent) 1 else 0) + (pinnedTweetIds.asKnown().getOrNull()?.size ?: 0) + (if (possiblySensitive.asKnown().isPresent) 1 else 0) + (professional.asKnown().getOrNull()?.validity() ?: 0) + (profileBio.asKnown().getOrNull()?.validity() ?: 0) + (if (profileBannerUrl.asKnown().isPresent) 1 else 0) + (if (profileDescriptionLanguage.asKnown().isPresent) 1 else 0) + (if (profileImageShape.asKnown().isPresent) 1 else 0) + (if (profileInterstitialType.asKnown().isPresent) 1 else 0) + (if (profilePicture.asKnown().isPresent) 1 else 0) + (if (profilePictureOriginal.asKnown().isPresent) 1 else 0) + (if (profileSortEnabled.asKnown().isPresent) 1 else 0) + (if (profileTranslatorType.asKnown().isPresent) 1 else 0) + (if (protected_.asKnown().isPresent) 1 else 0) + (if (redirectsToUsername.asKnown().isPresent) 1 else 0) + (if (retweetedAt.asKnown().isPresent) 1 else 0) + (if (statusesCount.asKnown().isPresent) 1 else 0) + (if (subscribersCount.asKnown().isPresent) 1 else 0) + (if (superFollowEligible.asKnown().isPresent) 1 else 0) + (if (superFollowsUserProfileActive.asKnown().isPresent) 1 else 0) + (tipJar.asKnown().getOrNull()?.validity() ?: 0) + (if (unavailable.asKnown().isPresent) 1 else 0) + (if (unavailableReason.asKnown().isPresent) 1 else 0) + (if (url.asKnown().isPresent) 1 else 0) + (usernameChanges.asKnown().getOrNull()?.validity() ?: 0) + (verificationReason.asKnown().getOrNull()?.validity() ?: 0) + (if (verified.asKnown().isPresent) 1 else 0) + (if (verifiedType.asKnown().isPresent) 1 else 0) + (withheldInCountries.asKnown().getOrNull()?.size ?: 0) + (if (withheldScope.asKnown().isPresent) 1 else 0) /** * X's best-effort public label inferred from aggregated account-access IP addresses. It does * not state nationality, residence, identity, registration, post location, or exact location. */ class AccountBasedIn @JsonCreator(mode = JsonCreator.Mode.DISABLED) private constructor( private val level: JsonField<Level>, private val observedAt: JsonField<OffsetDateTime>, private val value: JsonField<String>, private val additionalProperties: MutableMap<String, JsonValue>, ) { @JsonCreator private constructor( @JsonProperty("level") @ExcludeMissing level: JsonField<Level> = JsonMissing.of(), @JsonProperty("observedAt") @ExcludeMissing observedAt: JsonField<OffsetDateTime> = JsonMissing.of(), @JsonProperty("value") @ExcludeMissing value: JsonField<String> = JsonMissing.of(), ) : this(level, observedAt, value, mutableMapOf()) /** * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or * is unexpectedly missing or null. */ fun level(): Level = level.getRequired("level") /** * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or * is unexpectedly missing or null. */ fun observedAt(): OffsetDateTime = observedAt.getRequired("observedAt") /** * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or * is unexpectedly missing or null. */ fun value(): String = value.getRequired("value") /** * Returns the raw JSON value of [level]. * * Unlike [level], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("level") @ExcludeMissing fun _level(): JsonField<Level> = level /** * Returns the raw JSON value of [observedAt]. * * Unlike [observedAt], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("observedAt") @ExcludeMissing fun _observedAt(): JsonField<OffsetDateTime> = observedAt /** * Returns the raw JSON value of [value]. * * Unlike [value], this method doesn't throw if the JSON field has an unexpected type. */ @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<String> = value @JsonAnySetter private fun putAdditionalProperty(key: String, value: JsonValue) { additionalProperties.put(key, value) } @JsonAnyGetter @ExcludeMissing fun _additionalProperties(): Map<String, JsonValue> = Collections.unmodifiableMap(additionalProperties) fun toBuilder() = Builder().from(this) companion object { /** * Returns a mutable builder for constructing an instance of [AccountBasedIn]. * * The following fields are required: * ```java * .level() * .observedAt() * .value() * ``` */ @JvmStatic fun builder() = Builder() } /** A builder for [AccountBasedIn]. */ class Builder internal constructor() { private var level: JsonField<Level>? = null private var observedAt: JsonField<OffsetDateTime>? = null private var value: JsonField<String>? = null private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf() @JvmSynthetic internal fun from(accountBasedIn: AccountBasedIn) = apply { level = accountBasedIn.level observedAt = accountBasedIn.observedAt value = accountBasedIn.value additionalProperties = accountBasedIn.additionalProperties.toMutableMap() } fun level(level: Level) = level(JsonField.of(level)) /** Sets [Builder.level] to an arbitrary JSON value. */ fun level(level: JsonField<Level>) = apply { this.level = level } fun observedAt(observedAt: OffsetDateTime) = observedAt(JsonField.of(observedAt)) /** Sets [Builder.observedAt] to an arbitrary JSON value. */ fun observedAt(observedAt: JsonField<OffsetDateTime>) = apply { this.observedAt = observedAt } fun value(value: String) = value(JsonField.of(value)) /** Sets [Builder.value] to an arbitrary JSON value. */ fun value(value: JsonField<String>) = apply { this.value = value } fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply { this.additionalProperties.clear() putAllAdditionalProperties(additionalProperties) } fun putAdditionalProperty(key: String, value: JsonValue) = apply { additionalProperties.put(key, value) } fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply { this.additionalProperties.putAll(additionalProperties) } fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) } fun removeAllAdditionalProperties(keys: Set<String>) = apply { keys.forEach(::removeAdditionalProperty) } /** * Returns an immutable instance of [AccountBasedIn]. * * Further updates to this [Builder] will not mutate the returned instance. * * The following fields are required: * ```java * .level() * .observedAt() * .value() * ``` * * @throws IllegalStateException if any required field is unset. */ fun build(): AccountBasedIn = AccountBasedIn( checkRequired("level", level), checkRequired("observedAt", observedAt), checkRequired("value", value), additionalProperties.toMutableMap(), ) } private var validated: Boolean = false /** * Validates that the types of all values in this object match their expected types * recursively. * * This method is _not_ forwards compatible with new types from the API for existing fields. * * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't * match its expected type. */ fun validate(): AccountBasedIn = apply { if (validated) { return@apply } level().validate() observedAt() value() validated = true } fun isValid(): Boolean = try { validate() true } catch (e: XTwitterScraperInvalidDataException) { false } @JvmSynthetic internal fun validity(): Int = (level.asKnown().getOrNull()?.validity() ?: 0) + (if (observedAt.asKnown().isPresent) 1 else 0) + (if (value.asKnown().isPresent) 1 else 0) class Level @JsonCreator private constructor(private val value: JsonField<String>) : Enum { /** Returns this class instance's raw value. */ @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value companion object { @JvmField val COUNTRY = of("country") @JvmField val REGION = of("region") @JvmStatic fun of(value: String) = Level(JsonField.of(value)) } /** An enum containing [Level]'s known values. */ enum class Known { COUNTRY, REGION, } /** * An enum containing [Level]'s known values, as well as an [_UNKNOWN] member. * * An instance of [Level] can contain an unknown value in a couple of cases: * - It was deserialized from data that doesn't match any known member. For example, if * the SDK is on an older version than the API, then the API may respond with new * members that the SDK is unaware of. * - It was constructed with an arbitrary value using the [of] method. */ enum class Value { COUNTRY, REGION, /** * An enum member indicating that [Level] was instantiated with an unknown value. */ _UNKNOWN, } /** * Returns an enum member corresponding to this class instance's value, or * [Value._UNKNOWN] if the class was instantiated with an unknown value. */ fun value(): Value = when (this) { COUNTRY -> Value.COUNTRY REGION -> Value.REGION else -> Value._UNKNOWN } /** * Returns an enum member corresponding to this class instance's value. * * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a * known member. */ fun known(): Known = when (this) { COUNTRY -> Known.COUNTRY REGION -> Known.REGION else -> throw XTwitterScraperInvalidDataException("Unknown Level: $value") } /** * Returns this class instance's primitive wire representation. * * @throws XTwitterScraperInvalidDataException if this class instance's value does not * have the expected primitive type. */ fun asString(): String = _value().asString().orElseThrow { XTwitterScraperInvalidDataException("Value is not a String") } private var validated: Boolean = false /** * Validates that the types of all values in this object match their expected types * recursively. * * This method is _not_ forwards compatible with new types from the API for existing * fields. * * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't * match its expected type. */ fun validate(): Level = apply { if (validated) { return@apply } known() validated = true } fun isValid(): Boolean = try { validate() true } catch (e: XTwitterScraperInvalidDataException) { false } @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1 override fun equals(other: Any?): Boolean { if (this === other) { return true } return other is Level && value == other.value } override fun hashCode() = value.hashCode() override fun toString() = value.toString() } override fun equals(other: Any?): Boolean { if (this === other) { return true } return other is AccountBasedIn && level == other.level && observedAt == other.observedAt && value == other.value && additionalProperties == other.additionalProperties } private val hashCode: Int by lazy { Objects.hash(level, observedAt, value, additionalProperties) } override fun hashCode(): Int = hashCode override fun toString() = "AccountBasedIn{level=$level, observedAt=$observedAt, value=$value, additionalProperties=$additionalProperties}" } /** Organization affiliation label shown on an X profile. */ class AffiliatesHighlightedLabel @JsonCreator(mode = JsonCreator.Mode.DISABLED) private constructor( private val badgeUrl: JsonField<String>, private val description: JsonField<String>, private val longDescription: JsonField<LongDescription>, private val url: JsonField<String>, private val urlType: JsonField<String>, private val userLabelDisplayType: JsonField<String>, private val userLabelType: JsonField<String>, private val auxiliaryLabels: JsonField<List<UserAuxiliaryLabel>>, private val additionalProperties: MutableMap<String, JsonValue>, ) { @JsonCreator private constructor( @JsonProperty("badgeUrl") @ExcludeMissing badgeUrl: JsonField<String> = JsonMissing.of(), @JsonProperty("description") @ExcludeMissing description: JsonField<String> = JsonMissing.of(), @JsonProperty("longDescription") @ExcludeMissing longDescription: JsonField<LongDescription> = JsonMissing.of(), @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(), @JsonProperty("urlType") @ExcludeMissing urlType: JsonField<String> = JsonMissing.of(), @JsonProperty("userLabelDisplayType") @ExcludeMissing userLabelDisplayType: JsonField<String> = JsonMissing.of(), @JsonProperty("userLabelType") @ExcludeMissing userLabelType: JsonField<String> = JsonMissing.of(), @JsonProperty("auxiliaryLabels") @ExcludeMissing auxiliaryLabels: JsonField<List<UserAuxiliaryLabel>> = JsonMissing.of(), ) : this( badgeUrl, description, longDescription, url, urlType, userLabelDisplayType, userLabelType, auxiliaryLabels, mutableMapOf(), ) /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun badgeUrl(): Optional<String> = badgeUrl.getOptional("badgeUrl") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun description(): Optional<String> = description.getOptional("description") /** * Public text, ranges, references, and mention data. * * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun longDescription(): Optional<LongDescription> = longDescription.getOptional("longDescription") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun url(): Optional<String> = url.getOptional("url") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun urlType(): Optional<String> = urlType.getOptional("urlType") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun userLabelDisplayType(): Optional<String> = userLabelDisplayType.getOptional("userLabelDisplayType") /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */ fun userLabelType(): Optional<String> = userLabelType.getOptional("userLabelType") /** More labels X shows beside the affiliation, such as an automated account's owner. */
                    fun auxiliaryLabels(auxiliaryLabels: List<UserAuxiliaryLabel>) = auxiliaryLabels(JsonField.of(auxiliaryLabels))

                    /** Sets [Builder.auxiliaryLabels] to an arbitrary JSON value. */
                    fun auxiliaryLabels(auxiliaryLabels: JsonField<List<UserAuxiliaryLabel>>) = apply { this.auxiliaryLabels = auxiliaryLabels.map { it.toMutableList() } }

                    /** Adds a single [UserAuxiliaryLabel] to [auxiliaryLabels]. */
                    fun addAuxiliaryLabel(auxiliaryLabel: UserAuxiliaryLabel) = apply {
                        auxiliaryLabels = (auxiliaryLabels ?: JsonField.of(mutableListOf())).also { checkKnown("auxiliaryLabels", it).add(auxiliaryLabel) }
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
                            (auxiliaryLabels ?: JsonMissing.of()).map { it.toImmutable() }, additionalProperties.toMutableMap(),
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
                    auxiliaryLabels().ifPresent { it.forEach { it.validate() } }
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
                        (if (userLabelType.asKnown().isPresent) 1 else 0) +
                    (auxiliaryLabels.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0)

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
                        auxiliaryLabels == other.auxiliaryLabels &&
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
                        auxiliaryLabels, additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "AffiliatesHighlightedLabel{badgeUrl=$badgeUrl, description=$description, longDescription=$longDescription, url=$url, urlType=$urlType, userLabelDisplayType=$userLabelDisplayType, userLabelType=$userLabelType, auxiliaryLabels=$auxiliaryLabels, additionalProperties=$additionalProperties}"
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
