// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x

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

class XGetArticleResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val article: JsonField<Article>,
    private val author: JsonField<Author>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("article") @ExcludeMissing article: JsonField<Article> = JsonMissing.of(),
        @JsonProperty("author") @ExcludeMissing author: JsonField<Author> = JsonMissing.of(),
    ) : this(article, author, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun article(): Article = article.getRequired("article")

    /**
     * X Article author profile fields returned when available.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun author(): Optional<Author> = author.getOptional("author")

    /**
     * Returns the raw JSON value of [article].
     *
     * Unlike [article], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("article") @ExcludeMissing fun _article(): JsonField<Article> = article

    /**
     * Returns the raw JSON value of [author].
     *
     * Unlike [author], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("author") @ExcludeMissing fun _author(): JsonField<Author> = author

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
         * Returns a mutable builder for constructing an instance of [XGetArticleResponse].
         *
         * The following fields are required:
         * ```java
         * .article()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [XGetArticleResponse]. */
    class Builder internal constructor() {

        private var article: JsonField<Article>? = null
        private var author: JsonField<Author> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(xGetArticleResponse: XGetArticleResponse) = apply {
            article = xGetArticleResponse.article
            author = xGetArticleResponse.author
            additionalProperties = xGetArticleResponse.additionalProperties.toMutableMap()
        }

        fun article(article: Article) = article(JsonField.of(article))

        /**
         * Sets [Builder.article] to an arbitrary JSON value.
         *
         * You should usually call [Builder.article] with a well-typed [Article] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun article(article: JsonField<Article>) = apply { this.article = article }

        /** X Article author profile fields returned when available. */
        fun author(author: Author) = author(JsonField.of(author))

        /**
         * Sets [Builder.author] to an arbitrary JSON value.
         *
         * You should usually call [Builder.author] with a well-typed [Author] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun author(author: JsonField<Author>) = apply { this.author = author }

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
         * Returns an immutable instance of [XGetArticleResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .article()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): XGetArticleResponse =
            XGetArticleResponse(
                checkRequired("article", article),
                author,
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
    fun validate(): XGetArticleResponse = apply {
        if (validated) {
            return@apply
        }

        article().validate()
        author().ifPresent { it.validate() }
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (article.asKnown().getOrNull()?.validity() ?: 0) +
            (author.asKnown().getOrNull()?.validity() ?: 0)

    class Article
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val bodyText: JsonField<String>,
        private val contents: JsonField<List<Content>>,
        private val coverImageUrl: JsonField<String>,
        private val createdAt: JsonField<String>,
        private val likeCount: JsonField<Long>,
        private val previewText: JsonField<String>,
        private val quoteCount: JsonField<Long>,
        private val replyCount: JsonField<Long>,
        private val title: JsonField<String>,
        private val viewCount: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("bodyText")
            @ExcludeMissing
            bodyText: JsonField<String> = JsonMissing.of(),
            @JsonProperty("contents")
            @ExcludeMissing
            contents: JsonField<List<Content>> = JsonMissing.of(),
            @JsonProperty("coverImageUrl")
            @ExcludeMissing
            coverImageUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("likeCount")
            @ExcludeMissing
            likeCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("previewText")
            @ExcludeMissing
            previewText: JsonField<String> = JsonMissing.of(),
            @JsonProperty("quoteCount")
            @ExcludeMissing
            quoteCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("replyCount")
            @ExcludeMissing
            replyCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("title") @ExcludeMissing title: JsonField<String> = JsonMissing.of(),
            @JsonProperty("viewCount")
            @ExcludeMissing
            viewCount: JsonField<Long> = JsonMissing.of(),
        ) : this(
            bodyText,
            contents,
            coverImageUrl,
            createdAt,
            likeCount,
            previewText,
            quoteCount,
            replyCount,
            title,
            viewCount,
            mutableMapOf(),
        )

        /**
         * Plain text joined from all article blocks
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun bodyText(): Optional<String> = bodyText.getOptional("bodyText")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun contents(): Optional<List<Content>> = contents.getOptional("contents")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun coverImageUrl(): Optional<String> = coverImageUrl.getOptional("coverImageUrl")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun createdAt(): Optional<String> = createdAt.getOptional("createdAt")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun likeCount(): Optional<Long> = likeCount.getOptional("likeCount")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun previewText(): Optional<String> = previewText.getOptional("previewText")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun quoteCount(): Optional<Long> = quoteCount.getOptional("quoteCount")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun replyCount(): Optional<Long> = replyCount.getOptional("replyCount")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun title(): Optional<String> = title.getOptional("title")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun viewCount(): Optional<Long> = viewCount.getOptional("viewCount")

        /**
         * Returns the raw JSON value of [bodyText].
         *
         * Unlike [bodyText], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("bodyText") @ExcludeMissing fun _bodyText(): JsonField<String> = bodyText

        /**
         * Returns the raw JSON value of [contents].
         *
         * Unlike [contents], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("contents")
        @ExcludeMissing
        fun _contents(): JsonField<List<Content>> = contents

        /**
         * Returns the raw JSON value of [coverImageUrl].
         *
         * Unlike [coverImageUrl], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("coverImageUrl")
        @ExcludeMissing
        fun _coverImageUrl(): JsonField<String> = coverImageUrl

        /**
         * Returns the raw JSON value of [createdAt].
         *
         * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("createdAt") @ExcludeMissing fun _createdAt(): JsonField<String> = createdAt

        /**
         * Returns the raw JSON value of [likeCount].
         *
         * Unlike [likeCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("likeCount") @ExcludeMissing fun _likeCount(): JsonField<Long> = likeCount

        /**
         * Returns the raw JSON value of [previewText].
         *
         * Unlike [previewText], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("previewText")
        @ExcludeMissing
        fun _previewText(): JsonField<String> = previewText

        /**
         * Returns the raw JSON value of [quoteCount].
         *
         * Unlike [quoteCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("quoteCount") @ExcludeMissing fun _quoteCount(): JsonField<Long> = quoteCount

        /**
         * Returns the raw JSON value of [replyCount].
         *
         * Unlike [replyCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("replyCount") @ExcludeMissing fun _replyCount(): JsonField<Long> = replyCount

        /**
         * Returns the raw JSON value of [title].
         *
         * Unlike [title], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("title") @ExcludeMissing fun _title(): JsonField<String> = title

        /**
         * Returns the raw JSON value of [viewCount].
         *
         * Unlike [viewCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("viewCount") @ExcludeMissing fun _viewCount(): JsonField<Long> = viewCount

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

            /** Returns a mutable builder for constructing an instance of [Article]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Article]. */
        class Builder internal constructor() {

            private var bodyText: JsonField<String> = JsonMissing.of()
            private var contents: JsonField<MutableList<Content>>? = null
            private var coverImageUrl: JsonField<String> = JsonMissing.of()
            private var createdAt: JsonField<String> = JsonMissing.of()
            private var likeCount: JsonField<Long> = JsonMissing.of()
            private var previewText: JsonField<String> = JsonMissing.of()
            private var quoteCount: JsonField<Long> = JsonMissing.of()
            private var replyCount: JsonField<Long> = JsonMissing.of()
            private var title: JsonField<String> = JsonMissing.of()
            private var viewCount: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(article: Article) = apply {
                bodyText = article.bodyText
                contents = article.contents.map { it.toMutableList() }
                coverImageUrl = article.coverImageUrl
                createdAt = article.createdAt
                likeCount = article.likeCount
                previewText = article.previewText
                quoteCount = article.quoteCount
                replyCount = article.replyCount
                title = article.title
                viewCount = article.viewCount
                additionalProperties = article.additionalProperties.toMutableMap()
            }

            /** Plain text joined from all article blocks */
            fun bodyText(bodyText: String) = bodyText(JsonField.of(bodyText))

            /**
             * Sets [Builder.bodyText] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bodyText] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bodyText(bodyText: JsonField<String>) = apply { this.bodyText = bodyText }

            fun contents(contents: List<Content>) = contents(JsonField.of(contents))

            /**
             * Sets [Builder.contents] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contents] with a well-typed `List<Content>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun contents(contents: JsonField<List<Content>>) = apply {
                this.contents = contents.map { it.toMutableList() }
            }

            /**
             * Adds a single [Content] to [contents].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addContent(content: Content) = apply {
                contents =
                    (contents ?: JsonField.of(mutableListOf())).also {
                        checkKnown("contents", it).add(content)
                    }
            }

            fun coverImageUrl(coverImageUrl: String) = coverImageUrl(JsonField.of(coverImageUrl))

            /**
             * Sets [Builder.coverImageUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.coverImageUrl] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun coverImageUrl(coverImageUrl: JsonField<String>) = apply {
                this.coverImageUrl = coverImageUrl
            }

            fun createdAt(createdAt: String) = createdAt(JsonField.of(createdAt))

            /**
             * Sets [Builder.createdAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.createdAt] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun createdAt(createdAt: JsonField<String>) = apply { this.createdAt = createdAt }

            fun likeCount(likeCount: Long) = likeCount(JsonField.of(likeCount))

            /**
             * Sets [Builder.likeCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.likeCount] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun likeCount(likeCount: JsonField<Long>) = apply { this.likeCount = likeCount }

            fun previewText(previewText: String) = previewText(JsonField.of(previewText))

            /**
             * Sets [Builder.previewText] to an arbitrary JSON value.
             *
             * You should usually call [Builder.previewText] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun previewText(previewText: JsonField<String>) = apply {
                this.previewText = previewText
            }

            fun quoteCount(quoteCount: Long) = quoteCount(JsonField.of(quoteCount))

            /**
             * Sets [Builder.quoteCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.quoteCount] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun quoteCount(quoteCount: JsonField<Long>) = apply { this.quoteCount = quoteCount }

            fun replyCount(replyCount: Long) = replyCount(JsonField.of(replyCount))

            /**
             * Sets [Builder.replyCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.replyCount] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun replyCount(replyCount: JsonField<Long>) = apply { this.replyCount = replyCount }

            fun title(title: String) = title(JsonField.of(title))

            /**
             * Sets [Builder.title] to an arbitrary JSON value.
             *
             * You should usually call [Builder.title] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun title(title: JsonField<String>) = apply { this.title = title }

            fun viewCount(viewCount: Long) = viewCount(JsonField.of(viewCount))

            /**
             * Sets [Builder.viewCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.viewCount] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun viewCount(viewCount: JsonField<Long>) = apply { this.viewCount = viewCount }

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
             * Returns an immutable instance of [Article].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Article =
                Article(
                    bodyText,
                    (contents ?: JsonMissing.of()).map { it.toImmutable() },
                    coverImageUrl,
                    createdAt,
                    likeCount,
                    previewText,
                    quoteCount,
                    replyCount,
                    title,
                    viewCount,
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
        fun validate(): Article = apply {
            if (validated) {
                return@apply
            }

            bodyText()
            contents().ifPresent { it.forEach { it.validate() } }
            coverImageUrl()
            createdAt()
            likeCount()
            previewText()
            quoteCount()
            replyCount()
            title()
            viewCount()
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
        @JvmSynthetic
        internal fun validity(): Int =
            (if (bodyText.asKnown().isPresent) 1 else 0) +
                (contents.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (coverImageUrl.asKnown().isPresent) 1 else 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (likeCount.asKnown().isPresent) 1 else 0) +
                (if (previewText.asKnown().isPresent) 1 else 0) +
                (if (quoteCount.asKnown().isPresent) 1 else 0) +
                (if (replyCount.asKnown().isPresent) 1 else 0) +
                (if (title.asKnown().isPresent) 1 else 0) +
                (if (viewCount.asKnown().isPresent) 1 else 0)

        class Content
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val height: JsonField<Long>,
            private val inlineStyleRanges: JsonField<List<InlineStyleRange>>,
            private val previewUrl: JsonField<String>,
            private val text: JsonField<String>,
            private val type: JsonField<String>,
            private val url: JsonField<String>,
            private val width: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("height") @ExcludeMissing height: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("inlineStyleRanges")
                @ExcludeMissing
                inlineStyleRanges: JsonField<List<InlineStyleRange>> = JsonMissing.of(),
                @JsonProperty("previewUrl")
                @ExcludeMissing
                previewUrl: JsonField<String> = JsonMissing.of(),
                @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
                @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
                @JsonProperty("width") @ExcludeMissing width: JsonField<Long> = JsonMissing.of(),
            ) : this(height, inlineStyleRanges, previewUrl, text, type, url, width, mutableMapOf())

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun height(): Optional<Long> = height.getOptional("height")

            /**
             * Inline text formatting ranges
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun inlineStyleRanges(): Optional<List<InlineStyleRange>> =
                inlineStyleRanges.getOptional("inlineStyleRanges")

            /**
             * Preview image URL for media blocks
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun previewUrl(): Optional<String> = previewUrl.getOptional("previewUrl")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun text(): Optional<String> = text.getOptional("text")

            /**
             * Block type: paragraph, header-one, header-two, header-three, header-four,
             * header-five, header-six, unordered-list-item, ordered-list-item, blockquote,
             * code-block, media, divider
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun type(): Optional<String> = type.getOptional("type")

            /**
             * Media URL for media blocks
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun url(): Optional<String> = url.getOptional("url")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun width(): Optional<Long> = width.getOptional("width")

            /**
             * Returns the raw JSON value of [height].
             *
             * Unlike [height], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("height") @ExcludeMissing fun _height(): JsonField<Long> = height

            /**
             * Returns the raw JSON value of [inlineStyleRanges].
             *
             * Unlike [inlineStyleRanges], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("inlineStyleRanges")
            @ExcludeMissing
            fun _inlineStyleRanges(): JsonField<List<InlineStyleRange>> = inlineStyleRanges

            /**
             * Returns the raw JSON value of [previewUrl].
             *
             * Unlike [previewUrl], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("previewUrl")
            @ExcludeMissing
            fun _previewUrl(): JsonField<String> = previewUrl

            /**
             * Returns the raw JSON value of [text].
             *
             * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

            /**
             * Returns the raw JSON value of [url].
             *
             * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

            /**
             * Returns the raw JSON value of [width].
             *
             * Unlike [width], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("width") @ExcludeMissing fun _width(): JsonField<Long> = width

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

                /** Returns a mutable builder for constructing an instance of [Content]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Content]. */
            class Builder internal constructor() {

                private var height: JsonField<Long> = JsonMissing.of()
                private var inlineStyleRanges: JsonField<MutableList<InlineStyleRange>>? = null
                private var previewUrl: JsonField<String> = JsonMissing.of()
                private var text: JsonField<String> = JsonMissing.of()
                private var type: JsonField<String> = JsonMissing.of()
                private var url: JsonField<String> = JsonMissing.of()
                private var width: JsonField<Long> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(content: Content) = apply {
                    height = content.height
                    inlineStyleRanges = content.inlineStyleRanges.map { it.toMutableList() }
                    previewUrl = content.previewUrl
                    text = content.text
                    type = content.type
                    url = content.url
                    width = content.width
                    additionalProperties = content.additionalProperties.toMutableMap()
                }

                fun height(height: Long) = height(JsonField.of(height))

                /**
                 * Sets [Builder.height] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.height] with a well-typed [Long] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun height(height: JsonField<Long>) = apply { this.height = height }

                /** Inline text formatting ranges */
                fun inlineStyleRanges(inlineStyleRanges: List<InlineStyleRange>) =
                    inlineStyleRanges(JsonField.of(inlineStyleRanges))

                /**
                 * Sets [Builder.inlineStyleRanges] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.inlineStyleRanges] with a well-typed
                 * `List<InlineStyleRange>` value instead. This method is primarily for setting the
                 * field to an undocumented or not yet supported value.
                 */
                fun inlineStyleRanges(inlineStyleRanges: JsonField<List<InlineStyleRange>>) =
                    apply {
                        this.inlineStyleRanges = inlineStyleRanges.map { it.toMutableList() }
                    }

                /**
                 * Adds a single [InlineStyleRange] to [inlineStyleRanges].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addInlineStyleRange(inlineStyleRange: InlineStyleRange) = apply {
                    inlineStyleRanges =
                        (inlineStyleRanges ?: JsonField.of(mutableListOf())).also {
                            checkKnown("inlineStyleRanges", it).add(inlineStyleRange)
                        }
                }

                /** Preview image URL for media blocks */
                fun previewUrl(previewUrl: String) = previewUrl(JsonField.of(previewUrl))

                /**
                 * Sets [Builder.previewUrl] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.previewUrl] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun previewUrl(previewUrl: JsonField<String>) = apply {
                    this.previewUrl = previewUrl
                }

                fun text(text: String) = text(JsonField.of(text))

                /**
                 * Sets [Builder.text] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.text] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun text(text: JsonField<String>) = apply { this.text = text }

                /**
                 * Block type: paragraph, header-one, header-two, header-three, header-four,
                 * header-five, header-six, unordered-list-item, ordered-list-item, blockquote,
                 * code-block, media, divider
                 */
                fun type(type: String) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<String>) = apply { this.type = type }

                /** Media URL for media blocks */
                fun url(url: String) = url(JsonField.of(url))

                /**
                 * Sets [Builder.url] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.url] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun url(url: JsonField<String>) = apply { this.url = url }

                fun width(width: Long) = width(JsonField.of(width))

                /**
                 * Sets [Builder.width] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.width] with a well-typed [Long] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun width(width: JsonField<Long>) = apply { this.width = width }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Content].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Content =
                    Content(
                        height,
                        (inlineStyleRanges ?: JsonMissing.of()).map { it.toImmutable() },
                        previewUrl,
                        text,
                        type,
                        url,
                        width,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
             *   match its expected type.
             */
            fun validate(): Content = apply {
                if (validated) {
                    return@apply
                }

                height()
                inlineStyleRanges().ifPresent { it.forEach { it.validate() } }
                previewUrl()
                text()
                type()
                url()
                width()
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
            @JvmSynthetic
            internal fun validity(): Int =
                (if (height.asKnown().isPresent) 1 else 0) +
                    (inlineStyleRanges.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                    (if (previewUrl.asKnown().isPresent) 1 else 0) +
                    (if (text.asKnown().isPresent) 1 else 0) +
                    (if (type.asKnown().isPresent) 1 else 0) +
                    (if (url.asKnown().isPresent) 1 else 0) +
                    (if (width.asKnown().isPresent) 1 else 0)

            class InlineStyleRange
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val length: JsonField<Long>,
                private val offset: JsonField<Long>,
                private val style: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("length")
                    @ExcludeMissing
                    length: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("offset")
                    @ExcludeMissing
                    offset: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("style")
                    @ExcludeMissing
                    style: JsonField<String> = JsonMissing.of(),
                ) : this(length, offset, style, mutableMapOf())

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type (e.g. if the server responded with an unexpected value).
                 */
                fun length(): Optional<Long> = length.getOptional("length")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type (e.g. if the server responded with an unexpected value).
                 */
                fun offset(): Optional<Long> = offset.getOptional("offset")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type (e.g. if the server responded with an unexpected value).
                 */
                fun style(): Optional<String> = style.getOptional("style")

                /**
                 * Returns the raw JSON value of [length].
                 *
                 * Unlike [length], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("length") @ExcludeMissing fun _length(): JsonField<Long> = length

                /**
                 * Returns the raw JSON value of [offset].
                 *
                 * Unlike [offset], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("offset") @ExcludeMissing fun _offset(): JsonField<Long> = offset

                /**
                 * Returns the raw JSON value of [style].
                 *
                 * Unlike [style], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("style") @ExcludeMissing fun _style(): JsonField<String> = style

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
                     * Returns a mutable builder for constructing an instance of [InlineStyleRange].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [InlineStyleRange]. */
                class Builder internal constructor() {

                    private var length: JsonField<Long> = JsonMissing.of()
                    private var offset: JsonField<Long> = JsonMissing.of()
                    private var style: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(inlineStyleRange: InlineStyleRange) = apply {
                        length = inlineStyleRange.length
                        offset = inlineStyleRange.offset
                        style = inlineStyleRange.style
                        additionalProperties = inlineStyleRange.additionalProperties.toMutableMap()
                    }

                    fun length(length: Long) = length(JsonField.of(length))

                    /**
                     * Sets [Builder.length] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.length] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun length(length: JsonField<Long>) = apply { this.length = length }

                    fun offset(offset: Long) = offset(JsonField.of(offset))

                    /**
                     * Sets [Builder.offset] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.offset] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun offset(offset: JsonField<Long>) = apply { this.offset = offset }

                    fun style(style: String) = style(JsonField.of(style))

                    /**
                     * Sets [Builder.style] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.style] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun style(style: JsonField<String>) = apply { this.style = style }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [InlineStyleRange].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): InlineStyleRange =
                        InlineStyleRange(length, offset, style, additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): InlineStyleRange = apply {
                    if (validated) {
                        return@apply
                    }

                    length()
                    offset()
                    style()
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
                @JvmSynthetic
                internal fun validity(): Int =
                    (if (length.asKnown().isPresent) 1 else 0) +
                        (if (offset.asKnown().isPresent) 1 else 0) +
                        (if (style.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is InlineStyleRange &&
                        length == other.length &&
                        offset == other.offset &&
                        style == other.style &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(length, offset, style, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "InlineStyleRange{length=$length, offset=$offset, style=$style, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Content &&
                    height == other.height &&
                    inlineStyleRanges == other.inlineStyleRanges &&
                    previewUrl == other.previewUrl &&
                    text == other.text &&
                    type == other.type &&
                    url == other.url &&
                    width == other.width &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    height,
                    inlineStyleRanges,
                    previewUrl,
                    text,
                    type,
                    url,
                    width,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Content{height=$height, inlineStyleRanges=$inlineStyleRanges, previewUrl=$previewUrl, text=$text, type=$type, url=$url, width=$width, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Article &&
                bodyText == other.bodyText &&
                contents == other.contents &&
                coverImageUrl == other.coverImageUrl &&
                createdAt == other.createdAt &&
                likeCount == other.likeCount &&
                previewText == other.previewText &&
                quoteCount == other.quoteCount &&
                replyCount == other.replyCount &&
                title == other.title &&
                viewCount == other.viewCount &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                bodyText,
                contents,
                coverImageUrl,
                createdAt,
                likeCount,
                previewText,
                quoteCount,
                replyCount,
                title,
                viewCount,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Article{bodyText=$bodyText, contents=$contents, coverImageUrl=$coverImageUrl, createdAt=$createdAt, likeCount=$likeCount, previewText=$previewText, quoteCount=$quoteCount, replyCount=$replyCount, title=$title, viewCount=$viewCount, additionalProperties=$additionalProperties}"
    }

    /** X Article author profile fields returned when available. */
    class Author
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val name: JsonField<String>,
        private val username: JsonField<String>,
        private val canDm: JsonField<Boolean>,
        private val createdAt: JsonField<String>,
        private val description: JsonField<String>,
        private val favouritesCount: JsonField<Long>,
        private val followersCount: JsonField<Long>,
        private val followingCount: JsonField<Long>,
        private val isBlueVerified: JsonField<Boolean>,
        private val isTranslator: JsonField<Boolean>,
        private val isVerified: JsonField<Boolean>,
        private val location: JsonField<String>,
        private val mediaCount: JsonField<Long>,
        private val profileBannerUrl: JsonField<String>,
        private val profilePicture: JsonField<String>,
        private val protected_: JsonField<Boolean>,
        private val statusesCount: JsonField<Long>,
        private val url: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("username")
            @ExcludeMissing
            username: JsonField<String> = JsonMissing.of(),
            @JsonProperty("canDm") @ExcludeMissing canDm: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("favouritesCount")
            @ExcludeMissing
            favouritesCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("followersCount")
            @ExcludeMissing
            followersCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("followingCount")
            @ExcludeMissing
            followingCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("isBlueVerified")
            @ExcludeMissing
            isBlueVerified: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("isTranslator")
            @ExcludeMissing
            isTranslator: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("isVerified")
            @ExcludeMissing
            isVerified: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("location")
            @ExcludeMissing
            location: JsonField<String> = JsonMissing.of(),
            @JsonProperty("mediaCount")
            @ExcludeMissing
            mediaCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("profileBannerUrl")
            @ExcludeMissing
            profileBannerUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("profilePicture")
            @ExcludeMissing
            profilePicture: JsonField<String> = JsonMissing.of(),
            @JsonProperty("protected")
            @ExcludeMissing
            protected_: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("statusesCount")
            @ExcludeMissing
            statusesCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        ) : this(
            id,
            name,
            username,
            canDm,
            createdAt,
            description,
            favouritesCount,
            followersCount,
            followingCount,
            isBlueVerified,
            isTranslator,
            isVerified,
            location,
            mediaCount,
            profileBannerUrl,
            profilePicture,
            protected_,
            statusesCount,
            url,
            mutableMapOf(),
        )

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun username(): String = username.getRequired("username")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun canDm(): Optional<Boolean> = canDm.getOptional("canDm")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun createdAt(): Optional<String> = createdAt.getOptional("createdAt")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun description(): Optional<String> = description.getOptional("description")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun favouritesCount(): Optional<Long> = favouritesCount.getOptional("favouritesCount")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun followersCount(): Optional<Long> = followersCount.getOptional("followersCount")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun followingCount(): Optional<Long> = followingCount.getOptional("followingCount")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun isBlueVerified(): Optional<Boolean> = isBlueVerified.getOptional("isBlueVerified")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun isTranslator(): Optional<Boolean> = isTranslator.getOptional("isTranslator")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun isVerified(): Optional<Boolean> = isVerified.getOptional("isVerified")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun location(): Optional<String> = location.getOptional("location")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun mediaCount(): Optional<Long> = mediaCount.getOptional("mediaCount")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun profileBannerUrl(): Optional<String> = profileBannerUrl.getOptional("profileBannerUrl")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun profilePicture(): Optional<String> = profilePicture.getOptional("profilePicture")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun protected_(): Optional<Boolean> = protected_.getOptional("protected")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun statusesCount(): Optional<Long> = statusesCount.getOptional("statusesCount")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun url(): Optional<String> = url.getOptional("url")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [username].
         *
         * Unlike [username], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username

        /**
         * Returns the raw JSON value of [canDm].
         *
         * Unlike [canDm], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("canDm") @ExcludeMissing fun _canDm(): JsonField<Boolean> = canDm

        /**
         * Returns the raw JSON value of [createdAt].
         *
         * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("createdAt") @ExcludeMissing fun _createdAt(): JsonField<String> = createdAt

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [favouritesCount].
         *
         * Unlike [favouritesCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("favouritesCount")
        @ExcludeMissing
        fun _favouritesCount(): JsonField<Long> = favouritesCount

        /**
         * Returns the raw JSON value of [followersCount].
         *
         * Unlike [followersCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("followersCount")
        @ExcludeMissing
        fun _followersCount(): JsonField<Long> = followersCount

        /**
         * Returns the raw JSON value of [followingCount].
         *
         * Unlike [followingCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("followingCount")
        @ExcludeMissing
        fun _followingCount(): JsonField<Long> = followingCount

        /**
         * Returns the raw JSON value of [isBlueVerified].
         *
         * Unlike [isBlueVerified], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("isBlueVerified")
        @ExcludeMissing
        fun _isBlueVerified(): JsonField<Boolean> = isBlueVerified

        /**
         * Returns the raw JSON value of [isTranslator].
         *
         * Unlike [isTranslator], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("isTranslator")
        @ExcludeMissing
        fun _isTranslator(): JsonField<Boolean> = isTranslator

        /**
         * Returns the raw JSON value of [isVerified].
         *
         * Unlike [isVerified], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("isVerified")
        @ExcludeMissing
        fun _isVerified(): JsonField<Boolean> = isVerified

        /**
         * Returns the raw JSON value of [location].
         *
         * Unlike [location], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("location") @ExcludeMissing fun _location(): JsonField<String> = location

        /**
         * Returns the raw JSON value of [mediaCount].
         *
         * Unlike [mediaCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("mediaCount") @ExcludeMissing fun _mediaCount(): JsonField<Long> = mediaCount

        /**
         * Returns the raw JSON value of [profileBannerUrl].
         *
         * Unlike [profileBannerUrl], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("profileBannerUrl")
        @ExcludeMissing
        fun _profileBannerUrl(): JsonField<String> = profileBannerUrl

        /**
         * Returns the raw JSON value of [profilePicture].
         *
         * Unlike [profilePicture], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("profilePicture")
        @ExcludeMissing
        fun _profilePicture(): JsonField<String> = profilePicture

        /**
         * Returns the raw JSON value of [protected_].
         *
         * Unlike [protected_], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("protected")
        @ExcludeMissing
        fun _protected_(): JsonField<Boolean> = protected_

        /**
         * Returns the raw JSON value of [statusesCount].
         *
         * Unlike [statusesCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("statusesCount")
        @ExcludeMissing
        fun _statusesCount(): JsonField<Long> = statusesCount

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
             * Returns a mutable builder for constructing an instance of [Author].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .name()
             * .username()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Author]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var name: JsonField<String>? = null
            private var username: JsonField<String>? = null
            private var canDm: JsonField<Boolean> = JsonMissing.of()
            private var createdAt: JsonField<String> = JsonMissing.of()
            private var description: JsonField<String> = JsonMissing.of()
            private var favouritesCount: JsonField<Long> = JsonMissing.of()
            private var followersCount: JsonField<Long> = JsonMissing.of()
            private var followingCount: JsonField<Long> = JsonMissing.of()
            private var isBlueVerified: JsonField<Boolean> = JsonMissing.of()
            private var isTranslator: JsonField<Boolean> = JsonMissing.of()
            private var isVerified: JsonField<Boolean> = JsonMissing.of()
            private var location: JsonField<String> = JsonMissing.of()
            private var mediaCount: JsonField<Long> = JsonMissing.of()
            private var profileBannerUrl: JsonField<String> = JsonMissing.of()
            private var profilePicture: JsonField<String> = JsonMissing.of()
            private var protected_: JsonField<Boolean> = JsonMissing.of()
            private var statusesCount: JsonField<Long> = JsonMissing.of()
            private var url: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(author: Author) = apply {
                id = author.id
                name = author.name
                username = author.username
                canDm = author.canDm
                createdAt = author.createdAt
                description = author.description
                favouritesCount = author.favouritesCount
                followersCount = author.followersCount
                followingCount = author.followingCount
                isBlueVerified = author.isBlueVerified
                isTranslator = author.isTranslator
                isVerified = author.isVerified
                location = author.location
                mediaCount = author.mediaCount
                profileBannerUrl = author.profileBannerUrl
                profilePicture = author.profilePicture
                protected_ = author.protected_
                statusesCount = author.statusesCount
                url = author.url
                additionalProperties = author.additionalProperties.toMutableMap()
            }

            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            fun username(username: String) = username(JsonField.of(username))

            /**
             * Sets [Builder.username] to an arbitrary JSON value.
             *
             * You should usually call [Builder.username] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun username(username: JsonField<String>) = apply { this.username = username }

            fun canDm(canDm: Boolean) = canDm(JsonField.of(canDm))

            /**
             * Sets [Builder.canDm] to an arbitrary JSON value.
             *
             * You should usually call [Builder.canDm] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun canDm(canDm: JsonField<Boolean>) = apply { this.canDm = canDm }

            fun createdAt(createdAt: String) = createdAt(JsonField.of(createdAt))

            /**
             * Sets [Builder.createdAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.createdAt] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun createdAt(createdAt: JsonField<String>) = apply { this.createdAt = createdAt }

            fun description(description: String) = description(JsonField.of(description))

            /**
             * Sets [Builder.description] to an arbitrary JSON value.
             *
             * You should usually call [Builder.description] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

            fun favouritesCount(favouritesCount: Long) =
                favouritesCount(JsonField.of(favouritesCount))

            /**
             * Sets [Builder.favouritesCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.favouritesCount] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun favouritesCount(favouritesCount: JsonField<Long>) = apply {
                this.favouritesCount = favouritesCount
            }

            fun followersCount(followersCount: Long) = followersCount(JsonField.of(followersCount))

            /**
             * Sets [Builder.followersCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.followersCount] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun followersCount(followersCount: JsonField<Long>) = apply {
                this.followersCount = followersCount
            }

            fun followingCount(followingCount: Long) = followingCount(JsonField.of(followingCount))

            /**
             * Sets [Builder.followingCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.followingCount] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun followingCount(followingCount: JsonField<Long>) = apply {
                this.followingCount = followingCount
            }

            fun isBlueVerified(isBlueVerified: Boolean) =
                isBlueVerified(JsonField.of(isBlueVerified))

            /**
             * Sets [Builder.isBlueVerified] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isBlueVerified] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isBlueVerified(isBlueVerified: JsonField<Boolean>) = apply {
                this.isBlueVerified = isBlueVerified
            }

            fun isTranslator(isTranslator: Boolean) = isTranslator(JsonField.of(isTranslator))

            /**
             * Sets [Builder.isTranslator] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isTranslator] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isTranslator(isTranslator: JsonField<Boolean>) = apply {
                this.isTranslator = isTranslator
            }

            fun isVerified(isVerified: Boolean) = isVerified(JsonField.of(isVerified))

            /**
             * Sets [Builder.isVerified] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isVerified] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isVerified(isVerified: JsonField<Boolean>) = apply { this.isVerified = isVerified }

            fun location(location: String) = location(JsonField.of(location))

            /**
             * Sets [Builder.location] to an arbitrary JSON value.
             *
             * You should usually call [Builder.location] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun location(location: JsonField<String>) = apply { this.location = location }

            fun mediaCount(mediaCount: Long) = mediaCount(JsonField.of(mediaCount))

            /**
             * Sets [Builder.mediaCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mediaCount] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun mediaCount(mediaCount: JsonField<Long>) = apply { this.mediaCount = mediaCount }

            fun profileBannerUrl(profileBannerUrl: String) =
                profileBannerUrl(JsonField.of(profileBannerUrl))

            /**
             * Sets [Builder.profileBannerUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.profileBannerUrl] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun profileBannerUrl(profileBannerUrl: JsonField<String>) = apply {
                this.profileBannerUrl = profileBannerUrl
            }

            fun profilePicture(profilePicture: String) =
                profilePicture(JsonField.of(profilePicture))

            /**
             * Sets [Builder.profilePicture] to an arbitrary JSON value.
             *
             * You should usually call [Builder.profilePicture] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun profilePicture(profilePicture: JsonField<String>) = apply {
                this.profilePicture = profilePicture
            }

            fun protected_(protected_: Boolean) = protected_(JsonField.of(protected_))

            /**
             * Sets [Builder.protected_] to an arbitrary JSON value.
             *
             * You should usually call [Builder.protected_] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun protected_(protected_: JsonField<Boolean>) = apply { this.protected_ = protected_ }

            fun statusesCount(statusesCount: Long) = statusesCount(JsonField.of(statusesCount))

            /**
             * Sets [Builder.statusesCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.statusesCount] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun statusesCount(statusesCount: JsonField<Long>) = apply {
                this.statusesCount = statusesCount
            }

            fun url(url: String) = url(JsonField.of(url))

            /**
             * Sets [Builder.url] to an arbitrary JSON value.
             *
             * You should usually call [Builder.url] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
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
             * Returns an immutable instance of [Author].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .name()
             * .username()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Author =
                Author(
                    checkRequired("id", id),
                    checkRequired("name", name),
                    checkRequired("username", username),
                    canDm,
                    createdAt,
                    description,
                    favouritesCount,
                    followersCount,
                    followingCount,
                    isBlueVerified,
                    isTranslator,
                    isVerified,
                    location,
                    mediaCount,
                    profileBannerUrl,
                    profilePicture,
                    protected_,
                    statusesCount,
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
        fun validate(): Author = apply {
            if (validated) {
                return@apply
            }

            id()
            name()
            username()
            canDm()
            createdAt()
            description()
            favouritesCount()
            followersCount()
            followingCount()
            isBlueVerified()
            isTranslator()
            isVerified()
            location()
            mediaCount()
            profileBannerUrl()
            profilePicture()
            protected_()
            statusesCount()
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

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (username.asKnown().isPresent) 1 else 0) +
                (if (canDm.asKnown().isPresent) 1 else 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (description.asKnown().isPresent) 1 else 0) +
                (if (favouritesCount.asKnown().isPresent) 1 else 0) +
                (if (followersCount.asKnown().isPresent) 1 else 0) +
                (if (followingCount.asKnown().isPresent) 1 else 0) +
                (if (isBlueVerified.asKnown().isPresent) 1 else 0) +
                (if (isTranslator.asKnown().isPresent) 1 else 0) +
                (if (isVerified.asKnown().isPresent) 1 else 0) +
                (if (location.asKnown().isPresent) 1 else 0) +
                (if (mediaCount.asKnown().isPresent) 1 else 0) +
                (if (profileBannerUrl.asKnown().isPresent) 1 else 0) +
                (if (profilePicture.asKnown().isPresent) 1 else 0) +
                (if (protected_.asKnown().isPresent) 1 else 0) +
                (if (statusesCount.asKnown().isPresent) 1 else 0) +
                (if (url.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Author &&
                id == other.id &&
                name == other.name &&
                username == other.username &&
                canDm == other.canDm &&
                createdAt == other.createdAt &&
                description == other.description &&
                favouritesCount == other.favouritesCount &&
                followersCount == other.followersCount &&
                followingCount == other.followingCount &&
                isBlueVerified == other.isBlueVerified &&
                isTranslator == other.isTranslator &&
                isVerified == other.isVerified &&
                location == other.location &&
                mediaCount == other.mediaCount &&
                profileBannerUrl == other.profileBannerUrl &&
                profilePicture == other.profilePicture &&
                protected_ == other.protected_ &&
                statusesCount == other.statusesCount &&
                url == other.url &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                name,
                username,
                canDm,
                createdAt,
                description,
                favouritesCount,
                followersCount,
                followingCount,
                isBlueVerified,
                isTranslator,
                isVerified,
                location,
                mediaCount,
                profileBannerUrl,
                profilePicture,
                protected_,
                statusesCount,
                url,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Author{id=$id, name=$name, username=$username, canDm=$canDm, createdAt=$createdAt, description=$description, favouritesCount=$favouritesCount, followersCount=$followersCount, followingCount=$followingCount, isBlueVerified=$isBlueVerified, isTranslator=$isTranslator, isVerified=$isVerified, location=$location, mediaCount=$mediaCount, profileBannerUrl=$profileBannerUrl, profilePicture=$profilePicture, protected_=$protected_, statusesCount=$statusesCount, url=$url, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is XGetArticleResponse &&
            article == other.article &&
            author == other.author &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(article, author, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "XGetArticleResponse{article=$article, author=$author, additionalProperties=$additionalProperties}"
}
