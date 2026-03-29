// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.extractions

import com.fasterxml.jackson.annotation.JsonCreator
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** List extraction jobs */
class ExtractionListParams
private constructor(
    private val after: String?,
    private val limit: Long?,
    private val status: Status?,
    private val toolType: ToolType?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Cursor for pagination */
    fun after(): Optional<String> = Optional.ofNullable(after)

    fun limit(): Optional<Long> = Optional.ofNullable(limit)

    fun status(): Optional<Status> = Optional.ofNullable(status)

    fun toolType(): Optional<ToolType> = Optional.ofNullable(toolType)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): ExtractionListParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [ExtractionListParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ExtractionListParams]. */
    class Builder internal constructor() {

        private var after: String? = null
        private var limit: Long? = null
        private var status: Status? = null
        private var toolType: ToolType? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(extractionListParams: ExtractionListParams) = apply {
            after = extractionListParams.after
            limit = extractionListParams.limit
            status = extractionListParams.status
            toolType = extractionListParams.toolType
            additionalHeaders = extractionListParams.additionalHeaders.toBuilder()
            additionalQueryParams = extractionListParams.additionalQueryParams.toBuilder()
        }

        /** Cursor for pagination */
        fun after(after: String?) = apply { this.after = after }

        /** Alias for calling [Builder.after] with `after.orElse(null)`. */
        fun after(after: Optional<String>) = after(after.getOrNull())

        fun limit(limit: Long?) = apply { this.limit = limit }

        /**
         * Alias for [Builder.limit].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun limit(limit: Long) = limit(limit as Long?)

        /** Alias for calling [Builder.limit] with `limit.orElse(null)`. */
        fun limit(limit: Optional<Long>) = limit(limit.getOrNull())

        fun status(status: Status?) = apply { this.status = status }

        /** Alias for calling [Builder.status] with `status.orElse(null)`. */
        fun status(status: Optional<Status>) = status(status.getOrNull())

        fun toolType(toolType: ToolType?) = apply { this.toolType = toolType }

        /** Alias for calling [Builder.toolType] with `toolType.orElse(null)`. */
        fun toolType(toolType: Optional<ToolType>) = toolType(toolType.getOrNull())

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [ExtractionListParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ExtractionListParams =
            ExtractionListParams(
                after,
                limit,
                status,
                toolType,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                after?.let { put("after", it) }
                limit?.let { put("limit", it.toString()) }
                status?.let { put("status", it.toString()) }
                toolType?.let { put("toolType", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val RUNNING = of("running")

            @JvmField val COMPLETED = of("completed")

            @JvmField val FAILED = of("failed")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            RUNNING,
            COMPLETED,
            FAILED,
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            RUNNING,
            COMPLETED,
            FAILED,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                RUNNING -> Value.RUNNING
                COMPLETED -> Value.COMPLETED
                FAILED -> Value.FAILED
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                RUNNING -> Known.RUNNING
                COMPLETED -> Known.COMPLETED
                FAILED -> Known.FAILED
                else -> throw XTwitterScraperInvalidDataException("Unknown Status: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): Status = apply {
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

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Status && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class ToolType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val ARTICLE_EXTRACTOR = of("article_extractor")

            @JvmField val COMMUNITY_EXTRACTOR = of("community_extractor")

            @JvmField val COMMUNITY_MODERATOR_EXPLORER = of("community_moderator_explorer")

            @JvmField val COMMUNITY_POST_EXTRACTOR = of("community_post_extractor")

            @JvmField val COMMUNITY_SEARCH = of("community_search")

            @JvmField val FOLLOWER_EXPLORER = of("follower_explorer")

            @JvmField val FOLLOWING_EXPLORER = of("following_explorer")

            @JvmField val LIST_FOLLOWER_EXPLORER = of("list_follower_explorer")

            @JvmField val LIST_MEMBER_EXTRACTOR = of("list_member_extractor")

            @JvmField val LIST_POST_EXTRACTOR = of("list_post_extractor")

            @JvmField val MENTION_EXTRACTOR = of("mention_extractor")

            @JvmField val PEOPLE_SEARCH = of("people_search")

            @JvmField val POST_EXTRACTOR = of("post_extractor")

            @JvmField val QUOTE_EXTRACTOR = of("quote_extractor")

            @JvmField val REPLY_EXTRACTOR = of("reply_extractor")

            @JvmField val REPOST_EXTRACTOR = of("repost_extractor")

            @JvmField val SPACE_EXPLORER = of("space_explorer")

            @JvmField val THREAD_EXTRACTOR = of("thread_extractor")

            @JvmField val TWEET_SEARCH_EXTRACTOR = of("tweet_search_extractor")

            @JvmField val VERIFIED_FOLLOWER_EXPLORER = of("verified_follower_explorer")

            @JvmStatic fun of(value: String) = ToolType(JsonField.of(value))
        }

        /** An enum containing [ToolType]'s known values. */
        enum class Known {
            ARTICLE_EXTRACTOR,
            COMMUNITY_EXTRACTOR,
            COMMUNITY_MODERATOR_EXPLORER,
            COMMUNITY_POST_EXTRACTOR,
            COMMUNITY_SEARCH,
            FOLLOWER_EXPLORER,
            FOLLOWING_EXPLORER,
            LIST_FOLLOWER_EXPLORER,
            LIST_MEMBER_EXTRACTOR,
            LIST_POST_EXTRACTOR,
            MENTION_EXTRACTOR,
            PEOPLE_SEARCH,
            POST_EXTRACTOR,
            QUOTE_EXTRACTOR,
            REPLY_EXTRACTOR,
            REPOST_EXTRACTOR,
            SPACE_EXPLORER,
            THREAD_EXTRACTOR,
            TWEET_SEARCH_EXTRACTOR,
            VERIFIED_FOLLOWER_EXPLORER,
        }

        /**
         * An enum containing [ToolType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [ToolType] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            ARTICLE_EXTRACTOR,
            COMMUNITY_EXTRACTOR,
            COMMUNITY_MODERATOR_EXPLORER,
            COMMUNITY_POST_EXTRACTOR,
            COMMUNITY_SEARCH,
            FOLLOWER_EXPLORER,
            FOLLOWING_EXPLORER,
            LIST_FOLLOWER_EXPLORER,
            LIST_MEMBER_EXTRACTOR,
            LIST_POST_EXTRACTOR,
            MENTION_EXTRACTOR,
            PEOPLE_SEARCH,
            POST_EXTRACTOR,
            QUOTE_EXTRACTOR,
            REPLY_EXTRACTOR,
            REPOST_EXTRACTOR,
            SPACE_EXPLORER,
            THREAD_EXTRACTOR,
            TWEET_SEARCH_EXTRACTOR,
            VERIFIED_FOLLOWER_EXPLORER,
            /** An enum member indicating that [ToolType] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                ARTICLE_EXTRACTOR -> Value.ARTICLE_EXTRACTOR
                COMMUNITY_EXTRACTOR -> Value.COMMUNITY_EXTRACTOR
                COMMUNITY_MODERATOR_EXPLORER -> Value.COMMUNITY_MODERATOR_EXPLORER
                COMMUNITY_POST_EXTRACTOR -> Value.COMMUNITY_POST_EXTRACTOR
                COMMUNITY_SEARCH -> Value.COMMUNITY_SEARCH
                FOLLOWER_EXPLORER -> Value.FOLLOWER_EXPLORER
                FOLLOWING_EXPLORER -> Value.FOLLOWING_EXPLORER
                LIST_FOLLOWER_EXPLORER -> Value.LIST_FOLLOWER_EXPLORER
                LIST_MEMBER_EXTRACTOR -> Value.LIST_MEMBER_EXTRACTOR
                LIST_POST_EXTRACTOR -> Value.LIST_POST_EXTRACTOR
                MENTION_EXTRACTOR -> Value.MENTION_EXTRACTOR
                PEOPLE_SEARCH -> Value.PEOPLE_SEARCH
                POST_EXTRACTOR -> Value.POST_EXTRACTOR
                QUOTE_EXTRACTOR -> Value.QUOTE_EXTRACTOR
                REPLY_EXTRACTOR -> Value.REPLY_EXTRACTOR
                REPOST_EXTRACTOR -> Value.REPOST_EXTRACTOR
                SPACE_EXPLORER -> Value.SPACE_EXPLORER
                THREAD_EXTRACTOR -> Value.THREAD_EXTRACTOR
                TWEET_SEARCH_EXTRACTOR -> Value.TWEET_SEARCH_EXTRACTOR
                VERIFIED_FOLLOWER_EXPLORER -> Value.VERIFIED_FOLLOWER_EXPLORER
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                ARTICLE_EXTRACTOR -> Known.ARTICLE_EXTRACTOR
                COMMUNITY_EXTRACTOR -> Known.COMMUNITY_EXTRACTOR
                COMMUNITY_MODERATOR_EXPLORER -> Known.COMMUNITY_MODERATOR_EXPLORER
                COMMUNITY_POST_EXTRACTOR -> Known.COMMUNITY_POST_EXTRACTOR
                COMMUNITY_SEARCH -> Known.COMMUNITY_SEARCH
                FOLLOWER_EXPLORER -> Known.FOLLOWER_EXPLORER
                FOLLOWING_EXPLORER -> Known.FOLLOWING_EXPLORER
                LIST_FOLLOWER_EXPLORER -> Known.LIST_FOLLOWER_EXPLORER
                LIST_MEMBER_EXTRACTOR -> Known.LIST_MEMBER_EXTRACTOR
                LIST_POST_EXTRACTOR -> Known.LIST_POST_EXTRACTOR
                MENTION_EXTRACTOR -> Known.MENTION_EXTRACTOR
                PEOPLE_SEARCH -> Known.PEOPLE_SEARCH
                POST_EXTRACTOR -> Known.POST_EXTRACTOR
                QUOTE_EXTRACTOR -> Known.QUOTE_EXTRACTOR
                REPLY_EXTRACTOR -> Known.REPLY_EXTRACTOR
                REPOST_EXTRACTOR -> Known.REPOST_EXTRACTOR
                SPACE_EXPLORER -> Known.SPACE_EXPLORER
                THREAD_EXTRACTOR -> Known.THREAD_EXTRACTOR
                TWEET_SEARCH_EXTRACTOR -> Known.TWEET_SEARCH_EXTRACTOR
                VERIFIED_FOLLOWER_EXPLORER -> Known.VERIFIED_FOLLOWER_EXPLORER
                else -> throw XTwitterScraperInvalidDataException("Unknown ToolType: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): ToolType = apply {
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

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ToolType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ExtractionListParams &&
            after == other.after &&
            limit == other.limit &&
            status == other.status &&
            toolType == other.toolType &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(after, limit, status, toolType, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ExtractionListParams{after=$after, limit=$limit, status=$status, toolType=$toolType, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
