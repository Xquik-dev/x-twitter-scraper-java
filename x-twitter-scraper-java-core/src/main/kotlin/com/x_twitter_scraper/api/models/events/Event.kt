// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.events

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.BaseDeserializer
import com.x_twitter_scraper.api.core.BaseSerializer
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.allMaxBy
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.getOrThrow
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import com.x_twitter_scraper.api.models.ContentDisclosure
import com.x_twitter_scraper.api.models.EmbeddedTweet
import com.x_twitter_scraper.api.models.EventType
import com.x_twitter_scraper.api.models.SearchTweet
import com.x_twitter_scraper.api.models.SoftIntervention
import com.x_twitter_scraper.api.models.TweetMedia
import com.x_twitter_scraper.api.models.UnknownCount
import com.x_twitter_scraper.api.models.UserProfile
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Monitor event summary with source metadata and occurrence time. */
class Event
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
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun data(): Data = data.getRequired("data")

    /**
     * Account monitor ID for account events, or keyword monitor ID for keyword events.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun monitorId(): String = monitorId.getRequired("monitorId")

    /**
     * Source monitor type.
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
     * Keyword monitor ID, present for keyword monitor events.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun keywordMonitorId(): Optional<String> = keywordMonitorId.getOptional("keywordMonitorId")

    /**
     * Keyword query, present for keyword monitor events.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun query(): Optional<String> = query.getOptional("query")

    /**
     * Account username, present for account monitor events.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun username(): Optional<String> = username.getOptional("username")

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
         * Returns a mutable builder for constructing an instance of [Event].
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

    /** A builder for [Event]. */
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
        private var xUserId: JsonField<String> = JsonMissing.of()
        private var monitorName: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(event: Event) = apply {
            id = event.id
            data = event.data
            monitorId = event.monitorId
            monitorType = event.monitorType
            occurredAt = event.occurredAt
            type = event.type
            keywordMonitorId = event.keywordMonitorId
            query = event.query
            username = event.username
            xUserId = event.xUserId
            monitorName = event.monitorName
            additionalProperties = event.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /** Sets [Builder.id] to an arbitrary JSON value. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun data(data: Data) = data(JsonField.of(data))

        /** Sets [Builder.data] to an arbitrary JSON value. */
        fun data(data: JsonField<Data>) = apply { this.data = data }

        /** Account monitor ID for account events, or keyword monitor ID for keyword events. */
        fun monitorId(monitorId: String) = monitorId(JsonField.of(monitorId))

        /** Sets [Builder.monitorId] to an arbitrary JSON value. */
        fun monitorId(monitorId: JsonField<String>) = apply { this.monitorId = monitorId }

        /** Source monitor type. */
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

        /** Keyword monitor ID, present for keyword monitor events. */
        fun keywordMonitorId(keywordMonitorId: String) =
            keywordMonitorId(JsonField.of(keywordMonitorId))

        /** Sets [Builder.keywordMonitorId] to an arbitrary JSON value. */
        fun keywordMonitorId(keywordMonitorId: JsonField<String>) = apply {
            this.keywordMonitorId = keywordMonitorId
        }

        /** Keyword query, present for keyword monitor events. */
        fun query(query: String) = query(JsonField.of(query))

        /** Sets [Builder.query] to an arbitrary JSON value. */
        fun query(query: JsonField<String>) = apply { this.query = query }

        /** Account username, present for account monitor events. */
        fun username(username: String) = username(JsonField.of(username))

        /** Sets [Builder.username] to an arbitrary JSON value. */
        fun username(username: JsonField<String>) = apply { this.username = username }

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
         * Returns an immutable instance of [Event].
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
        fun build(): Event =
            Event(
                checkRequired("id", id),
                checkRequired("data", data),
                checkRequired("monitorId", monitorId),
                checkRequired("monitorType", monitorType),
                checkRequired("occurredAt", occurredAt),
                checkRequired("type", type),
                keywordMonitorId,
                query,
                username,
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
    fun validate(): Event = apply {
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
            (if (xUserId.asKnown().isPresent) 1 else 0) +
            (if (monitorName.asKnown().isPresent) 1 else 0)

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
        private val card: JsonField<Card>,
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
        private val reactionContext: JsonField<ReactionContext>,
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
        private val author: JsonField<Author>,
        private val field: JsonField<String>,
        private val change: JsonField<Long>,
        private val userId: JsonField<String>,
        private val username: JsonField<String>,
        private val previous: JsonField<ProfileValue>,
        private val current: JsonField<ProfileValue>,
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
            @JsonProperty("card") @ExcludeMissing card: JsonField<Card> = JsonMissing.of(),
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
            reactionContext: JsonField<ReactionContext> = JsonMissing.of(),
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
            @JsonProperty("author") @ExcludeMissing author: JsonField<Author> = JsonMissing.of(),
            @JsonProperty("field") @ExcludeMissing field: JsonField<String> = JsonMissing.of(),
            @JsonProperty("change") @ExcludeMissing change: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("userId") @ExcludeMissing userId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("username")
            @ExcludeMissing
            username: JsonField<String> = JsonMissing.of(),
            @JsonProperty("previous")
            @ExcludeMissing
            previous: JsonField<ProfileValue> = JsonMissing.of(),
            @JsonProperty("current")
            @ExcludeMissing
            current: JsonField<ProfileValue> = JsonMissing.of(),
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
        fun card(): Optional<Card> = card.getOptional("card")

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
        fun reactionContext(): Optional<ReactionContext> =
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
        fun author(): Optional<Author> = author.getOptional("author")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun field(): Optional<String> = field.getOptional("field")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun change(): Optional<Long> = change.getOptional("change")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun userId(): Optional<String> = userId.getOptional("userId")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun username(): Optional<String> = username.getOptional("username")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun previous(): Optional<ProfileValue> = previous.getOptional("previous")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun current(): Optional<ProfileValue> = current.getOptional("current")

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
        @JsonProperty("card") @ExcludeMissing fun _card(): JsonField<Card> = card

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
        fun _reactionContext(): JsonField<ReactionContext> = reactionContext

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
        @JsonProperty("author") @ExcludeMissing fun _author(): JsonField<Author> = author

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
        fun _previous(): JsonField<ProfileValue> = previous

        /**
         * Returns the raw JSON value of [current].
         *
         * Unlike [current], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("current") @ExcludeMissing fun _current(): JsonField<ProfileValue> = current

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
            private var card: JsonField<Card> = JsonMissing.of()
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
            private var reactionContext: JsonField<ReactionContext> = JsonMissing.of()
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
            private var author: JsonField<Author> = JsonMissing.of()
            private var field: JsonField<String> = JsonMissing.of()
            private var change: JsonField<Long> = JsonMissing.of()
            private var userId: JsonField<String> = JsonMissing.of()
            private var username: JsonField<String> = JsonMissing.of()
            private var previous: JsonField<ProfileValue> = JsonMissing.of()
            private var current: JsonField<ProfileValue> = JsonMissing.of()
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

            fun card(card: Card) = card(JsonField.of(card))

            /** Sets [Builder.card] to an arbitrary JSON value. */
            fun card(card: JsonField<Card>) = apply { this.card = card }

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

            fun reactionContext(reactionContext: ReactionContext) =
                reactionContext(JsonField.of(reactionContext))

            /** Sets [Builder.reactionContext] to an arbitrary JSON value. */
            fun reactionContext(reactionContext: JsonField<ReactionContext>) = apply {
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

            fun author(author: Author?) = author(JsonField.ofNullable(author))

            /** Alias for calling [Builder.author] with `author.orElse(null)`. */
            fun author(author: Optional<Author>) = author(author.getOrNull())

            /** Sets [Builder.author] to an arbitrary JSON value. */
            fun author(author: JsonField<Author>) = apply { this.author = author }

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

            fun previous(previous: ProfileValue) = previous(JsonField.of(previous))

            /** Sets [Builder.previous] to an arbitrary JSON value. */
            fun previous(previous: JsonField<ProfileValue>) = apply { this.previous = previous }

            fun current(current: ProfileValue) = current(JsonField.of(current))

            /** Sets [Builder.current] to an arbitrary JSON value. */
            fun current(current: JsonField<ProfileValue>) = apply { this.current = current }

            fun followedAt(followedAt: OffsetDateTime) = followedAt(JsonField.of(followedAt))

            /** Sets [Builder.followedAt] to an arbitrary JSON value. */
            fun followedAt(followedAt: JsonField<OffsetDateTime>) = apply {
                this.followedAt = followedAt
            }

            /** Alias for calling [current] with `ProfileValue.ofString(string)`. */
            fun current(string: String) = current(ProfileValue.ofString(string))

            /** Alias for calling [current] with `ProfileValue.ofBoolean(boolean)`. */
            fun current(boolean: Boolean) = current(ProfileValue.ofBoolean(boolean))

            /** Alias for calling [current] with `ProfileValue.ofLong(long)`. */
            fun current(long: Long) = current(ProfileValue.ofLong(long))

            /** Alias for calling [current] with `ProfileValue.ofStrings(strings)`. */
            fun current(strings: List<String>) = current(ProfileValue.ofStrings(strings))

            /** Alias for calling [previous] with `ProfileValue.ofString(string)`. */
            fun previous(string: String) = previous(ProfileValue.ofString(string))

            /** Alias for calling [previous] with `ProfileValue.ofBoolean(boolean)`. */
            fun previous(boolean: Boolean) = previous(ProfileValue.ofBoolean(boolean))

            /** Alias for calling [previous] with `ProfileValue.ofLong(long)`. */
            fun previous(long: Long) = previous(ProfileValue.ofLong(long))

            /** Alias for calling [previous] with `ProfileValue.ofStrings(strings)`. */
            fun previous(strings: List<String>) = previous(ProfileValue.ofStrings(strings))

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

        @JsonDeserialize(using = ProfileValue.Deserializer::class)
        @JsonSerialize(using = ProfileValue.Serializer::class)
        class ProfileValue
        private constructor(
            private val string: String? = null,
            private val boolean: Boolean? = null,
            private val long: Long? = null,
            private val strings: List<String>? = null,
            private val _json: JsonValue? = null,
        ) {

            fun string(): Optional<String> = Optional.ofNullable(string)

            fun boolean(): Optional<Boolean> = Optional.ofNullable(boolean)

            fun long(): Optional<Long> = Optional.ofNullable(long)

            fun strings(): Optional<List<String>> = Optional.ofNullable(strings)

            fun isString(): Boolean = string != null

            fun isBoolean(): Boolean = boolean != null

            fun isLong(): Boolean = long != null

            fun isStrings(): Boolean = strings != null

            fun asString(): String = string.getOrThrow("string")

            fun asBoolean(): Boolean = boolean.getOrThrow("boolean")

            fun asLong(): Long = long.getOrThrow("long")

            fun asStrings(): List<String> = strings.getOrThrow("strings")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            /**
             * Maps this instance's current variant to a value of type [T] using the given
             * [visitor].
             *
             * @throws XTwitterScraperInvalidDataException if [Visitor.unknown] is not overridden in
             *   [visitor] and the current variant is unknown.
             */
            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    string != null -> visitor.visitString(string)
                    boolean != null -> visitor.visitBoolean(boolean)
                    long != null -> visitor.visitLong(long)
                    strings != null -> visitor.visitStrings(strings)
                    else -> visitor.unknown(_json)
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
            fun validate(): ProfileValue = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitString(string: String) {}

                        override fun visitBoolean(boolean: Boolean) {}

                        override fun visitLong(long: Long) {}

                        override fun visitStrings(strings: List<String>) {}
                    }
                )
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
                accept(
                    object : Visitor<Int> {
                        override fun visitString(string: String) = 1

                        override fun visitBoolean(boolean: Boolean) = 1

                        override fun visitLong(long: Long) = 1

                        override fun visitStrings(strings: List<String>) = strings.size

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ProfileValue &&
                    string == other.string &&
                    boolean == other.boolean &&
                    long == other.long &&
                    strings == other.strings
            }

            override fun hashCode(): Int = Objects.hash(string, boolean, long, strings)

            override fun toString(): String =
                when {
                    string != null -> "ProfileValue{string=$string}"
                    boolean != null -> "ProfileValue{boolean=$boolean}"
                    long != null -> "ProfileValue{long=$long}"
                    strings != null -> "ProfileValue{strings=$strings}"
                    _json != null -> "ProfileValue{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid ProfileValue")
                }

            companion object {

                @JvmStatic fun ofString(string: String) = ProfileValue(string = string)

                @JvmStatic fun ofBoolean(boolean: Boolean) = ProfileValue(boolean = boolean)

                @JvmStatic fun ofLong(long: Long) = ProfileValue(long = long)

                @JvmStatic fun ofStrings(strings: List<String>) = ProfileValue(strings = strings)
            }

            /**
             * An interface that defines how to map each variant of [ProfileValue] to a value of
             * type [T].
             */
            interface Visitor<out T> {

                fun visitString(string: String): T

                fun visitBoolean(boolean: Boolean): T

                fun visitLong(long: Long): T

                fun visitStrings(strings: List<String>): T

                /**
                 * Maps an unknown variant of [ProfileValue] to a value of type [T].
                 *
                 * An instance of [ProfileValue] can contain an unknown variant if it was
                 * deserialized from data that doesn't match any known variant.
                 *
                 * @throws XTwitterScraperInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw XTwitterScraperInvalidDataException("Unknown ProfileValue: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<ProfileValue>(ProfileValue::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): ProfileValue {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                    ProfileValue(string = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                                    ProfileValue(boolean = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                                    ProfileValue(long = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                                    ProfileValue(strings = it, _json = json)
                                },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        0 -> ProfileValue(_json = json)
                        1 -> bestMatches.single()
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<ProfileValue>(ProfileValue::class) {

                override fun serialize(
                    value: ProfileValue,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.string != null -> generator.writeObject(value.string)
                        value.boolean != null -> generator.writeObject(value.boolean)
                        value.long != null -> generator.writeObject(value.long)
                        value.strings != null -> generator.writeObject(value.strings)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid ProfileValue")
                    }
                }
            }
        }

        class Author
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val username: JsonField<String>,
            private val name: JsonField<String>,
            private val description: JsonField<String>,
            private val followers: JsonField<Long>,
            private val following: JsonField<Long>,
            private val verified: JsonField<Boolean>,
            private val isBlueVerified: JsonField<Boolean>,
            private val isVerified: JsonField<Boolean>,
            private val profilePicture: JsonField<String>,
            private val profilePictureOriginal: JsonField<String>,
            private val coverPicture: JsonField<String>,
            private val profileBannerUrl: JsonField<String>,
            private val location: JsonField<String>,
            private val accountBasedIn: JsonField<UserProfile.AccountBasedIn>,
            private val accountBasedInUnavailable: JsonField<Boolean>,
            private val accountBasedInAccurate: JsonField<Boolean>,
            private val connectedVia: JsonField<String>,
            private val connectedViaAccurate: JsonField<Boolean>,
            private val affiliateUsername: JsonField<String>,
            private val email: JsonField<String>,
            private val contactInfo: JsonField<UserProfile.ContactInfo>,
            private val usernameChanges: JsonField<UserProfile.UsernameChanges>,
            private val birthdate: JsonField<UserProfile.Birthdate>,
            private val retweetedAt: JsonField<OffsetDateTime>,
            private val createdAt: JsonField<String>,
            private val statusesCount: JsonField<Long>,
            private val mediaCount: JsonField<Long>,
            private val protected_: JsonField<Boolean>,
            private val url: JsonField<String>,
            private val favouritesCount: JsonField<Long>,
            private val hasCustomTimelines: JsonField<Boolean>,
            private val isTranslator: JsonField<Boolean>,
            private val withheldInCountries: JsonField<List<String>>,
            private val withheldScope: JsonField<String>,
            private val possiblySensitive: JsonField<Boolean>,
            private val professional: JsonField<UserProfile.Professional>,
            private val grokTranslatedBio: JsonField<UserProfile.GrokTranslatedBio>,
            private val pinnedTweetIds: JsonField<List<String>>,
            private val isAutomated: JsonField<Boolean>,
            private val automatedBy: JsonField<String>,
            private val unavailable: JsonField<Boolean>,
            private val unavailableReason: JsonField<String>,
            private val verifiedType: JsonField<String>,
            private val affiliatesHighlightedLabel:
                JsonField<UserProfile.AffiliatesHighlightedLabel>,
            private val businessAccountAffiliatesCount: JsonField<Long>,
            private val creatorSubscriptionsCount: JsonField<Long>,
            private val hasGraduatedAccess: JsonField<Boolean>,
            private val hasHiddenSubscriptionsOnProfile: JsonField<Boolean>,
            private val highlightsInfo: JsonField<UserProfile.HighlightsInfo>,
            private val identityVerification: JsonField<UserProfile.IdentityVerification>,
            private val isProfileTranslatable: JsonField<Boolean>,
            private val parodyCommentaryFanLabel: JsonField<String>,
            private val profileDescriptionLanguage: JsonField<String>,
            private val profileImageShape: JsonField<String>,
            private val profileInterstitialType: JsonField<String>,
            private val profileSortEnabled: JsonField<Boolean>,
            private val profileTranslatorType: JsonField<String>,
            private val redirectsToUsername: JsonField<String>,
            private val superFollowEligible: JsonField<Boolean>,
            private val superFollowsUserProfileActive: JsonField<Boolean>,
            private val tipJar: JsonField<UserProfile.TipJar>,
            private val listedCount: JsonField<Long>,
            private val fastFollowersCount: JsonField<Long>,
            private val normalFollowersCount: JsonField<Long>,
            private val defaultProfile: JsonField<Boolean>,
            private val defaultProfileImage: JsonField<Boolean>,
            private val hasExtendedProfile: JsonField<Boolean>,
            private val isTranslationEnabled: JsonField<Boolean>,
            private val geoEnabled: JsonField<Boolean>,
            private val advertiserAccountType: JsonField<String>,
            private val advertiserAccountServiceLevels: JsonField<List<String>>,
            private val businessProfileState: JsonField<String>,
            private val subscribersCount: JsonField<Long>,
            private val verificationReason: JsonField<UserProfile.VerificationReason>,
            private val communityRole: JsonField<String>,
            private val profileBio: JsonField<UserProfile.ProfileBio>,
            private val userName: JsonField<String>,
            private val rawVerified: JsonField<Boolean>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {
            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("username")
                @ExcludeMissing
                username: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("description")
                @ExcludeMissing
                description: JsonField<String> = JsonMissing.of(),
                @JsonProperty("followers")
                @ExcludeMissing
                followers: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("following")
                @ExcludeMissing
                following: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("verified")
                @ExcludeMissing
                verified: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("isBlueVerified")
                @ExcludeMissing
                isBlueVerified: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("isVerified")
                @ExcludeMissing
                isVerified: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("profilePicture")
                @ExcludeMissing
                profilePicture: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profilePictureOriginal")
                @ExcludeMissing
                profilePictureOriginal: JsonField<String> = JsonMissing.of(),
                @JsonProperty("coverPicture")
                @ExcludeMissing
                coverPicture: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profileBannerUrl")
                @ExcludeMissing
                profileBannerUrl: JsonField<String> = JsonMissing.of(),
                @JsonProperty("location")
                @ExcludeMissing
                location: JsonField<String> = JsonMissing.of(),
                @JsonProperty("accountBasedIn")
                @ExcludeMissing
                accountBasedIn: JsonField<UserProfile.AccountBasedIn> = JsonMissing.of(),
                @JsonProperty("accountBasedInUnavailable")
                @ExcludeMissing
                accountBasedInUnavailable: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("accountBasedInAccurate")
                @ExcludeMissing
                accountBasedInAccurate: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("connectedVia")
                @ExcludeMissing
                connectedVia: JsonField<String> = JsonMissing.of(),
                @JsonProperty("connectedViaAccurate")
                @ExcludeMissing
                connectedViaAccurate: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("affiliateUsername")
                @ExcludeMissing
                affiliateUsername: JsonField<String> = JsonMissing.of(),
                @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
                @JsonProperty("contactInfo")
                @ExcludeMissing
                contactInfo: JsonField<UserProfile.ContactInfo> = JsonMissing.of(),
                @JsonProperty("usernameChanges")
                @ExcludeMissing
                usernameChanges: JsonField<UserProfile.UsernameChanges> = JsonMissing.of(),
                @JsonProperty("birthdate")
                @ExcludeMissing
                birthdate: JsonField<UserProfile.Birthdate> = JsonMissing.of(),
                @JsonProperty("retweetedAt")
                @ExcludeMissing
                retweetedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
                @JsonProperty("createdAt")
                @ExcludeMissing
                createdAt: JsonField<String> = JsonMissing.of(),
                @JsonProperty("statusesCount")
                @ExcludeMissing
                statusesCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("mediaCount")
                @ExcludeMissing
                mediaCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("protected")
                @ExcludeMissing
                protected_: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
                @JsonProperty("favouritesCount")
                @ExcludeMissing
                favouritesCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("hasCustomTimelines")
                @ExcludeMissing
                hasCustomTimelines: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("isTranslator")
                @ExcludeMissing
                isTranslator: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("withheldInCountries")
                @ExcludeMissing
                withheldInCountries: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("withheldScope")
                @ExcludeMissing
                withheldScope: JsonField<String> = JsonMissing.of(),
                @JsonProperty("possiblySensitive")
                @ExcludeMissing
                possiblySensitive: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("professional")
                @ExcludeMissing
                professional: JsonField<UserProfile.Professional> = JsonMissing.of(),
                @JsonProperty("grokTranslatedBio")
                @ExcludeMissing
                grokTranslatedBio: JsonField<UserProfile.GrokTranslatedBio> = JsonMissing.of(),
                @JsonProperty("pinnedTweetIds")
                @ExcludeMissing
                pinnedTweetIds: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("isAutomated")
                @ExcludeMissing
                isAutomated: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("automatedBy")
                @ExcludeMissing
                automatedBy: JsonField<String> = JsonMissing.of(),
                @JsonProperty("unavailable")
                @ExcludeMissing
                unavailable: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("unavailableReason")
                @ExcludeMissing
                unavailableReason: JsonField<String> = JsonMissing.of(),
                @JsonProperty("verifiedType")
                @ExcludeMissing
                verifiedType: JsonField<String> = JsonMissing.of(),
                @JsonProperty("affiliatesHighlightedLabel")
                @ExcludeMissing
                affiliatesHighlightedLabel: JsonField<UserProfile.AffiliatesHighlightedLabel> =
                    JsonMissing.of(),
                @JsonProperty("businessAccountAffiliatesCount")
                @ExcludeMissing
                businessAccountAffiliatesCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("creatorSubscriptionsCount")
                @ExcludeMissing
                creatorSubscriptionsCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("hasGraduatedAccess")
                @ExcludeMissing
                hasGraduatedAccess: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("hasHiddenSubscriptionsOnProfile")
                @ExcludeMissing
                hasHiddenSubscriptionsOnProfile: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("highlightsInfo")
                @ExcludeMissing
                highlightsInfo: JsonField<UserProfile.HighlightsInfo> = JsonMissing.of(),
                @JsonProperty("identityVerification")
                @ExcludeMissing
                identityVerification: JsonField<UserProfile.IdentityVerification> =
                    JsonMissing.of(),
                @JsonProperty("isProfileTranslatable")
                @ExcludeMissing
                isProfileTranslatable: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("parodyCommentaryFanLabel")
                @ExcludeMissing
                parodyCommentaryFanLabel: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profileDescriptionLanguage")
                @ExcludeMissing
                profileDescriptionLanguage: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profileImageShape")
                @ExcludeMissing
                profileImageShape: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profileInterstitialType")
                @ExcludeMissing
                profileInterstitialType: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profileSortEnabled")
                @ExcludeMissing
                profileSortEnabled: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("profileTranslatorType")
                @ExcludeMissing
                profileTranslatorType: JsonField<String> = JsonMissing.of(),
                @JsonProperty("redirectsToUsername")
                @ExcludeMissing
                redirectsToUsername: JsonField<String> = JsonMissing.of(),
                @JsonProperty("superFollowEligible")
                @ExcludeMissing
                superFollowEligible: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("superFollowsUserProfileActive")
                @ExcludeMissing
                superFollowsUserProfileActive: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("tipJar")
                @ExcludeMissing
                tipJar: JsonField<UserProfile.TipJar> = JsonMissing.of(),
                @JsonProperty("listedCount")
                @ExcludeMissing
                listedCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("fastFollowersCount")
                @ExcludeMissing
                fastFollowersCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("normalFollowersCount")
                @ExcludeMissing
                normalFollowersCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("defaultProfile")
                @ExcludeMissing
                defaultProfile: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("defaultProfileImage")
                @ExcludeMissing
                defaultProfileImage: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("hasExtendedProfile")
                @ExcludeMissing
                hasExtendedProfile: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("isTranslationEnabled")
                @ExcludeMissing
                isTranslationEnabled: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("geoEnabled")
                @ExcludeMissing
                geoEnabled: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("advertiserAccountType")
                @ExcludeMissing
                advertiserAccountType: JsonField<String> = JsonMissing.of(),
                @JsonProperty("advertiserAccountServiceLevels")
                @ExcludeMissing
                advertiserAccountServiceLevels: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("businessProfileState")
                @ExcludeMissing
                businessProfileState: JsonField<String> = JsonMissing.of(),
                @JsonProperty("subscribersCount")
                @ExcludeMissing
                subscribersCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("verificationReason")
                @ExcludeMissing
                verificationReason: JsonField<UserProfile.VerificationReason> = JsonMissing.of(),
                @JsonProperty("communityRole")
                @ExcludeMissing
                communityRole: JsonField<String> = JsonMissing.of(),
                @JsonProperty("profile_bio")
                @ExcludeMissing
                profileBio: JsonField<UserProfile.ProfileBio> = JsonMissing.of(),
                @JsonProperty("userName")
                @ExcludeMissing
                userName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("rawVerified")
                @ExcludeMissing
                rawVerified: JsonField<Boolean> = JsonMissing.of(),
            ) : this(
                id,
                username,
                name,
                description,
                followers,
                following,
                verified,
                isBlueVerified,
                isVerified,
                profilePicture,
                profilePictureOriginal,
                coverPicture,
                profileBannerUrl,
                location,
                accountBasedIn,
                accountBasedInUnavailable,
                accountBasedInAccurate,
                connectedVia,
                connectedViaAccurate,
                affiliateUsername,
                email,
                contactInfo,
                usernameChanges,
                birthdate,
                retweetedAt,
                createdAt,
                statusesCount,
                mediaCount,
                protected_,
                url,
                favouritesCount,
                hasCustomTimelines,
                isTranslator,
                withheldInCountries,
                withheldScope,
                possiblySensitive,
                professional,
                grokTranslatedBio,
                pinnedTweetIds,
                isAutomated,
                automatedBy,
                unavailable,
                unavailableReason,
                verifiedType,
                affiliatesHighlightedLabel,
                businessAccountAffiliatesCount,
                creatorSubscriptionsCount,
                hasGraduatedAccess,
                hasHiddenSubscriptionsOnProfile,
                highlightsInfo,
                identityVerification,
                isProfileTranslatable,
                parodyCommentaryFanLabel,
                profileDescriptionLanguage,
                profileImageShape,
                profileInterstitialType,
                profileSortEnabled,
                profileTranslatorType,
                redirectsToUsername,
                superFollowEligible,
                superFollowsUserProfileActive,
                tipJar,
                listedCount,
                fastFollowersCount,
                normalFollowersCount,
                defaultProfile,
                defaultProfileImage,
                hasExtendedProfile,
                isTranslationEnabled,
                geoEnabled,
                advertiserAccountType,
                advertiserAccountServiceLevels,
                businessProfileState,
                subscribersCount,
                verificationReason,
                communityRole,
                profileBio,
                userName,
                rawVerified,
                mutableMapOf(),
            )

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun id(): Optional<String> = id.getOptional("id")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun username(): Optional<String> = username.getOptional("username")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun description(): Optional<String> = description.getOptional("description")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun followers(): Optional<Long> = followers.getOptional("followers")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun following(): Optional<Long> = following.getOptional("following")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun verified(): Optional<Boolean> = verified.getOptional("verified")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun isBlueVerified(): Optional<Boolean> = isBlueVerified.getOptional("isBlueVerified")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun isVerified(): Optional<Boolean> = isVerified.getOptional("isVerified")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profilePicture(): Optional<String> = profilePicture.getOptional("profilePicture")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profilePictureOriginal(): Optional<String> =
                profilePictureOriginal.getOptional("profilePictureOriginal")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun coverPicture(): Optional<String> = coverPicture.getOptional("coverPicture")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profileBannerUrl(): Optional<String> =
                profileBannerUrl.getOptional("profileBannerUrl")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun location(): Optional<String> = location.getOptional("location")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun accountBasedIn(): Optional<UserProfile.AccountBasedIn> =
                accountBasedIn.getOptional("accountBasedIn")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun accountBasedInUnavailable(): Optional<Boolean> =
                accountBasedInUnavailable.getOptional("accountBasedInUnavailable")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun accountBasedInAccurate(): Optional<Boolean> =
                accountBasedInAccurate.getOptional("accountBasedInAccurate")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun connectedVia(): Optional<String> = connectedVia.getOptional("connectedVia")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun connectedViaAccurate(): Optional<Boolean> =
                connectedViaAccurate.getOptional("connectedViaAccurate")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun affiliateUsername(): Optional<String> =
                affiliateUsername.getOptional("affiliateUsername")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun email(): Optional<String> = email.getOptional("email")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun contactInfo(): Optional<UserProfile.ContactInfo> =
                contactInfo.getOptional("contactInfo")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun usernameChanges(): Optional<UserProfile.UsernameChanges> =
                usernameChanges.getOptional("usernameChanges")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun birthdate(): Optional<UserProfile.Birthdate> = birthdate.getOptional("birthdate")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun retweetedAt(): Optional<OffsetDateTime> = retweetedAt.getOptional("retweetedAt")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun createdAt(): Optional<String> = createdAt.getOptional("createdAt")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun statusesCount(): Optional<Long> = statusesCount.getOptional("statusesCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun mediaCount(): Optional<Long> = mediaCount.getOptional("mediaCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun protected_(): Optional<Boolean> = protected_.getOptional("protected")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun url(): Optional<String> = url.getOptional("url")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun favouritesCount(): Optional<Long> = favouritesCount.getOptional("favouritesCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun hasCustomTimelines(): Optional<Boolean> =
                hasCustomTimelines.getOptional("hasCustomTimelines")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun isTranslator(): Optional<Boolean> = isTranslator.getOptional("isTranslator")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun withheldInCountries(): Optional<List<String>> =
                withheldInCountries.getOptional("withheldInCountries")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun withheldScope(): Optional<String> = withheldScope.getOptional("withheldScope")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun possiblySensitive(): Optional<Boolean> =
                possiblySensitive.getOptional("possiblySensitive")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun professional(): Optional<UserProfile.Professional> =
                professional.getOptional("professional")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun grokTranslatedBio(): Optional<UserProfile.GrokTranslatedBio> =
                grokTranslatedBio.getOptional("grokTranslatedBio")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun pinnedTweetIds(): Optional<List<String>> =
                pinnedTweetIds.getOptional("pinnedTweetIds")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun isAutomated(): Optional<Boolean> = isAutomated.getOptional("isAutomated")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun automatedBy(): Optional<String> = automatedBy.getOptional("automatedBy")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun unavailable(): Optional<Boolean> = unavailable.getOptional("unavailable")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun unavailableReason(): Optional<String> =
                unavailableReason.getOptional("unavailableReason")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun verifiedType(): Optional<String> = verifiedType.getOptional("verifiedType")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun affiliatesHighlightedLabel(): Optional<UserProfile.AffiliatesHighlightedLabel> =
                affiliatesHighlightedLabel.getOptional("affiliatesHighlightedLabel")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun businessAccountAffiliatesCount(): Optional<Long> =
                businessAccountAffiliatesCount.getOptional("businessAccountAffiliatesCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun creatorSubscriptionsCount(): Optional<Long> =
                creatorSubscriptionsCount.getOptional("creatorSubscriptionsCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun hasGraduatedAccess(): Optional<Boolean> =
                hasGraduatedAccess.getOptional("hasGraduatedAccess")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun hasHiddenSubscriptionsOnProfile(): Optional<Boolean> =
                hasHiddenSubscriptionsOnProfile.getOptional("hasHiddenSubscriptionsOnProfile")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun highlightsInfo(): Optional<UserProfile.HighlightsInfo> =
                highlightsInfo.getOptional("highlightsInfo")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun identityVerification(): Optional<UserProfile.IdentityVerification> =
                identityVerification.getOptional("identityVerification")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun isProfileTranslatable(): Optional<Boolean> =
                isProfileTranslatable.getOptional("isProfileTranslatable")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun parodyCommentaryFanLabel(): Optional<String> =
                parodyCommentaryFanLabel.getOptional("parodyCommentaryFanLabel")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profileDescriptionLanguage(): Optional<String> =
                profileDescriptionLanguage.getOptional("profileDescriptionLanguage")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profileImageShape(): Optional<String> =
                profileImageShape.getOptional("profileImageShape")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profileInterstitialType(): Optional<String> =
                profileInterstitialType.getOptional("profileInterstitialType")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profileSortEnabled(): Optional<Boolean> =
                profileSortEnabled.getOptional("profileSortEnabled")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profileTranslatorType(): Optional<String> =
                profileTranslatorType.getOptional("profileTranslatorType")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun redirectsToUsername(): Optional<String> =
                redirectsToUsername.getOptional("redirectsToUsername")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun superFollowEligible(): Optional<Boolean> =
                superFollowEligible.getOptional("superFollowEligible")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun superFollowsUserProfileActive(): Optional<Boolean> =
                superFollowsUserProfileActive.getOptional("superFollowsUserProfileActive")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun tipJar(): Optional<UserProfile.TipJar> = tipJar.getOptional("tipJar")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun listedCount(): Optional<Long> = listedCount.getOptional("listedCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun fastFollowersCount(): Optional<Long> =
                fastFollowersCount.getOptional("fastFollowersCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun normalFollowersCount(): Optional<Long> =
                normalFollowersCount.getOptional("normalFollowersCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun defaultProfile(): Optional<Boolean> = defaultProfile.getOptional("defaultProfile")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun defaultProfileImage(): Optional<Boolean> =
                defaultProfileImage.getOptional("defaultProfileImage")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun hasExtendedProfile(): Optional<Boolean> =
                hasExtendedProfile.getOptional("hasExtendedProfile")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun isTranslationEnabled(): Optional<Boolean> =
                isTranslationEnabled.getOptional("isTranslationEnabled")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun geoEnabled(): Optional<Boolean> = geoEnabled.getOptional("geoEnabled")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun advertiserAccountType(): Optional<String> =
                advertiserAccountType.getOptional("advertiserAccountType")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun advertiserAccountServiceLevels(): Optional<List<String>> =
                advertiserAccountServiceLevels.getOptional("advertiserAccountServiceLevels")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun businessProfileState(): Optional<String> =
                businessProfileState.getOptional("businessProfileState")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun subscribersCount(): Optional<Long> =
                subscribersCount.getOptional("subscribersCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun verificationReason(): Optional<UserProfile.VerificationReason> =
                verificationReason.getOptional("verificationReason")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun communityRole(): Optional<String> = communityRole.getOptional("communityRole")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun profileBio(): Optional<UserProfile.ProfileBio> =
                profileBio.getOptional("profile_bio")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun userName(): Optional<String> = userName.getOptional("userName")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun rawVerified(): Optional<Boolean> = rawVerified.getOptional("rawVerified")

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [username].
             *
             * Unlike [username], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [description].
             *
             * Unlike [description], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("description")
            @ExcludeMissing
            fun _description(): JsonField<String> = description

            /**
             * Returns the raw JSON value of [followers].
             *
             * Unlike [followers], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("followers") @ExcludeMissing fun _followers(): JsonField<Long> = followers

            /**
             * Returns the raw JSON value of [following].
             *
             * Unlike [following], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("following") @ExcludeMissing fun _following(): JsonField<Long> = following

            /**
             * Returns the raw JSON value of [verified].
             *
             * Unlike [verified], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("verified") @ExcludeMissing fun _verified(): JsonField<Boolean> = verified

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
             * Returns the raw JSON value of [isVerified].
             *
             * Unlike [isVerified], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("isVerified")
            @ExcludeMissing
            fun _isVerified(): JsonField<Boolean> = isVerified

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
             * Returns the raw JSON value of [coverPicture].
             *
             * Unlike [coverPicture], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("coverPicture")
            @ExcludeMissing
            fun _coverPicture(): JsonField<String> = coverPicture

            /**
             * Returns the raw JSON value of [profileBannerUrl].
             *
             * Unlike [profileBannerUrl], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("profileBannerUrl")
            @ExcludeMissing
            fun _profileBannerUrl(): JsonField<String> = profileBannerUrl

            /**
             * Returns the raw JSON value of [location].
             *
             * Unlike [location], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("location") @ExcludeMissing fun _location(): JsonField<String> = location

            /**
             * Returns the raw JSON value of [accountBasedIn].
             *
             * Unlike [accountBasedIn], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("accountBasedIn")
            @ExcludeMissing
            fun _accountBasedIn(): JsonField<UserProfile.AccountBasedIn> = accountBasedIn

            /**
             * Returns the raw JSON value of [accountBasedInUnavailable].
             *
             * Unlike [accountBasedInUnavailable], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("accountBasedInUnavailable")
            @ExcludeMissing
            fun _accountBasedInUnavailable(): JsonField<Boolean> = accountBasedInUnavailable

            /**
             * Returns the raw JSON value of [accountBasedInAccurate].
             *
             * Unlike [accountBasedInAccurate], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("accountBasedInAccurate")
            @ExcludeMissing
            fun _accountBasedInAccurate(): JsonField<Boolean> = accountBasedInAccurate

            /**
             * Returns the raw JSON value of [connectedVia].
             *
             * Unlike [connectedVia], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("connectedVia")
            @ExcludeMissing
            fun _connectedVia(): JsonField<String> = connectedVia

            /**
             * Returns the raw JSON value of [connectedViaAccurate].
             *
             * Unlike [connectedViaAccurate], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("connectedViaAccurate")
            @ExcludeMissing
            fun _connectedViaAccurate(): JsonField<Boolean> = connectedViaAccurate

            /**
             * Returns the raw JSON value of [affiliateUsername].
             *
             * Unlike [affiliateUsername], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("affiliateUsername")
            @ExcludeMissing
            fun _affiliateUsername(): JsonField<String> = affiliateUsername

            /**
             * Returns the raw JSON value of [email].
             *
             * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

            /**
             * Returns the raw JSON value of [contactInfo].
             *
             * Unlike [contactInfo], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("contactInfo")
            @ExcludeMissing
            fun _contactInfo(): JsonField<UserProfile.ContactInfo> = contactInfo

            /**
             * Returns the raw JSON value of [usernameChanges].
             *
             * Unlike [usernameChanges], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("usernameChanges")
            @ExcludeMissing
            fun _usernameChanges(): JsonField<UserProfile.UsernameChanges> = usernameChanges

            /**
             * Returns the raw JSON value of [birthdate].
             *
             * Unlike [birthdate], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("birthdate")
            @ExcludeMissing
            fun _birthdate(): JsonField<UserProfile.Birthdate> = birthdate

            /**
             * Returns the raw JSON value of [retweetedAt].
             *
             * Unlike [retweetedAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("retweetedAt")
            @ExcludeMissing
            fun _retweetedAt(): JsonField<OffsetDateTime> = retweetedAt

            /**
             * Returns the raw JSON value of [createdAt].
             *
             * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("createdAt")
            @ExcludeMissing
            fun _createdAt(): JsonField<String> = createdAt

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
             * Returns the raw JSON value of [mediaCount].
             *
             * Unlike [mediaCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("mediaCount")
            @ExcludeMissing
            fun _mediaCount(): JsonField<Long> = mediaCount

            /**
             * Returns the raw JSON value of [protected_].
             *
             * Unlike [protected_], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("protected")
            @ExcludeMissing
            fun _protected_(): JsonField<Boolean> = protected_

            /**
             * Returns the raw JSON value of [url].
             *
             * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

            /**
             * Returns the raw JSON value of [favouritesCount].
             *
             * Unlike [favouritesCount], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("favouritesCount")
            @ExcludeMissing
            fun _favouritesCount(): JsonField<Long> = favouritesCount

            /**
             * Returns the raw JSON value of [hasCustomTimelines].
             *
             * Unlike [hasCustomTimelines], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("hasCustomTimelines")
            @ExcludeMissing
            fun _hasCustomTimelines(): JsonField<Boolean> = hasCustomTimelines

            /**
             * Returns the raw JSON value of [isTranslator].
             *
             * Unlike [isTranslator], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("isTranslator")
            @ExcludeMissing
            fun _isTranslator(): JsonField<Boolean> = isTranslator

            /**
             * Returns the raw JSON value of [withheldInCountries].
             *
             * Unlike [withheldInCountries], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("withheldInCountries")
            @ExcludeMissing
            fun _withheldInCountries(): JsonField<List<String>> = withheldInCountries

            /**
             * Returns the raw JSON value of [withheldScope].
             *
             * Unlike [withheldScope], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("withheldScope")
            @ExcludeMissing
            fun _withheldScope(): JsonField<String> = withheldScope

            /**
             * Returns the raw JSON value of [possiblySensitive].
             *
             * Unlike [possiblySensitive], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("possiblySensitive")
            @ExcludeMissing
            fun _possiblySensitive(): JsonField<Boolean> = possiblySensitive

            /**
             * Returns the raw JSON value of [professional].
             *
             * Unlike [professional], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("professional")
            @ExcludeMissing
            fun _professional(): JsonField<UserProfile.Professional> = professional

            /**
             * Returns the raw JSON value of [grokTranslatedBio].
             *
             * Unlike [grokTranslatedBio], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("grokTranslatedBio")
            @ExcludeMissing
            fun _grokTranslatedBio(): JsonField<UserProfile.GrokTranslatedBio> = grokTranslatedBio

            /**
             * Returns the raw JSON value of [pinnedTweetIds].
             *
             * Unlike [pinnedTweetIds], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("pinnedTweetIds")
            @ExcludeMissing
            fun _pinnedTweetIds(): JsonField<List<String>> = pinnedTweetIds

            /**
             * Returns the raw JSON value of [isAutomated].
             *
             * Unlike [isAutomated], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("isAutomated")
            @ExcludeMissing
            fun _isAutomated(): JsonField<Boolean> = isAutomated

            /**
             * Returns the raw JSON value of [automatedBy].
             *
             * Unlike [automatedBy], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("automatedBy")
            @ExcludeMissing
            fun _automatedBy(): JsonField<String> = automatedBy

            /**
             * Returns the raw JSON value of [unavailable].
             *
             * Unlike [unavailable], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("unavailable")
            @ExcludeMissing
            fun _unavailable(): JsonField<Boolean> = unavailable

            /**
             * Returns the raw JSON value of [unavailableReason].
             *
             * Unlike [unavailableReason], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("unavailableReason")
            @ExcludeMissing
            fun _unavailableReason(): JsonField<String> = unavailableReason

            /**
             * Returns the raw JSON value of [verifiedType].
             *
             * Unlike [verifiedType], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("verifiedType")
            @ExcludeMissing
            fun _verifiedType(): JsonField<String> = verifiedType

            /**
             * Returns the raw JSON value of [affiliatesHighlightedLabel].
             *
             * Unlike [affiliatesHighlightedLabel], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("affiliatesHighlightedLabel")
            @ExcludeMissing
            fun _affiliatesHighlightedLabel(): JsonField<UserProfile.AffiliatesHighlightedLabel> =
                affiliatesHighlightedLabel

            /**
             * Returns the raw JSON value of [businessAccountAffiliatesCount].
             *
             * Unlike [businessAccountAffiliatesCount], this method doesn't throw if the JSON field
             * has an unexpected type.
             */
            @JsonProperty("businessAccountAffiliatesCount")
            @ExcludeMissing
            fun _businessAccountAffiliatesCount(): JsonField<Long> = businessAccountAffiliatesCount

            /**
             * Returns the raw JSON value of [creatorSubscriptionsCount].
             *
             * Unlike [creatorSubscriptionsCount], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("creatorSubscriptionsCount")
            @ExcludeMissing
            fun _creatorSubscriptionsCount(): JsonField<Long> = creatorSubscriptionsCount

            /**
             * Returns the raw JSON value of [hasGraduatedAccess].
             *
             * Unlike [hasGraduatedAccess], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("hasGraduatedAccess")
            @ExcludeMissing
            fun _hasGraduatedAccess(): JsonField<Boolean> = hasGraduatedAccess

            /**
             * Returns the raw JSON value of [hasHiddenSubscriptionsOnProfile].
             *
             * Unlike [hasHiddenSubscriptionsOnProfile], this method doesn't throw if the JSON field
             * has an unexpected type.
             */
            @JsonProperty("hasHiddenSubscriptionsOnProfile")
            @ExcludeMissing
            fun _hasHiddenSubscriptionsOnProfile(): JsonField<Boolean> =
                hasHiddenSubscriptionsOnProfile

            /**
             * Returns the raw JSON value of [highlightsInfo].
             *
             * Unlike [highlightsInfo], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("highlightsInfo")
            @ExcludeMissing
            fun _highlightsInfo(): JsonField<UserProfile.HighlightsInfo> = highlightsInfo

            /**
             * Returns the raw JSON value of [identityVerification].
             *
             * Unlike [identityVerification], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("identityVerification")
            @ExcludeMissing
            fun _identityVerification(): JsonField<UserProfile.IdentityVerification> =
                identityVerification

            /**
             * Returns the raw JSON value of [isProfileTranslatable].
             *
             * Unlike [isProfileTranslatable], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("isProfileTranslatable")
            @ExcludeMissing
            fun _isProfileTranslatable(): JsonField<Boolean> = isProfileTranslatable

            /**
             * Returns the raw JSON value of [parodyCommentaryFanLabel].
             *
             * Unlike [parodyCommentaryFanLabel], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("parodyCommentaryFanLabel")
            @ExcludeMissing
            fun _parodyCommentaryFanLabel(): JsonField<String> = parodyCommentaryFanLabel

            /**
             * Returns the raw JSON value of [profileDescriptionLanguage].
             *
             * Unlike [profileDescriptionLanguage], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("profileDescriptionLanguage")
            @ExcludeMissing
            fun _profileDescriptionLanguage(): JsonField<String> = profileDescriptionLanguage

            /**
             * Returns the raw JSON value of [profileImageShape].
             *
             * Unlike [profileImageShape], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("profileImageShape")
            @ExcludeMissing
            fun _profileImageShape(): JsonField<String> = profileImageShape

            /**
             * Returns the raw JSON value of [profileInterstitialType].
             *
             * Unlike [profileInterstitialType], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("profileInterstitialType")
            @ExcludeMissing
            fun _profileInterstitialType(): JsonField<String> = profileInterstitialType

            /**
             * Returns the raw JSON value of [profileSortEnabled].
             *
             * Unlike [profileSortEnabled], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("profileSortEnabled")
            @ExcludeMissing
            fun _profileSortEnabled(): JsonField<Boolean> = profileSortEnabled

            /**
             * Returns the raw JSON value of [profileTranslatorType].
             *
             * Unlike [profileTranslatorType], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("profileTranslatorType")
            @ExcludeMissing
            fun _profileTranslatorType(): JsonField<String> = profileTranslatorType

            /**
             * Returns the raw JSON value of [redirectsToUsername].
             *
             * Unlike [redirectsToUsername], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("redirectsToUsername")
            @ExcludeMissing
            fun _redirectsToUsername(): JsonField<String> = redirectsToUsername

            /**
             * Returns the raw JSON value of [superFollowEligible].
             *
             * Unlike [superFollowEligible], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("superFollowEligible")
            @ExcludeMissing
            fun _superFollowEligible(): JsonField<Boolean> = superFollowEligible

            /**
             * Returns the raw JSON value of [superFollowsUserProfileActive].
             *
             * Unlike [superFollowsUserProfileActive], this method doesn't throw if the JSON field
             * has an unexpected type.
             */
            @JsonProperty("superFollowsUserProfileActive")
            @ExcludeMissing
            fun _superFollowsUserProfileActive(): JsonField<Boolean> = superFollowsUserProfileActive

            /**
             * Returns the raw JSON value of [tipJar].
             *
             * Unlike [tipJar], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("tipJar")
            @ExcludeMissing
            fun _tipJar(): JsonField<UserProfile.TipJar> = tipJar

            /**
             * Returns the raw JSON value of [listedCount].
             *
             * Unlike [listedCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("listedCount")
            @ExcludeMissing
            fun _listedCount(): JsonField<Long> = listedCount

            /**
             * Returns the raw JSON value of [fastFollowersCount].
             *
             * Unlike [fastFollowersCount], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("fastFollowersCount")
            @ExcludeMissing
            fun _fastFollowersCount(): JsonField<Long> = fastFollowersCount

            /**
             * Returns the raw JSON value of [normalFollowersCount].
             *
             * Unlike [normalFollowersCount], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("normalFollowersCount")
            @ExcludeMissing
            fun _normalFollowersCount(): JsonField<Long> = normalFollowersCount

            /**
             * Returns the raw JSON value of [defaultProfile].
             *
             * Unlike [defaultProfile], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("defaultProfile")
            @ExcludeMissing
            fun _defaultProfile(): JsonField<Boolean> = defaultProfile

            /**
             * Returns the raw JSON value of [defaultProfileImage].
             *
             * Unlike [defaultProfileImage], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("defaultProfileImage")
            @ExcludeMissing
            fun _defaultProfileImage(): JsonField<Boolean> = defaultProfileImage

            /**
             * Returns the raw JSON value of [hasExtendedProfile].
             *
             * Unlike [hasExtendedProfile], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("hasExtendedProfile")
            @ExcludeMissing
            fun _hasExtendedProfile(): JsonField<Boolean> = hasExtendedProfile

            /**
             * Returns the raw JSON value of [isTranslationEnabled].
             *
             * Unlike [isTranslationEnabled], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("isTranslationEnabled")
            @ExcludeMissing
            fun _isTranslationEnabled(): JsonField<Boolean> = isTranslationEnabled

            /**
             * Returns the raw JSON value of [geoEnabled].
             *
             * Unlike [geoEnabled], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("geoEnabled")
            @ExcludeMissing
            fun _geoEnabled(): JsonField<Boolean> = geoEnabled

            /**
             * Returns the raw JSON value of [advertiserAccountType].
             *
             * Unlike [advertiserAccountType], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("advertiserAccountType")
            @ExcludeMissing
            fun _advertiserAccountType(): JsonField<String> = advertiserAccountType

            /**
             * Returns the raw JSON value of [advertiserAccountServiceLevels].
             *
             * Unlike [advertiserAccountServiceLevels], this method doesn't throw if the JSON field
             * has an unexpected type.
             */
            @JsonProperty("advertiserAccountServiceLevels")
            @ExcludeMissing
            fun _advertiserAccountServiceLevels(): JsonField<List<String>> =
                advertiserAccountServiceLevels

            /**
             * Returns the raw JSON value of [businessProfileState].
             *
             * Unlike [businessProfileState], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("businessProfileState")
            @ExcludeMissing
            fun _businessProfileState(): JsonField<String> = businessProfileState

            /**
             * Returns the raw JSON value of [subscribersCount].
             *
             * Unlike [subscribersCount], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("subscribersCount")
            @ExcludeMissing
            fun _subscribersCount(): JsonField<Long> = subscribersCount

            /**
             * Returns the raw JSON value of [verificationReason].
             *
             * Unlike [verificationReason], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("verificationReason")
            @ExcludeMissing
            fun _verificationReason(): JsonField<UserProfile.VerificationReason> =
                verificationReason

            /**
             * Returns the raw JSON value of [communityRole].
             *
             * Unlike [communityRole], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("communityRole")
            @ExcludeMissing
            fun _communityRole(): JsonField<String> = communityRole

            /**
             * Returns the raw JSON value of [profileBio].
             *
             * Unlike [profileBio], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("profile_bio")
            @ExcludeMissing
            fun _profileBio(): JsonField<UserProfile.ProfileBio> = profileBio

            /**
             * Returns the raw JSON value of [userName].
             *
             * Unlike [userName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("userName") @ExcludeMissing fun _userName(): JsonField<String> = userName

            /**
             * Returns the raw JSON value of [rawVerified].
             *
             * Unlike [rawVerified], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("rawVerified")
            @ExcludeMissing
            fun _rawVerified(): JsonField<Boolean> = rawVerified

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
                /** Returns a mutable builder for constructing an instance of [Author]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Author]. */
            class Builder internal constructor() {
                private var id: JsonField<String> = JsonMissing.of()
                private var username: JsonField<String> = JsonMissing.of()
                private var name: JsonField<String> = JsonMissing.of()
                private var description: JsonField<String> = JsonMissing.of()
                private var followers: JsonField<Long> = JsonMissing.of()
                private var following: JsonField<Long> = JsonMissing.of()
                private var verified: JsonField<Boolean> = JsonMissing.of()
                private var isBlueVerified: JsonField<Boolean> = JsonMissing.of()
                private var isVerified: JsonField<Boolean> = JsonMissing.of()
                private var profilePicture: JsonField<String> = JsonMissing.of()
                private var profilePictureOriginal: JsonField<String> = JsonMissing.of()
                private var coverPicture: JsonField<String> = JsonMissing.of()
                private var profileBannerUrl: JsonField<String> = JsonMissing.of()
                private var location: JsonField<String> = JsonMissing.of()
                private var accountBasedIn: JsonField<UserProfile.AccountBasedIn> = JsonMissing.of()
                private var accountBasedInUnavailable: JsonField<Boolean> = JsonMissing.of()
                private var accountBasedInAccurate: JsonField<Boolean> = JsonMissing.of()
                private var connectedVia: JsonField<String> = JsonMissing.of()
                private var connectedViaAccurate: JsonField<Boolean> = JsonMissing.of()
                private var affiliateUsername: JsonField<String> = JsonMissing.of()
                private var email: JsonField<String> = JsonMissing.of()
                private var contactInfo: JsonField<UserProfile.ContactInfo> = JsonMissing.of()
                private var usernameChanges: JsonField<UserProfile.UsernameChanges> =
                    JsonMissing.of()
                private var birthdate: JsonField<UserProfile.Birthdate> = JsonMissing.of()
                private var retweetedAt: JsonField<OffsetDateTime> = JsonMissing.of()
                private var createdAt: JsonField<String> = JsonMissing.of()
                private var statusesCount: JsonField<Long> = JsonMissing.of()
                private var mediaCount: JsonField<Long> = JsonMissing.of()
                private var protected_: JsonField<Boolean> = JsonMissing.of()
                private var url: JsonField<String> = JsonMissing.of()
                private var favouritesCount: JsonField<Long> = JsonMissing.of()
                private var hasCustomTimelines: JsonField<Boolean> = JsonMissing.of()
                private var isTranslator: JsonField<Boolean> = JsonMissing.of()
                private var withheldInCountries: JsonField<MutableList<String>>? = null
                private var withheldScope: JsonField<String> = JsonMissing.of()
                private var possiblySensitive: JsonField<Boolean> = JsonMissing.of()
                private var professional: JsonField<UserProfile.Professional> = JsonMissing.of()
                private var grokTranslatedBio: JsonField<UserProfile.GrokTranslatedBio> =
                    JsonMissing.of()
                private var pinnedTweetIds: JsonField<MutableList<String>>? = null
                private var isAutomated: JsonField<Boolean> = JsonMissing.of()
                private var automatedBy: JsonField<String> = JsonMissing.of()
                private var unavailable: JsonField<Boolean> = JsonMissing.of()
                private var unavailableReason: JsonField<String> = JsonMissing.of()
                private var verifiedType: JsonField<String> = JsonMissing.of()
                private var affiliatesHighlightedLabel:
                    JsonField<UserProfile.AffiliatesHighlightedLabel> =
                    JsonMissing.of()
                private var businessAccountAffiliatesCount: JsonField<Long> = JsonMissing.of()
                private var creatorSubscriptionsCount: JsonField<Long> = JsonMissing.of()
                private var hasGraduatedAccess: JsonField<Boolean> = JsonMissing.of()
                private var hasHiddenSubscriptionsOnProfile: JsonField<Boolean> = JsonMissing.of()
                private var highlightsInfo: JsonField<UserProfile.HighlightsInfo> = JsonMissing.of()
                private var identityVerification: JsonField<UserProfile.IdentityVerification> =
                    JsonMissing.of()
                private var isProfileTranslatable: JsonField<Boolean> = JsonMissing.of()
                private var parodyCommentaryFanLabel: JsonField<String> = JsonMissing.of()
                private var profileDescriptionLanguage: JsonField<String> = JsonMissing.of()
                private var profileImageShape: JsonField<String> = JsonMissing.of()
                private var profileInterstitialType: JsonField<String> = JsonMissing.of()
                private var profileSortEnabled: JsonField<Boolean> = JsonMissing.of()
                private var profileTranslatorType: JsonField<String> = JsonMissing.of()
                private var redirectsToUsername: JsonField<String> = JsonMissing.of()
                private var superFollowEligible: JsonField<Boolean> = JsonMissing.of()
                private var superFollowsUserProfileActive: JsonField<Boolean> = JsonMissing.of()
                private var tipJar: JsonField<UserProfile.TipJar> = JsonMissing.of()
                private var listedCount: JsonField<Long> = JsonMissing.of()
                private var fastFollowersCount: JsonField<Long> = JsonMissing.of()
                private var normalFollowersCount: JsonField<Long> = JsonMissing.of()
                private var defaultProfile: JsonField<Boolean> = JsonMissing.of()
                private var defaultProfileImage: JsonField<Boolean> = JsonMissing.of()
                private var hasExtendedProfile: JsonField<Boolean> = JsonMissing.of()
                private var isTranslationEnabled: JsonField<Boolean> = JsonMissing.of()
                private var geoEnabled: JsonField<Boolean> = JsonMissing.of()
                private var advertiserAccountType: JsonField<String> = JsonMissing.of()
                private var advertiserAccountServiceLevels: JsonField<MutableList<String>>? = null
                private var businessProfileState: JsonField<String> = JsonMissing.of()
                private var subscribersCount: JsonField<Long> = JsonMissing.of()
                private var verificationReason: JsonField<UserProfile.VerificationReason> =
                    JsonMissing.of()
                private var communityRole: JsonField<String> = JsonMissing.of()
                private var profileBio: JsonField<UserProfile.ProfileBio> = JsonMissing.of()
                private var userName: JsonField<String> = JsonMissing.of()
                private var rawVerified: JsonField<Boolean> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(author: Author) = apply {
                    id = author.id
                    username = author.username
                    name = author.name
                    description = author.description
                    followers = author.followers
                    following = author.following
                    verified = author.verified
                    isBlueVerified = author.isBlueVerified
                    isVerified = author.isVerified
                    profilePicture = author.profilePicture
                    profilePictureOriginal = author.profilePictureOriginal
                    coverPicture = author.coverPicture
                    profileBannerUrl = author.profileBannerUrl
                    location = author.location
                    accountBasedIn = author.accountBasedIn
                    accountBasedInUnavailable = author.accountBasedInUnavailable
                    accountBasedInAccurate = author.accountBasedInAccurate
                    connectedVia = author.connectedVia
                    connectedViaAccurate = author.connectedViaAccurate
                    affiliateUsername = author.affiliateUsername
                    email = author.email
                    contactInfo = author.contactInfo
                    usernameChanges = author.usernameChanges
                    birthdate = author.birthdate
                    retweetedAt = author.retweetedAt
                    createdAt = author.createdAt
                    statusesCount = author.statusesCount
                    mediaCount = author.mediaCount
                    protected_ = author.protected_
                    url = author.url
                    favouritesCount = author.favouritesCount
                    hasCustomTimelines = author.hasCustomTimelines
                    isTranslator = author.isTranslator
                    withheldInCountries = author.withheldInCountries.map { it.toMutableList() }
                    withheldScope = author.withheldScope
                    possiblySensitive = author.possiblySensitive
                    professional = author.professional
                    grokTranslatedBio = author.grokTranslatedBio
                    pinnedTweetIds = author.pinnedTweetIds.map { it.toMutableList() }
                    isAutomated = author.isAutomated
                    automatedBy = author.automatedBy
                    unavailable = author.unavailable
                    unavailableReason = author.unavailableReason
                    verifiedType = author.verifiedType
                    affiliatesHighlightedLabel = author.affiliatesHighlightedLabel
                    businessAccountAffiliatesCount = author.businessAccountAffiliatesCount
                    creatorSubscriptionsCount = author.creatorSubscriptionsCount
                    hasGraduatedAccess = author.hasGraduatedAccess
                    hasHiddenSubscriptionsOnProfile = author.hasHiddenSubscriptionsOnProfile
                    highlightsInfo = author.highlightsInfo
                    identityVerification = author.identityVerification
                    isProfileTranslatable = author.isProfileTranslatable
                    parodyCommentaryFanLabel = author.parodyCommentaryFanLabel
                    profileDescriptionLanguage = author.profileDescriptionLanguage
                    profileImageShape = author.profileImageShape
                    profileInterstitialType = author.profileInterstitialType
                    profileSortEnabled = author.profileSortEnabled
                    profileTranslatorType = author.profileTranslatorType
                    redirectsToUsername = author.redirectsToUsername
                    superFollowEligible = author.superFollowEligible
                    superFollowsUserProfileActive = author.superFollowsUserProfileActive
                    tipJar = author.tipJar
                    listedCount = author.listedCount
                    fastFollowersCount = author.fastFollowersCount
                    normalFollowersCount = author.normalFollowersCount
                    defaultProfile = author.defaultProfile
                    defaultProfileImage = author.defaultProfileImage
                    hasExtendedProfile = author.hasExtendedProfile
                    isTranslationEnabled = author.isTranslationEnabled
                    geoEnabled = author.geoEnabled
                    advertiserAccountType = author.advertiserAccountType
                    advertiserAccountServiceLevels =
                        author.advertiserAccountServiceLevels.map { it.toMutableList() }
                    businessProfileState = author.businessProfileState
                    subscribersCount = author.subscribersCount
                    verificationReason = author.verificationReason
                    communityRole = author.communityRole
                    profileBio = author.profileBio
                    userName = author.userName
                    rawVerified = author.rawVerified
                    additionalProperties = author.additionalProperties.toMutableMap()
                }

                fun id(id: String) = id(JsonField.of(id))

                /** Sets [Builder.id] to an arbitrary JSON value. */
                fun id(id: JsonField<String>) = apply { this.id = id }

                fun username(username: String) = username(JsonField.of(username))

                /** Sets [Builder.username] to an arbitrary JSON value. */
                fun username(username: JsonField<String>) = apply { this.username = username }

                fun name(name: String) = name(JsonField.of(name))

                /** Sets [Builder.name] to an arbitrary JSON value. */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun description(description: String) = description(JsonField.of(description))

                /** Sets [Builder.description] to an arbitrary JSON value. */
                fun description(description: JsonField<String>) = apply {
                    this.description = description
                }

                fun followers(followers: Long) = followers(JsonField.of(followers))

                /** Sets [Builder.followers] to an arbitrary JSON value. */
                fun followers(followers: JsonField<Long>) = apply { this.followers = followers }

                fun following(following: Long) = following(JsonField.of(following))

                /** Sets [Builder.following] to an arbitrary JSON value. */
                fun following(following: JsonField<Long>) = apply { this.following = following }

                fun verified(verified: Boolean) = verified(JsonField.of(verified))

                /** Sets [Builder.verified] to an arbitrary JSON value. */
                fun verified(verified: JsonField<Boolean>) = apply { this.verified = verified }

                fun isBlueVerified(isBlueVerified: Boolean) =
                    isBlueVerified(JsonField.of(isBlueVerified))

                /** Sets [Builder.isBlueVerified] to an arbitrary JSON value. */
                fun isBlueVerified(isBlueVerified: JsonField<Boolean>) = apply {
                    this.isBlueVerified = isBlueVerified
                }

                fun isVerified(isVerified: Boolean) = isVerified(JsonField.of(isVerified))

                /** Sets [Builder.isVerified] to an arbitrary JSON value. */
                fun isVerified(isVerified: JsonField<Boolean>) = apply {
                    this.isVerified = isVerified
                }

                fun profilePicture(profilePicture: String) =
                    profilePicture(JsonField.of(profilePicture))

                /** Sets [Builder.profilePicture] to an arbitrary JSON value. */
                fun profilePicture(profilePicture: JsonField<String>) = apply {
                    this.profilePicture = profilePicture
                }

                fun profilePictureOriginal(profilePictureOriginal: String) =
                    profilePictureOriginal(JsonField.of(profilePictureOriginal))

                /** Sets [Builder.profilePictureOriginal] to an arbitrary JSON value. */
                fun profilePictureOriginal(profilePictureOriginal: JsonField<String>) = apply {
                    this.profilePictureOriginal = profilePictureOriginal
                }

                fun coverPicture(coverPicture: String) = coverPicture(JsonField.of(coverPicture))

                /** Sets [Builder.coverPicture] to an arbitrary JSON value. */
                fun coverPicture(coverPicture: JsonField<String>) = apply {
                    this.coverPicture = coverPicture
                }

                fun profileBannerUrl(profileBannerUrl: String) =
                    profileBannerUrl(JsonField.of(profileBannerUrl))

                /** Sets [Builder.profileBannerUrl] to an arbitrary JSON value. */
                fun profileBannerUrl(profileBannerUrl: JsonField<String>) = apply {
                    this.profileBannerUrl = profileBannerUrl
                }

                fun location(location: String) = location(JsonField.of(location))

                /** Sets [Builder.location] to an arbitrary JSON value. */
                fun location(location: JsonField<String>) = apply { this.location = location }

                fun accountBasedIn(accountBasedIn: UserProfile.AccountBasedIn?) =
                    accountBasedIn(JsonField.ofNullable(accountBasedIn))

                /**
                 * Alias for calling [Builder.accountBasedIn] with `accountBasedIn.orElse(null)`.
                 */
                fun accountBasedIn(accountBasedIn: Optional<UserProfile.AccountBasedIn>) =
                    accountBasedIn(accountBasedIn.getOrNull())

                /** Sets [Builder.accountBasedIn] to an arbitrary JSON value. */
                fun accountBasedIn(accountBasedIn: JsonField<UserProfile.AccountBasedIn>) = apply {
                    this.accountBasedIn = accountBasedIn
                }

                fun accountBasedInUnavailable(accountBasedInUnavailable: Boolean) =
                    accountBasedInUnavailable(JsonField.of(accountBasedInUnavailable))

                /** Sets [Builder.accountBasedInUnavailable] to an arbitrary JSON value. */
                fun accountBasedInUnavailable(accountBasedInUnavailable: JsonField<Boolean>) =
                    apply {
                        this.accountBasedInUnavailable = accountBasedInUnavailable
                    }

                fun accountBasedInAccurate(accountBasedInAccurate: Boolean) =
                    accountBasedInAccurate(JsonField.of(accountBasedInAccurate))

                /** Sets [Builder.accountBasedInAccurate] to an arbitrary JSON value. */
                fun accountBasedInAccurate(accountBasedInAccurate: JsonField<Boolean>) = apply {
                    this.accountBasedInAccurate = accountBasedInAccurate
                }

                fun connectedVia(connectedVia: String) = connectedVia(JsonField.of(connectedVia))

                /** Sets [Builder.connectedVia] to an arbitrary JSON value. */
                fun connectedVia(connectedVia: JsonField<String>) = apply {
                    this.connectedVia = connectedVia
                }

                fun connectedViaAccurate(connectedViaAccurate: Boolean) =
                    connectedViaAccurate(JsonField.of(connectedViaAccurate))

                /** Sets [Builder.connectedViaAccurate] to an arbitrary JSON value. */
                fun connectedViaAccurate(connectedViaAccurate: JsonField<Boolean>) = apply {
                    this.connectedViaAccurate = connectedViaAccurate
                }

                fun affiliateUsername(affiliateUsername: String) =
                    affiliateUsername(JsonField.of(affiliateUsername))

                /** Sets [Builder.affiliateUsername] to an arbitrary JSON value. */
                fun affiliateUsername(affiliateUsername: JsonField<String>) = apply {
                    this.affiliateUsername = affiliateUsername
                }

                fun email(email: String) = email(JsonField.of(email))

                /** Sets [Builder.email] to an arbitrary JSON value. */
                fun email(email: JsonField<String>) = apply { this.email = email }

                fun contactInfo(contactInfo: UserProfile.ContactInfo) =
                    contactInfo(JsonField.of(contactInfo))

                /** Sets [Builder.contactInfo] to an arbitrary JSON value. */
                fun contactInfo(contactInfo: JsonField<UserProfile.ContactInfo>) = apply {
                    this.contactInfo = contactInfo
                }

                fun usernameChanges(usernameChanges: UserProfile.UsernameChanges) =
                    usernameChanges(JsonField.of(usernameChanges))

                /** Sets [Builder.usernameChanges] to an arbitrary JSON value. */
                fun usernameChanges(usernameChanges: JsonField<UserProfile.UsernameChanges>) =
                    apply {
                        this.usernameChanges = usernameChanges
                    }

                fun birthdate(birthdate: UserProfile.Birthdate) = birthdate(JsonField.of(birthdate))

                /** Sets [Builder.birthdate] to an arbitrary JSON value. */
                fun birthdate(birthdate: JsonField<UserProfile.Birthdate>) = apply {
                    this.birthdate = birthdate
                }

                fun retweetedAt(retweetedAt: OffsetDateTime?) =
                    retweetedAt(JsonField.ofNullable(retweetedAt))

                /** Alias for calling [Builder.retweetedAt] with `retweetedAt.orElse(null)`. */
                fun retweetedAt(retweetedAt: Optional<OffsetDateTime>) =
                    retweetedAt(retweetedAt.getOrNull())

                /** Sets [Builder.retweetedAt] to an arbitrary JSON value. */
                fun retweetedAt(retweetedAt: JsonField<OffsetDateTime>) = apply {
                    this.retweetedAt = retweetedAt
                }

                fun createdAt(createdAt: String) = createdAt(JsonField.of(createdAt))

                /** Sets [Builder.createdAt] to an arbitrary JSON value. */
                fun createdAt(createdAt: JsonField<String>) = apply { this.createdAt = createdAt }

                fun statusesCount(statusesCount: Long) = statusesCount(JsonField.of(statusesCount))

                /** Sets [Builder.statusesCount] to an arbitrary JSON value. */
                fun statusesCount(statusesCount: JsonField<Long>) = apply {
                    this.statusesCount = statusesCount
                }

                fun mediaCount(mediaCount: Long) = mediaCount(JsonField.of(mediaCount))

                /** Sets [Builder.mediaCount] to an arbitrary JSON value. */
                fun mediaCount(mediaCount: JsonField<Long>) = apply { this.mediaCount = mediaCount }

                fun protected_(protected_: Boolean) = protected_(JsonField.of(protected_))

                /** Sets [Builder.protected_] to an arbitrary JSON value. */
                fun protected_(protected_: JsonField<Boolean>) = apply {
                    this.protected_ = protected_
                }

                fun url(url: String) = url(JsonField.of(url))

                /** Sets [Builder.url] to an arbitrary JSON value. */
                fun url(url: JsonField<String>) = apply { this.url = url }

                fun favouritesCount(favouritesCount: Long) =
                    favouritesCount(JsonField.of(favouritesCount))

                /** Sets [Builder.favouritesCount] to an arbitrary JSON value. */
                fun favouritesCount(favouritesCount: JsonField<Long>) = apply {
                    this.favouritesCount = favouritesCount
                }

                fun hasCustomTimelines(hasCustomTimelines: Boolean) =
                    hasCustomTimelines(JsonField.of(hasCustomTimelines))

                /** Sets [Builder.hasCustomTimelines] to an arbitrary JSON value. */
                fun hasCustomTimelines(hasCustomTimelines: JsonField<Boolean>) = apply {
                    this.hasCustomTimelines = hasCustomTimelines
                }

                fun isTranslator(isTranslator: Boolean) = isTranslator(JsonField.of(isTranslator))

                /** Sets [Builder.isTranslator] to an arbitrary JSON value. */
                fun isTranslator(isTranslator: JsonField<Boolean>) = apply {
                    this.isTranslator = isTranslator
                }

                fun withheldInCountries(withheldInCountries: List<String>) =
                    withheldInCountries(JsonField.of(withheldInCountries))

                /** Sets [Builder.withheldInCountries] to an arbitrary JSON value. */
                fun withheldInCountries(withheldInCountries: JsonField<List<String>>) = apply {
                    this.withheldInCountries = withheldInCountries.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [withheldInCountries].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addWithheldInCountry(withheldInCountry: String) = apply {
                    this.withheldInCountries =
                        (this.withheldInCountries ?: JsonField.of(mutableListOf())).also {
                            checkKnown("withheldInCountries", it).add(withheldInCountry)
                        }
                }

                fun withheldScope(withheldScope: String) =
                    withheldScope(JsonField.of(withheldScope))

                /** Sets [Builder.withheldScope] to an arbitrary JSON value. */
                fun withheldScope(withheldScope: JsonField<String>) = apply {
                    this.withheldScope = withheldScope
                }

                fun possiblySensitive(possiblySensitive: Boolean) =
                    possiblySensitive(JsonField.of(possiblySensitive))

                /** Sets [Builder.possiblySensitive] to an arbitrary JSON value. */
                fun possiblySensitive(possiblySensitive: JsonField<Boolean>) = apply {
                    this.possiblySensitive = possiblySensitive
                }

                fun professional(professional: UserProfile.Professional) =
                    professional(JsonField.of(professional))

                /** Sets [Builder.professional] to an arbitrary JSON value. */
                fun professional(professional: JsonField<UserProfile.Professional>) = apply {
                    this.professional = professional
                }

                fun grokTranslatedBio(grokTranslatedBio: UserProfile.GrokTranslatedBio) =
                    grokTranslatedBio(JsonField.of(grokTranslatedBio))

                /** Sets [Builder.grokTranslatedBio] to an arbitrary JSON value. */
                fun grokTranslatedBio(grokTranslatedBio: JsonField<UserProfile.GrokTranslatedBio>) =
                    apply {
                        this.grokTranslatedBio = grokTranslatedBio
                    }

                fun pinnedTweetIds(pinnedTweetIds: List<String>) =
                    pinnedTweetIds(JsonField.of(pinnedTweetIds))

                /** Sets [Builder.pinnedTweetIds] to an arbitrary JSON value. */
                fun pinnedTweetIds(pinnedTweetIds: JsonField<List<String>>) = apply {
                    this.pinnedTweetIds = pinnedTweetIds.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [pinnedTweetIds].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addPinnedTweetId(pinnedTweetId: String) = apply {
                    this.pinnedTweetIds =
                        (this.pinnedTweetIds ?: JsonField.of(mutableListOf())).also {
                            checkKnown("pinnedTweetIds", it).add(pinnedTweetId)
                        }
                }

                fun isAutomated(isAutomated: Boolean) = isAutomated(JsonField.of(isAutomated))

                /** Sets [Builder.isAutomated] to an arbitrary JSON value. */
                fun isAutomated(isAutomated: JsonField<Boolean>) = apply {
                    this.isAutomated = isAutomated
                }

                fun automatedBy(automatedBy: String) = automatedBy(JsonField.of(automatedBy))

                /** Sets [Builder.automatedBy] to an arbitrary JSON value. */
                fun automatedBy(automatedBy: JsonField<String>) = apply {
                    this.automatedBy = automatedBy
                }

                fun unavailable(unavailable: Boolean) = unavailable(JsonField.of(unavailable))

                /** Sets [Builder.unavailable] to an arbitrary JSON value. */
                fun unavailable(unavailable: JsonField<Boolean>) = apply {
                    this.unavailable = unavailable
                }

                fun unavailableReason(unavailableReason: String) =
                    unavailableReason(JsonField.of(unavailableReason))

                /** Sets [Builder.unavailableReason] to an arbitrary JSON value. */
                fun unavailableReason(unavailableReason: JsonField<String>) = apply {
                    this.unavailableReason = unavailableReason
                }

                fun verifiedType(verifiedType: String) = verifiedType(JsonField.of(verifiedType))

                /** Sets [Builder.verifiedType] to an arbitrary JSON value. */
                fun verifiedType(verifiedType: JsonField<String>) = apply {
                    this.verifiedType = verifiedType
                }

                fun affiliatesHighlightedLabel(
                    affiliatesHighlightedLabel: UserProfile.AffiliatesHighlightedLabel
                ) = affiliatesHighlightedLabel(JsonField.of(affiliatesHighlightedLabel))

                /** Sets [Builder.affiliatesHighlightedLabel] to an arbitrary JSON value. */
                fun affiliatesHighlightedLabel(
                    affiliatesHighlightedLabel: JsonField<UserProfile.AffiliatesHighlightedLabel>
                ) = apply { this.affiliatesHighlightedLabel = affiliatesHighlightedLabel }

                fun businessAccountAffiliatesCount(businessAccountAffiliatesCount: Long) =
                    businessAccountAffiliatesCount(JsonField.of(businessAccountAffiliatesCount))

                /** Sets [Builder.businessAccountAffiliatesCount] to an arbitrary JSON value. */
                fun businessAccountAffiliatesCount(
                    businessAccountAffiliatesCount: JsonField<Long>
                ) = apply { this.businessAccountAffiliatesCount = businessAccountAffiliatesCount }

                fun creatorSubscriptionsCount(creatorSubscriptionsCount: Long) =
                    creatorSubscriptionsCount(JsonField.of(creatorSubscriptionsCount))

                /** Sets [Builder.creatorSubscriptionsCount] to an arbitrary JSON value. */
                fun creatorSubscriptionsCount(creatorSubscriptionsCount: JsonField<Long>) = apply {
                    this.creatorSubscriptionsCount = creatorSubscriptionsCount
                }

                fun hasGraduatedAccess(hasGraduatedAccess: Boolean) =
                    hasGraduatedAccess(JsonField.of(hasGraduatedAccess))

                /** Sets [Builder.hasGraduatedAccess] to an arbitrary JSON value. */
                fun hasGraduatedAccess(hasGraduatedAccess: JsonField<Boolean>) = apply {
                    this.hasGraduatedAccess = hasGraduatedAccess
                }

                fun hasHiddenSubscriptionsOnProfile(hasHiddenSubscriptionsOnProfile: Boolean) =
                    hasHiddenSubscriptionsOnProfile(JsonField.of(hasHiddenSubscriptionsOnProfile))

                /** Sets [Builder.hasHiddenSubscriptionsOnProfile] to an arbitrary JSON value. */
                fun hasHiddenSubscriptionsOnProfile(
                    hasHiddenSubscriptionsOnProfile: JsonField<Boolean>
                ) = apply { this.hasHiddenSubscriptionsOnProfile = hasHiddenSubscriptionsOnProfile }

                fun highlightsInfo(highlightsInfo: UserProfile.HighlightsInfo) =
                    highlightsInfo(JsonField.of(highlightsInfo))

                /** Sets [Builder.highlightsInfo] to an arbitrary JSON value. */
                fun highlightsInfo(highlightsInfo: JsonField<UserProfile.HighlightsInfo>) = apply {
                    this.highlightsInfo = highlightsInfo
                }

                fun identityVerification(identityVerification: UserProfile.IdentityVerification) =
                    identityVerification(JsonField.of(identityVerification))

                /** Sets [Builder.identityVerification] to an arbitrary JSON value. */
                fun identityVerification(
                    identityVerification: JsonField<UserProfile.IdentityVerification>
                ) = apply { this.identityVerification = identityVerification }

                fun isProfileTranslatable(isProfileTranslatable: Boolean) =
                    isProfileTranslatable(JsonField.of(isProfileTranslatable))

                /** Sets [Builder.isProfileTranslatable] to an arbitrary JSON value. */
                fun isProfileTranslatable(isProfileTranslatable: JsonField<Boolean>) = apply {
                    this.isProfileTranslatable = isProfileTranslatable
                }

                fun parodyCommentaryFanLabel(parodyCommentaryFanLabel: String) =
                    parodyCommentaryFanLabel(JsonField.of(parodyCommentaryFanLabel))

                /** Sets [Builder.parodyCommentaryFanLabel] to an arbitrary JSON value. */
                fun parodyCommentaryFanLabel(parodyCommentaryFanLabel: JsonField<String>) = apply {
                    this.parodyCommentaryFanLabel = parodyCommentaryFanLabel
                }

                fun profileDescriptionLanguage(profileDescriptionLanguage: String) =
                    profileDescriptionLanguage(JsonField.of(profileDescriptionLanguage))

                /** Sets [Builder.profileDescriptionLanguage] to an arbitrary JSON value. */
                fun profileDescriptionLanguage(profileDescriptionLanguage: JsonField<String>) =
                    apply {
                        this.profileDescriptionLanguage = profileDescriptionLanguage
                    }

                fun profileImageShape(profileImageShape: String) =
                    profileImageShape(JsonField.of(profileImageShape))

                /** Sets [Builder.profileImageShape] to an arbitrary JSON value. */
                fun profileImageShape(profileImageShape: JsonField<String>) = apply {
                    this.profileImageShape = profileImageShape
                }

                fun profileInterstitialType(profileInterstitialType: String) =
                    profileInterstitialType(JsonField.of(profileInterstitialType))

                /** Sets [Builder.profileInterstitialType] to an arbitrary JSON value. */
                fun profileInterstitialType(profileInterstitialType: JsonField<String>) = apply {
                    this.profileInterstitialType = profileInterstitialType
                }

                fun profileSortEnabled(profileSortEnabled: Boolean) =
                    profileSortEnabled(JsonField.of(profileSortEnabled))

                /** Sets [Builder.profileSortEnabled] to an arbitrary JSON value. */
                fun profileSortEnabled(profileSortEnabled: JsonField<Boolean>) = apply {
                    this.profileSortEnabled = profileSortEnabled
                }

                fun profileTranslatorType(profileTranslatorType: String) =
                    profileTranslatorType(JsonField.of(profileTranslatorType))

                /** Sets [Builder.profileTranslatorType] to an arbitrary JSON value. */
                fun profileTranslatorType(profileTranslatorType: JsonField<String>) = apply {
                    this.profileTranslatorType = profileTranslatorType
                }

                fun redirectsToUsername(redirectsToUsername: String) =
                    redirectsToUsername(JsonField.of(redirectsToUsername))

                /** Sets [Builder.redirectsToUsername] to an arbitrary JSON value. */
                fun redirectsToUsername(redirectsToUsername: JsonField<String>) = apply {
                    this.redirectsToUsername = redirectsToUsername
                }

                fun superFollowEligible(superFollowEligible: Boolean) =
                    superFollowEligible(JsonField.of(superFollowEligible))

                /** Sets [Builder.superFollowEligible] to an arbitrary JSON value. */
                fun superFollowEligible(superFollowEligible: JsonField<Boolean>) = apply {
                    this.superFollowEligible = superFollowEligible
                }

                fun superFollowsUserProfileActive(superFollowsUserProfileActive: Boolean) =
                    superFollowsUserProfileActive(JsonField.of(superFollowsUserProfileActive))

                /** Sets [Builder.superFollowsUserProfileActive] to an arbitrary JSON value. */
                fun superFollowsUserProfileActive(
                    superFollowsUserProfileActive: JsonField<Boolean>
                ) = apply { this.superFollowsUserProfileActive = superFollowsUserProfileActive }

                fun tipJar(tipJar: UserProfile.TipJar) = tipJar(JsonField.of(tipJar))

                /** Sets [Builder.tipJar] to an arbitrary JSON value. */
                fun tipJar(tipJar: JsonField<UserProfile.TipJar>) = apply { this.tipJar = tipJar }

                fun listedCount(listedCount: Long) = listedCount(JsonField.of(listedCount))

                /** Sets [Builder.listedCount] to an arbitrary JSON value. */
                fun listedCount(listedCount: JsonField<Long>) = apply {
                    this.listedCount = listedCount
                }

                fun fastFollowersCount(fastFollowersCount: Long) =
                    fastFollowersCount(JsonField.of(fastFollowersCount))

                /** Sets [Builder.fastFollowersCount] to an arbitrary JSON value. */
                fun fastFollowersCount(fastFollowersCount: JsonField<Long>) = apply {
                    this.fastFollowersCount = fastFollowersCount
                }

                fun normalFollowersCount(normalFollowersCount: Long) =
                    normalFollowersCount(JsonField.of(normalFollowersCount))

                /** Sets [Builder.normalFollowersCount] to an arbitrary JSON value. */
                fun normalFollowersCount(normalFollowersCount: JsonField<Long>) = apply {
                    this.normalFollowersCount = normalFollowersCount
                }

                fun defaultProfile(defaultProfile: Boolean) =
                    defaultProfile(JsonField.of(defaultProfile))

                /** Sets [Builder.defaultProfile] to an arbitrary JSON value. */
                fun defaultProfile(defaultProfile: JsonField<Boolean>) = apply {
                    this.defaultProfile = defaultProfile
                }

                fun defaultProfileImage(defaultProfileImage: Boolean) =
                    defaultProfileImage(JsonField.of(defaultProfileImage))

                /** Sets [Builder.defaultProfileImage] to an arbitrary JSON value. */
                fun defaultProfileImage(defaultProfileImage: JsonField<Boolean>) = apply {
                    this.defaultProfileImage = defaultProfileImage
                }

                fun hasExtendedProfile(hasExtendedProfile: Boolean) =
                    hasExtendedProfile(JsonField.of(hasExtendedProfile))

                /** Sets [Builder.hasExtendedProfile] to an arbitrary JSON value. */
                fun hasExtendedProfile(hasExtendedProfile: JsonField<Boolean>) = apply {
                    this.hasExtendedProfile = hasExtendedProfile
                }

                fun isTranslationEnabled(isTranslationEnabled: Boolean) =
                    isTranslationEnabled(JsonField.of(isTranslationEnabled))

                /** Sets [Builder.isTranslationEnabled] to an arbitrary JSON value. */
                fun isTranslationEnabled(isTranslationEnabled: JsonField<Boolean>) = apply {
                    this.isTranslationEnabled = isTranslationEnabled
                }

                fun geoEnabled(geoEnabled: Boolean) = geoEnabled(JsonField.of(geoEnabled))

                /** Sets [Builder.geoEnabled] to an arbitrary JSON value. */
                fun geoEnabled(geoEnabled: JsonField<Boolean>) = apply {
                    this.geoEnabled = geoEnabled
                }

                fun advertiserAccountType(advertiserAccountType: String) =
                    advertiserAccountType(JsonField.of(advertiserAccountType))

                /** Sets [Builder.advertiserAccountType] to an arbitrary JSON value. */
                fun advertiserAccountType(advertiserAccountType: JsonField<String>) = apply {
                    this.advertiserAccountType = advertiserAccountType
                }

                fun advertiserAccountServiceLevels(advertiserAccountServiceLevels: List<String>) =
                    advertiserAccountServiceLevels(JsonField.of(advertiserAccountServiceLevels))

                /** Sets [Builder.advertiserAccountServiceLevels] to an arbitrary JSON value. */
                fun advertiserAccountServiceLevels(
                    advertiserAccountServiceLevels: JsonField<List<String>>
                ) = apply {
                    this.advertiserAccountServiceLevels = advertiserAccountServiceLevels.map {
                        it.toMutableList()
                    }
                }

                /**
                 * Adds a single [String] to [advertiserAccountServiceLevels].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addAdvertiserAccountServiceLevel(advertiserAccountServiceLevel: String) =
                    apply {
                        this.advertiserAccountServiceLevels =
                            (this.advertiserAccountServiceLevels ?: JsonField.of(mutableListOf()))
                                .also {
                                    checkKnown("advertiserAccountServiceLevels", it)
                                        .add(advertiserAccountServiceLevel)
                                }
                    }

                fun businessProfileState(businessProfileState: String) =
                    businessProfileState(JsonField.of(businessProfileState))

                /** Sets [Builder.businessProfileState] to an arbitrary JSON value. */
                fun businessProfileState(businessProfileState: JsonField<String>) = apply {
                    this.businessProfileState = businessProfileState
                }

                fun subscribersCount(subscribersCount: Long) =
                    subscribersCount(JsonField.of(subscribersCount))

                /** Sets [Builder.subscribersCount] to an arbitrary JSON value. */
                fun subscribersCount(subscribersCount: JsonField<Long>) = apply {
                    this.subscribersCount = subscribersCount
                }

                fun verificationReason(verificationReason: UserProfile.VerificationReason) =
                    verificationReason(JsonField.of(verificationReason))

                /** Sets [Builder.verificationReason] to an arbitrary JSON value. */
                fun verificationReason(
                    verificationReason: JsonField<UserProfile.VerificationReason>
                ) = apply { this.verificationReason = verificationReason }

                fun communityRole(communityRole: String) =
                    communityRole(JsonField.of(communityRole))

                /** Sets [Builder.communityRole] to an arbitrary JSON value. */
                fun communityRole(communityRole: JsonField<String>) = apply {
                    this.communityRole = communityRole
                }

                fun profileBio(profileBio: UserProfile.ProfileBio) =
                    profileBio(JsonField.of(profileBio))

                /** Sets [Builder.profileBio] to an arbitrary JSON value. */
                fun profileBio(profileBio: JsonField<UserProfile.ProfileBio>) = apply {
                    this.profileBio = profileBio
                }

                fun userName(userName: String) = userName(JsonField.of(userName))

                /** Sets [Builder.userName] to an arbitrary JSON value. */
                fun userName(userName: JsonField<String>) = apply { this.userName = userName }

                fun rawVerified(rawVerified: Boolean) = rawVerified(JsonField.of(rawVerified))

                /** Sets [Builder.rawVerified] to an arbitrary JSON value. */
                fun rawVerified(rawVerified: JsonField<Boolean>) = apply {
                    this.rawVerified = rawVerified
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
                 * Returns an immutable instance of [Author].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Author =
                    Author(
                        id,
                        username,
                        name,
                        description,
                        followers,
                        following,
                        verified,
                        isBlueVerified,
                        isVerified,
                        profilePicture,
                        profilePictureOriginal,
                        coverPicture,
                        profileBannerUrl,
                        location,
                        accountBasedIn,
                        accountBasedInUnavailable,
                        accountBasedInAccurate,
                        connectedVia,
                        connectedViaAccurate,
                        affiliateUsername,
                        email,
                        contactInfo,
                        usernameChanges,
                        birthdate,
                        retweetedAt,
                        createdAt,
                        statusesCount,
                        mediaCount,
                        protected_,
                        url,
                        favouritesCount,
                        hasCustomTimelines,
                        isTranslator,
                        (withheldInCountries ?: JsonMissing.of()).map { it.toImmutable() },
                        withheldScope,
                        possiblySensitive,
                        professional,
                        grokTranslatedBio,
                        (pinnedTweetIds ?: JsonMissing.of()).map { it.toImmutable() },
                        isAutomated,
                        automatedBy,
                        unavailable,
                        unavailableReason,
                        verifiedType,
                        affiliatesHighlightedLabel,
                        businessAccountAffiliatesCount,
                        creatorSubscriptionsCount,
                        hasGraduatedAccess,
                        hasHiddenSubscriptionsOnProfile,
                        highlightsInfo,
                        identityVerification,
                        isProfileTranslatable,
                        parodyCommentaryFanLabel,
                        profileDescriptionLanguage,
                        profileImageShape,
                        profileInterstitialType,
                        profileSortEnabled,
                        profileTranslatorType,
                        redirectsToUsername,
                        superFollowEligible,
                        superFollowsUserProfileActive,
                        tipJar,
                        listedCount,
                        fastFollowersCount,
                        normalFollowersCount,
                        defaultProfile,
                        defaultProfileImage,
                        hasExtendedProfile,
                        isTranslationEnabled,
                        geoEnabled,
                        advertiserAccountType,
                        (advertiserAccountServiceLevels ?: JsonMissing.of()).map {
                            it.toImmutable()
                        },
                        businessProfileState,
                        subscribersCount,
                        verificationReason,
                        communityRole,
                        profileBio,
                        userName,
                        rawVerified,
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
            fun validate(): Author = apply {
                if (validated) {
                    return@apply
                }
                id()
                username()
                name()
                description()
                followers()
                following()
                verified()
                isBlueVerified()
                isVerified()
                profilePicture()
                profilePictureOriginal()
                coverPicture()
                profileBannerUrl()
                location()
                accountBasedIn().ifPresent { it.validate() }
                accountBasedInUnavailable()
                accountBasedInAccurate()
                connectedVia()
                connectedViaAccurate()
                affiliateUsername()
                email()
                contactInfo().ifPresent { it.validate() }
                usernameChanges().ifPresent { it.validate() }
                birthdate().ifPresent { it.validate() }
                retweetedAt()
                createdAt()
                statusesCount()
                mediaCount()
                protected_()
                url()
                favouritesCount()
                hasCustomTimelines()
                isTranslator()
                withheldInCountries()
                withheldScope()
                possiblySensitive()
                professional().ifPresent { it.validate() }
                grokTranslatedBio().ifPresent { it.validate() }
                pinnedTweetIds()
                isAutomated()
                automatedBy()
                unavailable()
                unavailableReason()
                verifiedType()
                affiliatesHighlightedLabel().ifPresent { it.validate() }
                businessAccountAffiliatesCount()
                creatorSubscriptionsCount()
                hasGraduatedAccess()
                hasHiddenSubscriptionsOnProfile()
                highlightsInfo().ifPresent { it.validate() }
                identityVerification().ifPresent { it.validate() }
                isProfileTranslatable()
                parodyCommentaryFanLabel()
                profileDescriptionLanguage()
                profileImageShape()
                profileInterstitialType()
                profileSortEnabled()
                profileTranslatorType()
                redirectsToUsername()
                superFollowEligible()
                superFollowsUserProfileActive()
                tipJar().ifPresent { it.validate() }
                listedCount()
                fastFollowersCount()
                normalFollowersCount()
                defaultProfile()
                defaultProfileImage()
                hasExtendedProfile()
                isTranslationEnabled()
                geoEnabled()
                advertiserAccountType()
                advertiserAccountServiceLevels()
                businessProfileState()
                subscribersCount()
                verificationReason().ifPresent { it.validate() }
                communityRole()
                profileBio().ifPresent { it.validate() }
                userName()
                rawVerified()
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
                    (if (username.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (description.asKnown().isPresent) 1 else 0) +
                    (if (followers.asKnown().isPresent) 1 else 0) +
                    (if (following.asKnown().isPresent) 1 else 0) +
                    (if (verified.asKnown().isPresent) 1 else 0) +
                    (if (isBlueVerified.asKnown().isPresent) 1 else 0) +
                    (if (isVerified.asKnown().isPresent) 1 else 0) +
                    (if (profilePicture.asKnown().isPresent) 1 else 0) +
                    (if (profilePictureOriginal.asKnown().isPresent) 1 else 0) +
                    (if (coverPicture.asKnown().isPresent) 1 else 0) +
                    (if (profileBannerUrl.asKnown().isPresent) 1 else 0) +
                    (if (location.asKnown().isPresent) 1 else 0) +
                    (accountBasedIn.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (accountBasedInUnavailable.asKnown().isPresent) 1 else 0) +
                    (if (accountBasedInAccurate.asKnown().isPresent) 1 else 0) +
                    (if (connectedVia.asKnown().isPresent) 1 else 0) +
                    (if (connectedViaAccurate.asKnown().isPresent) 1 else 0) +
                    (if (affiliateUsername.asKnown().isPresent) 1 else 0) +
                    (if (email.asKnown().isPresent) 1 else 0) +
                    (contactInfo.asKnown().getOrNull()?.validity() ?: 0) +
                    (usernameChanges.asKnown().getOrNull()?.validity() ?: 0) +
                    (birthdate.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (retweetedAt.asKnown().isPresent) 1 else 0) +
                    (if (createdAt.asKnown().isPresent) 1 else 0) +
                    (if (statusesCount.asKnown().isPresent) 1 else 0) +
                    (if (mediaCount.asKnown().isPresent) 1 else 0) +
                    (if (protected_.asKnown().isPresent) 1 else 0) +
                    (if (url.asKnown().isPresent) 1 else 0) +
                    (if (favouritesCount.asKnown().isPresent) 1 else 0) +
                    (if (hasCustomTimelines.asKnown().isPresent) 1 else 0) +
                    (if (isTranslator.asKnown().isPresent) 1 else 0) +
                    (if (withheldInCountries.asKnown().isPresent) 1 else 0) +
                    (if (withheldScope.asKnown().isPresent) 1 else 0) +
                    (if (possiblySensitive.asKnown().isPresent) 1 else 0) +
                    (professional.asKnown().getOrNull()?.validity() ?: 0) +
                    (grokTranslatedBio.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (pinnedTweetIds.asKnown().isPresent) 1 else 0) +
                    (if (isAutomated.asKnown().isPresent) 1 else 0) +
                    (if (automatedBy.asKnown().isPresent) 1 else 0) +
                    (if (unavailable.asKnown().isPresent) 1 else 0) +
                    (if (unavailableReason.asKnown().isPresent) 1 else 0) +
                    (if (verifiedType.asKnown().isPresent) 1 else 0) +
                    (affiliatesHighlightedLabel.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (businessAccountAffiliatesCount.asKnown().isPresent) 1 else 0) +
                    (if (creatorSubscriptionsCount.asKnown().isPresent) 1 else 0) +
                    (if (hasGraduatedAccess.asKnown().isPresent) 1 else 0) +
                    (if (hasHiddenSubscriptionsOnProfile.asKnown().isPresent) 1 else 0) +
                    (highlightsInfo.asKnown().getOrNull()?.validity() ?: 0) +
                    (identityVerification.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (isProfileTranslatable.asKnown().isPresent) 1 else 0) +
                    (if (parodyCommentaryFanLabel.asKnown().isPresent) 1 else 0) +
                    (if (profileDescriptionLanguage.asKnown().isPresent) 1 else 0) +
                    (if (profileImageShape.asKnown().isPresent) 1 else 0) +
                    (if (profileInterstitialType.asKnown().isPresent) 1 else 0) +
                    (if (profileSortEnabled.asKnown().isPresent) 1 else 0) +
                    (if (profileTranslatorType.asKnown().isPresent) 1 else 0) +
                    (if (redirectsToUsername.asKnown().isPresent) 1 else 0) +
                    (if (superFollowEligible.asKnown().isPresent) 1 else 0) +
                    (if (superFollowsUserProfileActive.asKnown().isPresent) 1 else 0) +
                    (tipJar.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (listedCount.asKnown().isPresent) 1 else 0) +
                    (if (fastFollowersCount.asKnown().isPresent) 1 else 0) +
                    (if (normalFollowersCount.asKnown().isPresent) 1 else 0) +
                    (if (defaultProfile.asKnown().isPresent) 1 else 0) +
                    (if (defaultProfileImage.asKnown().isPresent) 1 else 0) +
                    (if (hasExtendedProfile.asKnown().isPresent) 1 else 0) +
                    (if (isTranslationEnabled.asKnown().isPresent) 1 else 0) +
                    (if (geoEnabled.asKnown().isPresent) 1 else 0) +
                    (if (advertiserAccountType.asKnown().isPresent) 1 else 0) +
                    (if (advertiserAccountServiceLevels.asKnown().isPresent) 1 else 0) +
                    (if (businessProfileState.asKnown().isPresent) 1 else 0) +
                    (if (subscribersCount.asKnown().isPresent) 1 else 0) +
                    (verificationReason.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (communityRole.asKnown().isPresent) 1 else 0) +
                    (profileBio.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (userName.asKnown().isPresent) 1 else 0) +
                    (if (rawVerified.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }
                return other is Author &&
                    id == other.id &&
                    username == other.username &&
                    name == other.name &&
                    description == other.description &&
                    followers == other.followers &&
                    following == other.following &&
                    verified == other.verified &&
                    isBlueVerified == other.isBlueVerified &&
                    isVerified == other.isVerified &&
                    profilePicture == other.profilePicture &&
                    profilePictureOriginal == other.profilePictureOriginal &&
                    coverPicture == other.coverPicture &&
                    profileBannerUrl == other.profileBannerUrl &&
                    location == other.location &&
                    accountBasedIn == other.accountBasedIn &&
                    accountBasedInUnavailable == other.accountBasedInUnavailable &&
                    accountBasedInAccurate == other.accountBasedInAccurate &&
                    connectedVia == other.connectedVia &&
                    connectedViaAccurate == other.connectedViaAccurate &&
                    affiliateUsername == other.affiliateUsername &&
                    email == other.email &&
                    contactInfo == other.contactInfo &&
                    usernameChanges == other.usernameChanges &&
                    birthdate == other.birthdate &&
                    retweetedAt == other.retweetedAt &&
                    createdAt == other.createdAt &&
                    statusesCount == other.statusesCount &&
                    mediaCount == other.mediaCount &&
                    protected_ == other.protected_ &&
                    url == other.url &&
                    favouritesCount == other.favouritesCount &&
                    hasCustomTimelines == other.hasCustomTimelines &&
                    isTranslator == other.isTranslator &&
                    withheldInCountries == other.withheldInCountries &&
                    withheldScope == other.withheldScope &&
                    possiblySensitive == other.possiblySensitive &&
                    professional == other.professional &&
                    grokTranslatedBio == other.grokTranslatedBio &&
                    pinnedTweetIds == other.pinnedTweetIds &&
                    isAutomated == other.isAutomated &&
                    automatedBy == other.automatedBy &&
                    unavailable == other.unavailable &&
                    unavailableReason == other.unavailableReason &&
                    verifiedType == other.verifiedType &&
                    affiliatesHighlightedLabel == other.affiliatesHighlightedLabel &&
                    businessAccountAffiliatesCount == other.businessAccountAffiliatesCount &&
                    creatorSubscriptionsCount == other.creatorSubscriptionsCount &&
                    hasGraduatedAccess == other.hasGraduatedAccess &&
                    hasHiddenSubscriptionsOnProfile == other.hasHiddenSubscriptionsOnProfile &&
                    highlightsInfo == other.highlightsInfo &&
                    identityVerification == other.identityVerification &&
                    isProfileTranslatable == other.isProfileTranslatable &&
                    parodyCommentaryFanLabel == other.parodyCommentaryFanLabel &&
                    profileDescriptionLanguage == other.profileDescriptionLanguage &&
                    profileImageShape == other.profileImageShape &&
                    profileInterstitialType == other.profileInterstitialType &&
                    profileSortEnabled == other.profileSortEnabled &&
                    profileTranslatorType == other.profileTranslatorType &&
                    redirectsToUsername == other.redirectsToUsername &&
                    superFollowEligible == other.superFollowEligible &&
                    superFollowsUserProfileActive == other.superFollowsUserProfileActive &&
                    tipJar == other.tipJar &&
                    listedCount == other.listedCount &&
                    fastFollowersCount == other.fastFollowersCount &&
                    normalFollowersCount == other.normalFollowersCount &&
                    defaultProfile == other.defaultProfile &&
                    defaultProfileImage == other.defaultProfileImage &&
                    hasExtendedProfile == other.hasExtendedProfile &&
                    isTranslationEnabled == other.isTranslationEnabled &&
                    geoEnabled == other.geoEnabled &&
                    advertiserAccountType == other.advertiserAccountType &&
                    advertiserAccountServiceLevels == other.advertiserAccountServiceLevels &&
                    businessProfileState == other.businessProfileState &&
                    subscribersCount == other.subscribersCount &&
                    verificationReason == other.verificationReason &&
                    communityRole == other.communityRole &&
                    profileBio == other.profileBio &&
                    userName == other.userName &&
                    rawVerified == other.rawVerified &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    id,
                    username,
                    name,
                    description,
                    followers,
                    following,
                    verified,
                    isBlueVerified,
                    isVerified,
                    profilePicture,
                    profilePictureOriginal,
                    coverPicture,
                    profileBannerUrl,
                    location,
                    accountBasedIn,
                    accountBasedInUnavailable,
                    accountBasedInAccurate,
                    connectedVia,
                    connectedViaAccurate,
                    affiliateUsername,
                    email,
                    contactInfo,
                    usernameChanges,
                    birthdate,
                    retweetedAt,
                    createdAt,
                    statusesCount,
                    mediaCount,
                    protected_,
                    url,
                    favouritesCount,
                    hasCustomTimelines,
                    isTranslator,
                    withheldInCountries,
                    withheldScope,
                    possiblySensitive,
                    professional,
                    grokTranslatedBio,
                    pinnedTweetIds,
                    isAutomated,
                    automatedBy,
                    unavailable,
                    unavailableReason,
                    verifiedType,
                    affiliatesHighlightedLabel,
                    businessAccountAffiliatesCount,
                    creatorSubscriptionsCount,
                    hasGraduatedAccess,
                    hasHiddenSubscriptionsOnProfile,
                    highlightsInfo,
                    identityVerification,
                    isProfileTranslatable,
                    parodyCommentaryFanLabel,
                    profileDescriptionLanguage,
                    profileImageShape,
                    profileInterstitialType,
                    profileSortEnabled,
                    profileTranslatorType,
                    redirectsToUsername,
                    superFollowEligible,
                    superFollowsUserProfileActive,
                    tipJar,
                    listedCount,
                    fastFollowersCount,
                    normalFollowersCount,
                    defaultProfile,
                    defaultProfileImage,
                    hasExtendedProfile,
                    isTranslationEnabled,
                    geoEnabled,
                    advertiserAccountType,
                    advertiserAccountServiceLevels,
                    businessProfileState,
                    subscribersCount,
                    verificationReason,
                    communityRole,
                    profileBio,
                    userName,
                    rawVerified,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Author{id=$id, username=$username, name=$name, description=$description, followers=$followers, following=$following, verified=$verified, isBlueVerified=$isBlueVerified, isVerified=$isVerified, profilePicture=$profilePicture, profilePictureOriginal=$profilePictureOriginal, coverPicture=$coverPicture, profileBannerUrl=$profileBannerUrl, location=$location, accountBasedIn=$accountBasedIn, accountBasedInUnavailable=$accountBasedInUnavailable, accountBasedInAccurate=$accountBasedInAccurate, connectedVia=$connectedVia, connectedViaAccurate=$connectedViaAccurate, affiliateUsername=$affiliateUsername, email=$email, contactInfo=$contactInfo, usernameChanges=$usernameChanges, birthdate=$birthdate, retweetedAt=$retweetedAt, createdAt=$createdAt, statusesCount=$statusesCount, mediaCount=$mediaCount, protected_=$protected_, url=$url, favouritesCount=$favouritesCount, hasCustomTimelines=$hasCustomTimelines, isTranslator=$isTranslator, withheldInCountries=$withheldInCountries, withheldScope=$withheldScope, possiblySensitive=$possiblySensitive, professional=$professional, grokTranslatedBio=$grokTranslatedBio, pinnedTweetIds=$pinnedTweetIds, isAutomated=$isAutomated, automatedBy=$automatedBy, unavailable=$unavailable, unavailableReason=$unavailableReason, verifiedType=$verifiedType, affiliatesHighlightedLabel=$affiliatesHighlightedLabel, businessAccountAffiliatesCount=$businessAccountAffiliatesCount, creatorSubscriptionsCount=$creatorSubscriptionsCount, hasGraduatedAccess=$hasGraduatedAccess, hasHiddenSubscriptionsOnProfile=$hasHiddenSubscriptionsOnProfile, highlightsInfo=$highlightsInfo, identityVerification=$identityVerification, isProfileTranslatable=$isProfileTranslatable, parodyCommentaryFanLabel=$parodyCommentaryFanLabel, profileDescriptionLanguage=$profileDescriptionLanguage, profileImageShape=$profileImageShape, profileInterstitialType=$profileInterstitialType, profileSortEnabled=$profileSortEnabled, profileTranslatorType=$profileTranslatorType, redirectsToUsername=$redirectsToUsername, superFollowEligible=$superFollowEligible, superFollowsUserProfileActive=$superFollowsUserProfileActive, tipJar=$tipJar, listedCount=$listedCount, fastFollowersCount=$fastFollowersCount, normalFollowersCount=$normalFollowersCount, defaultProfile=$defaultProfile, defaultProfileImage=$defaultProfileImage, hasExtendedProfile=$hasExtendedProfile, isTranslationEnabled=$isTranslationEnabled, geoEnabled=$geoEnabled, advertiserAccountType=$advertiserAccountType, advertiserAccountServiceLevels=$advertiserAccountServiceLevels, businessProfileState=$businessProfileState, subscribersCount=$subscribersCount, verificationReason=$verificationReason, communityRole=$communityRole, profileBio=$profileBio, userName=$userName, rawVerified=$rawVerified, additionalProperties=$additionalProperties}"
        }

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

        class Card
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val name: JsonField<String>,
            private val url: JsonField<String>,
            private val bindingValues: JsonField<SearchTweet.Scopes>,
            private val platform: JsonField<SearchTweet.Scopes>,
            private val userReferenceErrors: JsonField<List<UserReferenceError>>,
            private val userReferences: JsonField<List<Author>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {
            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
                @JsonProperty("bindingValues")
                @ExcludeMissing
                bindingValues: JsonField<SearchTweet.Scopes> = JsonMissing.of(),
                @JsonProperty("platform")
                @ExcludeMissing
                platform: JsonField<SearchTweet.Scopes> = JsonMissing.of(),
                @JsonProperty("userReferenceErrors")
                @ExcludeMissing
                userReferenceErrors: JsonField<List<UserReferenceError>> = JsonMissing.of(),
                @JsonProperty("userReferences")
                @ExcludeMissing
                userReferences: JsonField<List<Author>> = JsonMissing.of(),
            ) : this(
                id,
                name,
                url,
                bindingValues,
                platform,
                userReferenceErrors,
                userReferences,
                mutableMapOf(),
            )

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun id(): Optional<String> = id.getOptional("id")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun url(): Optional<String> = url.getOptional("url")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun bindingValues(): Optional<SearchTweet.Scopes> =
                bindingValues.getOptional("bindingValues")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun platform(): Optional<SearchTweet.Scopes> = platform.getOptional("platform")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun userReferenceErrors(): Optional<List<UserReferenceError>> =
                userReferenceErrors.getOptional("userReferenceErrors")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun userReferences(): Optional<List<Author>> =
                userReferences.getOptional("userReferences")

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
             * Returns the raw JSON value of [url].
             *
             * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

            /**
             * Returns the raw JSON value of [bindingValues].
             *
             * Unlike [bindingValues], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("bindingValues")
            @ExcludeMissing
            fun _bindingValues(): JsonField<SearchTweet.Scopes> = bindingValues

            /**
             * Returns the raw JSON value of [platform].
             *
             * Unlike [platform], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("platform")
            @ExcludeMissing
            fun _platform(): JsonField<SearchTweet.Scopes> = platform

            /**
             * Returns the raw JSON value of [userReferenceErrors].
             *
             * Unlike [userReferenceErrors], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("userReferenceErrors")
            @ExcludeMissing
            fun _userReferenceErrors(): JsonField<List<UserReferenceError>> = userReferenceErrors

            /**
             * Returns the raw JSON value of [userReferences].
             *
             * Unlike [userReferences], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("userReferences")
            @ExcludeMissing
            fun _userReferences(): JsonField<List<Author>> = userReferences

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
                /** Returns a mutable builder for constructing an instance of [Card]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Card]. */
            class Builder internal constructor() {
                private var id: JsonField<String> = JsonMissing.of()
                private var name: JsonField<String> = JsonMissing.of()
                private var url: JsonField<String> = JsonMissing.of()
                private var bindingValues: JsonField<SearchTweet.Scopes> = JsonMissing.of()
                private var platform: JsonField<SearchTweet.Scopes> = JsonMissing.of()
                private var userReferenceErrors: JsonField<MutableList<UserReferenceError>>? = null
                private var userReferences: JsonField<MutableList<Author>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(card: Card) = apply {
                    id = card.id
                    name = card.name
                    url = card.url
                    bindingValues = card.bindingValues
                    platform = card.platform
                    userReferenceErrors = card.userReferenceErrors.map { it.toMutableList() }
                    userReferences = card.userReferences.map { it.toMutableList() }
                    additionalProperties = card.additionalProperties.toMutableMap()
                }

                fun id(id: String) = id(JsonField.of(id))

                /** Sets [Builder.id] to an arbitrary JSON value. */
                fun id(id: JsonField<String>) = apply { this.id = id }

                fun name(name: String) = name(JsonField.of(name))

                /** Sets [Builder.name] to an arbitrary JSON value. */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun url(url: String) = url(JsonField.of(url))

                /** Sets [Builder.url] to an arbitrary JSON value. */
                fun url(url: JsonField<String>) = apply { this.url = url }

                fun bindingValues(bindingValues: SearchTweet.Scopes) =
                    bindingValues(JsonField.of(bindingValues))

                /** Sets [Builder.bindingValues] to an arbitrary JSON value. */
                fun bindingValues(bindingValues: JsonField<SearchTweet.Scopes>) = apply {
                    this.bindingValues = bindingValues
                }

                fun platform(platform: SearchTweet.Scopes) = platform(JsonField.of(platform))

                /** Sets [Builder.platform] to an arbitrary JSON value. */
                fun platform(platform: JsonField<SearchTweet.Scopes>) = apply {
                    this.platform = platform
                }

                fun userReferenceErrors(userReferenceErrors: List<UserReferenceError>) =
                    userReferenceErrors(JsonField.of(userReferenceErrors))

                /** Sets [Builder.userReferenceErrors] to an arbitrary JSON value. */
                fun userReferenceErrors(userReferenceErrors: JsonField<List<UserReferenceError>>) =
                    apply {
                        this.userReferenceErrors = userReferenceErrors.map { it.toMutableList() }
                    }

                /**
                 * Adds a single [UserReferenceError] to [userReferenceErrors].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addUserReferenceError(userReferenceError: UserReferenceError) = apply {
                    this.userReferenceErrors =
                        (this.userReferenceErrors ?: JsonField.of(mutableListOf())).also {
                            checkKnown("userReferenceErrors", it).add(userReferenceError)
                        }
                }

                fun userReferences(userReferences: List<Author>) =
                    userReferences(JsonField.of(userReferences))

                /** Sets [Builder.userReferences] to an arbitrary JSON value. */
                fun userReferences(userReferences: JsonField<List<Author>>) = apply {
                    this.userReferences = userReferences.map { it.toMutableList() }
                }

                /**
                 * Adds a single [UserProfile] to [userReferences].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addUserReference(userReference: Author) = apply {
                    this.userReferences =
                        (this.userReferences ?: JsonField.of(mutableListOf())).also {
                            checkKnown("userReferences", it).add(userReference)
                        }
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
                 * Returns an immutable instance of [Card].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Card =
                    Card(
                        id,
                        name,
                        url,
                        bindingValues,
                        platform,
                        (userReferenceErrors ?: JsonMissing.of()).map { it.toImmutable() },
                        (userReferences ?: JsonMissing.of()).map { it.toImmutable() },
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
            fun validate(): Card = apply {
                if (validated) {
                    return@apply
                }
                id()
                name()
                url()
                bindingValues().ifPresent { it.validate() }
                platform().ifPresent { it.validate() }
                userReferenceErrors().ifPresent { it.forEach { it.validate() } }
                userReferences().ifPresent { it.forEach { it.validate() } }
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
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (url.asKnown().isPresent) 1 else 0) +
                    (bindingValues.asKnown().getOrNull()?.validity() ?: 0) +
                    (platform.asKnown().getOrNull()?.validity() ?: 0) +
                    (userReferenceErrors.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                    (userReferences.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }
                return other is Card &&
                    id == other.id &&
                    name == other.name &&
                    url == other.url &&
                    bindingValues == other.bindingValues &&
                    platform == other.platform &&
                    userReferenceErrors == other.userReferenceErrors &&
                    userReferences == other.userReferences &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    id,
                    name,
                    url,
                    bindingValues,
                    platform,
                    userReferenceErrors,
                    userReferences,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Card{id=$id, name=$name, url=$url, bindingValues=$bindingValues, platform=$platform, userReferenceErrors=$userReferenceErrors, userReferences=$userReferences, additionalProperties=$additionalProperties}"

            class UserReferenceError
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val message: JsonField<String>,
                private val reason: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {
                @JsonCreator
                private constructor(
                    @JsonProperty("message")
                    @ExcludeMissing
                    message: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("reason")
                    @ExcludeMissing
                    reason: JsonField<String> = JsonMissing.of(),
                ) : this(
                    message,
                    reason,
                    mutableMapOf(),
                )

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun message(): Optional<String> = message.getOptional("message")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun reason(): Optional<String> = reason.getOptional("reason")

                /**
                 * Returns the raw JSON value of [message].
                 *
                 * Unlike [message], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

                /**
                 * Returns the raw JSON value of [reason].
                 *
                 * Unlike [reason], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<String> = reason

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
                     * [UserReferenceError].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [UserReferenceError]. */
                class Builder internal constructor() {
                    private var message: JsonField<String> = JsonMissing.of()
                    private var reason: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(userReferenceError: UserReferenceError) = apply {
                        message = userReferenceError.message
                        reason = userReferenceError.reason
                        additionalProperties =
                            userReferenceError.additionalProperties.toMutableMap()
                    }

                    fun message(message: String) = message(JsonField.of(message))

                    /** Sets [Builder.message] to an arbitrary JSON value. */
                    fun message(message: JsonField<String>) = apply { this.message = message }

                    fun reason(reason: String) = reason(JsonField.of(reason))

                    /** Sets [Builder.reason] to an arbitrary JSON value. */
                    fun reason(reason: JsonField<String>) = apply { this.reason = reason }

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
                     * Returns an immutable instance of [UserReferenceError].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): UserReferenceError =
                        UserReferenceError(
                            message,
                            reason,
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
                fun validate(): UserReferenceError = apply {
                    if (validated) {
                        return@apply
                    }
                    message()
                    reason()
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
                        (if (message.asKnown().isPresent) 1 else 0) +
                        (if (reason.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }
                    return other is UserReferenceError &&
                        message == other.message &&
                        reason == other.reason &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(message, reason, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "UserReferenceError{message=$message, reason=$reason, additionalProperties=$additionalProperties}"
            }
        }

        class ReactionContext
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val reactedToPostId: JsonField<String>,
            private val reactedToUser: JsonField<Author>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {
            @JsonCreator
            private constructor(
                @JsonProperty("reactedToPostId")
                @ExcludeMissing
                reactedToPostId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("reactedToUser")
                @ExcludeMissing
                reactedToUser: JsonField<Author> = JsonMissing.of(),
            ) : this(
                reactedToPostId,
                reactedToUser,
                mutableMapOf(),
            )

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun reactedToPostId(): Optional<String> = reactedToPostId.getOptional("reactedToPostId")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun reactedToUser(): Optional<Author> = reactedToUser.getOptional("reactedToUser")

            /**
             * Returns the raw JSON value of [reactedToPostId].
             *
             * Unlike [reactedToPostId], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("reactedToPostId")
            @ExcludeMissing
            fun _reactedToPostId(): JsonField<String> = reactedToPostId

            /**
             * Returns the raw JSON value of [reactedToUser].
             *
             * Unlike [reactedToUser], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("reactedToUser")
            @ExcludeMissing
            fun _reactedToUser(): JsonField<Author> = reactedToUser

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
                /** Returns a mutable builder for constructing an instance of [ReactionContext]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ReactionContext]. */
            class Builder internal constructor() {
                private var reactedToPostId: JsonField<String> = JsonMissing.of()
                private var reactedToUser: JsonField<Author> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(reactionContext: ReactionContext) = apply {
                    reactedToPostId = reactionContext.reactedToPostId
                    reactedToUser = reactionContext.reactedToUser
                    additionalProperties = reactionContext.additionalProperties.toMutableMap()
                }

                fun reactedToPostId(reactedToPostId: String) =
                    reactedToPostId(JsonField.of(reactedToPostId))

                /** Sets [Builder.reactedToPostId] to an arbitrary JSON value. */
                fun reactedToPostId(reactedToPostId: JsonField<String>) = apply {
                    this.reactedToPostId = reactedToPostId
                }

                fun reactedToUser(reactedToUser: Author) =
                    reactedToUser(JsonField.of(reactedToUser))

                /** Sets [Builder.reactedToUser] to an arbitrary JSON value. */
                fun reactedToUser(reactedToUser: JsonField<Author>) = apply {
                    this.reactedToUser = reactedToUser
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
                 * Returns an immutable instance of [ReactionContext].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): ReactionContext =
                    ReactionContext(
                        reactedToPostId,
                        reactedToUser,
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
            fun validate(): ReactionContext = apply {
                if (validated) {
                    return@apply
                }
                reactedToPostId()
                reactedToUser().ifPresent { it.validate() }
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
                    (if (reactedToPostId.asKnown().isPresent) 1 else 0) +
                    (reactedToUser.asKnown().getOrNull()?.validity() ?: 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }
                return other is ReactionContext &&
                    reactedToPostId == other.reactedToPostId &&
                    reactedToUser == other.reactedToUser &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(reactedToPostId, reactedToUser, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ReactionContext{reactedToPostId=$reactedToPostId, reactedToUser=$reactedToUser, additionalProperties=$additionalProperties}"
        }
    }

    /** Source monitor type. */
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

        return other is Event &&
            id == other.id &&
            data == other.data &&
            monitorId == other.monitorId &&
            monitorType == other.monitorType &&
            occurredAt == other.occurredAt &&
            type == other.type &&
            keywordMonitorId == other.keywordMonitorId &&
            query == other.query &&
            username == other.username &&
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
            xUserId,
            monitorName,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Event{id=$id, data=$data, monitorId=$monitorId, monitorType=$monitorType, occurredAt=$occurredAt, type=$type, keywordMonitorId=$keywordMonitorId, query=$query, username=$username, xUserId=$xUserId, monitorName=$monitorName, additionalProperties=$additionalProperties}"
}
