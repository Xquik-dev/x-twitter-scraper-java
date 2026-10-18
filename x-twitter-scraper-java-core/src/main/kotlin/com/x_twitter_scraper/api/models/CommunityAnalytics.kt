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

/** Describe community activity and growth for X's latest period. */
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
     * Identify the community from your request.
     *
     * @throws XTwitterScraperInvalidDataException if this field is missing, null or has an
     *   unexpected type.
     */
    fun id(): String = id.getRequired("id")

    /**
     * Mark the end of X's latest period in UTC.
     *
     * @throws XTwitterScraperInvalidDataException if this field is missing, null or has an
     *   unexpected type.
     */
    fun periodEndsAt(): OffsetDateTime = periodEndsAt.getRequired("periodEndsAt")

    /**
     * Read each metric with its count and percent change.
     *
     * @throws XTwitterScraperInvalidDataException if this field is missing, null or has an
     *   unexpected type.
     */
    fun metrics(): Metrics = metrics.getRequired("metrics")

    /**
     * Return the raw JSON value of [id].
     *
     * This method accepts unexpected field types.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Return the raw JSON value of [periodEndsAt].
     *
     * This method accepts unexpected field types.
     */
    @JsonProperty("periodEndsAt")
    @ExcludeMissing
    fun _periodEndsAt(): JsonField<OffsetDateTime> = periodEndsAt

    /**
     * Return the raw JSON value of [metrics].
     *
     * This method accepts unexpected field types.
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
         * Return a mutable builder for [CommunityAnalytics].
         *
         * Set these required fields.
         *
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

        /** Identify the community from your request. */
        fun id(id: String) = id(JsonField.of(id))

        /** Sets [Builder.id] to an arbitrary JSON value. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Mark the end of X's latest period in UTC. */
        fun periodEndsAt(periodEndsAt: OffsetDateTime) = periodEndsAt(JsonField.of(periodEndsAt))

        /** Sets [Builder.periodEndsAt] to an arbitrary JSON value. */
        fun periodEndsAt(periodEndsAt: JsonField<OffsetDateTime>) = apply {
            this.periodEndsAt = periodEndsAt
        }

        /** Read each metric with its count and percent change. */
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
         * Return an immutable [CommunityAnalytics].
         *
         * Later builder changes leave this instance unchanged.
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
     * Validate every field and nested value.
     *
     * New types for existing fields can fail validation.
     *
     * @throws XTwitterScraperInvalidDataException if any field has an unexpected type.
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

    /** Describe community activity for X's latest period. */
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
         * Count likes on community posts.
         *
         * @throws XTwitterScraperInvalidDataException if this field is missing, null or has an
         *   unexpected type.
         */
        fun likes(): CommunityAnalyticsMetric = likes.getRequired("likes")

        /**
         * Count accounts that joined the community.
         *
         * @throws XTwitterScraperInvalidDataException if this field is missing, null or has an
         *   unexpected type.
         */
        fun newMembers(): CommunityAnalyticsMetric = newMembers.getRequired("newMembers")

        /**
         * Count community posts.
         *
         * @throws XTwitterScraperInvalidDataException if this field is missing, null or has an
         *   unexpected type.
         */
        fun posts(): CommunityAnalyticsMetric = posts.getRequired("posts")

        /**
         * Count replies to community posts.
         *
         * @throws XTwitterScraperInvalidDataException if this field is missing, null or has an
         *   unexpected type.
         */
        fun replies(): CommunityAnalyticsMetric = replies.getRequired("replies")

        /**
         * Count distinct accounts that posted.
         *
         * @throws XTwitterScraperInvalidDataException if this field is missing, null or has an
         *   unexpected type.
         */
        fun uniquePosters(): CommunityAnalyticsMetric = uniquePosters.getRequired("uniquePosters")

        /**
         * Return the raw JSON value of [likes].
         *
         * This method accepts unexpected field types.
         */
        @JsonProperty("likes")
        @ExcludeMissing
        fun _likes(): JsonField<CommunityAnalyticsMetric> = likes

        /**
         * Return the raw JSON value of [newMembers].
         *
         * This method accepts unexpected field types.
         */
        @JsonProperty("newMembers")
        @ExcludeMissing
        fun _newMembers(): JsonField<CommunityAnalyticsMetric> = newMembers

        /**
         * Return the raw JSON value of [posts].
         *
         * This method accepts unexpected field types.
         */
        @JsonProperty("posts")
        @ExcludeMissing
        fun _posts(): JsonField<CommunityAnalyticsMetric> = posts

        /**
         * Return the raw JSON value of [replies].
         *
         * This method accepts unexpected field types.
         */
        @JsonProperty("replies")
        @ExcludeMissing
        fun _replies(): JsonField<CommunityAnalyticsMetric> = replies

        /**
         * Return the raw JSON value of [uniquePosters].
         *
         * This method accepts unexpected field types.
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
             * Return a mutable builder for [Metrics].
             *
             * Set these required fields.
             *
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

            /** Count likes on community posts. */
            fun likes(likes: CommunityAnalyticsMetric) = likes(JsonField.of(likes))

            /** Sets [Builder.likes] to an arbitrary JSON value. */
            fun likes(likes: JsonField<CommunityAnalyticsMetric>) = apply { this.likes = likes }

            /** Count accounts that joined the community. */
            fun newMembers(newMembers: CommunityAnalyticsMetric) =
                newMembers(JsonField.of(newMembers))

            /** Sets [Builder.newMembers] to an arbitrary JSON value. */
            fun newMembers(newMembers: JsonField<CommunityAnalyticsMetric>) = apply {
                this.newMembers = newMembers
            }

            /** Count community posts. */
            fun posts(posts: CommunityAnalyticsMetric) = posts(JsonField.of(posts))

            /** Sets [Builder.posts] to an arbitrary JSON value. */
            fun posts(posts: JsonField<CommunityAnalyticsMetric>) = apply { this.posts = posts }

            /** Count replies to community posts. */
            fun replies(replies: CommunityAnalyticsMetric) = replies(JsonField.of(replies))

            /** Sets [Builder.replies] to an arbitrary JSON value. */
            fun replies(replies: JsonField<CommunityAnalyticsMetric>) = apply {
                this.replies = replies
            }

            /** Count distinct accounts that posted. */
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
             * Return an immutable [Metrics].
             *
             * Later builder changes leave this instance unchanged.
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
         * Validate every field and nested value.
         *
         * New types for existing fields can fail validation.
         *
         * @throws XTwitterScraperInvalidDataException if any field has an unexpected type.
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
