// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.monitors.posts

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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Post monitor that tracks 1 X post's replies, quotes, edits & metrics. */
class PostMonitor
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val name: JsonField<String>,
    private val postId: JsonField<String>,
    private val postUrl: JsonField<String>,
    private val authorId: JsonField<String>,
    private val authorUsername: JsonField<String>,
    private val authorName: JsonField<String>,
    private val text: JsonField<String>,
    private val postedAt: JsonField<OffsetDateTime>,
    private val eventTypes: JsonField<List<EventType>>,
    private val isActive: JsonField<Boolean>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val nextBillingAt: JsonField<OffsetDateTime>,
    private val pausedReason: JsonField<PausedReason>,
    private val pausedAt: JsonField<OffsetDateTime>,
    private val metrics: JsonField<PostMetrics>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("postId") @ExcludeMissing postId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("postUrl") @ExcludeMissing postUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("authorId") @ExcludeMissing authorId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("authorUsername") @ExcludeMissing authorUsername: JsonField<String> = JsonMissing.of(),
        @JsonProperty("authorName") @ExcludeMissing authorName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        @JsonProperty("postedAt") @ExcludeMissing postedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("eventTypes") @ExcludeMissing eventTypes: JsonField<List<EventType>> = JsonMissing.of(),
        @JsonProperty("isActive") @ExcludeMissing isActive: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("createdAt") @ExcludeMissing createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("nextBillingAt") @ExcludeMissing nextBillingAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("pausedReason") @ExcludeMissing pausedReason: JsonField<PausedReason> = JsonMissing.of(),
        @JsonProperty("pausedAt") @ExcludeMissing pausedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("metrics") @ExcludeMissing metrics: JsonField<PostMetrics> = JsonMissing.of(),
    ) : this(id, name, postId, postUrl, authorId, authorUsername, authorName, text, postedAt, eventTypes, isActive, createdAt, nextBillingAt, pausedReason, pausedAt, metrics, mutableMapOf())

    fun id(): String = id.getRequired("id")

    /** Customer-set label of the post monitor, when set. */
    fun name(): Optional<String> = name.getOptional("name")

    /** ID of the post you gave. */
    fun postId(): String = postId.getRequired("postId")

    fun postUrl(): String = postUrl.getRequired("postUrl")

    /** Permanent X user ID of the post's author. */
    fun authorId(): String = authorId.getRequired("authorId")

    fun authorUsername(): String = authorUsername.getRequired("authorUsername")

    fun authorName(): String = authorName.getRequired("authorName")

    /** Text of the newest version Xquik read. */
    fun text(): String = text.getRequired("text")

    fun postedAt(): OffsetDateTime = postedAt.getRequired("postedAt")

    /** Post event types to send. Without it, a monitor sends new replies, new quotes, like & retweet changes, edits & deletion. */
    fun eventTypes(): List<EventType> = eventTypes.getRequired("eventTypes")

    fun isActive(): Boolean = isActive.getRequired("isActive")

    fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

    /** Next hourly credit charge time for this post monitor. */
    fun nextBillingAt(): OffsetDateTime = nextBillingAt.getRequired("nextBillingAt")

    /** Why Xquik paused this post monitor. insufficient_credits means the balance could not pay an hour, so add credits & resume. The other 3 mean X stopped showing the post. Absent when the monitor is active or you paused it yourself. */
    fun pausedReason(): Optional<PausedReason> = pausedReason.getOptional("pausedReason")

    /** When Xquik paused this post monitor. */
    fun pausedAt(): Optional<OffsetDateTime> = pausedAt.getOptional("pausedAt")

    /** The 6 metrics of a post. */
    fun metrics(): PostMetrics = metrics.getRequired("metrics")

    /** Returns the raw JSON value of [id]. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** Returns the raw JSON value of [name]. */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /** Returns the raw JSON value of [postId]. */
    @JsonProperty("postId") @ExcludeMissing fun _postId(): JsonField<String> = postId

    /** Returns the raw JSON value of [postUrl]. */
    @JsonProperty("postUrl") @ExcludeMissing fun _postUrl(): JsonField<String> = postUrl

    /** Returns the raw JSON value of [authorId]. */
    @JsonProperty("authorId") @ExcludeMissing fun _authorId(): JsonField<String> = authorId

    /** Returns the raw JSON value of [authorUsername]. */
    @JsonProperty("authorUsername") @ExcludeMissing fun _authorUsername(): JsonField<String> = authorUsername

    /** Returns the raw JSON value of [authorName]. */
    @JsonProperty("authorName") @ExcludeMissing fun _authorName(): JsonField<String> = authorName

    /** Returns the raw JSON value of [text]. */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

    /** Returns the raw JSON value of [postedAt]. */
    @JsonProperty("postedAt") @ExcludeMissing fun _postedAt(): JsonField<OffsetDateTime> = postedAt

    /** Returns the raw JSON value of [eventTypes]. */
    @JsonProperty("eventTypes") @ExcludeMissing fun _eventTypes(): JsonField<List<EventType>> = eventTypes

    /** Returns the raw JSON value of [isActive]. */
    @JsonProperty("isActive") @ExcludeMissing fun _isActive(): JsonField<Boolean> = isActive

    /** Returns the raw JSON value of [createdAt]. */
    @JsonProperty("createdAt") @ExcludeMissing fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /** Returns the raw JSON value of [nextBillingAt]. */
    @JsonProperty("nextBillingAt") @ExcludeMissing fun _nextBillingAt(): JsonField<OffsetDateTime> = nextBillingAt

    /** Returns the raw JSON value of [pausedReason]. */
    @JsonProperty("pausedReason") @ExcludeMissing fun _pausedReason(): JsonField<PausedReason> = pausedReason

    /** Returns the raw JSON value of [pausedAt]. */
    @JsonProperty("pausedAt") @ExcludeMissing fun _pausedAt(): JsonField<OffsetDateTime> = pausedAt

    /** Returns the raw JSON value of [metrics]. */
    @JsonProperty("metrics") @ExcludeMissing fun _metrics(): JsonField<PostMetrics> = metrics

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

        /** Returns a mutable builder for constructing an instance of [PostMonitor]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [PostMonitor]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var name: JsonField<String> = JsonMissing.of()
        private var postId: JsonField<String>? = null
        private var postUrl: JsonField<String>? = null
        private var authorId: JsonField<String>? = null
        private var authorUsername: JsonField<String>? = null
        private var authorName: JsonField<String>? = null
        private var text: JsonField<String>? = null
        private var postedAt: JsonField<OffsetDateTime>? = null
        private var eventTypes: JsonField<MutableList<EventType>>? = null
        private var isActive: JsonField<Boolean>? = null
        private var createdAt: JsonField<OffsetDateTime>? = null
        private var nextBillingAt: JsonField<OffsetDateTime>? = null
        private var pausedReason: JsonField<PausedReason> = JsonMissing.of()
        private var pausedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var metrics: JsonField<PostMetrics>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(postMonitor: PostMonitor) = apply {
            id = postMonitor.id
            name = postMonitor.name
            postId = postMonitor.postId
            postUrl = postMonitor.postUrl
            authorId = postMonitor.authorId
            authorUsername = postMonitor.authorUsername
            authorName = postMonitor.authorName
            text = postMonitor.text
            postedAt = postMonitor.postedAt
            eventTypes = postMonitor.eventTypes.map { it.toMutableList() }
            isActive = postMonitor.isActive
            createdAt = postMonitor.createdAt
            nextBillingAt = postMonitor.nextBillingAt
            pausedReason = postMonitor.pausedReason
            pausedAt = postMonitor.pausedAt
            metrics = postMonitor.metrics
            additionalProperties = postMonitor.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /** Sets [Builder.id] to an arbitrary JSON value. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Customer-set label of the post monitor, when set. */
        fun name(name: String) = name(JsonField.of(name))

        /** Sets [Builder.name] to an arbitrary JSON value. */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** ID of the post you gave. */
        fun postId(postId: String) = postId(JsonField.of(postId))

        /** Sets [Builder.postId] to an arbitrary JSON value. */
        fun postId(postId: JsonField<String>) = apply { this.postId = postId }

        fun postUrl(postUrl: String) = postUrl(JsonField.of(postUrl))

        /** Sets [Builder.postUrl] to an arbitrary JSON value. */
        fun postUrl(postUrl: JsonField<String>) = apply { this.postUrl = postUrl }

        /** Permanent X user ID of the post's author. */
        fun authorId(authorId: String) = authorId(JsonField.of(authorId))

        /** Sets [Builder.authorId] to an arbitrary JSON value. */
        fun authorId(authorId: JsonField<String>) = apply { this.authorId = authorId }

        fun authorUsername(authorUsername: String) = authorUsername(JsonField.of(authorUsername))

        /** Sets [Builder.authorUsername] to an arbitrary JSON value. */
        fun authorUsername(authorUsername: JsonField<String>) = apply { this.authorUsername = authorUsername }

        fun authorName(authorName: String) = authorName(JsonField.of(authorName))

        /** Sets [Builder.authorName] to an arbitrary JSON value. */
        fun authorName(authorName: JsonField<String>) = apply { this.authorName = authorName }

        /** Text of the newest version Xquik read. */
        fun text(text: String) = text(JsonField.of(text))

        /** Sets [Builder.text] to an arbitrary JSON value. */
        fun text(text: JsonField<String>) = apply { this.text = text }

        fun postedAt(postedAt: OffsetDateTime) = postedAt(JsonField.of(postedAt))

        /** Sets [Builder.postedAt] to an arbitrary JSON value. */
        fun postedAt(postedAt: JsonField<OffsetDateTime>) = apply { this.postedAt = postedAt }

        /** Post event types to send. Without it, a monitor sends new replies, new quotes, like & retweet changes, edits & deletion. */
        fun eventTypes(eventTypes: List<EventType>) = eventTypes(JsonField.of(eventTypes))

        /** Sets [Builder.eventTypes] to an arbitrary JSON value. */
        fun eventTypes(eventTypes: JsonField<List<EventType>>) = apply { this.eventTypes = eventTypes.map { it.toMutableList() } }

        /** Adds a single [EventType] to [eventTypes]. */
        fun addEventType(eventType: EventType) = apply {
            eventTypes =
                (eventTypes ?: JsonField.of(mutableListOf())).also {
                    checkKnown("eventTypes", it).add(eventType)
                }
        }

        fun isActive(isActive: Boolean) = isActive(JsonField.of(isActive))

        /** Sets [Builder.isActive] to an arbitrary JSON value. */
        fun isActive(isActive: JsonField<Boolean>) = apply { this.isActive = isActive }

        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /** Sets [Builder.createdAt] to an arbitrary JSON value. */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        /** Next hourly credit charge time for this post monitor. */
        fun nextBillingAt(nextBillingAt: OffsetDateTime) = nextBillingAt(JsonField.of(nextBillingAt))

        /** Sets [Builder.nextBillingAt] to an arbitrary JSON value. */
        fun nextBillingAt(nextBillingAt: JsonField<OffsetDateTime>) = apply { this.nextBillingAt = nextBillingAt }

        /** Why Xquik paused this post monitor. insufficient_credits means the balance could not pay an hour, so add credits & resume. The other 3 mean X stopped showing the post. Absent when the monitor is active or you paused it yourself. */
        fun pausedReason(pausedReason: PausedReason) = pausedReason(JsonField.of(pausedReason))

        /** Sets [Builder.pausedReason] to an arbitrary JSON value. */
        fun pausedReason(pausedReason: JsonField<PausedReason>) = apply { this.pausedReason = pausedReason }

        /** When Xquik paused this post monitor. */
        fun pausedAt(pausedAt: OffsetDateTime) = pausedAt(JsonField.of(pausedAt))

        /** Sets [Builder.pausedAt] to an arbitrary JSON value. */
        fun pausedAt(pausedAt: JsonField<OffsetDateTime>) = apply { this.pausedAt = pausedAt }

        /** The 6 metrics of a post. */
        fun metrics(metrics: PostMetrics) = metrics(JsonField.of(metrics))

        /** Sets [Builder.metrics] to an arbitrary JSON value. */
        fun metrics(metrics: JsonField<PostMetrics>) = apply { this.metrics = metrics }

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
         * Returns an immutable instance of [PostMonitor].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): PostMonitor =
            PostMonitor(
                checkRequired("id", id),
                name,
                checkRequired("postId", postId),
                checkRequired("postUrl", postUrl),
                checkRequired("authorId", authorId),
                checkRequired("authorUsername", authorUsername),
                checkRequired("authorName", authorName),
                checkRequired("text", text),
                checkRequired("postedAt", postedAt),
                checkRequired("eventTypes", eventTypes).map { it.toImmutable() },
                checkRequired("isActive", isActive),
                checkRequired("createdAt", createdAt),
                checkRequired("nextBillingAt", nextBillingAt),
                pausedReason,
                pausedAt,
                checkRequired("metrics", metrics),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match
     *   its expected type.
     */
    fun validate(): PostMonitor = apply {
        if (validated) {
            return@apply
        }

        id()
        name()
        postId()
        postUrl()
        authorId()
        authorUsername()
        authorName()
        text()
        postedAt()
        eventTypes().forEach { it.validate() }
        isActive()
        createdAt()
        nextBillingAt()
        pausedReason().ifPresent { it.validate() }
        pausedAt()
        metrics().validate()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: XTwitterScraperInvalidDataException) {
            false
        }

    @JvmSynthetic internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (postId.asKnown().isPresent) 1 else 0) +
            (if (postUrl.asKnown().isPresent) 1 else 0) +
            (if (authorId.asKnown().isPresent) 1 else 0) +
            (if (authorUsername.asKnown().isPresent) 1 else 0) +
            (if (authorName.asKnown().isPresent) 1 else 0) +
            (if (text.asKnown().isPresent) 1 else 0) +
            (if (postedAt.asKnown().isPresent) 1 else 0) +
            (eventTypes.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (if (isActive.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (nextBillingAt.asKnown().isPresent) 1 else 0) +
            (pausedReason.asKnown().getOrNull()?.validity() ?: 0) +
            (if (pausedAt.asKnown().isPresent) 1 else 0) +
            (metrics.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PostMonitor &&
            id == other.id &&
            name == other.name &&
            postId == other.postId &&
            postUrl == other.postUrl &&
            authorId == other.authorId &&
            authorUsername == other.authorUsername &&
            authorName == other.authorName &&
            text == other.text &&
            postedAt == other.postedAt &&
            eventTypes == other.eventTypes &&
            isActive == other.isActive &&
            createdAt == other.createdAt &&
            nextBillingAt == other.nextBillingAt &&
            pausedReason == other.pausedReason &&
            pausedAt == other.pausedAt &&
            metrics == other.metrics &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(id, name, postId, postUrl, authorId, authorUsername, authorName, text, postedAt, eventTypes, isActive, createdAt, nextBillingAt, pausedReason, pausedAt, metrics, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "PostMonitor{id=$id, name=$name, postId=$postId, postUrl=$postUrl, authorId=$authorId, authorUsername=$authorUsername, authorName=$authorName, text=$text, postedAt=$postedAt, eventTypes=$eventTypes, isActive=$isActive, createdAt=$createdAt, nextBillingAt=$nextBillingAt, pausedReason=$pausedReason, pausedAt=$pausedAt, metrics=$metrics, additionalProperties=$additionalProperties}"

    class EventType @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val POST_REPLY_NEW = of("post.reply.new")

            @JvmField val POST_QUOTE_NEW = of("post.quote.new")

            @JvmField val POST_LIKES_CHANGED = of("post.likes.changed")

            @JvmField val POST_RETWEETS_CHANGED = of("post.retweets.changed")

            @JvmField val POST_REPLIES_CHANGED = of("post.replies.changed")

            @JvmField val POST_QUOTES_CHANGED = of("post.quotes.changed")

            @JvmField val POST_BOOKMARKS_CHANGED = of("post.bookmarks.changed")

            @JvmField val POST_VIEWS_CHANGED = of("post.views.changed")

            @JvmField val POST_EDITED = of("post.edited")

            @JvmField val POST_DELETED = of("post.deleted")

            @JvmStatic fun of(value: String) = EventType(JsonField.of(value))
        }

        /** An enum containing [EventType]'s known values. */
        enum class Known {
            POST_REPLY_NEW,
            POST_QUOTE_NEW,
            POST_LIKES_CHANGED,
            POST_RETWEETS_CHANGED,
            POST_REPLIES_CHANGED,
            POST_QUOTES_CHANGED,
            POST_BOOKMARKS_CHANGED,
            POST_VIEWS_CHANGED,
            POST_EDITED,
            POST_DELETED,
        }

        /** An enum containing [EventType]'s known values, as well as an [_UNKNOWN] member. */
        enum class Value {
            POST_REPLY_NEW,
            POST_QUOTE_NEW,
            POST_LIKES_CHANGED,
            POST_RETWEETS_CHANGED,
            POST_REPLIES_CHANGED,
            POST_QUOTES_CHANGED,
            POST_BOOKMARKS_CHANGED,
            POST_VIEWS_CHANGED,
            POST_EDITED,
            POST_DELETED,
            /** An enum member indicating that [EventType] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /** Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if unknown. */
        fun value(): Value =
            when (this) {
                POST_REPLY_NEW -> Value.POST_REPLY_NEW
                POST_QUOTE_NEW -> Value.POST_QUOTE_NEW
                POST_LIKES_CHANGED -> Value.POST_LIKES_CHANGED
                POST_RETWEETS_CHANGED -> Value.POST_RETWEETS_CHANGED
                POST_REPLIES_CHANGED -> Value.POST_REPLIES_CHANGED
                POST_QUOTES_CHANGED -> Value.POST_QUOTES_CHANGED
                POST_BOOKMARKS_CHANGED -> Value.POST_BOOKMARKS_CHANGED
                POST_VIEWS_CHANGED -> Value.POST_VIEWS_CHANGED
                POST_EDITED -> Value.POST_EDITED
                POST_DELETED -> Value.POST_DELETED
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
                POST_REPLY_NEW -> Known.POST_REPLY_NEW
                POST_QUOTE_NEW -> Known.POST_QUOTE_NEW
                POST_LIKES_CHANGED -> Known.POST_LIKES_CHANGED
                POST_RETWEETS_CHANGED -> Known.POST_RETWEETS_CHANGED
                POST_REPLIES_CHANGED -> Known.POST_REPLIES_CHANGED
                POST_QUOTES_CHANGED -> Known.POST_QUOTES_CHANGED
                POST_BOOKMARKS_CHANGED -> Known.POST_BOOKMARKS_CHANGED
                POST_VIEWS_CHANGED -> Known.POST_VIEWS_CHANGED
                POST_EDITED -> Known.POST_EDITED
                POST_DELETED -> Known.POST_DELETED
                else -> throw XTwitterScraperInvalidDataException("Unknown EventType: $value")
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

        /** Validates that this value is a known member. */
        fun validate(): EventType = apply {
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

            return other is EventType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class PausedReason @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val INSUFFICIENT_CREDITS = of("insufficient_credits")

            @JvmField val X_POST_DELETED = of("x_post_deleted")

            @JvmField val X_POST_PROTECTED = of("x_post_protected")

            @JvmField val X_POST_UNAVAILABLE = of("x_post_unavailable")

            @JvmStatic fun of(value: String) = PausedReason(JsonField.of(value))
        }

        /** An enum containing [PausedReason]'s known values. */
        enum class Known {
            INSUFFICIENT_CREDITS,
            X_POST_DELETED,
            X_POST_PROTECTED,
            X_POST_UNAVAILABLE,
        }

        /** An enum containing [PausedReason]'s known values, as well as an [_UNKNOWN] member. */
        enum class Value {
            INSUFFICIENT_CREDITS,
            X_POST_DELETED,
            X_POST_PROTECTED,
            X_POST_UNAVAILABLE,
            /** An enum member indicating that [PausedReason] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /** Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if unknown. */
        fun value(): Value =
            when (this) {
                INSUFFICIENT_CREDITS -> Value.INSUFFICIENT_CREDITS
                X_POST_DELETED -> Value.X_POST_DELETED
                X_POST_PROTECTED -> Value.X_POST_PROTECTED
                X_POST_UNAVAILABLE -> Value.X_POST_UNAVAILABLE
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
                INSUFFICIENT_CREDITS -> Known.INSUFFICIENT_CREDITS
                X_POST_DELETED -> Known.X_POST_DELETED
                X_POST_PROTECTED -> Known.X_POST_PROTECTED
                X_POST_UNAVAILABLE -> Known.X_POST_UNAVAILABLE
                else -> throw XTwitterScraperInvalidDataException("Unknown PausedReason: $value")
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

        /** Validates that this value is a known member. */
        fun validate(): PausedReason = apply {
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

            return other is PausedReason && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }
}
