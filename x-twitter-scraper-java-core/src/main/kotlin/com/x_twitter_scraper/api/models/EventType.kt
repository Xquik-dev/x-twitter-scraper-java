// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException

/**
 * Type of monitor event. Post monitors send the post types, and account & keyword monitors send the
 * others.
 */
class EventType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

    /** Returns this class instance's raw value. */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val TWEET_NEW = of("tweet.new")

        @JvmField val TWEET_REPLY = of("tweet.reply")

        @JvmField val TWEET_RETWEET = of("tweet.retweet")

        @JvmField val TWEET_QUOTE = of("tweet.quote")

        @JvmField val TWEET_MEDIA = of("tweet.media")

        @JvmField val TWEET_LINK = of("tweet.link")

        @JvmField val TWEET_POLL = of("tweet.poll")

        @JvmField val TWEET_MENTION = of("tweet.mention")

        @JvmField val TWEET_HASHTAG = of("tweet.hashtag")

        @JvmField val TWEET_LONGFORM = of("tweet.longform")

        @JvmField val PROFILE_AVATAR_CHANGED = of("profile.avatar.changed")

        @JvmField val PROFILE_BANNER_CHANGED = of("profile.banner.changed")

        @JvmField val PROFILE_NAME_CHANGED = of("profile.name.changed")

        @JvmField val PROFILE_USERNAME_CHANGED = of("profile.username.changed")

        @JvmField val PROFILE_BIO_CHANGED = of("profile.bio.changed")

        @JvmField val PROFILE_LOCATION_CHANGED = of("profile.location.changed")

        @JvmField val PROFILE_URL_CHANGED = of("profile.url.changed")

        @JvmField val PROFILE_VERIFIED_CHANGED = of("profile.verified.changed")

        @JvmField val PROFILE_PROTECTED_CHANGED = of("profile.protected.changed")

        @JvmField val PROFILE_PINNED_TWEET_CHANGED = of("profile.pinned_tweet.changed")

        @JvmField val PROFILE_UNAVAILABLE_CHANGED = of("profile.unavailable.changed")

        @JvmField val BROADCAST_STARTED = of("broadcast.started")

        @JvmField val FOLLOWER_ADDED = of("follower.added")

        @JvmField val FOLLOWER_REMOVED = of("follower.removed")

        @JvmField val FOLLOWING_ADDED = of("following.added")

        @JvmField val FOLLOWING_REMOVED = of("following.removed")

        @JvmField val PROFILE_FOLLOWERS_CHANGED = of("profile.followers.changed")

        @JvmField val PROFILE_FOLLOWING_CHANGED = of("profile.following.changed")

        @JvmField val SPACE_STARTED = of("space.started")

        @JvmField val TWEET_DELETED = of("tweet.deleted")

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
        TWEET_NEW,
        TWEET_REPLY,
        TWEET_RETWEET,
        TWEET_QUOTE,
        TWEET_MEDIA,
        TWEET_LINK,
        TWEET_POLL,
        TWEET_MENTION,
        TWEET_HASHTAG,
        TWEET_LONGFORM,
        PROFILE_AVATAR_CHANGED,
        PROFILE_BANNER_CHANGED,
        PROFILE_NAME_CHANGED,
        PROFILE_USERNAME_CHANGED,
        PROFILE_BIO_CHANGED,
        PROFILE_LOCATION_CHANGED,
        PROFILE_URL_CHANGED,
        PROFILE_VERIFIED_CHANGED,
        PROFILE_PROTECTED_CHANGED,
        PROFILE_PINNED_TWEET_CHANGED,
        PROFILE_UNAVAILABLE_CHANGED,
        BROADCAST_STARTED,
        FOLLOWER_ADDED,
        FOLLOWER_REMOVED,
        FOLLOWING_ADDED,
        FOLLOWING_REMOVED,
        PROFILE_FOLLOWERS_CHANGED,
        PROFILE_FOLLOWING_CHANGED,
        SPACE_STARTED,
        TWEET_DELETED,
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

    /**
     * An enum containing [EventType]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [EventType] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        TWEET_NEW,
        TWEET_REPLY,
        TWEET_RETWEET,
        TWEET_QUOTE,
        TWEET_MEDIA,
        TWEET_LINK,
        TWEET_POLL,
        TWEET_MENTION,
        TWEET_HASHTAG,
        TWEET_LONGFORM,
        PROFILE_AVATAR_CHANGED,
        PROFILE_BANNER_CHANGED,
        PROFILE_NAME_CHANGED,
        PROFILE_USERNAME_CHANGED,
        PROFILE_BIO_CHANGED,
        PROFILE_LOCATION_CHANGED,
        PROFILE_URL_CHANGED,
        PROFILE_VERIFIED_CHANGED,
        PROFILE_PROTECTED_CHANGED,
        PROFILE_PINNED_TWEET_CHANGED,
        PROFILE_UNAVAILABLE_CHANGED,
        BROADCAST_STARTED,
        FOLLOWER_ADDED,
        FOLLOWER_REMOVED,
        FOLLOWING_ADDED,
        FOLLOWING_REMOVED,
        PROFILE_FOLLOWERS_CHANGED,
        PROFILE_FOLLOWING_CHANGED,
        SPACE_STARTED,
        TWEET_DELETED,
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

    /**
     * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if
     * the class was instantiated with an unknown value.
     */
    fun value(): Value =
        when (this) {
            BROADCAST_STARTED -> Value.BROADCAST_STARTED
            FOLLOWER_ADDED -> Value.FOLLOWER_ADDED
            FOLLOWER_REMOVED -> Value.FOLLOWER_REMOVED
            FOLLOWING_ADDED -> Value.FOLLOWING_ADDED
            FOLLOWING_REMOVED -> Value.FOLLOWING_REMOVED
            PROFILE_FOLLOWERS_CHANGED -> Value.PROFILE_FOLLOWERS_CHANGED
            PROFILE_FOLLOWING_CHANGED -> Value.PROFILE_FOLLOWING_CHANGED
            SPACE_STARTED -> Value.SPACE_STARTED
            TWEET_DELETED -> Value.TWEET_DELETED
            TWEET_NEW -> Value.TWEET_NEW
            TWEET_REPLY -> Value.TWEET_REPLY
            TWEET_RETWEET -> Value.TWEET_RETWEET
            TWEET_QUOTE -> Value.TWEET_QUOTE
            TWEET_MEDIA -> Value.TWEET_MEDIA
            TWEET_LINK -> Value.TWEET_LINK
            TWEET_POLL -> Value.TWEET_POLL
            TWEET_MENTION -> Value.TWEET_MENTION
            TWEET_HASHTAG -> Value.TWEET_HASHTAG
            TWEET_LONGFORM -> Value.TWEET_LONGFORM
            PROFILE_AVATAR_CHANGED -> Value.PROFILE_AVATAR_CHANGED
            PROFILE_BANNER_CHANGED -> Value.PROFILE_BANNER_CHANGED
            PROFILE_NAME_CHANGED -> Value.PROFILE_NAME_CHANGED
            PROFILE_USERNAME_CHANGED -> Value.PROFILE_USERNAME_CHANGED
            PROFILE_BIO_CHANGED -> Value.PROFILE_BIO_CHANGED
            PROFILE_LOCATION_CHANGED -> Value.PROFILE_LOCATION_CHANGED
            PROFILE_URL_CHANGED -> Value.PROFILE_URL_CHANGED
            PROFILE_VERIFIED_CHANGED -> Value.PROFILE_VERIFIED_CHANGED
            PROFILE_PROTECTED_CHANGED -> Value.PROFILE_PROTECTED_CHANGED
            PROFILE_PINNED_TWEET_CHANGED -> Value.PROFILE_PINNED_TWEET_CHANGED
            PROFILE_UNAVAILABLE_CHANGED -> Value.PROFILE_UNAVAILABLE_CHANGED
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
     * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a known
     *   member.
     */
    fun known(): Known =
        when (this) {
            BROADCAST_STARTED -> Known.BROADCAST_STARTED
            FOLLOWER_ADDED -> Known.FOLLOWER_ADDED
            FOLLOWER_REMOVED -> Known.FOLLOWER_REMOVED
            FOLLOWING_ADDED -> Known.FOLLOWING_ADDED
            FOLLOWING_REMOVED -> Known.FOLLOWING_REMOVED
            PROFILE_FOLLOWERS_CHANGED -> Known.PROFILE_FOLLOWERS_CHANGED
            PROFILE_FOLLOWING_CHANGED -> Known.PROFILE_FOLLOWING_CHANGED
            SPACE_STARTED -> Known.SPACE_STARTED
            TWEET_DELETED -> Known.TWEET_DELETED
            TWEET_NEW -> Known.TWEET_NEW
            TWEET_REPLY -> Known.TWEET_REPLY
            TWEET_RETWEET -> Known.TWEET_RETWEET
            TWEET_QUOTE -> Known.TWEET_QUOTE
            TWEET_MEDIA -> Known.TWEET_MEDIA
            TWEET_LINK -> Known.TWEET_LINK
            TWEET_POLL -> Known.TWEET_POLL
            TWEET_MENTION -> Known.TWEET_MENTION
            TWEET_HASHTAG -> Known.TWEET_HASHTAG
            TWEET_LONGFORM -> Known.TWEET_LONGFORM
            PROFILE_AVATAR_CHANGED -> Known.PROFILE_AVATAR_CHANGED
            PROFILE_BANNER_CHANGED -> Known.PROFILE_BANNER_CHANGED
            PROFILE_NAME_CHANGED -> Known.PROFILE_NAME_CHANGED
            PROFILE_USERNAME_CHANGED -> Known.PROFILE_USERNAME_CHANGED
            PROFILE_BIO_CHANGED -> Known.PROFILE_BIO_CHANGED
            PROFILE_LOCATION_CHANGED -> Known.PROFILE_LOCATION_CHANGED
            PROFILE_URL_CHANGED -> Known.PROFILE_URL_CHANGED
            PROFILE_VERIFIED_CHANGED -> Known.PROFILE_VERIFIED_CHANGED
            PROFILE_PROTECTED_CHANGED -> Known.PROFILE_PROTECTED_CHANGED
            PROFILE_PINNED_TWEET_CHANGED -> Known.PROFILE_PINNED_TWEET_CHANGED
            PROFILE_UNAVAILABLE_CHANGED -> Known.PROFILE_UNAVAILABLE_CHANGED
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
     * @throws XTwitterScraperInvalidDataException if this class instance's value does not have the
     *   expected primitive type.
     */
    fun asString(): String =
        _value().asString().orElseThrow {
            XTwitterScraperInvalidDataException("Value is not a String")
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
