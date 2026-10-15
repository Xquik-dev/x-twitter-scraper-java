// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.tweets

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

/**
 * Returns the HTML that X gives websites to embed 1 public tweet, with the tweet's link and author.
 */
class TweetEmbedParams
private constructor(
    private val id: String?,
    private val fields: String?,
    private val hideMedia: Boolean?,
    private val hideThread: Boolean?,
    private val omit: String?,
    private val omitScript: Boolean?,
    private val theme: Theme?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun id(): Optional<String> = Optional.ofNullable(id)

    /**
     * Fields to keep in each row, comma-separated. Use dots for nested fields, such as
     * author.username. A list keeps the field in each item. Case & underscores do not matter. A row
     * that lacks a field leaves it out. Cursors, counts & diagnostics always stay. An unknown name
     * answers 400 unknown_field with the valid names, before any read. The price stays the same.
     * SDK row types then hold only the named fields.
     */
    fun fields(): Optional<String> = Optional.ofNullable(fields)

    /** Set `true` to leave photos, videos, and link cards out. */
    fun hideMedia(): Optional<Boolean> = Optional.ofNullable(hideMedia)

    /** Set `true` to leave the tweet this one replies to out. */
    fun hideThread(): Optional<Boolean> = Optional.ofNullable(hideThread)

    /**
     * Fields to drop from each row, comma-separated. It takes the same names as fields. With
     * fields, it drops from the kept fields.
     */
    fun omit(): Optional<String> = Optional.ofNullable(omit)

    /** Set `true` to leave the widget script tag out, for pages that load it once themselves. */
    fun omitScript(): Optional<Boolean> = Optional.ofNullable(omitScript)

    /** Color theme of the embed. X uses light when left out. */
    fun theme(): Optional<Theme> = Optional.ofNullable(theme)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): TweetEmbedParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [TweetEmbedParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TweetEmbedParams]. */
    class Builder internal constructor() {

        private var id: String? = null
        private var fields: String? = null
        private var hideMedia: Boolean? = null
        private var hideThread: Boolean? = null
        private var omit: String? = null
        private var omitScript: Boolean? = null
        private var theme: Theme? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(tweetEmbedParams: TweetEmbedParams) = apply {
            id = tweetEmbedParams.id
            fields = tweetEmbedParams.fields
            hideMedia = tweetEmbedParams.hideMedia
            hideThread = tweetEmbedParams.hideThread
            omit = tweetEmbedParams.omit
            omitScript = tweetEmbedParams.omitScript
            theme = tweetEmbedParams.theme
            additionalHeaders = tweetEmbedParams.additionalHeaders.toBuilder()
            additionalQueryParams = tweetEmbedParams.additionalQueryParams.toBuilder()
        }

        fun id(id: String?) = apply { this.id = id }

        /** Alias for calling [Builder.id] with `id.orElse(null)`. */
        fun id(id: Optional<String>) = id(id.getOrNull())

        /**
         * Fields to keep in each row, comma-separated. Use dots for nested fields, such as
         * author.username. A list keeps the field in each item. Case & underscores do not matter. A
         * row that lacks a field leaves it out. Cursors, counts & diagnostics always stay. An
         * unknown name answers 400 unknown_field with the valid names, before any read. The price
         * stays the same. SDK row types then hold only the named fields.
         */
        fun fields(fields: String?) = apply { this.fields = fields }

        /** Alias for calling [Builder.fields] with `fields.orElse(null)`. */
        fun fields(fields: Optional<String>) = fields(fields.getOrNull())

        /** Set `true` to leave photos, videos, and link cards out. */
        fun hideMedia(hideMedia: Boolean?) = apply { this.hideMedia = hideMedia }

        /** Alias for [Builder.hideMedia]. */
        fun hideMedia(hideMedia: Boolean) = hideMedia(hideMedia as Boolean?)

        /** Alias for calling [Builder.hideMedia] with `hideMedia.orElse(null)`. */
        fun hideMedia(hideMedia: Optional<Boolean>) = hideMedia(hideMedia.getOrNull())

        /** Set `true` to leave the tweet this one replies to out. */
        fun hideThread(hideThread: Boolean?) = apply { this.hideThread = hideThread }

        /** Alias for [Builder.hideThread]. */
        fun hideThread(hideThread: Boolean) = hideThread(hideThread as Boolean?)

        /** Alias for calling [Builder.hideThread] with `hideThread.orElse(null)`. */
        fun hideThread(hideThread: Optional<Boolean>) = hideThread(hideThread.getOrNull())

        /**
         * Fields to drop from each row, comma-separated. It takes the same names as fields. With
         * fields, it drops from the kept fields.
         */
        fun omit(omit: String?) = apply { this.omit = omit }

        /** Alias for calling [Builder.omit] with `omit.orElse(null)`. */
        fun omit(omit: Optional<String>) = omit(omit.getOrNull())

        /**
         * Set `true` to leave the widget script tag out, for pages that load it once themselves.
         */
        fun omitScript(omitScript: Boolean?) = apply { this.omitScript = omitScript }

        /** Alias for [Builder.omitScript]. */
        fun omitScript(omitScript: Boolean) = omitScript(omitScript as Boolean?)

        /** Alias for calling [Builder.omitScript] with `omitScript.orElse(null)`. */
        fun omitScript(omitScript: Optional<Boolean>) = omitScript(omitScript.getOrNull())

        /** Color theme of the embed. X uses light when left out. */
        fun theme(theme: Theme?) = apply { this.theme = theme }

        /** Alias for calling [Builder.theme] with `theme.orElse(null)`. */
        fun theme(theme: Optional<Theme>) = theme(theme.getOrNull())

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
         * Returns an immutable instance of [TweetEmbedParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): TweetEmbedParams =
            TweetEmbedParams(
                id,
                fields,
                hideMedia,
                hideThread,
                omit,
                omitScript,
                theme,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> id ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                fields?.let { put("fields", it) }
                hideMedia?.let { put("hideMedia", it.toString()) }
                hideThread?.let { put("hideThread", it.toString()) }
                omit?.let { put("omit", it) }
                omitScript?.let { put("omitScript", it.toString()) }
                theme?.let { put("theme", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    class Theme @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val LIGHT = of("light")

            @JvmField val DARK = of("dark")

            @JvmStatic fun of(value: String) = Theme(JsonField.of(value))
        }

        /** An enum containing [Theme]'s known values. */
        enum class Known {
            LIGHT,
            DARK,
        }

        /**
         * An enum containing [Theme]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Theme] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            LIGHT,
            DARK,
            /** An enum member indicating that [Theme] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         */
        fun value(): Value =
            when (this) {
                LIGHT -> Value.LIGHT
                DARK -> Value.DARK
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
                LIGHT -> Known.LIGHT
                DARK -> Known.DARK
                else -> throw XTwitterScraperInvalidDataException("Unknown Theme: $value")
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
        fun validate(): Theme = apply {
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

            return other is Theme && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TweetEmbedParams &&
            id == other.id &&
            fields == other.fields &&
            hideMedia == other.hideMedia &&
            hideThread == other.hideThread &&
            omit == other.omit &&
            omitScript == other.omitScript &&
            theme == other.theme &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            id,
            fields,
            hideMedia,
            hideThread,
            omit,
            omitScript,
            theme,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "TweetEmbedParams{id=$id, fields=$fields, hideMedia=$hideMedia, hideThread=$hideThread, omit=$omit, omitScript=$omitScript, theme=$theme, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
