// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x

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
     *   unexpectedly missing or null.
     */
    fun article(): Article = article.getRequired("article")

    /**
     * X Article author profile fields returned when available.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
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

        /** Sets [Builder.article] to an arbitrary JSON value. */
        fun article(article: JsonField<Article>) = apply { this.article = article }

        /** X Article author profile fields returned when available. */
        fun author(author: Author) = author(JsonField.of(author))

        /** Sets [Builder.author] to an arbitrary JSON value. */
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

    @JvmSynthetic
    internal fun validity(): Int =
        (article.asKnown().getOrNull()?.validity() ?: 0) +
            (author.asKnown().getOrNull()?.validity() ?: 0)

    class Article
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val articleId: JsonField<String>,
        private val bodyMarkdown: JsonField<String>,
        private val bodyText: JsonField<String>,
        private val bookmarkCount: JsonField<Long>,
        private val contents: JsonField<List<Content>>,
        private val coverImageUrl: JsonField<String>,
        private val coverMedia: JsonField<CoverMedia>,
        private val createdAt: JsonField<String>,
        private val lifecycleState: JsonField<LifecycleState>,
        private val likeCount: JsonField<Long>,
        private val metadata: JsonField<Metadata>,
        private val previewText: JsonField<String>,
        private val quoteCount: JsonField<Long>,
        private val replyCount: JsonField<Long>,
        private val retweetCount: JsonField<Long>,
        private val summaryText: JsonField<String>,
        private val title: JsonField<String>,
        private val viewCount: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("articleId")
            @ExcludeMissing
            articleId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("bodyMarkdown")
            @ExcludeMissing
            bodyMarkdown: JsonField<String> = JsonMissing.of(),
            @JsonProperty("bodyText")
            @ExcludeMissing
            bodyText: JsonField<String> = JsonMissing.of(),
            @JsonProperty("bookmarkCount")
            @ExcludeMissing
            bookmarkCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("contents")
            @ExcludeMissing
            contents: JsonField<List<Content>> = JsonMissing.of(),
            @JsonProperty("coverImageUrl")
            @ExcludeMissing
            coverImageUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("coverMedia")
            @ExcludeMissing
            coverMedia: JsonField<CoverMedia> = JsonMissing.of(),
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("lifecycleState")
            @ExcludeMissing
            lifecycleState: JsonField<LifecycleState> = JsonMissing.of(),
            @JsonProperty("likeCount")
            @ExcludeMissing
            likeCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("metadata")
            @ExcludeMissing
            metadata: JsonField<Metadata> = JsonMissing.of(),
            @JsonProperty("previewText")
            @ExcludeMissing
            previewText: JsonField<String> = JsonMissing.of(),
            @JsonProperty("quoteCount")
            @ExcludeMissing
            quoteCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("replyCount")
            @ExcludeMissing
            replyCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("retweetCount")
            @ExcludeMissing
            retweetCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("summaryText")
            @ExcludeMissing
            summaryText: JsonField<String> = JsonMissing.of(),
            @JsonProperty("title") @ExcludeMissing title: JsonField<String> = JsonMissing.of(),
            @JsonProperty("viewCount")
            @ExcludeMissing
            viewCount: JsonField<Long> = JsonMissing.of(),
        ) : this(
            articleId,
            bodyMarkdown,
            bodyText,
            bookmarkCount,
            contents,
            coverImageUrl,
            coverMedia,
            createdAt,
            lifecycleState,
            likeCount,
            metadata,
            previewText,
            quoteCount,
            replyCount,
            retweetCount,
            summaryText,
            title,
            viewCount,
            mutableMapOf(),
        )

        /**
         * X's ID for the Article, which differs from its post's ID
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun articleId(): Optional<String> = articleId.getOptional("articleId")

        /**
         * Article blocks as Markdown, with headings, lists, bold, italic, links, images & embedded
         * posts as their x.com URLs. Holds no HTML.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun bodyMarkdown(): Optional<String> = bodyMarkdown.getOptional("bodyMarkdown")

        /**
         * Plain text joined from all article blocks
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun bodyText(): Optional<String> = bodyText.getOptional("bodyText")

        /**
         * Accounts that bookmarked the Article's post. 0 or more.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun bookmarkCount(): Optional<Long> = bookmarkCount.getOptional("bookmarkCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun contents(): Optional<List<Content>> = contents.getOptional("contents")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun coverImageUrl(): Optional<String> = coverImageUrl.getOptional("coverImageUrl")

        /**
         * Public metadata whose fields X defines.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun coverMedia(): Optional<CoverMedia> = coverMedia.getOptional("coverMedia")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun createdAt(): Optional<String> = createdAt.getOptional("createdAt")

        /**
         * Public metadata whose fields X defines.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun lifecycleState(): Optional<LifecycleState> =
            lifecycleState.getOptional("lifecycleState")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun likeCount(): Optional<Long> = likeCount.getOptional("likeCount")

        /**
         * Public metadata whose fields X defines.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun metadata(): Optional<Metadata> = metadata.getOptional("metadata")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun previewText(): Optional<String> = previewText.getOptional("previewText")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun quoteCount(): Optional<Long> = quoteCount.getOptional("quoteCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun replyCount(): Optional<Long> = replyCount.getOptional("replyCount")

        /**
         * Reposts of the Article's post. 0 or more.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun retweetCount(): Optional<Long> = retweetCount.getOptional("retweetCount")

        /**
         * X's summary of the Article, when X has one
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun summaryText(): Optional<String> = summaryText.getOptional("summaryText")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun title(): Optional<String> = title.getOptional("title")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun viewCount(): Optional<Long> = viewCount.getOptional("viewCount")

        /**
         * Returns the raw JSON value of [articleId].
         *
         * Unlike [articleId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("articleId") @ExcludeMissing fun _articleId(): JsonField<String> = articleId

        /**
         * Returns the raw JSON value of [bodyMarkdown].
         *
         * Unlike [bodyMarkdown], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("bodyMarkdown")
        @ExcludeMissing
        fun _bodyMarkdown(): JsonField<String> = bodyMarkdown

        /**
         * Returns the raw JSON value of [bodyText].
         *
         * Unlike [bodyText], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("bodyText") @ExcludeMissing fun _bodyText(): JsonField<String> = bodyText

        /**
         * Returns the raw JSON value of [bookmarkCount].
         *
         * Unlike [bookmarkCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("bookmarkCount")
        @ExcludeMissing
        fun _bookmarkCount(): JsonField<Long> = bookmarkCount

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
         * Returns the raw JSON value of [coverMedia].
         *
         * Unlike [coverMedia], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("coverMedia")
        @ExcludeMissing
        fun _coverMedia(): JsonField<CoverMedia> = coverMedia

        /**
         * Returns the raw JSON value of [createdAt].
         *
         * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("createdAt") @ExcludeMissing fun _createdAt(): JsonField<String> = createdAt

        /**
         * Returns the raw JSON value of [lifecycleState].
         *
         * Unlike [lifecycleState], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("lifecycleState")
        @ExcludeMissing
        fun _lifecycleState(): JsonField<LifecycleState> = lifecycleState

        /**
         * Returns the raw JSON value of [likeCount].
         *
         * Unlike [likeCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("likeCount") @ExcludeMissing fun _likeCount(): JsonField<Long> = likeCount

        /**
         * Returns the raw JSON value of [metadata].
         *
         * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

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
         * Returns the raw JSON value of [retweetCount].
         *
         * Unlike [retweetCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("retweetCount")
        @ExcludeMissing
        fun _retweetCount(): JsonField<Long> = retweetCount

        /**
         * Returns the raw JSON value of [summaryText].
         *
         * Unlike [summaryText], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("summaryText")
        @ExcludeMissing
        fun _summaryText(): JsonField<String> = summaryText

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

            private var articleId: JsonField<String> = JsonMissing.of()
            private var bodyMarkdown: JsonField<String> = JsonMissing.of()
            private var bodyText: JsonField<String> = JsonMissing.of()
            private var bookmarkCount: JsonField<Long> = JsonMissing.of()
            private var contents: JsonField<MutableList<Content>>? = null
            private var coverImageUrl: JsonField<String> = JsonMissing.of()
            private var coverMedia: JsonField<CoverMedia> = JsonMissing.of()
            private var createdAt: JsonField<String> = JsonMissing.of()
            private var lifecycleState: JsonField<LifecycleState> = JsonMissing.of()
            private var likeCount: JsonField<Long> = JsonMissing.of()
            private var metadata: JsonField<Metadata> = JsonMissing.of()
            private var previewText: JsonField<String> = JsonMissing.of()
            private var quoteCount: JsonField<Long> = JsonMissing.of()
            private var replyCount: JsonField<Long> = JsonMissing.of()
            private var retweetCount: JsonField<Long> = JsonMissing.of()
            private var summaryText: JsonField<String> = JsonMissing.of()
            private var title: JsonField<String> = JsonMissing.of()
            private var viewCount: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(article: Article) = apply {
                articleId = article.articleId
                bodyMarkdown = article.bodyMarkdown
                bodyText = article.bodyText
                bookmarkCount = article.bookmarkCount
                contents = article.contents.map { it.toMutableList() }
                coverImageUrl = article.coverImageUrl
                coverMedia = article.coverMedia
                createdAt = article.createdAt
                lifecycleState = article.lifecycleState
                likeCount = article.likeCount
                metadata = article.metadata
                previewText = article.previewText
                quoteCount = article.quoteCount
                replyCount = article.replyCount
                retweetCount = article.retweetCount
                summaryText = article.summaryText
                title = article.title
                viewCount = article.viewCount
                additionalProperties = article.additionalProperties.toMutableMap()
            }

            /** X's ID for the Article, which differs from its post's ID */
            fun articleId(articleId: String) = articleId(JsonField.of(articleId))

            /** Sets [Builder.articleId] to an arbitrary JSON value. */
            fun articleId(articleId: JsonField<String>) = apply { this.articleId = articleId }

            /**
             * Article blocks as Markdown, with headings, lists, bold, italic, links, images &
             * embedded posts as their x.com URLs. Holds no HTML.
             */
            fun bodyMarkdown(bodyMarkdown: String) = bodyMarkdown(JsonField.of(bodyMarkdown))

            /** Sets [Builder.bodyMarkdown] to an arbitrary JSON value. */
            fun bodyMarkdown(bodyMarkdown: JsonField<String>) = apply {
                this.bodyMarkdown = bodyMarkdown
            }

            /** Plain text joined from all article blocks */
            fun bodyText(bodyText: String) = bodyText(JsonField.of(bodyText))

            /** Sets [Builder.bodyText] to an arbitrary JSON value. */
            fun bodyText(bodyText: JsonField<String>) = apply { this.bodyText = bodyText }

            /** Accounts that bookmarked the Article's post. 0 or more. */
            fun bookmarkCount(bookmarkCount: Long) = bookmarkCount(JsonField.of(bookmarkCount))

            /** Sets [Builder.bookmarkCount] to an arbitrary JSON value. */
            fun bookmarkCount(bookmarkCount: JsonField<Long>) = apply {
                this.bookmarkCount = bookmarkCount
            }

            fun contents(contents: List<Content>) = contents(JsonField.of(contents))

            /** Sets [Builder.contents] to an arbitrary JSON value. */
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

            /** Sets [Builder.coverImageUrl] to an arbitrary JSON value. */
            fun coverImageUrl(coverImageUrl: JsonField<String>) = apply {
                this.coverImageUrl = coverImageUrl
            }

            /** Public metadata whose fields X defines. */
            fun coverMedia(coverMedia: CoverMedia) = coverMedia(JsonField.of(coverMedia))

            /** Sets [Builder.coverMedia] to an arbitrary JSON value. */
            fun coverMedia(coverMedia: JsonField<CoverMedia>) = apply {
                this.coverMedia = coverMedia
            }

            fun createdAt(createdAt: String) = createdAt(JsonField.of(createdAt))

            /** Sets [Builder.createdAt] to an arbitrary JSON value. */
            fun createdAt(createdAt: JsonField<String>) = apply { this.createdAt = createdAt }

            /** Public metadata whose fields X defines. */
            fun lifecycleState(lifecycleState: LifecycleState) =
                lifecycleState(JsonField.of(lifecycleState))

            /** Sets [Builder.lifecycleState] to an arbitrary JSON value. */
            fun lifecycleState(lifecycleState: JsonField<LifecycleState>) = apply {
                this.lifecycleState = lifecycleState
            }

            fun likeCount(likeCount: Long) = likeCount(JsonField.of(likeCount))

            /** Sets [Builder.likeCount] to an arbitrary JSON value. */
            fun likeCount(likeCount: JsonField<Long>) = apply { this.likeCount = likeCount }

            /** Public metadata whose fields X defines. */
            fun metadata(metadata: Metadata) = metadata(JsonField.of(metadata))

            /** Sets [Builder.metadata] to an arbitrary JSON value. */
            fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

            fun previewText(previewText: String) = previewText(JsonField.of(previewText))

            /** Sets [Builder.previewText] to an arbitrary JSON value. */
            fun previewText(previewText: JsonField<String>) = apply {
                this.previewText = previewText
            }

            fun quoteCount(quoteCount: Long) = quoteCount(JsonField.of(quoteCount))

            /** Sets [Builder.quoteCount] to an arbitrary JSON value. */
            fun quoteCount(quoteCount: JsonField<Long>) = apply { this.quoteCount = quoteCount }

            fun replyCount(replyCount: Long) = replyCount(JsonField.of(replyCount))

            /** Sets [Builder.replyCount] to an arbitrary JSON value. */
            fun replyCount(replyCount: JsonField<Long>) = apply { this.replyCount = replyCount }

            /** Reposts of the Article's post. 0 or more. */
            fun retweetCount(retweetCount: Long) = retweetCount(JsonField.of(retweetCount))

            /** Sets [Builder.retweetCount] to an arbitrary JSON value. */
            fun retweetCount(retweetCount: JsonField<Long>) = apply {
                this.retweetCount = retweetCount
            }

            /** X's summary of the Article, when X has one */
            fun summaryText(summaryText: String) = summaryText(JsonField.of(summaryText))

            /** Sets [Builder.summaryText] to an arbitrary JSON value. */
            fun summaryText(summaryText: JsonField<String>) = apply {
                this.summaryText = summaryText
            }

            fun title(title: String) = title(JsonField.of(title))

            /** Sets [Builder.title] to an arbitrary JSON value. */
            fun title(title: JsonField<String>) = apply { this.title = title }

            fun viewCount(viewCount: Long) = viewCount(JsonField.of(viewCount))

            /** Sets [Builder.viewCount] to an arbitrary JSON value. */
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
                    articleId,
                    bodyMarkdown,
                    bodyText,
                    bookmarkCount,
                    (contents ?: JsonMissing.of()).map { it.toImmutable() },
                    coverImageUrl,
                    coverMedia,
                    createdAt,
                    lifecycleState,
                    likeCount,
                    metadata,
                    previewText,
                    quoteCount,
                    replyCount,
                    retweetCount,
                    summaryText,
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

            articleId()
            bodyMarkdown()
            bodyText()
            bookmarkCount()
            contents().ifPresent { it.forEach { it.validate() } }
            coverImageUrl()
            coverMedia().ifPresent { it.validate() }
            createdAt()
            lifecycleState().ifPresent { it.validate() }
            likeCount()
            metadata().ifPresent { it.validate() }
            previewText()
            quoteCount()
            replyCount()
            retweetCount()
            summaryText()
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

        @JvmSynthetic
        internal fun validity(): Int =
            (if (articleId.asKnown().isPresent) 1 else 0) +
                (if (bodyMarkdown.asKnown().isPresent) 1 else 0) +
                (if (bodyText.asKnown().isPresent) 1 else 0) +
                (if (bookmarkCount.asKnown().isPresent) 1 else 0) +
                (contents.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (coverImageUrl.asKnown().isPresent) 1 else 0) +
                (coverMedia.asKnown().getOrNull()?.validity() ?: 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (lifecycleState.asKnown().getOrNull()?.validity() ?: 0) +
                (if (likeCount.asKnown().isPresent) 1 else 0) +
                (metadata.asKnown().getOrNull()?.validity() ?: 0) +
                (if (previewText.asKnown().isPresent) 1 else 0) +
                (if (quoteCount.asKnown().isPresent) 1 else 0) +
                (if (replyCount.asKnown().isPresent) 1 else 0) +
                (if (retweetCount.asKnown().isPresent) 1 else 0) +
                (if (summaryText.asKnown().isPresent) 1 else 0) +
                (if (title.asKnown().isPresent) 1 else 0) +
                (if (viewCount.asKnown().isPresent) 1 else 0)

        class Content
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val altText: JsonField<String>,
            private val caption: JsonField<String>,
            private val durationMs: JsonField<Long>,
            private val height: JsonField<Long>,
            private val inlineStyleRanges: JsonField<List<InlineStyleRange>>,
            private val links: JsonField<List<Link>>,
            private val mediaType: JsonField<MediaType>,
            private val previewUrl: JsonField<String>,
            private val text: JsonField<String>,
            private val tweetId: JsonField<String>,
            private val type: JsonField<String>,
            private val url: JsonField<String>,
            private val variants: JsonField<List<Variant>>,
            private val width: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("altText")
                @ExcludeMissing
                altText: JsonField<String> = JsonMissing.of(),
                @JsonProperty("caption")
                @ExcludeMissing
                caption: JsonField<String> = JsonMissing.of(),
                @JsonProperty("durationMs")
                @ExcludeMissing
                durationMs: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("height") @ExcludeMissing height: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("inlineStyleRanges")
                @ExcludeMissing
                inlineStyleRanges: JsonField<List<InlineStyleRange>> = JsonMissing.of(),
                @JsonProperty("links")
                @ExcludeMissing
                links: JsonField<List<Link>> = JsonMissing.of(),
                @JsonProperty("mediaType")
                @ExcludeMissing
                mediaType: JsonField<MediaType> = JsonMissing.of(),
                @JsonProperty("previewUrl")
                @ExcludeMissing
                previewUrl: JsonField<String> = JsonMissing.of(),
                @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
                @JsonProperty("tweetId")
                @ExcludeMissing
                tweetId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
                @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
                @JsonProperty("variants")
                @ExcludeMissing
                variants: JsonField<List<Variant>> = JsonMissing.of(),
                @JsonProperty("width") @ExcludeMissing width: JsonField<Long> = JsonMissing.of(),
            ) : this(
                altText,
                caption,
                durationMs,
                height,
                inlineStyleRanges,
                links,
                mediaType,
                previewUrl,
                text,
                tweetId,
                type,
                url,
                variants,
                width,
                mutableMapOf(),
            )

            /**
             * Alt text of the image or preview image
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun altText(): Optional<String> = altText.getOptional("altText")

            /**
             * Caption the author wrote under a media block
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun caption(): Optional<String> = caption.getOptional("caption")

            /**
             * Length of a video, in milliseconds
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun durationMs(): Optional<Long> = durationMs.getOptional("durationMs")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun height(): Optional<Long> = height.getOptional("height")

            /**
             * Inline text formatting ranges
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun inlineStyleRanges(): Optional<List<InlineStyleRange>> =
                inlineStyleRanges.getOptional("inlineStyleRanges")

            /**
             * Links in the block's text, with the text range each covers
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun links(): Optional<List<Link>> = links.getOptional("links")

            /**
             * What a media block holds
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun mediaType(): Optional<MediaType> = mediaType.getOptional("mediaType")

            /**
             * Preview image URL for media blocks
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun previewUrl(): Optional<String> = previewUrl.getOptional("previewUrl")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun text(): Optional<String> = text.getOptional("text")

            /**
             * ID of the post a tweet block embeds
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun tweetId(): Optional<String> = tweetId.getOptional("tweetId")

            /**
             * Block type: paragraph, header-one, header-two, header-three, header-four,
             * header-five, header-six, unordered-list-item, ordered-list-item, blockquote,
             * code-block, media, divider
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun type(): Optional<String> = type.getOptional("type")

            /**
             * Media URL for media blocks
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun url(): Optional<String> = url.getOptional("url")

            /**
             * Files of a video or GIF block, in X's order
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun variants(): Optional<List<Variant>> = variants.getOptional("variants")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun width(): Optional<Long> = width.getOptional("width")

            /**
             * Returns the raw JSON value of [altText].
             *
             * Unlike [altText], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("altText") @ExcludeMissing fun _altText(): JsonField<String> = altText

            /**
             * Returns the raw JSON value of [caption].
             *
             * Unlike [caption], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("caption") @ExcludeMissing fun _caption(): JsonField<String> = caption

            /**
             * Returns the raw JSON value of [durationMs].
             *
             * Unlike [durationMs], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("durationMs")
            @ExcludeMissing
            fun _durationMs(): JsonField<Long> = durationMs

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
             * Returns the raw JSON value of [links].
             *
             * Unlike [links], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("links") @ExcludeMissing fun _links(): JsonField<List<Link>> = links

            /**
             * Returns the raw JSON value of [mediaType].
             *
             * Unlike [mediaType], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("mediaType")
            @ExcludeMissing
            fun _mediaType(): JsonField<MediaType> = mediaType

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
             * Returns the raw JSON value of [tweetId].
             *
             * Unlike [tweetId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("tweetId") @ExcludeMissing fun _tweetId(): JsonField<String> = tweetId

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
             * Returns the raw JSON value of [variants].
             *
             * Unlike [variants], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("variants")
            @ExcludeMissing
            fun _variants(): JsonField<List<Variant>> = variants

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

                private var altText: JsonField<String> = JsonMissing.of()
                private var caption: JsonField<String> = JsonMissing.of()
                private var durationMs: JsonField<Long> = JsonMissing.of()
                private var height: JsonField<Long> = JsonMissing.of()
                private var inlineStyleRanges: JsonField<MutableList<InlineStyleRange>>? = null
                private var links: JsonField<MutableList<Link>>? = null
                private var mediaType: JsonField<MediaType> = JsonMissing.of()
                private var previewUrl: JsonField<String> = JsonMissing.of()
                private var text: JsonField<String> = JsonMissing.of()
                private var tweetId: JsonField<String> = JsonMissing.of()
                private var type: JsonField<String> = JsonMissing.of()
                private var url: JsonField<String> = JsonMissing.of()
                private var variants: JsonField<MutableList<Variant>>? = null
                private var width: JsonField<Long> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(content: Content) = apply {
                    altText = content.altText
                    caption = content.caption
                    durationMs = content.durationMs
                    height = content.height
                    inlineStyleRanges = content.inlineStyleRanges.map { it.toMutableList() }
                    links = content.links.map { it.toMutableList() }
                    mediaType = content.mediaType
                    previewUrl = content.previewUrl
                    text = content.text
                    tweetId = content.tweetId
                    type = content.type
                    url = content.url
                    variants = content.variants.map { it.toMutableList() }
                    width = content.width
                    additionalProperties = content.additionalProperties.toMutableMap()
                }

                /** Alt text of the image or preview image */
                fun altText(altText: String) = altText(JsonField.of(altText))

                /** Sets [Builder.altText] to an arbitrary JSON value. */
                fun altText(altText: JsonField<String>) = apply { this.altText = altText }

                /** Caption the author wrote under a media block */
                fun caption(caption: String) = caption(JsonField.of(caption))

                /** Sets [Builder.caption] to an arbitrary JSON value. */
                fun caption(caption: JsonField<String>) = apply { this.caption = caption }

                /** Length of a video, in milliseconds */
                fun durationMs(durationMs: Long) = durationMs(JsonField.of(durationMs))

                /** Sets [Builder.durationMs] to an arbitrary JSON value. */
                fun durationMs(durationMs: JsonField<Long>) = apply { this.durationMs = durationMs }

                fun height(height: Long) = height(JsonField.of(height))

                /** Sets [Builder.height] to an arbitrary JSON value. */
                fun height(height: JsonField<Long>) = apply { this.height = height }

                /** Inline text formatting ranges */
                fun inlineStyleRanges(inlineStyleRanges: List<InlineStyleRange>) =
                    inlineStyleRanges(JsonField.of(inlineStyleRanges))

                /** Sets [Builder.inlineStyleRanges] to an arbitrary JSON value. */
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

                /** Links in the block's text, with the text range each covers */
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
                        (links ?: JsonField.of(mutableListOf())).also {
                            checkKnown("links", it).add(link)
                        }
                }

                /** What a media block holds */
                fun mediaType(mediaType: MediaType) = mediaType(JsonField.of(mediaType))

                /** Sets [Builder.mediaType] to an arbitrary JSON value. */
                fun mediaType(mediaType: JsonField<MediaType>) = apply {
                    this.mediaType = mediaType
                }

                /** Preview image URL for media blocks */
                fun previewUrl(previewUrl: String) = previewUrl(JsonField.of(previewUrl))

                /** Sets [Builder.previewUrl] to an arbitrary JSON value. */
                fun previewUrl(previewUrl: JsonField<String>) = apply {
                    this.previewUrl = previewUrl
                }

                fun text(text: String) = text(JsonField.of(text))

                /** Sets [Builder.text] to an arbitrary JSON value. */
                fun text(text: JsonField<String>) = apply { this.text = text }

                /** ID of the post a tweet block embeds */
                fun tweetId(tweetId: String) = tweetId(JsonField.of(tweetId))

                /** Sets [Builder.tweetId] to an arbitrary JSON value. */
                fun tweetId(tweetId: JsonField<String>) = apply { this.tweetId = tweetId }

                /**
                 * Block type: paragraph, header-one, header-two, header-three, header-four,
                 * header-five, header-six, unordered-list-item, ordered-list-item, blockquote,
                 * code-block, media, divider
                 */
                fun type(type: String) = type(JsonField.of(type))

                /** Sets [Builder.type] to an arbitrary JSON value. */
                fun type(type: JsonField<String>) = apply { this.type = type }

                /** Media URL for media blocks */
                fun url(url: String) = url(JsonField.of(url))

                /** Sets [Builder.url] to an arbitrary JSON value. */
                fun url(url: JsonField<String>) = apply { this.url = url }

                /** Files of a video or GIF block, in X's order */
                fun variants(variants: List<Variant>) = variants(JsonField.of(variants))

                /** Sets [Builder.variants] to an arbitrary JSON value. */
                fun variants(variants: JsonField<List<Variant>>) = apply {
                    this.variants = variants.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Variant] to [variants].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addVariant(variant: Variant) = apply {
                    variants =
                        (variants ?: JsonField.of(mutableListOf())).also {
                            checkKnown("variants", it).add(variant)
                        }
                }

                fun width(width: Long) = width(JsonField.of(width))

                /** Sets [Builder.width] to an arbitrary JSON value. */
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
                        altText,
                        caption,
                        durationMs,
                        height,
                        (inlineStyleRanges ?: JsonMissing.of()).map { it.toImmutable() },
                        (links ?: JsonMissing.of()).map { it.toImmutable() },
                        mediaType,
                        previewUrl,
                        text,
                        tweetId,
                        type,
                        url,
                        (variants ?: JsonMissing.of()).map { it.toImmutable() },
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

                altText()
                caption()
                durationMs()
                height()
                inlineStyleRanges().ifPresent { it.forEach { it.validate() } }
                links().ifPresent { it.forEach { it.validate() } }
                mediaType().ifPresent { it.validate() }
                previewUrl()
                text()
                tweetId()
                type()
                url()
                variants().ifPresent { it.forEach { it.validate() } }
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

            @JvmSynthetic
            internal fun validity(): Int =
                (if (altText.asKnown().isPresent) 1 else 0) +
                    (if (caption.asKnown().isPresent) 1 else 0) +
                    (if (durationMs.asKnown().isPresent) 1 else 0) +
                    (if (height.asKnown().isPresent) 1 else 0) +
                    (inlineStyleRanges.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                    (links.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                    (mediaType.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (previewUrl.asKnown().isPresent) 1 else 0) +
                    (if (text.asKnown().isPresent) 1 else 0) +
                    (if (tweetId.asKnown().isPresent) 1 else 0) +
                    (if (type.asKnown().isPresent) 1 else 0) +
                    (if (url.asKnown().isPresent) 1 else 0) +
                    (variants.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
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
                 *   type.
                 */
                fun length(): Optional<Long> = length.getOptional("length")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun offset(): Optional<Long> = offset.getOptional("offset")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
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

                    /** Sets [Builder.length] to an arbitrary JSON value. */
                    fun length(length: JsonField<Long>) = apply { this.length = length }

                    fun offset(offset: Long) = offset(JsonField.of(offset))

                    /** Sets [Builder.offset] to an arbitrary JSON value. */
                    fun offset(offset: JsonField<Long>) = apply { this.offset = offset }

                    fun style(style: String) = style(JsonField.of(style))

                    /** Sets [Builder.style] to an arbitrary JSON value. */
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

            class Link
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val length: JsonField<Long>,
                private val offset: JsonField<Long>,
                private val url: JsonField<String>,
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
                    @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
                ) : this(length, offset, url, mutableMapOf())

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun length(): Optional<Long> = length.getOptional("length")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun offset(): Optional<Long> = offset.getOptional("offset")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun url(): Optional<String> = url.getOptional("url")

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

                    /** Returns a mutable builder for constructing an instance of [Link]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Link]. */
                class Builder internal constructor() {

                    private var length: JsonField<Long> = JsonMissing.of()
                    private var offset: JsonField<Long> = JsonMissing.of()
                    private var url: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(link: Link) = apply {
                        length = link.length
                        offset = link.offset
                        url = link.url
                        additionalProperties = link.additionalProperties.toMutableMap()
                    }

                    fun length(length: Long) = length(JsonField.of(length))

                    /** Sets [Builder.length] to an arbitrary JSON value. */
                    fun length(length: JsonField<Long>) = apply { this.length = length }

                    fun offset(offset: Long) = offset(JsonField.of(offset))

                    /** Sets [Builder.offset] to an arbitrary JSON value. */
                    fun offset(offset: JsonField<Long>) = apply { this.offset = offset }

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
                     * Returns an immutable instance of [Link].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Link =
                        Link(length, offset, url, additionalProperties.toMutableMap())
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
                fun validate(): Link = apply {
                    if (validated) {
                        return@apply
                    }

                    length()
                    offset()
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
                    (if (length.asKnown().isPresent) 1 else 0) +
                        (if (offset.asKnown().isPresent) 1 else 0) +
                        (if (url.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Link &&
                        length == other.length &&
                        offset == other.offset &&
                        url == other.url &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(length, offset, url, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Link{length=$length, offset=$offset, url=$url, additionalProperties=$additionalProperties}"
            }

            /** What a media block holds */
            class MediaType @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /** Returns this class instance's raw value. */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val IMAGE = of("image")

                    @JvmField val VIDEO = of("video")

                    @JvmField val GIF = of("gif")

                    @JvmStatic fun of(value: String) = MediaType(JsonField.of(value))
                }

                /** An enum containing [MediaType]'s known values. */
                enum class Known {
                    IMAGE,
                    VIDEO,
                    GIF,
                }

                /**
                 * An enum containing [MediaType]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [MediaType] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    IMAGE,
                    VIDEO,
                    GIF,
                    /**
                     * An enum member indicating that [MediaType] was instantiated with an unknown
                     * value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 */
                fun value(): Value =
                    when (this) {
                        IMAGE -> Value.IMAGE
                        VIDEO -> Value.VIDEO
                        GIF -> Value.GIF
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value is a
                 *   not a known member.
                 */
                fun known(): Known =
                    when (this) {
                        IMAGE -> Known.IMAGE
                        VIDEO -> Known.VIDEO
                        GIF -> Known.GIF
                        else ->
                            throw XTwitterScraperInvalidDataException("Unknown MediaType: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value does
                 *   not have the expected primitive type.
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
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): MediaType = apply {
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

                    return other is MediaType && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            class Variant
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val contentType: JsonField<String>,
                private val url: JsonField<String>,
                private val bitrate: JsonField<Long>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("contentType")
                    @ExcludeMissing
                    contentType: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("bitrate")
                    @ExcludeMissing
                    bitrate: JsonField<Long> = JsonMissing.of(),
                ) : this(contentType, url, bitrate, mutableMapOf())

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun contentType(): String = contentType.getRequired("contentType")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun url(): String = url.getRequired("url")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun bitrate(): Optional<Long> = bitrate.getOptional("bitrate")

                /**
                 * Returns the raw JSON value of [contentType].
                 *
                 * Unlike [contentType], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("contentType")
                @ExcludeMissing
                fun _contentType(): JsonField<String> = contentType

                /**
                 * Returns the raw JSON value of [url].
                 *
                 * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

                /**
                 * Returns the raw JSON value of [bitrate].
                 *
                 * Unlike [bitrate], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("bitrate") @ExcludeMissing fun _bitrate(): JsonField<Long> = bitrate

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
                     * Returns a mutable builder for constructing an instance of [Variant].
                     *
                     * The following fields are required:
                     * ```java
                     * .contentType()
                     * .url()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Variant]. */
                class Builder internal constructor() {

                    private var contentType: JsonField<String>? = null
                    private var url: JsonField<String>? = null
                    private var bitrate: JsonField<Long> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(variant: Variant) = apply {
                        contentType = variant.contentType
                        url = variant.url
                        bitrate = variant.bitrate
                        additionalProperties = variant.additionalProperties.toMutableMap()
                    }

                    fun contentType(contentType: String) = contentType(JsonField.of(contentType))

                    /** Sets [Builder.contentType] to an arbitrary JSON value. */
                    fun contentType(contentType: JsonField<String>) = apply {
                        this.contentType = contentType
                    }

                    fun url(url: String) = url(JsonField.of(url))

                    /** Sets [Builder.url] to an arbitrary JSON value. */
                    fun url(url: JsonField<String>) = apply { this.url = url }

                    fun bitrate(bitrate: Long) = bitrate(JsonField.of(bitrate))

                    /** Sets [Builder.bitrate] to an arbitrary JSON value. */
                    fun bitrate(bitrate: JsonField<Long>) = apply { this.bitrate = bitrate }

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
                     * Returns an immutable instance of [Variant].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .contentType()
                     * .url()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Variant =
                        Variant(
                            checkRequired("contentType", contentType),
                            checkRequired("url", url),
                            bitrate,
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
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): Variant = apply {
                    if (validated) {
                        return@apply
                    }

                    contentType()
                    url()
                    bitrate()
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
                    (if (contentType.asKnown().isPresent) 1 else 0) +
                        (if (url.asKnown().isPresent) 1 else 0) +
                        (if (bitrate.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Variant &&
                        contentType == other.contentType &&
                        url == other.url &&
                        bitrate == other.bitrate &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(contentType, url, bitrate, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Variant{contentType=$contentType, url=$url, bitrate=$bitrate, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Content &&
                    altText == other.altText &&
                    caption == other.caption &&
                    durationMs == other.durationMs &&
                    height == other.height &&
                    inlineStyleRanges == other.inlineStyleRanges &&
                    links == other.links &&
                    mediaType == other.mediaType &&
                    previewUrl == other.previewUrl &&
                    text == other.text &&
                    tweetId == other.tweetId &&
                    type == other.type &&
                    url == other.url &&
                    variants == other.variants &&
                    width == other.width &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    altText,
                    caption,
                    durationMs,
                    height,
                    inlineStyleRanges,
                    links,
                    mediaType,
                    previewUrl,
                    text,
                    tweetId,
                    type,
                    url,
                    variants,
                    width,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Content{altText=$altText, caption=$caption, durationMs=$durationMs, height=$height, inlineStyleRanges=$inlineStyleRanges, links=$links, mediaType=$mediaType, previewUrl=$previewUrl, text=$text, tweetId=$tweetId, type=$type, url=$url, variants=$variants, width=$width, additionalProperties=$additionalProperties}"
        }

        /** Public metadata whose fields X defines. */
        class CoverMedia
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [CoverMedia]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [CoverMedia]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(coverMedia: CoverMedia) = apply {
                    additionalProperties = coverMedia.additionalProperties.toMutableMap()
                }

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
                 * Returns an immutable instance of [CoverMedia].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): CoverMedia = CoverMedia(additionalProperties.toImmutable())
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
            fun validate(): CoverMedia = apply {
                if (validated) {
                    return@apply
                }

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
            internal fun validity(): Int = additionalProperties.count { (_, value) ->
                !value.isNull() && !value.isMissing()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is CoverMedia && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "CoverMedia{additionalProperties=$additionalProperties}"
        }

        /** Public metadata whose fields X defines. */
        class LifecycleState
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [LifecycleState]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [LifecycleState]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(lifecycleState: LifecycleState) = apply {
                    additionalProperties = lifecycleState.additionalProperties.toMutableMap()
                }

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
                 * Returns an immutable instance of [LifecycleState].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): LifecycleState = LifecycleState(additionalProperties.toImmutable())
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
            fun validate(): LifecycleState = apply {
                if (validated) {
                    return@apply
                }

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
            internal fun validity(): Int = additionalProperties.count { (_, value) ->
                !value.isNull() && !value.isMissing()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is LifecycleState && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "LifecycleState{additionalProperties=$additionalProperties}"
        }

        /** Public metadata whose fields X defines. */
        class Metadata
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Metadata]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Metadata]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(metadata: Metadata) = apply {
                    additionalProperties = metadata.additionalProperties.toMutableMap()
                }

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
                 * Returns an immutable instance of [Metadata].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Metadata = Metadata(additionalProperties.toImmutable())
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
            fun validate(): Metadata = apply {
                if (validated) {
                    return@apply
                }

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
            internal fun validity(): Int = additionalProperties.count { (_, value) ->
                !value.isNull() && !value.isMissing()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Metadata && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Metadata{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Article &&
                articleId == other.articleId &&
                bodyMarkdown == other.bodyMarkdown &&
                bodyText == other.bodyText &&
                bookmarkCount == other.bookmarkCount &&
                contents == other.contents &&
                coverImageUrl == other.coverImageUrl &&
                coverMedia == other.coverMedia &&
                createdAt == other.createdAt &&
                lifecycleState == other.lifecycleState &&
                likeCount == other.likeCount &&
                metadata == other.metadata &&
                previewText == other.previewText &&
                quoteCount == other.quoteCount &&
                replyCount == other.replyCount &&
                retweetCount == other.retweetCount &&
                summaryText == other.summaryText &&
                title == other.title &&
                viewCount == other.viewCount &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                articleId,
                bodyMarkdown,
                bodyText,
                bookmarkCount,
                contents,
                coverImageUrl,
                coverMedia,
                createdAt,
                lifecycleState,
                likeCount,
                metadata,
                previewText,
                quoteCount,
                replyCount,
                retweetCount,
                summaryText,
                title,
                viewCount,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Article{articleId=$articleId, bodyMarkdown=$bodyMarkdown, bodyText=$bodyText, bookmarkCount=$bookmarkCount, contents=$contents, coverImageUrl=$coverImageUrl, coverMedia=$coverMedia, createdAt=$createdAt, lifecycleState=$lifecycleState, likeCount=$likeCount, metadata=$metadata, previewText=$previewText, quoteCount=$quoteCount, replyCount=$replyCount, retweetCount=$retweetCount, summaryText=$summaryText, title=$title, viewCount=$viewCount, additionalProperties=$additionalProperties}"
    }

    /** X Article author profile fields returned when available. */
    class Author
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val name: JsonField<String>,
        private val username: JsonField<String>,
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
        private val profilePictureOriginal: JsonField<String>,
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
            @JsonProperty("profilePictureOriginal")
            @ExcludeMissing
            profilePictureOriginal: JsonField<String> = JsonMissing.of(),
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
            profilePictureOriginal,
            protected_,
            statusesCount,
            url,
            mutableMapOf(),
        )

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun id(): String = id.getRequired("id")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun name(): String = name.getRequired("name")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun username(): String = username.getRequired("username")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun createdAt(): Optional<String> = createdAt.getOptional("createdAt")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun description(): Optional<String> = description.getOptional("description")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun favouritesCount(): Optional<Long> = favouritesCount.getOptional("favouritesCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun followersCount(): Optional<Long> = followersCount.getOptional("followersCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun followingCount(): Optional<Long> = followingCount.getOptional("followingCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun isBlueVerified(): Optional<Boolean> = isBlueVerified.getOptional("isBlueVerified")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun isTranslator(): Optional<Boolean> = isTranslator.getOptional("isTranslator")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun isVerified(): Optional<Boolean> = isVerified.getOptional("isVerified")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun location(): Optional<String> = location.getOptional("location")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun mediaCount(): Optional<Long> = mediaCount.getOptional("mediaCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun profileBannerUrl(): Optional<String> = profileBannerUrl.getOptional("profileBannerUrl")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun profilePicture(): Optional<String> = profilePicture.getOptional("profilePicture")

        /**
         * The same profile picture at full size.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun profilePictureOriginal(): Optional<String> =
            profilePictureOriginal.getOptional("profilePictureOriginal")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun protected_(): Optional<Boolean> = protected_.getOptional("protected")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun statusesCount(): Optional<Long> = statusesCount.getOptional("statusesCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
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
         * Returns the raw JSON value of [profilePictureOriginal].
         *
         * Unlike [profilePictureOriginal], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("profilePictureOriginal")
        @ExcludeMissing
        fun _profilePictureOriginal(): JsonField<String> = profilePictureOriginal

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
            private var profilePictureOriginal: JsonField<String> = JsonMissing.of()
            private var protected_: JsonField<Boolean> = JsonMissing.of()
            private var statusesCount: JsonField<Long> = JsonMissing.of()
            private var url: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(author: Author) = apply {
                id = author.id
                name = author.name
                username = author.username
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
                profilePictureOriginal = author.profilePictureOriginal
                protected_ = author.protected_
                statusesCount = author.statusesCount
                url = author.url
                additionalProperties = author.additionalProperties.toMutableMap()
            }

            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun name(name: String) = name(JsonField.of(name))

            /** Sets [Builder.name] to an arbitrary JSON value. */
            fun name(name: JsonField<String>) = apply { this.name = name }

            fun username(username: String) = username(JsonField.of(username))

            /** Sets [Builder.username] to an arbitrary JSON value. */
            fun username(username: JsonField<String>) = apply { this.username = username }

            fun createdAt(createdAt: String) = createdAt(JsonField.of(createdAt))

            /** Sets [Builder.createdAt] to an arbitrary JSON value. */
            fun createdAt(createdAt: JsonField<String>) = apply { this.createdAt = createdAt }

            fun description(description: String) = description(JsonField.of(description))

            /** Sets [Builder.description] to an arbitrary JSON value. */
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

            fun favouritesCount(favouritesCount: Long) =
                favouritesCount(JsonField.of(favouritesCount))

            /** Sets [Builder.favouritesCount] to an arbitrary JSON value. */
            fun favouritesCount(favouritesCount: JsonField<Long>) = apply {
                this.favouritesCount = favouritesCount
            }

            fun followersCount(followersCount: Long) = followersCount(JsonField.of(followersCount))

            /** Sets [Builder.followersCount] to an arbitrary JSON value. */
            fun followersCount(followersCount: JsonField<Long>) = apply {
                this.followersCount = followersCount
            }

            fun followingCount(followingCount: Long) = followingCount(JsonField.of(followingCount))

            /** Sets [Builder.followingCount] to an arbitrary JSON value. */
            fun followingCount(followingCount: JsonField<Long>) = apply {
                this.followingCount = followingCount
            }

            fun isBlueVerified(isBlueVerified: Boolean) =
                isBlueVerified(JsonField.of(isBlueVerified))

            /** Sets [Builder.isBlueVerified] to an arbitrary JSON value. */
            fun isBlueVerified(isBlueVerified: JsonField<Boolean>) = apply {
                this.isBlueVerified = isBlueVerified
            }

            fun isTranslator(isTranslator: Boolean) = isTranslator(JsonField.of(isTranslator))

            /** Sets [Builder.isTranslator] to an arbitrary JSON value. */
            fun isTranslator(isTranslator: JsonField<Boolean>) = apply {
                this.isTranslator = isTranslator
            }

            fun isVerified(isVerified: Boolean) = isVerified(JsonField.of(isVerified))

            /** Sets [Builder.isVerified] to an arbitrary JSON value. */
            fun isVerified(isVerified: JsonField<Boolean>) = apply { this.isVerified = isVerified }

            fun location(location: String) = location(JsonField.of(location))

            /** Sets [Builder.location] to an arbitrary JSON value. */
            fun location(location: JsonField<String>) = apply { this.location = location }

            fun mediaCount(mediaCount: Long) = mediaCount(JsonField.of(mediaCount))

            /** Sets [Builder.mediaCount] to an arbitrary JSON value. */
            fun mediaCount(mediaCount: JsonField<Long>) = apply { this.mediaCount = mediaCount }

            fun profileBannerUrl(profileBannerUrl: String) =
                profileBannerUrl(JsonField.of(profileBannerUrl))

            /** Sets [Builder.profileBannerUrl] to an arbitrary JSON value. */
            fun profileBannerUrl(profileBannerUrl: JsonField<String>) = apply {
                this.profileBannerUrl = profileBannerUrl
            }

            fun profilePicture(profilePicture: String) =
                profilePicture(JsonField.of(profilePicture))

            /** Sets [Builder.profilePicture] to an arbitrary JSON value. */
            fun profilePicture(profilePicture: JsonField<String>) = apply {
                this.profilePicture = profilePicture
            }

            /** The same profile picture at full size. */
            fun profilePictureOriginal(profilePictureOriginal: String) =
                profilePictureOriginal(JsonField.of(profilePictureOriginal))

            /** Sets [Builder.profilePictureOriginal] to an arbitrary JSON value. */
            fun profilePictureOriginal(profilePictureOriginal: JsonField<String>) = apply {
                this.profilePictureOriginal = profilePictureOriginal
            }

            fun protected_(protected_: Boolean) = protected_(JsonField.of(protected_))

            /** Sets [Builder.protected_] to an arbitrary JSON value. */
            fun protected_(protected_: JsonField<Boolean>) = apply { this.protected_ = protected_ }

            fun statusesCount(statusesCount: Long) = statusesCount(JsonField.of(statusesCount))

            /** Sets [Builder.statusesCount] to an arbitrary JSON value. */
            fun statusesCount(statusesCount: JsonField<Long>) = apply {
                this.statusesCount = statusesCount
            }

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
                    profilePictureOriginal,
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
            profilePictureOriginal()
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

        @JvmSynthetic
        internal fun validity(): Int =
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (username.asKnown().isPresent) 1 else 0) +
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
                (if (profilePictureOriginal.asKnown().isPresent) 1 else 0) +
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
                profilePictureOriginal == other.profilePictureOriginal &&
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
                profilePictureOriginal,
                protected_,
                statusesCount,
                url,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Author{id=$id, name=$name, username=$username, createdAt=$createdAt, description=$description, favouritesCount=$favouritesCount, followersCount=$followersCount, followingCount=$followingCount, isBlueVerified=$isBlueVerified, isTranslator=$isTranslator, isVerified=$isVerified, location=$location, mediaCount=$mediaCount, profileBannerUrl=$profileBannerUrl, profilePicture=$profilePicture, profilePictureOriginal=$profilePictureOriginal, protected_=$protected_, statusesCount=$statusesCount, url=$url, additionalProperties=$additionalProperties}"
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
