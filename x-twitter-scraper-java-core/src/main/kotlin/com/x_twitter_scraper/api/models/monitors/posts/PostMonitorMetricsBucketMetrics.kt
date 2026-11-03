// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.monitors.posts

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
import kotlin.jvm.optionals.getOrNull

class PostMonitorMetricsBucketMetrics
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val views: JsonField<PostMetricPoint>,
    private val likes: JsonField<PostMetricPoint>,
    private val retweets: JsonField<PostMetricPoint>,
    private val replies: JsonField<PostMetricPoint>,
    private val quotes: JsonField<PostMetricPoint>,
    private val bookmarks: JsonField<PostMetricPoint>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("views") @ExcludeMissing views: JsonField<PostMetricPoint> = JsonMissing.of(),
        @JsonProperty("likes") @ExcludeMissing likes: JsonField<PostMetricPoint> = JsonMissing.of(),
        @JsonProperty("retweets") @ExcludeMissing retweets: JsonField<PostMetricPoint> = JsonMissing.of(),
        @JsonProperty("replies") @ExcludeMissing replies: JsonField<PostMetricPoint> = JsonMissing.of(),
        @JsonProperty("quotes") @ExcludeMissing quotes: JsonField<PostMetricPoint> = JsonMissing.of(),
        @JsonProperty("bookmarks") @ExcludeMissing bookmarks: JsonField<PostMetricPoint> = JsonMissing.of(),
    ) : this(views, likes, retweets, replies, quotes, bookmarks, mutableMapOf())

    /** A metric's value at the hour's end & its gain over that hour. Both are null when X shows no count. */
    fun views(): PostMetricPoint = views.getRequired("views")

    /** A metric's value at the hour's end & its gain over that hour. Both are null when X shows no count. */
    fun likes(): PostMetricPoint = likes.getRequired("likes")

    /** A metric's value at the hour's end & its gain over that hour. Both are null when X shows no count. */
    fun retweets(): PostMetricPoint = retweets.getRequired("retweets")

    /** A metric's value at the hour's end & its gain over that hour. Both are null when X shows no count. */
    fun replies(): PostMetricPoint = replies.getRequired("replies")

    /** A metric's value at the hour's end & its gain over that hour. Both are null when X shows no count. */
    fun quotes(): PostMetricPoint = quotes.getRequired("quotes")

    /** A metric's value at the hour's end & its gain over that hour. Both are null when X shows no count. */
    fun bookmarks(): PostMetricPoint = bookmarks.getRequired("bookmarks")

    /** Returns the raw JSON value of [views]. */
    @JsonProperty("views") @ExcludeMissing fun _views(): JsonField<PostMetricPoint> = views

    /** Returns the raw JSON value of [likes]. */
    @JsonProperty("likes") @ExcludeMissing fun _likes(): JsonField<PostMetricPoint> = likes

    /** Returns the raw JSON value of [retweets]. */
    @JsonProperty("retweets") @ExcludeMissing fun _retweets(): JsonField<PostMetricPoint> = retweets

    /** Returns the raw JSON value of [replies]. */
    @JsonProperty("replies") @ExcludeMissing fun _replies(): JsonField<PostMetricPoint> = replies

    /** Returns the raw JSON value of [quotes]. */
    @JsonProperty("quotes") @ExcludeMissing fun _quotes(): JsonField<PostMetricPoint> = quotes

    /** Returns the raw JSON value of [bookmarks]. */
    @JsonProperty("bookmarks") @ExcludeMissing fun _bookmarks(): JsonField<PostMetricPoint> = bookmarks

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

        /** Returns a mutable builder for constructing an instance of [PostMonitorMetricsBucketMetrics]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [PostMonitorMetricsBucketMetrics]. */
    class Builder internal constructor() {

        private var views: JsonField<PostMetricPoint>? = null
        private var likes: JsonField<PostMetricPoint>? = null
        private var retweets: JsonField<PostMetricPoint>? = null
        private var replies: JsonField<PostMetricPoint>? = null
        private var quotes: JsonField<PostMetricPoint>? = null
        private var bookmarks: JsonField<PostMetricPoint>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(postMonitorMetricsBucketMetrics: PostMonitorMetricsBucketMetrics) = apply {
            views = postMonitorMetricsBucketMetrics.views
            likes = postMonitorMetricsBucketMetrics.likes
            retweets = postMonitorMetricsBucketMetrics.retweets
            replies = postMonitorMetricsBucketMetrics.replies
            quotes = postMonitorMetricsBucketMetrics.quotes
            bookmarks = postMonitorMetricsBucketMetrics.bookmarks
            additionalProperties = postMonitorMetricsBucketMetrics.additionalProperties.toMutableMap()
        }

        /** A metric's value at the hour's end & its gain over that hour. Both are null when X shows no count. */
        fun views(views: PostMetricPoint) = views(JsonField.of(views))

        /** Sets [Builder.views] to an arbitrary JSON value. */
        fun views(views: JsonField<PostMetricPoint>) = apply { this.views = views }

        /** A metric's value at the hour's end & its gain over that hour. Both are null when X shows no count. */
        fun likes(likes: PostMetricPoint) = likes(JsonField.of(likes))

        /** Sets [Builder.likes] to an arbitrary JSON value. */
        fun likes(likes: JsonField<PostMetricPoint>) = apply { this.likes = likes }

        /** A metric's value at the hour's end & its gain over that hour. Both are null when X shows no count. */
        fun retweets(retweets: PostMetricPoint) = retweets(JsonField.of(retweets))

        /** Sets [Builder.retweets] to an arbitrary JSON value. */
        fun retweets(retweets: JsonField<PostMetricPoint>) = apply { this.retweets = retweets }

        /** A metric's value at the hour's end & its gain over that hour. Both are null when X shows no count. */
        fun replies(replies: PostMetricPoint) = replies(JsonField.of(replies))

        /** Sets [Builder.replies] to an arbitrary JSON value. */
        fun replies(replies: JsonField<PostMetricPoint>) = apply { this.replies = replies }

        /** A metric's value at the hour's end & its gain over that hour. Both are null when X shows no count. */
        fun quotes(quotes: PostMetricPoint) = quotes(JsonField.of(quotes))

        /** Sets [Builder.quotes] to an arbitrary JSON value. */
        fun quotes(quotes: JsonField<PostMetricPoint>) = apply { this.quotes = quotes }

        /** A metric's value at the hour's end & its gain over that hour. Both are null when X shows no count. */
        fun bookmarks(bookmarks: PostMetricPoint) = bookmarks(JsonField.of(bookmarks))

        /** Sets [Builder.bookmarks] to an arbitrary JSON value. */
        fun bookmarks(bookmarks: JsonField<PostMetricPoint>) = apply { this.bookmarks = bookmarks }

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
         * Returns an immutable instance of [PostMonitorMetricsBucketMetrics].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): PostMonitorMetricsBucketMetrics =
            PostMonitorMetricsBucketMetrics(
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
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match
     *   its expected type.
     */
    fun validate(): PostMonitorMetricsBucketMetrics = apply {
        if (validated) {
            return@apply
        }

        views().validate()
        likes().validate()
        retweets().validate()
        replies().validate()
        quotes().validate()
        bookmarks().validate()
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
        (views.asKnown().getOrNull()?.validity() ?: 0) +
            (likes.asKnown().getOrNull()?.validity() ?: 0) +
            (retweets.asKnown().getOrNull()?.validity() ?: 0) +
            (replies.asKnown().getOrNull()?.validity() ?: 0) +
            (quotes.asKnown().getOrNull()?.validity() ?: 0) +
            (bookmarks.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PostMonitorMetricsBucketMetrics &&
            views == other.views &&
            likes == other.likes &&
            retweets == other.retweets &&
            replies == other.replies &&
            quotes == other.quotes &&
            bookmarks == other.bookmarks &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(views, likes, retweets, replies, quotes, bookmarks, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "PostMonitorMetricsBucketMetrics{views=$views, likes=$likes, retweets=$retweets, replies=$replies, quotes=$quotes, bookmarks=$bookmarks, additionalProperties=$additionalProperties}"
}
