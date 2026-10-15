// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class TweetResolveLinksResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val links: JsonField<List<Link>>,
    private val unprocessedUrls: JsonField<List<String>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("links") @ExcludeMissing links: JsonField<List<Link>> = JsonMissing.of(),
        @JsonProperty("unprocessedUrls")
        @ExcludeMissing
        unprocessedUrls: JsonField<List<String>> = JsonMissing.of(),
    ) : this(links, unprocessedUrls, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun links(): List<Link> = links.getRequired("links")

    /**
     * Links not read, in the order sent. X did not answer for them in time, or available credits
     * ran out. Send them again.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun unprocessedUrls(): List<String> = unprocessedUrls.getRequired("unprocessedUrls")

    /**
     * Returns the raw JSON value of [links].
     *
     * Unlike [links], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("links") @ExcludeMissing fun _links(): JsonField<List<Link>> = links

    /**
     * Returns the raw JSON value of [unprocessedUrls].
     *
     * Unlike [unprocessedUrls], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("unprocessedUrls")
    @ExcludeMissing
    fun _unprocessedUrls(): JsonField<List<String>> = unprocessedUrls

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
         * Returns a mutable builder for constructing an instance of [TweetResolveLinksResponse].
         *
         * The following fields are required:
         * ```java
         * .links()
         * .unprocessedUrls()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TweetResolveLinksResponse]. */
    class Builder internal constructor() {

        private var links: JsonField<MutableList<Link>>? = null
        private var unprocessedUrls: JsonField<MutableList<String>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(tweetResolveLinksResponse: TweetResolveLinksResponse) = apply {
            links = tweetResolveLinksResponse.links.map { it.toMutableList() }
            unprocessedUrls = tweetResolveLinksResponse.unprocessedUrls.map { it.toMutableList() }
            additionalProperties = tweetResolveLinksResponse.additionalProperties.toMutableMap()
        }

        fun links(links: List<Link>) = links(JsonField.of(links))

        /** Sets [Builder.links] to an arbitrary JSON value. */
        fun links(links: JsonField<List<Link>>) = apply {
            this.links = links.map { it.toMutableList() }
        }

        /**
         * Adds a single [Link] to [links].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addLink(link: Link) = apply {
            links =
                (links ?: JsonField.of(mutableListOf())).also { checkKnown("links", it).add(link) }
        }

        /**
         * Links not read, in the order sent. X did not answer for them in time, or available
         * credits ran out. Send them again.
         */
        fun unprocessedUrls(unprocessedUrls: List<String>) =
            unprocessedUrls(JsonField.of(unprocessedUrls))

        /** Sets [Builder.unprocessedUrls] to an arbitrary JSON value. */
        fun unprocessedUrls(unprocessedUrls: JsonField<List<String>>) = apply {
            this.unprocessedUrls = unprocessedUrls.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [unprocessedUrls].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addUnprocessedUrl(unprocessedUrl: String) = apply {
            unprocessedUrls =
                (unprocessedUrls ?: JsonField.of(mutableListOf())).also {
                    checkKnown("unprocessedUrls", it).add(unprocessedUrl)
                }
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
         * Returns an immutable instance of [TweetResolveLinksResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .links()
         * .unprocessedUrls()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TweetResolveLinksResponse =
            TweetResolveLinksResponse(
                checkRequired("links", links).map { it.toImmutable() },
                checkRequired("unprocessedUrls", unprocessedUrls).map { it.toImmutable() },
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
    fun validate(): TweetResolveLinksResponse = apply {
        if (validated) {
            return@apply
        }

        links().forEach { it.validate() }
        unprocessedUrls()
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
        (links.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (unprocessedUrls.asKnown().getOrNull()?.size ?: 0)

    /** Pairs 1 t.co link with the URL it leads to. */
    class Link
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val url: JsonField<String>,
        private val resolvedUrl: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
            @JsonProperty("resolvedUrl")
            @ExcludeMissing
            resolvedUrl: JsonField<String> = JsonMissing.of(),
        ) : this(url, resolvedUrl, mutableMapOf())

        /**
         * The t.co link, as `https://t.co/<code>`.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun url(): String = url.getRequired("url")

        /**
         * Target URL, as the link's author set it. Xquik does not check it. Absent for a link t.co
         * does not have.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun resolvedUrl(): Optional<String> = resolvedUrl.getOptional("resolvedUrl")

        /**
         * Returns the raw JSON value of [url].
         *
         * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

        /**
         * Returns the raw JSON value of [resolvedUrl].
         *
         * Unlike [resolvedUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("resolvedUrl")
        @ExcludeMissing
        fun _resolvedUrl(): JsonField<String> = resolvedUrl

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
             * Returns a mutable builder for constructing an instance of [Link].
             *
             * The following fields are required:
             * ```java
             * .url()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Link]. */
        class Builder internal constructor() {

            private var url: JsonField<String>? = null
            private var resolvedUrl: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(link: Link) = apply {
                url = link.url
                resolvedUrl = link.resolvedUrl
                additionalProperties = link.additionalProperties.toMutableMap()
            }

            /** The t.co link, as `https://t.co/<code>`. */
            fun url(url: String) = url(JsonField.of(url))

            /** Sets [Builder.url] to an arbitrary JSON value. */
            fun url(url: JsonField<String>) = apply { this.url = url }

            /**
             * Target URL, as the link's author set it. Xquik does not check it. Absent for a link
             * t.co does not have.
             */
            fun resolvedUrl(resolvedUrl: String) = resolvedUrl(JsonField.of(resolvedUrl))

            /** Sets [Builder.resolvedUrl] to an arbitrary JSON value. */
            fun resolvedUrl(resolvedUrl: JsonField<String>) = apply {
                this.resolvedUrl = resolvedUrl
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
             * Returns an immutable instance of [Link].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .url()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Link =
                Link(checkRequired("url", url), resolvedUrl, additionalProperties.toMutableMap())
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
        fun validate(): Link = apply {
            if (validated) {
                return@apply
            }

            url()
            resolvedUrl()
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
            (if (url.asKnown().isPresent) 1 else 0) +
                (if (resolvedUrl.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Link &&
                url == other.url &&
                resolvedUrl == other.resolvedUrl &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(url, resolvedUrl, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Link{url=$url, resolvedUrl=$resolvedUrl, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TweetResolveLinksResponse &&
            links == other.links &&
            unprocessedUrls == other.unprocessedUrls &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(links, unprocessedUrls, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TweetResolveLinksResponse{links=$links, unprocessedUrls=$unprocessedUrls, additionalProperties=$additionalProperties}"
}
