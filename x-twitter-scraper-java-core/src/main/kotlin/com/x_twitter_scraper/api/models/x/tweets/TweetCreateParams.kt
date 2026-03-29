// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Create tweet */
class TweetCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * X account (@username or account ID)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun account(): String = body.account()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun text(): String = body.text()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun attachmentUrl(): Optional<String> = body.attachmentUrl()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun communityId(): Optional<String> = body.communityId()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun isNoteTweet(): Optional<Boolean> = body.isNoteTweet()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun mediaIds(): Optional<List<String>> = body.mediaIds()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun replyToTweetId(): Optional<String> = body.replyToTweetId()

    /**
     * Returns the raw JSON value of [account].
     *
     * Unlike [account], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _account(): JsonField<String> = body._account()

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _text(): JsonField<String> = body._text()

    /**
     * Returns the raw JSON value of [attachmentUrl].
     *
     * Unlike [attachmentUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _attachmentUrl(): JsonField<String> = body._attachmentUrl()

    /**
     * Returns the raw JSON value of [communityId].
     *
     * Unlike [communityId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _communityId(): JsonField<String> = body._communityId()

    /**
     * Returns the raw JSON value of [isNoteTweet].
     *
     * Unlike [isNoteTweet], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _isNoteTweet(): JsonField<Boolean> = body._isNoteTweet()

    /**
     * Returns the raw JSON value of [mediaIds].
     *
     * Unlike [mediaIds], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _mediaIds(): JsonField<List<String>> = body._mediaIds()

    /**
     * Returns the raw JSON value of [replyToTweetId].
     *
     * Unlike [replyToTweetId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _replyToTweetId(): JsonField<String> = body._replyToTweetId()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TweetCreateParams].
         *
         * The following fields are required:
         * ```java
         * .account()
         * .text()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TweetCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(tweetCreateParams: TweetCreateParams) = apply {
            body = tweetCreateParams.body.toBuilder()
            additionalHeaders = tweetCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = tweetCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [account]
         * - [text]
         * - [attachmentUrl]
         * - [communityId]
         * - [isNoteTweet]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** X account (@username or account ID) */
        fun account(account: String) = apply { body.account(account) }

        /**
         * Sets [Builder.account] to an arbitrary JSON value.
         *
         * You should usually call [Builder.account] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun account(account: JsonField<String>) = apply { body.account(account) }

        fun text(text: String) = apply { body.text(text) }

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<String>) = apply { body.text(text) }

        fun attachmentUrl(attachmentUrl: String) = apply { body.attachmentUrl(attachmentUrl) }

        /**
         * Sets [Builder.attachmentUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.attachmentUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun attachmentUrl(attachmentUrl: JsonField<String>) = apply {
            body.attachmentUrl(attachmentUrl)
        }

        fun communityId(communityId: String) = apply { body.communityId(communityId) }

        /**
         * Sets [Builder.communityId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.communityId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun communityId(communityId: JsonField<String>) = apply { body.communityId(communityId) }

        fun isNoteTweet(isNoteTweet: Boolean) = apply { body.isNoteTweet(isNoteTweet) }

        /**
         * Sets [Builder.isNoteTweet] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isNoteTweet] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isNoteTweet(isNoteTweet: JsonField<Boolean>) = apply { body.isNoteTweet(isNoteTweet) }

        fun mediaIds(mediaIds: List<String>) = apply { body.mediaIds(mediaIds) }

        /**
         * Sets [Builder.mediaIds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mediaIds] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun mediaIds(mediaIds: JsonField<List<String>>) = apply { body.mediaIds(mediaIds) }

        /**
         * Adds a single [String] to [mediaIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addMediaId(mediaId: String) = apply { body.addMediaId(mediaId) }

        fun replyToTweetId(replyToTweetId: String) = apply { body.replyToTweetId(replyToTweetId) }

        /**
         * Sets [Builder.replyToTweetId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.replyToTweetId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun replyToTweetId(replyToTweetId: JsonField<String>) = apply {
            body.replyToTweetId(replyToTweetId)
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

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
         * Returns an immutable instance of [TweetCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .account()
         * .text()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TweetCreateParams =
            TweetCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val account: JsonField<String>,
        private val text: JsonField<String>,
        private val attachmentUrl: JsonField<String>,
        private val communityId: JsonField<String>,
        private val isNoteTweet: JsonField<Boolean>,
        private val mediaIds: JsonField<List<String>>,
        private val replyToTweetId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("account") @ExcludeMissing account: JsonField<String> = JsonMissing.of(),
            @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
            @JsonProperty("attachment_url")
            @ExcludeMissing
            attachmentUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("community_id")
            @ExcludeMissing
            communityId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("is_note_tweet")
            @ExcludeMissing
            isNoteTweet: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("media_ids")
            @ExcludeMissing
            mediaIds: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("reply_to_tweet_id")
            @ExcludeMissing
            replyToTweetId: JsonField<String> = JsonMissing.of(),
        ) : this(
            account,
            text,
            attachmentUrl,
            communityId,
            isNoteTweet,
            mediaIds,
            replyToTweetId,
            mutableMapOf(),
        )

        /**
         * X account (@username or account ID)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun account(): String = account.getRequired("account")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun text(): String = text.getRequired("text")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun attachmentUrl(): Optional<String> = attachmentUrl.getOptional("attachment_url")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun communityId(): Optional<String> = communityId.getOptional("community_id")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun isNoteTweet(): Optional<Boolean> = isNoteTweet.getOptional("is_note_tweet")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun mediaIds(): Optional<List<String>> = mediaIds.getOptional("media_ids")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun replyToTweetId(): Optional<String> = replyToTweetId.getOptional("reply_to_tweet_id")

        /**
         * Returns the raw JSON value of [account].
         *
         * Unlike [account], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("account") @ExcludeMissing fun _account(): JsonField<String> = account

        /**
         * Returns the raw JSON value of [text].
         *
         * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

        /**
         * Returns the raw JSON value of [attachmentUrl].
         *
         * Unlike [attachmentUrl], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("attachment_url")
        @ExcludeMissing
        fun _attachmentUrl(): JsonField<String> = attachmentUrl

        /**
         * Returns the raw JSON value of [communityId].
         *
         * Unlike [communityId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("community_id")
        @ExcludeMissing
        fun _communityId(): JsonField<String> = communityId

        /**
         * Returns the raw JSON value of [isNoteTweet].
         *
         * Unlike [isNoteTweet], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("is_note_tweet")
        @ExcludeMissing
        fun _isNoteTweet(): JsonField<Boolean> = isNoteTweet

        /**
         * Returns the raw JSON value of [mediaIds].
         *
         * Unlike [mediaIds], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("media_ids")
        @ExcludeMissing
        fun _mediaIds(): JsonField<List<String>> = mediaIds

        /**
         * Returns the raw JSON value of [replyToTweetId].
         *
         * Unlike [replyToTweetId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("reply_to_tweet_id")
        @ExcludeMissing
        fun _replyToTweetId(): JsonField<String> = replyToTweetId

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
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .account()
             * .text()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var account: JsonField<String>? = null
            private var text: JsonField<String>? = null
            private var attachmentUrl: JsonField<String> = JsonMissing.of()
            private var communityId: JsonField<String> = JsonMissing.of()
            private var isNoteTweet: JsonField<Boolean> = JsonMissing.of()
            private var mediaIds: JsonField<MutableList<String>>? = null
            private var replyToTweetId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                account = body.account
                text = body.text
                attachmentUrl = body.attachmentUrl
                communityId = body.communityId
                isNoteTweet = body.isNoteTweet
                mediaIds = body.mediaIds.map { it.toMutableList() }
                replyToTweetId = body.replyToTweetId
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** X account (@username or account ID) */
            fun account(account: String) = account(JsonField.of(account))

            /**
             * Sets [Builder.account] to an arbitrary JSON value.
             *
             * You should usually call [Builder.account] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun account(account: JsonField<String>) = apply { this.account = account }

            fun text(text: String) = text(JsonField.of(text))

            /**
             * Sets [Builder.text] to an arbitrary JSON value.
             *
             * You should usually call [Builder.text] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun text(text: JsonField<String>) = apply { this.text = text }

            fun attachmentUrl(attachmentUrl: String) = attachmentUrl(JsonField.of(attachmentUrl))

            /**
             * Sets [Builder.attachmentUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.attachmentUrl] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun attachmentUrl(attachmentUrl: JsonField<String>) = apply {
                this.attachmentUrl = attachmentUrl
            }

            fun communityId(communityId: String) = communityId(JsonField.of(communityId))

            /**
             * Sets [Builder.communityId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.communityId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun communityId(communityId: JsonField<String>) = apply {
                this.communityId = communityId
            }

            fun isNoteTweet(isNoteTweet: Boolean) = isNoteTweet(JsonField.of(isNoteTweet))

            /**
             * Sets [Builder.isNoteTweet] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isNoteTweet] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isNoteTweet(isNoteTweet: JsonField<Boolean>) = apply {
                this.isNoteTweet = isNoteTweet
            }

            fun mediaIds(mediaIds: List<String>) = mediaIds(JsonField.of(mediaIds))

            /**
             * Sets [Builder.mediaIds] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mediaIds] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun mediaIds(mediaIds: JsonField<List<String>>) = apply {
                this.mediaIds = mediaIds.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [mediaIds].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addMediaId(mediaId: String) = apply {
                mediaIds =
                    (mediaIds ?: JsonField.of(mutableListOf())).also {
                        checkKnown("mediaIds", it).add(mediaId)
                    }
            }

            fun replyToTweetId(replyToTweetId: String) =
                replyToTweetId(JsonField.of(replyToTweetId))

            /**
             * Sets [Builder.replyToTweetId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.replyToTweetId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun replyToTweetId(replyToTweetId: JsonField<String>) = apply {
                this.replyToTweetId = replyToTweetId
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .account()
             * .text()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("account", account),
                    checkRequired("text", text),
                    attachmentUrl,
                    communityId,
                    isNoteTweet,
                    (mediaIds ?: JsonMissing.of()).map { it.toImmutable() },
                    replyToTweetId,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            account()
            text()
            attachmentUrl()
            communityId()
            isNoteTweet()
            mediaIds()
            replyToTweetId()
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
            (if (account.asKnown().isPresent) 1 else 0) +
                (if (text.asKnown().isPresent) 1 else 0) +
                (if (attachmentUrl.asKnown().isPresent) 1 else 0) +
                (if (communityId.asKnown().isPresent) 1 else 0) +
                (if (isNoteTweet.asKnown().isPresent) 1 else 0) +
                (mediaIds.asKnown().getOrNull()?.size ?: 0) +
                (if (replyToTweetId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                account == other.account &&
                text == other.text &&
                attachmentUrl == other.attachmentUrl &&
                communityId == other.communityId &&
                isNoteTweet == other.isNoteTweet &&
                mediaIds == other.mediaIds &&
                replyToTweetId == other.replyToTweetId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                account,
                text,
                attachmentUrl,
                communityId,
                isNoteTweet,
                mediaIds,
                replyToTweetId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{account=$account, text=$text, attachmentUrl=$attachmentUrl, communityId=$communityId, isNoteTweet=$isNoteTweet, mediaIds=$mediaIds, replyToTweetId=$replyToTweetId, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TweetCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "TweetCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
