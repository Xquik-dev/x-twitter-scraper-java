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

/** The 6 metrics of a post. */
class PostMetrics
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val views: JsonField<PostMetricReading>,
    private val likes: JsonField<PostMetricReading>,
    private val retweets: JsonField<PostMetricReading>,
    private val replies: JsonField<PostMetricReading>,
    private val quotes: JsonField<PostMetricReading>,
    private val bookmarks: JsonField<PostMetricReading>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("views") @ExcludeMissing views: JsonField<PostMetricReading> = JsonMissing.of(),
        @JsonProperty("likes") @ExcludeMissing likes: JsonField<PostMetricReading> = JsonMissing.of(),
        @JsonProperty("retweets") @ExcludeMissing retweets: JsonField<PostMetricReading> = JsonMissing.of(),
        @JsonProperty("replies") @ExcludeMissing replies: JsonField<PostMetricReading> = JsonMissing.of(),
        @JsonProperty("quotes") @ExcludeMissing quotes: JsonField<PostMetricReading> = JsonMissing.of(),
        @JsonProperty("bookmarks") @ExcludeMissing bookmarks: JsonField<PostMetricReading> = JsonMissing.of(),
    ) : this(views, likes, retweets, replies, quotes, bookmarks, mutableMapOf())

    /** A metric's current value & its gain since tracking began. Both are null when X shows no count, as for views on old posts. */
    fun views(): PostMetricReading = views.getRequired("views")

    /** A metric's current value & its gain since tracking began. Both are null when X shows no count, as for views on old posts. */
    fun likes(): PostMetricReading = likes.getRequired("likes")

    /** A metric's current value & its gain since tracking began. Both are null when X shows no count, as for views on old posts. */
    fun retweets(): PostMetricReading = retweets.getRequired("retweets")

    /** A metric's current value & its gain since tracking began. Both are null when X shows no count, as for views on old posts. */
    fun replies(): PostMetricReading = replies.getRequired("replies")

    /** A metric's current value & its gain since tracking began. Both are null when X shows no count, as for views on old posts. */
    fun quotes(): PostMetricReading = quotes.getRequired("quotes")

    /** A metric's current value & its gain since tracking began. Both are null when X shows no count, as for views on old posts. */
    fun bookmarks(): PostMetricReading = bookmarks.getRequired("bookmarks")

    /** Returns the raw JSON value of [views]. */
    @JsonProperty("views") @ExcludeMissing fun _views(): JsonField<PostMetricReading> = views

    /** Returns the raw JSON value of [likes]. */
    @JsonProperty("likes") @ExcludeMissing fun _likes(): JsonField<PostMetricReading> = likes

    /** Returns the raw JSON value of [retweets]. */
    @JsonProperty("retweets") @ExcludeMissing fun _retweets(): JsonField<PostMetricReading> = retweets

    /** Returns the raw JSON value of [replies]. */
    @JsonProperty("replies") @ExcludeMissing fun _replies(): JsonField<PostMetricReading> = replies

    /** Returns the raw JSON value of [quotes]. */
    @JsonProperty("quotes") @ExcludeMissing fun _quotes(): JsonField<PostMetricReading> = quotes

    /** Returns the raw JSON value of [bookmarks]. */
    @JsonProperty("bookmarks") @ExcludeMissing fun _bookmarks(): JsonField<PostMetricReading> = bookmarks

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

        /** Returns a mutable builder for constructing an instance of [PostMetrics]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [PostMetrics]. */
    class Builder internal constructor() {

        private var views: JsonField<PostMetricReading>? = null
        private var likes: JsonField<PostMetricReading>? = null
        private var retweets: JsonField<PostMetricReading>? = null
        private var replies: JsonField<PostMetricReading>? = null
        private var quotes: JsonField<PostMetricReading>? = null
        private var bookmarks: JsonField<PostMetricReading>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(postMetrics: PostMetrics) = apply {
            views = postMetrics.views
            likes = postMetrics.likes
            retweets = postMetrics.retweets
            replies = postMetrics.replies
            quotes = postMetrics.quotes
            bookmarks = postMetrics.bookmarks
            additionalProperties = postMetrics.additionalProperties.toMutableMap()
        }

        /** A metric's current value & its gain since tracking began. Both are null when X shows no count, as for views on old posts. */
        fun views(views: PostMetricReading) = views(JsonField.of(views))

        /** Sets [Builder.views] to an arbitrary JSON value. */
        fun views(views: JsonField<PostMetricReading>) = apply { this.views = views }

        /** A metric's current value & its gain since tracking began. Both are null when X shows no count, as for views on old posts. */
        fun likes(likes: PostMetricReading) = likes(JsonField.of(likes))

        /** Sets [Builder.likes] to an arbitrary JSON value. */
        fun likes(likes: JsonField<PostMetricReading>) = apply { this.likes = likes }

        /** A metric's current value & its gain since tracking began. Both are null when X shows no count, as for views on old posts. */
        fun retweets(retweets: PostMetricReading) = retweets(JsonField.of(retweets))

        /** Sets [Builder.retweets] to an arbitrary JSON value. */
        fun retweets(retweets: JsonField<PostMetricReading>) = apply { this.retweets = retweets }

        /** A metric's current value & its gain since tracking began. Both are null when X shows no count, as for views on old posts. */
        fun replies(replies: PostMetricReading) = replies(JsonField.of(replies))

        /** Sets [Builder.replies] to an arbitrary JSON value. */
        fun replies(replies: JsonField<PostMetricReading>) = apply { this.replies = replies }

        /** A metric's current value & its gain since tracking began. Both are null when X shows no count, as for views on old posts. */
        fun quotes(quotes: PostMetricReading) = quotes(JsonField.of(quotes))

        /** Sets [Builder.quotes] to an arbitrary JSON value. */
        fun quotes(quotes: JsonField<PostMetricReading>) = apply { this.quotes = quotes }

        /** A metric's current value & its gain since tracking began. Both are null when X shows no count, as for views on old posts. */
        fun bookmarks(bookmarks: PostMetricReading) = bookmarks(JsonField.of(bookmarks))

        /** Sets [Builder.bookmarks] to an arbitrary JSON value. */
        fun bookmarks(bookmarks: JsonField<PostMetricReading>) = apply { this.bookmarks = bookmarks }

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
         * Returns an immutable instance of [PostMetrics].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): PostMetrics =
            PostMetrics(
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
    fun validate(): PostMetrics = apply {
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

        return other is PostMetrics &&
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
        "PostMetrics{views=$views, likes=$likes, retweets=$retweets, replies=$replies, quotes=$quotes, bookmarks=$bookmarks, additionalProperties=$additionalProperties}"
}
