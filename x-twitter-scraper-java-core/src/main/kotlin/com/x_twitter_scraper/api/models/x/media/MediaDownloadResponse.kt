// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.media

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

class MediaDownloadResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val cacheHit: JsonField<Boolean>,
    private val galleryUrl: JsonField<String>,
    private val totalMedia: JsonField<Long>,
    private val totalTweets: JsonField<Long>,
    private val tweetId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("cacheHit") @ExcludeMissing cacheHit: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("galleryUrl")
        @ExcludeMissing
        galleryUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("totalMedia") @ExcludeMissing totalMedia: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("totalTweets")
        @ExcludeMissing
        totalTweets: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("tweetId") @ExcludeMissing tweetId: JsonField<String> = JsonMissing.of(),
    ) : this(cacheHit, galleryUrl, totalMedia, totalTweets, tweetId, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun cacheHit(): Optional<Boolean> = cacheHit.getOptional("cacheHit")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun galleryUrl(): Optional<String> = galleryUrl.getOptional("galleryUrl")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun totalMedia(): Optional<Long> = totalMedia.getOptional("totalMedia")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun totalTweets(): Optional<Long> = totalTweets.getOptional("totalTweets")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun tweetId(): Optional<String> = tweetId.getOptional("tweetId")

    /**
     * Returns the raw JSON value of [cacheHit].
     *
     * Unlike [cacheHit], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("cacheHit") @ExcludeMissing fun _cacheHit(): JsonField<Boolean> = cacheHit

    /**
     * Returns the raw JSON value of [galleryUrl].
     *
     * Unlike [galleryUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("galleryUrl") @ExcludeMissing fun _galleryUrl(): JsonField<String> = galleryUrl

    /**
     * Returns the raw JSON value of [totalMedia].
     *
     * Unlike [totalMedia], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("totalMedia") @ExcludeMissing fun _totalMedia(): JsonField<Long> = totalMedia

    /**
     * Returns the raw JSON value of [totalTweets].
     *
     * Unlike [totalTweets], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("totalTweets") @ExcludeMissing fun _totalTweets(): JsonField<Long> = totalTweets

    /**
     * Returns the raw JSON value of [tweetId].
     *
     * Unlike [tweetId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tweetId") @ExcludeMissing fun _tweetId(): JsonField<String> = tweetId

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

        /** Returns a mutable builder for constructing an instance of [MediaDownloadResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MediaDownloadResponse]. */
    class Builder internal constructor() {

        private var cacheHit: JsonField<Boolean> = JsonMissing.of()
        private var galleryUrl: JsonField<String> = JsonMissing.of()
        private var totalMedia: JsonField<Long> = JsonMissing.of()
        private var totalTweets: JsonField<Long> = JsonMissing.of()
        private var tweetId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(mediaDownloadResponse: MediaDownloadResponse) = apply {
            cacheHit = mediaDownloadResponse.cacheHit
            galleryUrl = mediaDownloadResponse.galleryUrl
            totalMedia = mediaDownloadResponse.totalMedia
            totalTweets = mediaDownloadResponse.totalTweets
            tweetId = mediaDownloadResponse.tweetId
            additionalProperties = mediaDownloadResponse.additionalProperties.toMutableMap()
        }

        fun cacheHit(cacheHit: Boolean) = cacheHit(JsonField.of(cacheHit))

        /**
         * Sets [Builder.cacheHit] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cacheHit] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun cacheHit(cacheHit: JsonField<Boolean>) = apply { this.cacheHit = cacheHit }

        fun galleryUrl(galleryUrl: String) = galleryUrl(JsonField.of(galleryUrl))

        /**
         * Sets [Builder.galleryUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.galleryUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun galleryUrl(galleryUrl: JsonField<String>) = apply { this.galleryUrl = galleryUrl }

        fun totalMedia(totalMedia: Long) = totalMedia(JsonField.of(totalMedia))

        /**
         * Sets [Builder.totalMedia] to an arbitrary JSON value.
         *
         * You should usually call [Builder.totalMedia] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun totalMedia(totalMedia: JsonField<Long>) = apply { this.totalMedia = totalMedia }

        fun totalTweets(totalTweets: Long) = totalTweets(JsonField.of(totalTweets))

        /**
         * Sets [Builder.totalTweets] to an arbitrary JSON value.
         *
         * You should usually call [Builder.totalTweets] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun totalTweets(totalTweets: JsonField<Long>) = apply { this.totalTweets = totalTweets }

        fun tweetId(tweetId: String) = tweetId(JsonField.of(tweetId))

        /**
         * Sets [Builder.tweetId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tweetId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tweetId(tweetId: JsonField<String>) = apply { this.tweetId = tweetId }

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
         * Returns an immutable instance of [MediaDownloadResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MediaDownloadResponse =
            MediaDownloadResponse(
                cacheHit,
                galleryUrl,
                totalMedia,
                totalTweets,
                tweetId,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MediaDownloadResponse = apply {
        if (validated) {
            return@apply
        }

        cacheHit()
        galleryUrl()
        totalMedia()
        totalTweets()
        tweetId()
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
        (if (cacheHit.asKnown().isPresent) 1 else 0) +
            (if (galleryUrl.asKnown().isPresent) 1 else 0) +
            (if (totalMedia.asKnown().isPresent) 1 else 0) +
            (if (totalTweets.asKnown().isPresent) 1 else 0) +
            (if (tweetId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MediaDownloadResponse &&
            cacheHit == other.cacheHit &&
            galleryUrl == other.galleryUrl &&
            totalMedia == other.totalMedia &&
            totalTweets == other.totalTweets &&
            tweetId == other.tweetId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(cacheHit, galleryUrl, totalMedia, totalTweets, tweetId, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MediaDownloadResponse{cacheHit=$cacheHit, galleryUrl=$galleryUrl, totalMedia=$totalMedia, totalTweets=$totalTweets, tweetId=$tweetId, additionalProperties=$additionalProperties}"
}
