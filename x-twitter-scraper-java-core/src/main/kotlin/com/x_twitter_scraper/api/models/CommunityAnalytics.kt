// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models

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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** Community activity & growth for X's latest period. */
class CommunityAnalytics
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val periodEndsAt: JsonField<OffsetDateTime>,
    private val metrics: JsonField<Metrics>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("periodEndsAt")
        @ExcludeMissing
        periodEndsAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("metrics") @ExcludeMissing metrics: JsonField<Metrics> = JsonMissing.of(),
    ) : this(id, periodEndsAt, metrics, mutableMapOf())

    /**
     * The community ID from your request.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun id(): String = id.getRequired("id")

    /**
     * The end of X's latest period, in UTC.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun periodEndsAt(): OffsetDateTime = periodEndsAt.getRequired("periodEndsAt")

    /**
     * The period's activity, each metric with its count and changePercent. likes counts likes on
     * community posts and newMembers the accounts that joined. posts counts the community posts and
     * replies the replies to them. uniquePosters counts the distinct accounts that posted.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun metrics(): Metrics = metrics.getRequired("metrics")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [periodEndsAt].
     *
     * Unlike [periodEndsAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("periodEndsAt")
    @ExcludeMissing
    fun _periodEndsAt(): JsonField<OffsetDateTime> = periodEndsAt

    /**
     * Returns the raw JSON value of [metrics].
     *
     * Unlike [metrics], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("metrics") @ExcludeMissing fun _metrics(): JsonField<Metrics> = metrics

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
         * Returns a mutable builder for constructing an instance of [CommunityAnalytics].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .periodEndsAt()
         * .metrics()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CommunityAnalytics]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var periodEndsAt: JsonField<OffsetDateTime>? = null
        private var metrics: JsonField<Metrics>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(communityAnalytics: CommunityAnalytics) = apply {
            id = communityAnalytics.id
            periodEndsAt = communityAnalytics.periodEndsAt
            metrics = communityAnalytics.metrics
            additionalProperties = communityAnalytics.additionalProperties.toMutableMap()
        }

        /** The community ID from your request. */
        fun id(id: String) = id(JsonField.of(id))

        /** Sets [Builder.id] to an arbitrary JSON value. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The end of X's latest period, in UTC. */
        fun periodEndsAt(periodEndsAt: OffsetDateTime) = periodEndsAt(JsonField.of(periodEndsAt))

        /** Sets [Builder.periodEndsAt] to an arbitrary JSON value. */
        fun periodEndsAt(periodEndsAt: JsonField<OffsetDateTime>) = apply {
            this.periodEndsAt = periodEndsAt
        }

        /**
         * The period's activity, each metric with its count and changePercent. likes counts likes
         * on community posts and newMembers the accounts that joined. posts counts the community
         * posts and replies the replies to them. uniquePosters counts the distinct accounts that
         * posted.
         */
        fun metrics(metrics: Metrics) = metrics(JsonField.of(metrics))

        /** Sets [Builder.metrics] to an arbitrary JSON value. */
        fun metrics(metrics: JsonField<Metrics>) = apply { this.metrics = metrics }

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
         * Returns an immutable instance of [CommunityAnalytics].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .periodEndsAt()
         * .metrics()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CommunityAnalytics =
            CommunityAnalytics(
                checkRequired("id", id),
                checkRequired("periodEndsAt", periodEndsAt),
                checkRequired("metrics", metrics),
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
    fun validate(): CommunityAnalytics = apply {
        if (validated) {
            return@apply
        }

        id()
        periodEndsAt()
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

    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (periodEndsAt.asKnown().isPresent) 1 else 0) +
            (metrics.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * The period's activity, each metric with its count and changePercent. likes counts likes on
     * community posts and newMembers the accounts that joined. posts counts the community posts and
     * replies the replies to them. uniquePosters counts the distinct accounts that posted.
     */
    class Metrics
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val likes: JsonField<CommunityAnalyticsMetric>,
        private val newMembers: JsonField<CommunityAnalyticsMetric>,
        private val posts: JsonField<CommunityAnalyticsMetric>,
        private val replies: JsonField<CommunityAnalyticsMetric>,
        private val uniquePosters: JsonField<CommunityAnalyticsMetric>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("likes")
            @ExcludeMissing
            likes: JsonField<CommunityAnalyticsMetric> = JsonMissing.of(),
            @JsonProperty("newMembers")
            @ExcludeMissing
            newMembers: JsonField<CommunityAnalyticsMetric> = JsonMissing.of(),
            @JsonProperty("posts")
            @ExcludeMissing
            posts: JsonField<CommunityAnalyticsMetric> = JsonMissing.of(),
            @JsonProperty("replies")
            @ExcludeMissing
            replies: JsonField<CommunityAnalyticsMetric> = JsonMissing.of(),
            @JsonProperty("uniquePosters")
            @ExcludeMissing
            uniquePosters: JsonField<CommunityAnalyticsMetric> = JsonMissing.of(),
        ) : this(likes, newMembers, posts, replies, uniquePosters, mutableMapOf())

        /**
         * A community metric for X's latest period & its percent change.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun likes(): CommunityAnalyticsMetric = likes.getRequired("likes")

        /**
         * A community metric for X's latest period & its percent change.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun newMembers(): CommunityAnalyticsMetric = newMembers.getRequired("newMembers")

        /**
         * A community metric for X's latest period & its percent change.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun posts(): CommunityAnalyticsMetric = posts.getRequired("posts")

        /**
         * A community metric for X's latest period & its percent change.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun replies(): CommunityAnalyticsMetric = replies.getRequired("replies")

        /**
         * A community metric for X's latest period & its percent change.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun uniquePosters(): CommunityAnalyticsMetric = uniquePosters.getRequired("uniquePosters")

        /**
         * Returns the raw JSON value of [likes].
         *
         * Unlike [likes], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("likes")
        @ExcludeMissing
        fun _likes(): JsonField<CommunityAnalyticsMetric> = likes

        /**
         * Returns the raw JSON value of [newMembers].
         *
         * Unlike [newMembers], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("newMembers")
        @ExcludeMissing
        fun _newMembers(): JsonField<CommunityAnalyticsMetric> = newMembers

        /**
         * Returns the raw JSON value of [posts].
         *
         * Unlike [posts], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("posts")
        @ExcludeMissing
        fun _posts(): JsonField<CommunityAnalyticsMetric> = posts

        /**
         * Returns the raw JSON value of [replies].
         *
         * Unlike [replies], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("replies")
        @ExcludeMissing
        fun _replies(): JsonField<CommunityAnalyticsMetric> = replies

        /**
         * Returns the raw JSON value of [uniquePosters].
         *
         * Unlike [uniquePosters], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("uniquePosters")
        @ExcludeMissing
        fun _uniquePosters(): JsonField<CommunityAnalyticsMetric> = uniquePosters

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
             * Returns a mutable builder for constructing an instance of [Metrics].
             *
             * The following fields are required:
             * ```java
             * .likes()
             * .newMembers()
             * .posts()
             * .replies()
             * .uniquePosters()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Metrics]. */
        class Builder internal constructor() {

            private var likes: JsonField<CommunityAnalyticsMetric>? = null
            private var newMembers: JsonField<CommunityAnalyticsMetric>? = null
            private var posts: JsonField<CommunityAnalyticsMetric>? = null
            private var replies: JsonField<CommunityAnalyticsMetric>? = null
            private var uniquePosters: JsonField<CommunityAnalyticsMetric>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(metrics: Metrics) = apply {
                likes = metrics.likes
                newMembers = metrics.newMembers
                posts = metrics.posts
                replies = metrics.replies
                uniquePosters = metrics.uniquePosters
                additionalProperties = metrics.additionalProperties.toMutableMap()
            }

            /** A community metric for X's latest period & its percent change. */
            fun likes(likes: CommunityAnalyticsMetric) = likes(JsonField.of(likes))

            /** Sets [Builder.likes] to an arbitrary JSON value. */
            fun likes(likes: JsonField<CommunityAnalyticsMetric>) = apply { this.likes = likes }

            /** A community metric for X's latest period & its percent change. */
            fun newMembers(newMembers: CommunityAnalyticsMetric) =
                newMembers(JsonField.of(newMembers))

            /** Sets [Builder.newMembers] to an arbitrary JSON value. */
            fun newMembers(newMembers: JsonField<CommunityAnalyticsMetric>) = apply {
                this.newMembers = newMembers
            }

            /** A community metric for X's latest period & its percent change. */
            fun posts(posts: CommunityAnalyticsMetric) = posts(JsonField.of(posts))

            /** Sets [Builder.posts] to an arbitrary JSON value. */
            fun posts(posts: JsonField<CommunityAnalyticsMetric>) = apply { this.posts = posts }

            /** A community metric for X's latest period & its percent change. */
            fun replies(replies: CommunityAnalyticsMetric) = replies(JsonField.of(replies))

            /** Sets [Builder.replies] to an arbitrary JSON value. */
            fun replies(replies: JsonField<CommunityAnalyticsMetric>) = apply {
                this.replies = replies
            }

            /** A community metric for X's latest period & its percent change. */
            fun uniquePosters(uniquePosters: CommunityAnalyticsMetric) =
                uniquePosters(JsonField.of(uniquePosters))

            /** Sets [Builder.uniquePosters] to an arbitrary JSON value. */
            fun uniquePosters(uniquePosters: JsonField<CommunityAnalyticsMetric>) = apply {
                this.uniquePosters = uniquePosters
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
             * Returns an immutable instance of [Metrics].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .likes()
             * .newMembers()
             * .posts()
             * .replies()
             * .uniquePosters()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Metrics =
                Metrics(
                    checkRequired("likes", likes),
                    checkRequired("newMembers", newMembers),
                    checkRequired("posts", posts),
                    checkRequired("replies", replies),
                    checkRequired("uniquePosters", uniquePosters),
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
        fun validate(): Metrics = apply {
            if (validated) {
                return@apply
            }

            likes().validate()
            newMembers().validate()
            posts().validate()
            replies().validate()
            uniquePosters().validate()
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
            (likes.asKnown().getOrNull()?.validity() ?: 0) +
                (newMembers.asKnown().getOrNull()?.validity() ?: 0) +
                (posts.asKnown().getOrNull()?.validity() ?: 0) +
                (replies.asKnown().getOrNull()?.validity() ?: 0) +
                (uniquePosters.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Metrics &&
                likes == other.likes &&
                newMembers == other.newMembers &&
                posts == other.posts &&
                replies == other.replies &&
                uniquePosters == other.uniquePosters &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(likes, newMembers, posts, replies, uniquePosters, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Metrics{likes=$likes, newMembers=$newMembers, posts=$posts, replies=$replies, uniquePosters=$uniquePosters, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CommunityAnalytics &&
            id == other.id &&
            periodEndsAt == other.periodEndsAt &&
            metrics == other.metrics &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, periodEndsAt, metrics, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CommunityAnalytics{id=$id, periodEndsAt=$periodEndsAt, metrics=$metrics, additionalProperties=$additionalProperties}"
}
