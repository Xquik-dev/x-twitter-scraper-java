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
    private val authorAvatarUrl: JsonField<String>,
    private val authorVerified: JsonField<AuthorVerified>,
    private val authorAffiliate: JsonField<AuthorAffiliate>,
    private val media: JsonField<List<Media>>,
    private val baseline: JsonField<Baseline>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("postId") @ExcludeMissing postId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("postUrl") @ExcludeMissing postUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("authorId") @ExcludeMissing authorId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("authorUsername")
        @ExcludeMissing
        authorUsername: JsonField<String> = JsonMissing.of(),
        @JsonProperty("authorName")
        @ExcludeMissing
        authorName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        @JsonProperty("postedAt")
        @ExcludeMissing
        postedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("eventTypes")
        @ExcludeMissing
        eventTypes: JsonField<List<EventType>> = JsonMissing.of(),
        @JsonProperty("isActive") @ExcludeMissing isActive: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("createdAt")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("nextBillingAt")
        @ExcludeMissing
        nextBillingAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("pausedReason")
        @ExcludeMissing
        pausedReason: JsonField<PausedReason> = JsonMissing.of(),
        @JsonProperty("pausedAt")
        @ExcludeMissing
        pausedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("metrics") @ExcludeMissing metrics: JsonField<PostMetrics> = JsonMissing.of(),
        @JsonProperty("authorAvatarUrl")
        @ExcludeMissing
        authorAvatarUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("authorVerified")
        @ExcludeMissing
        authorVerified: JsonField<AuthorVerified> = JsonMissing.of(),
        @JsonProperty("authorAffiliate")
        @ExcludeMissing
        authorAffiliate: JsonField<AuthorAffiliate> = JsonMissing.of(),
        @JsonProperty("media") @ExcludeMissing media: JsonField<List<Media>> = JsonMissing.of(),
        @JsonProperty("baseline") @ExcludeMissing baseline: JsonField<Baseline> = JsonMissing.of(),
    ) : this(
        id,
        name,
        postId,
        postUrl,
        authorId,
        authorUsername,
        authorName,
        text,
        postedAt,
        eventTypes,
        isActive,
        createdAt,
        nextBillingAt,
        pausedReason,
        pausedAt,
        metrics,
        authorAvatarUrl,
        authorVerified,
        authorAffiliate,
        media,
        baseline,
        mutableMapOf(),
    )

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

    /**
     * Post event types to send. Without it, a monitor sends new replies, new quotes, like & retweet
     * changes, edits & deletion.
     */
    fun eventTypes(): List<EventType> = eventTypes.getRequired("eventTypes")

    fun isActive(): Boolean = isActive.getRequired("isActive")

    fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

    /** Next hourly credit charge time for this post monitor. */
    fun nextBillingAt(): OffsetDateTime = nextBillingAt.getRequired("nextBillingAt")

    /**
     * Why Xquik paused this post monitor. insufficient_credits means the balance could not pay an
     * hour, so add credits & resume. The other 3 mean X stopped showing the post. Absent when the
     * monitor is active or you paused it yourself.
     */
    fun pausedReason(): Optional<PausedReason> = pausedReason.getOptional("pausedReason")

    /** When Xquik paused this post monitor. */
    fun pausedAt(): Optional<OffsetDateTime> = pausedAt.getOptional("pausedAt")

    /** The 6 metrics of a post. */
    fun metrics(): PostMetrics = metrics.getRequired("metrics")

    /** The author's profile picture. Omitted when X shows none. */
    fun authorAvatarUrl(): Optional<String> = authorAvatarUrl.getOptional("authorAvatarUrl")

    /** The author's verified badge on X. Omitted when the author has none. */
    fun authorVerified(): Optional<AuthorVerified> = authorVerified.getOptional("authorVerified")

    /**
     * The organization badge X shows beside the author's name. Omitted when X shows none.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun authorAffiliate(): Optional<AuthorAffiliate> =
        authorAffiliate.getOptional("authorAffiliate")

    /** Photos, videos & GIFs on the post, in X's order. */
    fun media(): List<Media> = media.getRequired("media")

    /**
     * Counts Xquik read when tracking began. Each metric's gain counts from here. views is null
     * when X showed no view count.
     */
    fun baseline(): Baseline = baseline.getRequired("baseline")

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
    @JsonProperty("authorUsername")
    @ExcludeMissing
    fun _authorUsername(): JsonField<String> = authorUsername

    /** Returns the raw JSON value of [authorName]. */
    @JsonProperty("authorName") @ExcludeMissing fun _authorName(): JsonField<String> = authorName

    /** Returns the raw JSON value of [text]. */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

    /** Returns the raw JSON value of [postedAt]. */
    @JsonProperty("postedAt") @ExcludeMissing fun _postedAt(): JsonField<OffsetDateTime> = postedAt

    /** Returns the raw JSON value of [eventTypes]. */
    @JsonProperty("eventTypes")
    @ExcludeMissing
    fun _eventTypes(): JsonField<List<EventType>> = eventTypes

    /** Returns the raw JSON value of [isActive]. */
    @JsonProperty("isActive") @ExcludeMissing fun _isActive(): JsonField<Boolean> = isActive

    /** Returns the raw JSON value of [createdAt]. */
    @JsonProperty("createdAt")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /** Returns the raw JSON value of [nextBillingAt]. */
    @JsonProperty("nextBillingAt")
    @ExcludeMissing
    fun _nextBillingAt(): JsonField<OffsetDateTime> = nextBillingAt

    /** Returns the raw JSON value of [pausedReason]. */
    @JsonProperty("pausedReason")
    @ExcludeMissing
    fun _pausedReason(): JsonField<PausedReason> = pausedReason

    /** Returns the raw JSON value of [pausedAt]. */
    @JsonProperty("pausedAt") @ExcludeMissing fun _pausedAt(): JsonField<OffsetDateTime> = pausedAt

    /** Returns the raw JSON value of [metrics]. */
    @JsonProperty("metrics") @ExcludeMissing fun _metrics(): JsonField<PostMetrics> = metrics

    /** Returns the raw JSON value of [authorAvatarUrl]. */
    @JsonProperty("authorAvatarUrl")
    @ExcludeMissing
    fun _authorAvatarUrl(): JsonField<String> = authorAvatarUrl

    /** Returns the raw JSON value of [authorVerified]. */
    @JsonProperty("authorVerified")
    @ExcludeMissing
    fun _authorVerified(): JsonField<AuthorVerified> = authorVerified

    /**
     * Returns the raw JSON value of [authorAffiliate].
     *
     * Unlike [authorAffiliate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("authorAffiliate")
    @ExcludeMissing
    fun _authorAffiliate(): JsonField<AuthorAffiliate> = authorAffiliate

    /** Returns the raw JSON value of [media]. */
    @JsonProperty("media") @ExcludeMissing fun _media(): JsonField<List<Media>> = media

    /** Returns the raw JSON value of [baseline]. */
    @JsonProperty("baseline") @ExcludeMissing fun _baseline(): JsonField<Baseline> = baseline

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
        private var authorAvatarUrl: JsonField<String> = JsonMissing.of()
        private var authorVerified: JsonField<AuthorVerified> = JsonMissing.of()
        private var authorAffiliate: JsonField<AuthorAffiliate> = JsonMissing.of()
        private var media: JsonField<MutableList<Media>>? = null
        private var baseline: JsonField<Baseline>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(postMonitor: PostMonitor) = apply {
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
            authorAvatarUrl = postMonitor.authorAvatarUrl
            authorVerified = postMonitor.authorVerified
            authorAffiliate = postMonitor.authorAffiliate
            media = postMonitor.media.map { it.toMutableList() }
            baseline = postMonitor.baseline
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
        fun authorUsername(authorUsername: JsonField<String>) = apply {
            this.authorUsername = authorUsername
        }

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

        /**
         * Post event types to send. Without it, a monitor sends new replies, new quotes, like &
         * retweet changes, edits & deletion.
         */
        fun eventTypes(eventTypes: List<EventType>) = eventTypes(JsonField.of(eventTypes))

        /** Sets [Builder.eventTypes] to an arbitrary JSON value. */
        fun eventTypes(eventTypes: JsonField<List<EventType>>) = apply {
            this.eventTypes = eventTypes.map { it.toMutableList() }
        }

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
        fun nextBillingAt(nextBillingAt: OffsetDateTime) =
            nextBillingAt(JsonField.of(nextBillingAt))

        /** Sets [Builder.nextBillingAt] to an arbitrary JSON value. */
        fun nextBillingAt(nextBillingAt: JsonField<OffsetDateTime>) = apply {
            this.nextBillingAt = nextBillingAt
        }

        /**
         * Why Xquik paused this post monitor. insufficient_credits means the balance could not pay
         * an hour, so add credits & resume. The other 3 mean X stopped showing the post. Absent
         * when the monitor is active or you paused it yourself.
         */
        fun pausedReason(pausedReason: PausedReason) = pausedReason(JsonField.of(pausedReason))

        /** Sets [Builder.pausedReason] to an arbitrary JSON value. */
        fun pausedReason(pausedReason: JsonField<PausedReason>) = apply {
            this.pausedReason = pausedReason
        }

        /** When Xquik paused this post monitor. */
        fun pausedAt(pausedAt: OffsetDateTime) = pausedAt(JsonField.of(pausedAt))

        /** Sets [Builder.pausedAt] to an arbitrary JSON value. */
        fun pausedAt(pausedAt: JsonField<OffsetDateTime>) = apply { this.pausedAt = pausedAt }

        /** The 6 metrics of a post. */
        fun metrics(metrics: PostMetrics) = metrics(JsonField.of(metrics))

        /** Sets [Builder.metrics] to an arbitrary JSON value. */
        fun metrics(metrics: JsonField<PostMetrics>) = apply { this.metrics = metrics }

        /** The author's profile picture. Omitted when X shows none. */
        fun authorAvatarUrl(authorAvatarUrl: String) =
            authorAvatarUrl(JsonField.of(authorAvatarUrl))

        /** Sets [Builder.authorAvatarUrl] to an arbitrary JSON value. */
        fun authorAvatarUrl(authorAvatarUrl: JsonField<String>) = apply {
            this.authorAvatarUrl = authorAvatarUrl
        }

        /** The author's verified badge on X. Omitted when the author has none. */
        fun authorVerified(authorVerified: AuthorVerified) =
            authorVerified(JsonField.of(authorVerified))

        /** Sets [Builder.authorVerified] to an arbitrary JSON value. */
        fun authorVerified(authorVerified: JsonField<AuthorVerified>) = apply {
            this.authorVerified = authorVerified
        }

        /** The organization badge X shows beside the author's name. Omitted when X shows none. */
        fun authorAffiliate(authorAffiliate: AuthorAffiliate) =
            authorAffiliate(JsonField.of(authorAffiliate))

        /** Sets [Builder.authorAffiliate] to an arbitrary JSON value. */
        fun authorAffiliate(authorAffiliate: JsonField<AuthorAffiliate>) = apply {
            this.authorAffiliate = authorAffiliate
        }

        /** Photos, videos & GIFs on the post, in X's order. */
        fun media(media: List<Media>) = media(JsonField.of(media))

        /** Sets [Builder.media] to an arbitrary JSON value. */
        fun media(media: JsonField<List<Media>>) = apply {
            this.media = media.map { it.toMutableList() }
        }

        /** Adds a single [Media] to [media]. */
        fun addMediaItem(mediaItem: Media) = apply {
            media =
                (media ?: JsonField.of(mutableListOf())).also {
                    checkKnown("media", it).add(mediaItem)
                }
        }

        /**
         * Counts Xquik read when tracking began. Each metric's gain counts from here. views is null
         * when X showed no view count.
         */
        fun baseline(baseline: Baseline) = baseline(JsonField.of(baseline))

        /** Sets [Builder.baseline] to an arbitrary JSON value. */
        fun baseline(baseline: JsonField<Baseline>) = apply { this.baseline = baseline }

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
                authorAvatarUrl,
                authorVerified,
                authorAffiliate,
                checkRequired("media", media).map { it.toImmutable() },
                checkRequired("baseline", baseline),
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
        authorAvatarUrl()
        authorVerified().ifPresent { it.validate() }
        authorAffiliate().ifPresent { it.validate() }
        media().forEach { it.validate() }
        baseline().validate()
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
            (metrics.asKnown().getOrNull()?.validity() ?: 0) +
            (if (authorAvatarUrl.asKnown().isPresent) 1 else 0) +
            (authorVerified.asKnown().getOrNull()?.validity() ?: 0) +
            (authorAffiliate.asKnown().getOrNull()?.validity() ?: 0) +
            (media.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (baseline.asKnown().getOrNull()?.validity() ?: 0)

    /** The organization badge X shows beside the author's name. Omitted when X shows none. */
    class AuthorAffiliate
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val badgeUrl: JsonField<String>,
        private val description: JsonField<String>,
        private val url: JsonField<String>,
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
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        ) : this(badgeUrl, description, url, mutableMapOf())

        /**
         * The organization's badge image.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun badgeUrl(): String = badgeUrl.getRequired("badgeUrl")

        /**
         * The organization's name, as X shows it.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun description(): String = description.getRequired("description")

        /**
         * The organization's X profile, when X links one.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun url(): Optional<String> = url.getOptional("url")

        /**
         * Returns the raw JSON value of [badgeUrl].
         *
         * Unlike [badgeUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("badgeUrl") @ExcludeMissing fun _badgeUrl(): JsonField<String> = badgeUrl

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [url].
         *
         * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

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
             * Returns a mutable builder for constructing an instance of [AuthorAffiliate].
             *
             * The following fields are required:
             * ```java
             * .badgeUrl()
             * .description()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AuthorAffiliate]. */
        class Builder internal constructor() {

            private var badgeUrl: JsonField<String>? = null
            private var description: JsonField<String>? = null
            private var url: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(authorAffiliate: AuthorAffiliate) = apply {
                badgeUrl = authorAffiliate.badgeUrl
                description = authorAffiliate.description
                url = authorAffiliate.url
                additionalProperties = authorAffiliate.additionalProperties.toMutableMap()
            }

            /** The organization's badge image. */
            fun badgeUrl(badgeUrl: String) = badgeUrl(JsonField.of(badgeUrl))

            /** Sets [Builder.badgeUrl] to an arbitrary JSON value. */
            fun badgeUrl(badgeUrl: JsonField<String>) = apply { this.badgeUrl = badgeUrl }

            /** The organization's name, as X shows it. */
            fun description(description: String) = description(JsonField.of(description))

            /** Sets [Builder.description] to an arbitrary JSON value. */
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

            /** The organization's X profile, when X links one. */
            fun url(url: String) = url(JsonField.of(url))

            /** Sets [Builder.url] to an arbitrary JSON value. */
            fun url(url: JsonField<String>) = apply { this.url = url }

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
             * Returns an immutable instance of [AuthorAffiliate].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .badgeUrl()
             * .description()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): AuthorAffiliate =
                AuthorAffiliate(
                    checkRequired("badgeUrl", badgeUrl),
                    checkRequired("description", description),
                    url,
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
        fun validate(): AuthorAffiliate = apply {
            if (validated) {
                return@apply
            }

            badgeUrl()
            description()
            url()
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
                (if (url.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AuthorAffiliate &&
                badgeUrl == other.badgeUrl &&
                description == other.description &&
                url == other.url &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(badgeUrl, description, url, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AuthorAffiliate{badgeUrl=$badgeUrl, description=$description, url=$url, additionalProperties=$additionalProperties}"
    }

    /** The author's verified badge on X. Omitted when the author has none. */
    class AuthorVerified @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val BLUE = of("blue")

            @JvmField val BUSINESS = of("business")

            @JvmField val GOVERNMENT = of("government")

            @JvmStatic fun of(value: String) = AuthorVerified(JsonField.of(value))
        }

        /** An enum containing [AuthorVerified]'s known values. */
        enum class Known {
            BLUE,
            BUSINESS,
            GOVERNMENT,
        }

        /** An enum containing [AuthorVerified]'s known values, as well as an [_UNKNOWN] member. */
        enum class Value {
            BLUE,
            BUSINESS,
            GOVERNMENT,
            /**
             * An enum member indicating that [AuthorVerified] was instantiated with an unknown
             * value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if unknown.
         */
        fun value(): Value =
            when (this) {
                BLUE -> Value.BLUE
                BUSINESS -> Value.BUSINESS
                GOVERNMENT -> Value.GOVERNMENT
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
                BLUE -> Known.BLUE
                BUSINESS -> Known.BUSINESS
                GOVERNMENT -> Known.GOVERNMENT
                else -> throw XTwitterScraperInvalidDataException("Unknown AuthorVerified: $value")
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
        fun validate(): AuthorVerified = apply {
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

            return other is AuthorVerified && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class Media
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val kind: JsonField<Kind>,
        private val url: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("kind") @ExcludeMissing kind: JsonField<Kind> = JsonMissing.of(),
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        ) : this(kind, url, mutableMapOf())

        fun kind(): Kind = kind.getRequired("kind")

        /** The image URL. For a video or GIF, its preview image. */
        fun url(): String = url.getRequired("url")

        /** Returns the raw JSON value of [kind]. */
        @JsonProperty("kind") @ExcludeMissing fun _kind(): JsonField<Kind> = kind

        /** Returns the raw JSON value of [url]. */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

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

            /** Returns a mutable builder for constructing an instance of [Media]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Media]. */
        class Builder internal constructor() {

            private var kind: JsonField<Kind>? = null
            private var url: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(media: Media) = apply {
                kind = media.kind
                url = media.url
                additionalProperties = media.additionalProperties.toMutableMap()
            }

            fun kind(kind: Kind) = kind(JsonField.of(kind))

            /** Sets [Builder.kind] to an arbitrary JSON value. */
            fun kind(kind: JsonField<Kind>) = apply { this.kind = kind }

            /** The image URL. For a video or GIF, its preview image. */
            fun url(url: String) = url(JsonField.of(url))

            /** Sets [Builder.url] to an arbitrary JSON value. */
            fun url(url: JsonField<String>) = apply { this.url = url }

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
             * Returns an immutable instance of [Media].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Media =
                Media(
                    checkRequired("kind", kind),
                    checkRequired("url", url),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): Media = apply {
            if (validated) {
                return@apply
            }

            kind().validate()
            url()
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
            (kind.asKnown().getOrNull()?.validity() ?: 0) + (if (url.asKnown().isPresent) 1 else 0)

        class Kind @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /** Returns this class instance's raw value. */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val GIF = of("gif")

                @JvmField val PHOTO = of("photo")

                @JvmField val VIDEO = of("video")

                @JvmStatic fun of(value: String) = Kind(JsonField.of(value))
            }

            /** An enum containing [Kind]'s known values. */
            enum class Known {
                GIF,
                PHOTO,
                VIDEO,
            }

            /** An enum containing [Kind]'s known values, as well as an [_UNKNOWN] member. */
            enum class Value {
                GIF,
                PHOTO,
                VIDEO,
                /** An enum member indicating that [Kind] was instantiated with an unknown value. */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if unknown.
             */
            fun value(): Value =
                when (this) {
                    GIF -> Value.GIF
                    PHOTO -> Value.PHOTO
                    VIDEO -> Value.VIDEO
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
                    GIF -> Known.GIF
                    PHOTO -> Known.PHOTO
                    VIDEO -> Known.VIDEO
                    else -> throw XTwitterScraperInvalidDataException("Unknown Kind: $value")
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

            /** Validates that this value is a known member. */
            fun validate(): Kind = apply {
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

                return other is Kind && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Media &&
                kind == other.kind &&
                url == other.url &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(kind, url, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Media{kind=$kind, url=$url, additionalProperties=$additionalProperties}"
    }

    /**
     * Counts Xquik read when tracking began. Each metric's gain counts from here. views is null
     * when X showed no view count.
     */
    class Baseline
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val at: JsonField<OffsetDateTime>,
        private val views: JsonField<Long>,
        private val likes: JsonField<Long>,
        private val retweets: JsonField<Long>,
        private val replies: JsonField<Long>,
        private val quotes: JsonField<Long>,
        private val bookmarks: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("at") @ExcludeMissing at: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("views") @ExcludeMissing views: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("likes") @ExcludeMissing likes: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("retweets") @ExcludeMissing retweets: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("replies") @ExcludeMissing replies: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("quotes") @ExcludeMissing quotes: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("bookmarks")
            @ExcludeMissing
            bookmarks: JsonField<Long> = JsonMissing.of(),
        ) : this(at, views, likes, retweets, replies, quotes, bookmarks, mutableMapOf())

        /** When Xquik read these counts from X. */
        fun at(): OffsetDateTime = at.getRequired("at")

        fun views(): Optional<Long> = views.getOptional("views")

        fun likes(): Long = likes.getRequired("likes")

        fun retweets(): Long = retweets.getRequired("retweets")

        fun replies(): Long = replies.getRequired("replies")

        fun quotes(): Long = quotes.getRequired("quotes")

        fun bookmarks(): Long = bookmarks.getRequired("bookmarks")

        /** Returns the raw JSON value of [at]. */
        @JsonProperty("at") @ExcludeMissing fun _at(): JsonField<OffsetDateTime> = at

        /** Returns the raw JSON value of [views]. */
        @JsonProperty("views") @ExcludeMissing fun _views(): JsonField<Long> = views

        /** Returns the raw JSON value of [likes]. */
        @JsonProperty("likes") @ExcludeMissing fun _likes(): JsonField<Long> = likes

        /** Returns the raw JSON value of [retweets]. */
        @JsonProperty("retweets") @ExcludeMissing fun _retweets(): JsonField<Long> = retweets

        /** Returns the raw JSON value of [replies]. */
        @JsonProperty("replies") @ExcludeMissing fun _replies(): JsonField<Long> = replies

        /** Returns the raw JSON value of [quotes]. */
        @JsonProperty("quotes") @ExcludeMissing fun _quotes(): JsonField<Long> = quotes

        /** Returns the raw JSON value of [bookmarks]. */
        @JsonProperty("bookmarks") @ExcludeMissing fun _bookmarks(): JsonField<Long> = bookmarks

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

            /** Returns a mutable builder for constructing an instance of [Baseline]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Baseline]. */
        class Builder internal constructor() {

            private var at: JsonField<OffsetDateTime>? = null
            private var views: JsonField<Long>? = null
            private var likes: JsonField<Long>? = null
            private var retweets: JsonField<Long>? = null
            private var replies: JsonField<Long>? = null
            private var quotes: JsonField<Long>? = null
            private var bookmarks: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(baseline: Baseline) = apply {
                at = baseline.at
                views = baseline.views
                likes = baseline.likes
                retweets = baseline.retweets
                replies = baseline.replies
                quotes = baseline.quotes
                bookmarks = baseline.bookmarks
                additionalProperties = baseline.additionalProperties.toMutableMap()
            }

            /** When Xquik read these counts from X. */
            fun at(at: OffsetDateTime) = at(JsonField.of(at))

            /** Sets [Builder.at] to an arbitrary JSON value. */
            fun at(at: JsonField<OffsetDateTime>) = apply { this.at = at }

            fun views(views: Long?) = views(JsonField.ofNullable(views))

            /**
             * Alias for [Builder.views].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun views(views: Long) = views(views as Long?)

            /** Alias for calling [Builder.views] with `views.orElse(null)`. */
            fun views(views: Optional<Long>) = views(views.getOrNull())

            /** Sets [Builder.views] to an arbitrary JSON value. */
            fun views(views: JsonField<Long>) = apply { this.views = views }

            fun likes(likes: Long) = likes(JsonField.of(likes))

            /** Sets [Builder.likes] to an arbitrary JSON value. */
            fun likes(likes: JsonField<Long>) = apply { this.likes = likes }

            fun retweets(retweets: Long) = retweets(JsonField.of(retweets))

            /** Sets [Builder.retweets] to an arbitrary JSON value. */
            fun retweets(retweets: JsonField<Long>) = apply { this.retweets = retweets }

            fun replies(replies: Long) = replies(JsonField.of(replies))

            /** Sets [Builder.replies] to an arbitrary JSON value. */
            fun replies(replies: JsonField<Long>) = apply { this.replies = replies }

            fun quotes(quotes: Long) = quotes(JsonField.of(quotes))

            /** Sets [Builder.quotes] to an arbitrary JSON value. */
            fun quotes(quotes: JsonField<Long>) = apply { this.quotes = quotes }

            fun bookmarks(bookmarks: Long) = bookmarks(JsonField.of(bookmarks))

            /** Sets [Builder.bookmarks] to an arbitrary JSON value. */
            fun bookmarks(bookmarks: JsonField<Long>) = apply { this.bookmarks = bookmarks }

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
             * Returns an immutable instance of [Baseline].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Baseline =
                Baseline(
                    checkRequired("at", at),
                    checkRequired("views", views),
                    checkRequired("likes", likes),
                    checkRequired("retweets", retweets),
                    checkRequired("replies", replies),
                    checkRequired("quotes", quotes),
                    checkRequired("bookmarks", bookmarks),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): Baseline = apply {
            if (validated) {
                return@apply
            }

            at()
            views()
            likes()
            retweets()
            replies()
            quotes()
            bookmarks()
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
            (if (at.asKnown().isPresent) 1 else 0) +
                (if (views.asKnown().isPresent) 1 else 0) +
                (if (likes.asKnown().isPresent) 1 else 0) +
                (if (retweets.asKnown().isPresent) 1 else 0) +
                (if (replies.asKnown().isPresent) 1 else 0) +
                (if (quotes.asKnown().isPresent) 1 else 0) +
                (if (bookmarks.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Baseline &&
                at == other.at &&
                views == other.views &&
                likes == other.likes &&
                retweets == other.retweets &&
                replies == other.replies &&
                quotes == other.quotes &&
                bookmarks == other.bookmarks &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                at,
                views,
                likes,
                retweets,
                replies,
                quotes,
                bookmarks,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Baseline{at=$at, views=$views, likes=$likes, retweets=$retweets, replies=$replies, quotes=$quotes, bookmarks=$bookmarks, additionalProperties=$additionalProperties}"
    }

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
            authorAvatarUrl == other.authorAvatarUrl &&
            authorVerified == other.authorVerified &&
            authorAffiliate == other.authorAffiliate &&
            media == other.media &&
            baseline == other.baseline &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            name,
            postId,
            postUrl,
            authorId,
            authorUsername,
            authorName,
            text,
            postedAt,
            eventTypes,
            isActive,
            createdAt,
            nextBillingAt,
            pausedReason,
            pausedAt,
            metrics,
            authorAvatarUrl,
            authorVerified,
            authorAffiliate,
            media,
            baseline,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "PostMonitor{id=$id, name=$name, postId=$postId, postUrl=$postUrl, authorId=$authorId, authorUsername=$authorUsername, authorName=$authorName, text=$text, postedAt=$postedAt, eventTypes=$eventTypes, isActive=$isActive, createdAt=$createdAt, nextBillingAt=$nextBillingAt, pausedReason=$pausedReason, pausedAt=$pausedAt, metrics=$metrics, authorAvatarUrl=$authorAvatarUrl, authorVerified=$authorVerified, authorAffiliate=$authorAffiliate, media=$media, baseline=$baseline, additionalProperties=$additionalProperties}"

    class EventType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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
            /**
             * An enum member indicating that [EventType] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if unknown.
         */
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
            /**
             * An enum member indicating that [PausedReason] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if unknown.
         */
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
