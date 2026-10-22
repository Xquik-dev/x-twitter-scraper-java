// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.events

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import com.x_twitter_scraper.api.models.ContentDisclosure
import com.x_twitter_scraper.api.models.EmbeddedTweet
import com.x_twitter_scraper.api.models.EventType
import com.x_twitter_scraper.api.models.SearchTweet
import com.x_twitter_scraper.api.models.SoftIntervention
import com.x_twitter_scraper.api.models.TweetMedia
import com.x_twitter_scraper.api.models.UnknownCount
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Full monitor event including payload data and optional X event ID. */
class EventDetail
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val data: JsonField<Data>,
    private val monitorId: JsonField<String>,
    private val monitorType: JsonField<MonitorType>,
    private val occurredAt: JsonField<OffsetDateTime>,
    private val type: JsonField<EventType>,
    private val keywordMonitorId: JsonField<String>,
    private val query: JsonField<String>,
    private val username: JsonField<String>,
    private val xEventId: JsonField<String>,
    private val xUserId: JsonField<String>,
    private val monitorName: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        @JsonProperty("monitorId") @ExcludeMissing monitorId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("monitorType")
        @ExcludeMissing
        monitorType: JsonField<MonitorType> = JsonMissing.of(),
        @JsonProperty("occurredAt")
        @ExcludeMissing
        occurredAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<EventType> = JsonMissing.of(),
        @JsonProperty("keywordMonitorId")
        @ExcludeMissing
        keywordMonitorId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("query") @ExcludeMissing query: JsonField<String> = JsonMissing.of(),
        @JsonProperty("username") @ExcludeMissing username: JsonField<String> = JsonMissing.of(),
        @JsonProperty("xEventId") @ExcludeMissing xEventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("xUserId") @ExcludeMissing xUserId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("monitorName")
        @ExcludeMissing
        monitorName: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        data,
        monitorId,
        monitorType,
        occurredAt,
        type,
        keywordMonitorId,
        query,
        username,
        xEventId,
        xUserId,
        monitorName,
        mutableMapOf(),
    )

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun id(): String = id.getRequired("id")

    /**
     * Event payload - shape varies by event type (JSON)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun data(): Data = data.getRequired("data")

    /**
     * Monitor ID associated with this detailed event payload.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun monitorId(): String = monitorId.getRequired("monitorId")

    /**
     * Source monitor type for this detailed event.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun monitorType(): MonitorType = monitorType.getRequired("monitorType")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun occurredAt(): OffsetDateTime = occurredAt.getRequired("occurredAt")

    /**
     * Type of monitor event fired when account activity occurs.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun type(): EventType = type.getRequired("type")

    /**
     * Keyword monitor ID included on detailed keyword events.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun keywordMonitorId(): Optional<String> = keywordMonitorId.getOptional("keywordMonitorId")

    /**
     * Keyword query for this detailed monitor event.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun query(): Optional<String> = query.getOptional("query")

    /**
     * Account username for this detailed monitor event.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun username(): Optional<String> = username.getOptional("username")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun xEventId(): Optional<String> = xEventId.getOptional("xEventId")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun xUserId(): Optional<String> = xUserId.getOptional("xUserId")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun monitorName(): Optional<String> = monitorName.getOptional("monitorName")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

    /**
     * Returns the raw JSON value of [monitorId].
     *
     * Unlike [monitorId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("monitorId") @ExcludeMissing fun _monitorId(): JsonField<String> = monitorId

    /**
     * Returns the raw JSON value of [monitorType].
     *
     * Unlike [monitorType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("monitorType")
    @ExcludeMissing
    fun _monitorType(): JsonField<MonitorType> = monitorType

    /**
     * Returns the raw JSON value of [occurredAt].
     *
     * Unlike [occurredAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("occurredAt")
    @ExcludeMissing
    fun _occurredAt(): JsonField<OffsetDateTime> = occurredAt

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<EventType> = type

    /**
     * Returns the raw JSON value of [keywordMonitorId].
     *
     * Unlike [keywordMonitorId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("keywordMonitorId")
    @ExcludeMissing
    fun _keywordMonitorId(): JsonField<String> = keywordMonitorId

    /**
     * Returns the raw JSON value of [query].
     *
     * Unlike [query], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("query") @ExcludeMissing fun _query(): JsonField<String> = query

    /**
     * Returns the raw JSON value of [username].
     *
     * Unlike [username], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username

    /**
     * Returns the raw JSON value of [xEventId].
     *
     * Unlike [xEventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("xEventId") @ExcludeMissing fun _xEventId(): JsonField<String> = xEventId

    /**
     * Returns the raw JSON value of [xUserId].
     *
     * Unlike [xUserId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("xUserId") @ExcludeMissing fun _xUserId(): JsonField<String> = xUserId

    /**
     * Returns the raw JSON value of [monitorName].
     *
     * Unlike [monitorName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("monitorName") @ExcludeMissing fun _monitorName(): JsonField<String> = monitorName

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
         * Returns a mutable builder for constructing an instance of [EventDetail].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .data()
         * .monitorId()
         * .monitorType()
         * .occurredAt()
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [EventDetail]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var data: JsonField<Data>? = null
        private var monitorId: JsonField<String>? = null
        private var monitorType: JsonField<MonitorType>? = null
        private var occurredAt: JsonField<OffsetDateTime>? = null
        private var type: JsonField<EventType>? = null
        private var keywordMonitorId: JsonField<String> = JsonMissing.of()
        private var query: JsonField<String> = JsonMissing.of()
        private var username: JsonField<String> = JsonMissing.of()
        private var xEventId: JsonField<String> = JsonMissing.of()
        private var xUserId: JsonField<String> = JsonMissing.of()
        private var monitorName: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(eventDetail: EventDetail) = apply {
            id = eventDetail.id
            data = eventDetail.data
            monitorId = eventDetail.monitorId
            monitorType = eventDetail.monitorType
            occurredAt = eventDetail.occurredAt
            type = eventDetail.type
            keywordMonitorId = eventDetail.keywordMonitorId
            query = eventDetail.query
            username = eventDetail.username
            xEventId = eventDetail.xEventId
            xUserId = eventDetail.xUserId
            monitorName = eventDetail.monitorName
            additionalProperties = eventDetail.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /** Sets [Builder.id] to an arbitrary JSON value. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Event payload - shape varies by event type (JSON) */
        fun data(data: Data) = data(JsonField.of(data))

        /** Sets [Builder.data] to an arbitrary JSON value. */
        fun data(data: JsonField<Data>) = apply { this.data = data }

        /** Monitor ID associated with this detailed event payload. */
        fun monitorId(monitorId: String) = monitorId(JsonField.of(monitorId))

        /** Sets [Builder.monitorId] to an arbitrary JSON value. */
        fun monitorId(monitorId: JsonField<String>) = apply { this.monitorId = monitorId }

        /** Source monitor type for this detailed event. */
        fun monitorType(monitorType: MonitorType) = monitorType(JsonField.of(monitorType))

        /** Sets [Builder.monitorType] to an arbitrary JSON value. */
        fun monitorType(monitorType: JsonField<MonitorType>) = apply {
            this.monitorType = monitorType
        }

        fun occurredAt(occurredAt: OffsetDateTime) = occurredAt(JsonField.of(occurredAt))

        /** Sets [Builder.occurredAt] to an arbitrary JSON value. */
        fun occurredAt(occurredAt: JsonField<OffsetDateTime>) = apply {
            this.occurredAt = occurredAt
        }

        /** Type of monitor event fired when account activity occurs. */
        fun type(type: EventType) = type(JsonField.of(type))

        /** Sets [Builder.type] to an arbitrary JSON value. */
        fun type(type: JsonField<EventType>) = apply { this.type = type }

        /** Keyword monitor ID included on detailed keyword events. */
        fun keywordMonitorId(keywordMonitorId: String) =
            keywordMonitorId(JsonField.of(keywordMonitorId))

        /** Sets [Builder.keywordMonitorId] to an arbitrary JSON value. */
        fun keywordMonitorId(keywordMonitorId: JsonField<String>) = apply {
            this.keywordMonitorId = keywordMonitorId
        }

        /** Keyword query for this detailed monitor event. */
        fun query(query: String) = query(JsonField.of(query))

        /** Sets [Builder.query] to an arbitrary JSON value. */
        fun query(query: JsonField<String>) = apply { this.query = query }

        /** Account username for this detailed monitor event. */
        fun username(username: String) = username(JsonField.of(username))

        /** Sets [Builder.username] to an arbitrary JSON value. */
        fun username(username: JsonField<String>) = apply { this.username = username }

        fun xEventId(xEventId: String) = xEventId(JsonField.of(xEventId))

        /** Sets [Builder.xEventId] to an arbitrary JSON value. */
        fun xEventId(xEventId: JsonField<String>) = apply { this.xEventId = xEventId }

        fun xUserId(xUserId: String) = xUserId(JsonField.of(xUserId))

        /** Sets [Builder.xUserId] to an arbitrary JSON value. */
        fun xUserId(xUserId: JsonField<String>) = apply { this.xUserId = xUserId }

        fun monitorName(monitorName: String) = monitorName(JsonField.of(monitorName))

        /** Sets [Builder.monitorName] to an arbitrary JSON value. */
        fun monitorName(monitorName: JsonField<String>) = apply { this.monitorName = monitorName }

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
         * Returns an immutable instance of [EventDetail].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .data()
         * .monitorId()
         * .monitorType()
         * .occurredAt()
         * .type()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): EventDetail =
            EventDetail(
                checkRequired("id", id),
                checkRequired("data", data),
                checkRequired("monitorId", monitorId),
                checkRequired("monitorType", monitorType),
                checkRequired("occurredAt", occurredAt),
                checkRequired("type", type),
                keywordMonitorId,
                query,
                username,
                xEventId,
                xUserId,
                monitorName,
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
    fun validate(): EventDetail = apply {
        if (validated) {
            return@apply
        }

        id()
        data().validate()
        monitorId()
        monitorType().validate()
        occurredAt()
        type().validate()
        keywordMonitorId()
        query()
        username()
        xEventId()
        xUserId()
        monitorName()
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
            (data.asKnown().getOrNull()?.validity() ?: 0) +
            (if (monitorId.asKnown().isPresent) 1 else 0) +
            (monitorType.asKnown().getOrNull()?.validity() ?: 0) +
            (if (occurredAt.asKnown().isPresent) 1 else 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0) +
            (if (keywordMonitorId.asKnown().isPresent) 1 else 0) +
            (if (query.asKnown().isPresent) 1 else 0) +
            (if (username.asKnown().isPresent) 1 else 0) +
            (if (xEventId.asKnown().isPresent) 1 else 0) +
            (if (xUserId.asKnown().isPresent) 1 else 0) +
            (if (monitorName.asKnown().isPresent) 1 else 0)

    /** Event payload - shape varies by event type (JSON) */
    class Data
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val text: JsonField<String>,
        private val type: JsonField<String>,
        private val createdAt: JsonField<String>,
        private val url: JsonField<String>,
        private val lang: JsonField<String>,
        private val isReply: JsonField<Boolean>,
        private val isLimitedReply: JsonField<Boolean>,
        private val isNoteTweet: JsonField<Boolean>,
        private val isPinned: JsonField<Boolean>,
        private val isQuoteStatus: JsonField<Boolean>,
        private val isRetweet: JsonField<Boolean>,
        private val quotedTweetId: JsonField<String>,
        private val quotedTweetPermalink: JsonField<SearchTweet.QuotedTweetPermalink>,
        private val quotedTweetUnavailable: JsonField<SearchTweet.QuotedTweetUnavailable>,
        private val retweetedAt: JsonField<OffsetDateTime>,
        private val inReplyToId: JsonField<String>,
        private val inReplyToUserId: JsonField<String>,
        private val inReplyToUsername: JsonField<String>,
        private val conversationId: JsonField<String>,
        private val conversationControl: JsonField<SearchTweet.ConversationControl>,
        private val limitedActions: JsonField<List<SearchTweet.LimitedAction>>,
        private val source: JsonField<String>,
        private val displayTextRange: JsonField<List<Long>>,
        private val textHighlights: JsonField<List<SearchTweet.TextHighlight>>,
        private val contentDisclosure: JsonField<ContentDisclosure>,
        private val article: JsonField<SearchTweet.Article>,
        private val authorUnavailable: JsonField<SearchTweet.AuthorUnavailable>,
        private val unavailableAuthorId: JsonField<String>,
        private val card: JsonField<Event.Data.Card>,
        private val cashtagAttachments: JsonField<List<SearchTweet.CashtagAttachment>>,
        private val communityId: JsonField<String>,
        private val communityName: JsonField<String>,
        private val communityNote: JsonField<SearchTweet.CommunityNote>,
        private val hasCommunityNotes: JsonField<Boolean>,
        private val edit: JsonField<SearchTweet.Edit>,
        private val exclusiveContent: JsonField<SearchTweet.ExclusiveContent>,
        private val isTranslatable: JsonField<Boolean>,
        private val grokShareAttachment: JsonField<SearchTweet.GrokShareAttachment>,
        private val grokTranslatedPost: JsonField<SearchTweet.GrokTranslatedPost>,
        private val jetfuelAttachment: JsonField<SearchTweet.JetfuelAttachment>,
        private val noteTweet: JsonField<SearchTweet.NoteTweet>,
        private val place: JsonField<SearchTweet.Place>,
        private val coordinates: JsonField<SearchTweet.Coordinates>,
        private val geo: JsonField<SearchTweet.Geo>,
        private val postCta: JsonField<SearchTweet.PostCta>,
        private val possiblySensitive: JsonField<Boolean>,
        private val previousCounts: JsonField<SearchTweet.PreviousCounts>,
        private val reactionContext: JsonField<Event.Data.ReactionContext>,
        private val sportsContext: JsonField<SearchTweet.SportsContext>,
        private val subscriberBadge: JsonField<SearchTweet.SubscriberBadge>,
        private val tombstone: JsonField<SearchTweet.Tombstone>,
        private val interstitial: JsonField<SearchTweet.Interstitial>,
        private val unmentionedUserIds: JsonField<List<String>>,
        private val viewState: JsonField<String>,
        private val entities: JsonField<SearchTweet.Entities>,
        private val scopes: JsonField<SearchTweet.Scopes>,
        private val softIntervention: JsonField<SoftIntervention>,
        private val media: JsonField<List<TweetMedia>>,
        private val retweetCount: JsonField<Long>,
        private val replyCount: JsonField<Long>,
        private val likeCount: JsonField<Long>,
        private val quoteCount: JsonField<Long>,
        private val viewCount: JsonField<Long>,
        private val bookmarkCount: JsonField<Long>,
        private val unknownCounts: JsonField<List<UnknownCount>>,
        private val parentTweet: JsonField<EmbeddedTweet>,
        private val quotedTweet: JsonField<EmbeddedTweet>,
        private val retweetedTweet: JsonField<EmbeddedTweet>,
        private val author: JsonField<Event.Data.Author>,
        private val field: JsonField<String>,
        private val change: JsonField<Long>,
        private val userId: JsonField<String>,
        private val username: JsonField<String>,
        private val previous: JsonField<Event.Data.ProfileValue>,
        private val current: JsonField<Event.Data.ProfileValue>,
        private val followedAt: JsonField<OffsetDateTime>,
        private val followedAtExact: JsonField<Boolean>,
        private val reason: JsonField<Reason>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {
        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
            @JsonProperty("lang") @ExcludeMissing lang: JsonField<String> = JsonMissing.of(),
            @JsonProperty("isReply") @ExcludeMissing isReply: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("isLimitedReply")
            @ExcludeMissing
            isLimitedReply: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("isNoteTweet")
            @ExcludeMissing
            isNoteTweet: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("isPinned")
            @ExcludeMissing
            isPinned: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("isQuoteStatus")
            @ExcludeMissing
            isQuoteStatus: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("isRetweet")
            @ExcludeMissing
            isRetweet: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("quotedTweetId")
            @ExcludeMissing
            quotedTweetId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("quotedTweetPermalink")
            @ExcludeMissing
            quotedTweetPermalink: JsonField<SearchTweet.QuotedTweetPermalink> = JsonMissing.of(),
            @JsonProperty("quotedTweetUnavailable")
            @ExcludeMissing
            quotedTweetUnavailable: JsonField<SearchTweet.QuotedTweetUnavailable> =
                JsonMissing.of(),
            @JsonProperty("retweetedAt")
            @ExcludeMissing
            retweetedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("inReplyToId")
            @ExcludeMissing
            inReplyToId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("inReplyToUserId")
            @ExcludeMissing
            inReplyToUserId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("inReplyToUsername")
            @ExcludeMissing
            inReplyToUsername: JsonField<String> = JsonMissing.of(),
            @JsonProperty("conversationId")
            @ExcludeMissing
            conversationId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("conversationControl")
            @ExcludeMissing
            conversationControl: JsonField<SearchTweet.ConversationControl> = JsonMissing.of(),
            @JsonProperty("limitedActions")
            @ExcludeMissing
            limitedActions: JsonField<List<SearchTweet.LimitedAction>> = JsonMissing.of(),
            @JsonProperty("source") @ExcludeMissing source: JsonField<String> = JsonMissing.of(),
            @JsonProperty("displayTextRange")
            @ExcludeMissing
            displayTextRange: JsonField<List<Long>> = JsonMissing.of(),
            @JsonProperty("textHighlights")
            @ExcludeMissing
            textHighlights: JsonField<List<SearchTweet.TextHighlight>> = JsonMissing.of(),
            @JsonProperty("contentDisclosure")
            @ExcludeMissing
            contentDisclosure: JsonField<ContentDisclosure> = JsonMissing.of(),
            @JsonProperty("article")
            @ExcludeMissing
            article: JsonField<SearchTweet.Article> = JsonMissing.of(),
            @JsonProperty("authorUnavailable")
            @ExcludeMissing
            authorUnavailable: JsonField<SearchTweet.AuthorUnavailable> = JsonMissing.of(),
            @JsonProperty("unavailableAuthorId")
            @ExcludeMissing
            unavailableAuthorId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("card")
            @ExcludeMissing
            card: JsonField<Event.Data.Card> = JsonMissing.of(),
            @JsonProperty("cashtagAttachments")
            @ExcludeMissing
            cashtagAttachments: JsonField<List<SearchTweet.CashtagAttachment>> = JsonMissing.of(),
            @JsonProperty("communityId")
            @ExcludeMissing
            communityId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("communityName")
            @ExcludeMissing
            communityName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("communityNote")
            @ExcludeMissing
            communityNote: JsonField<SearchTweet.CommunityNote> = JsonMissing.of(),
            @JsonProperty("hasCommunityNotes")
            @ExcludeMissing
            hasCommunityNotes: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("edit")
            @ExcludeMissing
            edit: JsonField<SearchTweet.Edit> = JsonMissing.of(),
            @JsonProperty("exclusiveContent")
            @ExcludeMissing
            exclusiveContent: JsonField<SearchTweet.ExclusiveContent> = JsonMissing.of(),
            @JsonProperty("isTranslatable")
            @ExcludeMissing
            isTranslatable: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("grokShareAttachment")
            @ExcludeMissing
            grokShareAttachment: JsonField<SearchTweet.GrokShareAttachment> = JsonMissing.of(),
            @JsonProperty("grokTranslatedPost")
            @ExcludeMissing
            grokTranslatedPost: JsonField<SearchTweet.GrokTranslatedPost> = JsonMissing.of(),
            @JsonProperty("jetfuelAttachment")
            @ExcludeMissing
            jetfuelAttachment: JsonField<SearchTweet.JetfuelAttachment> = JsonMissing.of(),
            @JsonProperty("noteTweet")
            @ExcludeMissing
            noteTweet: JsonField<SearchTweet.NoteTweet> = JsonMissing.of(),
            @JsonProperty("place")
            @ExcludeMissing
            place: JsonField<SearchTweet.Place> = JsonMissing.of(),
            @JsonProperty("coordinates")
            @ExcludeMissing
            coordinates: JsonField<SearchTweet.Coordinates> = JsonMissing.of(),
            @JsonProperty("geo") @ExcludeMissing geo: JsonField<SearchTweet.Geo> = JsonMissing.of(),
            @JsonProperty("postCta")
            @ExcludeMissing
            postCta: JsonField<SearchTweet.PostCta> = JsonMissing.of(),
            @JsonProperty("possiblySensitive")
            @ExcludeMissing
            possiblySensitive: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("previousCounts")
            @ExcludeMissing
            previousCounts: JsonField<SearchTweet.PreviousCounts> = JsonMissing.of(),
            @JsonProperty("reactionContext")
            @ExcludeMissing
            reactionContext: JsonField<Event.Data.ReactionContext> = JsonMissing.of(),
            @JsonProperty("sportsContext")
            @ExcludeMissing
            sportsContext: JsonField<SearchTweet.SportsContext> = JsonMissing.of(),
            @JsonProperty("subscriberBadge")
            @ExcludeMissing
            subscriberBadge: JsonField<SearchTweet.SubscriberBadge> = JsonMissing.of(),
            @JsonProperty("tombstone")
            @ExcludeMissing
            tombstone: JsonField<SearchTweet.Tombstone> = JsonMissing.of(),
            @JsonProperty("interstitial")
            @ExcludeMissing
            interstitial: JsonField<SearchTweet.Interstitial> = JsonMissing.of(),
            @JsonProperty("unmentionedUserIds")
            @ExcludeMissing
            unmentionedUserIds: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("viewState")
            @ExcludeMissing
            viewState: JsonField<String> = JsonMissing.of(),
            @JsonProperty("entities")
            @ExcludeMissing
            entities: JsonField<SearchTweet.Entities> = JsonMissing.of(),
            @JsonProperty("scopes")
            @ExcludeMissing
            scopes: JsonField<SearchTweet.Scopes> = JsonMissing.of(),
            @JsonProperty("softIntervention")
            @ExcludeMissing
            softIntervention: JsonField<SoftIntervention> = JsonMissing.of(),
            @JsonProperty("media")
            @ExcludeMissing
            media: JsonField<List<TweetMedia>> = JsonMissing.of(),
            @JsonProperty("retweetCount")
            @ExcludeMissing
            retweetCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("replyCount")
            @ExcludeMissing
            replyCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("likeCount")
            @ExcludeMissing
            likeCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("quoteCount")
            @ExcludeMissing
            quoteCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("viewCount")
            @ExcludeMissing
            viewCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("bookmarkCount")
            @ExcludeMissing
            bookmarkCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("unknownCounts")
            @ExcludeMissing
            unknownCounts: JsonField<List<UnknownCount>> = JsonMissing.of(),
            @JsonProperty("parentTweet")
            @ExcludeMissing
            parentTweet: JsonField<EmbeddedTweet> = JsonMissing.of(),
            @JsonProperty("quoted_tweet")
            @ExcludeMissing
            quotedTweet: JsonField<EmbeddedTweet> = JsonMissing.of(),
            @JsonProperty("retweeted_tweet")
            @ExcludeMissing
            retweetedTweet: JsonField<EmbeddedTweet> = JsonMissing.of(),
            @JsonProperty("author")
            @ExcludeMissing
            author: JsonField<Event.Data.Author> = JsonMissing.of(),
            @JsonProperty("field") @ExcludeMissing field: JsonField<String> = JsonMissing.of(),
            @JsonProperty("change") @ExcludeMissing change: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("userId") @ExcludeMissing userId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("username")
            @ExcludeMissing
            username: JsonField<String> = JsonMissing.of(),
            @JsonProperty("previous")
            @ExcludeMissing
            previous: JsonField<Event.Data.ProfileValue> = JsonMissing.of(),
            @JsonProperty("current")
            @ExcludeMissing
            current: JsonField<Event.Data.ProfileValue> = JsonMissing.of(),
            @JsonProperty("followedAt")
            @ExcludeMissing
            followedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("followedAtExact")
            @ExcludeMissing
            followedAtExact: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("reason") @ExcludeMissing reason: JsonField<Reason> = JsonMissing.of(),
        ) : this(
            id,
            text,
            type,
            createdAt,
            url,
            lang,
            isReply,
            isLimitedReply,
            isNoteTweet,
            isPinned,
            isQuoteStatus,
            isRetweet,
            quotedTweetId,
            quotedTweetPermalink,
            quotedTweetUnavailable,
            retweetedAt,
            inReplyToId,
            inReplyToUserId,
            inReplyToUsername,
            conversationId,
            conversationControl,
            limitedActions,
            source,
            displayTextRange,
            textHighlights,
            contentDisclosure,
            article,
            authorUnavailable,
            unavailableAuthorId,
            card,
            cashtagAttachments,
            communityId,
            communityName,
            communityNote,
            hasCommunityNotes,
            edit,
            exclusiveContent,
            isTranslatable,
            grokShareAttachment,
            grokTranslatedPost,
            jetfuelAttachment,
            noteTweet,
            place,
            coordinates,
            geo,
            postCta,
            possiblySensitive,
            previousCounts,
            reactionContext,
            sportsContext,
            subscriberBadge,
            tombstone,
            interstitial,
            unmentionedUserIds,
            viewState,
            entities,
            scopes,
            softIntervention,
            media,
            retweetCount,
            replyCount,
            likeCount,
            quoteCount,
            viewCount,
            bookmarkCount,
            unknownCounts,
            parentTweet,
            quotedTweet,
            retweetedTweet,
            author,
            field,
            change,
            userId,
            username,
            previous,
            current,
            followedAt,
            followedAtExact,
            reason,
            mutableMapOf(),
        )

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun id(): Optional<String> = id.getOptional("id")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun text(): Optional<String> = text.getOptional("text")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun type(): Optional<String> = type.getOptional("type")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun createdAt(): Optional<String> = createdAt.getOptional("createdAt")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun url(): Optional<String> = url.getOptional("url")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun lang(): Optional<String> = lang.getOptional("lang")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun isReply(): Optional<Boolean> = isReply.getOptional("isReply")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun isLimitedReply(): Optional<Boolean> = isLimitedReply.getOptional("isLimitedReply")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun isNoteTweet(): Optional<Boolean> = isNoteTweet.getOptional("isNoteTweet")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun isPinned(): Optional<Boolean> = isPinned.getOptional("isPinned")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun isQuoteStatus(): Optional<Boolean> = isQuoteStatus.getOptional("isQuoteStatus")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun isRetweet(): Optional<Boolean> = isRetweet.getOptional("isRetweet")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun quotedTweetId(): Optional<String> = quotedTweetId.getOptional("quotedTweetId")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun quotedTweetPermalink(): Optional<SearchTweet.QuotedTweetPermalink> =
            quotedTweetPermalink.getOptional("quotedTweetPermalink")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun quotedTweetUnavailable(): Optional<SearchTweet.QuotedTweetUnavailable> =
            quotedTweetUnavailable.getOptional("quotedTweetUnavailable")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun retweetedAt(): Optional<OffsetDateTime> = retweetedAt.getOptional("retweetedAt")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun inReplyToId(): Optional<String> = inReplyToId.getOptional("inReplyToId")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun inReplyToUserId(): Optional<String> = inReplyToUserId.getOptional("inReplyToUserId")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun inReplyToUsername(): Optional<String> =
            inReplyToUsername.getOptional("inReplyToUsername")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun conversationId(): Optional<String> = conversationId.getOptional("conversationId")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun conversationControl(): Optional<SearchTweet.ConversationControl> =
            conversationControl.getOptional("conversationControl")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun limitedActions(): Optional<List<SearchTweet.LimitedAction>> =
            limitedActions.getOptional("limitedActions")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun source(): Optional<String> = source.getOptional("source")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun displayTextRange(): Optional<List<Long>> =
            displayTextRange.getOptional("displayTextRange")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun textHighlights(): Optional<List<SearchTweet.TextHighlight>> =
            textHighlights.getOptional("textHighlights")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun contentDisclosure(): Optional<ContentDisclosure> =
            contentDisclosure.getOptional("contentDisclosure")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun article(): Optional<SearchTweet.Article> = article.getOptional("article")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun authorUnavailable(): Optional<SearchTweet.AuthorUnavailable> =
            authorUnavailable.getOptional("authorUnavailable")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun unavailableAuthorId(): Optional<String> =
            unavailableAuthorId.getOptional("unavailableAuthorId")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun card(): Optional<Event.Data.Card> = card.getOptional("card")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun cashtagAttachments(): Optional<List<SearchTweet.CashtagAttachment>> =
            cashtagAttachments.getOptional("cashtagAttachments")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun communityId(): Optional<String> = communityId.getOptional("communityId")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun communityName(): Optional<String> = communityName.getOptional("communityName")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun communityNote(): Optional<SearchTweet.CommunityNote> =
            communityNote.getOptional("communityNote")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun hasCommunityNotes(): Optional<Boolean> =
            hasCommunityNotes.getOptional("hasCommunityNotes")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun edit(): Optional<SearchTweet.Edit> = edit.getOptional("edit")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun exclusiveContent(): Optional<SearchTweet.ExclusiveContent> =
            exclusiveContent.getOptional("exclusiveContent")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun isTranslatable(): Optional<Boolean> = isTranslatable.getOptional("isTranslatable")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun grokShareAttachment(): Optional<SearchTweet.GrokShareAttachment> =
            grokShareAttachment.getOptional("grokShareAttachment")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun grokTranslatedPost(): Optional<SearchTweet.GrokTranslatedPost> =
            grokTranslatedPost.getOptional("grokTranslatedPost")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun jetfuelAttachment(): Optional<SearchTweet.JetfuelAttachment> =
            jetfuelAttachment.getOptional("jetfuelAttachment")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun noteTweet(): Optional<SearchTweet.NoteTweet> = noteTweet.getOptional("noteTweet")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun place(): Optional<SearchTweet.Place> = place.getOptional("place")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun coordinates(): Optional<SearchTweet.Coordinates> =
            coordinates.getOptional("coordinates")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun geo(): Optional<SearchTweet.Geo> = geo.getOptional("geo")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun postCta(): Optional<SearchTweet.PostCta> = postCta.getOptional("postCta")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun possiblySensitive(): Optional<Boolean> =
            possiblySensitive.getOptional("possiblySensitive")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun previousCounts(): Optional<SearchTweet.PreviousCounts> =
            previousCounts.getOptional("previousCounts")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun reactionContext(): Optional<Event.Data.ReactionContext> =
            reactionContext.getOptional("reactionContext")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun sportsContext(): Optional<SearchTweet.SportsContext> =
            sportsContext.getOptional("sportsContext")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun subscriberBadge(): Optional<SearchTweet.SubscriberBadge> =
            subscriberBadge.getOptional("subscriberBadge")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun tombstone(): Optional<SearchTweet.Tombstone> = tombstone.getOptional("tombstone")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun interstitial(): Optional<SearchTweet.Interstitial> =
            interstitial.getOptional("interstitial")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun unmentionedUserIds(): Optional<List<String>> =
            unmentionedUserIds.getOptional("unmentionedUserIds")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun viewState(): Optional<String> = viewState.getOptional("viewState")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun entities(): Optional<SearchTweet.Entities> = entities.getOptional("entities")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun scopes(): Optional<SearchTweet.Scopes> = scopes.getOptional("scopes")

        /**
         * The label X shows under a post whose reach it limits. It links to the page that explains
         * it.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun softIntervention(): Optional<SoftIntervention> =
            softIntervention.getOptional("softIntervention")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun media(): Optional<List<TweetMedia>> = media.getOptional("media")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun retweetCount(): Optional<Long> = retweetCount.getOptional("retweetCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun replyCount(): Optional<Long> = replyCount.getOptional("replyCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun likeCount(): Optional<Long> = likeCount.getOptional("likeCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun quoteCount(): Optional<Long> = quoteCount.getOptional("quoteCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun viewCount(): Optional<Long> = viewCount.getOptional("viewCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun bookmarkCount(): Optional<Long> = bookmarkCount.getOptional("bookmarkCount")

        /**
         * X did not send these counts, so each 0 means unknown.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun unknownCounts(): Optional<List<UnknownCount>> =
            unknownCounts.getOptional("unknownCounts")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun parentTweet(): Optional<EmbeddedTweet> = parentTweet.getOptional("parentTweet")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun quotedTweet(): Optional<EmbeddedTweet> = quotedTweet.getOptional("quoted_tweet")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun retweetedTweet(): Optional<EmbeddedTweet> =
            retweetedTweet.getOptional("retweeted_tweet")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun author(): Optional<Event.Data.Author> = author.getOptional("author")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun field(): Optional<String> = field.getOptional("field")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun change(): Optional<Long> = change.getOptional("change")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun userId(): Optional<String> = userId.getOptional("userId")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun username(): Optional<String> = username.getOptional("username")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun previous(): Optional<Event.Data.ProfileValue> = previous.getOptional("previous")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun current(): Optional<Event.Data.ProfileValue> = current.getOptional("current")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun followedAt(): Optional<OffsetDateTime> = followedAt.getOptional("followedAt")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun followedAtExact(): Optional<Boolean> = followedAtExact.getOptional("followedAtExact")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun reason(): Optional<Reason> = reason.getOptional("reason")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [text].
         *
         * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

        /**
         * Returns the raw JSON value of [createdAt].
         *
         * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("createdAt") @ExcludeMissing fun _createdAt(): JsonField<String> = createdAt

        /**
         * Returns the raw JSON value of [url].
         *
         * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

        /**
         * Returns the raw JSON value of [lang].
         *
         * Unlike [lang], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("lang") @ExcludeMissing fun _lang(): JsonField<String> = lang

        /**
         * Returns the raw JSON value of [isReply].
         *
         * Unlike [isReply], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("isReply") @ExcludeMissing fun _isReply(): JsonField<Boolean> = isReply

        /**
         * Returns the raw JSON value of [isLimitedReply].
         *
         * Unlike [isLimitedReply], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("isLimitedReply")
        @ExcludeMissing
        fun _isLimitedReply(): JsonField<Boolean> = isLimitedReply

        /**
         * Returns the raw JSON value of [isNoteTweet].
         *
         * Unlike [isNoteTweet], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("isNoteTweet")
        @ExcludeMissing
        fun _isNoteTweet(): JsonField<Boolean> = isNoteTweet

        /**
         * Returns the raw JSON value of [isPinned].
         *
         * Unlike [isPinned], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("isPinned") @ExcludeMissing fun _isPinned(): JsonField<Boolean> = isPinned

        /**
         * Returns the raw JSON value of [isQuoteStatus].
         *
         * Unlike [isQuoteStatus], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("isQuoteStatus")
        @ExcludeMissing
        fun _isQuoteStatus(): JsonField<Boolean> = isQuoteStatus

        /**
         * Returns the raw JSON value of [isRetweet].
         *
         * Unlike [isRetweet], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("isRetweet") @ExcludeMissing fun _isRetweet(): JsonField<Boolean> = isRetweet

        /**
         * Returns the raw JSON value of [quotedTweetId].
         *
         * Unlike [quotedTweetId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("quotedTweetId")
        @ExcludeMissing
        fun _quotedTweetId(): JsonField<String> = quotedTweetId

        /**
         * Returns the raw JSON value of [quotedTweetPermalink].
         *
         * Unlike [quotedTweetPermalink], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("quotedTweetPermalink")
        @ExcludeMissing
        fun _quotedTweetPermalink(): JsonField<SearchTweet.QuotedTweetPermalink> =
            quotedTweetPermalink

        /**
         * Returns the raw JSON value of [quotedTweetUnavailable].
         *
         * Unlike [quotedTweetUnavailable], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("quotedTweetUnavailable")
        @ExcludeMissing
        fun _quotedTweetUnavailable(): JsonField<SearchTweet.QuotedTweetUnavailable> =
            quotedTweetUnavailable

        /**
         * Returns the raw JSON value of [retweetedAt].
         *
         * Unlike [retweetedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("retweetedAt")
        @ExcludeMissing
        fun _retweetedAt(): JsonField<OffsetDateTime> = retweetedAt

        /**
         * Returns the raw JSON value of [inReplyToId].
         *
         * Unlike [inReplyToId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("inReplyToId")
        @ExcludeMissing
        fun _inReplyToId(): JsonField<String> = inReplyToId

        /**
         * Returns the raw JSON value of [inReplyToUserId].
         *
         * Unlike [inReplyToUserId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("inReplyToUserId")
        @ExcludeMissing
        fun _inReplyToUserId(): JsonField<String> = inReplyToUserId

        /**
         * Returns the raw JSON value of [inReplyToUsername].
         *
         * Unlike [inReplyToUsername], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("inReplyToUsername")
        @ExcludeMissing
        fun _inReplyToUsername(): JsonField<String> = inReplyToUsername

        /**
         * Returns the raw JSON value of [conversationId].
         *
         * Unlike [conversationId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("conversationId")
        @ExcludeMissing
        fun _conversationId(): JsonField<String> = conversationId

        /**
         * Returns the raw JSON value of [conversationControl].
         *
         * Unlike [conversationControl], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("conversationControl")
        @ExcludeMissing
        fun _conversationControl(): JsonField<SearchTweet.ConversationControl> = conversationControl

        /**
         * Returns the raw JSON value of [limitedActions].
         *
         * Unlike [limitedActions], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("limitedActions")
        @ExcludeMissing
        fun _limitedActions(): JsonField<List<SearchTweet.LimitedAction>> = limitedActions

        /**
         * Returns the raw JSON value of [source].
         *
         * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<String> = source

        /**
         * Returns the raw JSON value of [displayTextRange].
         *
         * Unlike [displayTextRange], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("displayTextRange")
        @ExcludeMissing
        fun _displayTextRange(): JsonField<List<Long>> = displayTextRange

        /**
         * Returns the raw JSON value of [textHighlights].
         *
         * Unlike [textHighlights], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("textHighlights")
        @ExcludeMissing
        fun _textHighlights(): JsonField<List<SearchTweet.TextHighlight>> = textHighlights

        /**
         * Returns the raw JSON value of [contentDisclosure].
         *
         * Unlike [contentDisclosure], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("contentDisclosure")
        @ExcludeMissing
        fun _contentDisclosure(): JsonField<ContentDisclosure> = contentDisclosure

        /**
         * Returns the raw JSON value of [article].
         *
         * Unlike [article], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("article")
        @ExcludeMissing
        fun _article(): JsonField<SearchTweet.Article> = article

        /**
         * Returns the raw JSON value of [authorUnavailable].
         *
         * Unlike [authorUnavailable], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("authorUnavailable")
        @ExcludeMissing
        fun _authorUnavailable(): JsonField<SearchTweet.AuthorUnavailable> = authorUnavailable

        /**
         * Returns the raw JSON value of [unavailableAuthorId].
         *
         * Unlike [unavailableAuthorId], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("unavailableAuthorId")
        @ExcludeMissing
        fun _unavailableAuthorId(): JsonField<String> = unavailableAuthorId

        /**
         * Returns the raw JSON value of [card].
         *
         * Unlike [card], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("card") @ExcludeMissing fun _card(): JsonField<Event.Data.Card> = card

        /**
         * Returns the raw JSON value of [cashtagAttachments].
         *
         * Unlike [cashtagAttachments], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("cashtagAttachments")
        @ExcludeMissing
        fun _cashtagAttachments(): JsonField<List<SearchTweet.CashtagAttachment>> =
            cashtagAttachments

        /**
         * Returns the raw JSON value of [communityId].
         *
         * Unlike [communityId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("communityId")
        @ExcludeMissing
        fun _communityId(): JsonField<String> = communityId

        /**
         * Returns the raw JSON value of [communityName].
         *
         * Unlike [communityName], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("communityName")
        @ExcludeMissing
        fun _communityName(): JsonField<String> = communityName

        /**
         * Returns the raw JSON value of [communityNote].
         *
         * Unlike [communityNote], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("communityNote")
        @ExcludeMissing
        fun _communityNote(): JsonField<SearchTweet.CommunityNote> = communityNote

        /**
         * Returns the raw JSON value of [hasCommunityNotes].
         *
         * Unlike [hasCommunityNotes], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("hasCommunityNotes")
        @ExcludeMissing
        fun _hasCommunityNotes(): JsonField<Boolean> = hasCommunityNotes

        /**
         * Returns the raw JSON value of [edit].
         *
         * Unlike [edit], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("edit") @ExcludeMissing fun _edit(): JsonField<SearchTweet.Edit> = edit

        /**
         * Returns the raw JSON value of [exclusiveContent].
         *
         * Unlike [exclusiveContent], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("exclusiveContent")
        @ExcludeMissing
        fun _exclusiveContent(): JsonField<SearchTweet.ExclusiveContent> = exclusiveContent

        /**
         * Returns the raw JSON value of [isTranslatable].
         *
         * Unlike [isTranslatable], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("isTranslatable")
        @ExcludeMissing
        fun _isTranslatable(): JsonField<Boolean> = isTranslatable

        /**
         * Returns the raw JSON value of [grokShareAttachment].
         *
         * Unlike [grokShareAttachment], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("grokShareAttachment")
        @ExcludeMissing
        fun _grokShareAttachment(): JsonField<SearchTweet.GrokShareAttachment> = grokShareAttachment

        /**
         * Returns the raw JSON value of [grokTranslatedPost].
         *
         * Unlike [grokTranslatedPost], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("grokTranslatedPost")
        @ExcludeMissing
        fun _grokTranslatedPost(): JsonField<SearchTweet.GrokTranslatedPost> = grokTranslatedPost

        /**
         * Returns the raw JSON value of [jetfuelAttachment].
         *
         * Unlike [jetfuelAttachment], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("jetfuelAttachment")
        @ExcludeMissing
        fun _jetfuelAttachment(): JsonField<SearchTweet.JetfuelAttachment> = jetfuelAttachment

        /**
         * Returns the raw JSON value of [noteTweet].
         *
         * Unlike [noteTweet], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("noteTweet")
        @ExcludeMissing
        fun _noteTweet(): JsonField<SearchTweet.NoteTweet> = noteTweet

        /**
         * Returns the raw JSON value of [place].
         *
         * Unlike [place], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("place") @ExcludeMissing fun _place(): JsonField<SearchTweet.Place> = place

        /**
         * Returns the raw JSON value of [coordinates].
         *
         * Unlike [coordinates], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("coordinates")
        @ExcludeMissing
        fun _coordinates(): JsonField<SearchTweet.Coordinates> = coordinates

        /**
         * Returns the raw JSON value of [geo].
         *
         * Unlike [geo], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("geo") @ExcludeMissing fun _geo(): JsonField<SearchTweet.Geo> = geo

        /**
         * Returns the raw JSON value of [postCta].
         *
         * Unlike [postCta], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("postCta")
        @ExcludeMissing
        fun _postCta(): JsonField<SearchTweet.PostCta> = postCta

        /**
         * Returns the raw JSON value of [possiblySensitive].
         *
         * Unlike [possiblySensitive], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("possiblySensitive")
        @ExcludeMissing
        fun _possiblySensitive(): JsonField<Boolean> = possiblySensitive

        /**
         * Returns the raw JSON value of [previousCounts].
         *
         * Unlike [previousCounts], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("previousCounts")
        @ExcludeMissing
        fun _previousCounts(): JsonField<SearchTweet.PreviousCounts> = previousCounts

        /**
         * Returns the raw JSON value of [reactionContext].
         *
         * Unlike [reactionContext], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("reactionContext")
        @ExcludeMissing
        fun _reactionContext(): JsonField<Event.Data.ReactionContext> = reactionContext

        /**
         * Returns the raw JSON value of [sportsContext].
         *
         * Unlike [sportsContext], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("sportsContext")
        @ExcludeMissing
        fun _sportsContext(): JsonField<SearchTweet.SportsContext> = sportsContext

        /**
         * Returns the raw JSON value of [subscriberBadge].
         *
         * Unlike [subscriberBadge], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("subscriberBadge")
        @ExcludeMissing
        fun _subscriberBadge(): JsonField<SearchTweet.SubscriberBadge> = subscriberBadge

        /**
         * Returns the raw JSON value of [tombstone].
         *
         * Unlike [tombstone], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tombstone")
        @ExcludeMissing
        fun _tombstone(): JsonField<SearchTweet.Tombstone> = tombstone

        /**
         * Returns the raw JSON value of [interstitial].
         *
         * Unlike [interstitial], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("interstitial")
        @ExcludeMissing
        fun _interstitial(): JsonField<SearchTweet.Interstitial> = interstitial

        /**
         * Returns the raw JSON value of [unmentionedUserIds].
         *
         * Unlike [unmentionedUserIds], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("unmentionedUserIds")
        @ExcludeMissing
        fun _unmentionedUserIds(): JsonField<List<String>> = unmentionedUserIds

        /**
         * Returns the raw JSON value of [viewState].
         *
         * Unlike [viewState], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("viewState") @ExcludeMissing fun _viewState(): JsonField<String> = viewState

        /**
         * Returns the raw JSON value of [entities].
         *
         * Unlike [entities], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("entities")
        @ExcludeMissing
        fun _entities(): JsonField<SearchTweet.Entities> = entities

        /**
         * Returns the raw JSON value of [scopes].
         *
         * Unlike [scopes], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("scopes")
        @ExcludeMissing
        fun _scopes(): JsonField<SearchTweet.Scopes> = scopes

        /**
         * Returns the raw JSON value of [softIntervention].
         *
         * Unlike [softIntervention], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("softIntervention")
        @ExcludeMissing
        fun _softIntervention(): JsonField<SoftIntervention> = softIntervention

        /**
         * Returns the raw JSON value of [media].
         *
         * Unlike [media], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("media") @ExcludeMissing fun _media(): JsonField<List<TweetMedia>> = media

        /**
         * Returns the raw JSON value of [retweetCount].
         *
         * Unlike [retweetCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("retweetCount")
        @ExcludeMissing
        fun _retweetCount(): JsonField<Long> = retweetCount

        /**
         * Returns the raw JSON value of [replyCount].
         *
         * Unlike [replyCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("replyCount") @ExcludeMissing fun _replyCount(): JsonField<Long> = replyCount

        /**
         * Returns the raw JSON value of [likeCount].
         *
         * Unlike [likeCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("likeCount") @ExcludeMissing fun _likeCount(): JsonField<Long> = likeCount

        /**
         * Returns the raw JSON value of [quoteCount].
         *
         * Unlike [quoteCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("quoteCount") @ExcludeMissing fun _quoteCount(): JsonField<Long> = quoteCount

        /**
         * Returns the raw JSON value of [viewCount].
         *
         * Unlike [viewCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("viewCount") @ExcludeMissing fun _viewCount(): JsonField<Long> = viewCount

        /**
         * Returns the raw JSON value of [bookmarkCount].
         *
         * Unlike [bookmarkCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("bookmarkCount")
        @ExcludeMissing
        fun _bookmarkCount(): JsonField<Long> = bookmarkCount

        /**
         * Returns the raw JSON value of [unknownCounts].
         *
         * Unlike [unknownCounts], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("unknownCounts")
        @ExcludeMissing
        fun _unknownCounts(): JsonField<List<UnknownCount>> = unknownCounts

        /**
         * Returns the raw JSON value of [parentTweet].
         *
         * Unlike [parentTweet], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("parentTweet")
        @ExcludeMissing
        fun _parentTweet(): JsonField<EmbeddedTweet> = parentTweet

        /**
         * Returns the raw JSON value of [quotedTweet].
         *
         * Unlike [quotedTweet], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("quoted_tweet")
        @ExcludeMissing
        fun _quotedTweet(): JsonField<EmbeddedTweet> = quotedTweet

        /**
         * Returns the raw JSON value of [retweetedTweet].
         *
         * Unlike [retweetedTweet], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("retweeted_tweet")
        @ExcludeMissing
        fun _retweetedTweet(): JsonField<EmbeddedTweet> = retweetedTweet

        /**
         * Returns the raw JSON value of [author].
         *
         * Unlike [author], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("author") @ExcludeMissing fun _author(): JsonField<Event.Data.Author> = author

        /**
         * Returns the raw JSON value of [field].
         *
         * Unlike [field], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("field") @ExcludeMissing fun _field(): JsonField<String> = field

        /**
         * Returns the raw JSON value of [change].
         *
         * Unlike [change], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("change") @ExcludeMissing fun _change(): JsonField<Long> = change

        /**
         * Returns the raw JSON value of [userId].
         *
         * Unlike [userId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("userId") @ExcludeMissing fun _userId(): JsonField<String> = userId

        /**
         * Returns the raw JSON value of [username].
         *
         * Unlike [username], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username

        /**
         * Returns the raw JSON value of [previous].
         *
         * Unlike [previous], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("previous")
        @ExcludeMissing
        fun _previous(): JsonField<Event.Data.ProfileValue> = previous

        /**
         * Returns the raw JSON value of [current].
         *
         * Unlike [current], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("current")
        @ExcludeMissing
        fun _current(): JsonField<Event.Data.ProfileValue> = current

        /**
         * Returns the raw JSON value of [followedAt].
         *
         * Unlike [followedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("followedAt")
        @ExcludeMissing
        fun _followedAt(): JsonField<OffsetDateTime> = followedAt

        /**
         * Returns the raw JSON value of [followedAtExact].
         *
         * Unlike [followedAtExact], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("followedAtExact")
        @ExcludeMissing
        fun _followedAtExact(): JsonField<Boolean> = followedAtExact

        /**
         * Returns the raw JSON value of [reason].
         *
         * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<Reason> = reason

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
            /** Returns a mutable builder for constructing an instance of [Data]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Data]. */
        class Builder internal constructor() {
            private var id: JsonField<String> = JsonMissing.of()
            private var text: JsonField<String> = JsonMissing.of()
            private var type: JsonField<String> = JsonMissing.of()
            private var createdAt: JsonField<String> = JsonMissing.of()
            private var url: JsonField<String> = JsonMissing.of()
            private var lang: JsonField<String> = JsonMissing.of()
            private var isReply: JsonField<Boolean> = JsonMissing.of()
            private var isLimitedReply: JsonField<Boolean> = JsonMissing.of()
            private var isNoteTweet: JsonField<Boolean> = JsonMissing.of()
            private var isPinned: JsonField<Boolean> = JsonMissing.of()
            private var isQuoteStatus: JsonField<Boolean> = JsonMissing.of()
            private var isRetweet: JsonField<Boolean> = JsonMissing.of()
            private var quotedTweetId: JsonField<String> = JsonMissing.of()
            private var quotedTweetPermalink: JsonField<SearchTweet.QuotedTweetPermalink> =
                JsonMissing.of()
            private var quotedTweetUnavailable: JsonField<SearchTweet.QuotedTweetUnavailable> =
                JsonMissing.of()
            private var retweetedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var inReplyToId: JsonField<String> = JsonMissing.of()
            private var inReplyToUserId: JsonField<String> = JsonMissing.of()
            private var inReplyToUsername: JsonField<String> = JsonMissing.of()
            private var conversationId: JsonField<String> = JsonMissing.of()
            private var conversationControl: JsonField<SearchTweet.ConversationControl> =
                JsonMissing.of()
            private var limitedActions: JsonField<MutableList<SearchTweet.LimitedAction>>? = null
            private var source: JsonField<String> = JsonMissing.of()
            private var displayTextRange: JsonField<MutableList<Long>>? = null
            private var textHighlights: JsonField<MutableList<SearchTweet.TextHighlight>>? = null
            private var contentDisclosure: JsonField<ContentDisclosure> = JsonMissing.of()
            private var article: JsonField<SearchTweet.Article> = JsonMissing.of()
            private var authorUnavailable: JsonField<SearchTweet.AuthorUnavailable> =
                JsonMissing.of()
            private var unavailableAuthorId: JsonField<String> = JsonMissing.of()
            private var card: JsonField<Event.Data.Card> = JsonMissing.of()
            private var cashtagAttachments: JsonField<MutableList<SearchTweet.CashtagAttachment>>? =
                null
            private var communityId: JsonField<String> = JsonMissing.of()
            private var communityName: JsonField<String> = JsonMissing.of()
            private var communityNote: JsonField<SearchTweet.CommunityNote> = JsonMissing.of()
            private var hasCommunityNotes: JsonField<Boolean> = JsonMissing.of()
            private var edit: JsonField<SearchTweet.Edit> = JsonMissing.of()
            private var exclusiveContent: JsonField<SearchTweet.ExclusiveContent> = JsonMissing.of()
            private var isTranslatable: JsonField<Boolean> = JsonMissing.of()
            private var grokShareAttachment: JsonField<SearchTweet.GrokShareAttachment> =
                JsonMissing.of()
            private var grokTranslatedPost: JsonField<SearchTweet.GrokTranslatedPost> =
                JsonMissing.of()
            private var jetfuelAttachment: JsonField<SearchTweet.JetfuelAttachment> =
                JsonMissing.of()
            private var noteTweet: JsonField<SearchTweet.NoteTweet> = JsonMissing.of()
            private var place: JsonField<SearchTweet.Place> = JsonMissing.of()
            private var coordinates: JsonField<SearchTweet.Coordinates> = JsonMissing.of()
            private var geo: JsonField<SearchTweet.Geo> = JsonMissing.of()
            private var postCta: JsonField<SearchTweet.PostCta> = JsonMissing.of()
            private var possiblySensitive: JsonField<Boolean> = JsonMissing.of()
            private var previousCounts: JsonField<SearchTweet.PreviousCounts> = JsonMissing.of()
            private var reactionContext: JsonField<Event.Data.ReactionContext> = JsonMissing.of()
            private var sportsContext: JsonField<SearchTweet.SportsContext> = JsonMissing.of()
            private var subscriberBadge: JsonField<SearchTweet.SubscriberBadge> = JsonMissing.of()
            private var tombstone: JsonField<SearchTweet.Tombstone> = JsonMissing.of()
            private var interstitial: JsonField<SearchTweet.Interstitial> = JsonMissing.of()
            private var unmentionedUserIds: JsonField<MutableList<String>>? = null
            private var viewState: JsonField<String> = JsonMissing.of()
            private var entities: JsonField<SearchTweet.Entities> = JsonMissing.of()
            private var scopes: JsonField<SearchTweet.Scopes> = JsonMissing.of()
            private var softIntervention: JsonField<SoftIntervention> = JsonMissing.of()
            private var media: JsonField<MutableList<TweetMedia>>? = null
            private var retweetCount: JsonField<Long> = JsonMissing.of()
            private var replyCount: JsonField<Long> = JsonMissing.of()
            private var likeCount: JsonField<Long> = JsonMissing.of()
            private var quoteCount: JsonField<Long> = JsonMissing.of()
            private var viewCount: JsonField<Long> = JsonMissing.of()
            private var bookmarkCount: JsonField<Long> = JsonMissing.of()
            private var unknownCounts: JsonField<MutableList<UnknownCount>>? = null
            private var parentTweet: JsonField<EmbeddedTweet> = JsonMissing.of()
            private var quotedTweet: JsonField<EmbeddedTweet> = JsonMissing.of()
            private var retweetedTweet: JsonField<EmbeddedTweet> = JsonMissing.of()
            private var author: JsonField<Event.Data.Author> = JsonMissing.of()
            private var field: JsonField<String> = JsonMissing.of()
            private var change: JsonField<Long> = JsonMissing.of()
            private var userId: JsonField<String> = JsonMissing.of()
            private var username: JsonField<String> = JsonMissing.of()
            private var previous: JsonField<Event.Data.ProfileValue> = JsonMissing.of()
            private var current: JsonField<Event.Data.ProfileValue> = JsonMissing.of()
            private var followedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var followedAtExact: JsonField<Boolean> = JsonMissing.of()
            private var reason: JsonField<Reason> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                id = data.id
                text = data.text
                type = data.type
                createdAt = data.createdAt
                url = data.url
                lang = data.lang
                isReply = data.isReply
                isLimitedReply = data.isLimitedReply
                isNoteTweet = data.isNoteTweet
                isPinned = data.isPinned
                isQuoteStatus = data.isQuoteStatus
                isRetweet = data.isRetweet
                quotedTweetId = data.quotedTweetId
                quotedTweetPermalink = data.quotedTweetPermalink
                quotedTweetUnavailable = data.quotedTweetUnavailable
                retweetedAt = data.retweetedAt
                inReplyToId = data.inReplyToId
                inReplyToUserId = data.inReplyToUserId
                inReplyToUsername = data.inReplyToUsername
                conversationId = data.conversationId
                conversationControl = data.conversationControl
                limitedActions = data.limitedActions.map { it.toMutableList() }
                source = data.source
                displayTextRange = data.displayTextRange.map { it.toMutableList() }
                textHighlights = data.textHighlights.map { it.toMutableList() }
                contentDisclosure = data.contentDisclosure
                article = data.article
                authorUnavailable = data.authorUnavailable
                unavailableAuthorId = data.unavailableAuthorId
                card = data.card
                cashtagAttachments = data.cashtagAttachments.map { it.toMutableList() }
                communityId = data.communityId
                communityName = data.communityName
                communityNote = data.communityNote
                hasCommunityNotes = data.hasCommunityNotes
                edit = data.edit
                exclusiveContent = data.exclusiveContent
                isTranslatable = data.isTranslatable
                grokShareAttachment = data.grokShareAttachment
                grokTranslatedPost = data.grokTranslatedPost
                jetfuelAttachment = data.jetfuelAttachment
                noteTweet = data.noteTweet
                place = data.place
                coordinates = data.coordinates
                geo = data.geo
                postCta = data.postCta
                possiblySensitive = data.possiblySensitive
                previousCounts = data.previousCounts
                reactionContext = data.reactionContext
                sportsContext = data.sportsContext
                subscriberBadge = data.subscriberBadge
                tombstone = data.tombstone
                interstitial = data.interstitial
                unmentionedUserIds = data.unmentionedUserIds.map { it.toMutableList() }
                viewState = data.viewState
                entities = data.entities
                scopes = data.scopes
                softIntervention = data.softIntervention
                media = data.media.map { it.toMutableList() }
                retweetCount = data.retweetCount
                replyCount = data.replyCount
                likeCount = data.likeCount
                quoteCount = data.quoteCount
                viewCount = data.viewCount
                bookmarkCount = data.bookmarkCount
                unknownCounts = data.unknownCounts.map { it.toMutableList() }
                parentTweet = data.parentTweet
                quotedTweet = data.quotedTweet
                retweetedTweet = data.retweetedTweet
                author = data.author
                field = data.field
                change = data.change
                userId = data.userId
                username = data.username
                previous = data.previous
                current = data.current
                followedAt = data.followedAt
                followedAtExact = data.followedAtExact
                reason = data.reason
                additionalProperties = data.additionalProperties.toMutableMap()
            }

            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun text(text: String) = text(JsonField.of(text))

            /** Sets [Builder.text] to an arbitrary JSON value. */
            fun text(text: JsonField<String>) = apply { this.text = text }

            fun type(type: String) = type(JsonField.of(type))

            /** Sets [Builder.type] to an arbitrary JSON value. */
            fun type(type: JsonField<String>) = apply { this.type = type }

            fun createdAt(createdAt: String) = createdAt(JsonField.of(createdAt))

            /** Sets [Builder.createdAt] to an arbitrary JSON value. */
            fun createdAt(createdAt: JsonField<String>) = apply { this.createdAt = createdAt }

            fun url(url: String) = url(JsonField.of(url))

            /** Sets [Builder.url] to an arbitrary JSON value. */
            fun url(url: JsonField<String>) = apply { this.url = url }

            fun lang(lang: String) = lang(JsonField.of(lang))

            /** Sets [Builder.lang] to an arbitrary JSON value. */
            fun lang(lang: JsonField<String>) = apply { this.lang = lang }

            fun isReply(isReply: Boolean) = isReply(JsonField.of(isReply))

            /** Sets [Builder.isReply] to an arbitrary JSON value. */
            fun isReply(isReply: JsonField<Boolean>) = apply { this.isReply = isReply }

            fun isLimitedReply(isLimitedReply: Boolean) =
                isLimitedReply(JsonField.of(isLimitedReply))

            /** Sets [Builder.isLimitedReply] to an arbitrary JSON value. */
            fun isLimitedReply(isLimitedReply: JsonField<Boolean>) = apply {
                this.isLimitedReply = isLimitedReply
            }

            fun isNoteTweet(isNoteTweet: Boolean) = isNoteTweet(JsonField.of(isNoteTweet))

            /** Sets [Builder.isNoteTweet] to an arbitrary JSON value. */
            fun isNoteTweet(isNoteTweet: JsonField<Boolean>) = apply {
                this.isNoteTweet = isNoteTweet
            }

            fun isPinned(isPinned: Boolean) = isPinned(JsonField.of(isPinned))

            /** Sets [Builder.isPinned] to an arbitrary JSON value. */
            fun isPinned(isPinned: JsonField<Boolean>) = apply { this.isPinned = isPinned }

            fun isQuoteStatus(isQuoteStatus: Boolean) = isQuoteStatus(JsonField.of(isQuoteStatus))

            /** Sets [Builder.isQuoteStatus] to an arbitrary JSON value. */
            fun isQuoteStatus(isQuoteStatus: JsonField<Boolean>) = apply {
                this.isQuoteStatus = isQuoteStatus
            }

            fun isRetweet(isRetweet: Boolean) = isRetweet(JsonField.of(isRetweet))

            /** Sets [Builder.isRetweet] to an arbitrary JSON value. */
            fun isRetweet(isRetweet: JsonField<Boolean>) = apply { this.isRetweet = isRetweet }

            fun quotedTweetId(quotedTweetId: String) = quotedTweetId(JsonField.of(quotedTweetId))

            /** Sets [Builder.quotedTweetId] to an arbitrary JSON value. */
            fun quotedTweetId(quotedTweetId: JsonField<String>) = apply {
                this.quotedTweetId = quotedTweetId
            }

            fun quotedTweetPermalink(quotedTweetPermalink: SearchTweet.QuotedTweetPermalink) =
                quotedTweetPermalink(JsonField.of(quotedTweetPermalink))

            /** Sets [Builder.quotedTweetPermalink] to an arbitrary JSON value. */
            fun quotedTweetPermalink(
                quotedTweetPermalink: JsonField<SearchTweet.QuotedTweetPermalink>
            ) = apply { this.quotedTweetPermalink = quotedTweetPermalink }

            fun quotedTweetUnavailable(quotedTweetUnavailable: SearchTweet.QuotedTweetUnavailable) =
                quotedTweetUnavailable(JsonField.of(quotedTweetUnavailable))

            /** Sets [Builder.quotedTweetUnavailable] to an arbitrary JSON value. */
            fun quotedTweetUnavailable(
                quotedTweetUnavailable: JsonField<SearchTweet.QuotedTweetUnavailable>
            ) = apply { this.quotedTweetUnavailable = quotedTweetUnavailable }

            fun retweetedAt(retweetedAt: OffsetDateTime?) =
                retweetedAt(JsonField.ofNullable(retweetedAt))

            /** Alias for calling [Builder.retweetedAt] with `retweetedAt.orElse(null)`. */
            fun retweetedAt(retweetedAt: Optional<OffsetDateTime>) =
                retweetedAt(retweetedAt.getOrNull())

            /** Sets [Builder.retweetedAt] to an arbitrary JSON value. */
            fun retweetedAt(retweetedAt: JsonField<OffsetDateTime>) = apply {
                this.retweetedAt = retweetedAt
            }

            fun inReplyToId(inReplyToId: String) = inReplyToId(JsonField.of(inReplyToId))

            /** Sets [Builder.inReplyToId] to an arbitrary JSON value. */
            fun inReplyToId(inReplyToId: JsonField<String>) = apply {
                this.inReplyToId = inReplyToId
            }

            fun inReplyToUserId(inReplyToUserId: String) =
                inReplyToUserId(JsonField.of(inReplyToUserId))

            /** Sets [Builder.inReplyToUserId] to an arbitrary JSON value. */
            fun inReplyToUserId(inReplyToUserId: JsonField<String>) = apply {
                this.inReplyToUserId = inReplyToUserId
            }

            fun inReplyToUsername(inReplyToUsername: String) =
                inReplyToUsername(JsonField.of(inReplyToUsername))

            /** Sets [Builder.inReplyToUsername] to an arbitrary JSON value. */
            fun inReplyToUsername(inReplyToUsername: JsonField<String>) = apply {
                this.inReplyToUsername = inReplyToUsername
            }

            fun conversationId(conversationId: String) =
                conversationId(JsonField.of(conversationId))

            /** Sets [Builder.conversationId] to an arbitrary JSON value. */
            fun conversationId(conversationId: JsonField<String>) = apply {
                this.conversationId = conversationId
            }

            fun conversationControl(conversationControl: SearchTweet.ConversationControl) =
                conversationControl(JsonField.of(conversationControl))

            /** Sets [Builder.conversationControl] to an arbitrary JSON value. */
            fun conversationControl(
                conversationControl: JsonField<SearchTweet.ConversationControl>
            ) = apply { this.conversationControl = conversationControl }

            fun limitedActions(limitedActions: List<SearchTweet.LimitedAction>) =
                limitedActions(JsonField.of(limitedActions))

            /** Sets [Builder.limitedActions] to an arbitrary JSON value. */
            fun limitedActions(limitedActions: JsonField<List<SearchTweet.LimitedAction>>) = apply {
                this.limitedActions = limitedActions.map { it.toMutableList() }
            }

            /**
             * Adds a single [SearchTweet.LimitedAction] to [limitedActions].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLimitedAction(limitedAction: SearchTweet.LimitedAction) = apply {
                this.limitedActions =
                    (this.limitedActions ?: JsonField.of(mutableListOf())).also {
                        checkKnown("limitedActions", it).add(limitedAction)
                    }
            }

            fun source(source: String) = source(JsonField.of(source))

            /** Sets [Builder.source] to an arbitrary JSON value. */
            fun source(source: JsonField<String>) = apply { this.source = source }

            fun displayTextRange(displayTextRange: List<Long>) =
                displayTextRange(JsonField.of(displayTextRange))

            /** Sets [Builder.displayTextRange] to an arbitrary JSON value. */
            fun displayTextRange(displayTextRange: JsonField<List<Long>>) = apply {
                this.displayTextRange = displayTextRange.map { it.toMutableList() }
            }

            /**
             * Adds a single [Long] to [displayTextRange].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addDisplayTextRange(displayTextRange: Long) = apply {
                this.displayTextRange =
                    (this.displayTextRange ?: JsonField.of(mutableListOf())).also {
                        checkKnown("displayTextRange", it).add(displayTextRange)
                    }
            }

            fun textHighlights(textHighlights: List<SearchTweet.TextHighlight>) =
                textHighlights(JsonField.of(textHighlights))

            /** Sets [Builder.textHighlights] to an arbitrary JSON value. */
            fun textHighlights(textHighlights: JsonField<List<SearchTweet.TextHighlight>>) = apply {
                this.textHighlights = textHighlights.map { it.toMutableList() }
            }

            /**
             * Adds a single [SearchTweet.TextHighlight] to [textHighlights].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTextHighlight(textHighlight: SearchTweet.TextHighlight) = apply {
                this.textHighlights =
                    (this.textHighlights ?: JsonField.of(mutableListOf())).also {
                        checkKnown("textHighlights", it).add(textHighlight)
                    }
            }

            fun contentDisclosure(contentDisclosure: ContentDisclosure) =
                contentDisclosure(JsonField.of(contentDisclosure))

            /** Sets [Builder.contentDisclosure] to an arbitrary JSON value. */
            fun contentDisclosure(contentDisclosure: JsonField<ContentDisclosure>) = apply {
                this.contentDisclosure = contentDisclosure
            }

            fun article(article: SearchTweet.Article) = article(JsonField.of(article))

            /** Sets [Builder.article] to an arbitrary JSON value. */
            fun article(article: JsonField<SearchTweet.Article>) = apply { this.article = article }

            fun authorUnavailable(authorUnavailable: SearchTweet.AuthorUnavailable) =
                authorUnavailable(JsonField.of(authorUnavailable))

            /** Sets [Builder.authorUnavailable] to an arbitrary JSON value. */
            fun authorUnavailable(authorUnavailable: JsonField<SearchTweet.AuthorUnavailable>) =
                apply {
                    this.authorUnavailable = authorUnavailable
                }

            fun unavailableAuthorId(unavailableAuthorId: String) =
                unavailableAuthorId(JsonField.of(unavailableAuthorId))

            /** Sets [Builder.unavailableAuthorId] to an arbitrary JSON value. */
            fun unavailableAuthorId(unavailableAuthorId: JsonField<String>) = apply {
                this.unavailableAuthorId = unavailableAuthorId
            }

            fun card(card: Event.Data.Card) = card(JsonField.of(card))

            /** Sets [Builder.card] to an arbitrary JSON value. */
            fun card(card: JsonField<Event.Data.Card>) = apply { this.card = card }

            fun cashtagAttachments(cashtagAttachments: List<SearchTweet.CashtagAttachment>) =
                cashtagAttachments(JsonField.of(cashtagAttachments))

            /** Sets [Builder.cashtagAttachments] to an arbitrary JSON value. */
            fun cashtagAttachments(
                cashtagAttachments: JsonField<List<SearchTweet.CashtagAttachment>>
            ) = apply { this.cashtagAttachments = cashtagAttachments.map { it.toMutableList() } }

            /**
             * Adds a single [SearchTweet.CashtagAttachment] to [cashtagAttachments].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addCashtagAttachment(cashtagAttachment: SearchTweet.CashtagAttachment) = apply {
                this.cashtagAttachments =
                    (this.cashtagAttachments ?: JsonField.of(mutableListOf())).also {
                        checkKnown("cashtagAttachments", it).add(cashtagAttachment)
                    }
            }

            fun communityId(communityId: String) = communityId(JsonField.of(communityId))

            /** Sets [Builder.communityId] to an arbitrary JSON value. */
            fun communityId(communityId: JsonField<String>) = apply {
                this.communityId = communityId
            }

            fun communityName(communityName: String) = communityName(JsonField.of(communityName))

            /** Sets [Builder.communityName] to an arbitrary JSON value. */
            fun communityName(communityName: JsonField<String>) = apply {
                this.communityName = communityName
            }

            fun communityNote(communityNote: SearchTweet.CommunityNote) =
                communityNote(JsonField.of(communityNote))

            /** Sets [Builder.communityNote] to an arbitrary JSON value. */
            fun communityNote(communityNote: JsonField<SearchTweet.CommunityNote>) = apply {
                this.communityNote = communityNote
            }

            fun hasCommunityNotes(hasCommunityNotes: Boolean) =
                hasCommunityNotes(JsonField.of(hasCommunityNotes))

            /** Sets [Builder.hasCommunityNotes] to an arbitrary JSON value. */
            fun hasCommunityNotes(hasCommunityNotes: JsonField<Boolean>) = apply {
                this.hasCommunityNotes = hasCommunityNotes
            }

            fun edit(edit: SearchTweet.Edit) = edit(JsonField.of(edit))

            /** Sets [Builder.edit] to an arbitrary JSON value. */
            fun edit(edit: JsonField<SearchTweet.Edit>) = apply { this.edit = edit }

            fun exclusiveContent(exclusiveContent: SearchTweet.ExclusiveContent) =
                exclusiveContent(JsonField.of(exclusiveContent))

            /** Sets [Builder.exclusiveContent] to an arbitrary JSON value. */
            fun exclusiveContent(exclusiveContent: JsonField<SearchTweet.ExclusiveContent>) =
                apply {
                    this.exclusiveContent = exclusiveContent
                }

            fun isTranslatable(isTranslatable: Boolean) =
                isTranslatable(JsonField.of(isTranslatable))

            /** Sets [Builder.isTranslatable] to an arbitrary JSON value. */
            fun isTranslatable(isTranslatable: JsonField<Boolean>) = apply {
                this.isTranslatable = isTranslatable
            }

            fun grokShareAttachment(grokShareAttachment: SearchTweet.GrokShareAttachment) =
                grokShareAttachment(JsonField.of(grokShareAttachment))

            /** Sets [Builder.grokShareAttachment] to an arbitrary JSON value. */
            fun grokShareAttachment(
                grokShareAttachment: JsonField<SearchTweet.GrokShareAttachment>
            ) = apply { this.grokShareAttachment = grokShareAttachment }

            fun grokTranslatedPost(grokTranslatedPost: SearchTweet.GrokTranslatedPost) =
                grokTranslatedPost(JsonField.of(grokTranslatedPost))

            /** Sets [Builder.grokTranslatedPost] to an arbitrary JSON value. */
            fun grokTranslatedPost(grokTranslatedPost: JsonField<SearchTweet.GrokTranslatedPost>) =
                apply {
                    this.grokTranslatedPost = grokTranslatedPost
                }

            fun jetfuelAttachment(jetfuelAttachment: SearchTweet.JetfuelAttachment) =
                jetfuelAttachment(JsonField.of(jetfuelAttachment))

            /** Sets [Builder.jetfuelAttachment] to an arbitrary JSON value. */
            fun jetfuelAttachment(jetfuelAttachment: JsonField<SearchTweet.JetfuelAttachment>) =
                apply {
                    this.jetfuelAttachment = jetfuelAttachment
                }

            fun noteTweet(noteTweet: SearchTweet.NoteTweet) = noteTweet(JsonField.of(noteTweet))

            /** Sets [Builder.noteTweet] to an arbitrary JSON value. */
            fun noteTweet(noteTweet: JsonField<SearchTweet.NoteTweet>) = apply {
                this.noteTweet = noteTweet
            }

            fun place(place: SearchTweet.Place) = place(JsonField.of(place))

            /** Sets [Builder.place] to an arbitrary JSON value. */
            fun place(place: JsonField<SearchTweet.Place>) = apply { this.place = place }

            fun coordinates(coordinates: SearchTweet.Coordinates) =
                coordinates(JsonField.of(coordinates))

            /** Sets [Builder.coordinates] to an arbitrary JSON value. */
            fun coordinates(coordinates: JsonField<SearchTweet.Coordinates>) = apply {
                this.coordinates = coordinates
            }

            fun geo(geo: SearchTweet.Geo) = geo(JsonField.of(geo))

            /** Sets [Builder.geo] to an arbitrary JSON value. */
            fun geo(geo: JsonField<SearchTweet.Geo>) = apply { this.geo = geo }

            fun postCta(postCta: SearchTweet.PostCta) = postCta(JsonField.of(postCta))

            /** Sets [Builder.postCta] to an arbitrary JSON value. */
            fun postCta(postCta: JsonField<SearchTweet.PostCta>) = apply { this.postCta = postCta }

            fun possiblySensitive(possiblySensitive: Boolean) =
                possiblySensitive(JsonField.of(possiblySensitive))

            /** Sets [Builder.possiblySensitive] to an arbitrary JSON value. */
            fun possiblySensitive(possiblySensitive: JsonField<Boolean>) = apply {
                this.possiblySensitive = possiblySensitive
            }

            fun previousCounts(previousCounts: SearchTweet.PreviousCounts) =
                previousCounts(JsonField.of(previousCounts))

            /** Sets [Builder.previousCounts] to an arbitrary JSON value. */
            fun previousCounts(previousCounts: JsonField<SearchTweet.PreviousCounts>) = apply {
                this.previousCounts = previousCounts
            }

            fun reactionContext(reactionContext: Event.Data.ReactionContext) =
                reactionContext(JsonField.of(reactionContext))

            /** Sets [Builder.reactionContext] to an arbitrary JSON value. */
            fun reactionContext(reactionContext: JsonField<Event.Data.ReactionContext>) = apply {
                this.reactionContext = reactionContext
            }

            fun sportsContext(sportsContext: SearchTweet.SportsContext) =
                sportsContext(JsonField.of(sportsContext))

            /** Sets [Builder.sportsContext] to an arbitrary JSON value. */
            fun sportsContext(sportsContext: JsonField<SearchTweet.SportsContext>) = apply {
                this.sportsContext = sportsContext
            }

            fun subscriberBadge(subscriberBadge: SearchTweet.SubscriberBadge) =
                subscriberBadge(JsonField.of(subscriberBadge))

            /** Sets [Builder.subscriberBadge] to an arbitrary JSON value. */
            fun subscriberBadge(subscriberBadge: JsonField<SearchTweet.SubscriberBadge>) = apply {
                this.subscriberBadge = subscriberBadge
            }

            fun tombstone(tombstone: SearchTweet.Tombstone) = tombstone(JsonField.of(tombstone))

            /** Sets [Builder.tombstone] to an arbitrary JSON value. */
            fun tombstone(tombstone: JsonField<SearchTweet.Tombstone>) = apply {
                this.tombstone = tombstone
            }

            fun interstitial(interstitial: SearchTweet.Interstitial) =
                interstitial(JsonField.of(interstitial))

            /** Sets [Builder.interstitial] to an arbitrary JSON value. */
            fun interstitial(interstitial: JsonField<SearchTweet.Interstitial>) = apply {
                this.interstitial = interstitial
            }

            fun unmentionedUserIds(unmentionedUserIds: List<String>) =
                unmentionedUserIds(JsonField.of(unmentionedUserIds))

            /** Sets [Builder.unmentionedUserIds] to an arbitrary JSON value. */
            fun unmentionedUserIds(unmentionedUserIds: JsonField<List<String>>) = apply {
                this.unmentionedUserIds = unmentionedUserIds.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [unmentionedUserIds].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addUnmentionedUserId(unmentionedUserId: String) = apply {
                this.unmentionedUserIds =
                    (this.unmentionedUserIds ?: JsonField.of(mutableListOf())).also {
                        checkKnown("unmentionedUserIds", it).add(unmentionedUserId)
                    }
            }

            fun viewState(viewState: String) = viewState(JsonField.of(viewState))

            /** Sets [Builder.viewState] to an arbitrary JSON value. */
            fun viewState(viewState: JsonField<String>) = apply { this.viewState = viewState }

            fun entities(entities: SearchTweet.Entities) = entities(JsonField.of(entities))

            /** Sets [Builder.entities] to an arbitrary JSON value. */
            fun entities(entities: JsonField<SearchTweet.Entities>) = apply {
                this.entities = entities
            }

            fun scopes(scopes: SearchTweet.Scopes) = scopes(JsonField.of(scopes))

            /** Sets [Builder.scopes] to an arbitrary JSON value. */
            fun scopes(scopes: JsonField<SearchTweet.Scopes>) = apply { this.scopes = scopes }

            /**
             * The label X shows under a post whose reach it limits. It links to the page that
             * explains it.
             */
            fun softIntervention(softIntervention: SoftIntervention) =
                softIntervention(JsonField.of(softIntervention))

            /** Sets [Builder.softIntervention] to an arbitrary JSON value. */
            fun softIntervention(softIntervention: JsonField<SoftIntervention>) = apply {
                this.softIntervention = softIntervention
            }

            fun media(media: List<TweetMedia>) = media(JsonField.of(media))

            /** Sets [Builder.media] to an arbitrary JSON value. */
            fun media(media: JsonField<List<TweetMedia>>) = apply {
                this.media = media.map { it.toMutableList() }
            }

            /**
             * Adds a single [TweetMedia] to [media].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addMedia(media: TweetMedia) = apply {
                this.media =
                    (this.media ?: JsonField.of(mutableListOf())).also {
                        checkKnown("media", it).add(media)
                    }
            }

            fun retweetCount(retweetCount: Long) = retweetCount(JsonField.of(retweetCount))

            /** Sets [Builder.retweetCount] to an arbitrary JSON value. */
            fun retweetCount(retweetCount: JsonField<Long>) = apply {
                this.retweetCount = retweetCount
            }

            fun replyCount(replyCount: Long) = replyCount(JsonField.of(replyCount))

            /** Sets [Builder.replyCount] to an arbitrary JSON value. */
            fun replyCount(replyCount: JsonField<Long>) = apply { this.replyCount = replyCount }

            fun likeCount(likeCount: Long) = likeCount(JsonField.of(likeCount))

            /** Sets [Builder.likeCount] to an arbitrary JSON value. */
            fun likeCount(likeCount: JsonField<Long>) = apply { this.likeCount = likeCount }

            fun quoteCount(quoteCount: Long) = quoteCount(JsonField.of(quoteCount))

            /** Sets [Builder.quoteCount] to an arbitrary JSON value. */
            fun quoteCount(quoteCount: JsonField<Long>) = apply { this.quoteCount = quoteCount }

            fun viewCount(viewCount: Long) = viewCount(JsonField.of(viewCount))

            /** Sets [Builder.viewCount] to an arbitrary JSON value. */
            fun viewCount(viewCount: JsonField<Long>) = apply { this.viewCount = viewCount }

            fun bookmarkCount(bookmarkCount: Long) = bookmarkCount(JsonField.of(bookmarkCount))

            /** Sets [Builder.bookmarkCount] to an arbitrary JSON value. */
            fun bookmarkCount(bookmarkCount: JsonField<Long>) = apply {
                this.bookmarkCount = bookmarkCount
            }

            /** X did not send these counts, so each 0 means unknown. */
            fun unknownCounts(unknownCounts: List<UnknownCount>) =
                unknownCounts(JsonField.of(unknownCounts))

            /** Sets [Builder.unknownCounts] to an arbitrary JSON value. */
            fun unknownCounts(unknownCounts: JsonField<List<UnknownCount>>) = apply {
                this.unknownCounts = unknownCounts.map { it.toMutableList() }
            }

            /**
             * Adds a single [UnknownCount] to [unknownCounts].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addUnknownCount(unknownCount: UnknownCount) = apply {
                unknownCounts =
                    (unknownCounts ?: JsonField.of(mutableListOf())).also {
                        checkKnown("unknownCounts", it).add(unknownCount)
                    }
            }

            fun parentTweet(parentTweet: EmbeddedTweet) = parentTweet(JsonField.of(parentTweet))

            /** Sets [Builder.parentTweet] to an arbitrary JSON value. */
            fun parentTweet(parentTweet: JsonField<EmbeddedTweet>) = apply {
                this.parentTweet = parentTweet
            }

            fun quotedTweet(quotedTweet: EmbeddedTweet?) =
                quotedTweet(JsonField.ofNullable(quotedTweet))

            /** Alias for calling [Builder.quotedTweet] with `quotedTweet.orElse(null)`. */
            fun quotedTweet(quotedTweet: Optional<EmbeddedTweet>) =
                quotedTweet(quotedTweet.getOrNull())

            /** Sets [Builder.quotedTweet] to an arbitrary JSON value. */
            fun quotedTweet(quotedTweet: JsonField<EmbeddedTweet>) = apply {
                this.quotedTweet = quotedTweet
            }

            fun retweetedTweet(retweetedTweet: EmbeddedTweet?) =
                retweetedTweet(JsonField.ofNullable(retweetedTweet))

            /** Alias for calling [Builder.retweetedTweet] with `retweetedTweet.orElse(null)`. */
            fun retweetedTweet(retweetedTweet: Optional<EmbeddedTweet>) =
                retweetedTweet(retweetedTweet.getOrNull())

            /** Sets [Builder.retweetedTweet] to an arbitrary JSON value. */
            fun retweetedTweet(retweetedTweet: JsonField<EmbeddedTweet>) = apply {
                this.retweetedTweet = retweetedTweet
            }

            fun author(author: Event.Data.Author?) = author(JsonField.ofNullable(author))

            /** Alias for calling [Builder.author] with `author.orElse(null)`. */
            fun author(author: Optional<Event.Data.Author>) = author(author.getOrNull())

            /** Sets [Builder.author] to an arbitrary JSON value. */
            fun author(author: JsonField<Event.Data.Author>) = apply { this.author = author }

            fun field(field: String) = field(JsonField.of(field))

            /** Sets [Builder.field] to an arbitrary JSON value. */
            fun field(field: JsonField<String>) = apply { this.field = field }

            fun change(change: Long) = change(JsonField.of(change))

            /** Sets [Builder.change] to an arbitrary JSON value. */
            fun change(change: JsonField<Long>) = apply { this.change = change }

            fun userId(userId: String) = userId(JsonField.of(userId))

            /** Sets [Builder.userId] to an arbitrary JSON value. */
            fun userId(userId: JsonField<String>) = apply { this.userId = userId }

            fun username(username: String) = username(JsonField.of(username))

            /** Sets [Builder.username] to an arbitrary JSON value. */
            fun username(username: JsonField<String>) = apply { this.username = username }

            fun previous(previous: Event.Data.ProfileValue) = previous(JsonField.of(previous))

            /** Sets [Builder.previous] to an arbitrary JSON value. */
            fun previous(previous: JsonField<Event.Data.ProfileValue>) = apply {
                this.previous = previous
            }

            /** Alias for calling [previous] with `Event.Data.ProfileValue.ofString(string)`. */
            fun previous(string: String) = previous(Event.Data.ProfileValue.ofString(string))

            /** Alias for calling [previous] with `Event.Data.ProfileValue.ofBoolean(boolean)`. */
            fun previous(boolean: Boolean) = previous(Event.Data.ProfileValue.ofBoolean(boolean))

            /** Alias for calling [previous] with `Event.Data.ProfileValue.ofLong(long)`. */
            fun previous(long: Long) = previous(Event.Data.ProfileValue.ofLong(long))

            /** Alias for calling [previous] with `Event.Data.ProfileValue.ofStrings(strings)`. */
            fun previous(strings: List<String>) =
                previous(Event.Data.ProfileValue.ofStrings(strings))

            fun current(current: Event.Data.ProfileValue) = current(JsonField.of(current))

            /** Sets [Builder.current] to an arbitrary JSON value. */
            fun current(current: JsonField<Event.Data.ProfileValue>) = apply {
                this.current = current
            }

            /** Alias for calling [current] with `Event.Data.ProfileValue.ofString(string)`. */
            fun current(string: String) = current(Event.Data.ProfileValue.ofString(string))

            /** Alias for calling [current] with `Event.Data.ProfileValue.ofBoolean(boolean)`. */
            fun current(boolean: Boolean) = current(Event.Data.ProfileValue.ofBoolean(boolean))

            /** Alias for calling [current] with `Event.Data.ProfileValue.ofLong(long)`. */
            fun current(long: Long) = current(Event.Data.ProfileValue.ofLong(long))

            /** Alias for calling [current] with `Event.Data.ProfileValue.ofStrings(strings)`. */
            fun current(strings: List<String>) = current(Event.Data.ProfileValue.ofStrings(strings))

            fun followedAt(followedAt: OffsetDateTime) = followedAt(JsonField.of(followedAt))

            /** Sets [Builder.followedAt] to an arbitrary JSON value. */
            fun followedAt(followedAt: JsonField<OffsetDateTime>) = apply {
                this.followedAt = followedAt
            }

            fun followedAtExact(followedAtExact: Boolean) =
                followedAtExact(JsonField.of(followedAtExact))

            /** Sets [Builder.followedAtExact] to an arbitrary JSON value. */
            fun followedAtExact(followedAtExact: JsonField<Boolean>) = apply {
                this.followedAtExact = followedAtExact
            }

            fun reason(reason: Reason) = reason(JsonField.of(reason))

            /** Sets [Builder.reason] to an arbitrary JSON value. */
            fun reason(reason: JsonField<Reason>) = apply { this.reason = reason }

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
             * Returns an immutable instance of [Data].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Data =
                Data(
                    id,
                    text,
                    type,
                    createdAt,
                    url,
                    lang,
                    isReply,
                    isLimitedReply,
                    isNoteTweet,
                    isPinned,
                    isQuoteStatus,
                    isRetweet,
                    quotedTweetId,
                    quotedTweetPermalink,
                    quotedTweetUnavailable,
                    retweetedAt,
                    inReplyToId,
                    inReplyToUserId,
                    inReplyToUsername,
                    conversationId,
                    conversationControl,
                    (limitedActions ?: JsonMissing.of()).map { it.toImmutable() },
                    source,
                    (displayTextRange ?: JsonMissing.of()).map { it.toImmutable() },
                    (textHighlights ?: JsonMissing.of()).map { it.toImmutable() },
                    contentDisclosure,
                    article,
                    authorUnavailable,
                    unavailableAuthorId,
                    card,
                    (cashtagAttachments ?: JsonMissing.of()).map { it.toImmutable() },
                    communityId,
                    communityName,
                    communityNote,
                    hasCommunityNotes,
                    edit,
                    exclusiveContent,
                    isTranslatable,
                    grokShareAttachment,
                    grokTranslatedPost,
                    jetfuelAttachment,
                    noteTweet,
                    place,
                    coordinates,
                    geo,
                    postCta,
                    possiblySensitive,
                    previousCounts,
                    reactionContext,
                    sportsContext,
                    subscriberBadge,
                    tombstone,
                    interstitial,
                    (unmentionedUserIds ?: JsonMissing.of()).map { it.toImmutable() },
                    viewState,
                    entities,
                    scopes,
                    softIntervention,
                    (media ?: JsonMissing.of()).map { it.toImmutable() },
                    retweetCount,
                    replyCount,
                    likeCount,
                    quoteCount,
                    viewCount,
                    bookmarkCount,
                    (unknownCounts ?: JsonMissing.of()).map { it.toImmutable() },
                    parentTweet,
                    quotedTweet,
                    retweetedTweet,
                    author,
                    field,
                    change,
                    userId,
                    username,
                    previous,
                    current,
                    followedAt,
                    followedAtExact,
                    reason,
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
        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }
            id()
            text()
            type()
            createdAt()
            url()
            lang()
            isReply()
            isLimitedReply()
            isNoteTweet()
            isPinned()
            isQuoteStatus()
            isRetweet()
            quotedTweetId()
            quotedTweetPermalink().ifPresent { it.validate() }
            quotedTweetUnavailable().ifPresent { it.validate() }
            retweetedAt()
            inReplyToId()
            inReplyToUserId()
            inReplyToUsername()
            conversationId()
            conversationControl().ifPresent { it.validate() }
            limitedActions().ifPresent { it.forEach { it.validate() } }
            source()
            displayTextRange()
            textHighlights().ifPresent { it.forEach { it.validate() } }
            contentDisclosure().ifPresent { it.validate() }
            article().ifPresent { it.validate() }
            authorUnavailable().ifPresent { it.validate() }
            unavailableAuthorId()
            card().ifPresent { it.validate() }
            cashtagAttachments().ifPresent { it.forEach { it.validate() } }
            communityId()
            communityName()
            communityNote().ifPresent { it.validate() }
            hasCommunityNotes()
            edit().ifPresent { it.validate() }
            exclusiveContent().ifPresent { it.validate() }
            isTranslatable()
            grokShareAttachment().ifPresent { it.validate() }
            grokTranslatedPost().ifPresent { it.validate() }
            jetfuelAttachment().ifPresent { it.validate() }
            noteTweet().ifPresent { it.validate() }
            place().ifPresent { it.validate() }
            coordinates().ifPresent { it.validate() }
            geo().ifPresent { it.validate() }
            postCta().ifPresent { it.validate() }
            possiblySensitive()
            previousCounts().ifPresent { it.validate() }
            reactionContext().ifPresent { it.validate() }
            sportsContext().ifPresent { it.validate() }
            subscriberBadge().ifPresent { it.validate() }
            tombstone().ifPresent { it.validate() }
            interstitial().ifPresent { it.validate() }
            unmentionedUserIds()
            viewState()
            entities().ifPresent { it.validate() }
            scopes().ifPresent { it.validate() }
            softIntervention().ifPresent { it.validate() }
            media().ifPresent { it.forEach { it.validate() } }
            retweetCount()
            replyCount()
            likeCount()
            quoteCount()
            viewCount()
            bookmarkCount()
            unknownCounts().ifPresent { it.forEach { it.validate() } }
            parentTweet().ifPresent { it.validate() }
            quotedTweet().ifPresent { it.validate() }
            retweetedTweet().ifPresent { it.validate() }
            author().ifPresent { it.validate() }
            field()
            change()
            userId()
            username()
            previous().ifPresent { it.validate() }
            current().ifPresent { it.validate() }
            followedAt()
            followedAtExact()
            reason().ifPresent { it.validate() }
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
            (0) +
                (if (id.asKnown().isPresent) 1 else 0) +
                (if (text.asKnown().isPresent) 1 else 0) +
                (if (type.asKnown().isPresent) 1 else 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (url.asKnown().isPresent) 1 else 0) +
                (if (lang.asKnown().isPresent) 1 else 0) +
                (if (isReply.asKnown().isPresent) 1 else 0) +
                (if (isLimitedReply.asKnown().isPresent) 1 else 0) +
                (if (isNoteTweet.asKnown().isPresent) 1 else 0) +
                (if (isPinned.asKnown().isPresent) 1 else 0) +
                (if (isQuoteStatus.asKnown().isPresent) 1 else 0) +
                (if (isRetweet.asKnown().isPresent) 1 else 0) +
                (if (quotedTweetId.asKnown().isPresent) 1 else 0) +
                (quotedTweetPermalink.asKnown().getOrNull()?.validity() ?: 0) +
                (quotedTweetUnavailable.asKnown().getOrNull()?.validity() ?: 0) +
                (if (retweetedAt.asKnown().isPresent) 1 else 0) +
                (if (inReplyToId.asKnown().isPresent) 1 else 0) +
                (if (inReplyToUserId.asKnown().isPresent) 1 else 0) +
                (if (inReplyToUsername.asKnown().isPresent) 1 else 0) +
                (if (conversationId.asKnown().isPresent) 1 else 0) +
                (conversationControl.asKnown().getOrNull()?.validity() ?: 0) +
                (limitedActions.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (source.asKnown().isPresent) 1 else 0) +
                (if (displayTextRange.asKnown().isPresent) 1 else 0) +
                (textHighlights.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (contentDisclosure.asKnown().getOrNull()?.validity() ?: 0) +
                (article.asKnown().getOrNull()?.validity() ?: 0) +
                (authorUnavailable.asKnown().getOrNull()?.validity() ?: 0) +
                (if (unavailableAuthorId.asKnown().isPresent) 1 else 0) +
                (card.asKnown().getOrNull()?.validity() ?: 0) +
                (cashtagAttachments.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (communityId.asKnown().isPresent) 1 else 0) +
                (if (communityName.asKnown().isPresent) 1 else 0) +
                (communityNote.asKnown().getOrNull()?.validity() ?: 0) +
                (if (hasCommunityNotes.asKnown().isPresent) 1 else 0) +
                (edit.asKnown().getOrNull()?.validity() ?: 0) +
                (exclusiveContent.asKnown().getOrNull()?.validity() ?: 0) +
                (if (isTranslatable.asKnown().isPresent) 1 else 0) +
                (grokShareAttachment.asKnown().getOrNull()?.validity() ?: 0) +
                (grokTranslatedPost.asKnown().getOrNull()?.validity() ?: 0) +
                (jetfuelAttachment.asKnown().getOrNull()?.validity() ?: 0) +
                (noteTweet.asKnown().getOrNull()?.validity() ?: 0) +
                (place.asKnown().getOrNull()?.validity() ?: 0) +
                (coordinates.asKnown().getOrNull()?.validity() ?: 0) +
                (geo.asKnown().getOrNull()?.validity() ?: 0) +
                (postCta.asKnown().getOrNull()?.validity() ?: 0) +
                (if (possiblySensitive.asKnown().isPresent) 1 else 0) +
                (previousCounts.asKnown().getOrNull()?.validity() ?: 0) +
                (reactionContext.asKnown().getOrNull()?.validity() ?: 0) +
                (sportsContext.asKnown().getOrNull()?.validity() ?: 0) +
                (subscriberBadge.asKnown().getOrNull()?.validity() ?: 0) +
                (tombstone.asKnown().getOrNull()?.validity() ?: 0) +
                (interstitial.asKnown().getOrNull()?.validity() ?: 0) +
                (if (unmentionedUserIds.asKnown().isPresent) 1 else 0) +
                (if (viewState.asKnown().isPresent) 1 else 0) +
                (entities.asKnown().getOrNull()?.validity() ?: 0) +
                (scopes.asKnown().getOrNull()?.validity() ?: 0) +
                (softIntervention.asKnown().getOrNull()?.validity() ?: 0) +
                (media.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (retweetCount.asKnown().isPresent) 1 else 0) +
                (if (replyCount.asKnown().isPresent) 1 else 0) +
                (if (likeCount.asKnown().isPresent) 1 else 0) +
                (if (quoteCount.asKnown().isPresent) 1 else 0) +
                (if (viewCount.asKnown().isPresent) 1 else 0) +
                (if (bookmarkCount.asKnown().isPresent) 1 else 0) +
                (unknownCounts.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (parentTweet.asKnown().getOrNull()?.validity() ?: 0) +
                (quotedTweet.asKnown().getOrNull()?.validity() ?: 0) +
                (retweetedTweet.asKnown().getOrNull()?.validity() ?: 0) +
                (author.asKnown().getOrNull()?.validity() ?: 0) +
                (if (field.asKnown().isPresent) 1 else 0) +
                (if (change.asKnown().isPresent) 1 else 0) +
                (if (userId.asKnown().isPresent) 1 else 0) +
                (if (username.asKnown().isPresent) 1 else 0) +
                (previous.asKnown().getOrNull()?.validity() ?: 0) +
                (current.asKnown().getOrNull()?.validity() ?: 0) +
                (if (followedAt.asKnown().isPresent) 1 else 0) +
                (if (followedAtExact.asKnown().isPresent) 1 else 0) +
                (reason.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }
            return other is Data &&
                id == other.id &&
                text == other.text &&
                type == other.type &&
                createdAt == other.createdAt &&
                url == other.url &&
                lang == other.lang &&
                isReply == other.isReply &&
                isLimitedReply == other.isLimitedReply &&
                isNoteTweet == other.isNoteTweet &&
                isPinned == other.isPinned &&
                isQuoteStatus == other.isQuoteStatus &&
                isRetweet == other.isRetweet &&
                quotedTweetId == other.quotedTweetId &&
                quotedTweetPermalink == other.quotedTweetPermalink &&
                quotedTweetUnavailable == other.quotedTweetUnavailable &&
                retweetedAt == other.retweetedAt &&
                inReplyToId == other.inReplyToId &&
                inReplyToUserId == other.inReplyToUserId &&
                inReplyToUsername == other.inReplyToUsername &&
                conversationId == other.conversationId &&
                conversationControl == other.conversationControl &&
                limitedActions == other.limitedActions &&
                source == other.source &&
                displayTextRange == other.displayTextRange &&
                textHighlights == other.textHighlights &&
                contentDisclosure == other.contentDisclosure &&
                article == other.article &&
                authorUnavailable == other.authorUnavailable &&
                unavailableAuthorId == other.unavailableAuthorId &&
                card == other.card &&
                cashtagAttachments == other.cashtagAttachments &&
                communityId == other.communityId &&
                communityName == other.communityName &&
                communityNote == other.communityNote &&
                hasCommunityNotes == other.hasCommunityNotes &&
                edit == other.edit &&
                exclusiveContent == other.exclusiveContent &&
                isTranslatable == other.isTranslatable &&
                grokShareAttachment == other.grokShareAttachment &&
                grokTranslatedPost == other.grokTranslatedPost &&
                jetfuelAttachment == other.jetfuelAttachment &&
                noteTweet == other.noteTweet &&
                place == other.place &&
                coordinates == other.coordinates &&
                geo == other.geo &&
                postCta == other.postCta &&
                possiblySensitive == other.possiblySensitive &&
                previousCounts == other.previousCounts &&
                reactionContext == other.reactionContext &&
                sportsContext == other.sportsContext &&
                subscriberBadge == other.subscriberBadge &&
                tombstone == other.tombstone &&
                interstitial == other.interstitial &&
                unmentionedUserIds == other.unmentionedUserIds &&
                viewState == other.viewState &&
                entities == other.entities &&
                scopes == other.scopes &&
                softIntervention == other.softIntervention &&
                media == other.media &&
                retweetCount == other.retweetCount &&
                replyCount == other.replyCount &&
                likeCount == other.likeCount &&
                quoteCount == other.quoteCount &&
                viewCount == other.viewCount &&
                bookmarkCount == other.bookmarkCount &&
                unknownCounts == other.unknownCounts &&
                parentTweet == other.parentTweet &&
                quotedTweet == other.quotedTweet &&
                retweetedTweet == other.retweetedTweet &&
                author == other.author &&
                field == other.field &&
                change == other.change &&
                userId == other.userId &&
                username == other.username &&
                previous == other.previous &&
                current == other.current &&
                followedAt == other.followedAt &&
                followedAtExact == other.followedAtExact &&
                reason == other.reason &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                text,
                type,
                createdAt,
                url,
                lang,
                isReply,
                isLimitedReply,
                isNoteTweet,
                isPinned,
                isQuoteStatus,
                isRetweet,
                quotedTweetId,
                quotedTweetPermalink,
                quotedTweetUnavailable,
                retweetedAt,
                inReplyToId,
                inReplyToUserId,
                inReplyToUsername,
                conversationId,
                conversationControl,
                limitedActions,
                source,
                displayTextRange,
                textHighlights,
                contentDisclosure,
                article,
                authorUnavailable,
                unavailableAuthorId,
                card,
                cashtagAttachments,
                communityId,
                communityName,
                communityNote,
                hasCommunityNotes,
                edit,
                exclusiveContent,
                isTranslatable,
                grokShareAttachment,
                grokTranslatedPost,
                jetfuelAttachment,
                noteTweet,
                place,
                coordinates,
                geo,
                postCta,
                possiblySensitive,
                previousCounts,
                reactionContext,
                sportsContext,
                subscriberBadge,
                tombstone,
                interstitial,
                unmentionedUserIds,
                viewState,
                entities,
                scopes,
                softIntervention,
                media,
                retweetCount,
                replyCount,
                likeCount,
                quoteCount,
                viewCount,
                bookmarkCount,
                unknownCounts,
                parentTweet,
                quotedTweet,
                retweetedTweet,
                author,
                field,
                change,
                userId,
                username,
                previous,
                current,
                followedAt,
                followedAtExact,
                reason,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Data{id=$id, text=$text, type=$type, createdAt=$createdAt, url=$url, lang=$lang, isReply=$isReply, isLimitedReply=$isLimitedReply, isNoteTweet=$isNoteTweet, isPinned=$isPinned, isQuoteStatus=$isQuoteStatus, isRetweet=$isRetweet, quotedTweetId=$quotedTweetId, quotedTweetPermalink=$quotedTweetPermalink, quotedTweetUnavailable=$quotedTweetUnavailable, retweetedAt=$retweetedAt, inReplyToId=$inReplyToId, inReplyToUserId=$inReplyToUserId, inReplyToUsername=$inReplyToUsername, conversationId=$conversationId, conversationControl=$conversationControl, limitedActions=$limitedActions, source=$source, displayTextRange=$displayTextRange, textHighlights=$textHighlights, contentDisclosure=$contentDisclosure, article=$article, authorUnavailable=$authorUnavailable, unavailableAuthorId=$unavailableAuthorId, card=$card, cashtagAttachments=$cashtagAttachments, communityId=$communityId, communityName=$communityName, communityNote=$communityNote, hasCommunityNotes=$hasCommunityNotes, edit=$edit, exclusiveContent=$exclusiveContent, isTranslatable=$isTranslatable, grokShareAttachment=$grokShareAttachment, grokTranslatedPost=$grokTranslatedPost, jetfuelAttachment=$jetfuelAttachment, noteTweet=$noteTweet, place=$place, coordinates=$coordinates, geo=$geo, postCta=$postCta, possiblySensitive=$possiblySensitive, previousCounts=$previousCounts, reactionContext=$reactionContext, sportsContext=$sportsContext, subscriberBadge=$subscriberBadge, tombstone=$tombstone, interstitial=$interstitial, unmentionedUserIds=$unmentionedUserIds, viewState=$viewState, entities=$entities, scopes=$scopes, softIntervention=$softIntervention, media=$media, retweetCount=$retweetCount, replyCount=$replyCount, likeCount=$likeCount, quoteCount=$quoteCount, viewCount=$viewCount, bookmarkCount=$bookmarkCount, unknownCounts=$unknownCounts, parentTweet=$parentTweet, quotedTweet=$quotedTweet, retweetedTweet=$retweetedTweet, author=$author, field=$field, change=$change, userId=$userId, username=$username, previous=$previous, current=$current, followedAt=$followedAt, followedAtExact=$followedAtExact, reason=$reason, additionalProperties=$additionalProperties}"

        class Reason @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /** Returns this class instance's raw value. */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val UNAVAILABLE = of("unavailable")

                @JvmField val UNFOLLOWED = of("unfollowed")

                @JvmStatic fun of(value: String) = Reason(JsonField.of(value))
            }

            /** An enum containing [Reason]'s known values. */
            enum class Known {
                UNAVAILABLE,
                UNFOLLOWED,
            }

            /**
             * An enum containing [Reason]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Reason] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                UNAVAILABLE,
                UNFOLLOWED,
                /**
                 * An enum member indicating that [Reason] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             */
            fun value(): Value =
                when (this) {
                    UNAVAILABLE -> Value.UNAVAILABLE
                    UNFOLLOWED -> Value.UNFOLLOWED
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
             *   known member.
             */
            fun known(): Known =
                when (this) {
                    UNAVAILABLE -> Known.UNAVAILABLE
                    UNFOLLOWED -> Known.UNFOLLOWED
                    else -> throw XTwitterScraperInvalidDataException("Unknown Reason: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * @throws XTwitterScraperInvalidDataException if this class instance's value does not
             *   have the expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    XTwitterScraperInvalidDataException("Value is not a String")
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
            fun validate(): Reason = apply {
                if (validated) {
                    return@apply
                }

                known()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: XTwitterScraperInvalidDataException) {
                    false
                }

            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Reason && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }
    }

    /** Source monitor type for this detailed event. */
    class MonitorType @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val ACCOUNT = of("account")

            @JvmField val KEYWORD = of("keyword")

            @JvmStatic fun of(value: String) = MonitorType(JsonField.of(value))
        }

        /** An enum containing [MonitorType]'s known values. */
        enum class Known {
            ACCOUNT,
            KEYWORD,
        }

        /**
         * An enum containing [MonitorType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [MonitorType] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            ACCOUNT,
            KEYWORD,
            /**
             * An enum member indicating that [MonitorType] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         */
        fun value(): Value =
            when (this) {
                ACCOUNT -> Value.ACCOUNT
                KEYWORD -> Value.KEYWORD
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                ACCOUNT -> Known.ACCOUNT
                KEYWORD -> Known.KEYWORD
                else -> throw XTwitterScraperInvalidDataException("Unknown MonitorType: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
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
        fun validate(): MonitorType = apply {
            if (validated) {
                return@apply
            }

            known()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is MonitorType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is EventDetail &&
            id == other.id &&
            data == other.data &&
            monitorId == other.monitorId &&
            monitorType == other.monitorType &&
            occurredAt == other.occurredAt &&
            type == other.type &&
            keywordMonitorId == other.keywordMonitorId &&
            query == other.query &&
            username == other.username &&
            xEventId == other.xEventId &&
            xUserId == other.xUserId &&
            monitorName == other.monitorName &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            data,
            monitorId,
            monitorType,
            occurredAt,
            type,
            keywordMonitorId,
            query,
            username,
            xEventId,
            xUserId,
            monitorName,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "EventDetail{id=$id, data=$data, monitorId=$monitorId, monitorType=$monitorType, occurredAt=$occurredAt, type=$type, keywordMonitorId=$keywordMonitorId, query=$query, username=$username, xEventId=$xEventId, xUserId=$xUserId, monitorName=$monitorName, additionalProperties=$additionalProperties}"
}
